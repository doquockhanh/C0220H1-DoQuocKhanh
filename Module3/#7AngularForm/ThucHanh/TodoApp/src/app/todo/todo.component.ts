import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';

interface ITodo {
  id: number;
  content: string;
  done: boolean;
}

let index = 0;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})

export class TodoComponent implements OnInit {
  userInput = new FormControl();
  todos: Array<ITodo> = [];

  constructor() {
  }

  ngOnInit(): void {
  }

  onChange(): void {
    const {value} = this.userInput;
    if (value) {
      const todo: ITodo = {
        id: ++index,
        content: value,
        done: false
      };
      this.todos.push(todo);
    }
  }

  toggleTodo(i): void {
    this.todos[i].done = !this.todos[i].done;
  }

}
