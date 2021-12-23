import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/AuthService';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  public isAuth: boolean = false;

  constructor(
    private authService: AuthService) {
      this.isAuth = this.authService.authenticated;
    }

  ngOnInit(): void {
  }

  logout() {
    this.authService.logout();
  }
}
