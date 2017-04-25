package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.l;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.protocal.c.auo;
import com.tencent.mm.protocal.c.auw;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CardAcceptCardListUI extends MMActivity implements a, e {
    int bon = 8;
    private p dFI = null;
    protected ListView eAA = null;
    protected RelativeLayout eAC = null;
    private boolean eBT = false;
    private String eDA;
    private int eDB;
    private String eDC;
    private String eDy = "";
    private int eDz;
    private Button eFH;
    public int eFO = 0;
    private String eFP = "";
    private String eFQ = "";
    public ArrayList<String> eFR = new ArrayList();
    public ArrayList<String> eFS = new ArrayList();
    LinkedList<String> eHA = new LinkedList();
    private String eHB = "";
    HashMap<String, Integer> eHg = new HashMap();
    private View eHm;
    private View eHn;
    private View eHo;
    protected a eHp = null;
    private View eHq;
    private View eHr;
    private TextView eHs;
    private Button eHt;
    LinkedList<iv> eHu = new LinkedList();
    int eHv = 7;
    String eHw = "";
    String eHx = "";
    private String eHy = "";
    LinkedList<iv> eHz = new LinkedList();

    static /* synthetic */ void a(CardAcceptCardListUI cardAcceptCardListUI, LinkedList linkedList) {
        cardAcceptCardListUI.cg(true);
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            iv ivVar = (iv) linkedList.get(i);
            auo com_tencent_mm_protocal_c_auo = new auo();
            com_tencent_mm_protocal_c_auo.eBK = ivVar.eBK;
            com_tencent_mm_protocal_c_auo.bom = ivVar.bom;
            com_tencent_mm_protocal_c_auo.lZM = cardAcceptCardListUI.eHw;
            com_tencent_mm_protocal_c_auo.lZL = cardAcceptCardListUI.eHx;
            com_tencent_mm_protocal_c_auo.lZN = cardAcceptCardListUI.eHv;
            linkedList2.add(com_tencent_mm_protocal_c_auo);
        }
        auw a = j.a(cardAcceptCardListUI.eFO, cardAcceptCardListUI.eFR, cardAcceptCardListUI.eFS);
        axv com_tencent_mm_protocal_c_axv = new axv();
        com_tencent_mm_protocal_c_axv.mVn = cardAcceptCardListUI.eHB;
        ak.vy().a(new g(0, linkedList2, "", cardAcceptCardListUI.eHy, a, cardAcceptCardListUI.bon, com_tencent_mm_protocal_c_axv), 0);
    }

    static /* synthetic */ LinkedList b(CardAcceptCardListUI cardAcceptCardListUI) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardAcceptCardListUI.eHu.size(); i++) {
            linkedList.add(cardAcceptCardListUI.eHu.get(i));
        }
        return linkedList;
    }

    static /* synthetic */ void c(CardAcceptCardListUI cardAcceptCardListUI) {
        v.i("MicroMsg.CardAcceptCardListUI", "doSelectShareUser");
        com.tencent.mm.plugin.report.service.g.iuh.h(11582, new Object[]{"OpenShareUserSelectView", Integer.valueOf(0), "", "", "", ""});
        Intent intent = new Intent();
        intent.putExtra("KLabel_range_index", cardAcceptCardListUI.eFO);
        intent.putExtra("Klabel_name_list", cardAcceptCardListUI.eFP);
        intent.putExtra("Kother_user_name_list", cardAcceptCardListUI.eFQ);
        intent.putExtra("k_sns_label_ui_title", cardAcceptCardListUI.getString(2131231686));
        intent.putExtra("k_sns_label_ui_style", 0);
        intent.putExtra("Ktag_rangeFilterprivate", true);
        c.b(cardAcceptCardListUI, "sns", ".ui.SnsLabelUI", intent, 2);
        cardAcceptCardListUI.nDS = cardAcceptCardListUI;
    }

    protected final int getLayoutId() {
        return 2130903200;
    }

    protected final void NI() {
        vD(2131231577);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardAcceptCardListUI eHC;

            {
                this.eHC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                v.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
                this.eHC.jd(1);
                return true;
            }
        });
        this.eHm = findViewById(2131755722);
        this.eHn = findViewById(2131755723);
        this.eHo = findViewById(2131755724);
        this.eHn.setVisibility(4);
        this.eAA = (ListView) findViewById(16908298);
        this.eAC = (RelativeLayout) findViewById(2131755725);
        this.eAA.setEmptyView(this.eAC);
        this.eHp = new a(this);
        this.eAA.setAdapter(this.eHp);
        this.eAA.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardAcceptCardListUI eHC;

            {
                this.eHC = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.eHq = findViewById(2131755727);
        this.eFH = (Button) findViewById(2131755728);
        this.eFH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CardAcceptCardListUI eHC;

            {
                this.eHC = r1;
            }

            public final void onClick(View view) {
                if (this.eHC.eBT) {
                    CardAcceptCardListUI.a(this.eHC, CardAcceptCardListUI.b(this.eHC));
                    return;
                }
                CardAcceptCardListUI cardAcceptCardListUI = this.eHC;
                LinkedList b = CardAcceptCardListUI.b(this.eHC);
                cardAcceptCardListUI.cg(true);
                ak.vy().a(new l(b, cardAcceptCardListUI.bon, cardAcceptCardListUI.eHw, cardAcceptCardListUI.eHx, cardAcceptCardListUI.eHv), 0);
            }
        });
        this.eFH.setEnabled(false);
        this.eHr = findViewById(2131755729);
        this.eHs = (TextView) findViewById(2131755730);
        this.eHt = (Button) findViewById(2131755731);
        this.eHt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CardAcceptCardListUI eHC;

            {
                this.eHC = r1;
            }

            public final void onClick(View view) {
                CardAcceptCardListUI.c(this.eHC);
            }
        });
        Intent intent = getIntent();
        if (intent == null) {
            v.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
            jd(2);
            return;
        }
        v.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.bon = intent.getIntExtra("key_from_scene", 8);
        String stringExtra2 = intent.getStringExtra("key_package_name");
        String stringExtra3 = intent.getStringExtra("key_sign");
        this.eHv = getIntent().getIntExtra("key_stastic_scene", 7);
        this.eHw = getIntent().getStringExtra("src_username");
        this.eHx = getIntent().getStringExtra("js_url");
        this.eHy = getIntent().getStringExtra("key_consumed_card_id");
        this.eHB = getIntent().getStringExtra("key_template_id");
        Collection al = f.al(stringExtra, this.bon);
        if (al == null || al.size() == 0) {
            v.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
            jd(2);
            return;
        }
        this.eHu.clear();
        this.eHu.addAll(al);
        this.eHz.clear();
        this.eHA.clear();
        this.eHg.clear();
        LinkedList linkedList = this.eHu;
        cg(true);
        ak.vy().a(new x(linkedList, this.bon, stringExtra2, stringExtra3, this.eHw, this.eHx, this.eHy, this.eHv), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(690, this);
        ak.vy().a(687, this);
        ak.vy().a(902, this);
        NI();
    }

    protected void onDestroy() {
        ak.vy().b(690, this);
        ak.vy().b(687, this);
        ak.vy().b(902, this);
        this.eHu.clear();
        a aVar = this.eHp;
        aVar.eGh.clear();
        aVar.mContext = null;
        super.onDestroy();
    }

    void cg(boolean z) {
        if (z) {
            this.dFI = p.b(this, getString(2131233521), false, 0, null);
        } else if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
            this.dFI = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            v.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + kVar.getType() + "errType = " + i + " errCode = " + i2);
            cg(false);
            com.tencent.mm.plugin.card.b.c.b(this, str, i2);
            if (kVar instanceof l) {
                this.eDy = str;
            } else if (kVar instanceof g) {
                this.eDy = "";
            }
        } else if (kVar instanceof x) {
            cg(false);
            x xVar = (x) kVar;
            r0 = xVar.eDn;
            this.eDz = xVar.eDz;
            this.eDA = xVar.eDA;
            this.eDB = xVar.eDB;
            this.eDC = xVar.eDC;
            v.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.eDz + "  accept_button_wording: " + this.eDA);
            v.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.eDB + "  private_wording: " + this.eDC);
            List qm = d.qm(r0);
            Collection ab = ab(qm);
            if (qm == null || qm.size() <= 0) {
                v.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
            } else {
                v.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + qm.size());
                if (ab != null && ab.size() > 0) {
                    a aVar = this.eHp;
                    Map map = this.eHg;
                    if (ab != null) {
                        aVar.eGh.clear();
                        aVar.eGh.addAll(ab);
                        aVar.eHg.putAll(map);
                    }
                }
                this.eHp.notifyDataSetChanged();
                if (((CardInfo) qm.get(0)).Zb()) {
                    this.eBT = true;
                }
            }
            this.eHn.setVisibility(0);
            if (this.eHp.getCount() > 0) {
                Drawable bs;
                CardInfo jc = this.eHp.jc(0);
                com.tencent.mm.plugin.card.b.k.a(this, jc);
                this.eHm.setBackgroundColor(j.qv(jc.Zv().coN));
                this.eHq.setVisibility(0);
                Drawable stateListDrawable = new StateListDrawable();
                r2 = getResources().getDimensionPixelOffset(2131493367);
                if (this.eDz == 1) {
                    this.eFH.setEnabled(true);
                    bs = j.bs(j.qv(jc.Zv().coN), r2);
                    int[] iArr = new int[]{16842919};
                    stateListDrawable.addState(iArr, j.bs(j.am(jc.Zv().coN, 175), r2));
                    stateListDrawable.addState(new int[0], bs);
                } else {
                    this.eFH.setEnabled(false);
                    stateListDrawable.addState(new int[0], j.bs(j.am(jc.Zv().coN, 175), r2));
                }
                this.eFH.setBackgroundDrawable(stateListDrawable);
                if (!TextUtils.isEmpty(this.eDA)) {
                    this.eFH.setText(this.eDA);
                }
                if (this.eDB == 1) {
                    int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131493168);
                    Drawable c = j.c(this, getResources().getColor(2131690127), dimensionPixelOffset);
                    stateListDrawable = j.bs(getResources().getColor(2131690127), dimensionPixelOffset);
                    bs = new StateListDrawable();
                    bs.addState(new int[]{16842919}, stateListDrawable);
                    bs.addState(new int[0], c);
                    this.eHt.setBackgroundDrawable(bs);
                    int[] iArr2 = new int[]{j.qv(jc.Zv().coN), getResources().getColor(2131690127)};
                    this.eHt.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr2));
                    this.eHr.setVisibility(0);
                    if (TextUtils.isEmpty(this.eDC)) {
                        this.eHs.setText(2131231683);
                        return;
                    } else {
                        this.eHs.setText(this.eDC);
                        return;
                    }
                }
                this.eHr.setVisibility(8);
                LayoutParams layoutParams = (LayoutParams) this.eHn.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(2131493199);
                layoutParams.bottomMargin = getResources().getDimensionPixelSize(2131493139);
                this.eHn.setLayoutParams(layoutParams);
                this.eHn.invalidate();
                layoutParams = (LayoutParams) this.eHq.getLayoutParams();
                layoutParams.addRule(8, 2131755724);
                this.eHq.setLayoutParams(layoutParams);
                this.eHq.invalidate();
                return;
            }
            this.eHq.setVisibility(8);
            this.eHr.setVisibility(8);
            this.eHm.setBackgroundColor(getResources().getColor(2131689900));
        } else if (kVar instanceof l) {
            cg(false);
            l lVar = (l) kVar;
            if (lVar.eDo != 0) {
                r0 = lVar.eDp;
                if (TextUtils.isEmpty(r0)) {
                    r0 = getString(2131231592);
                }
                com.tencent.mm.ui.base.g.a(this, r0, null, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ CardAcceptCardListUI eHC;

                    {
                        this.eHC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.eHC.jd(2);
                    }
                });
                this.eDy = lVar.eDn;
                return;
            }
            com.tencent.mm.ui.base.g.bf(this, getResources().getString(2131231630));
            r0 = new Intent();
            r0.putExtra("card_list", lVar.eDn);
            setResult(-1, r0);
            v.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
            j.acG();
            finish();
        } else if (kVar instanceof g) {
            cg(false);
            String str2 = ((g) kVar).eDn;
            r2 = ((g) kVar).eDo;
            r0 = ((g) kVar).eDp;
            this.eDy = str2;
            if (r2 != 0) {
                if (TextUtils.isEmpty(r0)) {
                    r0 = getString(2131231694);
                }
                com.tencent.mm.ui.base.g.a(this, r0, null, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ CardAcceptCardListUI eHC;

                    {
                        this.eHC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.eHC.jd(2);
                    }
                });
                return;
            }
            com.tencent.mm.ui.base.g.bf(this, getResources().getString(2131231583));
            r0 = new Intent();
            r0.putExtra("card_list", this.eDy);
            setResult(-1, r0);
            v.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
            j.acI();
            ShareCardInfo shareCardInfo = new ShareCardInfo();
            d.a(shareCardInfo, str2);
            j.a(shareCardInfo);
            af.aar().Yj();
            finish();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            v.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
            jd(1);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void jd(int i) {
        v.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:" + i);
        Intent intent = new Intent();
        intent.putExtra("card_list", this.eDy);
        intent.putExtra("result_code", i);
        setResult(0, intent);
        finish();
    }

    public final void a(int i, int i2, Intent intent) {
        switch (i) {
            case 2:
                if (i2 == -1) {
                    this.eFO = intent.getIntExtra("Ktag_range_index", 0);
                    v.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.eFO)});
                    if (this.eFO >= 2) {
                        this.eFP = intent.getStringExtra("Klabel_name_list");
                        this.eFQ = intent.getStringExtra("Kother_user_name_list");
                        v.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.eFO), this.eFP});
                        if (TextUtils.isEmpty(this.eFP) && TextUtils.isEmpty(this.eFQ)) {
                            v.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
                            aaY();
                            return;
                        }
                        List asList = Arrays.asList(this.eFP.split(","));
                        this.eFS = j.ae(asList);
                        this.eFR = j.ad(asList);
                        if (this.eFQ != null && this.eFQ.length() > 0) {
                            this.eFR.addAll(Arrays.asList(this.eFQ.split(",")));
                        }
                        if (this.eFS != null) {
                            v.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.eFS.size());
                        }
                        if (this.eFR != null) {
                            v.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.eFR.size());
                            Iterator it = this.eFR.iterator();
                            while (it.hasNext()) {
                                v.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (TextUtils.isEmpty(this.eFP)) {
                            aaY();
                            return;
                        } else if (this.eFO == 2) {
                            this.eHs.setText(getString(2131231685, new Object[]{aaK()}));
                            return;
                        } else if (this.eFO == 3) {
                            this.eHs.setText(getString(2131231684, new Object[]{aaK()}));
                            return;
                        } else {
                            return;
                        }
                    }
                    aaY();
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

    private void aaY() {
        if (TextUtils.isEmpty(this.eDC)) {
            this.eHs.setText(2131231683);
        } else {
            this.eHs.setText(this.eDC);
        }
    }

    private ArrayList<CardInfo> ab(List<CardInfo> list) {
        if (list == null || list.size() == 0) {
            v.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
            return null;
        }
        this.eHz.clear();
        this.eHA.clear();
        this.eHg.clear();
        ArrayList<CardInfo> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            CardInfo cardInfo = (CardInfo) list.get(i);
            if (this.eHA.contains(cardInfo.field_card_tp_id)) {
                this.eHg.put(cardInfo.field_card_tp_id, Integer.valueOf(((Integer) this.eHg.get(cardInfo.field_card_tp_id)).intValue() + 1));
            } else {
                arrayList.add(cardInfo);
                this.eHg.put(cardInfo.field_card_tp_id, Integer.valueOf(1));
                this.eHA.add(cardInfo.field_card_tp_id);
            }
        }
        return arrayList;
    }
}
