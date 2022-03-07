package itmo.coursework.exception;

import org.jetbrains.annotations.NotNull;

public class FeedNotFoundException extends CourseWorkException {
    public FeedNotFoundException(@NotNull String message) {
        super(message);
    }
}
