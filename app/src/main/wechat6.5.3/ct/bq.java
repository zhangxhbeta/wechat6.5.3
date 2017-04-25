package ct;

import android.content.Context;
import android.os.Bundle;
import ct.b.a;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

final class bq extends bo {
    final Context a;

    public bq(Context context, String str) {
        super(str, "load libtencentloc.so myself");
        this.a = context;
        new Thread(this) {
            private /* synthetic */ bq a;

            {
                this.a = r1;
            }

            public final void run() {
                File file = new File(this.a.a.getFilesDir(), "libtencentloc.so");
                Object obj = (!file.exists() || file.length() <= 0) ? null : 1;
                if (obj == null) {
                    file.delete();
                    this.a.b();
                }
            }
        }.start();
    }

    protected final boolean a(Bundle bundle) {
        File file = new File(this.a.getFilesDir(), "libtencentloc.so");
        boolean z = file.exists() && file.length() > 0;
        if (!z) {
            file.delete();
            b();
        }
        try {
            System.load(file.getAbsolutePath());
            return true;
        } catch (Throwable e) {
            a.a("PluginLoadSo", "doWork0: load file(p=" + file.getAbsolutePath() + ",l=" + file.length() + ") failed", e);
            return false;
        }
    }

    final void b() {
        Closeable open;
        Closeable bufferedOutputStream;
        Throwable e;
        String str;
        File file;
        Closeable resourceAsStream;
        Closeable bufferedOutputStream2;
        Closeable closeable = null;
        File file2 = new File(this.a.getFilesDir(), "libtencentloc.so");
        try {
            open = this.a.getAssets().open("libtencentloc");
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = null;
                try {
                    a.a("PluginLoadSo", "copySoFile", e);
                    str = "/res/raw/libtencentloc";
                    file = new File(this.a.getFilesDir(), "libtencentloc.so");
                    try {
                        resourceAsStream = getClass().getResourceAsStream(str);
                        try {
                            bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                            try {
                                a(resourceAsStream, bufferedOutputStream2);
                                a.a(bufferedOutputStream2);
                                a.a(resourceAsStream);
                            } catch (Exception e3) {
                                e = e3;
                                closeable = bufferedOutputStream2;
                                bufferedOutputStream2 = resourceAsStream;
                                try {
                                    a.a("PluginLoadSo", "copySoFile: copy from /res/raw/libtencentloc", e);
                                    a.a(closeable);
                                    a.a(bufferedOutputStream2);
                                    a.a(bufferedOutputStream);
                                    a.a(open);
                                } catch (Throwable th) {
                                    e = th;
                                    resourceAsStream = bufferedOutputStream2;
                                    a.a(closeable);
                                    a.a(resourceAsStream);
                                    throw e;
                                }
                            } catch (Throwable th2) {
                                e = th2;
                                closeable = bufferedOutputStream2;
                                a.a(closeable);
                                a.a(resourceAsStream);
                                throw e;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            bufferedOutputStream2 = resourceAsStream;
                            a.a("PluginLoadSo", "copySoFile: copy from /res/raw/libtencentloc", e);
                            a.a(closeable);
                            a.a(bufferedOutputStream2);
                            a.a(bufferedOutputStream);
                            a.a(open);
                        } catch (Throwable th3) {
                            e = th3;
                            a.a(closeable);
                            a.a(resourceAsStream);
                            throw e;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        bufferedOutputStream2 = null;
                        a.a("PluginLoadSo", "copySoFile: copy from /res/raw/libtencentloc", e);
                        a.a(closeable);
                        a.a(bufferedOutputStream2);
                        a.a(bufferedOutputStream);
                        a.a(open);
                    } catch (Throwable th4) {
                        e = th4;
                        resourceAsStream = null;
                        a.a(closeable);
                        a.a(resourceAsStream);
                        throw e;
                    }
                    a.a(bufferedOutputStream);
                    a.a(open);
                } catch (Throwable th5) {
                    e = th5;
                    a.a(bufferedOutputStream);
                    a.a(open);
                    throw e;
                }
            } catch (Throwable th6) {
                e = th6;
                bufferedOutputStream = null;
                a.a(bufferedOutputStream);
                a.a(open);
                throw e;
            }
            try {
                a(open, bufferedOutputStream);
                a.a(bufferedOutputStream);
                a.a(open);
            } catch (IOException e6) {
                e = e6;
                a.a("PluginLoadSo", "copySoFile", e);
                str = "/res/raw/libtencentloc";
                file = new File(this.a.getFilesDir(), "libtencentloc.so");
                resourceAsStream = getClass().getResourceAsStream(str);
                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                a(resourceAsStream, bufferedOutputStream2);
                a.a(bufferedOutputStream2);
                a.a(resourceAsStream);
                a.a(bufferedOutputStream);
                a.a(open);
            }
        } catch (IOException e7) {
            e = e7;
            bufferedOutputStream = null;
            open = null;
            a.a("PluginLoadSo", "copySoFile", e);
            str = "/res/raw/libtencentloc";
            file = new File(this.a.getFilesDir(), "libtencentloc.so");
            resourceAsStream = getClass().getResourceAsStream(str);
            bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            a(resourceAsStream, bufferedOutputStream2);
            a.a(bufferedOutputStream2);
            a.a(resourceAsStream);
            a.a(bufferedOutputStream);
            a.a(open);
        } catch (Throwable th7) {
            e = th7;
            bufferedOutputStream = null;
            open = null;
            a.a(bufferedOutputStream);
            a.a(open);
            throw e;
        }
    }

    private static void a(InputStream inputStream, BufferedOutputStream bufferedOutputStream) {
        if (inputStream != null && bufferedOutputStream != null) {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        }
    }
}
