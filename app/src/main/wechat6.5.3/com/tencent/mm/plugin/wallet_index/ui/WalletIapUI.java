package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mm.BuildConfig;
import com.tencent.mm.e.a.qj;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.anj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.i;
import com.tencent.mm.wallet_core.b.j;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletIapUI extends MMActivity implements e {
    private int count = 1;
    private Dialog dQN;
    private boolean kXK = false;
    private List<String> kXL = new ArrayList();
    private ArrayList<String> kXM = new ArrayList();
    private ArrayList<String> kXN = new ArrayList();
    private b kXO;
    private long kXP = 0;
    private c kXQ = new c(this) {
        final /* synthetic */ WalletIapUI kXS;

        {
            this.kXS = r1;
        }

        public final void a(com.tencent.mm.plugin.wallet_index.b.a.b bVar, com.tencent.mm.plugin.wallet_index.b.a.d dVar) {
            v.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + bVar + ", purchase: " + dVar);
            if (this.kXS.kXO instanceof a) {
                if (dVar != null) {
                    n.b(dVar.kXf, dVar.fdU, dVar.kXl, bVar.gDS, bVar.mMessage);
                } else {
                    a aVar = (a) this.kXS.kXO;
                    n.b(aVar.kXX, aVar.fdU, aVar.kXl, bVar.gDS, bVar.mMessage);
                }
            }
            if (bVar.isFailure()) {
                v.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + bVar.gDS + " , errMsg: " + bVar.mMessage);
                Intent intent = new Intent();
                intent.putExtra("key_err_code", bVar.gDS);
                intent.putExtra("key_err_msg", bVar.mMessage);
                intent.putExtra("key_launch_ts", this.kXS.kXP);
                intent.putExtra("key_gw_error_code", bVar.kXc);
                this.kXS.setResult(-1, intent);
                this.kXS.finish();
            } else if (bVar.bhw()) {
                v.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
                this.kXS.kXO.hs(false);
            } else {
                v.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + dVar.fdU + ",billNo:" + dVar.kXi);
                ak.vy().a(new j(dVar.fdU, this.kXS.kXO.bhz(), this.kXS.count, dVar.kXi, dVar.kXj, dVar.jXL, dVar.kXk, dVar.kXl), 0);
            }
        }
    };
    private c kXR = new c(this) {
        final /* synthetic */ WalletIapUI kXS;

        {
            this.kXS = r1;
        }

        public final void a(com.tencent.mm.plugin.wallet_index.b.a.b bVar, com.tencent.mm.plugin.wallet_index.b.a.d dVar) {
            v.d("MicroMsg.WalletIapUI", "Consume finished: " + bVar + ", purchase: " + dVar);
            if (bVar.isFailure()) {
                v.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
            } else {
                v.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
            }
            Intent intent = new Intent();
            intent.putExtra("key_err_code", bVar.gDS);
            intent.putExtra("key_err_msg", bVar.mMessage);
            intent.putStringArrayListExtra("key_response_product_ids", this.kXS.kXM);
            intent.putStringArrayListExtra("key_response_series_ids", this.kXS.kXN);
            intent.putExtra("key_launch_ts", this.kXS.kXP);
            this.kXS.setResult(-1, intent);
            this.kXS.finish();
        }
    };

    interface b {
        void a(Activity activity, i iVar, c cVar);

        void a(ArrayList<String> arrayList, c cVar, boolean z);

        int bhz();

        boolean c(int i, int i2, Intent intent);

        void hs(boolean z);

        void onDestroy();
    }

    public interface c {
        void a(com.tencent.mm.plugin.wallet_index.b.a.b bVar, com.tencent.mm.plugin.wallet_index.b.a.d dVar);
    }

    class a implements b {
        BroadcastReceiver esp = new BroadcastReceiver(this) {
            final /* synthetic */ a kXY;

            {
                this.kXY = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE".equals(action)) {
                    this.kXY.kXW = com.tencent.mm.plugin.wallet_index.b.a.a.a(intent, this.kXY.kXT);
                } else if ("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE".equals(action)) {
                    final boolean booleanExtra = intent.getBooleanExtra("is_direct", true);
                    this.kXY.kXV.a(intent, new com.tencent.mm.plugin.wallet_index.b.a.a.a(this) {
                        final /* synthetic */ AnonymousClass1 kXZ;

                        public final void a(com.tencent.mm.plugin.wallet_index.b.a.b bVar, com.tencent.mm.plugin.wallet_index.b.a.c cVar) {
                            v.d("MicroMsg.WalletIapUI", "Query inventory finished.");
                            if (bVar.isFailure() || cVar == null) {
                                v.w("MicroMsg.WalletIapUI", "Failed to query inventory: " + bVar);
                                return;
                            }
                            v.d("MicroMsg.WalletIapUI", "Query inventory was successful.");
                            this.kXZ.kXY.kXW = cVar;
                            this.kXZ.kXY.kXS.kXL = new ArrayList(cVar.kXd.keySet());
                            List<com.tencent.mm.plugin.wallet_index.b.a.d> arrayList = new ArrayList(cVar.kXd.values());
                            if (arrayList.size() > 0) {
                                for (com.tencent.mm.plugin.wallet_index.b.a.d dVar : arrayList) {
                                    v.i("MicroMsg.WalletIapUI", "do NetSceneVerifyPurchase. productId:" + dVar.fdU + ",billNo:" + dVar.kXi);
                                    if (dVar.fdU.equals(this.kXZ.kXY.fdU)) {
                                        ak.vy().a(new j(dVar.fdU, 3, this.kXZ.kXY.kXS.count, dVar.kXi, dVar.kXj, dVar.jXL, this.kXZ.kXY.kXk, this.kXZ.kXY.kXl), 0);
                                        v.v("MicroMsg.WalletIapUI", "after price:%s , currencyType:%s", new Object[]{this.kXZ.kXY.kXl, this.kXZ.kXY.kXk});
                                    } else {
                                        ak.vy().a(new j(dVar.fdU, 3, this.kXZ.kXY.kXS.count, dVar.kXi, dVar.kXj, dVar.jXL, dVar.kXk, dVar.kXl), 0);
                                    }
                                }
                                return;
                            }
                            com.tencent.mm.plugin.wallet_index.b.a.b sw;
                            v.d("MicroMsg.WalletIapUI", "purchases is null. consume null ");
                            if (booleanExtra) {
                                v.d("MicroMsg.WalletIapUI", "result ok");
                                sw = com.tencent.mm.plugin.wallet_index.b.a.b.sw(0);
                            } else {
                                v.d("MicroMsg.WalletIapUI", "unknown_purchase");
                                sw = com.tencent.mm.plugin.wallet_index.b.a.b.sw(-2002);
                            }
                            if (this.kXZ.kXY.kXS.kXR != null) {
                                this.kXZ.kXY.kXS.kXR.a(sw, null);
                            }
                        }
                    });
                }
            }
        };
        String fdU;
        final /* synthetic */ WalletIapUI kXS;
        c kXT = null;
        private c kXU = null;
        com.tencent.mm.plugin.wallet_index.b.a.a kXV;
        com.tencent.mm.plugin.wallet_index.b.a.c kXW;
        String kXX;
        String kXk;
        String kXl;

        public a(WalletIapUI walletIapUI) {
            this.kXS = walletIapUI;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
            intentFilter.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
            walletIapUI.registerReceiver(this.esp, intentFilter);
            this.kXV = new com.tencent.mm.plugin.wallet_index.b.a.a();
        }

        public final int bhz() {
            return 3;
        }

        public final void a(Activity activity, i iVar, c cVar) {
            this.kXT = cVar;
            this.fdU = iVar.fdU;
            this.kXl = iVar.kXl;
            this.kXk = iVar.kXk;
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
            intent.setPackage(BuildConfig.APPLICATION_ID);
            intent.putExtra("product_id", this.fdU);
            this.kXX = iVar.bLc();
            String str = "developer_pay_load";
            String str2 = this.kXX;
            String str3 = this.kXl;
            String str4 = this.kXk;
            if (be.kS(str2)) {
                str2 = "";
            }
            if (be.kS(str3)) {
                str3 = "";
            }
            if (be.kS(str4)) {
                str4 = "";
            }
            intent.putExtra(str, str2 + "[#]" + str3 + "[#]" + str4);
            if (activity.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
                v.i("MicroMsg.WalletIapUI", "Try to downloading GWallet Moudle!");
                com.tencent.mm.plugin.wallet_index.b.a.b sw = com.tencent.mm.plugin.wallet_index.b.a.b.sw(-2000);
                if (this.kXT != null) {
                    this.kXT.a(sw, null);
                    return;
                }
                return;
            }
            this.kXS.kXP = be.Ni();
            v.i("MicroMsg.WalletIapUI", "GWallet Found!");
            activity.startActivityForResult(intent, 10001);
        }

        public final void onDestroy() {
            try {
                this.kXS.unregisterReceiver(this.esp);
            } catch (IllegalArgumentException e) {
                v.e("MicroMsg.WalletIapUI", e.toString());
            }
            if (!be.bm(this.kXS)) {
                v.d("MicroMsg.WalletIapUI", "close front UI.");
                Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
                intent.setPackage(BuildConfig.APPLICATION_ID);
                this.kXS.sendBroadcast(intent);
            }
            v.d("MicroMsg.WalletIapUI", "Destroying helper.");
        }

        private void sx(int i) {
            com.tencent.mm.plugin.wallet_index.b.a.b sw = com.tencent.mm.plugin.wallet_index.b.a.b.sw(i);
            Intent intent = new Intent();
            intent.putExtra("key_err_code", sw.gDS);
            intent.putExtra("key_err_msg", sw.mMessage);
            intent.putExtra("key_launch_ts", this.kXS.kXP);
            this.kXS.setResult(-1, intent);
            this.kXS.finish();
        }

        public final boolean c(int i, int i2, Intent intent) {
            if (i == 10001) {
                v.i("MicroMsg.WalletIapUI", "purchase flow!result_code: %d", new Object[]{Integer.valueOf(i2)});
                if (intent != null) {
                    int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
                    if (intExtra == -2001 || intExtra == 3) {
                        n.b(this.kXX, this.fdU, this.kXl, intExtra, "");
                        sx(intExtra);
                    } else if (intExtra == -3000) {
                        sx(intExtra);
                    }
                } else {
                    sx(1);
                }
                return true;
            }
            c cVar = this.kXU;
            String str = this.kXX;
            String str2 = this.fdU;
            String str3 = this.kXl;
            int M = com.tencent.mm.plugin.wallet_index.b.a.a.M(intent);
            v.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(M));
            com.tencent.mm.plugin.wallet_index.b.a.b sw = com.tencent.mm.plugin.wallet_index.b.a.b.sw(M);
            n.b(str, str2, str3, M, sw.mMessage);
            if (cVar != null) {
                cVar.a(sw, null);
            }
            return true;
        }

        public final void hs(boolean z) {
            v.d("MicroMsg.WalletIapUI", "restorePurchase. Querying inventory.");
            v.d("MicroMsg.WalletIapUI", "is direct? " + z);
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
            intent.setPackage(BuildConfig.APPLICATION_ID);
            intent.putExtra("is_direct", z);
            this.kXS.startActivityForResult(intent, 10001);
        }

        public final void a(ArrayList<String> arrayList, c cVar, boolean z) {
            this.kXU = cVar;
            v.d("MicroMsg.WalletIapUI", "consumePurchase. consume...");
            com.tencent.mm.plugin.wallet_index.b.a.c cVar2 = this.kXW;
            ArrayList arrayList2 = new ArrayList();
            for (String str : arrayList) {
                com.tencent.mm.plugin.wallet_index.b.a.d dVar = (com.tencent.mm.plugin.wallet_index.b.a.d) cVar2.kXd.get(str);
                if (dVar != null) {
                    arrayList2.add(dVar.cKN);
                }
            }
            if (arrayList2.size() > 0) {
                Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
                intent.setPackage(BuildConfig.APPLICATION_ID);
                intent.putStringArrayListExtra("tokens", arrayList2);
                intent.putExtra("IS_FAILED_CONSUME", z);
                this.kXS.sendBroadcast(intent);
                return;
            }
            com.tencent.mm.plugin.wallet_index.b.a.b sw = com.tencent.mm.plugin.wallet_index.b.a.b.sw(0);
            if (this.kXU != null) {
                this.kXU.a(sw, null);
            }
        }
    }

    class d implements b {
        private String fdU = null;
        private com.tencent.mm.sdk.c.c hSc = new com.tencent.mm.sdk.c.c<qj>(this) {
            final /* synthetic */ d kYb;

            {
                this.kYb = r2;
                this.nhz = qj.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                if (((qj) bVar) instanceof qj) {
                    if (this.kYb.kXS.dQN != null && this.kYb.kXS.dQN.isShowing()) {
                        this.kYb.kXS.dQN.dismiss();
                        this.kYb.kXS.dQN = null;
                    }
                    return true;
                }
                v.f("MicroMsg.WalletIapUI", "mismatched event");
                return false;
            }
        };
        final /* synthetic */ WalletIapUI kXS;
        private String kXX = null;
        private String kXk = null;
        private String kXl = null;
        private c kYa = null;

        public d(WalletIapUI walletIapUI) {
            this.kXS = walletIapUI;
            com.tencent.mm.sdk.c.a.nhr.e(this.hSc);
        }

        public final int bhz() {
            return 2;
        }

        public final void a(Activity activity, i iVar, c cVar) {
            String str;
            n.bLg();
            this.kYa = cVar;
            this.fdU = iVar.fdU;
            this.kXX = iVar.bLc();
            this.kXl = iVar.kXl;
            this.kXk = iVar.kXk;
            PayInfo payInfo = new PayInfo();
            anj com_tencent_mm_protocal_c_anj = (anj) iVar.cif.czl.czs;
            if (com_tencent_mm_protocal_c_anj != null) {
                v.d("MicroMsg.NetScenePreparePurchase", "get TradeToken4TenPay is " + com_tencent_mm_protocal_c_anj.mNA);
                str = com_tencent_mm_protocal_c_anj.mNA;
            } else {
                v.e("MicroMsg.NetScenePreparePurchase", "get TradeToken4TenPay field.");
                str = "";
            }
            payInfo.fTG = str;
            com_tencent_mm_protocal_c_anj = (anj) iVar.cif.czl.czs;
            if (com_tencent_mm_protocal_c_anj != null) {
                v.d("MicroMsg.NetScenePreparePurchase", "get Partner4TenPay is " + com_tencent_mm_protocal_c_anj.mNB);
                str = com_tencent_mm_protocal_c_anj.mNB;
            } else {
                v.e("MicroMsg.NetScenePreparePurchase", "get Partner4TenPay field.");
                str = "";
            }
            payInfo.bkj = str;
            com_tencent_mm_protocal_c_anj = (anj) iVar.cif.czl.czs;
            if (com_tencent_mm_protocal_c_anj != null) {
                v.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + com_tencent_mm_protocal_c_anj.mNC);
                str = com_tencent_mm_protocal_c_anj.mNC;
            } else {
                v.e("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay field.");
                str = "";
            }
            payInfo.lVB = str;
            payInfo.bkq = 5;
            com.tencent.mm.pluginsdk.wallet.e.a(activity, payInfo, 1);
        }

        public final boolean c(int i, int i2, Intent intent) {
            v.d("MicroMsg.WalletIapUI", "onPayEnd payResult : " + i2);
            if (this.kYa != null) {
                com.tencent.mm.plugin.wallet_index.b.a.b al;
                if (i2 == -1) {
                    al = com.tencent.mm.plugin.wallet_index.b.a.b.al(0, "");
                } else {
                    al = com.tencent.mm.plugin.wallet_index.b.a.b.al(100000000, "");
                }
                this.kYa.a(al, new com.tencent.mm.plugin.wallet_index.b.a.d(this.fdU, this.kXX, this.kXk, this.kXl));
                this.kYa = null;
            }
            return true;
        }

        public final void onDestroy() {
            com.tencent.mm.sdk.c.a.nhr.f(this.hSc);
        }

        public final void hs(boolean z) {
            Intent intent = new Intent();
            intent.putExtra("key_err_code", 0);
            intent.putExtra("key_err_msg", "");
            this.kXS.setResult(-1, intent);
            this.kXS.finish();
        }

        public final void a(ArrayList<String> arrayList, c cVar, boolean z) {
            if (cVar != null) {
                cVar.a(com.tencent.mm.plugin.wallet_index.b.a.b.al(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.d(this.fdU, this.kXX, this.kXk, this.kXl));
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.v("MicroMsg.WalletIapUI", "onCreate");
        this.kXP = 0;
        ak.vy().a(422, this);
        ak.vy().a(414, this);
        if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
            this.dQN = g.a(this, getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ WalletIapUI kXS;

                {
                    this.kXS = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.kXS.setResult(0);
                    this.kXS.finish();
                }
            });
        }
        if (getIntent().getBooleanExtra("key_force_google", false) || k.xS()) {
            v.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
            this.kXO = new a(this);
            return;
        }
        v.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
        this.kXO = new d(this);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        v.d("MicroMsg.WalletIapUI", "onResume");
        super.onResume();
        v.d("MicroMsg.WalletIapUI", "Handler jump");
        if (!this.kXK) {
            this.kXK = true;
            Intent intent = getIntent();
            if (intent.getIntExtra("key_action_type", 200001) == 200002) {
                v.d("MicroMsg.WalletIapUI", "start to restore the purchase!");
                this.kXO.hs(true);
                return;
            }
            String stringExtra = intent.getStringExtra("key_product_id");
            this.kXL.add(stringExtra);
            v.d("MicroMsg.WalletIapUI", "prepare pay product: " + stringExtra);
            String stringExtra2 = intent.getStringExtra("key_price");
            String stringExtra3 = intent.getStringExtra("key_currency_type");
            String stringExtra4 = intent.getStringExtra("key_ext_info");
            this.count = intent.getIntExtra("key_count", 1);
            ak.vy().a(new i(stringExtra, stringExtra2, stringExtra3, this.count, this.kXO.bhz(), stringExtra4), 0);
        }
    }

    protected void onNewIntent(Intent intent) {
        v.d("MicroMsg.WalletIapUI", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onDestroy() {
        v.d("MicroMsg.WalletIapUI", "onDestroy");
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.kXO != null) {
            this.kXO.c(i, i2, intent);
            v.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
            return;
        }
        v.i("MicroMsg.WalletIapUI", "havn't handle user action");
        Intent intent2 = new Intent();
        com.tencent.mm.plugin.wallet_index.b.a.b al = com.tencent.mm.plugin.wallet_index.b.a.b.al(-1, "");
        intent2.putExtra("key_err_code", al.gDS);
        intent2.putExtra("key_err_msg", al.mMessage);
        intent2.putExtra("key_launch_ts", this.kXP);
        setResult(-1, intent2);
        finish();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.WalletIapUI", "onSceneEnd ErrType:" + i + ", errCode:" + i2 + ",errMsg:" + str);
        com.tencent.mm.plugin.wallet_index.b.a.b al = com.tencent.mm.plugin.wallet_index.b.a.b.al(i2, str);
        int i3 = al.gDS;
        String str2 = al.mMessage;
        v.i("MicroMsg.WalletIapUI", "onSceneEnd getWeiXinResult errCode:" + i3 + ",errMsg:" + str2);
        Intent intent;
        switch (kVar.getType()) {
            case 414:
                boolean z = false;
                j jVar = (j) kVar;
                String str3 = jVar.fdU;
                this.kXL.remove(str3);
                if (i3 == 0) {
                    v.i("MicroMsg.WalletIapUI", "Verify " + str3 + " OK");
                    this.kXM.add(str3);
                    this.kXN.add(jVar.bLd());
                } else if (!str3.startsWith("com.tencent.xin.wco")) {
                    v.i("MicroMsg.WalletIapUI", "Verify " + str3 + " fail");
                } else if (jVar.piD > 0) {
                    this.kXM.add(str3);
                    this.kXN.add(jVar.bLd());
                    v.i("MicroMsg.WalletIapUI", "Verify " + str3 + " fail and cosume");
                    z = true;
                } else {
                    v.i("MicroMsg.WalletIapUI", "Verify " + str3 + " fail");
                }
                if (this.kXL.isEmpty()) {
                    v.d("MicroMsg.WalletIapUI", "Verify All End... ");
                    if (this.kXM.isEmpty()) {
                        v.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                        intent = new Intent();
                        intent.putExtra("key_err_code", i3);
                        intent.putExtra("key_err_msg", str2);
                        intent.putExtra("key_response_position", 3);
                        intent.putExtra("key_launch_ts", this.kXP);
                        setResult(-1, intent);
                        finish();
                        return;
                    }
                    v.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.kXM.size() + ", Consume ...");
                    this.kXO.a(this.kXM, this.kXR, z);
                    return;
                }
                return;
            case 422:
                if (i3 == 0) {
                    v.i("MicroMsg.WalletIapUI", "Prepare OK, LaunchPay...");
                    this.kXO.a((Activity) this, (i) kVar, this.kXQ);
                    return;
                }
                v.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                intent = new Intent();
                intent.putExtra("key_err_code", i3);
                intent.putExtra("key_err_msg", str2);
                intent.putExtra("key_response_position", 1);
                setResult(-1, intent);
                finish();
                return;
            default:
                return;
        }
    }

    public void finish() {
        v.i("MicroMsg.WalletIapUI", "finish");
        if (this.dQN != null && this.dQN.isShowing()) {
            this.dQN.dismiss();
            this.dQN = null;
        }
        if (this.kXO != null) {
            this.kXO.onDestroy();
        }
        ak.vy().b(422, this);
        ak.vy().b(414, this);
        super.finish();
    }
}
