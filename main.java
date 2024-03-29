import java.io.File;

import src.CmdExecutor;

class main {
    public static void main(String[] args) {
        File dDrive = new File("D:");
        String directory = dDrive.getAbsolutePath();
        directory = System.getProperty("user.dir").replace("\"", "");
        String applicationPath = "C:\\Program Files\\CCleaner\\CCleaner.exe";

        String makeDir = "cmd /c mkdir " + directory + "\\NewExecutorFolder";
        String startApp = "cmd /c start \"\" \"" + applicationPath + "\"";

        int index = 0;
        CmdExecutor cmdExecutor = CmdExecutor.getInstance();

        // for Runtime Implemention
        // making directory
        index = CmdExecutor.runtimeProcessExecutor(makeDir);
        cmdExecutor.errorhandling(index);

        // starting an application
        index = CmdExecutor.runtimeProcessExecutor(startApp);
        cmdExecutor.errorhandling(index);

        // for Process Builder Implementation
        // making directory
        index = CmdExecutor.builderProcessExecutor(makeDir);
        cmdExecutor.errorhandling(index);

        // for starting an application
        index = CmdExecutor.builderProcessExecutor(startApp);
        cmdExecutor.errorhandling(index);

    }

}