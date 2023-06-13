package com.defect.tracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.defect.tracker.common.response.BaseResponse;
import com.defect.tracker.resquest.dto.DefectRequest;
import com.defect.tracker.rest.enums.RequestStatus;
import com.defect.tracker.service.DefectService;
import com.defect.tracker.utils.EndpointURI;
import com.defect.tracker.utils.ValidationFailureResponseCode;

@RestController
public class DefectController {
  @Autowired
  private DefectService defectService;
  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;
  private static final Logger logger = LoggerFactory.getLogger(DefectController.class);

  @PostMapping(value = EndpointURI.DEFECT)
  public ResponseEntity<Object> saveDefect(@RequestBody DefectRequest defectRequest) {
    if (defectService.existByDefect(defectRequest.getCode())) {
      logger.info("Defect already exists");
      return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
          validationFailureResponseCode.getDefectAlreadyExists(),
          validationFailureResponseCode.getValidationDefectAlreadyExists()));
    }
    logger.info("Defect Added successfully");
    defectService.saveDefect(defectRequest);
    return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
        validationFailureResponseCode.getCommonSuccessCode(),
        validationFailureResponseCode.getSaveDefectSuccessMessage()));
  }


}
