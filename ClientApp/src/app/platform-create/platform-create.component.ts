import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Platform } from '../platform-list/Platform';

@Component({
  selector: 'app-platform-create',
  templateUrl: './platform-create.component.html',
  styleUrls: ['./platform-create.component.scss']
})
export class PlatformCreateComponent implements OnInit {

  constructor(private http: HttpClient,
    @Inject('BASE_URL') private baseUrl: string,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  platform: Platform = <Platform>{};

  platformForm = new FormGroup({
    name: new FormControl('')
  });

  errors = {
    name: ''
  }

  onSubmit() {

    var url = this.baseUrl + "/api/platforms";

    this.platform.name = this.platformForm.value.name;

    this.http
      .post<Platform>(url, this.platform)
      .subscribe(result => {
        this.router.navigate(['/admin/platforms']);
      }, errors => this.errors = errors.error);
  }

  ngOnInit(): void {
  }

}
