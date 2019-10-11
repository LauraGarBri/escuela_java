package viewnext.springrestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringrestClientApplication {

	private static final String URL_SRV_87 = "http://172.16.4.55:8087/users";
	
	public static void main(String[] args) {
		SpringApplication.run(SpringrestClientApplication.class, args);
		
		System.out.println(">> Recogiendo usuarios");
		RestClient clienteRest = new RestClient();
		String jsonUser = clienteRest.get("/users");	
		System.out.println(">> Usuarios recogidos: \n" + jsonUser);
		String usuarioEnviar = "{\n" + 
				"    \"id\": 6,\n" + 
				"    \"email\": \"enviado@ccc.com\",\n" + 
				"    \"name\": \"enviado\",\n" + 
				"    \"age\": 40\n" + 
				"}";
		String jsonuserCreado = clienteRest.post("/users", usuarioEnviar);
		System.out.println(">>> usuario creado : \n " + jsonuserCreado);
		
		
		
	}
	
	/*public List<User> getTodosUsuarios(){
		
	}*/

}
