
#ERROR 4: Declarar nuevamente la variable de otra forma
our $error = "Principio";
#my $error = "Inicio";
print $error,"\n\n";

my $num1;
my $num2;
#my $string1;
#my $string2;
my $answerStr;
my $opcionInicio;
#my $opcionNum;
#my $opcionStr;
my $raiz;
our $sum;
our $res;
our $div;
our $mul;
our $pwr;
our $long = 0 + 0 + 0;
our $fact = 1;

################################
my $num4 = "hola";
my $num1 = 20;

while($num4 <= $num1){
	print "Exito\n";
}

print"Es un gusto poder atenderte socio\n";
my $opcionInicio = 0;
while($opcionInicio !=3){
print"\n--Bienvenido a su menu principal-- \n";
print"Desea realizar operaciones con numeros o con Strings?\n";
print"1)Numeros 2)Strings 3)Salir\n";
#$opcionInicio = <STDIN>;
#ERROR 1: INCOMPATIBILIDAD DE DATOS en el given
  if ($opcionInicio == 1){
    my $opcionNum = 0;
    while($opcionNum!=7){
    print"\ndigite la opcion que quiera realizar:\n";
	print "1)Ingresar dos numeros y sumarlos\n";
	print "2)Ingresar dos numeros y restarlos\n"; 
	print "3)Ingresar dos numeros y multiplicarlos\n";  
	print "4)Ingresar dos numeros y dividirlos\n"; 
	print"5)Ingresar dos numeros y elevar el primero al numero del segundo\n";
	print "6)Obtener la raiz cuadrada de un numero\n" ;
	print "7)Volver al menu anterior\n";
    print"Ingrese una opcion:";
    $opcionNum = <STDIN>;
        if($opcionNum == 1){
		  #ERROR 7: Sumar valores ingresados incompatibles
          print "Ingrese el primer numero:";
          $num1 = <STDIN>;
          print "Ingrese el segundo numero:";
          $num2 = <STDIN>;
		  
		  $sum =  $num1 + $num2;
          print "la suma es : $sum\n";
        }
        if($opcionNum == 2){
          print "Ingrese el primer numero:";
          $num1 = <STDIN>;
          print "Ingrese el segundo numero:";
          $num2 = <STDIN>;
		  
		  $res =  $num1 - $num2;
		  print "la resta es : $res\n";
        }
        if($opcionNum == 3){
          print "Ingrese el primer numero:";
          $num1 = <STDIN>;
          print "Ingrese el segundo numero:";
          $num2 = <STDIN>;
          #ERROR 10: llamar una subrutina no definida
		  #&mulNumero($num1,$num2);
		  
		  $mul =  $num1 * $num2
          print "la multiplicacion es : $mul\n";
        }
        if($opcionNum == 4){
          print "Ingrese el primer numero:";
          $num1 = <STDIN>;
          print "Ingrese el segundo numero:";
          $num2 = <STDIN>;
		  #ERROR 5: operaciones con una cadena que comience con numeros
		  $div =  $num1 / $num2;
          print "la division es : $div\n";
        }
        if($opcionNum == 5){
          print "Ingrese el primer numero:";
          $num1 = <STDIN>;
          print "Ingrese el segundo numero:";
          $num2 = <STDIN>;
		  
		  $pwr =  $num1 ** $num2;
          print "el resultado de la potenciacion es : $pwr\n";
        }
        if($opcionNum == 6){
          print "Ingrese un numero:";
          $num1 = <STDIN>;
		  #ERROR 2: INCOMPATIBILIDAD DE DATOS con los metodos
          #$raiz = sqrt($num1);
          print"La raiz cuadrada del numero es : $raiz\n";
        }
        if($opcionNum == 7){
          print"\nEsta saliendo del menu numerico\n";
        }
        if($opcionNum > 7){
          print"Error,Ingrese una opcion valida";
        }
    }
  }
  if($opcionInicio == 2){
    my $opcionStr = 0;
    while($opcionStr != 4){
    print"\ndigite la operacion a realizar:\n";
	print"1)Ingresar dos Strings y comparar si son iguales\n"; 
	print"2)Sumar Contador\n"; 
	print"3)Imprimir el factorial de contador\n"; 
	print"4)Volver al menu anterior\n";
    print"Ingrese una opcion:";
    $opcionStr = <STDIN>;
      if($opcionStr == 1){
	    print"Ingrese un string:";
        my $string1 ="a";
        print"Ingrese otro String:";
        my $string2 ="b";
        #ERROR 8: Incompatibilidad en la comparación
        #if($string1 == $string2){
        if($string1 eq $string2){
           $answerStr = "Son iguales \n";
         }else{
           $answerStr = "son diferentes ";
        }
        print $answerStr;
      }
	  if($opcionStr == 2){
        print "Ingrese un nombre: ";
	    #ERROR 3: Variable sin inicializar en el arreglo
	    #my $string3;
	    #$long++;
		print"Se sumo uno\n";
      }
	  if($opcionStr == 3){
		if($long==0){
			print "No se ha sumado al contador\n";
		}
		else{
			for(my $i=1;$i<=$long;$i+=1){
				#ERROR 6: Escribir bien el formato de arreglos para usar
				#print @nom[$i];
				$fact = $fact*$i;
				#print " ";
			}
			print "El factorial de $long es $fact";
		}
      }
      if($opcionStr == 4){
        print"\nEsta saliendo del menu de Strings\n";
      }
      if($opcionStr > 4 or $opcionStr <= 0){
        print"Error,ingrese una opcion valida\n";
      }
    }

  }
  if ($opcionInicio == 3){
    print"\nHasta luego camarada\n";
  }
  if($opcionInicio <= 0){
    print"Error, ingrese una opcion valida\n";
  }


}
#ERROR 9: Duplicidad de variables
our $error9 = "\nFinal";
$error9 = "\nEnd";
print $error9;
