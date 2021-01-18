package day04;

import java.util.Arrays;
import java.util.List;

public class Passport {

    private String birthYear; //byr (Birth Year)
    private String issueYear; //iyr (Issue Year)
    private String expirationYear; //eyr (Expiration Year)
    private String height; //hgt (Height)
    private String hairColor; //hcl (Hair Color)
    private String eyeColor; //ecl (Eye Color)
    private String passportId; //pid (Passport ID)
    private String countryId; //cid (Country ID)
    private boolean isPassportValid;

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(String issueYear) {
        this.issueYear = issueYear;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public boolean isPassportValid() {
        return isPassportValid;
    }

    public void setPassportValid(boolean passportValid) {
        isPassportValid = passportValid;
    }

    public void easyValidate() {
        this.setPassportValid(this.getBirthYear() != null &&
                this.getIssueYear() != null &&
                this.getExpirationYear() != null &&
                this.getHeight() != null &&
                this.getHairColor() != null &&
                this.getEyeColor() != null &&
                this.getPassportId() != null);
    }

    public void extendedValidation() {
        boolean isValid;
        //check birthYear
        isValid = birthYearValidation();
        //check issueYear
        isValid &= issueYearValidation();
        //check expirationYear
        isValid &= expirationYearValidation();
        //check height
        isValid &= heightValidation();
        //check hairColor
        isValid &= hairColorValidation();
        //check eyeColor
        isValid &= eyeColorValidation();
        //check passportId
        isValid &= passportIdValidation();
        //check countryId
        this.setPassportValid(isValid);
    }

    private boolean birthYearValidation() {
        if (this.getBirthYear().length() == 4) {
            final int birth = Integer.parseInt(this.getBirthYear());
            return birth >= 1920 && birth <= 2002;
        }
        return false;
    }

    private boolean issueYearValidation() {
        if (this.getBirthYear().length() == 4) {
            final int issue = Integer.parseInt(this.getIssueYear());
            return issue >= 2010 && issue <= 2020;
        }
        return false;
    }

    private boolean expirationYearValidation() {
        if (this.getExpirationYear().length() == 4) {
            final int expiration = Integer.parseInt(this.getExpirationYear());
            return expiration >= 2020 && expiration <= 2030;
        }
        return false;
    }

    private boolean heightValidation() {
        final String hgt = this.getHeight();

        final String substring = hgt.substring(0, hgt.length() - 2);
        if (substring.equals("")) return false;
        int value = Integer.parseInt(substring);
        if (hgt.contains("cm")) {
            return value >= 150 && value <= 193;
        } else if (hgt.contains("in")) {
            return value >= 59 && value <= 76;
        }
        return false;

    }

    private boolean hairColorValidation() {
        return this.getHairColor().matches("^#(?:[0-9a-fA-F]{3}){1,2}$");
    }

    private boolean eyeColorValidation() {
        List<String> possible = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        return possible.contains(this.getEyeColor());
    }

    private boolean passportIdValidation() {
        return this.getPassportId().matches("^[0-9]{9}$");
    }
}
