import { Component } from '@angular/core';
import { AuthService } from './auth/AuthService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  title = 'Admin | Dosar';
  public isAuth: boolean = false;

  constructor(
    private authService: AuthService) {
      this.isAuth = this.authService.authenticated;
    }
}
