import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { IndexComponent } from "./index/index.component";
import { LoginComponent } from "./login/login.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { GroupComponent } from "./group/group.component";
import { NewGroupComponent } from "./new-group/new-group.component";
import { AboutComponent } from "./about/about.component";
import { TeacherLoginComponent } from "./teacher-login/teacher-login.component";

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
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}