import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core'
import {FormGroup} from '@angular/forms'
import {FeedService} from "../feed.service";

@Component({
  selector: 'app-create-feed',
  templateUrl: './app-create-feed.component.html',
  styleUrls: ['./app-create-feed.component.css']
})
export class AppCreateFeedComponent implements OnInit {
  @Input() modalOpen: boolean
  @Output() closeModal = new EventEmitter()

  feedForm: FormGroup
  errorMessage: string = undefined
  loading: boolean = false

  constructor(private feedService: FeedService) {
    this.feedForm = feedService.buildStaffForm()
  }

  ngOnInit(): void {
    this.errorMessage = undefined
  }

  createFeed() {
    this.loading = true
    this.errorMessage = undefined
    this.feedService.createFeed(this.feedForm.getRawValue()).subscribe(
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
