package androiddev.akp.mvctodolist.model;

import java.util.List;

import androiddev.akp.mvctodolist.view.OnChangeEventListener;

/**
 * Created by ki on 15-10-2015.
 */
public interface Observable {
    void addListener(OnChangeEventListener eventListener);
    void removeListener(OnChangeEventListener eventListener);
    void notify(TaskContainer tasks);
}
