import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Student } from "./model/Student";
import { Course } from "./model/Course";

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
  currentgroup: string;
  curGrp: Course;
  groups: Course[];

  constructor(public http: HttpClient) {}

  getExpenses(id) {
    return this.http.get("http://localhost:8080/group/expenses/" + id);
  }
  studentSignIn(login) {
    return this.http.post("http://localhost:8080/student/login", login);
  }
  patRegister(user) {
    return this.http.post("http://localhost:8080/register", user);
  }
  groupRegister(grp) {
    return this.http.post("http://localhost:8080/group/create", grp);
  }
  newExpense(exp) {
    return this.http.post("http://localhost:8080/expense/add", exp);
  }
  getAllUsers() {
    return this.http.get("http://localhost:8080/users");
  }
  getGroups(username) {
    return this.http.get("http://localhost:8080/user/group/" + username);
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
