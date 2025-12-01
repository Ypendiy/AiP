class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;
    private int size;
    
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public void addFirst(int data){
        Node newNode = new Node(data); 
        newNode.next = head;            
        head = newNode;                 
        size++;                         
    }
    
    public void addLast(int data){
        Node newNode = new Node(data);
        if (head == null){
           head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public void removeFirst(){
        if (head != null){
            head = head.next;
        }
        size --;
    }
public void removeLast() {
    if (head.next == null) {
        head = null;
    } else {
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    size--;
}
public void remove(int data){
    if (head == null) return;
    if (head.data == data){
        head = head.next;
        size--;
        return;
    }
    Node current = head;
    while (current.next != null){
        if(current.next.data == data) {
            current.next = current.next.next;
            size--;
            return;
        }
    }
}
public boolean contains(int data) {
    Node current = head;
    while (current != null) {
        if (current.data == data) {
            return true;
        }
        current = current.next;
    }
    return false;
}
public int size(){
    return size;
}
public boolean isEmpty(){
    return head == null;
}
public void display() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }
        
        Node current = head;
        System.out.print("Список: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    public void clear() {
        head = null;
        size = 0;
    }
 public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Добавляем элементы:");
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(5);
        list.addLast(30);
        list.display();
        System.out.println("Размер списка: " + list.size());
        System.out.println("Пуст ли список: " + list.isEmpty());
        System.out.println("Содержит 20: " + list.contains(20));
        System.out.println("Содержит 15: " + list.contains(15));
        System.out.println("Удаляем первый элемент:");
        list.removeFirst();
        list.display();
        System.out.println("Удаляем последний элемент:");
        list.removeLast();
        list.display();
        System.out.println("Удаляем элемент 10:");
        list.remove(10);
        list.display();
        System.out.println("Очищаем список:");
        list.clear();
        list.display();
        System.out.println("Размер списка: " + list.size());
        System.out.println("Пуст ли список: " + list.isEmpty());
    }
}







