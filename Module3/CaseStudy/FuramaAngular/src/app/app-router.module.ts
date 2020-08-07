import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {HomePgComponent} from './home-pg/home-pg.component';
import {AddServiceComponent} from './component/_services/add-service/add-service.component';
import {AddContractComponent} from './component/contract/add-contract/add-contract.component';
import {AddCustomerComponent} from './component/customer/add-customer/add-customer.component';
import {AddEmployeeComponent} from './component/employee/add-employee/add-employee.component';
import {AllServiceComponent} from './component/_services/all-service/all-service.component';
import {AllCustomerComponent} from './component/customer/all-customer/all-customer.component';
import {AllEmployeeComponent} from './component/employee/all-employee/all-employee.component';
import {UpdateServiceComponent} from './component/_services/update-service/update-service.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'}, // path
  {path: 'home', children: [
      {path: '', component: HomePgComponent},
      {path: 'addService', component: AddServiceComponent},
      {path: 'addContract', component: AddContractComponent},
      {path: 'addCustomer', component: AddCustomerComponent},
      {path: 'addEmployee', component: AddEmployeeComponent},
      {path: 'allService', children: [
          {path: '', component: AllServiceComponent},
          {path: 'editService/:id', component: UpdateServiceComponent}
        ]},
      {path: 'allCustomer', children: [
          {path: '', component: AllCustomerComponent},
          // them sua xoa
        ]},
      {path: 'allEmployee', children: [
          {path: '', component: AllEmployeeComponent},
          // them sua xoa
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
