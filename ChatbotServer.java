import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatbotServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket listener = new ServerSocket(9999);
		
		System.out.println("Servidor Iniciado");
		
		try {
		
			while(true) {
				Socket socket = listener.accept();
				
				// Leemos el numero elegido en el cliente
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				int clientNumber = 0;
				String inputString = input.readLine();
				
				// Comprobamos que sea un numero
				if(isNumeric(inputString)){
					// Guardamos el numero como un entero
					clientNumber = Integer.parseInt(inputString);
					
					// Creamos el stream de salida
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					
					// En funcion de la opcion elegida, enviamos al cliente la respuesta correspondiente
					if(clientNumber == 1) {
						out.println("Sala 1:	16:00	|	19:00	|	22.00");
					}else if(clientNumber == 2){
						out.println("Sala 2:	12:00	|	17.30	|	21.00");
					}else if(clientNumber == 3){
						out.println("Sala 3:	13:30	|	16:15	|	20.30");
					}else if(clientNumber == 4){
						out.println("Sala 4:	15:00	|	16:30	|	22.15");
					}else if(clientNumber == 5){
						out.println("Sala 5:	16:00	|	19:15	|	21.30");
					}else if(!isNumeric(inputString)){
						out.println(inputString + " no es un numero.");
					}else {
						out.println("Por favor, introduzca un numero entre 1 y 5.");
					}
				}
		
				// Cerramos el socket
				socket.close();
											
			}
		}finally {
			// Cerramos el listener
			listener.close();
		}
			
	}
	
	// Funcion que comprueba si el valor recibido es, en efecto, un numero
	public static boolean isNumeric(String str) {
		
		try {
			Integer.parseInt(str);
		}catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}

