import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManteminientoComponent } from './manteminiento.component';

describe('ManteminientoComponent', () => {
  let component: ManteminientoComponent;
  let fixture: ComponentFixture<ManteminientoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManteminientoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManteminientoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
