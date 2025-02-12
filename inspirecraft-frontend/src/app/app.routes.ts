import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ProductsComponent } from './pages/products/products.component';
import { ProductDetailComponent } from './pages/product-detail/product-detail.component';
import { CreatorProfileComponent } from './pages/creator-profile/creator-profile.component';
import { UserProfileComponent } from './pages/user-profile/user-profile.component';
import { UserSettingsComponent } from './pages/user-settings/user-settings.component';
import { RegisterComponent } from './pages/register/register.component';
import { LoginComponent } from './pages/login/login.component';
import { SuccessComponent } from './pages/success/success.component';
import { UserManagementComponent } from './pages/user-management/user-management.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'products', component: ProductsComponent },
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'creator', component: CreatorProfileComponent },
  { path: 'profile', component: UserProfileComponent },
  { path: 'settings', component: UserSettingsComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'success', component: SuccessComponent },
  { path: 'users-managment', component: UserManagementComponent },
];
