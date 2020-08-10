import { Component, OnInit } from '@angular/core';
import {Contract, ContractService} from '../../../contract.service';

@Component({
  selector: 'app-all-contract',
  templateUrl: './all-contract.component.html',
  styleUrls: ['./all-contract.component.css']
})
export class AllContractComponent implements OnInit {
  contracts: Array<Contract>;
  inputName: string;

  constructor(private contractService: ContractService) { }

  ngOnInit(): void {
    this.contracts = this.contractService.listContract;
  }

  delete(id: string): void {
    if (confirm('are you sure about that?')) {
      this.contractService.deleteById(id);
    }
  }

  search(): any {
    if (this.inputName !== '') {
      this.contracts = this.contracts.filter(res => {
        return res.id.toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.idService.toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.idCustomer.toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.price.toString().toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.deposit.toString().toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.dateStartRent.toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.dateEndRent.toLocaleLowerCase().match(this.inputName.toLocaleLowerCase());
      });
    } else if (this.inputName === '') {
      this.contracts = this.contractService.findAll();
    }
  }
}
