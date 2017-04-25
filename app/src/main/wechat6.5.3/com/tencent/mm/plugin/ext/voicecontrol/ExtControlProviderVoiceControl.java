package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.qq.wx.voice.embed.recognizer.b;
import com.qq.wx.voice.embed.recognizer.c;
import com.tencent.mm.c.c.d;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.pluginsdk.e.a.a;
import com.tencent.mm.protocal.c.ct;
import com.tencent.mm.protocal.c.cv;
import com.tencent.mm.protocal.c.cy;
import com.tencent.mm.protocal.c.cz;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.protocal.c.db;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class ExtControlProviderVoiceControl extends ExtContentProviderBase implements e {
    private static final String[] fGL = new String[]{"retCode"};
    private Context context;
    private String[] fGX = null;
    private int fGY = -1;
    private int fHY = 4;
    private long fHZ;
    private long fIa;
    private long fIb;
    a fIc = new a();
    private long fId = 0;
    private boolean fIe;
    private c fIf = new c(this) {
        final /* synthetic */ ExtControlProviderVoiceControl fIk;

        {
            this.fIk = r1;
        }

        public final void a(com.qq.wx.voice.embed.recognizer.a aVar) {
            if (aVar == null) {
                v.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
                return;
            }
            v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", Long.valueOf(System.currentTimeMillis() - this.fIk.fId), aVar.text, aVar.name);
            if (!be.kS(aVar.name)) {
                this.fIk.fIe = true;
                this.fIk.sK(aVar.name);
            }
        }

        public final void cD(int i) {
            v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", Integer.valueOf(i));
        }
    };

    static /* synthetic */ void a(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        extControlProviderVoiceControl.fIe = false;
        extControlProviderVoiceControl.fId = System.currentTimeMillis();
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl  hasInit:%s", Boolean.valueOf(aa.btk().getBoolean("hasInitVoiceControlData", true)));
        if (aa.btk().getBoolean("hasInitVoiceControlData", true)) {
            byte[] d = com.tencent.mm.a.e.d(str, 0, -1);
            b bVar = a.aGW;
            int a = bVar.aGV.a(extControlProviderVoiceControl.fIf, d);
            v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "recognize ret:%s", Integer.valueOf(a));
        }
    }

    static /* synthetic */ void c(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        Intent intent;
        if (com.tencent.mm.modelbiz.e.hB(str)) {
            intent = new Intent();
            intent.putExtra("enterprise_biz_name", str);
            intent.putExtra("enterprise_biz_display_name", l.er(str));
            com.tencent.mm.ay.c.a(extControlProviderVoiceControl.context, ".ui.conversation.EnterpriseConversationUI", intent);
        } else if (com.tencent.mm.modelbiz.e.hC(str)) {
            intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 7);
            com.tencent.mm.ay.c.a(extControlProviderVoiceControl.context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (com.tencent.mm.modelbiz.e.hD(str)) {
            BizInfo hw = com.tencent.mm.modelbiz.e.hw(str);
            String CD = hw == null ? null : hw.CD();
            if (CD == null) {
                CD = SQLiteDatabase.KeyEmpty;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", CD);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", str);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            com.tencent.mm.ay.c.b(extControlProviderVoiceControl.context, "webview", ".ui.tools.WebViewUI", intent2);
        } else {
            intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            com.tencent.mm.plugin.ext.a.drp.e(intent, extControlProviderVoiceControl.context);
        }
    }

    public ExtControlProviderVoiceControl(String[] strArr, int i, Context context) {
        this.fGX = strArr;
        this.fGY = i;
        this.context = context;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", Integer.valueOf(this.fGY));
        this.fHZ = 0;
        this.fIa = 0;
        a(uri, this.context, this.fGY, this.fGX);
        if (uri == null) {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
            bB(3, 5);
            return ExtContentProviderBase.kC(5);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (be.kS(this.fHh)) {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
            bB(3, 7);
            return ExtContentProviderBase.kC(7);
        } else if (be.kS(akY())) {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
            bB(3, 6);
            return ExtContentProviderBase.kC(6);
        } else {
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis2 = System.currentTimeMillis() - System.currentTimeMillis();
            int akZ = akZ();
            if (akZ != 1) {
                v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = " + akZ);
                bB(2, akZ);
                return ExtContentProviderBase.kC(akZ);
            }
            v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2));
            switch (this.fGY) {
                case 29:
                    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
                    if (strArr2 == null || strArr2.length < 4) {
                        v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        bB(3, 3501);
                        this.fHY = 3501;
                        return ExtContentProviderBase.kC(3501);
                    }
                    final String str3 = strArr2[0];
                    final String str4 = strArr2[1];
                    final String str5 = strArr2[2];
                    final String str6 = strArr2[3];
                    final String str7 = strArr2[4];
                    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", str3, str4, str5, str6, str7);
                    if (be.kS(str3) || be.kS(str4) || be.kS(str5) || be.kS(str6) || be.kS(str7)) {
                        bB(3, 3502);
                        v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        return ExtContentProviderBase.kC(3502);
                    } else if (com.tencent.mm.a.e.aR(str7)) {
                        this.fHZ = System.currentTimeMillis();
                        ak.vy().a(985, (e) this);
                        this.fIc.b(13000, new Runnable(this) {
                            final /* synthetic */ ExtControlProviderVoiceControl fIk;

                            public final void run() {
                                int i = be.getInt(str3, 4);
                                if (i == 1) {
                                    ExtControlProviderVoiceControl.a(this.fIk, str7);
                                } else {
                                    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
                                }
                                if (!ExtControlProviderVoiceControl.a(this.fIk.fHh, i, be.getInt(str4, 4), be.getInt(str5, 16000), be.getInt(str6, 16), str7)) {
                                    v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
                                    this.fIk.fHY = 3504;
                                    this.fIk.fIc.countDown();
                                }
                            }
                        });
                        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", Long.valueOf(this.fIa - this.fHZ), Long.valueOf(System.currentTimeMillis() - this.fIa));
                        ak.vy().b(985, (e) this);
                        z(10, 0, 1);
                        if (1 != this.fHY) {
                            z(11, 4, 1);
                        } else {
                            z(10, 0, 1);
                        }
                        kB(0);
                        return ExtContentProviderBase.kC(this.fHY);
                    } else {
                        v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
                        bB(3, 3503);
                        return ExtContentProviderBase.kC(3503);
                    }
                default:
                    bB(3, 15);
                    return ExtContentProviderBase.kC(15);
            }
        }
    }

    public static boolean a(String str, int i, int i2, int i3, int i4, String str2) {
        String str3;
        byte[] d;
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
        if (i != 4) {
            str3 = str2 + ".speex";
            d dVar = new d();
            if (!d.t(str2, str3)) {
                v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", str2, str3);
                return false;
            }
        }
        str3 = str2;
        int aQ = com.tencent.mm.a.e.aQ(str3);
        db dbVar = new db();
        dbVar.mdC = 4;
        dbVar.mdD = 4;
        dbVar.mdE = i3;
        dbVar.mdF = i4;
        da daVar = new da();
        daVar.mdz = aQ;
        daVar.mdA = 0;
        if (aQ <= 16384) {
            daVar.mdB = aQ;
            d = com.tencent.mm.a.e.d(str3, 0, aQ);
        } else {
            daVar.mdB = 16384;
            d = com.tencent.mm.a.e.d(str3, 0, 16384);
        }
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(aQ), Integer.valueOf(16384));
        if (d == null || d.length <= 0) {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
            return false;
        }
        cz czVar = new cz();
        czVar.mdx = dbVar;
        czVar.mdr = daVar;
        czVar.mdy = com.tencent.mm.ba.b.aT(d);
        int hashCode = (be.Ni()).hashCode();
        ak.vy().a(new a(hashCode != Integer.MIN_VALUE ? Math.abs(hashCode) : Integer.MIN_VALUE, str, aQ, str3, czVar), 0);
        return true;
    }

    private static boolean a(a aVar, int i, int i2) {
        if (aVar == null) {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
            return false;
        } else if (aVar.fIq == null) {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
            return false;
        } else if (aVar.fIq.mdr == null) {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
            return false;
        } else {
            cz czVar = new cz();
            cz czVar2 = aVar.fIq;
            czVar2.mdr.mdA = i;
            czVar2.mdr.mdB = i2;
            byte[] d = com.tencent.mm.a.e.d(aVar.fIp, i, i2);
            v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", Integer.valueOf(aVar.fIn), Integer.valueOf(i), Integer.valueOf(i2));
            if (d == null || d.length <= 0) {
                v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", aVar.fIp);
                return false;
            }
            czVar2.mdy = com.tencent.mm.ba.b.aT(d);
            k aVar2 = new a(aVar.fIn, aVar.appId, aVar.cyu, aVar.fIp, czVar2);
            aVar2.cyv = aVar.cyv;
            ak.vy().a(aVar2, 0);
            return true;
        }
    }

    public final boolean a(int i, String str, com.tencent.mm.ba.b bVar) {
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", Integer.valueOf(i), str);
        if (this.fIa == 0) {
            this.fIa = System.currentTimeMillis();
        }
        this.fIb = System.currentTimeMillis();
        ct ctVar = new ct();
        ctVar.mdk = bVar;
        ak.vy().a(new a(i, str, ctVar, this.fIa), 0);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
            this.fHY = 3506;
            this.fIc.countDown();
        } else if (i == 0 && i2 == 0) {
            v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", Integer.valueOf(kVar.getType()));
            if (kVar.getType() != 985) {
                return;
            }
            if (this.fIe) {
                v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
                return;
            }
            final a aVar = (a) kVar;
            a aVar2 = (a) kVar;
            final cv cvVar = (aVar2.cif == null || aVar2.cif.czl.czs == null) ? null : (cv) aVar2.cif.czl.czs;
            if (cvVar == null) {
                v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
                this.fHY = 3508;
                this.fIc.countDown();
                return;
            }
            aVar.fIo = cvVar.mdk;
            String str2 = "MicroMsg.ext.ExtControlProviderVoiceControl";
            String str3 = "[voiceControl] opCode=%s, resp.Cookies=%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(aVar.bdf);
            objArr[1] = cvVar.mdk == null ? "null" : new String(cvVar.mdk.lVU);
            v.i(str2, str3, objArr);
            if ((aVar.bdf == 1 ? 1 : null) != null) {
                if (cvVar.mdr == null) {
                    v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
                }
                v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", Integer.valueOf(cvVar.mdp), Integer.valueOf(cvVar.mdq), Integer.valueOf(cvVar.mdr.mdA), Integer.valueOf(cvVar.mdr.mdB));
                if (cvVar.mdr.mdA >= aVar.cyu) {
                    ad.g(new Runnable(this) {
                        final /* synthetic */ ExtControlProviderVoiceControl fIk;

                        public final void run() {
                            v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                            a aVar = aVar;
                            v.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", Integer.valueOf(cvVar.mdq));
                            aVar.fIs = r1;
                            this.fIk.a(aVar.fIn, aVar.appId, aVar.fIo);
                        }
                    }, (long) cvVar.mdp);
                    return;
                }
                v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
                if (cvVar.mdr.mdA == 0 || cvVar.mdr.mdA != aVar.cyv) {
                    aVar.cyv = cvVar.mdr.mdA;
                    if (cvVar.mdr.mdA + cvVar.mdr.mdB < aVar.cyu) {
                        if (!a(aVar, cvVar.mdr.mdA, cvVar.mdr.mdB)) {
                            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
                            this.fHY = 3510;
                            this.fIc.countDown();
                            return;
                        }
                        return;
                    } else if (!a(aVar, cvVar.mdr.mdA, aVar.cyu - cvVar.mdr.mdA)) {
                        v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
                        this.fHY = 3510;
                        this.fIc.countDown();
                        return;
                    } else {
                        return;
                    }
                }
                v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
                return;
            }
            if ((aVar.bdf == 2 ? 1 : null) != null) {
                Object obj;
                v.i("MicroMsg.ext.ExtControlProviderVoiceControl", SQLiteDatabase.KeyEmpty);
                if (System.currentTimeMillis() - aVar.fIt > ((long) aVar.fIs)) {
                    v.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", Long.valueOf(System.currentTimeMillis() - aVar.fIt), Integer.valueOf(aVar.fIs));
                    obj = 1;
                } else {
                    v.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", Long.valueOf(System.currentTimeMillis() - aVar.fIt), Integer.valueOf(aVar.fIs));
                    obj = null;
                }
                if (obj != null) {
                    this.fHY = 3509;
                    this.fIc.countDown();
                    return;
                }
                if (cvVar.mds != null) {
                    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", Integer.valueOf(cvVar.mds.mdl), Integer.valueOf(cvVar.mds.mdt));
                }
                if (cvVar.mds == null || cvVar.mds.mdt != 0) {
                    if (System.currentTimeMillis() - this.fIb >= ((long) cvVar.mdp)) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ ExtControlProviderVoiceControl fIk;

                            public final void run() {
                                this.fIk.a(aVar.fIn, aVar.appId, aVar.fIo);
                            }
                        });
                        return;
                    }
                    long currentTimeMillis = ((long) cvVar.mdp) - (System.currentTimeMillis() - this.fIb);
                    if (currentTimeMillis > ((long) cvVar.mdp)) {
                        currentTimeMillis = (long) cvVar.mdp;
                    }
                    ad.g(new Runnable(this) {
                        final /* synthetic */ ExtControlProviderVoiceControl fIk;

                        public final void run() {
                            this.fIk.a(aVar.fIn, aVar.appId, aVar.fIo);
                        }
                    }, currentTimeMillis);
                } else if (cvVar.mds.mdu == null) {
                    v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
                    this.fHY = 3511;
                    this.fIc.countDown();
                } else if (cvVar.mds.mdu.mdv == null || cvVar.mds.mdu.mdv.size() <= 0) {
                    v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
                    this.fHY = 3511;
                    this.fIc.countDown();
                } else if (cvVar.mds.mdu.mdv.size() == 0) {
                    this.fHY = 3511;
                    this.fIc.countDown();
                } else if (cvVar.mds.mdu.mdv.size() == 1) {
                    sK(((cy) cvVar.mds.mdu.mdv.get(0)).mdw);
                } else {
                    String[] strArr = new String[cvVar.mds.mdu.mdv.size()];
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        strArr[i3] = ((cy) cvVar.mds.mdu.mdv.get(i3)).mdw;
                        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", strArr[i3]);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                    intent.putExtra("VoiceSearchResultUI_VoiceId", aVar.fIn);
                    intent.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
                    intent.setFlags(67108864);
                    intent.putExtra("VoiceSearchResultUI_ShowType", 1);
                    com.tencent.mm.ay.c.a(this.context, ".ui.voicesearch.VoiceSearchResultUI", intent);
                    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
                    this.fHY = 1;
                    this.fIc.countDown();
                }
            }
        } else {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
            this.fHY = 3507;
            this.fIc.countDown();
        }
    }

    private void sK(final String str) {
        ak.yW();
        ab LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
            this.fHY = 3505;
            this.fIc.countDown();
            return;
        }
        com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ ExtControlProviderVoiceControl fIk;

            public final void run() {
                ExtControlProviderVoiceControl.c(this.fIk, str);
            }
        });
        this.fHY = 1;
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", str);
        this.fIc.countDown();
    }
}
