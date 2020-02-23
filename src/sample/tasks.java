package sample;

import java.util.Date;

// This is the class for keeping track of all the information for each task.
public class tasks
{
    private String general;
    private Date due;
    private Date finished;
    private boolean done;

    public tasks(String task, Date todo)
    {
        general = task;
        due = todo;
        done = false;
    }

    public String getTask()
    {
        return general;
    }

    public Date getDue()
    {
        return due;
    }

    public void setFinished(Date completed)
    {
        finished = completed;
    }

    public boolean getDone()
    {
        return done;
    }

    public void setDone(boolean good)
    {
        done = good;
    }
}
