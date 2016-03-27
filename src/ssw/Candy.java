package ssw;

class Candy extends Confection {
    private String color;

    public Candy(int weight, int sugar, String manufacturer, int id, String color) {
        setWeight(weight);
        setSugar(sugar);
        setManufacturer(manufacturer);
        setId(id);

        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
