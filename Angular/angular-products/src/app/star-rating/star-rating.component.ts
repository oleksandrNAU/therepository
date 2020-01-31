import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css']
})
export class StarRatingComponent implements OnInit, OnChanges {
  @Input() rating: number;
  @Output() ratingChanged = new EventEmitter<number>();
  auxRating: number;

  constructor() { }

  ngOnInit() {
    this.auxRating = this.rating;
  }

  ngOnChanges(changes: SimpleChanges) {
    this.auxRating = this.rating;
  }

  setRating() {
    this.ratingChanged.emit(this.auxRating);
  }

}
