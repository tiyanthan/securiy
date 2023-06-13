package com.defect.tracker.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.defect.tracker.entities.Defect;
import com.defect.tracker.entities.DefectStatus;
import com.defect.tracker.entities.DefectType;
import com.defect.tracker.entities.Module;
import com.defect.tracker.entities.Priority;
import com.defect.tracker.entities.Project;
import com.defect.tracker.entities.ProjectAllocation;
import com.defect.tracker.entities.Release;
import com.defect.tracker.entities.Severity;
import com.defect.tracker.entities.SubModule;
import com.defect.tracker.repositories.DefectRepository;
import com.defect.tracker.resquest.dto.DefectRequest;
import com.defect.tracker.service.DefectService;

@Service
public class DefectServiceImpl implements DefectService {
  @Autowired
  private DefectRepository defectRepository;

  @Override
  public boolean existsByRelease(Long releaseId) {
    return defectRepository.existsByReleaseId(releaseId);
  }

  @Override
  public boolean existsBySeverity(Long severityId) {
    return defectRepository.existsBySeverityId(severityId);
  }

  @Override
  public boolean existsByDefectType(Long typeId) {
    return defectRepository.existsByTypeId(typeId);
  }

  @Override
  public boolean existsByDefectStatus(Long statusId) {
    return defectRepository.existsByStatusId(statusId);
  }

  @Override
  public boolean existsByPriority(Long priorityid) {
    return defectRepository.existsByPriorityId(priorityid);
  }

  // new
  @Override
  public boolean existByDefect(String defectcode) {
    return defectRepository.existsByCodeIgnoreCase(defectcode);
  }

  //// crud_operations

  public void saveDefect(DefectRequest defectRequest) {
    Defect defect = new Defect();
    BeanUtils.copyProperties(defectRequest, defect);

    Release release = new Release();
    release.setId(defectRequest.getReleaseId());
    defect.setRelease(release);

    DefectType defectType = new DefectType();
    defectType.setId(defectRequest.getDefectTypeId());
    defect.setType(defectType);

    Severity severity = new Severity();
    severity.setId(defectRequest.getSeverityId());
    defect.setSeverity(severity);

    Priority priority = new Priority();
    priority.setId(defectRequest.getPriorityId());
    defect.setPriority(priority);

    DefectStatus defectStatus = new DefectStatus();
    defectStatus.setId(defectRequest.getDefectStatusId());
    defect.setStatus(defectStatus);

    ProjectAllocation projectAllocation = new ProjectAllocation();
    projectAllocation.setId(defectRequest.getProjectAllocationId());
    defect.setAssignTo(projectAllocation);

    Project project = new Project();
    project.setId(defectRequest.getProjectId());
    defect.setProject(project);

    Module module =new Module();
    module.setId(defectRequest.getModuleId());
    defect.setModule(module);

    SubModule subModule = new SubModule();
    subModule.setId(defectRequest.getSubModuleId());
    defect.setSubModule(subModule);
    
    defectRepository.save(defect);
  }
  @Override
  public boolean existsBySubModule(Long subModuleId) {
    return defectRepository.existsBySubModuleId(subModuleId);
  }
}
