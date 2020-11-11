import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

export interface Contract {
  id: string;
  idCustomer: string;
  idService: string;
  dateStartRent: string;
  dateEndRent: string;
  deposit: number;
  price: number;
}

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  private API_URL = 'http://localhost:3000/contractList';
  // listContract: Array<Contract> = [
  //   {
  //     id: 'HD-0001',
  //     idCustomer: 'KH-0001',
  //     idService: 'DV-0001',
  //     dateStartRent: '01-01-2020',
  //     dateEndRent: '01-02-2020',
  //     deposit: 101,
  //     price: 1000,
  //   },
  //   {
  //     id: 'HD-0002',
  //     idCustomer: 'KH-0001',
  //     idService: 'DV-0001',
  //     dateStartRent: '01-01-2020',
  //     dateEndRent: '01-02-2020',
  //     deposit: 100,
  //     price: 1000,
  //   },
  //   {
  //     id: 'HD-0003',
  //     idCustomer: 'KH-0001',
  //     idService: 'DV-0001',
  //     dateStartRent: '01-01-2020',
  //     dateEndRent: '01-02-2020',
  //     deposit: 100,
  //     price: 1000,
  //   },
  //   {
  //     id: 'HD-0004',
  //     idCustomer: 'KH-0001',
  //     idService: 'DV-0001',
  //     dateStartRent: '01-01-2020',
  //     dateEndRent: '01-02-2020',
  //     deposit: 100,
  //     price: 1000,
  //   },
  //   {
  //     id: 'HD-0005',
  //     idCustomer: 'KH-0001',
  //     idService: 'DV-0001',
  //     dateStartRent: '01-01-2020',
  //     dateEndRent: '01-02-2020',
  //     deposit: 100,
  //     price: 1000,
  //   },
  //   {
  //     id: 'HD-0006',
  //     idCustomer: 'KH-0001',
  //     idService: 'DV-0001',
  //     dateStartRent: '01-01-2020',
  //     dateEndRent: '01-02-2020',
  //     deposit: 100,
  //     price: 1000,
  //   },
  //   {
  //     id: 'HD-0007',
  //     idCustomer: 'KH-0001',
  //     idService: 'DV-0001',
  //     dateStartRent: '01-01-2020',
  //     dateEndRent: '01-02-2020',
  //     deposit: 100,
  //     price: 1000,
  //   },
  // ];

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Contract[]> {
    return this.httpClient.get<Contract[]>(this.API_URL);
  }

  add(contract: Contract): Observable<Contract> {
    return this.httpClient.post<Contract>(this.API_URL, contract);
  }

  updateById(contract: Contract): Observable<any> {
    return this.httpClient.patch(this.API_URL + '/' + contract.id, contract);
  }

  deleteById(id: string): Observable<Contract> {
    return this.httpClient.delete<Contract>(this.API_URL + '/' + id);
  }

  findById(id: string): Observable<Contract> {
    return this.httpClient.get<Contract>(this.API_URL + '/' + id);
  }
}
