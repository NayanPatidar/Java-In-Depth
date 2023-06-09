package Stack;

public class Reverser {
    String input;
    String output;
    public Reverser(String in){
        input = in;
    }

    public String stringReverse(){
        int i;
        int StackSize = input.length();
        StackX obj = new StackX(StackSize);

        for (i = 0 ; i < input.length() ; i++){
              char letterInput = input.charAt(i);

              obj.push(letterInput);
        }
        output = "";
        do {
            char letterOutput = obj.pop();
            output = output + letterOutput;
        }while (!obj.isEmpty());

        return output;
    }

}
