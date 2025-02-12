import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Product } from '../../interfaces/product';
import { Observable } from 'rxjs';

const API_URL = `${environment.apiURL}/api/products`;

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  [x: string]: any;
  http: HttpClient = inject(HttpClient);
  private apiUrl = API_URL;

  saveProduct(product: Product) {
    return this.http.post<{ msg: string }>(`${API_URL}/save`, product);
  }

  // Προσθήκη νέου προϊόντος
  addProduct(product: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/save`, product);
  }

  // Ενημέρωση προϊόντος
  updateProduct(id: number, product: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/update`, product);
  }

  // Διαγραφή προϊόντος
  deleteProduct(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}/delete`);
  }

  // Λήψη όλων των προϊόντων
  getProducts(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}
