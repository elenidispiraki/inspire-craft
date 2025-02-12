import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Creator } from '../../interfaces/creator'; // Το interface για τον Creator
import { Product } from '../../interfaces/product'; // Το interface για τα προϊόντα του creator

const API_URL = `${environment.apiURL}/creator`; // Το base URL για το creator API

@Injectable({
  providedIn: 'root',
})
export class CreatorService {
  http: HttpClient = inject(HttpClient);

  // Δημιουργία Creator
  saveCreator(creator: Creator) {
    return this.http.post<{ msg: string }>(`${API_URL}/save`, creator);
  }

  // Ενημέρωση Creator
  updateCreator(creator: Creator) {
    return this.http.put<{ msg: string }>(`${API_URL}/update`, creator);
  }

  // Διαγραφή Creator
  deleteCreator(id: number) {
    return this.http.delete(`${API_URL}/${id}/delete`);
  }

  // Λήψη προϊόντων από Creator μέσω id
  getProductsByCreatorId(creatorId: number) {
    return this.http.get<Product[]>(`${API_URL}/${creatorId}/products`);
  }

  // Λήψη όλων των creators
  getCreators() {
    return this.http.get<Creator[]>(`${API_URL}/all`);
  }

  // Λήψη ενός creator από το ID
  getCreator(id: number) {
    return this.http.get<Creator>(`${API_URL}/${id}`);
  }
}
