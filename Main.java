public class Main {
    public static void main(String[] args) {
        //I tested the classes in my main class as the Test classes from the github did not work on my computer
        Stack<Integer> s;
        s = new Stack<>();

        //test isEmpty
        System.out.println(s.isEmpty());

        //test push
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.size() == 3);

        //test pop
        System.out.println(s.pop() == 5);
        System.out.println(s.pop() == 4);
        System.out.println(s.pop() == 3);
        System.out.println(s.isEmpty());

        //test push & pop
        s.push(5);
        s.push(2);
        s.pop();
        s.push(6);
        s.push(7);
        s.pop();
        s.pop();
        System.out.println(s.pop() == 5);
        System.out.println(s.isEmpty());

        //test Peek
        s.push(5);
        s.push(2);
        s.push(6);
        System.out.println(s.peek()==6);
        System.out.println(s.size()==3);
        System.out.println(s.pop()==6);
        System.out.println(s.size()==2);
    }
}