import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomePgComponent} from './component/home-pg/home-pg.component';
import {AllCustomerComponent} from './component/customer/all-customer/all-customer.component';
import {AllEmployeeComponent} from './component/employee/all-employee/all-employee.component';
import {AllServiceComponent} from './component/_services/all-service/all-service.component';
import {AddServiceComponent} from './component/_services/add-service/add-service.component';
import {AddEmployeeComponent} from './component/employee/add-employee/add-employee.component';
import {AddCustomerComponent} from './component/customer/add-customer/add-customer.component';
import {AddContractComponent} from './component/contract/add-contract/add-contract.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRouterModule} from './app-router.module';
import {RouterModule} from '@angular/router';
import {UpdateServiceComponent} from './component/_services/update-service/update-service.component';
import {UpdateCustomerComponent} from './component/customer/update-customer/update-customer.component';
import {UpdateEmployeeComponent} from './component/employee/update-employee/update-employee.component';
import {AllContractComponent} from './component/contract/all-contract/all-contract.component';
import {UpdateContractComponent} from './component/contract/update-contract/update-contract.component';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {MaterialModule} from './material.module';

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
    AddContractComponent,
    UpdateServiceComponent,
    UpdateCustomerComponent,
    UpdateEmployeeComponent,
    AllContractComponent,
    UpdateContractComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRouterModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    MaterialModule
  ],
  providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
