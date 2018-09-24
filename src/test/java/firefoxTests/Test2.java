package firefoxTests;

/**
 * Created by Gan on 30.09.2017.
 */
public class Test2 {

    public static void main(String args[]) {

        int i = 10;

        while (i > 0){
            System.out.println(Integer.parseInt(random(1))/5);
            i--;
        }



    }

    public static String random (int length) {

        StringBuilder temp = new StringBuilder("1");
        for (int i = 1; i < length; i++) {
            temp.append(0);
        }
        int result = Integer.parseInt(temp.toString());
        return String.valueOf((int)(result + (result*9) * Math.random()));
    }
}


