package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ar.b;
import com.tencent.mm.ar.f;
import com.tencent.mm.ar.l;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at.d;
import com.tencent.mm.storage.u;
import junit.framework.Assert;

public final class a implements OnItemClickListener {
    private Context context;
    private boolean czr = false;
    private b kfZ;

    public a(Context context, b bVar, boolean z) {
        this.context = context;
        this.kfZ = bVar;
        this.czr = z;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.czr) {
            i--;
        }
        b bVar = (b) this.kfZ.getItem(i);
        if (bVar == null) {
            v.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = " + i);
        } else {
            e(this.context, bVar.field_talker, false);
        }
    }

    public static void e(Context context, String str, boolean z) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
            return;
        }
        v.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = " + str);
        l.KD().kA(str);
        f kH = l.KC().kH(str);
        if (kH == null) {
            v.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = " + str);
        } else if (kH.field_type == 0) {
            ak.yW();
            com.tencent.mm.storage.at.a MU = c.wJ().MU(kH.field_msgContent);
            if (MU != null && MU.lct.length() > 0) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("Contact_ShowFMessageList", true);
                bundle.putInt("Contact_Source_FMessage", MU.scene);
                bundle.putBoolean("Contact_AlwaysShowRemarkBtn", true);
                bundle.putBoolean("Contact_AlwaysShowSnsPreBtn", true);
                ak.yW();
                u LX = c.wH().LX(MU.lct);
                if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                    com.tencent.mm.plugin.subapp.b.drq.a(context, LX, MU, bundle, "");
                } else if (MU.hWq > 0) {
                    if (be.kS(MU.cIJ) && be.kS(MU.cIG) && !be.kS(MU.cID)) {
                        bundle.putString("Contact_QQNick", MU.cID);
                    }
                    com.tencent.mm.plugin.subapp.b.drq.a(context, MU, bundle);
                } else if (be.kS(MU.nvG) && be.kS(MU.nvH)) {
                    com.tencent.mm.plugin.subapp.b.drq.a(context, MU, bundle);
                } else {
                    com.tencent.mm.modelfriend.b iB = ah.FL().iB(MU.nvG);
                    if (iB == null || iB.EB() == null || iB.EB().length() <= 0) {
                        iB = ah.FL().iB(MU.nvH);
                        if (iB == null || iB.EB() == null || iB.EB().length() <= 0) {
                            if (LX == null || ((int) LX.chr) <= 0) {
                                com.tencent.mm.plugin.subapp.b.drq.a(context, MU, bundle);
                            } else {
                                com.tencent.mm.plugin.subapp.b.drq.a(context, LX, MU, bundle, "");
                            }
                            v.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + MU.nvG + " fullMD5:" + MU.nvH);
                            return;
                        }
                    }
                    if (iB.getUsername() == null || iB.getUsername().length() <= 0) {
                        iB.username = MU.lct;
                        iB.bkU = 128;
                        if (ah.FL().a(iB.EB(), iB) == -1) {
                            v.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
                            return;
                        }
                    }
                    com.tencent.mm.plugin.subapp.b.drq.a(context, MU, bundle);
                }
            }
        } else {
            a(context, kH, z);
        }
    }

    public static void a(Context context, f fVar, boolean z) {
        String str = fVar.field_msgContent;
        v.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : " + str);
        if (str != null && str.length() > 0) {
            ak.yW();
            d MT = c.wJ().MT(str);
            if (MT != null && !be.kS(MT.lct)) {
                Assert.assertTrue(MT.lct.length() > 0);
                ak.yW();
                u LX = c.wH().LX(MT.lct);
                Intent intent = new Intent();
                if (z) {
                    intent.putExtra("Accept_NewFriend_FromOutside", true);
                }
                intent.putExtra("Contact_ShowUserName", false);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("Contact_Scene", MT.scene);
                intent.putExtra("Verify_ticket", MT.hUb);
                intent.putExtra("Contact_Source_FMessage", MT.scene);
                intent.putExtra("Contact_AlwaysShowRemarkBtn", true);
                intent.putExtra("Contact_AlwaysShowSnsPreBtn", true);
                if (LX == null || ((int) LX.chr) <= 0 || !com.tencent.mm.i.a.ei(LX.field_type)) {
                    if (fVar.field_type == 1 || fVar.field_type == 2) {
                        intent.putExtra("User_Verify", true);
                    }
                    intent.putExtra("Contact_User", MT.lct);
                    intent.putExtra("Contact_Alias", MT.bLc);
                    intent.putExtra("Contact_Nick", MT.cID);
                    intent.putExtra("Contact_QuanPin", MT.cIF);
                    intent.putExtra("Contact_PyInitial", MT.cIE);
                    intent.putExtra("Contact_Sex", MT.bBZ);
                    intent.putExtra("Contact_Signature", MT.bCj);
                    intent.putExtra("Contact_FMessageCard", true);
                    intent.putExtra("Contact_City", MT.getCity());
                    intent.putExtra("Contact_Province", MT.getProvince());
                    intent.putExtra("Contact_Mobile_MD5", MT.nvG);
                    intent.putExtra("Contact_full_Mobile_MD5", MT.nvH);
                    intent.putExtra("Contact_KSnsBgUrl", MT.nvQ);
                } else {
                    intent.putExtra("Contact_User", LX.field_username);
                    com.tencent.mm.plugin.subapp.b.drq.a(intent, LX.field_username);
                }
                str = MT.content;
                if (be.ma(str).length() <= 0) {
                    switch (MT.scene) {
                        case 18:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            str = context.getString(2131231796);
                            break;
                        default:
                            str = context.getString(2131231792);
                            break;
                    }
                }
                intent.putExtra("Contact_Content", str);
                if (MT.nvS == 1 && !be.kS(MT.nvU)) {
                    intent.putExtra("Safety_Warning_Detail", MT.nvU);
                }
                intent.putExtra("Contact_verify_Scene", MT.scene);
                intent.putExtra("Contact_Uin", MT.hWq);
                intent.putExtra("Contact_QQNick", MT.cIG);
                intent.putExtra("Contact_Mobile_MD5", MT.nvG);
                intent.putExtra("User_From_Fmessage", true);
                intent.putExtra("Contact_from_msgType", 37);
                if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                    intent.putExtra("Contact_KSnsIFlag", 0);
                }
                intent.putExtra("Contact_KSnsBgUrl", MT.nvQ);
                intent.putExtra("verify_gmail", MT.hWt);
                intent.putExtra("source_from_user_name", MT.lJi);
                intent.putExtra("source_from_nick_name", MT.lJj);
                com.tencent.mm.ay.c.b(context, "profile", ".ui.ContactInfoUI", intent);
            }
        }
    }
}
