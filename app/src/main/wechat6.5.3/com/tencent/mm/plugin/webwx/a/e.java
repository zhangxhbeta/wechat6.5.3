package com.tencent.mm.plugin.webwx.a;

import android.content.Intent;
import com.tencent.mm.ar.l;
import com.tencent.mm.e.a.or;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.a.i;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class e implements d {
    public final b b(a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar != null && bmVar.gll == 51) {
            v.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[]{Integer.valueOf(bmVar.gll), Integer.valueOf(51)});
            String a = m.a(bmVar.mbV);
            if (!be.kS(a)) {
                String trim = m.a(bmVar.mbW).trim();
                Map q = bf.q(trim, "msg");
                if (q != null) {
                    int i = be.getInt((String) q.get(".msg.op.$id"), 0);
                    v.d("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[]{Integer.valueOf(i)});
                    if (i == 1 || i == 2 || i == 5) {
                        v.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = " + a);
                        com.tencent.mm.plugin.webwx.a.drp.cancelNotification(a);
                        if (com.tencent.mm.model.m.eH(a)) {
                            ak.yW();
                            c.vf().set(143618, Integer.valueOf(0));
                            l.KD().Kq();
                        } else {
                            v.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
                            ak.yW();
                            c.wK().Mj(a);
                            if (com.tencent.mm.model.m.dE(a)) {
                                ak.yW();
                                ab Mh = c.wK().Mh(a);
                                if (Mh != null && Mh.field_unReadCount > 0 && Mh.field_UnDeliverCount > 0) {
                                    v.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[]{a, Integer.valueOf(Mh.field_UnDeliverCount), Integer.valueOf(Mh.field_unReadCount)});
                                    com.tencent.mm.plugin.webwx.a.drq.bq(a);
                                    Mh.df(0);
                                    ak.yW();
                                    c.wK().a(Mh, a, true);
                                }
                            }
                        }
                    } else if (i == 3) {
                        ak.yW();
                        List bvK = c.wK().bvK();
                        StringBuilder stringBuilder = new StringBuilder();
                        int i2 = 0;
                        while (i2 < bvK.size()) {
                            stringBuilder.append(i2 > 0 ? "," : "");
                            stringBuilder.append((String) bvK.get(i2));
                            i2++;
                        }
                        ak.vy().a(new ae(stringBuilder.toString(), 4), 0);
                    } else if (i == 6) {
                        v.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                    } else if (i == 7) {
                        v.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        r3 = new Object[2];
                        ak.yW();
                        r3[0] = Integer.valueOf(c.wD());
                        r3[1] = Integer.valueOf(p.Jd());
                        v.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", r3);
                        a = be.ma((String) q.get(".msg.op.name")).trim();
                        r0 = be.ma((String) q.get(".msg.op.arg")).trim();
                        if ("WeixinStatus".equals(a)) {
                            ak.yW();
                            if (c.wD() == p.Jd() && p.cYI != null && p.cYI.trim().length() > 0) {
                                Intent intent = new Intent(aa.getContext(), WebWXLogoutUI.class);
                                intent.setFlags(603979776);
                                intent.addFlags(268435456);
                                intent.putExtra("intent.key.online_version", p.Jd());
                                aa.getContext().startActivity(intent);
                            }
                        } else if ("MomentsUnreadMsgStatus".equals(a)) {
                            r3 = new or();
                            r3.bpY.bdf = 7;
                            r3.bpY.bpZ = a;
                            r3.bpY.bqa = (long) be.getInt(r0, 0);
                            v.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[]{Integer.valueOf(r3.bpY.bdf), r3.bpY.bpZ, Long.valueOf(r3.bpY.bqa)});
                            com.tencent.mm.sdk.c.a.nhr.z(r3);
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            u.DJ();
                            i.f(i, a, r0);
                        }
                    } else if (i == 8) {
                        v.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        a = be.ma((String) q.get(".msg.op.name")).trim();
                        r0 = be.ma((String) q.get(".msg.op.arg")).trim();
                        if ("EnterpriseChatStatus".equals(a)) {
                            u.DJ();
                            i.f(i, a, r0);
                        } else {
                            or orVar = new or();
                            orVar.bpY.bdf = 8;
                            com.tencent.mm.sdk.c.a.nhr.z(orVar);
                        }
                    } else if (i == 9) {
                        v.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        a = be.ma((String) q.get(".msg.op.name")).trim();
                        r0 = be.ma((String) q.get(".msg.op.arg")).trim();
                        if ("MomentsTimelineStatus".equals(a)) {
                            String[] split = r0.split(",");
                            if (split.length == 2) {
                                r3 = new or();
                                r3.bpY.bdf = 9;
                                r3.bpY.bpZ = a;
                                r3.bpY.bqa = (long) be.getInt(split[1], 0);
                                r3.bpY.bqb = split[0];
                                com.tencent.mm.sdk.c.a.nhr.z(r3);
                            }
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            u.DJ();
                            i.f(i, a, r0);
                        }
                    } else if (i == 12) {
                        v.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock " + trim, new Object[]{Integer.valueOf(i)});
                        try {
                            if (q.get(".msg.op.arg") != null) {
                                r0 = new JSONObject((String) q.get(".msg.op.arg")).get("deviceName").toString();
                                if (p.Jc()) {
                                    Intent intent2 = new Intent(aa.getContext(), WebWXPopupUnlockUI.class);
                                    intent2.setFlags(872415232);
                                    intent2.putExtra("deviceName", r0);
                                    aa.getContext().startActivity(intent2);
                                }
                            } else {
                                v.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
                            }
                        } catch (JSONException e) {
                            v.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + e.getMessage());
                        }
                    } else {
                        v.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[]{Integer.valueOf(i)});
                    }
                }
            }
        }
        return null;
    }

    public final void d(at atVar) {
    }
}
