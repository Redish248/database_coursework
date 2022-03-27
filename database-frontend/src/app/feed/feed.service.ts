import {Injectable} from '@angular/core'
import {AppConfigService} from '../app-config.service'
import {HttpClient} from '@angular/common/http'
import {Feed} from "./Feed";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class FeedService {

  constructor(private configService: AppConfigService,
              private http: HttpClient,
              private formBuilder: FormBuilder) {
  }

  private get apiUrl() {
    return `${this.configService.silverPawAppUrl}/feed`
  }


  getFeed() {
    return this.http.get<Feed[]>(this.apiUrl + '/getAllFeed')
  }

  buildStaffForm(): FormGroup {
    return this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      price: [0, Validators.required],
      amount: [0, Validators.required]
    })

  }

  createFeed(feed) {
    return this.http.post<Feed>(`${this.apiUrl}` + '/createFeed', JSON.stringify(feed), {headers: {'Content-Type': 'application/json'}})
  }

  updateFeed(uid, feed) {
    feed.uid = uid
    return this.http.post<Feed>(`${this.apiUrl}` + '/updateFeed', JSON.stringify(feed), {headers: {'Content-Type': 'application/json'}})
  }

  deleteFeed(uid: number) {
    return this.http.delete(`${this.apiUrl}/deleteFeed/${uid}`)
  }


}
