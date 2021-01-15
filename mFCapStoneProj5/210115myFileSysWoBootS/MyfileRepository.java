package com.cp5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyfileRepository extends JpaRepository<Myfile, Long> {

}
