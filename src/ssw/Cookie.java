package ssw;

class Cookie extends Confection {
    private int flourAmount;

    public Cookie(int weight, int sugar, String manufacturer, int id, int flourAmount) {
        setWeight(weight);
        setSugar(sugar);
        setManufacturer(manufacturer);
        setId(id);

        this.flourAmount = flourAmount;
    }

    public int getFlourAmount() {
        return flourAmount;
    }

    public void setFlourAmount(int flourAmount) {
        this.flourAmount = flourAmount;
    }
}
