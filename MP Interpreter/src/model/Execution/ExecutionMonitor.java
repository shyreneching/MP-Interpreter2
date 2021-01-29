package model.Execution;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutionMonitor {

    private boolean executionFlag = true;
    private final Lock lock = new ReentrantLock();
    private final Condition executionGate = lock.newCondition();

    public void tryExecution() throws InterruptedException {
        this.lock.lock();

        try {
            while(executionFlag == false) {
                System.out.println("ExecutionMonitor - " + "Execution flag has been set to false. Execution sleeps!");
                this.executionGate.await();
            }

        }
        finally {
            this.lock.unlock();
        }
    }

    public void claimExecutionFlag() {
        this.executionFlag = false;
    }

    public void releaseExecutionFlag() {
        this.lock.lock();
        this.executionFlag = true;
        this.executionGate.signal();
        this.lock.unlock();
    }
}
