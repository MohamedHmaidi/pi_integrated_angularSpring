import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm = {
    email: '',
    password: ''
  };

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void { }

  submitForm() {
    this.authService.login(this.loginForm).subscribe({
      next: (response) => {
        console.log('Login successful: ', response);

        // Store sensitive authorization information securely (Explore SessionStorage or Secure Cookies)
        localStorage.setItem('access_token', response.access_token);

        this.authService.storeCurrentUser({ 
          userId: response.user_id,
          firstName: response.first_name,
          lastName: response.last_name,
          email: response.email,
          role: response.role // Assuming your backend returns the user's role
        });

        this.redirectBasedOnRole();
      },
      error: (error) => {
        console.error("Login Error: ", error);
        // Handle the error appropriately (e.g., display an error message to the user)
      }
    });
  }

  redirectBasedOnRole() {
    const user = this.authService.getCurrentUser();
    if (!user) return; // Check if user retrieved successfully

    switch(user.role) {
      case 'ADMIN':
        this.router.navigate(['/admin']);
        break;
      case 'USER':
        this.router.navigate(['/profile']); 
        break; 
      default: 
        this.router.navigate(['/']); // Default landing page
    }
  }
}