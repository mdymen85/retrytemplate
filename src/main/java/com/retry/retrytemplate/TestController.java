package com.retry.retrytemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestRetryTemplateService testRetryTemplateService;

    @PostMapping(path = "/v1/test")
    public ResponseEntity<Void> test() {
        log.info("Testing Controller !!");
        this.testRetryTemplateService.retryTemplateTest();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
