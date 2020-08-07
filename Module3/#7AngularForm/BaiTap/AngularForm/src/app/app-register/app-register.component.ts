import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {User} from '../user';

@Component({
  selector: 'app-app-register',
  templateUrl: './app-register.component.html',
  styleUrls: ['./app-register.component.css']
})

export class AppRegisterComponent implements OnInit {
  users: number[][] = [{1, 1}];
  user: User;

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
    console.log(this.users.indexOf(2));
    // if (!this.register.hasError('required')) {
    //   this.user = this.register.value;
    //   if (this.users.indexOf([this.user.userName, this.user.passWord]) === -1) {
    //     this.users.push([this.user.userName, this.user.passWord]);
    //   }
    // }
    // console.log(this.users);
  }
}
