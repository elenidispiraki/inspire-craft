import { User } from './user';

export interface Creator {
  id: number;
  uuid: string;
  products?: Product[]; // Προϊόντα που έχει ο Creator
  user: User;
}

export interface Product {
  id: number;
  name: string;
  description: string;
  imageUrl: string;
  creatorId: number; // Σύνδεση με τον Creator
}
