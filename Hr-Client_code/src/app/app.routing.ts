import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {AuthComponent} from "./auth/auth.component";
//import {HomeComponent} from "./home/home.component";
import {AuthGuard} from "./auth/services/auth-guard.service";

import { HomePageComponent } from './home-page/home-page.component';
import {LoginFormComponent} from "./auth/login-form/login-form.component";
import {RegisterFormComponent} from "./auth/register-form/register-form.component";
import {ApplyLeaveComponent} from "./leave/applyleave-form/apply-leave.component";

import {Admin_LP_Component} from "./landing_page/Admin/admin_LP.component";

import { sidebar_component } from "./sidebar/sidebar.component";

import {Employee_LP_Component } from './landing_page/Employee/employee_LP.component';
import {Role_component} from './Role/role.component';


const appRoutes: Routes = [
     { path: 'home1', component: HomePageComponent  },
     { path: '', redirectTo:'home1', pathMatch:'full'},
     { path: 'login', component: LoginFormComponent},
     { path: 'register', component: RegisterFormComponent},
     { path: 'applyLeave' ,component:ApplyLeaveComponent},
     { path: 'LandingPage' ,  component: Admin_LP_Component },
     { path: 'sidebar' , component: sidebar_component },
     { path:'Employee_LandingPage' , component: Employee_LP_Component},
     { path: 'AddRole' , component: Role_component},

    {
        path: 'auth',
        component: AuthComponent
    },
    
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);