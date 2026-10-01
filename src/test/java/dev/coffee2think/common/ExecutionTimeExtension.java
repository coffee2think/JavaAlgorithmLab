package dev.coffee2think.common;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ExecutionTimeExtension
        implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private long startTime;

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        startTime = System.nanoTime();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        long elapsed = System.nanoTime() - startTime;

        System.out.printf(
                "%s: %.3f ms%n",
                context.getDisplayName(),
                elapsed / 1_000_000.0
        );
    }
}
