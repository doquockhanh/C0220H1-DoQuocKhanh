import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {HomePgComponent} from './component/home-pg/home-pg.component';
import {AddServiceComponent} from './component/_services/add-service/add-service.component';
import {AddContractComponent} from './component/contract/add-contract/add-contract.component';
import {AddCustomerComponent} from './component/customer/add-customer/add-customer.component';
import {AddEmployeeComponent} from './component/employee/add-employee/add-employee.component';
import {AllServiceComponent} from './component/_services/all-service/all-service.component';
import {AllCustomerComponent} from './component/customer/all-customer/all-customer.component';
import {AllEmployeeComponent} from './component/employee/all-employee/all-employee.component';
import {UpdateServiceComponent} from './component/_services/update-service/update-service.component';
import {UpdateCustomerComponent} from './component/customer/update-customer/update-customer.component';
import {UpdateEmployeeComponent} from './component/employee/update-employee/update-employee.component';
import {AllContractComponent} from './component/contract/all-contract/all-contract.component';
import {UpdateContractComponent} from './component/contract/update-contract/update-contract.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', children: [
      {path: '', component: HomePgComponent},
      {path: 'allService', children: [
          {path: '', component: AllServiceComponent},
          {path: 'editService/:id', component: UpdateServiceComponent},
          {path: 'addService', component: AddServiceComponent},
          {path: 'addService', component: AddServiceComponent},
        ]},
      {path: 'allCustomer', children: [
          {path: '', component: AllCustomerComponent},
          {path: 'editCustomer/:id', component: UpdateCustomerComponent},
          {path: 'addCustomer', component: AddCustomerComponent},
          {path: 'addCustomer', component: AddCustomerComponent},
        ]},
      {path: 'allEmployee', children: [
          {path: '', component: AllEmployeeComponent},
          {path: 'editEmployee/:id', component: UpdateEmployeeComponent},
          {path: 'addEmployee', component: AddEmployeeComponent},
          {path: 'addEmployee', component: AddEmployeeComponent},
        ]},
      {path: 'allContract', children: [
          {path: '', component: AllContractComponent},
          {path: 'editContract/:id', component: UpdateContractComponent},
          {path: 'addContract', component: AddContractComponent},
          {path: 'addContract', component: AddContractComponent},
        ]}
    ]}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRouterModule {
}
