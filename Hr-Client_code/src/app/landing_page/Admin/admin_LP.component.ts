import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'admin-landing-LP',
  templateUrl: './admin_LP.component.html',
  styleUrls: ['./admin_LP.component.css']
})
export class Admin_LP_Component implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  openmenu() {
    console.log("inside menu")
     document.getElementById("mySidenav").style.width = "250px";
  }

}