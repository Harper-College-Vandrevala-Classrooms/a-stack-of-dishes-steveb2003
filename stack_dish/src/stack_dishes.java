import java.util.ArrayList;
import java.util.Scanner;

public class stack_dishes 
{
    public static ArrayList<Dish> dish_stack = new ArrayList<>();
    public static int stack_length;
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        System.out.println("Please enter the desired length of the stack: ");
        stack_length= in.nextInt();
        
        while(running)
        { 
            System.out.println("Please enter 'push' to add a new element at the top of the stack.\nPlease enter 'pop' to remove and return the top element of the stack. \nPlease enter 'peek' to retain and return the top element of the stack.\nPlease enter 'size' to get the size of the stack. \nPlease enter 'exit' to exit the program.");
            String entry = in.next();
            switch (entry)
            {
                case "push":
                    System.out.println("Please enter name of dish object to add to stack: ");
                    String description = in.next();
                    Dish dish = new Dish(description);
                    if (dish_stack.size()<stack_length)
                    {
                        push(dish);
                    }
                    else if (dish_stack.size()>=stack_length)
                    {
                        System.out.println("Stack is full. No more stacks can be added unless at least one is removed.");
                    }
                    break;
                case "pop":
                    pop();
                    break;
                case "peek":
                    peek();
                    break;
                case "size":
                    size();
                    break;
                case "exit":
                    running =false;
                    break;
                default:
                    System.out.println("Please enter a valid option");
            }
        
        }
        in.close();
    }
    public static void push(Dish dish)
    {
        dish_stack.add(dish);
    }

    public static void pop()
    {
        Dish top_dish = dish_stack.get(dish_stack.size()-1);
        dish_stack.remove(top_dish);
        System.out.println(("Popped element: " + top_dish.description +".\n"));
    }

    public static void peek()
    {
        Dish peek_dish = dish_stack.get(dish_stack.size()-1);
        System.out.println("Peeked element: " + peek_dish.description +".\n");
    }

    public static void size()
    {
        System.out.print("The size of the stack is: "+ dish_stack.size()+".\n");
    }
}
