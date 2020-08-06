import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomePgComponent} from './home-pg/home-pg.component';
import {AllCustomerComponent} from './component/customer/all-customer/all-customer.component';
import {AllEmployeeComponent} from './component/employee/all-employee/all-employee.component';
import {AllServiceComponent} from './component/_services/all-service/all-service.component';
import {AddServiceComponent} from './component/_services/add-service/add-service.component';
import {AddEmployeeComponent} from './component/employee/add-employee/add-employee.component';
import {AddCustomerComponent} from './component/customer/add-customer/add-customer.component';
import {AddContractComponent} from './component/contract/add-contract/add-contract.component';
import {ReactiveFormsModule} from '@angular/forms';
import {AppRouterModule} from './app-router.module';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    HomePgComponent,
    AllCustomerComponent,
    AllEmployeeComponent,
    AllServiceComponent,
    AddServiceComponent,
    AddEmployeeComponent,
    AddCustomerComponent,
    AddContractComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRouterModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
