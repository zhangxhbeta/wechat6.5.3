package com.tencent.mm.plugin.game.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.fr;
import com.tencent.mm.e.a.fs;
import com.tencent.mm.e.a.ft;
import com.tencent.mm.e.a.fu;
import com.tencent.mm.e.a.fv;
import com.tencent.mm.e.a.gi;
import com.tencent.mm.e.a.gj;
import com.tencent.mm.e.a.jn;
import com.tencent.mm.e.a.kg;
import com.tencent.mm.e.a.li;
import com.tencent.mm.e.a.lj;
import com.tencent.mm.e.a.ow;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.game.ui.GameCenterUI;
import com.tencent.mm.plugin.game.ui.GameDetailUI;
import com.tencent.mm.plugin.game.ui.GameLibraryUI;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.r;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.v.d.a;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class au implements ag {
    private static String gke = "";
    @SuppressLint({"UseSparseArrays"})
    static HashMap<Integer, c> gkf;
    private com.tencent.mm.sdk.c.c eOy = new com.tencent.mm.sdk.c.c<ow>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = ow.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ow owVar = (ow) bVar;
            if (owVar.bqh.bqi.equals(fu.class.getName())) {
                if (owVar.bqh.bdf == 1) {
                    this.gks.gko.bmH();
                } else {
                    this.gks.gko.unregister();
                }
            }
            return false;
        }
    };
    private bo.b fvh = new bo.b(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r1;
        }

        public final void a(a aVar) {
            n nVar;
            Object obj;
            n arq;
            au.asd();
            String a = m.a(aVar.czu.mbW);
            v.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[]{Long.valueOf(r0.mcb)});
            v.i("MicroMsg.GameMessageService", "Message content: %s" + a);
            if (be.kS(a)) {
                v.e("MicroMsg.GameMessageParser", "msg content is null");
                nVar = null;
            } else {
                Map q = bf.q(a, "sysmsg");
                if (q == null || q.size() == 0) {
                    v.e("MicroMsg.GameMessageParser", "Parse failed");
                    nVar = null;
                } else if ("gamecenter".equalsIgnoreCase((String) q.get(".sysmsg.$type"))) {
                    n nVar2 = new n();
                    nVar2.field_showInMsgList = true;
                    nVar2.field_msgId = System.currentTimeMillis();
                    nVar2.field_rawXML = a;
                    nVar2.field_msgType = be.getInt((String) q.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                    long j;
                    if (nVar2.field_msgType == 100) {
                        u.arB();
                        nVar2.field_gameMsgId = be.ah((String) q.get(".sysmsg.gamecenter.msg_id"), "");
                        nVar2.field_appId = (String) q.get(".sysmsg.gamecenter.appid");
                        nVar2.field_createTime = be.getLong((String) q.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        j = be.getLong((String) q.get(".sysmsg.gamecenter.time_info.expire_time"), 0);
                        if (j == 0) {
                            nVar2.field_expireTime = Long.MAX_VALUE;
                        } else {
                            nVar2.field_expireTime = j + be.getLong((String) q.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        }
                        nVar2.field_isHidden = be.getInt((String) q.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        nVar2.field_mergerId = be.ah((String) q.get(".sysmsg.gamecenter.merge_id"), "");
                        nVar2.field_weight = be.ah((String) q.get(".sysmsg.gamecenter.weight"), "");
                        u.c(q, nVar2);
                        nVar2.giA = be.getLong((String) q.get(".sysmsg.gamecenter.filter_flag"), 0);
                        nVar2.giB = be.getInt((String) q.get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                        nVar2.giC = be.ah((String) q.get(".sysmsg.gamecenter.float_layer.open_url"), "");
                        nVar2.gim = be.getInt((String) q.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) > 0;
                        nVar2.gin.giY = be.ah((String) q.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        if (be.kS((String) q.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url")) && be.kS((String) q.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"))) {
                            nVar2.gio = false;
                        } else {
                            nVar2.gio = true;
                        }
                    } else {
                        nVar2.field_gameMsgId = be.ah((String) q.get(".sysmsg.gamecenter.msg_id"), "");
                        nVar2.field_msgType = be.getInt((String) q.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                        if (nVar2.field_msgType == 0) {
                            nVar2.field_msgType = be.getInt((String) q.get(".sysmsg.gamecenter.$msgtype"), 0);
                        }
                        nVar2.field_appId = (String) q.get(".sysmsg.gamecenter.appinfo.appid");
                        nVar2.field_showInMsgList = !be.kS(p.q(q));
                        nVar2.field_createTime = be.getLong((String) q.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        j = be.getLong((String) q.get(".sysmsg.game_control_info.expiredtime"), 0);
                        if (j == 0) {
                            nVar2.field_expireTime = Long.MAX_VALUE;
                        } else {
                            nVar2.field_expireTime = j + be.getLong((String) q.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        }
                        nVar2.field_isHidden = be.getInt((String) q.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        nVar2.field_mergerId = be.ah((String) q.get(".sysmsg.gamecenter.merge_id"), "");
                        if (nVar2.field_msgType == 10) {
                            nVar2.field_weight = "6";
                        } else {
                            nVar2.field_weight = "2";
                        }
                        nVar2.giA = be.getLong((String) q.get(".sysmsg.game_control_info.filter_flag"), 0);
                        nVar2.giz = p.r(q);
                        nVar2.giB = be.getInt((String) q.get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                        nVar2.gio = be.getInt((String) q.get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) > 0;
                        nVar2.giC = be.ah((String) q.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
                        nVar2.giU = be.ah((String) q.get(".sysmsg.gamecenter.noticeid"), "");
                        nVar2.gin.gja = be.getInt((String) q.get(".sysmsg.gamecenter.badge_display_type"), 0);
                        nVar2.gim = nVar2.gin.gja > 0;
                        if ((nVar2.giz & 4) == 0) {
                            nVar2.gim = false;
                        }
                    }
                    if (nVar2.giB == 1) {
                        nVar2.field_showInMsgList = false;
                    }
                    nVar = nVar2;
                } else {
                    v.e("MicroMsg.GameMessageParser", "Type not matched");
                    nVar = null;
                }
            }
            v.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s", new Object[]{Integer.valueOf(nVar.field_msgType), nVar.field_appId, Long.valueOf(nVar.field_msgId)});
            if (nVar == null) {
                v.e("MicroMsg.GameMessageService", "msg is null");
                obj = null;
            } else {
                long j2;
                String str = nVar.field_gameMsgId;
                if (!be.kS(str)) {
                    int i = 0;
                    Cursor rawQuery = au.asc().rawQuery("select count(*) from GameRawMessage where gameMsgId = \"" + str + "\"", new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            i = rawQuery.getInt(0);
                        }
                        rawQuery.close();
                        if (i > 0) {
                            obj = 1;
                            if (obj == null) {
                                v.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[]{Long.valueOf(nVar.field_msgId)});
                                obj = null;
                            } else {
                                if ((nVar.field_expireTime > System.currentTimeMillis() / 1000 ? null : 1) != null) {
                                    v.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[]{Long.valueOf(nVar.field_msgId)});
                                    obj = null;
                                } else {
                                    j2 = nVar.giA;
                                    a = nVar.field_appId;
                                    if (j2 != 1) {
                                        if (be.kS(a) || !g.o(aa.getContext(), a)) {
                                        }
                                        obj = 1;
                                    } else {
                                        if (j2 == 2 && (be.kS(a) || g.o(aa.getContext(), a))) {
                                        }
                                        obj = 1;
                                    }
                                    if (obj != null) {
                                        v.e("MicroMsg.GameMessageService", "checkFilter failed,%s", new Object[]{Long.valueOf(nVar.field_msgId)});
                                        obj = null;
                                    } else {
                                        if (!be.kS(nVar.field_appId)) {
                                            am.bnA().Gx(nVar.field_appId);
                                        }
                                        if (nVar.field_msgType != 20) {
                                            arq = q.arq();
                                            if (arq == null) {
                                                arq = q.ars();
                                            }
                                            if (arq == null) {
                                                arq = q.aru();
                                            }
                                            if (arq == null || q.a(nVar, arq)) {
                                                if (nVar.gim) {
                                                    ak.yW();
                                                    com.tencent.mm.model.c.vf().a(t.a.nra, Long.valueOf(0));
                                                } else {
                                                    ak.yW();
                                                    com.tencent.mm.model.c.vf().a(t.a.nra, Long.valueOf(nVar.field_msgId));
                                                }
                                            }
                                            arq = q.arq();
                                            if (arq == null) {
                                                arq = q.ars();
                                            }
                                            if (arq == null) {
                                                arq = q.aru();
                                            }
                                            if (arq == null || q.a(nVar, arq)) {
                                                if (be.kS(nVar.giC)) {
                                                    ak.yW();
                                                    com.tencent.mm.model.c.vf().a(t.a.nre, Long.valueOf(nVar.field_msgId));
                                                } else {
                                                    q.art();
                                                }
                                            }
                                            arq = q.arq();
                                            if (arq == null) {
                                                arq = q.ars();
                                            }
                                            if (arq == null) {
                                                arq = q.aru();
                                            }
                                            if (arq == null || q.a(nVar, arq)) {
                                                if (nVar.gio) {
                                                    q.arv();
                                                } else {
                                                    ak.yW();
                                                    com.tencent.mm.model.c.vf().a(t.a.nrb, Long.valueOf(nVar.field_msgId));
                                                }
                                            }
                                            if (nVar.field_msgType == 4) {
                                                ak.yW();
                                                com.tencent.mm.model.c.vf().a(t.a.nrd, Long.valueOf(nVar.field_msgId));
                                            }
                                            if (!(nVar == null || be.kS(nVar.gin.giY))) {
                                                com.tencent.mm.plugin.game.e.c.uv(nVar.gin.giY);
                                            }
                                        }
                                        obj = 1;
                                    }
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    if (nVar.field_expireTime > System.currentTimeMillis() / 1000) {
                    }
                    if ((nVar.field_expireTime > System.currentTimeMillis() / 1000 ? null : 1) != null) {
                        j2 = nVar.giA;
                        a = nVar.field_appId;
                        obj = j2 != 1 ? null : null;
                        if (obj != null) {
                            if (be.kS(nVar.field_appId)) {
                                am.bnA().Gx(nVar.field_appId);
                            }
                            if (nVar.field_msgType != 20) {
                                arq = q.arq();
                                if (arq == null) {
                                    arq = q.ars();
                                }
                                if (arq == null) {
                                    arq = q.aru();
                                }
                                if (nVar.gim) {
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.nra, Long.valueOf(0));
                                } else {
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.nra, Long.valueOf(nVar.field_msgId));
                                }
                                arq = q.arq();
                                if (arq == null) {
                                    arq = q.ars();
                                }
                                if (arq == null) {
                                    arq = q.aru();
                                }
                                if (be.kS(nVar.giC)) {
                                    q.art();
                                } else {
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.nre, Long.valueOf(nVar.field_msgId));
                                }
                                arq = q.arq();
                                if (arq == null) {
                                    arq = q.ars();
                                }
                                if (arq == null) {
                                    arq = q.aru();
                                }
                                if (nVar.gio) {
                                    q.arv();
                                } else {
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.nrb, Long.valueOf(nVar.field_msgId));
                                }
                                if (nVar.field_msgType == 4) {
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.nrd, Long.valueOf(nVar.field_msgId));
                                }
                                com.tencent.mm.plugin.game.e.c.uv(nVar.gin.giY);
                            }
                            obj = 1;
                        } else {
                            v.e("MicroMsg.GameMessageService", "checkFilter failed,%s", new Object[]{Long.valueOf(nVar.field_msgId)});
                            obj = null;
                        }
                    } else {
                        v.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[]{Long.valueOf(nVar.field_msgId)});
                        obj = null;
                    }
                } else {
                    v.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[]{Long.valueOf(nVar.field_msgId)});
                    obj = null;
                }
            }
            if (obj != null) {
                if (nVar.field_msgType == 20) {
                    arq = au.asc().ue(nVar.field_appId);
                    if (arq != null) {
                        au.asc().c(arq, new String[0]);
                        v.i("MicroMsg.GameMessageService", "duplicated appId, type = %d, appId = %s, msgId = %s", new Object[]{Integer.valueOf(arq.field_msgType), arq.field_appId, Long.valueOf(arq.field_msgId)});
                    }
                }
                q.g(nVar);
                v.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[]{Boolean.valueOf(au.asc().b(nVar))});
                if (au.asc().b(nVar)) {
                    int i2 = nVar.field_msgType;
                    if (nVar.field_msgType == 100) {
                        i2 = nVar.giT;
                    }
                    af.a(aa.getContext(), 0, 0, 0, 18, 0, nVar.field_appId, 0, i2, nVar.field_gameMsgId, nVar.giU, af.bH("resource", String.valueOf(nVar.gin.gja)));
                    if (nVar.field_msgType == 20) {
                        d.a(nVar);
                    }
                }
            }
        }
    };
    private r gjY;
    private q gjZ;
    private b gka;
    private ae gkb;
    private t gkc;
    private w gkd;
    private com.tencent.mm.sdk.c.c gkg = new com.tencent.mm.sdk.c.c<fs>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = fs.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            fs fsVar = (fs) bVar;
            i.a(fsVar.bfe.url, fsVar.bfe.aZy, BaseReportManager.MAX_READ_COUNT, fsVar.bfe.appId, fsVar.bfe.extInfo);
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gkh = new com.tencent.mm.sdk.c.c<kg>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = kg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z;
            String str;
            kg kgVar = (kg) bVar;
            if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                v.i("MicroMsg.GameWifiStrategy", "WifiStrategy:isInWifi");
            } else {
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                int i = gregorianCalendar.get(11);
                gregorianCalendar.get(12);
                int i2 = i >= 21 ? 3 : i < 12 ? 0 : i < 14 ? 1 : i < 18 ? 0 : 2;
                v.i("MicroMsg.GameWifiStrategy", "WifiStrategy:inWhichTimeRange = " + i2);
                if (i2 == 0) {
                    z = true;
                } else if (i2 != 3) {
                    if (i2 == 1) {
                        v.i("MicroMsg.GameWifiStrategy", "WifiStrategy:randomHide p = %s, randomNum = %s", new Object[]{Integer.valueOf(((((new GregorianCalendar().get(11) - 12) << 1) + 1) * 10) + 50), Integer.valueOf(be.cW(100, 0))});
                        if (((((new GregorianCalendar().get(11) - 12) << 1) + 1) * 10) + 50 <= be.cW(100, 0)) {
                            z = true;
                        }
                    } else {
                        gregorianCalendar = new GregorianCalendar();
                        v.i("MicroMsg.GameWifiStrategy", "WifiStrategy:randomHide p = %s, randomNum = %s", new Object[]{Integer.valueOf((((gregorianCalendar.get(12) > 30 ? 1 : 0) + (gregorianCalendar.get(11) - 18)) * 10) + 50), Integer.valueOf(be.cW(100, 0))});
                        if ((((gregorianCalendar.get(12) > 30 ? 1 : 0) + (gregorianCalendar.get(11) - 18)) * 10) + 50 <= be.cW(100, 0)) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    au.asc().dF("GameRawMessage", "update GameRawMessage set isHidden = 0 where isHidden = 1");
                }
                if (be.kS(kgVar.blk.content)) {
                    str = kgVar.blk.content;
                    if (str != null && str.startsWith("//gamemsg:")) {
                        new bm().mbW = m.lY(str.substring(10));
                        str = str.substring(10);
                        if (!be.kS(str)) {
                            if (str.equals("jumpnative")) {
                                Intent intent = new Intent();
                                intent.putExtra("from_find_more_friend", true);
                                com.tencent.mm.ay.c.b(aa.getContext(), "game", ".ui.GameCenterUI2", intent);
                            } else if (str.equals("jumpLibrary")) {
                                com.tencent.mm.ay.c.b(aa.getContext(), "game", ".ui.GameLibraryUI", new Intent());
                            } else if (str.contains("jumpDetail:")) {
                                str = str.substring(11, str.length());
                                Intent intent2 = new Intent();
                                intent2.putExtra("game_app_id", str);
                                com.tencent.mm.ay.c.b(aa.getContext(), "game", ".ui.GameDetailUI2", intent2);
                            }
                        }
                    }
                } else {
                    au.asd().a(kgVar);
                }
                return false;
            }
            z = false;
            if (z) {
                au.asc().dF("GameRawMessage", "update GameRawMessage set isHidden = 0 where isHidden = 1");
            }
            if (be.kS(kgVar.blk.content)) {
                str = kgVar.blk.content;
                new bm().mbW = m.lY(str.substring(10));
                str = str.substring(10);
                if (be.kS(str)) {
                    if (str.equals("jumpnative")) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("from_find_more_friend", true);
                        com.tencent.mm.ay.c.b(aa.getContext(), "game", ".ui.GameCenterUI2", intent3);
                    } else if (str.equals("jumpLibrary")) {
                        com.tencent.mm.ay.c.b(aa.getContext(), "game", ".ui.GameLibraryUI", new Intent());
                    } else if (str.contains("jumpDetail:")) {
                        str = str.substring(11, str.length());
                        Intent intent22 = new Intent();
                        intent22.putExtra("game_app_id", str);
                        com.tencent.mm.ay.c.b(aa.getContext(), "game", ".ui.GameDetailUI2", intent22);
                    }
                }
            } else {
                au.asd().a(kgVar);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gki = new com.tencent.mm.sdk.c.c<fq>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = fq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            fq fqVar = (fq) bVar;
            switch (fqVar.beY.actionCode) {
                case 1:
                    e.d(fqVar.beY.context, fqVar.beY.appId, fqVar.beY.messageAction, fqVar.beY.messageExt);
                    af.a(fqVar.beY.context, fqVar.beY.scene, fqVar.beY.scene, 1, 3, fqVar.beY.appId, 0, null);
                    break;
                case 2:
                    int i = fqVar.beY.scene;
                    v.i("MicroMsg.SubCoreGameCenter", "scene = %d, extinfo = %s", new Object[]{Integer.valueOf(i), fqVar.beY.beZ});
                    Bundle bundle = new Bundle();
                    bundle.putInt("game_report_from_scene", i);
                    bundle.putCharSequence("game_app_id", fqVar.beY.appId);
                    bundle.putCharSequence("game_report_extra_click_extinfo", r1);
                    af.a(fqVar.beY.context, fqVar.beY.scene, fqVar.beY.scene, 1, com.tencent.mm.plugin.game.e.c.a(fqVar.beY.context, fqVar.beY.appId, null, bundle), fqVar.beY.appId, 0, null);
                    break;
                case 3:
                    m.update();
                    break;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gkj = new com.tencent.mm.sdk.c.c<ft>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = ft.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return AnonymousClass18.b((ft) bVar);
        }

        private static boolean b(ft ftVar) {
            n nVar;
            switch (ftVar.bff.of) {
                case 1:
                    String str = ftVar.bff.bfh;
                    LinkedList linkedList = new LinkedList();
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int i = be.getInt(jSONObject.optString(Columns.TYPE), 0);
                            int i2 = be.getInt(jSONObject.optString("limit"), 0);
                            long j = be.getLong(jSONObject.optString("lastLocalId"), -1);
                            int i3 = be.getInt(jSONObject.optString("isUnread"), -1);
                            if (i2 > 0 && i2 <= 10000 && j >= 0 && i3 >= 0) {
                                Object a = au.asc().a(i, j, i3, i2);
                                if (!be.bP(a)) {
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator it = a.iterator();
                                    while (it.hasNext()) {
                                        nVar = (n) it.next();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("localId", nVar.field_msgId);
                                        jSONObject2.put("content", nVar.field_rawXML);
                                        jSONArray.put(jSONObject2);
                                    }
                                    ftVar.bfg.bfi = jSONArray.toString();
                                    break;
                                }
                            }
                        } catch (JSONException e) {
                            v.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
                            break;
                        }
                    }
                    break;
                case 2:
                    s.a(ftVar);
                    break;
                case 3:
                    au.asd();
                    nVar = q.aru();
                    if (nVar != null) {
                        ftVar.bfg.bfi = nVar.field_rawXML;
                        break;
                    }
                    break;
                case 4:
                    au.asd();
                    q.arv();
                    break;
                case 5:
                    au.asd();
                    ak.yW();
                    nVar = au.asc().bX(((Long) com.tencent.mm.model.c.vf().get(t.a.nrc, Long.valueOf(0))).longValue());
                    if (nVar == null || nVar.field_isHidden) {
                        nVar = null;
                    }
                    if (nVar != null) {
                        ftVar.bfg.bfi = nVar.field_rawXML;
                        break;
                    }
                    break;
                case 6:
                    au.asd();
                    ak.yW();
                    nVar = au.asc().bX(((Long) com.tencent.mm.model.c.vf().get(t.a.nrc, Long.valueOf(0))).longValue());
                    if (!(nVar == null || nVar.field_isHidden)) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(t.a.nrc, Long.valueOf(0));
                        break;
                    }
                case 9:
                    au.asd();
                    nVar = q.arw();
                    if (nVar != null) {
                        ftVar.bfg.bfi = nVar.field_rawXML;
                        break;
                    }
                    break;
                case 10:
                    au.asd();
                    q.arx();
                    break;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gkk = new com.tencent.mm.sdk.c.c<jn>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = jn.class.getName().hashCode();
        }

        private static boolean a(jn jnVar) {
            String optString;
            int i;
            JSONException e;
            Intent intent;
            Exception e2;
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject(jnVar.bjW.extraInfo);
                optString = jSONObject.optString("appId");
                try {
                    i = be.getInt(jSONObject.optString("ssid"), 0);
                } catch (JSONException e3) {
                    e = e3;
                    v.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
                    i = 0;
                    intent = new Intent();
                    switch (jnVar.bjW.bjX) {
                        case 0:
                            intent.setClass(jnVar.bjW.context, GameCenterUI.class);
                            if (jnVar.bjW.jumpType == 1) {
                                intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            jnVar.bjW.context.startActivity(intent);
                            af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                            break;
                        case 1:
                            intent.setClass(jnVar.bjW.context, GameLibraryUI.class);
                            if (jnVar.bjW.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            jnVar.bjW.context.startActivity(intent);
                            af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                            break;
                        case 2:
                            if (!be.kS(optString)) {
                                intent.setClass(jnVar.bjW.context, GameDetailUI.class);
                                intent.putExtra("game_app_id", optString);
                                if (jnVar.bjW.jumpType == 1) {
                                    intent.putExtra("jump_game_center", "jump_game_center");
                                }
                                intent.putExtra("game_report_from_scene", 5);
                                jnVar.bjW.context.startActivity(intent);
                                af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                                break;
                            }
                            break;
                        case 3:
                            intent.setClass(jnVar.bjW.context, GameMessageUI.class);
                            intent.putExtra("game_report_from_scene", 5);
                            jnVar.bjW.context.startActivity(intent);
                            af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                            break;
                    }
                    return false;
                } catch (Exception e4) {
                    e2 = e4;
                    v.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e2.getMessage()});
                    i = 0;
                    intent = new Intent();
                    switch (jnVar.bjW.bjX) {
                        case 0:
                            intent.setClass(jnVar.bjW.context, GameCenterUI.class);
                            if (jnVar.bjW.jumpType == 1) {
                                intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            jnVar.bjW.context.startActivity(intent);
                            af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                            break;
                        case 1:
                            intent.setClass(jnVar.bjW.context, GameLibraryUI.class);
                            if (jnVar.bjW.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            jnVar.bjW.context.startActivity(intent);
                            af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                            break;
                        case 2:
                            if (be.kS(optString)) {
                                intent.setClass(jnVar.bjW.context, GameDetailUI.class);
                                intent.putExtra("game_app_id", optString);
                                if (jnVar.bjW.jumpType == 1) {
                                    intent.putExtra("jump_game_center", "jump_game_center");
                                }
                                intent.putExtra("game_report_from_scene", 5);
                                jnVar.bjW.context.startActivity(intent);
                                af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                                break;
                            }
                            break;
                        case 3:
                            intent.setClass(jnVar.bjW.context, GameMessageUI.class);
                            intent.putExtra("game_report_from_scene", 5);
                            jnVar.bjW.context.startActivity(intent);
                            af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                            break;
                    }
                    return false;
                }
            } catch (JSONException e5) {
                JSONException jSONException = e5;
                optString = str;
                e = jSONException;
                v.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
                i = 0;
                intent = new Intent();
                switch (jnVar.bjW.bjX) {
                    case 0:
                        intent.setClass(jnVar.bjW.context, GameCenterUI.class);
                        if (jnVar.bjW.jumpType == 1) {
                            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        jnVar.bjW.context.startActivity(intent);
                        af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                        break;
                    case 1:
                        intent.setClass(jnVar.bjW.context, GameLibraryUI.class);
                        if (jnVar.bjW.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        jnVar.bjW.context.startActivity(intent);
                        af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                        break;
                    case 2:
                        if (be.kS(optString)) {
                            intent.setClass(jnVar.bjW.context, GameDetailUI.class);
                            intent.putExtra("game_app_id", optString);
                            if (jnVar.bjW.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            jnVar.bjW.context.startActivity(intent);
                            af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                            break;
                        }
                        break;
                    case 3:
                        intent.setClass(jnVar.bjW.context, GameMessageUI.class);
                        intent.putExtra("game_report_from_scene", 5);
                        jnVar.bjW.context.startActivity(intent);
                        af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                        break;
                }
                return false;
            } catch (Exception e6) {
                Exception exception = e6;
                optString = str;
                e2 = exception;
                v.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e2.getMessage()});
                i = 0;
                intent = new Intent();
                switch (jnVar.bjW.bjX) {
                    case 0:
                        intent.setClass(jnVar.bjW.context, GameCenterUI.class);
                        if (jnVar.bjW.jumpType == 1) {
                            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        jnVar.bjW.context.startActivity(intent);
                        af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                        break;
                    case 1:
                        intent.setClass(jnVar.bjW.context, GameLibraryUI.class);
                        if (jnVar.bjW.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        jnVar.bjW.context.startActivity(intent);
                        af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                        break;
                    case 2:
                        if (be.kS(optString)) {
                            intent.setClass(jnVar.bjW.context, GameDetailUI.class);
                            intent.putExtra("game_app_id", optString);
                            if (jnVar.bjW.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            jnVar.bjW.context.startActivity(intent);
                            af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                            break;
                        }
                        break;
                    case 3:
                        intent.setClass(jnVar.bjW.context, GameMessageUI.class);
                        intent.putExtra("game_report_from_scene", 5);
                        jnVar.bjW.context.startActivity(intent);
                        af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                        break;
                }
                return false;
            }
            intent = new Intent();
            switch (jnVar.bjW.bjX) {
                case 0:
                    intent.setClass(jnVar.bjW.context, GameCenterUI.class);
                    if (jnVar.bjW.jumpType == 1) {
                        intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    jnVar.bjW.context.startActivity(intent);
                    af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                    break;
                case 1:
                    intent.setClass(jnVar.bjW.context, GameLibraryUI.class);
                    if (jnVar.bjW.jumpType == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    jnVar.bjW.context.startActivity(intent);
                    af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                    break;
                case 2:
                    if (be.kS(optString)) {
                        intent.setClass(jnVar.bjW.context, GameDetailUI.class);
                        intent.putExtra("game_app_id", optString);
                        if (jnVar.bjW.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        jnVar.bjW.context.startActivity(intent);
                        af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                        break;
                    }
                    break;
                case 3:
                    intent.setClass(jnVar.bjW.context, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 5);
                    jnVar.bjW.context.startActivity(intent);
                    af.a(jnVar.bjW.context, 5, 5, 1, 6, i, null);
                    break;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gkl = new com.tencent.mm.sdk.c.c<li>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = li.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            li liVar = (li) bVar;
            af.a(aa.getContext(), liVar.bmF.scene, liVar.bmF.bmG, 1, liVar.bmF.action, 0, liVar.bmF.appId, 0, liVar.bmF.msgType, liVar.bmF.blm, liVar.bmF.bln, liVar.bmF.bmH);
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gkm = new com.tencent.mm.sdk.c.c<lj>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = lj.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            lj ljVar = (lj) bVar;
            af.a(ljVar.bmI.context, ljVar.bmI.bmJ, ljVar.bmI.packageName, ljVar.bmI.bhM, ljVar.bmI.msgType, ljVar.bmI.scene, ljVar.bmI.bmK, ljVar.bmI.mediaTagName, ljVar.bmI.bmL, ljVar.bmI.bmM);
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gkn = new com.tencent.mm.sdk.c.c<gi>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = gi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gi giVar = (gi) bVar;
            switch (giVar.bfS.of) {
                case 1:
                    Context context = giVar.bfS.context;
                    if (context != null) {
                        GameRegionPreference.a bS = e.bS(context);
                        if (bS != null) {
                            giVar.bfT.bfi = e.a(bS);
                            break;
                        }
                    }
                    break;
            }
            return false;
        }
    };
    d gko = new d(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r1;
        }

        public final b um(String str) {
            fu fuVar = new fu();
            fuVar.bfj.aXv = str;
            return fuVar;
        }

        public final com.tencent.mm.sdk.h.g asj() {
            return au.asc();
        }
    };
    private com.tencent.mm.sdk.c.c gkp = new com.tencent.mm.sdk.c.c<fr>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = fr.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            fr frVar = (fr) bVar;
            h.bfb = frVar.bfa.bfb;
            h.bfd = frVar.bfa.bfd;
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gkq = new com.tencent.mm.sdk.c.c<gj>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = gj.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            ((gj) bVar).bfU.bfb = h.bfb;
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gkr = new com.tencent.mm.sdk.c.c<fv>(this) {
        final /* synthetic */ au gks;

        {
            this.gks = r2;
            this.nhz = fv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            fv fvVar = (fv) bVar;
            switch (fvVar.bfk.opType) {
                case 2:
                    i.ark();
                    i.k(fvVar.bfk.appId, fvVar.bfk.bfl, fvVar.bfk.aZh);
                    break;
                default:
                    au.asf();
                    t.a(fvVar.bfk.appId, fvVar.bfk.opType, fvVar.bfk.bfl, fvVar.bfk.bfm, fvVar.bfk.aZh);
                    break;
            }
            return false;
        }
    };

    public au() {
        j.a.lxN = new r(this) {
            final /* synthetic */ au gks;

            {
                this.gks = r1;
            }

            public final boolean bY(Context context) {
                try {
                    v.v("MicroMsg.GameCenterLogic", "shouldShowGameEntrance, lang = %s", new Object[]{u.d(context.getSharedPreferences(aa.bti(), 0))});
                    v.i("MicroMsg.GameCenterLogic", "hide game center:[%s]", new Object[]{be.ah(com.tencent.mm.h.j.sU().getValue("HideGameCenter"), "zh_CN".equals(u.d(context.getSharedPreferences(aa.bti(), 0))) ? "0" : "1")});
                    return be.ah(com.tencent.mm.h.j.sU().getValue("HideGameCenter"), "zh_CN".equals(u.d(context.getSharedPreferences(aa.bti(), 0))) ? "0" : "1").equalsIgnoreCase("0");
                } catch (Exception e) {
                    return true;
                }
            }

            public final void a(String str, String str2, int i, int i2, String str3, int i3) {
                af.a(str, str2, i, i2, str3, i3);
            }

            public final void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
                af.a(context, str, str2, str3, i, str4, i2);
            }

            public final void a(String str, String str2, int i, int i2, String str3, long j) {
                af.a(str, str2, i, i2, str3, j);
            }

            public final void z(String str, int i, int i2) {
                af.e(str, 1, i, i2);
            }

            public final void F(String str, String str2, String str3) {
                af.F(str, str2, str3);
            }

            public final void m(Context context, String str, String str2) {
                af.m(context, str, str2);
            }

            public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5) {
                af.a(context, str, str2, str3, i, i2, i3, str4, 0, str5);
            }

            public final void bZ(Context context) {
                context.getSharedPreferences("game_center_pref", 0).edit().putString("notified_game_for_yyb_download_key", "").commit();
                context.getSharedPreferences("game_center_pref", 0).edit().putInt("total_notify_times_for_yyb_download_key", 0).commit();
                context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("delete_message_by_time_key", false).commit();
            }
        };
    }

    static {
        HashMap hashMap = new HashMap();
        gkf = hashMap;
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return r.cic;
            }
        });
        gkf.put(Integer.valueOf("GAME_CENTER_JSON_CACHE_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return l.cic;
            }
        });
        gkf.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return w.cic;
            }
        });
    }

    public static String asa() {
        return gke;
    }

    public static void ul(String str) {
        gke = str;
    }

    private static au asb() {
        au auVar = (au) ak.yP().fY("plugin.game");
        if (auVar != null) {
            return auVar;
        }
        auVar = new au();
        ak.yP().a("plugin.game", auVar);
        return auVar;
    }

    public static r asc() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (asb().gjY == null) {
            au asb = asb();
            ak.yW();
            asb.gjY = new r(com.tencent.mm.model.c.wE());
        }
        return asb().gjY;
    }

    public static q asd() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (asb().gjZ == null) {
            asb().gjZ = new q();
        }
        return asb().gjZ;
    }

    public static ae ase() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (asb().gkb == null) {
            asb().gkb = new ae();
        }
        return asb().gkb;
    }

    public static t asf() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (asb().gkc == null) {
            asb().gkc = new t();
        }
        return asb().gkc;
    }

    public static w asg() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (asb().gkd == null) {
            au asb = asb();
            ak.yW();
            asb.gkd = new w(com.tencent.mm.model.c.wE());
        }
        return asb().gkd;
    }

    public static com.tencent.mm.pluginsdk.model.app.d ash() {
        return am.ash();
    }

    public static b asi() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (asb().gka == null) {
            asb().gka = new b();
        }
        return asb().gka;
    }

    public final HashMap<Integer, c> ti() {
        return gkf;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        ak.yU().a("gamecenter", this.fvh, true);
        com.tencent.mm.sdk.c.a.nhr.e(this.gkg);
        com.tencent.mm.sdk.c.a.nhr.e(this.gkh);
        com.tencent.mm.sdk.c.a.nhr.e(this.eOy);
        com.tencent.mm.sdk.c.a.nhr.e(this.gki);
        com.tencent.mm.sdk.c.a.nhr.e(this.gkj);
        com.tencent.mm.sdk.c.a.nhr.e(this.gkk);
        com.tencent.mm.sdk.c.a.nhr.e(this.gkl);
        com.tencent.mm.sdk.c.a.nhr.e(this.gkm);
        com.tencent.mm.sdk.c.a.nhr.e(this.gkp);
        com.tencent.mm.sdk.c.a.nhr.e(this.gkq);
        com.tencent.mm.sdk.c.a.nhr.e(this.gkn);
        com.tencent.mm.sdk.c.a.nhr.e(this.gkr);
        com.tencent.mm.plugin.game.b.a aVar = new com.tencent.mm.plugin.game.b.a();
        p.a(aVar);
        aVar.create();
        com.tencent.mm.plugin.game.b.b bVar = new com.tencent.mm.plugin.game.b.b();
        p.a(5, bVar);
        bVar.create();
        e.a(new com.tencent.mm.plugin.game.ui.a.d());
        e.a(new com.tencent.mm.plugin.game.ui.a.b());
        i.are();
        d.are();
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        ak.yU().b("gamecenter", this.fvh, true);
        com.tencent.mm.sdk.c.a.nhr.f(this.gkg);
        com.tencent.mm.sdk.c.a.nhr.f(this.gkh);
        com.tencent.mm.sdk.c.a.nhr.f(this.eOy);
        com.tencent.mm.sdk.c.a.nhr.f(this.gki);
        com.tencent.mm.sdk.c.a.nhr.f(this.gkj);
        com.tencent.mm.sdk.c.a.nhr.f(this.gkk);
        com.tencent.mm.sdk.c.a.nhr.f(this.gkl);
        com.tencent.mm.sdk.c.a.nhr.f(this.gkm);
        com.tencent.mm.sdk.c.a.nhr.f(this.gkp);
        com.tencent.mm.sdk.c.a.nhr.f(this.gkq);
        com.tencent.mm.sdk.c.a.nhr.f(this.gkn);
        com.tencent.mm.sdk.c.a.nhr.f(this.gkr);
        if (this.gkb != null) {
            ae aeVar = this.gkb;
            if (aeVar.gjQ != null) {
                aeVar.gjQ.clear();
            }
            ak.vy().b(427, aeVar);
        }
        if (this.gkc != null) {
            ak.vy().b(1223, this.gkc);
        }
        p.gc(16);
        p.gb(5);
        e.xZ(80);
        e.xZ(4144);
        i.arf();
        d.arf();
    }
}
