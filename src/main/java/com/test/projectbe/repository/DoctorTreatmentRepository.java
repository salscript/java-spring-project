package com.test.projectbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.projectbe.dto.TreatmentsDTO;
import com.test.projectbe.model.DoctorTreatment;

public interface DoctorTreatmentRepository extends JpaRepository<DoctorTreatment, Long> {

    @Query(value = "SELECT DISTINCT id AS id, name AS name from t_doctor_treatment where is_delete = false", nativeQuery = true)
    List<TreatmentsDTO> findAllData();

}
