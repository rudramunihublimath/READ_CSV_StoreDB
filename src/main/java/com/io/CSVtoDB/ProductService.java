package com.io.CSVtoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ProductService {
    @Autowired
    private  ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public  final String delimiter = ",";


    //public static void read(String csvFile,ProductDAOImpl productlist) {
    public  void read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;


            while((line = br.readLine()) != null) {
                    tempArr = line.split(delimiter);
                    Product pr = new Product();
                    pr.setPid(tempArr[0]);
                    pr.setPname(tempArr[1]);
                    pr.setPprice( tempArr[2]);
                    productDAO.save(pr);

                //}

            }

            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void findall() {
        productDAO.findall_1();
    }
}
