package todolist_file.dao;

import todolist_file.model.Task;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoListImpl implements ToDoList, Serializable {

    //fields
    private List<Task> tasks;
    private int quantity;

    private LocalDateTime time;

    // constructor
    public ToDoListImpl() {
        tasks = new ArrayList<>();
        this.quantity = 0;
    }

    @Override
    public boolean addTask(Task task) {
        if (task == null) {
            return false;
        }
        tasks.add(task);
        quantity = tasks.size();
        return true;
    }

    @Override
    public Task removeTask(int taskNumber) {
        // find task by number=id+1 then remove, quantity--
        if(taskNumber >= 1 && taskNumber <= quantity) {
            Task victim = tasks.get(taskNumber - 1 );
            tasks.remove(victim);
            System.out.println("Task: " + victim.getTask() + " removed.");
            quantity--;
            return victim;
        }
        System.out.println("Wrong task number");
        return null;
    }


    @Override
    public void viewTasks() {
        // for loop, print tasks & quantity
        for (Task t : tasks) {
            System.out.println((tasks.indexOf(t) + 1) + ". " + t);
        }
        System.out.println("You have " + quantity + " tasks.");
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks.stream().toList();
    }

    @Override
    public int quantity() {
        return quantity;
    }
}
