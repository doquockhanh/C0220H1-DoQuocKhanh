import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

interface User {
  userName: string;
  passWord: string;
}

@Component({
  selector: 'app-app-register',
  templateUrl: './app-register.component.html',
  styleUrls: ['./app-register.component.css']
})

export class AppRegisterComponent implements OnInit {
  users: Array<User> = [];

  register: FormGroup;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.register = this.formBuilder.group({
      userName: ['', Validators.required],
      passWord: ['', Validators.required]
    });
  }

  doRegister(): void {
    if (!this.register.hasError('required')) {
      if (!this.users.includes(this.register.value)) {
        this.users.push(this.register.value);
      }
      console.log(this.users);
    }
  }
}
