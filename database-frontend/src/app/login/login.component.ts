import { Component, OnInit } from '@angular/core'
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { AuthService } from '../auth.service'
import { ActivatedRoute, Router } from '@angular/router'
import { first } from 'rxjs'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup
  returnUrl: string
  errorMessage: String = undefined

  registrationMode: boolean = false

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private route: ActivatedRoute,
              private router: Router
  ) {
    if (this.authService.getUser()) {
      this.router.navigate(['/'])
    }
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/'
  }

  submit() {
    this.errorMessage = undefined
    console.log("submit login")
    this.authService.login(this.loginForm.getRawValue())
      .pipe(first())
      .subscribe(
        _ => {
          this.router.navigate([this.returnUrl])
        },
        err => this.errorMessage = err
      )
  }

  signup(data) {
    this.registrationMode = false
    this.authService.loginAfterRegistration(data.username, data.password)
  }
}
