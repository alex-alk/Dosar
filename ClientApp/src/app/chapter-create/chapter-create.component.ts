import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Platform } from '../platform-list/Platform';

@Component({
  selector: 'app-chapter-create',
  templateUrl: './chapter-create.component.html',
  styleUrls: ['./chapter-create.component.scss']
})
export class ChapterCreateComponent implements OnInit {

  public platforms: Platform[] = [];

  constructor(
    private http: HttpClient,
    @Inject('BASE_URL') private baseUrl: string,
    private router: Router) {
  }

  ngOnInit(): void {
    this.http.get<Platform[]>(this.baseUrl + '/api/platforms').subscribe(result => {

    
      this.platforms = result;
    }, error => console.error(error));
  }

}
