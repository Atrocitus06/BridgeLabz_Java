package DataStructure.AlgorithmComparison;
public class StringConcatUsingStringBuilder {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 1000; i++) {
            sb.append("a");
        }

        System.out.println("Final String Length: " + sb.length());
    }
}
