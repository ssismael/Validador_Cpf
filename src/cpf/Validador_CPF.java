package cpf;

import java.util.Scanner;

public class Validador_CPF {
	//dedmeodmeodmeomdodmoemdoemdoemdoedoemdoeodmeodoedmeodmeodoedmeodmeodmeodmeodmoedmeodmeodeodeommdoemo
	//emdoememdoedomemdoeomdmoedmoeomdmsçalds,ldmalrfmo
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite o CPF :");
		String cpfDigitado = teclado.nextLine();
		
		if (validarCPF(cpfDigitado)) {
			System.out.println("Resultado: Valido!");
		}else {
			System.out.println("Resultado: inválido");
			
		}
		teclado.close();
	}
	
	public static boolean validarCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");
		
		if (cpf.length() != 11) {
			return false;
			
		}
		int soma1 =  0;
		int multipli1= 10;
		
		for (int i=0; i<9; i++) {
			int alga = Character.getNumericValue(cpf.charAt(i));
			
			soma1 = soma1+ (alga *multipli1);
			multipli1= multipli1 -1;
			
		}
		
		int resto1= soma1 %11;
		int dig1Calculado;
		if (resto1<2) {
			dig1Calculado = 0;
		}else {
			dig1Calculado = 11 - resto1;
		}
		
		int soma2= 0;
		int multipli2 = 11;
		
		for (int i=0; i<10; i++) {
		    int alga = Character.getNumericValue(cpf.charAt(i));
		    soma2 = soma2 + (alga * multipli2);
		    multipli2--;
			
		}
		
		int resto2 = soma2 %11;
		
		int dig2Calculado;
		
		if (resto2<2) {
			dig2Calculado= 0;
		}else {
			dig2Calculado =11 -resto2;	
			
		}
		int digito1Real = Character.getNumericValue(cpf.charAt(9));
		int digito2Real = Character.getNumericValue(cpf.charAt(10));
		
		if (dig1Calculado == digito1Real && dig2Calculado ==digito2Real) {
			return true;
		}else {
			return false;
			
		}
	}

}
