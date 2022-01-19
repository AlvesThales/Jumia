import {Injectable} from '@angular/core';
import {Phone} from "./model/Phone";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) {
  }

  getPhones(): Observable<Array<Phone>> {
    return this.http.get<Array<Phone>>("http://localhost:8080/customers/phones")
  }
}
