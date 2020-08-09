import {Injectable} from '@angular/core';

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
  listService: Array<Service> = [
    {
      id: 'DV-0001',
      name: 'khanhquoc',
      maxPeople: 10,
      roomStandard: 'vip',
      numberOfFloor: 2,
      poolArea: 100,
      rentType: 'month',
      rentPrice: 1000,
      imageSource: 'service1.png'
    },
    {
      id: 'DV-0002',
      name: 'khanh',
      maxPeople: 10,
      roomStandard: 'vip',
      numberOfFloor: 2,
      poolArea: 100,
      rentType: 'month',
      rentPrice: 1000,
      imageSource: 'service1.png'
    },
    {
      id: 'DV-0003',
      name: 'khanh',
      maxPeople: 10,
      roomStandard: 'vip',
      numberOfFloor: 2,
      poolArea: 100,
      rentType: 'month',
      rentPrice: 1000,
      imageSource: 'service1.png'
    },
    {
      id: 'DV-0004',
      name: 'khanh',
      maxPeople: 10,
      roomStandard: 'vip',
      numberOfFloor: 2,
      poolArea: 100,
      rentType: 'month',
      rentPrice: 1000,
      imageSource: 'service1.png'
    },
    {
      id: 'DV-0005',
      name: 'khanh',
      maxPeople: 10,
      roomStandard: 'vip',
      numberOfFloor: 2,
      poolArea: 100,
      rentType: 'month',
      rentPrice: 1000,
      imageSource: 'service1.png'
    },
  ];

  constructor() {
  }

  findAll(): Array<Service> {
    return this.listService;
  }

  findById(id: string): Service {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.listService.length; i++) {
      if (this.listService[i].id === id) {
        return this.listService[i];
      }
    }
    return null;
  }

  add(service: Service): void {
    this.listService.push(service);
  }

  updateById(id: string, service: Service): void {
    for (let i = 0; i < this.listService.length; i++) {
      if (this.listService[i].id === id) {
        this.listService[i] = service;
        return;
      }
    }
  }

  deleteById(id: string): void {
    for (let i = 0; i < this.listService.length; i++) {
      if (this.listService[i].id === id) {
        this.listService.splice(i, 1);
        return;
      }
    }
  }
}
