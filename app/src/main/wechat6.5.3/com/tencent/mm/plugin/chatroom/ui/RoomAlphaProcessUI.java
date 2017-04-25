package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.chatroom.c.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;

@a(3)
@Deprecated
public class RoomAlphaProcessUI extends MMActivity implements a {
    private String biB;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.biB = getIntent().getStringExtra("RoomInfo_Id");
        o oVar = new o(this.biB);
        ak.vy().a(482, new com.tencent.mm.plugin.chatroom.ui.a.AnonymousClass2(false, g.a(this, getString(2131233521), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        }), this, this));
        ak.vy().a(oVar, 0);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
    }

    public final int getLayoutId() {
        return -1;
    }

    private static void k(Runnable runnable) {
        new ac().postDelayed(runnable, 200);
    }

    public final void e(final boolean z, final int i) {
        if (z) {
            g.bf(this, getString(2131234687));
            k(new Runnable(this) {
                final /* synthetic */ RoomAlphaProcessUI eQM;

                public final void run() {
                    Intent intent = new Intent(this.eQM, RoomUpgradeUI.class);
                    intent.setFlags(603979776);
                    intent.putExtra("room_name", this.eQM.biB);
                    intent.putExtra("upgrade_success", z);
                    intent.putExtra("left_quota", i);
                    this.eQM.startActivity(intent);
                }
            });
            return;
        }
        g.a(this, getString(2131234686), "", null);
        k(new Runnable(this) {
            final /* synthetic */ RoomAlphaProcessUI eQM;

            public final void run() {
                Intent intent = new Intent(this.eQM, RoomUpgradeUI.class);
                intent.setFlags(603979776);
                intent.putExtra("room_name", this.eQM.biB);
                intent.putExtra("upgrade_success", z);
                this.eQM.startActivity(intent);
            }
        });
    }
}
