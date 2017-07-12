import {NgModule, Optional, SkipSelf} from "@angular/core";
import {UserService} from "./user.service";

@NgModule({
    providers: [UserService]
})
export class CoreModule {

    constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
        if(parentModule) {
            throw new Error(
                'CoreModule is already loaded. Import it in the AppModule only');
        }
    }
}

export const API_URL = 'http://localhost:8080/hrwork-rest';