package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.google.a.a.e;
import com.tencent.mm.ah.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d.a;
import com.tencent.pb.common.b.a.a.aq;
import com.tencent.pb.common.b.a.a.aw;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    private Map<String, Long> hzD = new ConcurrentHashMap();

    final void a(String str, a aVar) {
        String a = m.a(aVar.czu.mbW);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + a + " buffer len " + decode.length);
        try {
            aw awVar = (aw) e.a(new aw(), decode, decode.length);
            if (awVar == null) {
                v.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:" + a);
            } else if (this.hzD.get(awVar.lEs) == null || ((Long) this.hzD.get(awVar.lEs)).longValue() < awVar.psM) {
                this.hzD.put(awVar.lEs, Long.valueOf(awVar.psM));
                bm bmVar = aVar.czu;
                String a2 = m.a(bmVar.mbU);
                String a3 = m.a(bmVar.mbV);
                ak.yW();
                String str2 = (String) c.vf().get(2, null);
                if (str2 == null) {
                    v.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
                    return;
                }
                String str3 = str2.equals(a2) ? a3 : a2;
                String str4 = awVar.psK;
                Object obj;
                String str5;
                Object obj2;
                if (awVar.psJ == 1) {
                    v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
                    String[] strArr = awVar.psL;
                    obj = null;
                    str5 = "";
                    for (aq aqVar : awVar.pre) {
                        str5 = str5 + aqVar.prp + ",";
                        if (aqVar.prp != null && aqVar.prp.equals(str2)) {
                            v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + str5);
                    obj2 = null;
                    for (String str6 : strArr) {
                        if (str6 != null && str6.equals(str2)) {
                            v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        o.aCI().wQ(str3);
                        o.aCI().aCr().remove(str3);
                    } else if (!(o.aCI().aCr().contains(str3) || r5 == null)) {
                        o.aCI().aCr().add(str3);
                    }
                    if (str2.equals(str4)) {
                        o.aCG().b(str3, str4, false, false);
                    } else if (obj != null && r5 == null) {
                        o.aCG().b(str3, str4, false, false);
                    } else if (obj == null || r5 == null) {
                        o.aCG().b(str3, str4, true, false);
                    } else {
                        o.aCG().b(str3, str4, true, true);
                    }
                    o.aCI().a(str3, awVar);
                    o.aCF().hyY.ay(be.f((Integer) ak.yT().get(1)), k.xF());
                } else if (awVar.psJ == 2) {
                    v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + awVar.pre.length);
                    String[] strArr2 = awVar.psL;
                    obj = null;
                    str5 = "";
                    for (aq aqVar2 : awVar.pre) {
                        str5 = str5 + aqVar2.prp + ",";
                        if (aqVar2.prp != null && aqVar2.prp.equals(str2)) {
                            v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + str5);
                    obj2 = null;
                    for (String str7 : strArr2) {
                        if (str7 != null && str7.equals(str2)) {
                            v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        if (!o.aCI().wR(str3) && o.aCI().aCr().contains(str3) && o.aCI().ce(str3, str2)) {
                            o.aCG();
                            e.wF(str3);
                        }
                        o.aCI().wQ(str3);
                        o.aCI().aCr().remove(str3);
                    } else if (!(o.aCI().aCr().contains(str3) || r5 == null)) {
                        o.aCI().aCr().add(str3);
                    }
                    g aCI = o.aCI();
                    v.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[]{str3});
                    b Rk = o.aCC().Rk(str3);
                    if (Rk == null) {
                        v.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
                        aCI.a(str3, awVar);
                    } else if (Rk.field_roomId != awVar.kty) {
                        v.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + Rk.field_roomId + "bannerinfo.roomid:" + awVar.kty);
                    } else if (g.c(str3, awVar)) {
                        aCI.wS(str3);
                    } else {
                        v.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
                    }
                } else if (awVar.psJ == 0) {
                    v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
                    if (!o.aCI().wR(str3) && o.aCI().aCr().contains(str3) && o.aCI().ce(str3, str2)) {
                        o.aCG();
                        e.wF(str3);
                    }
                    o.aCG();
                    at atVar = new at();
                    atVar.setType(64);
                    atVar.z(System.currentTimeMillis());
                    atVar.dh(6);
                    atVar.setContent(aa.getContext().getString(2131233954));
                    if (i.ef(str3)) {
                        atVar.cH(str3);
                        atVar.setContent(atVar.field_content);
                        ak.yW();
                        c.wJ().R(atVar);
                    }
                    o.aCI().wP(str3);
                    o.aCI().wQ(str3);
                    o.aCI().aCr().remove(str3);
                } else if (awVar.psJ == 3) {
                    for (aq aqVar3 : awVar.pre) {
                        if (aqVar3.prp != null && aqVar3.prp.equals(str2)) {
                            v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
                        }
                    }
                } else {
                    v.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + awVar.psJ);
                }
            } else {
                v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + awVar.lEs + " is early than last msg, so we do not process,now return.");
            }
        } catch (Exception e) {
            v.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:" + a, new Object[]{e.getMessage()});
        }
    }
}
