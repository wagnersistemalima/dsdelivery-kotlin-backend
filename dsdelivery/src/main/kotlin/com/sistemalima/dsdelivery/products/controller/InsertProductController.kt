package com.sistemalima.dsdelivery.products.controller

import com.sistemalima.dsdelivery.products.request.InsertProductRequest
import com.sistemalima.dsdelivery.products.response.InsertProductResponse
import com.sistemalima.dsdelivery.products.service.InsertProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@Validated
@RestController
@RequestMapping("/api/products")
class InsertProductController(
    @field:Autowired val insertProductService: InsertProductService
) {

    @PostMapping
    fun insert(@Valid @RequestBody request: InsertProductRequest): ResponseEntity<InsertProductResponse> {
        val product = request.toModel()
        val response = insertProductService.insert(product)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(response.id).toUri()

        return ResponseEntity.created(uri).body(response)
    }
}
