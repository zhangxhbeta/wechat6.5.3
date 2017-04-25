package com.tencent.mm.model.a;

import android.content.Intent;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class e {
    private static void gc(String str) {
        v.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", str);
        if (f.Aj().Ah()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
            intent.putExtra("content", str);
            aa.getContext().sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
            return;
        }
        v.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
    }

    private static void a(d dVar, boolean z) {
        if (dVar == null || !f.Aj().Ah()) {
            v.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z ? stringBuilder.append("TestPointStart:") : stringBuilder.append("TestPointEnd:"));
        stringBuilder.append(f.Aj().cvS.cvO);
        stringBuilder.append("_");
        stringBuilder.append(dVar.id);
        stringBuilder.append("_");
        stringBuilder.append(dVar.cvU);
        stringBuilder.append("_");
        stringBuilder.append(dVar.cvU);
        stringBuilder.append("_");
        stringBuilder.append(dVar.cvV);
        stringBuilder.append("_");
        stringBuilder.append(dVar.bfz);
        stringBuilder.append("_");
        stringBuilder.append(dVar.cvX);
        gc(stringBuilder.toString());
    }

    public static void a(d dVar) {
        if (dVar != null && f.Aj().Ah()) {
            String str = f.Aj().cvS.cvO;
            String str2 = dVar.id;
            String str3 = dVar.id;
            String str4 = (dVar.endTime - dVar.startTime);
            String str5 = dVar.bfz;
            String str6 = dVar.cvU;
            long j = dVar.cvX;
            v.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", str, str2, str6, str3, str4, str5, Long.valueOf(j));
            g.iuh.h(11394, str, str2, str6, str3, str4, str5, Long.valueOf(j));
        }
    }

    public static void gd(String str) {
        v.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
        gc("TestCaseID:" + str);
    }

    public static void ge(String str) {
        if (f.Aj().ga(str) != null) {
            v.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", str);
            f.Aj().ga(str).cvV = System.currentTimeMillis();
            f.Aj().ga(str).startTime = System.currentTimeMillis();
            f.Aj().ga(str).cvW = false;
            f.Aj().ga(str).bfz = "0";
            a(f.Aj().ga(str), true);
        }
    }

    public static void gf(String str) {
        if (f.Aj().ga(str) != null && !f.Aj().ga(str).cvW) {
            v.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", str);
            f.Aj().ga(str).cvV = System.currentTimeMillis();
            f.Aj().ga(str).endTime = System.currentTimeMillis();
            f.Aj().ga(str).cvW = true;
            a(f.Aj().ga(str));
            a(f.Aj().ga(str), false);
        }
    }
}
