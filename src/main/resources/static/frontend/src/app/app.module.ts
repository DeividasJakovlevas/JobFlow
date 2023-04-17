import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; // <-- import HttpClientModule

import { AppComponent } from './app.component';
import { JobDescriptionComponent } from './job-description/job-description.component';
import { JobFilterComponent } from './job-filter/job-filter.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    JobDescriptionComponent,
    JobFilterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
