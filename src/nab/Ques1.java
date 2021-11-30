package nab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


public class Ques1
{
	public static String solution(String message, int K) {
		// write your code in Java SE 8
		if(K>= message.length() || message.length() == 0){
			return message;
		}
		int prevSpace = 0;

		char[] strArr = message.toCharArray();
		for(int i = 0; i<strArr.length;i++){
			if(strArr[i] == ' '){
				prevSpace = i;
			}
			if(i > K - 1){
				break;
			}
		}
		return new String(Arrays.copyOfRange(strArr, 0, prevSpace));
	}

	public static void main(String[] args)
	{
		String test = "abc xyz";
		String res = solution(test, 7);
		System.out.print(res);

	}
}
