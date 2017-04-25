package com.tencent.mm.az;

import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class c {
    private static String Ip(String str) {
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return str.replaceAll(" ", SQLiteDatabase.KeyEmpty).trim().replaceAll("kB", SQLiteDatabase.KeyEmpty).trim().replaceAll("\\t", SQLiteDatabase.KeyEmpty).trim();
    }

    public static String brj() {
        InputStream inputStream;
        String str;
        Throwable e;
        Throwable e2;
        String str2 = SQLiteDatabase.KeyEmpty;
        try {
            inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start().getInputStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                str = str2;
                while (true) {
                    try {
                        str2 = bufferedReader.readLine();
                        if (str2 == null) {
                            break;
                        } else if (!be.kS(str2)) {
                            str = Ip(str + str2 + ";");
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e4) {
                        v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e4));
                    }
                }
            } catch (Throwable e22) {
                e4 = e22;
                str = str2;
                try {
                    v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e4));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e42) {
                            v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e42));
                        }
                    }
                    return str.replace(",", "_");
                } catch (Throwable th) {
                    e22 = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e422) {
                            v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e422));
                        }
                    }
                    throw e22;
                }
            }
        } catch (Throwable e222) {
            inputStream = null;
            e422 = e222;
            str = str2;
            v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e422));
            if (inputStream != null) {
                inputStream.close();
            }
            return str.replace(",", "_");
        } catch (Throwable th2) {
            e222 = th2;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            throw e222;
        }
        return str.replace(",", "_");
    }

    public static String brk() {
        InputStream inputStream;
        String str;
        Throwable e;
        Throwable e2;
        String str2 = SQLiteDatabase.KeyEmpty;
        try {
            inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/meminfo"}).start().getInputStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                str = str2;
                while (true) {
                    try {
                        str2 = bufferedReader.readLine();
                        if (str2 == null) {
                            break;
                        } else if (!be.kS(str2)) {
                            str = Ip(str + str2 + ";");
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e4) {
                        v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e4));
                    }
                }
            } catch (Throwable e22) {
                e4 = e22;
                str = str2;
                try {
                    v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e4));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e42) {
                            v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e42));
                        }
                    }
                    return str.replace(",", "_");
                } catch (Throwable th) {
                    e22 = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e422) {
                            v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e422));
                        }
                    }
                    throw e22;
                }
            }
        } catch (Throwable e222) {
            inputStream = null;
            e422 = e222;
            str = str2;
            v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e422));
            if (inputStream != null) {
                inputStream.close();
            }
            return str.replace(",", "_");
        } catch (Throwable th2) {
            e222 = th2;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            throw e222;
        }
        return str.replace(",", "_");
    }

    public static String brl() {
        String str = SQLiteDatabase.KeyEmpty;
        try {
            String str2 = SQLiteDatabase.KeyEmpty;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = aa.getContext().getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            float f = displayMetrics.density;
            float f2 = displayMetrics.xdpi;
            float f3 = displayMetrics.ydpi;
            str = ((((str2 + "width:" + String.valueOf(i) + ";") + "height:" + String.valueOf(i2) + ";") + "density:" + String.valueOf(f) + ";") + "xd:" + String.valueOf(f2) + ";") + "yd:" + String.valueOf(f3) + ";";
        } catch (Throwable e) {
            v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(e));
        }
        return str.replace(",", "_");
    }

    public static String getRomInfo() {
        String str;
        String str2 = SQLiteDatabase.KeyEmpty;
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str2 = (str2 + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";";
            str = str2 + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Throwable e) {
            Throwable th = e;
            str = str2;
            v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(th));
        }
        return str.replace(",", "_");
    }

    public static String brm() {
        String str;
        String str2 = SQLiteDatabase.KeyEmpty;
        try {
            StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str2 = (str2 + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";";
            str = str2 + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Throwable e) {
            Throwable th = e;
            str = str2;
            v.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", be.e(th));
        }
        return str.replace(",", "_");
    }

    public static String brn() {
        ak.yW();
        return (String) com.tencent.mm.model.c.vf().get(71, null);
    }
}
