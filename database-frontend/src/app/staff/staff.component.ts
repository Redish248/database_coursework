import { Component, OnInit } from '@angular/core'
import { StaffService } from './staff.service'

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {
  staff
  errorMessage: string = undefined

  constructor(private staffService: StaffService) {
  }

  ngOnInit(): void {
   this.getStaff()
  }

  getStaff() {
    this.errorMessage = undefined
    this.staffService.getStaff().subscribe(
      data => this.staff = data,
      err => this.errorMessage = err
    )

  }
}
