package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.af;
import com.tencent.mm.e.a.ag;
import com.tencent.mm.e.a.hj;
import com.tencent.mm.e.a.qn;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.b.f;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.b.h;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoUI extends WalletBaseUI {
    protected boolean aXO = true;
    protected boolean aXP = false;
    protected boolean aXQ = false;
    protected String dRA = null;
    protected String dzg = "";
    protected String hKp;
    private com.tencent.mm.sdk.c.c hLV = new com.tencent.mm.sdk.c.c<qn>(this) {
        final /* synthetic */ WalletOrderInfoUI kUl;

        {
            this.kUl = r2;
            this.nhz = qn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            qn qnVar = (qn) bVar;
            if (!(qnVar instanceof qn)) {
                return false;
            }
            if (qnVar.bsb.bsc.containsKey(".sysmsg.paymsg.guide_flag")) {
                qnVar.bsb.brU = (String) qnVar.bsb.bsc.get(".sysmsg.paymsg.guide_flag");
            }
            if (qnVar.bsb.bsc.containsKey(".sysmsg.paymsg.guide_wording")) {
                qnVar.bsb.brV = (String) qnVar.bsb.bsc.get(".sysmsg.paymsg.guide_wording");
            }
            if (qnVar.bsb.bsc.containsKey(".sysmsg.paymsg.left_button_wording")) {
                qnVar.bsb.brW = (String) qnVar.bsb.bsc.get(".sysmsg.paymsg.left_button_wording");
            }
            if (qnVar.bsb.bsc.containsKey(".sysmsg.paymsg.right_button_wording")) {
                qnVar.bsb.brX = (String) qnVar.bsb.bsc.get(".sysmsg.paymsg.right_button_wording");
            }
            if (qnVar.bsb.bsc.containsKey(".sysmsg.paymsg.upload_credit_url")) {
                qnVar.bsb.brY = (String) qnVar.bsb.bsc.get(".sysmsg.paymsg.upload_credit_url");
            }
            if (qnVar.bsb.bsc.containsKey(".sysmsg.paymsg.guide_block")) {
                if (!"1".equals((String) qnVar.bsb.bsc.get(".sysmsg.paymsg.guide_block"))) {
                    v.i("MicroMsg.WalletOrderInfoUI", "block pass");
                    return true;
                } else if (!"1".equals(qnVar.bsb.brU) && !"2".equals(qnVar.bsb.brU)) {
                    return false;
                } else {
                    Parcelable realnameGuideHelper = new RealnameGuideHelper();
                    realnameGuideHelper.a(qnVar.bsb.brU, qnVar.bsb.brV, qnVar.bsb.brW, qnVar.bsb.brX, qnVar.bsb.brY, this.kUl.kIA == null ? 0 : this.kUl.kIA.bkq);
                    v.i("MicroMsg.WalletOrderInfoUI", "receive guide");
                    this.kUl.uA.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                    return false;
                }
            }
            v.i("MicroMsg.WalletOrderInfoUI", "block pass");
            return true;
        }
    };
    protected String hOz = null;
    public Orders hdo;
    private String isM;
    protected PayInfo kIA;
    protected LinearLayout kTT = null;
    protected TextView kTU = null;
    protected TextView kTV = null;
    public List<Commodity> kTW = null;
    public a kTX = null;
    protected boolean kTY = false;
    public Set<String> kTZ = null;
    protected String kUa = null;
    protected HashMap<String, TextView> kUb = new HashMap();
    protected String kUc;
    protected c kUd;
    protected Map<Long, String> kUe = new HashMap();
    private d kUf;
    private HashMap<String, b> kUg = new HashMap();
    public com.tencent.mm.model.ab.c.a kUh = new com.tencent.mm.model.ab.c.a(this) {
        final /* synthetic */ WalletOrderInfoUI kUl;

        {
            this.kUl = r1;
        }

        public final void p(String str, boolean z) {
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(str);
            v.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + str + " succ: " + z);
            this.kUl.G(LX);
        }
    };
    private OnClickListener kUi = new OnClickListener(this) {
        final /* synthetic */ WalletOrderInfoUI kUl;

        {
            this.kUl = r1;
        }

        public final void onClick(View view) {
            if (!be.kS(this.kUl.dRA)) {
                e.L(this.kUl, this.kUl.dRA);
            }
        }
    };
    private OnLongClickListener kUj = new OnLongClickListener(this) {
        final /* synthetic */ WalletOrderInfoUI kUl;

        {
            this.kUl = r1;
        }

        public final boolean onLongClick(View view) {
            if (view.getId() == 2131759937 || view.getId() == 2131759947) {
                try {
                    String str = (String) view.getTag();
                    Toast.makeText(this.kUl, 2131236235, 0).show();
                    com.tencent.mm.pluginsdk.j.c.a(this.kUl.nDR.nEl, str, str);
                } catch (Throwable e) {
                    v.a("MicroMsg.WalletOrderInfoUI", e, "", new Object[0]);
                }
            }
            return true;
        }
    };
    private com.tencent.mm.sdk.c.c kUk = new com.tencent.mm.sdk.c.c<ag>(this) {
        final /* synthetic */ WalletOrderInfoUI kUl;

        {
            this.kUl = r2;
            this.nhz = ag.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ag agVar = (ag) bVar;
            if (agVar instanceof ag) {
                this.kUl.kUa = agVar.aXL.aXN;
                this.kUl.aXO = agVar.aXL.aXO;
                this.kUl.aXP = agVar.aXL.aXP;
                this.kUl.aXQ = agVar.aXL.aXQ;
                if (this.kUl.aXQ && !be.kS(this.kUl.kUc)) {
                    for (int i = 0; i < this.kUl.kTW.size(); i++) {
                        Commodity commodity = (Commodity) this.kUl.kTW.get(i);
                        int i2 = -1;
                        for (int i3 = 0; i3 < commodity.kPC.size(); i3++) {
                            com.tencent.mm.plugin.wallet_core.model.Orders.b bVar2 = (com.tencent.mm.plugin.wallet_core.model.Orders.b) commodity.kPC.get(i3);
                            if (bVar2.type == Orders.kPv && !be.kS(bVar2.url) && bVar2.url.equals(this.kUl.kUc)) {
                                i2 = i3;
                            }
                        }
                        if (i2 >= 0) {
                            commodity.kPC.remove(i2);
                        }
                    }
                }
                this.kUl.kTX.notifyDataSetChanged();
                if (!be.kS(this.kUl.kUc)) {
                    TextView textView = (TextView) this.kUl.kUb.get(this.kUl.kUc);
                    if (textView != null) {
                        textView.setClickable(this.kUl.aXO);
                        textView.setEnabled(this.kUl.aXO);
                        textView.setOnClickListener(null);
                        if (this.kUl.aXP) {
                            textView.setVisibility(8);
                        }
                    }
                }
                agVar.aXM.aXR = true;
            }
            return false;
        }
    };

    public class a extends BaseAdapter {
        final /* synthetic */ WalletOrderInfoUI kUl;

        class a {
            TextView dtZ;
            TextView kUA;
            final /* synthetic */ a kUm;
            TextView kUn;
            TextView kUo;
            TextView kUp;
            TextView kUq;
            TextView kUr;
            TextView kUs;
            TextView kUt;
            View kUu;
            MaxListView kUv;
            View kUw;
            TextView kUx;
            TextView kUy;
            TextView kUz;

            a(a aVar) {
                this.kUm = aVar;
            }
        }

        public a(WalletOrderInfoUI walletOrderInfoUI) {
            this.kUl = walletOrderInfoUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return st(i);
        }

        public final int getCount() {
            return this.kUl.kTW != null ? this.kUl.kTW.size() : 0;
        }

        private Commodity st(int i) {
            return (Commodity) this.kUl.kTW.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.kUl, 2130904661, null);
                a aVar2 = new a(this);
                aVar2.kUn = (TextView) view.findViewById(2131759944);
                aVar2.dtZ = (TextView) view.findViewById(2131759937);
                aVar2.kUq = (TextView) view.findViewById(2131759930);
                aVar2.kUo = (TextView) view.findViewById(2131759932);
                aVar2.kUp = (TextView) view.findViewById(2131759933);
                aVar2.kUp.getPaint().setFlags(16);
                aVar2.kUr = (TextView) view.findViewById(2131759947);
                aVar2.kUs = (TextView) view.findViewById(2131759943);
                aVar2.kUt = (TextView) view.findViewById(2131759945);
                aVar2.kUv = (MaxListView) view.findViewById(2131759949);
                aVar2.kUw = view.findViewById(2131759934);
                aVar2.kUu = view.findViewById(2131759948);
                aVar2.kUy = (TextView) view.findViewById(2131759939);
                aVar2.kUx = (TextView) view.findViewById(2131759938);
                aVar2.kUz = (TextView) view.findViewById(2131759941);
                aVar2.kUA = (TextView) view.findViewById(2131759940);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            Commodity st = st(i);
            if (!(st == null || aVar == null)) {
                CharSequence string;
                this.kUl.isM = st.eWA;
                aVar.kUo.setText(e.d(st.eWz, st.hNg));
                if (st.kPw < 0.0d || st.eWz >= st.kPw) {
                    aVar.kUp.setVisibility(8);
                } else {
                    aVar.kUp.setText(e.d(st.kPw, st.hNg));
                    aVar.kUp.setVisibility(0);
                }
                LinearLayout linearLayout = (LinearLayout) aVar.kUw;
                List list = st.kPz;
                linearLayout.removeAllViews();
                if (list != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        DiscountInfo discountInfo = (DiscountInfo) list.get(i2);
                        View textView = new TextView(this.kUl.nDR.nEl);
                        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.bottomMargin = this.kUl.nDR.nEl.getResources().getDimensionPixelOffset(2131492962);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextAppearance(this.kUl.nDR.nEl, 2131558919);
                        textView.setText(discountInfo.kPI + e.d(discountInfo.kPH / 100.0d, this.kUl.hdo.hNg));
                        linearLayout.addView(textView);
                        textView.setTextColor(this.kUl.getResources().getColor(2131690098));
                    }
                }
                if (linearLayout.getChildCount() > 0) {
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                }
                TextView textView2 = aVar.kUn;
                Context context = this.kUl;
                if (k.xT()) {
                    string = context.getString(2131236254);
                } else {
                    string = context.getString(2131236253);
                }
                textView2.setText(string);
                aVar.kUq.setText(st.hMV);
                aVar.dtZ.setText(st.desc);
                aVar.dtZ.setTag(st.desc);
                aVar.dtZ.setOnLongClickListener(this.kUl.kUj);
                aVar.dtZ.setBackgroundResource(2130839526);
                aVar.kUr.setText(st.eWA);
                aVar.kUr.setTag(st.eWA);
                aVar.kUr.setOnLongClickListener(this.kUl.kUj);
                aVar.kUr.setBackgroundResource(2130839526);
                aVar.kUs.setText(e.yB(st.hNc));
                aVar.kUt.setText(st.hNe);
                string = st.kPA;
                if (aVar.kUz != null) {
                    if (be.kS(string)) {
                        aVar.kUA.setVisibility(8);
                        aVar.kUz.setVisibility(8);
                    } else {
                        aVar.kUz.setText(string);
                        aVar.kUz.setVisibility(0);
                        aVar.kUA.setVisibility(0);
                    }
                }
                string = st.kPB;
                if (aVar.kUy != null) {
                    if (be.kS(string)) {
                        aVar.kUx.setVisibility(8);
                        aVar.kUy.setVisibility(8);
                    } else {
                        aVar.kUy.setText(string);
                        aVar.kUy.setVisibility(0);
                        aVar.kUx.setVisibility(0);
                    }
                }
                if (st.kPC.size() > 0) {
                    com.tencent.mm.plugin.wallet_core.model.Orders.b bVar = (com.tencent.mm.plugin.wallet_core.model.Orders.b) st.kPC.get(0);
                    g.iuh.h(13033, new Object[]{Integer.valueOf(1), bVar.hNh, bVar.url, bVar.name, this.kUl.isM});
                    this.kUl.kUd = new c(this.kUl, st.kPC);
                    aVar.kUv.setAdapter(this.kUl.kUd);
                    aVar.kUv.setOnItemClickListener(new OnItemClickListener(this) {
                        final /* synthetic */ a kUm;

                        {
                            this.kUm = r1;
                        }

                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            com.tencent.mm.plugin.wallet_core.model.Orders.b su = this.kUm.kUl.kUd.su(i);
                            if (be.kS(su.hNh)) {
                                String du = this.kUm.kUl.du(su.kPL);
                                if ("-1".equals(du) || "3".equals(du)) {
                                    g.iuh.h(13472, new Object[]{this.kUm.kUl.isM, Integer.valueOf(su.kPM), Integer.valueOf(1)});
                                    g.iuh.h(13033, new Object[]{Integer.valueOf(2), "", su.url, su.name, ""});
                                    if (su.kPM == 1) {
                                        this.kUm.kUl.a(su);
                                        return;
                                    } else if (su.kPM != 2 || be.kS(su.url)) {
                                        v.e("MicroMsg.WalletOrderInfoUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                                        return;
                                    } else if (this.kUm.kUl.kUg.containsKey(su.kPL)) {
                                        v.i("MicroMsg.WalletOrderInfoUI", "go to new url %s", new Object[]{((b) this.kUm.kUl.kUg.get(su.kPL)).url});
                                        this.kUm.kUl.Du(r0.url);
                                        return;
                                    } else {
                                        this.kUm.kUl.kUc = su.url;
                                        this.kUm.kUl.a(su.url, new d(this.kUm.kUl, su.kPL, su.kPN, su.kPO, su.kPP, this.kUm.kUl.bLx(), this.kUm.kUl.isM));
                                        return;
                                    }
                                }
                                return;
                            }
                            if (this.kUm.kUl.kTZ.contains(su.hNh)) {
                                this.kUm.kUl.kTZ.remove(su.hNh);
                            } else {
                                this.kUm.kUl.kTZ.add(su.hNh);
                            }
                            this.kUm.kUl.kTX.notifyDataSetChanged();
                        }
                    });
                    this.kUl.kUd.notifyDataSetChanged();
                    aVar.kUv.setVisibility(0);
                    aVar.kUu.setVisibility(0);
                } else {
                    aVar.kUv.setVisibility(8);
                    aVar.kUu.setVisibility(8);
                }
            }
            return view;
        }
    }

    class b {
        public String bhe;
        public String bll;
        public String kUB;
        final /* synthetic */ WalletOrderInfoUI kUl;
        public String title;
        public String url;

        public b(WalletOrderInfoUI walletOrderInfoUI, JSONObject jSONObject) {
            this.kUl = walletOrderInfoUI;
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
                if (optJSONObject != null) {
                    this.url = optJSONObject.optString("url");
                    this.bhe = optJSONObject.optString("wording");
                    this.bll = optJSONObject.optString("icon");
                    this.kUB = optJSONObject.optString("btn_text");
                    this.title = optJSONObject.optString("title");
                }
            }
        }

        public final String toString() {
            return this.url + " , " + this.bhe + " , " + this.bll + " , " + this.kUB + " , " + this.title;
        }
    }

    class c extends BaseAdapter {
        protected List<com.tencent.mm.plugin.wallet_core.model.Orders.b> kPC;
        final /* synthetic */ WalletOrderInfoUI kUl;

        class a {
            TextView dtB;
            TextView dyN;
            int kPK;
            CdnImageView kUC;
            TextView kUD;
            CheckBox kUE;
            final /* synthetic */ c kUF;
            int type;

            a(c cVar) {
                this.kUF = cVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return su(i);
        }

        public c(WalletOrderInfoUI walletOrderInfoUI, List<com.tencent.mm.plugin.wallet_core.model.Orders.b> list) {
            this.kUl = walletOrderInfoUI;
            this.kPC = null;
            this.kPC = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.tencent.mm.plugin.wallet_core.model.Orders.b bVar = (com.tencent.mm.plugin.wallet_core.model.Orders.b) list.get(i);
                if (bVar != null && (!be.kS(bVar.hNh) || bVar.kPM == 2 || bVar.kPM == 1)) {
                    this.kPC.add(list.get(i));
                }
            }
        }

        public final int getCount() {
            return this.kPC != null ? this.kPC.size() : 0;
        }

        public final com.tencent.mm.plugin.wallet_core.model.Orders.b su(int i) {
            return (com.tencent.mm.plugin.wallet_core.model.Orders.b) this.kPC.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            String du;
            a aVar;
            com.tencent.mm.plugin.wallet_core.model.Orders.b su = su(i);
            if (be.kS(su.hNh) && su.kPL > 0) {
                du = this.kUl.du(su.kPL);
                g gVar = g.iuh;
                Object[] objArr = new Object[4];
                objArr[0] = this.kUl.isM;
                objArr[1] = Integer.valueOf(1);
                objArr[2] = Integer.valueOf(su.kPM);
                if ("-1".equals(du)) {
                    du = Integer.valueOf(5);
                }
                objArr[3] = du;
                gVar.h(13471, objArr);
            }
            a aVar2;
            View inflate;
            View view2;
            if (view == null) {
                aVar2 = new a(this);
                aVar2.type = su.type;
                if (su.type == Orders.kPv) {
                    if (su.kPK == 1) {
                        inflate = View.inflate(this.kUl, 2130904662, null);
                        aVar2.kUC = (CdnImageView) inflate.findViewById(2131759950);
                        aVar2.dtB = (TextView) inflate.findViewById(2131759952);
                        aVar2.kUD = (TextView) inflate.findViewById(2131759954);
                        aVar2.dyN = (TextView) inflate.findViewById(2131759953);
                        if (!TextUtils.isEmpty(su.url)) {
                            this.kUl.kUb.put(su.url, aVar2.kUD);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    } else {
                        inflate = View.inflate(this.kUl, 2130904663, null);
                        aVar2.kUC = (CdnImageView) inflate.findViewById(2131759950);
                        aVar2.kUD = (TextView) inflate.findViewById(2131759954);
                        aVar2.dyN = (TextView) inflate.findViewById(2131759953);
                        aVar2.dtB = (TextView) inflate.findViewById(2131759952);
                        if (!TextUtils.isEmpty(su.url)) {
                            this.kUl.kUb.put(su.url, aVar2.kUD);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    }
                    aVar2.kPK = su.kPK;
                    view = view2;
                    aVar = aVar2;
                } else {
                    view = View.inflate(this.kUl, 2130904664, null);
                    aVar2.kUC = (CdnImageView) view.findViewById(2131759950);
                    aVar2.kUD = (TextView) view.findViewById(2131759954);
                    aVar2.dyN = (TextView) view.findViewById(2131759953);
                    aVar2.kUE = (CheckBox) view.findViewById(2131759869);
                    if (!TextUtils.isEmpty(su.url)) {
                        this.kUl.kUb.put(su.url, aVar2.kUD);
                    }
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
            } else {
                boolean z;
                a aVar3 = (a) view.getTag();
                if (su.type != aVar3.type || (su.type == Orders.kPv && su.kPK != aVar3.kPK)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    aVar = aVar3;
                } else {
                    aVar2 = new a(this);
                    aVar2.type = su.type;
                    if (su.type == Orders.kPv) {
                        if (su.kPK == 1) {
                            inflate = View.inflate(this.kUl, 2130904662, null);
                            aVar2.kUC = (CdnImageView) inflate.findViewById(2131759950);
                            aVar2.dtB = (TextView) inflate.findViewById(2131759952);
                            aVar2.kUD = (TextView) inflate.findViewById(2131759954);
                            aVar2.dyN = (TextView) inflate.findViewById(2131759953);
                            if (!TextUtils.isEmpty(su.url)) {
                                this.kUl.kUb.put(su.url, aVar2.kUD);
                            }
                            inflate.setTag(aVar2);
                            view2 = inflate;
                        } else {
                            inflate = View.inflate(this.kUl, 2130904663, null);
                            aVar2.kUC = (CdnImageView) inflate.findViewById(2131759950);
                            aVar2.kUD = (TextView) inflate.findViewById(2131759954);
                            aVar2.dyN = (TextView) inflate.findViewById(2131759953);
                            aVar2.dtB = (TextView) inflate.findViewById(2131759952);
                            if (!TextUtils.isEmpty(su.url)) {
                                this.kUl.kUb.put(su.url, aVar2.kUD);
                            }
                            inflate.setTag(aVar2);
                            view2 = inflate;
                        }
                        aVar2.kPK = su.kPK;
                        view = view2;
                        aVar = aVar2;
                    } else {
                        view = View.inflate(this.kUl, 2130904664, null);
                        aVar2.kUC = (CdnImageView) view.findViewById(2131759950);
                        aVar2.kUD = (TextView) view.findViewById(2131759954);
                        aVar2.dyN = (TextView) view.findViewById(2131759953);
                        aVar2.kUE = (CheckBox) view.findViewById(2131759869);
                        if (!TextUtils.isEmpty(su.url)) {
                            this.kUl.kUb.put(su.url, aVar2.kUD);
                        }
                        view.setTag(aVar2);
                        aVar = aVar2;
                    }
                }
            }
            if (su != null) {
                b bVar = (b) this.kUl.kUg.get(su.kPL);
                v.i("MicroMsg.WalletOrderInfoUI", "try get result " + bVar);
                if (bVar != null) {
                    aVar.kUC.G(bVar.bll, 0, 0);
                    aVar.dyN.setText(bVar.bhe);
                    aVar.kUD.setText(bVar.kUB);
                } else {
                    aVar.kUC.G(su.hRr, 0, 0);
                    aVar.dyN.setText(su.name);
                    aVar.kUD.setText(su.kPJ);
                }
                if (be.kS(su.hNh)) {
                    aVar.kUD.setVisibility(0);
                    if (aVar.kUE != null) {
                        aVar.kUE.setVisibility(8);
                    }
                } else {
                    aVar.kUD.setVisibility(8);
                    if (aVar.kUE != null) {
                        aVar.kUE.setVisibility(0);
                        if (this.kUl.kTZ.contains(su.hNh)) {
                            aVar.kUE.setChecked(true);
                        } else {
                            aVar.kUE.setChecked(false);
                        }
                    }
                }
                if (aVar.dtB != null && bVar != null && !be.kS(bVar.title)) {
                    aVar.dtB.setText(bVar.title);
                } else if (aVar.dtB != null && !be.kS(su.title)) {
                    aVar.dtB.setText(su.title);
                } else if (aVar.dtB != null) {
                    aVar.dtB.setVisibility(8);
                }
                if (!(be.kS(this.kUl.kUc) || aVar.kUD == null)) {
                    aVar.kUD.setClickable(this.kUl.aXO);
                    aVar.kUD.setEnabled(this.kUl.aXO);
                    aVar.kUD.setOnClickListener(null);
                    if (this.kUl.aXP) {
                        aVar.kUD.setVisibility(8);
                    }
                }
                du = this.kUl.du(su.kPL);
                if (du.equals("0")) {
                    aVar.kUD.setBackgroundColor(this.kUl.getResources().getColor(2131690078));
                    aVar.kUD.setTextColor(this.kUl.getResources().getColor(2131690123));
                } else if (du.equals("-1") || du.equals("3")) {
                    aVar.kUD.setBackgroundDrawable(this.kUl.getResources().getDrawable(2130837805));
                    aVar.kUD.setTextColor(this.kUl.getResources().getColor(2131690123));
                } else if (du.equals("4") || du.equals("2") || du.equals("1")) {
                    aVar.kUD.setBackgroundColor(this.kUl.getResources().getColor(2131690078));
                    aVar.kUD.setTextColor(this.kUl.getResources().getColor(2131689792));
                } else {
                    v.e("MicroMsg.WalletOrderInfoUI", "PromotionsAdapter unknow award state");
                }
            }
            if (aVar.kUD != null) {
                int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.kUl.nDR.nEl, 15.0f);
                int a2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.kUl.nDR.nEl, 5.0f);
                aVar.kUD.setPadding(a, a2, a, a2);
            }
            return view;
        }
    }

    class d {
        public String bfr;
        public String irC;
        public String kLw;
        public String kUG;
        public String kUH;
        public String kUI;
        final /* synthetic */ WalletOrderInfoUI kUl;

        public d(WalletOrderInfoUI walletOrderInfoUI, String str, String str2, String str3, String str4, String str5, String str6) {
            this.kUl = walletOrderInfoUI;
            this.kLw = str;
            this.kUG = str2;
            this.kUH = str3;
            this.kUI = str4;
            this.bfr = str5;
            this.irC = str6;
        }
    }

    protected final int getLayoutId() {
        return 2130904660;
    }

    public void NH() {
        int i = 1;
        boolean z = false;
        com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(this);
        this.kIA = (PayInfo) this.uA.getParcelable("key_pay_info");
        this.hKp = this.uA.getString("key_trans_id");
        int i2 = this.uA.getInt("key_pay_type", -1);
        v.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", new Object[]{this.hKp});
        this.hdo = (Orders) this.uA.getParcelable("key_orders");
        if (this.hKp != null) {
            if (i2 == -1) {
                Dt(this.hKp);
            } else {
                j(new m(this.hKp, i2));
            }
        } else if (this.hdo != null) {
            oa(0);
            this.hdo = (Orders) this.uA.getParcelable("key_orders");
            b(this.hdo);
            if (!(ae == null || this.hdo == null || this.kIA == null)) {
                boolean z2;
                this.dzg = this.kIA.appId;
                boolean bKW = ae.bKW();
                com.tencent.mm.plugin.wallet_core.d.c.a(this, this.uA, 7);
                int i3 = this.uA.getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                g gVar = g.iuh;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.kIA.bkq);
                if (this.kIA.bkq == 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[1] = Boolean.valueOf(z2);
                if (bKW) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                objArr[2] = Integer.valueOf(i2);
                objArr[3] = Integer.valueOf(n.bLh());
                objArr[4] = Integer.valueOf((int) (this.hdo.kOU * 100.0d));
                objArr[5] = this.hdo.hNg;
                objArr[6] = Integer.valueOf(i3);
                gVar.h(10691, objArr);
            }
            if (!((com.tencent.mm.plugin.wallet_core.model.k.bga().bgv() || ae == null || !ae.bKW()) && k.xO())) {
                k.xP();
            }
            if (this.hdo == null || this.hdo.kPm == null || this.hdo.kPm.size() <= 0) {
                v.w("MicroMsg.WalletOrderInfoUI", "mOrders info is Illegal!");
                com.tencent.mm.ui.base.g.a(this.nDR.nEl, 2131236242, 0, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletOrderInfoUI kUl;

                    {
                        this.kUl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kUl.done();
                    }
                });
            } else {
                this.kTW = this.hdo.kPm;
                this.hKp = ((Commodity) this.kTW.get(0)).eWA;
                if (!(this.kIA == null || ae == null)) {
                    if (ae.fNM.getInt("key_pay_flag", 0) != 2) {
                        i = 0;
                    }
                    if (i != 0 || ae.bKW()) {
                        bha();
                    }
                }
            }
            ak.yW();
            Object obj = com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nqc, Boolean.valueOf(false));
            if (obj != null) {
                z = ((Boolean) obj).booleanValue();
            }
            if (z) {
                v.i("MicroMsg.WalletOrderInfoUI", "has show the finger print auth guide!");
                return;
            }
            com.tencent.mm.wallet_core.b ae2 = com.tencent.mm.wallet_core.a.ae(this);
            Bundle bundle = new Bundle();
            if (ae2 != null) {
                bundle = ae2.fNM;
            }
            if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
                v.i("MicroMsg.WalletOrderInfoUI", "pwd is empty, not show the finger print auth guide!");
            } else {
                ae2.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
            }
        } else {
            v.w("MicroMsg.WalletOrderInfoUI", "mOrders info is Illegal!");
            com.tencent.mm.ui.base.g.a(this.nDR.nEl, 2131236242, 0, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletOrderInfoUI kUl;

                {
                    this.kUl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kUl.finish();
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oa(4);
        this.kTZ = new HashSet();
        NH();
        NI();
        gQ(1979);
        com.tencent.mm.sdk.c.a.nhr.e(this.kUk);
        com.tencent.mm.sdk.c.a.nhr.e(this.hLV);
    }

    public void bha() {
        j(new l(bLx()));
    }

    public void Dt(String str) {
        j(new m(str));
    }

    protected final void a(com.tencent.mm.plugin.wallet_core.model.Orders.b bVar) {
        p(new f(bVar, bLx(), this.hKp));
    }

    public final void b(Orders orders) {
        this.kTZ.clear();
        if (orders == null || orders.kPm == null) {
            v.w("MicroMsg.WalletOrderInfoUI", "hy: orders is null");
            return;
        }
        for (Commodity commodity : orders.kPm) {
            if (commodity.kPd == 2 && !be.kS(commodity.kPx)) {
                v.d("MicroMsg.WalletOrderInfoUI", "hy: has username and is force recommend");
                this.kTZ.add(commodity.kPx);
            }
        }
    }

    protected final void NI() {
        vD(2131236271);
        bzV();
        iS(false);
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletOrderInfoUI kUl;

            {
                this.kUl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kUl.done();
                return true;
            }
        });
        this.kTT = (LinearLayout) findViewById(2131759926);
        this.kTU = (TextView) findViewById(2131759927);
        this.kTV = (TextView) findViewById(2131759929);
        MaxListView maxListView = (MaxListView) findViewById(2131759928);
        this.kTX = new a(this);
        maxListView.setAdapter(this.kTX);
        bhb();
        bhe();
        ((ScrollView) findViewById(2131758524)).pageScroll(33);
    }

    public final void bhb() {
        if (this.hdo != null) {
            int i;
            this.kTW = this.hdo.kPm;
            for (Commodity commodity : this.kTW) {
                if ("1".equals(commodity.hMZ)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.kTT.setVisibility(0);
            this.kTU.setVisibility(0);
            if (i == 0) {
                this.kTU.setText(2131236259);
            } else if (!be.kS(this.hdo.kPf) && !be.kS(this.hdo.kPf.trim())) {
                this.kTU.setText(this.hdo.kPf);
            } else if (this.hdo.kLu != 1) {
                this.kTU.setText(2131236258);
            } else {
                this.kTU.setText(2131236257);
            }
        }
    }

    protected final void a(String str, d dVar) {
        bhc();
        this.kUf = dVar;
        e.bi(this, str);
    }

    protected final void Du(String str) {
        bhc();
        e.l(this, str, false);
    }

    public final void bhc() {
        int i = 0;
        if (!this.kTY) {
            hj hjVar = new hj();
            hjVar.bhc.aZt = 4;
            com.tencent.mm.e.a.hj.a aVar = hjVar.bhc;
            if (this.uA.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.aKK = i;
            com.tencent.mm.sdk.c.a.nhr.z(hjVar);
            this.kTY = true;
        }
    }

    public final void G(u uVar) {
        if (uVar != null && ((int) uVar.chr) != 0) {
            String tT = uVar.tT();
            v.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + tT + " username: " + uVar.field_username);
            if (this.kTW != null && this.kTW.size() > 0) {
                for (Commodity commodity : this.kTW) {
                    commodity.hNh = tT;
                }
                this.kTX.notifyDataSetChanged();
            }
            this.dRA = uVar.field_username;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.c.a.nhr.f(this.kUk);
        com.tencent.mm.sdk.c.a.nhr.f(this.hLV);
        gR(1979);
        if (this.hdo != null && !be.kS(this.hdo.username)) {
            com.tencent.mm.model.ab.a.crZ.fD(this.hdo.username);
        }
    }

    public void done() {
        t.a(this.kIA, this.hdo);
        if (this.uA.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.uA.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean a = realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletOrderInfoUI kUl;

                    {
                        this.kUl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kUl.bhd();
                    }
                });
                this.uA.remove("key_realname_guide_helper");
                if (!a) {
                    bhd();
                    return;
                }
                return;
            }
            return;
        }
        bhd();
    }

    public final void bhd() {
        bhc();
        af afVar = new af();
        afVar.aXJ.aXK = true;
        com.tencent.mm.sdk.c.a.nhr.z(afVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.uA.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.uA.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.uA.getBoolean("intent_pay_end"));
        v.i("MicroMsg.WalletOrderInfoUI", "pay done...feedbackData errCode:" + this.uA.getInt("intent_pay_end_errcode"));
        for (String str : this.kTZ) {
            if (!be.kS(str)) {
                v.i("MicroMsg.WalletOrderInfoUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str});
                if (this.hdo == null || this.kIA == null) {
                    ak.vy().a(new h(str), 0);
                } else {
                    ak.vy().a(new h(str, this.hdo.fTG, this.kIA.bkq, this.kIA.bkh, this.hdo.kPd), 0);
                }
            }
            g.iuh.h(13033, new Object[]{Integer.valueOf(2), str, "", "", ""});
        }
        com.tencent.mm.wallet_core.a.k(this, bundle);
        if (this.hdo != null && !be.kS(this.hdo.fwh)) {
            String str2 = this.hdo.kPm.size() > 0 ? ((Commodity) this.hdo.kPm.get(0)).eWA : "";
            str2 = String.format("%sreqkey=%s&transid=%s", new Object[]{this.hdo.fwh, this.hdo.fTG, str2});
            v.d("MicroMsg.WalletOrderInfoUI", "url = " + str2);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", k.xF());
            intent.putExtra("stastic_scene", 8);
            com.tencent.mm.ay.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        done();
        return true;
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131236255), getResources().getStringArray(2131296271), "", new com.tencent.mm.ui.base.g.c(this) {
            final /* synthetic */ WalletOrderInfoUI kUl;

            {
                this.kUl = r1;
            }

            public final void gT(int i) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.kUl.hOz));
                        intent.addFlags(268435456);
                        this.kUl.startActivity(intent);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.WalletOrderInfoUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            j(new com.tencent.mm.plugin.wallet_core.b.n(this.kUf.kLw, this.kUf.kUG, this.kUf.kUH, this.kUf.kUI, this.kUf.bfr, this.kUf.irC));
        }
    }

    private void bhe() {
        if (this.hdo == null || this.hdo.kPm == null || this.hdo.kPm.size() <= 0 || ((Commodity) this.hdo.kPm.get(0)).kPD == null || be.kS(((Commodity) this.hdo.kPm.get(0)).kPD.text) || be.kS(((Commodity) this.hdo.kPm.get(0)).kPD.url)) {
            v.i("MicroMsg.WalletOrderInfoUI", "hy: no commodity or no link act or link act is illegal!");
            this.kTV.setVisibility(8);
            return;
        }
        this.kTV.setVisibility(0);
        this.kTV.setText(((Commodity) this.hdo.kPm.get(0)).kPD.text);
        this.kTV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletOrderInfoUI kUl;

            {
                this.kUl = r1;
            }

            public final void onClick(View view) {
                e.l(this.kUl, ((Commodity) this.kUl.hdo.kPm.get(0)).kPD.url, false);
            }
        });
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_core.b.n) && i == 0 && i2 == 0) {
            com.tencent.mm.plugin.wallet_core.b.n nVar = (com.tencent.mm.plugin.wallet_core.b.n) kVar;
            b bVar = new b(this, nVar.kLx);
            boolean z = (be.kS(bVar.url) || be.kS(bVar.bhe)) ? false : true;
            if (z) {
                this.kUg.put(nVar.kLw, bVar);
            }
            this.kTX.notifyDataSetChanged();
        }
        if (kVar instanceof m) {
            if (i == 0 && i2 == 0) {
                oa(0);
                this.hdo = ((m) kVar).kLv;
                if (this.hdo != null) {
                    this.kTW = this.hdo.kPm;
                }
                b(this.hdo);
                v.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + this.kTW);
                if (!(this.kTW == null || this.kTW.size() == 0)) {
                    Commodity commodity = (Commodity) this.kTW.get(0);
                    this.hKp = commodity.eWA;
                    v.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + commodity.toString());
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(commodity.hNh);
                    if (LX == null || ((int) LX.chr) == 0) {
                        com.tencent.mm.model.ab.a.crZ.a(commodity.hNh, "", this.kUh);
                    } else {
                        G(LX);
                    }
                    this.kTX.notifyDataSetChanged();
                    bhb();
                }
            }
            if (this.kTX != null) {
                this.kTX.notifyDataSetChanged();
            }
            bhe();
            return true;
        }
        if (kVar instanceof f) {
            if (i == 0 && i2 == 0) {
                f fVar = (f) kVar;
                String str2 = fVar.kLk;
                this.kUe.put(Long.valueOf(fVar.kLj.kPL), str2);
                fVar.kLj.kPJ = fVar.eOP;
                if (!"-1".equals(str2) && !"0".equals(str2) && !be.kS(fVar.kLl)) {
                    com.tencent.mm.ui.base.g.A(this, fVar.kLl, "");
                } else if ("0".equals(str2)) {
                    CharSequence string;
                    if (be.kS(fVar.kLl)) {
                        string = getString(2131236325);
                    } else {
                        string = fVar.kLl;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                this.kTX.notifyDataSetChanged();
                return true;
            } else if (kVar instanceof f) {
                if (be.kS(str)) {
                    str = getString(2131236492);
                }
                com.tencent.mm.ui.base.g.a(this, str, null, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletOrderInfoUI kUl;

                    {
                        this.kUl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        }
        return false;
    }

    public final String du(long j) {
        if (this.kUe.containsKey(Long.valueOf(j))) {
            return (String) this.kUe.get(Long.valueOf(j));
        }
        return "-1";
    }
}
