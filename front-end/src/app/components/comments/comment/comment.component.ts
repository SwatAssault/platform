import {Component, Input} from '@angular/core'
import {IComment} from "../../../models/comment";

@Component({
  selector: 'comp-comment',
  templateUrl: './comment.component.html'
})

export class CommentComponent {
  @Input() comment: IComment
}
