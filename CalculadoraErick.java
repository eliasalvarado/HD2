public class CalculadoraErick implements IPosfixCalc{
	private char[] operators = new char[]{'-','+','*','/'};
	StackArrayList<Double> lista;

	@Override
	public int Evaluate(String expresion) {
		lista = new StackArrayList<Double>();
		expresion = expresion.replace(" ", "");
		for(int i = 0; i<expresion.length();i++) {
			if(!isANumber(expresion.charAt(i)) && !(new String(operators).contains(Character.toString(expresion.charAt(i)))))
				return -1;
			else if(isANumber(expresion.charAt(i))) {
				String numberText = Character.toString(expresion.charAt(i));
				double number = Integer.parseInt(numberText);
				lista.push(number);
			}else {
				if(lista.count()<2)
					return -1;
				else if(!lista.isEmpty())
					try {
						selectOperation(expresion.charAt(i));
					}catch(ArithmeticException e){
						throw e;
					}
			}
		}
		
		return (int)Math.round(lista.peek());
	}
	
	private boolean isANumber(char character) {
		try {
			Integer.parseInt(Character.toString(character));
		}catch(Exception e) {
			return false;
		}
		return true;
			
	}
	
	private void selectOperation(char operator) throws ArithmeticException{
		double num1 = 0;
		double num2 = 0;
		switch(operator) {
		case '+':
			num1 = lista.pull();
			num2 = lista.pull();
			lista.push(num2+num1);
			break;
		case '-':
			num1 = lista.pull();
			num2 = lista.pull();
			lista.push(num2-num1);
			break;
		case '/':
			double resultado = 0;
			num1 = lista.pull();
			num2 = lista.pull();
			resultado = num2/num1;
			if(Double.isInfinite(resultado))
				throw new ArithmeticException("/ by 0");
			lista.push(resultado);
			break;
		case '*':
			num1 = lista.pull();
			num2 = lista.pull();
			lista.push(num2*num1);
			break;
		}
	} 
}
