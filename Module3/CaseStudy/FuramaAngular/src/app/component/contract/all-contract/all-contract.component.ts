import {Component, OnInit} from '@angular/core';
import {Contract, ContractService} from '../../../contract.service';

@Component({
  selector: 'app-all-contract',
  templateUrl: './all-contract.component.html',
  styleUrls: ['./all-contract.component.css']
})
export class AllContractComponent implements OnInit {
  contracts: Array<Contract>;
  inputName: string;
  currentPage: number;
  totalItem: number;

  constructor(private contractService: ContractService) {
  }

  ngOnInit(): void {
    this.getContractAPI();
  }

  delete(id: string): void {
    if (confirm('are you sure to delete ' + id + '?')) {
      this.contractService.deleteById(id).subscribe(
        () => null,
        error => null,
        () => this.getContractAPI()
      );
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
      this.getContractAPI();
    }
  }

  getContractAPI(): void {
    this.contractService.findAll().subscribe(
      list => this.contracts = list, error => {
        this.contracts = [];
      },
      () => this.totalItem = this.contracts.length
    );
  }
}
