package src;

import java.io.IOException;

public class CmdExecutor {

    private static CmdExecutor instance;

    public CmdExecutor() {
    }

    // Singleton
    public static CmdExecutor getInstance() {
        if (instance == null) {
            instance = new CmdExecutor();
        }

        return instance;
    }

    // for using java.lang.Runtime
    public static int runtimeProcessExecutor(String cmd) {

        Process runtimeProcess = null;
        try {
            runtimeProcess = Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println(ioe);
        }

        int runtimeComplete = 0;
        try {
            runtimeComplete = runtimeProcess.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return runtimeComplete;
    }

    public void errorhandling(int n) {
        if (n != 0) {
            System.out.println("Index : " + n + " Command Executed.");
        } else {
            System.out.println("Index : " + n + " Yet to Executed.");
        }
    }

}
