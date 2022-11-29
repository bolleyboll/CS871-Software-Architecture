import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../auth.service";
import { Exam } from "../model/Exam";
import { ExamResponse } from "../model/ExamResponse";

@Component({
  selector: "app-exam",
  templateUrl: "./exam.component.html",
  styleUrls: ["./exam.component.css"],
})
export class ExamComponent implements OnInit {
  exmName: string;
  exam: ExamResponse;
  errorFlag: boolean;
  exmObj: Exam;

  constructor(public auth: AuthService, public router: Router) {
    this.exmName = "";
    this.exam = new ExamResponse();
    this.errorFlag = false;
    this.exmObj = new Exam();
  }
  ngOnInit(): void {
    console.log(this.auth.exams);
    console.log(this.auth.currentExam);
    this.auth.exams.forEach((exam) => {
      if (exam.examId === this.auth.currentExam) {
        this.exmName = exam.name;
        this.exmObj = exam;
      }
    });
  }

  examSave(examForm) {
    this.errorFlag = false;
    this.exam.exam = this.exmObj;
    this.exam.student = this.auth.currentuser.username;
    this.exam.examResponseId = Math.random() * (100 - 5) + 5;

    this.auth.saveExam(this.exam).subscribe((res: any) => {
      if (res.examResponseId === null) {
        this.errorFlag = true;
        console.log("Error");
      } else {
        alert("Response Saved");
        this.router.navigateByUrl("/dashboard");
      }
    });
    this.exam = new ExamResponse();
    examForm.form.markAsPristine();
  }
}
