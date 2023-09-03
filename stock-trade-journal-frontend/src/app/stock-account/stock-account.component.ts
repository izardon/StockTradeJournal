import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface StockAccount {
  id: string;
  name: string;
}

@Component({
  selector: 'app-stock-account',
  templateUrl: './stock-account.component.html',
  styleUrls: ['./stock-account.component.scss']
})
export class StockAccountComponent implements OnInit {
  accounts: StockAccount[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAccounts();
  }

  fetchAccounts(): void {
    const apiUrl = 'http://localhost:8080/stock-trade-journal/stock-account-list';

    this.http.get<{ stockAccountDtos: StockAccount[] }>(apiUrl)  // 替換為實際API的URL
      .subscribe(data => {
        this.accounts = data.stockAccountDtos;
      });
  }
}
