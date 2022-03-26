import { Component, OnInit } from '@angular/core'
import { StaffService } from './staff.service'
import { Staff } from './model/Staff'
import { Position } from './model/Position'
import { forkJoin } from 'rxjs'

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

  constructor(private staffService: StaffService) {
  }

  ngOnInit(): void {
    // todo: check permissions
    this.getAllStaff()
  }

  getAllStaff() {
    this.loading = true
    this.errorMessage = undefined

    this.staffService.getStaff().subscribe(
      data => {
        this.loading = false
        console.log("staff", data)
        this.staff = data
      },
      err => {
        this.loading = false
        this.errorMessage = err
      }
    )

  }

  addStaff() {
    this.createNewStaffAccount = true
  }

  viewStaff(staff: Staff) {
    this.selectedStaff = staff
    this.viewStaffAccount = true
  }
}
