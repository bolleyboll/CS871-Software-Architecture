import { Course } from "./Course";

export class Exam {
	examId: any;
	name: string;
	startDate: Date;
	duration: number;
	course: Course
	constructor() {
	  this.examId = 0;
	  this.name = "";
	  this.startDate = new Date();
	  this.duration = 0;
	  this.course = new Course();
	}
  }
  