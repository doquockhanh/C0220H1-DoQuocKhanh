import {Component, OnInit} from '@angular/core';
import {Service, ServiceService} from '../../../service.service';

@Component({
  selector: 'app-all-service',
  templateUrl: './all-service.component.html',
  styleUrls: ['./all-service.component.css']
})
export class AllServiceComponent implements OnInit {
  services: Array<Service>;
  inputName: string;

  constructor(private serviceService: ServiceService) {
  }

  ngOnInit(): void {
    this.services = this.serviceService.findAll();
  }

  delete(id: string): void {
    if (confirm('are you sure about that?')) {
      this.serviceService.deleteById(id);
    }
  }

  search(): any {
    if (this.inputName !== '') {
      this.services = this.services.filter(res => {
        return res.id.toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.name.toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.rentType.toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.rentPrice.toString().toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.imageSource.toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.poolArea.toString().toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.numberOfFloor.toString().toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.maxPeople.toString().toLocaleLowerCase().match(this.inputName.toLocaleLowerCase()) ||
          res.roomStandard.toLocaleLowerCase().match(this.inputName.toLocaleLowerCase());
      });
    } else if (this.inputName === '') {
      this.services = this.serviceService.findAll();
    }
  }
}
