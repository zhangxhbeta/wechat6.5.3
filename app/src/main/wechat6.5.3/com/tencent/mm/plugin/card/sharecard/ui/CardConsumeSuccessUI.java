package com.tencent.mm.plugin.card.sharecard.ui;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.ae.n;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.bi;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.b.o;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.d;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.protocal.c.auo;
import com.tencent.mm.protocal.c.auw;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardConsumeSuccessUI extends MMActivity implements e {
    private View Hq;
    private final String TAG = "MicroMsg.CardConsumeSuccessUI";
    private p dFI = null;
    private String eAS = "";
    private String eBG = "";
    private TextView eFC;
    private TextView eFD;
    private TextView eFE;
    private TextView eFF;
    private ImageView eFG;
    private Button eFH;
    private CheckBox eFI;
    private j eFJ;
    private String eFK = "";
    private String eFL = "";
    int eFM = 0;
    int eFN = 0;
    public int eFO = 0;
    private String eFP = "";
    private String eFQ = "";
    public ArrayList<String> eFR = new ArrayList();
    public ArrayList<String> eFS = new ArrayList();
    ac eFT = new ac(Looper.getMainLooper());
    private OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ CardConsumeSuccessUI eFU;

        {
            this.eFU = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == 2131755782) {
                CardConsumeSuccessUI.a(this.eFU);
            } else if (view.getId() == 2131755784) {
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", this.eFU.eFO);
                intent.putExtra("Klabel_name_list", this.eFU.eFP);
                intent.putExtra("Kother_user_name_list", this.eFU.eFQ);
                intent.putExtra("k_sns_label_ui_title", this.eFU.getString(2131231686));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("Ktag_rangeFilterprivate", true);
                c.b(this.eFU, "sns", ".ui.SnsLabelUI", intent, 1);
            }
        }
    };
    private TextView eFq;
    private TextView eFr;
    private long mStartTime = 0;

    static /* synthetic */ void a(CardConsumeSuccessUI cardConsumeSuccessUI) {
        if (cardConsumeSuccessUI.eFJ == null || cardConsumeSuccessUI.eFJ.eEz == null || cardConsumeSuccessUI.eFJ.eEz.isEmpty()) {
            v.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list == null || mConsumedInfo.list.isEmpty()!");
            return;
        }
        cardConsumeSuccessUI.cg(true);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardConsumeSuccessUI.eFJ.eEz.size(); i++) {
            jc jcVar = ((q) cardConsumeSuccessUI.eFJ.eEz.get(i)).eCv;
            auo com_tencent_mm_protocal_c_auo = new auo();
            if (jcVar != null) {
                com_tencent_mm_protocal_c_auo.eBK = jcVar.eBK;
                cardConsumeSuccessUI.eBG = jcVar.eBK;
            }
            com_tencent_mm_protocal_c_auo.bom = ((q) cardConsumeSuccessUI.eFJ.eEz.get(i)).bom;
            com_tencent_mm_protocal_c_auo.lZM = "";
            com_tencent_mm_protocal_c_auo.lZL = "";
            com_tencent_mm_protocal_c_auo.lZN = cardConsumeSuccessUI.eFN;
            linkedList.add(com_tencent_mm_protocal_c_auo);
        }
        String str = cardConsumeSuccessUI.eFM == 1 ? cardConsumeSuccessUI.eFJ.eEA : cardConsumeSuccessUI.eAS;
        auw a = com.tencent.mm.plugin.card.b.j.a(cardConsumeSuccessUI.eFO, cardConsumeSuccessUI.eFR, cardConsumeSuccessUI.eFS);
        k gVar = cardConsumeSuccessUI.eFI.isChecked() ? new g(0, linkedList, cardConsumeSuccessUI.eFJ.eEC, str, a, 20, null) : new g(0, linkedList, "", str, a, 20, null);
        if (cardConsumeSuccessUI.eFI != null && cardConsumeSuccessUI.eFI.getVisibility() == 0) {
            if (cardConsumeSuccessUI.eFI.isChecked()) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11324, new Object[]{"CardConsumeSuccessFollowServices", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.h(11324, new Object[]{"CardConsumeSuccessView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
            }
        }
        ak.vy().a(gVar, 0);
    }

    private void cg(boolean z) {
        if (z) {
            this.dFI = p.b(this, getString(2131233521), true, 0, null);
        } else if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
            this.dFI = null;
        }
    }

    protected final int getLayoutId() {
        return 2130903212;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
        this.mStartTime = System.currentTimeMillis();
        Fd("");
        setResult(0);
        ak.vy().a(902, this);
        ak.vy().a(910, this);
        String str = "";
        this.eFM = getIntent().getIntExtra("key_from_scene", 0);
        if (this.eFM == 1) {
            v.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
            this.eFK = getIntent().getStringExtra("key_consumed_card_id");
            this.eFL = getIntent().getStringExtra("key_consumed_Code");
            if (TextUtils.isEmpty(this.eFK)) {
                v.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
                jb(0);
                finish();
                return;
            }
            v.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.eFL);
            cg(true);
            ak.vy().a(new d("", this.eFK, this.eFL), 0);
            aaJ();
            this.eFN = 7;
        } else if (this.eFM == 2) {
            v.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
            this.eAS = getIntent().getStringExtra("key_card_id");
            if (TextUtils.isEmpty(this.eAS)) {
                v.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                jb(0);
                finish();
                return;
            }
            v.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.eAS);
            cg(true);
            ak.vy().a(new d(this.eAS, "", ""), 0);
            aaJ();
            this.eFN = 4;
        } else {
            v.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
            this.eAS = getIntent().getStringExtra("KEY_CARD_ID");
            if (qd(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON"))) {
                String str2;
                if (!(this.eFJ == null || be.bP(this.eFJ.eEz))) {
                    jc jcVar = ((q) this.eFJ.eEz.get(0)).eCv;
                    if (jcVar != null) {
                        str2 = jcVar.coN;
                        if (be.kS(str2)) {
                            str2 = getIntent().getStringExtra("KEY_CARD_COLOR");
                        }
                        this.eFN = getIntent().getIntExtra("key_stastic_scene", 0);
                        str = str2;
                    }
                }
                str2 = str;
                if (be.kS(str2)) {
                    str2 = getIntent().getStringExtra("KEY_CARD_COLOR");
                }
                this.eFN = getIntent().getIntExtra("key_stastic_scene", 0);
                str = str2;
            } else {
                v.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                jb(0);
                finish();
                return;
            }
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(11324, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.eFN), "", Integer.valueOf(0), ""});
        NI();
        if (!TextUtils.isEmpty(r1)) {
            qe(r1);
        }
    }

    private boolean qd(String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
            return false;
        }
        this.eFJ = o.qE(str);
        if (this.eFJ != null) {
            return true;
        }
        v.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is " + str);
        return false;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        ak.vy().b(902, this);
        ak.vy().b(910, this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (TextUtils.isEmpty(this.eAS)) {
            com.tencent.mm.plugin.report.service.g.iuh.h(13219, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(this.eFM), this.eBG, this.eFK, Long.valueOf(currentTimeMillis)});
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.h(13219, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(this.eFM), this.eBG, this.eAS, Long.valueOf(currentTimeMillis)});
        }
        super.onDestroy();
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardConsumeSuccessUI eFU;

            {
                this.eFU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eFU.finish();
                CardConsumeSuccessUI.jb(0);
                return true;
            }
        });
        this.Hq = this.nDR.dtW;
        this.eFq = (TextView) findViewById(2131755714);
        this.eFr = (TextView) findViewById(2131755716);
        this.eFC = (TextView) findViewById(2131755717);
        this.eFD = (TextView) findViewById(2131755781);
        this.eFE = (TextView) findViewById(2131755784);
        this.eFF = (TextView) findViewById(2131755785);
        this.eFG = (ImageView) findViewById(2131755713);
        this.eFH = (Button) findViewById(2131755782);
        this.eFI = (CheckBox) findViewById(2131755783);
        this.eFH.setOnClickListener(this.eFl);
        this.eFI.setOnClickListener(this.eFl);
        this.eFE.setOnClickListener(this.eFl);
        if (this.eFJ != null) {
            av();
        }
    }

    private void av() {
        if (this.eFJ == null) {
            v.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
            return;
        }
        findViewById(2131755778).setVisibility(0);
        if (TextUtils.isEmpty(this.eFJ.eEB) || TextUtils.isEmpty(this.eFJ.eEC)) {
            this.eFI.setVisibility(8);
            v.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
        } else {
            this.eFI.setText(this.eFJ.eEB);
            this.eFI.setVisibility(0);
        }
        if (this.eFJ.eEz == null || this.eFJ.eEz.size() <= 0) {
            this.eFH.setEnabled(false);
            v.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
            return;
        }
        this.eFD.setText(getString(2131231604, new Object[]{Integer.valueOf(this.eFJ.eEz.size())}));
        jc jcVar = ((q) this.eFJ.eEz.get(0)).eCv;
        if (jcVar != null) {
            qe(jcVar.coN);
            this.eFq.setText(jcVar.eCD);
            this.eFr.setText(jcVar.title);
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131493362);
            if (TextUtils.isEmpty(jcVar.eBM)) {
                v.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
                this.eFG.setImageResource(2130838736);
            } else {
                a aVar = new a();
                aVar.cPv = com.tencent.mm.compatible.util.e.cnj;
                n.GM();
                aVar.cPN = null;
                aVar.cPu = i.pR(jcVar.eBM);
                aVar.cPs = true;
                aVar.cPP = true;
                aVar.cPq = true;
                aVar.cPz = dimensionPixelSize;
                aVar.cPy = dimensionPixelSize;
                aVar.cPH = 2130838736;
                n.GL().a(jcVar.eBM, this.eFG, aVar.GU());
            }
            if (TextUtils.isEmpty(jcVar.mkW)) {
                this.eFH.setText(2131231601);
                return;
            }
            v.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
            this.eFH.setText(jcVar.mkW);
            return;
        }
        v.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    }

    private void aaJ() {
        this.nDR.dtW.setBackgroundColor(getResources().getColor(2131689900));
        findViewById(2131755778).setVisibility(4);
    }

    @TargetApi(16)
    private void qe(String str) {
        int qv = com.tencent.mm.plugin.card.b.j.qv(str);
        this.Hq.setBackgroundColor(qv);
        com.tencent.mm.plugin.card.b.k.a((MMActivity) this, qv);
        if (com.tencent.mm.compatible.util.d.dW(16)) {
            this.eFH.setBackground(com.tencent.mm.plugin.card.b.j.bs(qv, getResources().getDimensionPixelSize(2131493340) / 2));
        } else {
            this.eFH.setBackgroundDrawable(com.tencent.mm.plugin.card.b.j.bs(qv, getResources().getDimensionPixelSize(2131493340) / 2));
        }
        this.Hq.invalidate();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " scene cmd is " + kVar.getType());
        cg(false);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof g) {
                g gVar = (g) kVar;
                if (gVar.eDo == 0) {
                    com.tencent.mm.ui.base.g.bf(this, getString(2131231583));
                    setResult(-1);
                    this.eFH.setEnabled(false);
                    com.tencent.mm.plugin.card.b.j.acI();
                    v.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
                    jb(-1);
                    String str2 = ((g) kVar).eDn;
                    ShareCardInfo shareCardInfo = new ShareCardInfo();
                    com.tencent.mm.plugin.card.b.d.a(shareCardInfo, str2);
                    com.tencent.mm.plugin.card.b.j.a(shareCardInfo);
                    af.aar().Yj();
                    finish();
                    return;
                }
                v.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + gVar.eDo);
                com.tencent.mm.plugin.card.b.c.b(this, gVar.eDp);
                com.tencent.mm.ui.base.g.bf(this, getString(2131231579));
            } else if (kVar instanceof d) {
                d dVar = (d) kVar;
                if (dVar.eDo == 0) {
                    if (TextUtils.isEmpty(dVar.eDn) || !qd(dVar.eDn)) {
                        v.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
                        if (this.eFM == 1) {
                            jb(0);
                            finish();
                            return;
                        }
                        aaJ();
                        qf(dVar.eDp);
                        if (be.kS(dVar.eDp)) {
                            com.tencent.mm.ui.base.g.bf(this, getString(2131231581));
                            return;
                        } else {
                            com.tencent.mm.ui.base.g.bf(this, dVar.eDp);
                            return;
                        }
                    }
                    v.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
                    this.eFT.post(new Runnable(this) {
                        final /* synthetic */ CardConsumeSuccessUI eFU;

                        {
                            this.eFU = r1;
                        }

                        public final void run() {
                            this.eFU.av();
                        }
                    });
                } else if (this.eFM == 1) {
                    jb(0);
                    finish();
                } else {
                    v.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + dVar.eDo);
                    aaJ();
                    qf(dVar.eDp);
                }
            }
        } else if ((kVar instanceof d) && this.eFM == 1) {
            jb(0);
            finish();
        } else {
            com.tencent.mm.plugin.card.b.c.b(this, str);
        }
    }

    private void qf(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(2131231581);
        }
        com.tencent.mm.ui.base.g.a(this, str, "", false, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ CardConsumeSuccessUI eFU;

            {
                this.eFU = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                CardConsumeSuccessUI.jb(0);
                this.eFU.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            v.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
            jb(0);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static void jb(int i) {
        v.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is " + i);
        bi biVar = new bi();
        biVar.aYP.aKK = i;
        com.tencent.mm.sdk.c.a.nhr.z(biVar);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.eFO = intent.getIntExtra("Ktag_range_index", 0);
                    v.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.eFO)});
                    if (this.eFO >= 2) {
                        this.eFP = intent.getStringExtra("Klabel_name_list");
                        this.eFQ = intent.getStringExtra("Kother_user_name_list");
                        v.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.eFO), this.eFP});
                        if (TextUtils.isEmpty(this.eFP) && TextUtils.isEmpty(this.eFQ)) {
                            v.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
                            return;
                        }
                        List asList = Arrays.asList(this.eFP.split(","));
                        this.eFS = com.tencent.mm.plugin.card.b.j.ae(asList);
                        this.eFR = com.tencent.mm.plugin.card.b.j.ad(asList);
                        if (this.eFQ != null && this.eFQ.length() > 0) {
                            this.eFR.addAll(Arrays.asList(this.eFQ.split(",")));
                        }
                        if (this.eFS != null) {
                            v.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.eFS.size());
                        }
                        if (this.eFR != null) {
                            v.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.eFR.size());
                            Iterator it = this.eFR.iterator();
                            while (it.hasNext()) {
                                v.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (this.eFO == 2) {
                            this.eFF.setVisibility(0);
                            this.eFF.setText(getString(2131231685, new Object[]{aaK()}));
                            return;
                        } else if (this.eFO == 3) {
                            this.eFF.setVisibility(0);
                            this.eFF.setText(getString(2131231684, new Object[]{aaK()}));
                            return;
                        } else {
                            this.eFF.setVisibility(8);
                            return;
                        }
                    }
                    this.eFF.setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String aaK() {
        if (!TextUtils.isEmpty(this.eFP) && !TextUtils.isEmpty(this.eFQ)) {
            return this.eFP + "," + com.tencent.mm.plugin.card.b.j.qz(this.eFQ);
        }
        if (!TextUtils.isEmpty(this.eFP)) {
            return this.eFP;
        }
        if (TextUtils.isEmpty(this.eFQ)) {
            return "";
        }
        return com.tencent.mm.plugin.card.b.j.qz(this.eFQ);
    }
}
