package com.sistemalima.dsdelivery.products.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_product")
class Product(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,
    val name: String,
    val price: Double,
    val description: String,
    val imageUri: String
){

    override fun toString(): String {
        return "Product(id=$id, name='$name', price=$price, description='$description', imageUri='$imageUri')"
    }
}
