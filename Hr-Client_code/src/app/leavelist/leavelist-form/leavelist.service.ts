import {LeavelistPageComponent} from  './leavelist-form.component'
import {Injectable} from '@angular/core';
import {Response, Http} from '@angular/http';
import 'rxjs/Rx';




@Injectable()
export class LeavelistService{
  constructor(private http:Http){}

  getLeavelist(){
         //using get request
         return this.http.get('http://localhost:8080/leave/listofLeave')
         .map((response:Response) => response.json());
  }
}