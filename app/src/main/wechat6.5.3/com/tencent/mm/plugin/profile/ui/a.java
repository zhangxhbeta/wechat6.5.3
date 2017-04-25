package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.e.a.cc;
import com.tencent.mm.e.a.cf;
import com.tencent.mm.e.a.lf;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.k;
import com.tencent.mm.modelbiz.q;
import com.tencent.mm.modelbiz.t;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.protocal.c.ail;
import com.tencent.mm.protocal.c.atr;
import com.tencent.mm.protocal.c.ats;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.bit;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class a implements com.tencent.mm.modelbiz.g.a, k, com.tencent.mm.pluginsdk.c.a, e {
    MMActivity aWn;
    private boolean cBA;
    private String cBC;
    private List<com.tencent.mm.modelbiz.BizInfo.a> cBs;
    private ExtInfo cBt;
    private SharedPreferences cnm;
    p dwg;
    f dxf;
    private boolean eJx;
    private CheckBoxPreference ePj;
    u euW;
    boolean eut;
    BizInfo exj;
    private boolean hTY;
    private int hUa;
    String hUb;
    private String hUf;
    private j hVf;
    private List<WxaEntryInfo> hVg;
    private mc hVh;
    private boolean hVi;
    private boolean hVj;
    boolean hVk;
    private int hVl;
    private String hVm;
    private boolean hVn;
    h hVo;
    private Bundle hVp;
    SnsAdClick hVq;

    private static class a extends BitmapDrawable implements com.tencent.mm.platformtools.j.a {
        private String url;

        public a(Resources resources, String str) {
            boolean z = true;
            Bitmap c = com.tencent.mm.model.ab.a.csb != null ? b.c(com.tencent.mm.model.ab.a.csb.eI(16), 2.0f) : null;
            String str2 = "MicroMsg.ContactWidgetBizInfo";
            String str3 = "verify bmp is null ? %B";
            Object[] objArr = new Object[1];
            if (c != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.i(str2, str3, objArr);
            super(resources, c);
            this.url = str;
            com.tencent.mm.platformtools.j.a(this);
        }

        public final void draw(Canvas canvas) {
            Bitmap a = com.tencent.mm.platformtools.j.a(new i(this) {
                final /* synthetic */ a hVw;

                {
                    this.hVw = r1;
                }

                public final boolean MZ() {
                    return false;
                }

                public final boolean MY() {
                    return false;
                }

                public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar) {
                    if (com.tencent.mm.platformtools.i.a.doT == aVar) {
                        try {
                            d.a(bitmap, 100, CompressFormat.PNG, MU(), false);
                        } catch (Throwable e) {
                            v.a("MicroMsg.ContactWidgetBizInfo", e, "", new Object[0]);
                            v.w("MicroMsg.ContactWidgetBizInfo", "save bitmap fail");
                        }
                    }
                    v.d("MicroMsg.ContactWidgetBizInfo", "get bitmap, from %s", new Object[]{aVar.toString()});
                    return bitmap;
                }

                public final void Nb() {
                }

                public final void H(String str, boolean z) {
                }

                public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
                }

                public final String MU() {
                    StringBuilder stringBuilder = new StringBuilder();
                    ak.yW();
                    return stringBuilder.append(c.xe()).append(z.Kg(this.hVw.url)).toString();
                }

                public final String MW() {
                    return this.hVw.url;
                }

                public final Bitmap Na() {
                    return null;
                }

                public final String MV() {
                    return this.hVw.url;
                }

                public final String MX() {
                    return this.hVw.url;
                }
            });
            if (a == null || a.isRecycled()) {
                a = null;
            }
            Rect bounds = getBounds();
            if (a != null) {
                canvas.drawBitmap(a, null, bounds, null);
            }
        }

        public final void k(String str, Bitmap bitmap) {
            if (this.url.equals(str)) {
                invalidateSelf();
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(aVar.aWn, com.tencent.mm.ui.widget.f.pbS, false);
        fVar.jXn = new n.c(aVar) {
            final /* synthetic */ a hVr;

            {
                this.hVr = r1;
            }

            public final void a(l lVar) {
                if (this.hVr.exj != null && this.hVr.exj.Cz()) {
                    lVar.dg(1, 2131232155);
                    lVar.dg(3, 2131231490);
                    lVar.dg(4, 2131232011);
                    lVar.dg(5, 2131231995);
                } else if (this.hVr.exj == null || !this.hVr.exj.CA()) {
                    lVar.dg(1, 2131232155);
                    lVar.dg(2, 2131232005);
                    if (!this.hVr.xQ(this.hVr.euW.field_username)) {
                        lVar.dg(3, 2131231490);
                        lVar.dg(4, 2131232011);
                    }
                    lVar.dg(5, 2131231995);
                } else {
                    lVar.dg(5, 2131231995);
                }
            }
        };
        fVar.jXo = new n.d(aVar) {
            final /* synthetic */ a hVr;

            {
                this.hVr = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                a aVar;
                switch (menuItem.getItemId()) {
                    case 1:
                        aVar = this.hVr;
                        Intent intent = new Intent();
                        intent.putExtra("Select_Talker_Name", aVar.euW.field_username);
                        intent.putExtra("Select_block_List", aVar.euW.field_username);
                        intent.putExtra("Select_Send_Card", true);
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("mutil_select_is_ret", true);
                        com.tencent.mm.plugin.profile.a.drp.a(intent, aVar.aWn);
                        return;
                    case 2:
                        this.hVr.aWn.getString(2131232871, new Object[]{this.hVr.euW.tU()});
                        g.b(this.hVr.aWn, this.hVr.aWn.getString(2131232006), "", this.hVr.aWn.getString(2131232005), this.hVr.aWn.getString(2131231010), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass2 hVs;

                            {
                                this.hVs = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                a aVar = this.hVs.hVr;
                                String str = aVar.euW.field_username;
                                ak.yW();
                                at MH = c.wJ().MH(str);
                                ak.yW();
                                c.wG().b(new com.tencent.mm.ak.d(str, MH.field_msgSvrId));
                                aVar.eut = false;
                                MMActivity mMActivity = aVar.aWn;
                                aVar.aWn.getString(2131231164);
                                aVar.dwg = g.a(mMActivity, aVar.aWn.getString(2131231182), true, new OnCancelListener(aVar) {
                                    final /* synthetic */ a hVr;

                                    {
                                        this.hVr = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        this.hVr.eut = true;
                                    }
                                });
                                aw.a(str, new com.tencent.mm.model.aw.a(aVar) {
                                    final /* synthetic */ a hVr;

                                    {
                                        this.hVr = r1;
                                    }

                                    public final boolean zp() {
                                        return this.hVr.eut;
                                    }

                                    public final void zo() {
                                        if (this.hVr.dwg != null) {
                                            this.hVr.dwg.dismiss();
                                            this.hVr.dwg = null;
                                        }
                                    }
                                });
                            }
                        }, null);
                        return;
                    case 3:
                        this.hVr.aGI();
                        return;
                    case 4:
                        a aVar2 = this.hVr;
                        com.tencent.mm.plugin.profile.a.drq.a(aVar2.exj, aVar2.aWn, aVar2.euW, true, new Runnable(aVar2) {
                            final /* synthetic */ a hVr;

                            {
                                this.hVr = r1;
                            }

                            public final void run() {
                                this.hVr.V(4, null);
                                if (this.hVr.aWn.getIntent().getIntExtra("Kdel_from", -1) == 1) {
                                    Intent intent = new Intent();
                                    intent.addFlags(67108864);
                                    com.tencent.mm.ay.c.b(this.hVr.aWn, "shake", ".ui.ShakeReportUI", intent);
                                }
                            }
                        });
                        return;
                    case 5:
                        aVar = this.hVr;
                        v.d("MicroMsg.ContactWidgetBizInfo", "dealAddShortcut, username = " + aVar.euW.field_username);
                        com.tencent.mm.plugin.base.a.c.I(aVar.aWn, aVar.euW.field_username);
                        ad.g(new Runnable(aVar) {
                            final /* synthetic */ a hVr;

                            {
                                this.hVr = r1;
                            }

                            public final void run() {
                                com.tencent.mm.plugin.base.a.c.H(this.hVr.aWn, this.hVr.euW.field_username);
                            }
                        }, 1000);
                        g.bf(aVar.aWn, aVar.aWn.getString(2131230902));
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
    }

    private a(MMActivity mMActivity) {
        this.hVh = null;
        this.hVi = false;
        this.hVj = false;
        this.cBA = false;
        this.hVk = false;
        this.hVl = 0;
        this.hVo = null;
        this.cnm = null;
        this.hVq = null;
        this.dwg = null;
        this.eut = false;
        this.aWn = mMActivity;
    }

    public a(MMActivity mMActivity, String str, mc mcVar) {
        this(mMActivity);
        this.hUf = str;
        this.hVh = mcVar;
    }

    public final boolean pz(String str) {
        int i = 4;
        if (str == null) {
            return false;
        }
        String str2;
        String str3;
        if (str.equals("contact_info_verifyuser_weibo")) {
            com.tencent.mm.plugin.profile.ui.a.a aVar = new com.tencent.mm.plugin.profile.ui.a.a(this.aWn);
            str2 = this.euW.bCo;
            str3 = this.euW.field_username;
            if (str2 == null) {
                v.e("MicroMsg.ViewTWeibo", "null weibo id");
                return true;
            }
            ak.vy().a(205, aVar);
            aVar.hXC = new com.tencent.mm.plugin.profile.a.a(be.ma(str2).replace("http://t.qq.com/", "").trim(), str3);
            ak.vy().a(aVar.hXC, 0);
            aVar.hXD.ea(3000);
            return true;
        } else if ("contact_info_biz_go_chatting".endsWith(str)) {
            if (this.hVq != null) {
                lf lfVar = new lf();
                this.hVq.cZy = 5;
                lfVar.bmA.bmB = this.hVq;
                com.tencent.mm.sdk.c.a.nhr.z(lfVar);
            }
            if (this.exj == null || !(this.exj.Cz() || this.exj.CB())) {
                r0 = new Intent();
                r0.addFlags(67108864);
                if (this.hTY) {
                    r0.putExtra("Chat_User", this.euW.field_username);
                    r0.putExtra("Chat_Mode", 1);
                    this.aWn.setResult(-1, r0);
                } else {
                    r0.putExtra("Chat_User", this.euW.field_username);
                    r0.putExtra("Chat_Mode", 1);
                    r0.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.profile.a.drp.e(r0, this.aWn);
                }
            } else {
                r0 = new Intent();
                if (this.exj.CB()) {
                    str2 = this.exj.CF();
                    if (be.kS(str2)) {
                        v.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
                        return false;
                    }
                    r0.putExtra("enterprise_biz_name", str2);
                    r0.putExtra("enterprise_biz_display_name", com.tencent.mm.model.l.er(str2));
                } else {
                    r0.putExtra("enterprise_biz_name", this.euW.field_username);
                    r0.putExtra("enterprise_biz_display_name", com.tencent.mm.model.l.er(this.euW.field_username));
                }
                r0.addFlags(67108864);
                com.tencent.mm.ay.c.a(this.aWn, ".ui.conversation.EnterpriseConversationUI", r0);
                this.aWn.finish();
            }
            V(5, null);
            return true;
        } else if ("contact_info_biz_add".endsWith(str)) {
            if (this.aWn.getIntent() != null && this.aWn.getIntent().getBooleanExtra("KIsHardDevice", false)) {
                r0 = this.aWn.getIntent().getStringExtra("KHardDeviceBindTicket");
                if (be.kS(r0)) {
                    v.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
                } else if (!aGH()) {
                    v.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[]{r0});
                    ak.vy().a(536, this);
                    cc ccVar = new cc();
                    ccVar.aZF.aZH = r0;
                    ccVar.aZF.opType = 1;
                    com.tencent.mm.sdk.c.a.nhr.z(ccVar);
                    final com.tencent.mm.v.k kVar = ccVar.aZG.aZJ;
                    r1 = this.aWn;
                    this.aWn.getString(2131231164);
                    this.dwg = g.a(r1, this.aWn.getString(2131231182), true, new OnCancelListener(this) {
                        final /* synthetic */ a hVr;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().b(536, this.hVr);
                            cc ccVar = new cc();
                            ccVar.aZF.opType = 2;
                            ccVar.aZF.aZJ = kVar;
                            com.tencent.mm.sdk.c.a.nhr.z(ccVar);
                        }
                    });
                    if (this.hVl != 0) {
                        return true;
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(11263, new Object[]{Integer.valueOf(this.hVl), this.euW.field_username});
                    return true;
                }
            }
            com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.aWn, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                final /* synthetic */ a hVr;

                {
                    this.hVr = r1;
                }

                public final void a(boolean z, boolean z2, String str, String str2) {
                    if (z) {
                        BizInfo hw;
                        g.bf(this.hVr.aWn, this.hVr.aWn.getString(2131232003));
                        this.hVr.dxf.aO("contact_info_time_expired", true);
                        u uVar = this.hVr.euW;
                        if (uVar == null || be.kS(str)) {
                            v.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + str + ", contact = " + uVar);
                        } else {
                            if (m.eB(uVar.field_username)) {
                                String ma = be.ma(uVar.field_username);
                                hw = com.tencent.mm.modelbiz.e.hw(ma);
                                if (hw != null) {
                                    hw.field_username = str;
                                }
                                com.tencent.mm.modelbiz.u.Dy().hp(ma);
                                uVar.bY(ma);
                            } else {
                                hw = null;
                            }
                            uVar.setUsername(str);
                            if (((int) uVar.chr) == 0) {
                                ak.yW();
                                c.wH().O(uVar);
                            }
                            if (((int) uVar.chr) <= 0) {
                                v.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
                            } else {
                                m.n(uVar);
                                ak.yW();
                                uVar = c.wH().LX(uVar.field_username);
                                if (hw != null) {
                                    com.tencent.mm.modelbiz.u.Dy().d(hw);
                                } else {
                                    BizInfo hw2 = com.tencent.mm.modelbiz.e.hw(uVar.field_username);
                                    boolean z3 = uVar.bvm() && com.tencent.mm.modelbiz.a.Cq();
                                    if (hw2 == null || (hw2.Ct() && !z3)) {
                                        v.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
                                        com.tencent.mm.model.ab.a.crZ.I(uVar.field_username, "");
                                        com.tencent.mm.u.b.gC(uVar.field_username);
                                    } else if (uVar.bvp() && !z3) {
                                        v.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[]{Integer.valueOf(uVar.bCr)});
                                        com.tencent.mm.model.ab.a.crZ.I(uVar.field_username, "");
                                        com.tencent.mm.u.b.gC(uVar.field_username);
                                    }
                                }
                            }
                        }
                        this.hVr.hVk = true;
                        if (this.hVr.hVq != null) {
                            lf lfVar = new lf();
                            this.hVr.hVq.cZy = 4;
                            lfVar.bmA.bmB = this.hVr.hVq;
                            com.tencent.mm.sdk.c.a.nhr.z(lfVar);
                        }
                        hw = com.tencent.mm.modelbiz.u.Dy().ho(this.hVr.euW.field_username);
                        hw.field_status = 1;
                        if (!be.kS(hw.field_extInfo) || be.kS(hw.field_username) || this.hVr.exj == null || !hw.field_username.equals(be.ma(this.hVr.exj.field_username))) {
                            com.tencent.mm.modelbiz.u.Dy().e(hw);
                        } else {
                            com.tencent.mm.modelbiz.u.Dy().e(this.hVr.exj);
                        }
                        boolean booleanExtra = this.hVr.aWn.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
                        boolean booleanExtra2 = this.hVr.aWn.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
                        Intent intent;
                        if (hw.Cz()) {
                            intent = new Intent();
                            intent.putExtra("enterprise_biz_name", this.hVr.euW.field_username);
                            intent.putExtra("enterprise_biz_display_name", com.tencent.mm.model.l.er(this.hVr.euW.field_username));
                            intent.putExtra("enterprise_from_scene", 7);
                            intent.addFlags(67108864);
                            com.tencent.mm.ay.c.a(this.hVr.aWn, ".ui.conversation.EnterpriseConversationUI", intent);
                        } else {
                            intent = new Intent();
                            intent.putExtra("Chat_User", this.hVr.euW.field_username);
                            intent.putExtra("key_has_add_contact", true);
                            if (booleanExtra) {
                                intent.setFlags(67108864);
                                intent.putExtra("finish_direct", true);
                            }
                            if (booleanExtra2) {
                                intent.addFlags(335544320);
                                intent.putExtra("finish_direct", false);
                            }
                            com.tencent.mm.plugin.profile.a.drp.e(intent, this.hVr.aWn);
                            if (!booleanExtra) {
                                if (booleanExtra2) {
                                }
                                this.hVr.V(3, null);
                            }
                        }
                        this.hVr.aWn.finish();
                        this.hVr.V(3, null);
                    }
                }
            });
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(this.hUa));
            if (this.cBC != null) {
                aVar2.lJg = this.cBC;
            }
            if (!be.kS(this.hUb)) {
                aVar2.hUb = this.hUb;
            }
            aVar2.lJn = true;
            aVar2.b(this.euW.field_username, linkedList, false);
            if (this.hVl != 0) {
                return true;
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(11263, new Object[]{Integer.valueOf(this.hVl), this.euW.field_username});
            return true;
        } else if ("contact_info_biz_read_msg_online".endsWith(str)) {
            return true;
        } else {
            if (!"contact_info_stick_biz".equals(str)) {
                int i2;
                if (!(!"contact_info_guarantee_info".equals(str) || this.cBt.CQ() == null || be.kS(this.cBt.CQ().cCA))) {
                    r0 = new Intent();
                    r0.putExtra("rawUrl", this.cBt.CQ().cCA);
                    r0.putExtra("useJs", true);
                    r0.putExtra("vertical_scroll", true);
                    r0.putExtra("geta8key_scene", 3);
                    com.tencent.mm.ay.c.b(this.aWn, "webview", ".ui.tools.WebViewUI", r0);
                }
                if (str.startsWith("contact_info_bizinfo_external#")) {
                    i2 = be.getInt(str.replace("contact_info_bizinfo_external#", ""), -1);
                    if (i2 >= 0 && i2 < this.cBs.size()) {
                        com.tencent.mm.modelbiz.BizInfo.a aVar3 = (com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(i2);
                        str2 = aVar3.url;
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("useJs", true);
                        intent.putExtra("vertical_scroll", true);
                        intent.putExtra("geta8key_scene", 3);
                        intent.putExtra("KPublisherId", "brand_profile");
                        if ((this.hVp != null && (this.hUa == 39 || this.hUa == 56 || this.hUa == 35)) || this.hUa == 87 || this.hUa == 89 || this.hUa == 85 || this.hUa == 88) {
                            v.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("KFromBizSearch", true);
                            bundle.putBundle("KBizSearchExtArgs", this.hVp);
                            intent.putExtra("jsapiargs", bundle);
                            i = com.tencent.mm.i.a.ei(this.euW.field_type) ? 7 : 6;
                            int identifier = this.aWn.getResources().getIdentifier(aVar3.cBw, "string", this.aWn.getPackageName());
                            r0 = aVar3.title;
                            if (identifier > 0) {
                                r0 = this.aWn.getString(identifier);
                            }
                            V(i, r0);
                        }
                        com.tencent.mm.ay.c.b(this.aWn, "webview", ".ui.tools.WebViewUI", intent);
                        return true;
                    }
                }
                if ("contact_info_subscribe_bizinfo".endsWith(str) || "contact_info_show_brand".endsWith(str) || "contact_info_locate".endsWith(str)) {
                    final BizInfo bizInfo = this.exj;
                    if (bizInfo == null) {
                        return true;
                    }
                    if ("contact_info_subscribe_bizinfo".endsWith(str)) {
                        if (!bizInfo.Cy()) {
                            if (bizInfo.Cr()) {
                                bizInfo.field_brandFlag |= 1;
                                if (this.cBt == null && bizInfo != null) {
                                    this.cBt = bizInfo.aX(false);
                                }
                                if (this.cBt != null && this.cBt.CJ() && com.tencent.mm.ay.c.EH("brandservice")) {
                                    this.dxf.aO("contact_info_template_recv", false);
                                } else {
                                    this.dxf.aO("contact_info_template_recv", true);
                                }
                            } else {
                                bizInfo.field_brandFlag &= -2;
                                this.dxf.aO("contact_info_template_recv", true);
                            }
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                            Object[] objArr = new Object[4];
                            objArr[0] = bizInfo.field_username;
                            objArr[1] = Integer.valueOf(1);
                            if (bizInfo.Cr()) {
                                i = 3;
                            }
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Integer.valueOf(0);
                            gVar.h(13307, objArr);
                        } else if (bizInfo != null) {
                            if (bizInfo.CB()) {
                                ak.vy().a(1363, this);
                                if (((CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo")).isChecked()) {
                                    i2 = 0;
                                } else {
                                    i2 = 4;
                                }
                                final com.tencent.mm.plugin.profile.a.b bVar = new com.tencent.mm.plugin.profile.a.b(bizInfo.field_username, i2);
                                ak.vy().a(bVar, 0);
                                MMActivity mMActivity = this.aWn;
                                this.aWn.getString(2131231164);
                                this.dwg = g.a(mMActivity, this.aWn.getString(2131231182), true, new OnCancelListener(this) {
                                    final /* synthetic */ a hVr;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(bVar);
                                        ak.vy().b(1363, this.hVr);
                                    }
                                });
                            } else if (bizInfo.Cz()) {
                                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo");
                                com.tencent.mm.modelbiz.u.DF();
                                final t a = com.tencent.mm.modelbiz.c.a(bizInfo.field_username, !checkBoxPreference.isChecked(), this);
                                r1 = this.aWn;
                                this.aWn.getString(2131231164);
                                this.dwg = g.a(r1, this.aWn.getString(2131231182), true, new OnCancelListener(this) {
                                    final /* synthetic */ a hVr;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        com.tencent.mm.modelbiz.u.DF();
                                        com.tencent.mm.modelbiz.c.a(a);
                                    }
                                });
                            }
                        }
                    } else if ("contact_info_show_brand".endsWith(str)) {
                        boolean z;
                        if ((bizInfo.field_brandFlag & 2) == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            bizInfo.field_brandFlag |= 2;
                        } else {
                            bizInfo.field_brandFlag &= -3;
                        }
                    } else if ("contact_info_locate".endsWith(str)) {
                        if (bizInfo.Cs()) {
                            bizInfo.field_brandFlag &= -5;
                        } else {
                            this.hVo = g.a(this.aWn, this.aWn.getString(2131231766, new Object[]{this.euW.tU()}), this.aWn.getString(2131231164), new OnClickListener(this) {
                                final /* synthetic */ a hVr;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    bizInfo.field_hadAlert = 1;
                                    bizInfo.field_brandFlag |= 4;
                                    this.hVr.a(bizInfo, true);
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ a hVr;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    bizInfo.field_hadAlert = 1;
                                    this.hVr.a(bizInfo, false);
                                }
                            });
                        }
                    }
                    if (bizInfo.CB() || bizInfo.Cz()) {
                        return true;
                    }
                    a(bizInfo, false);
                    return true;
                } else if ("contact_info_verifyuser".endsWith(str)) {
                    r0 = this.exj;
                    if (r0 == null) {
                        return true;
                    }
                    ExtInfo aX = r0.aX(false);
                    if (aX == null) {
                        return true;
                    }
                    r0 = null;
                    if (aX.CS() != null && !be.kS(aX.CS().cCv)) {
                        r0 = aX.CS().cCv;
                    } else if (!(aX.CT() == null || be.kS(aX.CT().cCD))) {
                        r0 = aX.CT().cCD;
                    }
                    if (be.kS(r0)) {
                        return true;
                    }
                    r1 = new Intent();
                    r1.putExtra("rawUrl", r0);
                    r1.putExtra("useJs", true);
                    r1.putExtra("vertical_scroll", true);
                    r1.putExtra("geta8key_scene", 3);
                    com.tencent.mm.ay.c.b(this.aWn, "webview", ".ui.tools.WebViewUI", r1);
                    return true;
                } else if ("contact_info_trademark".endsWith(str)) {
                    r0 = this.exj;
                    if (r0 == null || r0.aX(false) == null || be.kS(r0.aX(false).CL())) {
                        return true;
                    }
                    r1 = new Intent();
                    r1.putExtra("rawUrl", r0.aX(false).CL());
                    r1.putExtra("useJs", true);
                    r1.putExtra("vertical_scroll", true);
                    r1.putExtra("geta8key_scene", 3);
                    com.tencent.mm.ay.c.b(this.aWn, "webview", ".ui.tools.WebViewUI", r1);
                    return true;
                } else {
                    if ("contact_is_mute".endsWith(str)) {
                        this.eJx = !this.eJx;
                        if (this.eJx) {
                            m.l(this.euW);
                        } else {
                            m.m(this.euW);
                        }
                        eL(this.eJx);
                    }
                    if ("enterprise_contact_info_enter".equals(str)) {
                        if (this.aWn == null) {
                            v.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
                        } else if (this.exj == null) {
                            v.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
                        } else {
                            r0 = new Intent();
                            r0.putExtra("enterprise_biz_name", this.exj.field_username);
                            r0.addFlags(67108864);
                            com.tencent.mm.ay.c.b(this.aWn, "brandservice", ".ui.EnterpriseBizContactListUI", r0);
                        }
                    }
                    if ("contact_info_biz_disable".equals(str)) {
                        g.b(this.aWn, this.aWn.getString(2131232460), "", this.aWn.getString(2131232459), this.aWn.getString(2131231010), new OnClickListener(this) {
                            final /* synthetic */ a hVr;

                            {
                                this.hVr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.hVr.eK(false);
                            }
                        }, null);
                    }
                    if ("contact_info_biz_enable".equals(str)) {
                        eK(true);
                    }
                    if ("contact_info_template_recv".equals(str)) {
                        r0 = new Intent();
                        r0.putExtra("enterprise_biz_name", this.exj.field_username);
                        com.tencent.mm.ay.c.b(this.aWn, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", r0);
                    }
                    if ("contact_info_service_phone".equals(str)) {
                        Preference Ow = this.dxf.Ow("contact_info_service_phone");
                        if (!(Ow == null || Ow.getSummary() == null || be.kS(Ow.getSummary().toString()))) {
                            str3 = Ow.getSummary().toString();
                            g.a(this.aWn, true, str3, "", this.aWn.getString(2131232024), this.aWn.getString(2131231010), new OnClickListener(this) {
                                final /* synthetic */ a hVr;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent("android.intent.action.DIAL");
                                    intent.setFlags(268435456);
                                    intent.setData(Uri.parse("tel:" + str3));
                                    if (be.m(this.hVr.aWn, intent)) {
                                        this.hVr.aWn.startActivity(intent);
                                    }
                                }
                            }, null);
                        }
                    }
                    if ("contact_info_expose_btn".equals(str)) {
                        aGI();
                    }
                    if (!str.equals("biz_placed_to_the_top")) {
                        return true;
                    }
                    v.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
                    if (this.cnm == null) {
                        this.cnm = this.aWn.getSharedPreferences(this.aWn.getPackageName() + "_preferences", 0);
                    }
                    if (this.euW == null) {
                        return true;
                    }
                    if (this.euW.tP()) {
                        v.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[]{this.euW.field_username});
                        m.m(this.euW.field_username, true);
                        this.cnm.edit().putBoolean("biz_placed_to_the_top", false).commit();
                        return true;
                    }
                    com.tencent.mm.model.f.ec(this.euW.field_username);
                    v.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[]{this.euW.field_username});
                    this.cnm.edit().putBoolean("biz_placed_to_the_top", true).commit();
                    return true;
                }
            } else if (((CheckBoxPreference) this.dxf.Ow("contact_info_stick_biz")).isChecked()) {
                com.tencent.mm.plugin.report.service.g.iuh.h(13307, new Object[]{this.euW.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)});
                com.tencent.mm.model.f.ec(this.euW.field_username);
                return true;
            } else {
                m.m(this.euW.field_username, true);
                com.tencent.mm.plugin.report.service.g.iuh.h(13307, new Object[]{this.euW.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0)});
                return true;
            }
        }
    }

    final void eK(boolean z) {
        final com.tencent.mm.plugin.profile.a.c cVar = new com.tencent.mm.plugin.profile.a.c(this.exj.field_username, !z);
        ak.vy().a(1394, this);
        ak.vy().a(cVar, 0);
        MMActivity mMActivity = this.aWn;
        this.aWn.getString(2131231164);
        this.dwg = g.a(mMActivity, this.aWn.getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ a hVr;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(cVar);
                ak.vy().b(1394, this.hVr);
            }
        });
    }

    final void a(BizInfo bizInfo, boolean z) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("contact_info_locate");
        ail com_tencent_mm_protocal_c_ail = new ail();
        com_tencent_mm_protocal_c_ail.cHq = bizInfo.field_brandFlag;
        com_tencent_mm_protocal_c_ail.gln = this.euW.field_username;
        if (oo(this.hUa)) {
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(58, com_tencent_mm_protocal_c_ail));
        } else {
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(47, com_tencent_mm_protocal_c_ail));
        }
        com.tencent.mm.modelbiz.u.Dy().a(bizInfo, new String[0]);
        checkBoxPreference.ocf = bizInfo.Cr();
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.ocf = bizInfo.Cs();
        }
        if (z) {
            aGF();
        }
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        boolean z2;
        Assert.assertTrue(uVar != null);
        if (be.ma(uVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.dxf = fVar;
        this.euW = uVar;
        this.hTY = z;
        this.hUa = i;
        this.hVl = this.aWn.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.hVq = (SnsAdClick) this.aWn.getIntent().getParcelableExtra("KSnsAdTag");
        this.hVp = this.aWn.getIntent().getBundleExtra("Contact_Ext_Args");
        aGF();
        if (uVar != null) {
            com.tencent.mm.modelbiz.u.DI().a(uVar.field_username, null);
            if (com.tencent.mm.modelbiz.e.hz(uVar.field_username)) {
                String str = uVar.field_username;
                if (com.tencent.mm.modelbiz.e.hC(str)) {
                    com.tencent.mm.modelbiz.u.DE();
                    com.tencent.mm.modelbiz.a.h.a(str, this);
                    str = com.tencent.mm.modelbiz.e.hw(str).CF();
                    if (str != null) {
                        com.tencent.mm.modelbiz.u.DI().a(str, null);
                    }
                } else if (com.tencent.mm.modelbiz.e.hB(str)) {
                    com.tencent.mm.modelbiz.u.DF();
                    com.tencent.mm.modelbiz.c.a(str, this);
                    com.tencent.mm.modelbiz.u.Dy();
                    str = com.tencent.mm.modelbiz.d.hs(str);
                    if (str != null) {
                        com.tencent.mm.modelbiz.u.DI().a(str, null);
                    }
                }
            }
        }
        return true;
    }

    private void aGF() {
        BizInfo bizInfo;
        CheckBoxPreference checkBoxPreference;
        ExtInfo extInfo;
        Preference Ow;
        KeyValuePreference keyValuePreference;
        Bitmap c;
        boolean z;
        Drawable bitmapDrawable;
        String string;
        Bitmap c2;
        CharSequence charSequence;
        IndexOutOfBoundsException e;
        int indexOf;
        com.tencent.mm.modelbiz.h Dx;
        com.tencent.mm.modelbiz.f hG;
        com.tencent.mm.modelbiz.f fVar;
        IconWidgetPreference iconWidgetPreference;
        com.tencent.mm.modelbiz.g Dz;
        CheckBoxPreference checkBoxPreference2;
        String tU;
        int identifier;
        XS();
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099663);
        if (this.hVk) {
            this.dxf.aO("contact_info_time_expired", true);
        }
        BizInfo hw = com.tencent.mm.modelbiz.e.hw(this.euW.field_username);
        this.cBs = null;
        this.cBt = null;
        this.hVg = null;
        if ((hw == null || hw.aX(false) == null) && this.hVh != null) {
            hw = new BizInfo();
            hw.field_username = this.euW.field_username;
            hw.field_brandFlag = this.hVh.cHq;
            hw.field_brandIconURL = this.hVh.cHt;
            hw.field_brandInfo = this.hVh.cHs;
            hw.field_extInfo = this.hVh.cHr;
            bizInfo = hw;
        } else {
            bizInfo = hw;
        }
        if (bizInfo != null && bizInfo.field_brandInfo == null && bizInfo.field_extInfo == null && this.hVh != null) {
            bizInfo.field_username = this.euW.field_username;
            bizInfo.field_brandFlag = this.hVh.cHq;
            bizInfo.field_brandIconURL = this.hVh.cHt;
            bizInfo.field_brandInfo = this.hVh.cHs;
            bizInfo.field_extInfo = this.hVh.cHr;
        }
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.dxf.Ow("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference == null || be.kS(this.euW.field_username)) {
            v.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
            this.dxf.aO("contact_info_header_bizinfo", true);
        } else {
            u uVar = this.euW;
            bizInfoHeaderPreference.hTS = this.hUf;
            bizInfoHeaderPreference.exj = bizInfo;
            bizInfoHeaderPreference.onDetach();
            ak.yW();
            c.wH().a(bizInfoHeaderPreference);
            com.tencent.mm.u.n.AX().d(bizInfoHeaderPreference);
            com.tencent.mm.modelbiz.u.DG().a(bizInfoHeaderPreference);
            bizInfoHeaderPreference.euW = uVar;
            Assert.assertTrue("initView: contact username is null", be.ma(uVar.field_username).length() > 0);
            bizInfoHeaderPreference.NI();
        }
        this.dxf.aO("biz_placed_to_the_top", true);
        this.dxf.aO("contact_info_biz_enable", true);
        this.dxf.aO("contact_info_biz_disable", true);
        this.dxf.aO("contact_info_stick_biz", true);
        if (bizInfo != null) {
            if (bizInfo.CA()) {
                this.dxf.aO("contact_info_biz_add", true);
                this.dxf.aO("contact_info_expose_btn", true);
                this.dxf.aO("contact_is_mute", false);
                this.eJx = this.euW.tM();
                if (bizInfo.CB()) {
                    this.dxf.aO("contact_info_biz_go_chatting", true);
                    this.dxf.aO("contact_info_stick_biz", !com.tencent.mm.i.a.ei(this.euW.field_type));
                    checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_stick_biz");
                    checkBoxPreference.ocf = this.euW.tP();
                    checkBoxPreference.setTitle(2131232457);
                    aGJ();
                } else {
                    this.dxf.aO("contact_info_subscribe_bizinfo", true);
                    this.dxf.aO("contact_info_biz_go_chatting", true);
                    if (bizInfo.Cr()) {
                        this.dxf.aO("contact_info_biz_enable", true);
                        this.dxf.aO("contact_info_biz_disable", false);
                        this.dxf.Ow("contact_info_biz_disable").setTitle(2131232459);
                        this.dxf.aO("contact_is_mute", false);
                        this.dxf.aO("biz_placed_to_the_top", false);
                        this.ePj = (CheckBoxPreference) this.dxf.Ow("biz_placed_to_the_top");
                        this.ePj.setTitle(2131232476);
                        aGJ();
                        if (bizInfo.CC()) {
                            this.dxf.aO("contact_info_locate", true);
                        }
                    } else {
                        this.dxf.aO("contact_info_biz_enable", false);
                        this.dxf.aO("contact_info_biz_disable", true);
                        this.dxf.Ow("contact_info_biz_enable").setTitle(2131232461);
                        this.dxf.aO("contact_is_mute", true);
                        this.dxf.aO("biz_placed_to_the_top", true);
                        this.dxf.aO("contact_info_locate", true);
                    }
                }
                eL(this.eJx);
            } else if (bizInfo.Cz()) {
                this.dxf.aO("contact_info_locate", true);
                this.dxf.aO("contact_info_subscribe_bizinfo", false);
                this.dxf.aO("enterprise_contact_info_enter", false);
                this.dxf.Ow("contact_info_biz_go_chatting").setTitle(2131232462);
                this.dxf.aO("contact_info_stick_biz", !com.tencent.mm.i.a.ei(this.euW.field_type));
                checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_stick_biz");
                checkBoxPreference.ocf = this.euW.tP();
                checkBoxPreference.setTitle(2131232466);
                aGJ();
                this.dxf.aO("contact_is_mute", true);
                this.eJx = this.euW.tM();
                eL(this.eJx);
                this.dxf.Ow("contact_is_mute").setSummary(2131232027);
            } else {
                f fVar2 = this.dxf;
                String str = "contact_info_stick_biz";
                boolean z2 = m.eP(this.euW.field_username) || !com.tencent.mm.i.a.ei(this.euW.field_type);
                fVar2.aO(str, z2);
                ((CheckBoxPreference) this.dxf.Ow("contact_info_stick_biz")).ocf = this.euW.tP();
                this.dxf.aO("contact_is_mute", true);
                this.eJx = false;
            }
            this.exj = bizInfo;
            this.cBs = bizInfo.CG();
            this.cBt = bizInfo.aX(false);
            this.hVg = this.cBt.CH();
            if (this.cBt.CI()) {
                this.dxf.Ow("near_field_service").setSummary(2131236655);
            } else {
                this.dxf.aO("near_field_service", true);
            }
            if (this.cBt.CN() != null) {
                this.hVj = true;
                if (xO(this.cBt.CN())) {
                    this.hVi = true;
                    if (!com.tencent.mm.i.a.ei(this.euW.field_type)) {
                        v.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[]{this.euW.field_username});
                        aGG();
                        if (m.fl(this.euW.field_username) || xQ(this.euW.field_username)) {
                            aGG();
                        }
                    }
                }
                this.dxf.aO("contact_info_time_expired", true);
                aGG();
            } else {
                this.dxf.aO("contact_info_time_expired", true);
            }
            if (this.cBt.CK() != null && this.cBt.CK().length() > 0) {
                this.cBC = this.cBt.CK();
            }
            extInfo = this.cBt;
            if (extInfo.cBx != null) {
                extInfo.cBA = "1".equals(extInfo.cBx.optString("IsShowMember"));
            }
            this.cBA = extInfo.cBA;
            if (be.kS(this.cBt.CY())) {
                this.dxf.aO("contact_info_service_phone", true);
            } else {
                this.dxf.aO("contact_info_service_phone", false);
                Ow = this.dxf.Ow("contact_info_service_phone");
                if (Ow != null) {
                    Ow.setSummary(this.cBt.CY());
                    Ow.eNB = this.aWn.getResources().getColor(2131689819);
                }
            }
        } else {
            this.dxf.aO("contact_info_time_expired", true);
            v.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        }
        if (be.kS(this.euW.bCj)) {
            v.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
            this.dxf.aO("contact_info_user_desc", true);
            if (!this.hVi) {
                this.dxf.aO("contact_info_time_expired", true);
            }
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_user_desc");
            if (keyValuePreference != null) {
                if (be.ma(this.euW.bCj).trim().length() <= 0) {
                    this.dxf.aO("contact_info_user_desc", true);
                } else {
                    keyValuePreference.bDd();
                    keyValuePreference.ocP = false;
                    keyValuePreference.nEc = this.aWn.getString(2131232058);
                    keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, this.euW.bCj));
                    keyValuePreference.jz(false);
                    if (com.tencent.mm.model.ab.a.csb != null) {
                        c = b.c(com.tencent.mm.model.ab.a.csb.eI(this.euW.field_verifyFlag), 2.0f);
                    } else {
                        c = null;
                    }
                    String str2 = "MicroMsg.ContactWidgetBizInfo";
                    String str3 = "verify bmp is null ? %B";
                    Object[] objArr = new Object[1];
                    if (c == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    v.i(str2, str3, objArr);
                    if (c != null) {
                        bitmapDrawable = new BitmapDrawable(this.aWn.getResources(), c);
                    } else {
                        bitmapDrawable = null;
                    }
                    keyValuePreference.ocX = bitmapDrawable;
                    keyValuePreference.ocV = 8;
                }
            }
        }
        if (this.cBt != null && this.cBt.CS() != null) {
            ExtInfo.c CS = this.cBt.CS();
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_verifyuser");
            if (keyValuePreference == null || be.kS(CS.cCt)) {
                this.dxf.aO("contact_info_verifyuser", true);
            } else {
                keyValuePreference.bDd();
                keyValuePreference.ocP = false;
                if (be.kS(CS.cCu)) {
                    switch (CS.cCs) {
                        case 0:
                            string = this.aWn.getResources().getString(2131232201);
                            break;
                        case 1:
                            string = this.aWn.getResources().getString(2131231555);
                            break;
                        case 2:
                            string = this.aWn.getResources().getString(2131231556);
                            break;
                        default:
                            v.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[]{Integer.valueOf(CS.cCs)});
                            string = this.aWn.getResources().getString(2131232058);
                            break;
                    }
                    keyValuePreference.nEc = string;
                } else {
                    keyValuePreference.nEc = CS.cCu;
                }
                if (com.tencent.mm.model.ab.a.csb != null) {
                    c2 = b.c(com.tencent.mm.model.ab.a.csb.eI(this.euW.field_verifyFlag), 2.0f);
                } else {
                    c2 = null;
                }
                if (c2 != null) {
                    bitmapDrawable = new BitmapDrawable(this.aWn.getResources(), c2);
                } else {
                    bitmapDrawable = null;
                }
                str3 = "MicroMsg.ContactWidgetBizInfo";
                String str4 = "verify bmp is null ? %B";
                Object[] objArr2 = new Object[1];
                if (c2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr2[0] = Boolean.valueOf(z);
                v.i(str3, str4, objArr2);
                keyValuePreference.ocX = bitmapDrawable;
                if (CS.cCt != null) {
                    str3 = CS.cCw;
                    CharSequence a = com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, CS.cCt.trim());
                    if (be.kS(str3)) {
                        charSequence = a;
                    } else {
                        try {
                            charSequence = new SpannableString(str3 + " " + a);
                            try {
                                charSequence.setSpan(new ForegroundColorSpan(-36352), 0, str3.length(), 17);
                            } catch (IndexOutOfBoundsException e2) {
                                e = e2;
                                v.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[]{e.getMessage()});
                                keyValuePreference.setSummary(charSequence);
                                if (this.cBt != null) {
                                }
                                v.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                                this.dxf.aO("contact_info_trademark", true);
                                if (this.cBt != null) {
                                }
                                this.dxf.aO("contact_info_privilege", true);
                                indexOf = this.dxf.indexOf("contact_info_category2");
                                if (indexOf >= 0) {
                                }
                                v.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                                if (!this.hVi) {
                                }
                                this.dxf.aO("contact_info_verifyuser_weibo", true);
                                if (this.cBt != null) {
                                }
                                this.dxf.aO("contact_info_reputation", true);
                                this.dxf.aO("contact_info_guarantee_info", true);
                                this.dxf.aO("contact_info_scope_of_business", true);
                                string = this.aWn.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                                v.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.hVn)});
                                if (!this.hVn) {
                                    this.hVm = string;
                                    if (this.cBt != null) {
                                        extInfo = this.cBt;
                                        if (extInfo.cBx != null) {
                                            extInfo.cBV = extInfo.cBx.optInt("FunctionFlag");
                                        }
                                        if ((extInfo.cBV & BizInfo.cBr) > 0) {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        if (be.kS(string)) {
                                            Dx = com.tencent.mm.modelbiz.u.Dx();
                                            hG = Dx.hG(string);
                                            com.tencent.mm.modelbiz.u.Dz().a(this);
                                            com.tencent.mm.modelbiz.u.Dz().R(this.euW.field_username, string);
                                            this.hVn = true;
                                            if (hG == null) {
                                                fVar = hG;
                                            } else {
                                                v.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                                                fVar = Dx.hH(this.euW.field_username);
                                            }
                                            if (fVar == null) {
                                                this.dxf.aO("contact_info_kf_worker", false);
                                                iconWidgetPreference = (IconWidgetPreference) this.dxf.Ow("contact_info_kf_worker");
                                                iconWidgetPreference.setSummary(fVar.field_nickname);
                                                c2 = com.tencent.mm.u.b.a(fVar.field_openId, false, -1);
                                                if (c2 == null) {
                                                    iconWidgetPreference.r(c2);
                                                } else {
                                                    c(fVar);
                                                    xP(fVar.field_openId);
                                                }
                                                v.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{fVar.field_openId, fVar.field_nickname});
                                            } else {
                                                this.dxf.aO("contact_info_kf_worker", true);
                                            }
                                        } else {
                                            fVar = com.tencent.mm.modelbiz.u.Dx().hH(this.euW.field_username);
                                            if (fVar == null) {
                                                v.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{fVar.field_openId});
                                                this.dxf.aO("contact_info_kf_worker", false);
                                                iconWidgetPreference = (IconWidgetPreference) this.dxf.Ow("contact_info_kf_worker");
                                                iconWidgetPreference.setSummary(fVar.field_nickname);
                                                c2 = com.tencent.mm.u.b.a(fVar.field_openId, false, -1);
                                                if (c2 == null) {
                                                    iconWidgetPreference.r(c2);
                                                } else {
                                                    c(fVar);
                                                    xP(fVar.field_openId);
                                                }
                                            } else {
                                                this.dxf.aO("contact_info_kf_worker", true);
                                                com.tencent.mm.modelbiz.u.Dz().a(this);
                                                Dz = com.tencent.mm.modelbiz.u.Dz();
                                                string = this.euW.field_username;
                                                str = com.tencent.mm.model.k.xF();
                                                if (be.kS(string)) {
                                                    ak.vy().a(new q(string, str), 0);
                                                    v.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[]{string, Integer.valueOf(Dz.cCP.size())});
                                                } else {
                                                    v.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                                                }
                                                this.hVn = true;
                                            }
                                        }
                                    }
                                    this.dxf.aO("contact_info_kf_worker", true);
                                }
                                v.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.aWn.getIntent().getBooleanExtra("KIsHardDevice", false))});
                                if (this.aWn.getIntent() == null) {
                                }
                                if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
                                    v.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.euW.field_username});
                                    aGG();
                                    Ow = this.dxf.Ow("contact_info_biz_add");
                                    Ow.setTitle(2131232008);
                                    if (oo(this.hUa)) {
                                        if (bizInfo == null) {
                                            ((CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo")).ocf = bizInfo.Cr();
                                            this.dxf.aO("contact_info_subscribe_bizinfo", false);
                                        } else {
                                            v.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                                        }
                                    }
                                    this.aWn.iU(false);
                                } else {
                                    if (bizInfo != null) {
                                        this.dxf.aO("contact_info_subscribe_bizinfo", true);
                                        this.dxf.aO("contact_info_locate", true);
                                        this.dxf.aO("contact_info_template_recv", true);
                                    } else {
                                        checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo");
                                        checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("contact_info_locate");
                                        if (!bizInfo.CB()) {
                                            checkBoxPreference.setTitle(2131232458);
                                            this.hVf = com.tencent.mm.modelbiz.u.DC().ig(com.tencent.mm.modelbiz.u.DC().ii(bizInfo.field_username));
                                            if (this.hVf != null) {
                                                v.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                                            } else {
                                                if (this.hVf.fe(4)) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                checkBoxPreference.ocf = z;
                                            }
                                        } else if (bizInfo.Cz()) {
                                            checkBoxPreference.ocf = bizInfo.Cr();
                                        } else {
                                            checkBoxPreference.setTitle(2131232454);
                                            checkBoxPreference.ocf = com.tencent.mm.modelbiz.u.DF().he(bizInfo.field_username);
                                        }
                                        if (bizInfo.Cr()) {
                                            this.dxf.aO("contact_info_template_recv", true);
                                        } else {
                                            this.cBt = bizInfo.aX(false);
                                            if (this.cBt == null) {
                                            }
                                            this.dxf.aO("contact_info_template_recv", true);
                                        }
                                        if (bizInfo.aX(false).Cv()) {
                                            this.dxf.aO("contact_info_locate", true);
                                            checkBoxPreference2.ocf = bizInfo.Cs();
                                        } else {
                                            checkBoxPreference2.ocf = bizInfo.Cs();
                                        }
                                    }
                                    this.dxf.aO("contact_info_biz_read_msg_online", true);
                                    this.dxf.aO("contact_info_biz_add", true);
                                    tU = this.euW.tU();
                                    if (tU != null) {
                                        this.aWn.Fd(tU);
                                    }
                                    if (m.eP(this.euW.field_username)) {
                                        this.dxf.Ow("contact_info_biz_go_chatting").setTitle(2131232154);
                                        this.aWn.vD(2131232194);
                                    }
                                    this.aWn.a(0, 2130838681, new OnMenuItemClickListener(this) {
                                        final /* synthetic */ a hVr;

                                        {
                                            this.hVr = r1;
                                        }

                                        public final boolean onMenuItemClick(MenuItem menuItem) {
                                            a.a(this.hVr);
                                            return true;
                                        }
                                    });
                                }
                                if (this.hVg != null) {
                                }
                                this.dxf.aO("contact_info_bindwxainfo", true);
                                return;
                            }
                        } catch (IndexOutOfBoundsException e3) {
                            IndexOutOfBoundsException indexOutOfBoundsException = e3;
                            charSequence = a;
                            e = indexOutOfBoundsException;
                            v.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[]{e.getMessage()});
                            keyValuePreference.setSummary(charSequence);
                            if (this.cBt != null) {
                            }
                            v.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                            this.dxf.aO("contact_info_trademark", true);
                            if (this.cBt != null) {
                            }
                            this.dxf.aO("contact_info_privilege", true);
                            indexOf = this.dxf.indexOf("contact_info_category2");
                            if (indexOf >= 0) {
                            }
                            v.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                            if (this.hVi) {
                            }
                            this.dxf.aO("contact_info_verifyuser_weibo", true);
                            if (this.cBt != null) {
                            }
                            this.dxf.aO("contact_info_reputation", true);
                            this.dxf.aO("contact_info_guarantee_info", true);
                            this.dxf.aO("contact_info_scope_of_business", true);
                            string = this.aWn.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                            v.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.hVn)});
                            if (this.hVn) {
                                this.hVm = string;
                                if (this.cBt != null) {
                                    extInfo = this.cBt;
                                    if (extInfo.cBx != null) {
                                        extInfo.cBV = extInfo.cBx.optInt("FunctionFlag");
                                    }
                                    if ((extInfo.cBV & BizInfo.cBr) > 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (be.kS(string)) {
                                        fVar = com.tencent.mm.modelbiz.u.Dx().hH(this.euW.field_username);
                                        if (fVar == null) {
                                            this.dxf.aO("contact_info_kf_worker", true);
                                            com.tencent.mm.modelbiz.u.Dz().a(this);
                                            Dz = com.tencent.mm.modelbiz.u.Dz();
                                            string = this.euW.field_username;
                                            str = com.tencent.mm.model.k.xF();
                                            if (be.kS(string)) {
                                                v.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                                            } else {
                                                ak.vy().a(new q(string, str), 0);
                                                v.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[]{string, Integer.valueOf(Dz.cCP.size())});
                                            }
                                            this.hVn = true;
                                        } else {
                                            v.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{fVar.field_openId});
                                            this.dxf.aO("contact_info_kf_worker", false);
                                            iconWidgetPreference = (IconWidgetPreference) this.dxf.Ow("contact_info_kf_worker");
                                            iconWidgetPreference.setSummary(fVar.field_nickname);
                                            c2 = com.tencent.mm.u.b.a(fVar.field_openId, false, -1);
                                            if (c2 == null) {
                                                c(fVar);
                                                xP(fVar.field_openId);
                                            } else {
                                                iconWidgetPreference.r(c2);
                                            }
                                        }
                                    } else {
                                        Dx = com.tencent.mm.modelbiz.u.Dx();
                                        hG = Dx.hG(string);
                                        com.tencent.mm.modelbiz.u.Dz().a(this);
                                        com.tencent.mm.modelbiz.u.Dz().R(this.euW.field_username, string);
                                        this.hVn = true;
                                        if (hG == null) {
                                            v.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                                            fVar = Dx.hH(this.euW.field_username);
                                        } else {
                                            fVar = hG;
                                        }
                                        if (fVar == null) {
                                            this.dxf.aO("contact_info_kf_worker", true);
                                        } else {
                                            this.dxf.aO("contact_info_kf_worker", false);
                                            iconWidgetPreference = (IconWidgetPreference) this.dxf.Ow("contact_info_kf_worker");
                                            iconWidgetPreference.setSummary(fVar.field_nickname);
                                            c2 = com.tencent.mm.u.b.a(fVar.field_openId, false, -1);
                                            if (c2 == null) {
                                                c(fVar);
                                                xP(fVar.field_openId);
                                            } else {
                                                iconWidgetPreference.r(c2);
                                            }
                                            v.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{fVar.field_openId, fVar.field_nickname});
                                        }
                                    }
                                }
                                this.dxf.aO("contact_info_kf_worker", true);
                            }
                            v.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.aWn.getIntent().getBooleanExtra("KIsHardDevice", false))});
                            if (this.aWn.getIntent() == null) {
                            }
                            if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
                                if (bizInfo != null) {
                                    checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo");
                                    checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("contact_info_locate");
                                    if (!bizInfo.CB()) {
                                        checkBoxPreference.setTitle(2131232458);
                                        this.hVf = com.tencent.mm.modelbiz.u.DC().ig(com.tencent.mm.modelbiz.u.DC().ii(bizInfo.field_username));
                                        if (this.hVf != null) {
                                            if (this.hVf.fe(4)) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            checkBoxPreference.ocf = z;
                                        } else {
                                            v.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                                        }
                                    } else if (bizInfo.Cz()) {
                                        checkBoxPreference.setTitle(2131232454);
                                        if (com.tencent.mm.modelbiz.u.DF().he(bizInfo.field_username)) {
                                        }
                                        checkBoxPreference.ocf = com.tencent.mm.modelbiz.u.DF().he(bizInfo.field_username);
                                    } else {
                                        checkBoxPreference.ocf = bizInfo.Cr();
                                    }
                                    if (bizInfo.Cr()) {
                                        this.cBt = bizInfo.aX(false);
                                        if (this.cBt == null) {
                                        }
                                        this.dxf.aO("contact_info_template_recv", true);
                                    } else {
                                        this.dxf.aO("contact_info_template_recv", true);
                                    }
                                    if (bizInfo.aX(false).Cv()) {
                                        checkBoxPreference2.ocf = bizInfo.Cs();
                                    } else {
                                        this.dxf.aO("contact_info_locate", true);
                                        checkBoxPreference2.ocf = bizInfo.Cs();
                                    }
                                } else {
                                    this.dxf.aO("contact_info_subscribe_bizinfo", true);
                                    this.dxf.aO("contact_info_locate", true);
                                    this.dxf.aO("contact_info_template_recv", true);
                                }
                                this.dxf.aO("contact_info_biz_read_msg_online", true);
                                this.dxf.aO("contact_info_biz_add", true);
                                tU = this.euW.tU();
                                if (tU != null) {
                                    this.aWn.Fd(tU);
                                }
                                if (m.eP(this.euW.field_username)) {
                                    this.dxf.Ow("contact_info_biz_go_chatting").setTitle(2131232154);
                                    this.aWn.vD(2131232194);
                                }
                                this.aWn.a(0, 2130838681, /* anonymous class already generated */);
                            } else {
                                v.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.euW.field_username});
                                aGG();
                                Ow = this.dxf.Ow("contact_info_biz_add");
                                Ow.setTitle(2131232008);
                                if (oo(this.hUa)) {
                                    if (bizInfo == null) {
                                        v.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                                    } else {
                                        ((CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo")).ocf = bizInfo.Cr();
                                        this.dxf.aO("contact_info_subscribe_bizinfo", false);
                                    }
                                }
                                this.aWn.iU(false);
                            }
                            if (this.hVg != null) {
                            }
                            this.dxf.aO("contact_info_bindwxainfo", true);
                            return;
                        }
                    }
                    keyValuePreference.setSummary(charSequence);
                } else {
                    v.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
                }
            }
        } else if (this.cBt == null || this.cBt.CT() == null || be.kS(this.cBt.CT().cCC)) {
            v.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
            this.dxf.aO("contact_info_verifyuser", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.cBt.CT().cCC);
            }
        }
        if (this.cBt != null || be.kS(this.cBt.CM())) {
            v.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
            this.dxf.aO("contact_info_trademark", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_trademark");
            if (keyValuePreference != null) {
                keyValuePreference.bDd();
                keyValuePreference.ocP = false;
                if (com.tencent.mm.model.ab.a.csb != null) {
                    c = d.uU(2131165307);
                } else {
                    c = null;
                }
                str2 = "MicroMsg.ContactWidgetBizInfo";
                str3 = "trademark bmp is null ? %B";
                objArr = new Object[1];
                if (c == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                v.i(str2, str3, objArr);
                if (c != null) {
                    bitmapDrawable = new BitmapDrawable(this.aWn.getResources(), c);
                } else {
                    bitmapDrawable = null;
                }
                keyValuePreference.ocX = bitmapDrawable;
                keyValuePreference.setSummary(this.cBt.CM());
                v.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[]{this.cBt.CM(), this.cBt.CL()});
            }
        }
        if (this.cBt != null || this.cBt.CO() == null || this.cBt.CO().size() <= 0) {
            this.dxf.aO("contact_info_privilege", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_privilege");
            keyValuePreference.bDd();
            keyValuePreference.jz(false);
            keyValuePreference.ocY.clear();
            for (ExtInfo.e eVar : this.cBt.CO()) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.aWn, 2130903843, null);
                ((ImageView) linearLayout.findViewById(2131756901)).setImageDrawable(new a(this.aWn.getResources(), eVar.iconUrl));
                CharSequence charSequence2 = eVar.description;
                identifier = this.aWn.getResources().getIdentifier(eVar.cCB, "string", this.aWn.getPackageName());
                if (identifier > 0) {
                    charSequence2 = this.aWn.getString(identifier);
                }
                ((TextView) linearLayout.findViewById(2131756108)).setText(charSequence2);
                keyValuePreference.ocY.add(linearLayout);
            }
        }
        indexOf = this.dxf.indexOf("contact_info_category2");
        if (indexOf >= 0 || this.cBs == null || this.cBs.size() <= 0) {
            v.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        } else {
            int size = this.cBs.size() - 1;
            while (size >= 0) {
                if (this.cBs.get(size) != null && ((!this.aWn.getString(2131232010).equals(((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).title) || this.cBA) && !(be.kS(((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).title) && be.kS(((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).cBw)))) {
                    Preference preference = new Preference(this.aWn);
                    preference.setKey("contact_info_bizinfo_external#" + size);
                    charSequence = ((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).title;
                    int identifier2 = this.aWn.getResources().getIdentifier(((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).cBw, "string", this.aWn.getPackageName());
                    if (identifier2 > 0) {
                        charSequence = this.aWn.getString(identifier2);
                    }
                    if (this.exj.Cy() && ("__mp_wording__brandinfo_history_massmsg".equals(((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).cBw) || r1.equals(this.aWn.getString(2131230748)))) {
                        charSequence = this.aWn.getString(2131232453);
                    }
                    preference.setTitle(charSequence);
                    if (!be.kS(((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).description)) {
                        preference.setSummary(((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).description);
                    }
                    if (be.ma(((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).cBw).equals("__mp_wording__brandinfo_feedback")) {
                        identifier2 = this.dxf.indexOf("contact_info_scope_of_business");
                        if (identifier2 > 0) {
                            identifier = identifier2 + 1;
                            this.dxf.a(preference, identifier);
                            if (be.ma(((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).cBw).equals("__mp_wording__brandinfo_biz_detail")) {
                                this.dxf.a(new PreferenceSmallCategory(this.aWn), identifier);
                            }
                        }
                    }
                    identifier = indexOf;
                    this.dxf.a(preference, identifier);
                    if (be.ma(((com.tencent.mm.modelbiz.BizInfo.a) this.cBs.get(size)).cBw).equals("__mp_wording__brandinfo_biz_detail")) {
                        this.dxf.a(new PreferenceSmallCategory(this.aWn), identifier);
                    }
                }
                size--;
            }
        }
        if (this.hVi || !m.t(this.euW) || this.euW.bCo == null || this.euW.bCo.equals("")) {
            this.dxf.aO("contact_info_verifyuser_weibo", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_verifyuser_weibo");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(be.ah(this.euW.field_weiboNickname, "") + this.aWn.getString(2131235142, new Object[]{m.fu(this.euW.bCo)}));
                keyValuePreference.eNB = com.tencent.mm.bd.a.b(this.aWn, 2131689819);
                keyValuePreference.jz(false);
            }
        }
        if (this.cBt != null || this.cBt.CQ() == null) {
            this.dxf.aO("contact_info_reputation", true);
            this.dxf.aO("contact_info_guarantee_info", true);
            this.dxf.aO("contact_info_scope_of_business", true);
        } else {
            BizInfoPayInfoIconPreference bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.dxf.Ow("contact_info_reputation");
            if (this.cBt.CQ().cCx > 0) {
                bizInfoPayInfoIconPreference.oh(this.cBt.CQ().cCx);
            } else {
                this.dxf.aO("contact_info_reputation", true);
            }
            bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.dxf.Ow("contact_info_guarantee_info");
            if (this.cBt.CQ().cCz == null || this.cBt.CQ().cCz.size() <= 0) {
                this.dxf.aO("contact_info_guarantee_info", true);
            } else {
                bizInfoPayInfoIconPreference.aX(this.cBt.CQ().cCz);
            }
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_scope_of_business");
            if (be.kS(this.cBt.CQ().cCy)) {
                this.dxf.aO("contact_info_scope_of_business", true);
            } else {
                keyValuePreference.setSummary(this.cBt.CQ().cCy);
                keyValuePreference.ocV = 4;
                keyValuePreference.jz(false);
            }
        }
        string = this.aWn.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        v.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.hVn)});
        if (this.hVn) {
            this.hVm = string;
            if (this.cBt != null) {
                extInfo = this.cBt;
                if (extInfo.cBx != null) {
                    extInfo.cBV = extInfo.cBx.optInt("FunctionFlag");
                }
                if ((extInfo.cBV & BizInfo.cBr) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && this.euW != null) {
                    if (be.kS(string)) {
                        fVar = com.tencent.mm.modelbiz.u.Dx().hH(this.euW.field_username);
                        if (fVar == null) {
                            this.dxf.aO("contact_info_kf_worker", true);
                            com.tencent.mm.modelbiz.u.Dz().a(this);
                            Dz = com.tencent.mm.modelbiz.u.Dz();
                            string = this.euW.field_username;
                            str = com.tencent.mm.model.k.xF();
                            if (be.kS(string)) {
                                v.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                            } else {
                                ak.vy().a(new q(string, str), 0);
                                v.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[]{string, Integer.valueOf(Dz.cCP.size())});
                            }
                            this.hVn = true;
                        } else {
                            v.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{fVar.field_openId});
                            this.dxf.aO("contact_info_kf_worker", false);
                            iconWidgetPreference = (IconWidgetPreference) this.dxf.Ow("contact_info_kf_worker");
                            iconWidgetPreference.setSummary(fVar.field_nickname);
                            c2 = com.tencent.mm.u.b.a(fVar.field_openId, false, -1);
                            if (c2 == null) {
                                c(fVar);
                                xP(fVar.field_openId);
                            } else {
                                iconWidgetPreference.r(c2);
                            }
                        }
                    } else {
                        Dx = com.tencent.mm.modelbiz.u.Dx();
                        hG = Dx.hG(string);
                        if (hG == null || com.tencent.mm.modelbiz.h.a(hG)) {
                            com.tencent.mm.modelbiz.u.Dz().a(this);
                            com.tencent.mm.modelbiz.u.Dz().R(this.euW.field_username, string);
                            this.hVn = true;
                        }
                        if (hG == null) {
                            v.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                            fVar = Dx.hH(this.euW.field_username);
                        } else {
                            fVar = hG;
                        }
                        if (fVar == null) {
                            this.dxf.aO("contact_info_kf_worker", true);
                        } else {
                            this.dxf.aO("contact_info_kf_worker", false);
                            iconWidgetPreference = (IconWidgetPreference) this.dxf.Ow("contact_info_kf_worker");
                            iconWidgetPreference.setSummary(fVar.field_nickname);
                            c2 = com.tencent.mm.u.b.a(fVar.field_openId, false, -1);
                            if (c2 == null) {
                                c(fVar);
                                xP(fVar.field_openId);
                            } else {
                                iconWidgetPreference.r(c2);
                            }
                            v.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{fVar.field_openId, fVar.field_nickname});
                        }
                    }
                }
            }
            this.dxf.aO("contact_info_kf_worker", true);
        }
        v.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.aWn.getIntent().getBooleanExtra("KIsHardDevice", false))});
        if (this.aWn.getIntent() == null && this.aWn.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            v.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
            z2 = aGH();
            v.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[]{Boolean.valueOf(com.tencent.mm.i.a.ei(this.euW.field_type)), Boolean.valueOf(z2)});
            if (com.tencent.mm.i.a.ei(this.euW.field_type) && z2) {
                if (bizInfo != null) {
                    checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo");
                    checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("contact_info_locate");
                    if (bizInfo.CB()) {
                        this.hVf = com.tencent.mm.modelbiz.u.DC().ig(com.tencent.mm.modelbiz.u.DC().ii(bizInfo.field_username));
                        if (this.hVf != null) {
                            checkBoxPreference.ocf = !this.hVf.fe(4);
                        } else {
                            v.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                        }
                    } else {
                        checkBoxPreference.ocf = bizInfo.Cr();
                    }
                    if (bizInfo.Cr()) {
                        if (this.cBt == null && bizInfo != null) {
                            this.cBt = bizInfo.aX(false);
                        }
                        if (this.cBt != null && this.cBt.CJ() && com.tencent.mm.ay.c.EH("brandservice")) {
                            this.dxf.aO("contact_info_template_recv", false);
                        } else {
                            this.dxf.aO("contact_info_template_recv", true);
                        }
                    } else {
                        this.dxf.aO("contact_info_template_recv", true);
                    }
                    if (bizInfo.aX(false).Cv()) {
                        checkBoxPreference2.ocf = bizInfo.Cs();
                    } else {
                        this.dxf.aO("contact_info_locate", true);
                        checkBoxPreference2.ocf = bizInfo.Cs();
                    }
                } else {
                    this.dxf.aO("contact_info_subscribe_bizinfo", true);
                    this.dxf.aO("contact_info_locate", true);
                    this.dxf.aO("contact_info_template_recv", true);
                }
                this.dxf.aO("contact_info_biz_read_msg_online", true);
                this.dxf.aO("contact_info_biz_add", true);
                tU = this.euW.tU();
                if (tU != null) {
                    this.aWn.Fd(tU);
                }
                if (m.eP(this.euW.field_username)) {
                    this.dxf.Ow("contact_info_biz_go_chatting").setTitle(2131232154);
                    this.aWn.vD(2131232194);
                }
                if (!m.fl(this.euW.field_username) && this.exj != null && !this.exj.CA()) {
                    this.aWn.a(0, 2130838681, new OnMenuItemClickListener(this) {
                        final /* synthetic */ a hVr;

                        {
                            this.hVr = r1;
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            a.a(this.hVr);
                            return true;
                        }
                    });
                    return;
                }
                return;
            }
            v.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[]{this.euW.field_username});
            aGG();
            Preference Ow2 = this.dxf.Ow("contact_info_biz_add");
            v.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[]{Boolean.valueOf(this.hVj)});
            if (Ow2 != null) {
                if (z2) {
                    Ow2.setTitle(2131232008);
                } else {
                    Ow2.setTitle(2131232004);
                }
            }
            if (oo(this.hUa)) {
                if (bizInfo == null) {
                    v.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo")).ocf = bizInfo.Cr();
                    this.dxf.aO("contact_info_subscribe_bizinfo", false);
                }
            }
            this.aWn.iU(false);
            return;
        }
        if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
            if (bizInfo != null) {
                checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo");
                checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("contact_info_locate");
                if (!bizInfo.CB()) {
                    checkBoxPreference.setTitle(2131232458);
                    this.hVf = com.tencent.mm.modelbiz.u.DC().ig(com.tencent.mm.modelbiz.u.DC().ii(bizInfo.field_username));
                    if (this.hVf != null) {
                        if (this.hVf.fe(4)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        checkBoxPreference.ocf = z;
                    } else {
                        v.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                    }
                } else if (bizInfo.Cz()) {
                    checkBoxPreference.setTitle(2131232454);
                    if (com.tencent.mm.modelbiz.u.DF().he(bizInfo.field_username)) {
                    }
                    checkBoxPreference.ocf = com.tencent.mm.modelbiz.u.DF().he(bizInfo.field_username);
                } else {
                    checkBoxPreference.ocf = bizInfo.Cr();
                }
                if (bizInfo.Cr()) {
                    if (this.cBt == null && bizInfo != null) {
                        this.cBt = bizInfo.aX(false);
                    }
                    if (this.cBt == null && this.cBt.CJ() && com.tencent.mm.ay.c.EH("brandservice")) {
                        this.dxf.aO("contact_info_template_recv", false);
                    } else {
                        this.dxf.aO("contact_info_template_recv", true);
                    }
                } else {
                    this.dxf.aO("contact_info_template_recv", true);
                }
                if (bizInfo.aX(false).Cv()) {
                    checkBoxPreference2.ocf = bizInfo.Cs();
                } else {
                    this.dxf.aO("contact_info_locate", true);
                    checkBoxPreference2.ocf = bizInfo.Cs();
                }
            } else {
                this.dxf.aO("contact_info_subscribe_bizinfo", true);
                this.dxf.aO("contact_info_locate", true);
                this.dxf.aO("contact_info_template_recv", true);
            }
            this.dxf.aO("contact_info_biz_read_msg_online", true);
            this.dxf.aO("contact_info_biz_add", true);
            tU = this.euW.tU();
            if (tU != null) {
                this.aWn.Fd(tU);
            }
            if (m.eP(this.euW.field_username)) {
                this.dxf.Ow("contact_info_biz_go_chatting").setTitle(2131232154);
                this.aWn.vD(2131232194);
            }
            if (!(m.fl(this.euW.field_username) || this.exj == null)) {
                this.aWn.a(0, 2130838681, /* anonymous class already generated */);
            }
        } else {
            v.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.euW.field_username});
            aGG();
            Ow = this.dxf.Ow("contact_info_biz_add");
            if (Ow != null && this.hVj) {
                Ow.setTitle(2131232008);
            }
            if (oo(this.hUa)) {
                if (bizInfo == null) {
                    v.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo")).ocf = bizInfo.Cr();
                    this.dxf.aO("contact_info_subscribe_bizinfo", false);
                }
            }
            this.aWn.iU(false);
        }
        if (this.hVg != null || this.hVg.size() <= 0) {
            this.dxf.aO("contact_info_bindwxainfo", true);
            return;
        }
        this.dxf.aO("contact_info_bindwxainfo", false);
        BizBindWxaInfoPreference bizBindWxaInfoPreference = (BizBindWxaInfoPreference) this.dxf.Ow("contact_info_bindwxainfo");
        Collection collection = this.hVg;
        bizBindWxaInfoPreference.hTz = true;
        if (bizBindWxaInfoPreference.hTA == null) {
            bizBindWxaInfoPreference.hTA = new LinkedList();
        } else {
            bizBindWxaInfoPreference.hTA.clear();
        }
        if (!(collection == null || collection.isEmpty())) {
            bizBindWxaInfoPreference.hTA.addAll(collection);
        }
        bizBindWxaInfoPreference.aGB();
    }

    private void aGG() {
        if (this.euW == null || !com.tencent.mm.i.a.ei(this.euW.field_type) || m.eP(this.euW.field_username) || xQ(this.euW.field_username)) {
            this.dxf.aO("contact_is_mute", true);
            if (this.euW == null || com.tencent.mm.i.a.ei(this.euW.field_type) || !oo(this.hUa)) {
                this.dxf.aO("contact_info_expose_btn", true);
            } else {
                this.dxf.aO("contact_info_expose_btn", false);
            }
        } else {
            this.dxf.aO("contact_is_mute", false);
        }
        this.dxf.aO("contact_info_verifyuser_weibo", true);
        this.dxf.aO("contact_info_subscribe_bizinfo", true);
        this.dxf.aO("contact_info_template_recv", true);
        this.dxf.aO("contact_info_locate", true);
        if (this.hVi) {
            this.dxf.aO("contact_info_biz_add", true);
        } else {
            this.dxf.aO("contact_info_time_expired", true);
        }
        if (this.euW == null || !((m.fl(this.euW.field_username) || xQ(this.euW.field_username)) && com.tencent.mm.i.a.ei(this.euW.field_type))) {
            this.dxf.aO("contact_info_biz_go_chatting", true);
        } else {
            this.dxf.aO("contact_info_biz_go_chatting", false);
        }
        if (xQ(this.euW.field_username)) {
            this.dxf.aO("contact_info_user_desc", true);
        } else {
            this.dxf.aO("contact_info_user_desc", false);
        }
    }

    public final boolean XS() {
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.dxf.Ow("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference != null) {
            bizInfoHeaderPreference.onDetach();
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (this.aWn == null) {
            v.e("MicroMsg.ContactWidgetBizInfo", "null == context");
            return;
        }
        v.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.pluginsdk.j.a.bmt().m(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.pluginsdk.j.a.bmt().df(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.f(this.aWn, this.aWn.getString(2131232839));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static boolean xO(String str) {
        try {
            long j = be.getLong(str, 0);
            if (j <= 0 || j - (System.currentTimeMillis() / 1000) >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    final void V(int i, String str) {
        if (this.hVp == null || !(this.hUa == 39 || this.hUa == 56 || this.hUa == 35 || this.hUa == 87 || this.hUa == 88 || this.hUa == 89 || this.hUa == 85)) {
            v.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
        } else if (this.euW == null) {
            v.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
        } else {
            int i2;
            String string = this.hVp.getString("Contact_Ext_Args_Search_Id");
            String ma = be.ma(this.hVp.getString("Contact_Ext_Args_Query_String"));
            int i3 = this.hVp.getInt("Contact_Ext_Args_Index");
            switch (this.hUa) {
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    i2 = 1;
                    break;
                case bw.CTRL_INDEX /*85*/:
                    i2 = 5;
                    break;
                case 87:
                    i2 = 2;
                    break;
                case 88:
                    i2 = 3;
                    break;
                case 89:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String ma2 = be.ma(this.hVp.getString("Contact_Ext_Extra_Params"));
            String str2 = ma + "," + i + "," + be.ma(this.euW.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (be.kS(str)) {
                str2 = str2 + ",," + ma2;
            } else {
                str2 = str2 + "," + str + "," + ma2;
            }
            v.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[]{str2});
            com.tencent.mm.plugin.report.service.g.iuh.Y(10866, str2);
        }
    }

    private boolean aGH() {
        if (this.aWn.getIntent() == null) {
            return false;
        }
        String stringExtra = this.aWn.getIntent().getStringExtra("device_id");
        String stringExtra2 = this.aWn.getIntent().getStringExtra("device_type");
        cf cfVar = new cf();
        cfVar.aZP.aRh = stringExtra;
        cfVar.aZP.aZN = stringExtra2;
        com.tencent.mm.sdk.c.a.nhr.z(cfVar);
        return cfVar.aZQ.aZR;
    }

    final void aGI() {
        if (this.euW != null && !be.kS(this.euW.field_username)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", String.format("http://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.euW.field_username}));
            intent.putExtra("showShare", false);
            com.tencent.mm.ay.c.b(this.aWn, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    private void eL(boolean z) {
        if (this.euW != null) {
            if (this.aWn != null) {
                if (!z || com.tencent.mm.modelbiz.e.hC(this.euW.field_username)) {
                    this.aWn.vI(8);
                } else {
                    this.aWn.vI(0);
                }
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_is_mute");
            if (checkBoxPreference != null) {
                checkBoxPreference.ocf = z;
            }
        }
    }

    private void xP(final String str) {
        ad.g(new Runnable(this) {
            final /* synthetic */ a hVr;

            public final void run() {
                if (this.hVr.dxf == null) {
                    v.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) this.hVr.dxf.Ow("contact_info_kf_worker");
                if (iconWidgetPreference != null && this.hVr.dxf != null) {
                    Bitmap a = com.tencent.mm.u.b.a(str, false, -1);
                    if (a != null) {
                        v.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", new Object[]{str});
                        iconWidgetPreference.r(a);
                        this.hVr.dxf.notifyDataSetChanged();
                    }
                }
            }
        }, 2000);
    }

    private static void c(com.tencent.mm.modelbiz.f fVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.u.i Bo = com.tencent.mm.u.n.Bo();
        if (Bo.gQ(fVar.field_openId) == null) {
            com.tencent.mm.u.h hVar = new com.tencent.mm.u.h();
            hVar.username = fVar.field_openId;
            hVar.cyC = fVar.field_headImgUrl;
            hVar.aP(false);
            hVar.bBY = 3;
            Bo.a(hVar);
        }
        com.tencent.mm.u.n.Bq().gE(fVar.field_openId);
        v.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        atr com_tencent_mm_protocal_c_atr = null;
        v.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.hVn = false;
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
        }
        if (kVar == null) {
            v.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
            return;
        }
        ak.vy().b(kVar.getType(), this);
        if (i == 0 && i2 == 0) {
            v.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 536) {
                ak.vy().b(536, this);
                aGF();
                return;
            } else if (kVar.getType() == 1363) {
                ats com_tencent_mm_protocal_c_ats;
                com.tencent.mm.plugin.profile.a.b bVar = (com.tencent.mm.plugin.profile.a.b) kVar;
                if (bVar.cif == null || bVar.cif.czl.czs == null) {
                    com_tencent_mm_protocal_c_ats = null;
                } else {
                    com_tencent_mm_protocal_c_ats = (ats) bVar.cif.czl.czs;
                }
                com.tencent.mm.plugin.profile.a.b bVar2 = (com.tencent.mm.plugin.profile.a.b) kVar;
                if (!(bVar2.cif == null || bVar2.cif.czk.czs == null)) {
                    com_tencent_mm_protocal_c_atr = (atr) bVar2.cif.czk.czs;
                }
                if (com_tencent_mm_protocal_c_ats == null || com_tencent_mm_protocal_c_ats.mhP == null || com_tencent_mm_protocal_c_ats.mhP.ret != 0 || com_tencent_mm_protocal_c_ats.mhM == null || be.kS(com_tencent_mm_protocal_c_ats.mhM.mhK)) {
                    if (com_tencent_mm_protocal_c_ats == null || com_tencent_mm_protocal_c_ats.mhP == null) {
                        v.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
                        return;
                    }
                    v.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ats.mhP.ret)});
                    return;
                } else if (com_tencent_mm_protocal_c_ats.mhM == null) {
                    v.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
                    return;
                } else {
                    j ig = com.tencent.mm.modelbiz.u.DC().ig(com_tencent_mm_protocal_c_ats.mhM.mhK);
                    if (ig == null) {
                        ig = new j();
                        ig.field_userId = com_tencent_mm_protocal_c_ats.mhM.mhK;
                    }
                    ig.field_userName = com_tencent_mm_protocal_c_ats.mhM.eES;
                    ig.field_brandUserName = com_tencent_mm_protocal_c_atr.mhJ;
                    ig.field_UserVersion = com_tencent_mm_protocal_c_ats.mhM.ver;
                    ig.field_headImageUrl = com_tencent_mm_protocal_c_ats.mhM.mhE;
                    ig.field_profileUrl = com_tencent_mm_protocal_c_ats.mhM.mhS;
                    ig.field_bitFlag = com_tencent_mm_protocal_c_ats.mhM.mhF;
                    ig.field_addMemberUrl = com_tencent_mm_protocal_c_ats.mhM.mhI;
                    ig.field_needToUpdate = false;
                    if (!com.tencent.mm.modelbiz.u.DC().b(ig)) {
                        com.tencent.mm.modelbiz.u.DC().a(ig);
                        return;
                    }
                    return;
                }
            } else if (kVar.getType() == 1394) {
                ays aGA = ((com.tencent.mm.plugin.profile.a.c) kVar).aGA();
                ayt aGz = ((com.tencent.mm.plugin.profile.a.c) kVar).aGz();
                if (aGz != null && aGz.mhP != null && aGz.mhP.ret == 0) {
                    boolean z;
                    if (aGA.mVW) {
                        z = false;
                    } else {
                        z = true;
                    }
                    BizInfo bizInfo;
                    if (z) {
                        ab abVar;
                        bizInfo = this.exj;
                        bizInfo.field_brandFlag &= -2;
                        a(bizInfo, true);
                        ak.yW();
                        if (c.wK().Mh(bizInfo.field_username) == null) {
                            abVar = new ab(bizInfo.field_username);
                            abVar.cw(be.ma(this.exj.CF()));
                            ak.yW();
                            at MI = c.wJ().MI(bizInfo.field_username);
                            if (MI != null) {
                                ak.yW();
                                c.wK().d(abVar);
                                ak.yW();
                                c.wK().N(MI);
                            } else {
                                abVar.bvG();
                                ak.yW();
                                c.wK().d(abVar);
                            }
                        }
                        ak.yW();
                        if (c.wK().Mh(bizInfo.field_enterpriseFather) == null) {
                            abVar = new ab(bizInfo.field_enterpriseFather);
                            abVar.bvG();
                            ak.yW();
                            c.wK().d(abVar);
                            return;
                        }
                        ak.yW().cra.Lx(bizInfo.field_enterpriseFather);
                        return;
                    }
                    bizInfo = this.exj;
                    bizInfo.field_brandFlag |= 1;
                    a(bizInfo, true);
                    ak.yW();
                    c.wK().Mf(bizInfo.field_username);
                    ak.yW();
                    if (c.wK().Mq(bizInfo.field_enterpriseFather) <= 0) {
                        ak.yW();
                        c.wK().Mf(bizInfo.field_enterpriseFather);
                        return;
                    }
                    ak.yW().cra.Lx(bizInfo.field_enterpriseFather);
                    return;
                } else if (aGz == null || aGz.mhP == null) {
                    v.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[]{Integer.valueOf(kVar.getType())});
                    return;
                } else {
                    v.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(aGz.mhP.ret)});
                    return;
                }
            } else if (kVar.getType() == 1343) {
                aGF();
                return;
            } else if (kVar.getType() == 1228) {
                aGF();
                return;
            } else {
                return;
            }
        }
        v.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
    }

    public final void d(LinkedList<bit> linkedList) {
        com.tencent.mm.modelbiz.u.Dz().b(this);
        if (this.dxf == null) {
            v.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
        } else if (this.euW == null) {
            v.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
        } else if (linkedList == null || linkedList.size() <= 0) {
            v.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
        } else {
            if (!be.kS(this.hVm)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    bit com_tencent_mm_protocal_c_bit = (bit) it.next();
                    if (com_tencent_mm_protocal_c_bit.ndl != null && com_tencent_mm_protocal_c_bit.ndl.equals(this.hVm)) {
                        this.dxf.aO("contact_info_kf_worker", false);
                        this.dxf.Ow("contact_info_kf_worker").setSummary(com_tencent_mm_protocal_c_bit.mGq);
                        return;
                    }
                }
            }
            this.dxf.aO("contact_info_kf_worker", false);
            this.dxf.Ow("contact_info_kf_worker").setSummary(((bit) linkedList.get(0)).mGq);
        }
    }

    public final void a(int i, com.tencent.mm.v.k kVar) {
        if (this.exj != null && this.exj.CB() && kVar.getType() == 1354) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_subscribe_bizinfo");
            this.hVf = com.tencent.mm.modelbiz.u.DC().ig(com.tencent.mm.modelbiz.u.DC().ii(this.exj.field_username));
            if (this.hVf != null) {
                checkBoxPreference.ocf = !this.hVf.fe(4);
            } else {
                v.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
            }
        }
    }

    final boolean xQ(String str) {
        return str.equals("weixinsrc") || this.euW.field_username.equalsIgnoreCase("gh_6e99ff560306");
    }

    public final String Dq() {
        return "MicroMsg.ContactWidgetBizInfo";
    }

    private void aGJ() {
        v.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
        if (this.cnm == null) {
            this.cnm = this.aWn.getSharedPreferences(this.aWn.getPackageName() + "_preferences", 0);
        }
        if (this.ePj != null) {
            if (this.euW != null) {
                this.cnm.edit().putBoolean("biz_placed_to_the_top", this.euW.tP()).commit();
            } else {
                this.cnm.edit().putBoolean("biz_placed_to_the_top", false).commit();
            }
        }
        this.dxf.notifyDataSetChanged();
    }

    private static boolean oo(int i) {
        if (i == 81 || i == 92 || i == 93 || i == 94) {
            return true;
        }
        return false;
    }
}
