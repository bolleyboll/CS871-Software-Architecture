import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../auth.service";
import { Expense } from "../model/Expense";

@Component({
  selector: "app-new-expense",
  templateUrl: "./new-expense.component.html",
  styleUrls: ["./new-expense.component.css"],
})
export class NewExpenseComponent implements OnInit {
  expense: Expense;
  errorFlag: boolean;
  successFlag: boolean;
  error: string;
  errorStyle: string;

  constructor(public auth: AuthService, public router: Router) {
    this.expense = new Expense();
    this.error = "";
    this.errorStyle = "form-text text-danger";
  }

  ngOnInit(): void {}

  newExpense(newExpForm) {
    this.errorFlag = false;
    this.successFlag = false;
    this.expense.expenseId = Math.floor(Math.random() * (999 - 100 + 1) + 100);
    this.expense.splitBetween = this.auth.currentuser.username;
    console.log(this.expense);
    this.auth.newExpense(this.expense).subscribe((res: any) => {
      if (res === null) {
        this.errorFlag = true;
      } else {
        this.successFlag = true;
      }
    });
    this.expense = new Expense();
    newExpForm.form.markAsPristine();
  }
}
