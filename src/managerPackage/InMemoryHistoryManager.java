package managerPackage;

import taskPackage.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private MyLinkedList<Task> browsingHistory = new MyLinkedList<>();
    private HashMap<Integer,Node> historyMap = new HashMap<>();

    @Override
    public void add(Task task){
        remove(task.getId());
        Node<Task> newNode = browsingHistory.linkLast(new Task(task));
        historyMap.put(task.getId(), newNode);
    }

    @Override
    public void remove(int id) {
        Node<Task> nodeToDelete = historyMap.getOrDefault(id,null);
        if (nodeToDelete != null) {
            browsingHistory.removeNode(nodeToDelete);
            historyMap.remove(id);
        }
    }
    @Override
    public ArrayList<Task> getHistory(){
        return browsingHistory.getTasks();
    }


}

 class MyLinkedList <T> {
      /**
      * Указатель на первый элемент списка. Он же first
      */
     private Node<T> head;

     /**
      * Указатель на последний элемент списка. Он же last
      */
     private Node<T> tail;

     private int size = 0;

     public Node<T> linkLast(T element) {
         final Node<T> oldtail = tail;
         final Node<T> newNode = new Node<>(oldtail, element, null);
         tail = newNode;
         if (oldtail == null)
             head = newNode;
         else
             oldtail.next = newNode;
         size++;
         return newNode;
     }

     public void removeNode(Node nodeToDelete) {

         if (nodeToDelete.prev == null && nodeToDelete.next == null){
             head = null;
             tail = null ;
         } else {

         if (nodeToDelete.prev == null){
             head = nodeToDelete.next;
             nodeToDelete.next.prev = null;
         };

         if (nodeToDelete.next == null){
             tail = nodeToDelete.prev;
             nodeToDelete.prev.next = null;
         };
         if (nodeToDelete.prev != null && nodeToDelete.next != null){
             nodeToDelete.prev.next = nodeToDelete.next;
             nodeToDelete.next.prev = nodeToDelete.prev;
         }}
         size--;
     }
     public ArrayList<T> getTasks() {
         Node<T> curhead = head;
         ArrayList<T> list = new ArrayList<>();
         while (curhead != null) {
             list.add(curhead.data);
             curhead = curhead.next;
         }
         return list; }

     public int size() {
         return this.size;
     }


 }
