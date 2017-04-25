package com.tencent.mm.plugin.wallet.trading;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletPayOrCollectUI extends WalletBaseUI {
    private View kKY;
    private View kKZ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kKY = findViewById(2131759963);
        this.kKZ = findViewById(2131759964);
        f.g(this, 1);
        e.yD(30);
        vD(2131236361);
        NI();
        b(new l(null), true);
    }

    protected final void NI() {
        super.NI();
        this.kKY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayOrCollectUI kLa;

            {
                this.kLa = r1;
            }

            public final void onClick(View view) {
                k.bfW();
                if (!k.b(this.kLa, 4, this.kLa.pjH, new a(this) {
                    final /* synthetic */ AnonymousClass1 kLb;

                    {
                        this.kLb = r1;
                    }

                    public final boolean a(int i, int i2, String str, boolean z) {
                        v.i("MicroMsg.WalletPayOrCollectUI", "getDisclaimer   resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                        if (i == 2) {
                            this.kLb.kLa.p(new com.tencent.mm.plugin.wallet_core.id_verify.a.f());
                        } else if (i == 0 && z) {
                            this.kLb.kLa.p(new com.tencent.mm.plugin.wallet_core.id_verify.a.f());
                        }
                        return true;
                    }
                }, 1006)) {
                    this.kLa.p(new com.tencent.mm.plugin.wallet_core.id_verify.a.f());
                }
            }
        });
        this.kKZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayOrCollectUI kLa;

            {
                this.kLa = r1;
            }

            public final void onClick(View view) {
                this.kLa.sk(1);
            }
        });
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.a.f) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.id_verify.a.f fVar = (com.tencent.mm.plugin.wallet_core.id_verify.a.f) kVar;
                if ("1".equals(fVar.kMy) || ("2".equals(fVar.kMy) && !be.kS(fVar.kMz))) {
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".trading.WalletPayOrCollectUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, fVar.kMz, fVar.kMA, fVar.kMB, bundle, false, null, 1006, 1);
                    return true;
                }
                sk(2);
                return true;
            }
            sk(2);
            return true;
        } else if ((kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.a.e) || (kVar instanceof l)) {
            return true;
        } else {
            return false;
        }
    }

    protected final int getLayoutId() {
        if (u.bsU()) {
            return 2130904667;
        }
        return 2130904668;
    }

    private void sk(int i) {
        if (i == 1) {
            e.yD(31);
            Intent intent = new Intent();
            intent.putExtra("key_from_scene", 2);
            c.b(this.nDR.nEl, "offline", ".ui.WalletOfflineEntranceUI", intent);
        } else {
            e.yD(32);
            com.tencent.mm.pluginsdk.wallet.e.dq(this);
        }
        finish();
    }
}
