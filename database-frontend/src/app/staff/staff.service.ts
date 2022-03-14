import { Injectable } from '@angular/core'
import { AppConfigService } from '../app-config.service'
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  constructor(private configService: AppConfigService,
              private http: HttpClient) {
  }

  private get apiUrl() {
    return this.configService.silverPawAppUrl
  }


  getStaff() {
    return this.http.get(`${this.apiUrl}/staff`)
  }
}
