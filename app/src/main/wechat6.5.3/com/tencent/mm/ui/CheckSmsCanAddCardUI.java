package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.kn;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;

public class CheckSmsCanAddCardUI extends MMActivity implements e {
    private b cif;
    private String nzK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.bAj();
        if (!ak.uN() || ak.uG()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            return;
        }
        int i;
        Uri data = getIntent().getData();
        if (data != null) {
            String host = data.getHost();
            if (be.kS(host) || !host.equals("cardpackage")) {
                v.e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", host);
            } else {
                this.nzK = data.getQueryParameter("encrystr");
                v.i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", this.nzK);
                if (!be.kS(this.nzK)) {
                    i = 1;
                    if (i == 0) {
                        ak.vy().a(1038, (e) this);
                        a aVar = new a();
                        aVar.czn = new kn();
                        aVar.czo = new ko();
                        aVar.czm = 1038;
                        aVar.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
                        this.cif = aVar.Bv();
                        ((kn) this.cif.czk.czs).mna = this.nzK;
                        v.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", this.nzK);
                        this.cif = u.a(this.cif);
                    }
                    byS();
                    return;
                }
            }
        }
        i = 0;
        if (i == 0) {
            byS();
            return;
        }
        ak.vy().a(1038, (e) this);
        a aVar2 = new a();
        aVar2.czn = new kn();
        aVar2.czo = new ko();
        aVar2.czm = 1038;
        aVar2.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
        this.cif = aVar2.Bv();
        ((kn) this.cif.czk.czs).mna = this.nzK;
        v.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", this.nzK);
        this.cif = u.a(this.cif);
    }

    protected final int getLayoutId() {
        return 2130903841;
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(1038, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            ko koVar = (ko) this.cif.czl.czs;
            v.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", koVar.bol, koVar.bom);
            Intent intent = new Intent();
            intent.putExtra("key_card_id", r1);
            intent.putExtra("key_card_ext", r0);
            intent.putExtra("key_from_scene", 8);
            intent.putExtra("key_is_sms_add_card", true);
            c.a((Context) this, "card", ".ui.CardDetailUI", intent, false);
            finish();
            return;
        }
        byS();
    }

    private void byS() {
        Toast.makeText(this, getString(2131235774), 1).show();
        LauncherUI.ej(this);
        finish();
    }
}
