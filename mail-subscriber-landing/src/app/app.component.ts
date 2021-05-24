import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserRegistrationRequest} from './landing/user.registration.request';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'mail-subscriber-landing';
}
