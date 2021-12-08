package com.sistemalima.dsdelivery.products.service

import com.sistemalima.dsdelivery.handler.exceptions.DataBaseException
import com.sistemalima.dsdelivery.products.model.Product
import com.sistemalima.dsdelivery.products.repository.ProductRepository
import com.sistemalima.dsdelivery.products.response.InsertProductResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InsertProductService(
    @field:Autowired val productRepository: ProductRepository
) {

    @Transactional
    fun insert(product: Product): InsertProductResponse {

        try {
            productRepository.save(product)
            val response = InsertProductResponse(product)
            return response
        }catch (erro: Exception) {
            throw DataBaseException("Error ao salvar os dados")
        }
    }
}