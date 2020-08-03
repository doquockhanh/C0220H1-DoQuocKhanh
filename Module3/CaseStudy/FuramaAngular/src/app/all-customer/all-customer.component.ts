import {Component, OnInit} from '@angular/core';

interface Customer {
  id: number;
  firstName: string;
  lastName: string;
  typeCustomer: string;
  userName: string;
  passWord: string;
}

@Component({
  selector: 'app-all-customer',
  templateUrl: './all-customer.component.html',
  styleUrls: ['./all-customer.component.css']
})

export class AllCustomerComponent implements OnInit {
  customer: Customer;
  customers: Array<Customer>;

  makeListCus(): void {
    this.customer = {
      id: 1,
      firstName: 'khanh',
      lastName: 'do',
      typeCustomer: 'diamond',
      userName: 'khanhquoc',
      passWord: 'khanh2901'
    };

    this.customers = [];
    for (let i = 0; i < 11; i++) {
      this.customers.push(this.customer);
    }
    console.log(this.customers);
  }

  constructor() {
    this.makeListCus();
  }

  ngOnInit(): void {

  }

}
