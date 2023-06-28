import {Component, OnInit} from '@angular/core'
import {PostsService} from "../../services/posts.service";
import {currentUser} from "../../constants/constants";

@Component({
  selector: 'comp-posts-list',
  templateUrl: './posts.list.component.html'
})

export class PostsListComponent implements OnInit {
  loading = false
  createPostDialogOpen = false

  constructor(public postsService: PostsService) {
  }

  createPostClick(): void {
    this.createPostDialogOpen = true
  }

  hidePostDialog(show: boolean): void {
    this.createPostDialogOpen = show
  }

  ngOnInit(): void {
    this.getPostsForUser(currentUser.id)
  }

  getPostsForUser(userId: number) {
    this.loading = true

    this.postsService.getPostsForUser(userId).subscribe(() => {
      this.loading = false
    })
  }
}
