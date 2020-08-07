import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {User} from '../user';

@Component({
  selector: 'app-app-login',
  templateUrl: './app-login.component.html',
  styleUrls: ['./app-login.component.css']
})
export class AppLoginComponent implements OnInit {
  login: FormGroup;
  success: string;
  user: User;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.success = ' ';
    this.login = this.formBuilder.group({
      userName: [],
      passWord: []
    });
  }

  doLogin(): void {
    this.user = this.login.value;
    console.log(this.user);
  }
}
