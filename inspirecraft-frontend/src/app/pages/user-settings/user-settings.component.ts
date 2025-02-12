import { Component } from '@angular/core';
import { UserService } from '../../services/user/user.service';
import { User } from '../../interfaces/user';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-settings',
  standalone: true,
  templateUrl: './user-settings.component.html',
  styleUrls: ['./user-settings.component.css'],
  imports: [FormsModule],
})
export class UserSettingsComponent {
  user: Partial<User> = {};

  constructor(private userService: UserService, private router: Router) {}

  updateUser() {
    if (!this.user.id) {
      console.error('User ID is missing!');
      return;
    }
    this.userService.updateUser(this.user as User).subscribe(
      (updatedUser) => {
        console.log('User updated:', updatedUser);
        // Προαιρετικά: Να κατευθυνθείς πίσω στο προφίλ ή σε άλλη σελίδα
        this.router.navigate(['/user-profile']);
      },
      (error) => {
        console.error('Error updating user:', error);
      }
    );
  }
}
