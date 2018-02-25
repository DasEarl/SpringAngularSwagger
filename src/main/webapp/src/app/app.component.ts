import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { HelloService } from '../swagger';

const API = environment.api;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'app';
  result = '';

  constructor(private http : HttpClient) {}

  private sayHello(): void {
    var a = new HelloService(this.http, "", null);
    a.helloWorldUsingGET().subscribe(response => this.result = response["text"]);
    a.testUsingGET("Hasan").subscribe(response => this.result = response["text"]);
  }
}
