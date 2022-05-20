import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Platform } from './Platform';

@Component({
  selector: 'app-platform-edit',
  templateUrl: './platform-edit.component.html',
})
export class PlatformEditComponent implements OnInit {
  constructor(
    private http: HttpClient,
    @Inject('BASE_URL') private baseUrl: string,
    private router: Router, private route: ActivatedRoute) {
  }

  platform: Platform = <Platform>{};

  platformForm = new FormGroup({
    name: new FormControl()
  });

  errors = {
    name: ''
  }


  onSubmit() {

    var url = this.baseUrl + "/api/platforms";
    this.platform.name = this.platformForm.controls['name'].value;

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    this.http
      .patch(url, this.platform, httpOptions)
      .subscribe(result => {
        this.router.navigate(['/admin/platforms']);
      }, errors => this.errors = errors.error);
  }

  ngOnInit() {
    const routeParams = this.route.snapshot.paramMap;
    const platformId = Number(routeParams.get('id'));

    this.http.get<Platform>(this.baseUrl + '/api/platforms/' + platformId).subscribe(result => {

      this.platform = result;

      this.platformForm.patchValue({
        name: result.name
      });

    }, error => this.router.navigate(['/admin/platforms']));

  }
}


