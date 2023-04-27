package com.VendingMachine.VendingMachine01.model;


import com.VendingMachine.VendingMachine01.dto.InventoryDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table
public  class Inventry implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    private   int productId;
    @NotBlank
    @Column
    private  String name;
    @NotNull
    @Column
    private  int productPrice;
    @NotNull
    @Column
    private  int productInventryCount;

    @Override
    public String toString() {
        return "Inventry{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", productPrice=" + productPrice +
                ", productInventryCount=" + productInventryCount +
                '}';
    }

    public Inventry(int productId, String name, int productPrice, int productInventryCount) {
        this.productId = productId;
        this.name = name;
        this.productPrice = productPrice;
        this.productInventryCount = productInventryCount;
    }

//    public Inventry(Inventry.InventoryBuilder inventoryDTOBuilder) {
//        this.productId = inventoryDTOBuilder.productId;
//        this.name = inventoryDTOBuilder.name;
//        this.productPrice = inventoryDTOBuilder.productPrice;
//        this.productInventryCount = inventoryDTOBuilder.productInventryCount;
//    }

//    public static Inventry.InventoryBuilder builder(){
//        return new Inventry.InventoryBuilder();
//    }

    public Inventry() {
    }

    public int getProductId() {
        return productId;
    }


    public  String getName() {
        return name;
    }

    public  int getProductPrice() {
        return productPrice;
    }


    public  int getProductInventryCount() {
        return productInventryCount;
    }



    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductInventryCount(int productInventryCount) {
        this.productInventryCount = productInventryCount;
    }

//
//    public static class InventoryBuilder {
//        private  int productId;
//        private  String name;
//        private  int productPrice;
//        private  int productInventryCount;
//
//        public InventoryBuilder() {
//        }
//
//        public Inventry.InventoryBuilder productId(int productId) {
//            this.productId = productId;
//            return this;
//        }
//
//        public Inventry.InventoryBuilder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Inventry.InventoryBuilder productPrice(int productPrice) {
//            this.productPrice = productPrice;
//            return this;
//        }
//        public Inventry.InventoryBuilder productInventryCount(int productInventryCount) {
//            this.productInventryCount = productInventryCount;
//            return this;
//        }
//        public Inventry build() {
//            return new Inventry(this);
//        }
//
//    }

}
