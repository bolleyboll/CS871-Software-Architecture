export class User {
  userId: number;
  name: string;
  password: string;
  email: string;
  username: string;
  groups: string;
  constructor() {
    this.userId = 0;
    this.name = "";
    this.password = "";
    this.email = "";
    this.username = "";
    this.groups = "";
  }
}
