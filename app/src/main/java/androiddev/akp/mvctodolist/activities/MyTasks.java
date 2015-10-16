package androiddev.akp.mvctodolist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androiddev.akp.mvctodolist.R;
import androiddev.akp.mvctodolist.model.Task;
import androiddev.akp.mvctodolist.model.TaskContainer;
import androiddev.akp.mvctodolist.view.TaskView;

public class MyTasks extends AppCompatActivity {

    private TaskContainer tasks;
    private TaskView taskView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasks = TaskContainer.getInstance();
        taskView = (TaskView)View.inflate(getApplicationContext(), R.layout.task_view, null);
        taskView.setTaskViewListener(taskViewListener);
        setContentView(taskView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_tasks, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private TaskView.TaskViewListener taskViewListener = new TaskView.TaskViewListener() {
        @Override
        public void onAddTask(String text) {
            Log.i("__Activity", "buttonEvent handled");
            tasks.addTask(new Task(text));
            //TODO reset edit field
        }
    };
}
