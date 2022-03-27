import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core'
import {FormGroup} from '@angular/forms'
import {ObjectsService} from "../objects.service";

@Component({
  selector: 'app-create-object',
  templateUrl: './app-create-object.component.html',
  styleUrls: ['./app-create-object.component.css']
})
export class AppCreateObjectsComponent implements OnInit {
  @Input() modalOpen: boolean
  @Output() closeModal = new EventEmitter()

  objectsForm: FormGroup
  errorMessage: string = undefined
  loading: boolean = false

  constructor(private objectsService: ObjectsService) {
    this.objectsForm = objectsService.buildObjectsForm()
  }

  ngOnInit(): void {
    this.errorMessage = undefined
  }

  createObject() {
    this.loading = true
    this.errorMessage = undefined
    console.log(this.objectsForm.getRawValue())
    this.objectsService.createObjects(this.objectsForm.getRawValue()).subscribe(
      _ => {
        this.loading = false
        this.closeModal.emit()
        this.modalOpen = false
      }, err => {
        this.loading = false
        this.errorMessage = err
      }
    )
  }
}
