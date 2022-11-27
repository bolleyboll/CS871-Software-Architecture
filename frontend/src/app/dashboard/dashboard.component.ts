import { Component, OnInit } from "@angular/core";
import { AuthService } from "../auth.service";
import { Group } from "../model/Group";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.css"],
})
export class DashboardComponent implements OnInit {
  groupsList: string[];

  constructor(public auth: AuthService) {
    this.auth.groups = [];
    this.groupsList = [];
  }

  ngOnInit(): void {
    if (this.auth.currentuser.name === null) {
      this.auth.groups = [];
    } else {
      this.auth
        .getGroups(this.auth.currentuser.username)
        .subscribe((res: any) => {
          this.groupsList = res;
          console.log(this.groupsList);

          this.groupsList.forEach((group) => {
            this.auth.getGroup(group).subscribe((res: any) => {
              this.auth.groups.push(res);
            });
          });
          console.log(this.auth.groups);
        });
    }
  }

  groupDet(i: string) {
    this.auth.currentgroup = i;
  }
}
