package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	public int verify (String candidateSolution)
    {
		/*
		 * Return 0: means it is a valid Sudoku solution
		 * Return -1: means it is violating Rule #1
		 * Return -2: means it is violating Rule #2
		 * Return -3: means it is violating Rule #3
		 * Return -4: means it is violating Rule #4
		 */
		// Ponemos el los numeros del String en filas de 9 dígitos
		String[] rows = SplitRows(candidateSolution);
				
		// Ponemos el los numeros del String en columnas de 9 dígitos
		String[] columns = SplitColumns(candidateSolution);
		
		//comprobamos si los digitos estan comprendidos entre el 1 y el 9
		for (int i = 0; i<rows.length;i++){
			char[] row = rows[i].toCharArray();
			for (int j = 0; j < row.length; j++)
			{
				if(Character.getNumericValue(row[j]) < 1 || Character.getNumericValue(row[j]) > 9)
					return -1;
			}
		}
		
		// inicializamos el tablero (9x9)
				int[][] mainGrid = new int[9][9];
				
				for (int i = 0; i < 9; i++)
				{
					char[] rowsElements = rows[i].toCharArray();
					
					for (int j = 0; j < 9; j++)
					{	
						mainGrid[i][j] = Character.getNumericValue(rowsElements[j]);
					}
				}
				
				//imprimimos
				for (int i = 0; i < 9; i++)
				{
					for (int j = 0; j < 9; j++)
					{	
						System.out.print(mainGrid[i][j] + "  ");
					}
					System.out.println();
				}
				System.out.println();
				
				
				
				// creamos las submallas (3x3)
				
				int[][] subGrid = new int[3][3];		
				
				for(int i = 0; i < 9; i+=3)
				{
					for(int j = 0; j < 9; j+=3)
					{
						for (int k = 0; k < 3; k++)
						{	
							for (int l = 0; l < 3; l++)
							{	
								subGrid[k][l] = mainGrid[i+k][j+l];					
							}
						}
						
						//imprimimos
						for (int m = 0; m < 3; m++)
						{
							for (int n = 0; n < 3; n++)
							{	
								System.out.print(subGrid[m][n] + "  ");
							}
							System.out.println();
						}
						System.out.println();
						System.out.println();
						
						
						
						if (CheckTheGrid(subGrid) != true)
						{
							return -2;
						}
						else
						{
							subGrid = new int[3][3];
						}
					}
				}
				
				// iteramos por las filas para ver si algun digito aparece dos veces, si esto pasa la función devuelve -3 como se indica enel enunciado
				for (int i = 0; i < rows.length; i++) {
					char[] charArray = rows[i].toCharArray();
					int[] integerArray = new int[9];

					for (int j = 0; j < integerArray.length; j++) {
						integerArray[j] = Character.getNumericValue(charArray[j]);
					}

					for (int k = 0; k < integerArray.length - 1; k++) {
						for (int l = k + 1; l < integerArray.length; l++) {
							if (integerArray[k] == integerArray[l])
								return -3;
						}
					}
				}
				
				//Lo mismo que arriba pero iterando por las columnas, solo que en este caso se devuelve un -4 como se indica en el enunciado
				
				for (int i = 0; i < columns.length; i++) {
					char[] charArray = columns[i].toCharArray();
					int[] integerArray = new int[9];

					for (int j = 0; j < integerArray.length; j++) {
						integerArray[j] = Character.getNumericValue(charArray[j]);
					}

					for (int k = 0; k < integerArray.length - 1; k++) {
						for (int l = k + 1; l < integerArray.length; l++) {
							if (integerArray[k] == integerArray[l])
								return -4;
						}
					}
				}
				
				//la solucion es correcta
				return 0;
			}//
	public boolean CheckSolutionLength(String solution)
	{
		if(solution.length() == 81)
			return true;
		else
			return false;
	}
	
	public String[] SplitRows(String string)
	{
		int startIndex = 0;
		int endIndex = 9;
		String[] strings = new String[9];
		
		for (int i = 0; i < 9; i++, startIndex += 9, endIndex += 9)
		{
			String row = string.substring(startIndex, endIndex);
			strings[i] = row;
		}
		
		return strings;
	}
	
	
	
	public String[] SplitColumns(String string)
	{
		char[] charArray = string.toCharArray();
		String[] columns = new String[9];
		int columnNumber = 0;
		boolean first = true;
		
		for(int i = 0; i < string.length(); i++, columnNumber++)
		{
			if(columnNumber == 9)
			{
				columnNumber = 0;
				first = false;
			}
			
			int integer = Character.getNumericValue(charArray[i]);
			
			if(first)
				columns[columnNumber] = "" + String.valueOf(integer);
			else
				columns[columnNumber] = columns[columnNumber] + String.valueOf(integer);
		}
		
		return columns;
	}
	public boolean CheckTheGrid(int[][] grid)
	{
		
		int[] array = new int[9];
		int counter = 0;
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{	
				array[counter] = grid[i][j];
				counter++;
			}
		}
		
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j])
					return false;
			}
		}
		
		return true;
	}
	
}