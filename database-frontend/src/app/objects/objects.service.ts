import {Injectable} from '@angular/core'
import {AppConfigService} from '../app-config.service'
import {HttpClient} from '@angular/common/http'
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ObjectsInfo} from "./Objects";

@Injectable({
  providedIn: 'root'
})
export class ObjectsService {

  constructor(private configService: AppConfigService,
              private http: HttpClient,
              private formBuilder: FormBuilder) {
  }

  private get apiUrl() {
    return `${this.configService.silverPawAppUrl}/objects`
  }


  getObjects() {
    return this.http.get<ObjectsInfo[]>(this.apiUrl + '/getAllObjects')
  }

  buildObjectsForm(): FormGroup {
    return this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      price: [0, Validators.required],
      amount: [0, Validators.required]
    })

  }

  createObjects(objects) {
    return this.http.post<ObjectsInfo>(`${this.apiUrl}` + '/createObject', JSON.stringify(objects), {headers: {'Content-Type': 'application/json'}})
  }

  updateObjects(uid, objects) {
    objects.uid = uid
    return this.http.post<ObjectsInfo>(`${this.apiUrl}` + '/updateObject', JSON.stringify(objects), {headers: {'Content-Type': 'application/json'}})
  }

  deleteObjects(uid: number) {
    return this.http.delete(`${this.apiUrl}/deleteObject/${uid}`)
  }


}
