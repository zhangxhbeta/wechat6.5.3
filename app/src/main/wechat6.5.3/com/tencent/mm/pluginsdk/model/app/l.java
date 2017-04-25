package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.k;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.sdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.sdk.modelmsg.WXEmojiObject;
import com.tencent.mm.sdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.sdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.sdk.modelmsg.WXFileObject;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMusicObject;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXVideoObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public final class l {
    public static boolean GA(String str) {
        if (be.kS(str) || str.equals("0:0")) {
            return false;
        }
        return true;
    }

    public static void GB(String str) {
        c Gu = am.Wf().Gu(str);
        if (Gu != null) {
            b.deleteFile(Gu.field_fileFullPath);
            am.Wf().c(Gu, "mediaId");
        }
    }

    public static void dA(long j) {
        c Wf = am.Wf();
        Wf.cie.dF("appattach", " update appattach set status = 198" + " , lastModifyTime = " + be.Nh() + " where rowid = " + j);
        Wf.Ls();
        c bVar = new b();
        am.Wf().b(j, bVar);
        if (bVar.field_msgInfoId > 0) {
            ak.yW();
            at ek = com.tencent.mm.model.c.wJ().ek(bVar.field_msgInfoId);
            if (ek.field_msgId == bVar.field_msgInfoId) {
                ek.dh(5);
                ak.yW();
                com.tencent.mm.model.c.wJ().a(ek.field_msgId, ek);
            }
        }
    }

    public static int GC(String str) {
        a dV = a.dV(str);
        if (dV == null) {
            return -1;
        }
        if (!GA(dV.aXa)) {
            return -1;
        }
        b bVar = new b();
        long j = be.getLong(dV.aXa, -1);
        if (j != -1) {
            am.Wf().b(j, (c) bVar);
            if (bVar.nmb != j) {
                bVar = am.Wf().Gu(dV.aXa);
                if (bVar == null || !bVar.field_mediaSvrId.equals(dV.aXa)) {
                    return -1;
                }
            }
        }
        bVar = am.Wf().Gu(dV.aXa);
        if (bVar == null || !bVar.field_mediaSvrId.equals(dV.aXa)) {
            return -1;
        }
        if (bVar.field_totalLen == 0) {
            return -1;
        }
        return (int) ((bVar.field_offset * 100) / bVar.field_totalLen);
    }

    public static String b(long j, String str, String str2) {
        v.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", Long.valueOf(j), str, str2);
        a dV = a.dV(str);
        if (dV == null) {
            return null;
        }
        String str3;
        String str4;
        if (str2 != null) {
            str3 = str2;
        } else {
            str4 = e.cge + (be.ma(dV.title).length() > 0 ? dV.title : "da_" + be.Ni());
            if (com.tencent.mm.a.e.aR(str4)) {
                str4 = e.cge + be.Nh() + dV.title;
            }
            str3 = (be.kS(dV.coc) || str4.endsWith(dV.coc)) ? str4 : str4 + "." + dV.coc;
        }
        if (be.kS(dV.aXa) && !be.kS(dV.coi)) {
            dV.aXa = dV.coi.hashCode();
        }
        int i = dV.sdkVer;
        String str5 = dV.appId;
        String str6 = dV.aXa;
        int i2 = dV.cob;
        int i3 = dV.type;
        str4 = dV.cop;
        return a(str3, j, i, str5, str6, i2, i3, dV.cof);
    }

    public static String a(String str, long j, int i, String str2, String str3, int i2, int i3, int i4) {
        c bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = be.Ni();
        bVar.field_lastModifyTime = be.Nh();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        bVar.field_type = (long) i3;
        v.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", Boolean.valueOf(am.Wf().b(bVar)), Long.valueOf(bVar.nmb), Long.valueOf(bVar.field_totalLen), Long.valueOf(bVar.field_type), Integer.valueOf(i4), str, be.bur());
        return str3;
    }

    public static b a(String str, long j, int i, String str2, String str3, int i2) {
        b bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = be.Ni();
        bVar.field_lastModifyTime = be.Nh();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        return bVar;
    }

    public static b a(String str, a aVar, String str2) {
        v.d("MicroMsg.AppMsgLogic", g.sm() + " summerbig buildUploadAttachInfo clientAppDataId:" + str + " attach file :" + str2);
        if (str2.replace("//", "/").startsWith(e.cnf)) {
            v.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", str2.replace("//", "/"));
            return null;
        }
        c bVar = new b();
        bVar.field_totalLen = (long) aVar.cob;
        bVar.field_fileFullPath = str2;
        bVar.field_sdkVer = (long) aVar.sdkVer;
        bVar.field_appId = aVar.appId;
        bVar.field_clientAppDataId = str;
        bVar.field_type = (long) aVar.type;
        bVar.field_status = 200;
        bVar.field_isUpload = true;
        bVar.field_createTime = be.Ni();
        bVar.field_lastModifyTime = be.Nh();
        bVar.field_mediaSvrId = be.Ni();
        am.Wf().b(bVar);
        v.d("MicroMsg.AppMsgLogic", g.sm() + " summerbig buildUploadAttachInfo file:" + bVar.field_fileFullPath + " rowid:" + bVar.nmb + " clientAppDataId:" + bVar.field_clientAppDataId);
        if (bVar.nmb >= 0) {
            return bVar;
        }
        v.e("MicroMsg.AppMsgLogic", g.sm() + " summerbig uploadAttach insert appattach info failed :" + bVar.nmb);
        return null;
    }

    public static int n(long j, String str) {
        ak.yW();
        at ek = com.tencent.mm.model.c.wJ().ek(j);
        if (ek.field_msgId != j) {
            v.e("MicroMsg.AppMsgLogic", g.sm() + " getmsgFailed id:" + j);
            return 0 - g.sk();
        }
        a dV = a.dV(ek.field_content);
        if (dV == null) {
            v.e("MicroMsg.AppMsgLogic", g.sm() + " getmsgFailed id:" + j);
            return 0 - g.sk();
        }
        dV.aXa = str;
        ek.setContent(a.b(dV));
        ak.yW();
        com.tencent.mm.model.c.wJ().a(ek.field_msgId, ek);
        c dz = am.bnC().dz(j);
        dz.field_xml = ek.field_content;
        am.bnC().a(dz, "msgId");
        c dy = am.Wf().dy(j);
        dy.field_mediaSvrId = str;
        dy.field_offset = dy.field_totalLen;
        am.Wf().a(dy, new String[0]);
        return 0;
    }

    public static int a(a aVar, String str, String str2, String str3, String str4, byte[] bArr) {
        return a(aVar, str, str2, str3, str4, bArr, null);
    }

    public static int a(a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5) {
        return a(aVar, str, str2, str3, str4, bArr, str5, SQLiteDatabase.KeyEmpty);
    }

    public static int a(a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6) {
        v.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", str4, aVar);
        c cVar = null;
        String str7 = System.currentTimeMillis();
        if (!be.kS(str4)) {
            cVar = a(str7, aVar, str4);
            if (cVar == null) {
                return 0 - g.sk();
            }
        }
        bx atVar = new at();
        if (bArr != null && bArr.length > 0) {
            if (aVar.type == 33) {
                str7 = n.GH().a(bArr, CompressFormat.PNG, (int) (d.bsM().density * 215.0f), (int) (d.bsM().density * 215.0f));
            } else {
                str7 = n.GH().a(6, bArr, aVar.type == 2, CompressFormat.PNG);
            }
            v.d("MicroMsg.AppMsgLogic", g.sm() + " thumbData MsgInfo path:" + str7);
            if (!be.kS(str7)) {
                atVar.cI(str7);
                v.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + str7);
            }
        }
        if (cVar != null) {
            aVar.aXa = cVar.nmb;
        }
        atVar.setContent(a.b(aVar));
        atVar.dh(1);
        atVar.cH(str3);
        atVar.z(aw.fN(str3));
        atVar.di(1);
        atVar.setType(h(aVar.type, aVar.aXx, aVar.cov, aVar.cow, aVar.cpT));
        if (com.tencent.mm.modelbiz.e.hC(atVar.field_talker)) {
            atVar.cN(com.tencent.mm.modelbiz.a.e.zr());
            v.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", atVar.bNo);
        }
        ak.yW();
        long R = com.tencent.mm.model.c.wJ().R(atVar);
        v.d("MicroMsg.AppMsgLogic", g.sm() + " msginfo insert id: " + R);
        if (R < 0) {
            v.e("MicroMsg.AppMsgLogic", g.sm() + "insert msg failed :" + R);
            return 0 - g.sk();
        }
        v.i("MicroMsg.AppMsgLogic", g.sk() + " new msg inserted to db , local id = " + R);
        atVar.x(R);
        c aVar2 = new com.tencent.mm.q.a();
        aVar2.field_xml = atVar.field_content;
        aVar2.field_appId = str;
        aVar2.field_title = aVar.title;
        aVar2.field_type = aVar.type;
        aVar2.field_description = aVar.description;
        aVar2.field_msgId = R;
        aVar2.field_source = str2;
        am.bnC().b(aVar2);
        String str8 = "MicroMsg.AppMsgLogic";
        String str9 = "summerbig sendAppMsg attInfo is null[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(cVar == null);
        v.i(str8, str9, objArr);
        if (cVar != null) {
            cVar.field_msgInfoId = R;
            cVar.field_status = 101;
            am.Wf().a(cVar, new String[0]);
            if (aVar.type == 2 || !be.kS(str5)) {
                am.bnE().o(R, str5);
            }
            am.bnE().run();
        } else {
            am.bnE();
            al.a.c(R, str5, str6);
        }
        return 0;
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4) {
        return a(wXMediaMessage, str, str2, str3, i, str4, null);
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4, String str5) {
        a aVar = new a();
        aVar.appId = str;
        aVar.appName = str2;
        aVar.coe = i;
        return a(aVar, wXMediaMessage, str3, str4, str5);
    }

    public static int a(a aVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        c cVar;
        c a;
        String a2;
        String a3 = a(aVar, wXMediaMessage, str2);
        v.d("MicroMsg.AppMsgLogic", g.sm() + "summerbig content url:" + aVar.url + " lowUrl:" + aVar.coa + " attachlen:" + aVar.cob + " attachid:" + aVar.aXa + " attach file:" + a3);
        String str4 = System.currentTimeMillis();
        if (be.kS(a3)) {
            cVar = null;
        } else {
            a = a(str4, aVar, a3);
            if (a == null) {
                return 0 - g.sk();
            }
            Options JS = d.JS(a3);
            if (JS != null) {
                aVar.coo = JS.outWidth;
                aVar.con = JS.outHeight;
            }
            cVar = a;
        }
        bx atVar = new at();
        if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
            if (wXMediaMessage.thumbData.length > WXMediaMessage.THUMB_LENGTH_LIMIT) {
                a2 = n.GH().a(6, wXMediaMessage.thumbData, aVar.type == 2, CompressFormat.JPEG);
            } else {
                a2 = n.GH().f(6, wXMediaMessage.thumbData);
            }
            v.d("MicroMsg.AppMsgLogic", g.sm() + " summerbig thumbData MsgInfo path:" + a2);
            if (!be.kS(a2)) {
                atVar.cI(a2);
            }
        }
        if (cVar != null) {
            aVar.aXa = cVar.nmb;
        }
        for (String a22 : be.g(str.split(","))) {
            aVar.cod = str2;
            atVar.setContent(a.b(aVar));
            atVar.dh(1);
            atVar.cH(a22);
            atVar.z(aw.fN(a22));
            atVar.di(1);
            atVar.setType(h(aVar.type, aVar.aXx, aVar.cov, aVar.cow, aVar.cpT));
            if (com.tencent.mm.modelbiz.e.hC(atVar.field_talker)) {
                atVar.cN(com.tencent.mm.modelbiz.a.e.zr());
            }
            ak.yW();
            long R = com.tencent.mm.model.c.wJ().R(atVar);
            if (R < 0) {
                v.e("MicroMsg.AppMsgLogic", g.sm() + " summerbig insert msg failed :" + R);
                return 0 - g.sk();
            }
            v.i("MicroMsg.AppMsgLogic", g.sk() + " summerbig new msg inserted to db , local id = " + R);
            atVar.x(R);
            a = new com.tencent.mm.q.a();
            a.field_xml = atVar.field_content;
            a.field_title = wXMediaMessage.title;
            a.field_type = wXMediaMessage.mediaObject.type();
            a.field_description = wXMediaMessage.description;
            a.field_msgId = R;
            a.field_source = aVar.appName;
            am.bnC().b(a);
            if (cVar != null) {
                cVar.field_msgInfoId = R;
                cVar.field_status = 101;
                v.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", Long.valueOf(cVar.field_msgInfoId), Long.valueOf(cVar.field_status), Long.valueOf(cVar.nmb), Integer.valueOf(a.field_type));
                am.Wf().a(cVar, new String[0]);
                if (!be.kS(str3)) {
                    am.bnE().o(cVar.field_msgInfoId, str3);
                }
                am.bnE().run();
            } else {
                v.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", cVar, Long.valueOf(R), str3, Integer.valueOf(a.field_type));
                am.bnE();
                al.a.p(R, str3);
            }
        }
        return 0;
    }

    private static String aS(byte[] bArr) {
        if (be.bl(bArr)) {
            v.e("MicroMsg.AppMsgLogic", g.sm() + " attachBuf is null");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.xd()).append("ua_").append(be.Ni()).toString();
        v.d("MicroMsg.AppMsgLogic", g.sm() + " buildUploadAttachInfo file:" + stringBuilder2);
        if (com.tencent.mm.a.e.b(stringBuilder2, bArr, bArr.length) == 0) {
            return stringBuilder2;
        }
        v.e("MicroMsg.AppMsgLogic", g.sm() + " writeFile error file:" + stringBuilder2);
        return null;
    }

    public static String a(a aVar, WXMediaMessage wXMediaMessage, String str) {
        v.d("MicroMsg.AppMsgLogic", g.sm() + "mediaMessageToContent sdkver:" + wXMediaMessage.sdkVer + " title:" + wXMediaMessage.title + " desc:" + wXMediaMessage.description + " type:" + wXMediaMessage.mediaObject.type());
        aVar.sdkVer = wXMediaMessage.sdkVer;
        aVar.title = wXMediaMessage.title;
        aVar.description = wXMediaMessage.description;
        aVar.mediaTagName = wXMediaMessage.mediaTagName;
        aVar.messageAction = wXMediaMessage.messageAction;
        aVar.messageExt = wXMediaMessage.messageExt;
        WXMediaMessage.b bVar = wXMediaMessage.mediaObject;
        aVar.type = bVar.type();
        if (aVar.type == 7) {
            WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) bVar;
            aVar.extInfo = wXAppExtendObject.extInfo;
            if (be.bl(wXAppExtendObject.fileData)) {
                aVar.cob = com.tencent.mm.a.e.aQ(wXAppExtendObject.filePath);
                v.d("MicroMsg.AppMsgLogic", g.sm() + " read file:" + wXAppExtendObject.filePath + " len:" + aVar.cob);
                if (aVar.cob <= 0) {
                    return null;
                }
                aVar.coc = com.tencent.mm.a.e.aS(wXAppExtendObject.filePath);
                return wXAppExtendObject.filePath;
            }
            v.d("MicroMsg.AppMsgLogic", g.sm() + " fileData:" + wXAppExtendObject.fileData.length);
            aVar.cob = wXAppExtendObject.fileData.length;
            return aS(wXAppExtendObject.fileData);
        } else if (aVar.type == 6) {
            WXFileObject wXFileObject = (WXFileObject) bVar;
            if (be.bl(wXFileObject.fileData)) {
                aVar.cob = com.tencent.mm.a.e.aQ(wXFileObject.filePath);
                v.d("MicroMsg.AppMsgLogic", g.sm() + " read file:" + wXFileObject.filePath + " len:" + aVar.cob);
                if (aVar.cob <= 0) {
                    return null;
                }
                aVar.coc = com.tencent.mm.a.e.aS(wXFileObject.filePath);
                return wXFileObject.filePath;
            }
            v.d("MicroMsg.AppMsgLogic", g.sm() + " fileData:" + wXFileObject.fileData.length);
            aVar.cob = wXFileObject.fileData.length;
            return aS(wXFileObject.fileData);
        } else if (aVar.type == 2) {
            WXImageObject wXImageObject = (WXImageObject) bVar;
            if (!be.bl(wXImageObject.imageData)) {
                v.d("MicroMsg.AppMsgLogic", g.sm() + " fileData:" + wXImageObject.imageData.length);
                aVar.cob = wXImageObject.imageData.length;
                return aS(wXImageObject.imageData);
            } else if (be.kS(wXImageObject.imagePath)) {
                return null;
            } else {
                aVar.cob = com.tencent.mm.a.e.aQ(wXImageObject.imagePath);
                v.d("MicroMsg.AppMsgLogic", g.sm() + " read file:" + wXImageObject.imagePath + " len:" + aVar.cob);
                if (aVar.cob <= 0) {
                    return null;
                }
                aVar.coc = com.tencent.mm.a.e.aS(wXImageObject.imagePath);
                ak.yW();
                String absolutePath = new File(com.tencent.mm.model.c.xd(), "appmsg_img_" + System.currentTimeMillis()).getAbsolutePath();
                Options JS = d.JS(wXImageObject.imagePath);
                if (JS == null || JS.outWidth <= 0 || JS.outHeight <= 0) {
                    boolean z;
                    String str2 = "MicroMsg.AppMsgLogic";
                    String str3 = "options is null! %B, bitmapWidth = %d, bitmapHeight = %d";
                    Object[] objArr = new Object[3];
                    if (JS == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Integer.valueOf(JS == null ? -1 : JS.outWidth);
                    objArr[2] = Integer.valueOf(JS == null ? -1 : JS.outHeight);
                    v.e(str2, str3, objArr);
                    return null;
                } else if (k.a(wXImageObject.imagePath, SQLiteDatabase.KeyEmpty, true)) {
                    return wXImageObject.imagePath;
                } else {
                    if (JS.outWidth > 960 || JS.outHeight > 960) {
                        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                        Bitmap a = d.a(wXImageObject.imagePath, 960, 960, false, decodeResultLogger, 0);
                        if (a != null) {
                            try {
                                d.a(a, 100, CompressFormat.JPEG, absolutePath, true);
                            } catch (Throwable e) {
                                v.a("MicroMsg.AppMsgLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                return null;
                            }
                        }
                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(wXImageObject.imagePath, 6, decodeResultLogger));
                        }
                        return null;
                    } else if (com.tencent.mm.a.e.p(wXImageObject.imagePath, absolutePath) < 0) {
                        return null;
                    }
                    return absolutePath;
                }
            }
        } else if (aVar.type == 3) {
            WXMusicObject wXMusicObject = (WXMusicObject) bVar;
            aVar.url = wXMusicObject.musicUrl;
            aVar.coa = wXMusicObject.musicLowBandUrl;
            aVar.cos = wXMusicObject.musicDataUrl;
            aVar.cot = wXMusicObject.musicLowBandDataUrl;
            return null;
        } else if (aVar.type == 4) {
            WXVideoObject wXVideoObject = (WXVideoObject) bVar;
            aVar.url = wXVideoObject.videoUrl;
            aVar.coa = wXVideoObject.videoLowBandUrl;
            return null;
        } else if (aVar.type == 5) {
            WXWebpageObject wXWebpageObject = (WXWebpageObject) bVar;
            aVar.url = wXWebpageObject.webpageUrl;
            if (!be.kS(wXWebpageObject.extInfo)) {
                aVar.extInfo = wXWebpageObject.extInfo;
            }
            if (!be.kS(wXWebpageObject.canvasPageXml)) {
                aVar.canvasPageXml = wXWebpageObject.canvasPageXml;
            }
            return null;
        } else if (aVar.type == 1) {
            aVar.title = ((WXTextObject) bVar).text;
            return null;
        } else {
            if (aVar.type == 8) {
                WXEmojiObject wXEmojiObject = (WXEmojiObject) bVar;
                if (!be.bl(wXEmojiObject.emojiData)) {
                    v.d("MicroMsg.AppMsgLogic", g.sm() + " fileData:" + wXEmojiObject.emojiData.length);
                    aVar.cob = wXEmojiObject.emojiData.length;
                    return aS(wXEmojiObject.emojiData);
                } else if (be.kS(wXEmojiObject.emojiPath)) {
                    aVar.cod = str;
                } else {
                    aVar.cob = com.tencent.mm.a.e.aQ(wXEmojiObject.emojiPath);
                    v.d("MicroMsg.AppMsgLogic", g.sm() + " read file:" + wXEmojiObject.emojiPath + " len:" + aVar.cob);
                    if (aVar.cob <= 0) {
                        return null;
                    }
                    aVar.coc = com.tencent.mm.a.e.aS(wXEmojiObject.emojiPath);
                    return wXEmojiObject.emojiPath;
                }
            } else if (aVar.type == 15) {
                r0 = (WXEmojiSharedObject) bVar;
                aVar.thumburl = r0.thumburl;
                aVar.coG = r0.packageflag;
                aVar.coF = r0.packageid;
                aVar.aXx = 8;
                aVar.url = r0.url;
                return null;
            } else if (aVar.type == 13) {
                r0 = (WXEmojiSharedObject) bVar;
                aVar.thumburl = r0.thumburl;
                aVar.coG = r0.packageflag;
                aVar.coF = r0.packageid;
                aVar.aXx = 8;
                aVar.url = r0.url;
                return null;
            } else if (aVar.type == 25) {
                WXDesignerSharedObject wXDesignerSharedObject = (WXDesignerSharedObject) bVar;
                aVar.thumburl = wXDesignerSharedObject.thumburl;
                aVar.url = wXDesignerSharedObject.url;
                aVar.cqd = wXDesignerSharedObject.designerUIN;
                aVar.designerName = wXDesignerSharedObject.designerName;
                aVar.designerRediretctUrl = wXDesignerSharedObject.designerRediretctUrl;
                aVar.aXx = 18;
                return null;
            } else if (aVar.type == 27 || aVar.type == 26) {
                WXEmojiPageSharedObject wXEmojiPageSharedObject = (WXEmojiPageSharedObject) bVar;
                aVar.thumburl = wXEmojiPageSharedObject.iconUrl;
                aVar.url = wXEmojiPageSharedObject.url;
                aVar.tid = wXEmojiPageSharedObject.tid;
                aVar.cqe = wXEmojiPageSharedObject.title;
                aVar.desc = wXEmojiPageSharedObject.desc;
                aVar.iconUrl = wXEmojiPageSharedObject.iconUrl;
                aVar.secondUrl = wXEmojiPageSharedObject.secondUrl;
                aVar.pageType = wXEmojiPageSharedObject.pageType;
                aVar.aXx = 20;
                return null;
            }
            return null;
        }
    }

    public static b GD(String str) {
        c bVar = new b();
        if (be.kS(str)) {
            return null;
        }
        long j = be.getLong(str, -1);
        if (j != -1) {
            am.Wf().b(j, bVar);
            if (bVar.nmb != j) {
                bVar = am.Wf().Gu(str);
                if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                    v.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                    bVar = null;
                }
            }
        } else {
            bVar = am.Wf().Gu(str);
            if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                v.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                bVar = null;
            }
        }
        return bVar;
    }

    public static void L(at atVar) {
        c cVar = null;
        a dV = a.dV(atVar.field_content);
        if (dV == null) {
            v.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
            return;
        }
        byte[] c;
        a a;
        String str;
        String str2;
        bx atVar2;
        long R;
        b GD = GD(dV.aXa);
        String str3 = SQLiteDatabase.KeyEmpty;
        if (!(GD == null || GD.field_fileFullPath == null || GD.field_fileFullPath.equals(SQLiteDatabase.KeyEmpty))) {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            str3 = stringBuilder.append(com.tencent.mm.model.c.xd()).append("da_").append(be.Ni()).toString();
            j.n(GD.field_fileFullPath, str3, false);
        }
        if (!(atVar.field_imgPath == null || atVar.field_imgPath.equals(SQLiteDatabase.KeyEmpty))) {
            String w = n.GH().w(atVar.field_imgPath, true);
            try {
                c = com.tencent.mm.a.e.c(w, 0, com.tencent.mm.a.e.aQ(w));
            } catch (Exception e) {
            }
            a = a.a(dV);
            str = dV.appId;
            str2 = dV.appName;
            str = System.currentTimeMillis();
            if (!be.kS(str3)) {
                cVar = a(str, a, str3);
                if (cVar == null) {
                    g.sk();
                    return;
                }
            }
            atVar2 = new at();
            if (c != null && c.length > 0) {
                str3 = n.GH().a(6, c, a.type != 2, CompressFormat.PNG);
                v.d("MicroMsg.AppMsgLogic", g.sm() + " thumbData MsgInfo path:" + str3);
                if (!be.kS(str3)) {
                    atVar2.cI(str3);
                    v.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + str3);
                }
            }
            if (cVar != null) {
                a.aXa = cVar.nmb;
            }
            atVar2.setContent(a.b(a));
            atVar2.dh(1);
            atVar2.cH(atVar.field_talker);
            atVar2.z(aw.fN(atVar.field_talker));
            atVar2.di(1);
            atVar2.setType(h(a.type, a.aXx, a.cov, a.cow, a.cpT));
            if (com.tencent.mm.modelbiz.e.hC(atVar2.field_talker)) {
                atVar2.cN(com.tencent.mm.modelbiz.a.e.zr());
                v.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", atVar2.bNo);
            }
            ak.yW();
            R = com.tencent.mm.model.c.wJ().R(atVar2);
            v.d("MicroMsg.AppMsgLogic", g.sm() + " msginfo insert id: " + R);
            if (R >= 0) {
                v.e("MicroMsg.AppMsgLogic", g.sm() + "insert msg failed :" + R);
                g.sk();
            }
            v.i("MicroMsg.AppMsgLogic", g.sk() + " new msg inserted to db , local id = " + R);
            atVar2.x(R);
            com.tencent.mm.sdk.c.b pqVar = new pq();
            pqVar.bqU.bqV = atVar.field_msgId;
            pqVar.bqU.bqW = R;
            com.tencent.mm.sdk.c.a.nhr.z(pqVar);
            c aVar = new com.tencent.mm.q.a();
            aVar.field_xml = atVar2.field_content;
            aVar.field_title = a.title;
            aVar.field_type = a.type;
            aVar.field_description = a.description;
            aVar.field_msgId = R;
            aVar.field_source = str2;
            am.bnC().b(aVar);
            if (cVar == null) {
                cVar.field_msgInfoId = R;
                cVar.field_status = 101;
                am.Wf().a(cVar, new String[0]);
                am.bnE().run();
                return;
            }
            am.bnE();
            al.a.dC(R);
            return;
        }
        c = null;
        a = a.a(dV);
        str = dV.appId;
        str2 = dV.appName;
        str = System.currentTimeMillis();
        if (be.kS(str3)) {
            cVar = a(str, a, str3);
            if (cVar == null) {
                g.sk();
                return;
            }
        }
        atVar2 = new at();
        if (a.type != 2) {
        }
        str3 = n.GH().a(6, c, a.type != 2, CompressFormat.PNG);
        v.d("MicroMsg.AppMsgLogic", g.sm() + " thumbData MsgInfo path:" + str3);
        if (be.kS(str3)) {
            atVar2.cI(str3);
            v.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + str3);
        }
        if (cVar != null) {
            a.aXa = cVar.nmb;
        }
        atVar2.setContent(a.b(a));
        atVar2.dh(1);
        atVar2.cH(atVar.field_talker);
        atVar2.z(aw.fN(atVar.field_talker));
        atVar2.di(1);
        atVar2.setType(h(a.type, a.aXx, a.cov, a.cow, a.cpT));
        if (com.tencent.mm.modelbiz.e.hC(atVar2.field_talker)) {
            atVar2.cN(com.tencent.mm.modelbiz.a.e.zr());
            v.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", atVar2.bNo);
        }
        ak.yW();
        R = com.tencent.mm.model.c.wJ().R(atVar2);
        v.d("MicroMsg.AppMsgLogic", g.sm() + " msginfo insert id: " + R);
        if (R >= 0) {
            v.i("MicroMsg.AppMsgLogic", g.sk() + " new msg inserted to db , local id = " + R);
            atVar2.x(R);
            com.tencent.mm.sdk.c.b pqVar2 = new pq();
            pqVar2.bqU.bqV = atVar.field_msgId;
            pqVar2.bqU.bqW = R;
            com.tencent.mm.sdk.c.a.nhr.z(pqVar2);
            c aVar2 = new com.tencent.mm.q.a();
            aVar2.field_xml = atVar2.field_content;
            aVar2.field_title = a.title;
            aVar2.field_type = a.type;
            aVar2.field_description = a.description;
            aVar2.field_msgId = R;
            aVar2.field_source = str2;
            am.bnC().b(aVar2);
            if (cVar == null) {
                am.bnE();
                al.a.dC(R);
                return;
            }
            cVar.field_msgInfoId = R;
            cVar.field_status = 101;
            am.Wf().a(cVar, new String[0]);
            am.bnE().run();
            return;
        }
        v.e("MicroMsg.AppMsgLogic", g.sm() + "insert msg failed :" + R);
        g.sk();
    }

    public static int h(int i, int i2, int i3, int i4, int i5) {
        v.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + i2 + " atype " + i + ", itemShowType = " + i3 + ", c2cNewAAType = " + i5);
        if (i3 == 4 || i4 != 0) {
            return 318767153;
        }
        if (i3 == 5) {
            return 486539313;
        }
        if (i != MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
            switch (i2) {
                case 1:
                    if (i == 21) {
                        return -1879048185;
                    }
                    return 285212721;
                case 2:
                    if (i == 21) {
                        return -1879048183;
                    }
                    return 301989937;
                case 3:
                    if (i == 21) {
                        return -1879048176;
                    }
                    return -1879048189;
                case 4:
                    return -1879048190;
                case 5:
                    return -1879048191;
                case 17:
                    return -1879048186;
                default:
                    switch (i) {
                        case 1:
                            return 16777265;
                        case 2:
                            return 268435505;
                        case 8:
                            return 1048625;
                        case 10:
                            return 335544369;
                        case 13:
                            return 369098801;
                        case 16:
                            return 452984881;
                        case 17:
                            return -1879048186;
                        case 20:
                            return 402653233;
                        case 34:
                            return 520093745;
                        case 2000:
                            return 419430449;
                        default:
                            return 49;
                    }
            }
        } else if (i2 == 1) {
            return 469762097;
        } else {
            if (i5 == 4) {
                return 503316529;
            }
            return 436207665;
        }
    }

    public static int tD(int i) {
        switch (i) {
            case -1879048191:
            case -1879048190:
            case -1879048189:
            case -1879048186:
            case -1879048185:
            case -1879048183:
            case -1879048176:
            case 1048625:
            case 16777265:
            case 268435505:
            case 285212721:
            case 301989937:
            case 335544369:
            case 402653233:
            case 419430449:
            case 486539313:
                return 49;
            default:
                return i;
        }
    }
}
