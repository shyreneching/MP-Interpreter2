package model.Execution;

import model.Commands.ICommand;
import model.ErrorChecking.ErrorRepository;
import model.Execution.Adders.IExecutionAdder;
import model.Execution.Adders.MainExecutionAdder;
import model.Execution.Adders.MethodExecutionAdder;
import model.Item.PseudoMethod;
import model.PseudoCodeListener;
import model.notifications.NotificationListener;
import model.notifications.Notifications;
import model.notifications.NotificationsCenter;
import model.notifications.Parameters;

import java.util.ArrayList;

public class ExecutionManager implements NotificationListener {

    private static ExecutionManager sharedInstance = null;
    private ExecutionThread executionThread;
    private ExecutionMonitor executionMonitor;
    private IExecutionAdder activeExecutionAdder;
    private MainExecutionAdder mainExecutionAdder;
//    private IAttemptCommand.CatchTypeEnum currentCatchType = null;
//    private IAttemptCommand currentTryCommand = null;

    private ArrayList<ICommand> executionList = new ArrayList<ICommand>();
    private boolean foundEntryPoint = false;
    private String entryClassName = null;

    private boolean aborted = false;
    private int currentCheckedLineNumber = -1;

    private boolean isMain;

    public static ExecutionManager getInstance() {
        return sharedInstance;
    }

    private ExecutionManager() {
        this.mainExecutionAdder = new MainExecutionAdder(this.executionList);
        this.activeExecutionAdder = this.mainExecutionAdder;
    }

    public static void initialize() {
        sharedInstance = new ExecutionManager();
        NotificationsCenter.getInstance().addObserver(Notifications.ON_EXECUTION_FINISHED, sharedInstance);
    }

    public static void reset() {
        sharedInstance.foundEntryPoint = false;
        sharedInstance.entryClassName = null;
        sharedInstance.clearAllActions();

//        sharedInstance.currentCatchType = null;
//        sharedInstance.currentTryCommand = null;
        sharedInstance.aborted = false;

        NotificationsCenter.getInstance().removeObserver(Notifications.ON_EXECUTION_FINISHED, sharedInstance);
    }

//    public IAttemptCommand getCurrentTryCommand() {
//        return this.currentTryCommand;
//    }

//    public void setCurrentTryCommand(IAttemptCommand command) {
//        this.currentTryCommand = command;
//    }

//    public IAttemptCommand.CatchTypeEnum getCurrentCatchType() {
//        return this.currentCatchType;
//    }

//    public void setCurrentCatchType(IAttemptCommand.CatchTypeEnum catchType) {
//
//        if (catchType == null) {
//            this.currentCatchType = null;
//            return;
//        }
//
//        if (this.currentTryCommand != null && this.currentTryCommand.hasCatchFor(catchType))
//            this.currentCatchType = catchType;
//        else {
//
//            this.aborted = true;
//
//            if (catchType == IAttemptCommand.CatchTypeEnum.ARRAY_OUT_OF_BOUNDS) {
//                PseudoCodeListener.reportCustomError(ErrorRepository.RUNTIME_ARRAY_OUT_OF_BOUNDS, "", this.currentCheckedLineNumber);
//            } else if (catchType == IAttemptCommand.CatchTypeEnum.NEGATIVE_ARRAY_SIZE) {
//                PseudoCodeListener.reportCustomError(ErrorRepository.RUNTIME_NEGATIVE_ARRAY_SIZE, "", this.currentCheckedLineNumber);
//            } else if (catchType == IAttemptCommand.CatchTypeEnum.ARITHMETIC_EXCEPTION) {
//                PseudoCodeListener.reportCustomError(ErrorRepository.RUNTIME_ARITHMETIC_EXCEPTION, "", this.currentCheckedLineNumber);
//            }
//
//            this.clearAllActions();
//        }
//    }

    public boolean isAborted () {
        return aborted;
    }

    public void setCurrentCheckedLineNumber (int n) {
        this.currentCheckedLineNumber = n;
    }

    public void reportFoundEntryPoint(String entryClassName) {
        this.entryClassName = entryClassName;
        this.foundEntryPoint = true;
    }

    public boolean hasFoundEntryPoint() {
        return this.foundEntryPoint;
    }

    public String getEntryClassName() {
        return this.entryClassName;
    }

    public void addCommand(ICommand command) {
        this.activeExecutionAdder.addCommand(command);
    }

    public void deleteCommand(ICommand command) {
        this.executionList.remove(command);
    }

    public void openFunctionExecution(PseudoMethod pseudoMethod) {
        MethodExecutionAdder methodExecutionAdder = new MethodExecutionAdder(pseudoMethod);
        this.activeExecutionAdder = methodExecutionAdder;
    }

    public boolean isInFunctionExecution() {
        return (this.activeExecutionAdder instanceof MethodExecutionAdder);
    }

    public boolean isInMain() {
        return isMain;
    }

    public void setIsMain(boolean ismain){
        isMain = ismain;
    }

    public PseudoMethod getCurrentFunction() {
        if(this.isInFunctionExecution()) {
            MethodExecutionAdder functionExecAdder = (MethodExecutionAdder) this.activeExecutionAdder;

            return functionExecAdder.getAssignedFunction();
        }
        else {
            System.out.println("ExecutionManager - " + "Execution manager is not in a function!");
            return null;
        }
    }

    public void closeFunctionExecution() {
        this.activeExecutionAdder = this.mainExecutionAdder;
    }

    public void blockExecution() {
        this.executionMonitor.claimExecutionFlag();
    }

    public void resumeExecution() {
        this.executionMonitor.releaseExecutionFlag();
    }

    public void executeAllActions() {
        this.executionMonitor = new ExecutionMonitor();
        this.executionThread = new ExecutionThread(this.executionList, this.executionMonitor);
        this.executionThread.start();
    }

    public void clearAllActions() {
        this.executionList.clear();
    }

    public ExecutionMonitor getExecutionMonitor() {
        return this.executionMonitor;
    }

    @Override
    public void notified(String notificationString, Parameters params) {
        if(notificationString == Notifications.ON_EXECUTION_FINISHED) {
            //SymbolTableManager.getInstance().resetClassTables(); //TODO: does not work as intended
        }
    }

    //temp for checking list
//    public ArrayList<ICommand> getExecutionList() {
//        return executionList;
//    }
}
