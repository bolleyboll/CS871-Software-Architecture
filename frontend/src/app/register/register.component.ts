import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../auth.service";
import { User } from "../model/User";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"],
})
export class RegisterComponent implements OnInit {
  user: User;
  errorFlag: boolean;
  successFlag: boolean;
  error: string;
  errorStyle: string;

  constructor(public auth: AuthService, public router: Router) {
    this.user = new User();
    this.error = "";
    this.errorStyle = "form-text text-danger";
  }

  ngOnInit(): void {}

  patientSubmit(patRegForm) {
    this.errorFlag = false;
    this.successFlag = false;
    this.user.userId = Math.floor(Math.random() * (999 - 100 + 1) + 100);
    this.user.groups = "";
    this.auth.patRegister(this.user).subscribe((res: any) => {
      if (res === null) {
        this.errorFlag = true;
      } else {
        this.successFlag = true;
      }
    });
    this.user = new User();
    patRegForm.form.markAsPristine();
  }
  registerbtn() {
    this.successFlag = false;
  }
  validatePass() {
    let pass: string = (<HTMLInputElement>document.getElementById("pass"))
      .value;
    let cpass: string = (<HTMLInputElement>document.getElementById("cpass"))
      .value;
    // console.log(pass, cpass);
    if (pass === cpass) {
      this.error = "The passwords match.";
      this.errorStyle = "form-text text-success";
    } else {
      this.error = "The passwords do not match.";
      this.errorStyle = "form-text text-danger";
    }
  }
}
