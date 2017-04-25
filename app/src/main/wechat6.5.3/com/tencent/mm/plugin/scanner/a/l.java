package com.tencent.mm.plugin.scanner.a;

import android.graphics.Point;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class l {
    public static int iwg = 0;
    public static int iwh = 1;
    public static int iwi = 2;
    public static l iwj = new l();
    private boolean cWm = false;
    private long iwk = 0;
    private boolean iwl = false;
    private int iwm = 0;
    private long iwn = 0;
    public int iwo = -1;
    private Point iwp = null;
    public String iwq;
    public String iwr;
    public String iws;
    public int iwt;
    public int iwu;
    public String iwv;
    private int retryCount = 0;

    public final void cx(long j) {
        v.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[]{Long.valueOf(j)});
        this.iwk += j;
    }

    public final void aKT() {
        v.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
        this.iwl = true;
    }

    public final void aKU() {
        v.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[]{Integer.valueOf(this.iwm)});
        this.iwm++;
    }

    public final void oW(int i) {
        v.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[]{Integer.valueOf(i)});
        this.iwo = i;
    }

    public final void ci(int i, int i2) {
        v.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.iwp = new Point(i, i2);
    }

    public final void aKV() {
        v.i("MicroMsg.QBarEngineReporter", "addRetryTime, current retry count: %s", new Object[]{Integer.valueOf(this.retryCount)});
        this.retryCount++;
    }

    public final void cy(long j) {
        v.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[]{Long.valueOf(j)});
        this.iwn = j;
    }

    public final void auO() {
        int i = 0;
        if (this.cWm) {
            v.i("MicroMsg.QBarEngineReporter", "doReport, already report");
            return;
        }
        int i2;
        v.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s", new Object[]{Integer.valueOf(this.iwm), Long.valueOf(this.iwk), Long.valueOf(this.iwn), Integer.valueOf(this.iwo), this.iwp, Integer.valueOf(this.retryCount), Boolean.valueOf(this.iwl), this.iwq, this.iwr, this.iws, Integer.valueOf(this.iwt), Integer.valueOf(this.iwu), this.iwv});
        String str = "";
        if (this.iwp != null) {
            str = this.iwp.x + "x" + this.iwp.y;
        }
        g gVar = g.iuh;
        Object[] objArr = new Object[14];
        objArr[0] = Integer.valueOf(this.iwm);
        objArr[1] = Long.valueOf(this.iwk);
        objArr[2] = Long.valueOf(this.iwn);
        objArr[3] = Integer.valueOf(this.iwo);
        objArr[4] = str;
        objArr[5] = Integer.valueOf(this.retryCount);
        if (this.iwl) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = this.iwq;
        objArr[8] = "";
        objArr[9] = this.iws;
        objArr[10] = Integer.valueOf(this.iwt);
        objArr[11] = Integer.valueOf(this.iwu);
        objArr[12] = this.iwv;
        if (!be.kS(this.iwr)) {
            i = this.iwr.length();
        }
        objArr[13] = Integer.valueOf(i);
        gVar.h(13233, objArr);
        this.cWm = true;
    }

    public final void reset() {
        this.iwk = 0;
        this.iwl = false;
        this.iwm = 0;
        this.iwo = -1;
        this.iwp = null;
        this.retryCount = 0;
        this.iwq = "";
        this.iwr = "";
        this.iws = "";
        this.iwt = 0;
        this.iwu = 0;
        this.iwv = "";
        this.iwn = 0;
        this.cWm = false;
        v.i("MicroMsg.QBarEngineReporter", "reset");
    }
}
