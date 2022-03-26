import { Injectable } from '@angular/core'
import { AppConfigService } from '../app-config.service'
import { HttpClient} from '@angular/common/http'
import { Router } from '@angular/router'
import {UserInfo} from "./UserInfo";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  userInfo: UserInfo = undefined

  constructor(private configService: AppConfigService,
              private http: HttpClient,
              private router: Router) {
  }

  private get appUrl(): string {
    return this.configService.silverPawAppUrl
  }

  getUserInfo() {
    const nick = localStorage.getItem("username");
    return this.http.get<UserInfo>(`${this.appUrl}/users/getUserByNick?nick=${nick}`).subscribe(
      (data: UserInfo) => {
        this.userInfo = data;
        this.router.navigate(['/profile'])
      }, err => {
        console.log("error during getting user info - " + err)
      }
    )
  }

  updateUser(newName, newSurname, newGender, newDate) {
    const newUser = new UserInfo;
    newUser.uid = this.userInfo.uid
    newUser.name = newName
    newUser.surname = newSurname
    newUser.gender = newGender
    newUser.dateOfBirth = newDate
    newUser.nick = this.userInfo.nick
    newUser.userType = this.userInfo.userType
    newUser.email = this.userInfo.email
    newUser.password = this.userInfo.password
    this.http.post(`${this.appUrl}/users/updateUser`, JSON.stringify(newUser),
      {headers: {'Content-Type': 'application/json'}})
      .subscribe(
        (data: UserInfo) => {
          this.userInfo = data;
        }, err => {
          console.log("error during updating user - " + err)
        }
    )
  }
}
