package com.groupName.artifactName.code.controllers;

import com.groupName.artifactName.code.OrderRequest;
import com.groupName.artifactName.code.RecruitmentRequest;
import com.groupName.artifactName.code.service.OrderService;
import com.groupName.artifactName.code.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recruit")
public class RecruitmentController {
    private final RecruitmentService recruitmentService;

    @Autowired
    public RecruitmentController(RecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }

    @PostMapping
    public ResponseEntity<?> recruit(@RequestBody RecruitmentRequest recruitmentRequest) {
        boolean is_ok =   recruitmentService.recruit(recruitmentRequest.getFamily(),recruitmentRequest.getSoldierId());
        if (is_ok){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
