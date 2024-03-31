package com.example.LabCycle05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	List<Product> list = new ArrayList<Product>();

	@GetMapping
	public List<Product> getProduct() {
		return list;
	}

	@PostMapping
	public ResponseEntity<?> insertProduct(@Valid @RequestBody Product product, BindingResult results) 
	{
		List<String> errors = new ArrayList<String>();
		if (results.hasErrors()) {
			for (FieldError error : results.getFieldErrors()) {
				errors.add(error.getField() + "  " + error.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errors);

		} else {
			list.add(product);
			return ResponseEntity.ok(list);
		}
	}

	@DeleteMapping("/{id}")
	public List<Product> deleteProduct(@PathVariable int id) {
		for (Product p : list) {
			if (id == p.getId()) {
				list.remove(p);
			}
		}
		return list;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putproduct(@PathVariable int id, @Valid @RequestBody Product updatedProduct, BindingResult result) {
	    List<String> errors = new ArrayList<String>();
	    if (result.hasErrors()) {
	        for (FieldError error : result.getFieldErrors()) {
	            errors.add(error.getField() + " " + error.getDefaultMessage());
	        }
	        return ResponseEntity.badRequest().body(errors);
	    } else {
	        boolean found = false;
	        for (Product p : list) {
	            if (p.getId() == id) {
	                p.setName(updatedProduct.getName());
	                p.setPrice(updatedProduct.getPrice());
	                found = true;
	                break; // No need to continue searching
	            }
	        }
	        if (found) {
	            return ResponseEntity.ok(list);
	        } else {
	            errors.add("Product with ID " + id + " not found");
	            return ResponseEntity.badRequest().body(errors);
	        }
	    }
	}

}