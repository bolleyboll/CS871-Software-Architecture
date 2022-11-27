import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { User } from '../model/User';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  constructor(public auth: AuthService) {}
  logout() {
    this.auth.currentuser = null;
    this.auth.isLoggedIn = false;
  }
}
