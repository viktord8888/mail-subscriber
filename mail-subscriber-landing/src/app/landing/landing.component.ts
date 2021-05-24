import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserRegistrationRequest} from './user.registration.request';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent {

  email = '';

  constructor(private http: HttpClient) { }

  sendMail(): any {
    // const token = requestAccessToken();

    var request = new UserRegistrationRequest(this.email);

    var headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic dXNlcjE6dXNlcjFQYXNz'}
    );

    this.http.post('http://localhost:8080/register', JSON.stringify(request), {headers:headers}).subscribe(data => {
      alert(JSON.stringify(data));
    });
  }

}
