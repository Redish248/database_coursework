import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core'
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { StaffService } from '../../staff.service'
import { Gender, Role } from '../../../common_model'
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

  roles = Object.keys(Role)

  constructor(
    private staffService: StaffService,
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.buildStaffForm()
    this.errorMessage = undefined
    this.staffService.getPositions().subscribe(
      data => this.positions = data || [],
      err => this.errorMessage = err
    )
  }

  buildStaffForm() {
    this.staffForm = this.formBuilder.group({
      newStaff: this.formBuilder.group({
        name: ['', Validators.required],
        surname: ['', Validators.required],
        patronymic: ['', Validators.required],
        gender: [Gender.MALE, Validators.required],
        positionUid: ['', Validators.required],
        salary: [30000, Validators.required],
        experience: [0, [Validators.required, Validators.min(0)]],
        dateOfBirth: ['', Validators.required],
        firstWorkDate: ['', Validators.required]
      }),
      userInfo: this.formBuilder.group({
        nick: ['', Validators.required],
        email: ['@silverpaw.ru', Validators.required],
        password: ['', Validators.required],
        role: [Role.READER, Validators.required]
      })
    })
  }

  addNewStaff() {
    console.log(this.staffForm.getRawValue())
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
