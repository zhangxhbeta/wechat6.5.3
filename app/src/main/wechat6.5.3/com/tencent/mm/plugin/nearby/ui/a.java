package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.nearby.a.d;
import com.tencent.mm.plugin.nearby.a.g;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j;
import com.tencent.mm.v.e;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.c.a, b, e {
    private static boolean hFa = true;
    private Context context;
    private p dwg;
    private f dxf;
    private u euW;
    private d hEX;
    private View hEY;
    private CheckBox hEZ;
    private h hFb = null;

    static class AnonymousClass6 extends ac {
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;

        AnonymousClass6(boolean z, j jVar) {
            this.euZ = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int xQ = k.xQ();
            if (this.euZ) {
                i = xQ & -513;
            } else {
                i = xQ | 512;
            }
            ak.yW();
            c.vf().set(34, Integer.valueOf(i));
            ak.yW();
            c.wG().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.euZ) {
                g.aDB();
            }
            if (this.eva != null) {
                this.eva.a(null, null);
            }
        }
    }

    public a(Context context) {
        this.context = context;
        this.hEY = View.inflate(context, 2130903854, null);
        this.hEZ = (CheckBox) this.hEY.findViewById(2131757691);
        this.hEZ.setChecked(false);
        ak.vy().a(148, this);
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_lbs_go_lbs")) {
            ak.yW();
            Boolean bool = (Boolean) c.vf().get(4103, null);
            if (bool == null || !bool.booleanValue()) {
                com.tencent.mm.ay.c.w(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
            } else {
                bf zP = bf.zP();
                if (zP == null) {
                    com.tencent.mm.ay.c.w(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                } else {
                    String ma = be.ma(zP.getProvince());
                    String ma2 = be.ma(zP.getCity());
                    int i = zP.bBZ;
                    if (ma.equals("") || ma2.equals("") || i == 0) {
                        com.tencent.mm.ay.c.w(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                    } else {
                        ak.yW();
                        bool = (Boolean) c.vf().get(4104, null);
                        if (bool == null || !bool.booleanValue()) {
                            com.tencent.mm.aw.a.cU(this.context);
                            ((Activity) this.context).finish();
                        } else if (this.hFb == null) {
                            this.hFb = com.tencent.mm.ui.base.g.a(this.context, this.context.getString(2131231164), this.hEY, new OnClickListener(this) {
                                final /* synthetic */ a hFc;

                                {
                                    this.hFc = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ak.yW();
                                    c.vf().set(4104, Boolean.valueOf(!this.hFc.hEZ.isChecked()));
                                    com.tencent.mm.aw.a.cU(this.hFc.context);
                                    ((Activity) this.hFc.context).finish();
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ a hFc;

                                {
                                    this.hFc = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else {
                            this.hFb.show();
                        }
                    }
                }
            }
            return true;
        } else if (str.equals("contact_info_lbs_install")) {
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_lbs_clear_info")) {
            com.tencent.mm.ui.base.g.a(this.context, 2131233983, 2131233982, new OnClickListener(this) {
                final /* synthetic */ a hFc;

                {
                    this.hFc = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.hFc.hEX = new d(2, 0.0f, 0.0f, 0, 0, "", "");
                    ak.vy().a(this.hFc.hEX, 0);
                    a aVar = this.hFc;
                    Context a = this.hFc.context;
                    this.hFc.context.getString(2131231164);
                    aVar.dwg = com.tencent.mm.ui.base.g.a(a, this.hFc.context.getString(2131233986), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass4 hFd;

                        {
                            this.hFd = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(this.hFd.hFc.hEX);
                        }
                    });
                }
            }, new OnClickListener(this) {
                final /* synthetic */ a hFc;

                {
                    this.hFc = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        } else if (str.equals("contact_info_lbs_uninstall")) {
            com.tencent.mm.ui.base.g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ a hFc;

                {
                    this.hFc = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.f(this.hFc.context, false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(m.eQ(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        v.v("MicroMsg.ContactWidgetLBS", "listener added");
        this.euW = uVar;
        this.dxf = fVar;
        hFa = true;
        fVar.addPreferencesFromResource(2131099670);
        XR();
        return true;
    }

    private void XR() {
        int i;
        boolean z;
        boolean z2 = true;
        boolean z3 = (k.xQ() & 512) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
        helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232062));
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.updateStatus(i);
        this.dxf.aO("contact_info_lbs_install", z3);
        f fVar = this.dxf;
        String str = "contact_info_lbs_go_lbs";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        fVar = this.dxf;
        str = "contact_info_lbs_clear_info";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        f fVar2 = this.dxf;
        String str2 = "contact_info_lbs_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.aO(str2, z2);
    }

    public static void f(Context context, boolean z) {
        String string = z ? context.getString(2131235103) : context.getString(2131235111);
        hFa = z;
        context.getString(2131231164);
        final p a = com.tencent.mm.ui.base.g.a(context, string, true, null);
        final AnonymousClass6 anonymousClass6 = new AnonymousClass6(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass6.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        ak.vy().b(148, this);
        com.tencent.mm.plugin.nearby.a.drq.ow();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 40 || n == 34 || n == 7) {
            XR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.hEX != null || ((d) kVar).AG() != 2) {
            v.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
            if (kVar.getType() == 148) {
                int i3;
                if (this.dwg != null) {
                    this.dwg.dismiss();
                    this.dwg = null;
                }
                if (i == 0 && i2 == 0) {
                    i3 = 2131233985;
                } else {
                    i3 = 2131233984;
                }
                if (((d) kVar).AG() == 2 && hFa) {
                    com.tencent.mm.ui.base.g.a(this.context, i3, 2131231164, new OnClickListener(this) {
                        final /* synthetic */ a hFc;

                        {
                            this.hFc = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    this.hEX = null;
                }
            }
        }
    }
}
