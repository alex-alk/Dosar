import { Component, OnInit, Inject } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Platform } from './platform';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  public platforms: Platform[] = [];

  constructor(
    private http: HttpClient,
    @Inject('BASE_URL') private baseUrl: string
  ){}

  ngOnInit() {
    this.http.get<Platform[]>(this.baseUrl + 'api/platforms')
      .subscribe(result => {
        this.platforms = result;
    }, error => console.error(error));
  }
}
