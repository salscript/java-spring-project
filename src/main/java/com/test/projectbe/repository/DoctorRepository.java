package com.test.projectbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.projectbe.dto.DoctorDetailDTO;
import com.test.projectbe.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

    @Query(value = """
        SELECT 
            d.id AS id, 
            b.full_name AS fullName,
            EXTRACT(YEAR FROM COALESCE(dof.end_date, CURRENT_DATE)) - EXTRACT(YEAR FROM dof.start_date) AS pengalaman,
            mfc.name || ' ' || mf.name AS medicalFacilities,
            l1.name AS kelurahan,
            l2.name AS kecamatan,
            l3.name AS kota,
            l4.name AS provinsi,
            STRING_AGG(DISTINCT dt.name, ',') AS treatments,
            ms.name AS specialization
        FROM m_doctor d
        JOIN m_biodata b ON d.biodata_id = b.id
        JOIN t_doctor_office dof ON d.id = dof.doctor_id
        JOIN m_medical_facility mf ON dof.medical_facility_id = mf.id
        JOIN m_medical_facility_category mfc ON mf.medical_facility_category_id = mfc.id
        JOIN t_current_doctor_specialization tcds on tcds.doctor_id = d.id 
        JOIN m_specialization ms on tcds.specialization_id = ms.id
        LEFT JOIN m_location l1 ON mf.location_id = l1.id
        LEFT JOIN m_location l2 ON l1.parent_id = l2.id
        LEFT JOIN m_location l3 ON l2.parent_id = l3.id
        LEFT JOIN m_location l4 ON l3.parent_id = l4.id
        LEFT JOIN t_doctor_treatment dt ON d.id = dt.doctor_id
        JOIN t_doctor_office_treatment dot ON dot.doctor_treatment_id = dt.id AND dot.doctor_office_id = dof.id
        WHERE d.is_delete = false
        GROUP BY d.id, b.full_name, dof.end_date, dof.start_date, l1.name, l2.name, l3.name, l4.name, mfc.name || ' ' || mf.name, ms.name;
    """, nativeQuery = true)
    List<DoctorDetailDTO> findDoctorDetails();

}
