import java.util.Stack;

public class StackImpl {

    public static void main(String[] args) {
        StackClass root = new StackClass(1);
        root.insert(2);
        root.insert(3);
        root.insert(4);
        root.insert(5);
        print(root);
        root.pop();
        System.out.println(root.peek());
        print(root);
    }
    
    public static void print(StackClass root) {
        while(root != null) {
            System.out.print(root.value+",");
            root = root.next;
        }
        System.out.println();
    }
}

class StackClass {
    int value;
    StackClass next;

    public StackClass(int value) {
         this.value = value;
    }

    public StackClass(int value, StackClass next) {
        this.value = value;
        this.next = next;
    }

    public StackClass insert(int value) {
        StackClass temp = this;
        while(temp.next != null) {
            temp = temp.next;
        }
        StackClass newNode = new StackClass(value);
        temp.next = newNode;
        return this;
    }

    public StackClass pop() {
        StackClass temp = this;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
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
