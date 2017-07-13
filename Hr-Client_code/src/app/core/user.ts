export class User {

    id: string;
    email: string;
    password: string;
<<<<<<< HEAD
   firstname: string;
   lastname: string;
    username: string;
dob: Date;
phonenumber: string;
=======
    firstname: string;
    lastname: string;
    username: string;

>>>>>>> 96d66a91d282be17ade18d3b0efcd86269e6ec93
    constructor() {
    }

    public static isNull(user: User): boolean {
        return user.email === null &&
            user.password === null &&
<<<<<<< HEAD
           user.firstname === null &&
           user.lastname === null &&
           user.dob === null &&
           user.phonenumber === null &&
=======
            user.firstname === null &&
            user.lastname === null && 
>>>>>>> 96d66a91d282be17ade18d3b0efcd86269e6ec93
            user.username === null;
    }
}