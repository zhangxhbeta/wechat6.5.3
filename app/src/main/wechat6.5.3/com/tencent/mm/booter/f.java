package com.tencent.mm.booter;

import com.tencent.mm.a.g;
import com.tencent.mm.a.n;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.ob;
import com.tencent.mm.modelmulti.c;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.protocal.ae;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public final class f {
    public static boolean a(int i, int i2, byte[] bArr, byte[] bArr2, long j) {
        v.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            D(2);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            switch (i2) {
                case 138:
                    D(bArr == null ? 7 : (long) n.c(bArr, 0));
                    break;
                case 268369921:
                    if (!be.bl(bArr) && bArr.length > 8) {
                        int c = n.c(bArr, 0);
                        int c2 = n.c(bArr, 4);
                        v.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + c + " bufLen:" + c2 + " dump:" + be.A(bArr, 8));
                        if (c2 == bArr.length - 8) {
                            Object obj = new byte[c2];
                            System.arraycopy(bArr, 8, obj, 0, c2);
                            d bVar = new b();
                            PByteArray pByteArray = new PByteArray();
                            PByteArray pByteArray2 = new PByteArray();
                            PInt pInt = new PInt();
                            try {
                                if (MMProtocalJni.unpack(pByteArray2, obj, bArr2, pByteArray, pInt, new PInt())) {
                                    if (pInt.value != -13) {
                                        c2 = bVar.y(pByteArray2.value);
                                        v.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
                                        bVar.lWU = c2;
                                        bVar.lWT = (long) obj.length;
                                        byte[] KG = be.KG(aa.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", SQLiteDatabase.KeyEmpty));
                                        byte[] a = m.a(bVar.lXt.mkF);
                                        if (!be.bl(a) && ae.j(KG, a)) {
                                            new c(bVar, c, j).a(z.Mx(), new e() {
                                                public final void a(int i, int i2, String str, k kVar) {
                                                    v.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
                                                }
                                            });
                                            break;
                                        }
                                        v.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
                                        break;
                                    }
                                    bVar.lWU = pInt.value;
                                    v.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
                                    break;
                                }
                                v.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
                                break;
                            } catch (Throwable e) {
                                v.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", e);
                                v.a("MicroMsg.NotifySyncMgr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                break;
                            }
                        }
                        v.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + bArr.length);
                        break;
                    }
                    v.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
                    break;
                    break;
                case 1000000205:
                    ab.b bVar2 = new ab.b();
                    try {
                        bVar2.y(bArr);
                        D(bVar2.lXy);
                        break;
                    } catch (Throwable e2) {
                        v.a("MicroMsg.NotifySyncMgr", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                        break;
                    }
                case 2147480001:
                    D(7);
                    break;
            }
            return true;
        }
    }

    private static void D(long j) {
        v.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = " + j);
        if ((256 & j) != 0) {
            a.nhr.z(new ob());
        }
        if (((-257 & j) & 2) != 0) {
            new c().a(z.Mx(), new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    v.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
                }
            });
        }
    }

    public static byte[] a(PInt pInt, int i) {
        String dy = dy(i);
        int cU = cU(dy);
        for (int i2 = 1; i2 <= cU; i2++) {
            String str = dy + "/syncResp.bin" + i2;
            if (com.tencent.mm.a.e.aR(str)) {
                byte[] d = com.tencent.mm.a.e.d(str, 0, -1);
                if (be.bl(d)) {
                    v.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
                    d = com.tencent.mm.a.e.d(str, 0, -1);
                }
                byte[] b = com.tencent.mm.a.k.b(d, g.m((p.rJ() + i).getBytes()).getBytes());
                v.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", Integer.valueOf(i2), Integer.valueOf(cU), v(d), v(b), v(r6.getBytes()));
                if (!be.bl(b)) {
                    pInt.value = i2;
                    return b;
                }
            }
        }
        return null;
    }

    public static void at(int i, int i2) {
        String dy = dy(i2);
        int cU = cU(dy);
        com.tencent.mm.loader.stub.b.deleteFile(dy + "/syncResp.bin" + i);
        v.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", Integer.valueOf(i), Integer.valueOf(cU));
        if (i == cU) {
            com.tencent.mm.loader.stub.b.deleteFile(dy + "/syncResp.ini");
            v.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
        }
    }

    public static int cU(String str) {
        int i = 0;
        byte[] d = com.tencent.mm.a.e.d(str + "/syncResp.ini", i, -1);
        if (!be.bl(d)) {
            try {
                i = Integer.parseInt(new String(d));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public static String dy(int i) {
        String str = t.cng + g.m(("mm" + i).getBytes()) + "/pushSyncResp";
        com.tencent.mm.a.e.aU(str);
        return str;
    }

    public static String v(byte[] bArr) {
        if (be.bl(bArr)) {
            return "buf is nullOrNil";
        }
        if (bArr.length == 1) {
            return "buf.len is 1: " + Integer.toHexString(bArr[0]);
        }
        return "buf last two[len:" + bArr.length + "]: %s, %s" + Integer.toHexString(bArr[bArr.length - 2] & WebView.NORMAL_MODE_ALPHA) + ", " + Integer.toHexString(bArr[bArr.length - 1] & WebView.NORMAL_MODE_ALPHA);
    }
}
