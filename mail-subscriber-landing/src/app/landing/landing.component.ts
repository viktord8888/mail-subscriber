import {Component} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserRegistrationRequest} from './user.registration.request';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent {

  email = '';

  constructor(private http: HttpClient, private router: Router) {
  }

  sendMail(): any {
    // const token = requestAccessToken();

    var request = new UserRegistrationRequest(this.email);

    var headers = new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic dXNlcjE6dXNlcjFQYXNz'
      }
    );

    this.http.post('http://localhost:8080/register', JSON.stringify(request), {headers: headers}).subscribe(
        data => this.router.navigate(['confirmation']),
        error => alert('Cannot register user.')
    );
  }

}
