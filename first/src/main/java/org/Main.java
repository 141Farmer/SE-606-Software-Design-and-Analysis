package org;
import com.Utils;
import com.google.gson.Gson;



public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World  from first project!");
        Utils.print();
        Gson gson = new Gson();
        String json = gson.toJson(new String[] {"a", "b", "c"});
        System.out.println(json);
    }
}