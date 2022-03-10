import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'

import { AppComponent } from './app.component'
import { RouterModule, Routes } from '@angular/router'
import { HeaderComponent } from './header/header.component'
import { AnimalsComponent } from './animals/animals.component'
import { NotFoundPageComponent } from './not-found-page/not-found-page.component'
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { FeedComponent } from './feed/feed.component';
import { ObjectsComponent } from './objects/objects.component';
import { PersonalComponent } from './personal/personal.component'

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'animals', component: AnimalsComponent},
  {path: 'feed', component: FeedComponent},
  {path: 'objects', component: ObjectsComponent},
  {path: 'personal', component: PersonalComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: '**', component: NotFoundPageComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AnimalsComponent,
    NotFoundPageComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    FeedComponent,
    ObjectsComponent,
    PersonalComponent
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
