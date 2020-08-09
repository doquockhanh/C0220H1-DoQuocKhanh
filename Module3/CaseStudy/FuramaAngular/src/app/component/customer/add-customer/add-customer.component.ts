import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Customer, CustomerService} from '../../../customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  customer: Customer;
  addCustomer: FormGroup;
  status: string;

  constructor(private formBuilder: FormBuilder,
              private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.addCustomer = this.formBuilder.group({
      id: ['', [Validators.pattern('^(KH-)[0-9]{4}$'), Validators.required]],
      typeCus: ['', Validators.required],
      name: ['', [Validators.pattern('^[a-zA-Z]{1,32}$'), Validators.required]],
      birthday: ['', Validators.required],
      idCard: ['', [Validators.pattern('^[0-9]{8}$'), Validators.required]],
      phoneNumber: ['', [Validators.pattern('^[0-9]{10}$'), Validators.required]],
      email: ['', [Validators.pattern('^[a-zA-Z0-9]+(@)[a-zA-Z0-9]+().[a-zA-Z0-9]+$'), Validators.required]],
      address: ['', Validators.required],
    });
  }

  add(): void {
    this.customer = this.addCustomer.value;
    this.customerService.add(this.customer);
    this.status = 'add successful !';
  }

  changeStatus(): void {
     this.status = '';
  }

}
