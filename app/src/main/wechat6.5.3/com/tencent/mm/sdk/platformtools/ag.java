package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class ag implements UncaughtExceptionHandler {
    private static ag niR = null;
    private d niS;
    private com.tencent.mm.sdk.b.a niT;
    public a niU;
    public Map<String, b> niV;
    private UncaughtExceptionHandler niW;
    private boolean niX;
    private List<c> niY;

    public interface a {
        void ol();
    }

    public interface b {
        String AC();
    }

    public interface c {
        void oc();
    }

    public interface d {
        void a(ag agVar, String str, Throwable th);
    }

    public static synchronized void a(d dVar) {
        synchronized (ag.class) {
            if (niR == null) {
                niR = new ag();
            }
            niR.niS = dVar;
        }
    }

    public static synchronized void a(com.tencent.mm.sdk.b.a aVar) {
        synchronized (ag.class) {
            if (niR == null) {
                niR = new ag();
            }
            niR.niT = aVar;
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (ag.class) {
            if (niR == null) {
                niR = new ag();
            }
            niR.niU = aVar;
        }
    }

    public static synchronized void a(String str, b bVar) {
        synchronized (ag.class) {
            if (niR == null) {
                niR = new ag();
            }
            niR.niV.put(str, bVar);
        }
    }

    public static synchronized void o(String str, final String str2, boolean z) {
        synchronized (ag.class) {
            a(str, new b() {
                public final String AC() {
                    return "subinfo=" + str2;
                }
            });
            Assert.assertTrue(str, z);
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (ag.class) {
            if (cVar != null) {
                if (niR == null) {
                    niR = new ag();
                }
                niR.niY.add(cVar);
            }
        }
    }

    private ag() {
        this.niS = null;
        this.niT = null;
        this.niU = null;
        this.niV = new HashMap();
        this.niW = null;
        this.niX = false;
        this.niY = new LinkedList();
        this.niW = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private static String Km(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > '') {
                toCharArray[i] = '\u0000';
                c = '\u0001';
                break;
            }
            i++;
        }
        c = '\u0000';
        if (c != '\u0000') {
            return new String(toCharArray, 0, i);
        }
        return str;
    }

    public static String f(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        th.printStackTrace(printStream);
        String Km = Km(byteArrayOutputStream.toString());
        return Km;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        com.tencent.recovery.b.bMv();
        if (!this.niX) {
            this.niX = true;
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                Throwable th2 = th;
                while (th2.getCause() != null) {
                    th2 = th2.getCause();
                }
                th2.printStackTrace(printStream);
                String Km = Km(byteArrayOutputStream.toString());
                if (!(this.niT == null || Km == null)) {
                    this.niT.dS(Km);
                }
                if (!(this.niS == null || Km == null)) {
                    this.niS.a(this, Km, th);
                    this.niU.ol();
                }
                for (c cVar : this.niY) {
                    if (cVar != null) {
                        try {
                            cVar.oc();
                        } catch (Exception e) {
                        }
                    }
                }
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
            v.appenderClose();
            int myPid = Process.myPid();
            com.tencent.recovery.b.yH(13);
            Process.killProcess(myPid);
            System.exit(0);
        }
    }
}
