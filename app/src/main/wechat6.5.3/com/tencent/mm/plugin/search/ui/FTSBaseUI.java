package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelsearch.FTSUtils;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.plugin.search.a.i;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public abstract class FTSBaseUI extends MMActivity implements b.a, c, p.a {
    String bkC;
    p eyI;
    TextView gxS;
    private VoiceSearchLayout iHo;
    ListView iHp;
    private b iHq;
    private RelativeLayout iHr;
    private boolean iHs = false;

    protected abstract b a(c cVar);

    protected abstract boolean aMn();

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.nDR.nEl;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bAb();
        Fd("");
        aMr();
        this.eyI = new p();
        this.eyI.kj(aMA());
        this.eyI.a(this);
        this.eyI.lUX = aMn();
        this.iHp = (ListView) findViewById(2131757154);
        if (abc() != null) {
            v.i("MicroMsg.FTS.FTSBaseUI", "searchResultLV addFooterView");
            this.iHp.addFooterView(abc());
        }
        this.iHq = a((c) this);
        this.iHq.iHn = this;
        this.iHp.setAdapter(this.iHq);
        this.iHp.setOnScrollListener(this.iHq);
        this.iHp.setOnItemClickListener(this.iHq);
        this.iHp.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FTSBaseUI iHt;

            {
                this.iHt = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.iHt.eyI.clearFocus();
                this.iHt.axg();
                return false;
            }
        });
        if (aMn()) {
            this.iHo = new VoiceSearchLayout(this);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14);
            this.iHo.setLayoutParams(layoutParams);
            this.iHo.tR(b.a(this, 100.0f));
            this.iHo.fDt.findViewById(2131759672).setBackgroundResource(0);
            this.iHo.setVisibility(8);
            this.eyI.o(this.iHo);
            this.iHr = (RelativeLayout) findViewById(2131757155);
            this.iHr.addView(this.iHo);
        }
        this.gxS = (TextView) findViewById(2131755213);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FTSBaseUI iHt;

            {
                this.iHt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iHt.finish();
                return true;
            }
        });
    }

    protected void aMr() {
    }

    protected View abc() {
        return null;
    }

    public final void Yt() {
        v.d("MicroMsg.FTS.FTSBaseUI", "onVoiceSearchStart");
        aMs();
    }

    public final void Yu() {
        v.d("MicroMsg.FTS.FTSBaseUI", "onVoiceSearchCancel");
        aMt();
    }

    public void a(boolean z, String[] strArr, long j, int i) {
        v.d("MicroMsg.FTS.FTSBaseUI", "onVoiceReturn");
        aMt();
    }

    public final void Og() {
        v.d("MicroMsg.FTS.FTSBaseUI", "onEnterSearch");
    }

    public final void Of() {
        v.d("MicroMsg.FTS.FTSBaseUI", "onQuitSearch");
        finish();
    }

    public void ml(String str) {
        v.d("MicroMsg.FTS.FTSBaseUI", "onSearchChange %s", new Object[]{str});
        if (be.kS(str)) {
            if (!this.eyI.bIT()) {
                this.eyI.bIU();
                aJs();
            }
            aMx();
        } else if (str.startsWith("$$")) {
            String replace = str.replace("$$", "");
            if (!be.kS(replace)) {
                try {
                    i.aMj().searchMode = Integer.valueOf(replace).intValue();
                    v.i("MicroMsg.FTS.SubCoreSearch", "set search mode %d", new Object[]{Integer.valueOf(r0)});
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        this.bkC = FTSUtils.jG(str);
        if (be.kS(this.bkC)) {
            stopSearch();
        } else {
            aMo();
        }
    }

    public final void Oh() {
    }

    public boolean mk(String str) {
        v.d("MicroMsg.FTS.FTSBaseUI", "onSearchKeyDown %s", new Object[]{str});
        axg();
        if (this.eyI != null) {
            this.eyI.clearFocus();
        }
        return false;
    }

    protected void aMo() {
        this.iHs = true;
        this.iHq.zj(this.bkC);
        aMu();
    }

    protected void aMs() {
        this.gxS.setVisibility(8);
        if (this.iHr != null) {
            this.iHr.setVisibility(0);
        }
        this.iHp.setVisibility(8);
    }

    protected void aMt() {
        this.gxS.setVisibility(8);
        if (this.iHr != null) {
            this.iHr.setVisibility(8);
        }
        this.iHp.setVisibility(8);
    }

    protected void aMu() {
        this.gxS.setVisibility(8);
        if (this.iHr != null) {
            this.iHr.setVisibility(8);
        }
        this.iHp.setVisibility(8);
    }

    protected void aMv() {
        this.gxS.setVisibility(0);
        this.gxS.setText(h.m(getString(2131234830), getString(2131234829), this.bkC));
        if (this.iHr != null) {
            this.iHr.setVisibility(8);
        }
        this.iHp.setVisibility(8);
    }

    protected void aMw() {
        this.gxS.setVisibility(8);
        if (this.iHr != null) {
            this.iHr.setVisibility(8);
        }
        this.iHp.setVisibility(0);
    }

    protected void aMx() {
        this.gxS.setVisibility(8);
        if (this.iHr != null) {
            this.iHr.setVisibility(8);
        }
        this.iHp.setVisibility(8);
    }

    protected void stopSearch() {
        this.iHs = false;
        this.iHq.stopSearch();
        aMx();
    }

    protected void onPause() {
        super.onPause();
        this.eyI.cancel();
        this.eyI.clearFocus();
    }

    protected void onDestroy() {
        this.iHq.finish();
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.eyI.a(this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.eyI.a(this, menu);
        return true;
    }

    public void E(int i, boolean z) {
        v.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (z) {
            aMz();
            if (i > 0) {
                aMw();
            } else {
                aMv();
            }
        } else if (i > 0) {
            aMw();
            aMy();
        } else {
            aMu();
            aMz();
        }
        if (this.iHs) {
            this.iHs = false;
            this.iHp.setSelection(0);
        }
    }

    protected void aMy() {
    }

    protected void aMz() {
    }

    protected boolean aMA() {
        return true;
    }
}
