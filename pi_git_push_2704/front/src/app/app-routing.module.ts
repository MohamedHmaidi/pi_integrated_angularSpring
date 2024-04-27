import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

// layouts
import { AdminComponent } from "./layouts/admin/admin.component";
import { AuthComponent } from "./layouts/auth/auth.component";

// admin views
import { DashboardComponent } from "./views/admin/dashboard/dashboard.component";
import { MapsComponent } from "./views/admin/maps/maps.component";
import { SettingsComponent } from "./views/admin/settings/settings.component";
import { TablesComponent } from "./views/admin/tables/tables.component";

// auth views
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";

// no layouts views
import { IndexComponent } from "./views/index/index.component";
import { LandingComponent } from "./views/landing/landing.component";
import { ProfileComponent } from "./views/profile/profile.component";


// Quiz Components
import { QuizzesComponent } from "./views/tmfiles/quizzes/quizzes.component"; 
import { QuizDetailComponent } from "./views/tmfiles/quiz-detail/quiz-detail.component"; 
import { AddQuizComponent } from "./views/tmfiles/add-quiz/add-quiz.component";
import { TrainingContentListComponent } from './views/tmfiles/training-content-list/training-content-list.component';
import { AvailableQuizzesComponent } from './views/tmfiles/available-quizzes/available-quizzes.component';
import { PassQuizComponent } from './views/tmfiles/pass-quiz/pass-quiz.component';
import { AddTrainingContentComponent } from './views/tmfiles/add-training-content/add-training-content.component';
import { QuizStatisticsComponent } from './views/tmfiles/quiz-statistics/quiz-statistics.component';


import {IncidentListComponent} from "./incident-list/incident-list.component"
import { UpdateIncidentComponent } from "./update-incident/update-incident.component";
import { AddIncidentComponent } from "./add-incident/add-incident.component";
import { TypeIncidentListComponent } from "./type-incident-list/type-incident-list.component";
import { AddIncidentTypeComponent } from "./add-incident-type/add-incident-type.component";
import { ChatComponent } from "./chat/chat.component";
import { RoleGuardService } from "./role/role-guard.service";
const routes: Routes = [
 /* {path: 'chatRoom',component: ChatComponent},
  {path: 'incidents', component: IncidentListComponent} ,
  {path: 'TypeIncidents', component: TypeIncidentListComponent} ,
  {path: 'add-incident', component: AddIncidentComponent} ,
  {path: 'update-incident/:id', component:  UpdateIncidentComponent} ,
  {path: 'addType', component:   AddIncidentTypeComponent},*/
  
  // admin views
  {
    path: 'admin', component: AdminComponent, canActivate: [RoleGuardService], data: { roles: ['ADMIN']},
    children: [
  {path: 'incidents', component: IncidentListComponent} ,
  {path: 'TypeIncidents', component: TypeIncidentListComponent} ,
  {path: 'add-incident', component: AddIncidentComponent} ,
  {path: 'update-incident/:id', component:  UpdateIncidentComponent} ,
  {path: 'addType', component:   AddIncidentTypeComponent},
    ],
  },
  // auth views
  {
    path: "auth",
    component: AuthComponent,
    children: [
      { path: "login", component: LoginComponent },
      { path: "register", component: RegisterComponent },
      { path: "", redirectTo: "login", pathMatch: "full" },
    ],
  },
  // no layout views
  { path: "profile", component: ProfileComponent },
  { path: "landing", component: LandingComponent },
  { path: "", component: IndexComponent },
  { path: "**", redirectTo: "", pathMatch: "full" },


  
  // Quiz Routes
  { path: 'quizzes', component: QuizzesComponent },
  { path: 'quizzes/statistics', component: QuizStatisticsComponent },
  { path: 'quizzes/:id', component: QuizDetailComponent },
  { path: 'addquiz', component: AddQuizComponent },
  { path: 'training-content', component: TrainingContentListComponent },
  { path: 'addtrainingcontent', component: AddTrainingContentComponent },
  { path: 'available-quizzes', component: AvailableQuizzesComponent },
  { path: 'available-quizzes/:id', component: PassQuizComponent },
  { path: "**", redirectTo: "", pathMatch: "full" },




];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
