public class DoubleLinkedListImpl {


    public static void main(String[] args) {
        DoubleLinkedList head = new DoubleLinkedList(1);
        head = head.insert(2);
        head = head.insert(3);
        head = head.insert(4);
        head = head.insert(5);
        head = head.insertAfter(3, 14);
        head = head.remove(4);
        print(head);
    }

    public static void print(DoubleLinkedList list) {
        while(list != null){
            System.out.println(list.value +",");
            list = list.next;
        }
    }

}

class DoubleLinkedList {

    int value;
    DoubleLinkedList next;
    DoubleLinkedList prev;

    public DoubleLinkedList(int value) {
        this.value = value;
    }

    public DoubleLinkedList(int value, DoubleLinkedList next, DoubleLinkedList prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public DoubleLinkedList insert(int value) {
        DoubleLinkedList temp = this;
        while(temp.next != null){
            temp = temp.next;
        }
        DoubleLinkedList newNode = new DoubleLinkedList(value);
        newNode.prev = temp;
        temp.next = newNode;
        return this;
    }

    public DoubleLinkedList insertAfter(int value, int valueToBeInserted){
        DoubleLinkedList temp = this;
        while(temp.next.value != value){
            temp = temp.next;
        }
        DoubleLinkedList newNode = new DoubleLinkedList(valueToBeInserted,temp.next,temp);
        temp.next.prev = newNode;
        temp.next = newNode;
        return this;
    }

    public DoubleLinkedList remove(int value) {
        DoubleLinkedList temp = this;
        while(temp.next.value != value) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
        return this;
    }
}
