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
      userName: 'khanh',
      password: 'khanh',
      id: 'NV-0001',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '47534934',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gamil.com',
    },
    {
      userName: 'khanh',
      password: 'khanh',
      id: 'NV-0002',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '47534934',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gamil.com',
    },
    {
      userName: 'khanh',
      password: 'khanh',
      id: 'NV-0003',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '47534934',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gamil.com',
    },
    {
      userName: 'khanh',
      password: 'khanh',
      id: 'NV-0004',
      name: 'khanh',
      birthday: '02-09-2001',
      idCard: '47534934',
      phoneNumber: '0393074552',
      email: 'khanhquocdo@gamil.com',
    },
    {
      userName: 'khanh',
      password: 'khanh',
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
}
