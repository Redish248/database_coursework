import { Component, OnInit } from '@angular/core';
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signin',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(public router: Router, private auth: AuthService) { }
  nick = '';
  name = '';
  surname = ''
  date_of_birth = ''
  gender = ''
  email = '';
  password = '';
  repeat = '';

  register(nick: string, name: string, surname: string, date_of_birth: string, gender: string, email: string, password: string, repeat: string) {
    let register_error = document.getElementById('register_error');
    if (register_error != null) {
      register_error.innerText = '';
      if (password === '' || nick === '' || email === '' || name === '' || repeat === '') {
        register_error.innerText = 'Заполните пустые поля!';
      } else {
        if (repeat !== password) {
          register_error.innerText = 'Поля с паролями должны совпадать!';
        } else {
          this.auth.register(nick, name, surname, date_of_birth, gender, email, password).subscribe((response) => {
            this.auth.login(nick, password).subscribe((resp) => {
              this.router.navigate(['']).then(() => {
                window.location.reload();
              });
            });
          }, () => {
            if (register_error != null) {
              register_error.innerText = 'Такой пользователь уже существует. Или что-то пошло не так';
            }
          });
        }
      }
    }
  }

  ngOnInit(): void {
  }

}
