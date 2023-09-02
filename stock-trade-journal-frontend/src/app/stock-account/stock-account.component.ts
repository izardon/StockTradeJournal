import { Component } from '@angular/core';


@Component({
  selector: 'app-stock-account',
  templateUrl: './stock-account.component.html',
  styleUrls: ['./stock-account.component.scss']
})
export class StockAccountComponent {
  accounts = [
    { name: 'Account 1' },
    { name: 'Account 2' },
    // Add more account objects as needed
  ];
}
