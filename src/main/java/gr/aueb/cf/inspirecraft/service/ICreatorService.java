package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.model.Product;
import java.util.List;


public interface ICreatorService extends IUserService {

    List<Product> getProductsByCreatorId(Long creatorId);

}
