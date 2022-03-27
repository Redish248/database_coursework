import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core'
import {FormGroup} from '@angular/forms'
import {ViewMode} from '../../common_model'
import {ObjectsInfo} from "../Objects";
import {ObjectsService} from "../objects.service";

@Component({
  selector: 'app-view-object',
  templateUrl: './app-view-object.component.html',
  styleUrls: ['./app-view-object.component.css']
})
export class AppViewObjectComponent implements OnInit {
  @Input() modalOpen: boolean
  @Input() objectsInfo: ObjectsInfo
  @Output() closeModal = new EventEmitter()

  objectsForm: FormGroup
  errorMessage: string = undefined
  ViewMode = ViewMode
  mode: ViewMode = ViewMode.VIEW
  loading: boolean = false

  constructor(private objectsService: ObjectsService) {
    this.objectsForm = objectsService.buildObjectsForm()
  }

  ngOnInit(): void {
    this.objectsForm.reset({
      name: this.objectsInfo.name,
      description: this.objectsInfo.description,
      price: this.objectsInfo.price,
      amount: this.objectsInfo.amount
    })
    this.errorMessage = undefined
    this.objectsForm.disable()
  }

  switchModeToEdit() {
    if (this.mode == ViewMode.VIEW) {
      this.mode = ViewMode.EDIT
      this.objectsForm.enable()
    }
  }

  update() {
    this.loading = true
    this.errorMessage = undefined
    this.objectsService.updateObjects(this.objectsInfo.uid, this.objectsForm.getRawValue()).subscribe(
      data => {
        this.loading = false
        this.objectsInfo = data
      },
      err => {
        this.loading = false
        this.errorMessage = err
      }
    )
    this.cancelEdit()
    location.reload();
  }

  cancelEdit(){
    this.objectsForm.reset({
      name: this.objectsInfo.name,
      description: this.objectsInfo.description,
      price: this.objectsInfo.price,
      amount: this.objectsInfo.amount
    })
    this.mode = ViewMode.VIEW
  }

  deleteObject() {
    this.loading = true
    this.errorMessage = undefined
    this.objectsService.deleteObjects(this.objectsInfo.uid).subscribe(
      _ => {
        this.loading = false
        this.modalOpen = false
        this.closeModal.emit()
      },
      err => {
        this.loading = false
        this.errorMessage = err
      }
    )
    location.reload();
  }

}
