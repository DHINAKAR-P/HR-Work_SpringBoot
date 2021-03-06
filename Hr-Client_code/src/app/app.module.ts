﻿import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule,Routes } from '@angular/router';
import { Component } from '@angular/core';
import {FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProfilePageComponent } from './profile-form/profile-form.component';
import { HomePage2Component } from './home-page2/home-page2.component';
import { UiElementsPagePanelsComponent } from './ui-elements-page-panels/ui-elements-page-panels.component';
import { HeaderComponent } from './header/header.component';
import { Header2Component } from './header/header2.component';
import { FooterComponent } from './footer/footer.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LeavelistPageComponent } from './leavelist/leavelist-form/leavelist-form.component';
import {CoreModule} from "./core/core.module";
import {AuthModule} from "./auth/auth.module";
import {AuthComponent} from "./auth/auth.component";
import {routing} from "./app.routing";
import {ApplyLeaveComponent}  from "./leave/applyleave-form/apply-leave.component";

import { Admin_LP_Component } from './landing_page/Admin/admin_LP.component';
import { sidebar_component } from './sidebar/sidebar.component';
import {Employee_LP_Component } from './landing_page/Employee/employee_LP.component';
import { Role_component } from './Role/role.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ProfilePageComponent,
    ApplyLeaveComponent,
    HomePage2Component,
    LeavelistPageComponent,
    UiElementsPagePanelsComponent,
    HeaderComponent,
    Header2Component,
    FooterComponent,
    NavigationComponent,
    Admin_LP_Component,
    sidebar_component,
    Employee_LP_Component,
    Role_component,
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

