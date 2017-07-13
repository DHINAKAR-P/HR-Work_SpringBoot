import {Injectable} from "@angular/core";
import {Http} from "@angular/http";

import 'rxjs/Rx';
import {Observable} from 'rxjs/Observable';

import {UserLeave} from "../../core/leave/UserLeave";
import {API_URL} from "../../core/core.module";

@Injectable()
export class UserLeaveService {

    isLoggedIn: boolean = false;

    constructor(private http: Http) {
    }

    applyLeave(userLeave: UserLeave): Observable<boolean> {
        console.log("I AM iN LEAVE SERVICE")
        return this.http.post(API_URL + "/leave/applyleave", userLeave)
            .map(response => response.json() as UserLeave)
            .map(userLeave => !UserLeave.isNull(userLeave))
            .catch(UserLeaveService.handleError);
    }

    private static handleError(error: any) {
        let errorMessage = (error.message) ? error.message :
            error.status ? `${error.status} - ${error.statusText}` : `Server error`;
        console.log(errorMessage);
        return Observable.throw(errorMessage);
    }
}