package com.sistemalima.dsdelivery.product.service

import com.sistemalima.dsdelivery.handler.exceptions.DataBaseException
import com.sistemalima.dsdelivery.products.model.Product
import com.sistemalima.dsdelivery.products.repository.ProductRepository
import com.sistemalima.dsdelivery.products.service.InsertProductService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
class InsertProductServiceTest {

    @field:InjectMocks
    lateinit var insertProductService: InsertProductService

    @field:Mock
    lateinit var productRepository: ProductRepository

    @Test
    fun `deve salvar um produto`() {
        // cenario

        // ação

        //comportamento do repository
        Mockito.`when`(productRepository.save(ArgumentMatchers.any())).thenReturn(getProduct())

        //assertivas

        Assertions.assertDoesNotThrow { insertProductService.insert(getProduct()) }
        Mockito.verify(productRepository, Mockito.times(1)).save(ArgumentMatchers.any())
    }

    @Test
    fun `nao deve salvar um produto, lancar exception quando nao salvar produto, dataBaseException`() {
        // cenario

        // ação

        //comportamento do repository
        Mockito.`when`(productRepository.save(ArgumentMatchers.any())).thenThrow(DataBaseException::class.java)

        // assertivas
        Assertions.assertThrows(DataBaseException::class.java) {insertProductService.insert(getProduct())}
    }

    fun getProduct(): Product {
        return Product(
            id = 1L,
            name = "Computador",
            price = 20.0,
            description = "Um nootbook preto",
            imageUri = "image"
        )
    }
}