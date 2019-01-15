package com.example.nikhil.workers.data_model;

public class WorkerListData {

    private static WorkerListData instance = null;
    private String message;

    private Data data;

    private WorkerListData(){}

    public static WorkerListData getInstance(){
        if(instance == null){
            instance = new WorkerListData();
        }

        return instance;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    public boolean hasData(){
        if(instance != null && instance.data != null && (instance.data.getItems().length != 0))
            return true;
        else
            return false;
    }

}
