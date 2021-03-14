public class DoubleLinkedListImpl
 {
    
    public static void main(String[] args) {

        ListNode listNodes = new ListNode(1);
        listNodes = listNodes.insert(2);
        listNodes = listNodes.insert(3);
        listNodes = listNodes.insert(4);
        listNodes = listNodes.insert(5);
        listNodes = listNodes.insertAfter(2,10);
        listNodes = listNodes.removeNode(3);
        print(listNodes);
        
    }

    public static void print(ListNode listNode){
        while(listNode != null){
            System.out.print(listNode.value+",");
            listNode = listNode.next;
        }
    }
}

class DoubleLinkedListNode{
    int value;
    DoubleLinkedListNode next;
    DoubleLinkedListNode prev;

    public DoubleLinkedListNode(int value){
        this.value = value;
    }

    public DoubleLinkedListNode(int value , DoubleLinkedListNode next, DoubleLinkedListNode prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public DoubleLinkedListNode insert(int value){
        DoubleLinkedListNode temp = this;
        while(temp.next != null){
            temp = temp.next;
        }
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(value);
        newNode.prev = temp;
        temp.next = newNode;
        return this;
    }

    public DoubleLinkedListNode insertAfter(int value,int valueToBeInserted){
        DoubleLinkedListNode temp = this;
        while(temp.value != value){
            temp = temp.next;
        }
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(valueToBeInserted,temp.next,temp.prev);
        temp.next = newNode;
        return this;
    }

    public DoubleLinkedListNode removeNode(int value){
        DoubleLinkedListNode temp = this;
        while(temp.next.value != value){
            temp = temp.next;
        }
        temp.next.prev = temp.prev;  
        temp.next = temp.next.next;
        return this;
    }

    
}
