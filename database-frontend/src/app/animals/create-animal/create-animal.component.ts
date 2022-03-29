import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core'
import { FormArray, FormGroup } from '@angular/forms'
import { AnimalService } from '../animal.service'
import { Feed } from '../../feed/Feed'
import { FeedService } from '../../feed/feed.service'
import { AnimalType } from '../model/Animal'
import { Gender } from '../../common_model'
import { forkJoin, retry } from 'rxjs'
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
  unknownOwner: string = ''

  feed: Feed[] = []
  users: User[] = []
  AnimalTypes = Object.keys(AnimalType)
  Gender = Object.keys(Gender)

  constructor(private animalService: AnimalService, private feedService: FeedService) {
    this.animalForm = animalService.buildForm()
  }

  ngOnInit(): void {
    this.unknownOwner = ''
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

  private getName(uid) {
    return this.users.find(el => el.uid == uid)
  }

  creatAnimal() {
    let newAnimal = this.animalForm.getRawValue()
    let uid = newAnimal.newOwner.uid
    console.log(uid)
    newAnimal.newOwner.fullName = uid ? this.getName(uid) : "незарегистрированный пользователь"
    newAnimal.newOwner.uid = uid ? uid : -1
    
    console.log("submit", newAnimal)
    this.errorMessage = undefined
    this.loading = true
    this.animalService.createAnimal(newAnimal).subscribe(
      _ => {
        this.loading = false
        this.modalOpened = false
        this.unknownOwner = ''
        this.modalClose.emit()
      }, error => {
        this.loading = false
        this.errorMessage = error
        this.unknownOwner = ''
      }
    )
  }

  get owner(): boolean {
    let o = this.animalForm.getRawValue().newOwner.uid
    return o == undefined || o == 'undefined'
  }

  get photo(): string {
    return this.animalForm.getRawValue().photo
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
