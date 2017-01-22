/*

Given a sequence of words, print all anagrams together | Set 1

Given an array of words, print all anagrams together. For example, if the given array is {cat, dog, tac, god, act}, then output may be 
'cat tac act dog god'.
*/
package Strings;
import java.util.*;
class PrintAnagramsTogether
{
	/* To store words and corresponding original index*/
	static class Word
	{
		String word;
		int index;

		Word(String word,int index)
		{
			this.word = word;
			this.index = index;
		}
	}

	public static void printAnagramsTogether(String[] arr)
	{
		Word[] words = new Word[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			Word word = new Word(arr[i],i);
			words[i]= word; 
		}

		/*Sort each individual word*/	
		for(int i=0;i<words.length;i++)
		{
			char[] sortedWord = words[i].word.toCharArray();
			Arrays.sort(sortedWord);
			words[i].word = String.valueOf(sortedWord);
		}

		/*Sort all the words*/
		Arrays.sort(words, new Comparator<Word>(){
			public int compare(Word w1, Word w2)
			{
				return w1.word.compareTo(w2.word);	
			}
		});

		for(int i=0;i<words.length;i++)
		{
			int index = words[i].index;
			System.out.println(arr[index]);
		}	
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.next();
		}
		printAnagramsTogether(arr);		
		sc.close();				
	} 



}