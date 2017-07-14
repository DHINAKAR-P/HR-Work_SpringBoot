export class Role {

    id: string;
    role: string;

    constructor() {
    }

    public static isNull(role: Role): boolean {
        return role.role === null;
    }
}