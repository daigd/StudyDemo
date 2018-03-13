package com.dgd.adapter;

import java.io.*;
import java.util.List;

/**
 * @Author DGD
 * @date 2018/3/13.
 */
public class LogFileOperate implements LogFileOperateApi {
    private String logFileName = "adapter.log";

    @Override
    public List<LogModel> readLogFile() {
        List<LogModel> list = null;
        ObjectInputStream ois = null;
        File file = new File(logFileName);
        if (file.exists()) {
            try {
                ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                list = (List<LogModel>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }

    @Override
    public void writeLogFile(List<LogModel> logModels) {
        File file = new File(logFileName);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            oos.writeObject(logModels);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
