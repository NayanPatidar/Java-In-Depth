package Stack;

public class DelimiterMatching {
    private String input;
    private String output;

    public DelimiterMatching(String in) {
        input = in;
    }

    public void check() {
        int i;
        char c = ' ';
        StackX stackX = new StackX(input.length());

        for (i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch)
            {
                case '{':
                case '(':
                case '[':
                    stackX.push(ch);
                    break;

                case '}':
                case ')':
                case ']':
                    if (!stackX.isEmpty()) {
                        char chx = stackX.pop();
                        if (    ch == ')' && chx != '(' ||
                                ch == '}' && chx != '{' ||
                                ch == ']' && chx != '['    ) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                      }
                    break;
            }
        }
        if (!stackX.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}

