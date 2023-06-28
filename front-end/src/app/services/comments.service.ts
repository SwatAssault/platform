import {Injectable} from '@angular/core'
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable, tap} from "rxjs";
import {IPost} from "../models/post";
import {IComment} from "../models/comment";

// хрен знает зачем это
@Injectable({
  providedIn: 'root'
})

export class CommentsService {
  baseURL = 'http://localhost:8080/blog/posts'

  constructor(private httpClient: HttpClient) {
  }

  getCommentsForPost(postId: number): Observable<IComment[]> {
    return this.httpClient.get<IComment[]>(`${this.baseURL}/${postId}/comments`)
  }

  createCommentToPost(postId: number, userId: number, comment: IComment) {
    return this.httpClient.post<IComment>(`${this.baseURL}/${postId}/comments/user/${userId}`, comment)
  }

}
