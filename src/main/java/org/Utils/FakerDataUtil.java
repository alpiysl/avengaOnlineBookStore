package org.Utils;

import com.github.javafaker.Faker;

public class FakerDataUtil {

    static Faker faker = new Faker();

    public static String generateTitle() {
        return faker.medical().medicineName();
    }

    public static int generateId() {
        return (Math.abs(faker.idNumber().hashCode()) % 31) + 1; //related api returns only ids between 1-30
    }

    public static boolean generateBool() {
        return faker.bool().bool();
    }
}
