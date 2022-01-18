package com.jumia.jpay.customers.service.core.domain;

import com.jumia.jpay.customers.service.core.application.service.customer.PhoneDto;
import com.jumia.jpay.customers.service.core.domain.validators.CustomValidator;

import javax.validation.constraints.NotEmpty;

import static com.jumia.jpay.customers.service.core.domain.Country.toCountryDto;

public class Phone {

    @NotEmpty
    private final String number;
    private final Country country;
    private final boolean isValid;

    private Phone(String number, Country country, boolean isValid) {
        this.number = number;
        this.country = country;
        this.isValid = isValid;
    }

    public static PhoneDto toPhoneDto(Phone phone) {
        return new PhoneDto(phone.getNumber(), toCountryDto(phone.getCountry()), phone.isValid());
    }

    public static Integer getCountryCodeFromPhoneNumber(String phoneNumber) {

        return phoneNumber.length() < 4 ? null : Integer.parseInt(phoneNumber.substring(1, 4));
    }

    public static String getCountryNameFromCountryCode(int code) {

        for (CountryName c : CountryName.values()) {
            if (c.getCode() == code) return c.name();
        }
        return null;
    }

    public static boolean validatePhoneNumber(String phoneNumber) {

        if (phoneNumber == null) return false;

        var code = getCountryCodeFromPhoneNumber(phoneNumber);
        if (code == null) return false;

        switch (code) {
            case 237:
                return phoneNumber.matches("\\(237\\)\\ ?[2368]\\d{7,8}$");
            case 251:
                return phoneNumber.matches("\\(251\\)\\ ?[1-59]\\d{8}$");
            case 212:
                return phoneNumber.matches("\\(212\\)\\ ?[5-9]\\d{8}$");
            case 258:
                return phoneNumber.matches("\\(258\\)\\ ?[28]\\d{7,8}$");
            case 256:
                return phoneNumber.matches("\\(256\\)\\ ?\\d{9}$");
            default:
                return false;
        }
    }

    public static Phone create(String number) {

        var country = Country.create(number);
        var isValid = validatePhoneNumber(number);
        var phone = new Phone(number, country, isValid);
        CustomValidator.validateAndThrow(phone);
        return phone;
    }

    public String getNumber() {
        return number;
    }

    public Country getCountry() {
        return country;
    }

    public boolean isValid() {
        return isValid;
    }
}
