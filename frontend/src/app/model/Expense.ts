export class Expense {
	expenseId: number;
	name: string;
	amount: number;
	forGroup: string;
	splitBetween: string;
	constructor() {
	  this.expenseId = 0;
	  this.name = "";
	  this.amount = 0.0;
	  this.forGroup = "";
	  this.splitBetween = "";
	}
  }
  