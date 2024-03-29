import {Component, OnInit} from '@angular/core';
import {Service, ServiceService} from '../../../service.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-update-service',
  templateUrl: './update-service.component.html',
  styleUrls: ['./update-service.component.css']
})
export class UpdateServiceComponent implements OnInit {
  service: Service;
  addService: FormGroup;
  status: string;

  constructor(private formBuilder: FormBuilder,
              private serviceService: ServiceService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = String(paramMap.get('id'));
      this.serviceService.findById(id).subscribe(
        next => this.service = next,
        error => null,
        () => this.validate()
      );
    });
  }

  validate(): void {
    this.addService = this.formBuilder.group({
      id: [this.service.id, [Validators.pattern('^(DV-)[0-9]{4}$'), Validators.required]],
      name: [this.service.name, [Validators.pattern('^[a-zA-Z]{1,32}$'), Validators.required]],
      roomStandard: [this.service.roomStandard, Validators.required],
      maxPeople: [this.service.maxPeople, [Validators.min(1), Validators.max(20), Validators.required]],
      numberOfFloor: [this.service.numberOfFloor, [Validators.min(1), Validators.max(10), Validators.required]],
      poolArea: [this.service.poolArea, [Validators.min(12), Validators.max(169), Validators.required]],
      rentType: [this.service.rentType, Validators.required],
      rentPrice: [this.service.rentPrice, [Validators.min(0), Validators.required]],
      imageSource: [this.service.imageSource, Validators.required],
    });
  }

  changeStatus(): void {
    this.status = '';
  }

  update(): void {
    this.service = this.addService.value;
    this.serviceService.updateById(this.service).subscribe();
    this.status = 'update successful!';
    this.router.navigateByUrl('home/allService');
  }

}
