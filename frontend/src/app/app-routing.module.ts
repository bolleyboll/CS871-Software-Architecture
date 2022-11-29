import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { IndexComponent } from "./index/index.component";
import { LoginComponent } from "./login/login.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { AboutComponent } from "./about/about.component";
import { TeacherLoginComponent } from "./teacher-login/teacher-login.component";
import { ExamComponent } from "./exam/exam.component";
import { TeacherDashboardComponent } from "./teacher-dashboard/teacher-dashboard.component";
import { NewTestComponent } from "./new-test/new-test.component";

const routes: Routes = [
  {
    path: "",
    component: IndexComponent,
  },
  {
    path: "login",
    component: LoginComponent,
  },{
    path: "tlogin",
    component: TeacherLoginComponent,
  },
  {
    path: "dashboard",
    component: DashboardComponent,
  },
  {
    path: "exam",
    component: ExamComponent,
  },
  {
    path: "tdashboard",
    component: TeacherDashboardComponent,
  },
  {
    path: "about",
    component: AboutComponent,
  },
  {
    path: "newtest",
    component: NewTestComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
