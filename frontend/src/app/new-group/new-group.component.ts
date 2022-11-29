import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../auth.service";
import { Course } from "../model/Course";

@Component({
  selector: "app-new-group",
  templateUrl: "./new-group.component.html",
  styleUrls: ["./new-group.component.css"],
})
export class NewGroupComponent implements OnInit {
  group: Course;
  errorFlag: boolean;
  successFlag: boolean;
  error: string;
  errorStyle: string;

  constructor(public auth: AuthService, public router: Router) {
    this.group = new Course();
    this.error = "";
    this.errorStyle = "form-text text-danger";
  }

  ngOnInit(): void {}

  newGroup(newGrpForm) {
    this.errorFlag = false;
    this.successFlag = false;
    this.group.courseId = Math.floor(Math.random() * (999 - 100 + 1) + 100);
    this.group.courseCode = this.auth.currentuser.username;
    this.auth.groupRegister(this.group).subscribe((res: any) => {
      if (res === null) {
        this.errorFlag = true;
      } else {
        this.successFlag = true;
      }
    });
    this.group = new Course();
    newGrpForm.form.markAsPristine();
  }
}
