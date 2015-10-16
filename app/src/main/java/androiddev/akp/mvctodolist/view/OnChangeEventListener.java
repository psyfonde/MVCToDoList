package androiddev.akp.mvctodolist.view;

import java.util.List;

import androiddev.akp.mvctodolist.model.Task;
import androiddev.akp.mvctodolist.model.TaskContainer;

/**
 * Created by ki on 15-10-2015.
 */
public interface OnChangeEventListener {
    void onChange(TaskContainer tasks);
}
