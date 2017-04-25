package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletOfflineEntranceUI extends WalletBaseUI {
    private int cKI = -1;
    boolean hMc = true;

    protected final int getLayoutId() {
        return 2130904657;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
        com.tencent.mm.wallet_core.b.a.bKZ();
        com.tencent.mm.wallet_core.b.a.init(getApplicationContext());
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 0);
            v.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is " + intExtra);
            if (intExtra == 3) {
                com.tencent.mm.plugin.offline.b.a.hMk = intExtra;
                intExtra = getIntent().getIntExtra("key_expire_time", 0);
                long longExtra = getIntent().getLongExtra("key_begin_time", 0);
                boolean booleanExtra = getIntent().getBooleanExtra("key_is_mark", false);
                v.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + intExtra + " beginTime:" + longExtra + " isMark:" + booleanExtra);
                com.tencent.mm.plugin.offline.b.a.hMl = intExtra;
                com.tencent.mm.plugin.offline.b.a.hMm = longExtra;
                com.tencent.mm.plugin.offline.b.a.hMn = booleanExtra;
                com.tencent.mm.plugin.offline.b.a.eAS = getIntent().getStringExtra("key_card_id");
                com.tencent.mm.plugin.offline.b.a.hMo = getIntent().getStringExtra("key_user_card_id");
                com.tencent.mm.plugin.offline.b.a.hMp = getIntent().getStringExtra("key_card_code");
            } else if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
                com.tencent.mm.plugin.offline.b.a.hMk = intExtra;
                com.tencent.mm.plugin.offline.b.a.hMl = 0;
                com.tencent.mm.plugin.offline.b.a.hMm = 0;
                com.tencent.mm.plugin.offline.b.a.hMn = false;
                com.tencent.mm.plugin.offline.b.a.eAS = "";
                com.tencent.mm.plugin.offline.b.a.hMo = "";
                com.tencent.mm.plugin.offline.b.a.hMp = "";
            }
        }
        init();
    }

    private void init() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("key_from_scene")) {
            int intExtra = intent.getIntExtra("key_from_scene", 0);
            if (intExtra == 1) {
                this.cKI = 1;
            } else if (intExtra == 2) {
                this.cKI = 2;
            } else if (intExtra == 3) {
                this.cKI = 3;
            } else if (intExtra == 4) {
                this.cKI = 4;
            } else {
                this.cKI = 0;
            }
        }
        if (k.bga().bgu()) {
            v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
            b(new l(null), true);
            this.hMc = false;
        } else if (k.bga().bgs()) {
            v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isUnreg()");
            aFj();
            this.hMc = false;
        } else if (k.bga().bgv() && com.tencent.mm.plugin.offline.b.a.aFk()) {
            v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isReg()  && isOfflineCreate()");
            j.aEM();
            String nO = j.nO(196617);
            finish();
            com.tencent.mm.wallet_core.b.a.bKZ();
            if (com.tencent.mm.wallet_core.b.a.isCertExist(nO)) {
                v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is true");
                intent = new Intent();
                intent.putExtra("key_entry_scene", this.cKI);
                c.b(this.nDR.nEl, "offline", ".ui.WalletOfflineCoinPurseUI", intent);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.b.a.bKZ();
            v.e("MicroMsg.WalletOfflineEntranceUI", stringBuilder.append(com.tencent.mm.wallet_core.b.a.getLastError()).toString());
            ak.yW();
            String str = (String) com.tencent.mm.model.c.vf().get(t.a.nom, "");
            if (str == null || !str.equals(p.rJ())) {
                v.i("MicroMsg.WalletOfflineEntranceUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
            } else {
                v.i("MicroMsg.WalletOfflineEntranceUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
            }
            v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + nO + " ,recreate offline");
            com.tencent.mm.plugin.offline.b.a.aFu();
            com.tencent.mm.plugin.offline.b.a.E(this);
        } else if (k.bga().bgv() && !com.tencent.mm.plugin.offline.b.a.aFk()) {
            v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI (isReg() && !isOfflineCreate()");
            finish();
            com.tencent.mm.plugin.offline.b.a.E(this);
        } else if (k.bga().bgw()) {
            v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isSimpleReg");
            aFj();
            this.hMc = false;
        } else {
            v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI finish()");
            finish();
        }
    }

    private void aFj() {
        com.tencent.mm.plugin.offline.b.a.aFu();
        j.aEM();
        j.T(196648, "0");
        g.a(this, false, getString(2131236516), "", getString(2131236524), getString(2131231010), new OnClickListener(this) {
            final /* synthetic */ WalletOfflineEntranceUI hMd;

            {
                this.hMd = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                com.tencent.mm.plugin.offline.b.a.f(this.hMd, this.hMd.cKI);
                v.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI startBindProcess()");
                this.hMd.hMc = true;
            }
        }, new OnClickListener(this) {
            final /* synthetic */ WalletOfflineEntranceUI hMd;

            {
                this.hMd = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.hMd.finish();
            }
        });
    }

    public void onResume() {
        super.onResume();
        v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
        if (this.hMc) {
            v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
            if (com.tencent.mm.plugin.offline.b.a.aFk()) {
                v.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
                Intent intent = new Intent();
                intent.putExtra("key_entry_scene", this.cKI);
                c.b(this.nDR.nEl, "offline", ".ui.WalletOfflineCoinPurseUI", intent);
            } else {
                v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
            }
            finish();
            return;
        }
        v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
        this.hMc = true;
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0) {
            v.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
            init();
            return true;
        }
        v.e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return true;
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null && intent.hasExtra("is_offline_create")) {
            v.i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
            this.hMc = true;
        }
    }
}
