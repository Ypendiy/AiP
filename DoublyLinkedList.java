class Node {
    int data;
    Node prev;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public void removeFirst() {
        if (head == null) return;
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    
    public void removeLast() {
        if (tail == null) return;
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
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
        while (current != null) {
            if (current.data == data) {
                if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return;
            }
            current = current.next;
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
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }
    
    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }
    
    public void remove2(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }
    
    public int get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Список пуст");
            return;
        }
        Node current = tail;
        System.out.print("Список в обратном порядке: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }
        System.out.println();
    }
    
    public int getFirst() {
        if (head == null) {
            System.out.println("Список пуст");
            return 0;
        }
        return head.data;
    }
    
    public int getLast() {
        if (tail == null) {
            System.out.println("Список пуст");
            return 0;
        }
        return tail.data;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("Добавляем элементы:");
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(5);
        list.addLast(30);
        list.display();
        System.out.println("Добавляем 15 по индексу 2:");
        list.add(2, 15);
        list.display();
        System.out.println("Элемент по индексу 3: " + list.get(3));
        System.out.println("Первый элемент: " + list.getFirst());
        System.out.println("Последний элемент: " + list.getLast());
        System.out.println("Вывод в обратном порядке:");
        list.displayReverse();
        System.out.println("Удаляем по индексу 1:");
        list.remove2(1);
        list.display();
        System.out.println("Содержит 15: " + list.contains(15));
        System.out.println("Размер: " + list.size());
        System.out.println("Пуст ли список: " + list.isEmpty());
        System.out.println("Удаляем элемент 20:");
        list.remove(20);
        list.display();
        System.out.println("Очищаем список:");
        list.clear();
        list.display();
        System.out.println("Пуст ли список: " + list.isEmpty());
    }
}