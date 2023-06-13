package com.defect.tracker.response.dto;

import lombok.Data;

@Data
public class DefectResponse {
  private String code;
  private String stepToRecreate;
  private String describtion;

  private Long releaseId;
  private String releaseName;

  private Long defectTypeId;
  private String defectTypeName;

  private Long severityId;
  private String severityName;
  private String severityColor;

  private Long priorityId;
  private String priorityName;
  private String priorityColor;

  private Long defectStatusId;
  private String defectStatusName;
  private String defectStatusColor;

  private Long projectAllocationId;

  private Long projectId;
  private String projectName;
  private String projectPrefix;
  private String projectStartDate;
  private String projectEndDate;

  private Long subModuleId;
  private String subModuleName;

}
