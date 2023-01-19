// this will be java file for the code , I connected this with sql file and got good responce which was similar to the output of the data

import java.sql.*;

public class CallCenterAnalytics {
    public static void main(String[] args) {
        try {
            // Connect to the database
            Connection con = DriverManager.getConnection("jdbc:postgresql://host:port/database", "username", "password");

            // Hour of the day when the call volume is highest
            Statement stmt1 = con.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT EXTRACT(HOUR FROM start_time) AS hour, COUNT() FROM call GROUP BY hour ORDER BY COUNT() DESC LIMIT 1");
            if (rs1.next()) {
                System.out.println("Hour of the day when the call volume is highest: " + rs1.getInt("hour"));
            }
            rs1.close();
            stmt1.close();

            // Hour of the day when the calls are longest
            Statement stmt2 = con.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT EXTRACT(HOUR FROM start_time) AS hour, SUM(duration) FROM call GROUP BY hour ORDER BY SUM(duration) DESC LIMIT 1");
            if (rs2.next()) {
                System.out.println("Hour of the day when the calls are longest: " + rs2.getInt("hour"));
            }
            rs2.close();
            stmt2.close();

            // Day of the week when the call volume is highest
            Statement stmt3 = con.createStatement();
            ResultSet rs3 = stmt3.executeQuery("SELECT EXTRACT(DOW FROM start_time) AS day, COUNT() FROM call GROUP BY day ORDER BY COUNT() DESC LIMIT 1");
            if (rs3.next()) {
                System.out.println("Day of the week when the call volume is highest: " + rs3.getInt("day"));
            }
            rs3.close();
            stmt3.close();

            // Day of the week when the calls are longest
            Statement stmt4 = con.createStatement();
            ResultSet rs4 = stmt4.executeQuery("SELECT EXTRACT(DOW FROM start_time) AS day, SUM(duration) FROM call GROUP BY day ORDER BY SUM(duration) DESC LIMIT 1");
            if (rs4.next()) {
                System.out.println("Day of the week when the calls are longest: " + rs4.getInt("day"));
            }
            rs4.close();
            stmt4.close();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
