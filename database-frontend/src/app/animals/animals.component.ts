import { Component, OnInit } from '@angular/core'
import { AuthService } from '../auth.service'
import { AnimalService } from './animal.service'
import { Animal, AnimalType } from './model/Animal'
import { Gender } from '../common_model'

@Component({
  selector: 'app-animals',
  templateUrl: './animals.component.html',
  styleUrls: ['./animals.component.css']
})
export class AnimalsComponent implements OnInit {

  animals: Animal[]
  Gender = Gender
  AnimalType = AnimalType

  ageFilterRange = [
    {min: 0, max: 1},
    {min: 1, max: 2},
    {min: 2, max: 5},
    {min: 5, max: 10},
    {min: 10, max: 20}
  ]
  weightFilterRange = [
    {min: 0, max: 1},
    {min: 1, max: 2},
    {min: 2, max: 5},
    {min: 5, max: 10},
    {min: 10, max: 20},
    {min: 20, max: 50}
  ]


  loading: boolean = false
  hasManagerPermissions: boolean = false
  errorMessage: string = undefined

  createAnimal: boolean = false
  viewAnimal: boolean = false

  constructor(private authService: AuthService, private animalsService: AnimalService) {
    this.hasManagerPermissions = authService.hasManagerPermission()
  }

  ngOnInit(): void {
  }

  getAnimals() {
    this.errorMessage = undefined
    this.loading = true
    this.animalsService.getAnimals().subscribe(
      data => {
        this.loading = false
        this.animals = data
      },
      err => {
        this.loading = false
        this.errorMessage = err
      }
    )
  }

  addAnimal() {
    this.createAnimal = true
  }
}
