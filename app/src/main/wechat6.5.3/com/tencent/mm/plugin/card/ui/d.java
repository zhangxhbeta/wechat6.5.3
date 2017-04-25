package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.bh;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.a.e;
import com.tencent.mm.plugin.card.ui.a.h;
import com.tencent.mm.plugin.card.ui.b.f;
import com.tencent.mm.plugin.card.ui.b.i;
import com.tencent.mm.plugin.card.ui.b.l;
import com.tencent.mm.plugin.card.ui.b.n;
import com.tencent.mm.plugin.card.ui.b.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.an;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.protocal.c.nd;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class d implements l, com.tencent.mm.ui.MMActivity.a {
    ListView Eq;
    private final String TAG = "MicroMsg.CardDetailUIContoller";
    boolean beg = false;
    LinearLayout dT;
    com.tencent.mm.plugin.card.base.b eBg;
    MMActivity eBk;
    List<com.tencent.mm.plugin.card.model.b> eBl = new ArrayList();
    ArrayList<ix> eBn;
    private View eEX;
    public int eFO = 0;
    String eFP = "";
    String eFQ = "";
    public ArrayList<String> eFR = new ArrayList();
    public ArrayList<String> eFS = new ArrayList();
    OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ d eID;

        {
            this.eID = r1;
        }

        public final void onClick(View view) {
            boolean z = true;
            int i = false;
            if (view.getId() == 2131755727 || view.getId() == 2131755728) {
                if (this.eID.eBg.Za()) {
                    if (this.eID.eIA != null) {
                        this.eID.eIA.abm();
                    }
                } else if (this.eID.eBg.Zb() && this.eID.eIA != null) {
                    this.eID.eIA.abk();
                }
            } else if (view.getId() == 2131757137 || view.getId() == 2131755733) {
                com.tencent.mm.plugin.card.b.b.L(this.eID.eBk, this.eID.eIB.eHL);
            } else if (view.getId() == 2131755758 || view.getId() == 2131755754) {
                if (view.getId() == 2131755758) {
                    this.eID.eIt = false;
                } else if (view.getId() == 2131755754) {
                    this.eID.eIt = true;
                }
                i iVar = this.eID.eIs;
                boolean z2 = this.eID.eIt;
                iVar.abQ();
                iVar.eIt = z2;
                if (iVar.eLp != null && !iVar.eLp.isShowing()) {
                    iVar.eLp.showAtLocation(view.getRootView(), 17, 0, 0);
                    iVar.eLp.setFocusable(true);
                    iVar.eLp.setTouchable(true);
                    iVar.eLp.setBackgroundDrawable(new ColorDrawable(16777215));
                    iVar.eLp.setOutsideTouchable(true);
                    if (iVar.eIt) {
                        iVar.eLv.setOnClickListener(iVar.eFl);
                        Bitmap bitmap = iVar.eLo;
                        if (iVar.eFc != null) {
                            iVar.eLo = j.k(iVar.eFc);
                        } else {
                            iVar.eLo = null;
                        }
                        iVar.eLv.setImageBitmap(iVar.eLo);
                        iVar.eLy.add(0, bitmap);
                        iVar.abS();
                        iVar.eLq.setVisibility(8);
                        iVar.eLu.setVisibility(0);
                        r1 = iVar.eBg.Zw().code;
                        if (TextUtils.isEmpty(r1) || r1.length() > 40) {
                            iVar.eLw.setVisibility(8);
                        } else {
                            iVar.eLw.setText(k.qD(r1));
                            if (iVar.eBg.Zk()) {
                                iVar.eLw.setVisibility(0);
                            } else {
                                iVar.eLw.setVisibility(8);
                            }
                        }
                        if (TextUtils.isEmpty(iVar.eBg.Zv().hbX)) {
                            iVar.eLx.setVisibility(8);
                        } else {
                            iVar.eLx.setText(iVar.eBg.Zv().hbX);
                            iVar.eLx.setVisibility(0);
                        }
                    } else {
                        iVar.eLr.setOnClickListener(iVar.eFl);
                        iVar.eLr.setImageBitmap(iVar.eFb);
                        r1 = iVar.eBg.Zw().code;
                        if (TextUtils.isEmpty(r1) || r1.length() > 40) {
                            iVar.eLs.setVisibility(8);
                        } else {
                            iVar.eLs.setText(k.qD(r1));
                            if (iVar.eBg.Zk()) {
                                iVar.eLs.setVisibility(0);
                            } else {
                                iVar.eLs.setVisibility(8);
                            }
                        }
                        if (TextUtils.isEmpty(iVar.eBg.Zv().hbX)) {
                            iVar.eLt.setVisibility(8);
                        } else {
                            iVar.eLt.setText(iVar.eBg.Zv().hbX);
                            iVar.eLt.setVisibility(0);
                        }
                        iVar.eLq.setVisibility(0);
                        iVar.eLu.setVisibility(8);
                    }
                    iVar.eLp.update();
                }
            } else if (view.getId() == 2131756000 || view.getId() == 2131755919 || view.getId() == 2131755788 || view.getId() == 2131755756 || view.getId() == 2131755918) {
                if (view.getId() == 2131756000) {
                    if (this.eID.eBg.Zb()) {
                        int i2;
                        r1 = g.iuh;
                        r5 = new Object[9];
                        r5[0] = "CardConsumedCodeUI";
                        r5[1] = Integer.valueOf(this.eID.eBg.Zv().eBL);
                        r5[2] = this.eID.eBg.ZA();
                        r5[3] = this.eID.eBg.Zz();
                        r5[4] = Integer.valueOf(0);
                        r5[5] = Integer.valueOf(this.eID.eIB.eHT);
                        r5[6] = this.eID.eIB.eHL;
                        if (this.eID.eBg.Zt()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        r5[7] = Integer.valueOf(i2);
                        r5[8] = "";
                        r1.h(11324, r5);
                        if (this.eID.eIA != null) {
                            this.eID.eIA.ck(true);
                            return;
                        }
                        return;
                    }
                    this.eID.a(true, new com.tencent.mm.plugin.card.a.g.b(), false);
                } else if (!this.eID.eBg.Zb()) {
                    this.eID.a(false, new com.tencent.mm.plugin.card.a.g.b(), false);
                } else if (this.eID.eIA != null) {
                    this.eID.eIA.ck(false);
                }
            } else if (view.getId() == 2131755822) {
                if (!TextUtils.isEmpty(this.eID.eBg.Zv().mkZ)) {
                    com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, this.eID.eBg.Zv().mkZ, 3);
                    g.iuh.h(11941, new Object[]{Integer.valueOf(13), this.eID.eBg.Zz(), this.eID.eBg.ZA(), "", this.eID.eBg.Zv().mkY});
                }
            } else if (view.getId() == 2131755731) {
                g.iuh.h(11582, new Object[]{"OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(this.eID.eBg.Zv().eBL), this.eID.eBg.ZA(), this.eID.eBg.Zz(), this.eID.eIB.eHL});
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", this.eID.eFO);
                intent.putExtra("Klabel_name_list", this.eID.eFP);
                intent.putExtra("Kother_user_name_list", this.eID.eFQ);
                intent.putExtra("k_sns_label_ui_title", this.eID.eBk.getString(2131231686));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("Ktag_rangeFilterprivate", true);
                c.b(this.eID.eBk, "sns", ".ui.SnsLabelUI", intent, 2);
                this.eID.eBk.nDS = this.eID;
            } else if (view.getId() == 2131755954) {
                if (this.eID.eBg.Zw().mko != null) {
                    LinkedList linkedList = this.eID.eBg.Zw().mko;
                    int intValue = ((Integer) view.getTag()).intValue();
                    r0 = (ld) linkedList.get(intValue);
                    if (r0 != null && !TextUtils.isEmpty(r0.url)) {
                        com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, r0.url, 1);
                        g gVar = g.iuh;
                        Object[] objArr = new Object[5];
                        switch (intValue) {
                            case 0:
                                r1 = 10;
                                break;
                            case 1:
                                r1 = 11;
                                break;
                            case 2:
                                r1 = 12;
                                break;
                            case 3:
                                r1 = 16;
                                break;
                            default:
                                r1 = 10;
                                break;
                        }
                        objArr[0] = Integer.valueOf(r1);
                        objArr[1] = this.eID.eBg.Zz();
                        objArr[2] = this.eID.eBg.ZA();
                        objArr[3] = "";
                        objArr[4] = r0.title;
                        gVar.h(11941, objArr);
                        if (j.a(r0, this.eID.eBg.Zz())) {
                            r1 = this.eID.eBg.Zz();
                            r0 = r0.title;
                            j.qB(r1);
                            com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, this.eID.eBg.Zv().eCD);
                        }
                    }
                }
            } else if (view.getId() == 2131755957) {
                if (this.eID.eBg.Zw().mko != null) {
                    r0 = (ld) this.eID.eBg.Zw().mko.get(0);
                    if (r0 != null && !TextUtils.isEmpty(r0.url)) {
                        com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, r0.url, 1);
                        g.iuh.h(11941, new Object[]{Integer.valueOf(10), this.eID.eBg.Zz(), this.eID.eBg.ZA(), "", r0.title});
                        if (j.a(r0, this.eID.eBg.Zz())) {
                            r1 = this.eID.eBg.Zz();
                            r0 = r0.title;
                            j.qB(r1);
                            com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, this.eID.eBg.Zv().eCD);
                        }
                    }
                }
            } else if (view.getId() == 2131755935 || view.getId() == 2131755936) {
                if (this.eID.eBg.Zw().mkv == null) {
                    return;
                }
                if (this.eID.eBg.Zn()) {
                    if (!this.eID.eBg.Zb()) {
                        this.eID.a(false, new com.tencent.mm.plugin.card.a.g.b(), false);
                    } else if (this.eID.eIA != null) {
                        this.eID.eIA.ck(false);
                    }
                } else if (this.eID.eBg.Zo()) {
                    com.tencent.mm.plugin.card.a.g.b bVar = new com.tencent.mm.plugin.card.a.g.b();
                    com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, bVar.eBz, bVar.eBA, false, this.eID.eBg);
                } else {
                    r0 = this.eID.eBg.Zw().mkv;
                    if (r0 != null && !TextUtils.isEmpty(r0.url)) {
                        com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, j.o(r0.url, r0.mlB), 1);
                        g.iuh.h(11941, new Object[]{Integer.valueOf(9), this.eID.eBg.Zz(), this.eID.eBg.ZA(), "", r0.title});
                        if (j.a(r0, this.eID.eBg.Zz())) {
                            r1 = this.eID.eBg.Zz();
                            r0 = r0.title;
                            j.qB(r1);
                            com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, this.eID.eBg.Zv().eCD);
                        }
                    }
                }
            } else if (view.getId() == 2131755812 || view.getId() == 2131755805) {
                nd ndVar = this.eID.eBg.Zv().mlf;
                r1 = g.iuh;
                r5 = new Object[9];
                r5[0] = "CardLeftRightIntroduceView";
                r5[1] = Integer.valueOf(this.eID.eBg.Zv().eBL);
                r5[2] = this.eID.eBg.ZA();
                r5[3] = this.eID.eBg.Zz();
                r5[4] = Integer.valueOf(0);
                r5[5] = Integer.valueOf(this.eID.eIB.eHT);
                r5[6] = this.eID.eIB.eHL;
                if (this.eID.eBg.Zt()) {
                    i = 1;
                }
                r5[7] = Integer.valueOf(i);
                r5[8] = "";
                r1.h(11324, r5);
                if (ndVar == null || TextUtils.isEmpty(ndVar.url)) {
                    Intent intent2 = new Intent();
                    if (this.eID.eBg instanceof CardInfo) {
                        intent2.putExtra("key_card_info_data", (CardInfo) this.eID.eBg);
                    } else if (this.eID.eBg instanceof ShareCardInfo) {
                        intent2.putExtra("key_card_info_data", (ShareCardInfo) this.eID.eBg);
                    }
                    intent2.setClass(this.eID.eBk, CardDetailPreference.class);
                    this.eID.eBk.startActivity(intent2);
                    return;
                }
                com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, ndVar.url, 1);
            } else if (view.getId() == 2131755976) {
                if (com.tencent.mm.plugin.card.sharecard.a.b.pU(this.eID.eBg.ZA()) > 1) {
                    d dVar = this.eID;
                    if (this.eID.eIc) {
                        z = false;
                    }
                    dVar.eIc = z;
                    this.eID.aaI();
                }
            } else if (view.getId() == 2131755808) {
                if (this.eID.eBg.Zv().mlb != null && !TextUtils.isEmpty(this.eID.eBg.Zv().mlb.url)) {
                    com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, this.eID.eBg.Zv().mlb.url, 3);
                    g.iuh.h(11941, new Object[]{Integer.valueOf(3), this.eID.eBg.Zz(), this.eID.eBg.ZA(), "", this.eID.eBg.Zv().mlb.text});
                }
            } else if (view.getId() == 2131755736) {
                if (this.eID.eBg.Zv().mli != null && !be.kS(this.eID.eBg.Zv().mli.url)) {
                    com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, this.eID.eBg.Zv().mli.url, 1);
                    g.iuh.h(11941, new Object[]{Integer.valueOf(14), this.eID.eBg.Zz(), this.eID.eBg.ZA(), "", this.eID.eBg.Zv().mli.text});
                }
            } else if (view.getId() == 2131755990 || view.getId() == 2131755989) {
                if (this.eID.eBg.Zv().mkR <= 0) {
                    return;
                }
                if (this.eID.eBn == null || this.eID.eBn.size() == 0) {
                    v.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    return;
                }
                r0 = (ix) this.eID.eBn.get(0);
                com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, r0.bhs, r0.biH, r0.cJf);
                g gVar2 = g.iuh;
                Object[] objArr2 = new Object[9];
                objArr2[0] = "UsedStoresView";
                objArr2[1] = Integer.valueOf(this.eID.eBg.Zv().eBL);
                objArr2[2] = this.eID.eBg.ZA();
                objArr2[3] = this.eID.eBg.Zz();
                objArr2[4] = Integer.valueOf(0);
                objArr2[5] = Integer.valueOf(this.eID.eIB.eHT);
                objArr2[6] = this.eID.eIB.eHL;
                if (this.eID.eBg.Zt()) {
                    r1 = 1;
                } else {
                    r1 = 0;
                }
                objArr2[7] = Integer.valueOf(r1);
                objArr2[8] = "";
                gVar2.h(11324, objArr2);
                g.iuh.h(11941, new Object[]{Integer.valueOf(5), this.eID.eBg.Zz(), this.eID.eBg.ZA(), "", r0.name});
            } else if (view.getId() == 2131756010) {
                if (this.eID.eBn == null || this.eID.eBn.size() == 0) {
                    v.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    return;
                }
                r0 = (ix) this.eID.eBn.get(0);
                r1 = (String) view.getTag();
                if (!TextUtils.isEmpty(r1) && r1.equals(this.eID.eBk.getString(2131231594))) {
                    d.a(this.eID);
                } else if (!TextUtils.isEmpty(r0.eDc)) {
                    com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, r0.eDc, 1);
                    g.iuh.h(11941, new Object[]{Integer.valueOf(4), this.eID.eBg.Zz(), this.eID.eBg.ZA(), "", r0.name});
                }
            } else if (view.getId() == 2131756014) {
                d.a(this.eID);
            }
        }
    };
    b eIA;
    a eIB;
    com.tencent.mm.sdk.c.c eIC = new com.tencent.mm.sdk.c.c<bh>(this) {
        final /* synthetic */ d eID;

        {
            this.eID = r2;
            this.nhz = bh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            bh bhVar = (bh) bVar;
            if (ak.uz()) {
                v.i("MicroMsg.CardDetailUIContoller", "deal with card notify event ConsumedCardByOfflinePayEvent");
                if (bhVar instanceof bh) {
                    if (bhVar.aYO.aKK == 0) {
                        com.tencent.mm.plugin.card.b.c.b(this.eID.eBk, this.eID.eBk.getResources().getString(2131236534));
                    }
                    return true;
                }
            }
            return false;
        }
    };
    com.tencent.mm.plugin.card.ui.a.g eIa;
    f eIb;
    boolean eIc = false;
    f eId;
    f eIe;
    com.tencent.mm.plugin.card.widget.g eIf;
    f eIg;
    k eIh;
    f eIi;
    f eIj;
    f eIk;
    f eIl;
    f eIm;
    f eIn;
    f eIo;
    f eIp;
    com.tencent.mm.plugin.card.ui.b.d eIq;
    f eIr;
    i eIs;
    boolean eIt = true;
    com.tencent.mm.plugin.card.a.f eIu;
    public String eIv = "";
    public String eIw = "";
    HashMap<Integer, String> eIx = new HashMap();
    HashMap<String, String> eIy = new HashMap();
    ArrayList<String> eIz = new ArrayList();

    public static class a {
        public String eAS = "";
        public boolean eBT = false;
        public String eHL = "";
        public String eHM = "";
        public String eHN = "";
        public int eHT = -1;
        public String eHw = "";
        public String eHx = "";
        public int exT = 3;
    }

    public interface b {
        void abj();

        void abk();

        void abl();

        void abm();

        void abn();

        void abo();

        void abp();

        void ck(boolean z);

        void d(com.tencent.mm.plugin.card.base.b bVar);

        void qh(String str);
    }

    static /* synthetic */ void a(d dVar) {
        Intent intent = new Intent();
        if (dVar.eBg instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) dVar.eBg);
        } else if (dVar.eBg instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) dVar.eBg);
        }
        intent.setClass(dVar.eBk, CardShopUI.class);
        dVar.eBk.startActivity(intent);
        g gVar = g.iuh;
        Object[] objArr = new Object[9];
        objArr[0] = "UsedStoresView";
        objArr[1] = Integer.valueOf(dVar.eBg.Zv().eBL);
        objArr[2] = dVar.eBg.ZA();
        objArr[3] = dVar.eBg.Zz();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(dVar.eIB.eHT);
        objArr[6] = dVar.eIB.eHL;
        objArr[7] = Integer.valueOf(dVar.eBg.Zt() ? 1 : 0);
        objArr[8] = "";
        gVar.h(11324, objArr);
    }

    static /* synthetic */ void b(d dVar) {
        com.tencent.mm.plugin.card.b.b.a(dVar.eBk, 0, (com.tencent.mm.ui.MMActivity.a) dVar);
        dVar.eBk.nDS = dVar;
    }

    public d(MMActivity mMActivity, View view) {
        this.eBk = mMActivity;
        this.eEX = view;
    }

    public final void a(com.tencent.mm.plugin.card.base.b bVar, a aVar, ArrayList<ix> arrayList) {
        this.eBg = bVar;
        this.eIB = aVar;
        this.eBn = arrayList;
    }

    public final View findViewById(int i) {
        return this.eEX.findViewById(i);
    }

    public final com.tencent.mm.plugin.card.base.b abq() {
        return this.eBg;
    }

    public final void d(com.tencent.mm.plugin.card.base.b bVar) {
        if (bVar != null) {
            this.eBg = bVar;
            if (this.eIA != null) {
                this.eIA.d(bVar);
            }
            aaI();
        }
    }

    public final boolean abr() {
        return this.eIc;
    }

    public final void abs() {
        this.eIc = false;
    }

    public final MMActivity abt() {
        return this.eBk;
    }

    public final OnClickListener abu() {
        return this.eFl;
    }

    public final com.tencent.mm.plugin.card.ui.a.g abv() {
        return this.eIa;
    }

    public final b abw() {
        return this.eIA;
    }

    public final a abx() {
        return this.eIB;
    }

    public final com.tencent.mm.plugin.card.a.f aby() {
        return this.eIu;
    }

    public final i abz() {
        return this.eIs;
    }

    public final String getString(int i) {
        return this.eBk.getString(i);
    }

    public final void aaI() {
        if (this.eBg == null) {
            v.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
            if (this.eIA != null) {
                this.eIA.abn();
            }
        } else if (this.eBg.Zv() == null) {
            v.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
            if (this.eIA != null) {
                this.eIA.abn();
            }
        } else if (this.eBg.Zw() == null) {
            v.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
            if (this.eIA != null) {
                this.eIA.abn();
            }
        } else if (this.eBg.Zh()) {
            int i;
            v.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
            v.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.eBg.Zv().mlo);
            com.tencent.mm.plugin.card.a.f fVar = this.eIu;
            com.tencent.mm.plugin.card.base.b bVar = this.eBg;
            ArrayList arrayList = this.eBn;
            int i2 = this.eIB.exT;
            fVar.eBg = bVar;
            fVar.eBn = arrayList;
            fVar.exT = i2;
            boolean z = this.eIa == null ? false : this.eBg.Zb() ? !(this.eIa instanceof h) : this.eBg.Zc() ? !(this.eIa instanceof e) : this.eBg.Zf() ? !(this.eIa instanceof com.tencent.mm.plugin.card.ui.a.b) : this.eBg.Zd() ? !(this.eIa instanceof com.tencent.mm.plugin.card.ui.a.c) : this.eBg.Ze() ? !(this.eIa instanceof com.tencent.mm.plugin.card.ui.a.f) : this.eBg.Zg() ? !(this.eIa instanceof com.tencent.mm.plugin.card.ui.a.d) : !(this.eIa instanceof com.tencent.mm.plugin.card.ui.a.a);
            if (z) {
                this.eIa.release();
                this.eIa = null;
                v.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[]{Integer.valueOf(this.eBg.Zv().eBL)});
            }
            if (this.eIa == null) {
                v.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[]{Integer.valueOf(this.eBg.Zv().eBL)});
                v.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[]{Integer.valueOf(this.eBg.Zv().eBL)});
                if (!this.eBg.Zb()) {
                    switch (this.eBg.Zv().eBL) {
                        case 0:
                            this.eIa = new com.tencent.mm.plugin.card.ui.a.c(this.eBk);
                            break;
                        case 10:
                            this.eIa = new e(this.eBk);
                            break;
                        case 11:
                            this.eIa = new com.tencent.mm.plugin.card.ui.a.b(this.eBk);
                            break;
                        case 20:
                            this.eIa = new com.tencent.mm.plugin.card.ui.a.f(this.eBk);
                            break;
                        case 30:
                            this.eIa = new com.tencent.mm.plugin.card.ui.a.d(this.eBk);
                            break;
                        default:
                            this.eIa = new com.tencent.mm.plugin.card.ui.a.a(this.eBk);
                            break;
                    }
                }
                this.eIa = new h(this.eBk);
            }
            v.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:", new Object[]{Integer.valueOf(this.eBg.Zv().eBL)});
            this.eIa.a(this.eBg, this.eIB);
            this.eIa.acE();
            v.i("MicroMsg.CardDetailUIContoller", "");
            if (this.eIa.acm()) {
                this.eBk.Fd(this.eIu.getTitle());
            } else {
                this.eBk.Fd("");
            }
            if (this.eBg == null) {
                v.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
            } else {
                View acN;
                LinearLayout linearLayout;
                if (this.eIf != null) {
                    if (this.eBg.Zc()) {
                        if (!(this.eIf instanceof com.tencent.mm.plugin.card.widget.e)) {
                            z = true;
                            if (z) {
                                acN = this.eIf.acN();
                                if (acN != null) {
                                    this.dT.removeView(acN);
                                }
                                this.dT.removeAllViews();
                                this.dT.invalidate();
                                this.eIf.release();
                                this.eIf = null;
                            }
                            if (this.eIf == null) {
                                if (this.eBg.Zc()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.e(this.eBk);
                                } else if (this.eBg.Zf()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.c(this.eBk);
                                } else if (this.eBg.Zd()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                                } else if (this.eBg.Ze()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.f(this.eBk);
                                } else if (this.eBg.Zg()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                                } else {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.d(this.eBk);
                                }
                                this.eIf.h(this.eBg);
                                acN = this.eIf.acN();
                                if (acN != null) {
                                    linearLayout = this.dT;
                                    acN.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(acN);
                                }
                                this.dT.invalidate();
                                this.eIf.setOnClickListener(this.eFl);
                                j(false, false);
                            }
                            if (this.eIf != null) {
                                if (this.eBg.Ze()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.eIf).eBn = this.eBn;
                                }
                                this.eIf.f(this.eBg);
                            }
                        }
                    } else if (this.eBg.Zf()) {
                        if (!(this.eIf instanceof com.tencent.mm.plugin.card.widget.c)) {
                            z = true;
                            if (z) {
                                acN = this.eIf.acN();
                                if (acN != null) {
                                    this.dT.removeView(acN);
                                }
                                this.dT.removeAllViews();
                                this.dT.invalidate();
                                this.eIf.release();
                                this.eIf = null;
                            }
                            if (this.eIf == null) {
                                if (this.eBg.Zc()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.e(this.eBk);
                                } else if (this.eBg.Zf()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.c(this.eBk);
                                } else if (this.eBg.Zd()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                                } else if (this.eBg.Ze()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.f(this.eBk);
                                } else if (this.eBg.Zg()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                                } else {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.d(this.eBk);
                                }
                                this.eIf.h(this.eBg);
                                acN = this.eIf.acN();
                                if (acN != null) {
                                    linearLayout = this.dT;
                                    acN.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(acN);
                                }
                                this.dT.invalidate();
                                this.eIf.setOnClickListener(this.eFl);
                                j(false, false);
                            }
                            if (this.eIf != null) {
                                if (this.eBg.Ze()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.eIf).eBn = this.eBn;
                                }
                                this.eIf.f(this.eBg);
                            }
                        }
                    } else if (this.eBg.Zd()) {
                        if (!(this.eIf instanceof com.tencent.mm.plugin.card.widget.b)) {
                            z = true;
                            if (z) {
                                acN = this.eIf.acN();
                                if (acN != null) {
                                    this.dT.removeView(acN);
                                }
                                this.dT.removeAllViews();
                                this.dT.invalidate();
                                this.eIf.release();
                                this.eIf = null;
                            }
                            if (this.eIf == null) {
                                if (this.eBg.Zc()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.e(this.eBk);
                                } else if (this.eBg.Zf()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.c(this.eBk);
                                } else if (this.eBg.Zd()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                                } else if (this.eBg.Ze()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.f(this.eBk);
                                } else if (this.eBg.Zg()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.d(this.eBk);
                                } else {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                                }
                                this.eIf.h(this.eBg);
                                acN = this.eIf.acN();
                                if (acN != null) {
                                    linearLayout = this.dT;
                                    acN.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(acN);
                                }
                                this.dT.invalidate();
                                this.eIf.setOnClickListener(this.eFl);
                                j(false, false);
                            }
                            if (this.eIf != null) {
                                if (this.eBg.Ze()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.eIf).eBn = this.eBn;
                                }
                                this.eIf.f(this.eBg);
                            }
                        }
                    } else if (this.eBg.Ze()) {
                        if (!(this.eIf instanceof com.tencent.mm.plugin.card.widget.f)) {
                            z = true;
                            if (z) {
                                acN = this.eIf.acN();
                                if (acN != null) {
                                    this.dT.removeView(acN);
                                }
                                this.dT.removeAllViews();
                                this.dT.invalidate();
                                this.eIf.release();
                                this.eIf = null;
                            }
                            if (this.eIf == null) {
                                if (this.eBg.Zc()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.e(this.eBk);
                                } else if (this.eBg.Zf()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.c(this.eBk);
                                } else if (this.eBg.Zd()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                                } else if (this.eBg.Ze()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.f(this.eBk);
                                } else if (this.eBg.Zg()) {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                                } else {
                                    this.eIf = new com.tencent.mm.plugin.card.widget.d(this.eBk);
                                }
                                this.eIf.h(this.eBg);
                                acN = this.eIf.acN();
                                if (acN != null) {
                                    linearLayout = this.dT;
                                    acN.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(acN);
                                }
                                this.dT.invalidate();
                                this.eIf.setOnClickListener(this.eFl);
                                j(false, false);
                            }
                            if (this.eIf != null) {
                                if (this.eBg.Ze()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.eIf).eBn = this.eBn;
                                }
                                this.eIf.f(this.eBg);
                            }
                        }
                    } else if (this.eBg.Zg() && !(this.eIf instanceof com.tencent.mm.plugin.card.widget.d)) {
                        z = true;
                        if (z) {
                            acN = this.eIf.acN();
                            if (acN != null) {
                                this.dT.removeView(acN);
                            }
                            this.dT.removeAllViews();
                            this.dT.invalidate();
                            this.eIf.release();
                            this.eIf = null;
                        }
                        if (this.eIf == null) {
                            if (this.eBg.Zc()) {
                                this.eIf = new com.tencent.mm.plugin.card.widget.e(this.eBk);
                            } else if (this.eBg.Zf()) {
                                this.eIf = new com.tencent.mm.plugin.card.widget.c(this.eBk);
                            } else if (this.eBg.Zd()) {
                                this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                            } else if (this.eBg.Ze()) {
                                this.eIf = new com.tencent.mm.plugin.card.widget.f(this.eBk);
                            } else if (this.eBg.Zg()) {
                                this.eIf = new com.tencent.mm.plugin.card.widget.d(this.eBk);
                            } else {
                                this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                            }
                            this.eIf.h(this.eBg);
                            acN = this.eIf.acN();
                            if (acN != null) {
                                linearLayout = this.dT;
                                acN.setLayoutParams(new LayoutParams(-1, -2));
                                linearLayout.addView(acN);
                            }
                            this.dT.invalidate();
                            this.eIf.setOnClickListener(this.eFl);
                            j(false, false);
                        }
                        if (this.eIf != null) {
                            if (this.eBg.Ze()) {
                                ((com.tencent.mm.plugin.card.widget.f) this.eIf).eBn = this.eBn;
                            }
                            this.eIf.f(this.eBg);
                        }
                    }
                }
                z = false;
                if (z) {
                    acN = this.eIf.acN();
                    if (acN != null) {
                        this.dT.removeView(acN);
                    }
                    this.dT.removeAllViews();
                    this.dT.invalidate();
                    this.eIf.release();
                    this.eIf = null;
                }
                if (this.eIf == null) {
                    if (this.eBg.Zc()) {
                        this.eIf = new com.tencent.mm.plugin.card.widget.e(this.eBk);
                    } else if (this.eBg.Zf()) {
                        this.eIf = new com.tencent.mm.plugin.card.widget.c(this.eBk);
                    } else if (this.eBg.Zd()) {
                        this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                    } else if (this.eBg.Ze()) {
                        this.eIf = new com.tencent.mm.plugin.card.widget.f(this.eBk);
                    } else if (this.eBg.Zg()) {
                        this.eIf = new com.tencent.mm.plugin.card.widget.b(this.eBk);
                    } else {
                        this.eIf = new com.tencent.mm.plugin.card.widget.d(this.eBk);
                    }
                    this.eIf.h(this.eBg);
                    acN = this.eIf.acN();
                    if (acN != null) {
                        linearLayout = this.dT;
                        acN.setLayoutParams(new LayoutParams(-1, -2));
                        linearLayout.addView(acN);
                    }
                    this.dT.invalidate();
                    this.eIf.setOnClickListener(this.eFl);
                    j(false, false);
                }
                if (this.eIf != null) {
                    if (this.eBg.Ze()) {
                        ((com.tencent.mm.plugin.card.widget.f) this.eIf).eBn = this.eBn;
                    }
                    this.eIf.f(this.eBg);
                }
            }
            if (this.eIa.acn()) {
                v.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
                this.eIb.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
                this.eIb.acF();
            }
            if (this.eIa.ace()) {
                if (this.eIr == null) {
                    this.eIr = new com.tencent.mm.plugin.card.ui.b.b();
                    this.eIr.a(this);
                }
                v.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
                this.eIr.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
                if (this.eIr != null) {
                    this.eIr.acF();
                }
            }
            this.eBk.iT(this.eIa.aci());
            if (this.eIa.acj()) {
                this.eIx.clear();
                this.eIz.clear();
                if (this.eBg.Zj()) {
                    this.eIz.add(getString(2131236669));
                    this.eIx.put(Integer.valueOf(0), "menu_func_share_friend");
                    this.eIz.add(getString(2131236668));
                    this.eIx.put(Integer.valueOf(1), "menu_func_share_timeline");
                    i = 2;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(this.eBg.Zw().mkr)) {
                    this.eIz.add(getString(2131231655));
                    this.eIx.put(Integer.valueOf(i), "menu_func_report");
                    i++;
                }
                jf(i);
                if (this.eIz.size() > 0) {
                    abA();
                }
            }
            if (this.eIa.ack()) {
                this.eIx.clear();
                this.eIz.clear();
                if (this.eBg.Za() && this.eBg.Zi()) {
                    this.eIz.add(getString(2131231654));
                    this.eIx.put(Integer.valueOf(0), "menu_func_gift");
                    i = 1;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(this.eBg.Zw().mkr)) {
                    this.eIz.add(getString(2131231655));
                    this.eIx.put(Integer.valueOf(i), "menu_func_report");
                    i++;
                }
                if (this.eBg.Za()) {
                    this.eIz.add(getString(2131231020));
                    this.eIx.put(Integer.valueOf(i), "menu_func_delete");
                    i++;
                } else if (this.eBg.Zb()) {
                    String xF = com.tencent.mm.model.k.xF();
                    String ZB = this.eBg.ZB();
                    if (xF == null || !xF.equals(ZB)) {
                        v.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
                    } else {
                        this.eIz.add(getString(2131231020));
                        this.eIx.put(Integer.valueOf(i), "menu_func_delete_share_card");
                        i++;
                    }
                }
                jf(i);
                if (this.eIz.size() > 0) {
                    abA();
                }
            }
            if (this.eIa.acl()) {
                this.eIx.clear();
                this.eIz.clear();
                if (TextUtils.isEmpty(this.eBg.Zw().mkr)) {
                    i = 0;
                } else {
                    this.eIz.add(getString(2131231655));
                    this.eIx.put(Integer.valueOf(0), "menu_func_report");
                    i = 1;
                }
                jf(i);
                if (this.eIz.size() > 0) {
                    abA();
                }
            }
            if (this.eIf != null && (this.eIf instanceof com.tencent.mm.plugin.card.widget.b)) {
                ((com.tencent.mm.plugin.card.widget.b) this.eIf).acU();
            }
            j(this.eIa.acg(), this.eIa.ach());
            if (!this.eBg.Zc() && this.eIa.acp()) {
                v.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
                this.eId.update();
            } else if (this.eBg.Zc() && this.eIa.acp()) {
                v.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
                this.eIe.update();
            } else if (this.eIa.acq()) {
                v.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
                this.eIe.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
                this.eIe.acF();
                this.eId.acF();
            }
            if (this.eIf != null) {
                this.eIf.cn(this.eIa.abC());
            }
            if (this.beg) {
                v.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
            } else {
                View findViewById;
                LayoutParams layoutParams;
                if (this.eBg.Za() && this.eBg.Zc()) {
                    this.eEX.findViewById(2131755797).setBackgroundColor(this.eBk.getResources().getColor(2131689900));
                    k.b(this.eBk, this.eBk.getResources().getColor(2131689900));
                } else {
                    this.eEX.findViewById(2131755797).setBackgroundColor(j.qv(this.eBg.Zv().coN));
                    k.a(this.eBk, this.eBg);
                }
                View findViewById2 = this.eEX.findViewById(2131755801);
                View findViewById3 = this.eEX.findViewById(2131755802);
                View findViewById4 = this.eEX.findViewById(2131755803);
                if (this.eBg.Za() && this.eIa.acp()) {
                    if (this.eBg.Zd()) {
                        findViewById2.setBackgroundResource(2130837891);
                        this.eEX.findViewById(2131757136).setBackgroundResource(2130837851);
                        findViewById4.setBackgroundResource(0);
                    } else if (this.eBg.Zc()) {
                        this.eEX.findViewById(2131757136).setBackgroundResource(0);
                        findViewById4.setBackgroundColor(this.eBk.getResources().getColor(2131689900));
                    } else if (this.eBg.Ze()) {
                        findViewById2.setBackgroundResource(2130837891);
                        this.eEX.findViewById(2131757136).setBackgroundResource(2130837851);
                        findViewById4.setBackgroundResource(0);
                    } else if (!this.eBg.Zf() && this.eBg.Zg()) {
                        findViewById4.setBackgroundColor(this.eBk.getResources().getColor(2131689900));
                    }
                } else if (this.eBg.Zb()) {
                    if (this.eIa.acn() && this.eIc) {
                        findViewById2.setBackgroundResource(2130837891);
                        findViewById4.setBackgroundResource(0);
                    } else if (!this.eIa.acn() || this.eIc) {
                        findViewById2.setBackgroundResource(0);
                        if (this.eIa.abC()) {
                            findViewById4.setBackgroundResource(2130837889);
                        } else {
                            findViewById4.setBackgroundResource(2130837891);
                        }
                    } else {
                        findViewById2.setBackgroundResource(2130837889);
                        findViewById4.setBackgroundResource(0);
                    }
                } else if (this.eBg.Zd()) {
                    findViewById2.setBackgroundResource(0);
                    if (this.eIa.abC()) {
                        findViewById4.setBackgroundResource(2130837889);
                    } else {
                        findViewById4.setBackgroundResource(2130837891);
                    }
                } else if (this.eBg.Ze()) {
                    findViewById2.setBackgroundResource(2130837894);
                    findViewById4.setBackgroundResource(0);
                } else {
                    findViewById2.setBackgroundResource(0);
                    findViewById4.setBackgroundColor(this.eBk.getResources().getColor(2131689900));
                }
                if (this.eBg.Zg()) {
                    TextView textView = (TextView) this.eEX.findViewById(2131755820);
                    Drawable bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.uU(2130837888));
                    bitmapDrawable.setTileModeX(TileMode.REPEAT);
                    textView.setBackgroundDrawable(bitmapDrawable);
                    textView.setVisibility(0);
                }
                Rect rect = new Rect(0, 0, 0, 0);
                findViewById2.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                findViewById2.invalidate();
                findViewById4.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                findViewById4.invalidate();
                if (this.eBg.Zb() && this.eIa.acn() && this.eIc) {
                    findViewById = this.eEX.findViewById(2131755982);
                    findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    findViewById.invalidate();
                }
                if (this.eBg.Za() && this.eIa.acp()) {
                    findViewById = this.eEX.findViewById(2131757136);
                    rect.left = this.eBk.getResources().getDimensionPixelOffset(2131493135);
                    rect.right = this.eBk.getResources().getDimensionPixelOffset(2131493135);
                    findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    findViewById.invalidate();
                    if (this.eBg.Ze()) {
                        findViewById = this.eEX.findViewById(2131755799);
                        layoutParams = (LayoutParams) findViewById.getLayoutParams();
                        int dimensionPixelSize = this.eBk.getResources().getDimensionPixelSize(2131493199);
                        layoutParams.rightMargin = dimensionPixelSize;
                        layoutParams.leftMargin = dimensionPixelSize;
                        findViewById.setLayoutParams(layoutParams);
                    }
                }
                if (this.eIa.acp() || this.eIa.acn()) {
                    if (this.eIf != null && ((this.eBg.Za() && this.eBg.Zd()) || this.eBg.Zb())) {
                        this.eIf.jm(0);
                    }
                } else if (this.eIf != null && ((this.eBg.Za() && this.eBg.Zd()) || this.eBg.Zb())) {
                    if (this.eIa.abC()) {
                        this.eIf.jm(2130837892);
                    } else {
                        this.eIf.jm(2130837890);
                    }
                }
                if (this.eIf != null && this.eBg.Za() && this.eBg.Zc()) {
                    this.eIf.a(j.bs(j.qv(this.eBg.Zv().coN), this.eBk.getResources().getDimensionPixelOffset(2131493366)));
                }
                if (this.eBg.Za() && this.eBg.Zc()) {
                    layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    if (TextUtils.isEmpty(this.eBg.Zv().mkY)) {
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.weight = 0.0f;
                        layoutParams.height = -2;
                    }
                    findViewById2.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) findViewById3.getLayoutParams();
                    int dimensionPixelSize2 = this.eBk.getResources().getDimensionPixelSize(2131493152);
                    layoutParams.rightMargin = dimensionPixelSize2;
                    layoutParams.leftMargin = dimensionPixelSize2;
                    if (this.eBg.Zc()) {
                        layoutParams.topMargin = this.eBk.getResources().getDimensionPixelSize(2131493143);
                        layoutParams.bottomMargin = this.eBk.getResources().getDimensionPixelSize(2131493144);
                        dimensionPixelSize2 = this.eBk.getResources().getDimensionPixelSize(2131493138);
                        layoutParams.rightMargin = dimensionPixelSize2;
                        layoutParams.leftMargin = dimensionPixelSize2;
                    } else {
                        dimensionPixelSize2 = this.eBk.getResources().getDimensionPixelSize(2131492971);
                        layoutParams.bottomMargin = dimensionPixelSize2;
                        layoutParams.topMargin = dimensionPixelSize2;
                    }
                    findViewById3.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) findViewById4.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    if (this.eBg.Zc()) {
                        layoutParams.bottomMargin = this.eBk.getResources().getDimensionPixelSize(2131493138);
                    }
                    if (TextUtils.isEmpty(this.eBg.Zv().mkY)) {
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.weight = 0.0f;
                        layoutParams.height = -2;
                    }
                    findViewById4.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(this.eBg.Zv().mkY)) {
                        findViewById2 = findViewById(2131755821);
                        layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                        findViewById2.setLayoutParams(layoutParams);
                    }
                }
                this.eEX.invalidate();
            }
            if (this.eIa.acu()) {
                if (this.eIj == null) {
                    this.eIj = new n();
                    this.eIj.a(this);
                }
                v.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
                this.eIj.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
                if (this.eIj != null) {
                    this.eIj.acF();
                }
            }
            if (this.eIa.acD()) {
                if (this.eIi == null) {
                    this.eIi = new com.tencent.mm.plugin.card.ui.b.c();
                    this.eIi.a(this);
                }
                v.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
                this.eIi.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
                if (this.eIi != null) {
                    this.eIi.acF();
                }
            }
            if (this.eIa.acv()) {
                if (this.eIk == null) {
                    this.eIk = new com.tencent.mm.plugin.card.ui.b.h();
                    this.eIk.a(this);
                }
                v.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
                this.eIk.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
                if (this.eIk != null) {
                    this.eIk.acF();
                }
            }
            if (this.eIa.acw()) {
                if (this.eIl == null) {
                    this.eIl = new l();
                    this.eIl.a(this);
                }
                v.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
                this.eIl.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
                if (this.eIl != null) {
                    this.eIl.acF();
                }
            }
            if (this.eIa.acx()) {
                if (this.eIm == null) {
                    this.eIm = new i();
                    this.eIm.a(this);
                }
                v.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
                this.eIm.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
                if (this.eIm != null) {
                    this.eIm.acF();
                }
            }
            if (this.eIa.acy()) {
                if (this.eIn == null) {
                    this.eIn = new o();
                    this.eIn.a(this);
                }
                v.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
                this.eIn.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
                if (this.eIn != null) {
                    this.eIn.acF();
                }
            }
            if (this.eIa.acA()) {
                if (this.eIo == null) {
                    this.eIo = new com.tencent.mm.plugin.card.ui.b.e();
                    this.eIo.a(this);
                }
                v.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
                this.eIo.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
                if (this.eIo != null) {
                    this.eIo.acF();
                }
            }
            if (this.eIa.acz()) {
                if (this.eIp == null) {
                    this.eIp = new com.tencent.mm.plugin.card.ui.b.k();
                    this.eIp.a(this);
                }
                v.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
                this.eIp.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
                if (this.eIp != null) {
                    this.eIp.acF();
                }
            }
            if (this.eIa.acr()) {
                com.tencent.mm.plugin.card.model.b bVar2;
                this.eBl.clear();
                List list = this.eBl;
                com.tencent.mm.plugin.card.a.f fVar2 = this.eIu;
                fVar2.eBl.clear();
                if (fVar2.eBg.Zw().mkz != null) {
                    bVar2 = new com.tencent.mm.plugin.card.model.b();
                    bVar2.eBU = 1;
                    bVar2.title = fVar2.eBg.Zw().mkz.title;
                    bVar2.eEL = "";
                    bVar2.url = "card://jump_card_gift";
                    bVar2.eBZ = fVar2.eBg.Zw().mkz.eBZ;
                    fVar2.eBl.add(bVar2);
                }
                if (fVar2.eBg.Zw().mki != null && fVar2.eBg.Zw().mki.size() > 0) {
                    Collection ac = j.ac(fVar2.eBg.Zw().mki);
                    ((com.tencent.mm.plugin.card.model.b) ac.get(0)).eBV = false;
                    fVar2.eBl.addAll(ac);
                }
                if (((fVar2.exT == 6 && fVar2.eBg.Zw().mkm <= 0) || j.jl(fVar2.exT)) && fVar2.eBg.Zr() && fVar2.eBg.Za() && fVar2.eBg.Zi()) {
                    bVar2 = new com.tencent.mm.plugin.card.model.b();
                    bVar2.eBU = 1;
                    bVar2.title = aa.getContext().getString(2131231654);
                    bVar2.eEL = "";
                    bVar2.url = "card://jump_gift";
                    fVar2.eBl.add(bVar2);
                }
                if (!(fVar2.eBg.Zw().status == 0 || fVar2.eBg.Zw().status == 1)) {
                    i = fVar2.eBg.Zw().status;
                }
                if (fVar2.exT != 3 && fVar2.exT == 6) {
                    i = fVar2.eBg.Zw().mkm;
                }
                nd ndVar = fVar2.eBg.Zv().mlf;
                if (fVar2.eBg.Zw().mks != null) {
                    TextUtils.isEmpty(fVar2.eBg.Zw().mks.title);
                }
                com.tencent.mm.plugin.card.model.b bVar3 = new com.tencent.mm.plugin.card.model.b();
                z = fVar2.eBg.Zg() ? false : ndVar == null || ndVar.mpb == null || ndVar.mpb.size() <= 0 || TextUtils.isEmpty((CharSequence) ndVar.mpb.get(0));
                bVar3.eBV = false;
                bVar3.eBU = 1;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(fVar2.getTitle());
                stringBuilder.append(fVar2.getString(2131231611));
                bVar3.title = stringBuilder.toString();
                bVar3.eBN = "";
                bVar3.eEL = "";
                bVar3.url = "card://jump_detail";
                if (z) {
                    fVar2.eBl.add(bVar3);
                }
                if (!fVar2.eBg.Ze() || fVar2.eBg.Zv().mkR <= 0) {
                    ix ixVar;
                    if (!fVar2.eBg.Zc() || fVar2.eBg.Zv().mkR <= 0) {
                        if (fVar2.eBg.Zv().mkR > 0) {
                            v.e("MicroMsg.CardDetailDataMgr", "shop_count:" + fVar2.eBg.Zv().mkR);
                            if (fVar2.eBg.Zv().mkR > 0 && fVar2.eBn != null && fVar2.eBn.size() > 0) {
                                ixVar = (ix) fVar2.eBn.get(0);
                                if (ixVar != null && ixVar.mkD < 50000.0f) {
                                    bVar3 = new com.tencent.mm.plugin.card.model.b();
                                    bVar3.eBU = 2;
                                    bVar3.title = ixVar.name;
                                    bVar3.eBN = fVar2.eBk.getString(2131231697, new Object[]{j.b(fVar2.eBk, ixVar.mkD), ixVar.cJf});
                                    bVar3.eEL = "";
                                    bVar3.url = "card://jump_shop";
                                    bVar3.eBY = ixVar.eBY;
                                    bVar3.coN = fVar2.eBg.Zv().coN;
                                    fVar2.eBl.add(bVar3);
                                } else if (ixVar != null) {
                                    v.e("MicroMsg.CardDetailDataMgr", "distance:" + ixVar.mkD);
                                }
                            }
                        }
                    }
                    if (fVar2.eBg.Zv().mkR > 0 && fVar2.eBn == null) {
                        bVar2 = new com.tencent.mm.plugin.card.model.b();
                        bVar2.eBU = 1;
                        if (TextUtils.isEmpty(fVar2.eBg.Zv().mlq)) {
                            bVar2.title = fVar2.getString(2131231589);
                        } else {
                            bVar2.title = fVar2.eBg.Zv().mlq;
                        }
                        bVar2.eBN = "";
                        bVar2.eEL = "";
                        bVar2.url = "card://jump_shop_list";
                        fVar2.eBl.add(bVar2);
                    } else if (fVar2.eBg.Zv().mkR > 0 && fVar2.eBn != null && fVar2.eBn.size() > 0) {
                        bVar3 = new com.tencent.mm.plugin.card.model.b();
                        bVar3.eBU = 1;
                        ixVar = (ix) fVar2.eBn.get(0);
                        if (!TextUtils.isEmpty(fVar2.eBg.Zv().mlq)) {
                            bVar3.title = fVar2.eBg.Zv().mlq;
                        } else if (fVar2.eBg.Zc() || ixVar.mkD >= 5000.0f) {
                            bVar3.title = fVar2.getString(2131231589);
                        } else if (fVar2.eBg.Zv().mkR == 1 || fVar2.eBn.size() == 1) {
                            v.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
                        } else {
                            bVar3.title = fVar2.getString(2131231595);
                        }
                        if (!fVar2.eBg.Zc() || ixVar.mkD >= 2000.0f) {
                            bVar3.eBN = "";
                        } else if (fVar2.eBg.Zv().mkR > 1 || (fVar2.eBn != null && fVar2.eBn.size() > 1)) {
                            bVar3.eBN = fVar2.eBk.getString(2131231650, new Object[]{j.b(fVar2.eBk, ixVar.mkD)});
                        } else {
                            bVar3.eBN = j.b(fVar2.eBk, ixVar.mkD);
                        }
                        bVar3.eEL = "";
                        bVar3.url = "card://jump_shop_list";
                        fVar2.eBl.add(bVar3);
                    }
                }
                if (!((fVar2.eBg.Zg() && fVar2.eBg.Zw().status == 3) || TextUtils.isEmpty(fVar2.eBg.Zv().mkK))) {
                    fVar2.eBl.add(fVar2.ZU());
                }
                list.addAll(fVar2.eBl);
                k kVar = this.eIh;
                Collection collection = this.eBl;
                kVar.eBl.clear();
                kVar.eBl.addAll(collection);
                this.eIh.eMa = this.eBg.Zg();
                this.eIh.notifyDataSetChanged();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
            }
            if (this.eIa.acs()) {
                this.eBg.a(this.eBg.Zw());
                j.g(this.eBg);
                if (this.eIa.act()) {
                    if (this.eIg == null) {
                        this.eIg = new com.tencent.mm.plugin.card.ui.b.g();
                        this.eIg.a(this);
                    }
                    v.i("MicroMsg.CardDetailUIContoller", "update CardCodeView");
                    this.eIg.update();
                } else if (this.eIg != null) {
                    this.eIg.acF();
                }
                if (this.eIf != null) {
                    this.eIf.cm(true);
                }
            } else {
                v.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
                if (this.eIg != null) {
                    this.eIg.acF();
                }
                if (this.eIf != null) {
                    this.eIf.cm(false);
                }
            }
            if (this.eIa.acB()) {
                v.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
                this.eIq.update();
            } else {
                v.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
                this.eIq.acF();
            }
            this.eIs.eBg = this.eBg;
        } else {
            v.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[]{Integer.valueOf(this.eBg.Zv().eBL)});
            if (TextUtils.isEmpty(this.eBg.Zv().mkT)) {
                com.tencent.mm.ui.base.g.a(this.eBk, getString(2131231661), null, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ d eID;

                    {
                        this.eID = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (this.eID.eIA != null) {
                            this.eID.eIA.abn();
                        }
                    }
                });
                return;
            }
            com.tencent.mm.plugin.card.b.b.a(this.eBk, this.eBg.Zv().mkT, 0);
            if (this.eIA != null) {
                this.eIA.abn();
            }
        }
    }

    public final void a(boolean z, com.tencent.mm.plugin.card.a.g.b bVar, boolean z2) {
        int i = 1;
        g gVar;
        Object[] objArr;
        if (!z) {
            gVar = g.iuh;
            objArr = new Object[9];
            objArr[0] = "CardConsumedCodeUI";
            objArr[1] = Integer.valueOf(this.eBg.Zv().eBL);
            objArr[2] = this.eBg.ZA();
            objArr[3] = this.eBg.Zz();
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(this.eIB.eHT);
            objArr[6] = this.eIB.eHL;
            if (!this.eBg.Zt()) {
                i = 0;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "";
            gVar.h(11324, objArr);
            qi(bVar.eBw);
        } else if (this.eBg.Zo()) {
            com.tencent.mm.plugin.card.b.b.a(this.eBk, bVar.eBz, bVar.eBA, z2, this.eBg);
            g.iuh.h(11941, new Object[]{Integer.valueOf(17), this.eBg.Zz(), this.eBg.ZA(), "", this.eBg.Zw().mkv.title});
        } else if (this.eBg.Zw().mkv == null || TextUtils.isEmpty(this.eBg.Zw().mkv.title) || TextUtils.isEmpty(this.eBg.Zw().mkv.url)) {
            gVar = g.iuh;
            objArr = new Object[9];
            objArr[0] = "CardConsumedCodeUI";
            objArr[1] = Integer.valueOf(this.eBg.Zv().eBL);
            objArr[2] = this.eBg.ZA();
            objArr[3] = this.eBg.Zz();
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(this.eIB.eHT);
            objArr[6] = this.eIB.eHL;
            if (!this.eBg.Zt()) {
                i = 0;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "";
            gVar.h(11324, objArr);
            qi(bVar.eBw);
        } else {
            com.tencent.mm.plugin.card.b.b.a(this.eBk, j.o(this.eBg.Zw().mkv.url, this.eBg.Zw().mkv.mlB), 1);
            g.iuh.h(11941, new Object[]{Integer.valueOf(6), this.eBg.Zz(), this.eBg.ZA(), "", this.eBg.Zw().mkv.title});
        }
    }

    private void j(boolean z, boolean z2) {
        if (this.eIf != null) {
            this.eIf.j(z, z2);
        }
    }

    private void jf(int i) {
        LinkedList linkedList = this.eBg.Zw().mkt;
        if (linkedList != null) {
            this.eIy.clear();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                an anVar = (an) linkedList.get(i2);
                if (!(be.kS(anVar.text) || be.kS(anVar.url))) {
                    this.eIz.add(anVar.text);
                    this.eIx.put(Integer.valueOf(i), anVar.text);
                    this.eIy.put(anVar.text, anVar.url);
                    i++;
                }
            }
        }
    }

    private void abA() {
        int i = 2130838681;
        if (this.eBg.Zc()) {
            i = 2130837868;
        }
        this.eBk.a(0, i, new OnMenuItemClickListener(this) {
            final /* synthetic */ d eID;

            {
                this.eID = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.iuh.h(11582, new Object[]{"CardDetailUiMenu", Integer.valueOf(1), Integer.valueOf(this.eID.eBg.Zv().eBL), this.eID.eBg.ZA(), this.eID.eBg.Zz(), this.eID.eIB.eHL});
                com.tencent.mm.ui.base.g.a(this.eID.eBk.nDR.nEl, null, (String[]) this.eID.eIz.toArray(new String[this.eID.eIz.size()]), null, false, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ AnonymousClass4 eIE;

                    {
                        this.eIE = r1;
                    }

                    public final void gT(int i) {
                        String str = (String) this.eIE.eID.eIx.get(Integer.valueOf(i));
                        if (!TextUtils.isEmpty(str)) {
                            if (str.equals("menu_func_share_friend")) {
                                int i2;
                                com.tencent.mm.ui.MMActivity.a aVar = this.eIE.eID;
                                com.tencent.mm.plugin.card.b.b.a(aVar.eBk, 1, aVar);
                                aVar.eBk.nDS = aVar;
                                g gVar = g.iuh;
                                Object[] objArr = new Object[9];
                                objArr[0] = "BrandContactView";
                                objArr[1] = Integer.valueOf(this.eIE.eID.eBg.Zv().eBL);
                                objArr[2] = this.eIE.eID.eBg.ZA();
                                objArr[3] = this.eIE.eID.eBg.Zz();
                                objArr[4] = Integer.valueOf(0);
                                objArr[5] = Integer.valueOf(this.eIE.eID.eIB.eHT);
                                objArr[6] = this.eIE.eID.eIB.eHL;
                                if (this.eIE.eID.eBg.Zt()) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                objArr[7] = Integer.valueOf(i2);
                                objArr[8] = "";
                                gVar.h(11324, objArr);
                                g.iuh.h(11582, new Object[]{"OperShareFriend", Integer.valueOf(1), Integer.valueOf(this.eIE.eID.eBg.Zv().eBL), this.eIE.eID.eBg.ZA(), this.eIE.eID.eBg.Zz(), this.eIE.eID.eIv});
                            } else if (str.equals("menu_func_gift")) {
                                d.b(this.eIE.eID);
                            } else if (str.equals("menu_func_delete")) {
                                str = "";
                                if (this.eIE.eID.eBg.Zc()) {
                                    str = this.eIE.eID.eBk.getString(2131231609);
                                }
                                com.tencent.mm.plugin.card.b.c.a(this.eIE.eID.eBk, this.eIE.eID.eIB.eAS, str, new com.tencent.mm.plugin.card.b.c.a(this) {
                                    final /* synthetic */ AnonymousClass1 eIF;

                                    {
                                        this.eIF = r1;
                                    }

                                    public final void YZ() {
                                        if (this.eIF.eIE.eID.eIA != null) {
                                            this.eIF.eIE.eID.eIA.abl();
                                        }
                                    }
                                });
                                g.iuh.h(11582, new Object[]{"OperDelete", Integer.valueOf(1), Integer.valueOf(this.eIE.eID.eBg.Zv().eBL), this.eIE.eID.eBg.ZA(), this.eIE.eID.eBg.Zz(), ""});
                            } else if (str.equals("menu_func_service")) {
                                if (!TextUtils.isEmpty(this.eIE.eID.eBg.Zv().mkK)) {
                                    com.tencent.mm.plugin.card.b.b.M(this.eIE.eID.eBk, this.eIE.eID.eBg.Zv().mkK);
                                    af.aaq().l(this.eIE.eID.eBg.Zz(), this.eIE.eID.eBg.ZA(), 1);
                                }
                                g.iuh.h(11582, new Object[]{"OperService", Integer.valueOf(1), Integer.valueOf(this.eIE.eID.eBg.Zv().eBL), this.eIE.eID.eBg.ZA(), this.eIE.eID.eBg.Zz(), this.eIE.eID.eIB.eHL});
                            } else if (str.equals("menu_func_report")) {
                                if (!TextUtils.isEmpty(this.eIE.eID.eBg.Zw().mkr)) {
                                    r0 = this.eIE.eID.eBk;
                                    r3 = this.eIE.eID.eBg.Zw().mkr;
                                    r4 = this.eIE.eID.getString(2131231667);
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", r3);
                                    intent.putExtra("stastic_scene", 0);
                                    intent.putExtra("rawUrl", r3);
                                    intent.putExtra("title", r4);
                                    c.b(r0, "webview", ".ui.tools.WebViewUI", intent);
                                }
                                g.iuh.h(11582, new Object[]{"OperReport", Integer.valueOf(1), Integer.valueOf(this.eIE.eID.eBg.Zv().eBL), this.eIE.eID.eBg.ZA(), this.eIE.eID.eBg.Zz(), ""});
                            } else if (str.equals("menu_func_share_timeline")) {
                                com.tencent.mm.platformtools.j.a(new com.tencent.mm.plugin.card.model.i(this.eIE.eID.eBg.Zv().eBM));
                                r0 = this.eIE.eID.eBk;
                                com.tencent.mm.plugin.card.base.b bVar = this.eIE.eID.eBg;
                                r4 = this.eIE.eID.eIB.eAS;
                                Object obj = this.eIE.eID.eIB.eHN;
                                Intent intent2 = new Intent();
                                intent2.putExtra("Ksnsupload_link", bVar.Zv().mkT);
                                intent2.putExtra("KContentObjDesc", bVar.Zv().eCD);
                                intent2.putExtra("Ksnsupload_title", bVar.Zv().title);
                                if (TextUtils.isEmpty(obj)) {
                                    intent2.putExtra("KUploadProduct_UserData", r4 + "#");
                                } else {
                                    intent2.putExtra("KUploadProduct_UserData", r4 + "#" + obj);
                                }
                                intent2.putExtra("Ksnsupload_imgurl", bVar.Zv().eBM);
                                if (!TextUtils.isEmpty(bVar.Zv().eBM)) {
                                    intent2.putExtra("KsnsUpload_imgPath", new com.tencent.mm.plugin.card.model.i(bVar.Zv().eBM).MU());
                                }
                                v.d("MicroMsg.CardActivityHelper", "doShareTimeLine KSnsUploadImgPath:" + intent2.getStringExtra("KsnsUpload_imgPath"));
                                intent2.putExtra("src_username", com.tencent.mm.model.k.xF());
                                intent2.putExtra("src_displayname", com.tencent.mm.model.k.xH());
                                intent2.putExtra("Ksnsupload_appid", bVar.Zv().bmJ);
                                intent2.putExtra("Ksnsupload_appname", bVar.Zv().mkK);
                                intent2.putExtra("Ksnsupload_type", 7);
                                r3 = com.tencent.mm.model.o.fz("card_package");
                                com.tencent.mm.model.o.yx().n(r3, true).l("prePublishId", "card_package");
                                intent2.putExtra("reportSessionId", r3);
                                c.a(r0, "sns", ".ui.SnsUploadUI", intent2, false);
                                g.iuh.h(11582, new Object[]{"OperShareTimeLine", Integer.valueOf(1), Integer.valueOf(this.eIE.eID.eBg.Zv().eBL), this.eIE.eID.eBg.ZA(), this.eIE.eID.eBg.Zz(), this.eIE.eID.eIB.eHL});
                            } else if (str.equals("menu_func_delete_share_card")) {
                                com.tencent.mm.plugin.card.b.c.a(this.eIE.eID.eBk, this.eIE.eID.eIB.eAS, "", new com.tencent.mm.plugin.card.b.c.a(this) {
                                    final /* synthetic */ AnonymousClass1 eIF;

                                    {
                                        this.eIF = r1;
                                    }

                                    public final void YZ() {
                                        if (this.eIF.eIE.eID.eIA != null) {
                                            this.eIF.eIE.eID.eIA.abo();
                                        }
                                    }
                                });
                            } else {
                                str = (String) this.eIE.eID.eIy.get(str);
                                if (!be.kS(str)) {
                                    com.tencent.mm.plugin.card.b.b.a(this.eIE.eID.eBk, str, 0);
                                }
                            }
                        }
                    }
                });
                return true;
            }
        });
    }

    public final void a(final int i, int i2, Intent intent) {
        switch (i) {
            case 0:
            case 1:
            case 4:
                if (i2 == -1) {
                    this.eIv = intent.getStringExtra("Select_Conv_User");
                    final String str = this.eIv;
                    if (this.eBg.Zv() == null) {
                        v.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    if (i == 0) {
                        if (TextUtils.isEmpty(this.eBg.Zx().mSm)) {
                            stringBuilder.append(getString(2131235509));
                        } else {
                            stringBuilder.append(this.eBg.Zx().mSm);
                        }
                    } else if (i == 1) {
                        stringBuilder.append(getString(2131231696) + this.eIu.getTitle());
                    } else if (i == 4) {
                        stringBuilder.append(getString(2131231666) + this.eIu.getTitle());
                    }
                    com.tencent.mm.pluginsdk.ui.applet.c.a(this.eBk.nDR, stringBuilder.toString(), this.eBg.Zv().eBM, this.eBg.Zv().title + "\n" + this.eBg.Zv().eCD, true, this.eBk.getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                        final /* synthetic */ d eID;

                        public final void a(boolean z, String str, int i) {
                            if (z) {
                                this.eID.eIw = str;
                                if (i == 0) {
                                    if (this.eID.eIA != null) {
                                        this.eID.eIA.qh(str);
                                    }
                                    g.iuh.h(11582, new Object[]{"OperGift", Integer.valueOf(1), Integer.valueOf(this.eID.eBg.Zv().eBL), this.eID.eBg.ZA(), this.eID.eBg.Zz(), this.eID.eIv});
                                    com.tencent.mm.ui.base.g.bf(this.eID.eBk, this.eID.eBk.getResources().getString(2131231631));
                                } else if (i == 1) {
                                    r0 = this.eID;
                                    r0.eBg.Zx().mSm = r0.getString(2131231696) + r0.eIu.getTitle();
                                    j.a(r0.eBg, r0.eIv, r0.eIB.eHN, 2);
                                    j.bk(r0.eIw, r0.eIv);
                                    com.tencent.mm.ui.base.g.bf(this.eID.eBk, this.eID.eBk.getResources().getString(2131231631));
                                } else if (i == 4) {
                                    r0 = this.eID;
                                    if (TextUtils.isEmpty(r0.eBg.ZB())) {
                                        r0.eBg.pE(com.tencent.mm.model.k.xF());
                                    }
                                    r0.eBg.Zx().mSm = r0.getString(2131231666) + r0.eIu.getTitle();
                                    j.a(r0.eBg, r0.eIv, r0.eIB.eHN, 23);
                                    j.bk(r0.eIw, r0.eIv);
                                    g.iuh.h(11582, new Object[]{"OpeRecommendCard", Integer.valueOf(this.eID.eIB.exT), Integer.valueOf(this.eID.eBg.Zv().eBL), this.eID.eBg.ZA(), this.eID.eBg.Zz(), this.eID.eIv});
                                    com.tencent.mm.ui.base.g.bf(this.eID.eBk, this.eID.eBk.getResources().getString(2131231631));
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    this.eFO = intent.getIntExtra("Ktag_range_index", 0);
                    v.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.eFO)});
                    if (this.eFO >= 2) {
                        this.eFP = intent.getStringExtra("Klabel_name_list");
                        this.eFQ = intent.getStringExtra("Kother_user_name_list");
                        v.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.eFO), this.eFP});
                        if (TextUtils.isEmpty(this.eFP) && TextUtils.isEmpty(this.eFQ)) {
                            v.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
                            return;
                        }
                        List asList = Arrays.asList(this.eFP.split(","));
                        this.eFS = j.ae(asList);
                        this.eFR = j.ad(asList);
                        if (this.eFQ != null && this.eFQ.length() > 0) {
                            this.eFR.addAll(Arrays.asList(this.eFQ.split(",")));
                        }
                        if (this.eFS != null) {
                            v.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.eFS.size());
                        }
                        if (this.eFR != null) {
                            v.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.eFR.size());
                            Iterator it = this.eFR.iterator();
                            while (it.hasNext()) {
                                v.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (this.eFO == 2) {
                            this.eIq.qk(this.eBk.getString(2131231685, new Object[]{aaK()}));
                            return;
                        } else if (this.eFO == 3) {
                            this.eIq.qk(this.eBk.getString(2131231684, new Object[]{aaK()}));
                            return;
                        } else {
                            this.eIq.qk(this.eBk.getString(2131231683));
                            return;
                        }
                    }
                    this.eIq.qk(this.eBk.getString(2131231683));
                    return;
                }
                return;
            case 3:
                if (this.eIA != null) {
                    this.eIA.abp();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String aaK() {
        if (!TextUtils.isEmpty(this.eFP) && !TextUtils.isEmpty(this.eFQ)) {
            return this.eFP + "," + j.qz(this.eFQ);
        }
        if (!TextUtils.isEmpty(this.eFP)) {
            return this.eFP;
        }
        if (TextUtils.isEmpty(this.eFQ)) {
            return "";
        }
        return j.qz(this.eFQ);
    }

    private void qi(String str) {
        Intent intent = new Intent();
        if (this.eBg instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) this.eBg);
        } else if (this.eBg instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) this.eBg);
        }
        intent.setClass(this.eBk, CardConsumeCodeUI.class);
        intent.putExtra("key_from_scene", this.eIB.exT);
        intent.putExtra("key_mark_user", str);
        this.eBk.startActivityForResult(intent, 3);
        this.eBk.nDS = this;
    }

    public final int abB() {
        if (this.eIu == null) {
            return 0;
        }
        com.tencent.mm.plugin.card.a.f fVar = this.eIu;
        if (fVar.eBm == null ? false : fVar.eBm.eBX) {
            return 1;
        }
        return 0;
    }

    public final boolean abC() {
        return this.eIa == null ? false : this.eIa.abC();
    }
}
