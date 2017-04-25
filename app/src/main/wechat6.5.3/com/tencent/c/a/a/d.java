package com.tencent.c.a.a;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

final class d extends q {
    d(Context context) {
        super(context);
    }

    protected final boolean nM() {
        return s.l(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    protected final String nN() {
        String str;
        synchronized (this) {
            try {
                for (String str2 : c.d(new File(Environment.getExternalStorageDirectory(), s.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=")))) {
                    String[] split = str2.split(",");
                    if (split.length == 2 && split[0].equals(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        new StringBuilder("read mid from InternalStorage:").append(split[1]);
                        str2 = split[1];
                        break;
                    }
                }
                str2 = null;
            } catch (IOException e) {
                str2 = null;
            }
        }
        return str2;
    }

    protected final void write(String str) {
        synchronized (this) {
            c.aJ(Environment.getExternalStorageDirectory() + "/" + s.decode("6X8Y4XdM2Vhvn0I="));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), s.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(new StringBuilder(String.valueOf(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="))).append(",").append(str).toString());
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Exception e) {
            }
        }
    }

    protected final a nO() {
        return null;
    }

    protected final void a(a aVar) {
    }
}
