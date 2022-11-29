import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Student } from "./model/Student";
import { Course } from "./model/Course";
import { Exam } from "./model/Exam";

// const httpOptions = {
//   headers: new HttpHeaders({
//     "Content-Type": "application/json; charset=utf-8",
//     "Access-Control-Allow-Origin": "true",
//   }),
// };

@Injectable({
  providedIn: "root",
})
export class AuthService {
  currentuser: Student = null;
  isLoggedIn: Boolean = false;
  currentExam: number;
  curGrp: Course;
  groups: Course[];
  exams: Exam[];
  selCourse: string;

  constructor(public http: HttpClient) {}

  studentSignIn(login) {
    return this.http.post("http://localhost:8080/student/login", login);
  }
  teacherSignIn(login) {
    return this.http.post("http://localhost:8080/teacher/login", login);
  }
  saveExamResponse(exam) {
    return this.http.post(
      "http://localhost:8080/course/tests/response/save",
      exam
    );
  }
  findAllCourses() {
    return this.http.get("http://localhost:8080/course/all");
  }
  saveExam(exam, course) {
    return this.http.post("http://localhost:8080/course/tests/save/" + course, exam);
  }
  newExpense(exp) {
    return this.http.post("http://localhost:8080/expense/add", exp);
  }
  getAllUsers() {
    return this.http.get("http://localhost:8080/users");
  }
  getTests(username) {
    return this.http.get("http://localhost:8080/course/tests/" + username);
  }
  getGroup(id) {
    return this.http.get("http://localhost:8080/group/" + id);
  }
  addUserToGrp(username, groupId) {
    return this.http.get(
      "http://localhost:8080/group/add/" + username + "/" + groupId
    );
  }
}
