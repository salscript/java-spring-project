package com.test.projectbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.projectbe.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

    List<Location> findByIsDelete(boolean b);

    @Query(value = "SELECT ml.name FROM m_location ml where is_delete = false", nativeQuery = true)
    List<Location> findAllData();

}
