import {NgModule} from '@angular/core'
import {BrowserModule} from '@angular/platform-browser'
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module'
import {HttpClientModule} from "@angular/common/http";

import {AppComponent} from './app.component'

import {PostComponent} from "./components/post/post.component";
import {PostsListComponent} from "./components/postsList/posts.list.component";
import {CreatePostComponent} from "./components/createPost/create.post.component";

import {CommentComponent} from "./components/comments/comment/comment.component";
import {CommentsListComponent} from "./components/comments/commentsList/comments.list.component";
import {ToolbarComponent} from "./components/toolbar/toolbar.component";

@NgModule({
  declarations: [
    AppComponent,
    PostComponent,
    PostsListComponent,
    CreatePostComponent,
    CommentComponent,
    CommentsListComponent,
    ToolbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
