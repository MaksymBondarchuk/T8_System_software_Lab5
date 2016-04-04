package ssw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.Vector;

import static java.sql.DriverManager.getConnection;

@SuppressWarnings("ALL")
class NewYearGift {
    private Vector<Candy> candies = new Vector<>();
    private Vector<Cookie> cookies = new Vector<>();

    private Connection conn = null;

    NewYearGift() {
    }

    /**
     * Reads tables from database
     */
    void init() {
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
        }
    }

    /**
     * Commits tables to database (deletes all from tables and inserts new rows)
     */
    void commit() {
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM candy;");
            for (Candy candy : candies)
                st.executeUpdate(String.format("INSERT INTO candy (Id, Weight, Sugar, Manufacturer, Color) VALUES (%d, %d, %d, '%s', '%s');", candy.getId(),
                        candy.getWeight(), candy.getSugar(), candy.getManufacturer(), candy.getColor()));

            st.executeUpdate("DELETE FROM cookie;");
            for (Cookie cookie : cookies)
                st.executeUpdate(String.format("INSERT INTO cookie (Id, Weight, Sugar, Manufacturer, FlourAmount) VALUES (%d, %d, %d, '%s', %d);", cookie.getId(),
                        cookie.getWeight(), cookie.getSugar(), cookie.getManufacturer(), cookie.getFlourAmount()));
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

    void print() {
        System.out.println("Candies:");
        System.out.print(String.format("%15s", "Id"));
        System.out.print(String.format("%15s", "Weight"));
        System.out.print(String.format("%15s", "Sugar"));
        System.out.print(String.format("%15s", "Manufacturer"));
        System.out.print(String.format("%15s\n", "Color"));
        for (Candy candy : candies) {
            System.out.print(String.format("%15d", candy.getId()));
            System.out.print(String.format("%15d", candy.getWeight()));
            System.out.print(String.format("%15d", candy.getSugar()));
            System.out.print(String.format("%15s", candy.getManufacturer()));
            System.out.print(String.format("%15s\n", candy.getColor()));
        }
        System.out.println("\nCookies:");
        System.out.print(String.format("%15s", "Id"));
        System.out.print(String.format("%15s", "Weight"));
        System.out.print(String.format("%15s", "Sugar"));
        System.out.print(String.format("%15s", "Manufacturer"));
        System.out.print(String.format("%15s\n", "FlourAmount"));
        for (Cookie cookie : cookies) {
            System.out.print(String.format("%15d", cookie.getId()));
            System.out.print(String.format("%15d", cookie.getWeight()));
            System.out.print(String.format("%15d", cookie.getSugar()));
            System.out.print(String.format("%15s", cookie.getManufacturer()));
            System.out.print(String.format("%15d\n\n", cookie.getFlourAmount()));
        }
    }

    int weigt() {
        int weight = 0;
        for (Candy candy : candies) weight += candy.getWeight();
        for (Cookie cookie : cookies) weight += cookie.getWeight();
        return weight;
    }

    void sortByWeight() {
        candies.sort(new Comparator<Candy>() {
            @Override
            public int compare(Candy a, Candy b) {
                return a.getWeight() < b.getWeight() ? -1 : a.getWeight() == b.getWeight() ? 0 : 1;
            }
        });
        cookies.sort(new Comparator<Cookie>() {
            @Override
            public int compare(Cookie a, Cookie b) {
                return a.getWeight() < b.getWeight() ? -1 : a.getWeight() == b.getWeight() ? 0 : 1;
            }
        });
    }

    Candy getCandybySugarAmountRange(int begin, int end) {
        for (Candy candy : candies)
            if (begin <= candy.getSugar() && candy.getSugar() <= end)
                return candy;
        return null;
    }

    Cookie getCookiebySugarAmountRange(int begin, int end) {
        for (Cookie cookie : cookies)
            if (begin <= cookie.getSugar() && cookie.getSugar() <= end)
                return cookie;
        return null;
    }
}
