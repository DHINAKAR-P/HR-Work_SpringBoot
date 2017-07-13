export class UserLeave {

    id: string;
    leaveApprovedBy: number;
    leaveFromDate: any;
    leaveToDate: any;
    createOn: any;
    numberOfDays:any;
    summary: string;

    constructor() {
    }

    public static isNull(leave: UserLeave): boolean {
        return leave.leaveApprovedBy === null &&
            leave.leaveFromDate === null &&
            leave.leaveToDate === null &&
            leave.createOn === null&&
            leave.numberOfDays === null&&
            leave.summary ===null;
    }
}