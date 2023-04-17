import { Component, ViewChild} from '@angular/core';
import { JobService } from './job-service/job-service.service';
import { JobListing } from './models/job-listing.model';
import { JobFilterComponent } from './job-filter/job-filter.component';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
 job!: JobListing
 email: string = 'test';
 constructor(private jobService: JobService) {}

   onFiltered(event: { email: string; salary: number; skills: string[] }) {
      this.email = event.email;
      this.next();
    }
   ngOnInit() {
      this.showNext();
   }
   apply() {
       console.log('not implemented');
    }
   markCurrentSeen() {
    console.log(this.job);
     if(this.job === null){
        return;
     }
     this.jobService.markJobListingSeen(this.job.id,this.email)
     .subscribe((res: any) => this.showNext(),
        error => console.log(error));

   }
  next() {
    this.markCurrentSeen();
  }
  showNext(){
    this.jobService.getNextJobListing(this.email)
           .subscribe((job: JobListing) => {
              console.log(job);
               if(job){
                  this.job = job;
               }else{
                  this.job = {
                      id: 0,
                      companyName: "You looked at all job listings",
                      rating: 0,
                      description: "",
                      salary: 0,
                      skills: []
                 };
               }

           },
           error =>{
               this.job = {
                       id: 0,
                       companyName: "You looked at all job listings",
                       rating: 0,
                       description: "",
                       salary: 0,
                       skills: []
               }
               console.log(error);
          });
  }
}
