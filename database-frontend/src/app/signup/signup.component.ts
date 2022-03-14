import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core'
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { SignupService } from './signup.service'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  @Input() modalOpened: boolean
  @Output() closeModal = new EventEmitter<string>()

  signupForm: FormGroup
  errorMessage: string = undefined

  constructor(private formBuilder: FormBuilder,
              private signupService: SignupService) {
  }

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      username: ['', Validators.required],
      surname: ['', Validators.required],
      password: ['', Validators.required],
      nick: ['', Validators.required],
      email: ['', Validators.required],
      gender: ['male', Validators.required]
    })
  }

  signup() {
    this.errorMessage = undefined
    this.signupService.signup(this.signupForm.getRawValue()).subscribe(
      _ => {
        this.closeModal.emit(this.signupForm.value.username)
        this.modalOpened = false
      }, err => this.errorMessage = err
    )

  }

}
