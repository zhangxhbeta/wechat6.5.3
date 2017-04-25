package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.af.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class c implements a {
    Context context;
    p dwg = null;
    private f dxf;
    private u euW;
    boolean eut = false;
    private boolean hTY;
    private HelperHeaderPreference.a hVx;
    private int status;

    public c(Context context) {
        this.context = context;
        this.hVx = new p(context);
        this.status = -1;
    }

    public final boolean pz(String str) {
        boolean z = false;
        v.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_recommend_qqfriends_to_me")) {
            a(!((CheckBoxPreference) this.dxf.Ow("contact_info_recommend_qqfriends_to_me")).isChecked(), 128, 6);
            return true;
        } else if (str.equals("contact_info_recommend_mobilefriends_to_me")) {
            if (!((CheckBoxPreference) this.dxf.Ow("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
                z = true;
            }
            a(z, 256, 7);
            return true;
        } else if (str.equals("contact_info_recommend_fbfriends_to_me")) {
            z = ((CheckBoxPreference) this.dxf.Ow("contact_info_recommend_fbfriends_to_me")).isChecked();
            v.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = 4 functionId = 18");
            int xL = k.xL();
            xL = z ? xL | 4 : xL & -5;
            ak.yW();
            com.tencent.mm.model.c.vf().set(40, Integer.valueOf(xL));
            xL = z ? 1 : 2;
            ak.yW();
            com.tencent.mm.model.c.wG().b(new g(18, xL));
            return true;
        } else if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent();
            if (this.hTY) {
                intent.putExtra("Chat_User", this.euW.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
                ((Activity) this.context).finish();
                return true;
            }
            intent.putExtra("Chat_User", this.euW.field_username);
            intent.putExtra("Chat_Mode", 1);
            intent.addFlags(67108864);
            com.tencent.mm.plugin.profile.a.drp.e(intent, this.context);
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_bind_mobile_entry")) {
            com.tencent.mm.plugin.profile.a.drp.g(new Intent(), this.context);
            return true;
        } else if (str.equals("contact_info_bind_qq_entry")) {
            com.tencent.mm.plugin.profile.a.drp.h(new Intent(), this.context);
            return true;
        } else if (str.equals("contact_info_bind_fb_entry")) {
            com.tencent.mm.ay.c.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_fmessage_clear_data")) {
            com.tencent.mm.ui.base.g.b(this.context, this.context.getString(2131232017), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ c hVy;

                {
                    this.hVy = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    c cVar = this.hVy;
                    cVar.eut = false;
                    Context context = cVar.context;
                    cVar.context.getString(2131231164);
                    cVar.dwg = com.tencent.mm.ui.base.g.a(context, cVar.context.getString(2131231182), true, new OnCancelListener(cVar) {
                        final /* synthetic */ c hVy;

                        {
                            this.hVy = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.hVy.eut = true;
                        }
                    });
                    aw.a("fmessage", new aw.a(cVar) {
                        final /* synthetic */ c hVy;

                        {
                            this.hVy = r1;
                        }

                        public final boolean zp() {
                            return this.hVy.eut;
                        }

                        public final void zo() {
                            if (this.hVy.dwg != null) {
                                this.hVy.dwg.dismiss();
                                this.hVy.dwg = null;
                            }
                        }
                    });
                    ak.yW();
                    com.tencent.mm.model.c.wK().Mf("fmessage");
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    private void a(boolean z, int i, int i2) {
        v.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        ak.yW();
        com.tencent.mm.model.c.vf().set(7, Integer.valueOf(this.status));
        int i3 = z ? 1 : 2;
        ak.yW();
        com.tencent.mm.model.c.wG().b(new g(i2, i3));
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        Assert.assertTrue(fVar != null);
        if (uVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(m.eH(uVar.field_username));
        this.dxf = fVar;
        this.hTY = z;
        this.euW = uVar;
        if (this.status == -1) {
            this.status = k.xJ();
        }
        fVar.addPreferencesFromResource(2131099668);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.Ow("contact_info_recommend_qqfriends_to_me");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) fVar.Ow("contact_info_recommend_mobilefriends_to_me");
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) fVar.Ow("contact_info_recommend_fbfriends_to_me");
        checkBoxPreference2.ocf = !op(256);
        if (op(128)) {
            z3 = false;
        } else {
            z3 = true;
        }
        checkBoxPreference.ocf = z3;
        if ((k.xL() & 4) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        checkBoxPreference3.ocf = z3;
        ((HelperHeaderPreference) fVar.Ow("contact_info_header_helper")).a(uVar, this.hVx);
        ak.yW();
        if (be.f((Integer) com.tencent.mm.model.c.vf().get(9, null)) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            fVar.b(fVar.Ow("contact_info_bind_qq_entry"));
            fVar.b(fVar.Ow("contact_info_bind_qq_entry_tip"));
        } else {
            fVar.b(checkBoxPreference);
            if (!b.Hb()) {
                fVar.b(fVar.Ow("contact_info_bind_qq_entry"));
                fVar.b(fVar.Ow("contact_info_bind_qq_entry_tip"));
            }
        }
        if (com.tencent.mm.modelfriend.m.EY() == com.tencent.mm.modelfriend.m.a.cHR) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            fVar.b(fVar.Ow("contact_info_bind_mobile_entry"));
            fVar.b(fVar.Ow("contact_info_bind_mobile_entry_tip"));
        } else {
            fVar.b(checkBoxPreference2);
            fVar.Ow("contact_info_bind_mobile_entry").setSummary(2131234985);
        }
        if ((k.xQ() & 8192) == 0) {
            z4 = true;
        }
        if (z4) {
            z2 = k.yh();
            fVar.b(checkBoxPreference3);
            if (z2) {
                fVar.Ow("contact_info_bind_fb_entry").setSummary(2131232030);
            } else {
                fVar.Ow("contact_info_bind_fb_entry").setSummary(2131234985);
            }
        } else {
            fVar.b(fVar.Ow("contact_info_bind_fb_entry"));
            fVar.b(fVar.Ow("contact_info_bind_fb_entry_tip"));
            fVar.b(checkBoxPreference3);
        }
        return true;
    }

    private boolean op(int i) {
        return (this.status & i) != 0;
    }

    public final boolean XS() {
        com.tencent.mm.plugin.profile.a.drq.ow();
        this.dxf.Ow("contact_info_header_helper");
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
