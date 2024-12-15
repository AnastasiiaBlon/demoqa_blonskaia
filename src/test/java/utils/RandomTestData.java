package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomTestData {
    private String firstName;
    private String lastName;
    private String gender;
    private String userEmail;
    private String userPhone;
    private String yearOfBirth;
    private String monthOfBirth;
    private String dayOfBirth;
    private String subject;
    private String hobby;
    private String picture;
    private String streetAddress;
    private String state;
    private String city;

    Faker faker = new Faker(new Locale("en-GB"));
    public String getFirstName() {
        firstName = faker.name().firstName();
        return firstName;
    }
    public String getLastName() {
        lastName = faker.name().lastName();
        return lastName;
    }
    public String getGender() {
        gender = faker.options().option("Male", "Female", "Other");
        return gender;
    }
    public String getUserEmail() {
        userEmail = faker.internet().emailAddress();
        return userEmail;
    }
    public String getUserPhone() {
        userPhone = faker.number().digits(10);
        return userPhone;
    }
    public String getYearOfBirth() {
        yearOfBirth = String.format("%s", faker.number().numberBetween(1920, 2024));
        return yearOfBirth;
    }
    public String getMonthOfBirth() {
        monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December");
        return monthOfBirth;
    }
    public String getDayOfBirth() {
        dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28));
        return dayOfBirth;
    }
    public String getSubject() {
        subject = faker.options().option("Accounting", "Arts", "Biology",
                "Chemistry", "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi",
                "History", "Maths", "Physics", "Social Studies");
        return subject;
    }
    public String getHobby() {
        hobby = faker.options().option("Sports", "Reading", "Music");
        return hobby;
    }
    public String getPicture() {
        picture = faker.options().option("ams.jpg", "amsNew.jpg");
        return picture;
    }
    public String getStreetAddress() {
        streetAddress = faker.address().streetAddress();
        return streetAddress;
    }
    public String getState() {
        state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        return state;
    }
    public String getCity() {
        city = getRandomCity(state);

        return city;
    }

    public String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipat");

            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");

            default:
                return null;
        }
    }
}
