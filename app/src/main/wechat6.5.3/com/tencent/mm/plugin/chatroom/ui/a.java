package com.tencent.mm.plugin.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.i;
import com.tencent.mm.plugin.chatroom.c.o;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a {

    static class AnonymousClass2 implements e {
        final /* synthetic */ ProgressDialog ePM;
        final /* synthetic */ boolean eRD = false;
        final /* synthetic */ a eRE;
        final /* synthetic */ Activity nw;

        AnonymousClass2(boolean z, ProgressDialog progressDialog, Activity activity, a aVar) {
            this.ePM = progressDialog;
            this.nw = activity;
            this.eRE = aVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ak.vy().b(482, this);
            if (!this.eRD) {
                this.ePM.cancel();
            }
            boolean z = false;
            this.nw.getString(2131234686);
            o oVar = (o) kVar;
            if (i == 0 && i2 == 0) {
                com.tencent.mm.storage.o LC = ak.yW().wO().LC(oVar.biB);
                if (LC == null) {
                    LC = new com.tencent.mm.storage.o();
                }
                LC.dK(com.tencent.mm.model.k.xF(), oVar.eOY);
                i.a(LC);
                z = true;
            }
            if (this.eRE != null) {
                this.eRE.e(z, oVar.eOZ);
            }
        }
    }

    interface a {
        void e(boolean z, int i);
    }

    public static void a(Activity activity, String str, boolean z) {
        if (z) {
            Intent intent = new Intent(activity, RoomUpgradeUI.class);
            intent.setFlags(603979776);
            intent.putExtra("room_name", str);
            Intent intent2 = new Intent();
            intent2.setClassName(activity, "com.tencent.mm.ui.account.bind.BindMobileUI");
            intent2.putExtra("is_bind_for_chatroom_upgrade", true);
            MMWizardActivity.b(activity, intent2, intent);
            return;
        }
        intent = new Intent(activity, RoomUpgradeUI.class);
        intent.setFlags(603979776);
        intent.putExtra("room_name", str);
        intent.putExtra("announce_ok", true);
        activity.startActivity(intent);
    }
}
