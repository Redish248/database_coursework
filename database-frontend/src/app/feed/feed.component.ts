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

}
