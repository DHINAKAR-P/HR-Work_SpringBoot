import {Injectable} from "@angular/core";
import {User} from "./user";
import {Http} from "@angular/http";

import {Observable} from "rxjs";
import {API_URL} from "./core.module";

@Injectable()
export class UserService {

    constructor(private http : Http) {}

    getUsers(): Observable<User[]> {
        return this.http.get(API_URL + '/users')
            .map(response => response.json() as User[])
    }

    getUser(userId: string): Observable<User> {
        return this.http.get(API_URL + '/user/' + userId)
            .map(response => response.json())
    }

}