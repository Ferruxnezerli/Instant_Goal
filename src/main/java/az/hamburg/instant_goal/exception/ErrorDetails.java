package az.hamburg.instant_goal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorDetails {
    String message;
    LocalDateTime timeStamp;
}
