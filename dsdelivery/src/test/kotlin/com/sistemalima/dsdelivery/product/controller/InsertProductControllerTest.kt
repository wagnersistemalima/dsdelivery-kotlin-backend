package com.sistemalima.dsdelivery.product.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.sistemalima.dsdelivery.products.request.InsertProductRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.Transactional
import java.net.URI

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
@ActiveProfiles("test")
@Transactional
class InsertProductControllerTest {

    @field:Autowired
    lateinit var mockMvc: MockMvc

    @field:Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `deve retornar 201 created`() {
        // cenario

        val uri = URI("/api/products")

        val request = getRequestValid()

        // ação

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON).content(toJson(request)))
            .andExpect(MockMvcResultMatchers.status().`is`(201))

        // assertivas

    }

    @Test
    fun `deve retornar 400 badRequest, quando receber parametro name vazio`() {
        // cenario

        val uri = URI("/api/products")

        val request = getRequestInValidName()

        // ação

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON).content(toJson(request)))
            .andExpect(MockMvcResultMatchers.status().`is`(400))

        // assertivas

    }

    @Test
    fun `deve retornar 400 badRequest, quando receber parametro price zerado`() {
        // cenario

        val uri = URI("/api/products")

        val request = getRequestInValidPrice()

        // ação

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON).content(toJson(request)))
            .andExpect(MockMvcResultMatchers.status().`is`(400))

        // assertivas

    }

    @Test
    fun `deve retornar 400 badRequest, quando receber parametro descrição vazio`() {
        // cenario

        val uri = URI("/api/products")

        val request = getRequestInValidImage()

        // ação

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON).content(toJson(request)))
            .andExpect(MockMvcResultMatchers.status().`is`(400))

        // assertivas

    }

    @Test
    fun `deve retornar 400 badRequest, quando receber parametro image vazio`() {
        // cenario

        val uri = URI("/api/products")

        val request = getRequestInValidImage()

        // ação

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON).content(toJson(request)))
            .andExpect(MockMvcResultMatchers.status().`is`(400))

        // assertivas

    }

    private fun getRequestInValidImage(): InsertProductRequest {
        return  InsertProductRequest(
            name = "Computador",
            price = 20.0,
            description = "um computador legal",
            imageUri = ""
        )
    }

    private fun getRequestInValidDescricao(): InsertProductRequest {
        return  InsertProductRequest(
            name = "Computador",
            price = 20.0,
            description = "",
            imageUri = "image"
        )
    }

    fun toJson(request: InsertProductRequest): String {
        return objectMapper.writeValueAsString(request)
    }

    private fun getRequestValid(): InsertProductRequest {
        return  InsertProductRequest(
            name = "Computador",
            price = 20.0,
            description = "Um computador legal",
            imageUri = "image"
        )
    }

    private fun getRequestInValidName(): InsertProductRequest {
        return  InsertProductRequest(
            name = "",
            price = 20.0,
            description = "Um computador legal",
            imageUri = "image"
        )
    }

    private fun getRequestInValidPrice(): InsertProductRequest {
        return  InsertProductRequest(
            name = "Computador",
            price = 0.0,
            description = "Um computador legal",
            imageUri = "image"
        )
    }
}