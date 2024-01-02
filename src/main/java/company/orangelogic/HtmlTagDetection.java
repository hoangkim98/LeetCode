package company.orangelogic;

import java.util.Stack;

public class HtmlTagDetection {

   public static String abc(String str){
       Stack<String> strStack = new Stack<>();
       int startIdx = 0;
       boolean isCloseTag = false;

       for(int i=0;i<str.length();i++){
           if(str.charAt(i) == '<'){
               isCloseTag = str.charAt(i + 1) == '/';
               startIdx = i;
               while(str.charAt(i) != '>'){
                   i++;
               }
           }

           if(isCloseTag){
               String content = str.substring(startIdx+2,i);
               if(strStack.peek().equalsIgnoreCase(content)){
                   strStack.pop();
               }
           }else{
               strStack.push(str.substring(startIdx+1,i));
           }
       }
       if(strStack.isEmpty()){
           return "true";
       }else{
           return strStack.peek();
       }
   }

    public static void main(String[] args) {
        System.out.println(abc("<div><div><b></b></div></p>"));
    }
}
