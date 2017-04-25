package com.tencent.mm.plugin.favorite.c;

import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public final class a {

    private static class a implements Runnable {
        i fLP;

        public a(i iVar) {
            this.fLP = iVar;
        }

        public final void run() {
            List list = this.fLP.field_favProto.mtR;
            if (list.size() > 0) {
                boolean z = false;
                int size = list.size();
                v.i("MicroMsg.AddFavService", "run addfavservice copyrunable info.field_type = %d", new Object[]{Integer.valueOf(this.fLP.field_type)});
                pw pwVar;
                if (this.fLP.field_type == 18 && this.fLP.field_sourceType == 6) {
                    int i = 0;
                    while (i < size) {
                        boolean z2;
                        pwVar = (pw) list.get(i);
                        if (pwVar.msE && pwVar.msG) {
                            z2 = z;
                        } else {
                            z2 = true;
                        }
                        i++;
                        z = z2;
                    }
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        String aX;
                        String aY;
                        pwVar = (pw) list.get(i2);
                        if (be.kS(pwVar.luu)) {
                            pwVar.IJ(com.tencent.mm.plugin.favorite.b.v.aw(pwVar.toString(), this.fLP.field_type));
                        }
                        if (!(pwVar.msE && pwVar.msG)) {
                            z = true;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        String str = pwVar.msq;
                        if (FileOp.aR(str)) {
                            aX = g.aX(str);
                            aY = g.aY(str);
                            pwVar.IH(aX);
                            pwVar.II(aY);
                            pwVar.dQ(new File(str).length());
                            aX = com.tencent.mm.plugin.favorite.b.v.f(pwVar);
                            if (!str.equals(aX)) {
                                FileOp.p(str, aX);
                            }
                        } else {
                            v.i("MicroMsg.AddFavService", "copy file fail, type:%d, %s not exist!", new Object[]{Integer.valueOf(pwVar.aKG), str});
                        }
                        aX = pwVar.mss;
                        if (FileOp.aR(aX)) {
                            InputStream inputStream = null;
                            try {
                                inputStream = FileOp.openRead(aX);
                                aY = be.ma(g.a(inputStream, 4096));
                                long jP = FileOp.jP(aX);
                                String a = g.a(inputStream, 0, 256);
                                pwVar.IM(aY);
                                pwVar.IN(a);
                                pwVar.dR(jP);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e) {
                                    }
                                }
                            } catch (FileNotFoundException e2) {
                                v.e("MicroMsg.AddFavService", "FileOp thumbpath error !");
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e3) {
                                    }
                                }
                            } catch (Throwable th) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                            }
                            String g = com.tencent.mm.plugin.favorite.b.v.g(pwVar);
                            if (!aX.equals(g)) {
                                FileOp.p(aX, g);
                            }
                        } else {
                            v.i("MicroMsg.AddFavService", "copy thumb fail, %s not exist!", new Object[]{aX});
                        }
                        v.v("MicroMsg.AddFavService", "klem cul md5 and copy file, favLocalId:%d  time:%d", new Object[]{Long.valueOf(this.fLP.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
                ad.o(new Runnable(this) {
                    final /* synthetic */ a fMl;

                    public final void run() {
                        if (z) {
                            v.v("MicroMsg.AddFavService", "has data, check cdn now, type %d", new Object[]{Integer.valueOf(this.fMl.fLP.field_type)});
                            this.fMl.fLP.field_itemStatus = 1;
                            this.fMl.fLP.field_xml = i.b(this.fMl.fLP);
                            h.alu().c(this.fMl.fLP);
                            h.all().run();
                            return;
                        }
                        v.v("MicroMsg.AddFavService", "no data, send item now, type %d", new Object[]{Integer.valueOf(this.fMl.fLP.field_type)});
                        this.fMl.fLP.field_itemStatus = 9;
                        this.fMl.fLP.field_xml = i.b(this.fMl.fLP);
                        h.alu().c(this.fMl.fLP);
                        h.alk().run();
                    }
                });
            }
        }
    }

    public static void u(i iVar) {
        iVar.field_updateTime = System.currentTimeMillis();
        iVar.field_localId = System.currentTimeMillis();
        v(iVar);
        com.tencent.mm.plugin.favorite.b.v.r(iVar);
    }

    public static void v(i iVar) {
        com.tencent.mm.plugin.favorite.b.v.bF(iVar.field_localId);
        if (iVar.field_favProto.mtR.size() > 0) {
            e.a(new a(iVar), "AddFavService_copy");
            return;
        }
        iVar.field_itemStatus = 9;
        h.alu().c(iVar);
        h.alk().run();
    }
}
