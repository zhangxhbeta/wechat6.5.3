package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.e.a.ou;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.ui.smiley.e.AnonymousClass3;
import com.tencent.mm.plugin.emoji.ui.smiley.e.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import java.util.Iterator;

public class SmileyPanel extends ChatFooterPanel implements a {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanel";
    private boolean dYF = false;
    private e fkL;
    private f fkM;

    public SmileyPanel(Context context) {
        super(context, null);
        init();
    }

    public SmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.fkM = new f();
        this.fkL = new e(getContext(), this.fkM, this);
    }

    public final void onResume() {
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
        f fVar = this.fkM;
        fVar.fmn = true;
        fVar.ahH();
        e eVar = this.fkL;
        eVar.ahy();
        eVar.ahA();
    }

    public final void onPause() {
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
        f fVar = this.fkM;
        fVar.fmn = false;
        fVar.ahG();
        fVar.ahQ();
    }

    public final void destroy() {
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDestroy");
        this.lGm = null;
        if (this.fkL != null) {
            v.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "ui clear");
            e eVar = this.fkL;
            eVar.ahx();
            eVar.fda = null;
            if (eVar.fkY != null) {
                eVar.fkY.a(null);
            }
            v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager destroy remove listener.");
            g.afx().fci.d(eVar.fln);
            g.afx().fch.d(eVar.fcA);
            com.tencent.mm.sdk.c.a.nhr.f(eVar.fcB);
            this.fkL = null;
        }
        if (this.fkM != null) {
            v.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "stg clear");
            f fVar = this.fkM;
            Iterator it = fVar.fmu.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar != null) {
                    dVar.fkM = null;
                    dVar.fkN = null;
                }
            }
            fVar.ahQ();
        }
    }

    public final void a(com.tencent.mm.pluginsdk.ui.chat.g gVar) {
        super.a(gVar);
    }

    public final void cB(boolean z) {
        e eVar = this.fkL;
        if (eVar.flh != null) {
            eVar.flh.setEnabled(z);
        }
    }

    public final void ahk() {
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "dealOrientationChange");
        this.fkL.fkM.Wj = 0;
    }

    public final void ahl() {
        this.lGm = null;
    }

    public final void refresh() {
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "reflesh");
        try {
            if (this.fkM != null && this.fkL != null) {
                this.fkL.ahB();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.emoji.SmileyPanel.SmileyPanel", e, "", new Object[0]);
        }
    }

    public final void ahm() {
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideCustomBtn");
        this.fkM.fmj = true;
    }

    public final void l(boolean z, boolean z2) {
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(false)});
        this.fkM.fmk = z;
        this.fkM.fml = false;
    }

    public final void ahn() {
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSendButton:B", new Object[]{Boolean.valueOf(false)});
        this.fkL.cC(false);
        this.fkM.fmo = true;
    }

    public final ChatFooterPanel.a aho() {
        return this.lGm;
    }

    public final k ahp() {
        return (k) this.lGn;
    }

    public final void jS(int i) {
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[]{Integer.valueOf(i)});
        this.fkM.Wj = 0;
        f fVar = this.fkM;
        if (fVar.fmb != i) {
            fVar.fmt = false;
            fVar.fms = false;
        }
        fVar.fmb = i;
        this.fkM.ahG();
        fVar = this.fkM;
        int i2 = i - this.fkM.flQ;
        f fVar2 = this.fkM;
        fVar.jY(i2 - (fVar2.flz - fVar2.flY));
        this.fkM.fmd = 0;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setVisibility(int i) {
        int i2 = 8;
        super.setVisibility(i);
        if (i == 0) {
            this.dYF = false;
            if (this.fkL != null) {
                e eVar = this.fkL;
                v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initView begin");
                if (this == null) {
                    return;
                }
                if (eVar.mView == null || getChildCount() <= 0) {
                    eVar.fkM.fmw = false;
                    if (eVar.mView == null) {
                        eVar.mView = View.inflate(eVar.aHq, 2130904411, null);
                    } else if (eVar.mView.getParent() != null) {
                        ((ViewGroup) eVar.mView.getParent()).removeView(eVar.mView);
                    }
                    eVar.fkY = (SmileyPanelViewPager) eVar.findViewById(2131759218);
                    eVar.fkY.fkM = eVar.fkM;
                    eVar.fkY.fmC = eVar;
                    eVar.fkY.b(eVar);
                    eVar.fkY.yb(3);
                    eVar.fkM.fmd = eVar.fkY.getWidth();
                    eVar.fla = (SmileyPanelScrollView) eVar.findViewById(2131759219);
                    eVar.fla.flq = eVar;
                    eVar.fla.fks = eVar.fkM;
                    eVar.flb = (HorizontalListViewV2) eVar.findViewById(2131759220);
                    eVar.flc = new h(eVar.fda, eVar.fkM);
                    eVar.flb.setAdapter(eVar.flc);
                    eVar.flb.setOnItemClickListener(eVar.flo);
                    eVar.flh = (TextView) eVar.findViewById(2131758381);
                    eVar.fle = (ImageView) eVar.findViewById(2131759222);
                    eVar.fle.setOnClickListener(eVar);
                    eVar.fld = eVar.findViewById(2131759221);
                    eVar.flf = (ImageView) eVar.findViewById(2131759223);
                    eVar.flh.setOnClickListener(eVar);
                    eVar.flh.setVisibility(eVar.fkM.ahK() ? 0 : 8);
                    addView(eVar.mView, new LayoutParams(-1, -1));
                    eVar.fkM.fmw = true;
                    View view = eVar.fld;
                    if (!eVar.fkM.fmj) {
                        i2 = 0;
                    }
                    view.setVisibility(i2);
                    return;
                }
                v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "already load view --- pass");
                eVar.ahw();
                return;
            }
            v.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley Panel Manager is null.");
        } else if (this.fkM != null) {
            this.fkM.ahQ();
        } else {
            v.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley PanelStg Manager is null.");
        }
    }

    public final void rL(String str) {
        this.fkM.fmg = str;
    }

    public final void rM(String str) {
        f fVar = this.fkM;
        fVar.rO(str);
        fVar.ahG();
        if (fVar.fmv == null) {
            fVar.fmv = new c<ou>(fVar) {
                final /* synthetic */ f fmx;

                {
                    this.fmx = r2;
                    this.nhz = ou.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    ou ouVar = (ou) bVar;
                    v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "kv stat update click cell item");
                    com.tencent.mm.plugin.report.service.g.iuh.Y(11076, "1," + ouVar.bqe.aZD);
                    this.fmx.ahQ();
                    return true;
                }
            };
        }
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "add succeed send listener");
        com.tencent.mm.sdk.c.a.nhr.e(fVar.fmv);
    }

    protected void onMeasure(int i, int i2) {
        if (this.dYF) {
            setVisibility(8);
            i = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final void ahq() {
        this.fkM.fmq = true;
    }

    public final void ahr() {
        if (this.fkL != null) {
            e eVar = this.fkL;
            String str = "TAG_DEFAULT_TAB";
            if (!(eVar.fkY == null || eVar.fkM == null)) {
                if (eVar.fll) {
                    eVar.flm = null;
                    eVar.fkY.post(new AnonymousClass3(eVar, str));
                } else {
                    eVar.flm = str;
                }
            }
        }
        if (this.fkM != null) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(-29414086, "TAG_DEFAULT_TAB");
        }
    }

    public final void jT(int i) {
        if (this.fkM != null) {
            this.fkM.cVh = i;
        }
    }
}
