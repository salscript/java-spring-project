package com.test.projectbe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.test.projectbe.dto.DoctorDetailDTO;
import com.test.projectbe.dto.TreatmentsDTO;
import com.test.projectbe.model.DoctorTreatment;
import com.test.projectbe.model.Location;
import com.test.projectbe.model.Specialization;
import com.test.projectbe.repository.DoctorRepository;
import com.test.projectbe.repository.DoctorTreatmentRepository;
import com.test.projectbe.repository.LocationRepository;
import com.test.projectbe.repository.SpecializationRepository;
import com.test.projectbe.utility.ApiResponse;
import com.test.projectbe.utility.ResponseUtil;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class ApiDoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private DoctorTreatmentRepository doctorTreatmentRepository;

    @GetMapping("doctor")
    public ResponseEntity<ApiResponse<List<?>>> getDoctor() {

        try {
            List<DoctorDetailDTO> listDoctor = this.doctorRepository.findDoctorDetails();
    
            if(listDoctor.isEmpty()) {
                return ResponseUtil.generateSuccessResponse("No Doctor Found", listDoctor);
            }

            List<Map<String, Object>> result = new ArrayList<>();
            for (DoctorDetailDTO item : listDoctor) {
                List<Map<String, Object>> medicalFacility = new ArrayList<>();
                Map<String, Object> doctorObj = new HashMap<>();
                Map<String, Object> medicalFacilityDetail = new HashMap<>();

                Boolean isMatch = false;
                for (Map<String, Object> arr: result) {
                    if ((Long) arr.get("id") == (Long) item.getId()) {
                        isMatch = true;

                        Integer currentPengalaman = (Integer) arr.get("pengalaman");
                        if (currentPengalaman < item.getPengalaman()) {
                            arr.put("pengalaman", item.getPengalaman());
                        }

                        String[] listTreatments = item.getTreatments().split(",");
                        medicalFacilityDetail.put("name", item.getMedicalFacilities());
                        medicalFacilityDetail.put("treatments", listTreatments);
                        medicalFacilityDetail.put("provinsi", item.getProvinsi());
                        medicalFacilityDetail.put("kota", item.getKota());
                        medicalFacilityDetail.put("kecamatan", item.getKecamatan());
                        medicalFacilityDetail.put("kelurahan", item.getKelurahan());
                        medicalFacility.add(medicalFacilityDetail);
        
                        List<Map<String, Object>> existingArr = (List<Map<String, Object>>) arr.get("medicalFacilities");
                        existingArr.add(medicalFacilityDetail);
                        break;
                    }
                }

                if (!isMatch) {
                    doctorObj.put("id", item.getId());
                    doctorObj.put("fullName", item.getFullName());
                    doctorObj.put("spesialis", item.getSpecialization());
                    doctorObj.put("pengalaman", item.getPengalaman());
                    
                    String[] listTreatments = item.getTreatments().split(",");
                    medicalFacilityDetail.put("name", item.getMedicalFacilities());
                    medicalFacilityDetail.put("treatments", listTreatments);
                    medicalFacilityDetail.put("provinsi", item.getProvinsi());
                    medicalFacilityDetail.put("kota", item.getKota());
                    medicalFacilityDetail.put("kecamatan", item.getKecamatan());
                    medicalFacilityDetail.put("kelurahan", item.getKelurahan());
                    medicalFacility.add(medicalFacilityDetail);
    
                    doctorObj.put("medicalFacilities", medicalFacility);
                    
                    result.add(doctorObj);
                }
            }
    
            return ResponseUtil.generateSuccessResponse("Doctor Retrieved Successfully", result, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.generateErrorResponse("Failed to Retrieved Doctor", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("doctor/getAllData")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAllData() {

        try {
            // List<Map<String, Object>> arrData = new ArrayList<>();

            // List<Location> listLocations = this.locationRepository.findAllData();
            // List<Specialization> listSpecializations = this.specializationRepository.findAllData();
            List<TreatmentsDTO> listDoctorTreatments = this.doctorTreatmentRepository.findAllData();

            Map<String, Object> map = new HashMap<>();
            // map.put("locations", listLocations);
            // map.put("specializations", listSpecializations);
            map.put("treatments", listDoctorTreatments);

            // arrData.add(map);

            if (map.isEmpty()) {
                return ResponseUtil.generateSuccessResponse("No Data Found", map);
            }

            return ResponseUtil.generateSuccessResponse("List Data Retrieved Successfully", map);

        } catch (Exception e) {
            return ResponseUtil.generateErrorResponse("Failed to Retrieved Data", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
