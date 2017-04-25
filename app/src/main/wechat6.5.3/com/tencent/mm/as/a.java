package com.tencent.mm.as;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.mm.a.e;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public final class a {
    String aST = null;
    String bdZ = null;
    String bou = null;
    Context context = null;
    public a dgj = null;
    String dgk = null;
    final AsyncTask<String, Integer, String> dgl = new AsyncTask<String, Integer, String>(this) {
        final /* synthetic */ a dgm;
        int ret = 0;

        {
            this.dgm = r2;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return KK();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            if (this.dgm.dgj != null) {
                this.dgm.dgj.a(this.ret, this.dgm.aST, this.dgm.dgk, this.dgm.duration);
            }
        }

        private String KK() {
            com.tencent.mm.compatible.i.a.a l;
            Throwable e;
            this.ret = 0;
            boolean is2G = ak.is2G(aa.getContext());
            try {
                l = com.tencent.mm.compatible.i.a.l(this.dgm.context, this.dgm.intent);
            } catch (Throwable e2) {
                v.e("MicroMsg.ImportVideo", "exception:%s", be.e(e2));
                l = null;
            }
            if (l == null) {
                v.e("MicroMsg.ImportVideo", "GetVideoMetadata filed.");
                g.iuh.a(106, 244, 1, false);
                this.ret = -50005;
                return null;
            }
            this.dgm.dgk = l.filename;
            int aQ = e.aQ(this.dgm.dgk);
            v.i("MicroMsg.ImportVideo", "import file is2G:%b len:%d duration:%d path:%s ", Boolean.valueOf(is2G), Integer.valueOf(aQ), Integer.valueOf(l.duration), this.dgm.dgk);
            if (aQ <= 0) {
                g.iuh.a(106, 244, 1, false);
                this.ret = -50001;
                return null;
            }
            if (aQ > (is2G ? 10485760 : 20971520)) {
                g.iuh.a(106, 245, 1, false);
                this.ret = -50002;
                return null;
            }
            j.n(this.dgm.dgk, this.dgm.bou, false);
            this.dgm.duration = l.duration / 1000;
            Object obj = 1;
            if (l.bitmap != null) {
                try {
                    d.a(l.bitmap, 60, CompressFormat.JPEG, this.dgm.bdZ, true);
                    try {
                        g.iuh.a(106, 231, 1, false);
                        obj = null;
                    } catch (Exception e3) {
                        e2 = e3;
                        obj = null;
                        v.e("MicroMsg.ImportVideo", "exception:%s", be.e(e2));
                        if (obj != null) {
                            try {
                                g.iuh.a(106, 232, 1, false);
                                d.a(d.Q(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, this.dgm.bdZ, true);
                            } catch (Throwable e22) {
                                v.e("MicroMsg.ImportVideo", "exception:%s", be.e(e22));
                            }
                        }
                        if (!e.aR(this.dgm.bou)) {
                            this.ret = -50003;
                        }
                        if (!e.aR(this.dgm.bdZ)) {
                            this.ret = -50004;
                        }
                        return null;
                    }
                } catch (Exception e4) {
                    e22 = e4;
                    v.e("MicroMsg.ImportVideo", "exception:%s", be.e(e22));
                    if (obj != null) {
                        g.iuh.a(106, 232, 1, false);
                        d.a(d.Q(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, this.dgm.bdZ, true);
                    }
                    if (e.aR(this.dgm.bou)) {
                        this.ret = -50003;
                    }
                    if (e.aR(this.dgm.bdZ)) {
                        this.ret = -50004;
                    }
                    return null;
                }
            }
            if (obj != null) {
                g.iuh.a(106, 232, 1, false);
                d.a(d.Q(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, this.dgm.bdZ, true);
            }
            if (e.aR(this.dgm.bou)) {
                this.ret = -50003;
            }
            if (e.aR(this.dgm.bdZ)) {
                this.ret = -50004;
            }
            return null;
        }
    };
    int duration = 0;
    Intent intent = null;

    public interface a {
        void a(int i, String str, String str2, int i2);
    }

    public final void a(Context context, Intent intent, a aVar) {
        this.context = context;
        this.intent = intent;
        com.tencent.mm.model.ak.yW();
        this.aST = o.lb((String) c.vf().get(2, SQLiteDatabase.KeyEmpty));
        k.KV();
        this.bdZ = o.ld(this.aST);
        k.KV();
        this.bou = o.lc(this.aST);
        this.dgj = aVar;
        this.dgl.execute(new String[0]);
    }
}
