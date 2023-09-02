import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockAccountComponent } from './stock-account.component';

describe('StockAccountComponent', () => {
  let component: StockAccountComponent;
  let fixture: ComponentFixture<StockAccountComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StockAccountComponent]
    });
    fixture = TestBed.createComponent(StockAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
