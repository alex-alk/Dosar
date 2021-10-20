import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';

@Component({
  selector: 'app-platform',
  templateUrl: './platform.component.html',
  styleUrls: ['./platform.component.scss']
})
export class PlatformComponent implements OnInit {
  public result: Platform[] = [];

  constructor(
    private http: HttpClient,
    @Inject('BASE_URL') private baseUrl: string) {

      
  }
  ngOnInit() {

    this.http.get<Platform[]>(this.baseUrl + 'platforms').subscribe(result => {

    
      this.result = result;
    }, error => console.error(error));

  }
}
interface Platform {
  id: number,
  chapters: Chapter[];
  name: string;
}
interface Chapter {
  id: number,
  name: string;
  content: string;
  urlName: string;
}
