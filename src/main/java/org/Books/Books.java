package org.Books;

import java.util.Map;

public class Books {

    public static Map<String, Object> updateAndReturnMap(int id, String title, String description, int pageCount,String excerpt,String publishDate) {
        return Map.of(
                "id", id,
                "title", title,
                "description", description,
                "pageCount", pageCount,
                "excerpt",excerpt,
                "publishDate",publishDate
        );
    }
}
