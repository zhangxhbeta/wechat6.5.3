package com.tencent.mm.plugin.sport.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.model.n;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.pluginsdk.c.a, e {
    Context context;
    private p dwE;
    private f dxf;
    u euW;
    private CheckBoxPreference keo;
    private CheckBoxPreference kep;

    public a(Context context) {
        this.context = context;
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        this.dxf = fVar;
        this.euW = uVar;
        fVar.addPreferencesFromResource(2131099683);
        this.keo = (CheckBoxPreference) fVar.Ow("contact_info_top_sport");
        this.kep = (CheckBoxPreference) fVar.Ow("contact_info_not_disturb");
        XR();
        return true;
    }

    public final boolean XS() {
        return true;
    }

    public final boolean pz(String str) {
        if ("contact_info_record_data".equals(str)) {
            this.context.startActivity(new Intent(this.context, ExdeviceRankDataSourceUI.class));
        } else if ("contact_info_top_sport".equals(str)) {
            if (this.keo.isChecked()) {
                m.l(this.euW.field_username, true);
            } else {
                m.m(this.euW.field_username, true);
            }
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.kep.isChecked()) {
                m.l(this.euW);
            } else {
                m.m(this.euW);
            }
        } else if ("contact_info_go_to_sport".equals(str)) {
            r0 = new Intent();
            r0.putExtra("Chat_User", this.euW.field_username);
            r0.putExtra("finish_direct", true);
            c.a(this.context, ".ui.chatting.ChattingUI", r0);
        } else if ("contact_info_go_to_my_profile".equals(str)) {
            String xF = k.xF();
            if (be.kS(xF)) {
                v.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
            } else {
                Intent intent = new Intent();
                intent.putExtra("username", xF);
                c.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", intent);
            }
        } else if ("contact_info_invite_friend".equals(str)) {
            r0 = new Intent();
            r0.putExtra("Select_Talker_Name", this.euW.field_username);
            r0.putExtra("Select_block_List", this.euW.field_username);
            r0.putExtra("Select_Conv_Type", 3);
            r0.putExtra("Select_Send_Card", true);
            c.a(this.context, ".ui.transmit.SelectConversationUI", r0, 1);
        } else if ("contact_info_common_problem".equals(str)) {
            r0 = new Intent();
            r0.putExtra("KPublisherId", "custom_menu");
            r0.putExtra("pre_username", this.euW.field_username);
            r0.putExtra("prePublishId", "custom_menu");
            r0.putExtra("preUsername", this.euW.field_username);
            r0.putExtra("preChatName", this.euW.field_username);
            r0.putExtra("preChatTYPE", n.F(this.euW.field_username, this.euW.field_username));
            r0.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
            r0.putExtra("geta8key_username", this.euW.field_username);
            r0.putExtra("from_scence", 1);
            c.b(this.context, "webview", ".ui.tools.WebViewUI", r0);
        } else if ("contact_info_privacy_and_notification".equals(str)) {
            c.w(this.context, "exdevice", ".ui.ExdeviceSettingUI");
        } else if ("contact_info_sport_install".equals(str)) {
            Context context = this.context;
            this.context.getString(2131231164);
            this.dwE = g.a(context, this.context.getString(2131235103), true, null);
            this.dwE.show();
            ak.vy().a(30, this);
            List linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            List linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            ak.vy().a(new com.tencent.mm.pluginsdk.model.m(1, linkedList, linkedList2, "", ""), 0);
        } else if ("contact_info_sport_uninstall".equals(str)) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ a keq;

                {
                    this.keq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.sport.a.drq.a(com.tencent.mm.modelbiz.e.hw(this.keq.euW.field_username), (Activity) this.keq.context, this.keq.euW);
                    this.keq.XR();
                }
            }, null);
        } else if ("contact_info_clear_data".equals(str)) {
            g.b(this.context, this.context.getString(2131232017), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ a keq;

                {
                    this.keq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.yW();
                    com.tencent.mm.model.c.wJ().MO("gh_43f2581f6fd6");
                }
            }, null);
        }
        return false;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("be_send_card_name");
                        String stringExtra2 = intent.getStringExtra("received_card_name");
                        String stringExtra3 = intent.getStringExtra("custom_send_text");
                        boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Chat_User", stringExtra2);
                        intent2.putExtra("send_card_username", stringExtra);
                        intent2.putExtra("send_card_edittext", stringExtra3);
                        intent2.putExtra("Is_Chatroom", booleanExtra);
                        c.a(this.context, ".ui.chatting.ChattingUI", intent2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    final void XR() {
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
        helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232189));
        if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
            helperHeaderPreference.updateStatus(1);
            this.dxf.aO("contact_info_sport_install", true);
            this.dxf.aO("contact_info_sport_uninstall", false);
            this.dxf.aO("contact_info_go_to_sport", false);
            this.dxf.aO("contact_info_go_to_my_profile", false);
            this.dxf.aO("contact_info_invite_friend", false);
            this.dxf.aO("contact_info_common_problem", false);
            this.dxf.aO("contact_info_record_data", false);
            this.dxf.aO("contact_info_privacy_and_notification", false);
            this.dxf.aO("contact_info_top_sport", false);
            this.dxf.aO("contact_info_not_disturb", false);
            ak.yW();
            if (com.tencent.mm.model.c.wK().Mn(this.euW.field_username)) {
                this.keo.ocf = true;
            } else {
                this.keo.ocf = false;
            }
            if (this.euW.tM()) {
                this.kep.ocf = true;
                return;
            } else {
                this.kep.ocf = false;
                return;
            }
        }
        helperHeaderPreference.updateStatus(0);
        this.dxf.aO("contact_info_sport_install", false);
        this.dxf.aO("contact_info_sport_uninstall", true);
        this.dxf.aO("contact_info_go_to_sport", true);
        this.dxf.aO("contact_info_go_to_my_profile", true);
        this.dxf.aO("contact_info_invite_friend", true);
        this.dxf.aO("contact_info_common_problem", true);
        this.dxf.aO("contact_info_record_data", true);
        this.dxf.aO("contact_info_privacy_and_notification", true);
        this.dxf.aO("contact_info_top_sport", true);
        this.dxf.aO("contact_info_not_disturb", true);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof com.tencent.mm.pluginsdk.model.m) {
            ak.vy().b(30, this);
            if (i == 0 && i2 == 0) {
                String bmW = ((com.tencent.mm.pluginsdk.model.m) kVar).bmW();
                v.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[]{bmW});
                ak.yW();
                u LX = com.tencent.mm.model.c.wH().LX("gh_43f2581f6fd6");
                if (LX == null || be.kS(bmW)) {
                    v.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + bmW + ", contact = " + LX);
                } else {
                    BizInfo bizInfo = null;
                    if (m.eB(LX.field_username)) {
                        String ma = be.ma(LX.field_username);
                        bizInfo = com.tencent.mm.modelbiz.e.hw(ma);
                        if (bizInfo != null) {
                            bizInfo.field_username = bmW;
                        }
                        com.tencent.mm.modelbiz.u.Dy().hp(ma);
                        LX.bY(ma);
                    }
                    LX.setUsername(bmW);
                    if (((int) LX.chr) == 0) {
                        ak.yW();
                        com.tencent.mm.model.c.wH().O(LX);
                    }
                    if (((int) LX.chr) <= 0) {
                        v.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
                    } else {
                        m.n(LX);
                        ak.yW();
                        u LX2 = com.tencent.mm.model.c.wH().LX(LX.field_username);
                        if (bizInfo != null) {
                            com.tencent.mm.modelbiz.u.Dy().d(bizInfo);
                        } else {
                            bizInfo = com.tencent.mm.modelbiz.e.hw(LX2.field_username);
                            if (bizInfo == null || bizInfo.Ct()) {
                                v.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
                                com.tencent.mm.model.ab.a.crZ.I(LX2.field_username, "");
                                b.gC(LX2.field_username);
                            } else if (LX2.bvp()) {
                                v.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[]{Integer.valueOf(LX2.bCr)});
                                com.tencent.mm.model.ab.a.crZ.I(LX2.field_username, "");
                                b.gC(LX2.field_username);
                            }
                        }
                    }
                }
                com.tencent.mm.modelbiz.u.Dy().e(com.tencent.mm.modelbiz.u.Dy().ho(LX.field_username));
                ak.yW();
                com.tencent.mm.model.c.vf().set(327825, Boolean.valueOf(true));
            } else {
                v.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 4 && i2 == -24 && !be.kS(str)) {
                    Toast.makeText(aa.getContext(), str, 1).show();
                }
            }
            if (this.dwE != null) {
                this.dwE.dismiss();
            }
            XR();
        }
    }
}
