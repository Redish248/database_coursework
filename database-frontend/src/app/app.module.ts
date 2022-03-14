import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'

import { AppComponent } from './app.component'
import { HeaderComponent } from './header/header.component'
import { NotFoundPageComponent } from './not-found-page/not-found-page.component'
import { HomeComponent } from './home/home.component'
import { LoginComponent } from './login/login.component'
import { SignupComponent } from './signup/signup.component'
import { FeedComponent } from './feed/feed.component'
import { ObjectsComponent } from './objects/objects.component'
import { StaffComponent } from './staff/staff.component'
import { RouterModule, Routes } from '@angular/router'
import { AnimalsComponent } from './animals/animals.component'
import { ClarityModule } from '@clr/angular'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http'
import { AuthGuard } from './auth.guard'
import { ErrorInterceptor } from './error.interceptor'

const appRoutes: Routes = [
  {path: '', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'animals', component: AnimalsComponent, canActivate: [AuthGuard]},
  {path: 'feed', component: FeedComponent, canActivate: [AuthGuard]},
  {path: 'objects', component: ObjectsComponent, canActivate: [AuthGuard]},
  {path: 'staff', component: StaffComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: '**', component: NotFoundPageComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NotFoundPageComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    FeedComponent,
    ObjectsComponent,
    StaffComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    ClarityModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    AuthGuard,
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
