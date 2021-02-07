/*https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html

Methods inherited from interface org.springframework.data.repository.PagingAndSortingRepository
findAll
Methods inherited from interface org.springframework.data.repository.CrudRepository
count, delete, deleteAll, deleteAll, deleteById, existsById, findById, save
Methods inherited from interface org.springframework.data.repository.query.QueryByExampleExecutor
count, exists, findAll, findOne

*/

package com.cp6.cust;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
