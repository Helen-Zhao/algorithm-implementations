/**
 * Created by helen on 11/02/2017.
 */
public class UniqueString {
    private final String input;

    public UniqueString(String input) {
        this.input = input;
    }

    public boolean determineUnique() {
        int[] chars = new int[256];
        for(char c : input.toCharArray()){
            if (chars[c] > 0){
                return false;
            }
            chars[c]++;
        }
        return true;
    }
}
