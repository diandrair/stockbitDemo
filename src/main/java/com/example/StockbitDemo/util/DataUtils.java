package com.example.StockbitDemo.util;


import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DataUtils {

    public static String env = System.getProperty("environment");
    public static String getDataFromExcel(String sheetName, String key) {
        String testdata = "error extracting testdata file";

        if (null == env) {
            testdata = "TestData.xlsx";
        } else {

            if (env.toLowerCase().equals("staging")) {
                testdata = "TestDataSTA.xlsx";
            } else {
                testdata = "TestData.xlsx";

            }
        }

        String valueResult = "error fetching data";

        try {
            Fillo fillo = new Fillo();

            Connection conn = fillo.getConnection(
                    System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" +
                            File.separator + "resources" + File.separator + testdata);

            String query = "Select * from " + sheetName + " where ID='" + key + "'";

            Recordset recordset = conn.executeQuery(query);

            while (recordset.next()) {
                valueResult = recordset.getField("Value");
            }

            recordset.close();
            conn.close();
        } catch (FilloException e) {
            e.printStackTrace();
        }

        return valueResult;

    }
}
