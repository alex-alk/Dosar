import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { User } from '../models/User';
import { Credential } from '../models/Credential';

@Injectable()
export class AuthService {
    private user: User = new User;

    constructor(private jwtHelper: JwtHelperService,
        private http: HttpClient, private router: Router, @Inject('BASE_URL') private baseUrl: string,) { }

    public get authenticated(): boolean {

        const token = this.jwtHelper.tokenGetter();
        if (token) {// Check if saved token has not expired
            return !this.jwtHelper.isTokenExpired(token);
        }
        return false;
    }

    public login(userCreds: Credential) {
        let url: string = `${this.baseUrl}/api/authenticate`;
        return this.http.post(url, userCreds,
            { responseType: 'text' }
        ).subscribe(tokenResult => {
            localStorage.setItem('token', tokenResult);
            this.user = new User();
            this.user.username = userCreds.username;
            this.router.navigate(['admin']).then(() => {
                window.location.reload();
              });;
        });
    }

    /* Logout in AuthService simply removes token */
    public logout() {
        localStorage.removeItem('token');
        this.router.navigate(['login']).then(() => {
            window.location.reload();
          });;
    }
    public get currentUser(): User {
        return this.user;
    }
}