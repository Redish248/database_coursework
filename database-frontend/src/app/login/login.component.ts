import { Component, OnInit } from '@angular/core'
import { AuthService } from "../services/auth.service"
import { Router } from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public router: Router, private auth: AuthService) {
  }

  log = ''
  pass = ''

  log_in(login: string, password: string) {
    let login_error = document.getElementById('login_error')
    if (login_error != null) {
      login_error.innerText = ''
    }
    if (password === '' || login === '') {
      if (login_error != null) {
        login_error.innerText = 'Введите все данные!'
      }
    } else {
      this.auth.login(login, password).subscribe(() => {
        sessionStorage.setItem('password', password)
        sessionStorage.setItem('login', "true")
        this.router.navigate(['']).then(() => {
          window.location.reload()
        })
      }, () => {
        if (login_error != null) {
          login_error.innerText = 'Неправильное имя пользователя или пароль'
        }
      })
    }
  }

  ngOnInit(): void {
  }

}
