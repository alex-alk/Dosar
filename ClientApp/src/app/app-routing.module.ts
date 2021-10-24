import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PlatformComponent } from './platform-list/platform.component';
import { PlatformCreateComponent } from './platform-create/platform-create.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PlatformEditComponent } from './platform-list/platform-edit.component';
import { ChapterListComponent } from './chapter-list/chapter-list.component';
import { ChapterCreateComponent } from './chapter-create/chapter-create.component';

const routes: Routes = [
  //{ path: 'admin', component: AppComponent },
  { path: 'admin/platforms/create', component: PlatformCreateComponent },
  { path: 'admin/platforms', component: PlatformComponent },
  { path: 'admin/platforms/:id/edit', component: PlatformEditComponent },

  { path: 'admin/chapters', component: ChapterListComponent },
  { path: 'admin/chapters/create', component: ChapterCreateComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
