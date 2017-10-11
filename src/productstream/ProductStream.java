
package productstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductStream {

   
    public static void main(String[] args) {
         
        Product po1 = new Product("cod1","Parafusos",3);
        Product po2 = new Product("cod2","Arandelas",4);
        
        String ruta = "/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/ProductStream/produtos.txt";
        
        
        ProductStream.escribir(ruta, po1,false);
        ProductStream.escribir(ruta, po2,true);
        ProductStream.leer(ruta);
        
      
       
       
    }
 public static void leer(String ruta){
      Product po3 = new Product();
   
     
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(ruta)));
             for(int i=0;i<2;i++){
             while(dis.available()!=0){
            
             po3.setCodigo(dis.readUTF());
             po3.setDescripcion(dis.readUTF());
             po3.setPrezo(dis.readDouble());
                         
             System.out.println(" Código :"+po3.getCodigo()+" Nome :"+po3.getDescripcion()+" Prezo :"+po3.getPrezo());
             }
             } 
             dis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error"+ex.getMessage());
            
        } catch (IOException ex){
            Logger.getLogger(ProductStream.class.getName()).log(Level.SEVERE, null, ex);
           
        }
     
     
     
     
 }
 
 public static void escribir(String ruta,Product po2,boolean ap){
       try {
           
           DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(ruta,ap)));
           dos.writeUTF(po2.getCodigo());
           dos.writeUTF(po2.getDescripcion());
           dos.writeDouble(po2.getPrezo());
           dos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
     
 }


     
}
