import { Component } from '@angular/core';
import { AuthenticationService } from '../../services/auth/authentication.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  imports: [FormsModule],
})
export class RegisterComponent {
  username: string = '';
  password: string = '';
  firstname: string = '';
  lastname: string = '';

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  onSubmit(): void {
    // Call the register method of the authentication service
    this.authService
      .register(this.username, this.password, this.firstname, this.lastname)
      .subscribe({
        next: (response) => {
          console.log('Registration successful:', response);
          // You can navigate to a login page or somewhere else upon successful registration
          this.router.navigate(['/success']);
        },
        error: (err) => {
          console.error('Registration error:', err);
          // Handle errors here, like showing an error message to the user
        },
      });
  }
}
