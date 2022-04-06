import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AngularEditorConfig } from '@kolkov/angular-editor';
import { Chapter } from '../chapter-list/Chapter';
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

  chapterForm = new FormGroup({
    name: new FormControl(''),
    htmlContent: new FormControl(''),
    platform: new FormControl(0)
  });

  editorConfig: AngularEditorConfig = {
    editable: true,
    spellcheck: true,
    height: 'auto',
    minHeight: '300px',
    maxHeight: 'auto',
    width: 'auto',
    minWidth: '0',
    translate: 'yes',
    enableToolbar: true,
    showToolbar: true,
    placeholder: 'Enter text here...',
    defaultParagraphSeparator: '',
    defaultFontName: '',
    defaultFontSize: '',
    fonts: [
      { class: 'arial', name: 'Arial' },
      { class: 'consolas', name: 'Consolas' },
      { class: 'calibri', name: 'Calibri' },
      { class: 'comic-sans-ms', name: 'Comic Sans MS' }
    ],
    customClasses: [
      {
        name: 'quote',
        class: 'quote',
      },
      {
        name: 'redText',
        class: 'redText'
      },
      {
        name: 'titleText',
        class: 'titleText',
        tag: 'h1',
      },
    ],
    uploadUrl: 'v1/image',
    uploadWithCredentials: false,
    sanitize: true,
    toolbarPosition: 'top',
  };

  chapter: Chapter = <Chapter>{};

  onSubmit() {

    var url = this.baseUrl + "/api/chapters";

    this.chapter.name = this.chapterForm.value.name;
    this.chapter.content = this.chapterForm.value.htmlContent;
    this.chapter.platform = {id: this.chapterForm.value.platform, name: ''};

    this.http
      .post<Platform>(url, this.chapter)
      .subscribe(result => {
        this.router.navigate(['/admin/chapters']);
      }, error => console.error(error));


  }
  ngOnInit(): void {
    this.http.get<Platform[]>(this.baseUrl + '/api/platforms').subscribe(result => {
      this.platforms = result;

      this.chapterForm.patchValue({
        platform: result[0].id
      });
    }, error => console.error(error));
  }

}
