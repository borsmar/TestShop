package com.testshop.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String paymentType;

    @Column
    String deliveryType;

    @Column
    String paymentStatus;

    @Column
    String orderStatus;

    @ManyToMany
    List<Goods> goods;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

  //  @ManyToOne
   // @JoinColumn(name = "user_id")
  //  private User user;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", PaymentType='" + paymentType + '\'' +
                ", DeliveryType='" + deliveryType + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", goods=" + goods +
                ", address=" + address +
           //     ", user=" + user +
                '}';
    }

}
