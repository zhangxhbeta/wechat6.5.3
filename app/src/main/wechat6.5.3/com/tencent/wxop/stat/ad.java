package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;
import java.util.Timer;
import java.util.TimerTask;

public class ad {
    private static volatile ad pLY = null;
    private Context c = null;
    private Timer pLX = null;

    private ad(Context context) {
        this.c = context.getApplicationContext();
        this.pLX = new Timer(false);
    }

    public static ad ht(Context context) {
        if (pLY == null) {
            synchronized (ad.class) {
                if (pLY == null) {
                    pLY = new ad(context);
                }
            }
        }
        return pLY;
    }

    public final void a() {
        if (b.bPV() == c.PERIOD) {
            long bQe = (long) ((b.bQe() * 60) * 1000);
            if (b.bPW()) {
                l.bQC().bw("setupPeriodTimer delay:" + bQe);
            }
            TimerTask aeVar = new ae(this);
            if (this.pLX != null) {
                if (b.bPW()) {
                    l.bQC().bw("setupPeriodTimer schedule delay:" + bQe);
                }
                this.pLX.schedule(aeVar, bQe);
            } else if (b.bPW()) {
                l.bQC().bx("setupPeriodTimer schedule timer == null");
            }
        }
    }
}
