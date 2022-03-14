import { Injectable } from '@angular/core'
import { AppConfigService } from './app-config.service'
import { HttpClient, HttpParams } from '@angular/common/http'
import { User } from './login/User'
import { map } from 'rxjs'
import { Router } from '@angular/router'

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user: User = undefined

  constructor(private configService: AppConfigService,
              private http: HttpClient,
              private router: Router) {
  }

  private get apiUrl(): string {
    return this.configService.silverPawBaseUrl
  }

  getUser(): string {
    return localStorage.getItem("username")
  }

  loginAfterRegistration(username: string) {
    localStorage.setItem("username", username)
    this.user = {name: username}
    this.router.navigate(['/'])
  }

  login(credentials) {
    const sendParams = new HttpParams()
      .append('username', credentials.username)
      .append('password', credentials.password)
    console.log(sendParams)
    return this.http.post(`${this.apiUrl}/login`, null, {
      params: sendParams,
      withCredentials: true,
      observe: 'response'
    }).pipe(
      map((user) => {
        localStorage.setItem("username", credentials.username)
        this.user = {name: credentials.username}
        return user
      })
    )
  }

  logout() {
    return this.http.post(`${this.apiUrl}/logout`, null).subscribe(
      _ => {
        this.user = undefined
        localStorage.removeItem("username")
        this.router.navigate(['/login'])
      }, err => {
        console.log("error during logout - " + err.message)
      }
    )
  }
}
