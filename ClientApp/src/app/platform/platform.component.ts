import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-platform',
  templateUrl: './platform.component.html',
  styleUrls: ['./platform.component.scss']
})
export class PlatformComponent implements OnInit {
  public show: string = "show"

  constructor() { }

  ngOnInit(): void {
  }

}
