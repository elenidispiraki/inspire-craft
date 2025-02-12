import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Product } from '../../interfaces/product';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../services/product/product.service';

@Component({
  selector: 'app-products',
  standalone: true,
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
  imports: [FormsModule],
})
export class ProductsComponent {
  // products = [
  //   {
  //     id: 1,
  //     name: 'DIY Jewelry Stand',
  //     description:
  //       'A stylish and functional jewelry stand to organize your accessories!',
  //     imageUrl: 'diy-jewelry-stand.jpg',
  //     creator: '',
  //   },
  //   {
  //     id: 2,
  //     name: 'Ξύλινο Ρολόι',
  //     description: 'Κομψό ξύλινο ρολόι, ιδανικό για κάθε περίσταση.',
  //     imageUrl: 'phone-case.jpg',
  //     creator: '',
  //   },
  //   {
  //     id: 3,
  //     name: 'Μαρμάρινο Διακοσμητικό',
  //     description: 'Minimal διακοσμητικό από μάρμαρο για τον χώρο σας.',
  //     imageUrl: 'embroidered-pendant.jpg',
  //     creator: '',
  //   },
  // ];

  products: any[] = [];
  newProduct = { name: '', description: '', imageUrl: '', creatorId: 0 };
  showForm = false;

  constructor(private productService: ProductService) {}

  // showForm = false; // Ελέγχει αν θα εμφανίζεται η φόρμα
  // newProduct: Product = {
  //   id: 0,
  //   name: '',
  //   description: '',
  //   imageUrl: '',
  //   creatorId: 0,
  // };

  toggleForm() {
    this.showForm = !this.showForm;
    // this.newProduct = {
    //   id: 0,
    //   name: '',
    //   description: '',
    //   imageUrl: '',
    //   creatorId: 0,
    // };
  }

  // addProduct() {
  //   if (
  //     this.newProduct.name &&
  //     this.newProduct.description &&
  //     this.newProduct.imageUrl
  //   ) {
  //     this.newProduct.id = this.products.length + 1;
  //     this.products.push({
  //       ...this.newProduct,
  //       creator: '',
  //     });
  //     this.toggleForm(); // Απόκρυψη φόρμας μετά την προσθήκη
  //   } else {
  //     alert('Συμπληρώστε όλα τα πεδία!');
  //   }
  // }

  addProduct() {
    // if (!this.newProduct.imageUrl) {
    //   this.newProduct.imageUrl = null; // Αν δεν έχει δώσει εικόνα, ορίζουμε το πεδίο ως null
    // }
    this.productService.addProduct(this.newProduct).subscribe((response) => {
      this.products.push(response); // Ενημέρωση της λίστας προϊόντων
      this.toggleForm(); // Κλείσιμο της φόρμας
    });
  }

  // updateProduct(id: number) {
  //   const product = this.products.find((p) => p.id === id);
  //   if (product) {
  //     product.name =
  //       prompt('Εισάγετε νέο όνομα:', product.name) || product.name;
  //     product.description =
  //       prompt('Εισάγετε νέα περιγραφή:', product.description) ||
  //       product.description;
  //   }
  // }

  updateProduct(id: number) {
    const updatedProduct = {
      name: 'Updated Name',
      description: 'Updated Description',
    }; // Χρησιμοποίησε τα δεδομένα σου
    this.productService
      .updateProduct(id, updatedProduct)
      .subscribe((response) => {
        // Ενημέρωση της λίστας με το νέο προϊόν
      });
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
      this.products = this.products.filter((product) => product.id !== id);
    });
  }

  // deleteProduct(id: number) {
  //   this.products = this.products.filter((p) => p.id !== id);
  // }
}
