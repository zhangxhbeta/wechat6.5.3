package com.tencent.mm.plugin.record.a;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public final class h extends f<g> {
    private a cNe = new a(this) {
        final /* synthetic */ h ipv;

        {
            this.ipv = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            v.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", new Object[]{Integer.valueOf(i), str});
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                v.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)});
            }
            if (i == -21006 || i == -21005) {
                this.ipv.aJA();
                return 0;
            }
            final g yx = s.aJE().yx(str);
            if (yx == null) {
                v.w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", new Object[]{str});
                this.ipv.aJA();
                return 0;
            }
            if (i != 0) {
                v.w("MicroMsg.RecordMsgCDNService", "tran fail, startRet[%d], mediaId[%s], type[%d]", new Object[]{Integer.valueOf(i), str, Integer.valueOf(yx.field_type)});
                if (-5103059 == i) {
                    yx.field_status = 4;
                } else {
                    yx.field_status = 3;
                }
                yx.field_errCode = i;
                s.aJE().b(yx, "localId");
            } else {
                if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                    yx.field_offset = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                    yx.field_totalLen = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                    yx.field_status = 1;
                    s.aJE().b(yx, "localId");
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    v.i("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck), be.KW(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey), com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5});
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode >= 0) {
                        yx.field_status = 2;
                        if (1 == yx.field_type) {
                            String str2 = yx.field_path + ".temp";
                            String str3 = yx.field_path;
                            if (be.kS(str2) || be.kS(str3)) {
                                v.w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
                            } else {
                                File file = new File(str2);
                                File file2 = new File(str3);
                                if (file.exists()) {
                                    boolean renameTo = file.renameTo(file2);
                                    v.v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", new Object[]{Boolean.valueOf(renameTo), str2, file2});
                                }
                            }
                            s.aJE().a(yx, "localId");
                        } else {
                            v.i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, str});
                            v.d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult});
                            v.d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId});
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.isUploadBySafeCDNWithMD5()) {
                                v.i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", new Object[]{Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_upload_by_safecdn), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc), com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey, com_tencent_mm_modelcdntran_keep_SceneResult.field_mp4identifymd5});
                                ak.vy().a(new z(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5, com_tencent_mm_modelcdntran_keep_SceneResult.field_mp4identifymd5, com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc, new z.a(this) {
                                    final /* synthetic */ AnonymousClass1 ipy;

                                    public final void D(String str, int i, int i2) {
                                        v.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                                        if (i == 4 && i2 == 102) {
                                            v.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", new Object[]{Integer.valueOf(yx.field_status), Integer.valueOf(yx.field_offset), Integer.valueOf(yx.field_totalLen)});
                                            yx.field_offset = 0;
                                            yx.field_totalLen = 0;
                                            yx.field_status = 0;
                                            s.aJE().b(yx, "localId");
                                            this.ipy.ipv.a(yx, false);
                                            return;
                                        }
                                        yx.field_cdnKey = str;
                                        yx.field_cdnUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                                        s.aJE().b(yx, "localId");
                                        this.ipy.ipv.aJA();
                                    }
                                }), 0);
                                return 0;
                            }
                            yx.field_cdnKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                            yx.field_cdnUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                            s.aJE().b(yx, "localId");
                        }
                    } else {
                        v.e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                        if (-5103059 == com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode) {
                            yx.field_status = 4;
                        } else {
                            yx.field_status = 3;
                        }
                        yx.field_errCode = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                        s.aJE().b(yx, "localId");
                    }
                }
                return 0;
            }
            this.ipv.aJA();
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };

    protected final /* bridge */ /* synthetic */ void a(f.a aVar) {
        a((g) aVar, true);
    }

    protected final List<g> aJz() {
        i aJE = s.aJE();
        List<g> linkedList = new LinkedList();
        Cursor rawQuery = aJE.cie.rawQuery("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2", null);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            while (!rawQuery.isAfterLast()) {
                g gVar = new g();
                gVar.b(rawQuery);
                linkedList.add(gVar);
                rawQuery.moveToNext();
            }
            rawQuery.close();
        }
        v.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[]{Integer.valueOf(linkedList.size())});
        v.d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    final void a(g gVar, boolean z) {
        v.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", new Object[]{gVar.field_dataId, gVar.field_mediaId, Integer.valueOf(gVar.field_type), Integer.valueOf(gVar.field_status)});
        com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
        hVar.cFR = this.cNe;
        hVar.field_mediaId = gVar.field_mediaId;
        if (2 == gVar.field_type) {
            hVar.cFQ = true;
            hVar.field_priority = b.cEz;
            hVar.field_needStorage = false;
            hVar.field_totalLen = gVar.field_totalLen;
            hVar.field_aesKey = gVar.field_cdnKey;
            hVar.field_fileId = gVar.field_cdnUrl;
            hVar.cFR = this.cNe;
            hVar.field_fullpath = gVar.field_path;
            hVar.field_fileType = gVar.field_fileType;
            hVar.field_talker = gVar.field_toUser;
            hVar.field_force_aeskeycdn = false;
            hVar.field_trysafecdn = true;
            hVar.field_enable_hitcheck = z;
            v.i("MicroMsg.RecordMsgCDNService", "summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b]", new Object[]{Boolean.valueOf(hVar.field_force_aeskeycdn), Integer.valueOf(hVar.field_fileType), hVar.field_aesKey, hVar.field_fileId, Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn), Boolean.valueOf(hVar.field_enable_hitcheck)});
            g.DZ().b(hVar);
        } else {
            hVar.cFQ = false;
            hVar.field_priority = b.cEA;
            hVar.field_needStorage = false;
            hVar.field_totalLen = gVar.field_totalLen;
            hVar.field_aesKey = gVar.field_cdnKey;
            hVar.field_fileId = gVar.field_cdnUrl;
            hVar.cFR = this.cNe;
            hVar.field_fullpath = gVar.field_path + ".temp";
            hVar.field_fileType = gVar.field_fileType;
            g.DZ().a(hVar, -1);
        }
        v.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", new Object[]{Boolean.valueOf(hVar.cFQ), Integer.valueOf(hVar.field_totalLen), hVar.field_aesKey, hVar.field_fileId, hVar.field_fullpath, Integer.valueOf(hVar.field_fileType), Boolean.valueOf(hVar.field_enable_hitcheck), Boolean.valueOf(hVar.field_force_aeskeycdn)});
    }
}
