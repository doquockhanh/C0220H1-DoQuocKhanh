import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { DrawParkingLotComponent } from './draw-parking-lot/draw-parking-lot.component';

@NgModule({
  declarations: [
    AppComponent,
    DrawParkingLotComponent
  ],
  imports: [
    BrowserModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
