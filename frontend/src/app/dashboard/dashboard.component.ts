import { Component, OnInit } from "@angular/core";
import { AuthService } from "../auth.service";
import { Exam } from "../model/Exam";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.css"],
})
export class DashboardComponent implements OnInit {
  examsList: Exam[];

  constructor(public auth: AuthService) {
    this.auth.exams = [];
    this.examsList = [];
  }

  ngOnInit(): void {
    if (this.auth.currentuser.name === null) {
      this.auth.exams = [];
    } else {
      console.log("in here")
      console.log(this.auth.currentuser.username)
      this.auth
        .getTests(this.auth.currentuser.username)
        .subscribe((res: any) => {
          this.auth.exams = res;
          console.log(this.auth.exams);
        });
    }
  }

  groupDet(i: string) {
    this.auth.currentgroup = i;
  }
}
