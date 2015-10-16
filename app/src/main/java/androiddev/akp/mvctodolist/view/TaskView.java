package androiddev.akp.mvctodolist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import androiddev.akp.mvctodolist.R;
import androiddev.akp.mvctodolist.activities.MyTasks;
import androiddev.akp.mvctodolist.model.Task;
import androiddev.akp.mvctodolist.model.TaskContainer;

/**
 * Created by ki on 14-10-2015.
 */
public class TaskView extends RelativeLayout implements OnChangeEventListener {

    //anonymous inner class to send events from the view to the activity
    public interface TaskViewListener {
        void onAddTask(String text);
    }

    private TaskContainer tasks;
    private TaskViewListener taskViewListener;
    private ListView listView;
    ArrayAdapter<Task> adapter;

    public TaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
        tasks = TaskContainer.getInstance();
        tasks.addListener(this);
    }

    public void setTaskViewListener(TaskViewListener taskViewListener){
        this.taskViewListener = taskViewListener;
    }

    //inherited from RelativeLayout
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Button btnAddTask = (Button)findViewById(R.id.btnAddTask);
        final EditText editText = (EditText)findViewById(R.id.txtInputTask);
        listView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(getContext(), R.layout.list_view_black_text, tasks.getAll());
        listView.setAdapter(adapter);

        btnAddTask.setOnClickListener(new TaskView.OnClickListener() {

            @Override
            public void onClick(View v) {
                taskViewListener.onAddTask(editText.getText().toString());
            }
        });
    }

    //inherited form OnChangeEventListener
    @Override
    public void onChange(TaskContainer tasks) {
        updateView();
    }

    private void updateView() {
        adapter.notifyDataSetChanged();
    }

}
