package ssw;


public class Main {

    public static void main(String[] args) {
        NewYearGift newYearGift = new NewYearGift();
        newYearGift.init();
        newYearGift.print();
        newYearGift.sortByWeight();
        newYearGift.commit();

        Candy candy = newYearGift.getCandybySugarAmountRange(1, 3);
        if (candy != null)
            System.out.println(candy.getId());
    }
}
