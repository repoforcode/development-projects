/**
 * 
 */
package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Product;

/**
 * @author Sujeet Sharma
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
}
