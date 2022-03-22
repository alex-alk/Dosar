import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PlatformComponent } from './platform-list/platform.component';
import { PlatformCreateComponent } from './platform-create/platform-create.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PlatformEditComponent } from './platform-list/platform-edit.component';
import { ChapterListComponent } from './chapter-list/chapter-list.component';
import { ChapterCreateComponent } from './chapter-create/chapter-create.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuardService } from './auth/AuthGuardService';
import { ChapterEditComponent } from './chapter-edit/chapter-edit.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';

const routes: Routes = [
  { path: 'admin', component: AdminHomeComponent, canActivate: [ AuthGuardService ]  },
  { path: 'login', component: LoginComponent },
  { path: 'register/', component: RegisterComponent },
  { path: 'admin/platforms/create', component: PlatformCreateComponent, canActivate: [ AuthGuardService ] },
  { path: 'admin/platforms', component: PlatformComponent, canActivate: [ AuthGuardService ] },
  { path: 'admin/platforms/:id/edit', component: PlatformEditComponent, canActivate: [ AuthGuardService ] },

  { path: 'admin/chapters', component: ChapterListComponent, canActivate: [ AuthGuardService ] },
  { path: 'admin/chapters/:id/edit', component: ChapterEditComponent, canActivate: [ AuthGuardService ] },
  { path: 'admin/chapters/create', component: ChapterCreateComponent, canActivate: [ AuthGuardService ] },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
