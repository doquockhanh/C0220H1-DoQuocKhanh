import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Service {
  id: string;
  name: string;
  maxPeople: number;
  roomStandard: string;
  numberOfFloor: number;
  poolArea: number;
  rentType: string;
  rentPrice: number;
  imageSource: string;
}

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private API_URL = 'http://localhost:3000/serviceList';

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Service[]> {
    return this.httpClient.get<Service[]>(this.API_URL);
  }

  findById(id: string): Observable<Service> {
    return this.httpClient.get<Service>(`${this.API_URL}/${id}`);
  }

  add(service: Service): Observable<Service> {
    //  method post error when id existed
    return this.httpClient.post<Service>(this.API_URL, service);
  }

  updateById(service: Service): Observable<void> {
    return this.httpClient.patch<void>(this.API_URL + '/' + service.id, service);
  }

  deleteById(id: string): Observable<Service>{
    return this.httpClient.delete<Service>(this.API_URL + '/' + id);
  }
}
