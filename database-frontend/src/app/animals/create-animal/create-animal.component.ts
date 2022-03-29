import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core'
import { FormArray, FormGroup } from '@angular/forms'
import { AnimalService } from '../animal.service'
import { Feed } from '../../feed/Feed'
import { FeedService } from '../../feed/feed.service'
import { AnimalType } from '../model/Animal'
import { Gender } from '../../common_model'
import { forkJoin } from 'rxjs'
import { User } from '../model/User'

@Component({
  selector: 'app-create-animal',
  templateUrl: './create-animal.component.html',
  styleUrls: ['./create-animal.component.css']
})
export class CreateAnimalComponent implements OnInit {
  @Input() modalOpened: boolean
  @Output() modalClose = new EventEmitter()

  animalForm: FormGroup
  errorMessage: string = undefined
  loading: boolean = false

  feed: Feed[] = []
  users: User[] = []
  AnimalTypes = Object.keys(AnimalType)
  Gender = Object.keys(Gender)

  constructor(private animalService: AnimalService, private feedService: FeedService) {
    this.animalForm = animalService.buildForm()
  }

  ngOnInit(): void {
    this.getMetadata()
  }

  getMetadata() {
    this.loading = true
    this.errorMessage = undefined
    forkJoin({
        users: this.animalService.getUsers(),
        feed: this.feedService.getFeed()
      }
    ).subscribe(
      data => {
        this.loading = false
        this.users = data.users || []
        this.feed = data.feed || []
        console.log(this.users, this.feed)
      },
      err => {
        this.loading = false
        this.errorMessage = err
      })
  }

  creatAnimal() {
    console.log("submit", this.animalForm.getRawValue())
  }

  getFeedArr(): FormArray {
    return this.animalForm.get('feed') as FormArray
  }

  addNewFeed() {
    this.getFeedArr().push(this.animalService.feed)
  }

  deleteFeed(index: number) {
    if (this.getFeedArr().length > 1)
      this.getFeedArr().removeAt(index)
  }

  getTypicalIllnesses(): FormArray {
    return this.animalForm.get('animalTypeInfo').get('typicalIllnesses') as FormArray

  }

  addTI() {
    this.getTypicalIllnesses().push(this.animalService.characteristic)
  }

  deleteTI(index: number) {
    if (this.getTypicalIllnesses().length > 1)
      this.getTypicalIllnesses().removeAt(index)
  }

  getHabits(): FormArray {
    return this.animalForm.get('animalTypeInfo').get('habits') as FormArray
  }

  addHabit() {
    this.getHabits().push(this.animalService.characteristic)
  }

  deleteHabit(index: number) {
    if (this.getHabits().length > 1)
      this.getHabits().removeAt(index)
  }

  getAdditionalInfo(): FormArray {
    return this.animalForm.get('animalTypeInfo').get('additionalInfo') as FormArray
  }

  addInfo() {
    this.getAdditionalInfo().push(this.animalService.characteristic)
  }

  deleteInfo(index: number) {
    if (this.getAdditionalInfo().length > 1)
      this.getAdditionalInfo().removeAt(index)
  }

  getOtherCharacteristic(): FormArray {
    return this.animalForm.get('additionalCharacteristics') as FormArray

  }

  addCharacteristic() {
    this.getOtherCharacteristic().push(this.animalService.characteristic)
  }

  deleteCharacteristic(index: number) {
    if (this.getOtherCharacteristic().length > 1)
      this.getOtherCharacteristic().removeAt(index)
  }


}
