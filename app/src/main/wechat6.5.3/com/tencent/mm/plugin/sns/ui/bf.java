package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class bf {
    ListView gMx;
    SnsCommentFooter jEp;
    public int jMD = -1;
    int jNR = -1;
    int jZm = -1;
    int jZn = -1;
    public int jZo = 0;
    boolean jZp = false;
    int jZq;
    protected long jZr;
    Runnable jZs = new Runnable(this) {
        final /* synthetic */ bf jZv;

        {
            this.jZv = r1;
        }

        public final void run() {
            if (this.jZv.gMx != null && this.jZv.gMx.getCount() > this.jZv.position) {
                int i;
                int top = this.jZv.jEp.getTop();
                v.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + this.jZv.jZq + " footerHeight:" + this.jZv.jEp.getHeight() + " listOriginalBottom: " + this.jZv.jMD);
                if (this.jZv.jZq = this.jZv.jZq - 1 > 0 && (this.jZv.jNR != top || top > this.jZv.jMD - 200 || this.jZv.gMx.getBottom() > (this.jZv.jMD - this.jZv.jEp.getHeight()) - 150)) {
                    i = 10;
                    if (this.jZv.jZq == 0) {
                        i = 200;
                    }
                    new ac().postDelayed(this, (long) i);
                }
                this.jZv.jNR = top;
                i = (this.jZv.jNR - this.jZv.jZo) - this.jZv.jZm;
                v.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.jZv.jZm + " footerTop" + this.jZv.jNR + " list.bottom:" + this.jZv.gMx.getBottom() + " position: " + this.jZv.position + " topselection: " + i);
                v.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.jZv.gMx.getTop() + " marginTop: " + this.jZv.jZo + " footerTop " + this.jZv.jNR);
                this.jZv.gMx.setSelectionFromTop(this.jZv.position + this.jZv.gMx.getHeaderViewsCount(), i);
            }
        }
    };
    Runnable jZt = new Runnable(this) {
        final /* synthetic */ bf jZv;
        int offset = 0;

        {
            this.jZv = r2;
        }

        public final void run() {
            if (this.jZv.gMx != null && this.jZv.gMx.getCount() > this.jZv.position) {
                this.jZv.jNR = this.jZv.jEp.getTop();
                int i = (this.jZv.jNR - this.jZv.jZo) - this.jZv.jZm;
                v.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.jZv.jZm + " footerTop" + this.jZv.jNR + " list.bottom:" + this.jZv.gMx.getBottom() + " position: " + this.jZv.position + " topselection: " + i);
                v.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.jZv.gMx.getTop() + " marginTop: " + this.jZv.jZo + " footerTop " + this.jZv.jNR);
                if (i == this.offset && this.jZv.gMx.getBottom() < this.jZv.jMD - 150) {
                    this.jZv.gMx.setSelectionFromTop(this.jZv.position + this.jZv.gMx.getHeaderViewsCount(), i);
                    this.offset = 0;
                    this.jZv.jZq = 0;
                } else if (this.jZv.jZq = this.jZv.jZq - 1 > 0) {
                    new ac().postDelayed(this, 100);
                    this.offset = i;
                } else {
                    this.offset = 0;
                    this.jZv.jZq = 0;
                }
            }
        }
    };
    Runnable jZu = new Runnable(this) {
        final /* synthetic */ bf jZv;

        {
            this.jZv = r1;
        }

        public final void run() {
            v.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + this.jZv.jZn + " position:" + this.jZv.position + " list.bottom:" + this.jZv.gMx.getBottom());
        }
    };
    int position = -1;

    public bf(ListView listView, SnsCommentFooter snsCommentFooter) {
        this.gMx = listView;
        this.jEp = snsCommentFooter;
    }

    public final void aYn() {
        this.jZp = true;
        new ac().postDelayed(this.jZs, 30);
        this.jZq = 10;
        v.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.jEp.getTop());
        this.jZr = be.Nj();
    }

    public final void aYo() {
        if (this.jZp) {
            this.jZp = false;
            new ac().postDelayed(this.jZu, 30);
            this.jZq = 10;
        }
    }
}
