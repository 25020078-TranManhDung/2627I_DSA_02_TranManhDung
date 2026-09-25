import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstline = br.readLine();
        if (firstline == null) return;

        int q = Integer.parseInt(firstline.trim());

        StringBuilder current = new StringBuilder();
        Stack<String[]> history = new Stack<>();

        for (int i = 0; i < q; i++) {
            String line = br.readLine();
            if (line == null) break;

            String[] parts = line.split(" ");
            int type = Integer.parseInt(parts[0]);

            if (type == 1) {
                String w = parts[1];
                history.push(new String[]{"1", String.valueOf(w.length())});
                current.append(w);
            }

            else if (type == 2) {
                int k = Integer.parseInt(parts[1]);
                String deleted = current.substring(current.length() - k);
                history.push(new String[]{"2", deleted});
                current.delete(current.length() - k, current.length());
            }
            else if (type == 3) {
                int k = Integer.parseInt(parts[1]);
                System.out.println(current.charAt(k - 1));
            }
            else if (type == 4) {
                if (!history.isEmpty()) {
                    String[] op = history.pop();
                    if (op[0].equals("1")) {
                        int len = Integer.parseInt(op[1]);
                        current.delete(current.length() - len, current.length());
                    } else {
                        current.append(op[1]);
                    }
                }
            }

        }
        br.close();
    }
}
