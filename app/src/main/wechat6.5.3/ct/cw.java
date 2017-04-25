package ct;

import ct.b.a;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public final class cw {
    private static final FilenameFilter a = new FilenameFilter() {
        public final boolean accept(File file, String str) {
            return str.endsWith(".stacktrace");
        }
    };
    private static boolean b;

    static /* synthetic */ void a(bk bkVar, String str, File file) {
        if (file != null) {
            File[] listFiles = file.listFiles(a);
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    try {
                        byte[] a = a.a(file2);
                        if (a.length == 0) {
                            file2.delete();
                        } else {
                            bkVar.a(str, a);
                            file2.delete();
                        }
                    } catch (Throwable e) {
                        a.a("ExceptionReporter", e.getMessage(), e);
                    }
                }
            }
        }
    }

    public static synchronized CountDownLatch a(bk bkVar, String str, String str2, String str3) {
        final CountDownLatch countDownLatch;
        synchronized (cw.class) {
            countDownLatch = new CountDownLatch(1);
            final bk bkVar2 = bkVar;
            final String str4 = str;
            final String str5 = str3;
            final String str6 = str2;
            new Thread() {
                public final void run() {
                    BufferedWriter bufferedWriter;
                    if (!cw.b) {
                        cw.b = true;
                        cw.a(bkVar2, str4, new File(str5).getParentFile());
                        try {
                            bkVar2.a(str4, str6.getBytes());
                        } catch (Throwable e) {
                            a.a("ExceptionReporter", "exception", e);
                            try {
                                bufferedWriter = new BufferedWriter(new FileWriter(str5));
                                bufferedWriter.write(str6);
                                bufferedWriter.flush();
                            } catch (IOException e2) {
                            }
                        } finally {
                            bufferedWriter.close();
                        }
                        cw.b = false;
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        return countDownLatch;
    }
}
