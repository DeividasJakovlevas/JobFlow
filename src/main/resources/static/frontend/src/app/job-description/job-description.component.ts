import { Component, Input } from '@angular/core';
import { DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-job-description',
  templateUrl: './job-description.component.html',
  styleUrls: ['./job-description.component.css'],
  providers: [DecimalPipe]
})
export class JobDescriptionComponent {
  @Input() companyName!: string;
  @Input() companyRatings!: number;
  @Input() jobDescription!: string;
  @Input() salary!: number;
  @Input() skills!: string[];

  constructor(private decimalPipe: DecimalPipe) {}

  get formattedSalary() {
    return this.decimalPipe.transform(this.salary, '1.0-0');
  }

  get yearlySalary() {
    return this.decimalPipe.transform(this.salary * 12, '1.0-0');
  }
}
