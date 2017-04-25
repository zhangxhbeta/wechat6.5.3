package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class i implements a, b {
    private static boolean eut = false;
    private Context context;
    private f dxf;
    private u euW;

    static class AnonymousClass4 extends ac {
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;
        final /* synthetic */ Context val$context;

        AnonymousClass4(boolean z, Context context, j jVar) {
            this.euZ = z;
            this.val$context = context;
        }

        public final void handleMessage(Message message) {
            int i;
            if (this.euZ) {
                i.eN(true);
            }
            int xQ = k.xQ();
            if (this.euZ) {
                i = xQ & -17;
            } else {
                i = xQ | 16;
            }
            ak.yW();
            c.vf().set(34, Integer.valueOf(i));
            ak.yW();
            c.wG().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.euZ) {
                i.co(this.val$context);
            }
            if (this.eva != null) {
                this.eva.a(null, null);
            }
        }
    }

    static /* synthetic */ void co(Context context) {
        eut = false;
        context.getString(2131231164);
        final p a = g.a(context, context.getString(2131231182), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                i.eut = true;
            }
        });
        aw.a("medianote", new aw.a() {
            public final boolean zp() {
                return i.eut;
            }

            public final void zo() {
                if (a != null) {
                    a.dismiss();
                }
            }
        });
        ak.yW();
        c.wK().Mf("medianote");
    }

    public i(Context context) {
        this.context = context;
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_medianote_view")) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", "medianote");
            com.tencent.mm.plugin.profile.a.drp.e(intent, this.context);
            com.tencent.mm.plugin.profile.a.drq.ow();
            return true;
        } else if (str.equals("contact_info_medianote_sync_to_qqmail")) {
            if (k.yn()) {
                eN(((CheckBoxPreference) this.dxf.Ow(str)).isChecked());
            } else {
                g.a(this.context, 2131232087, 2131232086, new OnClickListener(this) {
                    final /* synthetic */ i hVN;

                    {
                        this.hVN = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.profile.a.drp.h(new Intent(), this.hVN.context);
                    }
                }, null);
                XR();
            }
            return true;
        } else if (str.equals("contact_info_medianote_clear_data")) {
            g.b(this.context, this.context.getString(2131232017), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ i hVN;

                {
                    this.hVN = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.co(this.hVN.context);
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_medianote_install")) {
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_medianote_uninstall")) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ i hVN;

                {
                    this.hVN = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.f(this.hVN.context, false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (uVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(m.eS(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        this.euW = uVar;
        this.dxf = fVar;
        fVar.addPreferencesFromResource(2131099673);
        XR();
        return true;
    }

    private void XR() {
        boolean z;
        int i;
        boolean z2;
        boolean z3 = true;
        boolean z4 = (k.xQ() & 16) == 0;
        int xJ = k.xJ();
        if (k.yn()) {
            z = (xJ & 16384) != 0;
        } else {
            if ((xJ & 16384) != 0) {
                xJ &= -16385;
                ak.yW();
                c.vf().set(7, Integer.valueOf(xJ));
            }
            z = false;
        }
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
        helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232088));
        if (z4) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.updateStatus(i);
        this.dxf.aO("contact_info_medianote_install", z4);
        f fVar = this.dxf;
        String str = "contact_info_medianote_view";
        if (z4) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.aO(str, z2);
        if (!z4 || k.yn()) {
            z2 = z4;
        } else {
            if (be.getInt(com.tencent.mm.h.j.sU().getValue("BindQQSwitch"), 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            v.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
        }
        fVar = this.dxf;
        str = "contact_info_medianote_sync_to_qqmail";
        if (z2) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.aO(str, z2);
        fVar = this.dxf;
        str = "contact_info_medianote_clear_data";
        if (z4) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.aO(str, z2);
        f fVar2 = this.dxf;
        String str2 = "contact_info_medianote_uninstall";
        if (z4) {
            z3 = false;
        }
        fVar2.aO(str2, z3);
        ((CheckBoxPreference) this.dxf.Ow("contact_info_medianote_sync_to_qqmail")).ocf = z;
    }

    public static void f(Context context, boolean z) {
        String string = z ? context.getString(2131235103) : context.getString(2131235111);
        context.getString(2131231164);
        final p a = g.a(context, string, true, null);
        final AnonymousClass4 anonymousClass4 = new AnonymousClass4(z, context, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass4.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        com.tencent.mm.plugin.profile.a.drq.ow();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 40 || n == 34 || n == 7) {
            XR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    static void eN(boolean z) {
        int xJ = k.xJ();
        if (z) {
            xJ |= 16384;
        } else {
            xJ &= -16385;
        }
        ak.yW();
        c.vf().set(7, Integer.valueOf(xJ));
        xJ = z ? 1 : 2;
        ak.yW();
        c.wG().b(new com.tencent.mm.ak.g(13, xJ));
    }
}
