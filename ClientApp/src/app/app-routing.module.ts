import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PlatformComponent } from './platform/platform.component';
import { PlatformCreateComponent } from './platform-create/platform-create.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PlatformEditComponent } from './platform/platform-edit.component';
import { ChapterListComponent } from './chapter/chapter-list.component';

const routes: Routes = [
  //{ path: 'admin', component: AppComponent },
  { path: 'admin/platforms/create', component: PlatformCreateComponent },
  { path: 'admin/platforms', component: PlatformComponent },
  { path: 'admin/platforms/:id/edit', component: PlatformEditComponent },

  { path: 'admin/chapters', component: ChapterListComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
