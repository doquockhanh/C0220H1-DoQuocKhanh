import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DictionaryListComponent } from './dictionary/dictionary-list.component';
import { DictionaryDetailComponent } from './dictionary-detail/dictionary-detail.component';
import {RouterModule} from '@angular/router';
import {DictionaryRoutingModule} from './dictionary-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    DictionaryListComponent,
    DictionaryDetailComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    DictionaryRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
