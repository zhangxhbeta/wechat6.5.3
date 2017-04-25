package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class CardListSelectedUI extends MMActivity implements com.tencent.mm.plugin.card.a.g.a, e {
    private ListView Eq;
    private p dFI = null;
    private View dZV;
    private String eBK;
    private String eBQ;
    com.tencent.mm.ba.b eDH = null;
    boolean eDI = true;
    private boolean eGs = false;
    private String eHE = "";
    private String eHF;
    private String eKA;
    private int eKB;
    private boolean eKC = false;
    private com.tencent.mm.plugin.card.model.a eKD;
    private TextView eKo;
    private a eKp;
    LinkedList<com.tencent.mm.plugin.card.model.a> eKq = new LinkedList();
    HashMap<Integer, Boolean> eKr = new HashMap();
    boolean eKs = false;
    private boolean eKt;
    private boolean eKu;
    private boolean eKv;
    private int eKw;
    private String eKx;
    private String eKy;
    private String eKz;
    private int exT = 0;
    private int time_stamp;

    class a extends BaseAdapter {
        final /* synthetic */ CardListSelectedUI eKE;

        a(CardListSelectedUI cardListSelectedUI) {
            this.eKE = cardListSelectedUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return jg(i);
        }

        public final int getCount() {
            return this.eKE.eKq.size();
        }

        private com.tencent.mm.plugin.card.model.a jg(int i) {
            return (com.tencent.mm.plugin.card.model.a) this.eKE.eKq.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            com.tencent.mm.plugin.card.model.a jg = jg(i);
            if (view == null) {
                view = View.inflate(this.eKE, 2130903249, null);
                bVar = new b(this.eKE);
                bVar.eKF = (ImageView) view.findViewById(2131755922);
                bVar.dID = (TextView) view.findViewById(2131755226);
                bVar.eKG = (TextView) view.findViewById(2131755963);
                bVar.eKH = (TextView) view.findViewById(2131755964);
                bVar.exF = (TextView) view.findViewById(2131755697);
                bVar.eKI = view.findViewById(2131755361);
                bVar.eKJ = (ImageView) view.findViewById(2131755965);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (j.iT(jg.eBL)) {
                int i2;
                bVar.dID.setText(jg.eBN);
                if (TextUtils.isEmpty(jg.title)) {
                    bVar.eKG.setVisibility(8);
                } else {
                    bVar.eKG.setVisibility(0);
                    bVar.eKG.setText(jg.title);
                }
                if (TextUtils.isEmpty(jg.eBO)) {
                    bVar.eKH.setVisibility(8);
                } else {
                    bVar.eKH.setVisibility(0);
                    bVar.eKH.setText(jg.eBO);
                }
                TextView textView = bVar.exF;
                if (be.kS(jg.exN)) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                bVar.exF.setText(jg.exN);
                k.a(bVar.eKF, jg.eBM, this.eKE.getBaseContext().getResources().getDimensionPixelSize(2131493377), 2130838736, true);
                Boolean bool = (Boolean) this.eKE.eKr.get(Integer.valueOf(i));
                if (bool == null || !bool.booleanValue()) {
                    bVar.eKJ.setImageResource(2130837831);
                } else {
                    bVar.eKJ.setImageResource(2130837830);
                }
            } else {
                v.i("MicroMsg.CardListSelectedUI", "not support type");
            }
            return view;
        }
    }

    class b {
        public TextView dID;
        final /* synthetic */ CardListSelectedUI eKE;
        public ImageView eKF;
        public TextView eKG;
        public TextView eKH;
        public View eKI;
        public ImageView eKJ;
        public TextView exF;

        b(CardListSelectedUI cardListSelectedUI) {
            this.eKE = cardListSelectedUI;
        }
    }

    static /* synthetic */ void d(CardListSelectedUI cardListSelectedUI) {
        for (int i = 0; i < cardListSelectedUI.eKq.size(); i++) {
            Boolean bool = (Boolean) cardListSelectedUI.eKr.get(Integer.valueOf(i));
            if (bool != null && bool.booleanValue()) {
                cardListSelectedUI.iT(true);
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903234;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        af.aaw().a(this);
        ak.vy().a(664, this);
        Intent intent = getIntent();
        v.i("MicroMsg.CardListSelectedUI", "initData()");
        if (intent == null) {
            v.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
            setResult(0);
            E(0, "");
            finish();
        } else {
            this.exT = intent.getIntExtra("key_from_scene", 0);
            v.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.exT);
            this.eBQ = intent.getStringExtra("app_id");
            this.eKw = intent.getIntExtra("shop_id", 0);
            this.eKx = intent.getStringExtra("sign_type");
            this.eKy = intent.getStringExtra("card_sign");
            this.time_stamp = intent.getIntExtra("time_stamp", 0);
            this.eKz = intent.getStringExtra("nonce_str");
            this.eBK = intent.getStringExtra("card_tp_id");
            this.eKA = intent.getStringExtra("card_type");
            this.eKB = intent.getIntExtra("can_multi_select", 0);
            this.eHE = intent.getStringExtra("key_package_name");
            this.eHF = intent.getStringExtra("key_transaction");
            v.i("MicroMsg.CardListSelectedUI", "app_id:" + this.eBQ + " shop_id:" + this.eKw + " sign_type:" + this.eKx + " time_stamp:" + this.time_stamp);
            v.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.eKz + " card_tp_id:" + this.eBK + " card_type:" + this.eKA + " canMultiSelect:" + this.eKB + " packateName:" + this.eHE);
            if ("INVOICE".equalsIgnoreCase(this.eKA)) {
                this.eKC = true;
            }
            if (TextUtils.isEmpty(this.eBQ) || TextUtils.isEmpty(this.eKy)) {
                v.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
                setResult(0);
                E(0, "");
                finish();
            }
        }
        abL();
        NI();
    }

    protected void onDestroy() {
        af.aaw().b(this);
        ak.vy().b(664, this);
        super.onDestroy();
    }

    protected final void cg(boolean z) {
        if (z) {
            this.dFI = p.b(this, getString(2131233521), false, 0, null);
        } else if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
            this.dFI = null;
        }
    }

    private void abL() {
        if (this.eGs) {
            v.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
            return;
        }
        if (this.eDH == null) {
            this.eKt = false;
            this.eKu = false;
            this.eKv = false;
        }
        ak.vy().a(new ac(this.eBQ, this.eKw, this.eKx, this.eKy, this.time_stamp, this.eKz, this.eBK, this.eKA, this.eDH), 0);
        cg(true);
        this.eGs = true;
        if (this.eKB == 1) {
            this.eKs = true;
        }
    }

    protected final void NI() {
        if (this.eKC) {
            vD(2131231641);
        } else {
            vD(2131231640);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardListSelectedUI eKE;

            {
                this.eKE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eKE.setResult(0);
                this.eKE.E(0, "");
                this.eKE.finish();
                return true;
            }
        });
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ CardListSelectedUI eKE;

            {
                this.eKE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.eKE.eKs || !this.eKE.eKD.eBT) {
                    this.eKE.abn();
                } else {
                    this.eKE.cg(true);
                    af.aaw().v(this.eKE.eKD.eBS, j.qC(this.eKE.eKD.userName), 3);
                }
                return true;
            }
        });
        iT(false);
        this.Eq = (ListView) findViewById(2131755913);
        this.eKp = new a(this);
        this.Eq.setAdapter(this.eKp);
        this.Eq.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardListSelectedUI eKE;

            {
                this.eKE = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.eKE.eKs) {
                    this.eKE.eKr.put(Integer.valueOf(i), Boolean.valueOf(!((Boolean) this.eKE.eKr.get(Integer.valueOf(i))).booleanValue()));
                } else {
                    for (int i2 = 0; i2 < this.eKE.eKq.size(); i2++) {
                        this.eKE.eKr.put(Integer.valueOf(i2), Boolean.valueOf(false));
                    }
                    this.eKE.eKr.put(Integer.valueOf(i), Boolean.valueOf(true));
                    this.eKE.eKD = (com.tencent.mm.plugin.card.model.a) this.eKE.eKq.get(i);
                }
                this.eKE.eKp.notifyDataSetChanged();
                CardListSelectedUI.d(this.eKE);
            }
        });
        this.Eq.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ CardListSelectedUI eKE;

            {
                this.eKE = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !this.eKE.eDI) {
                    v.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
                    this.eKE.abL();
                }
            }
        });
        this.dZV = findViewById(2131755725);
        this.eKo = (TextView) findViewById(2131755726);
        if (this.eKC) {
            this.eKo.setText(getString(2131231669));
        }
    }

    private void abn() {
        Intent intent = new Intent();
        String abM = abM();
        if (this.eKC) {
            intent.putExtra("choose_invoice_info", abM);
        } else {
            intent.putExtra("choose_card_info", abM);
        }
        setResult(-1, intent);
        E(-1, abM);
        finish();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof ac) {
            cg(false);
            if (i == 0 && i2 == 0) {
                int size;
                String str2 = ((ac) kVar).eDn;
                v.d("MicroMsg.CardListSelectedUI", str2);
                Collection pO = com.tencent.mm.plugin.card.model.a.pO(str2);
                Collection pP = com.tencent.mm.plugin.card.model.a.pP(str2);
                if (this.eDH == null && !(pO == null && pP == null)) {
                    this.eKr.clear();
                    this.eKq.clear();
                }
                if (pO != null) {
                    if (pO.size() > 0 && !this.eKt) {
                        this.eKt = true;
                        if (this.eKC) {
                            ((com.tencent.mm.plugin.card.model.a) pO.get(0)).exN = getString(2131231678);
                        } else {
                            ((com.tencent.mm.plugin.card.model.a) pO.get(0)).exN = getString(2131231677);
                        }
                    }
                    this.eKq.addAll(pO);
                    for (size = this.eKq.size(); size < this.eKq.size(); size++) {
                        this.eKr.put(Integer.valueOf(size), Boolean.valueOf(false));
                    }
                }
                if (pP != null) {
                    if (pP.size() > 0 && !this.eKu) {
                        this.eKu = true;
                        ((com.tencent.mm.plugin.card.model.a) pP.get(0)).exN = getString(2131231606);
                    }
                    this.eKq.addAll(pP);
                    for (size = this.eKq.size(); size < this.eKq.size(); size++) {
                        this.eKr.put(Integer.valueOf(size), Boolean.valueOf(false));
                    }
                }
                this.eDI = ((ac) kVar).eDI;
                this.eDH = ((ac) kVar).eDH;
                this.eKp.notifyDataSetChanged();
            } else {
                c.b(this, str, i2);
            }
            if (this.eKq.size() != 0) {
                this.dZV.setVisibility(8);
            } else {
                this.dZV.setVisibility(0);
            }
            this.eGs = false;
        }
    }

    public final void b(String str, com.tencent.mm.plugin.card.a.g.b bVar) {
        cg(false);
        if (TextUtils.isEmpty(str) || str.equals(this.eKD.eBS)) {
            v.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
            v.i("MicroMsg.CardListSelectedUI", "markSucc:" + bVar.eBx + " markCardId: " + bVar.eBy);
            if (bVar.eBx == 1) {
                if (TextUtils.isEmpty(bVar.eBy) || str.equals(bVar.eBy)) {
                    v.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
                } else {
                    v.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
                    int i = 0;
                    while (i < this.eKq.size()) {
                        if (((com.tencent.mm.plugin.card.model.a) this.eKq.get(i)).eBS == bVar.eBy) {
                            for (int i2 = 0; i2 < this.eKq.size(); i2++) {
                                this.eKr.put(Integer.valueOf(i2), Boolean.valueOf(false));
                            }
                            this.eKr.put(Integer.valueOf(i), Boolean.valueOf(true));
                        } else {
                            i++;
                        }
                    }
                }
                abn();
                return;
            }
            c.b(this, getString(2131231645));
            return;
        }
        v.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
    }

    public final void be(String str, String str2) {
        cg(false);
        if (TextUtils.isEmpty(str) || str.equals(this.eKD.eBS)) {
            v.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(2131231644);
            }
            c.b(this, str2);
            return;
        }
        v.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
    }

    public final void pL(String str) {
    }

    private String abM() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.eKq.size(); i2++) {
            Boolean bool = (Boolean) this.eKr.get(Integer.valueOf(i2));
            if (bool != null && bool.booleanValue()) {
                arrayList.add(this.eKq.get(i2));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (i < arrayList.size()) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            com.tencent.mm.plugin.card.model.a aVar = (com.tencent.mm.plugin.card.model.a) arrayList.get(i);
            stringBuilder.append("{");
            stringBuilder.append("\"card_id\":");
            stringBuilder.append("\"" + aVar.eBK + "\"");
            stringBuilder.append(",");
            stringBuilder.append("\"encrypt_code\":");
            stringBuilder.append("\"" + aVar.eBP + "\"");
            if (this.eKC) {
                stringBuilder.append(",");
                stringBuilder.append("\"app_id\":");
                stringBuilder.append("\"" + aVar.eBQ + "\"");
            }
            stringBuilder.append("}");
            i++;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            E(0, "");
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void E(int i, String str) {
        if (this.exT != 8) {
            v.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.exT);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_choose_card_from_wx_card_list", str);
        f aC = g.aC(this.eBQ, true);
        com.tencent.mm.sdk.f.b.a aVar = new com.tencent.mm.sdk.f.b.a(bundle);
        if (aC != null) {
            aVar.bfm = aC.field_openId;
        }
        aVar.lBj = this.eHF;
        String str2 = "MicroMsg.CardListSelectedUI";
        String str3 = "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.eBQ;
        objArr[1] = aC == null ? "null appinfo" : aC.field_appName;
        objArr[2] = aC == null ? "null appinfo" : aC.field_openId;
        objArr[3] = this.eHF;
        v.i(str2, str3, objArr);
        aVar.t(bundle);
        v.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:" + i);
        v.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:" + str);
        if (i == -1) {
            aVar.errCode = 0;
        } else {
            aVar.errCode = -2;
        }
        com.tencent.mm.sdk.a.a.a aVar2 = new com.tencent.mm.sdk.a.a.a();
        aVar2.nhj = this.eHE;
        aVar2.nhl = bundle;
        com.tencent.mm.pluginsdk.model.app.p.R(bundle);
        com.tencent.mm.pluginsdk.model.app.p.S(bundle);
        com.tencent.mm.sdk.a.a.a(aa.getContext(), aVar2);
    }
}
