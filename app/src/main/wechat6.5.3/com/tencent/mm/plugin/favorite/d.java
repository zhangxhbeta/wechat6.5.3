package com.tencent.mm.plugin.favorite;

import android.widget.ImageView;
import com.tencent.mm.bd.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.ew;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<ew> {
    private x<Long, i> fJU;
    private g fJV;

    public d() {
        this.fJU = new x(10);
        this.nhz = ew.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ew ewVar = (ew) bVar;
        i iVar = null;
        if (ewVar.bdC.aZa != 0) {
            if (ewVar.bdC.bdJ) {
                iVar = h.alu().bB(ewVar.bdC.aZa);
                this.fJU.put(Long.valueOf(ewVar.bdC.aZa), iVar);
            } else {
                i iVar2 = (i) this.fJU.get(Long.valueOf(ewVar.bdC.aZa));
                String str = "MicroMsg.FavImageServiceListener";
                String str2 = "get item from cache %s";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(iVar2 == null);
                v.d(str, str2, objArr);
                if (iVar2 == null) {
                    iVar = h.alu().bB(ewVar.bdC.aZa);
                    this.fJU.put(Long.valueOf(ewVar.bdC.aZa), iVar);
                } else {
                    iVar = iVar2;
                }
            }
        }
        v.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[]{Integer.valueOf(ewVar.bdC.opType), Long.valueOf(ewVar.bdC.aZa)});
        if (iVar != null || ewVar.bdC.opType == 3 || ewVar.bdC.opType == 4) {
            switch (ewVar.bdC.opType) {
                case 0:
                    ewVar.bdD.bdK = g.a(ewVar.bdC.bdE, iVar);
                    break;
                case 1:
                    if (this.fJV != null) {
                        g gVar = this.fJV;
                        ImageView imageView = ewVar.bdC.bdF;
                        pw pwVar = ewVar.bdC.bdE;
                        int i = ewVar.bdC.bdG;
                        int i2 = ewVar.bdC.width;
                        int i3 = ewVar.bdC.height;
                        if (imageView != null) {
                            if (f.sj()) {
                                if (iVar != null && pwVar != null) {
                                    qe qeVar;
                                    switch (pwVar.aKG) {
                                        case 4:
                                        case am.CTRL_INDEX /*15*/:
                                            gVar.a(imageView, pwVar, iVar, pwVar.aZh, i, i2, i3);
                                            break;
                                        case 5:
                                            qp qpVar = null;
                                            if (pwVar.msM != null) {
                                                qpVar = pwVar.msM.mtc;
                                            } else {
                                                v.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{pwVar.luu, Long.valueOf(iVar.field_localId), Integer.valueOf(iVar.field_id)});
                                            }
                                            String str3 = qpVar == null ? null : qpVar.bea;
                                            if (be.kS(str3)) {
                                                str3 = pwVar.aZh;
                                            }
                                            gVar.a(imageView, pwVar, iVar, str3, i, i2, i3);
                                            break;
                                        case 7:
                                            gVar.a(imageView, pwVar, iVar, pwVar.aZh, i, i2, i3);
                                            break;
                                        case 10:
                                            if (pwVar.msM != null) {
                                                qeVar = pwVar.msM.mte;
                                                if (qeVar != null) {
                                                    gVar.fMC.a(imageView, null, qeVar.bea, i, i2, i3);
                                                    break;
                                                }
                                            }
                                            v.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{pwVar.luu, Long.valueOf(iVar.field_localId), Integer.valueOf(iVar.field_id)});
                                            break;
                                            break;
                                        case 11:
                                            if (pwVar.msM != null) {
                                                qeVar = pwVar.msM.mte;
                                                if (qeVar != null) {
                                                    gVar.fMC.a(imageView, null, qeVar.bea, i, i2, i3);
                                                    break;
                                                }
                                            }
                                            v.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{pwVar.luu, Long.valueOf(iVar.field_localId), Integer.valueOf(iVar.field_id)});
                                            break;
                                            break;
                                        case an.CTRL_INDEX /*14*/:
                                            if (pwVar.msM != null) {
                                                qj qjVar = pwVar.msM.mtg;
                                                if (qjVar != null) {
                                                    gVar.fMC.a(imageView, null, qjVar.bea, i, i2, i3);
                                                    break;
                                                }
                                            }
                                            v.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{pwVar.luu, Long.valueOf(iVar.field_localId), Integer.valueOf(iVar.field_id)});
                                            break;
                                            break;
                                        default:
                                            v.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[]{Integer.valueOf(iVar.field_type)});
                                            break;
                                    }
                                }
                                imageView.setImageDrawable(a.a(gVar.context, i));
                                break;
                            }
                            imageView.setImageResource(2130838791);
                            break;
                        }
                    }
                    v.w("MicroMsg.FavImageServiceListener", "imageServer is null");
                    break;
                    break;
                case 2:
                    v.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[]{Boolean.valueOf(ewVar.bdC.bdH)});
                    if (!ewVar.bdC.bdH) {
                        ewVar.bdD.bdK = g.b(ewVar.bdC.bdE, iVar, ewVar.bdC.maxWidth);
                        break;
                    }
                    ewVar.bdD.bdK = g.i(ewVar.bdC.bdE);
                    break;
                case 3:
                    v.d("MicroMsg.FavImageServiceListener", "create image server");
                    if (this.fJV != null) {
                        this.fJV.destory();
                    }
                    this.fJV = new g(ewVar.bdC.context, 16);
                    break;
                case 4:
                    v.d("MicroMsg.FavImageServiceListener", "destroy image server");
                    if (this.fJV != null) {
                        this.fJV.destory();
                        this.fJV = null;
                        break;
                    }
                    break;
            }
        }
        return false;
    }
}
