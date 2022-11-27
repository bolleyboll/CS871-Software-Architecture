import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../auth.service";
import { Group } from "../model/Group";

@Component({
  selector: "app-new-group",
  templateUrl: "./new-group.component.html",
  styleUrls: ["./new-group.component.css"],
})
export class NewGroupComponent implements OnInit {
  group: Group;
  errorFlag: boolean;
  successFlag: boolean;
  error: string;
  errorStyle: string;

  constructor(public auth: AuthService, public router: Router) {
    this.group = new Group();
    this.error = "";
    this.errorStyle = "form-text text-danger";
  }

  ngOnInit(): void {}

  newGroup(newGrpForm) {
    this.errorFlag = false;
    this.successFlag = false;
    this.group.groupId = Math.floor(Math.random() * (999 - 100 + 1) + 100);
    this.group.members = this.auth.currentuser.username;
    this.auth.groupRegister(this.group).subscribe((res: any) => {
      if (res === null) {
        this.errorFlag = true;
      } else {
        this.successFlag = true;
      }
    });
    this.group = new Group();
    newGrpForm.form.markAsPristine();
  }
}
