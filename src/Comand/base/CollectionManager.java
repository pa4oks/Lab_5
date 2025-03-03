package Comand.base;
import Model.LabWork;

import java.util.Collection;
import java.util.PriorityQueue;

public class CollectionManager {
    public static PriorityQueue<LabWork> priorityQueue;
    public static PriorityQueue<LabWork> getCollection(){
        return priorityQueue;
    }
    public static void add(LabWork labWork){
        priorityQueue.add(labWork);
    }
    public static void remove(LabWork labWork){
        priorityQueue.remove(labWork);
    }
    public static void removeByID(int idToRemove){
        priorityQueue.removeIf(item -> item.getId() == idToRemove);
    }
    public static void clear(){
        priorityQueue.clear();
    }
    public static void removeFirst(){
        priorityQueue.remove(0);
    }
    public static void head(){
        LabWork highestPriorityElement = priorityQueue.peek(); // Получаем элемент с наивысшим приоритетом
        if (highestPriorityElement != null) {
            System.out.println("Первый элемент: " + highestPriorityElement);
        } else {
            System.out.println("Очередь пуста.");
        }
    }
    public static void remove_lower(LabWork lastElementUnderDelete){
        priorityQueue.removeIf(item -> item.getId() < lastElementUnderDelete.getId());
    }

}
