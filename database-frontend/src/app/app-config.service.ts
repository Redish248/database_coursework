import { Injectable } from '@angular/core'

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  constructor() {
  }

  get silverPawBaseUrl(): string {
    return 'http://localhost:8088'
  }
  get silverPawAppUrl(): string {
    return 'http://localhost:8088/database'
  }
}
