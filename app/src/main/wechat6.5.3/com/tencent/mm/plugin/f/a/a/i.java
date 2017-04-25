package com.tencent.mm.plugin.f.a.a;

import android.util.SparseArray;
import com.tencent.mm.protocal.c.kz;
import junit.framework.Assert;

public interface i {

    public static class a {
        private static SparseArray<i> hlf = new SparseArray();

        public static void a(int i, i iVar) {
            Assert.assertTrue(hlf.get(i) == null);
            hlf.put(i, iVar);
        }

        public static i mU(int i) {
            return (i) hlf.get(i);
        }
    }

    void a(kz kzVar, byte[] bArr, boolean z, j jVar);
}
