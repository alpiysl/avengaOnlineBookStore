package org.Endpoints;

public interface Endpoints {

    String prefix = "/api/";
    String version = "v1/";

    //ACTIVITIES ENDPOINTS
    String GET_ACTIVITIES = prefix + version + "Activities";
    String POST_ACTIVITIES = prefix + version + "Activities";
    String GET_SPECIFIC_ACTIVITY = prefix + version + "Activities/{id}";
    String PUT_SPECIFIC_ACTIVITY = prefix + version +  "Activities/{id}";
    String DELETE_SPECIFIC_ACTIVITY = prefix + version +  "Activities/{id}";

    //AUTHORS
    String GET_AUTHORS = prefix + version + "Authors";
    String POST_AUTHORS = prefix + version + "Authors";
    String GET_SPECIFIC_AUTHOR = prefix + version + "Authors/{id}";
    String PUT_SPECIFIC_AUTHOR = prefix + version +  "Authors/{id}";
    String DELETE_SPECIFIC_AUTHOR = prefix + version +  "Authors/{id}";

    //BOOKS
    String GET_BOOKS = prefix + version + "Books";
    String POST_BOOKS = prefix + version + "Books";
    String GET_SPECIFIC_BOOK = prefix + version + "Books/{id}";
    String PUT_SPECIFIC_BOOK = prefix + version +  "Books/{id}";
    String DELETE_SPECIFIC_BOOK = prefix + version +  "Books/{id}";
}
