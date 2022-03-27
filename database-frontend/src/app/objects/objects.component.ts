import { Component, OnInit } from '@angular/core'
import { ObjectsInfo } from "./Objects"
import { ObjectsService } from "./objects.service"
import { Amount } from '../common_model'

@Component({
  selector: 'app-objects',
  templateUrl: './objects.component.html',
  styleUrls: ['./objects.component.css', '../app.component.css']
})
export class ObjectsComponent implements OnInit {

  objects: ObjectsInfo[] = []
  loading: boolean = false
  errorMessage: string = undefined
  selectedObject: ObjectsInfo = undefined

  createNewObject: boolean = false
  viewObjectVal: boolean = false

  priceFilterRange = [
    {min: 0, max: 100},
    {min: 100, max: 200},
    {min: 200, max: 500},
    {min: 500, max: 1000},
    {min: 1000, max: 1500},
    {min: 1500, max: 2000},
    {min: 2000, max: 10000}
  ]

  amountFilterRange = [
    {min: 0, max: 5},
    {min: 5, max: 10},
    {min: 10, max: 15},
    {min: 15, max: 20},
    {min: 20, max: 50},
    {min: 50, max: 100},
    {min: 100, max: 1000}
  ]

  constructor(private objectsService: ObjectsService) {
  }

  ngOnInit(): void {
    this.getAllObjects()
  }

  getAllObjects() {
    this.loading = true
    this.errorMessage = undefined

    this.objectsService.getObjects().subscribe(
      data => {
        this.loading = false
        this.objects = data
      },
      err => {
        this.loading = false
        this.errorMessage = err
      }
    )
  }

  addObject() {
    this.createNewObject = true
  }

  viewObject(object: ObjectsInfo) {
    this.selectedObject = object
    this.viewObjectVal = true
  }

  rowColor(amount: number): string {
    if (amount < 15) return Amount.CRITICAL
    if (amount > 15 && amount <= 30) return Amount.AVERAGE
    else return Amount.ENOUGH
  }
}
