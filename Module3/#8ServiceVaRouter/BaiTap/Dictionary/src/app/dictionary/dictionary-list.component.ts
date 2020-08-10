import { Component, OnInit } from '@angular/core';
import {DictionaryService, IWord} from '../dictionary.service';

@Component({
  selector: 'app-dictionary-list',
  templateUrl: './dictionary-list.component.html',
  styleUrls: ['./dictionary-list.component.css']
})
export class DictionaryListComponent implements OnInit {
  word: IWord;

  constructor(private dictionaryService: DictionaryService) { }

  ngOnInit(): void {
  }


  search(value: string): void {
    this.word = this.dictionaryService.search(value);
  }
}
