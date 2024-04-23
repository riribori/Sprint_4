package general;

public enum RentTerm {
    ONEDAY("сутки"),
    TWODAY("двое суток"),
    THREEDAY("трое суток"),
    FOURDAY("четверо суток"),
    FIVEDAY("пятеро суток"),
    SIXDAY("шестеро суток"),
    SEVENDAY("семеро суток");
    private final String description;

    RentTerm(String description) {
        this.description = description;
    }

    public String getDescription () {
        return description;
    }
}
