import {Component} from "@angular/core";
import {AuthService} from "../auth/services/auth.service";
import {Router} from "@angular/router";

@Component({
    moduleId: module.id,
    selector: 'home',
    templateUrl: './home.component.html'
})
export class HomeComponent {

    constructor(private router: Router,
                private authService: AuthService) {}

    logOut(): void {
        this.authService.logOut().subscribe(isLoggedIn => {
            if( isLoggedIn === false) {
                this.router.navigate(['/auth']);
            }
        })
    }
}