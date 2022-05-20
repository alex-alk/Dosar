import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Platform } from './Platform';

@Component({
  selector: 'app-platform',
  templateUrl: './platform.component.html',
  styleUrls: ['./platform.component.scss']
})
export class PlatformComponent implements OnInit {
  public result: Platform[] = [];

  constructor(
    private http: HttpClient,
    @Inject('BASE_URL') private baseUrl: string,
    private router: Router) {
  }


  deletePlatform(id: number) {
    if (confirm("Are you sure?")) {
      var url = this.baseUrl + "/api/platforms/" + id;
      this.http
        .delete(url)
        .subscribe(result => {
          this.ngOnInit();
        }, error => this.ngOnInit());
    }
  }

  ngOnInit() {

    this.http.get<Platform[]>(this.baseUrl + '/api/platforms').subscribe(result => {

    
      this.result = result;
    }, error => console.error(error));

  }
}
