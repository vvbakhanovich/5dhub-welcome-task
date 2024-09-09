package com.vvbakh.userservice.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(Map<String, String> errors,
                            Integer status,
                            LocalDateTime timestamp) {
}
