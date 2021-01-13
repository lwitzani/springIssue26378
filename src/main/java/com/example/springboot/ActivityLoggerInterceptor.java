package com.example.springboot;


import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ActivityLoggerInterceptor implements HandlerInterceptor {
    private static final String FLAG_PRE_HANDLE_DONE = "pre-handle-done";
    private static final String FLAG_AFTER_COMPLETION_DONE = "after-completion-done";


    public ActivityLoggerInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        Boolean duplicatedCall = (Boolean) request.getAttribute(FLAG_PRE_HANDLE_DONE);
        if (duplicatedCall != null && duplicatedCall) {
            log.warn("############## DUPLICATED preHandle");
            return true;
        }

        log.warn("############## ACTUAL preHandle");
        request.setAttribute(FLAG_PRE_HANDLE_DONE, true);
        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler,
            @Nullable Exception exception
    ) throws Exception {
        Boolean duplicatedCall = (Boolean) request.getAttribute(FLAG_AFTER_COMPLETION_DONE);
        if (duplicatedCall != null && duplicatedCall) {
            log.warn("############## DUPLICATED afterCompletion");
            return;
        }

        log.warn("############## ACTUAL afterCompletion");
        request.setAttribute(FLAG_AFTER_COMPLETION_DONE, true);
    }
}
