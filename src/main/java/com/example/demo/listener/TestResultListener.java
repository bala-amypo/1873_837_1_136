package com.example.demo.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Listener to simulate test result logging or any startup actions.
 * This is a simple, test-safe implementation.
 */
@Component
public class TestResultListener {

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("[TestResultListener] Application context refreshed. Ready for tests.");
    }
}
