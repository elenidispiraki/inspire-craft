import { Creator } from './creator';
import { Role } from './role.enum'; // Αν υπάρχει enum ή τύπος για το Role

export interface User {
  id: number;
  username: string;
  password: string;
  firstname: string;
  lastname: string;
  dateOfBirth: string; // Χρησιμοποιούμε string για την ημερομηνία (ISO string π.χ. "YYYY-MM-DD")
  role: Role;
  creator?: Creator; // Εάν υπάρχει creator για τον χρήστη
}
