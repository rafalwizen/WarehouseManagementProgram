import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from './../../model/item';
import { ItemsService } from './../../service/items.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css'],
})
export class ItemComponent implements OnInit {
  items$: Observable<Item[]>;

  constructor(private itemsService: ItemsService) {}

  ngOnInit(): void {
    this.getAllItems();
  }

  getAllItems(): Observable<Item[]> {
    return (this.items$ = this.itemsService.getAllItems());
  }
}
