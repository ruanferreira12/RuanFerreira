package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class subtracaonum {
 
    //Declaracao das variaveis
    public static String cadeia, cadeia2,aux;       
    public static BufferedReader reader;
    public static int comprimento;
    public String resultado="";
    public String arranjo[];
    public int apontador=1;
 
    //O construtor do objeto mostra a entrada da cadeia
    public subtracaonum(){
        System.out.println("cadeia: "+cadeia); 
        decodificar(cadeia);
    }
 
    //O metodo Decodificar eh responsavel por criar o comeco da conter a cadeia
    public void decodificar(String dec){
        cadeia2="#"+cadeia+"#";
        comprimento = cadeia2.length();
        arranjo = new String[comprimento];
        for(int i=0;i<comprimento;i++){
            arranjo[i]=""+cadeia2.charAt(i);
        }
        e0();
    }
     
 
    //O método e0 representa o estado 0 ou o estado inicial
    public void e0(){
        aux= arranjo[apontador];
        if (aux.equals("1")){
            arranjo[apontador]="1";
            moverDireita();
            e0();
        }
        else if (aux.equals("-")){
            arranjo[apontador]="-";
            moverDireita();
            e1();
        }
        else if (aux.equals("#")){
            arranjo[apontador]="#";
            moverEsquerda();
            System.out.println("cadeia vazia");
        }else{
            rejeitar(aux);
        }
             
    }
 
 
    //O metodo e1 representa o estado 1
    public void e1(){
        aux= arranjo[apontador];
        if (aux.equals("1")){
            arranjo[apontador]="1";
            moverDireita();
            e1();
        }
        else if (aux.equals("#")){
            arranjo[apontador]="#";
            moverEsquerda();
            e2();
        }
        else if (aux.equals("-")){
            incorrecto();
        }else{
            rejeitar(aux);
        }
    }
 
 
    //O metodo e2 representa o estado 2
    public void e2(){
        aux= arranjo[apontador];
        if (aux.equals("1")){
            arranjo[apontador]="#";
            moverEsquerda();
            e3();
        }
        else if (aux.equals("-")){
            arranjo[apontador]="#";
            moverEsquerda();
            e6();
        }
        else if (aux.equals("#")){
            incorrecto();
        }else{
            rejeitar(aux);
        }
    }
 
 
    //O metodo e3 representa o estado 3
    public void e3(){
        aux= arranjo[apontador];
        if (aux.equals("1")){
            arranjo[apontador]="1";
            moverEsquerda();
            e3();
        }
        else if (aux.equals("-")){
            arranjo[apontador]="-";
            moverEsquerda();
            e3();
        }
        else if (aux.equals("#")){
            arranjo[apontador]="#";
            moverDireita();
            e4();
        }else{
            rejeitar(aux);
        }
    }
 
    //O metodo e4 representa o estado 4
    public void e4(){
        aux= arranjo[apontador];
        if (aux.equals("1")){
            arranjo[apontador]="#";
            moverDireita();
            e0();
        }
        else if (aux.equals("-")){
            arranjo[apontador]="1";
            moverEsquerda();
            e5();
        }
        else if (aux.equals("#")){
            incorrecto();
        }else{
            rejeitar(aux);
        }
    }
 
    //O metodo e5 representa o estado 5
    public void e5(){
        aux= arranjo[apontador];
        if (aux.equals("#")){
            arranjo[apontador]="-";
            moverEsquerda();
            e6();
        }
        else if (aux.equals("-")){
            incorrecto();
        }
        else if (aux.equals("1")){
            incorrecto();
        }else{
            rejeitar(aux);
        }
    }
 
    //O metodo e6 representa o estado 6
    public void e6(){
        aux= arranjo[apontador];
        if (aux.equals("1")){
            arranjo[apontador]="1";
            moverEsquerda();
            e6();
        }
        else if (aux.equals("#")){
            arranjo[apontador]="#";
            moverDireita();
            e7();
        }
        else if (aux.equals("-")){
            incorrecto();
        }else{
            rejeitar(aux);
        }
    }
 
    //O metodo e7 representa o estado 7, o estado de aceitaçao
    public void e7(){
 
        for(int i=0;i<comprimento;i++){
            if(arranjo[i].equals("#")){}
            else{
                resultado=resultado+arranjo[i];
            }
        }
        if(resultado.equals("")){
            System.out.println("El resultado de: "+ cadeia +" es: 0");
        }else
            System.out.println("El resultado de: "+ cadeia +" es: "+ resultado);
    }
 
 
 
    //Move o ponteiro da Maquina para a Direita
    public void moverDireita(){
        apontador++;
    }
     
    //Move o ponteiro da Maquina para a esquerda
    public void moverEsquerda(){
        apontador=apontador-1;
    }
 
    //Se entrar nesse estado, isso significa que um caracter inválido foi encontrado
    public void rejeitar(String noval){
        System.out.println("Caracter invalido: "+noval);
    }
 
    //Se entrar neste estado, significa que a sintaxe da subtração está incorreta
    public void incorrecto(){
        System.out.println("Sintaxe incorrecta");
    }
 
 
 
        // Pedir a subtração e salvá-la na cadeia variável
    public static void main(String args[]){
        System.out.println("Insira a subtraçao: ");
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            cadeia = reader.readLine();
        }catch(IOException e){
            e.getMessage();
        }
 
        subtracaonum obj = new subtracaonum();
    }
    }