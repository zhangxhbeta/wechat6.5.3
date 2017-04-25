package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.d.n;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.e.p;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class BaseEmojiStoreUI extends EmojiBaseActivity implements OnScrollListener, OnItemClickListener, com.tencent.mm.plugin.emoji.model.f.a, com.tencent.mm.plugin.emoji.model.f.b, com.tencent.mm.pluginsdk.model.f.a, com.tencent.mm.sdk.h.g.a, c, d, e, com.tencent.mm.v.e {
    private static Map<String, Long> ffX;
    protected ListView Eq;
    protected View dZV;
    private ProgressDialog eZg;
    com.tencent.mm.plugin.emoji.a.a.a fcY;
    private com.tencent.mm.plugin.emoji.h.b fdh;
    protected EmojiStoreVpHeader ffA;
    protected View ffB;
    protected StoreBannerEmojiView ffC;
    protected MMPullDownView ffD;
    protected TextView ffE;
    protected boolean ffF = false;
    int ffG = -1;
    private boolean ffH;
    private View ffI;
    byte[] ffJ;
    private final int ffK = 65537;
    private final int ffL = 20001;
    private final int ffM = 2002;
    protected final int ffN = 131074;
    private final int ffO = 131075;
    private final int ffP = 131076;
    private final String ffQ = "product_id";
    private final String ffR = "progress";
    private final String ffS = "status";
    private m ffT;
    private int ffU;
    private com.tencent.mm.plugin.emoji.model.e ffV;
    private f ffW;
    private com.tencent.mm.sdk.c.c ffY;
    protected g ffZ;
    protected boolean fga = false;
    private LinkedList<oa> fgb = new LinkedList();
    private LinkedList<oc> fgc = new LinkedList();

    private class a extends com.tencent.mm.sdk.c.c<cb> {
        final /* synthetic */ BaseEmojiStoreUI fgf;

        private a(BaseEmojiStoreUI baseEmojiStoreUI) {
            this.fgf = baseEmojiStoreUI;
            this.nhz = cb.class.getName().hashCode();
        }

        /* synthetic */ a(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
            this(baseEmojiStoreUI);
            this.nhz = cb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            cb cbVar = (cb) bVar;
            this.fgf.e(cbVar.aZC.aZD, cbVar.aZC.status, cbVar.aZC.progress, cbVar.aZC.aZE);
            return false;
        }
    }

    private class b implements OnMenuItemClickListener {
        final /* synthetic */ BaseEmojiStoreUI fgf;

        private b(BaseEmojiStoreUI baseEmojiStoreUI) {
            this.fgf = baseEmojiStoreUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.fgf.finish();
            return true;
        }
    }

    public abstract int agc();

    public abstract int agd();

    public abstract com.tencent.mm.plugin.emoji.a.a.a age();

    public abstract int agm();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ffW = new f();
        NI();
        this.ffU = getIntent().getIntExtra("preceding_scence", 2);
        if (com.tencent.mm.plugin.emoji.model.g.afx().fci != null) {
            com.tencent.mm.plugin.emoji.model.g.afx().fci.c(this);
        }
        this.ffY = new a();
        com.tencent.mm.sdk.c.a.nhr.e(this.ffY);
        this.ffW.fda = this;
        this.ffW.fcY = this.fcY;
        this.ffW.fdc = agc();
        this.ffW.fdf = this;
        boolean agw = agw();
        if (agw) {
            agw = agr();
        }
        k(false, agw);
        if (ffX == null) {
            ffX = new HashMap();
        }
        v.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        ffX.put(getClass().toString(), Long.valueOf(r0));
        this.fdh = new com.tencent.mm.plugin.emoji.h.b(1005);
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(411, this);
        ak.vy().a(423, this);
        ak.vy().a(413, this);
        ak.vy().a(717, this);
        if (agj() && this.ffA != null) {
            this.ffA.ahf();
        }
        Boolean.valueOf(false);
        this.ffW.fcZ = false;
        if (this.fcY != null && this.fcY.eZW != null) {
            this.fcY.eZW.aeO();
            this.fcY.acO();
        }
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(411, this);
        ak.vy().b(423, this);
        ak.vy().b(413, this);
        ak.vy().b(717, this);
        agp();
        if (agj() && this.ffA != null) {
            this.ffA.ahg();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.fcY != null) {
            this.fcY.clear();
            this.fcY = null;
        }
        if (agj() && this.ffA != null) {
            this.ffA.clear();
        }
        com.tencent.mm.plugin.emoji.model.g.afx().fci.d(this);
        com.tencent.mm.sdk.c.a.nhr.f(this.ffY);
        ak.vy().c(this.ffZ);
        if (this.ffW != null) {
            f fVar = this.ffW;
            fVar.fcY = null;
            fVar.fdf = null;
            fVar.fda = null;
        }
    }

    protected int getLayoutId() {
        return 2130903488;
    }

    public void a(int i, int i2, String str, k kVar) {
        int i3 = -1;
        String str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str3 = "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        v.i(str2, str3, objArr);
        agt();
        switch (kVar.getType()) {
            case 411:
                m mVar = (m) kVar;
                if (mVar == null || mVar.mType != agm()) {
                    str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
                    str3 = "no some scene type. this ui type:%d callbak type:%d";
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(agm());
                    if (mVar != null) {
                        i3 = mVar.mType;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    v.i(str2, str3, objArr);
                    return;
                }
                this.ffH = false;
                this.ffI.setVisibility(8);
                com.tencent.mm.plugin.emoji.model.e eVar = null;
                try {
                    eVar = m.a(mVar.afP());
                } catch (Exception e) {
                    v.j("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", new Object[]{e.toString()});
                }
                if (eVar != null) {
                    boolean z = i == 0 || i == 4;
                    if (z) {
                        this.dZV.setVisibility(8);
                        this.ffF = false;
                        this.ffJ = mVar.fek;
                        vt afP;
                        if (i2 == 0) {
                            afP = mVar.afP();
                            a(eVar, false, true);
                            b(afP);
                            this.ffG = 0;
                            return;
                        } else if (i2 == 2) {
                            afP = mVar.afP();
                            a(this.ffG, eVar, false, false);
                            agl();
                            b(afP);
                            this.ffG = 2;
                            return;
                        } else if (i2 == 3) {
                            a(this.ffG, eVar, false, false);
                            this.ffG = 1;
                            return;
                        } else {
                            this.dZV.setVisibility(0);
                            this.ffF = true;
                            if (agm() == 7) {
                                this.ffE.setText(2131232417);
                                return;
                            } else {
                                this.ffE.setText(2131232382);
                                return;
                            }
                        }
                    }
                }
                if (!this.fga) {
                    this.dZV.setVisibility(0);
                    this.ffF = true;
                    this.ffE.setText(2131232383);
                    return;
                }
                return;
            case 413:
                p pVar = (p) kVar;
                Message message;
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.plugin.emoji.model.g.afx().fci.NA(pVar.fdU);
                    message = new Message();
                    message.what = 2002;
                    message.obj = this.nDR.nEl.getString(2131231168);
                    h(message);
                } else {
                    message = new Message();
                    message.what = 2002;
                    message.obj = this.nDR.nEl.getString(2131232339);
                    h(message);
                }
                by(20001, 800);
                return;
            case 423:
                g gVar = (g) kVar;
                if (i == 0 && i2 == 0) {
                    a(gVar);
                    return;
                }
                str2 = gVar.fdU;
                str3 = gVar.fdW;
                final String str4 = gVar.fdV;
                com.tencent.mm.ui.base.g.a(this, getString(2131232377, new Object[]{str4}), "", new OnClickListener(this) {
                    final /* synthetic */ BaseEmojiStoreUI fgf;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.fgf.C(str2, str3, str4);
                        this.fgf.agq();
                        v.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str2});
                        this.fgf.ao(str2, 0);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ BaseEmojiStoreUI fgf;

                    {
                        this.fgf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                an(gVar.fdU, -1);
                return;
            case 717:
                if (i == 0 && i2 == 0) {
                    this.ffJ = null;
                    k(false, true);
                    return;
                }
                return;
            default:
                v.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (agj()) {
            if (i != 0) {
                i--;
            } else {
                return;
            }
        }
        if (i >= 0 && i < this.fcY.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f jG = this.fcY.jG(i);
            if (jG == null) {
                v.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
            } else if (jG.fah == com.tencent.mm.plugin.emoji.a.a.f.a.faq) {
                oc ocVar = jG.faj;
                if (ocVar == null) {
                    v.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
                } else {
                    n.a(this.nDR.nEl, ocVar, false);
                }
            } else {
                ol olVar = jG.fai;
                if (olVar == null) {
                    v.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
                    return;
                }
                n.a(this.nDR.nEl, olVar, agc(), jG.mStatus, jG.rT, getIntent().getStringExtra("to_talker_name"), agd());
            }
        }
    }

    protected void agb() {
        this.fcY = age();
        this.fcY.eZX = this;
    }

    protected void rH(String str) {
    }

    protected void agf() {
    }

    protected void agg() {
        if (agh()) {
            this.ffD = (MMPullDownView) findViewById(2131756685);
            if (this.ffD != null) {
                this.ffD.jr(false);
                this.ffD.nXg = this;
                this.ffD.nWU = this;
                this.ffD.nXf = this;
                this.ffD.jq(false);
                this.ffD.jp(false);
            }
        }
    }

    protected boolean agh() {
        return true;
    }

    public void NI() {
        b(new b());
        agb();
        this.dZV = findViewById(2131755597);
        this.ffE = (TextView) this.dZV.findViewById(2131756681);
        this.ffI = getLayoutInflater().inflate(2130903487, null);
        this.ffI.setVisibility(8);
        if (agj()) {
            this.ffA = new EmojiStoreVpHeader(this.nDR.nEl);
        }
        if (agk()) {
            this.ffB = LayoutInflater.from(this).inflate(2130903516, null);
            int i = EmojiStoreVpHeader.aG(this.nDR.nEl)[0];
            this.ffB.setLayoutParams(new LayoutParams(i, ((i * 3) / 8) + 1));
            this.ffC = (StoreBannerEmojiView) this.ffB.findViewById(2131756697);
        }
        this.Eq = (ListView) findViewById(16908298);
        this.Eq.setOnItemClickListener(this);
        if (agj()) {
            this.Eq.addHeaderView(this.ffA);
        } else if (agk()) {
            this.Eq.addHeaderView(this.ffB);
        }
        if (agx()) {
            this.Eq.addFooterView(this.ffI);
        }
        agf();
        this.Eq.setAdapter(this.fcY);
        this.Eq.setOnScrollListener(this);
        this.fcY.eZV = this.Eq;
        agg();
    }

    protected final void k(boolean z, boolean z2) {
        m mVar;
        this.ffH = true;
        if (z) {
            this.ffI.setVisibility(0);
        }
        Object obj = this.ffJ;
        int agm = agm();
        int ago = ago();
        int agn = agn();
        if (obj != null) {
            v.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[]{obj.toString()});
            mVar = new m(agm, obj, ago);
            if (agm == 7) {
                mVar.fem = agn;
            }
        } else {
            v.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
            mVar = new m(agm, ago);
            if (agm == 7) {
                mVar.fem = agn;
            }
        }
        this.ffT = mVar;
        ak.vy().a(this.ffT, 0);
        v.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z && !z2) {
            ags();
        }
    }

    public final boolean agi() {
        k(true, false);
        v.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
        return true;
    }

    public final void f(Message message) {
        switch (message.what) {
            case 2002:
                String str = (String) message.obj;
                if (isFinishing()) {
                    v.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
                    return;
                } else if (this.eZg != null) {
                    this.eZg.setMessage(str);
                    return;
                } else {
                    return;
                }
            case 20001:
                agt();
                return;
            case 65537:
                c((vt) message.obj);
                return;
            default:
                return;
        }
    }

    public void g(Message message) {
        String string;
        switch (message.what) {
            case 131074:
                if (this.fcY != null) {
                    this.fcY.notifyDataSetChanged();
                    agy();
                    return;
                }
                return;
            case 131075:
                if (this.fcY != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.fcY.ao(string, message.getData().getInt("progress"));
                        return;
                    }
                    return;
                }
                return;
            case 131076:
                if (this.fcY != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.fcY.an(string, message.getData().getInt("status"));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected boolean agj() {
        return true;
    }

    protected boolean agk() {
        return false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.ffG == 0 || this.ffH) {
            v.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
            return;
        }
        k(true, false);
        v.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    private void agl() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.fcY.eZW, (com.tencent.mm.pluginsdk.model.f.a) this);
    }

    protected void a(g gVar) {
        ao(gVar.fdU, 0);
    }

    private void ao(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        h(obtain);
    }

    private void an(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("status", i);
        obtain.what = 131076;
        h(obtain);
    }

    protected final g C(String str, String str2, String str3) {
        this.ffZ = new g(str, str2, str3);
        return this.ffZ;
    }

    public int agn() {
        return 0;
    }

    protected int ago() {
        if (this.ffU == 1) {
            return 1;
        }
        return 2;
    }

    protected final void agp() {
        ak.vy().c(this.ffT);
    }

    protected final void agq() {
        ak.vy().a(this.ffZ, 0);
    }

    protected boolean agr() {
        vt vo = com.tencent.mm.plugin.emoji.model.g.afx().fck.vo(agm());
        com.tencent.mm.plugin.emoji.model.e a = m.a(vo);
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "load cache type: %d, size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(agm());
        objArr[1] = Integer.valueOf(vo == null ? 0 : vo.myh);
        v.d(str, str2, objArr);
        if (a == null) {
            return false;
        }
        boolean z;
        if (a.fcT.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            v.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[]{Integer.valueOf(a.fcT.size())});
            a(a, true, false);
            return z;
        }
        v.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
        return z;
    }

    protected final void ags() {
        if (isFinishing()) {
            v.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(2131231164);
        this.eZg = com.tencent.mm.ui.base.g.a(this, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ BaseEmojiStoreUI fgf;

            {
                this.fgf = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.fgf.agp();
                ak.vy().cancel(413);
            }
        });
    }

    protected final void agt() {
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
    }

    protected void a(com.tencent.mm.plugin.emoji.model.e eVar, boolean z, boolean z2) {
        v.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
        if (eVar != null && eVar.fcT.size() > 0) {
            this.fga = true;
            this.dZV.setVisibility(8);
            this.ffF = false;
        }
        a(this.ffG, eVar, z, z2);
        agl();
    }

    private void a(int i, com.tencent.mm.plugin.emoji.model.e eVar, boolean z, boolean z2) {
        boolean z3 = false;
        v.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
        switch (i) {
            case -1:
                this.ffV = eVar;
                break;
            case 1:
                this.ffV = eVar;
                break;
            case 2:
                if (this.ffV == null) {
                    this.ffV = new com.tencent.mm.plugin.emoji.model.e();
                }
                if (eVar != null) {
                    this.ffV.jM(eVar.fcS);
                    this.ffV.ak(eVar.fcT);
                    break;
                }
                break;
            default:
                if (this.ffV != null) {
                    this.ffV.afn();
                }
                a(z3, this.ffV, z, z2);
        }
        z3 = true;
        if (this.ffV != null) {
            this.ffV.afn();
        }
        a(z3, this.ffV, z, z2);
    }

    protected void a(boolean z, com.tencent.mm.plugin.emoji.model.e eVar, boolean z2, boolean z3) {
        if (this.ffV != null && z) {
            if (agj()) {
                if (this.ffV == null || this.ffV.fcU == null || this.ffV.fcU.mpR == null) {
                    v.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
                } else {
                    this.fgb = (LinkedList) this.ffV.fcV;
                    this.fgc = (LinkedList) this.ffV.fcW;
                    if (this.fgb != null) {
                        this.ffA.b(this.fgb, this.fgc);
                    } else if (this.ffV.fcU != null) {
                        this.fgb = new LinkedList();
                        this.fgb.add(this.ffV.fcU);
                        this.ffA.b(this.fgb, this.fgc);
                    }
                }
            }
            if (this.fcY != null) {
                this.fcY.b(this.ffV);
            }
        }
    }

    private void b(vt vtVar) {
        if (this.ffG == -1) {
            Message obtain = Message.obtain();
            obtain.what = 65537;
            obtain.obj = vtVar;
            if (this.fgQ != null) {
                this.fgQ.sendMessage(obtain);
            }
        }
    }

    protected void c(vt vtVar) {
        int i = 0;
        if (vtVar != null) {
            String str = "MicroMsg.emoji.BaseEmojiStoreUI";
            String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(vtVar == null ? 0 : vtVar.myh);
            if (!(vtVar == null || vtVar.mcz == null)) {
                i = vtVar.mcz.aHr();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(agm());
            v.d(str, str2, objArr);
            com.tencent.mm.plugin.emoji.model.g.afx().fck.a(agm(), vtVar);
        }
    }

    public final boolean agu() {
        return false;
    }

    public final boolean agv() {
        return false;
    }

    public void a(String str, i iVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group")) {
            agG();
            by(131074, 50);
        }
    }

    public void e(String str, int i, int i2, String str2) {
        v.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        if (this.fcY != null && this.fcY.eZW != null) {
            if (i == 6) {
                ao(str, i2);
            } else {
                v.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[]{Integer.valueOf(i)});
                an(str, i);
            }
            com.tencent.mm.plugin.emoji.a.a.f qY = this.fcY.eZW.qY(str);
            if (qY != null) {
                qY.fal = str2;
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.aex();
        objArr[1] = TextUtils.isEmpty(aVar.aez()) ? "" : aVar.aez();
        objArr[2] = Integer.valueOf(aVar.aey());
        v.i(str, str2, objArr);
        if (aVar.aey() == 9) {
            String string = getString(2131231169);
            if (isFinishing()) {
                v.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            } else {
                getString(2131231164);
                this.eZg = com.tencent.mm.ui.base.g.a(this, string, true, new OnCancelListener(this) {
                    final /* synthetic */ BaseEmojiStoreUI fgf;

                    {
                        this.fgf = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().cancel(413);
                    }
                });
            }
        }
        this.ffW.a(aVar);
    }

    protected boolean agw() {
        return false;
    }

    public final void y(ArrayList<o> arrayList) {
        v.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
        if (this.fcY != null) {
            com.tencent.mm.plugin.emoji.a.a.b.a((ArrayList) arrayList, this.fcY.eZW);
            if (this.fgR != null) {
                this.fgR.removeMessages(131074);
                this.fgR.sendEmptyMessage(131074);
            }
        }
    }

    public final void B(String str, String str2, String str3) {
        C(str, str2, str3);
        agq();
    }

    public final void afo() {
        this.ffJ = null;
        this.ffG = -1;
        k(false, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        this.ffW.onActivityResult(i, i2, intent);
    }

    protected boolean agx() {
        return true;
    }

    public void agy() {
    }
}
