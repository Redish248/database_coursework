import { Component, OnInit } from '@angular/core';
import {AuthService} from "../auth.service";
import { DatePipe } from '@angular/common'

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(public authService: AuthService, public datepipe: DatePipe) { }

  ngOnInit(): void {
    this.authService.getUserInfo()
  }

  getUserInfo() {
    return this.authService.userInfo
  }

  dateTransform(dateOld){
    return this.datepipe.transform(dateOld, 'dd-MM-yyyy');
  }

}
