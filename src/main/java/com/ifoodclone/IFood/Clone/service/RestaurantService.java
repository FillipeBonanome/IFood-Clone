package com.ifoodclone.IFood.Clone.service;

import com.ifoodclone.IFood.Clone.domain.address.Address;
import com.ifoodclone.IFood.Clone.domain.restaurant.Restaurant;
import com.ifoodclone.IFood.Clone.domain.user.User;
import com.ifoodclone.IFood.Clone.domain.user.UserType;
import com.ifoodclone.IFood.Clone.dto.restaurant.RestaurantRegisterDTO;
import com.ifoodclone.IFood.Clone.infra.exception.RestaurantException;
import com.ifoodclone.IFood.Clone.repository.RestaurantRepository;
import com.ifoodclone.IFood.Clone.repository.UserRepository;
import com.ifoodclone.IFood.Clone.validation.cnpj.CNPJValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    public void registerRestaurant(RestaurantRegisterDTO restaurant) throws RestaurantException {
        var owner = userRepository.getReferenceById(restaurant.ownerId());

        checkRestaurantByOwnerId(owner);
        checkRestaurantByOwnerType(owner);
        checkRestaurantByOwnerActivity(owner);
        checkRestaurantCNPJ(restaurant);

        var newRestaurant = new Restaurant(
                null,
                restaurant.name(),
                owner,
                new Address(restaurant.address()),
                restaurant.phoneNumber(),
                restaurant.category(),
                restaurant.description(),
                restaurant.CNPJ());

        restaurantRepository.save(newRestaurant);
    }

    private void checkRestaurantByOwnerId(User owner) throws RestaurantException {
        var checkRestaurant = restaurantRepository.findByOwnerId(owner.getId());
        if (checkRestaurant.isPresent()) {
            throw new RestaurantException("The owner already has a restaurant!");
        }
    }

    private void checkRestaurantByOwnerType(User owner) throws  RestaurantException {
        if (owner.getUsertype() != UserType.RESTAURANT_OWNER) {
            throw new RestaurantException("This user can't be a owner!");
        }
    }

    private void checkRestaurantByOwnerActivity(User owner) throws RestaurantException {
        if (!owner.getActive()) {
            throw new RestaurantException("This user is not active, he can't register a restaurant");
        }
    }

    private void checkRestaurantCNPJ(RestaurantRegisterDTO restaurant) throws RestaurantException {
        CNPJValidator validator = new CNPJValidator();
        validator.isValid(restaurant.CNPJ());
    }

}
