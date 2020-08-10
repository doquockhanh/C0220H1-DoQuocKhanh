import {Injectable} from '@angular/core';

export interface IWord {
  key: string;
  meaning: string;
}

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  private words: IWord[] = [
    {
      key: 'service',
      meaning: 'dịch vụ'
    }, {
      key: 'service provider',
      meaning: 'nhà cung cấp dịch vụ'
    }, {
      key: 'provide',
      meaning: 'cung cấp'
    }, {
      key: 'efficient',
      meaning: 'hiệu quả'
    }, {
      key: 'snow',
      meaning: 'tuyết'
    }
  ];

  constructor() {
  }

  search(value: string): IWord {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.words.length; i++) {
      if (this.words[i].key === value) {
        return this.words[i];
      }
    }
    return null;
  }
}
