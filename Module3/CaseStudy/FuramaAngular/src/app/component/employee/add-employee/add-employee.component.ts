import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Employee, EmployeeService} from '../../../employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  addEmployee: FormGroup;
  employee: Employee;
  status: string;

  constructor(private formBuilder: FormBuilder,
              private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.addEmployee = this.formBuilder.group({
      userName: ['', [Validators.pattern('^[a-zA-Z0-9]{6,20}$'), Validators.required]],
      password: ['', [Validators.pattern('^[a-zA-Z0-9]{6,20}$'), Validators.required]],
      id: ['', [Validators.pattern('^(NV-)[0-9]{4}$'), Validators.required]],
      name: ['', [Validators.pattern('^[a-zA-Z]{1,32}$'), Validators.required]],
      birthday: ['', Validators.required],
      idCard: ['', [Validators.pattern('^[0-9]{8}$'), Validators.required]],
      phoneNumber: ['', [Validators.pattern('^[0-9]{10}$'), Validators.required]],
      email: ['', [Validators.pattern('^[a-zA-Z0-9]+(@)[a-zA-Z0-9]+().[a-zA-Z0-9]+$'), Validators.required]]
    });
  }

  add(): void {
    this.employee = this.addEmployee.value;
    this.employeeService.add(this.employee);
    this.status = 'add successful !';
  }

  changeStatus(): void {
    this.status = '';
  }
}
