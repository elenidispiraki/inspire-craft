import { Component } from '@angular/core';
import { AuthenticationService } from '../../services/auth/authentication.service';
import { Router } from '@angular/router';
import { AuthenticationRequestDTO } from '../../interfaces/authentication-request-dto';
import { AuthenticationResponseDTO } from '../../interfaces/authentication-response-dto';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [FormsModule, RouterLink],
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string | null = null;

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  async onLogin(): Promise<void> {
    console.log('Login method called'); // Προσθήκη για έλεγχο
    const loginRequest: AuthenticationRequestDTO = {
      username: this.username,
      password: this.password,
    };

    try {
      const response: AuthenticationResponseDTO | undefined =
        await this.authService.login(this.username, this.password).toPromise();

      if (response && response.token) {
        // Ελέγχουμε αν το response είναι ορισμένο και έχει token
        console.log('Login successful', response);
        this.authService.saveUserData(response);
        this.router.navigate(['/success']);
      } else {
        console.log('Login failed', response);
        this.errorMessage = 'Authentication failed: No token received';
      }
    } catch (error) {
      console.error('Login error', error);
      this.errorMessage = 'Invalid username or password';
    }
  }

  onSubmit() {
    if (this.username && this.password) {
      console.log('Form Submitted!', this.username, this.password);
      this.errorMessage = null;
    } else {
      this.errorMessage = 'Please enter both username and password.';
    }
  }
}
