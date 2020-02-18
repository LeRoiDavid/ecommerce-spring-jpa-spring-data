package org.sid.lightecomv1.dao;

import org.sid.lightecomv1.entities.Category;
import org.sid.lightecomv1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// Spring Data

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
