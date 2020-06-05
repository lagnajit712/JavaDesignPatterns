package com.str;

public class StrPrograms {
  public static void main(String[] args) {

    String s="Hello";
    System.out.println("Lenght of string "+s+" is "+length(s));
    System.out.println("Reverse of string "+s+" is "+reverse(s));
    isAnagram("Mother In Law", "Hitler Woman");
    reverseEachWordOfString("Java Concept Of The Day");
    StringPermutation("JSP");
  }
  public static int length(String str){
    if(str.equals("")){
      return 0;
    }else{
      System.out.println("Lenght of substring is "+str.substring(1));
      return length(str.substring(1))+1;
    }
  }

  public static  String reverse(String str)
  {
    if ((null == str) || (str.length() <= 1))
    {
      return str;
    }

    return reverse(str.substring(1)) + str.charAt(0);
  }
  public static void isAnagram(String s1, String s2)
  {
    //Removing white spaces from s1 and s2 and changing case to lower

    String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();

    String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();

    //Initially setting status as true

    boolean status = true;

    if(copyOfs1.length() != copyOfs2.length())
    {
      //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length

      status = false;
    }
    else
    {
      //Converting copyOfs1 to char array

      char[] s1ToArray = copyOfs1.toCharArray();

      //Checking whether each character of s1ToArray is present in copyOfs2

      for (char c : s1ToArray)
      {
        int index = copyOfs2.indexOf(c);

        if(index != -1)
        {
          //If character is present in copyOfs2, removing that char from copyOfs2

          copyOfs2 = copyOfs2.substring(0, index)+copyOfs2.substring(index+1, copyOfs2.length());
        }
        else
        {
          //If character is not present in copyOfs2, setting status as false and breaking the loop

          status = false;

          break;
        }
      }
    }

    //Output

    if(status)
    {
      System.out.println(s1+" and "+s2+" are anagrams");
    }
    else
    {
      System.out.println(s1+" and "+s2+" are not anagrams");
    }
  }

  public static void reverseEachWordOfString(String inputString)
  {
    String[] words = inputString.split(" ");

    String reverseString = "";

    for (int i = 0; i < words.length; i++)
    {
      String word = words[i];

      String reverseWord = "";

      for (int j = word.length()-1; j >= 0; j--)
      {
        reverseWord = reverseWord + word.charAt(j);
      }

      reverseString = reverseString + reverseWord + " ";
    }

    System.out.println(inputString);

    System.out.println(reverseString);

    System.out.println("-------------------------");
  }
  static public void StringPermutation(String input)
  {
    StringPermutation("", input);
  }

  private static void StringPermutation(String permutation, String input) {
    if (input.length() == 0) {
      System.out.println(permutation);
    } else {
      for (int i = 0; i < input.length(); i++) {
        StringPermutation(permutation + input.charAt(i), input.substring(0, i) + input.substring(i + 1, input.length()));
      }
    }
  }

}
