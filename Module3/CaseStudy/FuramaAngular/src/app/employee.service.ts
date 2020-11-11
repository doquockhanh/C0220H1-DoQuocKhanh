import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

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
  private API_URL = 'http://localhost:3000/employeeList';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.API_URL);
  }

  add(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>(this.API_URL, employee);
  }


  findById(id: string): Observable<Employee> {
     return this.httpClient.get<Employee>(this.API_URL + '/' + id);
  }

  updateById(employee: Employee): Observable<Employee> {
     return this.httpClient.patch<Employee>(this.API_URL + '/' + employee.id, employee);
  }

  deleteById(id: string): Observable<Employee> {
    return this.httpClient.delete<Employee>(this.API_URL + '/' + id);
  }
}
