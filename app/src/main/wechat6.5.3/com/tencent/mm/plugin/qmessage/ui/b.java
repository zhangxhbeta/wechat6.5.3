package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b implements a, com.tencent.mm.sdk.h.j.b {
    Context context;
    private f dxf;
    private u euW;
    private boolean hTY;

    static class AnonymousClass7 extends ac {
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;

        AnonymousClass7(boolean z, j jVar) {
            this.euZ = z;
        }

        public final void handleMessage(Message message) {
            int i;
            b.c(64, this.euZ, 5);
            b.c(8192, this.euZ, 12);
            int xQ = k.xQ();
            if (this.euZ) {
                i = xQ & -33;
            } else {
                i = xQ | 32;
            }
            ak.yW();
            c.vf().set(34, Integer.valueOf(i));
            ak.yW();
            c.wG().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.euZ) {
                g.aHn();
            }
            if (this.eva != null) {
                this.eva.a(null, null);
            }
        }
    }

    public b(Context context) {
        this.context = context;
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent(this.context, QConversationUI.class);
            if (this.hTY) {
                ((Activity) this.context).setResult(-1, intent);
            } else {
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qmessage_recv_offline_msg")) {
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow(str);
            if (checkBoxPreference.isChecked()) {
                c(64, true, 5);
            } else if (ou(8192)) {
                com.tencent.mm.ui.base.g.a(this.context, 2131232112, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ b hZX;

                    {
                        this.hZX = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.c(8192, false, 12);
                        b.c(64, false, 5);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ b hZX;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        checkBoxPreference.ocf = true;
                        this.hZX.XR();
                    }
                });
            } else {
                c(64, false, 5);
                return true;
            }
            return true;
        } else if (str.equals("contact_info_qmessage_display_weixin_online")) {
            c(8192, ((CheckBoxPreference) this.dxf.Ow(str)).isChecked(), 12);
            return true;
        } else if (str.equals("contact_info_qmessage_clear_data")) {
            com.tencent.mm.ui.base.g.b(this.context, this.context.getString(2131232017), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ b hZX;

                {
                    this.hZX = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.aHn();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_qmessage_install")) {
            ak.yW();
            if (be.f((Integer) c.vf().get(9, null)) == 0) {
                com.tencent.mm.ui.base.g.b(this.context, 2131235207, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ b hZX;

                    {
                        this.hZX = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.ay.c.a(this.hZX.context, "accountsync", "com.tencent.mm.ui.bindqq.BindQQUI", null);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ b hZX;

                    {
                        this.hZX = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_qmessage_uninstall")) {
            com.tencent.mm.ui.base.g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ b hZX;

                {
                    this.hZX = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.f(this.hZX.context, false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public static void f(Context context, boolean z) {
        String string = z ? context.getString(2131235103) : context.getString(2131235111);
        context.getString(2131231164);
        final p a = com.tencent.mm.ui.base.g.a(context, string, true, null);
        final AnonymousClass7 anonymousClass7 = new AnonymousClass7(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass7.sendEmptyMessage(0);
                }
            }
        }, 5000);
    }

    private static boolean ou(int i) {
        return (k.xJ() & i) != 0;
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(uVar != null);
        Assert.assertTrue(m.eK(uVar.field_username));
        if (fVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        ak.yW();
        c.vf().a(this);
        this.euW = uVar;
        this.hTY = z;
        this.dxf = fVar;
        XR();
        return true;
    }

    final void XR() {
        int i = 1;
        int i2 = (k.xQ() & 32) == 0 ? 1 : 0;
        boolean ou = ou(64);
        ou(8192);
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099676);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
        helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232114));
        if (i2 == 0) {
            i = 0;
        }
        helperHeaderPreference.updateStatus(i);
        if (i2 == 0) {
            this.dxf.Ox("contact_info_view_message");
            this.dxf.Ox("contact_info_qmessage_recv_offline_msg");
            this.dxf.Ox("contact_info_qmessage_uninstall");
            this.dxf.Ox("contact_info_qmessage_clear_data");
            return;
        }
        this.dxf.Ox("contact_info_qmessage_install");
        ((CheckBoxPreference) this.dxf.Ow("contact_info_qmessage_recv_offline_msg")).ocf = ou;
    }

    static void c(int i, boolean z, int i2) {
        int xJ = k.xJ();
        if (z) {
            xJ |= i;
        } else {
            xJ &= i ^ -1;
        }
        ak.yW();
        c.vf().set(7, Integer.valueOf(xJ));
        xJ = z ? 1 : 2;
        ak.yW();
        c.wG().b(new com.tencent.mm.ak.g(i2, xJ));
    }

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        com.tencent.mm.plugin.qmessage.a.hZE.ow();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        ak.yW();
        if (jVar == c.vf()) {
            XR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
