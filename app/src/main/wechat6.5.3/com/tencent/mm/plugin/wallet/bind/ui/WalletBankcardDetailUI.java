package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.bind.a.a;
import com.tencent.mm.plugin.wallet.bind.a.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public class WalletBankcardDetailUI extends WalletBaseUI {
    protected TextView kGF;
    private TextView kGG;
    private View kGH;
    protected LinearLayout kGI;
    protected LinearLayout kGJ;
    protected LinearLayout kGK;
    public Bankcard kGa;

    protected final int getLayoutId() {
        return 2130904617;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gQ(621);
        vD(2131236040);
        NI();
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        gR(621);
        super.onDestroy();
    }

    protected final void NI() {
        this.kGa = (Bankcard) this.uA.getParcelable("key_bankcard");
        if (this.kGa != null) {
            this.kGI = (LinearLayout) findViewById(2131759824);
            this.kGJ = (LinearLayout) findViewById(2131759815);
            this.kGK = (LinearLayout) findViewById(2131759828);
            this.kGG = (TextView) findViewById(2131759821);
            this.kGH = findViewById(2131759822);
            this.kGH.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBankcardDetailUI kGL;

                {
                    this.kGL = r1;
                }

                public final void onClick(View view) {
                    e.l(this.kGL, this.kGL.kGa.field_repay_url, false);
                }
            });
            if (1 == this.kGa.field_bankcardState) {
                beE();
                return;
            }
            String str;
            if (this.kGa.bfI()) {
                hb(true);
                this.kGF = (TextView) findViewById(2131759816);
                k.beN();
                k.beO();
                str = this.kGa.field_bindSerial;
                this.kGF.setVisibility(8);
            } else {
                hb(false);
                this.kGF = (TextView) findViewById(2131759829);
                k.beN();
                k.beO();
                str = this.kGa.field_bindSerial;
                this.kGF.setVisibility(8);
            }
            a(0, 2130838681, new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletBankcardDetailUI kGL;

                {
                    this.kGL = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    k.beN();
                    List bgG = k.beO().bgG();
                    if (bgG != null && bgG.size() > 1) {
                        k.beN();
                        k.beO();
                        String str = this.kGL.kGa.field_bindSerial;
                    }
                    List arrayList = new ArrayList();
                    g.a(this.kGL, null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.kGL.getString(2131236208), false, new c(this) {
                        final /* synthetic */ AnonymousClass5 kGM;

                        {
                            this.kGM = r1;
                        }

                        public final void gT(int i) {
                            switch (i) {
                                case 0:
                                    this.kGM.kGL.b(new a(this.kGM.kGL.kGa.field_bankcardType, this.kGM.kGL.kGa.field_bindSerial), true);
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
    }

    public final void hb(boolean z) {
        if (z) {
            this.kGI.setVisibility(8);
            this.kGJ.setVisibility(0);
            ((TextView) findViewById(2131759823)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBankcardDetailUI kGL;

                {
                    this.kGL = r1;
                }

                public final void onClick(View view) {
                    this.kGL.showDialog(0);
                }
            });
            TextView textView = (TextView) findViewById(2131759818);
            TextView textView2 = (TextView) findViewById(2131759819);
            TextView textView3 = (TextView) findViewById(2131759820);
            ((TextView) findViewById(2131759817)).setText(e.d(this.kGa.field_onceQuotaKind, null));
            textView.setText(e.d(this.kGa.field_onceQuotaVirtual, null));
            textView2.setText(e.d(this.kGa.field_dayQuotaKind, null));
            textView3.setText(e.d(this.kGa.field_dayQuotaVirtual, null));
            if (!be.kS(this.kGa.field_repay_url)) {
                this.kGG.setVisibility(0);
                this.kGH.setVisibility(0);
                return;
            }
            return;
        }
        this.kGI.setVisibility(8);
        this.kGJ.setVisibility(8);
        this.kGK.setVisibility(0);
    }

    public final void beE() {
        this.kGI.setVisibility(0);
        this.kGJ.setVisibility(8);
        ((TextView) findViewById(2131759827)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBankcardDetailUI kGL;

            {
                this.kGL = r1;
            }

            public final void onClick(View view) {
                this.kGL.showDialog(0);
            }
        });
        ((TextView) findViewById(2131759825)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBankcardDetailUI kGL;

            {
                this.kGL = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.wallet_core.a.k(this.kGL, this.kGL.uA);
            }
        });
    }

    private void hc(boolean z) {
        if (com.tencent.mm.model.k.xT() || z || com.tencent.mm.pluginsdk.g.a.ati()) {
            this.uA.putBoolean("offline_pay", false);
            com.tencent.mm.wallet_core.a.k(this, this.uA);
            return;
        }
        e.yD(0);
        g.a(this, 2131236042, -1, 2131236041, 2131236043, true, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletBankcardDetailUI kGL;

            {
                this.kGL = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.pluginsdk.g.a.P(this.kGL);
                e.yD(1);
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletBankcardDetailUI kGL;

            {
                this.kGL = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.kGL.hc(true);
                e.yD(2);
            }
        });
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return g.a(this.nDR.nEl, getString(2131236027), getResources().getStringArray(2131296271), "", new c(this) {
            final /* synthetic */ WalletBankcardDetailUI kGL;

            {
                this.kGL = r1;
            }

            public final void gT(int i) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.kGL.getString(2131236026)));
                        intent.addFlags(268435456);
                        this.kGL.startActivity(intent);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof b) {
                if (this.kGF == null) {
                    return false;
                }
                this.kGF.setVisibility(0);
                return false;
            } else if (!(kVar instanceof a)) {
                return false;
            } else {
                a aVar = (a) kVar;
                v.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + aVar.kGi);
                switch (aVar.kGi) {
                    case 2:
                    case 3:
                        final int i3 = aVar.kGi;
                        g.a(this, aVar.kGj, null, false, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ WalletBankcardDetailUI kGL;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (i3 == 2) {
                                    this.kGL.hc(true);
                                }
                                dialogInterface.dismiss();
                            }
                        });
                        return false;
                    default:
                        hc(false);
                        return false;
                }
            }
        } else if (!(kVar instanceof a)) {
            return false;
        } else {
            v.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
            hc(false);
            return true;
        }
    }
}
