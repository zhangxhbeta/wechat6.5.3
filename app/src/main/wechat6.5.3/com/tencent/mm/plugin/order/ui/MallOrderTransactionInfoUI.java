package com.tencent.mm.plugin.order.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.List;

public class MallOrderTransactionInfoUI extends WalletPreferenceUI {
    protected f ezq;
    private int hPp;
    private MallTransactionObject hPq = null;
    private c hPr;

    public void onCreate(Bundle bundle) {
        String string;
        String str = null;
        super.onCreate(bundle);
        b ae = a.ae(this);
        if (ae != null && (ae instanceof com.tencent.mm.plugin.order.a.a)) {
            string = aFV().getString("key_trans_id");
            str = aFV().getString("bill_id");
        } else if (getIntent().getIntExtra("scene", 0) == 1) {
            string = getIntent().getStringExtra("trans_id");
            str = getIntent().getStringExtra("bill_id");
        } else {
            string = null;
        }
        if (be.kS(string)) {
            v.w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
            g.a(this.nDR.nEl, 2131236242, 0, new OnClickListener(this) {
                final /* synthetic */ MallOrderTransactionInfoUI hPs;

                {
                    this.hPs = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.hPs.finish();
                }
            });
        }
        this.hPp = aFV().getInt("key_pay_type");
        NI();
        bLG().a(new h(string, str), true, true);
    }

    protected final void NI() {
        vD(2131233747);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallOrderTransactionInfoUI hPs;

            {
                this.hPs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hPs.finish();
                return false;
            }
        });
        this.ezq = this.ocZ;
        this.hPr = new c(this);
        this.hPr.init();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.hPr != null) {
            this.hPr.release();
        }
    }

    protected final int getLayoutId() {
        return 2130903950;
    }

    public final int Oo() {
        return 2131099700;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final boolean f(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof h) {
            MallOrderDetailObject mallOrderDetailObject = ((h) kVar).hNN;
            if (mallOrderDetailObject != null) {
                List list;
                this.hPq = mallOrderDetailObject.hMC;
                this.ezq.removeAll();
                ActionBarActivity actionBarActivity = this.nDR.nEl;
                f fVar = this.ezq;
                MallTransactionObject mallTransactionObject = this.hPq;
                Object[] objArr = new Object[]{this.hPr};
                if (mallTransactionObject == null) {
                    list = null;
                } else {
                    com.tencent.mm.plugin.order.model.a.a bVar;
                    switch (mallTransactionObject.hMR) {
                        case 21:
                            bVar = new com.tencent.mm.plugin.order.ui.a.b();
                            break;
                        default:
                            bVar = new com.tencent.mm.plugin.order.ui.a.a();
                            if (objArr[0] instanceof c) {
                                ((com.tencent.mm.plugin.order.ui.a.a) bVar).hPr = (c) objArr[0];
                                break;
                            }
                            break;
                    }
                    list = bVar.a(actionBarActivity, fVar, mallTransactionObject);
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        this.ezq.a((Preference) list.get(i3));
                    }
                }
                this.ezq.notifyDataSetChanged();
            }
        }
        return true;
    }

    private Bundle aFV() {
        Bundle ad = a.ad(this);
        if (ad == null) {
            return new Bundle();
        }
        return ad;
    }
}
