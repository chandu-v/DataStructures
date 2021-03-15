import java.util.Stack;

public class StackImpl {

    public static void main(String[] args) {
        StackClass root = new StackClass(1);
        root.insert(2);
        root.insert(3);
        root.insert(4);
        root.insert(5);
        printInRevOrder(root);
        printInOrder(root);
        System.out.println();
        root.pop();
        System.out.println(root.peek());
    }
    
    public static void printInRevOrder(StackClass root) {
        while(root != null) {
            System.out.print(root.value+",");
            root = root.next;
        }
        System.out.println();
    }

    public static void printInOrder(StackClass root) {
        StackClass temp = root;
        if(root.next == null){
            System.out.print(root.value+",");
        }else{
            printInOrder(root.next);
            System.out.print(root.value+",");
        }
    }
}

class StackClass {
    int value;
    StackClass next;
    boolean isEmpty = false;

    public StackClass(int value) {
         this.value = value;
    }

    public StackClass(int value, StackClass next) {
        this.value = value;
        this.next = next;
    }

    public StackClass insert(int value) {
        StackClass temp = this;
        this.isEmpty = true;
        while(temp.next != null) {
            temp = temp.next;
        }
        StackClass newNode = new StackClass(value);
        temp.next = newNode;
        return this;
    }

    public StackClass pop() {
        StackClass temp = this;
        if(temp.next != null) {
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        } else{
            this.value = -1;
            this.isEmpty = true;
        }
        return this;
    }

    public int peek() {
        StackClass temp = this;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp.value;
    }
}
