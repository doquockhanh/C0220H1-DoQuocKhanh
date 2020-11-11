import {Component, OnInit} from '@angular/core';
import {Employee, EmployeeService} from '../../../employee.service';

@Component({
  selector: 'app-all-employee',
  templateUrl: './all-employee.component.html',
  styleUrls: ['./all-employee.component.css']
})
export class AllEmployeeComponent implements OnInit {
  employees: Array<Employee>;
  firstName: string;
  currentPage: number;
  totalItem: number;

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.getEmployeeApi();
  }

  delete(id: string): void {
    if (confirm('are you sure to delete ' + id + '?')) {
      this.employeeService.deleteById(id).subscribe(
        () => null,
        error => null,
        () => this.getEmployeeApi()
      );
    }
  }

  search(): any {
    if (this.firstName !== '') {
      this.employees = this.employees.filter(res => {
        return res.id.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.name.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.phoneNumber.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.idCard.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.birthday.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
          || res.email.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase());
      });
    } else if (this.firstName === '') {
      this.getEmployeeApi();
    }
  }

  getEmployeeApi(): void {
    this.employeeService.getAll().subscribe(
      list => this.employees = list, error => {
        this.employees = [];
      },
      () => this.totalItem = this.employees.length
    );
  }
}
