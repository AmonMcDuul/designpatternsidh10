package sample.web.ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public final class SingletonLogging {
    //Implements a singleton logger instance
    private static final SingletonLogging instance = new SingletonLogging();

    //Retrieve the execution directory. Note that this is wherever this process was launched
    public String logname = "simplelog";
    protected String env = System.getProperty("user.dir");
    private static File logFile;

    public static SingletonLogging getInstance(){
        return instance;
    }

    public static SingletonLogging getInstance(String withName){
        instance.logname = withName;
        instance.createLogFile();
        return instance;
    }

    public void createLogFile(){
        //Determine if a logs directory exists or not.
        File logsFolder = new File(env + '/' + "logs");
        if(!logsFolder.exists()){
            //Create the directory
            System.err.println("INFO: Creating new logs directory in " + env);
            logsFolder.mkdir();

        }

        //Get the current date and time
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        //Create the name of the file from the path and current time
        logname =  logname + '-' +  dateFormat.format(cal.getTime()) + ".log";
        SingletonLogging.logFile = new File(logsFolder.getName(),logname);
        try{
            if(logFile.createNewFile()){
                //New file made
                System.err.println("INFO: Creating new log file");
            }
        }catch(IOException e){
            System.err.println("ERROR: Cannot create log file");
            System.exit(1);
        }
    }

    private SingletonLogging(){
        if (instance != null){
            //Prevent Reflection
            throw new IllegalStateException("Cannot instantiate a new singleton instance of log");
        }
        this.createLogFile();
    }

    public static void log(String message){
        try{
            FileWriter out = new FileWriter(SingletonLogging.logFile, true);
            out.write(message.toCharArray());
            out.close();
        }catch(IOException e){
            System.err.println("ERROR: Could not write to log file");
        }
    }
}
