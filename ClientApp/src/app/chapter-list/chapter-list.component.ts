import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Platform } from '../platform-list/Platform';

@Component({
  selector: 'app-chapter-list',
  templateUrl: './chapter-list.component.html',
  styleUrls: ['./chapter-list.component.scss']
})
export class ChapterListComponent implements OnInit {

  constructor(private http: HttpClient,
    @Inject('BASE_URL') private baseUrl: string,
    private router: Router) { }

  public result: Platform[] = [];

  ngOnInit(): void {

    this.http.get<Platform[]>(this.baseUrl + '/api/platforms').subscribe(result => {

    
      this.result = result;
    }, error => console.error(error));
  }

  deleteChapter(id: number) {
    var url = this.baseUrl + "/api/chapters/" + id;
    this.http
      .delete(url)
      .subscribe(result => {
        this.router.navigate(['/admin/chapters']);
        this.ngOnInit();
      }, error => console.error(error));
  }

}
