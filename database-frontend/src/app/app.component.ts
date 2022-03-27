import { Component, LOCALE_ID } from '@angular/core'
import { registerLocaleData } from '@angular/common'
import localeRu from "@angular/common/locales/ru"

registerLocaleData(localeRu)

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [{provide: LOCALE_ID, useValue: 'ru'}]
})
export class AppComponent {
  title = 'database-frontend'
}
