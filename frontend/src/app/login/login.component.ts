import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../auth.service";
import { Login } from "../model/Login";
import { User } from "../model/User";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  currentUser: User;
  login: Login;
  errorFlag: boolean;

  constructor(public auth: AuthService, public router: Router) {
    this.login = new Login();
  }

  ngOnInit(): void {}

  loginSubmit(loginForm) {
    this.errorFlag = false;
    this.auth.signIn(this.login).subscribe((res: any) => {
      if (res === null) {
        this.errorFlag = true;
      } else {
        this.auth.currentuser = res;
        this.auth.isLoggedIn = true;
        console.log(res);
        this.router.navigateByUrl("/dashboard");
      }
    });
    this.login = new Login();
    loginForm.form.markAsPristine();
  }
}
