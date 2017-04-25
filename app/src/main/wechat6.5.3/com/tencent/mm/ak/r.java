package com.tencent.mm.ak;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.ak.j.b;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.alb;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class r implements e {
    f<Integer, Integer> cKb = new f(200);
    private final int cKg = 500;
    ah cKi = new ah(g.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ r cTP;

        {
            this.cTP = r1;
        }

        public final boolean oU() {
            v.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
            r rVar = this.cTP;
            long Ni = be.Ni();
            if (rVar.cxK && Ni - rVar.cxV > 10000) {
                rVar.cxK = false;
            }
            if (rVar.cxK) {
                v.d("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
            } else {
                j jVar = rVar.cTO;
                List arrayList = new ArrayList();
                Cursor rawQuery = jVar.cuX.rawQuery("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[]{"200"});
                if (rawQuery != null) {
                    int count = rawQuery.getCount();
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            rawQuery.moveToPosition(i);
                            b bVar = new b(0);
                            bVar.id = rawQuery.getInt(0);
                            bVar.cJZ = rawQuery.getLong(1);
                            bVar.cmdId = rawQuery.getInt(2);
                            bVar.buffer = rawQuery.getBlob(3);
                            bVar.cTC = rawQuery.getInt(4);
                            bVar.cTD = rawQuery.getLong(4);
                            bVar.cTE = rawQuery.getString(4);
                            bVar.cTF = rawQuery.getString(4);
                            arrayList.add(bVar);
                        }
                    }
                    rawQuery.close();
                }
                if (arrayList.size() == 0) {
                    v.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
                } else {
                    if (!rVar.cxK && arrayList.size() > 0) {
                        rVar.cxV = Ni;
                        rVar.cxK = true;
                        g.vx();
                        g.vv().cjC.a(new a(arrayList), 0);
                    }
                    v.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. ", Long.valueOf(rVar.cxV), Boolean.valueOf(rVar.cxK), Long.valueOf(System.currentTimeMillis() - Ni));
                }
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|pusherTry";
        }
    }, false);
    j cTO;
    boolean cxK = false;
    long cxV = 0;

    private class a extends ah {
        final /* synthetic */ r cTP;

        class AnonymousClass1 implements com.tencent.mm.sdk.platformtools.ah.a {
            private int cRn = 0;
            private int cTQ = 0;
            final /* synthetic */ r cTR;
            final /* synthetic */ List cTS;
            final /* synthetic */ LinkedList cTT;

            AnonymousClass1(r rVar, List list, LinkedList linkedList) {
                this.cTR = rVar;
                this.cTS = list;
                this.cTT = linkedList;
            }

            public final boolean oU() {
                int i = 0;
                int size = this.cTS.size();
                int size2 = this.cTT.size();
                int i2 = size < size2 ? size : size2;
                if (size != size2) {
                    v.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(i2), Integer.valueOf(this.cRn));
                }
                List arrayList = new ArrayList();
                if (this.cRn >= i2) {
                    this.cTR.cxK = false;
                    if (this.cTQ > 0) {
                        long j;
                        ah ahVar = this.cTR.cKi;
                        if (this.cTR.cKb.size() > 0) {
                            j = 500;
                        } else {
                            j = 0;
                        }
                        ahVar.ea(j);
                    }
                    return false;
                }
                size = this.cRn + 20;
                if (size > i2) {
                    size2 = i2;
                } else {
                    size2 = size;
                }
                while (this.cRn < size2) {
                    size = ((Integer) this.cTT.get(this.cRn)).intValue();
                    b bVar = (b) this.cTS.get(this.cRn);
                    int i3 = bVar.id;
                    v.d("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", Integer.valueOf(i3), Integer.valueOf(bVar.getCmdId()), Integer.valueOf(size));
                    if (size == 0) {
                        this.cTQ++;
                        arrayList.add(bVar);
                        this.cTR.cKb.remove(Integer.valueOf(i3));
                    } else if (size == -433) {
                        v.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", Integer.valueOf(i3), Integer.valueOf(bVar.getCmdId()));
                    } else {
                        Integer num = (Integer) this.cTR.cKb.get(Integer.valueOf(i3));
                        v.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", Integer.valueOf(i3), Long.valueOf(bVar.cJZ), num);
                        if (num == null) {
                            this.cTR.cKb.k(Integer.valueOf(i3), Integer.valueOf(1));
                        } else if (num.intValue() < 2) {
                            this.cTR.cKb.k(Integer.valueOf(i3), Integer.valueOf(num.intValue() + 1));
                        } else {
                            v.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", Integer.valueOf(i3), Long.valueOf(bVar.cJZ));
                            arrayList.add(bVar);
                        }
                    }
                    this.cRn++;
                }
                size = arrayList.size();
                if (size > 0) {
                    g.vx();
                    long er = g.vw().ckb.er(Thread.currentThread().getId());
                    while (i < size) {
                        this.cTR.cTO.a((b) arrayList.get(i));
                        i++;
                    }
                    g.vx();
                    g.vw().ckb.es(er);
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|RespHandler";
            }
        }

        public a(r rVar, List<b> list, LinkedList<Integer> linkedList) {
            this.cTP = rVar;
            super(g.vA().htb.getLooper(), new AnonymousClass1(rVar, list, linkedList), true);
        }
    }

    public r(j jVar) {
        this.cTO = jVar;
        g.vx();
        g.vv().cjC.a(681, (e) this);
    }

    public final void b(b bVar) {
        if (bVar != null) {
            String str = "MicroMsg.OplogService";
            String str2 = "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bVar.getCmdId());
            objArr[1] = Integer.valueOf(bVar.getBuffer() == null ? -1 : bVar.getBuffer().length);
            objArr[2] = be.bur();
            v.i(str, str2, objArr);
            bVar.cJZ = be.Ni();
            j jVar = this.cTO;
            if (bVar != null) {
                bVar.bkU = -1;
                ContentValues contentValues = new ContentValues();
                if ((bVar.bkU & 2) != 0) {
                    contentValues.put("inserTime", Long.valueOf(bVar.cJZ));
                }
                if ((bVar.bkU & 4) != 0) {
                    contentValues.put("cmdId", Integer.valueOf(bVar.getCmdId()));
                }
                if ((bVar.bkU & 8) != 0) {
                    contentValues.put("buffer", bVar.getBuffer());
                }
                if ((bVar.bkU & 16) != 0) {
                    contentValues.put("reserved1", Integer.valueOf(bVar.cTC));
                }
                if ((bVar.bkU & 32) != 0) {
                    contentValues.put("reserved2", Long.valueOf(bVar.cTD));
                }
                if ((bVar.bkU & 64) != 0) {
                    contentValues.put("reserved3", bVar.cTE);
                }
                if ((bVar.bkU & FileUtils.S_IWUSR) != 0) {
                    contentValues.put("reserved4", bVar.cTF);
                }
                int insert = (int) jVar.cuX.insert("oplog2", "id", contentValues);
                if (insert > 0) {
                    bVar.id = insert;
                }
            }
        } else {
            v.i("MicroMsg.OplogService", "summeroplog dealWith option null");
        }
        this.cKi.ea(0);
    }

    public final void c(b bVar) {
        g.vx();
        long er = g.vw().ckb.er(Thread.currentThread().getId());
        this.cTO.a(bVar);
        g.vx();
        g.vw().ckb.es(er);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 681) {
            if (i == 0 && i2 == 0 && ((a) kVar).cTn != null) {
                ald com_tencent_mm_protocal_c_ald = ((a) kVar).cTn.cTq.cTs;
                if (com_tencent_mm_protocal_c_ald.mcj != 0 || com_tencent_mm_protocal_c_ald.mLY == null || com_tencent_mm_protocal_c_ald.mLY.mxR == null) {
                    v.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", Integer.valueOf(com_tencent_mm_protocal_c_ald.mcj));
                    this.cxK = false;
                    return;
                }
                com.tencent.mm.sdk.c.b jpVar = new jp();
                jpVar.bka.ret = ((Integer) com_tencent_mm_protocal_c_ald.mLY.mxR.getLast()).intValue();
                LinkedList linkedList = com_tencent_mm_protocal_c_ald.mLY.mLZ;
                jpVar.bka.bkb = linkedList.isEmpty() ? SQLiteDatabase.KeyEmpty : ((alb) linkedList.getLast()).aXz;
                jpVar.bka.bkc = linkedList.isEmpty() ? SQLiteDatabase.KeyEmpty : ((alb) linkedList.getLast()).hQP;
                com.tencent.mm.sdk.c.a.nhr.z(jpVar);
                new a(this, ((a) kVar).cTo, com_tencent_mm_protocal_c_ald.mLY.mxR).ea(50);
                return;
            }
            v.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", Integer.valueOf(i), Integer.valueOf(i2), ((a) kVar).cTn.toString());
            this.cxK = false;
        }
    }
}
