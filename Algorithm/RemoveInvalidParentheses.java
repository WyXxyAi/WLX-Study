package Algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        StringBuffer ss = new StringBuffer(s);
        List<String> res = new ArrayList<>();
        int left=0;
        res.add(s);
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i)=='('){
                left+=1;
            }else if (ss.charAt(i)==')'&&left>0){
                left-=1;
            }else if (ss.charAt(i)==')'&&left<=0){
                ss.deleteCharAt(i);
                i--;
            }
        }
        res.add(ss.toString());
        return res;
    }

    public static void main(String[] args) {
        String s = "((aaaa))b)(a)))c)d";
        List list= new RemoveInvalidParentheses().removeInvalidParentheses(s);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
