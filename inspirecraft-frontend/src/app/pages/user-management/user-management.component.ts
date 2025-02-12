import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user/user.service';
import { User } from '../../interfaces/user';
import { Role } from '../../interfaces/role.enum';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css'],
})
export class UserManagementComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    this.userService.getAllUsers().subscribe((usersData) => {
      this.users = usersData;
    });
  }

  addUser(): void {
    const newUser: User = {
      id: 0, // Το backend θα ορίσει το ID
      firstname: 'Νέο',
      lastname: 'Χρήστης',
      username: 'newuser@example.com',
      password: 'SecurePass123!',
      dateOfBirth: '2000-01-01',
      role: Role.MEMBER,
    };

    this.userService.addUser(newUser).subscribe(() => {
      this.loadUsers(); // Επαναφόρτωση λίστας χρηστών
    });
  }

  updateUser(user: User): void {
    user.firstname += ' (upd)';
    this.userService.updateUser(user).subscribe(() => {
      this.loadUsers();
    });
  }

  deleteUser(userId: number): void {
    this.userService.deleteUser(userId).subscribe(() => {
      this.loadUsers();
    });
  }
}
