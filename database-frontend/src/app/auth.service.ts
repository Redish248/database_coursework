import { Injectable } from '@angular/core'
import { AppConfigService } from './app-config.service'
import { HttpClient, HttpParams } from '@angular/common/http'
import { map } from 'rxjs'
import { Router } from '@angular/router'
import { Permission, User } from "./login/User"

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user: User = undefined
  permissions: Permission[]

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

  login(credentials) {
    const sendParams = new HttpParams()
      .append('username', credentials.username)
      .append('password', credentials.password)
    return this.http.post<User>(`${this.apiUrl}/login`, null, {
      params: sendParams,
      withCredentials: true,
      observe: 'response'
    }).pipe(
      map((user) => {
        console.log('sign in user', user)
        AuthService.setLocalStorage(credentials.username, credentials.password)
        return this.http.get<Permission[]>(`${this.apiUrl}/databases/permissions`).subscribe(
          permissions => {
            this.permissions = permissions
            this.user = {name: credentials.username}
            return user
          }
        )
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
        this.permissions = []
        this.user = undefined
        localStorage.removeItem("username")
        localStorage.removeItem("authData")
        this.router.navigate(['/login'])
      }, err => {
        console.log("error during logout - " + err)
      }
    )
  }

  hasAdminPermission(): boolean {
    return this.permissions.includes(Permission.ADMINISTRATION)
  }

  hasManagerPermission(): boolean {
    return this.permissions.includes(Permission.MANAGE_ANIMALS)
  }
}
