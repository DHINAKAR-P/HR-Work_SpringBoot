import {Component, OnInit} from "@angular/core";
//import {MdDatepickerModule} from '@angular/material'; 

import {Message} from "primeng/components/common/api";

import {UserLeaveService} from "../leaveservice/leave.service";
import {UserLeave} from "../../core/leave/UserLeave";


@Component({
    moduleId: module.id,
    selector: 'applyLeave',
    templateUrl: './apply-leave.component.html',
     providers: [UserLeaveService],
})
export class ApplyLeaveComponent implements OnInit {

    model: UserLeave;
    messages: Message[] = [];

    constructor(private userLeaveService: UserLeaveService) {
    }

    ngOnInit(): void {
        this.model = new UserLeave();
    }

    onSubmit(): void {
        this.messages = [];
        console.log(this.model);
        this.userLeaveService
            .applyLeave(this.model)
            .subscribe(isLeaveApplied => {
                if (isLeaveApplied) this.messages.push({severity: 'info', summary: ' Leave Applied successfully!'});
                else this.messages.push({severity: 'error', summary: 'Some Error Occured in Server side'});
            });
    }


}