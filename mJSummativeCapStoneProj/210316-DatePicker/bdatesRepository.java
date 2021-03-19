package com.ntuc;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bdatesRepository extends JpaRepository<Blockdate, LocalDate> {

}
