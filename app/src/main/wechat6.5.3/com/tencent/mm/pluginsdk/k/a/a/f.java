package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

final class f {

    private static final class a {
        static void a(r rVar, g gVar) {
            if (rVar == null) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null");
            } else {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", rVar.field_urlKey, rVar.field_url, Long.valueOf(rVar.field_contentLength), Boolean.valueOf(rVar.field_deleted), rVar.field_eccSignature, Long.valueOf(rVar.field_expireTime), Boolean.valueOf(rVar.field_fileCompress), Boolean.valueOf(rVar.field_fileEncrypt), rVar.field_filePath, Boolean.valueOf(rVar.field_fileUpdated), rVar.field_fileVersion, rVar.field_groupId2, Integer.valueOf(rVar.field_keyVersion), Boolean.valueOf(be.kS(rVar.field_encryptKey)), Integer.valueOf(rVar.field_maxRetryTimes), Integer.valueOf(rVar.field_retryTimes), rVar.field_sampleId, Integer.valueOf(rVar.field_status));
                v.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", rVar.field_encryptKey);
            }
            if (rVar != null && rVar.field_deleted && gVar.GX(rVar.field_fileVersion) <= 0) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", rVar.field_fileVersion, gVar.lgE);
            } else if (rVar == null) {
                r0 = gVar.biU();
                r0.field_fileUpdated = true;
                if (be.kS(r0.field_encryptKey)) {
                    r0.field_keyVersion = -1;
                }
                v.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record " + r0);
                a.lED.e(r0);
                b.lDs.f(gVar.aYo, gVar.aYp, 0, gVar.aYu);
                a(true, true, r0, gVar);
            } else {
                v.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
                rVar.field_networkType = gVar.networkType;
                if (be.kS(rVar.field_originalMd5)) {
                    rVar.field_originalMd5 = gVar.lCU;
                }
                if (gVar.GX(rVar.field_fileVersion) > 0) {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
                    r0 = gVar.biU();
                    if (rVar.field_keyVersion >= gVar.lCS) {
                        r0.field_keyVersion = rVar.field_keyVersion;
                        r0.field_encryptKey = rVar.field_encryptKey;
                    }
                    r0.field_fileUpdated = true;
                    r0.field_deleted = false;
                    a.lED.e(r0);
                    b.lDs.f(gVar.aYo, gVar.aYp, 0, gVar.aYu);
                    a.lED.Hi(gVar.lCO);
                    a(false, true, r0, gVar);
                    return;
                }
                if (rVar.field_status == 2 || rVar.field_status == 1 || rVar.field_status == 0) {
                    long Hj = com.tencent.mm.pluginsdk.k.a.d.a.Hj(rVar.field_filePath);
                    if (rVar.field_contentLength > Hj) {
                        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", Long.valueOf(rVar.field_contentLength), Long.valueOf(Hj));
                        if (0 == Hj) {
                            b.lDs.f(gVar.aYo, gVar.aYp, 0, gVar.aYu);
                            a(false, true, rVar, gVar);
                            return;
                        }
                        a(true, false, rVar, gVar);
                        return;
                    } else if (be.ma(g.aX(i.GZ(gVar.lCO))).equals(rVar.field_md5)) {
                        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt");
                        rVar.field_status = 2;
                        rVar.field_contentLength = com.tencent.mm.pluginsdk.k.a.d.a.Hj(rVar.field_filePath);
                        rVar.field_fileUpdated = false;
                        a.lED.e(rVar);
                        j.q(rVar.field_reportId, 13);
                        j.q(rVar.field_reportId, 44);
                        j.a(rVar.field_resType, rVar.field_subType, rVar.field_url, be.getInt(rVar.field_fileVersion, 0), com.tencent.mm.pluginsdk.k.a.a.j.a.lDP, true, "NewXml".equalsIgnoreCase(rVar.field_groupId2), true, rVar.field_sampleId);
                        if (gVar.lDu || gVar.lDv) {
                            v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request");
                            b.a(rVar, false);
                            return;
                        }
                        b.lDs.a(gVar.aYo, gVar.aYp, i.GZ(gVar.lCO), be.getInt(gVar.lgE, 0));
                        return;
                    }
                } else if (!(rVar.field_status == 4 || rVar.field_status == 3)) {
                    return;
                }
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
                a(false, true, rVar, gVar);
            }
        }

        private static void a(boolean z, boolean z2, r rVar, g gVar) {
            v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", Boolean.valueOf(z), Boolean.valueOf(z2));
            if (rVar.field_maxRetryTimes <= 0 || rVar.field_retryTimes > 0 || z2) {
                rVar.field_status = 0;
                if (z2) {
                    rVar.field_maxRetryTimes = gVar.lCY;
                    rVar.field_retryTimes = gVar.lCY;
                    rVar.field_fileUpdated = true;
                    rVar.field_priority = gVar.priority;
                    if (gVar.fileSize > 0) {
                        rVar.field_fileSize = gVar.fileSize;
                    }
                    a.lED.e(rVar);
                } else {
                    rVar.field_retryTimes--;
                    rVar.field_priority = gVar.priority;
                    a.lED.e(rVar);
                    j.q(rVar.field_reportId, 12);
                }
                if (a.lED.Hh(gVar.lCO)) {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", gVar.lCO);
                    if (gVar.aYu) {
                        j.q(gVar.lCW, 9);
                        j.q(gVar.lCW, 44);
                        return;
                    }
                    return;
                }
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", gVar.lCO);
                if (z2 && !z) {
                    b.lDs.f(rVar.field_resType, rVar.field_subType, 0, be.ma(rVar.field_groupId2).equals("NewXml"));
                }
                l b = c.b(rVar);
                b.ldv = z;
                b.lDt = gVar.lDt;
                if (!z) {
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(b.OZ());
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(b.OZ() + ".decompressed");
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(b.OZ() + ".decrypted");
                }
                a.lED.d(b);
                return;
            }
            v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", Integer.valueOf(rVar.field_maxRetryTimes), Integer.valueOf(rVar.field_retryTimes));
        }
    }

    private static final class b {
        static void a(r rVar, boolean z) {
            if (rVar == null) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
                return;
            }
            String str = rVar.field_urlKey;
            String str2 = rVar.field_filePath;
            String str3 = rVar.field_md5;
            boolean z2 = rVar.field_fileCompress;
            boolean z3 = rVar.field_fileEncrypt;
            Object obj = rVar.field_eccSignature;
            int i = be.getInt(rVar.field_fileVersion, 0);
            int i2 = rVar.field_keyVersion;
            String str4 = rVar.field_encryptKey;
            boolean z4 = rVar.field_deleted;
            v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + z4 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + rVar.field_originalMd5 + ", fileCompress = " + z2 + ", fileEncrypt = " + z3 + ", eccSignature = " + obj + ", fileVersion = " + i + ", (encrypt key == empty) = " + be.kS(str4));
            v.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", str4);
            if (!z3) {
                if (z) {
                    j.q(rVar.field_reportId, 53);
                    j.q(rVar.field_reportId, 45);
                }
                if (!z2) {
                    v.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
                    return;
                }
            }
            if (i2 != i && z3) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", Integer.valueOf(i), Integer.valueOf(i2));
                if (i2 >= 0) {
                    j.q(rVar.field_reportId, 52);
                    j.q(rVar.field_reportId, 45);
                }
            } else if (z4) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
                j.q(rVar.field_reportId, 51);
                j.q(rVar.field_reportId, 45);
            } else if (be.kS(str4) && z3) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
                j.q(rVar.field_reportId, 54);
                j.q(rVar.field_reportId, 45);
            } else if (be.kS(str3) || be.kS(str2)) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", str3, str2);
            } else if (a.lED.Hh(str)) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", str);
            } else if (!be.ma(g.aX(str2)).equals(str3)) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
                rVar.field_status = 3;
                a.lED.e(rVar);
                j.q(rVar.field_reportId, 56);
                j.q(rVar.field_reportId, 45);
            } else if (!a.lED.Hh(str)) {
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request");
                b.lDs.f(rVar.field_resType, rVar.field_subType, 1, be.ma(rVar.field_groupId2).equals("NewXml"));
                b.lDs.a(rVar);
            }
        }
    }
}
