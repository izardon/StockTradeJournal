import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StockAccountComponent } from './stock-account/stock-account.component';
import { AccountStockComponent } from './account-stock/account-stock.component';

const routes: Routes = [
  { path: 'stock-account', component: StockAccountComponent },
  { path: 'account-stock/:id', component: AccountStockComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
