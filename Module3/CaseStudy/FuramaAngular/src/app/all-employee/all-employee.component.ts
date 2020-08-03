import {Component, OnInit} from '@angular/core';

interface Employee {
  id: number;
  name: string;
  birthday: string;
  idCard: string;
  phoneNumber: string;
  email: string;
}

@Component({
  selector: 'app-all-employee',
  templateUrl: './all-employee.component.html',
  styleUrls: ['./all-employee.component.css']
})
export class AllEmployeeComponent implements OnInit {
  employee: Employee;
  employees: Array<Employee>;

  makeListEmployee(): void {
    this.employee = {
      id: 1,
      name: 'do quoc khanh',
      birthday: '02-09-2001',
      idCard: '65783947',
      phoneNumber: '0393074552',
      email: 'khanhquocdo.qt@gmail.com'
    };

    this.employees = [];
    for (let i = 0; i < 11; i++) {
      this.employees.push(this.employee);
    }
  }

  constructor() {
    this.makeListEmployee();
  }

  ngOnInit(): void {
  }

}
