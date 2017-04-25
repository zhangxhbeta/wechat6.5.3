package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.k.a.c.i;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.pluginsdk.k.a.d.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

final class h implements i {
    h() {
    }

    public final void a(r rVar, int i) {
        boolean z = true;
        if (rVar.field_expireTime != 0 && rVar.field_expireTime <= be.Nh()) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", rVar.field_urlKey, Long.valueOf(rVar.field_expireTime));
            a.lED.hp(rVar.field_urlKey);
            a.Hl(rVar.field_filePath);
            a.Hl(rVar.field_filePath + ".decompressed");
            a.Hl(rVar.field_filePath + ".decrypted");
            a.lED.Hi(rVar.field_urlKey);
        } else if (i == 0) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
        } else if (2 == i && 1 == rVar.field_networkType) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
        } else if (rVar.field_deleted) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", rVar.field_urlKey);
            a.Hl(rVar.field_filePath);
            a.Hl(rVar.field_filePath + ".decompressed");
            a.Hl(rVar.field_filePath + ".decrypted");
        } else if (rVar.field_status == 2) {
            long Hj = a.Hj(rVar.field_filePath);
            if (rVar.field_contentLength > Hj) {
                v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
                if (0 == Hj) {
                    if (1 != i) {
                        v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
                        return;
                    }
                    rVar.field_fileUpdated = true;
                    b.lDs.f(rVar.field_resType, rVar.field_subType, 0, be.ma(rVar.field_groupId2).equals("NewXml"));
                    a.lED.e(rVar);
                }
                a.lED.d(c.b(rVar));
            } else if (c(rVar)) {
                v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
                d(rVar);
            } else {
                v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                if (1 != i) {
                    z = false;
                }
                b(rVar, z);
            }
        } else if (rVar.field_status == 1 || rVar.field_status == 0) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", Long.valueOf(rVar.field_contentLength));
            if (a.lED.Hh(rVar.field_urlKey)) {
                v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
                return;
            }
            v.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
            if (c(rVar)) {
                v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
                rVar.field_status = 2;
                rVar.field_contentLength = a.Hj(rVar.field_filePath);
                a.lED.e(rVar);
                d(rVar);
                return;
            }
            if (0 == a.Hj(rVar.field_filePath)) {
                rVar.field_fileUpdated = true;
                a.lED.e(rVar);
                b.lDs.f(rVar.field_resType, rVar.field_subType, 0, be.ma(rVar.field_groupId2).equals("NewXml"));
            }
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
            a.lED.d(c.b(rVar));
        } else if (rVar.field_status == 4 || rVar.field_status == 3) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
            rVar.field_status = 0;
            b(rVar, true);
        }
    }

    private static boolean c(r rVar) {
        return be.ma(g.aX(rVar.field_filePath)).equals(rVar.field_md5);
    }

    private static void b(r rVar, boolean z) {
        a.lED.Hi(rVar.field_urlKey);
        a.Hl(rVar.field_filePath);
        a.Hl(rVar.field_filePath + ".decompressed");
        a.Hl(rVar.field_filePath + ".decrypted");
        if (2 == rVar.field_status && !z) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
        } else if (rVar.field_maxRetryTimes <= 0 || rVar.field_retryTimes > 0) {
            rVar.field_retryTimes--;
            rVar.field_fileUpdated = true;
            a.lED.e(rVar);
            j.q(rVar.field_reportId, 12);
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
            l b = c.b(rVar);
            b.ldv = false;
            a.lED.d(b);
        } else {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", Integer.valueOf(rVar.field_maxRetryTimes), Integer.valueOf(rVar.field_retryTimes));
        }
    }

    private static void d(r rVar) {
        if (rVar.field_fileUpdated) {
            j.q(rVar.field_reportId, 13);
            j.q(rVar.field_reportId, 44);
        }
        if (rVar.field_fileCompress || rVar.field_fileEncrypt) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
            b.lDs.a(rVar);
            return;
        }
        b.lDs.a(rVar.field_resType, rVar.field_subType, rVar.field_filePath, be.getInt(rVar.field_fileVersion, 0));
    }
}
