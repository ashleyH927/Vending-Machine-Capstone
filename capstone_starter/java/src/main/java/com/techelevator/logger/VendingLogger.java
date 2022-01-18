package com.techelevator.logger;

import java.io.*;

public class VendingLogger implements Closeable {

    private File auditFile;
    private PrintWriter vmAuditWriter;

    public VendingLogger(String pathName) {
        this.auditFile = new File(pathName);


        if (!auditFile.exists()) {
            try {
                this.vmAuditWriter = new PrintWriter(this.auditFile);
            } catch (FileNotFoundException e) {
                System.out.println("Error creating log file.");
            }
        } else {
            try {
                this.vmAuditWriter = new PrintWriter(new FileWriter(this.auditFile, true));
            } catch (IOException e) {
                System.out.println("Error appending log file.");
            }
        }
    }

    public void write(String logMessage) {
        this.vmAuditWriter.println(logMessage);
        this.vmAuditWriter.flush();
    }

    @Override
    public void close() throws IOException {
        this.vmAuditWriter.close();
    }
} //Class
