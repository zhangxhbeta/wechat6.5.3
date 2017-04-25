package com.tencent.mm.plugin.report;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;

public enum b implements a {
    ;
    
    public a itn;

    private static class a implements a {
        private a() {
        }

        public final void a(long j, long j2, long j3, boolean z) {
            v.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void cW(int i) {
            v.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void h(int i, Object... objArr) {
            v.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void a(int i, String str, boolean z, boolean z2) {
            v.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void a(int i, boolean z, boolean z2, Object... objArr) {
            v.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void c(int i, int i2, int i3, int i4, boolean z) {
            throw new UnsupportedOperationException();
        }
    }

    private b(String str) {
        this.itn = new a();
    }

    public final void h(int i, Object... objArr) {
        this.itn.h(i, objArr);
    }

    public final void a(int i, String str, boolean z, boolean z2) {
        this.itn.a(i, str, z, z2);
    }

    public final void a(int i, boolean z, boolean z2, Object... objArr) {
        this.itn.a(i, z, z2, objArr);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        this.itn.a(j, j2, j3, z);
    }

    public final void c(int i, int i2, int i3, int i4, boolean z) {
        this.itn.c(i, i2, i3, i4, z);
    }

    public final void cW(int i) {
        this.itn.cW(i);
    }

    public static Object a(int i, int[] iArr, Object[] objArr) {
        int i2 = 0;
        if (iArr.length <= 0 || iArr.length + 1 != objArr.length) {
            return null;
        }
        if (i <= iArr[0]) {
            return objArr[0];
        }
        while (i2 < iArr.length - 1) {
            if (iArr[i2] >= iArr[i2 + 1]) {
                return null;
            }
            if (i > iArr[i2] && i <= iArr[i2 + 1]) {
                return objArr[i2 + 1];
            }
            i2++;
        }
        return objArr[objArr.length - 1];
    }

    public static Object a(int i, int[] iArr, int i2, int i3) {
        int i4 = 0;
        if (iArr == null || iArr.length <= 0 || i3 <= i2 || i3 > WebView.NORMAL_MODE_ALPHA || iArr.length != i3 - i2) {
            return null;
        }
        if (i <= iArr[0]) {
            return Integer.valueOf(i2);
        }
        while (i4 < iArr.length - 1) {
            if (iArr[i4] >= iArr[i4 + 1]) {
                return null;
            }
            if (i > iArr[i4] && i <= iArr[i4 + 1]) {
                return Integer.valueOf(i4 + (i2 + 1));
            }
            i4++;
        }
        return Integer.valueOf(i3);
    }
}
