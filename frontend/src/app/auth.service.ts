import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { User } from "./model/User";
import { Group } from "./model/Group";

// const httpOptions = {
//   headers: new HttpHeaders({
//     Authorization: "someToken",
//   }),
//   withCredentials: true,
// };

@Injectable({
  providedIn: "root",
})
export class AuthService {
  currentuser: User = null;
  isLoggedIn: Boolean = false;
  currentgroup: string;
  curGrp: Group;
  groups: Group[];

  constructor(public http: HttpClient) {}

  getExpenses(id) {
    return this.http.get("http://localhost:8080/group/expenses/" + id);
  }
  signIn(login) {
    return this.http.post("http://localhost:8080/login", login);
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
