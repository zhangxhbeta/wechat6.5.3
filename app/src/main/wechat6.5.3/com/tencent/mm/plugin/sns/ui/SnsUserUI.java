package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.e.a.id;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsUserUI extends MMActivity implements com.tencent.mm.pluginsdk.j.q.e.a {
    private c dHB = new c<id>(this) {
        final /* synthetic */ SnsUserUI jYB;

        {
            this.jYB = r2;
            this.nhz = id.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            id idVar = (id) bVar;
            if (idVar instanceof id) {
                switch (idVar.bif.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        this.jYB.jYx.notifyDataSetChanged();
                        break;
                }
            }
            return false;
        }
    };
    private String dRA;
    private boolean jGc;
    private ag jUA;
    private boolean jUK = false;
    private String jUP;
    private boolean jUQ;
    private int jUR;
    private OnMenuItemClickListener jVv = new OnMenuItemClickListener(this) {
        final /* synthetic */ SnsUserUI jYB;

        {
            this.jYB = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            if (this.jYB.jUA == null || !this.jYB.jUA.jJG) {
                this.jYB.finish();
            } else {
                this.jYB.jUA.gq(true);
                this.jYB.aXE();
            }
            return true;
        }
    };
    private com.tencent.mm.plugin.sns.ui.ay.a jYA;
    private aq jYx;
    private ay jYy;
    private com.tencent.mm.plugin.sns.e.ak.a jYz;
    private Runnable jgR = new Runnable(this) {
        final /* synthetic */ SnsUserUI jYB;

        {
            this.jYB = r1;
        }

        public final void run() {
            this.jYB.jYx.aXn();
            this.jYB.jYx.aVH();
        }
    };

    class a extends f {
        private ax jVA = null;
        final /* synthetic */ SnsUserUI jYB;

        a(SnsUserUI snsUserUI) {
            this.jYB = snsUserUI;
        }

        public void cz(int i, int i2) {
            v.d("MicroMsg.SnsUserUI", "showImg snsinfo snslocalId " + i);
            if (!this.jYB.jGc || i2 != -1) {
                Intent intent = new Intent(this.jYB, SnsGalleryUI.class);
                intent.putExtra("sns_gallery_userName", this.jYB.dRA);
                intent.putExtra("sns_gallery_is_self", this.jYB.jGc);
                intent.putExtra("sns_gallery_localId", i);
                intent.putExtra("sns_source", this.jYB.jUR);
                intent.putExtra("sns_gallery_st_time", this.jYB.jYx.jRP);
                intent.putExtra("sns_gallery_ed_time", this.jYB.jYx.jRQ);
                if (this.jYB.jYx != null) {
                    intent.putExtra("sns_gallery_limit_seq", this.jYB.jYx.fHQ);
                    this.jYB.jYz.e(this.jYB.dRA, this.jYB.jYx.cy(i, i2));
                    intent.putExtra("sns_gallery_position", this.jYB.jYx.jRR);
                }
                this.jYB.startActivityForResult(intent, 8);
            } else if (q.drg) {
                g.a(this.jYB, null, new String[]{this.jYB.getString(2131231051), this.jYB.getString(2131231056)}, null, new g.c(this) {
                    final /* synthetic */ a jYC;

                    {
                        this.jYC = r1;
                    }

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                com.tencent.mm.plugin.report.service.g.iuh.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                                this.jYC.jYB.jYy.rj(1);
                                return;
                            case 1:
                                SnsUserUI.l(this.jYC.jYB);
                                return;
                            default:
                                return;
                        }
                    }
                });
            } else {
                this.jVA = new ax(this.jYB);
                this.jVA.jXn = new n.c(this) {
                    final /* synthetic */ a jYC;

                    {
                        this.jYC = r1;
                    }

                    public final void a(l lVar) {
                        lVar.d(0, this.jYC.jYB.getString(2131231049));
                        lVar.d(1, this.jYC.jYB.getString(2131231054));
                    }
                };
                this.jVA.b(0, this.jYB.nDR.nEl.getString(2131231052));
                this.jVA.jXo = new d(this) {
                    final /* synthetic */ a jYC;

                    {
                        this.jYC = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                com.tencent.mm.plugin.report.service.g.iuh.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                                this.jYC.jYB.aYk();
                                return;
                            case 1:
                                com.tencent.mm.plugin.report.service.g.iuh.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                                this.jYC.jYB.jYy.rj(1);
                                return;
                            default:
                                return;
                        }
                    }
                };
                this.jVA.aXZ();
            }
        }

        public final void cA(int i, int i2) {
            k qG = ad.aSE().qG(i);
            if (qG != null) {
                if (qG.field_type == 15) {
                    Intent intent = new Intent(this.jYB, SnsGalleryUI.class);
                    intent.putExtra("sns_gallery_userName", this.jYB.dRA);
                    intent.putExtra("sns_gallery_is_self", this.jYB.jGc);
                    intent.putExtra("sns_gallery_localId", i);
                    intent.putExtra("sns_source", this.jYB.jUR);
                    intent.putExtra("sns_gallery_st_time", this.jYB.jYx.jRP);
                    intent.putExtra("sns_gallery_ed_time", this.jYB.jYx.jRQ);
                    if (this.jYB.jYx != null) {
                        intent.putExtra("sns_gallery_limit_seq", this.jYB.jYx.fHQ);
                        this.jYB.jYz.e(this.jYB.dRA, this.jYB.jYx.cy(i, i2));
                        intent.putExtra("sns_gallery_position", this.jYB.jYx.jRR);
                    }
                    this.jYB.startActivityForResult(intent, 8);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClass(this.jYB, SnsCommentDetailUI.class);
                intent2.putExtra("INTENT_TALKER", qG.field_userName);
                intent2.putExtra("INTENT_SNS_LOCAL_ID", s.B("sns_table_", (long) i));
                this.jYB.startActivityForResult(intent2, 12);
            }
        }

        public final void rc(int i) {
            k qG = ad.aSE().qG(i);
            if (qG != null) {
                Intent intent = new Intent();
                intent.setClass(this.jYB, SnsCommentDetailUI.class);
                intent.putExtra("INTENT_TALKER", qG.field_userName);
                intent.putExtra("INTENT_SNS_LOCAL_ID", s.B("sns_table_", (long) i));
                this.jYB.startActivityForResult(intent, 12);
            }
        }
    }

    static /* synthetic */ void j(SnsUserUI snsUserUI) {
        snsUserUI.bAc();
        snsUserUI.nDR.bAi();
        snsUserUI.a(snsUserUI.jVv, 2131165204);
        snsUserUI.Fd("");
    }

    static /* synthetic */ void l(SnsUserUI snsUserUI) {
        if (!com.tencent.mm.ah.a.aT(snsUserUI)) {
            v.i("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(snsUserUI, "android.permission.CAMERA", 18, "", "")), be.bur(), snsUserUI});
            if (com.tencent.mm.pluginsdk.i.a.a(snsUserUI, "android.permission.CAMERA", 18, "", "")) {
                v.i("MicroMsg.SnsUserUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(snsUserUI, "android.permission.RECORD_AUDIO", 18, "", "")), be.bur(), snsUserUI});
                if (com.tencent.mm.pluginsdk.i.a.a(snsUserUI, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    snsUserUI.setRequestedOrientation(1);
                    com.tencent.mm.sdk.platformtools.ad.o(new Runnable(snsUserUI) {
                        final /* synthetic */ SnsUserUI jYB;

                        {
                            this.jYB = r1;
                        }

                        public final void run() {
                            SnsUserUI.n(this.jYB);
                            SnsUserUI.j(this.jYB);
                            this.jYB.jUA.aWm();
                        }
                    });
                }
            }
        }
    }

    static /* synthetic */ void n(SnsUserUI snsUserUI) {
        if (snsUserUI.jGc && snsUserUI.jUA == null) {
            snsUserUI.jUA = new ag((ViewGroup) snsUserUI.findViewById(2131755452), (ViewGroup) snsUserUI.findViewById(2131759250), snsUserUI, new com.tencent.mm.plugin.sns.ui.ag.a(snsUserUI) {
                final /* synthetic */ SnsUserUI jYB;

                {
                    this.jYB = r1;
                }

                public final void amF() {
                    this.jYB.aXE();
                }
            });
            ag agVar = snsUserUI.jUA;
            agVar.jJL = 11;
            if (agVar.jJC != null) {
                agVar.jJC.iYq = 11;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        com.tencent.mm.i.a LX;
        super.onCreate(bundle);
        this.jYz = ad.aSu();
        this.jUR = getIntent().getIntExtra("sns_source", 0);
        this.dRA = getIntent().getStringExtra("sns_userName");
        if (this.dRA == null) {
            this.dRA = "";
        }
        ak.yW();
        this.jUQ = com.tencent.mm.model.c.wH().LT(this.dRA);
        this.jUP = com.tencent.mm.model.k.xF();
        this.jGc = this.jUP.equals(this.dRA);
        aa aSs = ad.aSs();
        String ah = be.ah(getIntent().getStringExtra("sns_signature"), "");
        String ah2 = be.ah(getIntent().getStringExtra("sns_nickName"), "");
        if (this.dRA == null || this.dRA.equals("")) {
            LX = aSs.LX(this.jUP);
        } else {
            LX = aSs.LX(this.dRA);
        }
        if (LX != null && ((int) LX.chr) > 0) {
            ah = LX.bCj;
            ah2 = LX.tT();
            v.i("MicroMsg.SnsUserUI", "contact:user[%s] id[%d] nickname[%s]", new Object[]{LX.field_username, Integer.valueOf((int) LX.chr), ah2});
        }
        this.jYy = new ay(this);
        this.jYy.a(this.jUP, this.dRA, ah2, ah, this.jUQ, this.jGc, this.jUR);
        ay ayVar = this.jYy;
        com.tencent.mm.plugin.sns.ui.ay.a anonymousClass6 = new com.tencent.mm.plugin.sns.ui.ay.a(this) {
            final /* synthetic */ SnsUserUI jYB;

            {
                this.jYB = r1;
            }

            public final void aXK() {
                if (this.jYB.jYz == null) {
                    this.jYB.jYz = ad.aSu();
                }
                this.jYB.jYz.a(2, this.jYB.dRA, this.jYB.jGc, this.jYB.jUR);
                ad.aqz().postDelayed(this.jYB.jgR, 3000);
            }

            public final ListView aXL() {
                return (ListView) this.jYB.findViewById(2131759452);
            }

            public final MMPullDownView aXM() {
                return (MMPullDownView) this.jYB.findViewById(2131759451);
            }

            public final int getType() {
                return 2;
            }

            public final void a(int i, List<Integer> list, List<Integer> list2) {
                aq a;
                if (!(i == -1 || this.jYB.jYx == null)) {
                    a = this.jYB.jYx;
                    if (a.jRN != null) {
                        ar arVar = a.jRN;
                        k qG = ad.aSE().qG(i);
                        if (!(qG == null || qG.aUp().mWq == null || arVar.gKQ.size() <= 0)) {
                            arVar.gKQ.add(1, qG);
                            arVar.aXp();
                            arVar.aXq();
                        }
                    }
                }
                if (this.jYB.jYx != null && list != null && list2 != null) {
                    a = this.jYB.jYx;
                    if (a.jRN != null && list != null && list2 != null && list.size() + list2.size() != 0) {
                        int i2;
                        k kVar;
                        ar arVar2 = a.jRN;
                        if (!(list == null || list.size() == 0)) {
                            v.d("MicroMsg.SnsSelfHelper", "remove Items");
                            for (Integer intValue : list) {
                                int intValue2 = intValue.intValue();
                                int size = arVar2.gKQ.size();
                                for (i2 = 1; i2 < size; i2++) {
                                    kVar = (k) arVar2.gKQ.get(i2);
                                    if (kVar != null && kVar.jBI == intValue2) {
                                        arVar2.gKQ.remove(i2);
                                        break;
                                    }
                                }
                            }
                        }
                        if (!(list2 == null || list2.size() == 0)) {
                            v.d("MicroMsg.SnsSelfHelper", "change Items");
                            LinkedList linkedList = new LinkedList();
                            i2 = 1;
                            while (i2 < arVar2.gKQ.size()) {
                                kVar = (k) arVar2.gKQ.get(i2);
                                if (kVar != null) {
                                    for (Integer intValue3 : list2) {
                                        int intValue4 = intValue3.intValue();
                                        if (kVar.jBI == intValue4) {
                                            v.d("MicroMsg.SnsSelfHelper", "update list localId " + intValue4);
                                            arVar2.gKQ.remove(i2);
                                            linkedList.add(ad.aSE().qG(intValue4));
                                            i2--;
                                            break;
                                        }
                                    }
                                }
                                i2++;
                            }
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                arVar2.gKQ.add((k) it.next());
                            }
                        }
                        arVar2.aXp();
                        arVar2.aXq();
                    }
                }
            }

            public final boolean aXN() {
                return false;
            }

            public final void aXO() {
                this.jYB.jYz.b(2, this.jYB.dRA, this.jYB.jGc, this.jYB.jUR);
            }

            public final void aXP() {
            }

            public final void aXQ() {
            }

            public final void J(int i, boolean z) {
                Object obj = null;
                if (this.jYB.jYx != null) {
                    aq a = this.jYB.jYx;
                    if (a.jRN != null) {
                        ar arVar = a.jRN;
                        k qG = ad.aSE().qG(i);
                        if (qG != null && qG.aUp().mWq != null && arVar.gKQ.size() > 0) {
                            for (int i2 = 0; i2 < arVar.gKQ.size(); i2++) {
                                if (((k) arVar.gKQ.get(i2)).aUL() == qG.aUL()) {
                                    obj = 1;
                                    arVar.gKQ.remove(i2);
                                    break;
                                }
                            }
                            if (obj != null) {
                                arVar.gKQ.add(qG);
                                arVar.aXp();
                                arVar.aXq();
                            }
                        }
                    }
                }
            }

            public final void gw(boolean z) {
            }
        };
        this.jYA = anonymousClass6;
        ayVar.jXK = anonymousClass6;
        this.jYy.onCreate();
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        NI();
        com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
    }

    public final void a(boolean z, boolean z2, String str, boolean z3) {
        if (this.jYx != null) {
            this.jYx.jJv = str;
            if (str.compareTo(this.jYx.fHQ) < 0) {
                v.i("MicroMsg.SnsUserUI", "onFpSetSize addsize %s %s isNeedNP %s", new Object[]{str, this.jYx.fHQ, Boolean.valueOf(z)});
                this.jYx.aXn();
            } else {
                v.i("MicroMsg.SnsUserUI", "onFpSetSize addsize passed %s %s isNeedNP %s", new Object[]{str, this.jYx.fHQ, Boolean.valueOf(z)});
            }
            this.jYx.aVH();
        }
        this.jYy.jXH = z2;
        if (z2) {
            this.jYy.go(false);
        } else if (z) {
            this.jYz.a(this.jYA.getType(), this.dRA, this.jGc, this.jUR);
        }
        if (z3) {
            this.jYy.jrk.aWP();
        }
    }

    public final void b(boolean z, String str, boolean z2) {
        ad.aqz().removeCallbacks(this.jgR);
        if (this.jYx != null) {
            this.jYx.jRM = z2;
            this.jYx.jJv = str;
            if (str.compareTo(this.jYx.fHQ) < 0) {
                v.i("MicroMsg.SnsUserUI", "onNpAddSize addsize %s %s", new Object[]{str, this.jYx.fHQ});
                this.jYx.aXn();
            } else {
                v.i("MicroMsg.SnsUserUI", "onNpAddSize addsize passed %s %s", new Object[]{str, this.jYx.fHQ});
            }
            this.jYx.aVH();
        }
        this.jYy.jXH = z;
        if (z) {
            this.jYy.go(z2);
        }
    }

    public void onDestroy() {
        this.jUK = true;
        com.tencent.mm.sdk.c.a.nhr.f(this.dHB);
        com.tencent.mm.modelsns.a m = com.tencent.mm.modelsns.a.m(getIntent());
        if (m != null) {
            m.update();
            m.JF();
        }
        if (this.jYy.dwg != null) {
            this.jYy.dwg.dismiss();
            this.jYy.dwg = null;
        }
        if (this.jUA != null) {
            this.jUA.clean();
        }
        if (ak.uz() && this.jYz != null) {
            this.jYz.a(this, this.jYA.getType());
        }
        this.jYy.onDestroy();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904491;
    }

    public void onResume() {
        if (this.jYx != null) {
            this.jYx.notifyDataSetChanged();
        }
        if (this.jUA == null || !this.jUA.jJG) {
            aXE();
        }
        ay.onResume();
        super.onResume();
    }

    public void onPause() {
        if (this.jUA != null && this.jUA.aWn()) {
            aXE();
        }
        ay.onPause();
        super.onPause();
    }

    protected final void NI() {
        this.jYx = new aq(this, new a(this) {
            final /* synthetic */ SnsUserUI jYB;

            {
                this.jYB = r1;
            }

            public final void cz(int i, int i2) {
                super.cz(i, i2);
            }
        }, this.dRA, new aq.c(this) {
            final /* synthetic */ SnsUserUI jYB;

            {
                this.jYB = r1;
            }
        });
        this.jYy.gMx.setAdapter(this.jYx);
        this.jYy.gMx.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsUserUI jYB;

            {
                this.jYB = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.jYy.gMx.postDelayed(new Runnable(this) {
            final /* synthetic */ SnsUserUI jYB;

            {
                this.jYB = r1;
            }

            public final void run() {
                if (this.jYB.jUK) {
                    v.w("MicroMsg.SnsUserUI", "too fast that it finish");
                    return;
                }
                this.jYB.jYz.a(this.jYB.jYA.getType(), this.jYB.dRA, this.jYB);
                if (this.jYB.jYA.getType() == 1 && this.jYB.jYA.aXN()) {
                    ad.aSu().u(ad.aSJ().jne, -1);
                }
                if (!this.jYB.jYA.aXN()) {
                    this.jYB.jYz.b(this.jYB.jYA.getType(), this.jYB.dRA, this.jYB.jGc, this.jYB.jUR);
                }
            }
        }, 500);
        a(this.jVv, 2130837595);
    }

    private void aYk() {
        if (!com.tencent.mm.ah.a.aT(this)) {
            v.d("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 18, "", "")), be.bur(), this});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 18, "", "")) {
                v.d("MicroMsg.SnsUserUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), be.bur(), this});
                if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    com.tencent.mm.pluginsdk.ui.tools.l.u(this.nDR.nEl, new Intent());
                }
            }
        }
    }

    public void onBackPressed() {
        if (this.jUA == null || !this.jUA.jJG) {
            finish();
        } else if (!this.jUA.gq(false)) {
            aXE();
        }
    }

    public final boolean aXG() {
        if (this.jUA == null) {
            return super.aXG();
        }
        return !this.jUA.jJG;
    }

    private void aXE() {
        bAc();
        setRequestedOrientation(-1);
        if (this.jGc) {
            this.nDR.a(0, 2131165198, getString(2131235483), new OnMenuItemClickListener(this) {
                final /* synthetic */ SnsUserUI jYB;

                {
                    this.jYB = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.setClass(this.jYB, SnsMsgUI.class);
                    intent.putExtra("sns_msg_force_show_all", true);
                    this.jYB.startActivityForResult(intent, 8);
                    return true;
                }
            }, null, com.tencent.mm.ui.k.b.nES);
        } else {
            iT(false);
        }
        a(this.jVv, 2130837595);
        if (this.jGc) {
            vD(2131235500);
            return;
        }
        CharSequence tU;
        v.d("MicroMsg.SnsUserUI", "SnsUserUI, userName:%s, title:%s", new Object[]{this.dRA, this.jYy.title});
        u LX = ad.aSs().LX(this.dRA);
        if (LX != null) {
            v.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is not null");
            tU = LX.tU();
        } else {
            v.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is null, title:%s", new Object[]{this.jYy.title});
            tU = this.jYy.title;
        }
        Fd(i.t(tU));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.SnsUserUI", "on activity result, %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (5985 == i && i2 == -1) {
            if (this.jUA != null && this.jUA.jJG) {
                this.jUA.gq(true);
                aXE();
            }
            finish();
            return;
        }
        super.onActivityResult(i, i2, intent);
        this.jYy.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.SnsUserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    aYk();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? 2131234160 : 2131234163;
                if (iArr[0] != 0) {
                    g.a(this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ SnsUserUI jYB;

                        {
                            this.jYB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.jYB.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ SnsUserUI jYB;

                        {
                            this.jYB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
