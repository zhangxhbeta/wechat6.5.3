package com.tencent.mm.plugin.emoji;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    public static void aT(long j) {
        v.i("MicroMsg.emoji.EmojiReportHepler", "report id stat key:%d, value:%d", new Object[]{Long.valueOf(j), Long.valueOf(1)});
        g.iuh.a(96, j, 1, false);
    }

    public static void a(String str, int i, int i2, int i3, String str2, int i4, String str3) {
        v.i("MicroMsg.emoji.EmojiReportHepler", "report kv stat md5:%s, downType:%d donwloadResult:%d verifyResult:%d productID:%s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2});
        g.iuh.h(12007, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i4), str3});
    }
}
