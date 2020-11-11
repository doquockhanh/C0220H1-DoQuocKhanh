import {Component, OnInit} from '@angular/core';
import {Customer, CustomerService} from '../../../customer.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  customer: Customer;
  updateCustomer: FormGroup;
  status: string;

  constructor(private formBuilder: FormBuilder,
              private customerService: CustomerService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = String(paramMap.get('id'));
      this.customerService.findById(id).subscribe(
        customer => this.customer = customer,
        error => null,
        () => this.validate()
      );
    });
  }

  validate(): void {
    this.updateCustomer = this.formBuilder.group({
      id: [this.customer.id, [Validators.pattern('^(KH-)[0-9]{4}$'), Validators.required]],
      typeCus: [this.customer.typeCus, Validators.required],
      name: [this.customer.name, [Validators.pattern('^[a-zA-Z]{1,32}$'), Validators.required]],
      birthday: [this.customer.birthday, Validators.required],
      idCard: [this.customer.idCard, [Validators.pattern('^[0-9]{8}$'), Validators.required]],
      phoneNumber: [this.customer.phoneNumber, [Validators.pattern('^[0-9]{10}$'), Validators.required]],
      email: [this.customer.email, [Validators.pattern('^[a-zA-Z0-9]+(@)[a-zA-Z0-9]+().[a-zA-Z0-9]+$'), Validators.required]],
      address: [this.customer.address, Validators.required],
    });
  }

  update(): void {
    this.customer = this.updateCustomer.value;
    this.customerService.updateById(this.customer).subscribe();
    this.status = 'update successful !';
    this.router.navigateByUrl('home/allCustomer');
  }

  changeStatus(): void {
    this.status = '';
  }
}
