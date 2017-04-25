package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class ae {
    public static byte[] i(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length <= 0) {
            v.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
            return bArr2;
        } else if (bArr2 == null || bArr2.length <= 0) {
            v.e("MicroMsg.SyncKeyUtil", "newKey is null");
            return null;
        } else {
            PByteArray pByteArray = new PByteArray();
            try {
                if (MMProtocalJni.mergeSyncKey(bArr, bArr2, pByteArray)) {
                    return pByteArray.value;
                }
                v.e("MicroMsg.SyncKeyUtil", "merge key failed");
                return null;
            } catch (Throwable e) {
                v.a("MicroMsg.Crash", e, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(e));
            }
        }
    }

    private static Map<Integer, Long> aY(byte[] bArr) {
        if (be.bl(bArr)) {
            return null;
        }
        try {
            ayz com_tencent_mm_protocal_c_ayz = (ayz) new ayz().az(bArr);
            if (com_tencent_mm_protocal_c_ayz == null) {
                return null;
            }
            v.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + com_tencent_mm_protocal_c_ayz.mSs);
            LinkedList linkedList = com_tencent_mm_protocal_c_ayz.mSt;
            if (linkedList.size() != com_tencent_mm_protocal_c_ayz.mSs) {
                return null;
            }
            Map<Integer, Long> hashMap = new HashMap();
            for (int i = 0; i < com_tencent_mm_protocal_c_ayz.mSs; i++) {
                hashMap.put(Integer.valueOf(((afm) linkedList.get(i)).itH), Long.valueOf(4294967295L & ((long) ((afm) linkedList.get(i)).mFo)));
            }
            if (hashMap.size() != com_tencent_mm_protocal_c_ayz.mSs) {
                return null;
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    public static String aZ(byte[] bArr) {
        if (be.bl(bArr)) {
            return SQLiteDatabase.KeyEmpty;
        }
        Map aY = aY(bArr);
        if (aY == null || aY.size() <= 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" MsgKey:" + aY.get(Integer.valueOf(2)));
        stringBuffer.append(" profile:" + aY.get(Integer.valueOf(1)));
        stringBuffer.append(" contact:" + aY.get(Integer.valueOf(3)));
        stringBuffer.append(" chatroom:" + aY.get(Integer.valueOf(11)));
        stringBuffer.append(" Bottle:" + aY.get(Integer.valueOf(7)));
        stringBuffer.append(" QContact:" + aY.get(Integer.valueOf(5)));
        return stringBuffer.toString();
    }

    public static boolean j(byte[] bArr, byte[] bArr2) {
        Map aY = aY(bArr);
        if (aY == null) {
            v.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
            return true;
        }
        Map aY2 = aY(bArr2);
        if (aY2 == null) {
            v.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
            return false;
        }
        for (Integer num : aY2.keySet()) {
            Long l = (Long) aY.get(num);
            Long l2 = (Long) aY2.get(num);
            if (l == null) {
                v.d("MicroMsg.SyncKeyUtil", "dkpush local key null :" + num);
                return true;
            }
            v.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + num + " sv:" + l2 + " lv:" + l);
            if (l2.longValue() > l.longValue()) {
                return true;
            }
        }
        v.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
        return false;
    }
}
