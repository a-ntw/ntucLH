package com.ntuc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.ntuc.model.Category;
import com.ntuc.repository.CategoryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryRepositorTestDatabase {
	
	@Autowired
	private CategoryRepository repo;
	
	@Test
	public void testCategory() {
	Category savedCategory = 	repo.save(new Category("Televisions"));
		assertThat(savedCategory.getId()).isGreaterThan(0);
		
	}
	

}
