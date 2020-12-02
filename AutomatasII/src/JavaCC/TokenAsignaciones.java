package JavaCC;

import java.io.PrintStream;
import java.util.Hashtable;
import java.lang.String;
import java.util.ArrayList;

class TokenAsignaciones
{ 
	  //Tabla que almacenara las variabñes declaradas
	  private static Hashtable tabla = new Hashtable();
	  
	  //<entero>		 = 85
      //<real>			 = 86
      //<ident>			 = 87
      //<cadenainter>	 = 88
	  //<cadena>		 = 89
	  
												//variable		//tipoDato
	public static void InsertarSimbolo(Token identificador, int tipo)
	{
		//En este metodo se agrega a la tabla de tokens el identificador que esta siendo declarado junto con su tipo de dato
		tabla.put(identificador.image, tipo);
	}
	
	
	/*Metodo que verifica si un identificador ha sido declarado*/ 
	public static String checkVariable(Token checkTok)
	{
		try
		{
			//Intenta obtener el token a verificar(checkTok) de la tabla de los tokens
			//System.out.println(checkTok.image);
			String cadena = checkTok.image;
			if(cadena.charAt(0) != '$') return " ";
			int tipoIdent1 = (Integer)tabla.get(checkTok.image);
			if(tipoIdent1 == -1) 
				return "Error: El identificador "+checkTok.image+" no ha sido inicializado. Linea: "+checkTok.beginLine;
			return " ";
		}
		catch(Exception e)
		{
			//Si no lo puede obtener, manda el error
			return "Error: El identificador " + checkTok.image + " no ha sido declarado. Linea: " + checkTok.beginLine;
		}
	}
	
	public static String checkCompNum(Token v1, Token v2){
		String mensaje = "";
		Boolean bandera = false;
		int tipo1 = v1.kind;
		int tipo2 = v2.kind;
		//System.out.println(tipo1+" "+tipo2);
		if(v1.kind == 87){
			if(tabla.get(v1.image) != null){
				tipo1 = (Integer)tabla.get(v1.image);
				if(tipo1 == 88 || tipo1 == 89){
					if(bandera) mensaje+="\n";
					mensaje+="Error: La variable "+v1.image+" es una cadena y se esta usando con" 
						+ " operadores de numeros("+v1.next.image+"). Linea: "+v2.beginLine;
					bandera = true;
				}
			} else tipo1 = -1;
		}
		if(v2.kind == 87){
			if(tabla.get(v2.image) != null){
				tipo2 = (Integer)tabla.get(v2.image);
				if(tipo2 == 88 || tipo2 == 89){
					if(bandera) mensaje+="\n";
					mensaje+="Error: La variable "+v2.image+" es una cadena y se esta usando con" 
						+ " operadores de numeros("+v1.next.image+"). Linea: "+v2.beginLine;
					bandera = true;
				}
			} else tipo2 = -1;
		}
		if(bandera) return mensaje;
		//System.out.println(tipo1+" "+tipo2);
		if((tipo1 == 85 || tipo1 == 86 || tipo1 == -1) && (tipo2 == 85 || tipo2 == 86 || tipo2 == -1))
			return " ";
		return "Error: Se estan comparando cadenas con operadores de numeros("+v1.next.image+"). Linea: "+v1.beginLine;
	}
	
	public static String checkCompCad(Token v1, Token v2){
		String mensaje = "";
		Boolean bandera = false;
		int tipo1 = v1.kind;
		int tipo2 = v2.kind;
		//System.out.println(tipo1+" "+tipo2);
		if(v1.kind == 87){
			if(tabla.get(v1.image) != null){
				tipo1 = (Integer)tabla.get(v1.image);
				if(tipo1 == 85 || tipo1 == 86){
					mensaje+="Error: La variable "+v1.image+" es un numero y se esta usando con" 
						+ " operadores de cadenas("+v1.next.image+"). Linea: "+v1.beginLine;
					bandera = true;
				}
			} else tipo1 = -1;
		}
		if(v2.kind == 87){
			if(tabla.get(v2.image) != null){
				tipo2 = (Integer)tabla.get(v2.image);
				if(tipo2 == 85 || tipo2 == 86){
					if(bandera) mensaje+="\n";
					mensaje+="Error: La variable "+v2.image+" es un numero y se esta usando con" 
						+ " operadores de cadenas("+v1.next.image+"). Linea: "+v2.beginLine;
					bandera = true;
				}
			} else tipo2 = -1;
		}
		if(bandera) return mensaje;
		//System.out.println(tipo1+" "+tipo2);
		if((tipo1 == 88 || tipo1 == 89 || tipo1 == -1) && (tipo2 == 88 || tipo2 == 89 || tipo2 == -1))
			return " ";
		return "Error: Se estan comparando numeros con operadores de cadenas("+v1.next.image+"). Linea: "+v1.beginLine;
	}

 }