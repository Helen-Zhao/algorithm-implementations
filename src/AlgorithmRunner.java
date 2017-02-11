import java.util.ArrayList;
import java.util.List;

/**
 * Created by helen on 5/01/2017.
 */
public class AlgorithmRunner {

    public static void main(String[] args) {
        AlgorithmRunner algorithmRunner = new AlgorithmRunner();
        ReadyAlgorithm toRun = algorithmRunner.parseInput(args);
        algorithmRunner.run(toRun);
    }

    private void run(ReadyAlgorithm toRun) {
        switch (toRun.getAlgorithmToRun()) {
            case MERGE_SORT:
                MergeSorter ms = new MergeSorter();
                ms.run(toRun.getListInput());
                break;
            case STRING_UNIQUE:
                UniqueString uniqueString = new UniqueString(toRun.getStringInput());
        }
    }

    public ReadyAlgorithm parseInput(String[] args) {
        ReadyAlgorithm readyAlg = new ReadyAlgorithm();
        this.parseAlgorithm(args[0], readyAlg);
        this.parseAlgorithmInputs(args, readyAlg);

        return readyAlg;

    }

    public void parseAlgorithm(String alg, ReadyAlgorithm readyAlg) {
        switch (alg) {
            case "mergesort":
                readyAlg.setAlgorithmToRun(Algorithms.MERGE_SORT);
            case "quicksort":
                readyAlg.setAlgorithmToRun(Algorithms.QUICK_SORT);
            case "heapsort":
                readyAlg.setAlgorithmToRun(Algorithms.HEAP_SORT);
        }
    }

    public void parseAlgorithmInputs(String[] inputs, ReadyAlgorithm readyAlg) {

        List<Integer> inputList = new ArrayList<>();
        //index 0 is ignored as it does not contain input
        for (int i = 1; i < inputs.length; i++) {
            inputList.add((Integer.parseInt(inputs[i])));
        }

        readyAlg.setListInput(inputList);
    }

}

class ReadyAlgorithm {
    Algorithms algorithmToRun;
    List listInput;

    String stringInput;

    public ReadyAlgorithm() {

    }

    public ReadyAlgorithm(Algorithms algorithmToRun, String input) {
        this.algorithmToRun = algorithmToRun;
    }

    public ReadyAlgorithm(Algorithms algorithmToRun, List input) {
        this.algorithmToRun = algorithmToRun;
        this.listInput = input;
    }

    public Algorithms getAlgorithmToRun() {
        return algorithmToRun;
    }

    public void setAlgorithmToRun(Algorithms algorithmToRun) {

    }

    public List getListInput() {
        return listInput;
    }

    public void setListInput(List listInput) {
        this.listInput = listInput;
    }

    public String getStringInput() {
        return stringInput;
    }

    public void setStringInput(String stringInput) {
        this.stringInput = stringInput;
    }
}

