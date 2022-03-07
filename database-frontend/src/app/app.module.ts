import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'

import { AppComponent } from './app.component'
import { RouterModule, Routes } from '@angular/router'
import { HeaderComponent } from './header/header.component'
import { AnimalsComponent } from './animals/animals.component'
import { NotFoundPageComponent } from './not-found-page/not-found-page.component'
import { HomeComponent } from './home/home.component'

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'animals', component: AnimalsComponent},
  {path: '**', component: NotFoundPageComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AnimalsComponent,
    NotFoundPageComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
