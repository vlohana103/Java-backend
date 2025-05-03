package com.d288.vikas.services;

import com.d288.vikas.dao.CartRepository;
import com.d288.vikas.entities.Cart;
import com.d288.vikas.entities.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

import static com.d288.vikas.entities.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements CheckoutService {


    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;

    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {


        // retrieve the cart info from dto
        Cart cart = purchase.getCart();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);


        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));


        cart.setStatus(ordered);
        cartRepository.save(cart);

        // return a response
        if (cartItems.isEmpty()) {
            return new PurchaseResponse("Cart is Empty");
        } else {
            return new PurchaseResponse(orderTrackingNumber);
        }
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number
        return UUID.randomUUID().toString();

    }
}
