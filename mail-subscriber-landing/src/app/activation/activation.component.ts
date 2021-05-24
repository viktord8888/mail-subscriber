import {Component, OnInit} from '@angular/core';
import {UserRegistrationRequest} from '../landing/user.registration.request';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserActivationRequest} from './user.activation.request';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-activation',
  templateUrl: './activation.component.html',
  styleUrls: ['./activation.component.css']
})
export class ActivationComponent implements OnInit {

  private userId: string;
  activationSuccess: boolean;

  constructor(private route: ActivatedRoute, private http: HttpClient) {
    this.route.queryParams.subscribe(params => {
      this.userId = params.user;
    });
  }

  ngOnInit(): void {
    const request = new UserActivationRequest(this.userId);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});

    this.http.post('http://localhost:8080/activate', JSON.stringify(request), {headers: headers})
      .subscribe(
        data => this.activationSuccess = true,
        error => this.activationSuccess = false
      );
  }

}
