import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CreatorService } from '../../services/creator/creator.service';
import { Creator } from '../../interfaces/creator';
import { Product } from '../../interfaces/product';
import { User } from '../../interfaces/user';
import { Role } from '../../interfaces/role.enum';

@Component({
  selector: 'app-creator-profile',
  templateUrl: './creator-profile.component.html',
  styleUrls: ['./creator-profile.component.css'],
})
export class CreatorProfileComponent implements OnInit {
  products: Product[] = [];
  creator: Creator = {
    id: 0,
    uuid: '',
    user: {
      id: 0,
      dateOfBirth: '',
      firstname: '',
      lastname: '',
      username: '',
      password: '',
      role: Role.MEMBER,
    },
    products: [],
  };

  constructor(
    private creatorService: CreatorService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // Παίρνουμε το ID του creator από το route
    const creatorId = Number(this.route.snapshot.paramMap.get('id'));

    // Φορτώνουμε τα δεδομένα του Creator
    this.creatorService.getCreator(creatorId).subscribe((creatorData) => {
      this.creator = creatorData;
    });

    // Φορτώνουμε τα προϊόντα του Creator
    this.creatorService
      .getProductsByCreatorId(creatorId)
      .subscribe((productsData) => {
        this.products = productsData;
      });
  }
}
