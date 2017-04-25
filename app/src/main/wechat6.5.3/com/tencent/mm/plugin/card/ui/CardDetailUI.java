package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.e.a.my;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.card.a.c.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.card.ui.b.m;
import com.tencent.mm.protocal.c.auo;
import com.tencent.mm.protocal.c.auw;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class CardDetailUI extends MMActivity implements a, d.a, g.a, e {
    private final String TAG = "MicroMsg.CardDetailUI";
    private float bYf = -1000.0f;
    private float bYg = -1000.0f;
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ CardDetailUI eHY;

        {
            this.eHY = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return true;
            }
            if (this.eHY.bYf == -1000.0f && this.eHY.bYg == -1000.0f) {
                this.eHY.bYf = f2;
                this.eHY.bYg = f;
                af.aaq().m(this.eHY.bYf, this.eHY.bYg);
            }
            if (this.eHY.eHX) {
                this.eHY.abi();
                this.eHY.eHX = false;
            }
            this.eHY.YU();
            return false;
        }
    };
    private c cCR;
    private p dFI = null;
    private String eAS = "";
    private String eBG = "";
    private boolean eBT = false;
    private b eBg;
    private ArrayList<ix> eBn;
    private boolean eFA = false;
    private boolean eGy = false;
    private String eHB = "";
    private d eHK;
    private String eHL = "";
    private String eHM = "";
    private String eHN = "";
    private boolean eHO = false;
    private boolean eHP = false;
    private boolean eHQ = false;
    private String eHR = "";
    private d.a eHS;
    private int eHT = -1;
    private boolean eHU = false;
    private boolean eHV = true;
    private boolean eHW = false;
    private boolean eHX = false;
    private int eHv = 0;
    private String eHw = "";
    private String eHx = "";
    private String eHy = "";
    private Vibrator ewK;
    private int exT = 3;
    ac mHandler = new ac();
    private long mStartTime = 0;

    static /* synthetic */ void a(CardDetailUI cardDetailUI, String str) {
        cardDetailUI.cg(true);
        ak.vy().a(new aa(cardDetailUI.eBg.Zz(), str, 18), 0);
    }

    static /* synthetic */ void h(CardDetailUI cardDetailUI) {
        int i;
        cardDetailUI.cg(true);
        auo com_tencent_mm_protocal_c_auo = new auo();
        if (cardDetailUI.exT == 3) {
            com_tencent_mm_protocal_c_auo.bol = cardDetailUI.eAS;
            i = 1;
        } else {
            com_tencent_mm_protocal_c_auo.eBK = cardDetailUI.eAS;
            i = 0;
        }
        com_tencent_mm_protocal_c_auo.bom = cardDetailUI.eHN;
        com_tencent_mm_protocal_c_auo.lZM = cardDetailUI.eHw;
        com_tencent_mm_protocal_c_auo.lZL = cardDetailUI.eHx;
        com_tencent_mm_protocal_c_auo.lZN = cardDetailUI.eHv;
        LinkedList linkedList = new LinkedList();
        linkedList.add(com_tencent_mm_protocal_c_auo);
        auw a = j.a(cardDetailUI.eHK.eFO, cardDetailUI.eHK.eFR, cardDetailUI.eHK.eFS);
        axv com_tencent_mm_protocal_c_axv = new axv();
        com_tencent_mm_protocal_c_axv.mVn = cardDetailUI.eHB;
        com_tencent_mm_protocal_c_axv.eCF = cardDetailUI.eHR;
        v.i("MicroMsg.CardDetailUI", "ShareCardItem upload templateId:%s", new Object[]{cardDetailUI.eHB});
        ak.vy().a(new com.tencent.mm.plugin.card.sharecard.model.g(i, linkedList, cardDetailUI.eBg.Zv().mkK, cardDetailUI.eHy, a, cardDetailUI.exT, com_tencent_mm_protocal_c_axv), 0);
    }

    static /* synthetic */ void i(CardDetailUI cardDetailUI) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(cardDetailUI.eAS);
        cardDetailUI.cg(true);
        ak.vy().a(new n(linkedList), 0);
    }

    static /* synthetic */ void j(CardDetailUI cardDetailUI) {
        cardDetailUI.cg(true);
        String ZA = (cardDetailUI.exT == 6 || TextUtils.isEmpty(cardDetailUI.eBg.ZA())) ? cardDetailUI.eAS : cardDetailUI.eBg.ZA();
        int abB = cardDetailUI.eHK.abB();
        axv com_tencent_mm_protocal_c_axv = new axv();
        com_tencent_mm_protocal_c_axv.mVn = cardDetailUI.eHB;
        com_tencent_mm_protocal_c_axv.eCF = cardDetailUI.eHR;
        v.i("MicroMsg.CardDetailUI", "AcceptItemInfo templateId:%s", new Object[]{cardDetailUI.eHB});
        ak.vy().a(new k(ZA, cardDetailUI.exT, cardDetailUI.eHL, cardDetailUI.eHN, cardDetailUI.eHw, cardDetailUI.eHx, cardDetailUI.eHv, abB, com_tencent_mm_protocal_c_axv), 0);
    }

    protected final int getLayoutId() {
        return 2130903217;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        abd();
        Object aav = af.aav();
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        ak.vy().a(910, aav);
        af.aar().a(aav);
        com.tencent.mm.plugin.card.a.b aaj = af.aaj();
        if (aaj.eAR == null) {
            aaj.eAR = new ArrayList();
        }
        if (aav != null) {
            aaj.eAR.add(new WeakReference(aav));
        }
        aav.adL = new WeakReference(actionBarActivity);
        af.aav().a((d.a) this);
        af.aaw().a(this);
        com.tencent.mm.plugin.card.a.c aax = af.aax();
        ak.vy().a(577, aax);
        aax.eAT.clear();
        aax.eAU = 0;
        af.aax().a(this);
        NI();
    }

    protected void onResume() {
        super.onResume();
        abd();
        if (this.cCR != null) {
            this.cCR.a(this.bYl, true);
        }
        this.eHK.beg = false;
        af.aav().a(this, true);
        if ((!this.eHO && !this.eHP) || !this.eBg.Zb()) {
            return;
        }
        if (this.eBg.Zo()) {
            af.aaw().aj(this.eAS, 2);
            Boolean bool = (Boolean) af.aav().eBf.get(this.eAS);
            boolean z = bool != null && bool.booleanValue();
            if (!z || TextUtils.isEmpty(af.aav().eBi)) {
                v.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
                return;
            }
            v.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
            pI(af.aav().eBi);
            return;
        }
        af.aaw().aj(this.eAS, 1);
    }

    protected void onPause() {
        abe();
        super.onPause();
        this.eHK.beg = true;
        af.aav().a(this, false);
    }

    protected void onDestroy() {
        af.aav().c(this);
        abe();
        af.aav().b(this);
        af.aav().release();
        af.aaw().b(this);
        af.aax().b(this);
        af.aax().release();
        d dVar = this.eHK;
        f fVar = dVar.eIu;
        fVar.eBg = null;
        fVar.eBl.clear();
        dVar.eIu = null;
        i iVar = dVar.eIs;
        j.l(iVar.eLo);
        for (int size = iVar.eLy.size() - 1; size >= 0; size--) {
            j.l((Bitmap) iVar.eLy.remove(size));
        }
        iVar.eLy.clear();
        if (iVar.eLp.isShowing()) {
            iVar.eLp.dismiss();
        }
        iVar.eLp = null;
        iVar.abR();
        iVar.eLn = null;
        iVar.eBg = null;
        dVar.eIs = null;
        if (dVar.eIf != null) {
            dVar.eIf.release();
        }
        dVar.eBk.nDS = null;
        com.tencent.mm.sdk.c.a.nhr.f(dVar.eIC);
        dVar.eIb.destroy();
        dVar.eIe.destroy();
        dVar.eId.destroy();
        dVar.eIq.destroy();
        if (dVar.eIr != null) {
            dVar.eIr.destroy();
        }
        if (dVar.eIj != null) {
            dVar.eIj.destroy();
        }
        if (dVar.eIi != null) {
            dVar.eIi.destroy();
        }
        if (dVar.eIk != null) {
            dVar.eIk.destroy();
        }
        if (dVar.eIl != null) {
            dVar.eIl.destroy();
        }
        if (dVar.eIm != null) {
            dVar.eIm.destroy();
        }
        if (dVar.eIn != null) {
            dVar.eIn.destroy();
        }
        if (dVar.eIo != null) {
            dVar.eIo.destroy();
        }
        if (dVar.eIp != null) {
            dVar.eIp.destroy();
        }
        if (dVar.eIg != null) {
            dVar.eIg.destroy();
        }
        dVar.eIa = null;
        this.ewK.cancel();
        YU();
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (this.eBg != null) {
            com.tencent.mm.plugin.report.service.g.iuh.h(13219, new Object[]{"CardDetailView", Integer.valueOf(this.exT), this.eBg.ZA(), this.eBg.Zz(), Long.valueOf(currentTimeMillis)});
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.h(13219, new Object[]{"CardDetailView", Integer.valueOf(this.exT), this.eAS, this.eAS, Long.valueOf(currentTimeMillis)});
        }
        if ((this.eHO || this.eHP) && this.eBg.Zb()) {
            if (this.eBg.Zo()) {
                af.aaw().aj(this.eAS, 2);
            } else {
                af.aaw().aj(this.eAS, 1);
            }
        }
        super.onDestroy();
    }

    private void abd() {
        ak.vy().a(645, this);
        ak.vy().a(651, this);
        ak.vy().a(563, this);
        ak.vy().a(652, this);
        ak.vy().a(560, this);
        ak.vy().a(699, this);
        ak.vy().a(902, this);
        ak.vy().a(904, this);
        ak.vy().a(1163, this);
    }

    private void abe() {
        ak.vy().b(645, this);
        ak.vy().b(651, this);
        ak.vy().b(563, this);
        ak.vy().b(652, this);
        ak.vy().b(560, this);
        ak.vy().b(699, this);
        ak.vy().b(902, this);
        ak.vy().b(904, this);
        ak.vy().b(1163, this);
    }

    protected final void NI() {
        boolean z;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardDetailUI eHY;

            {
                this.eHY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eHY.cj(true);
                return true;
            }
        });
        this.ewK = (Vibrator) getSystemService("vibrator");
        if (this.eHK == null) {
            this.eHK = new d(this, this.nDR.dtW);
            d dVar = this.eHK;
            dVar.eIs = new i(dVar.eBk);
            i iVar = dVar.eIs;
            iVar.eFk = iVar.eLn.getWindow().getAttributes().screenBrightness;
            if (iVar.eLp == null) {
                View inflate = View.inflate(iVar.eLn, 2130903243, null);
                iVar.eLq = inflate.findViewById(2131755946);
                iVar.eLr = (ImageView) inflate.findViewById(2131755947);
                iVar.eLs = (TextView) inflate.findViewById(2131755948);
                iVar.eLt = (TextView) inflate.findViewById(2131755949);
                iVar.eLu = inflate.findViewById(2131755950);
                iVar.eLv = (ImageView) inflate.findViewById(2131755953);
                iVar.eLw = (MMVerticalTextView) inflate.findViewById(2131755952);
                iVar.eLx = (MMVerticalTextView) inflate.findViewById(2131755951);
                inflate.setOnClickListener(new OnClickListener(iVar) {
                    final /* synthetic */ i eLz;

                    {
                        this.eLz = r1;
                    }

                    public final void onClick(View view) {
                        if (this.eLz.eLp != null && this.eLz.eLp.isShowing()) {
                            this.eLz.eLp.dismiss();
                        }
                    }
                });
                iVar.eLp = new o(inflate, -1, -1, true);
                iVar.eLp.update();
                iVar.eLp.setBackgroundDrawable(new ColorDrawable(16777215));
                iVar.eLp.setOnDismissListener(new OnDismissListener(iVar) {
                    final /* synthetic */ i eLz;

                    {
                        this.eLz = r1;
                    }

                    public final void onDismiss() {
                    }
                });
            }
            dVar.eIu = new f(dVar.eBk);
            dVar.eBk.nDS = dVar;
            com.tencent.mm.sdk.c.a.nhr.e(dVar.eIC);
            dVar = this.eHK;
            if (dVar.eIb == null) {
                dVar.eIb = new m();
                dVar.eIb.a(dVar);
            }
            if (dVar.eId == null) {
                dVar.eId = new com.tencent.mm.plugin.card.ui.b.j();
                dVar.eId.a(dVar);
            }
            if (dVar.eIe == null) {
                dVar.eIe = new com.tencent.mm.plugin.card.ui.b.a();
                dVar.eIe.a(dVar);
            }
            dVar.Eq = (ListView) dVar.findViewById(2131755819);
            dVar.eIh = new k(dVar.eBk.nDR.nEl);
            dVar.eIh.eLZ = dVar.eFl;
            dVar.Eq.setAdapter(dVar.eIh);
            dVar.eIh.notifyDataSetChanged();
            dVar.Eq.setOnItemClickListener(new OnItemClickListener(dVar) {
                final /* synthetic */ d eID;

                {
                    this.eID = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.eID.eBl.get(i);
                    if (bVar != null && !TextUtils.isEmpty(bVar.url)) {
                        Intent intent = new Intent();
                        if (this.eID.eBg instanceof CardInfo) {
                            intent.putExtra("key_card_info_data", (CardInfo) this.eID.eBg);
                        } else if (this.eID.eBg instanceof ShareCardInfo) {
                            intent.putExtra("key_card_info_data", (ShareCardInfo) this.eID.eBg);
                        }
                        com.tencent.mm.plugin.report.service.g gVar;
                        Object[] objArr;
                        if (bVar.url.equals("card://jump_detail")) {
                            int i2;
                            if (this.eID.eBg.Zv().mlf == null || TextUtils.isEmpty(this.eID.eBg.Zv().mlf.url)) {
                                intent.setClass(this.eID.eBk, CardDetailPreference.class);
                                this.eID.eBk.startActivity(intent);
                            } else {
                                com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, this.eID.eBg.Zv().mlf.url, 1);
                            }
                            gVar = com.tencent.mm.plugin.report.service.g.iuh;
                            objArr = new Object[9];
                            objArr[0] = "CardLeftRightIntroduceView";
                            objArr[1] = Integer.valueOf(this.eID.eBg.Zv().eBL);
                            objArr[2] = this.eID.eBg.ZA();
                            objArr[3] = this.eID.eBg.Zz();
                            objArr[4] = Integer.valueOf(0);
                            objArr[5] = Integer.valueOf(this.eID.eIB.eHT);
                            objArr[6] = this.eID.eIB.eHL;
                            if (this.eID.eBg.Zt()) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            objArr[7] = Integer.valueOf(i2);
                            objArr[8] = "";
                            gVar.h(11324, objArr);
                        } else if (bVar.url.equals("card://jump_shop_list") && this.eID.eBg.Zv().mkR > 0) {
                            d.a(this.eID);
                        } else if (!bVar.url.equals("card://jump_shop") || this.eID.eBg.Zv().mkR <= 0) {
                            if (bVar.url.equals("card://jump_service")) {
                                if (!TextUtils.isEmpty(this.eID.eBg.Zv().mkK)) {
                                    com.tencent.mm.plugin.card.b.b.M(this.eID.eBk, this.eID.eBg.Zv().mkK);
                                    af.aaq().l(this.eID.eBg.Zz(), this.eID.eBg.ZA(), 1);
                                }
                                com.tencent.mm.plugin.report.service.g.iuh.h(11582, new Object[]{"OperService", Integer.valueOf(1), Integer.valueOf(this.eID.eBg.Zv().eBL), this.eID.eBg.ZA(), this.eID.eBg.Zz(), this.eID.eIB.eHL});
                            } else if (bVar.url.equals("card://jump_gift")) {
                                d.b(this.eID);
                                r0 = this.eID;
                                if (r0.eBg.Zw().mkz == null) {
                                    v.i("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell is null");
                                } else if (r0.eBg.Zw().mkz.mnG == null) {
                                    v.e("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                                } else {
                                    com.tencent.mm.plugin.report.service.g.iuh.h(13866, new Object[]{Integer.valueOf(6), r0.eBg.Zw().mkz.mnG.lZS, com.tencent.mm.a.o.getString(r0.eBg.Zw().mkz.mnG.lZR)});
                                }
                            } else if (bVar.url.equals("card://jump_card_gift")) {
                                if (this.eID.eBg.Zw().mkz == null) {
                                    v.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell is null");
                                } else if (this.eID.eBg.Zw().mkz.mnG == null) {
                                    v.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                                } else {
                                    r0 = this.eID;
                                    v.d("MicroMsg.CardDetailUIContoller", "doJumpCardGift, order_id:%s, biz_uin:%d", new Object[]{this.eID.eBg.Zw().mkz.mnG.lZS, Integer.valueOf(this.eID.eBg.Zw().mkz.mnG.lZR)});
                                    Intent intent2 = new Intent(r0.eBk, CardGiftReceiveUI.class);
                                    intent2.putExtra("key_biz_uin", r2);
                                    intent2.putExtra("key_order_id", r1);
                                    r0.eBk.startActivity(intent2);
                                    com.tencent.mm.plugin.report.service.g.iuh.h(13866, new Object[]{Integer.valueOf(5), this.eID.eBg.Zw().mkz.mnG.lZS, com.tencent.mm.a.o.getString(this.eID.eBg.Zw().mkz.mnG.lZR)});
                                }
                            } else if ((bVar.mlB & 32) > 0) {
                                com.tencent.mm.ui.MMActivity.a aVar = this.eID;
                                com.tencent.mm.plugin.card.b.b.a(aVar.eBk, 4, aVar);
                                aVar.eBk.nDS = aVar;
                            } else {
                                com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, j.o(bVar.url, bVar.mlB), 1);
                                com.tencent.mm.plugin.report.service.g.iuh.h(11492, new Object[]{Integer.valueOf(this.eID.eIB.eHT), this.eID.eIB.eHM, this.eID.eBg.Zz(), this.eID.eBg.ZA(), Integer.valueOf(this.eID.eBg.Zw().status), r1, Integer.valueOf(this.eID.eBg.Zv().eBL), this.eID.eBg.Zv().mkK});
                                com.tencent.mm.plugin.report.service.g.iuh.h(11941, new Object[]{Integer.valueOf(6), this.eID.eBg.Zz(), this.eID.eBg.ZA(), "", bVar.title});
                                if (j.a(bVar, this.eID.eBg.Zz())) {
                                    r1 = this.eID.eBg.Zz();
                                    String str = bVar.title;
                                    j.qB(r1);
                                    com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, this.eID.eBg.Zv().eCD);
                                }
                            }
                        } else if (this.eID.eBn == null || this.eID.eBn.size() == 0) {
                            v.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                        } else {
                            ix ixVar = (ix) this.eID.eBn.get(0);
                            if (!(ixVar == null || TextUtils.isEmpty(ixVar.eDc))) {
                                com.tencent.mm.plugin.card.b.b.a(this.eID.eBk, ixVar.eDc, 1);
                                com.tencent.mm.plugin.report.service.g.iuh.h(11941, new Object[]{Integer.valueOf(4), this.eID.eBg.Zz(), this.eID.eBg.ZA(), "", ixVar.name});
                            }
                            gVar = com.tencent.mm.plugin.report.service.g.iuh;
                            objArr = new Object[9];
                            objArr[0] = "UsedStoresView";
                            objArr[1] = Integer.valueOf(this.eID.eBg.Zv().eBL);
                            objArr[2] = this.eID.eBg.ZA();
                            objArr[3] = this.eID.eBg.Zz();
                            objArr[4] = Integer.valueOf(0);
                            objArr[5] = Integer.valueOf(this.eID.eIB.eHT);
                            objArr[6] = this.eID.eIB.eHL;
                            objArr[7] = Integer.valueOf(this.eID.eBg.Zt() ? 1 : 0);
                            objArr[8] = "";
                            gVar.h(11324, objArr);
                        }
                    }
                }
            });
            dVar.dT = (LinearLayout) dVar.findViewById(2131755802);
            dVar.eIq = new com.tencent.mm.plugin.card.ui.b.d();
            dVar.eIq.a(dVar);
            dVar.eIs.eBg = dVar.eBg;
        }
        int intExtra = getIntent().getIntExtra("key_from_scene", -1);
        v.d("MicroMsg.CardDetailUI", "scene:%d", new Object[]{Integer.valueOf(intExtra)});
        String stringExtra;
        com.tencent.mm.plugin.card.model.d qo;
        if (intExtra == 2 || intExtra == 6 || intExtra == 5) {
            this.exT = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            qo = com.tencent.mm.plugin.card.b.e.qo(stringExtra);
            if (qo != null) {
                this.eAS = qo.bol;
                this.eHL = qo.eCB;
                this.eHN = qo.bom;
                int i = qo.eCE;
                v.i("MicroMsg.CardDetailUI", "scene is " + intExtra + ", isRecommend is " + i);
                if (i == 1 && intExtra == 2) {
                    this.exT = 23;
                }
                this.eHR = qo.eCF;
                v.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.eHR);
            }
            this.eHM = com.tencent.mm.plugin.card.b.e.qp(stringExtra);
        } else if (j.jk(intExtra) || intExtra == 0 || intExtra == 1 || intExtra == 3 || intExtra == 4 || intExtra == 9 || intExtra == 12 || intExtra == 15 || intExtra == 17 || intExtra == 21) {
            this.exT = intExtra;
            this.eAS = getIntent().getStringExtra("key_card_id");
            this.eHN = getIntent().getStringExtra("key_card_ext");
            this.eBT = getIntent().getBooleanExtra("key_is_share_card", false);
            this.eHv = getIntent().getIntExtra("key_stastic_scene", 0);
            this.eHy = getIntent().getStringExtra("key_consumed_card_id");
            if (intExtra == 7 || intExtra == 16) {
                this.eHw = getIntent().getStringExtra("src_username");
                this.eHx = getIntent().getStringExtra("js_url");
                this.eHB = getIntent().getStringExtra("key_template_id");
            } else if (this.eBT && intExtra == 3) {
                this.eBG = getIntent().getStringExtra("key_card_tp_id");
                this.eAS = com.tencent.mm.plugin.card.sharecard.a.b.bh(this.eAS, this.eBG);
            } else if (intExtra == 8) {
                this.eHU = getIntent().getBooleanExtra("key_is_sms_add_card", false);
            }
        } else {
            if (intExtra == 50) {
                this.exT = 3;
                String stringExtra2 = getIntent().getStringExtra("card_list");
                this.eHB = getIntent().getStringExtra("key_template_id");
                LinkedList qu = i.qu(stringExtra2);
                if (qu == null || qu.size() == 0) {
                    v.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
                    cj(true);
                } else {
                    cg(true);
                    axv com_tencent_mm_protocal_c_axv = new axv();
                    com_tencent_mm_protocal_c_axv.mVn = this.eHB;
                    v.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[]{this.eHB});
                    ak.vy().a(new com.tencent.mm.plugin.card.model.p(qu, com_tencent_mm_protocal_c_axv), 0);
                }
                abf();
            } else if (intExtra == 51) {
                this.exT = 3;
                this.eAS = getIntent().getStringExtra("key_card_id");
                this.eBg = af.aap().eAI;
                if (this.eBg == null) {
                    this.eBg = af.aak().pQ(this.eAS);
                }
                abf();
                if (this.eBg == null) {
                    v.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
                    cj(true);
                } else {
                    abi();
                    aaI();
                    abg();
                    if (this.eBg.Zp()) {
                        af.aax().pG(this.eBg.Zz());
                    }
                }
            } else {
                this.exT = intExtra;
                stringExtra = getIntent().getStringExtra("key_card_app_msg");
                qo = com.tencent.mm.plugin.card.b.e.qo(stringExtra);
                if (qo != null) {
                    this.eAS = qo.bol;
                    this.eHL = qo.eCB;
                    this.eHN = qo.bom;
                }
                this.eHM = com.tencent.mm.plugin.card.b.e.qp(stringExtra);
            }
            this.eHK.a(this.eBg, this.eHS, this.eBn);
            this.eHK.eIA = new d.b(this) {
                final /* synthetic */ CardDetailUI eHY;

                {
                    this.eHY = r1;
                }

                public final void abk() {
                    CardDetailUI.h(this.eHY);
                }

                public final void qh(String str) {
                    CardDetailUI.a(this.eHY, str);
                }

                public final void abl() {
                    CardDetailUI.i(this.eHY);
                }

                public final void abm() {
                    CardDetailUI.j(this.eHY);
                }

                public final void abn() {
                    this.eHY.cj(true);
                }

                public final void abo() {
                    ak.vy().a(new com.tencent.mm.plugin.card.sharecard.model.a(this.eHY.eAS), 0);
                }

                public final void d(b bVar) {
                    this.eHY.eBg = bVar;
                    this.eHY.eAS = bVar.Zz();
                    this.eHY.eHS.eAS = this.eHY.eAS;
                }

                public final void abj() {
                    this.eHY.abj();
                }

                public final void abp() {
                    v.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
                }

                public final void ck(boolean z) {
                    v.i("MicroMsg.CardDetailUI", "doMark()");
                    this.eHY.eHP = true;
                    this.eHY.cg(true);
                    this.eHY.eHQ = z;
                    if (this.eHY.eBg.Zo()) {
                        af.aaw().v(this.eHY.eAS, j.qC(this.eHY.eBg.ZB()), 2);
                    } else {
                        af.aaw().v(this.eHY.eAS, j.qC(this.eHY.eBg.ZB()), 1);
                    }
                }
            };
            v.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
            this.eGy = z;
            if (this.eGy) {
                this.cCR = c.FY();
                YS();
            }
        }
        abf();
        if (TextUtils.isEmpty(this.eAS)) {
            v.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
            cj(true);
        } else {
            if (intExtra == 2 || intExtra == 6 || ((intExtra == 4 && !this.eBT) || intExtra == 5 || intExtra == 17 || intExtra == 21 || intExtra == 23)) {
                z = true;
            } else if (intExtra == 15) {
                Object value = af.aap().getValue("key_accept_card_info");
                if (value == null || !(value instanceof CardInfo)) {
                    z = true;
                } else {
                    this.eBg = (CardInfo) value;
                    z = false;
                }
            } else if (this.eBT) {
                this.eBg = af.aas().qc(this.eAS);
                z = false;
            } else {
                this.eBg = af.aak().pQ(this.eAS);
                z = false;
            }
            if (z || this.eBg == null) {
                v.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.eAS + " isShareCard is " + this.eBT);
                cg(true);
                if (this.eBT) {
                    abj();
                } else {
                    abh();
                }
            } else {
                v.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.eAS);
                ix Zy = this.eBg.Zy();
                if (Zy != null) {
                    this.eBn = new ArrayList();
                    this.eBn.add(Zy);
                }
                aaI();
                if (this.eBg.Zp()) {
                    af.aax().pG(this.eBg.Zz());
                }
                if (this.eBT) {
                    this.eHV = true;
                    z = true;
                } else {
                    if (((long) ((int) (System.currentTimeMillis() / 1000))) - this.eBg.ZC() >= 86400) {
                        this.eHV = true;
                        z = true;
                    } else if (this.eBg.Zm()) {
                        this.eHV = true;
                        z = true;
                    }
                }
                if (z) {
                    v.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.eAS + " isShareCard is " + this.eBT);
                    if (this.eBT) {
                        abj();
                    } else {
                        abh();
                    }
                } else {
                    abi();
                }
                abg();
            }
        }
        this.eHK.a(this.eBg, this.eHS, this.eBn);
        this.eHK.eIA = /* anonymous class already generated */;
        v.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.eGy = z;
        if (this.eGy) {
            this.cCR = c.FY();
            YS();
        }
    }

    private void abf() {
        this.eHT = this.exT;
        this.eHS = new d.a();
        this.eHS.exT = this.exT;
        this.eHS.eHT = this.eHT;
        this.eHS.eAS = this.eAS;
        this.eHS.eHL = this.eHL;
        this.eHS.eHN = this.eHN;
        this.eHS.eHM = this.eHM;
        this.eHS.eHw = this.eHw;
        this.eHS.eHx = this.eHx;
        this.eHS.eBT = this.eBT;
    }

    private void abg() {
        int i = 1;
        if (!this.eHW && this.eBg != null) {
            this.eHW = true;
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            if (this.eBT) {
                gVar = com.tencent.mm.plugin.report.service.g.iuh;
                objArr = new Object[9];
                objArr[0] = "ShareCardDetailUI";
                objArr[1] = Integer.valueOf(this.eBg.Zv().eBL);
                objArr[2] = this.eBg.ZA();
                objArr[3] = this.eBg.Zz();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.eHT);
                objArr[6] = this.eHL;
                if (!this.eBg.Zt()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                gVar.h(11324, objArr);
                return;
            }
            gVar = com.tencent.mm.plugin.report.service.g.iuh;
            objArr = new Object[9];
            objArr[0] = "CardDetailView";
            objArr[1] = Integer.valueOf(this.eBg.Zv().eBL);
            objArr[2] = this.eBg.ZA();
            objArr[3] = this.eBg.Zz();
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(this.eHT);
            objArr[6] = this.eHL;
            if (!this.eBg.Zt()) {
                i = 0;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "";
            gVar.h(11324, objArr);
        }
    }

    private void aaI() {
        this.eHS.exT = this.exT;
        this.eHS.eHT = this.eHT;
        this.eHS.eAS = this.eAS;
        this.eHK.a(this.eBg, this.eHS, this.eBn);
        this.eHK.aaI();
        af.aav().eBg = this.eBg;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2);
        int i3;
        String str2;
        if (i == 0 && i2 == 0) {
            cg(false);
            String str3;
            b bVar;
            if (kVar instanceof w) {
                str3 = ((w) kVar).eDn;
                if (TextUtils.isEmpty(str3)) {
                    v.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
                    return;
                }
                bVar = this.eBg;
                this.eBg = new CardInfo();
                com.tencent.mm.plugin.card.b.d.a((CardInfo) this.eBg, str3);
                if (!TextUtils.isEmpty(this.eBg.Zz())) {
                    this.eAS = this.eBg.Zz();
                }
                abi();
                if (this.exT == 3) {
                    if (bVar != null) {
                        ((CardInfo) this.eBg).field_stickyAnnouncement = ((CardInfo) bVar).field_stickyAnnouncement;
                        ((CardInfo) this.eBg).field_stickyEndTime = ((CardInfo) bVar).field_stickyEndTime;
                        ((CardInfo) this.eBg).field_stickyIndex = ((CardInfo) bVar).field_stickyIndex;
                        this.eBg.a(bVar.Zy());
                    }
                    if (this.eHV) {
                        j.g(this.eBg);
                    } else {
                        v.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
                    }
                }
                aaI();
                abg();
                if (this.eBg.Zp()) {
                    af.aax().pG(this.eBg.Zz());
                    return;
                }
                return;
            } else if (kVar instanceof k) {
                str3 = ((k) kVar).eDn;
                int i4 = ((k) kVar).eDo;
                String str4 = ((k) kVar).eDp;
                if (i4 != 0) {
                    b(i2, str, i4, str4);
                } else {
                    com.tencent.mm.ui.base.g.bf(this, getResources().getString(2131231591));
                }
                if (TextUtils.isEmpty(str3)) {
                    v.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
                    return;
                }
                this.exT = 3;
                if (this.eBg == null) {
                    this.eBg = new CardInfo();
                }
                com.tencent.mm.plugin.card.b.d.a((CardInfo) this.eBg, str3);
                if (!TextUtils.isEmpty(this.eBg.Zz())) {
                    this.eAS = this.eBg.Zz();
                }
                if (this.eHK.abB() == 1) {
                    d dVar = this.eHK;
                    if (dVar.eIu != null) {
                        f fVar = dVar.eIu;
                        if (fVar.eBm != null) {
                            fVar.eBm.eBW = false;
                        }
                    }
                }
                abi();
                aaI();
                j.acG();
                b bVar2 = this.eBg;
                if (bVar2.Zc()) {
                    ak.yW();
                    r0 = (Integer) com.tencent.mm.model.c.vf().get(t.a.npQ, Integer.valueOf(0));
                    if (r0 == null || r0.intValue() != 1) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(t.a.npQ, Integer.valueOf(1));
                    }
                    if (this.eHT != 7 || this.eHT == 16) {
                        r0 = new Intent();
                        r0.putExtra("key_code", this.eBg.ZF());
                        setResult(-1, r0);
                        je(-1);
                    } else if (!this.eHU && this.eHT == 8) {
                        cj(true);
                    }
                    if (!this.eBg.Zp()) {
                        af.aax().pG(this.eBg.Zz());
                        return;
                    }
                    return;
                }
                ak.yW();
                r0 = (Integer) com.tencent.mm.model.c.vf().get(282884, null);
                if (r0 == null || r0.intValue() != 1) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(282884, Integer.valueOf(1));
                }
                if (this.eHT != 7) {
                }
                r0 = new Intent();
                r0.putExtra("key_code", this.eBg.ZF());
                setResult(-1, r0);
                je(-1);
                if (!this.eBg.Zp()) {
                    af.aax().pG(this.eBg.Zz());
                    return;
                }
                return;
                if (j.acJ()) {
                    com.tencent.mm.plugin.card.b.c.c(this, 2130903257, 2131231588, bVar2.Zv().eCC);
                } else {
                    com.tencent.mm.plugin.card.b.c.c(this, 2130903256, 2131231587, bVar2.Zv().eCC);
                }
                if (this.eHT != 7) {
                }
                r0 = new Intent();
                r0.putExtra("key_code", this.eBg.ZF());
                setResult(-1, r0);
                je(-1);
                if (!this.eBg.Zp()) {
                    af.aax().pG(this.eBg.Zz());
                    return;
                }
                return;
            } else if (kVar instanceof r) {
                this.eBn = ((r) kVar).eDw;
                if (this.eBg != null && this.eBn != null && this.eBn.size() > 0) {
                    this.eBg.a((ix) this.eBn.get(0));
                    aaI();
                    if (this.eBg.Zb()) {
                        ShareCardInfo qc = af.aas().qc(this.eAS);
                        if (qc != null) {
                            qc.a((ix) this.eBn.get(0));
                            af.aas().a(qc, new String[]{this.eAS});
                            return;
                        }
                        return;
                    }
                    CardInfo pQ = af.aak().pQ(this.eAS);
                    if (pQ != null) {
                        pQ.a((ix) this.eBn.get(0));
                        af.aak().a(pQ, new String[]{this.eAS});
                        return;
                    }
                    return;
                } else if (this.eBg != null && this.eBn == null) {
                    this.eBg.a(null);
                    aaI();
                    if (this.eBg.Zb()) {
                        r0 = af.aas().qc(this.eAS);
                        if (r0 != null) {
                            r0.a(null);
                            af.aas().a(r0, new String[]{this.eAS});
                            return;
                        }
                        return;
                    }
                    CardInfo pQ2 = af.aak().pQ(this.eAS);
                    if (pQ2 != null) {
                        pQ2.a(null);
                        af.aak().a(pQ2, new String[]{this.eAS});
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } else if (kVar instanceof aa) {
                i3 = ((aa) kVar).eDo;
                str2 = ((aa) kVar).eDp;
                if (i3 == 10000) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = getString(2131231626);
                    }
                    com.tencent.mm.plugin.card.b.c.b(this, str2);
                    return;
                }
                this.eHN = ((aa) kVar).bom;
                ci(true);
                iu Zw = this.eBg.Zw();
                Zw.status = 3;
                this.eBg.a(Zw);
                j.g(this.eBg);
                aaI();
                if (this.eHT == 3) {
                    cj(true);
                    return;
                } else if (this.eHT == 15) {
                    com.tencent.mm.sdk.c.a.nhr.z(new my());
                    return;
                } else {
                    return;
                }
            } else if (kVar instanceof n) {
                com.tencent.mm.ui.base.g.bf(this, getResources().getString(2131231610));
                af.aaj();
                com.tencent.mm.plugin.card.a.b.iS(4);
                cj(true);
                return;
            } else if (kVar instanceof com.tencent.mm.plugin.card.model.p) {
                LinkedList linkedList = ((com.tencent.mm.plugin.card.model.p) kVar).eDu;
                if (linkedList != null && linkedList.size() > 0) {
                    this.eBg = (b) linkedList.get(0);
                    if (this.eBg != null) {
                        this.eAS = this.eBg.Zz();
                        abi();
                        if (this.eBg.Zp()) {
                            af.aax().pG(this.eBg.Zz());
                        }
                    }
                    aaI();
                }
                abg();
                j.acG();
                return;
            } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
                str3 = ((com.tencent.mm.plugin.card.sharecard.model.g) kVar).eDn;
                int i5 = ((com.tencent.mm.plugin.card.sharecard.model.g) kVar).eDo;
                str2 = ((com.tencent.mm.plugin.card.sharecard.model.g) kVar).eDp;
                if (i5 != 0) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = getString(2131231579);
                    }
                    com.tencent.mm.plugin.card.b.c.b(this, str2);
                } else {
                    com.tencent.mm.ui.base.g.bf(this, getResources().getString(2131231583));
                }
                if (TextUtils.isEmpty(str3)) {
                    v.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
                    return;
                }
                this.exT = 3;
                if (this.eBg == null) {
                    this.eBg = new ShareCardInfo();
                } else if (this.eBg instanceof CardInfo) {
                    this.eBg = new ShareCardInfo();
                }
                com.tencent.mm.plugin.card.b.d.a((ShareCardInfo) this.eBg, str3);
                r0 = (ShareCardInfo) this.eBg;
                if (TextUtils.isEmpty(str3)) {
                    v.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
                } else {
                    try {
                        JSONArray optJSONArray = new JSONObject(str3).optJSONArray("card_list");
                        if (optJSONArray != null) {
                            r0.eBP = optJSONArray.optJSONObject(0).optString("encrypt_code");
                            v.i("MicroMsg.CardInfoParser", "encrypt_code:" + r0.eBP);
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.CardInfoParser", e, "", new Object[0]);
                        v.e("MicroMsg.CardInfoParser", e.getMessage());
                    }
                }
                if (!TextUtils.isEmpty(this.eBg.Zz())) {
                    this.eAS = this.eBg.Zz();
                }
                if (TextUtils.isEmpty(this.eBg.ZB())) {
                    ((ShareCardInfo) this.eBg).field_from_username = com.tencent.mm.model.k.xF();
                }
                j.a((ShareCardInfo) this.eBg);
                af.aar().Yj();
                abi();
                aaI();
                j.acI();
                if (this.eHT == 7 || this.eHT == 16) {
                    r0 = new Intent();
                    r0.putExtra("key_code", this.eBg.ZF());
                    setResult(-1, r0);
                    je(-1);
                } else if (!this.eHU && this.eHT == 8) {
                    cj(true);
                }
                ak.yW();
                r0 = (Integer) com.tencent.mm.model.c.vf().get(t.a.npO, Integer.valueOf(0));
                if (r0 == null || r0.intValue() != 1) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.npO, Integer.valueOf(1));
                    com.tencent.mm.plugin.card.b.c.c(this, 2130903259, 2131231690, "");
                }
                if (this.eBg.Zp()) {
                    af.aax().pG(this.eBg.Zz());
                    return;
                }
                return;
            } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.c) {
                Object obj = ((com.tencent.mm.plugin.card.sharecard.model.c) kVar).eDn;
                if (TextUtils.isEmpty(obj)) {
                    v.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
                    return;
                }
                bVar = this.eBg;
                this.eBg = new ShareCardInfo();
                r0 = (ShareCardInfo) this.eBg;
                if (TextUtils.isEmpty(obj)) {
                    v.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
                } else {
                    try {
                        com.tencent.mm.plugin.card.b.d.a(r0, new JSONObject(obj));
                    } catch (Throwable e2) {
                        v.a("MicroMsg.CardInfoParser", e2, "", new Object[0]);
                    }
                }
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.ZB())) {
                        ((ShareCardInfo) this.eBg).field_from_username = ((ShareCardInfo) bVar).field_from_username;
                    }
                    ((ShareCardInfo) this.eBg).field_app_id = ((ShareCardInfo) bVar).field_app_id;
                    ((ShareCardInfo) this.eBg).field_consumer = ((ShareCardInfo) bVar).field_consumer;
                    ((ShareCardInfo) this.eBg).field_share_time = ((ShareCardInfo) bVar).field_share_time;
                    ((ShareCardInfo) this.eBg).field_updateTime = ((ShareCardInfo) bVar).field_updateTime;
                    ((ShareCardInfo) this.eBg).field_begin_time = ((ShareCardInfo) bVar).field_begin_time;
                    ((ShareCardInfo) this.eBg).field_end_time = ((ShareCardInfo) bVar).field_end_time;
                    ((ShareCardInfo) this.eBg).field_block_mask = ((ShareCardInfo) bVar).field_block_mask;
                    this.eBg.a(bVar.Zy());
                    ((ShareCardInfo) this.eBg).field_categoryType = ((ShareCardInfo) bVar).field_categoryType;
                    ((ShareCardInfo) this.eBg).field_itemIndex = ((ShareCardInfo) bVar).field_itemIndex;
                    if (((ShareCardInfo) bVar).field_status != ((ShareCardInfo) this.eBg).field_status) {
                        v.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo) this.eBg).field_status);
                        com.tencent.mm.plugin.card.sharecard.a.b.a((Context) this, this.eBg);
                    }
                }
                if (!TextUtils.isEmpty(this.eBg.Zz())) {
                    this.eAS = this.eBg.Zz();
                }
                aaI();
                abi();
                abg();
                if (this.exT == 3) {
                    if (this.eHV) {
                        j.g(this.eBg);
                    } else {
                        v.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
                    }
                }
                if (this.eBg.Zp()) {
                    af.aax().pG(this.eBg.Zz());
                    return;
                }
                return;
            } else if (!(kVar instanceof com.tencent.mm.plugin.card.sharecard.model.a)) {
                return;
            } else {
                if (((com.tencent.mm.plugin.card.sharecard.model.a) kVar).eDo != 0) {
                    com.tencent.mm.plugin.card.b.c.b(this, getString(2131231608));
                    return;
                }
                v.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.eBg.Zz());
                com.tencent.mm.plugin.card.sharecard.a.b.a((Context) this, this.eBg);
                com.tencent.mm.ui.base.g.bf(this, getResources().getString(2131231610));
                af.aar().aay();
                cj(true);
                return;
            }
        }
        v.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + kVar.getType());
        cg(false);
        if (kVar instanceof aa) {
            ci(false);
            i3 = ((aa) kVar).eDo;
            str2 = ((aa) kVar).eDp;
            if (i3 == 10000) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(2131231626);
                }
            }
            str2 = str;
        } else if (kVar instanceof k) {
            je(0);
            b(i2, str, ((k) kVar).eDo, ((k) kVar).eDp);
            return;
        } else {
            if (kVar instanceof r) {
                return;
            }
            str2 = str;
        }
        com.tencent.mm.plugin.card.b.c.b(this, str2);
    }

    private void b(int i, String str, int i2, String str2) {
        v.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + i + " errMsg = " + str + " ret_code:" + i2 + " ret_msg:" + str2);
        if (i2 == 10000) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(2131231580);
            }
            this.eBg.Zw().status = 4;
            aaI();
        } else if (i2 == 10001) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(2131231584);
            }
            this.eBg.Zw().status = 5;
            aaI();
        } else if (i2 == 10002) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(2131231660);
            }
        } else if (TextUtils.isEmpty(str2)) {
            str2 = getString(2131231578);
        }
        com.tencent.mm.plugin.card.b.c.b(this, str2);
    }

    private void cg(boolean z) {
        if (z) {
            this.dFI = p.b(this, getString(2131233521), true, 0, null);
        } else if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
            this.dFI = null;
        }
    }

    private void ci(boolean z) {
        if (z) {
            j.bk(this.eHK.eIw, this.eHK.eIv);
        }
    }

    private void abh() {
        axv com_tencent_mm_protocal_c_axv = new axv();
        com_tencent_mm_protocal_c_axv.mVn = this.eHB;
        com_tencent_mm_protocal_c_axv.eCF = this.eHR;
        v.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[]{this.eHB});
        ak.vy().a(new w(this.eAS, this.exT, this.eHL, this.eHN, this.eHw, this.eHx, this.eHv, this.eHy, com_tencent_mm_protocal_c_axv), 0);
    }

    private void abi() {
        String ZA;
        if (!TextUtils.isEmpty(this.eBg.ZA())) {
            ZA = this.eBg.ZA();
        } else if (TextUtils.isEmpty(this.eAS)) {
            v.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
            return;
        } else {
            ZA = this.eAS;
        }
        if (this.eBg != null && this.eBg.Zv().mkR == 1) {
            float f = this.bYf;
            float f2 = this.bYg;
            if (f == -1000.0f || f2 == -1000.0f) {
                f = af.aaq().bYf;
                f2 = af.aaq().bYg;
            }
            ak.vy().a(new r(ZA, f2, f, this.eBg.Zz()), 0);
        } else if (this.eBg == null || this.eBg.Zv().mkR <= 1) {
            if (this.eBg != null) {
                this.eBg.a(null);
                aaI();
                if (this.eBg.Zb()) {
                    ShareCardInfo qc = af.aas().qc(this.eAS);
                    if (qc != null) {
                        qc.a(null);
                        af.aas().a(qc, new String[]{this.eAS});
                        return;
                    }
                    return;
                }
                CardInfo pQ = af.aak().pQ(this.eAS);
                if (pQ != null) {
                    pQ.a(null);
                    af.aak().a(pQ, new String[]{this.eAS});
                }
            }
        } else if (this.bYf != -1000.0f && this.bYg != -1000.0f) {
            this.eHX = false;
            ak.vy().a(new r(ZA, this.bYg, this.bYf, this.eBg.Zz()), 0);
        } else if (!this.eHX) {
            this.eHX = true;
            if (this.eGy) {
                YS();
            }
        }
    }

    private void abj() {
        ak.vy().a(new com.tencent.mm.plugin.card.sharecard.model.c(this.eAS), 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            v.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
            cj(false);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cj(boolean z) {
        if ((this.eHT == 7 || this.eHT == 8 || this.eHT == 16) && this.exT == 3) {
            Intent intent = new Intent();
            intent.putExtra("key_code", this.eBg.ZF());
            setResult(-1, intent);
            if (z) {
                finish();
            }
        } else if ((this.eHT == 7 && this.exT == 7) || ((this.eHT == 16 && this.exT == 16) || (this.eHT == 8 && this.exT == 8))) {
            setResult(0);
            if (z) {
                finish();
            }
        } else if (z) {
            finish();
        }
    }

    private void je(int i) {
        if (this.eHT == 7 || this.eHT == 16) {
            LinkedList linkedList = new LinkedList();
            com.tencent.mm.plugin.card.model.e eVar = new com.tencent.mm.plugin.card.model.e();
            eVar.eBK = this.eBg.ZA();
            eVar.bom = this.eHN;
            eVar.code = this.eBg.ZF();
            linkedList.add(eVar);
            com.tencent.mm.e.a.b bVar = new com.tencent.mm.e.a.b();
            bVar.aWk.aKK = i;
            if (i == -1) {
                bVar.aWk.aWl = com.tencent.mm.plugin.card.b.f.a(linkedList, true, this.eHT);
            } else {
                bVar.aWk.aWl = com.tencent.mm.plugin.card.b.f.a(linkedList, false, this.eHT);
            }
            com.tencent.mm.sdk.c.a.nhr.z(bVar);
            return;
        }
        v.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
    }

    private void YS() {
        if (this.cCR == null) {
            this.cCR = c.FY();
        }
        this.cCR.a(this.bYl, true);
    }

    private void YU() {
        if (this.cCR != null) {
            this.cCR.c(this.bYl);
        }
    }

    private void aaR() {
        this.cCR = c.FY();
        YS();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.CardDetailUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case q.CTRL_INDEX /*69*/:
                if (iArr[0] == 0) {
                    v.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.eGy);
                    if (!this.eGy) {
                        this.eGy = true;
                        aaR();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ CardDetailUI eHY;

                    {
                        this.eHY = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.eHY.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            default:
                return;
        }
    }

    private synchronized void pH(String str) {
        if (this.eFA) {
            v.e("MicroMsg.CardDetailUI", "has start CardConsumeSuccessUI!");
        } else {
            v.i("MicroMsg.CardDetailUI", "startConsumedSuccUI() ");
            this.eFA = true;
            Intent intent = new Intent(this, CardConsumeSuccessUI.class);
            intent.putExtra("KEY_CARD_ID", this.eBg.Zz());
            intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
            intent.putExtra("KEY_CARD_COLOR", this.eBg.Zv().coN);
            intent.putExtra("key_stastic_scene", this.exT);
            intent.putExtra("key_from_scene", 0);
            startActivity(intent);
        }
    }

    public final void f(b bVar) {
        if (bVar == null) {
            v.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
        } else if (this.eBg == null || !this.eBg.Zz().equals(bVar.Zz())) {
            v.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
        } else if (this.eHK.abC()) {
            v.i("MicroMsg.CardDetailUI", "onDataChange");
            this.eBg = bVar;
            this.eAS = this.eBg.Zz();
            if (this.eBg.Zp() && af.aax().isEmpty()) {
                af.aax().pG(this.eBg.Zz());
            }
            aaI();
        } else {
            v.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
        }
    }

    public final void ZS() {
        v.i("MicroMsg.CardDetailUI", "onVibrate");
        this.ewK.vibrate(300);
    }

    public final void ZT() {
        v.i("MicroMsg.CardDetailUI", "onFinishUI");
    }

    public final void pI(final String str) {
        if (this.eHK.abC()) {
            v.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ CardDetailUI eHY;

                public final void run() {
                    this.eHY.pH(str);
                }
            });
            return;
        }
        v.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
    }

    public final void b(String str, g.b bVar) {
        if (TextUtils.isEmpty(str) || str.equals(this.eAS)) {
            cg(false);
            v.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
            v.i("MicroMsg.CardDetailUI", "markSucc:" + bVar.eBx + " markCardId: " + bVar.eBy);
            this.eHP = false;
            if (bVar.eBx != 1) {
                this.eHO = false;
                com.tencent.mm.plugin.card.b.c.b(this, getString(2131231645));
                return;
            } else if (TextUtils.isEmpty(bVar.eBy) || this.eBg.Zz().equals(bVar.eBy)) {
                v.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
                this.eHO = true;
                a(bVar);
                return;
            } else {
                v.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
                if (this.eBg.Zb()) {
                    b qc = af.aas().qc(bVar.eBy);
                    if (qc != null) {
                        this.eBg = qc;
                        this.eAS = bVar.eBy;
                        aaI();
                        af.aav().d(this.eBg);
                        v.i("MicroMsg.CardDetailUI", "update the mCardInfo");
                        this.eHO = true;
                        a(bVar);
                        return;
                    }
                    v.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
                    com.tencent.mm.plugin.card.b.c.b(this, getString(2131231644));
                    this.eHO = false;
                    return;
                }
                return;
            }
        }
        v.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
    }

    public final void be(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.equals(this.eAS)) {
            v.i("MicroMsg.CardDetailUI", "onMarkFail()");
            this.eHO = false;
            this.eHP = false;
            cg(false);
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(2131231644);
            }
            com.tencent.mm.plugin.card.b.c.b(this, str2);
            return;
        }
        v.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
    }

    public final void pL(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.eAS)) {
            this.eHO = false;
        } else {
            v.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
        }
    }

    private void a(g.b bVar) {
        if (this.eHK.beg) {
            v.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
            return;
        }
        v.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
        this.eHK.a(this.eHQ, bVar, true);
    }

    public final void ZN() {
        v.i("MicroMsg.CardDetailUI", "code change");
    }

    public final void pF(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.tencent.mm.plugin.card.b.c.a(this, str, true);
        }
    }

    public final void onSuccess() {
        v.i("MicroMsg.CardDetailUI", "code get success");
    }
}
