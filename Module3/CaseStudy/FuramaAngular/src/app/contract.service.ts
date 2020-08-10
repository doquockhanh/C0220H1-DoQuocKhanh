import {Injectable} from '@angular/core';

export interface Contract {
  id: string;
  idCustomer: string;
  idService: string;
  dateStartRent: string;
  dateEndRent: string;
  deposit: number;
  price: number;
}

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  listContract: Array<Contract> = [
    {
      id: 'HD-0001',
      idCustomer: 'KH-0001',
      idService: 'DV-0001',
      dateStartRent: '01-01-2020',
      dateEndRent: '01-02-2020',
      deposit: 101,
      price: 1000,
    },
    {
      id: 'HD-0002',
      idCustomer: 'KH-0001',
      idService: 'DV-0001',
      dateStartRent: '01-01-2020',
      dateEndRent: '01-02-2020',
      deposit: 100,
      price: 1000,
    },
    {
      id: 'HD-0003',
      idCustomer: 'KH-0001',
      idService: 'DV-0001',
      dateStartRent: '01-01-2020',
      dateEndRent: '01-02-2020',
      deposit: 100,
      price: 1000,
    },
    {
      id: 'HD-0004',
      idCustomer: 'KH-0001',
      idService: 'DV-0001',
      dateStartRent: '01-01-2020',
      dateEndRent: '01-02-2020',
      deposit: 100,
      price: 1000,
    },
    {
      id: 'HD-0005',
      idCustomer: 'KH-0001',
      idService: 'DV-0001',
      dateStartRent: '01-01-2020',
      dateEndRent: '01-02-2020',
      deposit: 100,
      price: 1000,
    },
    {
      id: 'HD-0006',
      idCustomer: 'KH-0001',
      idService: 'DV-0001',
      dateStartRent: '01-01-2020',
      dateEndRent: '01-02-2020',
      deposit: 100,
      price: 1000,
    },
    {
      id: 'HD-0007',
      idCustomer: 'KH-0001',
      idService: 'DV-0001',
      dateStartRent: '01-01-2020',
      dateEndRent: '01-02-2020',
      deposit: 100,
      price: 1000,
    },
  ];

  constructor() {
  }

  findAll(): Array<Contract> {
    return this.listContract;
  }

  add(contract: Contract): void {
    this.listContract.push(contract);
  }

  updateById(id: string, contract: Contract): void {
    for (let i = 0; i < this.listContract.length; i++) {
      if (this.listContract[i].id === id) {
        this.listContract[i] = contract;
        return;
      }
    }
  }

  deleteById(id: string): void {
    this.listContract.splice(this.listContract.indexOf(this.findById(id)), 1);
  }

  findById(id: string): Contract {
    return this.listContract.find(contract => contract.id === id);
  }
}
