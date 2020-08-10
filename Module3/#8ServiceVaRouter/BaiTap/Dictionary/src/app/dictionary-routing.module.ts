import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {DictionaryListComponent} from './dictionary/dictionary-list.component';
import {DictionaryDetailComponent} from './dictionary-detail/dictionary-detail.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {
    path: 'home', children: [
      {path: '', component: DictionaryListComponent},
      {path: 'detail', component: DictionaryDetailComponent}
    ]
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes, {
      preloadingStrategy: PreloadAllModules})
  ],
  exports: [RouterModule]
})
export class DictionaryRoutingModule {
}
