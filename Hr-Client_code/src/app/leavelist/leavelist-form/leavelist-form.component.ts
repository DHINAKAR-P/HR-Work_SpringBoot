import { Component, OnInit } from '@angular/core';
import {LeavelistService} from "./leavelist.service";
import {Response} from '@angular/http';


@Component({
  selector: 'leave',
  templateUrl: './leavelist-form.component.html',
  providers:[LeavelistService]
})
export class LeavelistPageComponent implements OnInit {
  Leavelists: [{
    id: number,
     username: string,
    LeaveFromDate: string,
    LeaveToDate: string,
     
  }];
  constructor(private leavelistService: LeavelistService){
    this.Leavelists = [{
      id: 0,
      username: '',
      LeaveFromDate: '',
      LeaveToDate: '',
     
    }];

  }

  ngOnInit(){
    this.leavelistService.getLeavelist()
     .subscribe(
       (data: any) =>{
         console.log(data.json());
         this.Leavelists = data
       })
  }

  }

