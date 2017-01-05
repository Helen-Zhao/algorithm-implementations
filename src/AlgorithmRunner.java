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
                ms.run(toRun.getInput());
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
        for(int i = 1; i < inputs.length; i++){
            inputList.add((Integer.parseInt(inputs[i])));
        }

        readyAlg.setInput(inputList);
    }



        private class ReadyAlgorithm {
        Algorithms algorithmToRun;
        List input;

        public ReadyAlgorithm() {

        }

        public ReadyAlgorithm(Algorithms algorithmToRun, List input) {
            this.algorithmToRun = algorithmToRun;
            this.input = input;
        }

        public Algorithms getAlgorithmToRun() {
            return algorithmToRun;
        }

        public void setAlgorithmToRun(Algorithms algorithmToRun) {
            this.algorithmToRun = algorithmToRun;
        }

        public List getInput() {
            return input;
        }

        public void setInput(List input) {
            this.input = input;
        }
    }
}

