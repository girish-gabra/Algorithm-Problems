
# Print all interleavings of given two strings

# Given two strings str1 and str2, write a function that prints all interleavings of the given two strings. You may assume that all characters in both strings are different

# Example:

# Input: str1 = "AB",  str2 = "CD"
# Output:
#     ABCD
#     ACBD
#     ACDB
#     CABD
#     CADB
#     CDAB

# Input: str1 = "AB",  str2 = "C"
# Output:
#     ABC
#     ACB
#     CAB

def toString(iStrList):
	return "".join(iStrList)

def printILSRecur(str1,str2,iStr,m,n,i):

	#When both strings are processed
	if(m==0 and n==0):
		print toString(iStr)

	if m!=0:	
		iStr[i]=str1[0]
		printILSRecur(str1[1:],str2,iStr,m-1,n,i+1)

	if n!=0:
		iStr[i]=str2[0]
		printILSRecur(str1,str2[1:],iStr,m,n-1,i+1)


def printILS(str1,str2,m,n):
	iStr = ['']*(m+n)
	printILSRecur(str1,str2,iStr,m,n,0)		# recursive function to print interleaving strings


str1="AB"
str2="CD"

printILS(str1,str2,len(str1),len(str2))