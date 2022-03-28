import { Component, OnInit } from '@angular/core'
import { StaffService } from './staff.service'
import { Staff } from './model/Staff'
import { Gender } from '../common_model'
import { DatePipe } from '@angular/common'
import { AuthService } from '../auth.service'

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {
  staff: Staff[] = []
  loading: boolean = false
  errorMessage: string = undefined
  selectedStaff: Staff = undefined

  createNewStaffAccount: boolean = false
  viewStaffAccount: boolean = false

  hasAdminPermissions: boolean = true

  Gender = Gender
  ageFilterRange = [
    {min: 0, max: 14},
    {min: 14, max: 16},
    {min: 17, max: 18},
    {min: 19, max: 25},
    {min: 26, max: 45},
    {min: 46, max: 55},
    {min: 56, max: 100}
  ]
  experienceFilterRange = [
    {min: 0, max: 1},
    {min: 2, max: 5},
    {min: 6, max: 10},
    {min: 11, max: 20}
  ]
  salaryFilterParams = [
    {min: 0, max: 15000},
    {min: 15001, max: 30000},
    {min: 30001, max: 60000},
    {min: 60000, max: 100000}
  ]

  constructor(private staffService: StaffService, private datePipe: DatePipe, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.hasAdminPermissions = this.authService.hasAdminPermission()
    this.getAllStaff()
  }

  getAllStaff() {
    this.loading = true
    this.errorMessage = undefined

    this.staffService.getStaff().subscribe(
      data => {
        this.loading = false
        this.staff = data
        this.staff.forEach(el => {
          el['fullName'] = `${el.surname} ${el.name} ${el.patronymic}`
          el['age'] = StaffComponent.getAge(el.dateOfBirth)
          el.dateOfBirth = this.replaceDate(el.dateOfBirth)
          el.firstWorkDate = this.replaceDate(el.firstWorkDate)
        })
        console.log("staff", this.staff)
      },
      err => {
        this.loading = false
        this.errorMessage = err
      }
    )
  }

  private replaceDate(dateString: string): string {
    return this.datePipe.transform(dateString.replace(/-/g, "/"), "dd/MM/yyyy")
  }

  addStaff() {
    this.createNewStaffAccount = true
  }

  viewStaff(staff: Staff) {
    this.selectedStaff = staff
    this.viewStaffAccount = true
  }

  private static getAge(birthday): number {
    const today = new Date()
    birthday = new Date(birthday)
    let age = today.getFullYear() - birthday.getFullYear()
    let m = today.getMonth() - birthday.getMonth()
    if (m < 0 || (m === 0 && today.getDate() < birthday.getDate())) {
      age--
    }
    return age
  }
}
