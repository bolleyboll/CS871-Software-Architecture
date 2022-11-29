import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../auth.service";
import { Login } from "../model/Login";
import { Teacher } from "../model/Teacher";

@Component({
  selector: "app-teacher-login",
  templateUrl: "./teacher-login.component.html",
  styleUrls: ["./teacher-login.component.css"],
})
export class TeacherLoginComponent implements OnInit {
  currentUser: Teacher;
  login: Login;
  errorFlag: boolean;

  constructor(public auth: AuthService, public router: Router) {
    this.login = new Login();
  }
  ngOnInit(): void {}

  loginSubmit(loginForm) {
    this.errorFlag = false;
    this.auth.teacherSignIn(this.login).subscribe((res: any) => {
      if (res.teacherId === null) {
        this.errorFlag = true;
        console.log("Error");
      } else {
        this.auth.currentuser = res;
        console.log(this.auth.currentuser);
        this.auth.isLoggedIn = true;
        this.router.navigateByUrl("/tdashboard");
      }
    });
    this.login = new Login();
    loginForm.form.markAsPristine();
  }
}
