package com.sistemalima.dsdelivery.products.repository

import com.sistemalima.dsdelivery.products.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {
}