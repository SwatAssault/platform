import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core'
import {FormControl, FormGroup} from "@angular/forms";
import {PostsService} from "../../services/posts.service";
import {currentUser} from "../../constants/constants";

@Component({
  selector: 'comp-create-post',
  templateUrl: './create.post.component.html'
})

export class CreatePostComponent {
  @Input() createPostDialogOpen: boolean
  @Output() onHide = new EventEmitter<boolean>();

  form = new FormGroup({
    title: new FormControl<string>(''),
    text: new FormControl<string>('')
  })

  constructor(
    private postService: PostsService) {
  }

  hideDialog() {
    this.onHide.emit(false);
  }

  submit() {
    this.postService.createPost(
      currentUser.id,
  {
        title: this.form.value.title as string,
        text: this.form.value.text as string
      }).subscribe(() => {
        this.hideDialog()
    })
  }
}
