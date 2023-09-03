import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountStockComponent } from './account-stock.component';

describe('StockInfoComponent', () => {
  let component: AccountStockComponent;
  let fixture: ComponentFixture<AccountStockComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AccountStockComponent]
    });
    fixture = TestBed.createComponent(AccountStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
