import { Component, OnInit } from "@angular/core";
import { AuthService } from "../auth.service";

@Component({
  selector: "app-teacher-dashboard",
  templateUrl: "./teacher-dashboard.component.html",
  styleUrls: ["./teacher-dashboard.component.css"],
})
export class TeacherDashboardComponent implements OnInit {
  constructor(public auth: AuthService) {
    this.auth.exams = [];
  }

  ngOnInit(): void {
    if (this.auth.currentuser.name === null) {
      this.auth.exams = [];
    } else {
      console.log("in here");
      console.log(this.auth.currentuser.username);
    }
  }
}
