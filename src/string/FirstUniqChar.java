package string;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class FirstUniqChar
{
	public static int firstUniqChar(String s) {
		char[] strArr = s.toCharArray();
		List<Integer> savedIdx = new ArrayList<>();
		Map<Character, Integer> map = new LinkedHashMap<>();
		for(int i=0;i<strArr.length;i++){
			char value = strArr[i];
			if(map.get(value) == null){
				map.put(value, 0);
				savedIdx.add(i);
			}
			map.put(value, map.get(value) + 1);
		}
		int count = 0;
		int[] savedIdxArr = savedIdx.stream().mapToInt(i->i).toArray();
		for(Map.Entry<Character, Integer> entry: map.entrySet()){
			if(entry.getValue() == 1){
				return savedIdxArr[count];
			}
			count++;
		}
		return -1;
	}


	public static void main(String[] args)
	{
		String str = "leetcode";
		System.out.println(firstUniqChar(str));
	}
}
