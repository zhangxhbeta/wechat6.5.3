package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.c.amv;
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

public final class b implements a, com.tencent.mm.sdk.h.j.b {
    Context context;
    private f dxf;
    private u euW;

    static class AnonymousClass3 extends ac {
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;
        final /* synthetic */ Context val$context;

        AnonymousClass3(boolean z, Context context, j jVar) {
            this.euZ = z;
            this.val$context = context;
        }

        public final void handleMessage(Message message) {
            if (this.euZ) {
                b.fb(true);
            }
            int xQ = k.xQ();
            if (this.euZ) {
                xQ &= -524289;
            } else {
                xQ |= 524288;
            }
            ak.yW();
            c.vf().set(34, Integer.valueOf(xQ));
            amv com_tencent_mm_protocal_c_amv = new amv();
            com_tencent_mm_protocal_c_amv.mau = 524288;
            if (this.euZ) {
                xQ = 0;
            } else {
                xQ = 1;
            }
            com_tencent_mm_protocal_c_amv.mNo = xQ;
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(39, com_tencent_mm_protocal_c_amv));
            if (!this.euZ) {
                final p a = g.a(this.val$context, this.val$context.getString(2131234312), false, null);
                com.tencent.mm.plugin.readerapp.b.g.a(new com.tencent.mm.plugin.readerapp.b.g.a(this) {
                    final /* synthetic */ AnonymousClass3 ilm;

                    public final void aJd() {
                        if (a != null) {
                            a.dismiss();
                        }
                    }
                });
                b.fb(false);
            }
            if (this.eva != null) {
                this.eva.a(null, null);
            }
        }
    }

    public b(Context context) {
        this.context = context;
    }

    static void fb(boolean z) {
        int xL = k.xL();
        if (z) {
            xL &= -1025;
        } else {
            xL |= 1024;
        }
        ak.yW();
        c.vf().set(40, Integer.valueOf(xL));
        xL = z ? 2 : 1;
        ak.yW();
        c.wG().b(new com.tencent.mm.ak.g(26, xL));
    }

    public final boolean pz(String str) {
        boolean z = false;
        v.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_readerappnews_view")) {
            Intent intent = new Intent(this.context, ReaderAppUI.class);
            intent.addFlags(67108864);
            intent.putExtra("type", 20);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
            com.tencent.mm.plugin.readerapp.a.a.drq.ow();
            return true;
        } else if (str.equals("contact_info_readerappnews_subscribe")) {
            this.context.startActivity(new Intent(this.context, ReaderAppSubscribeUI.class));
            return true;
        } else if (str.equals("contact_info_readerappnews_clear_data")) {
            g.b(this.context, this.context.getString(2131232018), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ b ilk;

                {
                    this.ilk = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    final p a = g.a(this.ilk.context, this.ilk.context.getString(2131234312), false, null);
                    com.tencent.mm.plugin.readerapp.b.g.a(new com.tencent.mm.plugin.readerapp.b.g.a(this) {
                        final /* synthetic */ AnonymousClass1 ill;

                        public final void aJd() {
                            a.dismiss();
                        }
                    });
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_readerappnews_recv_remind")) {
            boolean z2;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow(str);
            boolean aJe = com.tencent.mm.plugin.readerapp.b.c.aJe();
            if (aJe) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference.ocf = z2;
            if (!aJe) {
                z = true;
            }
            fb(z);
            return true;
        } else if (str.equals("contact_info_readerappnews_install")) {
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_readerappnews_uninstall")) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ b ilk;

                {
                    this.ilk = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.f(this.ilk.context, false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(m.eT(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        this.euW = uVar;
        this.dxf = fVar;
        XR();
        return true;
    }

    private void XR() {
        int i = 1;
        int i2 = (k.xQ() & 524288) == 0 ? 1 : 0;
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099680);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
        helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232132));
        if (i2 == 0) {
            i = 0;
        }
        helperHeaderPreference.updateStatus(i);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_readerappnews_recv_remind");
        boolean aJe = com.tencent.mm.plugin.readerapp.b.c.aJe();
        v.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = " + aJe);
        checkBoxPreference.ocf = aJe;
        if (i2 != 0) {
            this.dxf.Ox("contact_info_readerappnews_install");
            return;
        }
        this.dxf.Ox("contact_info_readerappnews_subscribe");
        this.dxf.Ox("contact_info_readerappnews_view");
        this.dxf.Ox("contact_info_readerappnews_clear_data");
        this.dxf.Ox("contact_info_readerappnews_uninstall");
        this.dxf.Ox("contact_info_readerappnews_recv_remind");
    }

    public static void f(Context context, boolean z) {
        String string = z ? context.getString(2131235103) : context.getString(2131235111);
        context.getString(2131231164);
        final p a = g.a(context, string, true, null);
        final AnonymousClass3 anonymousClass3 = new AnonymousClass3(z, context, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass3.sendEmptyMessage(0);
                }
            }
        }, 5000);
    }

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        com.tencent.mm.plugin.readerapp.a.a.drq.ow();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 40 || n == 34 || n == 7) {
            XR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
