package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    boolean bhY;
    ah cSA = null;
    private int duration;
    private float pPJ = 0.0f;
    private float pPK;
    float pPL;
    long pPM;
    float pPN;
    a pPO;
    private Runnable pPP = new Runnable(this) {
        final /* synthetic */ a pPQ;

        {
            this.pPQ = r1;
        }

        public final void run() {
            a.a(this.pPQ);
            if (!this.pPQ.bhY) {
                v.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
            } else if (this.pPQ.pPN < this.pPQ.pPL) {
                this.pPQ.cSA.post(this);
            } else {
                this.pPQ.bhY = false;
                v.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s", new Object[]{Float.valueOf(this.pPQ.pPN), Float.valueOf(this.pPQ.pPL)});
                if (this.pPQ.pPO != null) {
                    this.pPQ.pPO.onAnimationEnd();
                }
            }
        }
    };

    public interface a {
        void am(float f);

        void onAnimationEnd();
    }

    static /* synthetic */ void a(a aVar) {
        v.d("MicroMsg.ProgressHandlerAnimator", "updateImpl, currentValue: %s", new Object[]{Float.valueOf(aVar.pPN)});
        aVar.pPN = (((float) be.az(aVar.pPM)) / ((float) aVar.duration)) * (aVar.pPL - aVar.pPK);
        if (aVar.pPO != null) {
            aVar.pPO.am(aVar.pPN);
        }
    }

    public a(float f, float f2, int i) {
        this.pPK = f;
        this.pPL = f2;
        this.duration = i;
        if (f2 > f) {
            this.pPJ = ((f2 - f) / ((float) this.duration)) * 20.0f;
        }
        v.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Float.valueOf(this.pPJ)});
        this.bhY = false;
        this.pPM = 0;
        this.cSA = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ a pPQ;

            {
                this.pPQ = r1;
            }

            public final boolean oU() {
                a.a(this.pPQ);
                if (!this.pPQ.bhY) {
                    v.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
                    return false;
                } else if (this.pPQ.pPN < this.pPQ.pPL) {
                    return true;
                } else {
                    this.pPQ.bhY = false;
                    v.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[]{Float.valueOf(this.pPQ.pPN), Float.valueOf(this.pPQ.pPL), this.pPQ.pPO});
                    if (this.pPQ.pPO != null) {
                        this.pPQ.pPO.onAnimationEnd();
                    }
                    return false;
                }
            }
        }, true);
    }
}
