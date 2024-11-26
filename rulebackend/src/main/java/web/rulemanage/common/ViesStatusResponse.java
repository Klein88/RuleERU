package web.rulemanage.common;

import java.util.List;

// ViesStatusResponse.java
public class ViesStatusResponse {


    private Vow vow;
    private List<CountryAvailability> countries;
    public Vow getVow() {
        return vow;
    }

    public void setVow(Vow vow) {
        this.vow = vow;
    }

    public List<CountryAvailability> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryAvailability> countries) {
        this.countries = countries;
    }

    public static class Vow {
        private boolean available;

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
    }

    public static class CountryAvailability {
        private String countryCode;
        private String availability;

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getAvailability() {
            return availability;
        }

        public void setAvailability(String availability) {
            this.availability = availability;
        }
    }
}
