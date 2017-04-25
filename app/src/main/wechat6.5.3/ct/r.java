package ct;

import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;

public final class r implements q {
    private static r a = null;

    class a implements Runnable {
        private final ap a;

        a(ap apVar) {
            this.a = apVar;
        }

        public final void run() {
            try {
                Thread.sleep(5000);
                HashMap a = i.a(this.a);
                a.put("B63", this.a.F);
                a.put("B59", this.a.t);
                a.put("B60", this.a.u);
                a.put("B61", this.a.v);
                a.put("B62", this.a.w);
                a.put("B71", this.a.x);
                new StringBuilder("dnsTime:").append(this.a.t).append(";\nconnectTime:").append(this.a.u).append(";\nwaitTime:").append(this.a.v).append(";\nreadTime:").append(this.a.w).append(";\ntotalTime:").append(this.a.x);
                bd.a();
                String str = "B_ACSDK_SDK_Result";
                try {
                    if (as.k() == null) {
                        as.a(p.a);
                    }
                    av.a(str, a);
                } catch (Exception e) {
                } catch (OutOfMemoryError e2) {
                }
            } catch (InterruptedException e3) {
            }
        }
    }

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            if (a == null) {
                a = new r();
            }
            rVar = a;
        }
        return rVar;
    }

    public static void a(ap apVar) {
        HashMap a = i.a(apVar);
        a.put("B64", apVar.G);
        a.put("B79", apVar.P);
        if (!TextUtils.isEmpty(apVar.M)) {
            a.put("B73", apVar.G);
        }
        a.put("B65", apVar.q);
        a.put("B66", apVar.s);
        a.put("B75", apVar.r);
        a.put("B67", apVar.H);
        a.put("B70", apVar.L);
        a.put("B72", apVar.I);
        a.put("B74", apVar.J);
        a.put("B68", apVar.K);
        a.put("B80", apVar.Q);
        a.put("B81", apVar.R);
        a.put("B77", apVar.N);
        a.put("B82", apVar.S);
        a.put("B83", apVar.l);
        a.put("B84", apVar.f);
        a.put("B63", apVar.F);
        a.put("B90", apVar.y);
        a.put("B91", apVar.z);
        a.put("B92", apVar.A);
        a.put("B59", "0");
        a.put("B60", apVar.B);
        a.put("B61", "0");
        a.put("B62", apVar.C);
        a.put("B71", apVar.E);
        a.put("B76", apVar.D);
        String str = "B_ACSDK_SDKExt_Result";
        try {
            if (as.k() == null) {
                as.a(p.a);
            }
            av.a(str, a);
        } catch (Exception e) {
        } catch (OutOfMemoryError e2) {
        }
    }

    public final void a(f fVar) {
        bd.b();
        ap apVar = new ap();
        apVar.a = fVar.b;
        apVar.b = fVar.c;
        apVar.c = fVar.d;
        apVar.d = fVar.a;
        apVar.e = fVar.e;
        apVar.h = fVar.i;
        if (apVar.h == 1) {
            apVar.g = bc.a();
        } else {
            apVar.f = bc.a();
        }
        apVar.i = fVar.j;
        List<String> list = fVar.h;
        if (list == null || list.size() <= 0) {
            apVar.j = SQLiteDatabase.KeyEmpty;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : list) {
                stringBuilder.append(append);
                stringBuilder.append(";");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            apVar.j = stringBuilder.toString();
        }
        apVar.k = fVar.n;
        apVar.m = fVar.o ? 1 : 0;
        apVar.n = fVar.k;
        apVar.o = fVar.l;
        apVar.p = fVar.m;
        apVar.t = (long) fVar.p;
        apVar.v = (long) fVar.r;
        apVar.u = (long) fVar.q;
        apVar.w = (long) fVar.s;
        apVar.x = (long) fVar.t;
        apVar.F = fVar.f;
        new StringBuilder("AccessSchedulerFinished：").append(apVar.toString());
        bd.b();
        o.a().a(new a(apVar));
    }
}
