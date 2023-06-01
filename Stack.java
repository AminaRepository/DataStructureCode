public class Stack<Item> extends Queue<Item> {
    private Queue<Item> q1;
    private Queue<Item> q2;

    public Stack() {
        q1 = new Queue<Item>();
        q2 = new Queue<Item>();
    }

    public void push(Item data) {
        if(q1.isEmpty()){
            q1.enqueue(data);
        }
        else{
            while(q1.isEmpty()!=true){
                q2.enqueue(q1.dequeue());
            }
            q1.enqueue(data);
            while(q2.isEmpty()!=true){
                q1.enqueue(q2.dequeue());
            }
        }
    }

    public Item pop() {
        return q1.dequeue();
    }

    public Item peek() {
        Item data = pop();
        push(data);
        return data;
    }

    public int size() {
        int StackSize = 0;
        while(q1.isEmpty()!=true){
            q2.enqueue(q1.dequeue());
            StackSize++;
        }
        while(q2.isEmpty()!=true){
            q1.enqueue(q2.dequeue());
        }
        return StackSize;
    }

    public boolean isEmpty() {
        return size()==0;
    }
}