package com.retry.retrytemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestRetryTemplateService {

    private final RetryTemplate retryTemplate;
    private final TestRetryService testRetryService;

    public String retryTemplateTest() {

        return retryTemplate.execute(context -> {
            log.info("Processando tentativa numero {}", context.getRetryCount());
            this.testRetryService.testRetry();
            return "Processed data: ";
        }, context -> {
            // Optional recovery callback in case of retries not working
            System.out.println("Retrying operation failed! Attempt: " + context.getRetryCount());
            return null;
        });

    }

}
