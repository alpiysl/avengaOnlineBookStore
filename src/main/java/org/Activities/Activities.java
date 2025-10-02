package org.Activities;

import java.util.Map;

public class Activities{

    public static Map<String, Object> updateAndReturnMap(int id, String title, String dueDate, boolean completed) {
        return Map.of(
                "id", id,
                "title", title,
                "dueDate", dueDate,
                "completed", completed
        );
    }
}
