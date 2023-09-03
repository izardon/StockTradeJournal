import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

interface AccountStock {
  code: string;
  name: string;
}

@Component({
  selector: 'app-account-stock',
  templateUrl: './account-stock.component.html',
  styleUrls: ['./account-stock.component.scss']
})
export class AccountStockComponent implements OnInit {
  accountStocks: AccountStock[] = [];
  accountid!: string;

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.accountid = params['id']; // 從路由參數中獲取 accountid
      this.fetchInfos(this.accountid);
    });
  }

  fetchInfos(accountid: string): void {
    const apiUrl = `http://localhost:8080/stock-trade-journal/stock-account-list/${accountid}/account-stock-list`;

    this.http.get<{ accountStockDtos: AccountStock[] }>(apiUrl)
      .subscribe(data => {
        this.accountStocks = data.accountStockDtos;
      });
  }
}
