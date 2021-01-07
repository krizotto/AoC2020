package day4;

import utils.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day4 {

    private static final String path = "src/main/resources/input_day4";

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part2() {
        System.out.println("------ PART 2 ------");
        List<String> input = Input.getInput(path, "\n");
        List<Passport> passports = getPassports(input);

        //Extended validation
        for (Passport passport : passports) {
            passport.easyValidate(); //to check nulls
            if (passport.isPassportValid()) {
                passport.extendedValidation();
            }
        }

        long count = passports.stream()
                .filter(passport -> passport.isPassportValid())
                .count();
        System.out.println("Answer: " + count);
    }

    private static void part1() {
        System.out.println("------ PART 1 ------");
        List<String> input = Input.getInput(path, "\n");
        List<Passport> passports = getPassports(input);

        //EasyValidation
        for (Passport passport : passports) {
            passport.easyValidate();
        }

        long count = passports.stream()
                .filter(passport -> passport.isPassportValid())
                .count();
        System.out.println("Answer: " + count);
    }

    private static List<Passport> getPassports(List<String> input) {
        List<Passport> possiblePassports = new ArrayList<>();
        //Get all passports
        List<String> parameters = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (!input.get(i).equals("")) {
                final String[] params = input.get(i).split(" ");
                parameters.addAll(Arrays.asList(params));
            } else {
                Passport newPassport = createPassport(parameters);
                possiblePassports.add(newPassport);
                parameters.clear();
            }
            if (i == input.size() - 1) {
                //because there is no newline in the end
                Passport newPassport = createPassport(parameters);
                possiblePassports.add(newPassport);
            }
        }
        return possiblePassports;
    }


    private static Passport createPassport(List<String> params) {
        Passport tmpPassport = new Passport();
        for (String param : params) {
            final String[] paramValue = param.split(":");
            final String key = paramValue[0];
            final String value = paramValue[1];
            switch (key) {
                case "byr":
                    tmpPassport.setBirthYear(value);
                    break;
                case "iyr":
                    tmpPassport.setIssueYear(value);
                    break;
                case "eyr":
                    tmpPassport.setExpirationYear(value);
                    break;
                case "hgt":
                    tmpPassport.setHeight(value);
                    break;
                case "hcl":
                    tmpPassport.setHairColor(value);
                    break;
                case "ecl":
                    tmpPassport.setEyeColor(value);
                    break;
                case "pid":
                    tmpPassport.setPassportId(value);
                    break;
                case "cid":
                    tmpPassport.setCountryId(value);
                    break;
            }
        }
        return tmpPassport;
    }


}
