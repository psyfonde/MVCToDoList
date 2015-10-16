package androiddev.akp.mvctodolist.model;

/**
 * Created by ki on 14-10-2015.
 */
public class Task {
    private String message;

    public Task(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}
