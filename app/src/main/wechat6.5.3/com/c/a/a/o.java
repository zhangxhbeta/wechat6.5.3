package com.c.a.a;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class o {
    private static String aKh;
    private static final SimpleDateFormat aKi = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.US);
    private static final SimpleDateFormat aKj = new SimpleDateFormat("yyyMMddHHmmss", Locale.US);

    protected static boolean m(String str, String str2) {
        String str3 = null;
        if (aKh == null) {
            boolean z;
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(Environment.getExternalStorageDirectory() + "/" + y.aNB);
                boolean exists = file.exists();
                if (!exists) {
                    exists = file.mkdir();
                }
                if (exists) {
                    str3 = file.toString();
                }
                aKh = str3;
                z = exists;
            } else {
                aKh = null;
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(aKh + "/" + str + ".txt", true);
            fileWriter.write("\n" + aKi.format(new Date()) + ',' + str2);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected static String nk() {
        return aKj.format(new Date());
    }
}
