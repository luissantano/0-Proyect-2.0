package com.iesemilidarder.base;

/**
 * zeroproject
 * com.iesemilidarder.projectozero
 * Create by winadmin in 19/1/2018.
 * Description:
 */

import com.iesemilidarder.dao.Restaurants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.function.Function;


/*Cream una classe publica */
public class ReadDB {
    private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
    private static final String THIN_URL ="jdbc:oracle:thin:@35.205.41.45:1521:XE";
    private static final String USER = "usuari";
    private static final String PASSWORD  ="usuari";


    private Object searchDB(String query,Function<ResultSet, Object> f) {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(THIN_URL , USER , PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Object o = f.apply(rs);
            stmt.close();
            con.close();
            return o;

        } catch (Exception e) {
            return null;
        }

    }





    public static ArrayList readRestaurants(String cercar) {


        ArrayList ar = new ArrayList();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");


            Statement stmt = con.createStatement();

            ResultSet rs;

            System.out.println(cercar);

            //Aquest if serveix per al cercador . Diu que si el valor que introduim es null o no posam res , farà un select amb el nom , telèfon , imatge etc...

            if (cercar == null || cercar.equals("")) {

                rs = stmt.executeQuery("select * from  ( select RE.RES_CODI, RE.RES_NOM, RE.RES_WEB, RE.RES_ADRECA, RE.RES_TELEFON, RR.TRS_DESCRIPCIO , RE.RES_MITJANA , RES_URL_IMG FROM RESTAURANTS RE , TRESTAURANTS RR WHERE RE.RES_TRS_CODI = RR.TRS_CODI ORDER BY RE.RES_MITJANA desc ) where ROWNUM <= 5");

                //Aquesta part del else fa un select amb el valor que l'hi hem introduit
            } else {

                rs = stmt.executeQuery("select * from  ( select RE.RES_CODI, RE.RES_NOM, RE.RES_WEB, RE.RES_ADRECA, RE.RES_TELEFON, RR.TRS_DESCRIPCIO, RE.RES_MITJANA, RES_URL_IMG FROM RESTAURANTS RE , TRESTAURANTS RR WHERE RE.RES_TRS_CODI = RR.TRS_CODI AND LOWER( RE.RES_NOM) LIKE '%" + cercar.toLowerCase() + "%' ORDER BY RE.RES_MITJANA desc ) where ROWNUM <= 5");

            }


            while (rs.next()) {


                String name = rs.getString("RES_NOM");
                String website = rs.getString("RES_WEB");
                String address = rs.getString("RES_ADRECA");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");
                String image = rs.getString("RES_URL_IMG");
                String id = rs.getString("RES_CODI");

                Restaurants rst = new Restaurants();
                rst.setName(name);
                rst.setAddress(address);
                rst.setWebsite(website);
                rst.setTelephone(telephone);
                rst.setType(type);
                rst.setImage(image);
                rst.setId(id);


                ar.add(rst);


            }
            stmt.close();
            con.close();


        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ar;

    }


    public Restaurants ReadDBB(String ID) {

        Restaurants rstt = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = conn.createStatement();

            ResultSet rs;

            rs = stmt.executeQuery("SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG, R.RES_CODI, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE " + ID + "= R.RES_CODI AND R.RES_TRS_CODI = TR.TRS_CODI");

            if (rs.next()) {





                rstt = new Restaurants();

                rstt.setName(rs.getString("RES_NOM"));
                rstt.setAddress(rs.getString("RES_ADRECA"));
                rstt.setWebsite(rs.getString("RES_WEB"));
                rstt.setTelephone(rs.getString("RES_TELEFON"));
                rstt.setType(rs.getString("TRS_DESCRIPCIO"));
                rstt.setImage(rs.getString("RES_URL_IMG"));
                rstt.setId(rs.getString("RES_CODI"));


                Statement stmtt = conn.createStatement();
                ResultSet rst;

                rst = stmt.executeQuery("SELECT O.OPI_OBSERVACIO, U.USU_NOM FROM RESTAURANTS R, OPINIONS O, USUARIS U WHERE R.RES_CODI = O.OPI_RES_CODI AND " + ID + "=R.RES_CODI AND O.OPI_USU_CODI = U.USU_CODI" );
                while (rst.next()){

                    rstt.getOpinion().add(rst.getString("USU_NOM"));
                    rstt.getOpinion().add(rst.getString("OPI_OBSERVACIO"));

                }

                stmtt.close();
            }
            stmt.close();
            conn.close();




        }catch (Exception ee) {
            System.out.println(ee.toString());
        }
        return rstt;

    }
}
