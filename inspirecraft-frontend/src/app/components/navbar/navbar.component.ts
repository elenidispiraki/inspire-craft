import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { UserService } from '../../services/user/user.service';
import { AuthenticationService } from '../../services/auth/authentication.service';
import { CreatorService } from '../../services/creator/creator.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  userService = inject(UserService);
  authService = inject(AuthenticationService);
  creatorService = inject(CreatorService);

  isLoggedIn(): boolean {
    if (typeof window !== 'undefined' && localStorage) {
      return localStorage.getItem('token') !== null;
    }
    return false;
  }
}
