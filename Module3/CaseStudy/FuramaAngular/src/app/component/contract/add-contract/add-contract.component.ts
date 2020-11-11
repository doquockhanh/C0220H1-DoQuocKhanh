import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Contract, ContractService} from '../../../contract.service';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-add-contract',
  templateUrl: './add-contract.component.html',
  styleUrls: ['./add-contract.component.css']
})
export class AddContractComponent implements OnInit {
  contract: Contract;
  addContract: FormGroup;
  success: string;
  failure: string;
  pipe = new DatePipe('en-US');

  constructor(private formBuilder: FormBuilder,
              private contractService: ContractService,
              private router: Router) {
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

  changeStatus(success: string, failure: string): void {
    this.success = success;
    this.failure = failure;
  }

  add(): void {
    this.contract = this.addContract.value;
    this.contract.dateEndRent = this.pipe.transform(this.contract.dateEndRent, 'dd-MM-yyyy');
    this.contract.dateStartRent = this.pipe.transform(this.contract.dateStartRent, 'dd-MM-yyyy');
    this.contractService.add(this.contract).subscribe(
      () => {
        this.changeStatus('add successful!', '');
        this.addContract.reset();
      },

      error => this.changeStatus('', 'add failure, ID contract existed!')
    );
  }

  returnListPage(): void{
    this.router.navigateByUrl('home/allService');
  }
}
