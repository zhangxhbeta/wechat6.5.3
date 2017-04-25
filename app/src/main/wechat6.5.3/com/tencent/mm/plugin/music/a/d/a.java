package com.tencent.mm.plugin.music.a.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends f<com.tencent.mm.ai.a> {
    private d cie;
    public com.tencent.mm.a.f<String, com.tencent.mm.ai.a> hDD = new com.tencent.mm.a.f(20);
    public com.tencent.mm.a.f<String, com.tencent.mm.plugin.music.a.a> hDE = new com.tencent.mm.a.f(10);

    public a(d dVar) {
        super(dVar, com.tencent.mm.ai.a.chq, "Music", null);
        this.cie = dVar;
    }

    public final com.tencent.mm.ai.a xe(String str) {
        if (this.hDD.get(str) != null) {
            return (com.tencent.mm.ai.a) this.hDD.get(str);
        }
        String format = String.format("Select * From Music Where musicId=?", new Object[0]);
        Cursor rawQuery = this.cie.rawQuery(format, new String[]{str});
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        }
        com.tencent.mm.ai.a aVar = new com.tencent.mm.ai.a();
        aVar.b(rawQuery);
        rawQuery.close();
        this.hDD.put(str, aVar);
        return aVar;
    }

    public final com.tencent.mm.plugin.music.a.a g(com.tencent.mm.ai.a aVar, boolean z) {
        com.tencent.mm.plugin.music.a.a.a aVar2;
        String str = aVar.field_songLyric;
        String string = aa.getContext().getString(2131233970);
        String str2 = aVar.field_songSnsShareUser;
        boolean e = h.e(aVar);
        String str3 = aVar.field_songSinger;
        com.tencent.mm.plugin.music.a.a aVar3 = new com.tencent.mm.plugin.music.a.a();
        long Nj = be.Nj();
        if (be.kS(str)) {
            com.tencent.mm.plugin.music.a.a.a aVar4 = new com.tencent.mm.plugin.music.a.a.a();
            aVar4.timestamp = 0;
            if (z) {
                aVar4.content = str3;
            } else if (e) {
                aVar4.content = aa.getContext().getString(2131234060);
            } else {
                aVar4.content = aa.getContext().getString(2131234059);
            }
            if (aVar4.content != null) {
                aVar3.hCk.add(aVar4);
            }
        } else {
            if (str == null) {
                v.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
            } else {
                int i;
                Matcher matcher = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher(str.replaceAll("\n", " ").replaceAll("\r", " "));
                while (matcher.find()) {
                    CharSequence group = matcher.group();
                    matcher.start();
                    matcher.end();
                    if (group == null) {
                        v.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
                    } else if (group.startsWith("[ti:")) {
                        aVar3.title = com.tencent.mm.plugin.music.a.a.cj(group, "[ti:");
                    } else if (group.startsWith("[ar:")) {
                        aVar3.hCm = com.tencent.mm.plugin.music.a.a.cj(group, "[ar:");
                    } else if (group.startsWith("[al:")) {
                        aVar3.hCn = com.tencent.mm.plugin.music.a.a.cj(group, "[al:");
                    } else if (group.startsWith("[by:")) {
                        aVar3.hCo = com.tencent.mm.plugin.music.a.a.cj(group, "[by:");
                    } else if (group.startsWith("[offset:")) {
                        aVar3.cOf = be.getLong(com.tencent.mm.plugin.music.a.a.cj(group, "[offset:"), 0);
                    } else if (group.startsWith("[re:")) {
                        aVar3.hCp = com.tencent.mm.plugin.music.a.a.cj(group, "[re:");
                    } else if (group.startsWith("[ve:")) {
                        aVar3.hCq = com.tencent.mm.plugin.music.a.a.cj(group, "[ve:");
                    } else {
                        Pattern compile = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
                        Matcher matcher2 = compile.matcher(group);
                        com.tencent.mm.plugin.music.a.a.a aVar5 = new com.tencent.mm.plugin.music.a.a.a();
                        while (matcher2.find()) {
                            if (matcher2.groupCount() > 0) {
                                aVar5.timestamp = com.tencent.mm.plugin.music.a.a.wX(matcher2.group(1));
                            }
                            String[] split = compile.split(group);
                            if (split == null || split.length <= 0) {
                                aVar3.hCl.add(Long.valueOf(aVar5.timestamp));
                                break;
                            }
                            String str4 = split[split.length - 1];
                            if (str4 != null) {
                                str4 = str4.trim();
                            }
                            if (be.kS(str4)) {
                                str4 = " ";
                            }
                            aVar5.content = str4;
                            for (i = 0; i < aVar3.hCl.size(); i++) {
                                com.tencent.mm.plugin.music.a.a.a aVar6 = new com.tencent.mm.plugin.music.a.a.a();
                                aVar6.timestamp = ((Long) aVar3.hCl.get(i)).longValue();
                                aVar6.content = aVar5.content;
                                aVar6.hCs = true;
                            }
                            aVar3.hCl.clear();
                            i = aVar3.hCk.size() - 1;
                            while (i >= 0 && ((com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(i)).timestamp != aVar5.timestamp) {
                                if (((com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(i)).timestamp < aVar5.timestamp) {
                                    aVar3.hCk.add(i + 1, aVar5);
                                    break;
                                }
                                i--;
                            }
                            if (i < 0) {
                                aVar3.hCk.add(0, aVar5);
                            }
                        }
                    }
                }
                v.d("MicroMsg.Music.LyricObj", "handle offset %d", new Object[]{Long.valueOf(aVar3.cOf)});
                if (aVar3.cOf != 0) {
                    for (i = 0; i < aVar3.hCk.size(); i++) {
                        aVar2 = (com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(i);
                        aVar2.timestamp += aVar3.cOf;
                    }
                    aVar3.cOf = 0;
                }
                int i2 = 0;
                while (i2 < aVar3.hCk.size() - 1) {
                    aVar2 = (com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(i2);
                    if (aVar2.hCs && aVar2.content.equals(((com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(i2 + 1)).content)) {
                        aVar2.content = " ";
                    }
                    i2++;
                }
            }
            v.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[]{str});
            v.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[]{Integer.valueOf(aVar3.hCk.size())});
        }
        if (be.kS(str2)) {
            v.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        } else {
            aVar2 = new com.tencent.mm.plugin.music.a.a.a();
            aVar2.timestamp = 0;
            aVar2.content = aa.getContext().getString(2131235743, new Object[]{l.er(str2)});
            if (aVar3.hCk.isEmpty()) {
                aVar3.hCk.add(aVar2);
            } else if (aVar3.hCk.size() == 1) {
                aVar3.hCk.add(0, aVar2);
                ((com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(1)).timestamp = 5000;
            } else {
                aVar3.hCk.add(0, aVar2);
                ((com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(1)).timestamp = 3 * (((com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(2)).timestamp >> 2);
            }
        }
        if (!be.kS(str)) {
            if (be.kS(string)) {
                v.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
            } else {
                aVar2 = new com.tencent.mm.plugin.music.a.a.a();
                aVar2.timestamp = 0;
                aVar2.content = string;
                if (aVar3.hCk.isEmpty()) {
                    aVar3.hCk.add(aVar2);
                } else if (aVar3.hCk.size() == 1) {
                    aVar3.hCk.add(0, aVar2);
                    ((com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(1)).timestamp = 5000;
                } else {
                    aVar3.hCk.add(0, aVar2);
                    ((com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(1)).timestamp = 3 * (((com.tencent.mm.plugin.music.a.a.a) aVar3.hCk.get(2)).timestamp >> 2);
                }
            }
        }
        v.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[]{Long.valueOf(be.az(Nj))});
        this.hDE.put(aVar.field_musicId, aVar3);
        return aVar3;
    }

    public final com.tencent.mm.ai.a B(String str, int i, int i2) {
        v.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.ai.a xe = xe(str);
        if (xe == null) {
            v.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[]{str});
            return null;
        }
        xe.field_songBgColor = i;
        xe.field_songLyricColor = i2;
        a(xe, new String[]{"songBgColor", "songLyricColor"});
        this.hDD.put(str, xe);
        return xe;
    }

    public final com.tencent.mm.ai.a m(ajr com_tencent_mm_protocal_c_ajr) {
        com.tencent.mm.ai.a aVar;
        int i;
        String i2 = h.i(com_tencent_mm_protocal_c_ajr);
        com.tencent.mm.ai.a xe = xe(i2);
        if (xe == null) {
            aVar = new com.tencent.mm.ai.a();
            i = 0;
        } else {
            aVar = xe;
            i = 1;
        }
        aVar.field_musicId = i2;
        aVar.field_originMusicId = com_tencent_mm_protocal_c_ajr.mJW;
        aVar.field_musicType = com_tencent_mm_protocal_c_ajr.mJV;
        aVar.field_appId = com_tencent_mm_protocal_c_ajr.glj;
        if (be.kS(aVar.field_appId)) {
            aVar.field_appId = h.k(com_tencent_mm_protocal_c_ajr);
        }
        aVar.field_songAlbum = com_tencent_mm_protocal_c_ajr.mKa;
        aVar.field_songAlbumType = com_tencent_mm_protocal_c_ajr.mKi;
        aVar.field_songWifiUrl = com_tencent_mm_protocal_c_ajr.mKc;
        aVar.field_songName = com_tencent_mm_protocal_c_ajr.mJY;
        aVar.field_songSinger = com_tencent_mm_protocal_c_ajr.mJZ;
        aVar.field_songWapLinkUrl = com_tencent_mm_protocal_c_ajr.mKd;
        aVar.field_songWebUrl = com_tencent_mm_protocal_c_ajr.mKe;
        aVar.field_songAlbumLocalPath = com_tencent_mm_protocal_c_ajr.mKg;
        aVar.field_songMediaId = com_tencent_mm_protocal_c_ajr.mfo;
        aVar.field_songSnsAlbumUser = com_tencent_mm_protocal_c_ajr.mKm;
        aVar.field_songAlbumUrl = com_tencent_mm_protocal_c_ajr.mKb;
        aVar.field_songSnsShareUser = com_tencent_mm_protocal_c_ajr.mKn;
        if (!be.kS(com_tencent_mm_protocal_c_ajr.mKj)) {
            aVar.field_songHAlbumUrl = com_tencent_mm_protocal_c_ajr.mKj;
        }
        aVar.field_updateTime = System.currentTimeMillis();
        if (aVar.field_songId == 0) {
            h.h(com_tencent_mm_protocal_c_ajr);
            aVar.field_songId = com_tencent_mm_protocal_c_ajr.mAi;
        }
        if (be.kS(aVar.field_songWapLinkUrl) || aVar.field_songWapLinkUrl.equals(aVar.field_songWebUrl)) {
            aVar.field_songWapLinkUrl = aVar.field_songWifiUrl;
        }
        if (aVar.field_songId == 0 && com_tencent_mm_protocal_c_ajr.mJV == 4) {
            try {
                aVar.field_songId = Integer.valueOf(com_tencent_mm_protocal_c_ajr.mJW).intValue();
            } catch (Exception e) {
            }
        }
        aVar.field_hideBanner = com_tencent_mm_protocal_c_ajr.mKp;
        if (i != 0) {
            v.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[]{i2});
            a(aVar, new String[0]);
        } else {
            v.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[]{i2});
            b(aVar);
        }
        this.hDD.put(i2, aVar);
        return aVar;
    }

    public final void t(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiDownloadedLength", Long.valueOf(j));
        int update = this.cie.update("Music", contentValues, "musicId=?", new String[]{str});
        v.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.ai.a aVar = (com.tencent.mm.ai.a) this.hDD.get(str);
        if (aVar != null) {
            aVar.field_wifiDownloadedLength = j;
        }
    }

    public final void u(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("songWifiFileLength", Long.valueOf(j));
        int update = this.cie.update("Music", contentValues, "musicId=?", new String[]{str});
        v.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.ai.a aVar = (com.tencent.mm.ai.a) this.hDD.get(str);
        if (aVar != null) {
            aVar.field_songWifiFileLength = j;
        }
    }

    public final void aG(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiEndFlag", Integer.valueOf(i));
        int update = this.cie.update("Music", contentValues, "musicId=?", new String[]{str});
        v.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
        com.tencent.mm.ai.a aVar = (com.tencent.mm.ai.a) this.hDD.get(str);
        if (aVar != null) {
            aVar.field_wifiEndFlag = i;
        }
    }

    public final void v(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadedLength", Long.valueOf(j));
        int update = this.cie.update("Music", contentValues, "musicId=?", new String[]{str});
        v.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.ai.a aVar = (com.tencent.mm.ai.a) this.hDD.get(str);
        if (aVar != null) {
            aVar.field_downloadedLength = j;
        }
    }

    public final void aH(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("endFlag", Integer.valueOf(i));
        int update = this.cie.update("Music", contentValues, "musicId=?", new String[]{str});
        v.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
        com.tencent.mm.ai.a aVar = (com.tencent.mm.ai.a) this.hDD.get(str);
        if (aVar != null) {
            aVar.field_endFlag = i;
        }
    }

    public final void w(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("songFileLength", Long.valueOf(j));
        int update = this.cie.update("Music", contentValues, "musicId=?", new String[]{str});
        v.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.ai.a aVar = (com.tencent.mm.ai.a) this.hDD.get(str);
        if (aVar != null) {
            aVar.field_songFileLength = j;
        }
    }
}
