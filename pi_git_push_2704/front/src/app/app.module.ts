import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { MatPaginatorModule } from '@angular/material/paginator';
import { HttpClientModule , HTTP_INTERCEPTORS } from "@angular/common/http";
import { AuthInterceptorService } from "./auth-interceptor.service";

// layouts
import { AdminComponent } from "./layouts/admin/admin.component";
import { AuthComponent } from "./layouts/auth/auth.component";
import { MatSliderModule } from '@angular/material/slider';
// admin views
import { DashboardComponent } from "./views/admin/dashboard/dashboard.component";
import { MapsComponent } from "./views/admin/maps/maps.component";
import { SettingsComponent } from "./views/admin/settings/settings.component";
import { TablesComponent } from "./views/admin/tables/tables.component";

// auth views
import { LoginComponent } from "./login/login.component"
import { RegisterComponent } from "./register/register.component";

// no layouts views
import { IndexComponent } from "./views/index/index.component";
import { LandingComponent } from "./views/landing/landing.component";
import { ProfileComponent } from "./views/profile/profile.component";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
// components for views and layouts

import { AdminNavbarComponent } from "./components/navbars/admin-navbar/admin-navbar.component";
import { AuthNavbarComponent } from "./components/navbars/auth-navbar/auth-navbar.component";
import { CardBarChartComponent } from "./components/cards/card-bar-chart/card-bar-chart.component";
import { CardLineChartComponent } from "./components/cards/card-line-chart/card-line-chart.component";
import { CardPageVisitsComponent } from "./components/cards/card-page-visits/card-page-visits.component";
import { CardProfileComponent } from "./components/cards/card-profile/card-profile.component";
import { CardSettingsComponent } from "./components/cards/card-settings/card-settings.component";
import { CardSocialTrafficComponent } from "./components/cards/card-social-traffic/card-social-traffic.component";
import { CardStatsComponent } from "./components/cards/card-stats/card-stats.component";
import { CardTableComponent } from "./components/cards/card-table/card-table.component";
import { FooterAdminComponent } from "./components/footers/footer-admin/footer-admin.component";
import { FooterComponent } from "./components/footers/footer/footer.component";
import { FooterSmallComponent } from "./components/footers/footer-small/footer-small.component";
import { HeaderStatsComponent } from "./components/headers/header-stats/header-stats.component";
import { IndexNavbarComponent } from "./components/navbars/index-navbar/index-navbar.component";
import { MapExampleComponent } from "./components/maps/map-example/map-example.component";
import { IndexDropdownComponent } from "./components/dropdowns/index-dropdown/index-dropdown.component";
import { TableDropdownComponent } from "./components/dropdowns/table-dropdown/table-dropdown.component";
import { PagesDropdownComponent } from "./components/dropdowns/pages-dropdown/pages-dropdown.component";
import { NotificationDropdownComponent } from "./components/dropdowns/notification-dropdown/notification-dropdown.component";
import { SidebarComponent } from "./components/sidebar/sidebar.component";
import { UserDropdownComponent } from "./components/dropdowns/user-dropdown/user-dropdown.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { IncidentListComponent } from './incident-list/incident-list.component';
import { UpdateIncidentComponent } from './update-incident/update-incident.component';
import { AddIncidentComponent } from './add-incident/add-incident.component';
import { TypeIncidentListComponent } from './type-incident-list/type-incident-list.component';
import { AddIncidentTypeComponent } from './add-incident-type/add-incident-type.component';
import { ChatComponent } from './chat/chat.component';
import { MapComponent } from './map/map.component';
import { IncidentDetailComponent } from './incident-detail/incident-detail.component';
import { MatDialogModule } from '@angular/material/dialog';

//quizzes

import { QuizzesComponent } from "./views/tmfiles/quizzes/quizzes.component"; 
import { QuizDetailComponent } from "./views/tmfiles/quiz-detail/quiz-detail.component"; 
import { AddQuizComponent } from "./views/tmfiles/add-quiz/add-quiz.component";
import { TrainingContentListComponent } from './views/tmfiles/training-content-list/training-content-list.component';
import { AvailableQuizzesComponent } from './views/tmfiles/available-quizzes/available-quizzes.component';
import { PassQuizComponent } from './views/tmfiles/pass-quiz/pass-quiz.component';
import { AddTrainingContentComponent } from './views/tmfiles/add-training-content/add-training-content.component';
import { QuizStatisticsComponent } from './views/tmfiles/quiz-statistics/quiz-statistics.component';



@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    CardBarChartComponent,
    CardLineChartComponent,
    IndexDropdownComponent,
    PagesDropdownComponent,
    TableDropdownComponent,
    NotificationDropdownComponent,
    UserDropdownComponent,
    SidebarComponent,
    FooterComponent,
    FooterSmallComponent,
    FooterAdminComponent,
    CardPageVisitsComponent,
    CardProfileComponent,
    CardSettingsComponent,
    CardSocialTrafficComponent,
    CardStatsComponent,
    CardTableComponent,
    HeaderStatsComponent,
    MapExampleComponent,
    AuthNavbarComponent,
    AdminNavbarComponent,
    IndexNavbarComponent,
    AdminComponent,
    AuthComponent,
    MapsComponent,
    SettingsComponent,
    TablesComponent,
    LoginComponent,
    RegisterComponent,
    IndexComponent,
    LandingComponent,
    ProfileComponent,
    IncidentListComponent,
    UpdateIncidentComponent,
    AddIncidentComponent,
    TypeIncidentListComponent,
    AddIncidentTypeComponent,
    ChatComponent,
    MapComponent,
    IncidentDetailComponent,
    QuizzesComponent,
    QuizDetailComponent,
    AddQuizComponent,
    TrainingContentListComponent,
    AvailableQuizzesComponent,
    PassQuizComponent,
    AddTrainingContentComponent,
    QuizStatisticsComponent,

    
  ],
  imports: [BrowserModule, AppRoutingModule, BrowserAnimationsModule,HttpClientModule,MatSnackBarModule,FormsModule,MatPaginatorModule,MatSliderModule,MatDialogModule,ReactiveFormsModule],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptorService,
    multi: true // Set to true because you're providing multiple interceptors
  }],
  bootstrap: [AppComponent],
})
export class AppModule {}
