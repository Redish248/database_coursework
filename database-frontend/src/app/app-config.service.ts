import { Injectable } from '@angular/core'

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  constructor() {
  }

  get silverPawUrl(): string {
    return 'http://localhost:8088'
  }
}
