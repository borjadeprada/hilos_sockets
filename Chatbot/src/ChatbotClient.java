import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChatbotClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// Guardamos el numero IP
		String serverAddress = "127.0.0.1";
		
		while(true) {
			
			// Pedimos que se elija una de las peliculas
			String number = System.console().readLine("Bienvenido, seleccione que pelicula desea ver:\n1. Napoleon\n2. Los Juegos del Hambre\n3. El Favor\n4. Vidas Pasadas\n5. El Chico y la Garza\n");
			
			// Creamos el socket
			Socket socket = new Socket(serverAddress, 9999);
			
			// Creamos el stream de salida y enviamos el numero elegido al servidor
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(number);
			
			// Creamos el lector de entrada y recibimos la respuesta del servidor
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String answer = input.readLine();
			
			// Imprimimos el mensaje
			System.out.println(answer);
			
			// Cerramos el socket
			socket.close();
			
		}

	}

}
