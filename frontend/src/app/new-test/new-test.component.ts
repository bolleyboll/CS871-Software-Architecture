import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "../auth.service";
import { Course } from "../model/Course";
import { Exam } from "../model/Exam";

@Component({
  selector: "app-new-test",
  templateUrl: "./new-test.component.html",
  styleUrls: ["./new-test.component.css"],
})
export class NewTestComponent implements OnInit {
  exam: Exam;
  courses: Course[];
  errorFlag: boolean;
  successFlag: boolean;
  error: string;
  errorStyle: string;
  temp: Course;
  d: Course;

  constructor(public auth: AuthService, public router: Router) {
    this.exam = new Exam();
    this.courses = [];
    this.error = "";
    this.errorStyle = "form-text text-danger";
    this.d = new Course();
    this.temp = new Course();
  }

  ngOnInit(): void {
    this.auth.findAllCourses().subscribe((res: any) => {
      if (res === null) {
        alert("No Courses in DB");
      } else {
        this.courses = res;
      }
    });
  }

  newTest(newTestForm) {
    this.errorFlag = false;
    this.successFlag = false;
    this.exam.examId = Math.floor(Math.random() * (999 - 100 + 1) + 100);
    
    console.log(this.exam);

    this.auth.saveExam(this.exam, this.auth.selCourse).subscribe((res: any) => {
      console.log(res.examId)
      if (res.examId === null) {
        this.errorFlag = true;
      } else {
        this.successFlag = true;
        alert("Exam Saved");
      }
    });
    this.exam = new Exam();
    newTestForm.form.markAsPristine();
  }

  groupDet(i: string) {
    this.auth.selCourse = i;
  }
}
