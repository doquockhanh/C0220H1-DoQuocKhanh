import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

export interface Customer {
  id: string;
  typeCus: string;
  name: string;
  birthday: string;
  idCard: string;
  phoneNumber: string;
  email: string;
  address: string;
}

@Injectable({
  providedIn: 'root'
})

export class CustomerService {
  private API_URL = 'http://localhost:3000/customerList';

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL);
  }

  add(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(this.API_URL, customer);
  }

  updateById(customer: Customer): Observable<Customer> {
     return this.httpClient.patch<Customer>(this.API_URL + '/' + customer.id, customer);
  }

  deleteById(id: string): Observable<Customer> {
    return this.httpClient.delete<Customer>(this.API_URL + '/' + id);
  }

  findById(id: string): Observable<Customer> {
    return this.httpClient.get<Customer>(this.API_URL + '/' + id);
  }
}
