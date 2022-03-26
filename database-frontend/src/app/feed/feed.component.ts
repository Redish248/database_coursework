import {Component, OnInit} from '@angular/core';
import {Feed} from "./Feed";
import {FeedService} from "./feed.service";

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  feeds: Feed[] = []
  loading: boolean = false
  errorMessage: string = undefined
  selectedFeed: Feed = undefined

  createNewFeed: boolean = false
  viewFeedVal: boolean = false

  constructor(private feedService: FeedService) {
  }

  ngOnInit(): void {
    this.getAllFeed()
  }

  getAllFeed() {
    this.loading = true
    this.errorMessage = undefined

    this.feedService.getFeed().subscribe(
      data => {
        this.loading = false
        this.feeds = data
      },
      err => {
        this.loading = false
        this.errorMessage = err
      }
    )

  }

  addFeed() {
    this.createNewFeed = true
  }

  viewFeed(feed: Feed) {
    this.selectedFeed = feed
    this.viewFeedVal = true
  }

  closeModalView() {
    this.viewFeedVal = false;
    this.selectedFeed = undefined;
    this.getAllFeed()
  }

}
