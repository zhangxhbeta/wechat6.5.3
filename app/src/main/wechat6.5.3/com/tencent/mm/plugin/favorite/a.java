package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.b.ad;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.ui.FavTipsUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public final class a extends c<bp> {
    public a() {
        this.nhz = bp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bp bpVar = (bp) bVar;
        i bB;
        LinkedList linkedList;
        aix com_tencent_mm_protocal_c_aix;
        if (-2 == bpVar.aZd.type) {
            long j = be.getLong(bpVar.aZd.aZh, -1);
            if (0 >= j) {
                v.w("MicroMsg.AddFavoriteItemListener", "error fav info local id");
            } else {
                bB = h.alu().bB(j);
                if (be.kS(bB.field_favProto.gxy)) {
                    g.iuh.h(10873, new Object[]{Integer.valueOf(6)});
                } else {
                    g.iuh.h(10874, new Object[]{Integer.valueOf(6)});
                }
                bB.field_favProto.Jk(bpVar.aZd.desc);
                h.alu().a(bB, "rowid");
                String str = bpVar.aZd.desc;
                if (bB == null) {
                    v.w("MicroMsg.ModFavItemLogic", "modRemark, item info is null");
                } else if (bB.field_id <= 0) {
                    v.w("MicroMsg.ModFavItemLogic", "modRemark favid:%d", new Object[]{Integer.valueOf(bB.field_id)});
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    linkedList = new LinkedList();
                    com_tencent_mm_protocal_c_aix = new aix();
                    com_tencent_mm_protocal_c_aix.mJs = 4;
                    com_tencent_mm_protocal_c_aix.mJt = 0;
                    linkedList.add(com_tencent_mm_protocal_c_aix);
                    LinkedList linkedList2 = new LinkedList();
                    aja com_tencent_mm_protocal_c_aja = new aja();
                    com_tencent_mm_protocal_c_aja.gmM = "favitem.remark";
                    com_tencent_mm_protocal_c_aja.itR = str;
                    linkedList2.add(com_tencent_mm_protocal_c_aja);
                    aja com_tencent_mm_protocal_c_aja2 = new aja();
                    com_tencent_mm_protocal_c_aja2.gmM = "favitem.remark";
                    com_tencent_mm_protocal_c_aja2.mJy = "time";
                    com_tencent_mm_protocal_c_aja2.itR = String.valueOf(currentTimeMillis);
                    linkedList2.add(com_tencent_mm_protocal_c_aja2);
                    ak.vy().a(new ad(bB.field_id, linkedList, linkedList2), 0);
                }
            }
        } else {
            bp.b bVar2 = bpVar.aZe;
            int i = 0;
            if (bpVar == null || bpVar.aZd == null || bpVar.aZd.aZf == null) {
                v.w("MicroMsg.AddFavService", "handleEvent error, event is null");
                if (bpVar.aZd.aZk == 0) {
                    bpVar.aZd.aZk = 2131232653;
                }
            }
            if (bpVar.aZd.aXH == null && bpVar.aZd.og == null) {
                v.i("MicroMsg.AddFavService", "handleEvent context = null && frament = null");
            }
            if (bpVar.aZd.aZk != 0) {
                i = bpVar.aZd.aZk;
            } else if (com.tencent.mm.plugin.favorite.b.v.kG(bpVar.aZd.type)) {
                ez ezVar = new ez();
                ezVar.bdQ.type = 36;
                com.tencent.mm.sdk.c.a.nhr.z(ezVar);
                if (ezVar.bdR.ret == 1) {
                    i = -2;
                }
            }
            ak.yW();
            if (((Integer) com.tencent.mm.model.c.vf().get(225281, Integer.valueOf(0))).intValue() != 1) {
                v.d("MicroMsg.AddFavService", "try show intro ui");
                Context context = bpVar.aZd.aXH;
                if (context == null) {
                    context = aa.getContext();
                }
                Intent intent = new Intent(context, FavTipsUI.class);
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
                ak.yW();
                com.tencent.mm.model.c.vf().set(225281, Integer.valueOf(1));
            }
            com.tencent.mm.pluginsdk.model.c.a(i, bpVar.aZd.aZl, bpVar.aZd.aXH, bpVar.aZd.og, bpVar.aZd.aZn, bpVar.aZd.aZm);
            v.i("MicroMsg.AddFavService", "err Type = %d", new Object[]{Integer.valueOf(i)});
            if (i == 0) {
                Object obj;
                i iVar = new i();
                iVar.field_favProto = bpVar.aZd.aZf;
                iVar.field_sessionId = bpVar.aZd.aZj;
                qg qgVar = iVar.field_favProto.mtP;
                if (qgVar != null) {
                    iVar.field_sourceId = qgVar.mtU;
                    if (iVar.field_sourceId == null || iVar.field_sourceId.equals("")) {
                        obj = null;
                    } else {
                        bB = h.alu().sQ(iVar.field_sourceId);
                        if (bB != null && bB.field_id > 0) {
                            int i2 = bB.field_id;
                            if (i2 <= 0) {
                                v.e("MicroMsg.ModFavItemLogic", "modUpdateTime favId illegal:%d", new Object[]{Integer.valueOf(i2)});
                            } else {
                                linkedList = new LinkedList();
                                com_tencent_mm_protocal_c_aix = new aix();
                                com_tencent_mm_protocal_c_aix.mJs = 1;
                                com_tencent_mm_protocal_c_aix.mJt = (int) (System.currentTimeMillis() / 1000);
                                linkedList.add(com_tencent_mm_protocal_c_aix);
                                ak.vy().a(new ad(i2, linkedList, null), 0);
                            }
                        }
                        obj = bB != null ? 1 : null;
                    }
                    if (obj != null) {
                        v.w("MicroMsg.AddFavService", "handleEvent, msg already exist, do not insert");
                        obj = null;
                        if (obj != null) {
                            bB = h.alu().sQ(iVar.field_sourceId);
                            if (bB != null) {
                                com.tencent.mm.plugin.favorite.b.v.bN(bB.field_localId);
                            }
                            i = 0;
                        } else {
                            iVar.field_flag = 0;
                            iVar.field_updateTime = System.currentTimeMillis();
                            iVar.field_localId = System.currentTimeMillis();
                            com.tencent.mm.plugin.favorite.b.v.bN(iVar.field_localId);
                            iVar.field_type = bpVar.aZd.type;
                            if (bpVar.aZd.desc != null || bpVar.aZd.desc.length() < 10001) {
                                iVar.field_favProto.Jm(bpVar.aZd.desc);
                            } else {
                                v.w("MicroMsg.AddFavService", "length more than 10000, do cut desc");
                                iVar.field_favProto.Jm(bpVar.aZd.desc.substring(0, 10001));
                            }
                            iVar.field_xml = i.b(iVar);
                            com.tencent.mm.plugin.favorite.c.a.v(iVar);
                            com.tencent.mm.plugin.favorite.b.v.r(iVar);
                            iVar.sN("MicroMsg.AddFavService");
                            i = 0;
                        }
                    } else {
                        iVar.field_fromUser = qgVar.bhM;
                        iVar.field_toUser = qgVar.toUser;
                        iVar.field_sourceType = qgVar.aYX;
                        iVar.field_sourceId = qgVar.mtU;
                        iVar.field_sourceCreateTime = qgVar.dhH;
                    }
                }
                v.i("MicroMsg.AddFavService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", new Object[]{iVar.field_fromUser, iVar.field_toUser, iVar.field_sourceId, Integer.valueOf(iVar.field_sourceType)});
                obj = 1;
                if (obj != null) {
                    iVar.field_flag = 0;
                    iVar.field_updateTime = System.currentTimeMillis();
                    iVar.field_localId = System.currentTimeMillis();
                    com.tencent.mm.plugin.favorite.b.v.bN(iVar.field_localId);
                    iVar.field_type = bpVar.aZd.type;
                    if (bpVar.aZd.desc != null) {
                    }
                    iVar.field_favProto.Jm(bpVar.aZd.desc);
                    iVar.field_xml = i.b(iVar);
                    com.tencent.mm.plugin.favorite.c.a.v(iVar);
                    com.tencent.mm.plugin.favorite.b.v.r(iVar);
                    iVar.sN("MicroMsg.AddFavService");
                    i = 0;
                } else {
                    bB = h.alu().sQ(iVar.field_sourceId);
                    if (bB != null) {
                        com.tencent.mm.plugin.favorite.b.v.bN(bB.field_localId);
                    }
                    i = 0;
                }
            }
            bVar2.ret = i;
        }
        return false;
    }
}
