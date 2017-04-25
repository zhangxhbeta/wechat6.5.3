package com.tencent.mm.plugin.webview.d;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.webview.d.c.b;
import com.tencent.mm.protocal.c.agy;
import com.tencent.mm.protocal.c.aha;
import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Vector;

public final class w implements e {
    private a cNe = new a(this) {
        final /* synthetic */ w lej;

        {
            this.lej = r1;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            v.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", new Object[]{str});
        }

        public final byte[] i(String str, byte[] bArr) {
            v.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", new Object[]{str});
            return null;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            x xVar;
            String str2 = "MicroMsg.WebviewFileChooserCdnService";
            String str3 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo == null ? "null" : com_tencent_mm_modelcdntran_keep_ProgressInfo.toString();
            objArr[3] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "null" : com_tencent_mm_modelcdntran_keep_SceneResult.toString();
            v.i(str2, str3, objArr);
            y bjd = com.tencent.mm.plugin.webview.e.e.bjd();
            if (!be.kS(str)) {
                for (x xVar2 : bjd.les.values()) {
                    if (be.ma(xVar2.mediaId).equals(str)) {
                        xVar = xVar2;
                        break;
                    }
                }
            }
            v.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
            xVar = null;
            if (xVar == null) {
                v.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", new Object[]{str});
                return 0;
            } else if (i == -21005) {
                v.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", new Object[]{str});
                return 0;
            } else if (i != 0) {
                v.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
                this.lej.b(false, xVar.bde, xVar.mediaId, null);
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                v.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.toString()});
                int i2 = 0;
                if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength > 0) {
                    i2 = (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength * 100) / com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                }
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > 100) {
                    i2 = 100;
                }
                this.lej.b(xVar.leo, xVar.bcp, i2, xVar.bde, xVar.mediaId);
                return 0;
            } else {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        v.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[]{str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult});
                        this.lej.b(false, xVar.bde, xVar.mediaId, null);
                    } else {
                        v.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s", new Object[]{str});
                        if (xVar != null) {
                            xVar.b(com_tencent_mm_modelcdntran_keep_SceneResult);
                            if (xVar.leo && xVar.leq) {
                                w wVar = this.lej;
                                if (xVar == null) {
                                    v.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                                } else {
                                    agy com_tencent_mm_protocal_c_agy = new agy();
                                    com_tencent_mm_protocal_c_agy.mGO = xVar.lem.field_aesKey;
                                    com_tencent_mm_protocal_c_agy.mlN = xVar.lem.field_fileLength;
                                    com_tencent_mm_protocal_c_agy.mGN = xVar.lem.field_fileId;
                                    com_tencent_mm_protocal_c_agy.type = xVar.bij();
                                    v.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", new Object[]{xVar.appId, xVar.bde, com_tencent_mm_protocal_c_agy.mGO, Integer.valueOf(com_tencent_mm_protocal_c_agy.mlN), com_tencent_mm_protocal_c_agy.mGN});
                                    com_tencent_mm_protocal_c_agy.mGP = xVar.bii();
                                    ak.vy().a(1034, wVar);
                                    ak.vy().a(new s(xVar.appId, xVar.bde, com_tencent_mm_protocal_c_agy), 0);
                                }
                            } else {
                                this.lej.b(true, xVar.bde, xVar.ldU, xVar.lem.field_fileUrl);
                            }
                        }
                    }
                }
                return 0;
            }
        }
    };
    private Vector<b> leh = new Vector();
    public Vector<c.a> lei = new Vector();

    public final void a(b bVar) {
        if (this.leh != null && bVar != null) {
            this.leh.remove(bVar);
        }
    }

    private void b(boolean z, String str, String str2, String str3) {
        if (this.leh != null && this.leh.size() > 0) {
            Iterator it = this.leh.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(z, str, str2, str3);
            }
        }
    }

    final void b(boolean z, int i, int i2, String str, String str2) {
        v.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2});
        if (this.lei != null && this.lei.size() > 0) {
            Iterator it = this.lei.iterator();
            while (it.hasNext()) {
                ((c.a) it.next()).a(z, i, i2, str, str2);
            }
        }
    }

    public final boolean a(String str, String str2, b bVar) {
        y bjd = com.tencent.mm.plugin.webview.e.e.bjd();
        if (!be.kS(str2)) {
            for (x xVar : bjd.les.values()) {
                if (be.ma(xVar.ldU).equals(str2)) {
                    break;
                }
            }
        }
        v.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
        x xVar2 = null;
        if (xVar2 != null) {
            xVar2.appId = str;
            v.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[]{str, str2, xVar2.bde});
            bVar.a(true, xVar2.bde, xVar2.ldU, null);
        } else {
            ak.vy().a(1035, this);
            ak.vy().a(new f(str, str2), 0);
            this.leh.add(bVar);
        }
        return true;
    }

    private void a(x xVar) {
        h hVar = new h();
        hVar.cFR = this.cNe;
        hVar.cFQ = false;
        hVar.field_mediaId = xVar.mediaId;
        hVar.field_fullpath = xVar.lel;
        hVar.field_totalLen = xVar.lem.field_fileLength;
        hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
        hVar.field_fileId = xVar.lem.field_fileId;
        hVar.field_aesKey = xVar.lem.field_aesKey;
        hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
        hVar.field_needStorage = false;
        hVar.field_isStreamMedia = false;
        v.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[]{Boolean.valueOf(g.DZ().a(hVar, -1)), xVar.ldU});
        if (!g.DZ().a(hVar, -1)) {
            b(false, null, null, null);
        }
    }

    public final boolean a(String str, String str2, int i, int i2, int i3, b bVar) {
        x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str2);
        if (DW == null) {
            v.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str2});
            return false;
        }
        DW.appId = str;
        if (bVar != null) {
            this.leh.add(bVar);
        }
        if (i2 == 202) {
            DW.leq = false;
        }
        DW.leo = true;
        h hVar = new h();
        hVar.cFR = this.cNe;
        hVar.cFQ = true;
        hVar.field_mediaId = DW.mediaId;
        hVar.field_fullpath = DW.lel;
        hVar.field_fileType = i;
        hVar.field_talker = "weixin";
        hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
        if (i == com.tencent.mm.modelcdntran.b.cED) {
            hVar.field_needStorage = true;
        } else {
            hVar.field_needStorage = false;
        }
        hVar.field_isStreamMedia = false;
        hVar.field_appType = i2;
        hVar.field_bzScene = i3;
        hVar.field_force_aeskeycdn = true;
        hVar.field_trysafecdn = false;
        v.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[]{Boolean.valueOf(g.DZ().b(hVar)), Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn), str2});
        return g.DZ().b(hVar);
    }

    public final boolean b(String str, String str2, b bVar) {
        return a(str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, bVar);
    }

    public static boolean DR(String str) {
        x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str);
        if (DW != null) {
            return g.DZ().ip(DW.mediaId);
        }
        v.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str});
        return false;
    }

    public static boolean DS(String str) {
        v.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[]{str});
        return g.DZ().iq(str);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        String str2;
        String str3;
        String str4;
        String str5;
        switch (kVar.getType()) {
            case 1034:
                ak.vy().b(1034, this);
                s sVar = (s) kVar;
                str2 = ((ahe) sVar.cif.czl.czs).mGQ;
                str3 = sVar.appId;
                str4 = sVar.bde;
                x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str4);
                String str6 = "MicroMsg.WebviewFileChooserCdnService";
                str5 = "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b";
                Object[] objArr = new Object[4];
                objArr[0] = str2;
                objArr[1] = str3;
                objArr[2] = str4;
                objArr[3] = Boolean.valueOf(DW == null);
                v.i(str6, str5, objArr);
                if (i != 0 || i2 != 0) {
                    v.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
                    if (DW != null) {
                        b(false, DW.bde, DW.mediaId, null);
                        return;
                    }
                    return;
                } else if (!be.kS(str3) && !be.kS(str2) && DW != null) {
                    DW.ldU = str2;
                    b(true, DW.bcp, 100, DW.bde, DW.ldU);
                    b(true, DW.bde, DW.ldU, DW.lem.field_fileUrl);
                    return;
                } else {
                    return;
                }
            case 1035:
                ak.vy().b(1035, this);
                if (i == 0 && i2 == 0) {
                    f fVar = (f) kVar;
                    str2 = fVar.appId;
                    str3 = fVar.ldU;
                    agy com_tencent_mm_protocal_c_agy = ((aha) fVar.cif.czl.czs).mGR;
                    str5 = "MicroMsg.WebviewFileChooserCdnService";
                    String str7 = "appid = %s, serverId = %s, cdninfo == null ? %b";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = str2;
                    objArr2[1] = str3;
                    objArr2[2] = Boolean.valueOf(com_tencent_mm_protocal_c_agy == null);
                    v.i(str5, str7, objArr2);
                    if (!be.kS(str2) && !be.kS(str3) && com_tencent_mm_protocal_c_agy != null) {
                        str4 = com_tencent_mm_protocal_c_agy.type;
                        v.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[]{str4});
                        if (!be.kS(str4)) {
                            x DU;
                            if (str4.toLowerCase().equals("voice")) {
                                DU = x.DU(ah.Eb(str2));
                            } else if (str4.toLowerCase().equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                                DU = x.DV(ah.DX(be.Ni()));
                            } else {
                                DU = x.DT(ah.DX(be.Ni()));
                            }
                            DU.leo = false;
                            DU.appId = str2;
                            DU.ldU = str3;
                            if (DU.lem == null) {
                                DU.lem = new x.a();
                            }
                            if (com_tencent_mm_protocal_c_agy == null) {
                                v.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
                            } else {
                                DU.lem.field_aesKey = com_tencent_mm_protocal_c_agy.mGO;
                                DU.lem.field_fileId = com_tencent_mm_protocal_c_agy.mGN;
                                DU.lem.field_fileLength = com_tencent_mm_protocal_c_agy.mlN;
                            }
                            com.tencent.mm.plugin.webview.e.e.bjd().b(DU);
                            a(DU);
                            return;
                        }
                        return;
                    }
                    return;
                }
                v.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
                b(false, null, null, null);
                return;
            default:
                return;
        }
    }
}
