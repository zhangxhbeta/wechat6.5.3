package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;

@TargetApi(16)
public final class m implements Runnable {
    public MediaFormat geA;
    public MediaFormat geB;
    public VideoMediaItem geC;
    public a geD;
    public String path;
    public int position;

    public interface a {
        void a(m mVar);
    }

    public m(String str, int i, VideoMediaItem videoMediaItem, a aVar) {
        this.path = str;
        this.position = i;
        this.geC = videoMediaItem;
        this.geD = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r12 = this;
        r11 = 2;
        r10 = 1;
        r1 = 0;
        r2 = new android.media.MediaExtractor;
        r2.<init>();
        r0 = r12.path;	 Catch:{ Exception -> 0x011c }
        r2.setDataSource(r0);	 Catch:{ Exception -> 0x011c }
        r3 = r2.getTrackCount();	 Catch:{ Exception -> 0x011c }
        r0 = r1;
    L_0x0012:
        if (r0 >= r3) goto L_0x005c;
    L_0x0014:
        r4 = r2.getTrackFormat(r0);	 Catch:{ Exception -> 0x011c }
        r5 = "mime";
        r5 = r4.containsKey(r5);	 Catch:{ Exception -> 0x011c }
        if (r5 != 0) goto L_0x002d;
    L_0x0021:
        r4 = "VideoAnalysisTask";
        r5 = "find video mime : not found.";
        com.tencent.mm.sdk.platformtools.v.d(r4, r5);	 Catch:{ Exception -> 0x011c }
    L_0x002a:
        r0 = r0 + 1;
        goto L_0x0012;
    L_0x002d:
        r5 = "mime";
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x011c }
        r6 = "VideoAnalysisTask";
        r7 = "find video mime : %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x011c }
        r9 = 0;
        r8[r9] = r5;	 Catch:{ Exception -> 0x011c }
        com.tencent.mm.sdk.platformtools.v.d(r6, r7, r8);	 Catch:{ Exception -> 0x011c }
        if (r5 == 0) goto L_0x002a;
    L_0x0045:
        r6 = "video/";
        r6 = r5.startsWith(r6);	 Catch:{ Exception -> 0x011c }
        if (r6 == 0) goto L_0x010b;
    L_0x004e:
        r5 = r12.geA;	 Catch:{ Exception -> 0x011c }
        if (r5 != 0) goto L_0x0054;
    L_0x0052:
        r12.geA = r4;	 Catch:{ Exception -> 0x011c }
    L_0x0054:
        r4 = r12.geB;	 Catch:{ Exception -> 0x011c }
        if (r4 == 0) goto L_0x002a;
    L_0x0058:
        r4 = r12.geA;	 Catch:{ Exception -> 0x011c }
        if (r4 == 0) goto L_0x002a;
    L_0x005c:
        r0 = r12.geC;	 Catch:{ Exception -> 0x011c }
        if (r0 == 0) goto L_0x00ec;
    L_0x0060:
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        if (r0 == 0) goto L_0x00d6;
    L_0x0064:
        r3 = r12.geC;	 Catch:{ Exception -> 0x011c }
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "durationUs";
        r0 = r0.containsKey(r4);	 Catch:{ Exception -> 0x011c }
        if (r0 != 0) goto L_0x0139;
    L_0x0071:
        r0 = r1;
    L_0x0072:
        r3.gee = r0;	 Catch:{ Exception -> 0x011c }
        r3 = r12.geC;	 Catch:{ Exception -> 0x011c }
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "height";
        r0 = r0.containsKey(r4);	 Catch:{ Exception -> 0x011c }
        if (r0 != 0) goto L_0x0148;
    L_0x0081:
        r0 = r1;
    L_0x0082:
        r3.gef = r0;	 Catch:{ Exception -> 0x011c }
        r3 = r12.geC;	 Catch:{ Exception -> 0x011c }
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "width";
        r0 = r0.containsKey(r4);	 Catch:{ Exception -> 0x011c }
        if (r0 != 0) goto L_0x0153;
    L_0x0091:
        r0 = r1;
    L_0x0092:
        r3.geg = r0;	 Catch:{ Exception -> 0x011c }
        r3 = r12.geC;	 Catch:{ Exception -> 0x011c }
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "mime";
        r0 = r0.containsKey(r4);	 Catch:{ Exception -> 0x011c }
        if (r0 != 0) goto L_0x015e;
    L_0x00a1:
        r0 = "";
    L_0x00a4:
        r3.gec = r0;	 Catch:{ Exception -> 0x011c }
        r3 = r12.geC;	 Catch:{ Exception -> 0x011c }
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "bitrate";
        r0 = r0.containsKey(r4);	 Catch:{ Exception -> 0x011c }
        if (r0 != 0) goto L_0x0169;
    L_0x00b3:
        r0 = r1;
    L_0x00b4:
        r3.videoBitRate = r0;	 Catch:{ Exception -> 0x011c }
        r3 = r12.geC;	 Catch:{ Exception -> 0x011c }
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "i-frame-interval";
        r0 = r0.containsKey(r4);	 Catch:{ Exception -> 0x011c }
        if (r0 != 0) goto L_0x0174;
    L_0x00c3:
        r0 = r1;
    L_0x00c4:
        r3.geh = r0;	 Catch:{ Exception -> 0x011c }
        r3 = r12.geC;	 Catch:{ Exception -> 0x011c }
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "frame-rate";
        r0 = r0.containsKey(r4);	 Catch:{ Exception -> 0x011c }
        if (r0 != 0) goto L_0x017f;
    L_0x00d3:
        r0 = r1;
    L_0x00d4:
        r3.videoFrameRate = r0;	 Catch:{ Exception -> 0x011c }
    L_0x00d6:
        r0 = r12.geB;	 Catch:{ Exception -> 0x011c }
        if (r0 == 0) goto L_0x00ec;
    L_0x00da:
        r3 = r12.geC;	 Catch:{ Exception -> 0x011c }
        r0 = r12.geB;	 Catch:{ Exception -> 0x011c }
        r4 = "mime";
        r0 = r0.containsKey(r4);	 Catch:{ Exception -> 0x011c }
        if (r0 != 0) goto L_0x018a;
    L_0x00e7:
        r0 = "";
    L_0x00ea:
        r3.ged = r0;	 Catch:{ Exception -> 0x011c }
    L_0x00ec:
        r2.release();
    L_0x00ef:
        r0 = r12.geD;
        if (r0 != 0) goto L_0x019a;
    L_0x00f3:
        r0 = "VideoAnalysisTask";
        r2 = "video analysis end. observer == null, position = [%d], mediaItem = [%s]";
        r3 = new java.lang.Object[r11];
        r4 = r12.position;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r1] = r4;
        r1 = r12.geC;
        r3[r10] = r1;
        com.tencent.mm.sdk.platformtools.v.d(r0, r2, r3);
    L_0x010a:
        return;
    L_0x010b:
        r6 = "audio/";
        r5 = r5.startsWith(r6);	 Catch:{ Exception -> 0x011c }
        if (r5 == 0) goto L_0x0054;
    L_0x0114:
        r5 = r12.geB;	 Catch:{ Exception -> 0x011c }
        if (r5 != 0) goto L_0x0054;
    L_0x0118:
        r12.geB = r4;	 Catch:{ Exception -> 0x011c }
        goto L_0x0054;
    L_0x011c:
        r0 = move-exception;
        r3 = "VideoAnalysisTask";
        r4 = "Video extractor init failed. video path = [%s] e = [%s]";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0195 }
        r6 = 0;
        r7 = r12.path;	 Catch:{ all -> 0x0195 }
        r5[r6] = r7;	 Catch:{ all -> 0x0195 }
        r6 = 1;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0195 }
        r5[r6] = r0;	 Catch:{ all -> 0x0195 }
        com.tencent.mm.sdk.platformtools.v.d(r3, r4, r5);	 Catch:{ all -> 0x0195 }
        r2.release();
        goto L_0x00ef;
    L_0x0139:
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "durationUs";
        r4 = r0.getLong(r4);	 Catch:{ Exception -> 0x011c }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 / r6;
        r0 = (int) r4;	 Catch:{ Exception -> 0x011c }
        goto L_0x0072;
    L_0x0148:
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "height";
        r0 = r0.getInteger(r4);	 Catch:{ Exception -> 0x011c }
        goto L_0x0082;
    L_0x0153:
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "width";
        r0 = r0.getInteger(r4);	 Catch:{ Exception -> 0x011c }
        goto L_0x0092;
    L_0x015e:
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "mime";
        r0 = r0.getString(r4);	 Catch:{ Exception -> 0x011c }
        goto L_0x00a4;
    L_0x0169:
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "bitrate";
        r0 = r0.getInteger(r4);	 Catch:{ Exception -> 0x011c }
        goto L_0x00b4;
    L_0x0174:
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "i-frame-interval";
        r0 = r0.getInteger(r4);	 Catch:{ Exception -> 0x011c }
        goto L_0x00c4;
    L_0x017f:
        r0 = r12.geA;	 Catch:{ Exception -> 0x011c }
        r4 = "frame-rate";
        r0 = r0.getInteger(r4);	 Catch:{ Exception -> 0x011c }
        goto L_0x00d4;
    L_0x018a:
        r0 = r12.geB;	 Catch:{ Exception -> 0x011c }
        r4 = "mime";
        r0 = r0.getString(r4);	 Catch:{ Exception -> 0x011c }
        goto L_0x00ea;
    L_0x0195:
        r0 = move-exception;
        r2.release();
        throw r0;
    L_0x019a:
        r0 = new com.tencent.mm.plugin.gallery.model.m$1;
        r0.<init>(r12);
        com.tencent.mm.sdk.platformtools.ad.o(r0);
        goto L_0x010a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.m.run():void");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof m) && (this == obj || this.position == ((m) obj).position || (this.path != null && this.path.equals(((m) obj).path)));
    }
}
