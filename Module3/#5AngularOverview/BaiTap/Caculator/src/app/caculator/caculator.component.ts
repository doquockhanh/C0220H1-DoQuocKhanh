import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-caculator',
  templateUrl: './caculator.component.html',
  styleUrls: ['./caculator.component.css']
})
export class CaculatorComponent implements OnInit {

  result;
  num1;
  num2;
  operation = '+';

  constructor() {
  }

  changeNum1(num1): void {
    // tslint:disable-next-line:radix
    this.num1 = parseInt(num1);
  }

  changeNum2(num2): void {
    // tslint:disable-next-line:radix
    this.num2 = parseInt(num2);
  }


  changeOperation(a): void {
    this.operation = a;
    console.log(a);
  }

  calculate2num(): void {
    console.log(this.num1 + this.operation + this.num2);

    this.result = eval(this.num1 + this.operation + this.num2);
  }

  ngOnInit(): void {
  }

}
