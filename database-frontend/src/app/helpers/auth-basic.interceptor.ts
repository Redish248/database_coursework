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

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (this.authService.getUser() &&
      request.url.startsWith(this.appService.silverPawBaseUrl)) {
      request = request.clone(
        {
          setHeaders: {
            Authorization: `Basic ${AuthBasicInterceptor.getAuth()}`
          }
        }
      )
    }

    return next.handle(request)
  }


  private static getAuth() {
    return localStorage.getItem("authData")
  }
}
