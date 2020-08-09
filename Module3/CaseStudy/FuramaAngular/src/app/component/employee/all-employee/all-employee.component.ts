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

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employees = this.employeeService.getAll();
  }

  delete(id: string): void {
    if (confirm('are you sure about that?')) {
      this.employeeService.deleteById(id);
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
      this.employees = this.employeeService.getAll();
    }
  }
}
