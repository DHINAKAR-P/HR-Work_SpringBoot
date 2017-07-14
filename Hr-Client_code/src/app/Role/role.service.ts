import { Injectable } from "@angular/core";
import { Http } from "@angular/http";

import 'rxjs/Rx';
import { Observable } from 'rxjs/Observable';

import { Role } from "../Role/role";
import { API_URL } from "../core/core.module";


@Injectable()
export class Roleservice {

    isRoleadd: boolean = false;

    constructor(private http: Http) {
    }

    addrole(role: Role): Observable<boolean> {
        console.log("Role----->", JSON.stringify(role))
        return this.http.post(API_URL + "/user/createuser", role)
            .map(response => response.json() as Role)
            .map(role => !Role.isNull(role))
            .catch(Roleservice.handleError);
    }

    private static handleError(error: any) {
        let errorMessage = (error.message) ? error.message :
            error.status ? `${error.status} - ${error.statusText}` : `Server error`;
        console.log(errorMessage);
        return Observable.throw(errorMessage);
    }
}