import { Component, OnInit } from '@angular/core';

import {Message} from "primeng/components/common/api";
import { Role } from "../Role/role";
import { Roleservice } from "../Role/role.service";

@Component({
  selector: 'role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css'],
   providers: [Roleservice],
})
export class Role_component implements OnInit {

  model: Role;
  messages: Message[] = [];

  constructor(private Roleservice: Roleservice) { 

  }

  ngOnInit() {
  }

  addrole() {
    this.messages = [];
    console.log("inside addrole");
    this.Roleservice
        .addrole(this.model)
        .subscribe(isRoleadd => {
                if (isRoleadd) this.messages.push({severity: 'info', summary: ' Role Saved successfully!'});
                else this.messages.push({severity: 'error', summary: 'Some Error Occured in Server side'});
        });

  }
}