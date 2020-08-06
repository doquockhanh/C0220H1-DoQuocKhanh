import {Component, OnInit} from '@angular/core';
import {Employee, EmployeeService} from '../../../employee.service';

@Component({
  selector: 'app-all-employee',
  templateUrl: './all-employee.component.html',
  styleUrls: ['./all-employee.component.css']
})
export class AllEmployeeComponent implements OnInit {
  employees: Array<Employee>;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employees = this.employeeService.getAll();
  }

}
