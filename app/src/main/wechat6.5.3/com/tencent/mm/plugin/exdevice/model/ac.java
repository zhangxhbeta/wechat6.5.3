package com.tencent.mm.plugin.exdevice.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.ae.n;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.cj;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.f.b.b.a;
import com.tencent.mm.plugin.exdevice.f.b.b.b;
import com.tencent.mm.plugin.exdevice.f.b.b.d;
import com.tencent.mm.plugin.exdevice.f.b.b.e;
import com.tencent.mm.plugin.exdevice.i.g;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class ac implements ag {
    private static HashMap<Integer, c> bXq;
    private ab fuR = new ab();
    private b fuS;
    private com.tencent.mm.plugin.exdevice.h.c fuT;
    private d fuU;
    private a fuV;
    private b fuW;
    private e fuX;
    private e fuY;
    private d fuZ;
    private com.tencent.mm.plugin.exdevice.f.b.c fva;
    private com.tencent.mm.plugin.exdevice.f.b.a fvb;
    private com.tencent.mm.plugin.exdevice.f.a.c fvc;
    private com.tencent.mm.ae.a.a fvd = null;
    private com.tencent.mm.ae.a.a.c fve = null;
    private ae fvf;
    private h fvg;
    private bo.b fvh = new bo.b(this) {
        final /* synthetic */ ac fvj;

        {
            this.fvj = r1;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            if (ac.ajw() != null) {
                Object obj;
                Map q;
                ac.ajw();
                bm bmVar = aVar.czu;
                v.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
                String a = m.a(bmVar.mbW);
                if (be.kS(a)) {
                    v.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
                } else {
                    Map q2 = bf.q(a, "sysmsg");
                    if (q2 != null && q2.size() > 0) {
                        a = (String) q2.get(".sysmsg.$type");
                        if (!be.kS(a) && a.equalsIgnoreCase("wcdevicemsg")) {
                            a = (String) q2.get(".sysmsg.wcdevicemsg.xml.ToUserName");
                            String str = (String) q2.get(".sysmsg.wcdevicemsg.xml.FromUserName");
                            long j = be.getLong((String) q2.get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1);
                            String str2 = (String) q2.get(".sysmsg.wcdevicemsg.xml.MsgType");
                            String str3 = (String) q2.get(".sysmsg.wcdevicemsg.xml.DeviceType");
                            String str4 = (String) q2.get(".sysmsg.wcdevicemsg.xml.DeviceID");
                            int i = be.getInt((String) q2.get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
                            v.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + a + ",fromuser=" + str + ",createtime=" + j + ",msgtype=" + str2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
                            com.tencent.mm.plugin.exdevice.h.b sq = ac.ajq().sq(str4);
                            if (sq != null && be.ma(sq.field_connProto).contains("4") && be.ma(str2).contains("device_status")) {
                                if (i != 0) {
                                    ac.ajB();
                                    e.a(sq.field_brandName, sq.field_url, 2, sq.field_deviceID);
                                } else {
                                    ac.ajB();
                                    e.a(sq.field_brandName, sq.field_url, 4, sq.field_deviceID);
                                }
                                obj = 1;
                                if (obj == null) {
                                    a = m.a(bmVar.mbW);
                                    if (be.kS(a)) {
                                        q = bf.q(a, "sysmsg");
                                        if (q != null || q.size() <= 0) {
                                            v.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                                            return;
                                        }
                                        a = (String) q.get(".sysmsg.$type");
                                        if (be.kS(a) || !a.equalsIgnoreCase("wcdevicemsg")) {
                                            v.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
                                            return;
                                        }
                                        v.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[]{be.ma((String) q.get(".sysmsg.wcdevicemsg.xml.MsgType"))});
                                        if (be.ma((String) q.get(".sysmsg.wcdevicemsg.xml.MsgType")).equals("device_relation")) {
                                            cj cjVar = new cj();
                                            cjVar.bac.bad = true;
                                            com.tencent.mm.sdk.c.a.nhr.z(cjVar);
                                            return;
                                        }
                                        a = (String) q.get(".sysmsg.wcdevicemsg.xml.Content");
                                        v.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[]{a});
                                        if (be.kS(a)) {
                                            v.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
                                            return;
                                        }
                                        try {
                                            byte[] decode = Base64.decode(a, 0);
                                            if (be.bl(decode)) {
                                                v.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
                                                return;
                                            }
                                            long j2 = be.getLong((String) q.get(".sysmsg.wcdevicemsg.xml.SessionID"), -1);
                                            v.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[]{Long.valueOf(j2), (String) q.get(".sysmsg.wcdevicemsg.xml.DeviceID"), a, Integer.valueOf(decode.length)});
                                            sq = ac.ajq().sq(str);
                                            if (sq == null) {
                                                v.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                                                return;
                                            } else if (0 == j2) {
                                                u.ajW().a(new g(decode, 0, sq.field_mac));
                                                return;
                                            } else {
                                                k aiw = k.aiw();
                                                v.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[]{Long.valueOf(j2)});
                                                Assert.assertTrue(j2 >= 0);
                                                c cVar = new c();
                                                cVar.epy = j2;
                                                cVar.epb = decode;
                                                aiw.mHandler.obtainMessage(3, cVar).sendToTarget();
                                                return;
                                            }
                                        } catch (Throwable e) {
                                            v.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[]{e.getMessage()});
                                            v.a("MicroMsg.exdevice.ExDeviceMessageService", e, "", new Object[0]);
                                            return;
                                        }
                                    }
                                    v.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    a = m.a(bmVar.mbW);
                    if (be.kS(a)) {
                        q = bf.q(a, "sysmsg");
                        if (q != null) {
                        }
                        v.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                        return;
                    }
                    v.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                }
            }
        }
    };
    j.b fvi = new j.b(this) {
        final /* synthetic */ ac fvj;

        {
            this.fvj = r1;
        }

        public final void a(int i, j jVar, final Object obj) {
            try {
                if (!ak.uz()) {
                    v.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
                } else if (obj instanceof String) {
                    ak.vA().f(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 fvk;

                        public final void run() {
                            String str = (String) obj;
                            if (ac.ajs().sk(str)) {
                                ak.yW();
                                if (!com.tencent.mm.model.c.wH().LT(str)) {
                                    ak.vy().a(new h(str, null), 0);
                                }
                            }
                        }
                    }, 2000);
                }
            } catch (Exception e) {
                v.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[]{e.getMessage()});
            }
        }
    };

    static /* synthetic */ void a(ac acVar) {
        try {
            ad.g(new Runnable(acVar) {
                final /* synthetic */ ac fvj;

                {
                    this.fvj = r1;
                }

                public final void run() {
                    boolean hasSystemFeature = aa.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                    boolean hasSystemFeature2 = aa.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                    if (hasSystemFeature && hasSystemFeature2) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(11891, "3", true, true);
                    } else if (hasSystemFeature) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(11891, "1", true, true);
                    } else if (hasSystemFeature2) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(11891, "2", true, true);
                    }
                    v.i("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] deviceFeatures stepCounter %s, stepDetector %s", new Object[]{Boolean.valueOf(hasSystemFeature), Boolean.valueOf(hasSystemFeature2)});
                }
            }, 30000);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] exception in deviceFeaturesKVStat, %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.SubCoreExDevice", e, "", new Object[0]);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.plugin.exdevice.h.c.cic;
            }
        });
        bXq.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return d.cic;
            }
        });
        bXq.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return a.cic;
            }
        });
        bXq.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return e.cic;
            }
        });
        bXq.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return b.cic;
            }
        });
        bXq.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.plugin.exdevice.f.b.b.c.cic;
            }
        });
    }

    public ac() {
        if (this.fuZ == null) {
            this.fuZ = new d();
        }
        if (this.fuY == null) {
            this.fuY = new e();
        }
        v.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
        com.tencent.mm.sdk.c.a.nhr.e(this.fuY.fsN);
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    private static ac ajp() {
        ac acVar = (ac) ak.yP().fY("plugin.exdevice");
        if (acVar != null) {
            return acVar;
        }
        v.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
        acVar = new ac();
        ak.yP().a("plugin.exdevice", acVar);
        return acVar;
    }

    public static com.tencent.mm.plugin.exdevice.h.c ajq() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (ajp().fuT == null) {
            ac ajp = ajp();
            ak.yW();
            ajp.fuT = new com.tencent.mm.plugin.exdevice.h.c(com.tencent.mm.model.c.wE());
        }
        return ajp().fuT;
    }

    public static d ajr() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (ajp().fuU == null) {
            ac ajp = ajp();
            ak.yW();
            ajp.fuU = new d(com.tencent.mm.model.c.wE());
        }
        return ajp().fuU;
    }

    public static a ajs() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (ajp().fuV == null) {
            ac ajp = ajp();
            ak.yW();
            ajp.fuV = new a(com.tencent.mm.model.c.wE());
        }
        return ajp().fuV;
    }

    public static com.tencent.mm.ae.a.a ajt() {
        if (ajp().fvd == null) {
            ajp().fvd = n.GL();
        }
        return ajp().fvd;
    }

    public static com.tencent.mm.ae.a.a.c sf(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
            ac ajp = ajp();
            if (ajp.fve == null) {
                com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
                n.GM();
                aVar.cPN = null;
                aVar.cPz = 640;
                aVar.cPy = 640;
                aVar.cPq = false;
                aVar.cPs = true;
                ajp.fve = aVar.GU();
            }
            return ajp().fve;
        }
        com.tencent.mm.ae.a.a.c.a aVar2 = new com.tencent.mm.ae.a.a.c.a();
        aVar2.cPz = 640;
        aVar2.cPy = 640;
        aVar2.cPq = false;
        aVar2.cPr = true;
        ak.yW();
        aVar2.cPv = com.tencent.mm.model.c.wP();
        return aVar2.GU();
    }

    public static b aju() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (ajp().fuW == null) {
            ac ajp = ajp();
            ak.yW();
            ajp.fuW = new b(com.tencent.mm.model.c.wE());
        }
        return ajp().fuW;
    }

    public static e ajv() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (ajp().fuX == null) {
            ac ajp = ajp();
            ak.yW();
            ajp.fuX = new e(com.tencent.mm.model.c.wE());
        }
        return ajp().fuX;
    }

    public static b ajw() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (ajp().fuS == null) {
            ajp().fuS = new b();
        }
        return ajp().fuS;
    }

    public static d ajx() {
        if (ajp().fuZ == null) {
            ajp().fuZ = new d();
        }
        return ajp().fuZ;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.c ajy() {
        if (ajp().fva == null) {
            ajp().fva = new com.tencent.mm.plugin.exdevice.f.b.c();
        }
        return ajp().fva;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.a ajz() {
        if (ajp().fvb == null) {
            ajp().fvb = new com.tencent.mm.plugin.exdevice.f.b.a();
        }
        return ajp().fvb;
    }

    public static com.tencent.mm.plugin.exdevice.f.a.c ajA() {
        if (ajp().fvc == null) {
            ajp().fvc = new com.tencent.mm.plugin.exdevice.f.a.c();
        }
        return ajp().fvc;
    }

    public static e ajB() {
        if (ajp().fuY == null) {
            ajp().fuY = new e();
        }
        return ajp().fuY;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        ak.yW();
        com.tencent.mm.model.c.wH().a(this.fvi);
        ak.vy().a(538, k.aiw());
        this.fvf = new ae();
        com.tencent.mm.sdk.c.a.nhr.e(this.fuR);
        ak.yU().a("wcdevicemsg", this.fvh, true);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsn);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fso);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsp);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsI);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsm);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsl);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsq);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsr);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fss);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsJ);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fst);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsu);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsv);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsx);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsw);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsB);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsz);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsA);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsC);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsK);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsM);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsy);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsD);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsE);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsF);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsG);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsU);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsV);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsW);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsY);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsX);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsO);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsP);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsQ);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsR);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsS);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsT);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsL);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsN);
        com.tencent.mm.sdk.c.a.nhr.e(ajB().fsZ);
        i iVar = i.fuj;
        v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
        ak.vy().a(539, iVar);
        com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ ac fvj;

            {
                this.fvj = r1;
            }

            public final void run() {
                ac.a(this.fvj);
            }
        });
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        ak.yW();
        com.tencent.mm.model.c.wH().b(this.fvi);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsn);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fso);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsp);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsI);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsK);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsm);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsl);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsq);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsr);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fss);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsJ);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsU);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsV);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsW);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsY);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsX);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsO);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsP);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsQ);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsR);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsS);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsT);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsu);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsL);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsN);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fsZ);
        v.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            v.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
        } else if (!sharedPreferences.edit().clear().commit()) {
            v.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
        }
        f ajV = u.ajV();
        v.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
        if (ajV.fxr == null) {
            v.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
        } else {
            for (Entry entry : ajV.fxr.entrySet()) {
                f.a aVar = (f.a) entry.getValue();
                aVar.fxv = false;
                entry.setValue(aVar);
            }
        }
        ak.vy().b(538, k.aiw());
        k.frj = null;
        com.tencent.mm.sdk.c.a.nhr.f(this.fuR);
        ak.yU().b("wcdevicemsg", this.fvh, true);
        com.tencent.mm.sdk.c.a.nhr.f(ajB().fst);
        if (ajp().fuS != null) {
            ajp();
        }
        i iVar = i.fuj;
        v.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
        ak.vy().b(539, iVar);
        d dVar = ajp().fuZ;
        if (!(dVar.frT == null || dVar.frT.isEmpty())) {
            for (Entry entry2 : dVar.frT.entrySet()) {
                ((ah) entry2.getValue()).QI();
            }
            dVar.frT.clear();
        }
        if (ajp().fva != null) {
            com.tencent.mm.plugin.exdevice.f.b.c cVar = ajp().fva;
            ak.vy().b(1042, cVar);
            ak.vy().b(1041, cVar);
            ak.vy().b(1043, cVar);
            ak.vy().b(1040, cVar);
        }
        if (ajp().fvd != null) {
            ajp().fvd.detach();
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.fvf.bYn);
    }

    public static h ajC() {
        if (ajp().fvg == null) {
            ajp().fvg = new h();
        }
        return ajp().fvg;
    }
}
