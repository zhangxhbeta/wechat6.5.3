package com.tencent.mm.plugin.card.b;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static List<WeakReference<a>> eAR = new ArrayList();

    public interface a {
        void ak(String str, int i);

        void bj(String str, String str2);
    }

    public static void a(a aVar) {
        if (eAR == null) {
            eAR = new ArrayList();
        }
        v.i("MicroMsg.CDNDownloadHelpper", "register:%d", new Object[]{Integer.valueOf(aVar.hashCode())});
        if (aVar != null) {
            eAR.add(new WeakReference(aVar));
        }
    }

    public static void b(a aVar) {
        if (eAR != null && aVar != null) {
            v.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", new Object[]{Integer.valueOf(aVar.hashCode())});
            for (int i = 0; i < eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) eAR.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        eAR.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    public static void c(final String str, String str2, int i, int i2) {
        int i3 = 0;
        if (str == null || str2 == null || i == 0) {
            v.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
            return;
        }
        String str3;
        String Kg = z.Kg(str);
        File file = new File(i.eDe);
        if (!file.mkdirs()) {
            v.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + file.exists());
        }
        String str4 = i2 == 2 ? ".jpeg" : ".mp4";
        if (file.getAbsolutePath().endsWith("/")) {
            str3 = file.getAbsolutePath() + Kg + str4;
        } else {
            str3 = file.getAbsolutePath() + File.separator + Kg + str4;
        }
        v.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", new Object[]{Kg, str3});
        v.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3});
        v.i("MicroMsg.CDNDownloadHelpper", "read file length = " + e.aQ(str3));
        WeakReference weakReference;
        if (e.aR(str3) && e.aQ(str3) == i) {
            while (i3 < eAR.size()) {
                weakReference = (WeakReference) eAR.get(i3);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bj(str, str3);
                    }
                }
                i3++;
            }
            return;
        }
        v.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", new Object[]{str3});
        h hVar = new h();
        hVar.cFR = new com.tencent.mm.modelcdntran.h.a() {
            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21005) {
                    v.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", new Object[]{str});
                } else if (i != 0) {
                    v.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
                    for (r1 = 0; r1 < a.eAR.size(); r1++) {
                        r0 = (WeakReference) a.eAR.get(r1);
                        if (r0 != null) {
                            r0.get();
                        }
                    }
                } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                    v.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.toString()});
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength > 0) {
                        r1 = (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength * 100) / com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                    } else {
                        r1 = 0;
                    }
                    if (r1 < 0) {
                        r1 = 0;
                    } else if (r1 > 100) {
                        r1 = 100;
                    }
                    for (int i2 = 0; i2 < a.eAR.size(); i2++) {
                        r0 = (WeakReference) a.eAR.get(i2);
                        if (r0 != null) {
                            r0 = (a) r0.get();
                            if (r0 != null) {
                                r0.ak(str, r1);
                            }
                        }
                    }
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        v.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", new Object[]{str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult});
                        for (r1 = 0; r1 < a.eAR.size(); r1++) {
                            r0 = (WeakReference) a.eAR.get(r1);
                            if (r0 != null) {
                                r0.get();
                            }
                        }
                    } else {
                        v.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult});
                        for (r1 = 0; r1 < a.eAR.size(); r1++) {
                            r0 = (WeakReference) a.eAR.get(r1);
                            if (r0 != null) {
                                r0 = (a) r0.get();
                                if (r0 != null) {
                                    r0.bj(str, str3);
                                }
                            }
                        }
                    }
                }
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                v.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", new Object[]{str});
            }

            public final byte[] i(String str, byte[] bArr) {
                v.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", new Object[]{str});
                return null;
            }
        };
        hVar.cFQ = false;
        hVar.field_mediaId = d.a("cardgiftfile", be.Ni(), str, str);
        hVar.field_fullpath = str3;
        hVar.field_totalLen = i;
        hVar.field_fileType = b.cED;
        hVar.field_fileId = str;
        hVar.field_aesKey = str2;
        hVar.field_priority = b.cEA;
        hVar.field_needStorage = true;
        v.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", new Object[]{Boolean.valueOf(g.DZ().a(hVar, -1)), hVar.field_fileId});
        if (!g.DZ().a(hVar, -1)) {
            while (i3 < eAR.size()) {
                weakReference = (WeakReference) eAR.get(i3);
                if (weakReference != null) {
                    weakReference.get();
                }
                i3++;
            }
            v.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
        }
    }
}
