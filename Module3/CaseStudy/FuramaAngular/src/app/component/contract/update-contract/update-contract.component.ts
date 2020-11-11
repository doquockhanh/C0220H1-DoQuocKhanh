import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Contract, ContractService} from '../../../contract.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-update-contract',
  templateUrl: './update-contract.component.html',
  styleUrls: ['./update-contract.component.css']
})
export class UpdateContractComponent implements OnInit {
  contract: Contract;
  updateContract: FormGroup;
  status: string;

  constructor(private formBuilder: FormBuilder,
              private contractService: ContractService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = String(paramMap.get('id'));
      this.contractService.findById(id).subscribe(
        contract => this.contract = contract,
        error => this.contract = null,
        () => this.validate()
      );
    });
  }

  validate(): void{
    this.updateContract = this.formBuilder.group({
      id: [this.contract.id, [Validators.pattern('^(HD-)[0-9]{4}$'), Validators.required]],
      idCustomer: [this.contract.idCustomer, [Validators.pattern('^(KH-)[0-9]{4}$'), Validators.required]],
      idService: [this.contract.idService, [Validators.pattern('^(DV-)[0-9]{4}$'), Validators.required]],
      dateStartRent: [this.contract.dateStartRent, Validators.required],
      dateEndRent: [this.contract.dateEndRent, Validators.required],
      deposit: [this.contract.deposit, [Validators.min(0), Validators.required]],
      price: [this.contract.price, [Validators.min(0), Validators.required]],
    });
  }

  changeStatus(): void {
    this.status = '';
  }

  update(): void {
    this.contract = this.updateContract.value;
    this.contractService.updateById(this.contract).subscribe(
      () => null,
      error => null,
      () => this.router.navigateByUrl('home/allContract')
    );
    this.status = 'update successful!';
  }
}
