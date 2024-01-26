package ru.netology.domain;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    private String[] addToArray(String[] current, String subtasks) {
        String[] tmp = new String[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = subtasks;
        return tmp;
    }

    public void addSubtask(String subtask) {
        subtasks = addToArray(subtasks, subtask);
    }

    @Override
    public boolean matches(String query) {

        for (String i : subtasks) {
            if (i.contains(query))
                return true;

            }
            return false;

        }
    }

