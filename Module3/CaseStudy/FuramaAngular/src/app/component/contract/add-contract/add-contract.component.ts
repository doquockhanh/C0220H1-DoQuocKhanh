import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Service} from '../../../service.service';
import {Contract, ContractService} from '../../../contract.service';

@Component({
  selector: 'app-add-contract',
  templateUrl: './add-contract.component.html',
  styleUrls: ['./add-contract.component.css']
})
export class AddContractComponent implements OnInit {
  contract: Contract;
  addContract: FormGroup;
  status: string;

  constructor(private formBuilder: FormBuilder,
              private contractService: ContractService) {
  }

  ngOnInit(): void {
    this.addContract = this.formBuilder.group({
      id: ['', [Validators.pattern('^(HD-)[0-9]{4}$'), Validators.required]],
      idCustomer: ['', [Validators.pattern('^(KH-)[0-9]{4}$'), Validators.required]],
      idService: ['', [Validators.pattern('^(DV-)[0-9]{4}$'), Validators.required]],
      dateStartRent: ['', Validators.required],
      dateEndRent: ['', Validators.required],
      deposit: [0, [Validators.min(0), Validators.required]],
      price: [0, [Validators.min(0), Validators.required]],
    });
  }

  changeStatus(): void {
    this.status = '';
  }

  add(): void {
    this.contract = this.addContract.value;
    this.contractService.add(this.contract);
    this.status = 'add successful!';
  }
}
