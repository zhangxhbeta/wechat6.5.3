package com.tencent.mm.plugin.card.model;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.gc;
import com.tencent.mm.e.a.lu;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.a.h;
import com.tencent.mm.plugin.card.a.i;
import com.tencent.mm.plugin.card.a.j;
import com.tencent.mm.plugin.card.a.k;
import com.tencent.mm.plugin.card.a.l;
import com.tencent.mm.plugin.card.a.m;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.protocal.c.is;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class af implements ag {
    private static HashMap<Integer, c> bXq;
    private b eDJ;
    private c eDK;
    private ae eDL;
    private h eDM;
    private k eDN;
    private a eDO;
    private com.tencent.mm.plugin.card.sharecard.model.k eDP;
    private o eDQ;
    private com.tencent.mm.plugin.card.sharecard.a.c eDR;
    private i eDS = null;
    private e eDT = null;
    private j eDU = null;
    private d eDV = null;
    private g eDW = null;
    private com.tencent.mm.plugin.card.a.c eDX;
    private com.tencent.mm.sdk.c.c eDY = new l();
    private com.tencent.mm.sdk.c.c eDZ = new m();
    private com.tencent.mm.sdk.c.c eEa = new com.tencent.mm.plugin.card.a.a();
    private com.tencent.mm.sdk.c.c eEb = new com.tencent.mm.sdk.c.c<gc>(this) {
        final /* synthetic */ af eEf;

        {
            this.eEf = r2;
            this.nhz = gc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            final gc gcVar = (gc) bVar;
            v.i("MicroMsg.SubCoreCard.cardGetCountListener", "deal with card notify event GetCardCountEvent");
            if (gcVar instanceof gc) {
                this.eEf.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 eEh;

                    public final void run() {
                        if (ak.uz()) {
                            boolean z = gcVar.bfE.bfF;
                            v.i("MicroMsg.SubCoreCard.cardGetCountListener", "GetCardCountEvent isForceGet is " + z);
                            boolean acH = com.tencent.mm.plugin.card.b.j.acH();
                            boolean acJ = com.tencent.mm.plugin.card.b.j.acJ();
                            if (acH && acJ) {
                                v.i("MicroMsg.SubCoreCard.cardGetCountListener", "card entrance and share card entrance is open");
                                return;
                            }
                            if (z) {
                                ak.vy().a(new u(), 0);
                            } else {
                                int intValue;
                                ak.yW();
                                Integer num = (Integer) com.tencent.mm.model.c.vf().get(282882, null);
                                if (num != null) {
                                    intValue = num.intValue();
                                } else {
                                    intValue = 0;
                                }
                                if (((int) (System.currentTimeMillis() / 1000)) - intValue >= 7200) {
                                    ak.vy().a(new u(), 0);
                                }
                            }
                            if (acJ) {
                                ak.yW();
                                Long l = (Long) com.tencent.mm.model.c.vf().get(t.a.npM, Long.valueOf(0));
                                if (l != null && l.longValue() == 0) {
                                    af.aar().aay();
                                }
                            }
                            if (acH) {
                                ak.yW();
                                if (TextUtils.isEmpty((String) com.tencent.mm.model.c.vf().get(t.a.npC, null))) {
                                    af.aaj();
                                    b.iS(1);
                                }
                            }
                        }
                    }
                }, 10000);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c eEc = new com.tencent.mm.sdk.c.c<lu>(this) {
        final /* synthetic */ af eEf;

        {
            this.eEf = r2;
            this.nhz = lu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            v.i("MicroMsg.SubCoreCard.ResetCardRetryCounter", "deal with reset card retry counter event");
            ae aal = af.aal();
            v.d("MicroMsg.PendingCardIdInfoStorage", "resetRetryCounter");
            aal.cie.dF("PendingCardId", "update PendingCardId set retryCount = 0 where retryCount >= 10");
            return false;
        }
    };
    private bo.b eEd = new bo.b(this) {
        final /* synthetic */ af eEf;

        {
            this.eEf = r1;
        }

        public final void a(final com.tencent.mm.v.d.a aVar) {
            final String a = com.tencent.mm.platformtools.m.a(aVar.czu.mbW);
            if (a == null || a.length() == 0) {
                v.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
            } else {
                this.eEf.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 eEi;

                    public final void run() {
                        i aao = af.aao();
                        Object obj = a;
                        String str = aVar.czu.mcb;
                        v.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is " + str);
                        if (!TextUtils.isEmpty(obj)) {
                            g gVar;
                            String str2;
                            Map q = bf.q(obj, "sysmsg");
                            if (q == null) {
                                gVar = null;
                            } else {
                                g gVar2 = new g();
                                str2 = (String) q.get(".sysmsg.carditemmsg.card_type");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.j.qw(str2)) {
                                    gVar2.field_card_type = 0;
                                } else {
                                    gVar2.field_card_type = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_title = (String) q.get(".sysmsg.carditemmsg.title");
                                gVar2.field_description = (String) q.get(".sysmsg.carditemmsg.description");
                                gVar2.field_logo_url = (String) q.get(".sysmsg.carditemmsg.logo_url");
                                gVar2.field_logo_color = (String) q.get(".sysmsg.carditemmsg.logo_color");
                                str2 = (String) q.get(".sysmsg.carditemmsg.time");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.j.qw(str2)) {
                                    gVar2.field_time = (int) (System.currentTimeMillis() / 1000);
                                } else if (Long.valueOf(str2).longValue() >= 2147483647L) {
                                    gVar2.field_time = Integer.MAX_VALUE;
                                } else {
                                    gVar2.field_time = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_card_id = (String) q.get(".sysmsg.carditemmsg.card_id");
                                gVar2.field_card_tp_id = (String) q.get(".sysmsg.carditemmsg.card_tp_id");
                                gVar2.field_msg_id = (String) q.get(".sysmsg.carditemmsg.msg_id");
                                str2 = (String) q.get(".sysmsg.carditemmsg.msg_type");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.j.qw(str2)) {
                                    gVar2.field_msg_type = 0;
                                } else {
                                    gVar2.field_msg_type = Integer.valueOf(str2).intValue();
                                }
                                str2 = (String) q.get(".sysmsg.carditemmsg.jump_type");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.j.qw(str2)) {
                                    gVar2.field_jump_type = 1;
                                } else {
                                    gVar2.field_jump_type = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_url = (String) q.get(".sysmsg.carditemmsg.url");
                                str2 = (String) q.get(".sysmsg.carditemmsg.button.text");
                                if (!TextUtils.isEmpty(str2)) {
                                    is isVar = new is();
                                    isVar.text = str2;
                                    isVar.url = (String) q.get(".sysmsg.carditemmsg.button.url");
                                    str2 = (String) q.get(".sysmsg.carditemmsg.button.action_type");
                                    if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.j.qw(str2)) {
                                        isVar.eCZ = 0;
                                    } else {
                                        isVar.eCZ = Integer.valueOf(str2).intValue();
                                    }
                                    gVar2.eCQ = isVar;
                                    try {
                                        gVar2.field_buttonData = gVar2.eCQ.toByteArray();
                                    } catch (Throwable e) {
                                        v.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[]{e.getMessage()});
                                        v.a("MicroMsg.CardMsgInfo", e, "", new Object[0]);
                                    }
                                }
                                str2 = (String) q.get(".sysmsg.carditemmsg.opt_region.text");
                                if (!TextUtils.isEmpty(str2)) {
                                    iw iwVar = new iw();
                                    iwVar.text = str2;
                                    iwVar.url = (String) q.get(".sysmsg.carditemmsg.opt_region.url");
                                    str2 = (String) q.get(".sysmsg.carditemmsg.opt_region.type");
                                    if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.j.qw(str2)) {
                                        iwVar.type = 0;
                                    } else {
                                        iwVar.type = Integer.valueOf(str2).intValue();
                                    }
                                    str2 = (String) q.get(".sysmsg.carditemmsg.opt_region.endtime");
                                    if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.j.qw(str2)) {
                                        iwVar.iOT = (int) (System.currentTimeMillis() / 1000);
                                    } else if (Long.valueOf(str2).longValue() >= 2147483647L) {
                                        iwVar.iOT = Integer.MAX_VALUE;
                                    } else {
                                        iwVar.iOT = Integer.valueOf(str2).intValue();
                                    }
                                    gVar2.eCR = iwVar;
                                    try {
                                        gVar2.field_operData = gVar2.eCR.toByteArray();
                                    } catch (Throwable e2) {
                                        v.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", new Object[]{e2.getMessage()});
                                        v.a("MicroMsg.CardMsgInfo", e2, "", new Object[0]);
                                    }
                                }
                                str2 = (String) q.get(".sysmsg.carditemmsg.report_scene");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.j.qw(str2)) {
                                    gVar2.field_report_scene = 2;
                                } else {
                                    gVar2.field_report_scene = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_read_state = 1;
                                gVar2.field_accept_buttons = i.g(q, ".sysmsg.carditemmsg");
                                gVar2.field_jump_buttons = i.f(q, ".sysmsg.carditemmsg");
                                str2 = (String) q.get(".sysmsg.carditemmsg.get_layout_scene");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.j.qw(str2)) {
                                    gVar2.eCU = 0;
                                } else {
                                    gVar2.eCU = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_consumed_box_id = (String) q.get(".sysmsg.carditemmsg.consumed_box_id");
                                gVar2.eCK = (String) q.get(".sysmsg.carditemmsg.reddot_wording");
                                gVar2.eCL = (String) q.get(".sysmsg.carditemmsg.reddot_buff");
                                gVar2.eCM = (String) q.get(".sysmsg.carditemmsg.reddot_icon_url");
                                gVar2.eCN = (String) q.get(".sysmsg.carditemmsg.msg_tips.title");
                                gVar2.eCO = (String) q.get(".sysmsg.carditemmsg.msg_tips.icon_url");
                                str2 = (String) q.get(".sysmsg.carditemmsg.msg_scene");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.j.qw(str2)) {
                                    gVar2.eCV = 0;
                                } else {
                                    gVar2.eCV = Integer.valueOf(str2).intValue();
                                    v.i("MicroMsg.CardMsgManager", "msg_scene is " + str2);
                                }
                                str2 = (String) q.get(".sysmsg.carditemmsg.need_check");
                                v.i("MicroMsg.CardMsgManager", "need_check:" + str2);
                                if (TextUtils.isEmpty(str2)) {
                                    gVar2.eCP = false;
                                } else {
                                    gVar2.eCP = str2.equals("true");
                                }
                                gVar = gVar2;
                            }
                            if (gVar == null) {
                                v.e("MicroMsg.CardMsgManager", "card msg == null");
                                return;
                            }
                            if (TextUtils.isEmpty(gVar.field_card_id)) {
                                v.e("MicroMsg.CardMsgManager", "card id == null");
                            }
                            str2 = gVar.field_msg_id;
                            gVar.field_msg_id = str;
                            if (TextUtils.isEmpty(gVar.field_msg_id)) {
                                gVar.field_msg_id = str2;
                            }
                            if (TextUtils.isEmpty(gVar.field_msg_id)) {
                                gVar.field_msg_id = System.currentTimeMillis();
                            }
                            v.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + gVar.field_msg_id);
                            v.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + gVar.field_msg_type);
                            if (gVar.eCU != 0) {
                                ak.yW();
                                com.tencent.mm.model.c.vf().a(t.a.npJ, Integer.valueOf(gVar.eCU));
                            }
                            v.i("MicroMsg.CardMsgManager", "reddot_buff is " + gVar.eCL);
                            if (TextUtils.isEmpty(gVar.eCL)) {
                                v.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                            } else {
                                ak.yW();
                                com.tencent.mm.model.c.vf().a(t.a.npF, gVar.eCL);
                            }
                            if ((gVar.field_msg_type & 1) != 0) {
                                v.i("MicroMsg.CardMsgManager", "msg_tips_title is " + gVar.eCN);
                                v.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + gVar.eCO);
                                ak.yW();
                                com.tencent.mm.model.c.vf().a(t.a.npH, gVar.eCN);
                                ak.yW();
                                com.tencent.mm.model.c.vf().a(t.a.npI, gVar.eCO);
                            }
                            boolean ax = com.tencent.mm.p.c.us().ax(262152, 266256);
                            if (!(ax || (gVar.field_msg_type & 64) == 0)) {
                                com.tencent.mm.p.c.us().s(262152, true);
                                ax = true;
                            }
                            if (ax) {
                                v.i("MicroMsg.CardMsgManager", "has card new msg, return");
                            } else {
                                v.i("MicroMsg.CardMsgManager", "not has new!");
                                obj = null;
                                if ((gVar.field_msg_type & 32) != 0) {
                                    com.tencent.mm.p.c.us().t(262152, true);
                                    v.i("MicroMsg.CardMsgManager", "has reddot");
                                    obj = 1;
                                } else {
                                    v.e("MicroMsg.CardMsgManager", "not has reddot!");
                                }
                                Object obj2 = null;
                                if (TextUtils.isEmpty(gVar.eCK)) {
                                    v.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
                                } else {
                                    v.i("MicroMsg.CardMsgManager", "reddot_wording is " + gVar.eCK);
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.npD, gVar.eCK);
                                    com.tencent.mm.p.c.us().a(t.a.npx, true);
                                    obj2 = 1;
                                }
                                Object obj3 = null;
                                v.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + gVar.eCM);
                                if (TextUtils.isEmpty(gVar.eCM)) {
                                    v.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
                                } else {
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.npG, gVar.eCM);
                                    com.tencent.mm.p.c.us().a(t.a.npy, true);
                                    obj3 = 1;
                                }
                                if (obj == null || r1 == null || r2 == null) {
                                    if (obj != null && r1 != null && r2 == null) {
                                        com.tencent.mm.p.c.us().a(t.a.npy, false);
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().a(t.a.npG, "");
                                    } else if (obj != null && r1 == null && r2 != null) {
                                        com.tencent.mm.p.c.us().a(t.a.npx, false);
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().a(t.a.npD, "");
                                    } else if (obj == null && r1 != null && r2 != null) {
                                        com.tencent.mm.p.c.us().t(262152, false);
                                    } else if (obj != null && r1 == null && r2 == null) {
                                        com.tencent.mm.p.c.us().a(t.a.npy, false);
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().a(t.a.npG, "");
                                        com.tencent.mm.p.c.us().a(t.a.npx, false);
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().a(t.a.npD, "");
                                    } else if (obj == null && r1 != null && r2 == null) {
                                        com.tencent.mm.p.c.us().a(t.a.npy, false);
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().a(t.a.npG, "");
                                        com.tencent.mm.p.c.us().t(262152, false);
                                    } else if (obj == null && r1 == null && r2 != null) {
                                        com.tencent.mm.p.c.us().a(t.a.npx, false);
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().a(t.a.npD, "");
                                        com.tencent.mm.p.c.us().t(262152, false);
                                    }
                                }
                                if (!(obj == null && r1 == null && r2 == null)) {
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.npU, gVar.field_card_id);
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.npV, Boolean.valueOf(gVar.eCP));
                                    v.i("MicroMsg.CardMsgManager", "card_id:" + gVar.field_card_id + "  need_check:" + gVar.eCP);
                                }
                            }
                            if ((gVar.field_msg_type & 1) != 0) {
                                if (aao.pM(gVar.field_msg_id)) {
                                    v.e("MicroMsg.CardMsgManager", "msg for id " + gVar.field_msg_id + " is exist!!");
                                    aao.pN(gVar.field_msg_id);
                                    aao.eBB.add(gVar);
                                    i.b(gVar);
                                } else {
                                    aao.eBB.add(gVar);
                                    i.b(gVar);
                                    if ((gVar.field_msg_type & 128) != 0) {
                                        aao.eBC++;
                                    }
                                }
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(139268, Integer.valueOf(aao.eBC));
                                aao.a(gVar);
                            }
                            if ((gVar.field_msg_type & 2) != 0) {
                                af.aaj();
                                b.iS(gVar.eCU);
                            }
                            if ((gVar.field_msg_type & 4) != 0) {
                                aao.Yj();
                            }
                            if ((gVar.field_msg_type & 8) != 0) {
                                af.aaq().l(gVar.field_card_id, gVar.field_card_tp_id, gVar.field_report_scene);
                            }
                            com.tencent.mm.plugin.card.b.j.acG();
                        }
                    }
                });
            }
        }
    };
    private bo.b eEe = new bo.b(this) {
        final /* synthetic */ af eEf;

        {
            this.eEf = r1;
        }

        public final void a(final com.tencent.mm.v.d.a aVar) {
            final String a = com.tencent.mm.platformtools.m.a(aVar.czu.mbW);
            if (a == null || a.length() == 0) {
                v.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
            } else {
                this.eEf.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 eEj;

                    public final void run() {
                        com.tencent.mm.plugin.card.sharecard.a.c aau = af.aau();
                        Object obj = a;
                        v.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is " + (aVar.czu.mcb));
                        if (!TextUtils.isEmpty(obj)) {
                            com.tencent.mm.plugin.card.sharecard.a.c.a aVar;
                            Map q = bf.q(obj, "sysmsg");
                            if (q == null) {
                                aVar = null;
                            } else {
                                com.tencent.mm.plugin.card.sharecard.a.c.a aVar2 = new com.tencent.mm.plugin.card.sharecard.a.c.a(aau);
                                String str = (String) q.get(".sysmsg.notifysharecard.state_flag");
                                if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.b.j.qw(str)) {
                                    aVar2.eEu = 0;
                                } else {
                                    aVar2.eEu = Integer.valueOf(str).intValue();
                                }
                                aVar2.username = (String) q.get(".sysmsg.notifysharecard.username");
                                aVar2.bol = (String) q.get(".sysmsg.notifysharecard.card_id");
                                aVar = aVar2;
                            }
                            if (aVar == null) {
                                v.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                                return;
                            }
                            if (TextUtils.isEmpty(aVar.bol)) {
                                v.e("MicroMsg.ShareCardMsgMgr", "card id == null");
                            }
                            v.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + aVar.bol);
                            af.aar().aay();
                            com.tencent.mm.plugin.card.b.j.acI();
                        }
                    }
                });
            }
        }
    };
    private ac mHandler = new ac(Looper.getMainLooper());

    public af() {
        File file = new File(i.eDd);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(i.eDe);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private static af aai() {
        af afVar = (af) ak.yP().fY("plugin.card");
        if (afVar != null) {
            return afVar;
        }
        afVar = new af();
        ak.yP().a("plugin.card", afVar);
        return afVar;
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return c.cic;
            }
        });
        bXq.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return ae.cic;
            }
        });
        bXq.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return h.cic;
            }
        });
        bXq.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.plugin.card.sharecard.model.k.cic;
            }
        });
        bXq.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return o.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[]{Boolean.valueOf(z)});
        com.tencent.mm.sdk.c.a.nhr.e(this.eEb);
        com.tencent.mm.sdk.c.a.nhr.e(this.eEc);
        com.tencent.mm.sdk.c.a.nhr.e(this.eDY);
        com.tencent.mm.sdk.c.a.nhr.e(this.eDZ);
        com.tencent.mm.sdk.c.a.nhr.e(this.eEa);
        ak.yU().a("carditemmsg", this.eEd, true);
        ak.yU().a("notifysharecard", this.eEe, true);
        this.eDS = null;
        if (this.eDT != null) {
            this.eDT.eBj.clear();
            this.eDT = null;
        }
        if (this.eDN != null) {
            k kVar = this.eDN;
            synchronized (kVar.eBE) {
                kVar.eBE.clear();
            }
            synchronized (kVar.eBF) {
                kVar.eBF.clear();
            }
            ak.vy().b(563, kVar);
            com.tencent.mm.modelgeo.c FY = com.tencent.mm.modelgeo.c.FY();
            if (FY != null) {
                FY.c(kVar);
            }
            if (kVar.eBH != null) {
                ak.vy().c(kVar.eBH);
            }
            this.eDN = null;
        }
        if (this.eDJ != null) {
            this.eDJ.detach();
            this.eDJ = null;
        }
        if (this.eDO != null) {
            a aVar = this.eDO;
            synchronized (aVar.cGJ) {
                aVar.eAO.clear();
                aVar.eAP.clear();
            }
            if (aVar.eEk != null) {
                ak.vy().c(aVar.eEk);
            }
            ak.vy().b(903, aVar);
            this.eDO = null;
        }
        if (this.eDV != null) {
            this.eDV.release();
            d dVar = this.eDV;
            dVar.eAR.clear();
            dVar.eBd.clear();
            dVar.eBe.clear();
            dVar.eBf.clear();
            dVar.eBh = false;
            this.eDV = null;
        }
        if (this.eDW != null) {
            g gVar = this.eDW;
            ak.vy().b(907, gVar);
            Iterator it = gVar.eBp.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Runnable runnable = (Runnable) gVar.eBr.get(str);
                gVar.eBr.remove(str);
                gVar.eBq.removeCallbacks(runnable);
            }
            gVar.eBo.clear();
            gVar.eBp.clear();
            gVar.eBr.clear();
            this.eDW = null;
        }
        if (this.eDX != null) {
            this.eDX.release();
            this.eDX = null;
        }
        this.eDU = null;
        com.tencent.mm.pluginsdk.j.a.lxM = new h();
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        if (aai().eDJ != null) {
            aai().eDJ.detach();
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.eEb);
        com.tencent.mm.sdk.c.a.nhr.f(this.eEc);
        com.tencent.mm.sdk.c.a.nhr.f(this.eDY);
        com.tencent.mm.sdk.c.a.nhr.f(this.eDZ);
        com.tencent.mm.sdk.c.a.nhr.f(this.eEa);
        ak.yU().b("carditemmsg", this.eEd, true);
        ak.yU().b("notifysharecard", this.eEe, true);
        com.tencent.mm.pluginsdk.j.a.lxM = null;
    }

    public static b aaj() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDJ == null) {
            aai().eDJ = new b();
        }
        return aai().eDJ;
    }

    public static c aak() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDK == null) {
            af aai = aai();
            ak.yW();
            aai.eDK = new c(com.tencent.mm.model.c.wE());
        }
        return aai().eDK;
    }

    public static ae aal() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDL == null) {
            af aai = aai();
            ak.yW();
            aai.eDL = new ae(com.tencent.mm.model.c.wE());
        }
        return aai().eDL;
    }

    public static h aam() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDM == null) {
            af aai = aai();
            ak.yW();
            aai.eDM = new h(com.tencent.mm.model.c.wE());
        }
        return aai().eDM;
    }

    public static k aan() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDN == null) {
            aai().eDN = new k();
        }
        return aai().eDN;
    }

    public static i aao() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDS == null) {
            aai().eDS = new i();
        }
        return aai().eDS;
    }

    public static e aap() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDT == null) {
            aai().eDT = new e();
        }
        return aai().eDT;
    }

    public static j aaq() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDU == null) {
            aai().eDU = new j();
        }
        return aai().eDU;
    }

    public static a aar() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDO == null) {
            aai().eDO = new a();
        }
        return aai().eDO;
    }

    public static com.tencent.mm.plugin.card.sharecard.model.k aas() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDP == null) {
            af aai = aai();
            ak.yW();
            aai.eDP = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.model.c.wE());
        }
        return aai().eDP;
    }

    public static o aat() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDQ == null) {
            af aai = aai();
            ak.yW();
            aai.eDQ = new o(com.tencent.mm.model.c.wE());
        }
        return aai().eDQ;
    }

    public static com.tencent.mm.plugin.card.sharecard.a.c aau() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDR == null) {
            aai().eDR = new com.tencent.mm.plugin.card.sharecard.a.c();
        }
        return aai().eDR;
    }

    public static d aav() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDV == null) {
            aai().eDV = new d();
        }
        return aai().eDV;
    }

    public static g aaw() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDW == null) {
            aai().eDW = new g();
        }
        return aai().eDW;
    }

    public static com.tencent.mm.plugin.card.a.c aax() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aai().eDX == null) {
            aai().eDX = new com.tencent.mm.plugin.card.a.c();
        }
        return aai().eDX;
    }
}
