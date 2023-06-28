import {Component, Input, OnInit} from '@angular/core'
import {IComment} from "../../../models/comment";
import {CommentsService} from "../../../services/comments.service";
import {currentUser} from "../../../constants/constants";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'comp-comments-list',
  templateUrl: './comments.list.component.html'
})

export class CommentsListComponent implements OnInit {
  @Input() postId?: number
  comments: IComment[] = []

  form = new FormGroup({
    commentText: new FormControl<string>('')
  })

  constructor(private commentsService: CommentsService) {
  }

  addComment() {
    if (this.postId && this.form.value.commentText) {
      this.commentsService.createCommentToPost(this.postId, currentUser.id, {"text": this.form.value.commentText}).subscribe((comment) => {
        this.comments.push(comment)
        this.form.reset()
      })
    }
  }

  ngOnInit(): void {
    if (this.postId) {
      this.commentsService.getCommentsForPost(this.postId).subscribe((comments) => {
        this.comments = comments
      })
    }
  }
}
