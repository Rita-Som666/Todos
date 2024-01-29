package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Task;
import ru.netology.domain.Epic;
import ru.netology.domain.SimpleTask;
import ru.netology.domain.Meeting;
import ru.netology.domain.Todos;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    Todos todos = new Todos();

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchSimpleTask() {

        todos.search("родителям");
        boolean actual = simpleTask.matches("родителям");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotSearchSimpleTask() {

        todos.search("маме");
        boolean actual = simpleTask.matches("маме");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldSearchEpicTask() {
        todos.search("Хлеб");
        boolean actual = epic.matches("Хлеб");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotSearchEpicTask() {
        todos.search("сок");
        boolean actual = epic.matches("сок");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldSearchMeetingTaskInTopic() {
        todos.search("Выкатка");
        boolean actual = meeting.matches("Выкатка");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldSearchMeetingTaskInProject() {
        todos.search("Приложение");
        boolean actual = meeting.matches("Приложение");
        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldNotSearchMeetingTack() {
        todos.search("созвон");
        boolean actual = meeting.matches("созвон");
        Assertions.assertFalse(actual);
    }
}


