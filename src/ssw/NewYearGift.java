package ssw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import static java.sql.DriverManager.getConnection;

public class NewYearGift {
    private Vector<Candy> candies = new Vector<>();
    private Vector<Cookie> cookies = new Vector<>();

    private Connection conn = null;

    public NewYearGift() {
    }

    public void init() {

        try {
            conn = getConnection("jdbc:mysql://localhost:3306/ssw_lab5", "root", "5131");
            Statement st = conn.createStatement();
            ResultSet candyResultSet = st.executeQuery("SELECT * FROM candy");
            while (candyResultSet.next()) {
                int id = candyResultSet.getInt("id");
                int weight = candyResultSet.getInt("Weight");
                int sugar = candyResultSet.getInt("Sugar");
                String manufacturer = candyResultSet.getString("Manufacturer");
                String color = candyResultSet.getString("Color");
                candies.add(new Candy(weight, sugar, manufacturer, id, color));
            }
            ResultSet cookieResultSet = st.executeQuery("SELECT * FROM cookie");
            while (cookieResultSet.next()) {
                int id = cookieResultSet.getInt("id");
                int weight = cookieResultSet.getInt("Weight");
                int sugar = cookieResultSet.getInt("Sugar");
                String manufacturer = cookieResultSet.getString("Manufacturer");
                int flourAmount = cookieResultSet.getInt("FlourAmount");
                cookies.add(new Cookie(weight, sugar, manufacturer, id, flourAmount));
            }
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public void print() {
        System.out.println("Candies:");
        System.out.print(String.format("%15s", "Id"));
        System.out.print(String.format("%15s", "Weight"));
        System.out.print(String.format("%15s", "Sugar"));
        System.out.print(String.format("%15s", "Manufacturer"));
        System.out.print(String.format("%15s\n", "Color"));
        for (Candy candy : candies) {
            System.out.print(String.format("%15s", candy.getId()));
            System.out.print(String.format("%15s", candy.getWeight()));
            System.out.print(String.format("%15s", candy.getSugar()));
            System.out.print(String.format("%15s", candy.getManufacturer()));
            System.out.print(String.format("%15s\n", candy.getColor()));
        }
        System.out.println("\nCookies:");
        System.out.print(String.format("%15s", "Id"));
        System.out.print(String.format("%15s", "Weight"));
        System.out.print(String.format("%15s", "Sugar"));
        System.out.print(String.format("%15s", "Manufacturer"));
        System.out.print(String.format("%15s\n", "Color"));
        for (Cookie cookie : cookies) {
            System.out.print(String.format("%15s", cookie.getId()));
            System.out.print(String.format("%15s", cookie.getWeight()));
            System.out.print(String.format("%15s", cookie.getSugar()));
            System.out.print(String.format("%15s", cookie.getManufacturer()));
            System.out.print(String.format("%15s\n", cookie.getFlourAmount()));
        }
    }

    public int weigt() {
        int weight = 0;
        for (Candy candy : candies) weight += candy.getWeight();
        for (Cookie cookie : cookies) weight += cookie.getWeight();
        return weight;
    }
}
