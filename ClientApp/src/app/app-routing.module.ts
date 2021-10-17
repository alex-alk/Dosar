import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PlatformComponent } from './platform/platform.component';

const routes: Routes = [
  { path: 'admin', component: AppComponent },
  { path: 'admin/platform/create', component: PlatformComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
