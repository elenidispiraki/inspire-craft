import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../../services/product/product.service';
import { Product } from '../../interfaces/product';
import { Observable } from 'rxjs';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-product-detail',
  standalone: true,

  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'],
})
export class ProductDetailComponent implements OnInit {
  productId!: number;
  product$!: Observable<Product>;
  product: any;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    // Παίρνουμε το productId από το route
    this.productId = Number(this.route.snapshot.paramMap.get('id'));
    // Καλούμε την υπηρεσία για να φέρουμε το προϊόν
    this.product$ = this.productService['getProductById'](this.productId);
  }
}
