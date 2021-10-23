import { Component, OnInit } from '@angular/core';
import { Chapter } from './Chapter';

@Component({
  selector: 'app-chapter-list',
  templateUrl: './chapter-list.component.html',
  styleUrls: ['./chapter-list.component.scss']
})
export class ChapterListComponent implements OnInit {

  constructor() { }

  public result: Chapter[] = [];

  ngOnInit(): void {
  }

  deleteChapter(id: number) {
    // var url = this.baseUrl + "/api/platforms/" + id;
    // this.http
    //   .delete(url)
    //   .subscribe(result => {
    //     //this.router.navigate(['/admin/platforms']);
    //     this.ngOnInit();
    //   }, error => console.error(error));
  }

}
