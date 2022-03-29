import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { AppConfigService } from '../app-config.service'
import { Animal } from './model/Animal'
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { User } from './model/User'

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  constructor(private configService: AppConfigService,
              private http: HttpClient,
              private formBuilder: FormBuilder) {
  }

  private get apiUrl() {
    return `${this.configService.silverPawAppUrl}/mongo/animals`
  }

  buildForm(): FormGroup {
    return this.formBuilder.group({
      name: ['', Validators.required],
      animalType: ['', Validators.required],
      gender: ['', Validators.required],
      weight: ['', Validators.required],
      age: ['', Validators.required],
      dateOfArrival: ['', Validators.required],
      placeOfArrival: ['', Validators.required],
      photo: ['', Validators.required],
      furColor: ['', Validators.required],
      eyesColor: ['', Validators.required],
      passport: this.formBuilder.group({
        number: ['', Validators.required],
        officialName: ['', Validators.required]
      }),
      newOwner: this.formBuilder.group({
        uid: ['', Validators.required],
        // fullName: '',
        phone: ['', Validators.required],
        email: ['', Validators.required],
        address: ['', Validators.required]
      }),
      feed: this.formBuilder.array([this.feed]),
      animalTypeInfo: this.formBuilder.group({
        typicalIllnesses: this.formBuilder.array([this.characteristic]),
        habits: this.formBuilder.array([this.characteristic]),
        additionalInfo: this.formBuilder.array([this.characteristic])
      }),
      additionalCharacteristics: this.formBuilder.array([this.characteristic])
    })
  }

  get feed(): FormGroup {
    return this.formBuilder.group({
      uid: ['', Validators.required],
      amountInGramm: ['', Validators.required],
    })
  }

  get characteristic(): FormGroup {
    return this.formBuilder.group({
        name: ['', Validators.required],
        description: ['', Validators.required]
      }
    )
  }

  getAnimals() {
    return this.http.get<Animal[]>(`${this.apiUrl}/getAllMongoAnimals`)
  }

  createAnimal(animal: Animal) {
    return this.http.post(`${this.apiUrl}/createMongoAnimal`, JSON.stringify(animal), {headers: {'Content-Type': 'application/json'}})
  }

  updateAnimal(animal: Animal) {
    return this.http.post(`${this.apiUrl}/updateMongoAnimal`, JSON.stringify(animal), {headers: {'Content-Type': 'application/json'}})
  }

  deleteAnimal(animalId: string) {
    return this.http.delete(`${this.apiUrl}/deleteMongoAnimal/${animalId}`)
  }

  getUsers() {
    return this.http.get<User[]>(`${this.apiUrl}/getSystemUsers`)
  }
}
