package androiddev.akp.mvctodolist.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androiddev.akp.mvctodolist.view.OnChangeEventListener;

/**
 * Created by ki on 14-10-2015.
 */
public class TaskContainer implements Observable {
    private static TaskContainer instance = null;
    private List<Task> tasks;
    private List<OnChangeEventListener> listeners;

    private TaskContainer(){
        tasks = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    public static TaskContainer getInstance(){
        if (instance == null){
            instance = new TaskContainer();
        }
        return instance;
    }

    public void addTask(Task task){
        tasks.add(task);
        notifyChange();
    }

    public List<Task> getAll() {
        List<Task> taskList = this.tasks;
        return taskList;
    }

    private void notifyChange(){
        notify(this);
    }

    @Override
    public void addListener(OnChangeEventListener eventListener) {
        listeners.add(eventListener);
    }

    @Override
    public void removeListener(OnChangeEventListener eventListener) {
        listeners.remove(eventListener);
    }

    @Override
    public void notify(TaskContainer tasks) {
        for (OnChangeEventListener listener : listeners){
            Log.i("__TaskContainer", "listeners notified");
            listener.onChange(null);
        }
    }
}
