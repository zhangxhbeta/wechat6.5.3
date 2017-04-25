package com.tencent.mm.plugin.offline.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.af;
import com.tencent.mm.e.a.bh;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.qn;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.offline.a.j;
import com.tencent.mm.plugin.offline.a.n.d;
import com.tencent.mm.plugin.offline.b;
import com.tencent.mm.plugin.offline.b.a;
import com.tencent.mm.plugin.offline.h;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.c.am;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class WalletOfflineCoinPurseUI extends WalletBaseUI implements com.tencent.mm.platformtools.j.a, com.tencent.mm.plugin.offline.a.n.a, b, a, com.tencent.mm.sdk.platformtools.as.a {
    private static int dVG = 0;
    private long bYQ = 0;
    private int cKI = -1;
    private boolean dMT;
    private OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI hLY;

        {
            this.hLY = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == 2131759916 || view.getId() == 2131759921 || view.getId() == 2131759915) {
                if (view.getId() == 2131759916 && this.hLY.hLT != null && this.hLY.hLT.getVisibility() == 0) {
                    v.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hLY.bYQ >= 400 && com.tencent.mm.plugin.offline.b.a.aFk() && !this.hLY.aFc()) {
                    if (view.getId() == 2131759916) {
                        this.hLY.eIt = false;
                    } else if (view.getId() == 2131759915) {
                        this.hLY.eIt = true;
                    }
                    if (this.hLY.hLR != null) {
                        this.hLY.aFd();
                        this.hLY.hLR.r(view, this.hLY.eIt);
                    }
                    this.hLY.bYQ = currentTimeMillis;
                }
            } else if (view.getId() == 2131759919) {
                this.hLY.aFh();
            }
        }
    };
    private boolean eIt = true;
    private String hJK = "";
    private String hJU = "";
    private j hJW;
    private int hJY = 60000;
    private ah hJZ = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI hLY;

        {
            this.hLY = r1;
        }

        public final boolean oU() {
            this.hLY.nP(0);
            this.hLY.avT();
            this.hLY.hJZ.ea((long) this.hLY.hJY);
            return false;
        }
    }, false);
    Bitmap hLA = null;
    Bitmap hLB = null;
    private a hLC;
    private ArrayList<String> hLD = new ArrayList();
    private ArrayList<String> hLE = new ArrayList();
    private ArrayList<Boolean> hLF = new ArrayList();
    private View hLG;
    private ImageView hLH;
    private ImageView hLI;
    private TextView hLJ;
    private TextView hLK;
    private View hLL;
    private TextView hLM;
    private ImageView hLN;
    private String hLO = "";
    private ArrayList<Bitmap> hLP = new ArrayList();
    private ArrayList<Bitmap> hLQ = new ArrayList();
    private c hLR;
    private c hLS;
    private OfflineAlertView hLT;
    private boolean hLU = false;
    private com.tencent.mm.sdk.c.c hLV = new com.tencent.mm.sdk.c.c<qn>(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI hLY;

        {
            this.hLY = r2;
            this.nhz = qn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            qn qnVar = (qn) bVar;
            if (qnVar instanceof qn) {
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
                    if ("1".equals((String) qnVar.bsb.bsc.get(".sysmsg.paymsg.guide_block"))) {
                        v.i("MicroMsg.WalletOfflineCoinPurseUI", "block pass");
                        return true;
                    }
                }
                WalletOfflineCoinPurseUI.a(this.hLY, qnVar.bsb);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c hLW = new com.tencent.mm.sdk.c.c<af>(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI hLY;

        {
            this.hLY = r2;
            this.nhz = af.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            af afVar = (af) bVar;
            if (com.tencent.mm.plugin.offline.b.a.hMk != 3 || !(afVar instanceof af) || !afVar.aXJ.aXK) {
                return false;
            }
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "finish button event!");
            this.hLY.finish();
            return true;
        }
    };
    private ah hLX = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI hLY;

        {
            this.hLY = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[]{Boolean.valueOf(this.hLY.dMT)});
            if (this.hLY.dMT) {
                bh bhVar = new bh();
                bhVar.aYO.aKK = 0;
                com.tencent.mm.sdk.c.a.nhr.z(bhVar);
            }
            this.hLY.finish();
            return false;
        }
    }, false);
    private HashMap<String, View> hLy = new HashMap();
    private HashMap<String, Integer> hLz = new HashMap();
    private int mState = 3;

    class a extends BaseAdapter {
        ArrayList<String> dQG = new ArrayList();
        final /* synthetic */ WalletOfflineCoinPurseUI hLY;
        ArrayList<Boolean> hMb = new ArrayList();

        public a(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
            this.hLY = walletOfflineCoinPurseUI;
        }

        public final int getCount() {
            return this.dQG.size();
        }

        public final Object getItem(int i) {
            return this.dQG.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            return ((Boolean) this.hMb.get(i)).booleanValue();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.hLY, 2130904652, null);
            checkedTextView.setText((String) this.dQG.get(i));
            if (WalletOfflineCoinPurseUI.dVG == i) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            if (isEnabled(i)) {
                checkedTextView.setTextColor(this.hLY.getResources().getColor(2131689909));
                checkedTextView.setEnabled(true);
            } else {
                checkedTextView.setTextColor(this.hLY.getResources().getColor(2131689792));
                checkedTextView.setEnabled(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ boolean a(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, com.tencent.mm.e.a.qn.a aVar) {
        if ("1".equals(aVar.brU)) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
            bundle.putString("realname_verify_process_jump_plugin", "wallet");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(walletOfflineCoinPurseUI, aVar.brV, aVar.brW, aVar.brX, bundle, walletOfflineCoinPurseUI.ayJ(), null, 0, 2);
        } else if ("2".equals(aVar.brU)) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "need upload credit");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(walletOfflineCoinPurseUI, aVar.brV, aVar.brY, aVar.brW, aVar.brX, walletOfflineCoinPurseUI.ayJ(), null);
        } else {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "realnameGuideFlag =  " + aVar.brU);
            return false;
        }
    }

    protected /* synthetic */ Dialog onCreateDialog(final int i) {
        View inflate = getLayoutInflater().inflate(2130904651, null);
        ListView listView = (ListView) inflate.findViewById(2131755317);
        if (this.hLC == null) {
            this.hLC = new a(this);
        }
        if (i == 1) {
            a aVar = this.hLC;
            Collection collection = this.hLD;
            Collection collection2 = this.hLF;
            if (collection != null) {
                aVar.dQG.clear();
                aVar.dQG.addAll(collection);
            }
            if (collection2 != null) {
                aVar.hMb.clear();
                aVar.hMb.addAll(collection2);
            }
        }
        listView.setAdapter(this.hLC);
        this.hLC.notifyDataSetChanged();
        listView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI hLY;

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.hLY.dismissDialog(i);
                WalletOfflineCoinPurseUI.dVG = i;
                if (i == 1) {
                    String str = (String) this.hLY.hLE.get(i);
                    if (!TextUtils.isEmpty(str) && !str.equals(this.hLY.hJK)) {
                        this.hLY.hJK = str;
                        com.tencent.mm.plugin.offline.b.a.xr(this.hLY.hJK);
                        com.tencent.mm.plugin.offline.j.aEM();
                        com.tencent.mm.plugin.offline.j.aEO().hJK = this.hLY.hJK;
                        this.hLY.aFg();
                        this.hLY.nP(0);
                        this.hLY.avT();
                    }
                }
            }
        });
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(this);
        if (i == 1) {
            aVar2.wm(2131236521);
        }
        aVar2.cC(inflate);
        aVar2.c(null);
        return aVar2.RX();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.yD(41);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("key_entry_scene")) {
            this.cKI = intent.getIntExtra("key_entry_scene", this.cKI);
        }
        com.tencent.mm.pluginsdk.g.a.O(this);
        oa(0);
        cU().cV().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131690105)));
        View customView = cU().cV().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(2131755264);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(2131689783));
            }
            customView = customView.findViewById(16908309);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(2131690127));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(2131690107));
        }
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        e.bLF();
        if (k.bga().bgu()) {
            v.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
            p(new l(null));
        } else if (k.bga().bgs()) {
            v.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
            com.tencent.mm.plugin.offline.b.a.aFu();
            com.tencent.mm.plugin.offline.j.aEM();
            com.tencent.mm.plugin.offline.j.T(196648, "0");
        } else if (k.bga().bgv() && com.tencent.mm.plugin.offline.b.a.aFk()) {
            aFi();
        }
        NI();
        com.tencent.mm.platformtools.j.a(this);
        com.tencent.mm.plugin.offline.j.aEM();
        com.tencent.mm.plugin.offline.j.aEN().a(this);
        gQ(606);
        gQ(609);
        com.tencent.mm.plugin.offline.j.aEM();
        com.tencent.mm.plugin.offline.j.aEO().aS(this);
        com.tencent.mm.sdk.c.a.nhr.e(this.hLW);
        com.tencent.mm.plugin.offline.b.a.aFv();
    }

    public void onResume() {
        boolean z;
        super.onResume();
        com.tencent.mm.sdk.c.a.nhr.e(this.hLV);
        as.a(this);
        if (!this.hLU) {
            ak.yW();
            if (!((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.ntq, Boolean.valueOf(false))).booleanValue()) {
                this.hLT.bV(this.hLG);
            }
            this.hLU = true;
        }
        v.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
        this.dMT = true;
        com.tencent.mm.pluginsdk.g.a.a(this, com.tencent.mm.pluginsdk.g.b.bmN());
        if (com.tencent.mm.sdk.platformtools.ak.isNetworkConnected(getBaseContext())) {
            if (k.bga().bgu()) {
                p(new l(null));
            }
            if (com.tencent.mm.plugin.offline.b.a.aFk()) {
                com.tencent.mm.plugin.offline.j.aEM();
                com.tencent.mm.plugin.offline.j.aEP().aEL();
                if (!c.aEW()) {
                    aFe();
                }
            }
        }
        aFb();
        Bankcard aFm = com.tencent.mm.plugin.offline.b.a.aFm();
        if (aFm == null || aFm.field_bindSerial == null || aFm.field_bindSerial.equals(this.hJK)) {
            z = false;
        } else {
            this.hJK = aFm.field_bindSerial;
            com.tencent.mm.plugin.offline.j.aEM();
            com.tencent.mm.plugin.offline.j.aEO().hJK = this.hJK;
            z = true;
        }
        if (z) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
            aFg();
            nP(0);
            avT();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        v.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
    }

    public void onPause() {
        com.tencent.mm.plugin.offline.j.aEM();
        h aEP = com.tencent.mm.plugin.offline.j.aEP();
        aEP.mHandler.removeCallbacks(aEP.hJX);
        as.a(null);
        this.dMT = false;
        com.tencent.mm.sdk.c.a.nhr.f(this.hLV);
        super.onPause();
    }

    public void onDestroy() {
        e.l(this.hLA);
        e.l(this.hLB);
        e.ae(this.hLP);
        e.ae(this.hLQ);
        this.hLP.clear();
        this.hLQ.clear();
        this.hLD.clear();
        this.hLE.clear();
        this.hLF.clear();
        com.tencent.mm.platformtools.j.c(this);
        com.tencent.mm.plugin.offline.j.aEM();
        com.tencent.mm.plugin.offline.j.aEN().b((com.tencent.mm.plugin.offline.a.n.a) this);
        gR(606);
        gR(609);
        com.tencent.mm.plugin.offline.j.aEM();
        com.tencent.mm.plugin.offline.j.aEO().aT(this);
        com.tencent.mm.sdk.c.a.nhr.f(this.hLW);
        if (!this.hJZ.btC()) {
            this.hJZ.QI();
        }
        if (!this.hLX.btC()) {
            this.hLX.QI();
        }
        if (this.hLR != null) {
            this.hLR.release();
        }
        if (this.hLS != null) {
            c cVar = this.hLS;
            cVar.ewK.cancel();
            cVar.pP = null;
        }
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + i + "  errCode" + i2 + " errMsg:" + str);
        if ((kVar instanceof com.tencent.mm.plugin.offline.a.c) && ((i == 0 && i2 == 0) || i != 0)) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.hJW.aER();
            this.hJW = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof l) {
                if (com.tencent.mm.plugin.offline.b.a.aFk()) {
                    if (com.tencent.mm.plugin.offline.b.a.aFn() != null) {
                        aFe();
                    }
                    aFi();
                }
            } else if (kVar instanceof j) {
                this.hJW = (j) kVar;
                String str2 = this.hJW.hKS;
                com.tencent.mm.plugin.offline.j.aEM();
                ak.vy().a(new com.tencent.mm.plugin.offline.a.c(str2, com.tencent.mm.plugin.offline.j.nO(196617)), 0);
            } else if (kVar instanceof com.tencent.mm.plugin.offline.a.k) {
                com.tencent.mm.plugin.offline.a.k kVar2 = (com.tencent.mm.plugin.offline.a.k) kVar;
                if ("1".equals(kVar2.hKV)) {
                    v.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. show alert to finish");
                    g.a(this, be.kS(kVar2.hKW) ? getString(2131236155) : kVar2.hKW, "", false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletOfflineCoinPurseUI hLY;

                        {
                            this.hLY = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.hLY.finish();
                        }
                    });
                } else if (kVar2.hKs == 0) {
                    c cVar = this.hLS;
                    cVar.hLt = (float) com.tencent.mm.plugin.offline.b.a.aFq();
                    cVar.hLt = cVar.hLt;
                    if ("1".equals(kVar2.hKU)) {
                        v.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
                        b(new j(((int) (System.currentTimeMillis() / 1000)), 8), false);
                    }
                } else if (kVar2.hKs != 0) {
                    this.hLS.q(kVar2.hKs, kVar2.hKt, null);
                }
            } else if (!(kVar instanceof com.tencent.mm.plugin.offline.a.a) && (kVar instanceof com.tencent.mm.plugin.offline.a.b)) {
                this.hLS.d(i, i2, str, kVar);
            }
            if ((kVar instanceof l) || (kVar instanceof com.tencent.mm.plugin.offline.a.k) || (kVar instanceof com.tencent.mm.plugin.offline.a.a) || (kVar instanceof com.tencent.mm.plugin.offline.a.b)) {
                aFb();
                aEZ();
            }
        } else if (kVar instanceof com.tencent.mm.plugin.offline.a.k) {
            aFb();
            aEZ();
            if (411 == i2) {
                this.hLS.q(i2, str, null);
            }
        } else if (kVar instanceof com.tencent.mm.plugin.offline.a.b) {
            this.hLS.d(i, i2, str, kVar);
        } else if (!(kVar instanceof com.tencent.mm.plugin.offline.a.g) && (kVar instanceof com.tencent.mm.plugin.offline.a.c)) {
            this.hJW = null;
        }
        return true;
    }

    protected final int getLayoutId() {
        return 2130904656;
    }

    protected final void NI() {
        this.hLT = (OfflineAlertView) findViewById(2131759920);
        this.hLT.dismiss();
        this.hLT.hLn = new com.tencent.mm.plugin.offline.ui.OfflineAlertView.a(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI hLY;

            {
                this.hLY = r1;
            }

            public final void onClose() {
                this.hLY.aEY();
            }

            public final void aEU() {
                this.hLY.aEY();
            }
        };
        com.tencent.mm.wallet_core.b.a.bKZ();
        com.tencent.mm.wallet_core.b.a.init(getApplicationContext());
        vD(2131236529);
        vE(2131236646);
        this.hLS = new c(this, this);
        c cVar = this.hLS;
        cVar.ewK = (Vibrator) cVar.pP.getSystemService("vibrator");
        this.hLR = new c(this);
        this.hLR.init();
        this.hLG = findViewById(2131759913);
        this.hLH = (ImageView) findViewById(2131759916);
        this.hLI = (ImageView) findViewById(2131759915);
        this.hLJ = (TextView) findViewById(2131759914);
        this.hLK = (TextView) findViewById(2131759921);
        this.hLL = findViewById(2131759917);
        this.hLM = (TextView) findViewById(2131759919);
        this.hLN = (ImageView) findViewById(2131759918);
        this.hLH.setOnClickListener(this.eFl);
        this.hLI.setOnClickListener(this.eFl);
        this.hLK.setOnClickListener(this.eFl);
        this.hLM.setOnClickListener(this.eFl);
        this.bYQ = System.currentTimeMillis();
        if (com.tencent.mm.plugin.offline.b.a.aFk() && c.aEW()) {
            c cVar2 = this.hLS;
            com.tencent.mm.plugin.offline.j.aEM();
            cVar2.a(com.tencent.mm.plugin.offline.j.aEN().hKX);
        }
        aFb();
        aEZ();
        this.hJZ.ea((long) this.hJY);
        if (com.tencent.mm.plugin.offline.b.a.hMk == 3 && com.tencent.mm.plugin.offline.b.a.hMn) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
            int i = com.tencent.mm.plugin.offline.b.a.hMl;
            long j = com.tencent.mm.plugin.offline.b.a.hMm;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = (((long) (i * 1000)) + j) - currentTimeMillis;
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + j + " now:" + currentTimeMillis + " interval:" + j2);
            if (com.tencent.mm.plugin.offline.b.a.hMl <= 0 || com.tencent.mm.plugin.offline.b.a.hMm <= 0 || j2 <= 0) {
                v.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
            } else {
                if (!this.hLX.btC()) {
                    this.hLX.QI();
                }
                this.hLX.ea(j2);
                v.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
            }
        } else if (com.tencent.mm.plugin.offline.b.a.hMk == 3) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
        } else {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[]{Integer.valueOf(com.tencent.mm.plugin.offline.b.a.hMk)});
        }
        aFa();
        final qk qkVar = new qk();
        qkVar.brG.brI = "5";
        qkVar.bpT = new Runnable(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI hLY;

            public final void run() {
                if (be.kS(qkVar.brH.brJ)) {
                    v.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
                } else {
                    e.a((TextView) this.hLY.findViewById(2131756367), qkVar.brH.brJ, qkVar.brH.content, qkVar.brH.url);
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(qkVar);
    }

    private void aEY() {
        switch (this.mState) {
            case 1:
            case 2:
                this.hLK.setVisibility(8);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                this.hLK.setVisibility(0);
                break;
            case 7:
                this.hLK.setVisibility(8);
                break;
        }
        if (this.hLT.getVisibility() == 0) {
            this.hLK.setVisibility(8);
        } else {
            this.hLK.setVisibility(0);
        }
    }

    private void aEZ() {
        aEY();
        if (com.tencent.mm.plugin.offline.b.a.eJ(true).size() > 0) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
            aFg();
            Bankcard aFm = com.tencent.mm.plugin.offline.b.a.aFm();
            if (aFm != null) {
                v.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
                com.tencent.mm.plugin.offline.b.a.xr(aFm.field_bindSerial);
                this.hJK = aFm.field_bindSerial;
                com.tencent.mm.plugin.offline.j.aEM();
                com.tencent.mm.plugin.offline.j.aEO().hJK = this.hJK;
            } else {
                v.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
            }
            this.hLL.setVisibility(0);
        } else {
            this.hLL.setVisibility(8);
            v.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
        }
        nP(0);
        avT();
        if (com.tencent.mm.plugin.offline.b.a.aFk()) {
            a(0, 2131230795, 2131165205, new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletOfflineCoinPurseUI hLY;

                {
                    this.hLY = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.plugin.offline.j.aEM();
                    com.tencent.mm.plugin.offline.j.aEO();
                    if (com.tencent.mm.plugin.offline.e.aEH() > 0) {
                        this.hLY.nP(0);
                        this.hLY.avT();
                        g.bf(this.hLY, this.hLY.getString(2131236544));
                    } else {
                        v.i("MicroMsg.WalletOfflineCoinPurseUI", "don't refresh code, code size is 0");
                        this.hLY.aFa();
                    }
                    return true;
                }
            });
            a(1, 2130838681, new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletOfflineCoinPurseUI hLY;

                {
                    this.hLY = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    g.a(this.hLY.nDR.nEl, null, this.hLY.getResources().getStringArray(2131296270), null, false, new g.c(this.hLY) {
                        final /* synthetic */ WalletOfflineCoinPurseUI hLY;

                        {
                            this.hLY = r1;
                        }

                        public final void gT(int i) {
                            switch (i) {
                                case 0:
                                    com.tencent.mm.plugin.offline.b.a.cn(this.hLY);
                                    return;
                                case 1:
                                    c m = this.hLY.hLS;
                                    if (com.tencent.mm.pluginsdk.g.a.ati()) {
                                        g.b(m.pP, m.getString(2131236526), "", m.getString(2131236525), m.getString(2131231010), new DialogInterface.OnClickListener(m) {
                                            final /* synthetic */ c hLw;

                                            {
                                                this.hLw = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                                a.aFu();
                                                g.bf(this.hLw.pP, this.hLw.pP.getResources().getString(2131236528));
                                                c.a(this.hLw);
                                                this.hLw.pP.finish();
                                            }
                                        }, new DialogInterface.OnClickListener(m) {
                                            final /* synthetic */ c hLw;

                                            {
                                                this.hLw = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                            }
                                        });
                                        return;
                                    } else {
                                        g.b(m.pP, m.getString(2131236527), "", m.getString(2131236545), m.getString(2131236525), new DialogInterface.OnClickListener(m) {
                                            final /* synthetic */ c hLw;

                                            {
                                                this.hLw = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                com.tencent.mm.pluginsdk.g.a.P(this.hLw.pP);
                                            }
                                        }, new DialogInterface.OnClickListener(m) {
                                            final /* synthetic */ c hLw;

                                            {
                                                this.hLw = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                                a.aFu();
                                                g.bf(this.hLw.pP, this.hLw.pP.getResources().getString(2131236528));
                                                c.a(this.hLw);
                                                this.hLw.pP.finish();
                                            }
                                        });
                                        return;
                                    }
                                default:
                                    return;
                            }
                        }
                    });
                    return true;
                }
            });
        } else {
            iU(false);
        }
        aFa();
    }

    private void aFa() {
        if (!com.tencent.mm.sdk.platformtools.ak.isNetworkConnected(getBaseContext())) {
            com.tencent.mm.plugin.offline.j.aEM();
            com.tencent.mm.plugin.offline.j.aEO();
            if (com.tencent.mm.plugin.offline.e.aEH() == 0) {
                v.e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
                g.a(this, getString(2131236523), null, false, new com.tencent.mm.plugin.offline.ui.b.AnonymousClass4(this));
                v.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
            }
        }
    }

    private void aFb() {
        int aFp = com.tencent.mm.plugin.offline.b.a.aFp();
        Bankcard aFn = com.tencent.mm.plugin.offline.b.a.aFn();
        if (c.aEW()) {
            this.mState = 7;
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
        } else if (!com.tencent.mm.sdk.platformtools.ak.isNetworkConnected(getBaseContext())) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
            this.mState = 6;
        } else if (com.tencent.mm.plugin.offline.b.a.aFk()) {
            if (aFp == 0) {
                v.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
                this.mState = 1;
            } else if (aFp == 0 || aFn != null) {
                v.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
                this.mState = 5;
            } else {
                v.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
                this.mState = 2;
            }
        } else if (aFp == 0) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
            this.mState = 1;
        } else if (aFp == 0 || aFn != null) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
            this.mState = 5;
        } else {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
            this.mState = 2;
        }
    }

    public final boolean ayM() {
        return false;
    }

    private void avT() {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap bitmap3 = this.hLA;
        if (TextUtils.isEmpty(this.hLO)) {
            v.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
            bitmap = null;
        } else {
            bitmap = com.tencent.mm.bb.a.a.b(this, this.hLO, 0, 3);
        }
        this.hLA = bitmap;
        this.hLH.setImageBitmap(this.hLA);
        if (aFc()) {
            this.hLH.setAlpha(10);
        } else {
            this.hLH.setAlpha(255);
        }
        this.hLP.add(0, bitmap3);
        v.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - currentTimeMillis));
        bitmap = this.hLB;
        if (TextUtils.isEmpty(this.hJU)) {
            v.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
        } else {
            bitmap2 = com.tencent.mm.bb.a.a.b(this, this.hJU, 5, 0);
        }
        this.hLB = bitmap2;
        this.hLI.setImageBitmap(this.hLB);
        if (aFc()) {
            this.hLI.setAlpha(10);
        } else {
            this.hLI.setAlpha(255);
        }
        this.hLJ.setText(e.PV(this.hJU));
        this.hLQ.add(0, bitmap);
        v.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - currentTimeMillis));
        abS();
        aFd();
    }

    private boolean aFc() {
        return this.mState == 2 || this.mState == 1 || this.mState == 7;
    }

    private void aFd() {
        if (this.hLR != null) {
            this.hLR.eb(this.hLO, this.hJU);
            this.hLR.hLA = this.hLA;
            this.hLR.hLB = this.hLB;
            this.hLR.bLv();
        }
    }

    private void abS() {
        int size;
        if (this.hLP.size() >= 2) {
            for (size = this.hLP.size() - 1; size > 1; size--) {
                e.l((Bitmap) this.hLP.remove(size));
            }
        }
        if (this.hLQ.size() >= 2) {
            for (size = this.hLQ.size() - 1; size > 1; size--) {
                e.l((Bitmap) this.hLQ.remove(size));
            }
        }
    }

    private void nP(int i) {
        com.tencent.mm.plugin.offline.j.aEM();
        String cc = com.tencent.mm.plugin.offline.j.aEO().cc(this.cKI, i);
        this.hJU = cc;
        this.hLO = cc;
        v.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[]{Integer.valueOf(i), this.hJU, this.hLO, be.bur().toString()});
        am bfP = f.bfP();
        StringBuilder append = new StringBuilder().append(this.hLO);
        ak.yW();
        String Kg = z.Kg(append.append(o.getString(com.tencent.mm.model.c.ww())).toString());
        if (bfP != null) {
            com.tencent.mm.plugin.report.service.g.iuh.h(13444, new Object[]{bfP.maR, bfP.maS, Long.valueOf(bfP.maQ), Kg});
        }
        n.dB(10, 0);
    }

    public final boolean a(com.tencent.mm.plugin.offline.a.n.c cVar) {
        if (cVar == null) {
            v.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
            return false;
        }
        boolean z;
        if (4 == cVar.hLc) {
            z = false;
        } else if (5 != cVar.hLc && 6 == cVar.hLc && com.tencent.mm.plugin.offline.b.a.aFl()) {
            z = false;
        } else {
            z = true;
        }
        c cVar2 = this.hLS;
        if (cVar == null) {
            v.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
        } else {
            v.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + cVar.hLc);
            cVar2.ewK.vibrate(50);
            if (4 == cVar.hLc) {
                cVar2.a((com.tencent.mm.plugin.offline.a.n.b) cVar);
            } else if (5 == cVar.hLc) {
                d dVar = (d) cVar;
                if (dVar != null) {
                    v.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + dVar.hLf + " msg.wxRetMsg:" + dVar.hLg + " msg.cftRetCode:" + dVar.hLf + " msg.cftRetMsg:" + dVar.hLe);
                    if (!(TextUtils.isEmpty(dVar.hLf) && TextUtils.isEmpty(dVar.hLg) && TextUtils.isEmpty(dVar.hLd) && TextUtils.isEmpty(dVar.hLe))) {
                        if (TextUtils.isEmpty(dVar.hLf) && TextUtils.isEmpty(dVar.hLg) && !TextUtils.isEmpty(dVar.hLd) && !TextUtils.isEmpty(dVar.hLe)) {
                            b.a(cVar2.pP, dVar.hLe);
                        } else if (TextUtils.isEmpty(dVar.hLf) || !com.tencent.mm.plugin.offline.b.a.qw(dVar.hLf)) {
                            b.a(cVar2.pP, dVar.hLg);
                        } else {
                            cVar2.q(Integer.valueOf(dVar.hLf).intValue(), dVar.hLg, dVar.hLh);
                        }
                    }
                }
                com.tencent.mm.plugin.report.service.g.iuh.a(135, 0, 1, true);
            } else if (6 == cVar.hLc) {
                com.tencent.mm.plugin.offline.a.n.e eVar = (com.tencent.mm.plugin.offline.a.n.e) cVar;
                if (eVar != null) {
                    v.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + eVar.hLi);
                    com.tencent.mm.plugin.offline.b.a.a(cVar2.pP, eVar.hLj);
                }
                com.tencent.mm.plugin.report.service.g.iuh.a(135, 7, 1, true);
                if (com.tencent.mm.plugin.offline.b.a.hMk == 4) {
                    v.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
                    com.tencent.mm.plugin.report.service.g.iuh.h(13412, new Object[0]);
                }
            } else if (8 == cVar.hLc) {
                com.tencent.mm.plugin.offline.a.n.f fVar = (com.tencent.mm.plugin.offline.a.n.f) cVar;
                v.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + fVar.id);
                if (fVar.hLm == 0) {
                    View inflate = cVar2.pP.getLayoutInflater().inflate(2130904658, null);
                    TextView textView = (TextView) inflate.findViewById(2131759925);
                    ((TextView) inflate.findViewById(2131759924)).setText(fVar.hLl);
                    textView.setText(fVar.hLk);
                    g.a(cVar2.pP, "", inflate, cVar2.getString(2131236539), cVar2.getString(2131231010), new com.tencent.mm.plugin.offline.ui.c.AnonymousClass1(cVar2, fVar), new com.tencent.mm.plugin.offline.ui.c.AnonymousClass10(cVar2, fVar));
                } else if (fVar.hLm == 1) {
                    if (cVar2.hLs != null) {
                        cVar2.hLs.show();
                    }
                    v.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + fVar.id);
                    cVar2.hLs = com.tencent.mm.plugin.wallet_core.ui.k.a(cVar2.pP, fVar.hLk, fVar.hLl, new com.tencent.mm.plugin.offline.ui.c.AnonymousClass11(cVar2, fVar), new OnCancelListener(cVar2) {
                        final /* synthetic */ c hLw;

                        {
                            this.hLw = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.hLw.aEV();
                        }
                    }, new com.tencent.mm.plugin.offline.ui.c.AnonymousClass13(cVar2, fVar));
                    cVar2.hLs.iys.setVisibility(0);
                    cVar2.hLs.isG.setVisibility(8);
                }
            }
        }
        if (z) {
            nP(0);
            avT();
        }
        return true;
    }

    private void aFe() {
        b(new com.tencent.mm.plugin.offline.a.k(System.currentTimeMillis(), com.tencent.mm.plugin.offline.b.a.hMk), false);
    }

    public final void k(String str, final Bitmap bitmap) {
        if (!TextUtils.isEmpty(str) && bitmap != null && !bitmap.isRecycled()) {
            final ImageView imageView = (ImageView) this.hLy.get(str);
            final Integer num = (Integer) this.hLz.get(str);
            if (imageView != null && num != null) {
                new ac(getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ WalletOfflineCoinPurseUI hLY;

                    public final void run() {
                        int intValue = num.intValue();
                        imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(bitmap, intValue, intValue, true, false));
                    }
                });
            }
        }
    }

    public final void aFf() {
        v.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
        nP(1);
        avT();
        e.yD(40);
        com.tencent.mm.plugin.report.service.g.iuh.a(135, 21, 1, true);
        this.hLT.bV(this.hLG);
    }

    public final void aFg() {
        Bankcard aFm = com.tencent.mm.plugin.offline.b.a.aFm();
        if (this.hLM != null && aFm != null) {
            Object string = getString(2131236518);
            Object string2 = getString(2131236519, new Object[]{aFm.field_desc});
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(string2);
            spannableStringBuilder.append(string);
            int length = string2.length();
            if (length > 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131690110)), length, string.length() + length, 17);
                this.hLM.setText(spannableStringBuilder);
                this.hLM.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                return;
            }
        } else if (aFm == null) {
            v.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
        }
        if (TextUtils.isEmpty(this.hJK)) {
            v.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
            return;
        }
        string2 = com.tencent.mm.plugin.offline.b.a.xx(this.hJK);
        if (TextUtils.isEmpty(string2)) {
            v.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
            return;
        }
        ImageView imageView = this.hLN;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131493610);
        if (imageView != null && !TextUtils.isEmpty(string2)) {
            Bitmap a = com.tencent.mm.platformtools.j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(string2));
            if (a != null) {
                imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(a, dimensionPixelOffset, dimensionPixelOffset, true, false));
            }
            this.hLy.put(string2, imageView);
            this.hLz.put(string2, Integer.valueOf(dimensionPixelOffset));
        }
    }

    private void aFh() {
        List eJ = com.tencent.mm.plugin.offline.b.a.eJ(false);
        if (eJ.size() <= 0) {
            v.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
            this.hLM.setVisibility(8);
            return;
        }
        v.i("MicroMsg.WalletOfflineCoinPurseUI", "showChangeBankcardDialog() bankcard size is " + eJ.size());
        String aFt = com.tencent.mm.plugin.offline.b.a.aFt();
        this.hLD.clear();
        this.hLE.clear();
        this.hLF.clear();
        dVG = 0;
        for (int i = 0; i < eJ.size(); i++) {
            Bankcard bankcard = (Bankcard) eJ.get(i);
            if (bankcard != null) {
                if (bankcard.field_support_micropay) {
                    this.hLD.add(bankcard.field_desc);
                } else {
                    this.hLD.add(bankcard.field_desc + "[" + getResources().getString(2131236537) + "]");
                }
                this.hLE.add(bankcard.field_bindSerial);
                this.hLF.add(Boolean.valueOf(bankcard.field_support_micropay));
                if (bankcard.field_bindSerial != null && bankcard.field_bindSerial.equals(aFt)) {
                    dVG = this.hLE.size() - 1;
                }
            }
        }
        showDialog(1);
    }

    protected final int NO() {
        return 1;
    }

    private static void aFi() {
        if (!com.tencent.mm.plugin.offline.b.a.aFC()) {
            v.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
            com.tencent.mm.plugin.offline.j.aEM();
            com.tencent.mm.plugin.offline.j.aEP().nL(3);
        }
    }

    public final void ZN() {
        nP(0);
        avT();
    }

    public final void p(int i, String str, String str2) {
        b(new com.tencent.mm.plugin.offline.a.b(i, str, str2), com.tencent.mm.plugin.offline.b.a.aFl());
    }

    public final void aES() {
        aFh();
    }

    public final void aET() {
        b(new com.tencent.mm.plugin.offline.a.g(""), false);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.hLT == null || this.hLT.getVisibility() != 0) {
            return super.onKeyUp(i, keyEvent);
        }
        this.hLT.dismiss();
        return true;
    }
}
