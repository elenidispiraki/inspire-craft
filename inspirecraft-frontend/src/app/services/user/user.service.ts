import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { User } from '../../interfaces/user'; // Το interface για τον χρήστη

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private API_URL = `${environment.apiURL}/api/users`;

  constructor(private http: HttpClient) {}

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.API_URL}/all`);
  }
  // Δημιουργία χρήστη
  saveUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.API_URL}/save`, user);
  }

  // Ενημέρωση χρήστη
  updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.API_URL}/update`, user);
  }

  // Διαγραφή χρήστη
  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API_URL}/${id}/delete`);
  }

  // Λήψη χρήστη από το username
  getUserByUsername(username: string): Observable<User> {
    return this.http.get<User>(`${this.API_URL}/username/${username}`);
  }

  // Λήψη χρήστη από το ID
  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.API_URL}/${id}`);
  }

  // Λήψη χρηστών με βάση το επώνυμο
  getUsersByLastname(lastname: string): Observable<User[]> {
    return this.http.get<User[]>(`${this.API_URL}/name/${lastname}`);
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.API_URL}/add`, user);
  }
}
