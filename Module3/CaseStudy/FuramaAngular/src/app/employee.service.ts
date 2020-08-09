import {Injectable} from '@angular/core';

export interface Employee {
  userName: string;
  password: string;
  id: string;
  name: string;
  birthday: string;
  idCard: string;
  phoneNumber: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  listEmployee: Array<Employee> = [
    {
      userName: 'khanhq',
      password: 'khanhq',
      id: 'NV-0001',
      name: 'khanhquoc',
      birthday: '02-09-2001',
      idCard: '47534934',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gamil.com',
    },
    {
      userName: 'khanhq',
      password: 'khanhq',
      id: 'NV-0002',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '47534934',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gamil.com',
    },
    {
      userName: 'khanhq',
      password: 'khanhq',
      id: 'NV-0003',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '47534934',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gamil.com',
    },
    {
      userName: 'khanhq',
      password: 'khanhq',
      id: 'NV-0004',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '47534934',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gamil.com',
    },
    {
      userName: 'khanhq',
      password: 'khanhq',
      id: 'NV-0005',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '47534934',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gamil.com',
    },
  ];

  constructor() {
  }

  getAll(): Array<Employee> {
    return this.listEmployee;
  }

  add(employee: Employee): void {
    this.listEmployee.push(employee);
  }


  findById(id: string): Employee {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.listEmployee.length; i++) {
      if (this.listEmployee[i].id === id) {
        return this.listEmployee[i];
      }
    }
    return null;
  }

  updateById(id: string,  employee: Employee): void {
    for (let i = 0; i < this.listEmployee.length; i++) {
      if (this.listEmployee[i].id === id) {
        this.listEmployee[i] = employee;
        return;
      }
    }
  }

  deleteById(id: string): void {
    for (let i = 0; i < this.listEmployee.length; i++) {
      if (this.listEmployee[i].id === id) {
        this.listEmployee.splice(i, 1);
        return;
      }
    }
  }
}
