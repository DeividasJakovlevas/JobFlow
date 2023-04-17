import { Component, EventEmitter, Output } from '@angular/core';
@Component({
  selector: 'app-job-filter',
  templateUrl: './job-filter.component.html',
  styleUrls: ['./job-filter.component.css']
})
export class JobFilterComponent {
  email: string = "test@gmail.com";
  salary!: number;
  skills!: string;

  @Output() filtered = new EventEmitter<{ email: string,salary: number; skills: string[];}>();

  filter() {
    const skillsArray = this.skills ? this.skills.split(',').map((s) => s.trim()) : [];
    this.filtered.emit({ email : this.email, salary: this.salary, skills: skillsArray });
  }
}
