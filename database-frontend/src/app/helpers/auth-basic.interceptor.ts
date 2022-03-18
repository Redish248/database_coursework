import { Injectable } from '@angular/core'
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http'
import { Observable } from 'rxjs'
import { AuthService } from '../auth.service'
import { AppConfigService } from '../app-config.service'

@Injectable()
export class AuthBasicInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService, private appService: AppConfigService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.authService.getUser() &&
      request.url.startsWith(this.appService.silverPawBaseUrl)) {
      request = request.clone(
        {
          setHeaders: {
            Authorization: `Basic ${AuthBasicInterceptor.getAuth()}`
          },
          withCredentials: true
        }
      )
    }

    return next.handle(request)
  }

  private static getAuth() {
    return localStorage.getItem("authData")
  }
}
