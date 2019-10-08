import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroRestComponent } from './registro-rest.component';

describe('RegistroRestComponent', () => {
  let component: RegistroRestComponent;
  let fixture: ComponentFixture<RegistroRestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistroRestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistroRestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
