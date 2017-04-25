package com.tencent.mm.plugin.exdevice.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.e.a.df;
import com.tencent.mm.e.a.dj;
import com.tencent.mm.e.a.gs;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.protocal.c.acl;
import com.tencent.mm.protocal.c.acm;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.protocal.c.aco;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g implements e {
    long bZz;
    String bhR;
    long cMR;
    String cMU = "";
    public a cNe = new a(this) {
        final /* synthetic */ g ftT;

        {
            this.ftT = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", new Object[]{this.ftT.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult, Boolean.valueOf(this.ftT.ftA)});
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                try {
                    int i2;
                    int i3 = (int) ((((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) / ((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)) * 100.0f);
                    v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 >= 100) {
                        i2 = 99;
                    } else {
                        i2 = i3;
                    }
                    for (String a : this.ftT.ftC.keySet()) {
                        g.a(this.ftT, a, i2);
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", new Object[]{e});
                }
            }
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (this.ftT.ftA) {
                    acj com_tencent_mm_protocal_c_acj = new acj();
                    this.ftT.a(com_tencent_mm_protocal_c_acj, this.ftT.bZz);
                    this.ftT.ftA = false;
                    if (g.aW(this.ftT.bZz).booleanValue() || g.aX(this.ftT.bZz).booleanValue()) {
                        com_tencent_mm_protocal_c_acj.mDv.mjT = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                        com_tencent_mm_protocal_c_acj.mDv.mjV = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                        com_tencent_mm_protocal_c_acj.mDv.glb = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                        v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", new Object[]{com_tencent_mm_protocal_c_acj.mDv.glb});
                    } else if (g.aV(this.ftT.bZz).booleanValue()) {
                        com_tencent_mm_protocal_c_acj.mDw.mjT = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                        com_tencent_mm_protocal_c_acj.mDw.mjV = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                        com_tencent_mm_protocal_c_acj.mDw.glb = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                        v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", new Object[]{com_tencent_mm_protocal_c_acj.mDw.glb});
                    } else if (g.aY(this.ftT.bZz).booleanValue()) {
                        com_tencent_mm_protocal_c_acj.mDy.glb = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                        v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", new Object[]{com_tencent_mm_protocal_c_acj.mDy.glb});
                    }
                    this.ftT.ftD = com_tencent_mm_protocal_c_acj;
                    for (String a2 : this.ftT.ftC.keySet()) {
                        ak.vy().a(new n(com_tencent_mm_protocal_c_acj, (String) this.ftT.ftC.get(a2), a2, 1), 0);
                    }
                    this.ftT.ftC.clear();
                }
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = " + str);
        }

        public final byte[] i(String str, byte[] bArr) {
            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
            return bArr;
        }
    };
    boolean ftA = false;
    boolean ftB = false;
    public HashMap<String, String> ftC = new HashMap();
    acj ftD;
    List<b> ftE = null;
    List<b> ftF = new ArrayList();
    HashMap<String, String> ftG = new HashMap();
    HashMap<String, Integer> ftH = new HashMap();
    HashMap<String, Boolean> ftI = new HashMap();
    j.a ftJ;
    j.a ftK;
    j.a ftL;
    j.a ftM;
    Runnable ftN = new Runnable(this) {
        final /* synthetic */ g ftT;

        {
            this.ftT = r1;
        }

        public final void run() {
            BufferedOutputStream bufferedOutputStream;
            Throwable e;
            ack com_tencent_mm_protocal_c_ack;
            String str;
            String str2;
            int i;
            String str3;
            String str4 = null;
            try {
                String str5 = com.tencent.mm.compatible.util.e.cgf + String.format("%s%d.%s", new Object[]{SlookAirButtonRecentMediaAdapter.IMAGE_TYPE, Integer.valueOf(this.ftT.bhR.hashCode()), "jpg"});
                byte[] sd = g.sd(this.ftT.bhR);
                if (sd != null) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(sd, 0, sd.length);
                    g gVar = this.ftT;
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str5)));
                        try {
                            decodeByteArray.compress(CompressFormat.JPEG, 80, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable e2) {
                                v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            try {
                                v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                                g.bq(gVar.ftQ, gVar.fty);
                                v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Throwable e22) {
                                        v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                    }
                                }
                                this.ftT.ftv = str5;
                                if (this.ftT.ftv == null) {
                                }
                                com_tencent_mm_protocal_c_ack = new ack();
                                str = this.ftT.ftv;
                                if (str != null) {
                                }
                                str2 = null;
                                i = -1;
                                str3 = null;
                                com_tencent_mm_protocal_c_ack.mqB = str4;
                                com_tencent_mm_protocal_c_ack.gkB = str3;
                                com_tencent_mm_protocal_c_ack.efj = i;
                                com_tencent_mm_protocal_c_ack.mpC = str2;
                                this.ftT.ftO.mDv = com_tencent_mm_protocal_c_ack;
                                this.ftT.ftO.mDs = 3;
                                ak.vy().a(new n(this.ftT.ftO, this.ftT.ftP, this.ftT.ftQ, this.ftT.ftR), 0);
                                return;
                            } catch (Throwable th) {
                                e22 = th;
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Throwable e4) {
                                        v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e4, "", new Object[0]);
                                    }
                                }
                                throw e22;
                            }
                        }
                    } catch (IOException e5) {
                        e22 = e5;
                        bufferedOutputStream = null;
                        v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                        g.bq(gVar.ftQ, gVar.fty);
                        v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        this.ftT.ftv = str5;
                        if (this.ftT.ftv == null) {
                        }
                        com_tencent_mm_protocal_c_ack = new ack();
                        str = this.ftT.ftv;
                        if (str != null) {
                        }
                        str2 = null;
                        i = -1;
                        str3 = null;
                        com_tencent_mm_protocal_c_ack.mqB = str4;
                        com_tencent_mm_protocal_c_ack.gkB = str3;
                        com_tencent_mm_protocal_c_ack.efj = i;
                        com_tencent_mm_protocal_c_ack.mpC = str2;
                        this.ftT.ftO.mDv = com_tencent_mm_protocal_c_ack;
                        this.ftT.ftO.mDs = 3;
                        ak.vy().a(new n(this.ftT.ftO, this.ftT.ftP, this.ftT.ftQ, this.ftT.ftR), 0);
                        return;
                    } catch (Throwable th2) {
                        e22 = th2;
                        bufferedOutputStream = null;
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw e22;
                    }
                    this.ftT.ftv = str5;
                    if (this.ftT.ftv == null || FileOp.aR(this.ftT.ftv)) {
                        com_tencent_mm_protocal_c_ack = new ack();
                        str = this.ftT.ftv;
                        if (str != null || str.length() <= 0) {
                            str2 = null;
                            i = -1;
                            str3 = null;
                        } else {
                            File file = new File(str);
                            str3 = file.getName();
                            i = (int) file.length();
                            str4 = str3.substring(str3.lastIndexOf(".") + 1, str3.length());
                            str2 = com.tencent.mm.a.g.g(file);
                            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable filePath %s", new Object[]{str});
                            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileSize %s", new Object[]{Integer.valueOf(i)});
                            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileMd5 %s", new Object[]{str2});
                        }
                        com_tencent_mm_protocal_c_ack.mqB = str4;
                        com_tencent_mm_protocal_c_ack.gkB = str3;
                        com_tencent_mm_protocal_c_ack.efj = i;
                        com_tencent_mm_protocal_c_ack.mpC = str2;
                        this.ftT.ftO.mDv = com_tencent_mm_protocal_c_ack;
                        this.ftT.ftO.mDs = 3;
                        ak.vy().a(new n(this.ftT.ftO, this.ftT.ftP, this.ftT.ftQ, this.ftT.ftR), 0);
                        return;
                    }
                    v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mSnsImagePath is null or file not exist!");
                    g.bq(this.ftT.ftQ, this.ftT.fty);
                    return;
                }
                v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get image error !");
                g.bq(this.ftT.ftQ, this.ftT.fty);
            } catch (Throwable e222) {
                v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
            }
        }
    };
    acj ftO;
    String ftP;
    String ftQ;
    int ftR;
    HashMap<Integer, String> ftS = new HashMap();
    boolean ftr = false;
    boolean fts = false;
    boolean ftt = false;
    String ftu;
    String ftv;
    int ftw;
    String ftx = "send_data_sucess";
    String fty = "send_data_failed";
    private String ftz = "send_data_sending";

    static /* synthetic */ void a(g gVar, String str, int i) {
        dj djVar = new dj();
        djVar.bbr.aRh = str;
        if (i >= 100) {
            djVar.bbr.bbt = gVar.ftx;
        } else {
            djVar.bbr.bbt = gVar.ftz;
        }
        djVar.bbr.progress = i;
        com.tencent.mm.sdk.c.a.nhr.z(djVar);
    }

    static /* synthetic */ void a(g gVar, List list) {
        List arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((b) list.get(i)).field_deviceType);
            hashMap.put("deviceID", ((b) list.get(i)).field_deviceID);
            hashMap.put("displayName", f((b) list.get(i)));
            hashMap.put("iconUrl", ((b) list.get(i)).iconUrl);
            hashMap.put("ability", ((b) list.get(i)).bLi);
            hashMap.put("abilityInf", ((b) list.get(i)).bLj);
            arrayList.add(hashMap);
        }
        df dfVar = new df();
        dfVar.bbg.bas = arrayList;
        com.tencent.mm.sdk.c.a.nhr.z(dfVar);
    }

    public g() {
        this.ftF.clear();
        this.ftG.clear();
        this.ftI.clear();
        this.ftE = ac.ajq().ajY();
        if (this.ftE != null && this.ftE.size() > 0) {
            v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", new Object[]{Integer.valueOf(this.ftE.size())});
            int size = this.ftE.size();
            int i = 0;
            while (i < size) {
                if (((b) this.ftE.get(i)).bLi.contains("internet_to_device") && !((b) this.ftE.get(i)).bLi.contains("wechat_to_device")) {
                    this.ftF.add(this.ftE.get(i));
                }
                i++;
            }
            this.ftM = new j.a(this) {
                final /* synthetic */ g ftT;

                {
                    this.ftT = r1;
                }

                public final void e(int i, Object... objArr) {
                    int i2;
                    Object obj;
                    if (i == 15 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        try {
                            v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file transfer update json %s", new Object[]{new String((byte[]) objArr[1])});
                            int i3 = new JSONObject(r1).getInt("progress");
                            try {
                                g.a(this.ftT, (String) this.ftT.ftS.get(Integer.valueOf(intValue)), i3);
                                if (i3 >= 100) {
                                    this.ftT.ftS.remove(Integer.valueOf(intValue));
                                }
                                i2 = i3;
                            } catch (JSONException e) {
                                JSONException jSONException = e;
                                i2 = i3;
                                JSONException jSONException2 = jSONException;
                                v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", new Object[]{obj});
                                v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", new Object[]{Integer.valueOf(i2)});
                            }
                        } catch (JSONException e2) {
                            obj = e2;
                            i2 = 0;
                            v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", new Object[]{obj});
                            v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", new Object[]{Integer.valueOf(i2)});
                        }
                        v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", new Object[]{Integer.valueOf(i2)});
                    }
                }
            };
            this.ftJ = new j.a(this) {
                final /* synthetic */ g ftT;

                {
                    this.ftT = r1;
                }

                public final void e(int i, Object... objArr) {
                    String string;
                    Exception e;
                    Object obj;
                    Object obj2;
                    JSONObject jSONObject;
                    int i2;
                    String str = null;
                    if (i == 14 && objArr != null && objArr.length > 0 && (objArr[0] instanceof byte[])) {
                        JSONObject jSONObject2;
                        int size;
                        try {
                            JSONObject jSONObject3 = new JSONObject(new String((byte[]) objArr[0]));
                            jSONObject2 = jSONObject3.getJSONObject("deviceInfo");
                            try {
                                string = jSONObject2.getString("deviceType");
                            } catch (Exception e2) {
                                e = e2;
                                string = null;
                                v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", new Object[]{e});
                                obj = string;
                                obj2 = str;
                                jSONObject = jSONObject2;
                                v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", new Object[]{obj, obj2});
                                size = this.ftT.ftE.size();
                                i2 = 0;
                                while (i2 < size) {
                                    this.ftT.ftG.put(obj2, jSONObject.toString());
                                    this.ftT.ftF.add(this.ftT.ftE.get(i2));
                                    g.a(this.ftT, this.ftT.ftF);
                                    i2++;
                                }
                            }
                            try {
                                str = jSONObject2.getString("deviceId");
                                if (jSONObject3.isNull("profile")) {
                                    v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "json have not profile, return");
                                    return;
                                }
                                JSONArray jSONArray = jSONObject3.getJSONArray("profile");
                                v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package profiles %s", new Object[]{jSONArray.toString()});
                                String str2 = string;
                                string = str;
                                jSONObject = jSONObject2;
                                if (!(obj == null || obj2 == null)) {
                                    v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", new Object[]{obj, obj2});
                                }
                                size = this.ftT.ftE.size();
                                i2 = 0;
                                while (i2 < size) {
                                    if (((b) this.ftT.ftE.get(i2)).field_deviceID.equals(obj2) && ((b) this.ftT.ftE.get(i2)).field_deviceType.equals(obj) && ((b) this.ftT.ftE.get(i2)).bLi.contains("wechat_to_device") && !this.ftT.ftF.contains(this.ftT.ftE.get(i2))) {
                                        this.ftT.ftG.put(obj2, jSONObject.toString());
                                        this.ftT.ftF.add(this.ftT.ftE.get(i2));
                                        g.a(this.ftT, this.ftT.ftF);
                                    }
                                    i2++;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", new Object[]{e});
                                obj = string;
                                obj2 = str;
                                jSONObject = jSONObject2;
                                v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", new Object[]{obj, obj2});
                                size = this.ftT.ftE.size();
                                i2 = 0;
                                while (i2 < size) {
                                    this.ftT.ftG.put(obj2, jSONObject.toString());
                                    this.ftT.ftF.add(this.ftT.ftE.get(i2));
                                    g.a(this.ftT, this.ftT.ftF);
                                    i2++;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            jSONObject2 = null;
                            string = null;
                            v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", new Object[]{e});
                            obj = string;
                            obj2 = str;
                            jSONObject = jSONObject2;
                            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", new Object[]{obj, obj2});
                            size = this.ftT.ftE.size();
                            i2 = 0;
                            while (i2 < size) {
                                this.ftT.ftG.put(obj2, jSONObject.toString());
                                this.ftT.ftF.add(this.ftT.ftE.get(i2));
                                g.a(this.ftT, this.ftT.ftF);
                                i2++;
                            }
                        }
                    }
                }
            };
            this.ftK = new j.a(this) {
                final /* synthetic */ g ftT;

                {
                    this.ftT = r1;
                }

                public final void e(int i, Object... objArr) {
                    if (i == 12 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        byte[] bArr = (byte[]) objArr[1];
                        if (intValue > 0) {
                            String str = (String) this.ftT.ftS.get(Integer.valueOf(intValue));
                            if (str != null) {
                                try {
                                    v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", new Object[]{new String(bArr)});
                                    JSONObject jSONObject = new JSONObject(r2);
                                    if (jSONObject.isNull("errcode") || jSONObject.getInt("errcode") == 0) {
                                        g.bq(str, this.ftT.ftx);
                                        v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
                                        return;
                                    }
                                    g.bq(str, this.ftT.fty);
                                    v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", new Object[]{r2});
                                    return;
                                } catch (JSONException e) {
                                    v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", new Object[]{e});
                                    return;
                                }
                            }
                        }
                        v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =" + intValue);
                    }
                }
            };
            this.ftL = new j.a(this) {
                final /* synthetic */ g ftT;

                {
                    this.ftT = r1;
                }

                public final void e(int i, Object... objArr) {
                    if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
                        String str = (String) objArr[0];
                        int intValue = ((Integer) objArr[1]).intValue();
                        Object obj = null;
                        try {
                            JSONObject jSONObject = new JSONObject(new String(str));
                            obj = jSONObject.getString("deviceId");
                            jSONObject.getString("deviceType");
                        } catch (Throwable e) {
                            v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e, "", new Object[0]);
                            v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
                        }
                        switch (intValue) {
                            case ai.CTRL_INDEX /*-2*/:
                            case -1:
                            case 0:
                                this.ftT.ftI.put(obj, Boolean.valueOf(false));
                                v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = " + intValue);
                                return;
                            case 1:
                                this.ftT.ftI.put(obj, Boolean.valueOf(true));
                                v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            ak.vy().a(1717, this);
            j.ajh().a(14, this.ftJ);
            j.ajh().a(12, this.ftK);
            j.ajh().a(13, this.ftL);
            j.ajh().a(15, this.ftM);
            v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
        }
    }

    static Boolean aV(long j) {
        boolean z = false;
        ak.yW();
        at ek = c.wJ().ek(j);
        if (ek.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        String str = ek.field_content;
        if (ek.field_type == 49) {
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str);
            if (dV != null && dV.type == 6) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }

    static Boolean aW(long j) {
        boolean z = false;
        ak.yW();
        at ek = c.wJ().ek(j);
        if (ek.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (ek.field_type == 3) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static Boolean aX(long j) {
        boolean z = false;
        ak.yW();
        at ek = c.wJ().ek(j);
        if (ek.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (ek.bwr()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static Boolean aY(long j) {
        boolean z = false;
        ak.yW();
        at ek = c.wJ().ek(j);
        if (ek.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (ek.field_type == 62) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static byte[] sd(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "url %s", new Object[]{str});
        t a;
        InputStream inputStream;
        try {
            a = com.tencent.mm.network.b.a(str, null);
            try {
                a.setRequestMethod("GET");
                a.setConnectTimeout(25000);
                a.setReadTimeout(25000);
                inputStream = a.getInputStream();
                try {
                    if (a.getResponseCode() == 200) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            byteArrayOutputStream.close();
                            inputStream.close();
                            a.dmc.disconnect();
                            bArr = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e2) {
                                v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                }
                            }
                            a.dmc.disconnect();
                        } catch (Exception e3) {
                            e22 = e3;
                            try {
                                v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable e222) {
                                        v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e2222) {
                                        v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222, "", new Object[0]);
                                    }
                                }
                                if (a != null) {
                                    a.dmc.disconnect();
                                }
                                return bArr;
                            } catch (Throwable th2) {
                                th = th2;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable e22222) {
                                        v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22222, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e222222) {
                                        v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222222, "", new Object[0]);
                                    }
                                }
                                if (a != null) {
                                    a.dmc.disconnect();
                                }
                                throw th;
                            }
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e2222222) {
                            v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222222, "", new Object[0]);
                        }
                    }
                    a.dmc.disconnect();
                } catch (Exception e4) {
                    e2222222 = e4;
                    byteArrayOutputStream = bArr;
                    v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222222, "", new Object[0]);
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (a != null) {
                        a.dmc.disconnect();
                    }
                    return bArr;
                } catch (Throwable e22222222) {
                    byteArrayOutputStream = bArr;
                    th = e22222222;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (a != null) {
                        a.dmc.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e22222222 = e5;
                inputStream = bArr;
                byteArrayOutputStream = bArr;
                v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22222222, "", new Object[0]);
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (a != null) {
                    a.dmc.disconnect();
                }
                return bArr;
            } catch (Throwable e222222222) {
                inputStream = bArr;
                byteArrayOutputStream = bArr;
                th = e222222222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (a != null) {
                    a.dmc.disconnect();
                }
                throw th;
            }
        } catch (Exception e6) {
            e222222222 = e6;
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
            v.a("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222222222, "", new Object[0]);
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (a != null) {
                a.dmc.disconnect();
            }
            return bArr;
        } catch (Throwable e2222222222) {
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
            th = e2222222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (a != null) {
                a.dmc.disconnect();
            }
            throw th;
        }
        return bArr;
    }

    public final azr ajf() {
        gs gsVar = new gs();
        gsVar.bgj.bap = this.ftu;
        com.tencent.mm.sdk.c.a.nhr.z(gsVar);
        return gsVar.bgk.bgl;
    }

    final boolean a(acj com_tencent_mm_protocal_c_acj, long j) {
        int i = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String aZ = aZ(j);
        if (aZ != null && aZ.length() > 0) {
            File file = new File(aZ);
            str2 = file.getName();
            i = (int) file.length();
            str3 = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
            str = com.tencent.mm.a.g.g(file);
            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", new Object[]{aZ});
            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", new Object[]{Integer.valueOf(i)});
            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", new Object[]{str});
        }
        ak.yW();
        at ek = c.wJ().ek(j);
        if (ek.field_msgId == 0) {
            v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
            return false;
        }
        switch (ek.field_type) {
            case 3:
                ack com_tencent_mm_protocal_c_ack = new ack();
                com_tencent_mm_protocal_c_ack.mqB = str3;
                com_tencent_mm_protocal_c_ack.gkB = str2;
                com_tencent_mm_protocal_c_ack.efj = i;
                com_tencent_mm_protocal_c_ack.mpC = str;
                com_tencent_mm_protocal_c_acj.mDv = com_tencent_mm_protocal_c_ack;
                com_tencent_mm_protocal_c_acj.mDs = 3;
                break;
            case 48:
                ak.yW();
                at.b MV = c.wJ().MV(ek.field_content);
                acl com_tencent_mm_protocal_c_acl = new acl();
                com_tencent_mm_protocal_c_acl.mij = (float) MV.gRK;
                com_tencent_mm_protocal_c_acl.mik = (float) MV.gRL;
                com_tencent_mm_protocal_c_acl.mDA = (float) MV.bhu;
                com_tencent_mm_protocal_c_acl.gnz = MV.label;
                com_tencent_mm_protocal_c_acl.mDC = MV.gUr;
                com_tencent_mm_protocal_c_acj.mDu = com_tencent_mm_protocal_c_acl;
                com_tencent_mm_protocal_c_acj.mDs = 2;
                break;
            case 49:
            case 268435505:
                com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(ek.field_content);
                if (dV != null) {
                    if (dV.type != 3) {
                        if (dV.type != 6) {
                            if (dV.type != 5) {
                                if (dV.type == 2) {
                                    ack com_tencent_mm_protocal_c_ack2 = new ack();
                                    com_tencent_mm_protocal_c_ack2.mqB = "jpg";
                                    com_tencent_mm_protocal_c_ack2.gkB = str2;
                                    com_tencent_mm_protocal_c_ack2.efj = i;
                                    com_tencent_mm_protocal_c_ack2.mpC = str;
                                    com_tencent_mm_protocal_c_acj.mDv = com_tencent_mm_protocal_c_ack2;
                                    com_tencent_mm_protocal_c_acj.mDs = 3;
                                    break;
                                }
                            }
                            acn com_tencent_mm_protocal_c_acn = new acn();
                            com_tencent_mm_protocal_c_acn.glb = dV.url;
                            com_tencent_mm_protocal_c_acn.aXz = dV.title;
                            com_tencent_mm_protocal_c_acn.mDD = dV.description;
                            com_tencent_mm_protocal_c_acn.hNZ = dV.appName;
                            com_tencent_mm_protocal_c_acj.mDx = com_tencent_mm_protocal_c_acn;
                            com_tencent_mm_protocal_c_acj.mDs = 5;
                            break;
                        }
                        aci com_tencent_mm_protocal_c_aci = new aci();
                        com_tencent_mm_protocal_c_aci.mqB = dV.coc;
                        com_tencent_mm_protocal_c_aci.gkB = dV.title;
                        com_tencent_mm_protocal_c_aci.efj = i;
                        com_tencent_mm_protocal_c_aci.mpC = str;
                        com_tencent_mm_protocal_c_acj.mDw = com_tencent_mm_protocal_c_aci;
                        com_tencent_mm_protocal_c_acj.mDs = 4;
                        break;
                    }
                    acm com_tencent_mm_protocal_c_acm = new acm();
                    com_tencent_mm_protocal_c_acm.aXz = dV.title;
                    com_tencent_mm_protocal_c_acm.mDD = dV.description;
                    com_tencent_mm_protocal_c_acm.glb = dV.url;
                    com_tencent_mm_protocal_c_acm.mDE = dV.coa;
                    com_tencent_mm_protocal_c_acm.mDF = dV.cos;
                    com_tencent_mm_protocal_c_acm.mDG = dV.cot;
                    com_tencent_mm_protocal_c_acm.hNZ = dV.appName;
                    com_tencent_mm_protocal_c_acm.mDH = dV.coj;
                    com_tencent_mm_protocal_c_acm.mDI = dV.cok;
                    com_tencent_mm_protocal_c_acm.mDJ = dV.coq;
                    com_tencent_mm_protocal_c_acj.mDt = com_tencent_mm_protocal_c_acm;
                    com_tencent_mm_protocal_c_acj.mDs = 1;
                    break;
                }
                v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
                return false;
                break;
            case ao.CTRL_INDEX /*62*/:
                aco com_tencent_mm_protocal_c_aco = new aco();
                com_tencent_mm_protocal_c_aco.mqB = str3;
                com_tencent_mm_protocal_c_aco.efj = i;
                com_tencent_mm_protocal_c_aco.mpC = str;
                com_tencent_mm_protocal_c_aco.gkB = str2;
                com_tencent_mm_protocal_c_acj.mDy = com_tencent_mm_protocal_c_aco;
                com_tencent_mm_protocal_c_acj.mDs = 6;
                break;
        }
        return true;
    }

    private String aZ(long j) {
        String str = "";
        ak.yW();
        at ek = c.wJ().ek(j);
        if (ek.field_msgId == 0) {
            return "";
        }
        int i = ek.field_type;
        String str2 = ek.field_content;
        if (ek.bvY()) {
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str2);
            if (dV != null && (dV.type == 6 || dV.type == 2)) {
                com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(dV.aXa);
                if (Gu != null) {
                    return Gu.field_fileFullPath;
                }
                v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                return str;
            } else if (dV == null) {
                return str;
            } else {
                if (dV.type != 3 && dV.type != 5) {
                    return str;
                }
                this.fts = true;
                return str;
            }
        } else if (i == 3) {
            d j2 = n.GH().j(ek);
            if (j2 == null) {
                return str;
            }
            str = n.GH().iW(j2.cLv);
            if (be.kS(str)) {
                return n.GH().iW(j2.cLx);
            }
            return str;
        } else if (i == 62) {
            k.KV();
            return o.lc(ek.field_imgPath);
        } else if (i != 48) {
            return str;
        } else {
            this.fts = true;
            return str;
        }
    }

    static void bq(String str, String str2) {
        dj djVar = new dj();
        djVar.bbr.bbt = str2;
        djVar.bbr.aRh = str;
        com.tencent.mm.sdk.c.a.nhr.z(djVar);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
        } else if (kVar instanceof n) {
            n nVar = (n) kVar;
            if (i == 0 && i2 == 0) {
                bab com_tencent_mm_protocal_c_bab = (nVar.cif == null || nVar.cif.czl.czs == null) ? null : (bab) nVar.cif.czl.czs;
                String str2 = com_tencent_mm_protocal_c_bab.mWI;
                if (1 == nVar.fuz) {
                    bq(nVar.aRh, this.ftx);
                    return;
                }
                String str3 = nVar.aRh;
                String str4 = (String) this.ftG.get(str3);
                bq(str3, this.ftz);
                String aZ = (!this.ftt || this.ftu == null) ? aZ(this.bZz) : this.ftv;
                if (str4 == null || str4.length() == 0) {
                    v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
                    bq(str3, this.fty);
                    return;
                }
                if (!this.ftr) {
                    v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
                    Java2CExDevice.stopScanWCLanDevice();
                    this.ftr = true;
                }
                if (!(this.ftI.containsKey(str3) && ((Boolean) this.ftI.get(str3)).booleanValue())) {
                    v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: " + str4);
                    if (Java2CExDevice.connectWCLanDevice(str4.getBytes(), true) != 0) {
                        bq(str3, this.fty);
                        v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
                    }
                }
                int useWCLanDeviceService;
                if (this.fts) {
                    useWCLanDeviceService = Java2CExDevice.useWCLanDeviceService(str4.getBytes(), str2.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.ftS.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.ftH.put(str3, Integer.valueOf(useWCLanDeviceService));
                        v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: " + useWCLanDeviceService);
                        return;
                    }
                    bq(str3, this.fty);
                    v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
                    return;
                } else if (aZ == null || aZ.length() == 0) {
                    v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
                    bq(str3, this.fty);
                    return;
                } else {
                    useWCLanDeviceService = Java2CExDevice.sendFileToWCLanDevice(str4.getBytes(), str2.getBytes(), aZ.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.ftS.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.ftH.put(str3, Integer.valueOf(useWCLanDeviceService));
                        v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =" + useWCLanDeviceService);
                        return;
                    }
                    bq(str3, this.fty);
                    v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
                    return;
                }
            }
            v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            bq(nVar.aRh, this.fty);
        }
    }

    static String f(b bVar) {
        if (bVar == null) {
            return "";
        }
        String str = null;
        if (!be.kS(bVar.bLc)) {
            str = bVar.bLc;
        } else if (!be.kS(bVar.bLd)) {
            str = bVar.bLd;
        } else if (bVar.field_mac != 0) {
            str = com.tencent.mm.plugin.exdevice.j.b.br(bVar.field_mac);
        } else if (!be.kS(bVar.field_deviceID)) {
            str = bVar.field_deviceID;
        }
        return be.ma(str);
    }
}
