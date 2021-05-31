import java.net.*; 
import java.util.Scanner;
import java.io.*;  
 
public class Servidor {
  
 
	public static void main(String argv[]) {
        ServerSocket server = null;
        Scanner sc1 = new Scanner(System.in);
        Socket sc = null;
        DataInputStream input;
        DataOutputStream output;
        int port = 6666;

        try {
            server = new ServerSocket(port);
            System.out.println("Cliente 1");
            
            while(true){
                System.out.println("Esperando conexiones...");
                sc = server.accept();
                System.out.println("Listo!");
                System.out.println("Espera a recibir mensaje.");
                

                input = new DataInputStream(sc.getInputStream());
                output = new DataOutputStream(sc.getOutputStream());
                
                
                String mensajeEnvio = "";
                do{
                    
                   
                    
                    String mensaje = input.readUTF();
                    System.out.println("Recibido>> " + mensaje);
                    

                    mensajeEnvio = sc1.nextLine();
                    output.writeUTF(mensajeEnvio);
                    System.out.println("Espera a recibir mensaje.");

                    
                    
                    if(mensajeEnvio.equals("0")){
                        sc.close();
                        System.out.println("Desconection");
                    }
                }while(true);
                    

                //System.out.println("Desconectado.");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
    }
}