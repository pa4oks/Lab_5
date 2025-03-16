package Comand.base;
import Model.Difficulty;
import Comand.base.*;
import Model.*;

import java.util.*;

public class CollectionManager implements ReaderCreator{
    public static PriorityQueue<LabWork> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
    public static PriorityQueue<LabWork> getCollection(){
        return priorityQueue;
    }
    public static void add(LabWork labWork){
        priorityQueue.add(labWork);
    }
    public static void remove(LabWork labWork){
        priorityQueue.remove(labWork);
    }

    public static void removeByID(long idToRemove){
        priorityQueue.removeIf(item -> item.getId() == idToRemove);
    }

}
