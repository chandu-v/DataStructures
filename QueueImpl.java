public class QueueImpl {

    public static void main(String[] args) {
        QueueClass queueClass = new QueueClass();
        queueClass.insert(1);
        queueClass.insert(2);
        queueClass.insert(3);
        queueClass.insert(4);
        queueClass.insert(5);
        print(queueClass);
        System.out.println(queueClass.peek());
        queueClass.enQueue();
        System.out.println(queueClass.peek());
        print(queueClass);
    }

    public static void print(QueueClass queueClass) {
        QueueClass temp = queueClass.next;
        while(temp != null) {
            System.out.print(temp.value+",");
            temp = temp.next;
        }
        System.out.println();
    }
    
}

class QueueClass {
    int value;
    QueueClass next;
    boolean isEmpty = true;

    public QueueClass(){

    }

    public QueueClass(int value) {
        this.value = value;
    }

    public QueueClass(int value, QueueClass next) {
        this.value = value;
        this.next = next;
    }

    public QueueClass insert(int value) {
        this.isEmpty = false;
        QueueClass newNode = new QueueClass(value,this.next);
        newNode.isEmpty = false;
        this.next = newNode;
        return newNode;
    }

    public int peek() {
        QueueClass temp = this;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp.value;
    }

    public QueueClass enQueue() {
        QueueClass temp = this;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
        return this;
    }
}
