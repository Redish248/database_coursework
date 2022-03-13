import { Injectable } from '@angular/core'
import { HttpClient, HttpParams } from "@angular/common/http"
import { AppConfigService } from './app-config.service'

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient, private appConfig: AppConfigService) {
  }

  get silverPowUrl(): String {
    return this.appConfig.silverPawUrl
  }


  login(login: string, password: string) {

    const sendParams = new HttpParams()
      .append('username', login)
      .append('password', password)

    return this.http.post(`${this.silverPowUrl}/login`, null, {
      params: sendParams,
      withCredentials: true,
      observe: 'response'
    })
  }

  register(login: string, name: string, email: string, password: string) {
    const sendParams = new HttpParams()
      .append('login', login)
      .append('email', email)
      .append('name', name)
      .append('password', password)
    return this.http.post(`${this.silverPowUrl}/databases/signup`, null, {
      params: sendParams,
      withCredentials: true,
      observe: 'response'
    })
  }

  logout() {
    return this.http.post(`${this.silverPowUrl}/logout`, null, {
      withCredentials: true
    })
  }
}
