import { Component, OnInit } from '@angular/core';
import { User } from '../../interfaces/user';
import { UserService } from '../../services/user/user.service';
import { ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../../services/auth/authentication.service';
import { Router } from '@angular/router';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  user?: User | null | undefined = null;

  constructor(
    private userService: UserService,
    private authService: AuthenticationService,
    private router: Router
  ) {
    this.user = this.authService.getCurrentUser();
  }

  ngOnInit(): void {
    this.user = this.authService.getCurrentUser();
    console.log('Retrieved user:', this.user);
    if (!this.user) {
      console.error('User is not logged in');
      this.router.navigate(['/login']);
    }
  }

  logout() {
    this.authService.logout();
    this.user = null;
  }
}
