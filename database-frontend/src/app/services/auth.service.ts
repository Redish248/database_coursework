import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(login: string, password: string) {

    const sendParams = new HttpParams()
      .append('username', login)
      .append('password', password);

    return this.http.post('http://localhost:8088/login', null, {
      params: sendParams,
      withCredentials: true,
      observe: 'response'
    });
  }

  register(nick: string, name: string, surname: string, date_of_birth: string, gender: string, email: string, password: string) {
    const sendParams = new HttpParams()
      .append('nick', nick)
      .append('password', password)
      .append('name', name)
      .append('surname', surname)
      .append('email', email)
      .append('gender', gender)
      .append('dateOfBirth', date_of_birth);
    return this.http.post('http://localhost:8088/databases/signup', null, {
      params: sendParams,
      withCredentials: true,
      observe: 'response'
    });
  }

  logout() {
    return this.http.post('http://localhost:8088/logout', null, {
      withCredentials: true
    });
  }
}
