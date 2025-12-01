class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    private Node head;
    private int size;
    
    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            newNode.next = head;
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            newNode.next = head;
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }
    
    public void removeFirst() {
        if (head == null) return;
        
        if (head.next == head) {
            head = null;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
        }
        size--;
    }
    
    public void removeLast() {
        if (head == null) return;
        
        if (head.next == head) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != head) {
                current = current.next;
            }
            current.next = head;
        }
        size--;
    }
    
    public void remove(int data) {
        if (head == null) return;
        
        if (head.data == data) {
            removeFirst();
            return;
        }
        
        Node current = head;
        while (current.next != head) {
            if (current.next.data == data) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }
    
    public boolean contains(int data) {
        if (head == null) return false;
        
        Node current = head;
        do {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void display() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }
        
        Node current = head;
        System.out.print("Список: ");
        do {
            System.out.print(current.data);
            if (current.next != head) {
                System.out.print(" -> ");
            }
            current = current.next;
        } while (current != head);
        System.out.println();
    }
    
    public void clear() {
        head = null;
        size = 0;
    }
    
    public void rotate() {
        if (head != null) {
            head = head.next;
        }
    }
    
    public boolean findCycle() {
        return head != null;
    }
    
    public CircularLinkedList[] splitIntoTwo() {
        CircularLinkedList[] result = new CircularLinkedList[2];
        result[0] = new CircularLinkedList();
        result[1] = new CircularLinkedList();
        
        if (head == null) return result;
        
        int mid = size / 2;
        Node current = head;
        
        for (int i = 0; i < mid; i++) {
            result[0].addLast(current.data);
            current = current.next;
        }
        
        for (int i = mid; i < size; i++) {
            result[1].addLast(current.data);
            current = current.next;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        
        System.out.println("Добавляем элементы:");
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(5);
        list.addLast(30);
        list.display();
        
        System.out.println("Размер: " + list.size());
        System.out.println("Пуст ли список: " + list.isEmpty());
        
        System.out.println("Содержит 20: " + list.contains(20));
        System.out.println("Содержит 15: " + list.contains(15));
        
        System.out.println("Проверка цикла: " + list.findCycle());
        
        System.out.println("Циклический сдвиг:");
        list.rotate();
        list.display();
        
        System.out.println("Разделение на два списка:");
        CircularLinkedList[] halves = list.splitIntoTwo();
        System.out.println("Первый список:");
        halves[0].display();
        System.out.println("Второй список:");
        halves[1].display();
        
        System.out.println("Удаляем первый элемент:");
        list.removeFirst();
        list.display();
        
        System.out.println("Удаляем последний элемент:");
        list.removeLast();
        list.display();
        
        System.out.println("Удаляем элемент 20:");
        list.remove(20);
        list.display();
        
        System.out.println("Очищаем список:");
        list.clear();
        list.display();
        System.out.println("Пуст ли список: " + list.isEmpty());
    }
}