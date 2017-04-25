package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.ae.d;
import com.tencent.mm.as.p;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.by;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.e.a.ms;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.e.a.qh;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.model.n;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.network.aa;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;
import junit.framework.Assert;

class cq implements OnClickListener {
    public static boolean oqV = false;
    private a onG;

    public cq(a aVar, String str) {
        this.onG = aVar;
        b hqVar = new hq();
        hqVar.bhv.aOo = u.bsY();
        if (m.dE(str)) {
            hqVar.bhv.bhx = true;
        } else {
            hqVar.bhv.bhx = false;
        }
        com.tencent.mm.sdk.c.a.nhr.z(hqVar);
    }

    public void onClick(View view) {
        dl dlVar = (dl) view.getTag();
        int i = 0;
        String str;
        Intent intent;
        String str2;
        Intent intent2;
        String str3;
        Intent intent3;
        at atVar;
        String str4;
        String str5;
        switch (dlVar.eKg) {
            case 1:
            case 9:
                str = dlVar.userName;
                if (str != null && !str.equals(SQLiteDatabase.KeyEmpty)) {
                    if (this.onG.lMy) {
                        Context context = this.onG.nDR.nEl;
                        intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        intent.putExtra("Contact_Encryptusername", true);
                        intent.putExtra("Contact_IsLBSFriend", true);
                        intent.putExtra("Contact_IsLbsChattingProfile", true);
                        c.b(context, "profile", ".ui.ContactInfoUI", intent);
                        return;
                    } else if (this.onG.lKa) {
                        j hQ = this.onG.ogZ.hQ(str);
                        if (hQ == null) {
                            return;
                        }
                        if (hQ == null || t.kS(hQ.field_profileUrl)) {
                            str = "MicroMsg.ChattingListClickListener";
                            str2 = "onClick userInfo == null:%s";
                            Object[] objArr = new Object[1];
                            objArr[0] = Boolean.valueOf(hQ == null);
                            v.w(str, str2, objArr);
                            return;
                        }
                        v.i("MicroMsg.ChattingListClickListener", "onClick Url:%s", hQ.field_profileUrl);
                        com.tencent.mm.modelbiz.u.DE();
                        h.a(hQ.field_userId, hQ.field_brandUserName, null);
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", hQ.field_profileUrl);
                        intent2.putExtra("useJs", true);
                        c.b(this.onG.bzo(), "webview", ".ui.tools.WebViewUI", intent2);
                        return;
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        if (dlVar.eKg == 9 && !t.kS(dlVar.oxT)) {
                            intent.putExtra("Contact_BIZ_KF_WORKER_ID", dlVar.oxT);
                        }
                        ak.yW();
                        com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
                        if (LX != null && LX.tS() > 0 && LX.tI()) {
                            e.a(intent, str);
                        } else if (this.onG.onm) {
                            ab.a.crZ.a(str, SQLiteDatabase.KeyEmpty, new ab.c.a(this) {
                                final /* synthetic */ cq oqW;

                                {
                                    this.oqW = r1;
                                }

                                public final void p(String str, boolean z) {
                                }
                            });
                        }
                        if (m.dE(this.onG.bhV.getUsername())) {
                            o LD = ak.yW().wO().LD(this.onG.bhV.getUsername());
                            intent.putExtra("Contact_RoomNickname", LD.er(str));
                            intent.putExtra("Contact_Scene", 14);
                            intent.putExtra("room_name", this.onG.bhV.getUsername());
                            intent.putExtra("Is_RoomOwner", LD.field_roomowner == null ? false : LD.field_roomowner.equals(k.xF()));
                        }
                        if (dlVar.bmk != null) {
                            switch (dlVar.bmk.getType()) {
                                case 55:
                                case 57:
                                    intent.putExtra("Contact_Scene", 34);
                                    intent.putExtra("Contact_IsLBSFriend", true);
                                    break;
                            }
                        }
                        c.b(this.onG.aLx(), "profile", ".ui.ContactInfoUI", intent, 213);
                        return;
                    }
                }
                return;
            case 6:
                v.d("MicroMsg.ChattingListClickListener", "edw timestamp, onClick = " + System.currentTimeMillis());
                if (!r.a(dlVar.cCj, this.onG.aLx(), null, this.onG.bEn())) {
                    str2 = dlVar.userName;
                    str3 = dlVar.oxQ;
                    if (str2 != null && !str2.equals(SQLiteDatabase.KeyEmpty)) {
                        intent3 = new Intent();
                        intent3.putExtra("rawUrl", str2);
                        intent3.putExtra("shortUrl", str2);
                        intent3.putExtra("webpageTitle", str3);
                        Bundle bundle = new Bundle();
                        atVar = dlVar.bmk;
                        if (atVar != null) {
                            if (atVar.bwh()) {
                                Map q = bf.q(atVar.pO(), "msg");
                                if (q != null) {
                                    dc X = dc.X(q);
                                    if (!t.kS(X.eHB)) {
                                        intent3.putExtra("KTemplateId", X.eHB);
                                        v.d("MicroMsg.ChattingListClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", X.eHB, dlVar.bnR);
                                        g.iuh.h(11608, X.eHB, dlVar.bnR);
                                    }
                                }
                            }
                            ak.yW();
                            com.tencent.mm.storage.u LX2 = com.tencent.mm.model.c.wH().LX(atVar.pN());
                            if (LX2 != null && LX2.bvm()) {
                                i = 4;
                                v.d("MicroMsg.ChattingListClickListener", "hakon click biz msg %s", LX2.getUsername());
                            }
                            intent3.putExtra("msg_id", atVar.pJ());
                            intent3.putExtra("KPublisherId", "msg_" + Long.toString(atVar.pK()));
                            intent3.putExtra("pre_username", atVar.pN());
                            intent3.putExtra("prePublishId", "msg_" + Long.toString(atVar.pK()));
                            intent3.putExtra("preUsername", ad.a(atVar, dlVar.nQK, this.onG.lKa));
                            intent3.putExtra("preChatName", this.onG.bEn());
                            intent3.putExtra("preChatTYPE", n.F(ad.a(atVar, dlVar.nQK, this.onG.lKa), this.onG.bEn()));
                            intent3.putExtra("preMsgIndex", dlVar.lfe);
                        }
                        bundle.putInt("snsWebSource", i);
                        intent3.putExtra("jsapiargs", bundle);
                        intent3.putExtra("geta8key_username", this.onG.bEn());
                        if (!t.kS(dlVar.bnR)) {
                            intent3.putExtra("srcUsername", dlVar.bnR);
                            intent3.putExtra("srcDisplayname", dlVar.bnS);
                            intent3.putExtra("mode", 1);
                        }
                        intent3.putExtra("message_id", dlVar.lfd);
                        intent3.putExtra("message_index", dlVar.lfe);
                        intent3.putExtra("from_scence", 1);
                        c.b(this.onG.aLx(), "webview", ".ui.tools.WebViewUI", intent3);
                        if (!t.kS(this.onG.bEn())) {
                            ak.yW();
                            if (com.tencent.mm.model.c.wH().LX(this.onG.bEn()).bCs == 1) {
                                ak.yW();
                                com.tencent.mm.model.c.wK().Mk(this.onG.bEn());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 7:
                intent2 = new Intent();
                intent2.putExtra("geta8key_username", this.onG.bEn());
                intent2.putExtra("rawUrl", dlVar.bNm);
                c.b(this.onG.aLx(), "webview", ".ui.tools.WebViewUI", intent2);
                return;
            case 8:
                if (dlVar.bmk != null) {
                    Object obj = dlVar.aZD;
                    if (TextUtils.isEmpty(obj)) {
                        obj = com.tencent.mm.pluginsdk.j.a.bmr().rn(dlVar.bNm);
                    }
                    if (TextUtils.isEmpty(obj)) {
                        intent2 = new Intent();
                        intent2.putExtra("geta8key_username", this.onG.bEn());
                        intent2.putExtra("rawUrl", dlVar.bNm);
                        c.b(this.onG.aLx(), "webview", ".ui.tools.WebViewUI", intent2);
                        return;
                    }
                    intent = new Intent();
                    intent.putExtra("extra_id", obj);
                    intent.putExtra("extra_name", dlVar.title);
                    if (dlVar.oxR) {
                        intent.putExtra("download_entrance_scene", 20);
                        intent.putExtra("preceding_scence", 3);
                        intent.putExtra("reward_tip", true);
                        g.iuh.h(12953, Integer.valueOf(1), obj);
                    } else if (dlVar.oxS) {
                        intent.putExtra("download_entrance_scene", 25);
                        intent.putExtra("preceding_scence", 9);
                        intent.putExtra("reward_tip", true);
                    } else {
                        intent.putExtra("download_entrance_scene", 22);
                        intent.putExtra("preceding_scence", 122);
                        g.iuh.h(10993, Integer.valueOf(2), obj);
                    }
                    c.b(this.onG.aLx(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                    return;
                }
                return;
            case 10:
                if (dlVar.bmk != null) {
                    i = dlVar.designerUIN;
                    str2 = dlVar.designerName;
                    str3 = dlVar.designerRediretctUrl;
                    if (i != 0) {
                        intent3 = new Intent();
                        intent3.putExtra("geta8key_username", this.onG.bEn());
                        intent3.putExtra("rawUrl", dlVar.bNm);
                        intent3.putExtra("uin", i);
                        intent3.putExtra("name", str2);
                        intent3.putExtra("rediret_url", str3);
                        intent3.putExtra("extra_scence", 22);
                        c.b(this.onG.aLx(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent3);
                        return;
                    }
                    return;
                }
                return;
            case 11:
                com.tencent.mm.ui.base.g.b(this.onG.aLx(), this.onG.getString(2131232329), SQLiteDatabase.KeyEmpty, this.onG.getString(2131232331), this.onG.getString(2131232328), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ cq oqW;

                    {
                        this.oqW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b byVar = new by();
                        byVar.aZv.aZw = true;
                        com.tencent.mm.sdk.c.a.nhr.z(byVar);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ cq oqW;

                    {
                        this.oqW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b byVar = new by();
                        byVar.aZv.aZw = false;
                        com.tencent.mm.sdk.c.a.nhr.z(byVar);
                    }
                });
                return;
            case 12:
                if (dlVar.bmk != null) {
                    i = dlVar.tid;
                    str2 = dlVar.cqe;
                    str3 = dlVar.desc;
                    str4 = dlVar.iconUrl;
                    str5 = dlVar.secondUrl;
                    if (i != 0) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("geta8key_username", this.onG.bEn());
                        intent4.putExtra("rawUrl", dlVar.bNm);
                        intent4.putExtra("topic_id", i);
                        intent4.putExtra("topic_name", str2);
                        intent4.putExtra("topic_desc", str3);
                        intent4.putExtra("topic_icon_url", str4);
                        intent4.putExtra("topic_ad_url", str5);
                        intent4.putExtra("extra_scence", 22);
                        c.b(this.onG.aLx(), "emoji", ".ui.EmojiStoreTopicUI", intent4);
                        return;
                    }
                    v.i("MicroMsg.ChattingListClickListener", "topic id is zero.");
                    return;
                }
                return;
            case 13:
                if (dlVar.bmk != null) {
                    i = dlVar.tid;
                    str2 = dlVar.cqe;
                    str3 = dlVar.desc;
                    str4 = dlVar.iconUrl;
                    str5 = dlVar.secondUrl;
                    int i2 = dlVar.pageType;
                    if (i != 0) {
                        Intent intent5 = new Intent();
                        intent5.putExtra("geta8key_username", this.onG.bEn());
                        intent5.putExtra("rawUrl", dlVar.bNm);
                        intent5.putExtra("set_id", i);
                        intent5.putExtra("set_title", str2);
                        intent5.putExtra("set_iconURL", str4);
                        intent5.putExtra("set_desc", str3);
                        intent5.putExtra("headurl", str5);
                        intent5.putExtra("pageType", i2);
                        c.b(this.onG.aLx(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent5);
                        return;
                    }
                    v.i("MicroMsg.ChattingListClickListener", "topic id is zero.");
                    return;
                }
                return;
            default:
                at atVar2 = dlVar.bmk;
                if (atVar2 != null) {
                    ad X2 = this.onG.onh.X(atVar2.getType(), atVar2.pL() == 1);
                    if (X2 == null || !X2.a(view, this.onG, atVar2)) {
                        if (dlVar.eKg == 5 && atVar2.pL() == 1) {
                            final at atVar3 = dlVar.bmk;
                            com.tencent.mm.ui.base.g.b(this.onG.aLx(), this.onG.getString(2131231873), SQLiteDatabase.KeyEmpty, this.onG.getString(2131231143), this.onG.getString(2131231010), new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ cq oqW;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    atVar3.bww();
                                    ak.yW();
                                    com.tencent.mm.model.c.wJ().a(atVar3.field_msgId, atVar3);
                                    if (atVar3.bwb()) {
                                        this.oqW.onG.ap(atVar3);
                                    } else if (atVar3.bwj()) {
                                        this.oqW.onG.aq(atVar3);
                                    } else if (atVar3.bwp()) {
                                        this.oqW.onG.ar(atVar3);
                                    } else if (atVar3.bwm()) {
                                        this.oqW.onG.as(atVar3);
                                    } else if (atVar3.bwl()) {
                                        this.oqW.onG.av(atVar3);
                                    } else if (atVar3.bwq()) {
                                        this.oqW.onG.au(atVar3);
                                    } else if (atVar3.bwk()) {
                                        this.oqW.onG.at(atVar3);
                                    } else {
                                        v.e("MicroMsg.ChattingListClickListener", "uknown msg type");
                                    }
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ cq oqW;

                                {
                                    this.oqW = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        }
                        v.i("MicroMsg.ChattingListClickListener", "CreateTime:" + atVar2.pM());
                        if (atVar2.bwb()) {
                            com.tencent.mm.modelstat.b.daJ.s(dlVar.bmk);
                            if (com.tencent.mm.as.u.bj(this.onG.aLx()) || com.tencent.mm.ah.a.aT(this.onG.aLx())) {
                                v.d("MicroMsg.ChattingListClickListener", "voip is running, not play voice");
                                return;
                            }
                            ak.yW();
                            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                                s.ey(this.onG.aLx());
                                return;
                            } else if (dlVar != null && dlVar.bmk != null) {
                                com.tencent.mm.modelvoice.n nVar = new com.tencent.mm.modelvoice.n(dlVar.bmk.pO());
                                if (t.kS(dlVar.bmk.pO()) || nVar.time == 0) {
                                    Toast.makeText(this.onG.aLx(), 2131231774, 0).show();
                                    return;
                                } else if (this.onG.onh != null && this.onG.onh.oqd != null) {
                                    this.onG.onh.oqd.a(dlVar.position, dlVar.bmk);
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if ((atVar2.getType() == 35 ? 1 : null) != null) {
                            ak.yW();
                            at.c MS = com.tencent.mm.model.c.wJ().MS(dlVar.bmk.pO());
                            if (t.ma(MS.iaq).length() > 0) {
                                c.b(this.onG.aLx(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", dlVar.bmk.pJ()));
                                return;
                            } else if (t.ma(MS.bwP()).length() > 0) {
                                c.b(this.onG.aLx(), "webview", ".ui.tools.WebViewUI", new Intent("android.intent.action.VIEW", Uri.parse(MS.bwP())));
                                return;
                            } else {
                                return;
                            }
                        } else if (atVar2.bwj()) {
                            d dVar;
                            Map q2;
                            d a;
                            com.tencent.mm.modelstat.b.daJ.s(dlVar.bmk);
                            at atVar4 = dlVar.bmk;
                            com.tencent.mm.modelstat.a.a(atVar4, com.tencent.mm.modelstat.a.a.Click);
                            int[] iArr = new int[2];
                            int i3 = 0;
                            int i4 = 0;
                            if (view != null) {
                                view.getLocationInWindow(iArr);
                                i3 = view.getWidth();
                                i4 = view.getHeight();
                            }
                            if (atVar4.pL() == 1) {
                                d ai = com.tencent.mm.ae.n.GH().ai(atVar4.pJ());
                                if (ai.Gm() != 0) {
                                    dVar = ai;
                                    q2 = bf.q(atVar4.pO(), "msg");
                                    if (q2 != null) {
                                        Long.valueOf(t.ah((String) q2.get(".msg.img.$hdlength"), "0")).longValue();
                                    }
                                    ak.yW();
                                    if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                                        s.ey(this.onG.aLx());
                                        return;
                                    } else if (atVar4.pL() == 1) {
                                        if (com.tencent.mm.a.e.aR(com.tencent.mm.ae.n.GH().l(com.tencent.mm.ae.e.c(dVar), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty))) {
                                            if (com.tencent.mm.a.e.aR(com.tencent.mm.ae.n.GH().l(dVar.Gn(), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty))) {
                                                a(atVar4.pJ(), atVar4.pK(), dlVar.userName, dlVar.biB, iArr, i3, i4);
                                                return;
                                            } else {
                                                b(dVar.Gl(), dVar.pK(), dlVar.userName, dlVar.biB, iArr, i3, i4);
                                                return;
                                            }
                                        }
                                        b(dVar.Gl(), dVar.pK(), dlVar.userName, dlVar.biB, iArr, i3, i4);
                                        return;
                                    } else if (dVar.Go()) {
                                        if (dVar.status == -1) {
                                            v.i("MicroMsg.ChattingListClickListener", "retry downloadImg, %d", Long.valueOf(dVar.Gm()));
                                            dVar.dh(0);
                                            dVar.bkU = FileUtils.S_IRUSR;
                                            com.tencent.mm.ae.n.GH().a(Long.valueOf(dVar.Gm()), dVar);
                                        }
                                        a(atVar4.pJ(), atVar4.pK(), dlVar.userName, dlVar.biB, iArr, i3, i4);
                                        return;
                                    } else {
                                        str = dVar.Gn();
                                        if (dVar.Gp()) {
                                            a = com.tencent.mm.ae.e.a(dVar);
                                            if (a != null && a.Gm() > 0 && a.Go() && com.tencent.mm.a.e.aR(com.tencent.mm.ae.n.GH().l(a.Gn(), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty))) {
                                                str = a.Gn();
                                            }
                                        }
                                        com.tencent.mm.ae.n.GH().l(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                                        b(dVar.Gl(), dVar.pK(), dlVar.userName, dlVar.biB, iArr, i3, i4);
                                        return;
                                    }
                                }
                            }
                            dVar = com.tencent.mm.ae.n.GH().ah(atVar4.pK());
                            q2 = bf.q(atVar4.pO(), "msg");
                            if (q2 != null) {
                                Long.valueOf(t.ah((String) q2.get(".msg.img.$hdlength"), "0")).longValue();
                            }
                            ak.yW();
                            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                                s.ey(this.onG.aLx());
                                return;
                            } else if (atVar4.pL() == 1) {
                                if (com.tencent.mm.a.e.aR(com.tencent.mm.ae.n.GH().l(com.tencent.mm.ae.e.c(dVar), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty))) {
                                    if (com.tencent.mm.a.e.aR(com.tencent.mm.ae.n.GH().l(dVar.Gn(), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty))) {
                                        a(atVar4.pJ(), atVar4.pK(), dlVar.userName, dlVar.biB, iArr, i3, i4);
                                        return;
                                    } else {
                                        b(dVar.Gl(), dVar.pK(), dlVar.userName, dlVar.biB, iArr, i3, i4);
                                        return;
                                    }
                                }
                                b(dVar.Gl(), dVar.pK(), dlVar.userName, dlVar.biB, iArr, i3, i4);
                                return;
                            } else if (dVar.Go()) {
                                if (dVar.status == -1) {
                                    v.i("MicroMsg.ChattingListClickListener", "retry downloadImg, %d", Long.valueOf(dVar.Gm()));
                                    dVar.dh(0);
                                    dVar.bkU = FileUtils.S_IRUSR;
                                    com.tencent.mm.ae.n.GH().a(Long.valueOf(dVar.Gm()), dVar);
                                }
                                a(atVar4.pJ(), atVar4.pK(), dlVar.userName, dlVar.biB, iArr, i3, i4);
                                return;
                            } else {
                                str = dVar.Gn();
                                if (dVar.Gp()) {
                                    a = com.tencent.mm.ae.e.a(dVar);
                                    str = a.Gn();
                                    break;
                                }
                                com.tencent.mm.ae.n.GH().l(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                                b(dVar.Gl(), dVar.pK(), dlVar.userName, dlVar.biB, iArr, i3, i4);
                                return;
                            }
                        } else if (atVar2.bwk()) {
                            str3 = dlVar.userName;
                            str = atVar2.pO();
                            r0 = (!dlVar.nQK || (atVar2.pL() == 0 ? 1 : null) == null) ? str : aw.fM(str);
                            ak.yW();
                            at.a MU = com.tencent.mm.model.c.wJ().MU(r0);
                            if (MU != null) {
                                intent2 = new Intent();
                                intent2.putExtra("Contact_User", MU.bwE());
                                intent2.putExtra("Contact_Alias", MU.bLc);
                                intent2.putExtra("Contact_Nick", MU.cID);
                                intent2.putExtra("Contact_QuanPin", MU.cIF);
                                intent2.putExtra("Contact_PyInitial", MU.cIE);
                                intent2.putExtra("Contact_Uin", MU.bwH());
                                intent2.putExtra("Contact_Mobile_MD5", MU.bwG());
                                intent2.putExtra("Contact_full_Mobile_MD5", MU.bwJ());
                                intent2.putExtra("Contact_QQNick", MU.bwI());
                                intent2.putExtra("User_From_Fmessage", false);
                                intent2.putExtra("Contact_Scene", MU.bwF());
                                intent2.putExtra("Contact_FMessageCard", true);
                                intent2.putExtra("Contact_RemarkName", MU.cIJ);
                                intent2.putExtra("Contact_VUser_Info_Flag", MU.bwK());
                                intent2.putExtra("Contact_VUser_Info", MU.bCp);
                                intent2.putExtra("Contact_BrandIconURL", MU.hUf);
                                intent2.putExtra("Contact_Province", MU.getProvince());
                                intent2.putExtra("Contact_City", MU.getCity());
                                intent2.putExtra("Contact_Sex", MU.bBZ);
                                intent2.putExtra("Contact_Signature", MU.bCj);
                                intent2.putExtra("Contact_ShowUserName", true);
                                intent2.putExtra("Contact_KSnsIFlag", 0);
                                intent2.putExtra("Contact_Source_FMessage", 17);
                                intent2.putExtra("source_from_user_name", str3);
                                intent2.putExtra("source_from_nick_name", l.eq(str3));
                                if ((MU.bwK() & 8) > 0) {
                                    if (!t.kS(str3)) {
                                        ak.yW();
                                        if (com.tencent.mm.model.c.wH().LX(str3).bvm()) {
                                            intent2.putExtra("Contact_Scene", 41);
                                            g.iuh.Y(10298, MU.bwE() + ",41");
                                        }
                                    }
                                    intent2.putExtra("Contact_Scene", 17);
                                    g.iuh.Y(10298, MU.bwE() + ",17");
                                }
                                c.b(this.onG.aLx(), "profile", ".ui.ContactInfoUI", intent2);
                                com.tencent.mm.az.a.uy(MU.bwF());
                                return;
                            }
                            return;
                        } else if (atVar2.getType() == 37) {
                            r0 = atVar2.pO();
                            v.w("MicroMsg.ChattingListClickListener", "dealClickVerifyMsgEvent : " + r0);
                            if (r0 != null && r0.length() > 0) {
                                ak.yW();
                                at.d MT = com.tencent.mm.model.c.wJ().MT(r0);
                                if (MT != null) {
                                    Assert.assertTrue(MT.bwE().length() > 0);
                                    ak.yW();
                                    com.tencent.mm.storage.u LX3 = com.tencent.mm.model.c.wH().LX(MT.bwE());
                                    intent = new Intent();
                                    if (LX3 == null || LX3.tS() <= 0 || !LX3.tI()) {
                                        intent.putExtra("Verify_ticket", MT.hUb);
                                        intent.putExtra("User_Verify", true);
                                        intent.putExtra("Contact_User", MT.bwE());
                                        intent.putExtra("Contact_Alias", MT.bLc);
                                        intent.putExtra("Contact_Nick", MT.cID);
                                        intent.putExtra("Contact_QuanPin", MT.cIF);
                                        intent.putExtra("Contact_PyInitial", MT.cIE);
                                        intent.putExtra("Contact_Sex", MT.bBZ);
                                        intent.putExtra("Contact_Signature", MT.bCj);
                                        intent.putExtra("Contact_Scene", MT.bwF());
                                        intent.putExtra("Contact_FMessageCard", true);
                                        intent.putExtra("Contact_City", MT.getCity());
                                        intent.putExtra("Contact_Province", MT.getProvince());
                                        intent.putExtra("Contact_Mobile_MD5", MT.bwG());
                                        intent.putExtra("Contact_full_Mobile_MD5", MT.nvH);
                                        intent.putExtra("Contact_KSnsIFlag", MT.bwQ());
                                        intent.putExtra("Contact_KSnsBgUrl", MT.bwR());
                                    } else {
                                        intent.putExtra("Contact_User", LX3.getUsername());
                                        e.a(intent, LX3.getUsername());
                                    }
                                    r0 = MT.content;
                                    if (t.ma(r0).length() <= 0) {
                                        switch (MT.bwF()) {
                                            case android.support.v7.a.a.k.MG /*18*/:
                                            case android.support.v7.a.a.k.MM /*22*/:
                                            case android.support.v7.a.a.k.Nb /*23*/:
                                            case 24:
                                            case 25:
                                            case android.support.v7.a.a.k.Kr /*26*/:
                                            case 27:
                                            case 28:
                                            case 29:
                                                r0 = this.onG.getString(2131231796);
                                                break;
                                            default:
                                                r0 = this.onG.getString(2131231792);
                                                break;
                                        }
                                    }
                                    intent.putExtra("Contact_Content", r0);
                                    intent.putExtra("Contact_verify_Scene", MT.bwF());
                                    intent.putExtra("Contact_Uin", MT.hWq);
                                    intent.putExtra("Contact_QQNick", MT.cIG);
                                    intent.putExtra("Contact_Mobile_MD5", MT.bwG());
                                    intent.putExtra("User_From_Fmessage", true);
                                    intent.putExtra("Contact_from_msgType", 37);
                                    intent.putExtra("Contact_KSnsIFlag", MT.bwQ());
                                    intent.putExtra("Contact_KSnsBgUrl", MT.bwR());
                                    c.b(this.onG.aLx(), "profile", ".ui.ContactInfoUI", intent);
                                    com.tencent.mm.az.a.uy(MT.bwF());
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (atVar2.getType() == 40) {
                            r0 = atVar2.pO();
                            ak.yW();
                            at.a MU2 = com.tencent.mm.model.c.wJ().MU(r0);
                            if (MU2 != null && MU2.bwE().length() > 0) {
                                com.tencent.mm.az.a.uy(MU2.bwF());
                                ak.yW();
                                com.tencent.mm.storage.u LX4 = com.tencent.mm.model.c.wH().LX(MU2.bwE());
                                if (LX4 != null && LX4.tS() > 0 && LX4.tI()) {
                                    e.a(this.onG.aLx(), LX4, MU2);
                                    return;
                                } else if (MU2.bwH() > 0 || (t.kS(MU2.bwG()) && t.kS(MU2.bwJ()))) {
                                    e.a(this.onG.aLx(), MU2);
                                    return;
                                } else {
                                    com.tencent.mm.modelfriend.b iB = ah.FL().iB(MU2.bwG());
                                    if (iB == null || iB.EB() == null || iB.EB().length() <= 0) {
                                        iB = ah.FL().iB(MU2.bwJ());
                                        if (iB == null || iB.EB() == null || iB.EB().length() <= 0) {
                                            if (LX4 == null || LX4.tS() <= 0) {
                                                e.a(this.onG.aLx(), MU2);
                                            } else {
                                                e.a(this.onG.aLx(), LX4, MU2);
                                            }
                                            v.e("MicroMsg.ChattingListClickListener", "error : this is not the mobile contact, MD5 = " + MU2.bwG() + " fullMD5:" + MU2.bwJ());
                                            return;
                                        }
                                    }
                                    if (iB.getUsername() == null || iB.getUsername().length() <= 0) {
                                        iB.username = MU2.bwE();
                                        iB.bkU = FileUtils.S_IWUSR;
                                        if (ah.FL().a(iB.EB(), iB) == -1) {
                                            v.e("MicroMsg.ChattingListClickListener", "update mobile contact username failed");
                                            return;
                                        }
                                    }
                                    e.a(this.onG.aLx(), MU2);
                                    return;
                                }
                            }
                            return;
                        } else if (atVar2.bwn() || atVar2.bwo()) {
                            com.tencent.mm.modelstat.b.daJ.s(dlVar.bmk);
                            com.tencent.mm.modelstat.a.a(dlVar.bmk, com.tencent.mm.modelstat.a.a.Click);
                            if (2 != dlVar.eKg) {
                                at atVar5 = dlVar.bmk;
                                if (atVar5.pL() == 0) {
                                    atVar2 = dlVar.bmk;
                                    com.tencent.mm.as.n lp = p.lp(atVar2.pP());
                                    v.i("MicroMsg.ChattingListClickListener", "videoReceiverEvent video status:" + lp.getStatus() + " is sender:" + atVar2.pL());
                                    switch (dlVar.eKg) {
                                        case 3:
                                            h(lp);
                                            break;
                                        case 4:
                                            ak.yW();
                                            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                                                s.ey(this.onG.aLx());
                                                break;
                                            } else {
                                                p.lm(atVar2.pP());
                                                break;
                                            }
                                    }
                                }
                                if (atVar5.pL() == 1) {
                                    atVar5 = dlVar.bmk;
                                    com.tencent.mm.as.n kZ = com.tencent.mm.as.k.KV().kZ(atVar5.pP());
                                    int status = kZ.getStatus();
                                    v.i("MicroMsg.ChattingListClickListener", " videoSendEvent status : " + status);
                                    switch (dlVar.eKg) {
                                        case 3:
                                            ak.yW();
                                            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                                                s.ey(this.onG.aLx());
                                                return;
                                            } else if (status == MMGIFException.D_GIF_ERR_EOF_TOO_SOON) {
                                                v.i("MicroMsg.ChattingListClickListener", "this video come from pc weixin, user restart now.");
                                                h(kZ);
                                                return;
                                            } else {
                                                atVar5.bww();
                                                ak.yW();
                                                com.tencent.mm.model.c.wJ().a(atVar5.pJ(), atVar5);
                                                if (kZ.getStatus() == 198) {
                                                    p.lo(atVar5.pP());
                                                    return;
                                                } else {
                                                    p.lk(atVar5.pP());
                                                    return;
                                                }
                                            }
                                        case 4:
                                            ak.yW();
                                            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                                                s.ey(this.onG.aLx());
                                                return;
                                            } else if (status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                                                v.i("MicroMsg.ChattingListClickListener", "this video come from pc weixin, user pause recv now.");
                                                p.lm(atVar5.pP());
                                                return;
                                            } else {
                                                r0 = atVar5.pP();
                                                kZ = p.lp(r0);
                                                if (kZ == null) {
                                                    v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " getinfo failed: " + r0);
                                                    com.tencent.mm.compatible.util.g.sk();
                                                } else if (kZ.getStatus() == MMGIFException.D_GIF_ERR_NO_SCRN_DSCR || kZ.getStatus() == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                                                    kZ.status = MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
                                                    kZ.dhI = be.Nh();
                                                    kZ.gw(1280);
                                                    if (!p.e(kZ)) {
                                                        v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " update failed: " + r0);
                                                        com.tencent.mm.compatible.util.g.sk();
                                                    }
                                                } else {
                                                    v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " get status failed: " + r0 + " status:" + kZ.getStatus());
                                                    com.tencent.mm.compatible.util.g.sk();
                                                }
                                                v.d("MicroMsg.ChattingListClickListener", "pause video, publish SendMsgFailEvent");
                                                b msVar = new ms();
                                                msVar.boc.aXd = atVar5;
                                                com.tencent.mm.sdk.c.a.nhr.z(msVar);
                                                return;
                                            }
                                        default:
                                            return;
                                    }
                                }
                                return;
                            } else if (com.tencent.mm.as.u.bj(this.onG.aLx()) || com.tencent.mm.ah.a.aT(this.onG.aLx())) {
                                v.i("MicroMsg.ChattingListClickListener", "Voip or multitalk is running, can't do this");
                                return;
                            } else {
                                atVar = dlVar.bmk;
                                int[] iArr2 = new int[2];
                                int i5 = 0;
                                i = 0;
                                if (view != null) {
                                    view.getLocationInWindow(iArr2);
                                    i5 = view.getWidth();
                                    i = view.getHeight();
                                }
                                long pJ = atVar.pJ();
                                long pK = atVar.pK();
                                str5 = dlVar.userName;
                                String str6 = dlVar.biB;
                                Intent intent6 = new Intent(this.onG.aLx(), ImageGalleryUI.class);
                                intent6.putExtra("show_search_chat_content_result", this.onG.onc);
                                intent6.putExtra("img_gallery_msg_id", pJ);
                                intent6.putExtra("key_is_biz_chat", this.onG.lKa);
                                intent6.putExtra("key_biz_chat_id", this.onG.bFS());
                                intent6.putExtra("img_gallery_msg_svr_id", pK);
                                intent6.putExtra("img_gallery_talker", str5);
                                intent6.putExtra("img_gallery_chatroom_name", str6);
                                intent6.putExtra("img_gallery_left", iArr2[0]);
                                intent6.putExtra("img_gallery_top", iArr2[1]);
                                intent6.putExtra("img_gallery_width", i5);
                                intent6.putExtra("img_gallery_height", i);
                                intent6.putExtra("img_gallery_enter_from_chatting_ui", this.onG.otW);
                                this.onG.startActivity(intent6);
                                this.onG.overridePendingTransition(0, 0);
                                if (atVar.bwo() && dlVar.userName != null) {
                                    a.a(a.a.EnterFullScreen, atVar);
                                    if (dlVar.userName.toLowerCase().endsWith("@chatroom")) {
                                        g.iuh.h(11444, Integer.valueOf(2));
                                        return;
                                    } else {
                                        g.iuh.h(11444, Integer.valueOf(1));
                                        return;
                                    }
                                }
                                return;
                            }
                        } else if (atVar2.bwp()) {
                            ak.yW();
                            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                com.tencent.mm.storage.a.c rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(dlVar.bmk.pP());
                                if (rg != null && !rg.bnk()) {
                                    intent = new Intent();
                                    intent.putExtra("custom_smiley_preview_md5", dlVar.bmk.pP());
                                    intent.putExtra("custom_to_talker_name", dlVar.bmk.pN());
                                    if (!(rg.bxK() == com.tencent.mm.storage.a.a.nwL || rg.bxK() == com.tencent.mm.storage.a.a.nwK || rg.bxK() == com.tencent.mm.storage.a.a.nwJ)) {
                                        intent.putExtra("custom_smiley_preview_productid", rg.field_groupId);
                                    }
                                    intent.putExtra("msg_id", dlVar.bmk.pK());
                                    intent.putExtra("msg_content", dlVar.bmk.pO());
                                    str = dlVar.bmk.pN();
                                    if (m.dE(str)) {
                                        r0 = aw.fL(dlVar.bmk.pO());
                                    } else {
                                        r0 = str;
                                    }
                                    intent.putExtra("msg_sender", r0);
                                    c.b(this.onG.aLx(), "emoji", ".ui.CustomSmileyPreviewUI", intent);
                                    g.iuh.h(11592, Integer.valueOf(0));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (atVar2.getType() == 48) {
                            at.b MV;
                            b hqVar;
                            atVar = dlVar.bmk;
                            str2 = atVar.pO();
                            Object obj2 = atVar.pL() == 0 ? 1 : null;
                            str = SQLiteDatabase.KeyEmpty;
                            if (obj2 != null) {
                                str = atVar.pN();
                            }
                            if (!(!m.dE(atVar.pN()) || obj2 == null || this.onG.lKa)) {
                                int fJ = aw.fJ(str2);
                                if (fJ != -1) {
                                    str = str2.substring(0, fJ).trim();
                                    r0 = str2.substring(fJ + 1).trim();
                                    ak.yW();
                                    MV = com.tencent.mm.model.c.wJ().MV(r0);
                                    if (!t.kS(str) && m.dE(str)) {
                                        str = SQLiteDatabase.KeyEmpty;
                                    }
                                    hqVar = new hq();
                                    hqVar.bhv.bhq = 1;
                                    hqVar.bhv.aXd = atVar;
                                    com.tencent.mm.sdk.c.a.nhr.z(hqVar);
                                    str4 = hqVar.bhw.bhy;
                                    if ((t.kS(hqVar.bhw.bhz) || !t.kS(str4)) && !"err_not_started".equals(str4)) {
                                        intent = new Intent();
                                        intent.putExtra("kMsgId", atVar.pJ());
                                        intent.putExtra("map_view_type", 1);
                                        intent.putExtra("kwebmap_slat", MV.bwM());
                                        intent.putExtra("kwebmap_lng", MV.bwN());
                                        intent.putExtra("kwebmap_scale", MV.bwO());
                                        intent.putExtra("kPoiName", MV.bwL());
                                        intent.putExtra("kisUsername", l.er(str));
                                        intent.putExtra("Kwebmap_locaion", str4);
                                        ak.yW();
                                        intent.putExtra("kimg_path", com.tencent.mm.model.c.wP());
                                        intent.putExtra("map_talker_name", atVar.pN());
                                        intent.putExtra("view_type_key", 0);
                                        intent.putExtra("kwebmap_from_to", true);
                                        intent.putExtra("kPoi_url", MV.lyO);
                                        intent.putExtra("soso_street_view_url", t.ah(atVar.pQ(), SQLiteDatabase.KeyEmpty));
                                        g.iuh.h(12809, Integer.valueOf(2), SQLiteDatabase.KeyEmpty);
                                        c.a(this.onG, "location", ".ui.RedirectUI", intent, (int) MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
                                        return;
                                    }
                                    v.e("MicroMsg.ChattingListClickListener", "location not valid or subcore not started");
                                    return;
                                }
                            }
                            r0 = str2;
                            ak.yW();
                            MV = com.tencent.mm.model.c.wJ().MV(r0);
                            str = SQLiteDatabase.KeyEmpty;
                            hqVar = new hq();
                            hqVar.bhv.bhq = 1;
                            hqVar.bhv.aXd = atVar;
                            com.tencent.mm.sdk.c.a.nhr.z(hqVar);
                            str4 = hqVar.bhw.bhy;
                            if (t.kS(hqVar.bhw.bhz)) {
                                break;
                            }
                            intent = new Intent();
                            intent.putExtra("kMsgId", atVar.pJ());
                            intent.putExtra("map_view_type", 1);
                            intent.putExtra("kwebmap_slat", MV.bwM());
                            intent.putExtra("kwebmap_lng", MV.bwN());
                            intent.putExtra("kwebmap_scale", MV.bwO());
                            intent.putExtra("kPoiName", MV.bwL());
                            intent.putExtra("kisUsername", l.er(str));
                            intent.putExtra("Kwebmap_locaion", str4);
                            ak.yW();
                            intent.putExtra("kimg_path", com.tencent.mm.model.c.wP());
                            intent.putExtra("map_talker_name", atVar.pN());
                            intent.putExtra("view_type_key", 0);
                            intent.putExtra("kwebmap_from_to", true);
                            intent.putExtra("kPoi_url", MV.lyO);
                            intent.putExtra("soso_street_view_url", t.ah(atVar.pQ(), SQLiteDatabase.KeyEmpty));
                            g.iuh.h(12809, Integer.valueOf(2), SQLiteDatabase.KeyEmpty);
                            c.a(this.onG, "location", ".ui.RedirectUI", intent, (int) MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
                            return;
                        } else if (atVar2.bwf()) {
                            str = atVar2.pO();
                            b qiVar = new qi();
                            qiVar.brC.bdn = 1;
                            qiVar.brC.content = str;
                            com.tencent.mm.sdk.c.a.nhr.z(qiVar);
                            if ((qiVar.brD.type == 2 ? 1 : null) != null || atVar2.pO().equals(at.nvC)) {
                                c(dlVar);
                                return;
                            } else if (dB(atVar2.pO()) || atVar2.pO().equals(at.nvB)) {
                                e(dlVar);
                                return;
                            } else {
                                return;
                            }
                        } else if (atVar2.bwq()) {
                            b(dlVar);
                            return;
                        } else if (atVar2.bwe()) {
                            bEJ();
                            return;
                        } else if (atVar2.bws()) {
                            a(dlVar);
                            return;
                        } else {
                            v.e("MicroMsg.ChattingListClickListener", "uknown msg type");
                            return;
                        }
                    } else if (atVar2.bvY()) {
                        com.tencent.mm.modelstat.b.daJ.s(dlVar.bmk);
                        return;
                    } else {
                        return;
                    }
                }
                return;
        }
    }

    private void a(dl dlVar) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            this.onG.onh.oqd.b(dlVar.position, dlVar.bmk);
        } else {
            s.ey(this.onG.nDR.nEl);
        }
    }

    private static boolean dB(String str) {
        b qiVar = new qi();
        qiVar.brC.bdn = 1;
        qiVar.brC.content = str;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
        if (qiVar.brD.type == 3) {
            return true;
        }
        return false;
    }

    private void bEJ() {
        if (this.onG != null) {
            g.iuh.Y(10221, "1");
            Intent intent = new Intent();
            intent.addFlags(67108864);
            c.b(this.onG.nDR.nEl, "shake", ".ui.ShakeReportUI", intent);
        }
    }

    private void h(final com.tencent.mm.as.n nVar) {
        ak.yW();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            s.ey(this.onG.nDR.nEl);
        } else if (nVar.status == 198) {
            p.ln(nVar.getFileName());
        } else if (aa.bk(this.onG.nDR.nEl) || a.oqV) {
            s((long) nVar.dhL, nVar.getFileName());
        } else {
            a.oqV = true;
            com.tencent.mm.ui.base.g.a(this.onG.nDR.nEl, 2131235789, 2131231164, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ cq oqW;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oqW.s((long) nVar.dhL, nVar.getFileName());
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ cq oqW;

                {
                    this.oqW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    private void s(long j, String str) {
        this.onG.ey(j);
        p.ll(str);
    }

    private void b(dl dlVar) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            com.tencent.mm.pluginsdk.j.a.bmr().a(this.onG.nDR.nEl, dlVar.bmk);
            g.iuh.h(11592, Integer.valueOf(0));
        }
    }

    private void c(final dl dlVar) {
        if (!com.tencent.mm.ah.a.aT(this.onG.nDR.nEl)) {
            b qhVar = new qh();
            com.tencent.mm.sdk.c.a.nhr.z(qhVar);
            if (dlVar.bmk.field_talker.equals(qhVar.bry.bdo) || !(qhVar.bry.brA || qhVar.bry.brB)) {
                qhVar = new pd();
                qhVar.bqt.bqv = true;
                com.tencent.mm.sdk.c.a.nhr.z(qhVar);
                String str = qhVar.bqu.bqx;
                if (t.kS(str)) {
                    d(dlVar);
                    return;
                }
                v.v("MicroMsg.ChattingListClickListener", "Talkroom is on: " + str);
                com.tencent.mm.ui.base.g.b(this.onG.nDR.nEl, this.onG.nDR.nEl.getString(2131235616), SQLiteDatabase.KeyEmpty, this.onG.nDR.nEl.getString(2131231107), this.onG.nDR.nEl.getString(2131231010), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ cq oqW;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b pdVar = new pd();
                        pdVar.bqt.bqw = true;
                        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                        this.oqW.d(dlVar);
                        dialogInterface.dismiss();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ cq oqW;

                    {
                        this.oqW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            }
            Toast.makeText(this.onG.nDR.nEl, qhVar.bry.brz ? 2131231572 : 2131231573, 0).show();
            v.i("MicroMsg.ChattingListClickListener", "voip is running, can't do this");
        }
    }

    private void d(dl dlVar) {
        int i = 3;
        dlVar.bmk.dh(6);
        ak.yW();
        com.tencent.mm.model.c.wJ().a(dlVar.bmk.field_msgId, dlVar.bmk);
        this.onG.bFY();
        b qiVar = new qi();
        qiVar.brC.bdn = 5;
        qiVar.brC.bdo = dlVar.bmk.field_talker;
        qiVar.brC.context = this.onG.nDR.nEl;
        qiVar.brC.brx = 2;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
        g gVar = g.iuh;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(3);
        objArr[1] = Integer.valueOf(1);
        if (dlVar.bmk.bNo == null || dlVar.bmk.bNo.length() <= 0) {
            i = 1;
        }
        objArr[2] = Integer.valueOf(i);
        gVar.h(11033, objArr);
    }

    private void e(dl dlVar) {
        int i = 3;
        if (!com.tencent.mm.ah.a.aT(this.onG.nDR.nEl)) {
            b qhVar = new qh();
            com.tencent.mm.sdk.c.a.nhr.z(qhVar);
            if (dlVar.bmk.field_talker.equals(qhVar.bry.bdo) || !(qhVar.bry.brA || qhVar.bry.brB)) {
                dlVar.bmk.dh(6);
                ak.yW();
                com.tencent.mm.model.c.wJ().a(dlVar.bmk.field_msgId, dlVar.bmk);
                this.onG.bFY();
                qhVar = new qi();
                qhVar.brC.bdn = 5;
                qhVar.brC.bdo = dlVar.bmk.field_talker;
                qhVar.brC.context = this.onG.nDR.nEl;
                qhVar.brC.brx = 4;
                com.tencent.mm.sdk.c.a.nhr.z(qhVar);
                g gVar = g.iuh;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(3);
                objArr[1] = Integer.valueOf(2);
                if (dlVar.bmk.bNo == null || dlVar.bmk.bNo.length() <= 0) {
                    i = 1;
                }
                objArr[2] = Integer.valueOf(i);
                gVar.h(11033, objArr);
                return;
            }
            Toast.makeText(this.onG.nDR.nEl, qhVar.bry.brz ? 2131231572 : 2131231573, 0).show();
            v.i("MicroMsg.ChattingListClickListener", "voip is running, can't do this");
        }
    }

    private void a(long j, long j2, String str, String str2, int[] iArr, int i, int i2) {
        Intent intent = new Intent(this.onG.nDR.nEl, ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", j);
        intent.putExtra("show_search_chat_content_result", this.onG.onc);
        intent.putExtra("img_gallery_msg_svr_id", j2);
        intent.putExtra("key_is_biz_chat", this.onG.lKa);
        intent.putExtra("key_biz_chat_id", this.onG.bFS());
        intent.putExtra("img_gallery_talker", str);
        intent.putExtra("img_gallery_chatroom_name", str2);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_width", i);
        intent.putExtra("img_gallery_height", i2);
        intent.putExtra("img_gallery_enter_from_chatting_ui", this.onG.otW);
        intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.u.dW(str));
        this.onG.startActivity(intent);
        this.onG.overridePendingTransition(0, 0);
    }

    private void b(long j, long j2, String str, String str2, int[] iArr, int i, int i2) {
        Intent intent = new Intent(this.onG.nDR.nEl, ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", j);
        intent.putExtra("img_gallery_msg_svr_id", j2);
        intent.putExtra("show_search_chat_content_result", this.onG.onc);
        intent.putExtra("key_is_biz_chat", this.onG.lKa);
        intent.putExtra("key_biz_chat_id", this.onG.bFS());
        intent.putExtra("img_gallery_talker", str);
        intent.putExtra("img_gallery_chatroom_name", str2);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_width", i);
        intent.putExtra("img_gallery_height", i2);
        intent.putExtra("img_gallery_enter_from_chatting_ui", this.onG.otW);
        intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.u.dW(str));
        this.onG.startActivity(intent);
        this.onG.overridePendingTransition(0, 0);
    }
}
