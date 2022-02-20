/**
 * Clase Calculadora. Sera la clase encargada de realizar los distintos calculos que el archivo tenga en escritura Postfix
 * @author Elías Alvarado | 21808
 * Fecha: 19 de febrero del 2022
 */

public class Calculadora implements IPosfixCalc
{
	/** 
	 * @param expresion
	 * @return int
	 * @throws ArithmeticException
	 */
	public int Evaluate(String expresion) throws ArithmeticException
	{
		int resultado = 0;
		int op1 = 0;
		int op2 = 0;
		String[] caracteres = expresion.split(" ");
		StackArrayList<Integer> stack = new StackArrayList<>();
		for(String caracter: caracteres)
		{
			if(caracter.equals("+") || caracter.equals("-") || caracter.equals("*") || caracter.equals("/"))
			{
				if(stack.count() <= 1) 
				{
					throw new IllegalArgumentException("\nNo se puede realizar la operacion a falta de operadores."); // pre: Deben existir mas de dos operador. 
				}
				else
				{
					op1 = stack.pull();
					op2 = stack.pull();
					
					if (caracter.equals("+"))
					{
						resultado = op1 + op2; 
					}

					else if (caracter.equals("-"))
					{
						resultado = op2 - op1;
					}

					else if (caracter.equals("*"))
					{
						resultado = op1 * op2;
					}

					else
					{
						if(op1 == 0) throw new IllegalArgumentException("\nNo se puede realizar la division entre 0."); //No se puede dividir en 0
						else resultado = op2 / op1;
					}

					stack.push(resultado);
				}
				
			}
			else stack.push(Integer.parseInt(caracter));
		}
		return resultado;
	}

}