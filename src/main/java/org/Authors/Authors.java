package org.Authors;

import java.util.Map;

public class Authors {

    public static Map<String, Object> updateAndReturnMap(int id, int idBook, String firstName, String lastName) {
        return Map.of(
                "id", id,
                "idBook", idBook,
                "firstName", firstName,
                "lastName", lastName
        );
    }
}
