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
    /*public void update_id(long id) throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        Iterator<LabWork> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            LabWork lb = iterator.next();
            long currentId = lb.getId();

            if (currentId == id) {
                System.out.println("Введите имя: ");
                lb.setName(in.nextLine());
                lb.setCoordinates(CoordinateReaderCreator());
                System.out.println("Введите Минимальный Пойнт: ");
                lb.setMinimalPoint(Double.parseDouble(in.nextLine()));
                System.out.println("Введите сложность: ");
                lb.setDifficulty(Difficulty.valueOf(in.nextLine()));
                lb.setAuthor(PersonReaderCreator());
                break;
            }
        }

    }*/
    public static void removeByID(long idToRemove){
        priorityQueue.removeIf(item -> item.getId() == idToRemove);
    }
    /*public static void clear(){
        priorityQueue.clear();
    }
    public static void remove_first(){
        priorityQueue.remove(0);
    }
    public static void head(){
        LabWork highestPriorityElement = priorityQueue.peek(); // Получаем элемент с наивысшим приоритетом
        if (highestPriorityElement != null) {
            System.out.println("Первый элемент: " + highestPriorityElement);
        } else {
            System.out.println("Очередь пуста.");
        }
    }*/
    /*public static void remove_lower(long lastElementUnderDelete){
        priorityQueue.removeIf(item -> item.getId() < lastElementUnderDelete);
    }*/
    /*public static void remove_any_by_author(Person author){
        priorityQueue.removeIf(item -> item.getAuthor().equals(author));
    }*/
    /*public static void count_greater_than_minimal_point(Double minimalPoint){
        priorityQueue.removeIf(item -> item.getMinimalPoint() >= minimalPoint);
    }*/
    /*public static void print_descending(){
        PriorityQueue<LabWork> queueCopy = new PriorityQueue<>(priorityQueue);

        ArrayList<LabWork> reveredQueue = new ArrayList<>();
        while (!queueCopy.isEmpty()) {
            reveredQueue.add(queueCopy.poll()); //poll возвращает элемент очереди, удаляя его
        }

        Collections.sort(reveredQueue, Collections.reverseOrder());
        System.out.println("Элементы в порядке убывания: " + reveredQueue);
    }*/
    /*public static void show(){
        priorityQueue.forEach(LabWork::print);
    }*/
}
