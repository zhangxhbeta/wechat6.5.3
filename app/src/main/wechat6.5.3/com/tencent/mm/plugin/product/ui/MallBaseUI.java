package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.g;

public abstract class MallBaseUI extends MMActivity {
    protected String dLV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallBaseUI hRz;

            {
                this.hRz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hRz.finish();
                return true;
            }
        });
    }

    protected final void xJ(String str) {
        this.dLV = str;
        showDialog(-10001);
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case -10002:
                return g.a(this.nDR.nEl, false, new OnCancelListener(this) {
                    final /* synthetic */ MallBaseUI hRz;

                    {
                        this.hRz = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
            case -10001:
                if (be.kS(this.dLV)) {
                    this.dLV = getString(2131233760);
                }
                return com.tencent.mm.ui.base.g.a(this, this.dLV, null, false, new OnClickListener(this) {
                    final /* synthetic */ MallBaseUI hRz;

                    {
                        this.hRz = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.hRz.finish();
                    }
                });
            default:
                return super.onCreateDialog(i);
        }
    }

    public final void oa(int i) {
        this.nDR.dtW.setVisibility(i);
        if (i == 0) {
            bzZ();
        } else {
            this.nDR.bAj();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            this.nDR.bAf();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
