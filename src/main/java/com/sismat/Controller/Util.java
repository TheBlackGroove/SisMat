package com.sismat.Controller;

import javax.servlet.http.HttpSession;

public class Util {

	public static boolean VerificarEstadoLogin(HttpSession session){
		
		if(session.getAttribute("usuario") != null){
			return true;
		}
		else
		{
			return false;
		}		
	}
	
}
