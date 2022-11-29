import { Exam } from "./Exam";

export class ExamResponse {
  examResponseId: number;
  student: string;
  exam: Exam;
  response: string;
  constructor() {
    this.examResponseId = 0;
    this.student = "";
    this.exam = new Exam;
    this.response = "";
  }
}