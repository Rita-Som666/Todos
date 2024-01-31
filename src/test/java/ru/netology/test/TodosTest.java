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
    SimpleTask simpleTask2 = new SimpleTask(6, "Позвонить папе");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);
    String[] subtasks2 = {"Яблоки", "Мясо", "Молоко"};
    Epic epic2 = new Epic(66, subtasks2);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Meeting meeting2 = new Meeting(
            666,
            "Согласование новой версии",
            "Сайт НетоБанка",
            "В четверг утром"
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
    public void shouldSearchOneSimpleTask() {

        todos.search("родителям");
        boolean actual = simpleTask.matches("родителям");
        boolean actual2 = simpleTask2.matches("родителям");
        Assertions.assertTrue(actual);
        Assertions.assertFalse(actual2);
    }

    @Test
    public void shouldSearchMoreOneSimpleTask() {
        todos.search("Позвонить");
        boolean actual = simpleTask.matches("Позвонить");
        boolean actual2 = simpleTask2.matches("Позвонить");
        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);

    }

    @Test
    public void shouldNotSearchSimpleTask() {

        todos.search("маме");
        boolean actual = simpleTask.matches("маме");
        boolean actual2 = simpleTask2.matches("маме");
        Assertions.assertFalse(actual);
        Assertions.assertFalse(actual2);

    }

    @Test
    public void shouldSearchOneEpicTask() {
        todos.search("Хлеб");
        boolean actual = epic.matches("Хлеб");
        boolean actual2 = epic2.matches("Хлеб");
        Assertions.assertTrue(actual);
        Assertions.assertFalse(actual2);
    }

    @Test
    public void shouldSearchMoreOneEpicTask() {
        todos.search("Молоко");
        boolean actual = epic.matches("Молоко");
        boolean actual2 = epic2.matches("Молоко");
        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
    }

    @Test
    public void shouldNotSearchEpicTask() {
        todos.search("сок");
        boolean actual = epic.matches("сок");
        boolean actual2 = epic2.matches("сок");
        Assertions.assertFalse(actual);
        Assertions.assertFalse(actual2);
    }

    @Test
    public void shouldSearchOneMeetingTaskInTopic() {
        todos.search("Выкатка");
        boolean actual = meeting.matches("Выкатка");
        boolean actual2 = meeting2.matches("Выкатка");
        Assertions.assertTrue(actual);
        Assertions.assertFalse(actual2);
    }

    @Test
    public void shouldSearchMoreOneMeetingTaskInTopic() {
        todos.search("версии");
        boolean actual = meeting.matches("версии");
        boolean actual2 = meeting2.matches("версии");
        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
    }

    @Test
    public void shouldSearchOneMeetingTaskInProject() {
        todos.search("Приложение");
        boolean actual = meeting.matches("Приложение");
        boolean actual2 = meeting2.matches("Приложение");
        Assertions.assertTrue(actual);
        Assertions.assertFalse(actual2);

    }

    @Test
    public void shouldSearchMoreOneMeetingTaskInProject() {
        todos.search("НетоБанка");
        boolean actual = meeting.matches("НетоБанка");
        boolean actual2 = meeting2.matches("НетоБанка");
        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);

    }

    @Test
    public void shouldNotSearchMeetingTack() {
        todos.search("созвон");
        boolean actual = meeting.matches("созвон");
        boolean actual2 = meeting2.matches("созвон");
        Assertions.assertFalse(actual);
        Assertions.assertFalse(actual2);
    }
}


