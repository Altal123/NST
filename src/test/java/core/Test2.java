package core;

import java.sql.*;
import java.util.*;

//import static conciseSeleniumAPI.OracleDBConnector.getDataFromDB;

/**
 * Created by Gan on 30.09.2017.
 */
public class Test2 {

    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    private static String sqlRequestPart1 = "select msg_id, msg_status from msg_queue where msg_topic like '%LoanNSTWF%' and " +
            "(extractvalue(msg_body, '//local/application/field[@name=\"lastNameUkr\"]/text()', 'xmlns=\"http://sab/') = '";
    private static String sqlRequestPart2 = "and (extractvalue(msg_body, '//local/application/field[@name=\"firstNameUkr\"]/text()'," +
            " 'xmlns=\"http://sab/') = '";
    private static String sqlRequestPart3 = "and (extractvalue(msg_body, '//local/application/field[@name=\"middleNameUkr\"]/text()'," +
            " 'xmlns=\"http://sab/') = '";

    public static void main(String args[]) {

        int i = 10;

//        while (i > 0){
//            System.out.println(random(8));
//            i--;
//        }

//        Date dateNow = new Date();
//        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
//
//        System.out.println(formatForDateNow.format(dateNow));

//        --------------------
        String [] map = findMsgId("ТОЛЯН", "СТРАХ ВОСЬМИЙ", "ДВА ТОВАРИ");
//        String[] result3 = results.toArray(new String[results2.size()]);
        System.out.println(map[0] + ": " + map[1]);

    }


    public static String[] findMsgId(String lastNameUkr, String firstNameUkr, String middleNameUkr) {
//        LinkedHashMap results = new LinkedHashMap();
        LinkedHashSet<String> results = new LinkedHashSet<String>();
        String[] values_to_return = {"msg_id", "msg_status"};
        String dbLink = PropertyLoader.loadProperty("dbLink");
        String dbUsername = PropertyLoader.loadProperty("dbUsername");
        String dbPassword = PropertyLoader.loadProperty("dbPassword");
        String query = sqlRequestPart1 + lastNameUkr + "') " + sqlRequestPart2 + firstNameUkr +"')"
                + sqlRequestPart3 + middleNameUkr +  "') order by msg_created desc";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connect = DriverManager.getConnection(dbLink, dbUsername, dbPassword);
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                for(int i = 0; i < values_to_return.length; ++i) {
                    String result = resultSet.getString(values_to_return[i]);
//                    results.put(result, values_to_return[i]);
                    results.add(result);
                }
            }
            if(resultSet!=null)resultSet.close();
            if(statement!=null)statement.close();
            if(connect!=null)connect.close();

        } catch (SQLException var8) {
            var8.printStackTrace();
        } catch (ClassNotFoundException var9) {
            var9.printStackTrace();
        }

        return results.toArray(new String[results.size()]);
    }

    public static boolean randomZeroOrOne(){
        if (Integer.parseInt(randomNumber(1))/5 == 1) return true;
        return false;
    }

    public static String randomNumber (int length){
        StringBuilder temp = new StringBuilder("1");
        for (int i = 1; i < length; i++){
            temp.append(0);
        }
        int result = Integer.parseInt(temp.toString());
        return String.valueOf((int)(result + (result*9) * Math.random()));
    }

    public static String random (int length) {

        StringBuilder temp = new StringBuilder("1");
        for (int i = 1; i < length; i++) {
            temp.append(0);
        }
        int result = Integer.parseInt(temp.toString());
        return String.valueOf((int)(result + (result*9) * Math.random()));
    }
}


