import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobListing } from '../models/job-listing.model';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  private baseUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

    getNextJobListing(email: string): Observable<JobListing> {
       const url = `${this.baseUrl}/api/job-listings/next?email=${email}`;
       return this.http.get<JobListing>(url);
    }

   markJobListingSeen(id: number, email: string): Observable<any> {
     if(email === undefined) {
        email='test';
     }
     const url = `${this.baseUrl}/api/job-listings/${id}/seen`;
     return this.http.post(url, email);
   }
}
