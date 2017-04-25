package com.tencent.mm.plugin.g.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.b.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    a ihq = null;
    long ihr = 0;
    boolean ik = false;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String ihs;
        final /* synthetic */ a iht;

        AnonymousClass1(a aVar, String str) {
            this.iht = aVar;
            this.ihs = str;
        }

        public final void run() {
            new b(this.iht).execute(new String[]{this.ihs});
        }
    }

    public interface a {
        int a(d dVar);
    }

    class b extends AsyncTask<String, Integer, d> {
        final /* synthetic */ a iht;

        b(a aVar) {
            this.iht = aVar;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return r((String[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            d dVar = (d) obj;
            if (this.iht.ihq != null) {
                this.iht.ihq.a(dVar);
            }
        }

        private d r(String... strArr) {
            d dVar = null;
            v.d("dktest", "doInBackground :" + strArr);
            if (strArr != null && strArr.length == 1) {
                try {
                    this.iht.ihr = System.currentTimeMillis();
                    com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                    dVar = this.iht.yn(strArr[0]);
                    v.d("MicroMsg.scanner.DecodeFile", "time: " + aVar.sn());
                } catch (OutOfMemoryError e) {
                    v.e("MicroMsg.scanner.DecodeFile", "decode failed, OutOfMemoryError");
                } catch (Throwable e2) {
                    v.a("MicroMsg.scanner.DecodeFile", e2, "decode failed due to Exception", new Object[]{""});
                }
            }
            return dVar;
        }
    }

    final d yn(String str) {
        OutOfMemoryError e;
        if (str == null || str.length() <= 0) {
            v.e("MicroMsg.scanner.DecodeFile", "in decodeFile, file == null");
            return null;
        }
        Options JS = d.JS(str);
        if (JS != null) {
            JS.inJustDecodeBounds = false;
            JS.inPreferredConfig = Config.RGB_565;
        }
        if (this.ik) {
            return null;
        }
        d a;
        try {
            Bitmap decodeFile = d.decodeFile(str, JS);
            if (decodeFile == null) {
                v.e("MicroMsg.scanner.DecodeFile", "decode bitmap is null!");
                return null;
            }
            com.tencent.mm.plugin.scanner.b.d dVar = new com.tencent.mm.plugin.scanner.b.d(null, 0, false);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            a = a(dVar, decodeFile, 3);
            l.iwj.aKV();
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            v.d("MicroMsg.scanner.DecodeFile", "decode once time(ms):" + elapsedRealtime);
            if (a == null || be.kS(a.bfz)) {
                if (elapsedRealtime == 0) {
                    elapsedRealtime = 1;
                }
                v.i("MicroMsg.scanner.DecodeFile", "max retry time: %s", new Object[]{Integer.valueOf((int) (20000 / elapsedRealtime))});
                for (int i = 1; i < r3 && !this.ik; i++) {
                    int i2 = (i * 8) + 3;
                    if (i2 >= decodeFile.getWidth() || i2 >= decodeFile.getHeight() || System.currentTimeMillis() - this.ihr > 5000) {
                        break;
                    }
                    a = a(dVar, decodeFile, i2);
                    l.iwj.aKV();
                    if (a != null && !be.kS(a.bfz)) {
                        v.d("MicroMsg.scanner.DecodeFile", "Decode file done, i = %d, max times = %d, width = %d, height = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(r3), Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight())});
                        break;
                    }
                }
            }
            dVar.aLM();
            try {
                String str2 = "MicroMsg.scanner.DecodeFile";
                String str3 = "decode result==null:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(a == null);
                v.d(str2, str3, objArr);
                return (a == null || be.kS(a.bfz)) ? a : a;
            } catch (OutOfMemoryError e2) {
                e = e2;
                v.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", new Object[]{e.getMessage()});
                return a;
            }
        } catch (OutOfMemoryError e3) {
            OutOfMemoryError outOfMemoryError = e3;
            a = null;
            e = outOfMemoryError;
            v.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", new Object[]{e.getMessage()});
            return a;
        }
    }

    private static d a(com.tencent.mm.plugin.scanner.b.d dVar, Bitmap bitmap, int i) {
        c.a fVar = new f(bitmap, i, i);
        if (fVar.aLQ() == null || fVar.width <= 0 || fVar.height <= 0) {
            return null;
        }
        return dVar.a(fVar);
    }
}
