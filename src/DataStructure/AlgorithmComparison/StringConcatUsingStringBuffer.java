package DataStructure.AlgorithmComparison;
public class StringConcatUsingStringBuffer {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < 1000; i++) {
            sb.append("a");
        }

        System.out.println("Final String Length: " + sb.length());
    }

}