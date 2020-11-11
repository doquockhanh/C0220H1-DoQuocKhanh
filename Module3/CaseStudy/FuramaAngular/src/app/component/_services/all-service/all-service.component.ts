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
  currentPage: number;
  totalItem: number;

  constructor(private serviceService: ServiceService) {
  }

  ngOnInit(): void {
    this.allService();
  }

  delete(id: string): void {
    if (confirm('are you sure to delete ' + id + '?')) {
      this.serviceService.deleteById(id).subscribe(
        next => console.log('processing'),
        error => console.log(),
        () => this.allService()
      );
    }
  }

  allService(): void {
    this.serviceService.findAll().subscribe(
      next => {
        this.services = next;
      }, error => {
        this.services = [];
      },
      () => this.totalItem = this.services.length
    );
  }

  search(): any {
    console.log(this.inputName);
    if (this.inputName !== '') {
      this.services = this.services.filter(res => {
        console.log(res.id);
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
      this.allService();
    }
  }
}
