package ssw;


public class Main {

    public static void main(String[] args) {
        NewYearGift newYearGift = new NewYearGift();
        newYearGift.init();
        newYearGift.print();

        System.out.println(newYearGift.weigt());

//        try
//        {
//            // create our mysql database connection
//            String myDriver = "com.mysql.jdbc.Driver";
//            String myUrl = "jdbc:mysql://localhost:3306/ssw_lab5";
//            Class.forName(myDriver);
//            Connection conn = DriverManager.getConnection(myUrl, "root", "5131");
//
//            // our SQL SELECT query.
//            // if you only need a few columns, specify them by name instead of using "*"
//            String query = "SELECT * FROM candy";
//
//            // create the java statement
//            Statement st = conn.createStatement();
//
//            // execute the query, and get a java resultset
//            ResultSet rs = st.executeQuery(query);
//
//            // iterate through the java resultset
//            while (rs.next())
//            {
//                int id = rs.getInt("id");
//                String firstName = rs.getString("Id");
//                String lastName = rs.getString("Weight");
//                Date dateCreated = rs.getDate("Sugar");
//                boolean isAdmin = rs.getBoolean("Manufacturer");
//                int numPoints = rs.getInt("Color");
//
//                // print the results
//                System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
//            }
//            st.close();
//        }
//        catch (Exception e)
//        {
//            System.err.println("Got an exception! ");
//            System.err.println(e.getMessage());
//        }

    }
}
