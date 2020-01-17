package de.kevinjoanreiss.joansshop.joans.shop.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserOrder {

    @Id
    private long userOrderId;
}
