package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.a.fb;
import com.tencent.mm.e.a.ja;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wenote.b.b.AnonymousClass3;
import com.tencent.mm.plugin.wenote.b.d;
import com.tencent.mm.plugin.wenote.c.e;
import com.tencent.mm.plugin.wenote.c.f;
import com.tencent.mm.plugin.wenote.c.g;
import com.tencent.mm.plugin.wenote.c.h;
import com.tencent.mm.plugin.wenote.c.i;
import com.tencent.mm.plugin.wenote.c.l;
import com.tencent.mm.plugin.wenote.c.m;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class b extends c<ja> {
    public b() {
        this.nhz = ja.class.getName().hashCode();
    }

    private static boolean a(ja jaVar) {
        v.i("MicroMsg.NotifyWNNoteOperationListener", "on NotifyWNNoteWebviewOperationListener operation listener, %d", new Object[]{Integer.valueOf(jaVar.bjr.type)});
        com.tencent.mm.plugin.wenote.b.b cVar;
        Context context;
        switch (jaVar.bjr.type) {
            case 0:
                com.tencent.mm.plugin.wenote.b.b bmb = com.tencent.mm.plugin.wenote.c.b.bma().bmb();
                String str = jaVar.bjr.bjt;
                switch (((e) bmb.ltD.get(str)).type) {
                    case 2:
                        bmb.FP(str);
                        break;
                    case 3:
                        bmb.FO(str);
                        break;
                    case 4:
                        m mVar = (m) bmb.ltD.get(str);
                        ez ezVar = new ez();
                        ezVar.bdQ.type = 20;
                        ezVar.bdQ.title = mVar.bjG;
                        ezVar.bdQ.bdW = mVar.bdW;
                        ezVar.bdQ.bdX = mVar.bdX;
                        a.nhr.z(ezVar);
                        jb jbVar = new jb();
                        jbVar.bjB.type = 2;
                        jbVar.bjB.bjG = mVar.bjG;
                        jbVar.bjB.bdW = mVar.bdW;
                        jbVar.bjB.bdX = mVar.bdX;
                        a.nhr.z(jbVar);
                        break;
                    case 5:
                        bmb.FN(str);
                        break;
                    default:
                        break;
                }
            case 2:
                v.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
                cVar = new com.tencent.mm.plugin.wenote.b.c();
                com.tencent.mm.plugin.wenote.c.b.bma().lur = cVar;
                long j = jaVar.bjr.field_localId;
                context = jaVar.bjr.context;
                String str2 = jaVar.bjr.bjt;
                cVar.bjH = j;
                cVar.ltQ = str2;
                cVar.cS(context);
                ak.vA().x(new Runnable(cVar) {
                    final /* synthetic */ c ltT;

                    {
                        this.ltT = r1;
                    }

                    public final void run() {
                        f fVar;
                        c cVar = this.ltT;
                        long a = this.ltT.bjH;
                        fb fbVar = new fb();
                        fbVar.bek.aZa = a;
                        a.nhr.z(fbVar);
                        if (fbVar.bel.ret == 0) {
                            v.w("MicroMsg.WNNoteFavLogic", "can not fetch FavItem");
                            fVar = null;
                        } else {
                            v.d("MicroMsg.WNNoteFavLogic", "fetch favitem localId %s, itemStatus %d", new Object[]{Long.valueOf(fbVar.bek.aZa), Integer.valueOf(fbVar.bel.field_itemStatus)});
                            fVar = new f();
                            fVar.field_localId = fbVar.bek.aZa;
                            fVar.field_id = fbVar.bel.field_id;
                            fVar.field_fromUser = fbVar.bel.field_fromUser;
                            fVar.field_toUser = fbVar.bel.field_toUser;
                            fVar.field_favProto = fbVar.bel.field_favProto;
                            fVar.field_realChatName = fbVar.bel.field_realChatName;
                            fVar.field_type = fbVar.bel.field_type;
                            fVar.field_itemStatus = fbVar.bel.field_itemStatus;
                        }
                        cVar.ltR = fVar;
                        if (this.ltT.ltR != null) {
                            this.ltT.ltH = this.ltT.ltR.field_favProto;
                            g.bmc();
                            b.ltz = this.ltT.ltR;
                            if (c.ltS.containsKey(this.ltT.ltR)) {
                                this.ltT.lty = (com.tencent.mm.plugin.wenote.ui.a.a) c.ltS.get(this.ltT.ltR);
                            } else {
                                this.ltT.lty = new com.tencent.mm.plugin.wenote.ui.a.a();
                                this.ltT.lty.lvF = this.ltT.ltR;
                                this.ltT.lty.bjH = this.ltT.bjH;
                                this.ltT.lty.aKG = 1;
                                if (this.ltT.ltR != null && this.ltT.ltR.field_favProto != null) {
                                    this.ltT.lty.ipS = this.ltT.ltR.field_favProto.mtR;
                                    c.ltS.put(this.ltT.ltR, this.ltT.lty);
                                } else {
                                    return;
                                }
                            }
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 ltU;

                                {
                                    this.ltU = r1;
                                }

                                public final void run() {
                                    this.ltU.ltT.blW();
                                }
                            });
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|dealWNoteInfo";
                    }
                });
                break;
            case 3:
                jaVar.bjs.path = com.tencent.mm.bj.a.bLN();
                break;
            case 4:
                if (com.tencent.mm.plugin.wenote.c.b.bma().bmb() != null) {
                    cVar = com.tencent.mm.plugin.wenote.c.b.bma().bmb();
                    try {
                        JSONObject jSONObject = new JSONObject(jaVar.bjr.bju);
                        switch (jSONObject.getInt("type")) {
                            case 2:
                                h hVar = new h();
                                hVar.lut = jSONObject.getString("localEditorId");
                                hVar.type = jSONObject.getInt("type");
                                hVar.luw = jSONObject.getString("bigImagePath");
                                hVar.bjG = jSONObject.getString("localPath");
                                hVar.luv = true;
                                com.tencent.mm.plugin.wenote.b.b.ltB.put(hVar.lut, hVar);
                                cVar.ltD.put(hVar.lut, hVar);
                                break;
                            case 3:
                                i iVar = new i();
                                iVar.lut = jSONObject.getString("localEditorId");
                                iVar.type = jSONObject.getInt("type");
                                iVar.luv = true;
                                iVar.gUr = jSONObject.getString("poiName");
                                iVar.cJf = jSONObject.getString("address");
                                iVar.lat = jSONObject.getDouble("lat");
                                iVar.lng = jSONObject.getDouble("lng");
                                iVar.lux = (double) jSONObject.getInt("scale");
                                iVar.bjG = jSONObject.getString("localPath");
                                com.tencent.mm.plugin.wenote.b.b.ltB.put(iVar.lut, iVar);
                                cVar.ltD.put(iVar.lut, iVar);
                                break;
                            case 4:
                                m mVar2 = new m();
                                mVar2.lut = jSONObject.getString("localEditorId");
                                mVar2.type = jSONObject.getInt("type");
                                if (jSONObject.getBoolean("downloaded")) {
                                    mVar2.luy = jSONObject.getString("lengthStr");
                                    mVar2.bjG = jSONObject.getString("localPath");
                                    mVar2.bjJ = jSONObject.getString("iconPath");
                                    mVar2.length = jSONObject.getInt("length");
                                    mVar2.bdX = mVar2.length;
                                }
                                com.tencent.mm.plugin.wenote.b.b.ltB.put(mVar2.lut, mVar2);
                                cVar.ltD.put(mVar2.lut, mVar2);
                                break;
                            case 5:
                                l lVar = new l();
                                lVar.lut = jSONObject.getString("localEditorId");
                                lVar.type = jSONObject.getInt("type");
                                lVar.title = jSONObject.getString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                                lVar.content = jSONObject.getString("content");
                                lVar.bjJ = jSONObject.getString("iconPath");
                                lVar.bjG = jSONObject.getString("localPath");
                                com.tencent.mm.plugin.wenote.b.b.ltB.put(lVar.lut, lVar);
                                cVar.ltD.put(lVar.lut, lVar);
                                break;
                        }
                        ak.vA().x(new AnonymousClass3(cVar, jSONObject.getString("localEditorId")));
                        break;
                    } catch (Throwable e) {
                        v.a("MicroMsg.WNNoteBase", e, "", new Object[0]);
                        break;
                    }
                }
                break;
            case 5:
                com.tencent.mm.plugin.wenote.b.b.aB(jaVar.bjr.bjv, jaVar.bjr.bjw);
                break;
            case 6:
                Bundle bundle = jaVar.bjr.bjx;
                d dVar = new d();
                dVar.bhs = (float) bundle.getDouble("latitude");
                dVar.cNt = (float) bundle.getDouble("longtitude");
                dVar.bhu = bundle.getInt("scale");
                dVar.ltV = bundle.getString("loclabel");
                dVar.ltW = bundle.getString("locpoiname");
                dVar.ltX = bundle.getString("editorid");
                com.tencent.mm.plugin.wenote.d.b.a(dVar);
                break;
            case 7:
                switch (jaVar.bjr.bjy) {
                    case 2:
                        com.tencent.mm.plugin.wenote.b.e.U(jaVar.bjr.bjA);
                        break;
                    case 3:
                        try {
                            com.tencent.mm.plugin.wenote.b.e.FS(jaVar.bjr.bju);
                            break;
                        } catch (Throwable e2) {
                            v.a("MicroMsg.NotifyWNNoteOperationListener", e2, "", new Object[0]);
                            break;
                        }
                    case 4:
                        com.tencent.mm.plugin.wenote.b.e.h(jaVar.bjr.context, jaVar.bjr.path, jaVar.bjr.bjz);
                        break;
                    case 5:
                        com.tencent.mm.plugin.wenote.b.e.FR(jaVar.bjr.path);
                        break;
                    default:
                        break;
                }
            case 8:
                com.tencent.mm.plugin.wenote.b.e.aH(jaVar.bjr.context, jaVar.bjr.path);
                break;
            case NetStatusUtil.MOBILE /*9*/:
                v.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
                cVar = new com.tencent.mm.plugin.wenote.b.c();
                com.tencent.mm.plugin.wenote.c.b.bma().lur = cVar;
                context = jaVar.bjr.context;
                cVar.lsA = true;
                cVar.cS(context);
                break;
            case NetStatusUtil.LTE /*10*/:
                g.m(jaVar.bjr.field_localId, jaVar.bjr.path);
                break;
            case 11:
                g.V(jaVar.bjr.bjA);
                break;
        }
        return false;
    }
}
