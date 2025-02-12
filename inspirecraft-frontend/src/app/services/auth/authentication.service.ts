import { Injectable, Inject, PLATFORM_ID } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationRequestDTO } from '../../interfaces/authentication-request-dto';
import { AuthenticationResponseDTO } from '../../interfaces/authentication-response-dto';
import { RegistrationRequestDTO } from '../../interfaces/registration-request-dto';
import { isPlatformBrowser } from '@angular/common';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private authUrl = 'http://localhost:8080/api/auth/authenticate'; // URL for login
  private registerUrl = 'http://localhost:8080/api/auth/register';
  constructor(
    private http: HttpClient,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {}

  login(
    username: string,
    password: string
  ): Observable<AuthenticationResponseDTO> {
    const request: AuthenticationRequestDTO = { username, password };
    return this.http.post<AuthenticationResponseDTO>(this.authUrl, request);
  }

  register(
    username: string,
    password: string,
    firstname: string,
    lastname: string
  ): Observable<any> {
    const request: RegistrationRequestDTO = {
      username,
      password,
      firstname,
      lastname,
    };
    return this.http.post<any>(this.registerUrl, request);
  }

  // Αποθήκευση των στοιχείων στο localStorage
  saveUserData(authResponse: AuthenticationResponseDTO) {
    if (authResponse.token) {
      localStorage.setItem('token', authResponse.token);
    } else {
      console.error('Token is undefined');
    }
    if (authResponse.firstname && authResponse.lastname) {
      const user = {
        firstname: authResponse.firstname,
        lastname: authResponse.lastname,
        username: authResponse.username,
        dateOfBirth: authResponse.dateOfBirth,
        role: authResponse.role,
      };
      localStorage.setItem('user', JSON.stringify(user));
      console.log('Saved user:', user);
    } else {
      console.error('firstname or Lastname is undefined');
    }
  }

  // Λήψη του τρέχοντος χρήστη από το localStorage
  getCurrentUser() {
    const token = localStorage.getItem('token');
    const userData = localStorage.getItem('user');
    if (token && userData) {
      const user = JSON.parse(userData);
      console.log('Loaded user:', user);
      return user;
    }
    return null;
  }

  // Διαγραφή δεδομένων κατά το logout
  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
  }
}
