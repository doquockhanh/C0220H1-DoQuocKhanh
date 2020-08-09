import {Injectable} from '@angular/core';

export interface Customer {
  id: string;
  typeCus: string;
  name: string;
  birthday: string;
  idCard: string;
  phoneNumber: string;
  email: string;
  address: string;
}

@Injectable({
  providedIn: 'root'
})

export class CustomerService {
  listCustomer: Array<Customer> = [
    {
      id: 'KH-0001',
      typeCus: 'diamond',
      name: 'khanhquoc',
      birthday: '02-09-2001',
      idCard: '46445235',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gmail.com',
      address: 'hvt',
    },
    {
      id: 'KH-0001',
      typeCus: 'diamond',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '46445235',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gmail.com',
      address: 'hvt',
    },
    {
      id: 'KH-0002',
      typeCus: 'diamond',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '46445235',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gmail.com',
      address: 'hvt',
    },
    {
      id: 'KH-0003',
      typeCus: 'diamond',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '46445235',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gmail.com',
      address: 'hvt',
    },
    {
      id: 'KH-0004',
      typeCus: 'diamond',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '46445235',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gmail.com',
      address: 'hvt',
    },
    {
      id: 'KH-0005',
      typeCus: 'diamond',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '46445235',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gmail.com',
      address: 'hvt',
    },
    {
      id: 'KH-0006',
      typeCus: 'diamond',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '46445235',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gmail.com',
      address: 'hvt',
    },
    {
      id: 'KH-0007',
      typeCus: 'diamond',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '46445235',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gmail.com',
      address: 'hvt',
    },
    {
      id: 'KH-0008',
      typeCus: 'diamond',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '46445235',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gmail.com',
      address: 'hvt',
    }
  ];

  constructor() {
  }

  findAll(): Array<Customer> {
    return this.listCustomer;
  }

  add(customer: Customer): void {
    this.listCustomer.push(customer);
  }

  updateById(id: string, customer: Customer): void {
    for (let i = 0; i < this.listCustomer.length; i++) {
      if (this.listCustomer[i].id === id) {
        this.listCustomer[i] = customer;
        return;
      }
    }
  }

  deleteById(id: string): void {
    this.listCustomer.splice(this.listCustomer.indexOf(this.findById(id)), 1);
  }

  findById(id: string): Customer {
    return this.listCustomer.find(customer => customer.id === id);
  }
}
