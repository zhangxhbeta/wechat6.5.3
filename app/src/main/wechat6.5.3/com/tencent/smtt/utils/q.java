package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public final class q {
    private static q pzG = null;
    private Context mContext = null;
    public boolean pzE = false;
    private boolean pzF = false;
    private File pzH = null;
    private File pzu = null;

    private q(Context context) {
        this.mContext = context.getApplicationContext();
        bOg();
    }

    private synchronized void bOg() {
        Throwable th;
        FileInputStream fileInputStream = null;
        synchronized (this) {
            FileInputStream fileInputStream2;
            try {
                if (this.pzH == null) {
                    this.pzH = bOh();
                }
                if (this.pzH == null) {
                    fileInputStream = null;
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                    }
                } else {
                    fileInputStream2 = new FileInputStream(this.pzH);
                    try {
                        Properties properties = new Properties();
                        properties.load(fileInputStream2);
                        String property = properties.getProperty("setting_forceUseSystemWebview", SQLiteDatabase.KeyEmpty);
                        if (!SQLiteDatabase.KeyEmpty.equals(property)) {
                            this.pzE = Boolean.parseBoolean(property);
                        }
                        try {
                            fileInputStream2.close();
                        } catch (Exception e2) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileInputStream2.close();
                        } catch (Exception e3) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream2 = null;
                th = th4;
                fileInputStream2.close();
                throw th;
            }
        }
        return;
    }

    private File bOh() {
        File file;
        try {
            if (this.pzu == null) {
                this.pzu = new File(this.mContext.getDir("tbs", 0), "core_private");
                if (this.pzu == null || !this.pzu.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.pzu, "debug.conf");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Throwable th) {
            file = null;
        }
        return file;
    }

    public static synchronized q bOi() {
        q qVar;
        synchronized (q.class) {
            qVar = pzG;
        }
        return qVar;
    }

    public static synchronized q gf(Context context) {
        q qVar;
        synchronized (q.class) {
            if (pzG == null) {
                pzG = new q(context);
            }
            qVar = pzG;
        }
        return qVar;
    }

    public final void kC(boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Throwable th2;
        FileInputStream fileInputStream = null;
        this.pzF = z;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream2;
        try {
            File bOh = bOh();
            if (bOh == null) {
                fileInputStream2 = null;
                try {
                    fileInputStream2.close();
                } catch (Exception e) {
                }
                FileOutputStream fileOutputStream3 = null;
                try {
                    fileOutputStream3.close();
                    return;
                } catch (Exception e2) {
                    return;
                }
            }
            fileInputStream2 = new FileInputStream(bOh);
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream2);
                properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.pzE));
                properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.pzF));
                fileOutputStream2 = new FileOutputStream(bOh);
                try {
                    properties.store(fileOutputStream2, null);
                    try {
                        fileInputStream2.close();
                    } catch (Exception e3) {
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    th2 = th;
                    try {
                        fileInputStream.close();
                    } catch (Exception e5) {
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e6) {
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream2 = null;
                fileInputStream = fileInputStream2;
                th2 = th;
                fileInputStream.close();
                fileOutputStream2.close();
                throw th2;
            }
        } catch (Throwable th5) {
            th2 = th5;
            fileOutputStream2 = null;
            fileInputStream.close();
            fileOutputStream2.close();
            throw th2;
        }
    }
}
