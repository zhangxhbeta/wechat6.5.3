package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class AutoAddFriendUI extends MMActivity {
    private MMSwitchBtn kfU = null;
    private TextView kfV = null;
    private MMSwitchBtn kfW = null;
    private SparseIntArray kfX = new SparseIntArray();
    private int status;

    static /* synthetic */ boolean a(AutoAddFriendUI autoAddFriendUI, boolean z, int i, int i2) {
        v.d("MicroMsg.AutoAddFriendUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            autoAddFriendUI.status |= i;
        } else {
            autoAddFriendUI.status &= i ^ -1;
        }
        autoAddFriendUI.kfX.put(i2, z ? 1 : 2);
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131231199);
        this.status = k.xJ();
        NI();
    }

    private boolean op(int i) {
        return (this.status & i) != 0;
    }

    protected final int getLayoutId() {
        return 2130903140;
    }

    protected final void NI() {
        this.kfU = (MMSwitchBtn) findViewById(2131755494);
        this.kfV = (TextView) findViewById(2131755495);
        this.kfW = (MMSwitchBtn) findViewById(2131755496);
        this.kfU.kq(op(32));
        if (aZx() == 1) {
            this.kfW.kq(op(2097152));
            this.kfW.pdu = new a(this) {
                final /* synthetic */ AutoAddFriendUI kfY;

                {
                    this.kfY = r1;
                }

                public final void gB(boolean z) {
                    AutoAddFriendUI.a(this.kfY, z, 2097152, 32);
                }
            };
        } else {
            this.kfV.setVisibility(8);
            this.kfW.setVisibility(8);
        }
        this.kfU.pdu = new a(this) {
            final /* synthetic */ AutoAddFriendUI kfY;

            {
                this.kfY = r1;
            }

            public final void gB(boolean z) {
                AutoAddFriendUI.a(this.kfY, z, 32, 4);
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AutoAddFriendUI kfY;

            {
                this.kfY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kfY.finish();
                return true;
            }
        });
    }

    private static int aZx() {
        int i;
        String value = j.sU().getValue("AutoAddFriendShow");
        if (be.kS(value)) {
            value = "0";
        }
        try {
            i = be.getInt(value, 0);
        } catch (Exception e) {
            i = 0;
        }
        v.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        ak.yW();
        c.vf().set(7, Integer.valueOf(this.status));
        for (int i = 0; i < this.kfX.size(); i++) {
            int keyAt = this.kfX.keyAt(i);
            int valueAt = this.kfX.valueAt(i);
            rc rcVar = new rc();
            rcVar.muR = keyAt;
            rcVar.muS = valueAt;
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(23, rcVar));
            v.d("MicroMsg.AutoAddFriendUI", "switch  " + keyAt + " " + valueAt);
        }
        this.kfX.clear();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
