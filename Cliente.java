 
import java.net.*;
import java.util.Scanner;
import java.io.*; 
 
public class Cliente {

    public static void main(String args[]) {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Cliente 2");
        System.out.println("IP de asociado: ");
        String host = sc1.nextLine();
        

        int port = 6666;
       
        DataInputStream input;
        DataOutputStream output;

       
        try {
            System.out.println("Envia un mensaje!");
            while(true){
            Socket sc = new Socket(host,port);


                input = new DataInputStream(sc.getInputStream());
                output = new DataOutputStream(sc.getOutputStream());
                String mensajeEnvio = "";
                do{
                    
                    mensajeEnvio = sc1.nextLine();
                    output.writeUTF(mensajeEnvio);
                    System.out.println("Espera a recibir mensaje.");

                    
                    String mensaje = input.readUTF();
                    System.out.println("Recibido>> " + mensaje);

                    
                    if(mensajeEnvio.equals("0")){
                        sc.close();
                        System.out.println("Desconection");
                    }
                }while(true);
                    
                    
                    
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}