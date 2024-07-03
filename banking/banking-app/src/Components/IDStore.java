package Components;

import java.util.HashSet;
import java.util.Set;

public class IDStore {
    private Set<Integer> registeredIDs;
    private int currentHighestId = 0;

    public IDStore(){
        this.registeredIDs = new HashSet<>();
    }

    // For generating the lowest available id
    public int generateId(){
        // For looping through the id values under and including the current highest
        for (int i = 1; i <= currentHighestId; i++){
            // Returns the lowest value that is not contained in the registered ids set
            if (!registeredIDs.contains(i)){
                System.out.println(registeredIDs + " does not contain i: " + i);
                registeredIDs.add(i);
                return i;
            }
        }
        // If no ids below the current highest are available, next id is generated and added to the set
        currentHighestId++;
        registeredIDs.add(currentHighestId);
        return currentHighestId;
    }

    public boolean deleteId(int id){
        return registeredIDs.remove(id);
    }
}
