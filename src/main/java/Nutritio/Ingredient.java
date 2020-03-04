package Nutritio;

class Ingredient implements Comparable {

    private String name;
    private String amount;
    private String unit;
    private String imageURL;

    public Ingredient(String name, String amount, String unit, String imageURL) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return name + ": " + amount + " " + unit;
    }

    @Override
    public int compareTo(Object oth) {
        Recipe other = (Recipe) oth;
        return name.compareTo(other.getName());
    }

}