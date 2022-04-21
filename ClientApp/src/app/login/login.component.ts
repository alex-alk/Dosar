import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../auth/AuthService';
import { Credential } from '../models/Credential';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private http: HttpClient,
    @Inject('BASE_URL') private baseUrl: string,
    private activatedRoute: ActivatedRoute,
    private authService: AuthService,
    private router: Router) { }

  loginForm = new FormGroup({
    username: new FormControl(),
    password: new FormControl()
  });

  credentials = {
    userName: '',
    password: ''
  };

  ngOnInit(): void {
  }

  onSubmit() {

    this.authService.login(
      new Credential(
        this.loginForm.value.username,
        this.loginForm.value.password
      )
    );
  }
}
