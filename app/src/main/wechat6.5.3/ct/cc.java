package ct;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.zip.GZIPOutputStream;

final class cc {
    final LinkedBlockingQueue<a> a = new LinkedBlockingQueue(3);
    final bk b;
    long c;
    long d;
    long e;
    long f;
    volatile boolean g;

    class AnonymousClass1 implements Runnable {
        private /* synthetic */ Handler a;
        private /* synthetic */ cc b;

        AnonymousClass1(cc ccVar, Handler handler) {
            this.b = ccVar;
            this.a = handler;
        }

        public final void run() {
            Throwable e;
            Throwable th;
            this.b.a.clear();
            cc ccVar = this.b;
            Handler handler = this.a;
            LinkedBlockingQueue linkedBlockingQueue = ccVar.a;
            a aVar = null;
            while (ccVar.g) {
                a aVar2;
                try {
                    aVar2 = (a) linkedBlockingQueue.take();
                    try {
                        if (a.d == aVar2) {
                            ct.b.a.a("TxRequestSender", "run: state=[shutdown]");
                            return;
                        }
                        ct.b.a.a("request:" + aVar2.b);
                        long currentTimeMillis = System.currentTimeMillis();
                        String a = ccVar.b.a(aVar2.g, aVar2.f);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        ct.b.a.a("cost:" + currentTimeMillis2 + "request:" + a);
                        ccVar.c++;
                        ccVar.d += (long) aVar2.f.length;
                        byte[] a2 = ct.b.a.a(a.getBytes());
                        ccVar.e += (long) (a2 != null ? a2.length : 0);
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.arg1 = (int) currentTimeMillis2;
                        aVar2.c = currentTimeMillis;
                        if (1 == aVar2.e) {
                            obtainMessage.obj = Pair.create(a, aVar2);
                            obtainMessage.what = 4999;
                            obtainMessage.sendToTarget();
                        }
                        aVar = aVar2;
                    } catch (InterruptedException e2) {
                        e = e2;
                        ct.b.a.a("TxRequestSender", "run: thread is interrupted", e);
                        aVar = aVar2;
                    } catch (IOException e3) {
                        e = e3;
                        ct.b.a.a("TxRequestSender", "cost:" + (System.currentTimeMillis() - 0) + ",run: io error", e);
                        ccVar.a(aVar2);
                        ct.b.a.b("TxRequestSender", "Send timeout");
                        handler.sendEmptyMessageDelayed(4998, 0);
                        aVar = aVar2;
                    }
                } catch (Throwable e4) {
                    th = e4;
                    aVar2 = aVar;
                    e = th;
                    ct.b.a.a("TxRequestSender", "run: thread is interrupted", e);
                    aVar = aVar2;
                } catch (Throwable e42) {
                    th = e42;
                    aVar2 = aVar;
                    e = th;
                    ct.b.a.a("TxRequestSender", "cost:" + (System.currentTimeMillis() - 0) + ",run: io error", e);
                    ccVar.a(aVar2);
                    ct.b.a.b("TxRequestSender", "Send timeout");
                    handler.sendEmptyMessageDelayed(4998, 0);
                    aVar = aVar2;
                }
            }
        }
    }

    static class a {
        public static final a d = new a();
        final Object a;
        public String b;
        public long c;
        private final int e;
        private final byte[] f;
        private final String g;
        private int h;

        private a() {
            this.h = 1;
            this.e = 0;
            this.f = null;
            this.g = null;
            this.a = null;
        }

        a(int i, byte[] bArr, String str, Object obj) {
            this.h = 1;
            this.e = i;
            this.f = bArr;
            this.g = str;
            this.a = obj;
        }
    }

    cc(bk bkVar) {
        this.b = bkVar;
    }

    static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e) {
            return bArr2;
        } catch (Error e2) {
            return bArr2;
        }
    }

    public final void a(String str, ci ciVar, int i) {
        SystemClock.elapsedRealtime();
        try {
            byte[] a = ct.b.a.a(str.getBytes("GBK"));
            a aVar = new a(1, a, a(a, i), ciVar);
            aVar.b = str;
            boolean z = false;
            if (aVar.f != null) {
                z = this.a.offer(aVar);
            }
            if (!z) {
                this.a.clear();
                this.a.offer(aVar);
                ct.b.a.b("TxRequestSender", "postLocationRequest: failed to add request,because the queue has full,so we delete the first");
            }
        } catch (Throwable e) {
            ct.b.a.a("TxRequestSender", SQLiteDatabase.KeyEmpty, e);
        }
    }

    final void a(a aVar) {
        Object obj;
        aVar.h = aVar.h - 1;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).e == aVar.e) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (aVar.h > 0 && r0 == null) {
            ct.b.a.a("TxRequestSender", "retryIfNeed: times=" + aVar.h);
            this.a.offer(aVar);
        }
    }

    private static String a(byte[] bArr, int i) {
        if (!(TencentLogImpl.isDebugEnabled() || bArr == null)) {
            try {
                if (e.o(bArr, 1) >= 0) {
                    return bu.a(i, 1);
                }
            } catch (UnsatisfiedLinkError e) {
                return null;
            }
        }
        return bu.a(i, 0);
    }
}
