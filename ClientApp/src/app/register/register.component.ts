import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private http: HttpClient,
    @Inject('BASE_URL') private baseUrl: string,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  registerForm = new FormGroup({ 
    username: new FormControl(),
    password: new FormControl()
  });

  credentials = {
    username: '',
    password: ''
  };

  ngOnInit(): void {
  }

  onSubmit() {

    var url = this.baseUrl + "/api/register";

    this.credentials.username = this.registerForm.value.username;
    this.credentials.password = this.registerForm.value.password;

    this.http
      .post(url, this.credentials)
      .subscribe(result => {
        this.router.navigate(['/login']);
      }, error => console.error(error));
  }

}
