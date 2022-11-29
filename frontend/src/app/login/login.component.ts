import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../auth.service";
import { Login } from "../model/Login";
import { Student } from "../model/Student";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  currentUser: Student;
  login: Login;
  errorFlag: boolean;

  constructor(public auth: AuthService, public router: Router) {
    this.login = new Login();
  }

  ngOnInit(): void {}

  loginSubmit(loginForm) {
    this.errorFlag = false;
    this.auth.studentSignIn(this.login).subscribe((res: any) => {
      if (res.studentId === null) {
        this.errorFlag = true;
        console.log("Error")
      } else {
        this.auth.currentuser = res;
        console.log(this.auth.currentuser)
        this.auth.isLoggedIn = true;
        this.router.navigateByUrl("/dashboard");
      }
    });
    this.login = new Login();
    loginForm.form.markAsPristine();
  }
}