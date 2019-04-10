package HuaweiTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] list = new String[n];
        String s = "";
        ArrayList<String> res = new ArrayList<>();
        list = in.nextLine().split(" ");
        for(int i=0;i<list.length;i++){
            String temp = list[i];
            while(temp.length()%8!=0){
                temp = temp+"0";
            }
            for(int j=0;j<temp.length();j=j+8){
                res.add(temp.substring(j,j+8));
            }
        }
        Collections.sort(res);
        for(int i=0;i<res.size();i++){
            if(i<res.size()-1) {
                System.out.print(res.get(i) + " ");
            }else{
                System.out.println(res.get(i));
            }
        }

    }
}