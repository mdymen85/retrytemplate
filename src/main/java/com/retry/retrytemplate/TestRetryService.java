package com.retry.retrytemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestRetryService {

    private static Integer RETRY = 0;

//    @Retryable(maxAttempts = 3, retryFor = TestRetryException.class)
    public void testRetry() {
        try {
            log.info("Retry {}", RETRY);
            RETRY++;
            throw new Exception();
        }
        catch (Exception e) {
            throw new TestRetryException();
        }
    }

}
