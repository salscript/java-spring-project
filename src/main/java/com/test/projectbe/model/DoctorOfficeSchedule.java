package com.test.projectbe.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_doctor_office_schedule")
public class DoctorOfficeSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "medical_facility_schedule_id")
    private Long medicalFacilityScheduleId;

    @Column(name = "slot")
    private int slot;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "deleted_by")
    private Long deletedBy;

    @Column(name = "deleted_on")
    private Date deletedOn;

    @Column(name = "is_delete")
    private Boolean isDelete = false;

    @ManyToOne 
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "medical_faciity_schedule_id", insertable = false, updatable = false)
    private MedicalFacilitySchedule medicalFacilitySchedule;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id", insertable = false, updatable = false)
    private User userCreatedBy;

    @ManyToOne
    @JoinColumn(name = "modified_by", referencedColumnName = "id", insertable = false, updatable = false)
    private User userModifiedBy;

    @ManyToOne
    @JoinColumn(name = "deleted_by", referencedColumnName = "id", insertable = false, updatable = false)
    private User userDeletedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getMedicalFacilityScheduleId() {
        return medicalFacilityScheduleId;
    }

    public void setMedicalFacilityScheduleId(Long medicalFacilityScheduleId) {
        this.medicalFacilityScheduleId = medicalFacilityScheduleId;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(Date deletedOn) {
        this.deletedOn = deletedOn;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public MedicalFacilitySchedule getMedicalFacilitySchedule() {
        return medicalFacilitySchedule;
    }

    public void setMedicalFacilitySchedule(MedicalFacilitySchedule medicalFacilitySchedule) {
        this.medicalFacilitySchedule = medicalFacilitySchedule;
    }

    public User getUserCreatedBy() {
        return userCreatedBy;
    }

    public void setUserCreatedBy(User userCreatedBy) {
        this.userCreatedBy = userCreatedBy;
    }

    public User getUserModifiedBy() {
        return userModifiedBy;
    }

    public void setUserModifiedBy(User userModifiedBy) {
        this.userModifiedBy = userModifiedBy;
    }

    public User getUserDeletedBy() {
        return userDeletedBy;
    }

    public void setUserDeletedBy(User userDeletedBy) {
        this.userDeletedBy = userDeletedBy;
    }
}
