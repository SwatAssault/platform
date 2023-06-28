import {Injectable} from '@angular/core'
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable, tap} from "rxjs";
import {IPost} from "../models/post";

// хрен знает зачем это
@Injectable({
  providedIn: 'root'
})

export class PostsService {
  baseURL = 'http://localhost:8080/blog/posts'

  // добавлял для возможности прослушки добавления элемента в массив
  // posts = new BehaviorSubject<Array<IPost>>([]);
  posts: IPost[] = []

  constructor(private httpClient: HttpClient) {
  }

  // getPosts() {
  //   return this.posts.asObservable();
  // }

  getPostsForUser(userId: number): Observable<IPost[]> {
    return this.httpClient.get<IPost[]>(`${this.baseURL}/user/` + userId)
      .pipe(
        tap(posts => this.posts = posts!.sort((a, b) => b.id! < a.id! ? -1 : b.id! > a.id! ? 1 : 0))
      )
  }

  createPost(userId: number, post: IPost): Observable<IPost> {
    return this.httpClient.post<IPost>(`${this.baseURL}/user/${userId}`, post)
      .pipe(
        tap((post) => {
          this.posts.push(post)
          this.posts.sort((a, b) => b.id! < a.id! ? -1 : b.id! > a.id! ? 1 : 0)
        })
      )
  }
}
