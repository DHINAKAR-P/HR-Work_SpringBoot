import {Component, OnInit} from "@angular/core";

import {Message} from "primeng/components/common/api";

import {AuthService} from "../services/auth.service";
import {User} from "../../core/user";

@Component({
    moduleId: module.id,
    selector: 'register',
    templateUrl: './register-form.component.html'
})
export class RegisterFormComponent implements OnInit {

    model: User;
    messages: Message[] = [];
 static id;
  
   
    constructor(private authService: AuthService) {
      RegisterFormComponent.id = "";
  }

  get staticId() {
    return RegisterFormComponent.id;
  }

    ngOnInit(): void {
        this.model = new User();
    }

    onSubmit(): void {
        this.messages = [];
        console.log(this.model);
        this.authService
            .register(this.model)
            .subscribe(isRegistered => {
                if (isRegistered) this.messages.push({severity: 'info', summary: 'Registered successfully!'});
                else this.messages.push({severity: 'error', summary: 'Email already in use'});
            });
    }
}