package com.d288.vikas.services;

import com.d288.vikas.entities.Cart;
import com.d288.vikas.entities.CartItem;
import com.d288.vikas.entities.Customer;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {

    private String orderTrackingNumber;

}
