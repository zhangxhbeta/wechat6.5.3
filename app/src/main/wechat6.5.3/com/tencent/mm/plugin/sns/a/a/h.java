package com.tencent.mm.plugin.sns.a.a;

import android.os.SystemClock;
import com.tencent.mm.plugin.sns.a.a.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.LinkedList;

public final class h {
    public String TAG = "MicroMsg.SnsAdVideoStatistic";
    public int jcA = 0;
    public a jcB = new a();
    public LinkedList<a> jcC = new LinkedList();
    public int jcx = 0;
    public int jcy = 0;
    public long jcz = 0;

    public h(String str) {
        this.TAG = "MicroMsg.SnsAdVideoStatistic:" + str;
    }

    public final void pP(int i) {
        if (this.jcB.jdx <= 0) {
            this.jcB.jdx = this.jcB.jdB == 0 ? 0 : (int) be.az(this.jcB.jdB);
        }
        if (i != 0) {
            this.jcB.jdy = i;
        }
        v.i(this.TAG, "pushplayitem duration " + this.jcB.jdx + " " + this.jcB.jdA);
        this.jcC.add(this.jcB);
        this.jcB = new a();
    }

    public final String aQV() {
        int i;
        if (this.jcz == 0) {
            i = 0;
        } else {
            i = (int) be.az(this.jcz);
        }
        this.jcy = i;
        v.d(this.TAG, "__staytotaltime " + this.jcz + " " + this.jcy + " clock: " + SystemClock.elapsedRealtime());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<viewinfo>");
        stringBuffer.append("<downloadstatus>");
        stringBuffer.append(this.jcx);
        stringBuffer.append("</downloadstatus>");
        stringBuffer.append("<staytotaltime>");
        stringBuffer.append(this.jcy);
        stringBuffer.append("</staytotaltime>");
        if (this.jcA > 0) {
            stringBuffer.append("<masktotaltime>");
            stringBuffer.append(this.jcA);
            stringBuffer.append("</masktotaltime>");
        }
        stringBuffer.append(String.format("<playitemlist count=\"%d\">", new Object[]{Integer.valueOf(this.jcC.size())}));
        for (int i2 = 0; i2 < this.jcC.size(); i2++) {
            a aVar = (a) this.jcC.get(i2);
            stringBuffer.append("<playitem>");
            stringBuffer.append(String.format("<playcount>%d</playcount>", new Object[]{Integer.valueOf(aVar.jdw)}));
            stringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[]{Integer.valueOf(aVar.jdx)}));
            stringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[]{Integer.valueOf(aVar.jdy * BaseReportManager.MAX_READ_COUNT)}));
            stringBuffer.append(String.format("<playmode>%d</playmode>", new Object[]{Integer.valueOf(aVar.jdz)}));
            stringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[]{Integer.valueOf(aVar.jdA)}));
            stringBuffer.append("</playitem>");
        }
        stringBuffer.append("</playitemlist>");
        stringBuffer.append("</viewinfo>");
        String stringBuffer2 = stringBuffer.toString();
        v.i(this.TAG, "xml " + stringBuffer2);
        return stringBuffer2;
    }
}
