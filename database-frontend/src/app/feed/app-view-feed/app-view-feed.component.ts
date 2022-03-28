import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core'
import {FormGroup} from '@angular/forms'
import {ViewMode} from '../../common_model'
import {Feed} from "../Feed";
import {FeedService} from "../feed.service";
import {AuthService} from "../../auth.service";

@Component({
  selector: 'app-view-feed',
  templateUrl: './app-view-feed.component.html',
  styleUrls: ['./app-view-feed.component.css']
})
export class AppViewFeedComponent implements OnInit {
  @Input() modalOpen: boolean
  @Input() feed: Feed
  @Output() closeModal = new EventEmitter()

  feedForm: FormGroup
  errorMessage: string = undefined
  ViewMode = ViewMode
  mode: ViewMode = ViewMode.VIEW
  loading: boolean = false

  hasAdminPermissions: boolean = true

  constructor(private feedService: FeedService, private authService: AuthService) {
    this.feedForm = feedService.buildFeedForm()
  }

  ngOnInit(): void {
    this.feedForm.reset({
      name: this.feed.name,
      description: this.feed.description,
      price: this.feed.price,
      amount: this.feed.amount
    })
    this.errorMessage = undefined
    this.hasAdminPermissions = this.authService.hasAdminPermission()
    this.feedForm.disable()
  }

  switchModeToEdit() {
    if (this.mode == ViewMode.VIEW) {
      this.mode = ViewMode.EDIT
      this.feedForm.enable()
    }
  }

  update() {
    this.loading = true
    this.errorMessage = undefined
    this.feedService.updateFeed(this.feed.uid, this.feedForm.getRawValue()).subscribe(
      data => {
        this.loading = false
        this.feed = data
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
    this.feedForm.reset({
      name: this.feed.name,
      description: this.feed.description,
      price: this.feed.price,
      amount: this.feed.amount
    })
    this.mode = ViewMode.VIEW
  }

  deleteFeed() {
    this.loading = true
    this.errorMessage = undefined
    this.feedService.deleteFeed(this.feed.uid).subscribe(
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
