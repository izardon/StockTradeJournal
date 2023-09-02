import { Component } from '@angular/core';

@Component({
  selector: 'app-drawer',
  templateUrl: './drawer.component.html',
  styleUrls: ['./drawer.component.scss']
})
export class DrawerComponent {
  isDrawerOpen = false;

  toggleDrawer() {
    this.isDrawerOpen = !this.isDrawerOpen;
  }
}
