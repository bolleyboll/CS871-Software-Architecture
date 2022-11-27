import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { IndexComponent } from "./index/index.component";
import { RegisterComponent } from "./register/register.component";
import { LoginComponent } from "./login/login.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { GroupComponent } from "./group/group.component";
import { NewGroupComponent } from "./new-group/new-group.component";
import { AboutComponent } from "./about/about.component";
import { NewExpenseComponent } from "./new-expense/new-expense.component";
import { NewMemberComponent } from "./new-member/new-member.component";

const routes: Routes = [
  {
    path: "",
    component: IndexComponent,
  },
  {
    path: "register",
    component: RegisterComponent,
  },
  {
    path: "login",
    component: LoginComponent,
  },
  {
    path: "dashboard",
    component: DashboardComponent,
  },
  {
    path: "group",
    component: GroupComponent,
  },
  {
    path: "newgroup",
    component: NewGroupComponent,
  },
  {
    path: "about",
    component: AboutComponent,
  },
  {
    path: "newexpense",
    component: NewExpenseComponent,
  },
  {
    path: "newmember",
    component: NewMemberComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
