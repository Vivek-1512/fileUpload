/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.greentech.pojo.Data;
import com.greentech.pojo.Product;
import com.hibernet.utils.HibernateUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ASUS
 */
public class ProductDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
         Transaction tx=null;
          Session sess=null;
        try
        {
        sess=HibernateUtils.getSessionFactory().openSession();
        Product p=new Product();
        Data d=sess.get(Data.class,82);
        p.setData(d);
        p.setName("2000 LPH SS FRP RO Plant");
        p.setDetail("Usage/Application=Water Purification#RO Capacity=2000 LPH#Material=FRP#Max Water Recovery Rate=50-55 %#Automation Grade=Semi-Automatic#Number Of Membranes In Ro=2#Installation Type=Complete Civil work with Installation");
        p.setPrice(4);
        p.setText("We are offering an extensive series of 2000 LPH SS FRP RO Plant. These products are extremely employed in the market for diverse purposes.");
        //save image into database
//        System.out.println("Enter the path : ");
//        String path=new Scanner(System.in).nextLine();
    	File file = new File("‪‪‪‪‪‪‪D:\\vivek\\MyImage\\chhilpa.jpg".trim());
        byte[] bFile = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
         //convert file into array of bytes
        fileInputStream.read(bFile);
        fileInputStream.close();
        p.setPhoto(bFile);
        tx=sess.beginTransaction();
            System.out.println("Done!!!");
//        sess.save(p);
        tx.commit();
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }
        finally{
            if(sess!=null)
            {
                sess.close();
            }
            
//            HibernateUtils.closeSessionFactory();
        }
            
    }
}

