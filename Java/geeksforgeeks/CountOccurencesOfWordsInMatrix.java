/*

Find all occurrences of a given word in a matrix

Given a 2D grid of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said be found in a direction if all characters match in this direction (not in zig-zag form).

The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up and 4 Diagonals.

Input:
mat[ROW][COL]= { {'B', 'N', 'E', 'Y', 'S'},
     	         {'H', 'E', 'D', 'E', 'S'},
	             {'S', 'G', 'N', 'D', 'E'}
               };
Word = DES

Output:
D(1, 2) E(1, 1) S(2, 0) 
D(1, 2) E(1, 3) S(0, 4) 
D(1, 2) E(1, 3) S(1, 4)
D(2, 3) E(1, 3) S(0, 4)
D(2, 3) E(1, 3) S(1, 4)
D(2, 3) E(2, 4) S(1, 4)
*/
package geeksforgeeks;
import java.util.*;
class CountOccurencesOfWordsInMatrix
{

	public static void countOccurence(String word, char[][] mat)
	{
		int m = mat.length;
		int n = mat[0].length;
		char start = word.charAt(0);
		for(int i=0; i<mat.length;i++)
		{
			for(int j=0; j<mat[0].length;j++)
			{
				if(start == mat[i][j])
				{
					String path = start+"("+i+","+j+") ";// check next character in all neighbours
					System.out.println("inside if:"+i+" "+j );
					checkNeighbours(mat,word,1,i,j,path);
				}
			}
		}

	}

	public static void checkNeighbours(char[][] mat, String word,int index,int row, int col, String path)
	{
		int minRow = row-1;
		int maxRow = row+1;
		int minCol = col-1;
		int maxCol = col+1;

		if(minRow < 0){
			minRow=0;
		}

		if(maxRow > mat.length-1){
			maxRow = mat.length-1;
		}

		if(minCol<0){
			minCol=0;
		}

		if(maxCol>mat[0].length-1){
			maxCol=mat[0].length-1;
		}

		/*System.out.println("next char to be found "+word.charAt(index));
		System.out.println("minRow: "+minRow+" maxRow: "+maxRow);
		System.out.println("minCol: "+minCol+" maxCol: "+maxCol);*/
		for(int i=minRow;i<=maxRow;i++){
			for(int j=minCol;j<=maxCol;j++)
			{
				//System.out.println("mat[i][j]: "+mat[i][j]);
				if(mat[i][j] == word.charAt(index)){
					//System.out.println("Char found:"+mat[i][j]);
					if(index==word.length()-1){
						//return true;
						String actualPath=path;
						String appendPath = mat[i][j]+"("+i+","+j+") "; 
						path += appendPath;
						System.out.println(path);
						path=actualPath;
					}else{
						String actualPath=path;
						String appendPath = mat[i][j]+"("+i+","+j+") "; 
						path += appendPath;
						checkNeighbours(mat,word,index+1,i,j,path);
						path=actualPath;	
					}
				}
			}
		}

	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		char mat[][] = new char[m][n];
		for(int i=0; i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				mat[i][j] = s.next().charAt(0);
			}
		}

		String word = s.next();

		countOccurence(word,mat);
		/*display elements*/
		/*for(int i=0; i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}*/
	}

}