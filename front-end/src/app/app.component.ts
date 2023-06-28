import {Component} from '@angular/core';
import {currentUser} from "./constants/constants";
import {IUser} from "./models/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  title = 'front-end'

  // установка карент юзера...
  user: IUser = currentUser
}
