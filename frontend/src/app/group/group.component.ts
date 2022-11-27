import { Component, OnInit } from "@angular/core";
import { AuthService } from "../auth.service";
import { Expense } from "../model/Expense";
import { Group } from "../model/Group";

@Component({
  selector: "app-group",
  templateUrl: "./group.component.html",
  styleUrls: ["./group.component.css"],
})
export class GroupComponent implements OnInit {
  grp: Group;
  members: string[];
  mem: string;
  expenses: Expense[];
  split: string[];

  constructor(public auth: AuthService) {
    this.expenses = [];
    this.split = [];
  }

  ngOnInit(): void {
    this.auth.groups.forEach((element) => {
      if (element.name === this.auth.currentgroup) {
        this.grp = element;
        this.auth.curGrp = element;
      }
    });
    console.log(this.grp);
    this.mem = this.grp.members;
    this.members = this.mem.split(", ");

    this.auth.getExpenses(this.auth.curGrp.groupId).subscribe((res: any) => {
      this.expenses = res;
      console.log(this.expenses);

      this.expenses.forEach((exp) => {
        let arr = exp.splitBetween.split(", ");

        for (let i = 0; i < arr.length; i++) {
          let name, amt;
          if (i == 0) {
            if (!arr[i].split(": ")[0].startsWith("'")) {
              name = arr[i].split(": ")[0].substring(1);
              amt = arr[i].split(": ")[1];
            } else {
              name = arr[i].split(": ")[0].substring(0);
              amt = arr[i].split(": ")[1];
            }
          } else if (i == arr.length - 1) {
            name = arr[i].split(": ")[0].substring(1);
            let test = arr[i].split(": ")[1];
            amt = test.substring(0, test.length - 1);
          } else {
            name = arr[i].split(": ")[0];
            amt = arr[i].split(": ")[1];
          }
          this.split[i] = name + " " + amt;
        }
      });
    });
  }
}
