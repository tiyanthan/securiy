package com.defect.tracker.resquest.dto;

import lombok.Data;

@Data
public class DefectRequest {
  private String code;
  private String stepToRecreate;
  private String describtion;
  private Long releaseId;
  private Long defectTypeId;
  private Long severityId;
  private Long priorityId;
  private Long defectStatusId;
  private Long projectAllocationId;
  private Long projectId;
  private Long subModuleId;
  private Long moduleId;
}
