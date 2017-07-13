import {Injectable} from "@angular/core";
import {Http} from "@angular/http";

import 'rxjs/Rx';
import {Observable} from 'rxjs/Observable';

import {User} from "../../core/user";
import {API_URL} from "../../core/core.module";

@Injectable()
export class AuthService {

    isLoggedIn: boolean = false;

    constructor(private http: Http) {
    }

    login(user: User): Observable<boolean> {
    console.log("loginuser----->",this)
        return this.http.post(API_URL + "/login/checkuserName", user)
            .map(response => response.json() as User)
            .map(user => {
                if (!User.isNull(user)) {
                    this.isLoggedIn = true;
                    return true
                } else {
                    this.isLoggedIn = false;
                    return false
                }
            })
            .catch(AuthService.handleError);
    }

    logOut(): Observable<boolean> {
        this.isLoggedIn = !this.isLoggedIn;
        return Observable.of(false);
    }

    register(user: User): Observable<boolean> {
    console.log("registeruser----->",JSON.stringify(user))
      
        return this.http.post(API_URL + "/user/createuser", user)
            .map(response => response.json() as User)
            .map(user => !User.isNull(user))
            .catch(AuthService.handleError);
    }

    private static handleError(error: any) {
        let errorMessage = (error.message) ? error.message :
            error.status ? `${error.status} - ${error.statusText}` : `Server error`;
        console.log(errorMessage);
        return Observable.throw(errorMessage);
    }
}