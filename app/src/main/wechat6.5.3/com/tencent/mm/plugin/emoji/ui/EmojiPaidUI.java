package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g.c;
import java.util.ArrayList;

public class EmojiPaidUI extends BaseEmojiStoreUI {
    private g[] fhR;

    protected final int ago() {
        return 2;
    }

    protected final int agm() {
        return 2;
    }

    protected final void NI() {
        vD(2131232351);
        if (k.xS()) {
            a(0, 2130838681, new OnMenuItemClickListener(this) {
                final /* synthetic */ EmojiPaidUI fhS;

                {
                    this.fhS = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.base.g.a(this.fhS.nDR.nEl, null, null, this.fhS.getResources().getString(2131232354), false, new c(this.fhS) {
                        final /* synthetic */ EmojiPaidUI fhS;

                        {
                            this.fhS = r1;
                        }

                        public final void gT(int i) {
                            switch (i) {
                                case 0:
                                    Intent intent = new Intent();
                                    intent.putExtra("key_action_type", 200002);
                                    com.tencent.mm.ay.c.b(this.fhS, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                                    v.i("MicroMsg.emoji.EmojiPaidUI", "[showMenuDialog] startActivityForResult ui.WalletIapUI");
                                    this.fhS.ags();
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return true;
                }
            });
        }
        super.NI();
        this.dZV.setVisibility(8);
        this.Eq.setVisibility(8);
    }

    protected final void agg() {
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.fhR != null && this.fhR.length > 0) {
            for (com.tencent.mm.v.k c : this.fhR) {
                ak.vy().c(c);
            }
        }
    }

    protected final void a(g gVar) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        agt();
        String str = "";
        int intExtra;
        if (intent != null) {
            intExtra = intent.getIntExtra("key_err_code", 0);
            v.w("MicroMsg.emoji.EmojiPaidUI", "errCode:" + intExtra);
            CharSequence stringExtra = intent.getStringExtra("key_err_msg");
            v.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:" + stringExtra);
        } else {
            Object obj = str;
            intExtra = 0;
        }
        if (i2 != -1) {
            Toast.makeText(this, 2131232355, 0).show();
        } else if (intent == null || r0 != 0) {
            Toast.makeText(this, stringExtra, 0).show();
        } else {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                Toast.makeText(this, stringExtra, 0).show();
                return;
            }
            this.ffJ = null;
            this.ffG = -1;
            k(false, false);
            ak.yW();
            com.tencent.mm.model.c.vf().set(208900, Boolean.valueOf(true));
            Toast.makeText(this, 2131232356, 0).show();
        }
    }

    protected final void a(boolean z, e eVar, boolean z2, boolean z3) {
        if (!(eVar == null || !z || this.fcY == null)) {
            this.fcY.b(eVar);
        }
        if (this.fcY == null || eVar == null || eVar.fcS <= 0) {
            this.dZV.setVisibility(0);
            this.ffE.setText(2131232349);
            this.Eq.setVisibility(8);
            return;
        }
        this.dZV.setVisibility(8);
        this.Eq.setVisibility(0);
    }

    protected final boolean agj() {
        return false;
    }

    protected final a age() {
        return new d(this.nDR.nEl);
    }

    public final void a(String str, i iVar) {
        if (str != null && str.equals("event_update_group")) {
            agG();
            by(131074, 50);
        }
    }

    protected final int agc() {
        return 10;
    }

    protected final int agd() {
        return 6;
    }
}
