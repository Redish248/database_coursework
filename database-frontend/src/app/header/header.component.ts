import { Component, OnInit } from '@angular/core'
import { AuthService } from '../auth.service'
import {ProfileService} from "../profile/profile.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public authService: AuthService, public profileService: ProfileService) {

  }

  ngOnInit(): void {
  }

  getUsername() {
    return localStorage.getItem("username")
  }

}
