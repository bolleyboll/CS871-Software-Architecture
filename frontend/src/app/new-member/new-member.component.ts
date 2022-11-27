import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../auth.service";
import { User } from "../model/User";

@Component({
  selector: "app-new-member",
  templateUrl: "./new-member.component.html",
  styleUrls: ["./new-member.component.css"],
})
export class NewMemberComponent implements OnInit {
  users: User[];
  username: string;
  errorFlag: boolean;
  successFlag: boolean;
  error: string;
  errorStyle: string;
  constructor(public auth: AuthService, public router: Router) {}

  ngOnInit(): void {
    if (this.auth.currentuser.name === null) {
      this.users = [];
    } else {
      this.auth.getAllUsers().subscribe((res: any) => {
        this.users = res;
      });
    }
  }

  addUser(addUserForm) {
    this.auth
      .addUserToGrp(this.username, this.auth.curGrp.groupId)
      .subscribe((res: any) => {
        if (res === null) {
          this.errorFlag = true;
        } else {
          this.successFlag = true;
        }
      });
  }
}
