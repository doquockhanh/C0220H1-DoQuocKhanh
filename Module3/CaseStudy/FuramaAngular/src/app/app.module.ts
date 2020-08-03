import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomePgComponent } from './home-pg/home-pg.component';
import { AllCustomerComponent } from './all-customer/all-customer.component';
import { AllEmployeeComponent } from './all-employee/all-employee.component';
import { AllServiceComponent } from './all-service/all-service.component';
import { AddServiceComponent } from './add-service/add-service.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { AddContractComponent } from './add-contract/add-contract.component';

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
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
