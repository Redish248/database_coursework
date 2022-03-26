import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core'
import { FormGroup } from '@angular/forms'
import { Gender, ViewMode } from '../../../common_model'
import { StaffService } from '../../staff.service'
import { Staff } from '../../model/Staff'
import { Position } from '../../model/Position'

@Component({
  selector: 'app-view-staff-account',
  templateUrl: './view-staff-account.component.html',
  styleUrls: ['./view-staff-account.component.css']
})
export class ViewStaffAccountComponent implements OnInit {
  @Input() modalOpen: boolean
  @Input() staff: Staff
  @Output() closeModal = new EventEmitter()

  staffForm: FormGroup
  errorMessage: string = undefined
  Gender = Gender
  ViewMode = ViewMode
  mode: ViewMode = ViewMode.VIEW
  loading: boolean = false

  positions: Position[] = []

  hasAdminPermissions: boolean = true

  constructor(private staffService: StaffService) {
    this.staffForm = staffService.buildStaffForm()
  }

  ngOnInit(): void {
    // todo: check permissions
    this.staffForm.reset({
      name: this.staff.name,
      surname: this.staff.surname,
      patronymic: this.staff.patronymic,
      gender: this.staff.gender,
      positionUid: this.staff.positionType.uid,
      salary: this.staff.salary,
      experience: this.staff.experience,
      dateOfBirth: this.staff.dateOfBirth,
      firstWorkDate: this.staff.firstWorkDate
    })
    console.log(this.staffForm)
    this.errorMessage = undefined
    this.staffService.getPositions().subscribe(
      data => this.positions = data,
      err => this.errorMessage = err
    )
    this.staffForm.disable()
  }

  switchModeToEdit() {
    if (this.mode == ViewMode.VIEW) {
      this.mode = ViewMode.EDIT
      this.staffForm.enable()
    }
  }

  update() {
    this.loading = true
    this.errorMessage = undefined
    this.staffService.updateStaff(this.staff.uid, this.staffForm.getRawValue()).subscribe(
      _ => {
        this.loading = false
        this.modalOpen = false
        this.closeModal.emit()
      },
      err => {
        this.loading = false
        this.errorMessage = err
      }
    )
  }

  deleteStaff() {
    this.loading = true
    this.errorMessage = undefined
    this.staffService.deleteStaff(this.staff.uid).subscribe(
      _ => {
        this.loading = false
        this.modalOpen = false
        this.closeModal.emit(
        )
      },
      err => {
        this.loading = false
        this.errorMessage = err
      }
    )
  }

}