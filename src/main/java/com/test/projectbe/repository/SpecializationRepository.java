package com.test.projectbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.projectbe.model.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

    List<Specialization> findByIsDelete(boolean b);

    @Query(value = "SELECT DISTINCT id, name FROM m_specialization where is_delete = false", nativeQuery = true)
    List<Specialization> findAllData();

}
