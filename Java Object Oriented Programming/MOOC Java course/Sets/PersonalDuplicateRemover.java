package Sets;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {

    private Map<String, Integer> duplicateCounter;


    public PersonalDuplicateRemover() {
        this.duplicateCounter = new HashMap<String, Integer>();
    }

    @Override
    public void add(String characterString) {
        this.duplicateCounter.merge(characterString, 1, Integer::sum);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        int duplicates = 0;
        for (String key : this.duplicateCounter.keySet()) {
            if (this.duplicateCounter.get(key) > 1) {
                duplicates ++;
            }
        }
        return duplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.duplicateCounter.keySet();
    }

    @Override
    public void empty() {
        this.duplicateCounter = new HashMap<String, Integer>();
    }
    
    public static void main(String[] args) {
        DuplicateRemover remover = new PersonalDuplicateRemover();
        remover.add("first");
        remover.add("second");
        remover.add("first");

        System.out.println("Current number of duplicates: " +
            remover.getNumberOfDetectedDuplicates());

        remover.add("last");
        remover.add("last");
        remover.add("new");

        System.out.println("Current number of duplicates: " +
            remover.getNumberOfDetectedDuplicates());

        System.out.println("Unique characterStrings: " +
            remover.getUniqueCharacterStrings());

        remover.empty();

        System.out.println("Current number of duplicates: " +
            remover.getNumberOfDetectedDuplicates());

        System.out.println("Unique characterStrings: " +
            remover.getUniqueCharacterStrings());
    }

}