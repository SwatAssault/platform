import {Component, Input} from '@angular/core'

@Component({
  selector: 'comp-toolbar',
  templateUrl: './toolbar.component.html'
})

export class ToolbarComponent {
  @Input() userId: number
}
