package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;

/**
 * Clase que permite manejar los mensajes de error del API como objetos JSON
 * @author MIMO
 *
 */
public class ErrorObject {

	/**
	 * Código del error
	 */
	private String code;
	
	/**
	 * Mensaje con la información del error
	 */
	private String message;

	/**
	 * Constructor de la clase ErrorObject
	 * @param code Código del error
	 * @param message Mensaje con la información del error
	 */
	public ErrorObject(String code, String message) {
		
		super();
		this.code = code;
		this.message = message;
	}

	/**
	 * Método que convierte el mensaje de error en un objeto Json
	 * @return El objeto Json con la información del error
	 */
	public JsonNode convertToJson() {
		return Json.toJson(this);
	}
	
	/**
	 * Getter de code
	 * @return El código del error
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter de code
	 * @param code El código del error
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter de message
	 * @return El mensaje con la información del error
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Setter de message
	 * @param message Mensaje con la información del error
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}