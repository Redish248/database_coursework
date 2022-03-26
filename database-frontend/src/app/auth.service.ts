import { Injectable } from '@angular/core'
import { AppConfigService } from './app-config.service'
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'
import {User, UserInfo} from './login/User'
import { map } from 'rxjs'
import { Router } from '@angular/router'

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user: User = undefined
  userInfo: UserInfo = undefined

  constructor(private configService: AppConfigService,
              private http: HttpClient,
              private router: Router) {
  }

  private get apiUrl(): string {
    return this.configService.silverPawBaseUrl
  }

  private get appUrl(): string {
    return this.configService.silverPawAppUrl
  }

  getUser(): string {
    return localStorage.getItem("username")
  }

  loginAfterRegistration(username: string, password: string) {
    AuthService.setLocalStorage(username, password)
    this.user = {name: username}
    this.router.navigate(['/'])
  }

  login(credentials) {
    const sendParams = new HttpParams()
      .append('username', credentials.username)
      .append('password', credentials.password)
    const authToken = btoa(`${credentials.username}:${credentials.password}`)
    console.log(sendParams)
    return this.http.post<User>(`${this.apiUrl}/login`, null, {
      params: sendParams,
      withCredentials: true,
      observe: 'response'
    }).pipe(
      map((user) => {
        console.log(user)
        AuthService.setLocalStorage(credentials.username, credentials.password)
        this.user = {name: credentials.username}
        return user
      })
    )
  }

  private static setLocalStorage(username: string, pswd: string) {
    localStorage.setItem("username", username)
    const authToken = window.btoa(`${username}:${pswd}`)
    localStorage.setItem("authData", authToken)
  }

  logout() {
    return this.http.post(`${this.apiUrl}/logout`, null).subscribe(
      _ => {
        this.user = undefined
        localStorage.removeItem("username")
        localStorage.removeItem("authData")
        this.router.navigate(['/login'])
      }, err => {
        console.log("error during logout - " + err)
      }
    )
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
}
