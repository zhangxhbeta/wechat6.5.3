package com.tencent.mm.platformtools;

import com.tencent.mm.ba.b;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;

public final class m {
    public static are H(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        are com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(bArr);
        return com_tencent_mm_protocal_c_are;
    }

    public static byte[] a(are com_tencent_mm_protocal_c_are) {
        if (com_tencent_mm_protocal_c_are == null || com_tencent_mm_protocal_c_are.mQw == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_are.mQw.toByteArray();
    }

    public static byte[] a(are com_tencent_mm_protocal_c_are, byte[] bArr) {
        return (com_tencent_mm_protocal_c_are == null || com_tencent_mm_protocal_c_are.mQw == null) ? bArr : com_tencent_mm_protocal_c_are.mQw.toByteArray();
    }

    public static String a(arf com_tencent_mm_protocal_c_arf) {
        if (com_tencent_mm_protocal_c_arf == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_arf.mQy;
    }

    public static arf lY(String str) {
        if (str == null) {
            return null;
        }
        arf com_tencent_mm_protocal_c_arf = new arf();
        com_tencent_mm_protocal_c_arf.JF(str);
        return com_tencent_mm_protocal_c_arf;
    }

    public static String a(b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.brp();
    }

    public static String b(are com_tencent_mm_protocal_c_are) {
        if (com_tencent_mm_protocal_c_are == null || com_tencent_mm_protocal_c_are.mQw == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_are.mQw.brp();
    }
}
