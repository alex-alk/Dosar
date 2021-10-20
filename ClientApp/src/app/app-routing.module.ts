import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PlatformComponent } from './platform/platform.component';
import { PlatformCreateComponent } from './platform-create/platform-create.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  //{ path: 'admin', component: AppComponent },
  { path: 'admin/platform/create', component: PlatformCreateComponent },
  { path: 'admin/platform', component: PlatformComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
