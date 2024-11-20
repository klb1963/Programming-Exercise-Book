package todolist.test;

import todolist.dao.ToDoList;
import todolist.dao.ToDoListImpl;
import todolist.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListImplTest {

    ToDoList toDoList;
    LocalDate now = LocalDate.now();

    @BeforeEach
    void setUp() {

        toDoList = new ToDoListImpl();

        toDoList.addTask(new Task("Do homework", now.minusDays(3)));
        toDoList.addTask(new Task("By products", now.minusDays(2)));
        toDoList.addTask(new Task("Play with cat", now.minusDays(1)));

        System.out.println(toDoList);

    }

    @Test
    void addTask() {
        assertEquals(3, toDoList.quantity());
        Task task = new Task("to clean", now.minusDays(1));
        assertTrue(toDoList.addTask(task));
        assertEquals(4, toDoList.quantity());
        assertFalse(toDoList.addTask(null)); // null
        assertFalse(toDoList.addTask(task)); // duplicate

    }

    @Test
    void removeTask() {
        toDoList.removeTask(1);
        assertEquals(2, toDoList.quantity());
        toDoList.viewTasks();
    }

    @Test
    void viewTasks() {
        toDoList.viewTasks();
    }

    @Test
    void getAllTasks() {
        toDoList.getAllTasks();

    }

    @Test
    void quantity() {
        assertEquals(3, toDoList.quantity());
    }
}