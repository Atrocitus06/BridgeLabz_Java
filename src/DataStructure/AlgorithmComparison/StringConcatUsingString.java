package DataStructure.AlgorithmComparison;
public class StringConcatUsingString {

    public static void main(String[] args) {

        String str = "";

        for (int i = 0; i < 1000; i++) {
            str = str + "a";
        }

        System.out.println("Final String Length: " + str.length());
    }
}