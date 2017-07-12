import {NgModule} from "@angular/core";
import {HomeComponent} from "./home.component";
import {ButtonModule} from "primeng/components/button/button";
@NgModule({
    imports: [ButtonModule],
    declarations: [HomeComponent],
    exports: [HomeComponent]
})
export class HomeModule {}