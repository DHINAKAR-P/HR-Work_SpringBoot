import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'employee-landing-LP',
  templateUrl: './employee_LP.component.html',
  styleUrls: ['./employee_LP.component.css']
})
export class Employee_LP_Component implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  openmenu() {
    console.log("inside menu")
     document.getElementById("mySidenav").style.width = "250px";
  }

}