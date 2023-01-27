import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class program {
    public static void main(String[] args) throws IOException {
        int[] ab = ImportFromTXT("data1.txt");
        int a = ab[0];
        int b = ab[1];
        int result = degre(a, b);
        System.out.println(result);
        String textresult = "Число a = " + a + ", в степени b = " + b + ", равно " + result;
        System.out.println(textresult);
        SaveTofile("result.txt", textresult);
    }

    public static int[] ImportFromTXT(String string) {
        String line;
        int[] ab = new int[2];
        try (FileReader reader = new FileReader(new File(string))) {
            BufferedReader br = new BufferedReader(reader);
            while ((line = br.readLine()) != null) {
                String[] curline;
                curline = line.split(" ");
                switch (curline[0]) {
                    case ("a"):
                        ab[0] = (Integer.parseInt(curline[1]));
                        break;
                    case ("b"):
                        ab[1] = (Integer.parseInt(curline[1]));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ab;
    }

    public static int degre(int a, int b) {
        int res = a;
        for (int i = 1; i < b; i++) {
            res = res * a;
        }
        return res;
    }

    public static void SaveTofile(String str, String res) throws IOException {
        try (FileWriter file = new FileWriter(new File(str), false)) {
            file.write(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
