import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Service, ServiceService} from '../../../service.service';

@Component({
  selector: 'app-add-service',
  templateUrl: './add-service.component.html',
  styleUrls: ['./add-service.component.css']
})

export class AddServiceComponent implements OnInit {
  service: Service;
  addService: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private serviceService: ServiceService) {
  }

  ngOnInit(): void {
    this.addService = this.formBuilder.group({
      id: ['', [Validators.pattern('^(DV-)[0-9]{4}$'), Validators.required]],
      name: ['', [Validators.pattern('^[a-zA-Z]{1,32}$'), Validators.required]],
      roomStandard: ['', Validators.required],
      maxPeople: [1, [Validators.min(1), Validators.max(20), Validators.required]],
      numberOfFloor: [1, [Validators.min(1), Validators.max(10), Validators.required]],
      poolArea: [12, [Validators.min(12), Validators.max(169), Validators.required]],
      rentType: ['', Validators.required],
      rentPrice: [0, [Validators.min(0), Validators.required]],
      imageSource: ['', Validators.required],
    });
  }

  add(): void {
    this.service = this.addService.value;
    this.serviceService.add(this.service);
  }
}
