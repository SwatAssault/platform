import {IUser} from "./user";

export interface IComment {
  id?: number,
  text: string,
  created?: string,
  user?: IUser
}
