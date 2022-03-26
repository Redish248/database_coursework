import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core'
import { FormGroup } from '@angular/forms'
import { StaffService } from '../../staff.service'
import { Gender } from '../../../common_model'
import { Position } from '../../model/Position'

@Component({
  selector: 'app-create-staff-account',
  templateUrl: './create-staff-account.component.html',
  styleUrls: ['./create-staff-account.component.css']
})
export class CreateStaffAccountComponent implements OnInit {
  @Input() modalOpen: boolean
  @Output() closeModal = new EventEmitter()

  staffForm: FormGroup
  errorMessage: string = undefined
  Gender = Gender
  positions: Position[] = []
  loading: boolean = false

  constructor(private staffService: StaffService
  ) {
    this.staffForm = staffService.buildStaffForm()
  }

  ngOnInit(): void {
    this.errorMessage = undefined
    this.staffService.getPositions().subscribe(
      data => this.positions = data || [],
      err => this.errorMessage = err
    )
  }

  addNewStaff() {
    this.loading = true
    this.errorMessage = undefined
    this.staffService.addStaff(this.staffForm.getRawValue()).subscribe(
      _ => {
        this.loading = false
        this.closeModal.emit()
        this.modalOpen = false
      }, err => {
        this.loading = false
        this.errorMessage = err
      }
    )
  }
}
