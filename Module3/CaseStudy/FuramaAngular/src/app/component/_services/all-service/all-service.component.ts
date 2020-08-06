import {Component, OnInit} from '@angular/core';
import {Service, ServiceService} from '../../../service.service';

@Component({
  selector: 'app-all-service',
  templateUrl: './all-service.component.html',
  styleUrls: ['./all-service.component.css']
})
export class AllServiceComponent implements OnInit {
  services: Array<Service>;

  constructor(private serviceService: ServiceService) {
  }

  ngOnInit(): void {
    this.services = this.serviceService.findAll();
  }
}
