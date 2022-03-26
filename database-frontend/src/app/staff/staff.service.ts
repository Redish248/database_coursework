import { Injectable } from '@angular/core'
import { AppConfigService } from '../app-config.service'
import { HttpClient } from '@angular/common/http'
import { Staff } from './model/Staff'
import { Position } from './model/Position'
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { Gender } from '../common_model'

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  constructor(private configService: AppConfigService,
              private http: HttpClient,
              private formBuilder: FormBuilder) {
  }

  private get apiUrl() {
    return `${this.configService.silverPawAppUrl}/staff`
  }

  buildStaffForm(): FormGroup {
    return this.formBuilder.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      patronymic: ['', Validators.required],
      gender: [Gender.MALE, Validators.required],
      positionUid: ['', Validators.required],
      salary: [30000, Validators.required],
      experience: [0, [Validators.required, Validators.min(0)]],
      dateOfBirth: ['', Validators.required],
      firstWorkDate: ['', Validators.required]
    })

  }

  getStaff() {
    return this.http.get<Staff[]>(this.apiUrl)
  }

  getPositions() {
    return this.http.get<Position[]>(`${this.apiUrl}/positions`)
  }

  addStaff(staff) {
    return this.http.post<Staff>(`${this.apiUrl}`, JSON.stringify(staff), {headers: {'Content-Type': 'application/json'}})
  }

  updateStaff(uid, staff) {
    return this.http.put<Staff>(`${this.apiUrl}/${uid}`, JSON.stringify(staff), {headers: {'Content-Type': 'application/json'}})
  }

  deleteStaff(staff) {

  }
}
