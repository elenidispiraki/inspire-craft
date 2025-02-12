import {
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class AuthInterceptorService implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let authToken: string | null = null;

    if (typeof window !== 'undefined' && window.localStorage) {
      authToken = localStorage.getItem('token');
    }
    if (!authToken) {
      return next.handle(req);
    }

    const authRequest = req.clone({
      headers: req.headers.set('Authorization', `Bearer ${authToken}`),
    });

    return next.handle(authRequest);
  }
}
