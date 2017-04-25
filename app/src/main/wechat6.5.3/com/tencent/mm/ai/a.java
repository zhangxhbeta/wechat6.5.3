package com.tencent.mm.ai;

import com.tencent.mm.e.b.ca;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.platformtools.be;

public final class a extends ca {
    public static com.tencent.mm.sdk.h.c.a chq = ca.pz();

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }

    public final boolean Hy() {
        return (this.field_songBgColor == 0 || this.field_songLyricColor == 0) ? false : true;
    }

    public final boolean Hz() {
        return !be.kS(this.field_songHAlbumUrl);
    }

    public final boolean e(int[] iArr) {
        return this.field_songBgColor == iArr[0] && this.field_songLyricColor == iArr[1];
    }

    public final boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.field_musicId.equals(aVar.field_musicId);
    }

    public final ajr HA() {
        ajr com_tencent_mm_protocal_c_ajr = new ajr();
        com_tencent_mm_protocal_c_ajr.mJW = this.field_originMusicId;
        com_tencent_mm_protocal_c_ajr.mJV = this.field_musicType;
        com_tencent_mm_protocal_c_ajr.glj = this.field_appId;
        com_tencent_mm_protocal_c_ajr.mKa = this.field_songAlbum;
        com_tencent_mm_protocal_c_ajr.mKi = this.field_songAlbumType;
        com_tencent_mm_protocal_c_ajr.mKc = this.field_songWifiUrl;
        com_tencent_mm_protocal_c_ajr.mJY = this.field_songName;
        com_tencent_mm_protocal_c_ajr.mJZ = this.field_songSinger;
        com_tencent_mm_protocal_c_ajr.mKd = this.field_songWapLinkUrl;
        com_tencent_mm_protocal_c_ajr.mKe = this.field_songWebUrl;
        com_tencent_mm_protocal_c_ajr.mKg = this.field_songAlbumLocalPath;
        com_tencent_mm_protocal_c_ajr.mfo = this.field_songMediaId;
        com_tencent_mm_protocal_c_ajr.mKm = this.field_songSnsAlbumUser;
        com_tencent_mm_protocal_c_ajr.mKn = this.field_songSnsShareUser;
        com_tencent_mm_protocal_c_ajr.mKp = this.field_hideBanner;
        return com_tencent_mm_protocal_c_ajr;
    }
}
