package easy.string;

public class ReverseString
{
	public  static void reverseString(char[] s) {
		int size = s.length;
		int count = 0;
		while(size > count){
			char temp = s[count];
			s[count] = s[size - 1];
			s[size - 1] = temp;
			count++;
			size--;
		}
	}


	public static void main(String[] args)
	{
		char[] str = {'h', 'e', 'l', 'l', 'o'};
		reverseString(str);
		System.out.println(str);
	}
}
