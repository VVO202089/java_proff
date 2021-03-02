package lesson7;

import java.lang.reflect.Method;

public class MethodsPriority {

    public Method method;
    private Integer priority;

    public MethodsPriority(Method method, Integer priority) {
        this.method = method;
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }
}
