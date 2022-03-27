import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core'
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { SignupService } from './signup.service'
import { Gender } from '../common_model'
import { AuthService } from '../auth.service'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  @Input() modalOpened: boolean
  @Output() closeModal = new EventEmitter()

  signupForm: FormGroup
  errorMessage: string = undefined
  loading: boolean = false
  Gender = Gender

  constructor(private formBuilder: FormBuilder,
              private signupService: SignupService,
              private authService: AuthService) {
  }

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      username: ['', Validators.required],
      surname: ['', Validators.required],
      password: ['', Validators.required],
      nick: ['', [Validators.required, Validators.pattern("[A-Za-z]")]],
      email: ['', Validators.required],
      dateOfBirth: ['', Validators.required],
      gender: ['male', Validators.required]
    })
  }

  signup() {
    this.loading = true
    this.errorMessage = undefined
    this.signupService.signup(this.signupForm.getRawValue()).subscribe(
      _ => {
        // login after success registration
        this.authService.login({
          username: this.signupForm.value.nick,
          password: this.signupForm.value.password
        }).subscribe(
          _ => {
            this.loading = false
            this.closeModal.emit({
              username: this.signupForm.value.nick,
              password: this.signupForm.value.password
            })
            this.modalOpened = false
          },
          err => {
            this.loading = false
            this.errorMessage = err
          }
        )
      }, err => {
        this.loading = false
        this.errorMessage = err
      })
  }
}
