package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.e.a.lb;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.d.m;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.ui.smiley.SmileyPanelScrollView.b;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.MMRadioGroupView.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class e implements android.support.v4.view.ViewPager.e, OnClickListener, b, com.tencent.mm.plugin.emoji.ui.smiley.SmileyPanelViewPager.a, c {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    Context aHq = aa.getContext();
    final com.tencent.mm.sdk.h.g.a fcA = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ e flp;

        {
            this.flp = r1;
        }

        public final void a(String str, i iVar) {
            if (str != null) {
                if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                    this.flp.ahB();
                    return;
                }
                com.tencent.mm.storage.a.c rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(str);
                if (rg != null && rg.field_catalog == com.tencent.mm.storage.a.c.nwR) {
                    g.afx().afi();
                    this.flp.ahB();
                }
            }
        }
    };
    final com.tencent.mm.sdk.c.c fcB = new com.tencent.mm.sdk.c.c<lb>(this) {
        final /* synthetic */ e flp;

        {
            this.flp = r2;
            this.nhz = lb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "REFRESH_PANEL_EVENT");
            this.flp.ahB();
            return false;
        }
    };
    Context fda;
    f fkM;
    private final int fkU = 100;
    private final int fkV = 1102;
    private final int fkW = 1103;
    private final int fkX = 100;
    SmileyPanelViewPager fkY;
    private g fkZ;
    SmileyPanelScrollView fla;
    HorizontalListViewV2 flb;
    h flc;
    View fld;
    ImageView fle;
    ImageView flf;
    private ImageButton flg;
    TextView flh;
    a fli;
    private int flj = -1;
    private boolean flk = false;
    boolean fll = true;
    String flm;
    final com.tencent.mm.sdk.h.g.a fln = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ e flp;

        {
            this.flp = r1;
        }

        public final void a(String str, i iVar) {
            if (!TextUtils.isEmpty(str)) {
                if (str.equals("event_update_group") || str.equalsIgnoreCase("productID")) {
                    v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
                    this.flp.ahB();
                }
            }
        }
    };
    OnItemClickListener flo = new OnItemClickListener(this) {
        final /* synthetic */ e flp;

        {
            this.flp = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.tencent.mm.storage.a.a kb = this.flp.flc.kb(i);
            if (kb.field_productID.equalsIgnoreCase("TAG_STORE_MANEGER_TAB")) {
                com.tencent.mm.ay.c.b(this.flp.aHq, "emoji", ".ui.EmojiMineUI", null);
                return;
            }
            this.flp.c(this.flp.fkM.ka(this.flp.flj), false, true);
            d rP = this.flp.fkM.rP(kb.field_productID);
            this.flp.flj = rP.fkP;
            if (this.flp.fkY != null) {
                this.flp.fkY.k(this.flp.flj, false);
            }
            this.flp.g(rP.aht(), 0, true);
            this.flp.fkM.fmi = 0;
            this.flp.fkM.rO(kb.field_productID);
            if (kb.equals(String.valueOf(com.tencent.mm.storage.a.a.nwK))) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11594, new Object[]{Integer.valueOf(0)});
            }
        }
    };
    private ac mHandler = new ac(this) {
        final /* synthetic */ e flp;

        {
            this.flp = r1;
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case 1102:
                    this.flp.ahv();
                    this.flp.fll = true;
                    if (this.flp.flm != null && this.flp.fkY != null) {
                        int i = this.flp.fkM.fmi;
                        if (i < 0 || i > this.flp.fkM.rP(this.flp.flm).aht()) {
                            i = 0;
                        }
                        this.flp.flj = i + this.flp.fkM.rP(this.flp.flm).fkP;
                        this.flp.fkY.Z(this.flp.flj);
                        this.flp.flm = null;
                        return;
                    }
                    return;
                case 1103:
                    v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update selection");
                    e eVar = this.flp;
                    int i2 = message.arg1;
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    eVar.c(i2, z, false);
                    return;
                default:
                    return;
            }
        }
    };
    View mView;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String fbS;
        final /* synthetic */ e flp;

        AnonymousClass3(e eVar, String str) {
            this.flp = eVar;
            this.fbS = str;
        }

        public final void run() {
            if (this.flp.fkY != null && this.flp.fkM != null && this.flp.fkM.rP(this.fbS) != null) {
                this.flp.flj = this.flp.fkM.rP(this.fbS).fkP;
                this.flp.fkY.Z(this.flp.flj);
                this.flp.fkM.fmi = 0;
            }
        }
    }

    public interface a {
        com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a aho();

        k ahp();
    }

    public e(Context context, f fVar, a aVar) {
        this.fda = context;
        this.fkM = fVar;
        this.fli = aVar;
        v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener.");
        g.afx().fci.c(this.fln);
        g.afx().fch.c(this.fcA);
        com.tencent.mm.sdk.c.a.nhr.e(this.fcB);
    }

    public final synchronized void ahv() {
        if (this.mView == null || !this.fkM.fmw) {
            v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "not view can't deal");
        } else {
            Object obj;
            m afx;
            ArrayList arrayList;
            int i;
            int i2;
            Collection arrayList2;
            Iterator it;
            int i3;
            com.tencent.mm.storage.a.a aVar;
            h hVar;
            long currentTimeMillis = System.currentTimeMillis();
            this.fkM.fmm = false;
            v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initSmileyData");
            long currentTimeMillis2 = System.currentTimeMillis();
            f fVar = this.fkM;
            if (fVar.fmu != null) {
                Iterator it2 = fVar.fmu.iterator();
                while (it2.hasNext()) {
                    if (((d) it2.next()) != null) {
                        v.v("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener listener: %s", new Object[]{((d) it2.next()).fdU});
                    } else {
                        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener already release: ..");
                    }
                }
            }
            if (fVar.fmu != null) {
                fVar.fmu.clear();
            }
            if (g.afx().fch.iC(true) <= 2) {
                ak.yW();
                if (!((Boolean) com.tencent.mm.model.c.vf().get(208912, Boolean.valueOf(false))).booleanValue()) {
                    obj = null;
                    afx = g.afx();
                    if (m.fcw == null) {
                        m.fcw = new ArrayList();
                    }
                    if (m.fcw.size() == 0 || m.fcs) {
                        ak.yW();
                        if (com.tencent.mm.model.c.isSDCardAvailable()) {
                            m.fcw = (ArrayList) afx.fci.bxn();
                        } else {
                            m.fcw = afx.fci.bxv();
                        }
                    }
                    m.fcs = false;
                    arrayList = m.fcw;
                    i = j.sU().getInt("EmotionRecommandCount", 3);
                    afx = g.afx();
                    if (m.dLy == -1 || m.fcv) {
                        m.dLy = afx.fci.bxr();
                    }
                    i2 = i - m.dLy;
                    v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(m.dLy)});
                    arrayList2 = new ArrayList();
                    arrayList2.add(f.ahI());
                    a(f.ahI(), true);
                    if (!this.fkM.fmj) {
                        if (obj != null) {
                            arrayList2.add(f.ahJ());
                            a(f.ahJ(), true);
                        }
                        it = arrayList.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            aVar = (com.tencent.mm.storage.a.a) it.next();
                            if (!(aVar == null || be.kS(aVar.field_productID))) {
                                if (aVar.field_recommand != 1) {
                                    if (i3 < i2 && i3 < i) {
                                        i3++;
                                        a(aVar, f.a(aVar));
                                        arrayList2.add(aVar);
                                    }
                                } else if (!(aVar.field_productID.equalsIgnoreCase(String.valueOf(com.tencent.mm.storage.a.a.nwK)) || aVar.field_productID.equalsIgnoreCase("TAG_DEFAULT_TAB"))) {
                                    a(aVar, f.a(aVar));
                                    arrayList2.add(aVar);
                                }
                            }
                        }
                        if (obj == null) {
                            arrayList2.add(f.ahJ());
                            a(f.ahJ(), true);
                        }
                        aVar = new com.tencent.mm.storage.a.a();
                        aVar.field_productID = "TAG_STORE_MANEGER_TAB";
                        arrayList2.add(aVar);
                    }
                    hVar = this.flc;
                    hVar.mData.clear();
                    hVar.mData.addAll(arrayList2);
                    hVar.notifyDataSetChanged();
                    ahy();
                    this.fkM.ahN();
                    v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                    v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
                    if (this.fkY == null) {
                        v.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
                    } else if (this.fkZ != null) {
                        ahx();
                        this.fkZ = new g(this.fkM, this.fda);
                        this.fkM.ahM();
                        this.fkY.a(this.fkZ);
                        this.fkY.yb(1);
                    } else {
                        this.fkZ.fmG = true;
                        this.fkZ.ahR();
                        this.fkZ.notifyDataSetChanged();
                        this.fkZ.fmG = false;
                    }
                    ahw();
                    this.fkM.fmm = true;
                    this.fkM.fmp = true;
                    if (!this.fkM.fmn) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(406, 6, 1, false);
                        com.tencent.mm.plugin.report.service.g.iuh.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
                    }
                }
            }
            obj = 1;
            afx = g.afx();
            if (m.fcw == null) {
                m.fcw = new ArrayList();
            }
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                m.fcw = (ArrayList) afx.fci.bxn();
            } else {
                m.fcw = afx.fci.bxv();
            }
            m.fcs = false;
            arrayList = m.fcw;
            i = j.sU().getInt("EmotionRecommandCount", 3);
            afx = g.afx();
            m.dLy = afx.fci.bxr();
            i2 = i - m.dLy;
            v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(m.dLy)});
            arrayList2 = new ArrayList();
            arrayList2.add(f.ahI());
            a(f.ahI(), true);
            if (this.fkM.fmj) {
                if (obj != null) {
                    arrayList2.add(f.ahJ());
                    a(f.ahJ(), true);
                }
                it = arrayList.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    aVar = (com.tencent.mm.storage.a.a) it.next();
                    if (aVar.field_recommand != 1) {
                        a(aVar, f.a(aVar));
                        arrayList2.add(aVar);
                    } else {
                        i3++;
                        a(aVar, f.a(aVar));
                        arrayList2.add(aVar);
                    }
                }
                if (obj == null) {
                    arrayList2.add(f.ahJ());
                    a(f.ahJ(), true);
                }
                aVar = new com.tencent.mm.storage.a.a();
                aVar.field_productID = "TAG_STORE_MANEGER_TAB";
                arrayList2.add(aVar);
            }
            hVar = this.flc;
            hVar.mData.clear();
            hVar.mData.addAll(arrayList2);
            hVar.notifyDataSetChanged();
            ahy();
            this.fkM.ahN();
            v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
            if (this.fkY == null) {
                v.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
            } else if (this.fkZ != null) {
                this.fkZ.fmG = true;
                this.fkZ.ahR();
                this.fkZ.notifyDataSetChanged();
                this.fkZ.fmG = false;
            } else {
                ahx();
                this.fkZ = new g(this.fkM, this.fda);
                this.fkM.ahM();
                this.fkY.a(this.fkZ);
                this.fkY.yb(1);
            }
            ahw();
            this.fkM.fmm = true;
            this.fkM.fmp = true;
            if (this.fkM.fmn) {
                com.tencent.mm.plugin.report.service.g.iuh.a(406, 6, 1, false);
                com.tencent.mm.plugin.report.service.g.iuh.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
            }
        }
    }

    final void ahw() {
        d ahM = this.fkM.ahM();
        if (ahM == null) {
            this.fkM.rO("TAG_DEFAULT_TAB");
            ahM = this.fkM.ahM();
        }
        ahA();
        if (ahM != null && this.fkY != null) {
            int i = this.fkM.fmi;
            if (i < 0 || i > ahM.aht()) {
                i = 0;
            }
            this.flj = ahM.fkP + i;
            this.fkY.Z(this.flj);
            if (!ahM.fdU.equals("TAG_STORE_TAB")) {
                v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "init set currentItem not default qq. ");
            }
            g(ahM.aht(), i + 0, false);
        }
    }

    private void g(int i, int i2, boolean z) {
        if (i <= 1) {
            this.fla.setVisibility(4);
            return;
        }
        this.fla.setVisibility(0);
        SmileyPanelScrollView smileyPanelScrollView = this.fla;
        v.d("MicroMsg.SmileyPanelScrollView", "setDot dotCount:%d selectDot:%d force:%b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        smileyPanelScrollView.flu = i;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > smileyPanelScrollView.flu) {
            i2 = smileyPanelScrollView.flu;
        }
        smileyPanelScrollView.flv = i2;
        if (smileyPanelScrollView.flI == -1 || z) {
            smileyPanelScrollView.flI = smileyPanelScrollView.flv;
        }
        if (smileyPanelScrollView.flH == -1 || z) {
            smileyPanelScrollView.flH = smileyPanelScrollView.flv;
            smileyPanelScrollView.flJ = 0.0f;
        }
        smileyPanelScrollView.invalidate();
    }

    public final void ahx() {
        if (this.fkZ != null) {
            v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "clearViewPagerCache");
            this.fkZ.mCount = 0;
        }
    }

    private void a(com.tencent.mm.storage.a.a aVar, boolean z) {
        f fVar = this.fkM;
        if (fVar.fmu == null) {
            fVar.fmu = new ArrayList();
        }
        int size = fVar.fmu.size();
        d dVar = size <= 0 ? null : (d) fVar.fmu.get(size - 1);
        fVar.fmu.add(new d(aVar, dVar == null ? 0 : dVar.fkP + dVar.aht(), fVar, this, z));
    }

    public final void ahy() {
        if (this.fle != null) {
            if (!f.ahE() || this.fkM.fmh.equalsIgnoreCase("TAG_STORE_TAB")) {
                this.flf.setVisibility(8);
            } else {
                this.flf.setVisibility(0);
            }
            this.fle.setContentDescription(this.aHq.getString(2131232445));
        }
    }

    private ImageButton ahz() {
        if (this.flg == null) {
            this.flg = new ImageButton(this.fda, null, 2131558883);
            this.flg.setMaxHeight(this.fkM.flQ);
            this.flg.setMinimumHeight(this.fkM.flQ);
            this.flg.setMaxWidth(this.fkM.flP);
            this.flg.setMinimumWidth(this.fkM.flP);
            this.flg.setScaleType(ScaleType.CENTER);
            this.flg.setPadding(this.fkM.flS, this.fkM.flS, this.fkM.flS, this.fkM.flS);
            this.flg.setClickable(false);
            this.flg.setVisibility(8);
        }
        return this.flg;
    }

    public final void onClick(View view) {
        if (view == this.fle) {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("check_clickflag", false);
            if (f.ahD()) {
                v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "called emoji store must refresh by net");
                intent.putExtra("emoji_stroe_must_refresh_by_net", true);
            }
            if (!be.kS(this.fkM.fmg)) {
                intent.putExtra("to_talker_name", this.fkM.fmg);
            }
            com.tencent.mm.ay.c.b(this.aHq, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            com.tencent.mm.plugin.report.service.g.iuh.h(11594, new Object[]{Integer.valueOf(2)});
        } else if (view == this.flh && this.fli != null && this.fli.aho() != null) {
            this.fli.aho().ayC();
        }
    }

    final View findViewById(int i) {
        return this.mView.findViewById(i);
    }

    public final void cC(boolean z) {
        ahz().setVisibility(8);
        if (this.flh != null && this.flh.getVisibility() == 0) {
            if (z) {
                Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.flh.getWidth(), 0.0f, 0.0f);
                translateAnimation.setDuration(250);
                this.flh.startAnimation(translateAnimation);
            }
            this.flh.setVisibility(8);
        }
    }

    public final void jU(int i) {
        int i2 = this.fkY.xB;
        int i3 = this.fkM.jZ(i2).fkP + i;
        if (!(this.fkY == null || i3 == i2)) {
            Math.abs(i3 - i2);
            this.fkY.Z(i3);
        }
        this.flj = i3;
    }

    public final void X(int i) {
        if (this.fla != null) {
            SmileyPanelScrollView smileyPanelScrollView = this.fla;
            if (i == 0) {
                smileyPanelScrollView.flI = smileyPanelScrollView.flv;
                smileyPanelScrollView.flH = smileyPanelScrollView.flv;
                smileyPanelScrollView.flJ = 0.0f;
                smileyPanelScrollView.invalidate();
                if (smileyPanelScrollView.flK) {
                    smileyPanelScrollView.flK = false;
                }
            } else if (i == 1) {
                smileyPanelScrollView.flI = smileyPanelScrollView.flv;
                smileyPanelScrollView.flH = smileyPanelScrollView.flv;
                smileyPanelScrollView.flJ = 0.0f;
            }
        }
        if (i == 0 || i == 1) {
            this.flj = this.fkY.xB;
        }
    }

    public final void a(int i, float f, int i2) {
        if (this.fla != null && f != 0.0f) {
            if (this.flj == -1) {
                this.flj = this.fkY.xB;
            }
            int i3 = this.flj;
            if (i == this.flj) {
                i3 = this.flj + 1;
            }
            d jZ = this.fkM.jZ(i3);
            d jZ2 = this.fkM.jZ(i);
            if (jZ == jZ2) {
                SmileyPanelScrollView smileyPanelScrollView = this.fla;
                int i4 = i - jZ2.fkP;
                smileyPanelScrollView.flJ = f;
                if (smileyPanelScrollView.flI != i4) {
                    smileyPanelScrollView.flI = i4;
                }
                smileyPanelScrollView.invalidate();
                this.flk = true;
                return;
            }
            this.flk = false;
        }
    }

    private void c(int i, boolean z, boolean z2) {
        int i2 = 1;
        if (this.flb != null) {
            v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab index:%d selected:%b listView child count:%d", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.flb.getChildCount())});
            this.flb.setSelection(i);
            View selectedView = this.flb.getSelectedView();
            if (selectedView != null) {
                selectedView.setSelected(z);
                return;
            }
            v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "list item view is null. refreshable:%b", new Object[]{Boolean.valueOf(z2)});
            if (z2) {
                Message message = new Message();
                message.what = 1103;
                message.arg1 = i;
                if (!z) {
                    i2 = 0;
                }
                message.arg2 = i2;
                this.mHandler.sendMessageDelayed(message, 100);
            }
        }
    }

    public final void W(int i) {
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "cpan onPageSelected :%d", new Object[]{Integer.valueOf(i)});
        if (this.fkM != null && this.fkM.fmw) {
            boolean z;
            d jZ = this.fkM.jZ(i);
            if (jZ.fdU.equals("TAG_STORE_TAB")) {
                this.fle.setSelected(true);
                v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "show TAB: viewId: %d, tabProductId: %s", new Object[]{Integer.valueOf(this.fle.getId()), "TAG_STORE_TAB"});
                this.fkM.rO("TAG_STORE_TAB");
                com.tencent.mm.plugin.report.service.g.iuh.h(11594, new Object[]{Integer.valueOf(5)});
                com.tencent.mm.p.c.us().az(262147, 266244);
                com.tencent.mm.p.c.us().az(262149, 266244);
                ahy();
            } else {
                this.fle.setSelected(false);
            }
            int i2 = i - jZ.fkP;
            int aht = jZ.aht();
            int i3 = i - jZ.fkP;
            if (this.flk) {
                z = false;
            } else {
                z = true;
            }
            g(aht, i3, z);
            this.fkM.fmi = i2;
            this.fkM.rO(jZ.fdU);
            jV(this.fkM.ka(i));
            c(this.fkM.ka(i) - 1, false, true);
            c(this.fkM.ka(i) + 1, false, true);
        }
    }

    private void jV(int i) {
        int i2 = this.fkM.flP;
        int width = this.flb.getWidth();
        int firstVisiblePosition = this.flb.getFirstVisiblePosition();
        if (i > this.flb.getLastVisiblePosition()) {
            this.flb.wg((i2 * (i + 1)) - width);
        } else if (i < firstVisiblePosition) {
            this.flb.wg(i2 * i);
        }
        c(i, true, true);
    }

    public final void ahA() {
        if (this.fkM.fmn) {
            if (this.fkM.fmh.equals("TAG_DEFAULT_TAB")) {
                if (!(this.fli == null || this.fli.aho() == null)) {
                    this.fli.aho().ef(true);
                }
                if (this.fkM.ahK()) {
                    this.fkM.fmo = false;
                    ahz().setVisibility(0);
                    if (this.flh != null && this.flh.getVisibility() != 0) {
                        Animation translateAnimation = new TranslateAnimation((float) this.flh.getWidth(), 0.0f, 0.0f, 0.0f);
                        translateAnimation.setDuration(250);
                        this.flh.startAnimation(translateAnimation);
                        this.flh.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!(this.fli == null || this.fli.aho() == null)) {
                this.fli.aho().ef(false);
            }
            cC(true);
        }
    }

    public final synchronized void jW(int i) {
        f fVar;
        if (this.fkM.ahO()) {
            if (!this.fkM.fms) {
                fVar = this.fkM;
                fVar.fms = true;
                fVar.fmt = false;
            }
        } else if (!this.fkM.fmt) {
            fVar = this.fkM;
            fVar.fmt = true;
            fVar.fms = false;
        }
        v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "catch Size & start deal");
        if (i > 0) {
            this.mView.post(new Runnable(this) {
                final /* synthetic */ e flp;

                {
                    this.flp = r1;
                }

                public final void run() {
                    v.v("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onLayoutChange handle");
                    this.flp.ahv();
                }
            });
        }
    }

    public final void jX(int i) {
        if (i > 0) {
            v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab size changed ,so adjusting tab site.");
            jV(this.fkM.ahL());
        }
    }

    public final void ahB() {
        this.fll = false;
        this.mHandler.removeMessages(1102);
        this.mHandler.sendEmptyMessageDelayed(1102, 100);
    }
}
