package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import model.Account;
import model.Accounts;
import model.Clients;
import model.Link;
import model.Operation;
import model.Operations;
import model.Summary;

public class cliente {

	private static ClientConfig config;
	private static javax.ws.rs.client.Client client_x;
    private static WebTarget target;
	
	public static void main(String[] args) {

		int op = 100;

		while (op != 0) {

			System.out.println("-----------------------------------------------------------------");
			System.out.println("Introduzca número de operación a probar:");
			System.out.println("\t+[1] Añadir un cliente del banco");
			System.out.println("\t+[2] Ver los datos básicos de un cliente");
			System.out.println("\t+[3] Cambiar datos básicos de un cliente");
			System.out.println("\t+[4] Borrar todos los datos de un cliente");
			System.out.println("\t+[5] Crear una cuenta bancaria para un cliente");
			System.out.println("\t+[6] Eliminar la cuenta bancaria");
			System.out.println("\t+[7] Realizar una transferencia entre cuentas");
			System.out.println("\t+[8] Eliminar una transferencia (Administrador)");
			System.out.println("\t+[9] Realizar una retirada de efectivo");
			System.out.println("\t+[10] Obtener un listado de todas las transferencias emitidas");
			System.out.println("\t+[11] Obtener un listado de todos sus usuarios");
			System.out.println("\t+[12] Consultar un listado con todas las retiradas de efectivo de un cliente");
			System.out.println("\t+[13] Consultar todos los movimientos de un cliente");
			System.out.println("\t+[14] Consulta aplicación");
			System.out.println("\t+[15] Probar todas las operaciones ");
			System.out.println("\t+[0] Salir");
			System.out.println("-----------------------------------------------------------------");
			System.out.println(">");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				op = Integer.parseInt(reader.readLine());
				if (op >= 0 && op <= 15) {
					
					config = new ClientConfig();
					client_x = ClientBuilder.newClient(config);
					target = client_x.target(getBaseURI());
					
					switch (op) {
					case 1:
						System.out.println(op1());
						break;
					case 2:
						op2();
						break;
					case 3:
						op3();
						break;
					case 4:
						op4();
						break;
					case 5:
						System.out.println(op5());
						break;
					case 6:
						op6();
						break;
					case 7:
						System.out.println(op7());
						break;
					case 8:
						op8();
						break;
					case 9:
						System.out.println(op9());
						break;
					case 10:
						op10();
						break;
					case 11:
						op11();
						break;
					case 12:
						op12();
						break;
					case 13:
						op13();
						break;
					case 14:
						op14();
						break;
					case 15:
						op1();
						op2();
						op3();
						op4();
						op5();
						op6();
						op7();
						op8();
						op9();
						op10();
						op11();
						op12();
						op13();
						op14();
						break;

					default:
						break;
					}

				} else {
					throw new NumberFormatException("Número de operación inválido");
				}

			} catch (NumberFormatException | IOException e) {
				System.out.println("Número de operación mal introducido\n" + e.getMessage());
			}

		}
		System.out.println("Exit");
	}

	private static String op1() {
		model.Client cliente = new model.Client();
		cliente.setName("Vladimir");
		cliente.setSurname("Petkov");
		cliente.setIdentificationN("X98765421R");
		
		Response respuesta = target.path("api/client").request().accept(MediaType.APPLICATION_XML).post(Entity.xml(cliente));
		System.out.println(respuesta.toString());
		if (respuesta.getStatus()==201) {
			return respuesta.getHeaders().get("Location").toString();
		}
		else
			return "Error interno del servidor";
	}
	
	private static void op2() {
		model.Client cliente = new model.Client();
		int id = 35;
		Response respuesta =  target.path("api/client/"+id).request().accept(MediaType.APPLICATION_XML).get();
		cliente = target.path("api/client/"+id).request().accept(MediaType.APPLICATION_XML).get(model.Client.class);
		System.out.println("codigo respuesta: "+respuesta.getStatus());
        System.out.println("dato del usuario:\n"+cliente.toString());
        
	}
	
	private static void op3() {
		model.Client cliente = new model.Client();
		int id = 35;
		cliente.setFamilyName("Stoyanov");
		cliente.setIdentificationN("X74185263R");
		Response respuesta =  target.path("api/client/"+id).request().accept(MediaType.APPLICATION_XML).put(Entity.xml(cliente));
		System.out.println("codigo respuesta: "+respuesta.getStatus());
		
	}
	
	private static void op4() {
		int id = 34;
		Response respuesta = target.path("api/client/"+id).request().accept(MediaType.APPLICATION_XML).delete(); 
		System.out.println("codigo respuesta: "+respuesta.getStatus());
	}
	
	private static String op5() {
		Account cuenta = new Account();
		int id = 35;
		cuenta.setName("Prueba desde cliente");
		Response respuesta = target.path("api/client/"+id+"/accounts").request().accept(MediaType.APPLICATION_XML).post(Entity.xml(cuenta)); 
		System.out.println("codigo respuesta: "+respuesta.getStatus());
		if (respuesta.getStatus()==201) {
			return respuesta.getHeaders().get("Location").toString();
		}
		else return "Error interno del servidor";
	}
	
	private static void op6(){
		int id = 12;
		int id_cliente = 35;
		Response respuesta = target.path("api/client/"+id_cliente+"/accounts/"+id).request().accept(MediaType.APPLICATION_XML).delete(); 
		System.out.println("codigo respuesta: "+respuesta.getStatus());
	}
	
	private static String op7() {
		int id_cliente = 4;
		int id_cuenta = 8;
		Operation transf = new Operation(true,100.2f,12);
		
		Response respuesta = target.path("api/client/"+id_cliente+"/accounts/"+id_cuenta+"/op").request().accept(MediaType.APPLICATION_XML).post(Entity.xml(transf));
		System.out.println("codigo respuesta: "+respuesta.getStatus());
		if (respuesta.getStatus()==201) {
			return respuesta.getHeaders().get("Location").toString();
		}
		else return "Error";	
	}
	
	private static void op8() {
		int id_cliente = 4;
		int id_cuenta = 8;
		int id_op = 25;
		Response respuesta = target.path("api/client/"+id_cliente+"/accounts/"+id_cuenta+"/op/"+id_op).request().accept(MediaType.APPLICATION_XML).delete(); 
		System.out.println("codigo respuesta: "+respuesta.getStatus());
		
	}
	
	private static String op9() {
		int id_cliente = 27;
		int id_cuenta = 12;
		Operation retirada = new Operation();
		retirada.setAmount(50f);
		
		Response respuesta = target.path("api/client/"+id_cliente+"/accounts/"+id_cuenta+"/op").request().accept(MediaType.APPLICATION_XML).post(Entity.xml(retirada));
		System.out.println("codigo respuesta: "+respuesta.getStatus());
		if (respuesta.getStatus()==201) {
			return respuesta.getHeaders().get("Location").toString();
		}
		else return "Error";	
	}
	
	private static void op10() {
		int id_cliente = 4;
		int id_cuenta = 8;

		Response respuesta =  target.path("api/client/"+id_cliente+"/accounts/"+id_cuenta+"/op").request().accept(MediaType.APPLICATION_XML).get();
		Operations ops = target.path("api/client/"+id_cliente+"/accounts/"+id_cuenta+"/op").request().accept(MediaType.APPLICATION_XML).get(Operations.class);
		
		System.out.println("codigo respuesta: "+respuesta.getStatus());
		Iterator<Link> it = ops.getOperations().iterator();
		while (it.hasNext()) {
			System.out.println( it.next().getUrl().toString() );
		}
		
		
	}
	
	private static void op12() {
		int id_cliente = 35;
		
		Response respuesta =  target.path("api/client/"+id_cliente+"/op").request().accept(MediaType.APPLICATION_XML).get();
		Operations ops = target.path("api/client/"+id_cliente+"/op").request().accept(MediaType.APPLICATION_XML).get(Operations.class);
		
		System.out.println("codigo respuesta: "+respuesta.getStatus());
		Iterator<Link> it = ops.getOperations().iterator();
		while (it.hasNext()) {
			System.out.println( it.next().getUrl().toString() );
		}
		
	}
	
	private static void op11() {
		
		Response respuesta =  target.path("api/client/").request().accept(MediaType.APPLICATION_XML).get();
		Clients lista_clientes = target.path("api/client/").request().accept(MediaType.APPLICATION_XML).get(Clients.class);
		System.out.println("codigo respuesta: "+respuesta.getStatus());
		Iterator<Link> it = lista_clientes.getClients().iterator();
		while (it.hasNext()) {
			System.out.println( it.next().getUrl().toString() );
		}
		
	}
	
	private static void op13() {
		int id_cliente = 35;
		
		Response respuesta =  target.path("api/client/"+id_cliente+"/op").queryParam("transfer", 1).request().accept(MediaType.APPLICATION_XML).get();
		Operations ops = target.path("api/client/"+id_cliente+"/op").queryParam("transfer", 1).request().accept(MediaType.APPLICATION_XML).get(Operations.class);
		
		System.out.println("codigo respuesta: "+respuesta.getStatus());
		Iterator<Link> it = ops.getOperations().iterator();
		while (it.hasNext()) {
			System.out.println( it.next() .getUrl().toString() );
		}
		
	}
	
	private static void op14() {
		int id_cliente = 35;
		
		Summary summary = target.path("api/client/summaries/"+id_cliente).request().accept(MediaType.APPLICATION_XML).get(Summary.class);
		System.out.println(summary.toString());
		
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/SOSBank/").build();
	}
	
}
