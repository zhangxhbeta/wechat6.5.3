package com.tencent.mm.plugin.voip.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class v2protocal {
    public static final int hyT;
    public static int kjU;
    public static final int kvC;
    public static boolean kvD = false;
    public long cLC = 0;
    public int channelStrategy = 0;
    public int defaultHeight = 240;
    public int defaultWidth = 320;
    public int[] field_SpeedTestSvrParaArray = null;
    public int field_audioDuration = 0;
    public byte[] field_capInfo = null;
    int field_channelStatLength = 0;
    public int field_connectingStatusKey = 0;
    int field_engine2ndStatLength = 0;
    int field_engineQosStatLength = 0;
    int field_engineVersionStatLength = 0;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_mGetValidSample = 0;
    int field_netFlowRecv = 0;
    int field_netFlowSent = 0;
    int field_newEngineExtStatLength = 0;
    int field_newEngineStatLength = 0;
    public byte[] field_peerId = null;
    public int field_pstnChannelInfoLength = 0;
    public int field_pstnEngineInfoLength = 0;
    public int[] field_punchSvrArray = null;
    public int field_realLinkQualityInfoBuffLen = 0;
    public int field_recvVideoLen = 120;
    public int field_relayDataSyncKey = 0;
    public int[] field_relaySvrArray = null;
    public int[] field_relayTcpSvrArray = null;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgOrien = 0;
    public int field_remoteImgWidth = 0;
    public int field_sendVideoLen = 100;
    int field_speedTestInfoLength = 0;
    int field_statInfoLength = 0;
    public int field_statusSyncKey = 0;
    public int field_videoDuration = 0;
    public int field_voipcsChannelInfoLength = 0;
    public int field_voipcsEngineInfoLength = 0;
    public int gFG = 0;
    public long gFH = 0;
    public int gFJ = 0;
    public int gFO = 0;
    public String gUE = "";
    private ac handler = null;
    public boolean hqt = false;
    public int kvE = 0;
    public int kvF = 0;
    public int kvG = 0;
    public int kvH = 0;
    public long kvI = 0;
    public byte[] kvJ = null;
    public byte[] kvK = null;
    public byte[] kvL = null;
    public int kvM = 0;
    public byte[] kvN = null;
    public int kvO = 500;
    public int kvP = 30;
    public int kvQ = 999;
    public int kvR = 0;
    public int kvS = 0;
    public int kvT = 0;
    public int kvU = 0;
    public int kvV = 0;
    public int kvW = 0;
    public int kvX = 0;
    public int kvY = 0;
    public int kvZ = 7;
    public int kwA = 0;
    public int kwB = 0;
    public byte[] kwC = null;
    public int kwD = 0;
    public int kwE = 0;
    public byte[] kwF = new byte[1500];
    public int kwG = 0;
    public byte[] kwH = null;
    public byte[] kwI = null;
    public int kwJ = 0;
    public int kwK = 0;
    public long kwL = 0;
    public byte[] kwM = new byte[8];
    public int kwN = 0;
    public int kwO = 0;
    public int kwP = 0;
    public int kwQ = 0;
    public int kwR = 0;
    byte[] kwS = new byte[4096];
    byte[] kwT = new byte[2048];
    byte[] kwU = new byte[2048];
    byte[] kwV = new byte[4096];
    byte[] kwW = new byte[4096];
    byte[] kwX = new byte[2048];
    byte[] kwY = new byte[4096];
    public byte[] kwZ = new byte[2048];
    public int kwa = 3;
    public int kwb = 3;
    public int kwc = 0;
    public int kwd = 0;
    public int kwe = -1;
    public int kwf = -1;
    public int kwg = 0;
    public int kwh = 0;
    public int kwi = 0;
    public int kwj = 0;
    public int kwk = 100;
    public int kwl = 300;
    public int kwm = 1;
    public int kwn = 1;
    public int kwo = 0;
    public int kwp = 1;
    public int kwq = 0;
    public int kwr = 0;
    public int kws = 0;
    public int kwt = 0;
    public int kwu = 0;
    public int kwv = 0;
    public int kww = 0;
    public int[] kwx = null;
    public int kwy = 0;
    public int kwz = 0;
    public byte[] kxa = new byte[2048];
    public byte[] kxb = new byte[2048];
    public byte[] kxc = new byte[2048];
    public int[] kxd = new int[30];
    int kxe = 0;
    public h kxf = new h();
    public int netType = 0;

    private native int forceredirect();

    private native int setsvraddr();

    private native int uninit();

    public native int SendDTMF(int i);

    public native int SendRUDP(byte[] bArr, int i);

    public native int SetDTMFPayload(int i);

    public native int StartSpeedTest(long j, int i);

    public native int StopSpeedTest();

    public native int app2EngineDataEx(int i, int i2, byte[] bArr, int i3, int i4);

    public native int app2EngineLinkQualityEx(int i, byte[] bArr);

    public native int doubleLinkSwitch(int i);

    public native int exchangeCabInfo(byte[] bArr, int i);

    public native int freeJNIReport();

    public native int getAVDuration(byte[] bArr, int i);

    public native int getChannelInfo(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int getCurrentConnType();

    public native int getEngine2ndInfo(byte[] bArr, int i);

    public native int getEngineQosInfo(byte[] bArr, int i);

    public native int getEngineVersionInfo(byte[] bArr, int i);

    public native int getNewEngineExtInfo(byte[] bArr, int i);

    public native int getNewEngineInfo(byte[] bArr, int i);

    public native int getPstnChannelInfo(byte[] bArr, int i, int i2, int i3);

    public native int getPstnEngineInfo(byte[] bArr, int i);

    public native int getStatInfo(byte[] bArr, int i, int[] iArr, int i2);

    public native int getVoipcsChannelInfo(byte[] bArr, int i, int i2);

    public native int getVoipcsEngineInfo(byte[] bArr, int i);

    public native int getcurstrategy();

    public native int handleCommand(byte[] bArr, int i);

    public native int init(int i, int i2, int i3, int i4, int i5, int i6, String str, int i7);

    public native int isDCReady();

    public native int isDCSameLan();

    public native int isRelayConnReady();

    public native int parseSyncKeyBuff(byte[] bArr, int i);

    public native int playCallback(byte[] bArr, int i);

    public native int recordCallback(byte[] bArr, int i, int i2);

    public native int setActive();

    public native int setAppCmd(int i, byte[] bArr, int i2);

    public native int setConfigConnect(int i, long j, int i2, long j2, byte[] bArr, int i3, int i4, int i5, int i6, int i7, byte[] bArr2, int i8, int i9, int i10, int i11, byte[] bArr3);

    public native int setInactive();

    public native int setJNIAppCmd(int i, byte[] bArr, int i2);

    public native int setSvrConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public native int startEngine();

    public native int videoDecode(int[] iArr);

    public native int videoEncodeToLocal(byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr);

    public native int videoEncodeToSend(byte[] bArr, int i, int i2, int i3, int i4);

    public native int videoRorate90D(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7, int i8);

    static {
        int rx = l.rx();
        if ((rx & 1024) != 0) {
            d.v(aa.getContext(), "libvoipCodec_v7a.so");
        } else if ((rx & 512) != 0) {
            d.v(aa.getContext(), "libvoipCodec.so");
        } else {
            d.v(aa.getContext(), "libvoipCodec_v5.so");
        }
        k.b("voipMain", v2protocal.class.getClassLoader());
        rx = l.rx();
        kjU = rx;
        rx = (rx & 1024) != 0 ? 16000 : 8000;
        hyT = rx;
        kvC = ((rx / BaseReportManager.MAX_READ_COUNT) * 20) * 2;
    }

    public final int nl(int i) {
        int appCmd = setAppCmd(i, new byte[]{(byte) 0}, 1);
        if (appCmd < 0) {
            a.cT("MicroMsg.Voip", "setAppCmd: type:" + appCmd + ":ret:" + appCmd);
        }
        return appCmd;
    }

    public static String bcZ() {
        String str = Build.MANUFACTURER;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.MODEL;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        String str3 = VERSION.SDK;
        if (str3.contains(",")) {
            str3 = str3.replace(',', ' ');
        }
        String str4 = VERSION.RELEASE;
        if (str4.contains(",")) {
            str4 = str3.replace(',', ' ');
        }
        return "," + str + "," + str2 + "," + str3 + "," + str4;
    }

    public static long aL(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getLong();
    }

    private String bda() {
        return "," + this.channelStrategy;
    }

    public final String bdb() {
        if (this.field_videoDuration == 0) {
            a.cT("MicroMsg.Voip", "captureFrames:" + this.kwN + ", videoduration: 0");
            return ",0";
        }
        a.cT("MicroMsg.Voip", "capturefps:" + (this.kwN / this.field_videoDuration) + " framecount:" + this.kwN + " videoDuration:" + this.field_videoDuration);
        return "," + (this.kwN / this.field_videoDuration);
    }

    private String bdc() {
        a.cT("MicroMsg.Voip", "usePreConnect:" + this.kwi);
        return "," + this.kwi;
    }

    private String bdd() {
        a.cT("MicroMsg.Voip", "preConnectSuccess:" + this.kwj);
        return "," + this.kwj;
    }

    public final String bde() {
        if (VERSION.SDK_INT < 11) {
            this.kwa = 0;
            this.kwb = 2;
        } else {
            this.kwa = 3;
            this.kwb = 3;
        }
        if (p.ceB.cbQ >= 0) {
            this.kwa = p.ceB.cbQ;
        }
        if (VERSION.SDK_INT >= 11 && com.tencent.mm.compatible.util.l.qA() && 2 == p.ceJ.cdz) {
            this.kwb = 2;
        }
        if (p.ceB.cbR >= 0) {
            this.kwb = p.ceB.cbR;
        }
        if (VERSION.SDK_INT < 11) {
            this.kvZ = 1;
        } else {
            this.kvZ = 7;
        }
        if (p.ceB.cbr) {
            this.kvZ = 1;
        }
        if (p.ceB.cbP >= 0) {
            this.kvZ = p.ceB.cbP;
        }
        if (p.ceB.cbs > 0) {
            this.kwc = 3;
            this.kwd = 0;
        } else if (p.ceB.cbS >= 0) {
            this.kwc = p.ceB.cbS;
            this.kwd = p.ceB.cbS;
        }
        if (p.ceB.cbT >= 0) {
            this.kwc = p.ceB.cbT;
        }
        if (p.ceB.cbU >= 0) {
            this.kwd = p.ceB.cbU;
        }
        return "," + this.kwa + "," + this.kwb + "," + this.kvZ + "," + this.kwc + "," + this.kwd;
    }

    public v2protocal(ac acVar) {
        this.handler = acVar;
    }

    public int keep_onNotifyFromJni(int i, int i2, byte[] bArr) {
        if (i == 100) {
            a.a(bArr, "MicroMsg.Voip", i2);
        } else if (i == 101) {
            a.a(bArr, "MicroMsg.v2Core", i2);
        } else {
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = bArr;
            this.handler.sendMessage(message);
        }
        return 0;
    }

    public final int b(beh com_tencent_mm_protocal_c_beh, beh com_tencent_mm_protocal_c_beh2, beh com_tencent_mm_protocal_c_beh3) {
        if (com_tencent_mm_protocal_c_beh == null || com_tencent_mm_protocal_c_beh.naa <= 0) {
            a.cT("MicroMsg.Voip", "forceRedirect: [TRANSPORT]No relay svr ip");
        } else {
            a.cT("MicroMsg.Voip", "forceRedirect: got relay svr addr from server");
            this.field_relaySvrArray = a.a(com_tencent_mm_protocal_c_beh);
        }
        if (com_tencent_mm_protocal_c_beh2 == null || com_tencent_mm_protocal_c_beh2.naa <= 0) {
            a.cT("MicroMsg.Voip", "forceRedirect: No punch svr ip");
        } else {
            a.cT("MicroMsg.Voip", "forceRedirect: got punch svr addr from server");
            this.field_punchSvrArray = a.a(com_tencent_mm_protocal_c_beh2);
        }
        if (com_tencent_mm_protocal_c_beh3 == null || com_tencent_mm_protocal_c_beh3.naa <= 0) {
            a.cT("MicroMsg.Voip", "forceRedirect: No relay tcp svr ip");
        } else {
            a.cT("MicroMsg.Voip", "forceRedirect: got relay tcp svr addr from server");
            this.field_relayTcpSvrArray = a.a(com_tencent_mm_protocal_c_beh3);
        }
        int forceredirect = forceredirect();
        a.cT("MicroMsg.Voip", "v2protocal forceRedirect ret :" + forceredirect);
        return forceredirect;
    }

    public final int c(beh com_tencent_mm_protocal_c_beh, beh com_tencent_mm_protocal_c_beh2, beh com_tencent_mm_protocal_c_beh3) {
        if (com_tencent_mm_protocal_c_beh.naa > 0) {
            a.cT("MicroMsg.Voip", "setSvrAddr: got relay svr addr from server");
            this.field_relaySvrArray = a.a(com_tencent_mm_protocal_c_beh);
        } else {
            a.cT("MicroMsg.Voip", "setSvrAddr: [TRANSPORT]No relay svr ip");
        }
        if (com_tencent_mm_protocal_c_beh2.naa > 0) {
            a.cT("MicroMsg.Voip", "setSvrAddr: got punch svr addr from server");
            this.field_punchSvrArray = a.a(com_tencent_mm_protocal_c_beh2);
        } else {
            a.cT("MicroMsg.Voip", "setSvrAddr: No punch svr ip");
        }
        if (com_tencent_mm_protocal_c_beh3.naa > 0) {
            a.cT("MicroMsg.Voip", "setSvrAddr:got tcpsvr addr from server");
            this.field_relayTcpSvrArray = a.a(com_tencent_mm_protocal_c_beh3);
        } else {
            a.cT("MicroMsg.Voip", "setSvrAddr:no tcp svr addr ip");
        }
        int i = setsvraddr();
        a.cT("MicroMsg.Voip", "v2protocal setsvraddr ret :" + i);
        return i;
    }

    public final int aZP() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        this.netType = a.getNetType(aa.getContext());
        this.kvG = this.netType;
        if (this.netType == 5) {
            this.netType = 4;
        }
        boolean z5 = this.kvG >= 4 && (kjU & 1024) != 0 && (kjU & 255) >= 26;
        if (!z5 || (kjU & 255) < 30) {
            z = false;
        } else {
            z = true;
        }
        if (p.ceA.cdd <= 0 || p.ceA.ccG.width < 480 || p.ceA.ccG.height < 360 || p.ceA.ccI.width < 480 || p.ceA.ccI.height < 360) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (p.ceA.cdd < 2 || p.ceA.ccG.width < 640 || p.ceA.ccG.height < 480 || p.ceA.ccI.width < 640 || p.ceA.ccI.height < 480) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (p.ceA.cdd == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((z5 || z2) && !z4) {
            if (z3) {
                this.defaultWidth = 640;
                this.defaultHeight = 480;
            } else {
                this.defaultWidth = 480;
                this.defaultHeight = 360;
            }
            kvD = true;
            a.cS("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        }
        a.cS("MicroMsg.Voip", "steve: Android CPUFlag:" + (kjU & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z5 + ", bEnable480FromSvr:" + z2 + ", bDisable480FromSvr:" + z4 + ", bEnable640FromLocal:" + z + ", bEnable640FromSvr:" + z3);
        this.kwx = new int[(this.defaultWidth * this.defaultHeight)];
        ak.yW();
        this.kvF = c.ww();
        if ((kjU & 1024) != 0) {
            d.v(aa.getContext(), "libvoipCodec_v7a.so");
            a.cT("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
        } else if ((kjU & 512) != 0) {
            d.v(aa.getContext(), "libvoipCodec.so");
            a.cT("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
        } else {
            d.v(aa.getContext(), "libvoipCodec_v5.so");
            a.cT("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
        }
        int i = VERSION.SDK_INT;
        int bdM = OpenGlRender.bdM();
        Display defaultDisplay = ((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int init = init(this.netType, 2, (this.defaultWidth << 16) | this.defaultHeight, (width << 16) | defaultDisplay.getHeight(), this.kvF, kjU | ((bdM << 24) | (i << 16)), e.cnf + "app_lib/", 0);
        a.cT("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + this.kvF);
        this.hqt = true;
        if (init < 0) {
            reset();
        }
        return init;
    }

    public final String gU(boolean z) {
        if (this.hqt) {
            a.cT("MicroMsg.Voip", "call protocalUninit now...needStatInfo=" + z);
            this.hqt = false;
            uninit();
            kvD = false;
            a.cT("MicroMsg.Voip", "uninit over.");
            if (z) {
                getStatInfo(this.kwS, this.kwS.length, this.kxd, 30);
                getEngineVersionInfo(this.kwT, this.kwT.length);
                getEngineQosInfo(this.kwU, this.kwU.length);
                StringBuilder stringBuilder = new StringBuilder();
                long j = (long) this.kvF;
                if (this.kvF < 0) {
                    j = ((long) this.kvF) + 4294967296L;
                }
                StringBuilder append = new StringBuilder().append(j).append(",").append(this.gFH).append(",").append(this.gFG).append(",").append(this.gFO).append(",");
                h hVar = this.kxf;
                String stringBuilder2 = append.append(hVar.ksP + "," + hVar.ksQ + "," + hVar.ksR + "," + hVar.ksS + "," + hVar.ksT + "," + hVar.ksU + "," + hVar.ksV + "," + hVar.ksW + "," + hVar.ksX + "," + hVar.ksY + "," + hVar.ksZ).toString();
                a.cS("MicroMsg.Voip", "voipreport:DailStatString:" + stringBuilder2);
                append = stringBuilder.append(stringBuilder2).append(new String(this.kwS, 0, this.field_statInfoLength)).append(bcZ()).append(bda()).append("," + this.kxf.kta).append(new String(this.kwT, 0, this.field_engineVersionStatLength)).append(bdb());
                a.cT("MicroMsg.Voip", "cpuCapacity:" + kjU);
                stringBuilder2 = append.append("," + kjU).append(bdc()).append(bdd()).append(new String(this.kwU, 0, this.field_engineQosStatLength)).toString();
                a.cS("MicroMsg.Voip", "statInfoBuffer = " + new String(this.kwS, 0, this.field_statInfoLength));
                a.cS("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.kwT, 0, this.field_engineVersionStatLength));
                a.cS("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.kwU, 0, this.field_engineQosStatLength));
                a.cS("MicroMsg.Voip", "voipreport:StatString = " + stringBuilder2);
                ab.a.csa.aC(this.field_netFlowRecv, this.field_netFlowSent);
                a.cT("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
                return stringBuilder2;
            }
        }
        return "";
    }

    public static String bdf() {
        return "\u0000";
    }

    public final String bdg() {
        long j = 0;
        if (this.kvS == 0 && this.kvT == 0) {
            this.kxf.ktg = 0;
        } else if (this.kvT != 0 && this.kvS != 0) {
            this.kxf.ktg = 3;
        } else if (this.kvT != 0) {
            this.kxf.ktg = 1;
        } else if (this.kvS != 0) {
            this.kxf.ktg = 2;
        }
        this.kxf.kto = a.getNetType(aa.getContext());
        this.kxf.ktn = this.field_videoDuration;
        this.kxf.ktm = this.field_audioDuration;
        this.kvX = ak.yX().rf();
        long j2 = (this.kxf.ktv <= 0 || this.kxf.ktq <= this.kxf.ktv) ? 0 : this.kxf.ktq - this.kxf.ktv;
        a.cT("MicroMsg.Voip", "voipreport:acceptcalltime:" + j2);
        setJNIAppCmd(1, this.kwM, this.kwM.length);
        long aL = aL(this.kwM);
        h hVar = this.kxf;
        long j3 = (aL <= this.kxf.ktt || this.kxf.ktt <= 0) ? 0 : aL - this.kxf.ktt;
        hVar.ktw = j3;
        h hVar2 = this.kxf;
        if (aL > this.kxf.ktv && this.kxf.ktv > 0) {
            j = aL - this.kxf.ktv;
        }
        hVar2.ktx = j;
        a.cT("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.kxf.ktw + " lCalledWaitTime:" + this.kxf.ktx);
        StringBuilder append = new StringBuilder().append(this.kvR).append(",").append(this.gFG).append(",").append(this.gFH).append(",").append(this.gFO).append(",").append(this.kxf.ksP).append(",").append(this.kxf.ktb).append(",").append(this.kxf.ktc).append(",").append(this.kxf.ktd).append(",").append(this.kxf.kte).append(",").append(this.kxf.ktf).append(",").append(this.kxf.ktg).append(",").append(this.kxf.ksZ).append(",").append(this.kxf.kth).append(",").append(this.kxf.kti).append(",").append(this.kxf.ktj).append(",").append(this.kxf.ktk).append(",").append(this.kxf.ktl).append(",").append(this.kxf.ktm).append(",").append(this.kxf.ktn).append(",").append(this.kxf.kto).append(bdc()).append(bdd()).append(bcZ()).append(",").append(this.kxf.ktp).append(",").append(this.kvW).append(",").append(this.kvX).append(",").append(j2).append(",").append(this.kxf.ktw).append(",").append(this.kxf.ktx).append(",").append(this.kvY).append(",").append(this.kvG).append(bda()).append(",").append(kjU & 255).append(",").append(this.kwe).append(",").append(this.kwf);
        String str = VERSION.INCREMENTAL;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.DISPLAY;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        str = append.append("," + str + "," + str2).append(",").append(this.kxf.ktr).append(",").append(this.kxf.kts).toString();
        a.cS("MicroMsg.Voip", "voipreport:initNetType:" + this.kvG);
        a.cS("MicroMsg.Voip", "voipreport:NewDialStatString:" + str);
        a.cS("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + bda());
        return str;
    }

    public final String bdh() {
        getChannelInfo(this.kwV, this.kwV.length, this.kwy, this.kwz, this.kwA, this.kwB);
        String str = this.gFH + "," + this.gFG + "," + this.gFO + this.kxf.bbS() + ("," + this.kxf.ktf) + new String(this.kwV, 0, this.field_channelStatLength);
        a.cS("MicroMsg.Voip", "voipreport:ChannelString: " + str);
        return str;
    }

    public final String bdi() {
        getNewEngineInfo(this.kwW, this.kwW.length);
        getNewEngineExtInfo(this.kwX, this.kwX.length);
        String str = this.gFO + "," + this.gFH + this.kxf.bbS() + "," + this.kvS + "," + this.kvT + bdb() + new String(this.kwW, 0, this.field_newEngineStatLength) + "," + this.kvU + "," + this.kvV + bde() + new String(this.kwX, 0, this.field_newEngineExtStatLength);
        a.cS("MicroMsg.Voip", "voipreport:NewEngineString:" + str);
        return str;
    }

    public final String bdj() {
        getEngine2ndInfo(this.kwY, this.kwY.length);
        String str = this.gFH + "," + this.gFG + "," + this.gFO + new String(this.kwY, 0, this.field_engine2ndStatLength);
        a.cS("MicroMsg.Voip", "voipreport:12805,Engine2ndString:" + str);
        return str;
    }

    public final void reset() {
        a.cS("MicroMsg.Voip", "v2protocal reset!");
        this.field_punchSvrArray = null;
        this.field_relaySvrArray = null;
        this.field_relayTcpSvrArray = null;
        this.field_peerId = null;
        this.field_capInfo = null;
        this.gFG = 0;
        this.kvI = 0;
        this.kvH = 0;
        this.gFO = 0;
        this.gFH = 0;
        this.channelStrategy = 0;
        this.gFJ = 0;
        this.cLC = 0;
        this.kvJ = null;
        this.kvK = null;
        this.kvL = null;
        this.kvM = 0;
        this.kvN = null;
        this.kwB = 0;
        this.kwC = null;
        this.kwH = null;
        this.kwI = null;
        this.kwN = 0;
        this.kwO = 0;
        this.kwP = 0;
        this.kwQ = 0;
        this.kwR = 0;
        this.field_videoDuration = 0;
        this.field_audioDuration = 0;
        this.kxe = 0;
        this.kwj = 0;
        this.kwi = 0;
        this.field_engineVersionStatLength = 0;
        this.field_engineQosStatLength = 0;
        this.field_statusSyncKey = 0;
        this.field_relayDataSyncKey = 0;
        this.field_connectingStatusKey = 0;
        this.kvU = 0;
        this.kvV = 0;
        this.kvW = 0;
        this.kvX = 0;
        this.kvY = 0;
        this.kwf = -1;
        this.kwg = 0;
        this.kvE = 0;
        this.gUE = "";
        this.kwJ = 0;
        this.kwK = 0;
        this.kxf.reset();
        this.kxf.bbR();
        kvD = false;
        a.cT("MicroMsg.Voip", "freeJNIReport : " + freeJNIReport() + ". [0: null, no need to free, 1: free success!]");
    }
}
