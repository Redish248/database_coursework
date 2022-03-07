package itmo.coursework.exception;

import org.jetbrains.annotations.NotNull;

public class ObjectNotFoundException extends CourseWorkException{
    public ObjectNotFoundException(@NotNull String message) {
        super(message);
    }
}
