import {Component, Input} from '@angular/core'
import {IPost} from "../../models/post";

@Component({
  selector: 'comp-post',
  templateUrl: './post.component.html'
})

export class PostComponent {
  @Input() post: IPost

  showComments: boolean = false

  toggleCommentsVisibility(): void {
    this.showComments = !this.showComments
  }
}
