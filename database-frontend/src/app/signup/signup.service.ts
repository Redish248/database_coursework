import { Injectable } from '@angular/core'
import { AppConfigService } from '../app-config.service'
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private appConfig: AppConfigService,
              private http: HttpClient) {
  }

  private get apiUrl(): String {
    return this.appConfig.silverPawAppUrl
  }

  signup(newUser) {
    return this.http.post(`${this.apiUrl}/signup`, JSON.stringify(newUser), {headers: {'Content-Type': 'application/json'}})
  }
}
