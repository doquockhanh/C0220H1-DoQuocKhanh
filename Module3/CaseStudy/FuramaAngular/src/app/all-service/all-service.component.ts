import {Component, OnInit} from '@angular/core';

interface Service {
  id: number;
  name: string;
  maxPeople: number;
  roomStandard: string;
  numberOfFloor: number;
  poolArea: number;
  rentType: string;
  rentPrice: number;
  imageSource: string;
}

@Component({
  selector: 'app-all-service',
  templateUrl: './all-service.component.html',
  styleUrls: ['./all-service.component.css']
})
export class AllServiceComponent implements OnInit {
  service: Service;
  services: Array<Service> = [];

  createListService(): void {
    this.service = {
      id: 1,
      name: 'paradize villa',
      imageSource: 'home/image',
      maxPeople: 10,
      numberOfFloor: 2,
      poolArea: 50,
      rentPrice: 1000,
      rentType: 'month',
      roomStandard: 'vip',
    };

    for (let i = 0; i < 11; i++) {
      this.services.push(this.service);
    }
  }

  constructor() {
    this.createListService();
  }

  ngOnInit(): void {
  }

}
