import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-add-contract',
  templateUrl: './add-contract.component.html',
  styleUrls: ['./add-contract.component.css']
})
export class AddContractComponent implements OnInit {
  addContract: FormGroup;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.addContract = this.formBuilder.group({
      customer: ['', Validators.pattern('^[a-zA-Z]{1,32}$')],
      house: ['', Validators.pattern('^[a-zA-Z0-9]{6}$')],
      villa: ['', Validators.pattern('^[a-zA-Z0-9]{6}$')],
      room: ['', Validators.pattern('^[a-zA-Z0-9]{6}$')],
      contractDetail: ['', Validators.pattern('^[a-zA-Z0-9]{6}$')],
      deposits: [''],
      dateStartRent: [''],
      dateEndRent: ['']
    });
  }

  add(): void {
    alert('add ok');
  }
}
