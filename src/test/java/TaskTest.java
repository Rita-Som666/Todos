import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Epic;
import ru.netology.domain.SimpleTask;
import ru.netology.domain.Meeting;


public class TaskTest {
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


    @Test
    public void shouldMatchOneSimpleTask() {

        boolean actual = simpleTask.matches("родителям");
        boolean actual2 = simpleTask2.matches("родителям");
        Assertions.assertTrue(actual);
        Assertions.assertFalse(actual2);
    }

    @Test
    public void shouldMatchMoreOneSimpleTask() {

        boolean actual = simpleTask.matches("Позвонить");
        boolean actual2 = simpleTask2.matches("Позвонить");
        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);

    }

    @Test
    public void shouldNotMatchSimpleTask() {

        boolean actual = simpleTask.matches("маме");
        boolean actual2 = simpleTask2.matches("маме");
        Assertions.assertFalse(actual);
        Assertions.assertFalse(actual2);

    }

    @Test
    public void shouldMatchOneEpicTask() {

        boolean actual = epic.matches("Хлеб");
        boolean actual2 = epic2.matches("Хлеб");
        Assertions.assertTrue(actual);
        Assertions.assertFalse(actual2);
    }

    @Test
    public void shouldMatchMoreOneEpicTask() {

        boolean actual = epic.matches("Молоко");
        boolean actual2 = epic2.matches("Молоко");
        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
    }

    @Test
    public void shouldNotMatchEpicTask() {

        boolean actual = epic.matches("сок");
        boolean actual2 = epic2.matches("сок");
        Assertions.assertFalse(actual);
        Assertions.assertFalse(actual2);
    }

    @Test
    public void shouldSearchOneMeetingTaskInTopic() {

        boolean actual = meeting.matches("Выкатка");
        boolean actual2 = meeting2.matches("Выкатка");
        Assertions.assertTrue(actual);
        Assertions.assertFalse(actual2);
    }

    @Test
    public void shouldMatchMoreOneMeetingTaskInTopic() {

        boolean actual = meeting.matches("версии");
        boolean actual2 = meeting2.matches("версии");
        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
    }

    @Test
    public void shouldMatchOneMeetingTaskInProject() {

        boolean actual = meeting.matches("Приложение");
        boolean actual2 = meeting2.matches("Приложение");
        Assertions.assertTrue(actual);
        Assertions.assertFalse(actual2);

    }

    @Test
    public void shouldMatchMoreOneMeetingTaskInProject() {

        boolean actual = meeting.matches("НетоБанка");
        boolean actual2 = meeting2.matches("НетоБанка");
        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);

    }

    @Test
    public void shouldNotMatchMeetingTack() {

        boolean actual = meeting.matches("созвон");
        boolean actual2 = meeting2.matches("созвон");
        Assertions.assertFalse(actual);
        Assertions.assertFalse(actual2);
    }
}
