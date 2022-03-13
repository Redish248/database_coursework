import { Injectable } from '@angular/core'
import { AppConfigService } from './app-config.service'
import { HttpClient, HttpParams } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private configService: AppConfigService, private http: HttpClient) {
  }

  get apiUrl(): string {
    return this.configService.silverPawBaseUrl
  }

  public get userName(): string {
    return ''
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
      })
  }


  logout() {
  }
}
