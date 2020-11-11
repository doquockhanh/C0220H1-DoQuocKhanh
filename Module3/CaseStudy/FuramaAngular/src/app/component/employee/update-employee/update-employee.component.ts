import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Employee, EmployeeService} from '../../../employee.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  updateEmployee: FormGroup;
  employee: Employee;
  status: string;

  constructor(private formBuilder: FormBuilder,
              private employeeService: EmployeeService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = String(paramMap.get('id'));
      this.employeeService.findById(id).subscribe(
        employee => this.employee = employee,
        error => null,
        () => this.validate()
      );
    });
  }

  validate(): void {
    this.updateEmployee = this.formBuilder.group({
      userName: [this.employee.userName, [Validators.pattern('^[a-zA-Z0-9]{6,20}$'), Validators.required]],
      password: [this.employee.password, [Validators.pattern('^[a-zA-Z0-9]{6,20}$'), Validators.required]],
      id: [this.employee.id, [Validators.pattern('^(NV-)[0-9]{4}$'), Validators.required]],
      name: [this.employee.name, [Validators.pattern('^[a-zA-Z]{1,32}$'), Validators.required]],
      birthday: [this.employee.birthday, Validators.required],
      idCard: [this.employee.idCard, [Validators.pattern('^[0-9]{8}$'), Validators.required]],
      phoneNumber: [this.employee.phoneNumber, [Validators.pattern('^[0-9]{10}$'), Validators.required]],
      email: [this.employee.email, [Validators.pattern('^[a-zA-Z0-9]+(@)[a-zA-Z0-9]+().[a-zA-Z0-9]+$'), Validators.required]]
    });
  }

  update(): void {
    this.employee = this.updateEmployee.value;
    this.employeeService.updateById(this.employee).subscribe();
    this.status = 'update successful !';
    this.router.navigateByUrl('home/allEmployee');
  }

  changeStatus(): void {
    this.status = '';
  }

}
