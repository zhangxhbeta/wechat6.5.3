package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import junit.framework.Assert;

public final class MMGridPaper extends LinearLayout {
    protected View PH;
    protected int dWf;
    protected int dWg;
    protected int eUh = 0;
    protected int eZz = 0;
    protected MMDotView fjs;
    protected ac iqg = new ac(Looper.getMainLooper());
    protected int nSB = 10;
    protected int nSC = 10;
    final b nUW = new b(this) {
        final /* synthetic */ MMGridPaper nVJ;

        {
            this.nVJ = r1;
        }

        public final void pa(final int i) {
            v.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", Integer.valueOf(i), Integer.valueOf(this.nVJ.nVq), Integer.valueOf(this.nVJ.nVr), Integer.valueOf(this.nVJ.nVs));
            if (i <= this.nVJ.nVq && this.nVJ.nVq > 0) {
                this.nVJ.iqg.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 nVL;

                    public final void run() {
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) this.nVL.nVJ.nVl.getChildAt(this.nVL.nVJ.nVl.getChildCount() - 1);
                        v.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", Integer.valueOf(this.nVL.nVJ.nVl.getChildCount() - 1), Integer.valueOf(i - (this.nVL.nVJ.nVl.getChildCount() >> 1)));
                        this.nVL.nVJ.nVl.removeViewAt(this.nVL.nVJ.nVl.getChildCount() - 1);
                        mMGridPaperGridView.a(r1, this.nVL.nVJ.eUh, this.nVL.nVJ.eZz, this.nVL.nVJ.nVm);
                        this.nVL.nVJ.nVl.addView(mMGridPaperGridView, 0);
                        this.nVL.nVJ.nVl.wv(this.nVL.nVJ.nVl.getChildCount() >> 1);
                        MMGridPaper.a(this.nVL.nVJ, -1);
                    }
                });
            } else if (i >= this.nVJ.nVr && this.nVJ.nVr < this.nVJ.nVs - 1) {
                this.nVJ.iqg.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 nVL;

                    public final void run() {
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) this.nVL.nVJ.nVl.getChildAt(0);
                        v.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", Integer.valueOf(i + (this.nVL.nVJ.nVl.getChildCount() >> 1)));
                        this.nVL.nVJ.nVl.removeViewAt(0);
                        mMGridPaperGridView.a(r1, this.nVL.nVJ.eUh, this.nVL.nVJ.eZz, this.nVL.nVJ.nVm);
                        this.nVL.nVJ.nVl.addView(mMGridPaperGridView);
                        this.nVL.nVJ.nVl.wv(this.nVL.nVJ.nVl.getChildCount() >> 1);
                        MMGridPaper.a(this.nVL.nVJ, 1);
                    }
                });
            }
            this.nVJ.nVo = i;
            this.nVJ.fjs.wu(i);
        }
    };
    final a nUX = new a(this) {
        final /* synthetic */ MMGridPaper nVJ;

        {
            this.nVJ = r1;
        }

        public final void ck(int i, int i2) {
            v.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", Integer.valueOf(i), Integer.valueOf(this.nVJ.dWf), Integer.valueOf(i2), Integer.valueOf(this.nVJ.dWg), Boolean.valueOf(this.nVJ.nVA), Boolean.valueOf(this.nVJ.nVz));
            if ((Math.abs(this.nVJ.dWg - i2) < 50 && Math.abs(this.nVJ.dWf - i) < 50) || i2 == 0 || i == 0) {
                v.d("MicroMsg.MMGridPaper", "match width height limit, return");
            } else if (!this.nVJ.nVA || this.nVJ.dWf <= i || this.nVJ.nVz) {
                v.v("MicroMsg.MMGridPaper", "onMeasure: match");
                v.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", Boolean.valueOf(this.nVJ.nVG));
                this.nVJ.nVz = false;
                if (!this.nVJ.nVG) {
                    this.nVJ.dWg = i2;
                    this.nVJ.dWf = i;
                }
                this.nVJ.refresh();
            } else {
                v.d("MicroMsg.MMGridPaper", "match ori limit, return");
            }
        }
    };
    protected boolean nVA = false;
    protected int nVB = -1;
    protected int nVC = -1;
    protected int nVD = 0;
    protected int nVE = -1;
    protected int nVF = -1;
    protected boolean nVG = false;
    protected int nVH = 0;
    protected int nVI = 0;
    protected MMFlipper nVl;
    protected j nVm;
    protected int nVn = 0;
    protected int nVo = 0;
    protected int nVp = 3;
    protected int nVq = 0;
    protected int nVr = (this.nVp - 1);
    protected int nVs = 0;
    protected boolean nVt = false;
    protected int nVu = 9;
    protected int nVv = -1;
    protected int nVw = -1;
    protected int nVx = 96;
    protected int nVy = 96;
    protected boolean nVz = false;

    static /* synthetic */ void a(MMGridPaper mMGridPaper, int i) {
        mMGridPaper.nVq += i;
        if (mMGridPaper.nVq < 0) {
            mMGridPaper.nVq = 0;
        } else if (mMGridPaper.nVq > mMGridPaper.nVs - mMGridPaper.nVp) {
            mMGridPaper.nVq = mMGridPaper.nVs - mMGridPaper.nVp;
        }
        mMGridPaper.nVr = (mMGridPaper.nVq + mMGridPaper.nVp) - 1;
    }

    public MMGridPaper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(getContext(), 2130903990, this);
        this.nVD = bpv();
    }

    public final void bBU() {
        this.nVx = 70;
    }

    public final void bBV() {
        this.nVy = 70;
    }

    public final void bBW() {
        this.nVF = 3;
    }

    public final void wy(int i) {
        this.nVE = i;
    }

    public final void bBX() {
        this.nVA = true;
    }

    public final void bBY() {
        this.nVC = 3;
        this.nVB = 3;
    }

    public final void bBZ() {
        this.nSB = 8;
        this.nSC = 15;
    }

    public final void bCa() {
        this.PH = null;
        ViewGroup viewGroup = (ViewGroup) findViewById(2131755305);
        viewGroup.removeAllViews();
        if (this.PH != null) {
            viewGroup.addView(this.PH);
        }
    }

    public final void a(j jVar) {
        boolean z = true;
        this.nVm = jVar;
        String str = "MicroMsg.MMGridPaper";
        String str2 = "setGridPaperAdapter:adapter is null[%B]";
        Object[] objArr = new Object[1];
        if (jVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.d(str, str2, objArr);
        if (this.nVm != null) {
            this.nVm.nVM = new j.a(this) {
                final /* synthetic */ MMGridPaper nVJ;

                {
                    this.nVJ = r1;
                }

                public final void bCe() {
                    this.nVJ.refresh();
                }
            };
        }
        bpw();
    }

    public final void refresh() {
        this.nVn = (this.nVo * this.eZz) * this.eUh;
        v.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", Integer.valueOf(this.nVo), Integer.valueOf(this.eZz), Integer.valueOf(this.eUh), Integer.valueOf(this.nVn));
        bpw();
    }

    private int bpv() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    private void bCb() {
        View findViewById;
        LayoutParams layoutParams;
        int fromDPToPix;
        if (-1 != this.nVv && bpv() == 2) {
            findViewById = findViewById(2131758226);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(getContext(), this.nVv);
            if (fromDPToPix != layoutParams.height) {
                v.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", Integer.valueOf(this.nVv));
                layoutParams.height = fromDPToPix;
                findViewById.setLayoutParams(layoutParams);
                this.iqg.post(new Runnable(this) {
                    final /* synthetic */ MMGridPaper nVJ;

                    {
                        this.nVJ = r1;
                    }

                    public final void run() {
                        v.w("MicroMsg.MMGridPaper", "post do setDotView");
                        this.nVJ.bCd();
                    }
                });
            }
        } else if (-1 != this.nVw && bpv() == 1) {
            findViewById = findViewById(2131758226);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(getContext(), this.nVw);
            if (fromDPToPix != layoutParams.height) {
                v.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", Integer.valueOf(this.nVw));
                layoutParams.height = fromDPToPix;
                findViewById.setLayoutParams(layoutParams);
                this.iqg.post(new Runnable(this) {
                    final /* synthetic */ MMGridPaper nVJ;

                    {
                        this.nVJ = r1;
                    }

                    public final void run() {
                        v.w("MicroMsg.MMGridPaper", "post do setDotView");
                        this.nVJ.bCd();
                    }
                });
            }
        }
    }

    private void bpw() {
        v.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
        if (this.fjs == null) {
            this.fjs = (MMDotView) findViewById(2131758228);
            MMDotView mMDotView = this.fjs;
            v.d("MicroMsg.MMDotView", "setMaxCount:%d", Integer.valueOf(this.nVu));
            mMDotView.caG = r1;
        }
        if (this.nVl == null) {
            this.nVl = (MMFlipper) findViewById(2131758227);
            this.nVl.nUX = this.nUX;
            this.nVl.nUW = this.nUW;
        }
        bCb();
        bCc();
    }

    private void bCc() {
        v.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", Integer.valueOf(this.dWf), Integer.valueOf(this.dWg));
        if (this.dWf == 0 || this.dWg == 0) {
            v.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
            return;
        }
        boolean z;
        int min;
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(getContext(), this.nVx);
        int fromDPToPix2 = com.tencent.mm.bd.a.fromDPToPix(getContext(), this.nVy);
        fromDPToPix = Math.max(this.dWf / fromDPToPix, 1);
        fromDPToPix2 = Math.max(this.dWg / fromDPToPix2, 1);
        if (!(fromDPToPix == this.eZz && fromDPToPix2 == this.eUh)) {
            this.nVt = true;
        }
        this.eZz = fromDPToPix;
        if (this.nVE != -1) {
            this.eZz = Math.min(this.eZz, this.nVE);
        }
        this.eUh = fromDPToPix2;
        if (this.nVF != -1) {
            this.eUh = Math.min(this.eUh, this.nVF);
        }
        int i = this.eZz * this.eUh;
        this.nVs = 0;
        fromDPToPix2 = (this.nVm == null ? 0 : this.nVm.getCount()) + 0;
        v.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", Integer.valueOf(fromDPToPix2), Boolean.valueOf(this.nVA));
        if (fromDPToPix2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.nVA) {
            fromDPToPix = df(fromDPToPix2, this.eZz);
            switch (bpv()) {
                case 1:
                    min = ((this.nVy + 10) * Math.min(fromDPToPix, this.nVB)) + 8;
                    v.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(bpv()), Integer.valueOf(Math.min(fromDPToPix, this.nVB)), Integer.valueOf(min), Integer.valueOf(this.nVw), Boolean.valueOf(this.nVz));
                    if (this.nVw == min) {
                        z = true;
                        break;
                    }
                    this.nVw = min;
                    z = false;
                    break;
                case 2:
                    min = ((this.nVy + 10) * Math.min(fromDPToPix, this.nVC)) + 8;
                    v.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(bpv()), Integer.valueOf(Math.min(fromDPToPix, this.nVC)), Integer.valueOf(min), Integer.valueOf(this.nVv), Boolean.valueOf(this.nVz));
                    if (this.nVv == min) {
                        z = true;
                        break;
                    }
                    this.nVv = min;
                    z = false;
                    break;
            }
        }
        z = true;
        if (z) {
            this.nVs = df(fromDPToPix2, i);
            min = this.nVs - 1;
            int i2 = this.nVn;
            if (i2 == 0 || i <= 0) {
                v.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", Integer.valueOf(i2), Integer.valueOf(i));
                fromDPToPix = 0;
            } else {
                fromDPToPix2 = i2;
                fromDPToPix = 0;
                while (fromDPToPix2 >= i) {
                    fromDPToPix2 -= i;
                    fromDPToPix++;
                }
                v.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(fromDPToPix));
            }
            this.nVo = Math.min(min, fromDPToPix);
            this.nVp = Math.min(3, this.nVs);
            this.nVq = Math.min(this.nVs - this.nVp, Math.max(0, this.nVo - (this.nVp >> 1)));
            this.nVr = (this.nVq + this.nVp) - 1;
            v.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", Integer.valueOf(this.nVx), Integer.valueOf(this.nVy), Integer.valueOf(this.eUh), Integer.valueOf(this.eZz), Integer.valueOf(this.nVp), Integer.valueOf(this.nVs), Integer.valueOf(this.nVo), Integer.valueOf(this.nVq), Integer.valueOf(this.nVr));
            MMGridPaperGridView mMGridPaperGridView;
            if (this.nVl.getChildCount() != this.nVp || this.nVt) {
                v.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", Boolean.valueOf(this.nVt));
                this.nVt = false;
                this.nVl.removeAllViews();
                for (int i3 = this.nVq; i3 <= this.nVr; i3++) {
                    mMGridPaperGridView = (MMGridPaperGridView) inflate(getContext(), 2130903983, null);
                    mMGridPaperGridView.a(i3, this.eUh, this.eZz, this.nVm);
                    mMGridPaperGridView.setHorizontalSpacing(com.tencent.mm.bd.a.fromDPToPix(getContext(), this.nSB));
                    mMGridPaperGridView.setVerticalSpacing(com.tencent.mm.bd.a.fromDPToPix(getContext(), this.nSC));
                    this.nVl.addView(mMGridPaperGridView, new LayoutParams(-1, -1));
                }
            } else {
                for (fromDPToPix2 = this.nVq; fromDPToPix2 <= this.nVr; fromDPToPix2++) {
                    mMGridPaperGridView = (MMGridPaperGridView) this.nVl.getChildAt(fromDPToPix2 - this.nVq);
                    if (mMGridPaperGridView.mIndex != fromDPToPix2) {
                        v.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", Integer.valueOf(mMGridPaperGridView.mIndex), Integer.valueOf(fromDPToPix2));
                        mMGridPaperGridView.a(fromDPToPix2, this.eUh, this.eZz, this.nVm);
                        if (mMGridPaperGridView.nVS != null) {
                            mMGridPaperGridView.nVS.notifyDataSetChanged();
                        }
                    } else {
                        v.v("MicroMsg.MMGridPaper", "same grid index, continus");
                    }
                }
            }
            bCd();
            return;
        }
        bCb();
    }

    private static int df(int i, int i2) {
        if (i2 <= 0) {
            v.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
            return 0;
        }
        int i3 = i;
        int i4 = 0;
        while (i3 > 0) {
            i3 -= i2;
            i4++;
        }
        v.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
        return i4;
    }

    private void bCd() {
        v.v("MicroMsg.MMGridPaper", "set DotView");
        Assert.assertTrue(this.nVs >= 0);
        this.fjs.wt(this.nVs);
        if (this.nVm == null || this.nVs <= 1) {
            this.fjs.setVisibility(8);
            v.v("MicroMsg.MMGridPaper", "set DotView gone");
        } else {
            this.fjs.setVisibility(0);
            v.v("MicroMsg.MMGridPaper", "set DotView visible");
        }
        if (this.nVo >= this.nVs) {
            this.nVo = this.nVs - 1;
        }
        this.nVl.wv(this.nVo - this.nVq);
        this.nVl.ww(this.nVo);
        this.fjs.wu(this.nVo);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        v.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.nVD != bpv()) {
            this.nVD = bpv();
            v.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
            this.nVz = true;
            clearAnimation();
            bCb();
            bCc();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @TargetApi(8)
    public final void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            v.d("MicroMsg.MMGridPaper", "onConfigChanged:" + configuration.orientation);
            this.nVz = true;
        }
    }
}
