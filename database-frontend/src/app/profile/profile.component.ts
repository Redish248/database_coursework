import { Component, OnInit } from '@angular/core'
import { DatePipe } from '@angular/common'
import { ProfileService } from "./profile.service"

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  editMode: boolean = false
  newName: string
  newSurname: string
  newGender: string
  newDate: string

  constructor(public profileService: ProfileService, public datepipe: DatePipe) {
  }

  ngOnInit(): void {
    this.profileService.getUserInfo()
  }

  dateTransform(dateOld) {
    return this.datepipe.transform(dateOld, 'dd-MM-yyyy')
  }

  dateForBackend(dateOld) {
    return this.datepipe.transform(dateOld, 'yyyy-MM-dd')
  }

  dateInputShow(dateOld) {
    return this.datepipe.transform(dateOld, 'MM/dd/yyyy')
  }

  enableEditMode() {
    this.editMode = true
    this.newName = this.profileService.userInfo.name
    this.newSurname = this.profileService.userInfo.surname
    this.newGender = this.profileService.userInfo.gender
    this.newDate = this.dateInputShow(this.profileService.userInfo.dateOfBirth)
  }

  saveChanges() {
    console.log(this.newDate)
    this.profileService.updateUser(this.newName, this.newSurname, this.newGender, this.dateForBackend(this.newDate))
    this.editMode = false
  }

  cancel() {
    console.log(this.newDate)
    this.editMode = false
  }

}
