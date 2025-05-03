package com.d288.vikas.services;

import com.d288.vikas.entities.Cart;
import com.d288.vikas.entities.CartItem;
import com.d288.vikas.entities.Customer;
import java.util.Set;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
