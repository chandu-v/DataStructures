public class LinkedListImpl {
    
    public static void main(String[] args) {

        ListNode listNodes = new ListNode(1);
        listNodes = listNodes.insert(2);
        listNodes = listNodes.insert(3);
        listNodes = listNodes.insert(4);
        listNodes = listNodes.insert(5);
        listNodes = listNodes.insertAfter(2,10);
        listNodes = listNodes.removeNode(10);
        print(listNodes);
        
    }

    public static void print(ListNode listNode){
        while(listNode != null){
            System.out.print(listNode.value+",");
            listNode = listNode.next;
        }
    }
}

class ListNode{
    int value;
    ListNode next;

    public ListNode(int value){
        this.value = value;
    }

    public ListNode(int value , ListNode next){
        this.value = value;
        this.next = next;
    }

    public ListNode insert(int value){
        ListNode temp = this;
        while(temp.next != null){
            temp = temp.next;
        }
        ListNode newNode = new ListNode(value);
        temp.next = newNode;
        return this;
    }

    public ListNode insertAfter(int value,int valueToBeInserted){
        ListNode temp = this;
        while(temp.value != value){
            temp = temp.next;
        }
        ListNode newNode = new ListNode(valueToBeInserted,temp.next);
        temp.next = newNode;
        return this;
    }

    public ListNode removeNode(int value){
        ListNode temp = this;
        while(temp.next.value != value){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return this;
    }

    
}
