import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'app-draw-parking-lot',
  templateUrl: './draw-parking-lot.component.html',
  styleUrls: ['./draw-parking-lot.component.css']
})
export class DrawParkingLotComponent implements OnInit {
  @ViewChild('canvas', {static: true})
  canvas: ElementRef<HTMLCanvasElement>;

  private ctx: CanvasRenderingContext2D;
  private view;

  constructor() {
  }

  ngOnInit(): void {
    this.showAllComponent();
  }

  showAllComponent(): void {
    this.ctx = this.canvas.nativeElement.getContext('2d');
    this.view = this.ctx.canvas;
    this.ctx.clearRect(0, 0, this.view.width, this.view.height);
  }

  getHeightView(): string {
    //  chỗ tính toán số lượng khu để trong 1 tầng để đưa ra chiều cao phù hợp
    return '1000px';
  }
}
