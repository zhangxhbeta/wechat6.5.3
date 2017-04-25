package com.tencent.mm.plugin.music.a;

import com.tencent.mm.ai.a;
import com.tencent.mm.sdk.platformtools.v;

public final class g {
    public static boolean hCV;
    public static boolean hCW;
    public static int hCX;
    public static int hCY;
    public static long hCZ;
    public static a hDa;
    public static int scene;

    public static final void G(int i, int i2, int i3) {
        if (i.aDd().aCW() != null) {
            v.v("MicroMsg.Music.MusicReportUtil", "kvReportShakeReport: %d, %d, %d, %s, %s, %s, %s, %d %s, %s", new Object[]{Integer.valueOf(13042), Integer.valueOf(i), Integer.valueOf(i2), i.aDd().aCW().field_musicId, i.aDd().aCW().field_songName, i.aDd().aCW().field_songAlbum, Integer.valueOf(i.aDd().aCW().field_songId), Integer.valueOf(i3), i.aDd().aCW().field_songSinger, i.aDd().aCW().field_appId});
            com.tencent.mm.plugin.report.service.g.iuh.h(13042, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i3), r0.field_songSinger, r0.field_appId});
        }
    }

    public static final void bZ(int i, int i2) {
        if (i.aDd().aCW() != null) {
            v.v("MicroMsg.Music.MusicReportUtil", "kvReportAction: %d, %s, %s, %s, %s, %d, %d, %s, %s", new Object[]{Integer.valueOf(13232), i.aDd().aCW().field_musicId, i.aDd().aCW().field_songName, i.aDd().aCW().field_songAlbum, Integer.valueOf(i.aDd().aCW().field_songId), Integer.valueOf(i2), Integer.valueOf(i), i.aDd().aCW().field_songSinger, i.aDd().aCW().field_appId});
            com.tencent.mm.plugin.report.service.g.iuh.h(13232, new Object[]{r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i2), Integer.valueOf(i), r0.field_songSinger, r0.field_appId});
        }
    }

    public static final void aDa() {
        int i = 1;
        if (hDa != null) {
            int i2;
            rb();
            String str = "MicroMsg.Music.MusicReportUtil";
            String str2 = "kvReportMusicPlayInfo: %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s";
            Object[] objArr = new Object[12];
            objArr[0] = Integer.valueOf(13044);
            objArr[1] = hDa.field_musicId;
            objArr[2] = hDa.field_songName;
            objArr[3] = hDa.field_songAlbum;
            objArr[4] = Integer.valueOf(hDa.field_songId);
            objArr[5] = Integer.valueOf(hCX);
            objArr[6] = Integer.valueOf(hCY);
            objArr[7] = Integer.valueOf(hCV ? 1 : 2);
            objArr[8] = Integer.valueOf(hCW ? 1 : 2);
            objArr[9] = Integer.valueOf(scene);
            objArr[10] = hDa.field_songSinger;
            objArr[11] = hDa.field_appId;
            v.v(str, str2, objArr);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
            objArr = new Object[11];
            objArr[0] = hDa.field_musicId;
            objArr[1] = hDa.field_songName;
            objArr[2] = hDa.field_songAlbum;
            objArr[3] = Integer.valueOf(hDa.field_songId);
            objArr[4] = Integer.valueOf(hCX);
            objArr[5] = Integer.valueOf(hCY);
            if (hCV) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            objArr[6] = Integer.valueOf(i2);
            if (!hCW) {
                i = 2;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = Integer.valueOf(scene);
            objArr[9] = hDa.field_songSinger;
            objArr[10] = hDa.field_appId;
            gVar.h(13044, objArr);
        }
        hDa = null;
        hCV = false;
        hCW = false;
        hCX = 0;
        hCY = 0;
        hCZ = 0;
        scene = 0;
    }

    public static final void rb() {
        if (hCZ > 0) {
            hCY = (int) (((long) hCY) + ((System.currentTimeMillis() - hCZ) / 1000));
            hCZ = 0;
        }
    }

    public static final void aDb() {
        com.tencent.mm.plugin.report.service.g.iuh.a(285, 4, 1, false);
    }
}
