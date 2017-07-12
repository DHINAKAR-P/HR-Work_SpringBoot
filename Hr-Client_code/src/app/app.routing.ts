import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {AuthComponent} from "./auth/auth.component";
//import {HomeComponent} from "./home/home.component";
import {AuthGuard} from "./auth/services/auth-guard.service";

import { HomePageComponent } from './home-page/home-page.component';
import {LoginFormComponent} from "./auth/login-form/login-form.component";
import {RegisterFormComponent} from "./auth/register-form/register-form.component";


const appRoutes: Routes = [
     { path: 'home1', component: HomePageComponent  },
     //{ path: 'home2', component: HomePage2Component },
     { path: '', redirectTo:'home1', pathMatch:'full'},

    { path: 'login', component: LoginFormComponent  },
    { path: 'register', component: RegisterFormComponent  },

    {
        path: 'auth',
        component: AuthComponent
    },
    
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);