package com.test.projectbe.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_medical_facility_schedule")
public class MedicalFacilitySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "medical_facility_id")
    private Long medicalFacilityId;

    @Column(name = "day", length = 10)
    private String day;

    @Column(name = "time_schedule_start", length = 10)
    private String timeScheduleStart;

    @Column(name = "time_schedule_end", length = 10)
    private String timeScheduleEnd;

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
    
    @OneToMany(mappedBy = "medicalFacilitySchedule") 
    Set<DoctorOfficeSchedule> doctorOfficeSchedules;

    @ManyToOne
    @JoinColumn(name = "medical_facility_id", insertable = false, updatable = false)
    private MedicalFacility medicalFacility;

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

    public Long getMedicalFacilityId() {
        return medicalFacilityId;
    }

    public void setMedicalFacilityId(Long medicalFacilityId) {
        this.medicalFacilityId = medicalFacilityId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeScheduleStart() {
        return timeScheduleStart;
    }

    public void setTimeScheduleStart(String timeScheduleStart) {
        this.timeScheduleStart = timeScheduleStart;
    }

    public String getTimeScheduleEnd() {
        return timeScheduleEnd;
    }

    public void setTimeScheduleEnd(String timeScheduleEnd) {
        this.timeScheduleEnd = timeScheduleEnd;
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

    public MedicalFacility getMedicalFacility() {
        return medicalFacility;
    }

    public void setMedicalFacility(MedicalFacility medicalFacility) {
        this.medicalFacility = medicalFacility;
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
