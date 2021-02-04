package model.Execution;

import model.Commands.ICommand;

import java.util.ArrayList;

public class ExecutionThread extends Thread{
    private ArrayList<ICommand> executionList = new ArrayList<ICommand>();
    private ExecutionMonitor executionMonitor;

    public ExecutionThread(ArrayList<ICommand> executionList, ExecutionMonitor executionMonitor) {
        this.executionList = executionList;
        this.executionMonitor = executionMonitor;
    }

    @Override
    public void run() {
        try {
            //System.out.println(this.executionList.size());
            for(ICommand command : this.executionList) {
                this.executionMonitor.tryExecution();
                command.execute();
            }
        }
        catch(InterruptedException e) {
            System.out.println("ExecutionThread - " + "Monitor block interrupted! " +e.getMessage());
        }

//        NotificationCenter.getInstance().postNotification(Alerts.ON_EXECUTION_FINISHED);
    }
}
