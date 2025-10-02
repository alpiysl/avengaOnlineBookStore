package org.Utils;

import com.github.javafaker.Faker;

public class FakerDataUtil {

    static Faker faker = new Faker();

    /**
     * generates title
     */
    public static String generateTitle() {
        return faker.medical().medicineName();
    }

    /**
     * generates id
     */
    public static int generateId() {
        return (Math.abs(faker.idNumber().hashCode()) % 31) + 1; //related api returns only ids between 1-30
    }

    /**
     * generates bool
     */
    public static boolean generateBool() {
        return faker.bool().bool();
    }

    /**
     * generates first Name
     */
    public static String generateFirstName(){
        return faker.name().firstName();
    }

    /**
     * generates last Name
     */
    public static String generateLastName(){
        return faker.name().lastName();
    }

    /**
     * generates lorem texts
     */
    public static String generateLorem(Integer wordCount, Integer randomWordsToAdd) {
        return faker.lorem().sentence(wordCount, randomWordsToAdd);
    }
}
