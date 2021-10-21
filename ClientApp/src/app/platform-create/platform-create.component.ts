import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Platform } from '../platform/platform.component';
//import Platform from '../platform/platform.component';

@Component({
  selector: 'app-platform-create',
  templateUrl: './platform-create.component.html',
  styleUrls: ['./platform-create.component.scss']
})
export class PlatformCreateComponent implements OnInit {

  constructor(private http: HttpClient,
    @Inject('BASE_URL') private baseUrl: string,
    private activatedRoute: ActivatedRoute,
    private router: Router,) { }

  platform: Platform = <Platform>{};;

  platformForm = new FormGroup({
    name: new FormControl('')
  });



  onSubmit() {
    // TODO: Use EventEmitter with form value
    alert("awdawda");
    console.log("value is:");
    console.warn(this.platformForm.value);

    var url = this.baseUrl + "api/platforms";

    
this.platform.name = this.platformForm.value.name;

    this.http
      .post<Platform>(url, this.platform)
      .subscribe(result => {
        alert("City " + result.id + " has been created.");
        // go back to cities view
        this.router.navigate(['/admin/platform']);
      }, error => console.error(error));
  }

  ngOnInit(): void {
  }

}
