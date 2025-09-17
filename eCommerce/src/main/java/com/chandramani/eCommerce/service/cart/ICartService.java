package com.chandramani.eCommerce.service.cart;

import com.chandramani.eCommerce.model.Cart;
import com.chandramani.eCommerce.model.User;

import java.math.BigDecimal;

public interface ICartService {

    Cart getCart(Long Id);
    void clearCart(Long Id);
    BigDecimal getTotalPrice(Long Id);

    Cart initializeNewCart(User userId);

    Cart getCartByUserId(Long userId);


}
