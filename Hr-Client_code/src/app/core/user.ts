export class User {

    id: number;
    email: string;
    password: string;
    firstname: string;
    lastname: string;
    username: string;
    dob: Date;
    phonenumber: string;
    
    constructor() {
    }

    public static isNull(user: User): boolean {
        return user.email === null &&
            user.password === null &&
            user.firstname === null &&
            user.lastname === null &&
            user.dob === null &&
            user.phonenumber === null &&
            user.username === null;
    }
}