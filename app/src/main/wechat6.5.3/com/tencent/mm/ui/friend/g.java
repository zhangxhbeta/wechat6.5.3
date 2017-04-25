package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class g implements e {
    private Context context;
    private ProgressDialog eLA;
    String lJm = SQLiteDatabase.KeyEmpty;
    a oOM;
    private boolean oON = true;

    public interface a {
        void j(boolean z, String str);
    }

    public g(Context context, a aVar) {
        this.context = context;
        this.oOM = aVar;
        this.oON = true;
    }

    public g(Context context, a aVar, byte b) {
        this.context = context;
        this.oOM = aVar;
        this.oON = false;
    }

    public final void t(int[] iArr) {
        ak.vy().a(116, (e) this);
        final k aaVar = new aa(iArr);
        ak.vy().a(aaVar, 0);
        if (this.oON) {
            Context context = this.context;
            this.context.getString(2131233331);
            this.eLA = com.tencent.mm.ui.base.g.a(context, this.context.getString(2131233329), true, new OnCancelListener(this) {
                final /* synthetic */ g oOP;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(aaVar);
                    this.oOP.oOM.j(false, this.oOP.lJm);
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 116) {
            if (this.eLA != null) {
                this.eLA.dismiss();
                this.eLA = null;
            }
            ak.vy().b(116, (e) this);
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
                if (this.oON) {
                    com.tencent.mm.ui.base.g.a(this.context, 2131233328, 2131231164, new OnClickListener(this) {
                        final /* synthetic */ g oOP;

                        {
                            this.oOP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oOP.oOM.j(true, this.oOP.lJm);
                        }
                    });
                    return;
                } else {
                    this.oOM.j(true, this.lJm);
                    return;
                }
            }
            v.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
            this.oOM.j(false, this.lJm);
        }
    }
}
