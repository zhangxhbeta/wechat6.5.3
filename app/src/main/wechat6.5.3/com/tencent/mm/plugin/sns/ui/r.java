package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.bl;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.ir;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.e.a.oh;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.List;

public final class r implements e {
    int aYV;
    int aYW;
    final Context context;
    public p dwg = null;
    public int ehy = 0;
    SnsCmdList jFZ = new SnsCmdList();
    String jFs;
    String jFv;
    c jFx = new c<kv>(this) {
        final /* synthetic */ r jGj;

        {
            this.jGj = r2;
            this.nhz = kv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kv kvVar = (kv) bVar;
            if (this.jGj.jGb == null || this.jGj.jFs == null) {
                v.e("MicroMsg.GalleryTitleManager", "not in recoging");
            } else if (kvVar == null || !(kvVar instanceof kv)) {
                v.e("MicroMsg.GalleryTitleManager", "receive invalid callbak");
            } else if (kvVar.bme.filePath.equals(this.jGj.jFs)) {
                v.i("MicroMsg.GalleryTitleManager", "recog result: " + kvVar.bme.bfz);
                if (!be.kS(kvVar.bme.bfz)) {
                    this.jGj.jFv = kvVar.bme.bfz;
                    this.jGj.aYV = kvVar.bme.aYV;
                    this.jGj.aYW = kvVar.bme.aYW;
                    if (!(this.jGj.jFv == null || this.jGj.jGb == null)) {
                        this.jGj.jGe = true;
                    }
                    this.jGj.a(this.jGj.jGc, this.jGj.jaC, this.jGj.jGd, false, 0);
                }
                this.jGj.jFs = null;
            } else {
                v.e("MicroMsg.GalleryTitleManager", "not same filepath");
            }
            return false;
        }
    };
    c jFy = new c<ir>(this) {
        final /* synthetic */ r jGj;

        {
            this.jGj = r2;
            this.nhz = ir.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ir irVar = (ir) bVar;
            if (irVar == null || !(irVar instanceof ir)) {
                v.e("MicroMsg.GalleryTitleManager", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            } else {
                v.i("MicroMsg.GalleryTitleManager", "notify Event: %d", new Object[]{Integer.valueOf(irVar.bjg.bje)});
                if (!(irVar.bjg.aXH == ((Activity) this.jGj.context) && irVar.bjg.aXG.equals(this.jGj.jFv))) {
                    v.e("MicroMsg.GalleryTitleManager", "not the same");
                }
            }
            return false;
        }
    };
    private final a jGa;
    f jGb = null;
    boolean jGc;
    aib jGd;
    boolean jGe = false;
    private final String jGf;
    private OnCancelListener jGg = new OnCancelListener(this) {
        final /* synthetic */ r jGj;

        {
            this.jGj = r1;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            ae aeVar = new ae();
            aeVar.aXI.filePath = this.jGj.jFs;
            com.tencent.mm.sdk.c.a.nhr.z(aeVar);
            this.jGj.jGb = null;
            this.jGj.jFs = null;
            this.jGj.jaC = null;
            this.jGj.uo = null;
            this.jGj.jFv = null;
            r rVar = this.jGj;
            this.jGj.aYW = 0;
            rVar.aYV = 0;
        }
    };
    k jaC;
    String uo;

    class AnonymousClass8 implements OnCancelListener {
        final /* synthetic */ r jGj;
        final /* synthetic */ com.tencent.mm.plugin.sns.e.p jGo;

        AnonymousClass8(r rVar, com.tencent.mm.plugin.sns.e.p pVar) {
            this.jGj = rVar;
            this.jGo = pVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            if (this.jGj.ehy != 0) {
                ak.vy().c(this.jGo);
                this.jGj.ehy = 0;
            }
        }
    }

    class AnonymousClass9 implements OnCancelListener {
        final /* synthetic */ r jGj;
        final /* synthetic */ com.tencent.mm.plugin.sns.e.p jGp;

        AnonymousClass9(r rVar, com.tencent.mm.plugin.sns.e.p pVar) {
            this.jGj = rVar;
            this.jGp = pVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            ak.vy().c(this.jGp);
        }
    }

    public interface a {
        void XJ();

        void aVF();

        void aY(String str, int i);

        void aZ(String str, int i);

        void cO(String str, String str2);
    }

    static /* synthetic */ void BU(String str) {
        oh ohVar = new oh();
        ohVar.bpj.bdn = 3;
        ohVar.bpj.bde = str;
        com.tencent.mm.sdk.c.a.nhr.z(ohVar);
    }

    static /* synthetic */ void BV(String str) {
        oh ohVar = new oh();
        ohVar.bpj.bdn = 1;
        ohVar.bpj.bpm = 2;
        ohVar.bpj.bde = str;
        com.tencent.mm.sdk.c.a.nhr.z(ohVar);
    }

    static /* synthetic */ void a(r rVar) {
        v.i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
        bl blVar = new bl();
        blVar.aYU.aXH = (Activity) rVar.context;
        blVar.aYU.aXG = rVar.jFv;
        blVar.aYU.aYV = rVar.aYV;
        blVar.aYU.aYW = rVar.aYW;
        com.tencent.mm.sdk.c.a.nhr.z(blVar);
    }

    static /* synthetic */ void a(r rVar, k kVar, aib com_tencent_mm_protocal_c_aib) {
        if (kVar == null) {
            v.i("MicroMsg.GalleryTitleManager", "error beacause info null");
        } else if (kVar.field_type == 1) {
            r1 = new bp();
            com.tencent.mm.plugin.sns.j.a.a(r1, kVar, com_tencent_mm_protocal_c_aib.gID);
            r1.aZd.aXH = (Activity) rVar.context;
            r1.aZd.aZl = 15;
            com.tencent.mm.sdk.c.a.nhr.z(r1);
        } else if (kVar == null) {
        } else {
            if (kVar.qC(32)) {
                r1 = new bp();
                com.tencent.mm.plugin.sns.j.a.a(r1, kVar);
                r1.aZd.aXH = (Activity) rVar.context;
                r1.aZd.aZl = 16;
                com.tencent.mm.sdk.c.a.nhr.z(r1);
                return;
            }
            String aUL = kVar.aUL();
            oh ohVar = new oh();
            ohVar.bpj.bdn = 2;
            ohVar.bpj.bpk = 16;
            ohVar.bpj.bpl = false;
            ohVar.bpj.bde = aUL;
            com.tencent.mm.sdk.c.a.nhr.z(ohVar);
        }
    }

    static /* synthetic */ void a(r rVar, k kVar, aib com_tencent_mm_protocal_c_aib, int i) {
        if (kVar == null) {
            v.e("MicroMsg.GalleryTitleManager", "error beacause info null");
            return;
        }
        Intent intent = new Intent();
        if (kVar.field_type == 1) {
            intent.putExtra("sns_send_data_ui_image_path", FlipView.f(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.k(com_tencent_mm_protocal_c_aib), rVar.context));
            intent.putExtra("sns_send_data_ui_image_position", i);
        }
        intent.putExtra("sns_send_data_ui_activity", true);
        intent.putExtra("sns_local_id", kVar.aUL());
        com.tencent.mm.ay.c.a(rVar.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
    }

    public final void qJ(int i) {
        if (i != 0) {
            this.jFZ.pQ(i);
        }
    }

    public r(Context context, a aVar) {
        this.context = context;
        this.jGa = aVar;
        this.jGf = ((Activity) context).getIntent().getStringExtra("sns_gallery_pre_title");
    }

    public final void aVE() {
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.jFZ);
        ((Activity) this.context).setResult(-1, intent);
        ((Activity) this.context).finish();
    }

    public final void a(boolean z, final k kVar, final aib com_tencent_mm_protocal_c_aib, boolean z2, final int i) {
        this.jGc = z;
        this.jaC = kVar;
        this.jGd = com_tencent_mm_protocal_c_aib;
        this.uo = com_tencent_mm_protocal_c_aib.gID;
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        cp cpVar;
        if (!z) {
            kVar.aUp();
            arrayList.add(this.context.getString(2131235509));
            arrayList2.add(Integer.valueOf(3));
            if (com.tencent.mm.ay.c.EH("favorite")) {
                arrayList.add(this.context.getString(2131234180));
                arrayList2.add(Integer.valueOf(6));
            }
            if (kVar.field_type == 15 || kVar.field_type == 5) {
                arrayList.add(this.context.getString(2131234728));
                arrayList2.add(Integer.valueOf(2));
            } else if (kVar.field_type == 1) {
                arrayList.add(this.context.getString(2131234725));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(2131235511));
                arrayList2.add(Integer.valueOf(2));
            }
            cpVar = new cp();
            cpVar.bay.bap = kVar.aUL();
            com.tencent.mm.sdk.c.a.nhr.z(cpVar);
            if (cpVar.baz.aZW) {
                arrayList.add(this.context.getString(2131231834));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.jFv != null) {
                arrayList.add(this.context.getString(2131234352));
                arrayList2.add(Integer.valueOf(7));
            }
            if (arrayList.size() != 0) {
                if (this.jGb == null || !this.jGe) {
                    this.jGb = new f(this.context, f.pbS, false);
                } else {
                    this.jGe = false;
                }
                this.jGb.jXn = new n.c(this) {
                    final /* synthetic */ r jGj;

                    public final void a(l lVar) {
                        lVar.clear();
                        for (int i = 0; i < arrayList.size(); i++) {
                            lVar.d(((Integer) arrayList2.get(i)).intValue(), (CharSequence) arrayList.get(i));
                        }
                    }
                };
                this.jGb.jXo = new d(this) {
                    final /* synthetic */ r jGj;

                    public final void c(MenuItem menuItem, int i) {
                        int itemId = menuItem.getItemId();
                        v.d("MicroMsg.GalleryTitleManager", "showAlert " + itemId);
                        switch (itemId) {
                            case 2:
                                if (kVar != null && kVar.aUp().mWq != null) {
                                    if (kVar.field_type != 15) {
                                        com.tencent.mm.pluginsdk.ui.tools.l.h(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.k(com_tencent_mm_protocal_c_aib), this.jGj.context);
                                        return;
                                    } else {
                                        r.BU(kVar.aUL());
                                        return;
                                    }
                                }
                                return;
                            case 3:
                                if (kVar != null && kVar.aUp().mWq != null) {
                                    if (kVar.aUp().mWq.mol == 1) {
                                        this.jGj.BT(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.k(com_tencent_mm_protocal_c_aib));
                                        return;
                                    }
                                    r.BV(kVar.aUL());
                                    return;
                                }
                                return;
                            case 4:
                                r rVar = this.jGj;
                                long j = kVar.field_snsId;
                                k dd = ad.aSE().dd(j);
                                if (j != 0 && dd != null) {
                                    Intent intent = new Intent();
                                    intent.putExtra("k_username", dd.field_userName);
                                    intent.putExtra("k_expose_msg_id", j);
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                    com.tencent.mm.ay.c.b(rVar.context, "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                }
                                return;
                            case 6:
                                if (kVar != null && kVar.aUp().mWq != null) {
                                    r.a(this.jGj, kVar, com_tencent_mm_protocal_c_aib);
                                    return;
                                }
                                return;
                            case 7:
                                r.a(this.jGj);
                                return;
                            case 8:
                                r.a(this.jGj, kVar, com_tencent_mm_protocal_c_aib, i);
                                return;
                            default:
                                return;
                        }
                    }
                };
                this.jGb.bKh();
            }
        } else if (kVar != null) {
            if (kVar.field_localPrivate > 0) {
                if (!be.kS(ad.aSk()) && ad.aSk().equals(kVar.field_userName)) {
                    arrayList.add(this.context.getString(2131235517));
                    arrayList2.add(Integer.valueOf(5));
                }
                arrayList.add(this.context.getString(2131235509));
                arrayList2.add(Integer.valueOf(3));
            } else {
                arrayList.add(this.context.getString(2131235518));
                arrayList2.add(Integer.valueOf(1));
                arrayList.add(this.context.getString(2131235509));
                arrayList2.add(Integer.valueOf(3));
            }
            if (com.tencent.mm.ay.c.EH("favorite")) {
                arrayList.add(this.context.getString(2131234180));
                arrayList2.add(Integer.valueOf(6));
            }
            if (kVar.field_type == 15 || kVar.field_type == 5) {
                arrayList.add(this.context.getString(2131234728));
                arrayList2.add(Integer.valueOf(2));
            } else if (kVar.field_type == 1) {
                arrayList.add(this.context.getString(2131234725));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(2131235511));
                arrayList2.add(Integer.valueOf(2));
            }
            cpVar = new cp();
            cpVar.bay.bap = kVar.aUL();
            com.tencent.mm.sdk.c.a.nhr.z(cpVar);
            if (cpVar.baz.aZW) {
                arrayList.add(this.context.getString(2131231834));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.jFv != null) {
                arrayList.add(this.context.getString(2131234352));
                arrayList2.add(Integer.valueOf(7));
            }
            if (this.jGb == null || !this.jGe) {
                this.jGb = new f(this.context, f.pbS, false);
            } else {
                this.jGe = false;
            }
            this.jGb.jXn = new n.c(this) {
                final /* synthetic */ r jGj;

                public final void a(l lVar) {
                    lVar.clear();
                    for (int i = 0; i < arrayList.size(); i++) {
                        lVar.d(((Integer) arrayList2.get(i)).intValue(), (CharSequence) arrayList.get(i));
                    }
                    lVar.d(-1, this.jGj.context.getString(2131235387));
                }
            };
            this.jGb.jXo = new d(this) {
                final /* synthetic */ r jGj;

                public final void c(MenuItem menuItem, int i) {
                    int itemId = menuItem.getItemId();
                    v.d("MicroMsg.GalleryTitleManager", "showAlertWithDel " + itemId);
                    r rVar;
                    com.tencent.mm.plugin.sns.e.p pVar;
                    Context context;
                    switch (itemId) {
                        case -1:
                            if (kVar.aUp().mWq.mom.size() > 1) {
                                g.a(this.jGj.context, this.jGj.context.getString(2131235501), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass3 jGl;

                                    {
                                        this.jGl = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.jGl.jGj.A(kVar);
                                    }
                                }, null);
                                return;
                            } else {
                                g.a(this.jGj.context, this.jGj.context.getString(2131235499), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass3 jGl;

                                    {
                                        this.jGl = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.jGl.jGj.A(kVar);
                                    }
                                }, null);
                                return;
                            }
                        case 1:
                            rVar = this.jGj;
                            k kVar = kVar;
                            if (kVar.aUM() || kVar.aUN()) {
                                ad.aSE().qH(kVar.jBI);
                                return;
                            }
                            pVar = new com.tencent.mm.plugin.sns.e.p(kVar.field_snsId, 2);
                            ak.vy().a(pVar, 0);
                            context = rVar.context;
                            rVar.context.getString(2131231164);
                            rVar.dwg = g.a(context, rVar.context.getString(2131235514), true, new AnonymousClass8(rVar, pVar));
                            return;
                        case 2:
                            if (kVar != null && kVar.aUp().mWq != null) {
                                if (kVar.field_type != 15) {
                                    com.tencent.mm.pluginsdk.ui.tools.l.h(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.k(com_tencent_mm_protocal_c_aib), this.jGj.context);
                                    return;
                                } else {
                                    r.BU(kVar.aUL());
                                    return;
                                }
                            }
                            return;
                        case 3:
                            if (kVar != null && kVar.aUp().mWq != null) {
                                if (kVar.aUp().mWq.mol == 1) {
                                    this.jGj.BT(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.k(com_tencent_mm_protocal_c_aib));
                                    return;
                                }
                                r.BV(kVar.aUL());
                                return;
                            }
                            return;
                        case 5:
                            rVar = this.jGj;
                            pVar = new com.tencent.mm.plugin.sns.e.p(kVar.field_snsId, 3);
                            ak.vy().a(pVar, 0);
                            context = rVar.context;
                            rVar.context.getString(2131231164);
                            rVar.dwg = g.a(context, rVar.context.getString(2131235514), true, new AnonymousClass9(rVar, pVar));
                            return;
                        case 6:
                            if (kVar != null && kVar.aUp().mWq != null) {
                                r.a(this.jGj, kVar, com_tencent_mm_protocal_c_aib);
                                return;
                            }
                            return;
                        case 7:
                            r.a(this.jGj);
                            return;
                        case 8:
                            r.a(this.jGj, kVar, com_tencent_mm_protocal_c_aib, i);
                            return;
                        default:
                            return;
                    }
                }
            };
            this.jGb.bKh();
        } else {
            return;
        }
        if (true == z2 && ak.vy().BJ() != 0) {
            kt ktVar = new kt();
            String str = al.cA(ad.xh(), this.uo) + i.k(com_tencent_mm_protocal_c_aib);
            ktVar.bmc.filePath = str;
            this.jFs = str;
            com.tencent.mm.sdk.c.a.nhr.z(ktVar);
        }
    }

    protected final void A(k kVar) {
        if (kVar.aUM() || kVar.aUN()) {
            ad.aSE().qH(kVar.jBI);
            this.jFZ.pQ(kVar.jBI);
            return;
        }
        ad.aSD().cP(kVar.field_snsId);
        final com.tencent.mm.plugin.sns.e.p pVar = new com.tencent.mm.plugin.sns.e.p(kVar.field_snsId, 1);
        ak.vy().a(pVar, 0);
        Context context = this.context;
        this.context.getString(2131231164);
        this.dwg = g.a(context, this.context.getString(2131235388), true, new OnCancelListener(this) {
            final /* synthetic */ r jGj;

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.jGj.ehy != 0) {
                    ak.vy().c(pVar);
                    this.jGj.ehy = 0;
                }
            }
        });
    }

    protected final void BT(String str) {
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.plugin.sns.b.a.drp.l(intent, this.context);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0 && kVar != null) {
            v.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
            if (this.dwg != null) {
                this.dwg.dismiss();
            }
            com.tencent.mm.plugin.sns.e.p pVar = (com.tencent.mm.plugin.sns.e.p) kVar;
            switch (pVar.type) {
                case -1:
                    this.jGa.aY("", pVar.type);
                    return;
                case 1:
                    this.jFZ.pQ(pVar.jdV);
                    this.jGa.aY(s.B("sns_table_", (long) pVar.jdV), pVar.type);
                    return;
                case 2:
                    this.jFZ.pR(pVar.jdV);
                    this.jGa.aY("", pVar.type);
                    return;
                case 3:
                    this.jFZ.pR(pVar.jdV);
                    this.jGa.aY(s.B("sns_table_", (long) pVar.jdV), pVar.type);
                    return;
                default:
                    return;
            }
        }
    }
}
