import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { HttpClientModule } from '@angular/common/http';
import { PlatformComponent } from './platform-list/platform.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PlatformCreateComponent } from './platform-create/platform-create.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PlatformEditComponent } from './platform-list/platform-edit.component';
import { ChapterListComponent } from './chapter-list/chapter-list.component';
import { ChapterEditComponent } from './chapter-edit/chapter-edit.component';
import { ChapterCreateComponent } from './chapter-create/chapter-create.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    PlatformComponent,
    PageNotFoundComponent,
    PlatformCreateComponent,
    PlatformEditComponent,
    ChapterListComponent,
    ChapterEditComponent,
    ChapterCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
