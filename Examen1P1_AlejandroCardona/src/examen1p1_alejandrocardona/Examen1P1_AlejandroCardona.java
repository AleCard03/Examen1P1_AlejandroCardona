/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_alejandrocardona;
import java.util.Scanner;

/**
 *
 * @author jets
 */
public class Examen1P1_AlejandroCardona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean continuar = true;
        while (continuar){
            System.out.println("Ingrese una opción:\n1. Sumador Binario\n2. Estrella de David\n3.Salir");
            int opcion = read.nextInt();
            switch (opcion){
                case 1: {
                    //48 y 49 son 0 y 1 en ascii respectivamente
                    System.out.print("Ingrese el primer número: ");
                    String num1 = read.next();
                    System.out.print("Ingrese el segundo número: ");
                    String num2 = read.next();
                    boolean binario1 = true;
                    boolean binario2 = true;
                    boolean igual = true;
                    int cont1 = 0;
                    int cont2 =0;
                    
                    for (int i = 0; i<num1.length();i++){
                        int x = num1.charAt(i);                                    
                        if(x>49 || x<48){
                            binario1 = false;
                        }//if num1 no binario
                    }//fin for validacion binarios
                    if (binario1 == false){
                        System.out.println("El primer numero contiene caracteres distintos de '0' y '1'");
                    }
                    for (int i = 0; i<num2.length();i++){
                        int y = num2.charAt(i);                                    
                        if(y>49 || y<48){
                            binario2 = false;
                        }//if num2 no binario
                    }//fin for validacion binarios
                    if (binario2 == false){
                        System.out.println("El segundo numero contiene caracteres distintos de '0' y '1'");
                    }
                    if( num1.length() != num2.length()){
                        System.out.println("Los numeros deben tener el mismo numero de bits");
                        igual = false;
                    }//fin validacion longitud}
                    if ( binario1 && binario2 && igual){
                        String acum = "";
                        String combo = "10";
                        String oneofakind = "1";
                        String comb0 = "0";
                        String plus1 = "11";
                        int cont3 = 0;
                        int run = 0;
                        for(int i = num1.length()-1; i>=0;i--){
                            run = 1;
                            char x = num1.charAt(i);
                            char y = num2.charAt(i);
                            if(cont3==1){
                                if(x == '1'){
                                    if(y=='1'){
                                        acum = plus1 + acum;
                                    }
                                    else{
                                        acum = combo + acum;
                                    }
                                }
                                else{
                                    if (y=='1'){
                                        acum = combo + acum;
                                    }
                                    else{
                                        acum = acum;
                                        cont3--;
                                    }
                                }//else cuando x = 0
                                run = 0;
                            }//bonus
                            else if(cont3==0&&run ==1){
                                if((x == '1' && y == '1')){

                                    if(i>0&&(num1.charAt(i-1)=='1'||num2.charAt(i-1)=='1')){
                                        acum = comb0+ acum;
                                        cont3++;
                                    }
                                    else{
                                        acum= combo+acum;
                                        cont3++;
                                    }
                                }// 1 y 1
                                else if((x=='0'&&y =='1')||(x=='1'&&y=='0')){
                                    acum = oneofakind + acum;
                                }// uno de c/u
                                else{
                                    acum = comb0 + acum;
                                }// 0 y 0
                            }//ciclo normal

                        }
                        System.out.println(acum);
                    }
                }//fin case 1
                break;
                case 2: {
                    System.out.println("Ingrese un tamaño");
                    int size = read.nextInt();
                    while (size <= 9 || size%2 == 0){
                        System.out.println("Ingrese un tamaño mayor a 9 e impar");
                        size = read.nextInt();
                    }//fin validacion
                    for ( int i = 1; i <= size+4; i++){
                        for ( int j = 1; j<= size; j++){
                            if ( i == 3){
                                System.out.print("*");
                            }//base de triangulo arriba
                            
                            else if ((i == 1 || i ==size+2)&&j == size/2+1){
                                if(i==1){
                                    System.out.print("+");
                                }
                                else{
                                    System.out.print("*");
                                }
                            }//puntas arriba y abajo
                            else if(i%2 ==1 &&j == i/2&&i<=size){
                                System.out.print("*");
                            }//barra diagonal #1
                            else if(i%2 ==1 &&j == (size+i)/2&&i<=size){
                                System.out.print("+");
                            }//barra diagonal +
                            else if( i == size){
                                System.out.print("+");
                            }//Base
                            else {
                                System.out.print(" ");
                            }//espacios
                        }
                        System.out.println(""); 

                    }
                }//fin case 2
                break;
                case 3: {
                    continuar = false;
                }//fin case 3
                break;
                default: {
                    System.out.println("Se ingresó un valor no válido");
                }//fin default
            }//fin switch menu
        }//fin while continuar
        // TODO code application logic here
    }//fin main
    
}//fin class
