import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventoItemComponent } from './event-item.component';

describe('EventItemComponent', () => {
  let component: EventoItemComponent;
  let fixture: ComponentFixture<EventoItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventoItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventoItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
