import {Component, Input, OnInit} from '@angular/core';
import {Customer, CustomerService} from '../../../customer.service';

@Component({
  selector: 'app-all-customer',
  templateUrl: './all-customer.component.html',
  styleUrls: ['./all-customer.component.css']
})

export class AllCustomerComponent implements OnInit {
  customers: Array<Customer>;
  firstName: string;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customers = this.customerService.findAll();
  }

  delete(id: string): void {
    if (confirm('are you sure about that?')) {
      this.customerService.deleteById(id);
    }
  }

  search(): any {
    if (this.firstName !== '') {
      this.customers = this.customers.filter(res => {
        return res.id.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.name.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.typeCus.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.phoneNumber.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.idCard.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.address.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.birthday.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.email.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase());
      });
    } else if (this.firstName === '') {
      this.customers = this.customerService.findAll();
    }
  }
}
