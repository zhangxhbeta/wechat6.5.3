package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import com.google.a.a.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;

public abstract class d implements c {
    private final long cAs = 60000;
    Runnable cAx = new Runnable(this) {
        final /* synthetic */ d ppm;

        {
            this.ppm = r1;
        }

        public final void run() {
            this.ppm.esC = true;
            c.d("MicroMsg.Voip", "NETTASK_RECV TimeOut cmd= ", this.ppm.bLS());
            g.s(20006, 3, "-1104");
            if (this.ppm.ppg != null) {
                this.ppm.ppg.a(2, -1, "time exceed, force to callback", this.ppm);
            }
        }
    };
    boolean esC = false;
    private int esS = -999;
    Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean ppe = false;
    public final String ppf = getClass().getSimpleName();
    b ppg = null;
    public byte[] pph = null;
    public Object ppi = null;
    public int ppj;
    public int ppk = 2;
    public int ppl = 0;

    public abstract String bLS();

    public abstract Object bs(byte[] bArr);

    public abstract int getType();

    public final void m(final int i, byte[] bArr) {
        int i2 = 2;
        c.d("MicroMsg.Voip", this.ppf, "onResp errcode", Integer.valueOf(i));
        this.mHandler.removeCallbacks(this.cAx);
        c.d("MicroMsg.Voip", "NETTASK_RECV onResp:cmd= ", bLS(), Integer.valueOf(i), Boolean.valueOf(this.esC));
        if (i != 0) {
            c.i("MicroMsg.Voip", this.ppf, "getNetworkErrType errcode:" + i);
            if (i != -1) {
                i2 = i == 6801 ? 10 : 4;
            } else if (h.isNetworkConnected()) {
                i2 = 1;
            }
        } else {
            i2 = 0;
        }
        if (this.esC) {
            c.d("MicroMsg.Voip", "onResp netscene already canceled, cmd:" + this.ppj);
            return;
        }
        if (this.ppe) {
            SQLiteDatabase.KeyEmpty.length();
        }
        this.esS = i;
        this.ppi = bs(bArr);
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ d ppm;

            public final void run() {
                if (this.ppm.esC) {
                    c.d("MicroMsg.Voip", this.ppm.ppf, "onResp netscene already canceled, cmd:" + this.ppm.ppj);
                } else if (this.ppm.ppg != null) {
                    this.ppm.ppg.a(i2, i, SQLiteDatabase.KeyEmpty, this.ppm);
                }
            }
        });
    }

    public final void c(int i, e eVar) {
        this.ppj = i;
        byte[] bArr = null;
        try {
            bArr = e.b(eVar);
        } catch (Exception e) {
        }
        this.pph = bArr;
    }
}
