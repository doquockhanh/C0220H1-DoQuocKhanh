import {Component, Input, OnInit} from '@angular/core';
import {Customer, CustomerService} from '../../../customer.service';

@Component({
  selector: 'app-all-customer',
  templateUrl: './all-customer.component.html',
  styleUrls: ['./all-customer.component.css']
})

export class AllCustomerComponent implements OnInit {
  customers: Array<Customer>;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customers = this.customerService.findAll();
  }
}
