import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn = sessionStorage.getItem('login') === "true";

  constructor(public router: Router, private auth: AuthService) { }

  logout() {
    this.auth.logout().subscribe(() => {
        sessionStorage.setItem('login', "false");
        this.router.navigate(['']).then(() => {
          window.location.reload();
        });
      },
      error => {
        console.log(error);
      });
  }

  ngOnInit(): void {
  }

}
