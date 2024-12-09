import java.time.LocalDate;
import java.util.Random;

public class CPR {
    private String nummeret; // CPR nummeret som String

    public CPR() {
        // Default constructor
    }

    public CPR(String n) {
        this.nummeret = n;
    }

    public CPR(boolean generateRandom) {
        if (generateRandom) {
            this.nummeret = generateRandomCPR();
        } else {
            this.nummeret = "";
        }
    }

    public int getGender() {
        if (nummeret == null || nummeret.length() < 10) {
            throw new IllegalArgumentException("Invalid CPR number");
        }
        return Integer.parseInt(nummeret.substring(9, 10)); // Get the gender digit
    }

    public String getCprNr() {
        return nummeret;
    }

    public void setCprNr(String n) {
        this.nummeret = n;
    }

    public int getDag() {
        if (nummeret != null && nummeret.length() >= 2) {
            return Integer.parseInt(nummeret.substring(0, 2)); // Extract day
        }
        return -1; // Invalid value for day
    }

    public int getMaaned() {
        if (nummeret != null && nummeret.length() >= 4) {
            return Integer.parseInt(nummeret.substring(2, 4)); // Extract month
        }
        return -1; // Invalid value for month
    }

    public int getAar() {
        if (nummeret != null && nummeret.length() >= 6) {
            int yearPart = Integer.parseInt(nummeret.substring(4, 6)); // Extract last 2 digits of year
            int century = (yearPart < 24) ? 2000 : 1900; // Determine century
            return century + yearPart;
        }
        return -1; // Invalid year
    }

    public Dato getDato() {
        return new Dato(getDag(), getMaaned(), getAar());
    }

    public int getAlder() {
        LocalDate birthDate = LocalDate.of(getAar(), getMaaned(), getDag());
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthDate.getYear();

        if (today.getMonthValue() < birthDate.getMonthValue() ||
                (today.getMonthValue() == birthDate.getMonthValue() && today.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }

        return age;
    }

    public boolean erMand() {
        return Integer.parseInt(nummeret.substring(9, 10)) % 2 != 0;
    }

    public boolean erKvinde() {
        return !erMand();
    }

    public boolean isValid() {
        if (nummeret == null || nummeret.length() != 10) {
            return false; // Ensure it's a valid CPR number with exactly 10 digits
        }

        for (int i = 0; i < 10; i++) {
            if (nummeret.charAt(i) < '0' || nummeret.charAt(i) > '9') {
                return false; // Ensure that all characters are digits
            }
        }

        if (!getDato().valid()) {
            return false; // Validate the date of birth
        }

        int[] weights = {4, 3, 2, 7, 6, 5, 4, 3, 2, 1};
        int calculatedChecksum = 0;

        for (int i = 0; i < 10; i++) {
            calculatedChecksum += weights[i] * Integer.parseInt(String.valueOf(nummeret.charAt(i)));
        }

        return calculatedChecksum % 11 == 0; // Validates the checksum
    }

    public String toString() {
        return nummeret;
    }

    private String generateRandomCPR() {
        Random random = new Random();
        LocalDate currentDate = LocalDate.now();

        int minAge = 10;
        int maxAge = 100;

        int minYear = currentDate.getYear() - maxAge;
        int maxYear = currentDate.getYear() - minAge;

        int year = minYear + random.nextInt(maxYear - minYear + 1);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);

        String birthDate = String.format("%02d%02d%02d", day, month, year % 100);

        int randomDigits = random.nextInt(10000); // Generate 4 random digits
        String randomPart = String.format("%04d", randomDigits); // Always 4 digits

        return birthDate + "-" + randomPart; // Return the generated CPR number
    }
}
