import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule,Routes } from '@angular/router';
import { Component } from '@angular/core';
import {FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { HomePage2Component } from './home-page2/home-page2.component';
import { UiElementsPagePanelsComponent } from './ui-elements-page-panels/ui-elements-page-panels.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NavigationComponent } from './navigation/navigation.component';

import {CoreModule} from "./core/core.module";
import {AuthModule} from "./auth/auth.module";
import {AuthComponent} from "./auth/auth.component";
import {routing} from "./app.routing";
import {ApplyLeaveComponent}  from "./leave/applyleave-form/apply-leave.component";


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ApplyLeaveComponent,
    HomePage2Component,
    UiElementsPagePanelsComponent,
    HeaderComponent,
    FooterComponent,
    NavigationComponent,
  ],
  imports: [
    BrowserModule,
        CoreModule,
        AuthModule,
        routing,
        FormsModule,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

