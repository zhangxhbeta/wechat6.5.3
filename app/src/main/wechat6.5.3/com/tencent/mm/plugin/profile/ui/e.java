package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ak.n;
import com.tencent.mm.e.a.gr;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j;

public final class e extends k implements b {

    static class AnonymousClass1 implements a {
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;
        final /* synthetic */ p evb;

        AnonymousClass1(boolean z, j jVar, p pVar) {
            this.euZ = z;
            this.evb = pVar;
        }

        public final boolean oU() {
            int i;
            int xQ = k.xQ();
            if (this.euZ) {
                i = xQ & -32769;
            } else {
                i = xQ | 32768;
            }
            ak.yW();
            c.vf().set(34, Integer.valueOf(i));
            ak.yW();
            c.wG().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.euZ) {
                e.ua();
            }
            if (this.eva != null) {
                this.eva.a(null, null);
            }
            if (this.evb != null) {
                this.evb.dismiss();
            }
            return true;
        }
    }

    public final /* bridge */ /* synthetic */ boolean XS() {
        return super.XS();
    }

    public final /* bridge */ /* synthetic */ void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        super.a(i, jVar, obj);
    }

    public final /* bridge */ /* synthetic */ boolean a(f fVar, u uVar, boolean z, int i) {
        return super.a(fVar, uVar, z, i);
    }

    public final /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public e(Context context) {
        super(context, new r(context));
        com.tencent.mm.sdk.c.a.nhr.z(new gr());
    }

    public static void ua() {
        ak.yW();
        c.wJ().MO("feedsapp");
        ak.yW();
        c.wK().Mf("feedsapp");
    }

    protected final void clear() {
        ua();
    }

    protected final void eM(boolean z) {
        Context context = this.context;
        String string = z ? context.getString(2131235103) : context.getString(2131235111);
        context.getString(2131231164);
        new ah(new AnonymousClass1(z, null, g.a(context, string, true, null)), false).ea(1500);
    }

    protected final boolean aGK() {
        return (k.xQ() & 32768) == 0;
    }

    public final boolean pz(String str) {
        if ("contact_info_plugin_view".equals(str)) {
            Intent intent = new Intent();
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            com.tencent.mm.ay.c.b(this.context, "sns", ".ui.SnsTimeLineUI", intent);
            return true;
        }
        if ("contact_info_plugin_outsize".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            com.tencent.mm.ay.c.b(this.context, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if ("contact_info_plugin_black".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            com.tencent.mm.ay.c.b(this.context, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (!str.equals("contact_info_plugin_uninstall")) {
            return super.pz(str);
        }
        g.b(this.context, this.context.getString(2131235108), "", this.context.getString(2131231162), this.context.getString(2131231010), new OnClickListener(this) {
            final /* synthetic */ e hVB;

            {
                this.hVB = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.hVB.eM(false);
            }
        }, null);
        return true;
    }
}
