package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.c.a, b, e {
    private static boolean ieq = false;
    private boolean aZw;
    private Context context;
    private ProgressDialog dwR;
    private f dxf;
    private ProgressDialog eLA;
    private u euW;
    private boolean hTY;
    private boolean iep;

    public a(Context context) {
        Assert.assertTrue(context != null);
        this.context = context;
    }

    public final boolean pz(String str) {
        boolean z = false;
        v.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        Intent intent;
        if (str.equals("contact_info_qqmailhelper_view")) {
            intent = new Intent();
            if (this.hTY) {
                intent.putExtra("Chat_User", this.euW.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.euW.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                com.tencent.mm.plugin.qqmail.a.a.drp.e(intent, this.context);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qqmailhelper_compose")) {
            intent = new Intent(this.context, ComposeUI.class);
            if (this.hTY) {
                intent.putExtra("Chat_User", this.euW.field_username);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.euW.field_username);
                intent.addFlags(67108864);
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qqmailhelper_set_files_view")) {
            ak.yW();
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(be.ma((String) c.vf().get(29, null))));
            intent2.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.context.getString(2131232123));
            intent2.putExtra("zoom", false);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("showShare", false);
            intent2.putExtra("vertical_scroll", false);
            com.tencent.mm.plugin.qqmail.a.a.drp.j(intent2, this.context);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_recv_remind")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow(str);
            boolean isChecked = checkBoxPreference.isChecked();
            eU(isChecked);
            if (!isChecked) {
                z = true;
            }
            checkBoxPreference.ocf = z;
            return true;
        } else if (str.equals("contact_info_qqmailhelper_clear_data")) {
            g.a(this.context, this.context.getString(2131232019), "", new OnClickListener(this) {
                final /* synthetic */ a ier;

                {
                    this.ier = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.aHI();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_install")) {
            ak.yW();
            if (be.f((Integer) c.vf().get(9, null)) == 0) {
                g.b(this.context, 2131235207, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ a ier;

                    {
                        this.ier = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.qqmail.a.a.drp.h(null, this.ier.context);
                    }
                }, null);
                return true;
            }
            eT(true);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_uninstall")) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ a ier;

                {
                    this.ier = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.ier.eT(false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(m.eG(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        ak.vy().a(24, this);
        this.hTY = z;
        this.euW = uVar;
        this.dxf = fVar;
        fVar.addPreferencesFromResource(2131099678);
        XR();
        return true;
    }

    private void XR() {
        boolean z;
        int i;
        boolean z2 = true;
        this.aZw = (k.xQ() & 1) == 0;
        ak.yW();
        if (be.f((Integer) c.vf().get(17, null)) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.iep = z;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
        helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232124));
        if (this.aZw) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.updateStatus(i);
        this.dxf.aO("contact_info_qqmailhelper_install", this.aZw);
        f fVar = this.dxf;
        String str = "contact_info_qqmailhelper_view";
        if (this.aZw) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        fVar = this.dxf;
        str = "contact_info_qqmailhelper_compose";
        if (this.aZw) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_qqmailhelper_recv_remind");
        if (checkBoxPreference != null) {
            checkBoxPreference.ocf = this.iep;
        }
        fVar = this.dxf;
        str = "contact_info_qqmailhelper_recv_remind";
        if (this.aZw) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        fVar = this.dxf;
        str = "contact_info_qqmailhelper_set_files_view";
        if ((this.aZw & this.iep) == 0) {
            z = true;
        } else {
            z = false;
        }
        fVar.aO(str, z);
        this.dxf.aO("contact_info_qqmailhelper_download_mgr_view", true);
        fVar = this.dxf;
        str = "contact_info_qqmailhelper_clear_data";
        if (this.aZw) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        f fVar2 = this.dxf;
        String str2 = "contact_info_qqmailhelper_uninstall";
        if (this.aZw) {
            z2 = false;
        }
        fVar2.aO(str2, z2);
    }

    private void eT(boolean z) {
        String string = z ? this.context.getString(2131235103) : this.context.getString(2131235111);
        Context context = this.context;
        this.context.getString(2131231164);
        this.eLA = g.a(context, string, true, null);
        ieq = true;
        eU(z);
    }

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        ak.vy().b(24, this);
        if (this.eLA != null) {
            this.eLA.dismiss();
            this.eLA = null;
        }
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        return true;
    }

    public final void a(int i, j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetQQMail", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetQQMail", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 17 || n == 34 || n == 7) {
            XR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    private boolean eU(boolean z) {
        final o oVar = new o(z, "");
        if (!ieq) {
            this.dwR = g.a(this.context, this.context.getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ a ier;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(oVar);
                }
            });
        }
        ak.vy().a(oVar, 0);
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar.getType() != 24) {
            v.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd : unExpected type = " + kVar.getType());
            return;
        }
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (this.eLA != null) {
            this.eLA.dismiss();
            this.eLA = null;
        }
        if (i == 0 && i2 == 0) {
            boolean z = ((o) kVar).brc;
            ak.yW();
            c.vf().set(17, Integer.valueOf(z ? 1 : 2));
            if (ieq && be.bm(this.context)) {
                if (z) {
                    ak.yW();
                    c.vf().set(17, Integer.valueOf(1));
                }
                int xQ = k.xQ();
                int i3 = z ? xQ & -2 : xQ | 1;
                ak.yW();
                c.vf().set(34, Integer.valueOf(i3));
                ak.yW();
                c.wG().b(new n("", "", "", "", "", "", "", "", i3, "", ""));
                com.tencent.mm.plugin.qqmail.a.a.drq.ow();
                if (!z) {
                    x.aHI();
                }
            }
            ieq = false;
            return;
        }
        CharSequence string;
        final boolean z2 = ((o) kVar).brc;
        v.e("MicroMsg.ContactWidgetQQMail", "NetSceneSwitchPushMail fail : errType = " + i + ", errCode = " + i2);
        if (i == 4) {
            switch (i2) {
                case -31:
                    v.i("MicroMsg.ContactWidgetQQMail", "need second pass");
                    View inflate = View.inflate(this.context, 2130904314, null);
                    final EditText editText = (EditText) inflate.findViewById(2131759013);
                    g.a(this.context, this.context.getString(2131232122), inflate, new OnClickListener(this) {
                        final /* synthetic */ a ier;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            final o oVar = new o(z2, com.tencent.mm.a.g.m(editText.getText().toString().trim().getBytes()));
                            ak.vy().a(oVar, 0);
                            a aVar = this.ier;
                            Context a = this.ier.context;
                            this.ier.context.getString(2131232120);
                            aVar.dwR = g.a(a, this.ier.context.getString(2131231182), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass5 ieu;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ak.vy().c(oVar);
                                }
                            });
                        }
                    });
                    return;
                case -1:
                    v.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd, sys err");
                    break;
                default:
                    return;
            }
        }
        if (ieq) {
            string = this.context.getString(z2 ? 2131235100 : 2131235106);
        } else {
            string = this.context.getString(2131231041);
        }
        Toast.makeText(this.context, string, 1).show();
        ieq = false;
    }
}
