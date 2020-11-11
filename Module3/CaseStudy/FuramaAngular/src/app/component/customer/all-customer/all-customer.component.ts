import {Component, OnInit} from '@angular/core';
import {Customer, CustomerService} from '../../../customer.service';

@Component({
  selector: 'app-all-customer',
  templateUrl: './all-customer.component.html',
  styleUrls: ['./all-customer.component.css']
})

export class AllCustomerComponent implements OnInit {
  customers: Array<Customer>;
  firstName: string;
  currentPage: number;
  totalItem: number;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.getCustomerApi();
  }

  delete(id: string): void {
    if (confirm('are you sure to delete ' + id + '?')) {
      this.customerService.deleteById(id).subscribe(
        () => null,
        error => null,
        () => this.getCustomerApi()
      );
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
      this.getCustomerApi();
    }
  }

  getCustomerApi(): void {
    this.customerService.findAll().subscribe(
      list => this.customers = list, error => {
        this.customers = [];
      },
      () => this.totalItem = this.customers.length
    );
  }
}
