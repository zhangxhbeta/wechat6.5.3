package com.tencent.wecall.talkroom.model;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.a.a.ae;
import com.tencent.pb.common.b.a.a.ag;
import com.tencent.pb.common.b.a.a.ah;
import com.tencent.pb.common.b.a.a.an;
import com.tencent.pb.common.b.a.a.ao;
import com.tencent.pb.common.b.a.a.ap;
import com.tencent.pb.common.b.a.a.aq;
import com.tencent.pb.common.b.a.a.ar;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.n;
import com.tencent.pb.common.b.a.a.o;
import com.tencent.pb.common.b.a.a.p;
import com.tencent.pb.common.b.a.a.v;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.a.a.y;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.c.g;
import com.tencent.pb.common.c.h;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.wecall.talkroom.a.i;
import com.tencent.wecall.talkroom.a.j;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.model.g.AnonymousClass10;
import com.tencent.wecall.talkroom.model.g.AnonymousClass13;
import com.tencent.wecall.talkroom.model.g.AnonymousClass16;
import com.tencent.wecall.talkroom.model.g.AnonymousClass18;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public final class f implements Callback, com.tencent.d.a.d, com.tencent.pb.common.b.b {
    public static List<Integer> pHY = new ArrayList();
    public static String[] pIB = new String[]{"GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other"};
    private static com.tencent.pb.talkroom.sdk.e ppx = null;
    boolean aUy = false;
    public int gLN;
    boolean gUW = false;
    public String gpg;
    boolean ktR = false;
    Handler mHandler;
    private com.tencent.d.a.a pHA;
    f pHX;
    private Map<String, e> pHZ = new HashMap();
    private boolean pIA = false;
    public String pIC = null;
    HashSet<Long> pID = new HashSet();
    public boolean pIE = false;
    public boolean pIF = true;
    public boolean pIG = true;
    private short[] pIH = null;
    private int[] pII = null;
    public boolean pIJ = false;
    public boolean pIK = true;
    private Runnable pIL = new Runnable(this) {
        final /* synthetic */ f pIO;

        {
            this.pIO = r1;
        }

        public final void run() {
            if (this.pIO.bbD() && this.pIO.gUW) {
                com.tencent.pb.common.c.c.d("TalkRoomService", "syscall", "finishtalk becos holdtimeout");
                h.zK(-2003);
                this.pIO.pIq.zN(401);
                this.pIO.O(this.pIO.gpg, 3, MMGIFException.D_GIF_ERR_DATA_TOO_BIG);
            }
        }
    };
    private com.tencent.pb.common.b.d pIM = null;
    private Runnable pIN = new Runnable(this) {
        final /* synthetic */ f pIO;

        {
            this.pIO = r1;
        }

        public final void run() {
            com.tencent.pb.common.b.d dVar = null;
            String str = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "beginSenceCircle state: ";
            objArr[1] = Integer.valueOf(this.pIO.state);
            objArr[2] = " mCircleScene: ";
            objArr[3] = this.pIO.pIM == null ? null : Integer.valueOf(this.pIO.pIM.getType());
            objArr[4] = " mIsAck: ";
            objArr[5] = Boolean.valueOf(this.pIO.pIf);
            com.tencent.pb.common.c.c.d(str, objArr);
            if (this.pIO.pIM == null) {
                this.pIO.mHandler.removeCallbacks(this.pIO.pIN);
                com.tencent.pb.common.c.c.i("TalkRoomService", "beginSenceCircle removeCallbacks");
            } else if (this.pIO.bbD()) {
                if (this.pIO.pIM != null && this.pIO.pIM.getType() == 202 && this.pIO.state == 3) {
                    com.tencent.wecall.talkroom.a.e eVar = (com.tencent.wecall.talkroom.a.e) this.pIO.pIM;
                    if (this.pIO.b(eVar.gpg, eVar.gLN, eVar.pIi, f.zH(eVar.pJX))) {
                        dVar = new com.tencent.wecall.talkroom.a.e(eVar);
                        com.tencent.pb.common.c.c.i("TalkRoomService", "beginSenceCircle enter");
                    }
                }
                if (dVar != null) {
                    com.tencent.pb.common.b.e.bLT().a(dVar);
                    this.pIO.mHandler.postDelayed(this, 3000);
                    return;
                }
                this.pIO.mHandler.removeCallbacks(this.pIO.pIN);
                com.tencent.pb.common.c.c.i("TalkRoomService", "beginSenceCircle removeCallbacks");
            } else {
                this.pIO.mHandler.removeCallbacks(this.pIO.pIN);
                com.tencent.pb.common.c.c.i("TalkRoomService", "beginSenceCircle removeCallbacks");
            }
        }
    };
    private final int pIa = 1;
    private final int pIb = 2;
    private final int pIc = 3;
    private final int pId = 4;
    public final int pIe = 6;
    private boolean pIf = false;
    private boolean pIg = false;
    public String pIh;
    public long pIi;
    private int pIj = 0;
    private int pIk = 0;
    private int pIl = 0;
    private long pIm = 0;
    private boolean pIn = true;
    private int pIo = 0;
    int pIp = -1;
    public h pIq = h.pJv;
    b pIr;
    private com.tencent.mm.plugin.multi.talk.a pIs;
    private TimerTask pIt;
    private TimerTask pIu;
    private Timer pIv = new Timer("TalkRoomService_HelloTimer");
    private TimerTask pIw;
    private Timer pIx = new Timer("TalkRoomService_talkDurationTimer");
    g pIy = new g();
    private int pIz = 0;
    int ppl;
    int state = 0;

    class a {
        String lEs;
        final /* synthetic */ f pIO;
        String[] pIX;
        at pIY;
        long pIZ;
        String pJa;
        boolean pJb;
        String pJc;
        int ppV;
        int type;

        a(f fVar) {
            this.pIO = fVar;
        }
    }

    public enum b {
        OK,
        NOT_AUTH,
        NOT_BIND,
        NOT_MATCH,
        NO_NETWORK,
        BUSY,
        NOT_VALID_STATE,
        GROUP_NOT_VALID,
        UNINIT_SERVICE_FAILED,
        INIT_ENGINE_FAILED
    }

    class c {
        int gFG;
        long gFH;
        String lEs;
        final /* synthetic */ f pIO;
        int ppV;
        int pqc;

        c(f fVar) {
            this.pIO = fVar;
        }
    }

    class d {
        int gLN;
        String gpg;
        long pIi;
    }

    class e {
        int gFG;
        long gFH;
        String lEs;
        final /* synthetic */ f pIO;

        e(f fVar) {
            this.pIO = fVar;
        }
    }

    public interface f {
    }

    static /* synthetic */ void a(f fVar, final l lVar) {
        if (fVar.pIu == null) {
            fVar.pIu = new TimerTask(fVar) {
                final /* synthetic */ f pIO;

                public final void run() {
                    if (lVar == null) {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "doHelloTimeOutTask scene is null");
                    } else if (this.pIO.b(lVar.gpg, lVar.gLN, lVar.pIi, false)) {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "doHelloTimeOutTask mGroupId: ", this.pIO.gpg, " mRoomId: ", Integer.valueOf(this.pIO.gLN), " mRoomKey: ", Long.valueOf(this.pIO.pIi));
                        this.pIO.pIq.zN(330);
                        h.zJ(-1606);
                        this.pIO.a(lVar.gpg, lVar.gLN, lVar.pIi, 117, true);
                        this.pIO.pIy.d(-600, null);
                    } else {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "doHelloTimeOutTask isCurrentRoom is false scene.mGroupId: ", lVar.gpg, " scene.mRoomId: ", Integer.valueOf(lVar.gLN), " scene.mRoomKey: ", Long.valueOf(lVar.pIi));
                    }
                }
            };
            fVar.pIv.schedule(fVar.pIu, 60000);
        }
    }

    static /* synthetic */ void a(f fVar, int[] iArr) {
        if (iArr == null) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "onMebersChangedToEngineByIds members is null");
            return;
        }
        String str = "TalkRoomService";
        Object[] objArr = new Object[2];
        objArr[0] = "engine onMebersChangedToEngineByIds members.length: ";
        objArr[1] = Integer.valueOf(iArr == null ? 0 : iArr.length);
        com.tencent.pb.common.c.c.i(str, objArr);
        if (fVar.pIr == null) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "onMebersChangedToEngine engine is null");
        } else {
            fVar.pIr.OnMembersChanged(iArr);
        }
    }

    static /* synthetic */ void e(f fVar) {
        if (fVar.pIr == null) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "the engine should not be null.");
            return;
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "initMediaComponent");
        g.s(411, 1, "1");
        fVar.auD();
        fVar.bPK();
    }

    static /* synthetic */ l j(f fVar) {
        if (TextUtils.isEmpty(fVar.gpg)) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "doHelloVoiceRoom mGroupId is null");
            return null;
        }
        com.tencent.pb.common.c.c.i("TalkRoomService", "doHelloVoiceRoom mGroupId: ", fVar.gpg, " mRoomId: ", Integer.valueOf(fVar.gLN), " mRoomKey: ", Long.valueOf(fVar.pIi), " selfMemberId: ", Integer.valueOf(c.bPu().QL(fVar.gpg)), " mCallData: ", Integer.valueOf(fVar.pIo));
        com.tencent.pb.common.b.d lVar = new l(fVar.gpg, fVar.gLN, fVar.pIi, r6, fVar.pIo);
        com.tencent.pb.common.b.e.bLT().a(lVar);
        return lVar;
    }

    static /* synthetic */ int n(f fVar) {
        int i = fVar.pIj + 1;
        fVar.pIj = i;
        return i;
    }

    static /* synthetic */ int p(f fVar) {
        int i = fVar.pIl + 1;
        fVar.pIl = i;
        return i;
    }

    static /* synthetic */ int r(f fVar) {
        int i = fVar.pIk + 1;
        fVar.pIk = i;
        return i;
    }

    public final boolean handleMessage(Message message) {
        Object obj;
        switch (message.what) {
            case 1:
                obj = message.obj;
                if (this.state != 4) {
                    if (!(obj instanceof d)) {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "handlerInviteTimeOut obj is not GroupRoomInfo");
                        break;
                    }
                    d dVar = (d) obj;
                    if (dVar.gpg != null) {
                        com.tencent.pb.common.c.c.d("TalkRoomService", "handlerInviteTimeOut");
                        if (dVar.gpg.equals(this.gpg) && dVar.gLN == this.gLN && dVar.pIi == this.pIi) {
                            h.bPP();
                            this.pIq.zN(501);
                            b(dVar.gpg, dVar.gLN, dVar.pIi, 7);
                            com.tencent.pb.common.c.c.i("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId: ", dVar.gpg);
                            break;
                        }
                    }
                    com.tencent.pb.common.c.c.i("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId is null");
                    break;
                }
                com.tencent.pb.common.c.c.i("TalkRoomService", "handlerInviteTimeOut state: ", Integer.valueOf(this.state));
                break;
            case 2:
                obj = message.obj;
                if (this.state == 1) {
                    if (!(obj instanceof a)) {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                    a aVar = (a) obj;
                    if (h.ed(aVar.lEs, this.gpg)) {
                        String str = aVar.lEs;
                        String[] strArr = aVar.pIX;
                        at atVar = aVar.pIY;
                        int i = aVar.ppV;
                        int i2 = aVar.type;
                        long j = aVar.pIZ;
                        String str2 = aVar.pJa;
                        boolean z = aVar.pJb;
                        String str3 = aVar.pJc;
                        this.pIq.bPO();
                        c bPu = c.bPu();
                        String str4 = SQLiteDatabase.KeyEmpty;
                        TalkRoom QK = bPu.QK(str);
                        if (QK != null) {
                            str4 = QK.pHI == null ? SQLiteDatabase.KeyEmpty : QK.pHI.name;
                        }
                        boolean a = com.tencent.pb.common.b.e.bLT().a(new com.tencent.wecall.talkroom.a.d(str, strArr, this.pIr.bPs(), str4, atVar, i, i2, j, str2, z, str3));
                        this.pIq.J("create", "req", String.valueOf(a), String.valueOf(this.state));
                        com.tencent.pb.common.c.c.i("TalkRoomService", "sendCreateSence groupId: ", str, " routeId:", Integer.valueOf(i), " type: ", Integer.valueOf(i2), " playId: ", Long.valueOf(j), " name: ", str4, " ret: ", Boolean.valueOf(a));
                        break;
                    }
                }
                com.tencent.pb.common.c.c.i("TalkRoomService", "handlerCreateGroup state: ", Integer.valueOf(this.state));
                break;
                break;
            case 3:
                obj = message.obj;
                if (this.state == 3) {
                    if (!(obj instanceof c)) {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                    c cVar = (c) obj;
                    if (b(cVar.lEs, cVar.gFG, cVar.gFH, false)) {
                        a(cVar.lEs, cVar.gFG, cVar.gFH, cVar.ppV, cVar.pqc);
                        break;
                    }
                }
                com.tencent.pb.common.c.c.i("TalkRoomService", "handlerEnterGroup state: ", Integer.valueOf(this.state));
                break;
                break;
            case 4:
                g.bMn();
                break;
        }
        return true;
    }

    public f() {
        com.tencent.pb.common.b.e.bLT().a(201, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(202, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(203, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(204, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(205, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(206, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(207, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(208, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(210, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(209, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(211, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(212, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(213, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.bLT().a(214, (com.tencent.pb.common.b.b) this);
        c bPu = c.bPu();
        g gVar = this.pIy;
        try {
            new Throwable("trace caller").getStackTrace();
        } catch (Exception e) {
            com.tencent.pb.common.c.c.d("TalkRoomManager", "setTalkServerCallback caller stack: ", r2);
        }
        bPu.pHP = gVar;
        HandlerThread handlerThread = new HandlerThread("TalkRoomService");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        if (this.pHA == null) {
            this.pHA = (com.tencent.d.a.a) com.tencent.d.f.QG("EventCenter");
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "syscall", "register", Boolean.valueOf(true));
        this.pHA.a(this, pIB);
    }

    final boolean bPD() {
        com.tencent.pb.common.c.c.d("TalkRoomService", "initService");
        com.tencent.pb.talkroom.sdk.e eVar = ppx;
        if (eVar != null) {
            eVar.aBS();
        }
        this.pIr = new b();
        this.pIC = this.gpg;
        this.pIs = new com.tencent.mm.plugin.multi.talk.a(this) {
            final /* synthetic */ f pIO;

            {
                this.pIO = r1;
            }

            public final void keep_OnOpenSuccess() {
                int[] iArr = null;
                this.pIO.pIq.gHc = 1;
                com.tencent.pb.common.c.c.d("TalkRoomService", "engine OnOpenSuccess");
                if (this.pIO.state != 4) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "has exit the talkroom state:%d", Integer.valueOf(this.pIO.state));
                    return;
                }
                f fVar = this.pIO;
                c bPu = c.bPu();
                Object b = this.pIO.gpg;
                if (!TextUtils.isEmpty(b)) {
                    TalkRoom QK = bPu.QK(b);
                    if (QK != null) {
                        List bPo = QK.bPo();
                        if (bPo != null) {
                            int[] iArr2 = new int[bPo.size()];
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i = 0; i < bPo.size(); i++) {
                                d dVar = (d) bPo.get(i);
                                if (dVar != null) {
                                    iArr2[i] = dVar.bPx();
                                    stringBuffer.append(iArr2[i]);
                                    stringBuffer.append(",");
                                }
                            }
                            com.tencent.pb.common.c.c.i("TalkRoomManager", "getAllMemberIds memberIds: ", stringBuffer.toString());
                            iArr = iArr2;
                        }
                    }
                }
                f.a(fVar, iArr);
                if (this.pIO.pIr != null) {
                    b c = this.pIO.pIr;
                    boolean qZ = f.qZ();
                    if (com.tencent.pb.common.a.a.poK) {
                        if (qZ) {
                            c.pHK.nl(401);
                        } else {
                            c.pHK.nl(402);
                        }
                    }
                }
                this.pIO.pIg = true;
                this.pIO.pIr;
                com.tencent.pb.talkroom.sdk.e bPL = f.bPL();
                if (bPL != null) {
                    bPL.aBT();
                }
                talk com_tencent_mm_plugin_multi_talk = this.pIO.pIr.pHK;
                if (com.tencent.pb.common.a.a.poK) {
                    AtomicInteger atomicInteger = new AtomicInteger();
                    AtomicInteger atomicInteger2 = new AtomicInteger();
                    try {
                        com_tencent_mm_plugin_multi_talk.getSampleRate(atomicInteger, atomicInteger2);
                    } catch (Throwable th) {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "keep_OnOpenSuccess:  ", th);
                        return;
                    }
                    int i2 = atomicInteger.get();
                    int i3 = atomicInteger2.get();
                    talk.hyT = i2;
                    talk.hyU = i3;
                    com.tencent.pb.common.c.c.i("VoipAdapterUtil", "adapterInitv2engineSampleRate getSampleRate:", Integer.valueOf(talk.hyT), Integer.valueOf(talk.hyU));
                }
                try {
                    f.e(this.pIO);
                } catch (Throwable th2) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "keep_OnOpenSuccess initMediaComponent:  ", th2);
                }
                h hVar = this.pIO.pIq;
                if (hVar.pJK == 0) {
                    hVar.pJz = 0;
                } else {
                    hVar.pJz = System.currentTimeMillis() - hVar.pJK;
                }
                com.tencent.pb.common.c.c.d(h.TAG, "endFirstSendPcm", Long.valueOf(hVar.pJz), Long.valueOf(hVar.pJK));
                g f = this.pIO.pIy;
                Runnable anonymousClass19 = new Runnable(f) {
                    final /* synthetic */ g pJp;

                    {
                        this.pJp = r1;
                    }

                    public final void run() {
                        synchronized (this.pJp.bXt) {
                            for (a awP : this.pJp.bXt) {
                                awP.awP();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass19.run();
                } else {
                    f.handler.post(anonymousClass19);
                }
            }

            public final void keep_OnError(int i) {
                int i2 = 207;
                int i3 = -3007;
                int i4 = MMGIFException.D_GIF_ERR_NOT_GIF_FILE;
                switch (i) {
                    case -4:
                        i2 = 206;
                        i3 = -3006;
                        i4 = 115;
                        break;
                    case -3:
                        i2 = 205;
                        i3 = -3005;
                        i4 = 114;
                        break;
                    case -2:
                        i2 = 204;
                        i3 = -3004;
                        i4 = MMGIFException.D_GIF_ERR_EOF_TOO_SOON;
                        break;
                    case -1:
                        i2 = 203;
                        i3 = -3003;
                        i4 = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                        break;
                }
                h.zM(i3);
                this.pIO.pIq.zN(i2);
                com.tencent.pb.common.c.c.d("TalkRoomService", "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(i));
                this.pIO.a(this.pIO.gpg, this.pIO.gLN, this.pIO.pIi, i4, true);
                this.pIO.pIy.d(-400, null);
            }

            public final void keep_OnNotify(int i) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "keep_OnNotify eventCode: ", Integer.valueOf(i));
                if (i == 5) {
                    this.pIO.pIq.pJx = 1;
                    h hVar = this.pIO.pIq;
                    if (hVar.pJK == 0) {
                        hVar.pJy = 0;
                    } else {
                        hVar.pJy = System.currentTimeMillis() - hVar.pJK;
                    }
                    com.tencent.pb.common.c.c.d(h.TAG, "endRecvFirstPcm", Long.valueOf(hVar.pJK), Long.valueOf(hVar.pJy));
                    this.pIO.pIo = 1;
                    f.j(this.pIO);
                }
            }

            public final void keep_OnReportEngineRecv(String str, int i) {
                com.tencent.pb.common.c.c.d("TalkRoomService", "keep_OnReportEngineRecv:", Integer.valueOf(i), str);
                StringBuilder stringBuilder = new StringBuilder(h.Qe(this.pIO.pIC));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.QT(stringBuilder.toString());
            }

            public final void keep_OnReportEngineSend(String str) {
                com.tencent.pb.common.c.c.d("TalkRoomService", "keep_OnReportEngineSend:", str);
                StringBuilder stringBuilder = new StringBuilder(h.Qe(this.pIO.pIC));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.QU(stringBuilder.toString());
            }

            public final void keep_OnReportChannel(String str) {
                com.tencent.pb.common.c.c.d("TalkRoomService", "keep_OnReportChannel:", str);
                StringBuilder stringBuilder = new StringBuilder(h.Qe(this.pIO.pIC));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.QV(stringBuilder.toString());
            }
        };
        return true;
    }

    public final void kF(boolean z) {
        int uninitLive;
        String bPM;
        this.pIq.lEs = this.gpg;
        this.pIq.ppQ = this.pIh;
        if (h.ty(this.pIq.lEs)) {
            this.pIq.lEs = SQLiteDatabase.KeyEmpty;
        }
        if (h.ty(this.pIq.ppQ)) {
            this.pIq.ppQ = SQLiteDatabase.KeyEmpty;
        }
        this.pIq.kvR = 1;
        this.pIq.gFG = this.gLN;
        this.pIq.gFH = this.pIi;
        com.tencent.pb.common.c.c.d("TalkRoomService", "uninitService isUpload: ", Boolean.valueOf(z));
        com.tencent.pb.common.c.c.d("TalkRoomService", "releaseConpent");
        try {
            pb();
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "releaseConpent ", th);
        }
        try {
            bPF();
        } catch (Throwable th2) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "releaseConpent ", th2);
        }
        this.pHZ.remove(this.gpg);
        this.pIz = 0;
        this.aUy = false;
        setState(0);
        this.pIg = false;
        a(this.pIh, 0, 0, null);
        this.pIh = null;
        this.ppl = 0;
        this.pIj = 0;
        this.pIk = 0;
        this.pIl = 0;
        this.pIn = true;
        this.pIF = true;
        this.pIm = 0;
        this.pIo = 0;
        this.pIf = false;
        this.pIJ = false;
        this.pIK = true;
        bPE();
        this.mHandler.removeMessages(1);
        if (this.pIr != null) {
            b bVar = this.pIr;
            if (com.tencent.pb.common.a.a.poK) {
                bVar.pHK.field_capInfo = null;
            }
        }
        bPJ();
        bPI();
        try {
            com.tencent.pb.common.c.c.i("TalkRoomService", "cancelTalkDurationTimerTask");
            if (this.pIw != null) {
                this.pIw.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "cancelTalkDurationTimerTask: ", e);
        }
        this.pIw = null;
        this.mHandler.removeCallbacks(this.pIN);
        this.pIM = null;
        this.gUW = false;
        this.pIE = false;
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        if (this.pIr != null) {
            try {
                this.pIz = this.pIr.bPt();
                i = this.pIr.Close();
            } catch (Throwable th3) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "uninitService", th3);
            }
            com.tencent.pb.common.c.c.i("TalkRoomService", "uninitService mid", Integer.valueOf(i));
        }
        if (this.pIr != null) {
            try {
                uninitLive = this.pIr.uninitLive();
            } catch (Exception e2) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "uninitService 2", e2);
            }
            this.pIr = null;
            if (z) {
                bPM = this.pIq.bPM();
                if (!(TextUtils.isEmpty(this.pIq.lEs) && TextUtils.isEmpty(this.pIq.ppQ))) {
                    h.QS(bPM);
                    this.mHandler.removeMessages(4);
                    this.mHandler.sendEmptyMessageDelayed(4, 0);
                }
                bPG();
                try {
                    ((AudioManager) com.tencent.pb.common.c.d.kzS.getSystemService("audio")).setMode(0);
                    com.tencent.pb.common.c.c.i("TalkRoomService", "resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn()));
                } catch (Throwable th22) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "resumeAudioConfig ", th22);
                }
            }
            com.tencent.pb.common.c.c.d("TalkRoomService", "uninitService end error", Integer.valueOf(uninitLive));
        }
        uninitLive = i;
        this.pIr = null;
        if (z) {
            bPM = this.pIq.bPM();
            h.QS(bPM);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0);
            bPG();
            ((AudioManager) com.tencent.pb.common.c.d.kzS.getSystemService("audio")).setMode(0);
            com.tencent.pb.common.c.c.i("TalkRoomService", "resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn()));
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "uninitService end error", Integer.valueOf(uninitLive));
    }

    public final void bPE() {
        try {
            com.tencent.pb.common.c.c.i("TalkRoomService", "stopHoldeOnPusher ");
            if (this.pIL != null) {
                this.mHandler.removeCallbacks(this.pIL);
            }
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.i("TalkRoomService", " stopTimer: ", th);
        }
    }

    final void setState(int i) {
        com.tencent.pb.common.c.c.i("TalkRoomService", "setState newState: ", Integer.valueOf(i));
        if (this.state != i) {
            this.state = i;
            g gVar = this.pIy;
            Runnable anonymousClass7 = new com.tencent.wecall.talkroom.model.g.AnonymousClass7(gVar, i);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass7.run();
            } else {
                gVar.handler.post(anonymousClass7);
            }
        }
    }

    static String[] cM(List<String> list) {
        if (list == null || list.size() <= 0) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        int i = 0;
        for (String str : list) {
            int i2 = i + 1;
            strArr[i] = str;
            i = i2;
        }
        return strArr;
    }

    public final b a(Activity activity, String str, int i, long j, int i2, int i3) {
        com.tencent.pb.common.c.c.i("TalkRoomService", "enterTalkRoom", str, Integer.valueOf(this.gLN), Integer.valueOf(i), Long.valueOf(this.pIi), Long.valueOf(j), Integer.valueOf(i3), "needConfirm", Boolean.valueOf(false));
        if (com.tencent.pb.b.a.a.bMp()) {
            com.tencent.pb.common.b.h.isNetworkConnected();
            if (zH(i3) && i3 != 100 && bbD()) {
                h.a(str, SQLiteDatabase.KeyEmpty, this.gLN, this.pIi, "enter", "req", "false", String.valueOf(i3), "isBusy");
                com.tencent.pb.common.c.c.i("TalkRoomService", "enterTalkRoom isBusy");
                return b.BUSY;
            }
            boolean QR = i3 == 100 ? true : zH(i3) ? this.state == 0 : i3 == 1 ? QR(str) : false;
            if (!QR) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(i3), " state: ", Integer.valueOf(this.state));
                h.a(str, SQLiteDatabase.KeyEmpty, this.gLN, this.pIi, "enter", "req", "false", String.valueOf(i3), "isNotValidEnterState");
                return b.NOT_VALID_STATE;
            } else if (TextUtils.isEmpty(str)) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "exitTalkRoom enterTalkRoom groupId is null");
                h.a(str, SQLiteDatabase.KeyEmpty, this.gLN, this.pIi, "enter", "req", "false", String.valueOf(i3), "groupIdnull");
                return b.GROUP_NOT_VALID;
            } else {
                if (zH(i3)) {
                    bPG();
                    kF(false);
                }
                bPD();
                if (bam()) {
                    this.gpg = str;
                    if (zH(i3)) {
                        this.gLN = i;
                        this.pIi = j;
                    } else {
                        e QQ = QQ(str);
                        this.gLN = QQ == null ? 0 : QQ.gFG;
                        this.pIi = QQ == null ? 0 : QQ.gFH;
                    }
                    this.pIC = str;
                    this.ppl = i2;
                    setState(3);
                    this.ktR = zH(i3);
                    if (this.ktR) {
                        this.pIq.bPN();
                    }
                    if (!this.ktR || c.bPu().aT(this.gpg, true)) {
                        a(str, this.gLN, this.pIi, i2, i3);
                    } else {
                        c cVar = new c(this);
                        cVar.lEs = str;
                        cVar.gFG = this.gLN;
                        cVar.gFH = this.pIi;
                        cVar.pqc = i3;
                        cVar.ppV = i2;
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = cVar;
                        this.mHandler.sendMessageDelayed(obtain, 0);
                    }
                    return b.OK;
                }
                com.tencent.pb.common.c.c.i("TalkRoomService", "exitTalkRoom enterTalkRoom initEngine fail");
                if (zH(i3)) {
                    h.a(str, SQLiteDatabase.KeyEmpty, this.gLN, this.pIi, "enter", "req", "false", "initEnginefail");
                    kF(false);
                } else {
                    this.pIq.J("enter", "req", "false", "initEnginefail");
                }
                return b.INIT_ENGINE_FAILED;
            }
        }
        com.tencent.pb.common.c.c.i("TalkRoomService", "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.b.a.a.bMp()), " isBindMobile: ", Boolean.valueOf(true));
        h.a(str, SQLiteDatabase.KeyEmpty, this.gLN, this.pIi, "enter", "req", "false", String.valueOf(i3), "noAuth");
        return b.NOT_AUTH;
    }

    private void a(String str, int i, long j, int i2, int i3) {
        com.tencent.pb.common.c.c.i("TalkRoomService", "sendEnterGroupScence groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " enterType: ", Integer.valueOf(i3), " isSenceCircle: ", Boolean.valueOf(true));
        if (!zH(i3)) {
            h hVar = this.pIq;
            com.tencent.pb.common.c.c.d(h.TAG, "endAnswerTime", Long.valueOf(hVar.pJL));
            if (hVar.pJL == 0) {
                hVar.gHb = 0;
            } else {
                hVar.gHb = System.currentTimeMillis() - hVar.pJL;
            }
        }
        this.pIq.bPO();
        com.tencent.pb.common.b.d eVar = new com.tencent.wecall.talkroom.a.e(str, i, j, this.pIr.bPs(), i2, i3);
        com.tencent.pb.common.b.e.bLT().a(eVar);
        this.mHandler.removeCallbacks(this.pIN);
        this.pIM = eVar;
        this.mHandler.postDelayed(this.pIN, 3000);
    }

    public final boolean b(String str, int i, long j, int i2) {
        com.tencent.pb.common.c.c.i("TalkRoomService", "rejectTalkRoom groupId: ", str, " mGroupId: ", this.gpg, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " reason: ", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!(3 != (1 == i2 ? 1 : 3) || i2 == 7 || this.pIm == 0)) {
            System.currentTimeMillis();
        }
        boolean a = com.tencent.pb.common.b.e.bLT().a(new i(str, i, j, i2));
        if (b(str, i, j, false)) {
            this.pIq.J("reject", "req", String.valueOf(a), String.valueOf(this.state));
        } else {
            h.a(str, i, j, "reject", "req", String.valueOf(a), String.valueOf(this.state));
        }
        a(str, i, j, false);
        com.tencent.pb.common.c.c.i("TalkRoomService", "rejectTalkRoom ret: ", Boolean.valueOf(a));
        return a;
    }

    private boolean cu(String str, int i) {
        com.tencent.pb.common.c.c.i("TalkRoomService", "cancelCreateTalkRoom clientGroupId: ", str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.bLT().a(new com.tencent.wecall.talkroom.a.c(str, i, this.ppl));
        this.pIq.J("cancel", "req", String.valueOf(a), String.valueOf(this.state));
        a(str, this.gLN, this.pIi, true);
        com.tencent.pb.common.c.c.i("TalkRoomService", "cancelCreateTalkRoom ret: ", Boolean.valueOf(a));
        return a;
    }

    public final boolean a(String str, int i, long j, int i2, boolean z) {
        com.tencent.pb.common.c.c.i("TalkRoomService", "exitTalkRoom", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "exitTalkRoom: has exited");
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.bLT().a(new com.tencent.wecall.talkroom.a.f(str, i, j, i2));
        this.pIq.J("exit", "req", String.valueOf(a), String.valueOf(this.state));
        a(str, i, j, z);
        com.tencent.pb.common.c.c.i("TalkRoomService", "exitTalkRoom ret: ", Boolean.valueOf(a));
        return a;
    }

    private static boolean bPF() {
        boolean aBU;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = ppx;
            if (eVar != null) {
                aBU = eVar.aBU();
                com.tencent.pb.common.c.c.d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(aBU));
                return aBU;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "stopPlayer: ", e);
        }
        aBU = false;
        com.tencent.pb.common.c.c.d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(aBU));
        return aBU;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.b bVar) {
        int i3 = -100;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = ppx;
            if (eVar != null) {
                i3 = eVar.a(i, i2, bVar);
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "startPlayer: ", Integer.valueOf(i), Integer.valueOf(i2), e);
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        return i3;
    }

    private static boolean pb() {
        boolean aBV;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = ppx;
            if (eVar != null) {
                aBV = eVar.aBV();
                com.tencent.pb.common.c.c.d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(aBV));
                return aBV;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "stopRecord: ", e);
        }
        aBV = false;
        com.tencent.pb.common.c.c.d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(aBV));
        return aBV;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
        int i3 = -100;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = ppx;
            if (eVar != null) {
                i3 = eVar.a(i, i2, cVar);
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "startRecord: ", e);
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "startRecord samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        return i3;
    }

    public final void a(int i, int i2, String str, com.tencent.pb.common.b.d dVar) {
        Map u;
        String str2 = "TalkRoomService";
        Object[] objArr = new Object[6];
        objArr[0] = "CLTNOT onNetSceneEnd errCode:";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = " errType: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " scene.getType(): ";
        objArr[5] = dVar != null ? Integer.valueOf(dVar.getType()) : SQLiteDatabase.KeyEmpty;
        com.tencent.pb.common.c.c.d(str2, objArr);
        if (i == 1 || i == 2) {
            u = com.tencent.pb.common.c.b.u(Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(-1205), Integer.valueOf(204), Integer.valueOf(-1304), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(206), Integer.valueOf(-1522), Integer.valueOf(208), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542));
            int type = dVar.getType();
            if (u.containsKey(Integer.valueOf(type))) {
                h.zJ(((Integer) u.get(Integer.valueOf(type))).intValue());
            }
        }
        k kVar;
        if (i2 == -1) {
            try {
                if (dVar.getType() == 201) {
                    com.tencent.wecall.talkroom.a.d dVar2 = (com.tencent.wecall.talkroom.a.d) dVar;
                    if (h.ed(this.pIh, dVar2.pIh)) {
                        this.pIq.zN(301);
                        this.pIq.J("create", "resp", "-1", String.valueOf(this.state));
                        cu(dVar2.pIh, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                        if (!dVar2.pJW) {
                            this.pHA.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                        this.pIy.d(-100, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 209) {
                    this.pIy.ct(((com.tencent.wecall.talkroom.a.g) dVar).gpg, i2);
                    return;
                } else if (dVar.getType() == 206) {
                    com.tencent.wecall.talkroom.a.a aVar = (com.tencent.wecall.talkroom.a.a) dVar;
                    if (!b(aVar.gpg, aVar.gLN, aVar.pIi, false)) {
                        h.a(aVar.gpg, aVar.gLN, aVar.pIi, "ack", "resp", "-1", String.valueOf(this.state));
                    }
                    this.pIy.a(aVar.pJV, c.bPu().QP(aVar.gpg));
                    return;
                } else if (dVar.getType() == 204) {
                    com.tencent.wecall.talkroom.a.b bVar = (com.tencent.wecall.talkroom.a.b) dVar;
                    if (b(bVar.gpg, bVar.gLN, bVar.pIi, false)) {
                        this.pIq.J("add", "resp", "-1", String.valueOf(this.state));
                        this.pIy.d(-300, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 202) {
                    com.tencent.wecall.talkroom.a.e eVar = (com.tencent.wecall.talkroom.a.e) dVar;
                    if (b(eVar.gpg, eVar.gLN, eVar.pIi, zH(eVar.pJX)) && this.state == 3) {
                        this.pIq.zN(302);
                        this.pIy.d(-200, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 212) {
                    this.pIy.cL(null);
                    return;
                } else if (dVar.getType() == 213) {
                    if (h.equals(((j) dVar).gpg, this.gpg)) {
                        this.pIq.J("sendmsg", "resp", "-1", String.valueOf(this.state));
                        this.pIy.d(-700, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 211) {
                    com.tencent.wecall.talkroom.a.h hVar = (com.tencent.wecall.talkroom.a.h) dVar;
                    if (b(hVar.lEs, hVar.gFG, hVar.gFH, false)) {
                        this.pIq.J("redirect", "resp", "-1", String.valueOf(this.state));
                        return;
                    }
                    return;
                } else if (dVar.getType() == 214) {
                    kVar = (k) dVar;
                    if (b(kVar.gpg, kVar.gLN, kVar.pIi, false)) {
                        this.pIy.d(-800, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } catch (Exception e) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "cancelCreateTalkRoom: ", e);
                return;
            }
        }
        Map u2;
        g gVar;
        Runnable anonymousClass4;
        int i3;
        if (dVar.getType() == 201) {
            Object obj;
            com.tencent.wecall.talkroom.a.d dVar3 = (com.tencent.wecall.talkroom.a.d) dVar;
            x xVar = (x) dVar3.ppi;
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(i2), Integer.valueOf(dVar3.mType), dVar3.pIh);
            if (dVar3.pJW) {
                obj = null;
            } else {
                obj = 1;
            }
            u2 = com.tencent.pb.common.c.b.u(Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009));
            if (u2.containsKey(Integer.valueOf(i2))) {
                h.zJ(((Integer) u2.get(Integer.valueOf(i2))).intValue());
            }
            if (i2 != 14002) {
                pHY = null;
                if (i2 != 0) {
                    if (h.ed(this.pIh, dVar3.pIh)) {
                        if (i2 != -1) {
                            this.pIq.zN(321);
                            this.pIq.J("create", "resp", String.valueOf(i2), String.valueOf(this.state));
                        }
                        if (this.state != 1) {
                            com.tencent.pb.common.c.c.i("TalkRoomService", "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(i2), dVar3.pIh);
                            if (obj != null) {
                                this.pHA.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        } else {
                            a(this.gpg, this.gLN, this.pIi, true);
                            if (i2 == 14051) {
                                this.pIy.d(-900, null);
                            } else if (i2 == 14052) {
                                this.pIy.d(-1100, null);
                            } else if (i2 == 14053) {
                                this.pIy.d(-1300, null);
                            } else if (i2 == 14504) {
                                this.pIy.d(-1400, null);
                            } else {
                                this.pIy.d(-100, null);
                            }
                            if (obj != null) {
                                this.pHA.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        }
                    } else {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.pIh, " createScene.mClientGroupId: ", dVar3.pIh, " errCode: ", Integer.valueOf(i2));
                        if (obj != null) {
                            this.pHA.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                    }
                } else if (h.ed(this.pIh, xVar.ppQ)) {
                    this.pIq.J("create", "resp", String.valueOf(i2), String.valueOf(this.state));
                    if (this.state != 1) {
                        h.zJ(-1003);
                        com.tencent.pb.common.c.c.i("TalkRoomService", "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), xVar.ppQ, Integer.valueOf(xVar.kty), Long.valueOf(xVar.ktz));
                        if (obj != null) {
                            this.pHA.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                    } else if (xVar.prf == null || xVar.prf.length == 0) {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(i2), xVar.ppQ, Integer.valueOf(xVar.kty), Long.valueOf(xVar.ktz));
                        h.zJ(-1605);
                        this.pIq.kDx = 329;
                        a(xVar.lEs, xVar.kty, xVar.ktz, 116, true);
                        if (obj != null) {
                            this.pHA.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                        this.pIy.d(-100, null);
                    } else {
                        a(xVar.ppQ, xVar.kty, xVar.ktz, xVar.lEs);
                        this.pIC = xVar.lEs;
                        this.ppl = xVar.ppV;
                        setState(4);
                        a(xVar.prf);
                        a(xVar.lEs, xVar.ppQ, xVar.ppV, xVar.kty, xVar.ktz, xVar.pqt, xVar.prg, xVar.ppS, false, true);
                        if (this.pIy != null) {
                            gVar = this.pIy;
                            anonymousClass4 = new com.tencent.wecall.talkroom.model.g.AnonymousClass4(gVar, c.bPu().QP(xVar.lEs));
                            if (Looper.myLooper() == Looper.getMainLooper()) {
                                anonymousClass4.run();
                            } else {
                                gVar.handler.post(anonymousClass4);
                            }
                        }
                        byte[] bArr = new byte[xVar.pri.length];
                        for (i3 = 0; i3 < xVar.pri.length; i3++) {
                            bArr[i3] = (byte) xVar.pri[i3];
                        }
                        a(0, xVar.pqt, xVar.pqu, bArr, (xVar.prh & 2) != 0, xVar.lEs, xVar.kty, xVar.ktz);
                        bPH();
                        e(xVar.lEs, xVar.kty, xVar.ktz);
                        if (obj != null) {
                            u = new HashMap();
                            u.put("result", Boolean.valueOf(true));
                            u.put("shareUrl", new String(xVar.ppS.prK, Charset.forName("utf-8")));
                            u.put("smsShortUrl", new String(xVar.ppS.prL, Charset.forName("utf-8")));
                            u.put("groupId", xVar.lEs);
                            this.pHA.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, u);
                        }
                        com.tencent.pb.common.c.c.i("TalkRoomService", "handleCreateVoiceGroupEnd", this.gpg, Integer.valueOf(this.gLN), Long.valueOf(this.pIi));
                    }
                } else {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.pIh, " resp.clientGroupId: ", xVar.ppQ, Integer.valueOf(xVar.kty), Long.valueOf(xVar.ktz));
                    a(xVar.lEs, xVar.kty, xVar.ktz, (int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, false);
                    if (obj != null) {
                        this.pHA.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                    }
                }
            }
        }
        if (dVar.getType() == 202) {
            com.tencent.wecall.talkroom.a.e eVar2 = (com.tencent.wecall.talkroom.a.e) dVar;
            a(i2, (y) eVar2.ppi, eVar2);
        }
        if (dVar.getType() == 204) {
            com.tencent.wecall.talkroom.a.b bVar2 = (com.tencent.wecall.talkroom.a.b) dVar;
            v vVar = (v) bVar2.ppi;
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleAddVoiceGroupMemberEnd", this.gpg, Integer.valueOf(this.gLN), Long.valueOf(this.pIi), " errCode: ", Integer.valueOf(i2));
            u2 = com.tencent.pb.common.c.b.u(Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303));
            if (u2.containsKey(Integer.valueOf(i2))) {
                h.zJ(((Integer) u2.get(Integer.valueOf(i2))).intValue());
            }
            if (i2 == 0) {
                str2 = "TalkRoomService";
                objArr = new Object[2];
                objArr[0] = "handleAddVoiceGroupMemberEnd  resp.members length: ";
                objArr[1] = Integer.valueOf(vVar.pre == null ? 0 : vVar.pre.length);
                com.tencent.pb.common.c.c.i(str2, objArr);
                if (b(vVar.lEs, vVar.kty, vVar.ktz, false)) {
                    this.pIq.J("add", "resp", String.valueOf(i2), String.valueOf(this.state));
                } else {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", vVar.lEs, this.gpg, " resp.roomid: ", Integer.valueOf(vVar.kty), Integer.valueOf(this.gLN));
                    h.zJ(-1308);
                }
                a(vVar.lEs, null, this.ppl, vVar.kty, vVar.ktz, vVar.pre, null, vVar.ppS, true, true);
            } else if (b(bVar2.gpg, bVar2.gLN, bVar2.pIi, false)) {
                this.pIq.J("add", "resp", String.valueOf(i2), String.valueOf(this.state));
                this.pIy.d(-300, null);
            }
        }
        if (dVar.getType() == 203) {
            z zVar = (z) ((com.tencent.wecall.talkroom.a.f) dVar).ppi;
            com.tencent.pb.common.c.c.d("TalkRoomService", "handleExitVoiceRoomEnd", zVar.lEs, this.gpg, Integer.valueOf(this.gLN), Long.valueOf(this.pIi), " errCode: ", Integer.valueOf(i2));
            u = com.tencent.pb.common.c.b.u(Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204));
            if (u.containsKey(Integer.valueOf(i2))) {
                h.zJ(((Integer) u.get(Integer.valueOf(i2))).intValue());
            }
            if (i2 != 0) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(i2));
            }
        }
        if (dVar.getType() == 205) {
            ah ahVar = (ah) ((l) dVar).ppi;
            com.tencent.pb.common.c.c.d("TalkRoomService", "handleHelloEnd", ahVar.lEs, this.gpg, Integer.valueOf(this.gLN), Long.valueOf(this.pIi), Integer.valueOf(i2), Integer.valueOf(i));
            bPI();
            i3 = 0;
            if (i2 == 14800) {
                i3 = -1401;
            } else if (i2 == 14801) {
                i3 = -1402;
            }
            if (i3 != 0) {
                this.pIq.zN(324);
                h.zJ(i3);
            }
        }
        if (dVar.getType() == 206) {
            com.tencent.wecall.talkroom.a.a aVar2 = (com.tencent.wecall.talkroom.a.a) dVar;
            com.tencent.pb.common.c.c.i("TalkRoomService", "CLTNOT handleAckEnd errCode is ", Integer.valueOf(i2), " groupId: ", aVar2.gpg, " roomid: ", Integer.valueOf(aVar2.gLN), " roomKey: ", Long.valueOf(aVar2.pIi));
            MultiTalkGroup QP;
            if (i2 == 18950) {
                if (!b(aVar2.gpg, aVar2.gLN, aVar2.pIi, false)) {
                    h.a(aVar2.gpg, aVar2.gLN, aVar2.pIi, "ack", "resp", String.valueOf(i2), String.valueOf(this.state));
                }
                QP = c.bPu().QP(aVar2.gpg);
                com.tencent.pb.common.c.c.i("TalkRoomService", "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", aVar2.gpg, " multiTalkGroup: ", QP);
                if (QP != null) {
                    this.pIy.a(aVar2.pJV, QP);
                }
            } else {
                if (i2 == 0) {
                    this.pIf = true;
                }
                if (!bbD()) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "CLTNOT handleAckEnd is working groupId: ", aVar2.gpg);
                    bPG();
                    kF(false);
                    this.pIq.J("ack", "resp", String.valueOf(i2), String.valueOf(this.state));
                    this.ktR = false;
                    this.gpg = aVar2.gpg;
                    this.pIC = this.gpg;
                    this.gLN = aVar2.gLN;
                    this.pIi = aVar2.pIi;
                    this.ppl = aVar2.ppl;
                    setState(2);
                    this.pIm = System.currentTimeMillis();
                    h hVar2 = this.pIq;
                    com.tencent.pb.common.c.c.d(h.TAG, "beginNotifyTime");
                    hVar2.pJL = System.currentTimeMillis();
                    if (i2 == 18900) {
                        h.zJ(-1521);
                    }
                } else if (h.equals(aVar2.gpg, this.gpg)) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "CLTNOT handleAckEnd groupid same return ", this.gpg);
                }
                e eVar3 = new e(this);
                eVar3.lEs = aVar2.gpg;
                eVar3.gFG = aVar2.gLN;
                eVar3.gFH = aVar2.pIi;
                this.pHZ.put(aVar2.gpg, eVar3);
                QP = c.bPu().QP(aVar2.gpg);
                com.tencent.pb.common.c.c.i("TalkRoomService", "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", aVar2.gpg, " multiTalkGroup: ", QP);
                if (QP != null) {
                    gVar = this.pIy;
                    anonymousClass4 = new AnonymousClass16(gVar, QP);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        anonymousClass4.run();
                    } else {
                        gVar.handler.post(anonymousClass4);
                    }
                } else {
                    a(aVar2.gpg, aVar2.gLN, aVar2.pIi, false, false, false);
                }
            }
        }
        if (dVar.getType() == 207) {
            if (i2 == 18100) {
                h.zJ(-1501);
            }
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleRejectEnd  errCode is ", Integer.valueOf(i2));
        }
        if (dVar.getType() == 208) {
            if (i2 == 18300) {
                h.zJ(-1531);
            }
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleCancelCreateEnd errCode is ", Integer.valueOf(i2));
        }
        if (dVar.getType() == 209) {
            com.tencent.wecall.talkroom.a.g gVar2 = (com.tencent.wecall.talkroom.a.g) dVar;
            aa aaVar = (aa) gVar2.ppi;
            if (i2 == 17900) {
                h.zJ(-1511);
            }
            if (i2 != 0) {
                this.pIy.ct(gVar2.gpg, i2);
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(i2));
            } else {
                TalkRoom QK = c.bPu().QK(aaVar.lEs);
                if (QK != null) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd");
                    a(aaVar.lEs, null, QK.bPl(), TalkRoom.bPm(), TalkRoom.bcC(), null, null, aaVar.ppS, true, false);
                } else {
                    a(aaVar.lEs, null, 0, 0, 0, null, null, aaVar.ppS, true, false);
                }
                this.pIy.ct(aaVar.lEs, 0);
            }
        }
        if (dVar.getType() == 210) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "talkHoldonResp", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 == 19100) {
                h.zJ(-1541);
            }
        }
        if (dVar.getType() == 211) {
            a(i, i2, dVar.ppi, (com.tencent.wecall.talkroom.a.h) dVar);
        }
        if (dVar.getType() == 212) {
            a(i2, (ae) dVar.ppi);
        }
        if (dVar.getType() == 213) {
            j jVar = (j) dVar;
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleSendMsg errCode: ", Integer.valueOf(i2));
            if (i2 != 0) {
                if (h.equals(jVar.gpg, this.gpg)) {
                    this.pIq.J("sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state));
                    this.pIy.d(-700, null);
                }
            } else if (h.equals(jVar.gpg, this.gpg)) {
                this.pIq.J("sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state));
                gVar = this.pIy;
                Runnable anonymousClass14 = new Runnable(gVar) {
                    final /* synthetic */ g pJp;

                    {
                        this.pJp = r1;
                    }

                    public final void run() {
                        synchronized (this.pJp.bXt) {
                            for (a bPC : this.pJp.bXt) {
                                bPC.bPC();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass14.run();
                } else {
                    gVar.handler.post(anonymousClass14);
                }
            }
        }
        if (dVar.getType() == 214) {
            ac acVar = (ac) dVar.ppi;
            kVar = (k) dVar;
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleSwitchVideoGroup errCode: ", Integer.valueOf(i2));
            if (!b(kVar.gpg, kVar.gLN, kVar.pIi, false)) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleSwitchVideoGroup isCurrentRoom is not same", kVar.gpg, Integer.valueOf(kVar.gLN));
            } else if (i2 == 0) {
                g gVar3 = this.pIy;
                anonymousClass4 = new AnonymousClass10(gVar3, acVar.prm);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass4.run();
                } else {
                    gVar3.handler.post(anonymousClass4);
                }
            } else {
                this.pIy.d(-800, null);
            }
        }
    }

    private void a(int i, ae aeVar) {
        com.tencent.pb.common.c.c.i("TalkRoomService", "handleGetGroupInfoBatch errCode: ", Integer.valueOf(i));
        if (i != 0) {
            this.pIy.cL(null);
            return;
        }
        ap[] apVarArr = aeVar.prn;
        if (apVarArr == null || apVarArr.length == 0) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleGetGroupInfoBatch resp.groupInfoList is null");
            return;
        }
        List arrayList = new ArrayList();
        for (ap apVar : apVarArr) {
            if (apVar != null) {
                a(apVar.lEs, null, 0, apVar.kty, apVar.ktz, apVar.pre, null, null, false, false);
                arrayList.add(c.bPu().QP(apVar.lEs));
            }
        }
        com.tencent.pb.common.c.c.i("TalkRoomService", "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(arrayList.size()));
        this.pIy.cL(arrayList);
    }

    private void a(int i, int i2, Object obj, com.tencent.wecall.talkroom.a.h hVar) {
        com.tencent.pb.common.c.c.d("TalkRoomService", "handleRedirectResp", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != 0 || obj == null) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "handleRedirectResp err", Integer.valueOf(i), Integer.valueOf(i2));
            if (b(hVar.lEs, hVar.gFG, hVar.gFH, false)) {
                this.pIq.J("redirect", "resp", "-1", String.valueOf(this.state));
                return;
            }
            return;
        }
        ag agVar = (ag) obj;
        if (b(agVar.lEs, agVar.kty, agVar.ktz, false)) {
            this.pIq.J("redirect", "resp", String.valueOf(i2), String.valueOf(this.state));
            a(agVar.lEs, null, this.ppl, agVar.kty, agVar.ktz, agVar.pre, agVar.prg, agVar.ppS, false, false);
            byte[] bArr = new byte[agVar.pri.length];
            for (int i3 = 0; i3 < agVar.pri.length; i3++) {
                bArr[i3] = (byte) agVar.pri[i3];
            }
            a(agVar.prf);
            this.pIr.Close();
            a(0, agVar.pre, agVar.pqu, bArr, (agVar.prh & 2) != 0, agVar.lEs, agVar.kty, agVar.ktz);
            return;
        }
        com.tencent.pb.common.c.c.e("TalkRoomService", "handleRedirectResp roomid error", Integer.valueOf(agVar.kty), Integer.valueOf(this.gLN));
    }

    private void a(int i, y yVar, com.tencent.wecall.talkroom.a.e eVar) {
        com.tencent.pb.common.c.c.d("TalkRoomService", "handleEnterTalkRoomEnd", eVar.gpg, Integer.valueOf(eVar.gLN), Long.valueOf(eVar.pIi), " errCode: ", Integer.valueOf(i), " state: ", Integer.valueOf(this.state));
        Map u = com.tencent.pb.common.c.b.u(Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111));
        if (u.containsKey(Integer.valueOf(i))) {
            h.zJ(((Integer) u.get(Integer.valueOf(i))).intValue());
        }
        if (i == 14255) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), yVar.lEs, Integer.valueOf(yVar.kty), Long.valueOf(yVar.ktz));
            this.pIy.d(-14255, yVar);
        } else if (i == 14256) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), yVar.lEs, Integer.valueOf(yVar.kty), Long.valueOf(yVar.ktz));
            this.pIy.d(-14256, yVar);
        } else if (i == 0 || i == 14204) {
            if (i == 14204 && this.state == 4) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", yVar.lEs, Integer.valueOf(yVar.kty), Long.valueOf(yVar.ktz));
            } else if (!b(yVar.lEs, yVar.kty, yVar.ktz, zH(yVar.pqc))) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", yVar.lEs, " mGroupId: ", this.gpg, Integer.valueOf(yVar.kty), Integer.valueOf(this.gLN), Long.valueOf(yVar.ktz), Long.valueOf(this.pIi));
                a(yVar.lEs, yVar.kty, yVar.ktz, (int) MMGIFException.D_GIF_ERR_NOT_READABLE, false);
                h.zJ(-1110);
            } else if (this.state != 3) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), yVar.lEs, Integer.valueOf(yVar.kty), Long.valueOf(yVar.ktz));
            } else {
                this.pIq.J("enter", "resp", String.valueOf(i), String.valueOf(this.state));
                if (yVar.prf == null || yVar.prf.length == 0) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(i), yVar.lEs, Integer.valueOf(yVar.kty), Long.valueOf(yVar.ktz));
                    h.zJ(-1605);
                    this.pIq.kDx = 329;
                    a(yVar.lEs, yVar.kty, yVar.ktz, 116, true);
                    this.pIy.d(-200, null);
                    return;
                }
                this.gpg = yVar.lEs;
                this.pIC = yVar.lEs;
                this.gLN = yVar.kty;
                this.pIi = yVar.ktz;
                setState(4);
                a(yVar.prf);
                a(yVar.lEs, null, this.ppl, yVar.kty, yVar.ktz, yVar.pre, yVar.prg, yVar.ppS, false, true);
                g gVar = this.pIy;
                Runnable anonymousClass5 = new com.tencent.wecall.talkroom.model.g.AnonymousClass5(gVar, c.bPu().QP(yVar.lEs));
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass5.run();
                } else {
                    gVar.handler.post(anonymousClass5);
                }
                byte[] bArr = new byte[yVar.pri.length];
                for (int i2 = 0; i2 < yVar.pri.length; i2++) {
                    bArr[i2] = (byte) yVar.pri[i2];
                }
                a(0, yVar.pre, yVar.pqu, bArr, (yVar.prh & 2) != 0, yVar.lEs, yVar.kty, yVar.ktz);
                bPH();
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.gpg, Integer.valueOf(this.gLN), Long.valueOf(this.pIi));
            }
        } else if (!b(eVar.gpg, eVar.gLN, eVar.pIi, zH(eVar.pJX))) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(i), " enterScene.mGroupId: ", eVar.gpg, " mGroupId: ", this.gpg, Integer.valueOf(eVar.gLN), Integer.valueOf(this.gLN), Long.valueOf(eVar.pIi), Long.valueOf(this.pIi));
        } else if (3 != this.state) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(i), eVar.gpg, Integer.valueOf(eVar.gLN), Long.valueOf(eVar.pIi));
        } else {
            this.pIq.J("enter", "resp", String.valueOf(i), String.valueOf(this.state));
            this.pIq.zN(322);
            com.tencent.pb.common.c.c.i("TalkRoomService", "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(i), eVar.gpg, Integer.valueOf(eVar.gLN), Long.valueOf(eVar.pIi));
            a(eVar.gpg, eVar.gLN, eVar.pIi, true);
            if (i == 14251) {
                this.pIy.d(-1000, null);
            } else if (i == 14252) {
                this.pIy.d(-1200, null);
            } else if (i == 14253) {
                Object valueOf = Integer.valueOf(60);
                if (yVar != null) {
                    valueOf = Integer.valueOf(yVar.prk);
                }
                this.pIy.d(-1500, valueOf);
            } else {
                this.pIy.d(-200, null);
            }
        }
    }

    private void a(String str, String str2, int i, int i2, long j, aq[] aqVarArr, ar[] arVarArr, ao aoVar, boolean z, boolean z2) {
        String str3;
        boolean z3;
        if (aqVarArr == null) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "printMembersLog members is null groupId: ", str, "  roomid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j));
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (aq aqVar : aqVarArr) {
                if (aqVar != null) {
                    stringBuffer.append(" memberId:" + aqVar.gGl + " uuid: " + aqVar.prp + " status: " + aqVar.status + "   mem.inviteTime:" + aqVar.pse + "  mem.reason: " + aqVar.bhB + "  mem.inviteuuid: " + aqVar.psq + "\n");
                }
            }
            com.tencent.pb.common.c.c.i("TalkRoomService", "printMembersLog groupId: ", str, "  romid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j), "  members.length: ", Integer.valueOf(aqVarArr.length), "  ", stringBuffer.toString());
        }
        c bPu = c.bPu();
        Integer valueOf = i == 0 ? null : Integer.valueOf(i);
        boolean z4 = this.gpg != null && this.gpg.equals(str);
        com.tencent.pb.common.c.c.d("TalkRoomManager", "newOrUpdateGroup groupId: ", str, " isActive: ", Boolean.valueOf(z4));
        if (TextUtils.isEmpty(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (TextUtils.isEmpty(str3)) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "newOrUpdateGroup invalid groupId");
            z3 = false;
        } else {
            if (j.QW(str2)) {
                bPu.pHO.put(str2, str3);
            }
            TalkRoom talkRoom = (TalkRoom) bPu.pHN.get(str3);
            if (TextUtils.isEmpty(str2) || talkRoom == null || aoVar == null || aoVar.bdW == 100) {
                TalkRoom talkRoom2;
                if (talkRoom == null) {
                    if (j.QW(str2)) {
                        talkRoom2 = (TalkRoom) bPu.pHN.get(str2);
                    } else {
                        talkRoom2 = talkRoom;
                    }
                    if (talkRoom2 != null) {
                        bPu.pHN.put(str3, talkRoom2);
                    }
                } else {
                    talkRoom2 = talkRoom;
                }
                if (talkRoom2 != null && z4) {
                    int bPQ = j.bPQ();
                    long bPR = j.bPR();
                    com.tencent.pb.common.c.c.d("TalkRoomManager", "check current active group roomId: ", Integer.valueOf(bPQ), " and roomKey: ", Long.valueOf(j));
                    if (bPQ != 0 && bPQ != i2) {
                        com.tencent.pb.common.c.c.i("TalkRoomManager", "diff roomId: ", Integer.valueOf(bPQ), " -> ", Integer.valueOf(i2));
                        z3 = false;
                    } else if (!(0 == bPR || bPR == j)) {
                        com.tencent.pb.common.c.c.i("TalkRoomManager", "diff roomKey: ", Long.valueOf(bPR), " -> ", Long.valueOf(j));
                        z3 = false;
                    }
                }
                if (talkRoom2 == null) {
                    com.tencent.pb.common.c.c.d("TalkRoomManager", "newOrUpdateGroup create groupId: ", str3);
                    bPu.pHN.put(str3, TalkRoom.a(str3, str2, valueOf, i2, j, aoVar, aqVarArr, arVarArr));
                } else {
                    com.tencent.pb.common.c.c.d("TalkRoomManager", "newOrUpdateGroup update groupId: ", str3);
                    TalkRoom.a(talkRoom2, str3, str2, valueOf, i2, j, aoVar, aqVarArr, arVarArr);
                }
                if (bPu.pHP != null && z) {
                    bPu.pHP.g(bPu.QP(str3));
                }
                c.bPv();
                z3 = true;
            } else {
                com.tencent.pb.common.c.c.i("TalkRoomManager", "newOrUpdateGroup clientGroupId is not empty , room is not null");
                z3 = false;
            }
        }
        String str4 = "TalkRoomService";
        Object[] objArr = new Object[16];
        objArr[0] = "engine handleVoiceGroupMemberChange";
        objArr[1] = str;
        objArr[2] = this.gpg;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(this.gLN);
        objArr[5] = Long.valueOf(j);
        objArr[6] = Long.valueOf(this.pIi);
        objArr[7] = Boolean.valueOf(z3);
        objArr[8] = " isCurrentRoom: ";
        objArr[9] = Boolean.valueOf(b(str, i2, j, false));
        objArr[10] = " members.length: ";
        objArr[11] = Integer.valueOf(aqVarArr != null ? aqVarArr.length : 0);
        objArr[12] = " isCallBackEngine: ";
        objArr[13] = Boolean.valueOf(z2);
        objArr[14] = " mFirstGetAudioData: ";
        objArr[15] = Boolean.valueOf(this.pIn);
        com.tencent.pb.common.c.c.d(str4, objArr);
        if (c.bPu().aT(this.gpg, false)) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.pIn), " mGroupId: ", this.gpg, " roomId: ", Integer.valueOf(i2));
            if (this.pIn) {
                this.pIn = false;
                this.gUW = true;
                this.pIA = k.bPS();
                this.pIl = this.pIj;
                if (this.pIw != null) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "refreashTalkingTime mTalkDurationTimerTask is null");
                } else {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.pHX, " mIsHoldOn: ", Boolean.valueOf(this.pIJ));
                    this.pIw = new TimerTask(this) {
                        final /* synthetic */ f pIO;

                        {
                            this.pIO = r1;
                        }

                        public final void run() {
                            if (!this.pIO.pIJ) {
                                f.n(this.pIO);
                                if (this.pIO.pIA) {
                                    f.p(this.pIO);
                                }
                                if (this.pIO.pIp == 3 || this.pIO.pIp == 2) {
                                    f.r(this.pIO);
                                    this.pIO.pIq.kDL = this.pIO.pIk * 1000;
                                }
                                this.pIO.pIq.pJA = this.pIO.pIj * 1000;
                                this.pIO.pIq.kDK = this.pIO.pIq.pJA;
                            }
                            if (this.pIO.pHX != null) {
                                f fVar = this.pIO.pHX;
                                boolean z = this.pIO.pIJ;
                                this.pIO.pIj;
                            }
                        }
                    };
                    this.pIx.scheduleAtFixedRate(this.pIw, 1000, 1000);
                }
            }
        }
        if (aqVarArr != null && z2 && b(str, i2, j, false) && aqVarArr.length > 0 && this.pIr != null) {
            a(aqVarArr);
        }
    }

    private void a(aq[] aqVarArr) {
        if (aqVarArr == null) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "onMebersChangedToEngine members is null");
            return;
        }
        int[] iArr = new int[aqVarArr.length];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < aqVarArr.length; i++) {
            iArr[i] = aqVarArr[i].gGl;
            stringBuffer.append(aqVarArr[i].gGl);
            stringBuffer.append(",");
        }
        com.tencent.pb.common.c.c.i("TalkRoomService", "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", stringBuffer.toString());
        if (this.pIr == null) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "onMebersChangedToEngine engine is null");
            return;
        }
        this.pIr.OnMembersChanged(iArr);
    }

    private void a(n[] nVarArr) {
        String str = "TalkRoomService";
        Object[] objArr = new Object[2];
        objArr[0] = "handleRelayData addrs length: ";
        objArr[1] = Integer.valueOf(nVarArr == null ? 0 : nVarArr.length);
        com.tencent.pb.common.c.c.d(str, objArr);
        if (nVarArr != null && nVarArr.length > 0) {
            this.pII = new int[nVarArr.length];
            this.pIH = new short[nVarArr.length];
            int i = 0;
            for (n nVar : nVarArr) {
                this.pII[i] = nVar.pqq;
                this.pIH[i] = (short) nVar.port;
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleRelayData ip: ", Integer.valueOf(nVar.pqq), " addr.port: ", Integer.valueOf(nVar.port));
                i++;
            }
            com.tencent.pb.common.c.c.d("TalkRoomService", "handleRelayData", Arrays.toString(this.pII), Arrays.toString(this.pIH), this.gpg, this.gpg, Integer.valueOf(this.gLN), Long.valueOf(this.pIi));
        }
    }

    public final int bB(byte[] bArr) {
        o oVar;
        try {
            oVar = (o) com.google.a.a.e.a(new o(), bArr, bArr.length);
        } catch (Exception e) {
            h.zJ(-1601);
            oVar = null;
        }
        if (oVar == null) {
            if (TextUtils.isEmpty(this.gpg) && TextUtils.isEmpty(this.pIh)) {
                h.a(this.gLN, this.pIi, "notify", "pasrefail");
            } else {
                this.pIq.J("notify", "pasrefail");
            }
            com.tencent.pb.common.c.c.i("TalkRoomService", "CLTNOT onVoiceGroupChange groupChg null");
            return -2;
        }
        Object obj;
        com.tencent.pb.common.c.c.i("TalkRoomService", "CLTNOT onVoiceGroupChange", this.gpg, Integer.valueOf(this.gLN), Long.valueOf(this.pIi), Long.valueOf(oVar.bao), Integer.valueOf(oVar.pqr));
        long j = oVar.bao;
        if (this.pID.contains(Long.valueOf(j))) {
            obj = 1;
        } else {
            this.pID.add(Long.valueOf(j));
            obj = null;
        }
        if (obj != null) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "CLTNOT onVoiceGroupChange isMsgDouble error");
            if (b(oVar.lEs, oVar.kty, oVar.ktz, false)) {
                this.pIq.J("notify", "repeat", String.valueOf(oVar.pqr));
            } else {
                h.a(oVar.lEs, oVar.kty, oVar.ktz, "notify", "repeat", String.valueOf(oVar.pqr));
            }
            return -3;
        }
        if (b(oVar.lEs, oVar.kty, oVar.ktz, false)) {
            this.pIq.J("notify", "succ", String.valueOf(oVar.pqr));
        }
        if (oVar.pqr == 4 || oVar.pqr == 2) {
            a(oVar.lEs, null, oVar.ppV, oVar.kty, oVar.ktz, oVar.pqt, oVar.pqs, oVar.ppS, true, true);
        } else if (oVar.pqr == 16) {
            a(oVar.lEs, null, oVar.ppV, oVar.kty, oVar.ktz, oVar.pqt, oVar.pqs, oVar.ppS, true, false);
        } else if (oVar.pqr == 1) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "handlerCreateGroupChange groupChg.groupId: ", oVar.lEs, " roomId: ", Integer.valueOf(oVar.kty), " roomkey: ", Long.valueOf(oVar.ktz));
            if (!com.tencent.pb.b.a.a.bMp()) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "CLTNOT handlerCreateGroupChange isAuthed is false");
            } else if (bbD() && h.equals(oVar.lEs, this.gpg)) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "CLTNOT handlerCreateGroupChange return is same groupId: ", this.gpg);
            } else {
                a(oVar.lEs, null, oVar.ppV, oVar.kty, oVar.ktz, oVar.pqt, oVar.pqs, oVar.ppS, false, true);
                Object obj2 = oVar.lEs;
                r3 = oVar.kty;
                long j2 = oVar.ktz;
                int i = oVar.ppV;
                int i2 = oVar.pqv;
                if (TextUtils.isEmpty(obj2)) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "CLTNOT ackTalkRoom groupId is null");
                } else {
                    boolean a = com.tencent.pb.common.b.e.bLT().a(new com.tencent.wecall.talkroom.a.a(obj2, r3, j2, i, i2));
                    com.tencent.pb.common.c.c.d("TalkRoomService", "CLTNOT ackTalkRoom groupId: ", obj2, Integer.valueOf(r3), Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(a));
                }
                com.tencent.pb.common.c.c.i("TalkRoomService", "handlerCreateGroupChange start ui");
            }
        } else if (oVar.pqr == 8) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleCancelCreateVoiceGroupChange groupChg.groupId: ", oVar.lEs, " mGroupId: ", this.gpg);
            if (b(oVar.lEs, oVar.kty, oVar.ktz, false)) {
                a(oVar.lEs, null, oVar.ppV, oVar.kty, oVar.ktz, oVar.pqt, oVar.pqs, oVar.ppS, true, false);
                a(oVar.lEs, oVar.kty, oVar.ktz, false, false, true);
            } else {
                a(oVar.lEs, null, oVar.ppV, oVar.kty, oVar.ktz, oVar.pqt, oVar.pqs, oVar.ppS, true, false);
            }
        } else if (oVar.pqr == FileUtils.S_IWUSR) {
            String str = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "handleMemberWhisper groupChg.groupChg.groupId: ";
            objArr[1] = oVar.lEs;
            objArr[2] = " mGroupId: ";
            objArr[3] = this.gpg;
            objArr[4] = " groupChg.whisperBuf size: ";
            objArr[5] = Integer.valueOf(oVar.pqw == null ? 0 : oVar.pqw.length);
            com.tencent.pb.common.c.c.d(str, objArr);
            r0 = this.pIy;
            Runnable anonymousClass13 = new AnonymousClass13(r0, oVar.lEs, oVar.pqw);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass13.run();
            } else {
                r0.handler.post(anonymousClass13);
            }
        } else if (oVar.pqr == FileUtils.S_IRUSR) {
            if (!b(oVar.lEs, oVar.kty, oVar.ktz, false)) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleVideoMember is not same room ", oVar.lEs, Integer.valueOf(oVar.kty));
            } else if (oVar.pqw == null) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleVideoMember whisperBuf is null", oVar.lEs, Integer.valueOf(oVar.kty));
            } else {
                p pVar;
                try {
                    byte[] bArr2 = oVar.pqw;
                    pVar = (p) com.google.a.a.e.a(new p(), bArr2, bArr2.length);
                } catch (com.google.a.a.d e2) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "handleVideoMember ", e2);
                    pVar = null;
                }
                if (pVar == null || pVar.pqy == null) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "handleVideoMember notify is null", oVar.lEs, Integer.valueOf(oVar.kty));
                } else {
                    List arrayList = new ArrayList();
                    for (Object obj3 : pVar.pqy) {
                        if (obj3 != null) {
                            arrayList.add(obj3);
                        }
                    }
                    com.tencent.pb.common.c.c.d("TalkRoomService", "handleVideoMember groupid: ", this.gpg, " roomId: ", Integer.valueOf(this.gLN), " videoUserNames: ", arrayList);
                    r0 = this.pIy;
                    Runnable anonymousClass1 = new com.tencent.wecall.talkroom.model.g.AnonymousClass1(r0, arrayList);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        anonymousClass1.run();
                    } else {
                        r0.handler.post(anonymousClass1);
                    }
                }
            }
        } else if (oVar.pqr == 1024) {
            if (!b(oVar.lEs, oVar.kty, oVar.ktz, false)) {
                com.tencent.pb.common.c.c.i("TalkRoomService", "handleOtherDevice is not same room ", oVar.lEs, Integer.valueOf(oVar.kty));
            } else if (!(this.state == 3 || this.state == 4)) {
                b(oVar.lEs, oVar.kty, oVar.ktz, 1);
                this.pIy.d(-1400, null);
            }
        }
        return 0;
    }

    public final void bPG() {
        h hVar = this.pIq;
        com.tencent.pb.common.c.c.d(h.TAG, "reset");
        hVar.pJL = 0;
        hVar.pJK = 0;
        hVar.pJJ = 0;
        hVar.lEs = SQLiteDatabase.KeyEmpty;
        hVar.ppQ = SQLiteDatabase.KeyEmpty;
        hVar.kvR = 1;
        hVar.gFG = 0;
        hVar.gFH = 0;
        hVar.gGl = -1;
        hVar.kDx = 0;
        hVar.kDE = 0;
        hVar.kDA = 0;
        hVar.gHc = 0;
        hVar.pJw = 0;
        hVar.pJx = 0;
        hVar.pJy = 0;
        hVar.pJz = 0;
        hVar.pJA = 0;
        hVar.pJB = 0;
        hVar.pJC = 0;
        hVar.pJD = 0;
        hVar.kDF = 0;
        hVar.gHb = 0;
        hVar.kDK = 0;
        hVar.kDL = 0;
        hVar.netType = -1;
        hVar.pJE = 0;
        hVar.pJF = 0;
        hVar.pJG = SQLiteDatabase.KeyEmpty;
        hVar.deviceModel = SQLiteDatabase.KeyEmpty;
        hVar.pJH = -1;
        hVar.kDQ = SQLiteDatabase.KeyEmpty;
        hVar.pJI.setLength(0);
    }

    private void a(String str, int i, long j, boolean z) {
        a(str, i, j, z, true, true);
    }

    public final void a(String str, int i, long j, boolean z, boolean z2, boolean z3) {
        com.tencent.pb.common.c.c.i("TalkRoomService", "closeVoiceGroup groupId: ", str, " mGroupId: ", this.gpg, " roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.gLN), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.pIi));
        try {
            TalkRoom QK = c.bPu().QK(str);
            if (QK == null) {
                com.tencent.pb.common.c.c.i("TalkRoomManager", "handleRoomExit assert failed: current TalkRoom MUST exists");
            } else {
                d QJ = QK.QJ(com.tencent.pb.b.a.a.bMo());
                if (QJ != null) {
                    QJ.pHQ.status = 20;
                    QJ.pHQ.gGl = -1;
                }
                String str2 = "tagorewang:TalkRoom";
                Object[] objArr = new Object[2];
                objArr[0] = "resetRoomTempInfo groupId: ";
                objArr[1] = QK.pta == null ? SQLiteDatabase.KeyEmpty : QK.pta;
                com.tencent.pb.common.c.c.d(str2, objArr);
                c.bPv();
            }
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "handleRoomExit: ", th);
        }
        if (z) {
            e(str, i, j);
        }
        this.pHZ.remove(str);
        if (b(str, i, j, false)) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "closeVoiceGroup isCurrentRoom groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j));
            kF(true);
            g gVar = this.pIy;
            Runnable anonymousClass6 = new com.tencent.wecall.talkroom.model.g.AnonymousClass6(gVar, str, z2);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass6.run();
            } else {
                gVar.handler.post(anonymousClass6);
            }
        }
        if (z3) {
            MultiTalkGroup QP = c.bPu().QP(str);
            if (QP != null) {
                this.pIy.g(QP);
            }
        }
    }

    public final boolean bbD() {
        com.tencent.pb.common.c.c.i("TalkRoomService", "state: ", Integer.valueOf(this.state));
        if (this.state != 0) {
            return true;
        }
        return false;
    }

    public final e QQ(String str) {
        return (e) this.pHZ.get(str);
    }

    public final boolean QR(String str) {
        return ((e) this.pHZ.get(str)) != null;
    }

    private void bPH() {
        com.tencent.pb.common.c.c.i("TalkRoomService", "hello timer start~~");
        if (this.pIt != null) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "dealWithInit enter talkroom not first time");
            return;
        }
        try {
            this.pIt = new TimerTask(this) {
                final /* synthetic */ f pIO;

                {
                    this.pIO = r1;
                }

                public final void run() {
                    if (this.pIO.gLN == 0 || this.pIO.gpg == null) {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(this.pIO.gLN), this.pIO.gpg);
                        this.pIO.bPJ();
                        return;
                    }
                    f.a(this.pIO, f.j(this.pIO));
                }
            };
            this.pIv.schedule(this.pIt, 0, 10000);
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "startNooper: ", e);
        }
    }

    private void bPI() {
        try {
            com.tencent.pb.common.c.c.i("TalkRoomService", "cancelHelloTimeOutTask");
            if (this.pIu != null) {
                this.pIu.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "cancelHelloTimeOutTask: ", e);
        }
        this.pIu = null;
    }

    private void bPJ() {
        try {
            com.tencent.pb.common.c.c.i("TalkRoomService", "cancelHelloTimerTask");
            if (this.pIt != null) {
                this.pIt.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "cancelHelloTimerTask: ", e);
        }
        this.pIt = null;
    }

    private void a(int i, aq[] aqVarArr, an anVar, byte[] bArr, boolean z, String str, int i2, long j) {
        Exception e;
        final int i3;
        final aq[] aqVarArr2;
        final an anVar2;
        final byte[] bArr2;
        final boolean z2;
        final String str2;
        final int i4;
        final long j2;
        com.tencent.pb.common.c.c.d("TalkRoomService", "dealWithInit", Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(this.state));
        if (this.pIr != null) {
            boolean z3;
            try {
                if (this.state != 4) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "dealWithInit state is error: ", Integer.valueOf(this.state));
                    z3 = false;
                } else {
                    z3 = a(aqVarArr, anVar, bArr, z, i2, j);
                }
                try {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "dealWithInit ret: ", Boolean.valueOf(z3));
                } catch (Exception e2) {
                    e = e2;
                    com.tencent.pb.common.c.c.i("TalkRoomService", "dealWithInit ", e);
                    if (z3) {
                        return;
                    }
                    if (i <= 0) {
                        this.pIq.zN(202);
                        com.tencent.pb.common.c.c.i("TalkRoomService", "exitTalkRoom dealWithInit fail");
                        a(str, i2, j, (int) MMGIFException.D_GIF_ERR_READ_FAILED, true);
                        this.pIy.d(-400, null);
                        return;
                    }
                    i3 = i;
                    aqVarArr2 = aqVarArr;
                    anVar2 = anVar;
                    bArr2 = bArr;
                    z2 = z;
                    str2 = str;
                    i4 = i2;
                    j2 = j;
                    this.mHandler.postDelayed(new Runnable(this) {
                        final /* synthetic */ f pIO;

                        public final void run() {
                            this.pIO.a(i3 - 1, aqVarArr2, anVar2, bArr2, z2, str2, i4, j2);
                        }
                    }, 50);
                }
            } catch (Exception e3) {
                e = e3;
                z3 = false;
                com.tencent.pb.common.c.c.i("TalkRoomService", "dealWithInit ", e);
                if (z3) {
                    return;
                }
                if (i <= 0) {
                    i3 = i;
                    aqVarArr2 = aqVarArr;
                    anVar2 = anVar;
                    bArr2 = bArr;
                    z2 = z;
                    str2 = str;
                    i4 = i2;
                    j2 = j;
                    this.mHandler.postDelayed(/* anonymous class already generated */, 50);
                }
                this.pIq.zN(202);
                com.tencent.pb.common.c.c.i("TalkRoomService", "exitTalkRoom dealWithInit fail");
                a(str, i2, j, (int) MMGIFException.D_GIF_ERR_READ_FAILED, true);
                this.pIy.d(-400, null);
                return;
            }
            if (z3) {
                return;
            }
        }
        if (i <= 0) {
            this.pIq.zN(202);
            com.tencent.pb.common.c.c.i("TalkRoomService", "exitTalkRoom dealWithInit fail");
            a(str, i2, j, (int) MMGIFException.D_GIF_ERR_READ_FAILED, true);
            this.pIy.d(-400, null);
            return;
        }
        i3 = i;
        aqVarArr2 = aqVarArr;
        anVar2 = anVar;
        bArr2 = bArr;
        z2 = z;
        str2 = str;
        i4 = i2;
        j2 = j;
        this.mHandler.postDelayed(/* anonymous class already generated */, 50);
    }

    final boolean bam() {
        int rx;
        com.tencent.pb.common.c.c.d("TalkRoomService", "initEngine", this.gpg, Integer.valueOf(this.gLN), Long.valueOf(this.pIi), Integer.valueOf(this.state));
        try {
            b bVar = this.pIr;
            if (com.tencent.pb.common.a.a.poK) {
                int i;
                String absolutePath = com.tencent.pb.common.c.d.kzS.getDir("lib", 0).getAbsolutePath();
                com.tencent.pb.talkroom.sdk.e eVar = ppx;
                if (eVar != null) {
                    rx = eVar.rx();
                } else {
                    rx = 0;
                }
                com.tencent.pb.common.c.c.d("simon:TalkRoomContext", "protocalInit netType:", Integer.valueOf(k.gB(com.tencent.pb.common.c.d.kzS)), " cpuFlag:", Integer.valueOf(rx), "libPath:", absolutePath);
                rx = bVar.pHK.init(r6, rx, absolutePath + "/");
                absolutePath = "simon:TalkRoomContext";
                Object[] objArr = new Object[4];
                objArr[0] = "protocalInit";
                objArr[1] = Integer.valueOf(rx);
                objArr[2] = "field_capInfo length: ";
                if (bVar.pHK.field_capInfo == null) {
                    i = 0;
                } else {
                    i = bVar.pHK.field_capInfo.length;
                }
                objArr[3] = Integer.valueOf(i);
                com.tencent.pb.common.c.c.d(absolutePath, objArr);
            } else {
                rx = 0;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "initEngine", e);
            rx = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (rx >= 0) {
            return true;
        }
        h.zM(-3001);
        this.pIq.zN(201);
        this.pIr = null;
        com.tencent.pb.common.c.c.i("TalkRoomService", "initEngine engine.protocalInit error", Integer.valueOf(rx));
        return false;
    }

    public final void kG(boolean z) {
        try {
            pb();
            bPF();
            if (z) {
                auD();
                bPK();
            }
            com.tencent.pb.common.c.c.i("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z));
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z), th);
        }
    }

    private void auD() {
        pb();
        int b = b(talk.hyT, talk.hyU, new com.tencent.pb.talkroom.sdk.c(this) {
            final /* synthetic */ f pIO;

            {
                this.pIO = r1;
            }

            public final void C(byte[] bArr, int i) {
                try {
                    if (this.pIO.pIg) {
                        if (this.pIO.aUy) {
                            for (int i2 = 0; i2 < bArr.length; i2++) {
                                bArr[i2] = (byte) 0;
                            }
                        }
                        if (this.pIO.pIg) {
                            b c = this.pIO.pIr;
                            short s = (short) i;
                            if (com.tencent.pb.common.a.a.poK) {
                                c.pHK.SendAudio(bArr, s, 0);
                            }
                            if (this.pIO.pIF) {
                                this.pIO.pIF = false;
                                com.tencent.pb.common.c.c.i("TalkRoomService", "onRecPcmDataCallBack len: ", Integer.valueOf(i));
                            }
                        }
                    }
                } catch (Exception e) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "initMediaComponent record", e);
                }
            }
        });
        if (b <= 0) {
            this.pIq.zN(MMGIFException.D_GIF_ERR_OPEN_FAILED);
            h.zK(-2001);
            this.pIy.d(-500, null);
        }
        h hVar;
        if (b > 0) {
            hVar = this.pIq;
            hVar.pJw &= -2;
        } else {
            hVar = this.pIq;
            hVar.pJw |= 1;
        }
        com.tencent.pb.common.c.c.i("TalkRoomService", "audioAdapter startRecord ret: ", Integer.valueOf(b));
    }

    private void bPK() {
        bPF();
        final AtomicInteger atomicInteger = new AtomicInteger();
        final AtomicInteger atomicInteger2 = new AtomicInteger();
        if (b(talk.hyT, talk.hyU, new com.tencent.pb.talkroom.sdk.b(this) {
            final /* synthetic */ f pIO;

            public final int B(byte[] bArr, int i) {
                if (!this.pIO.pIg) {
                    return 0;
                }
                try {
                    int GetAudioData = !com.tencent.pb.common.a.a.poK ? 1 : this.pIO.pIr.pHK.GetAudioData(bArr, (short) i, atomicInteger, atomicInteger2);
                    if (this.pIO.pIG && GetAudioData >= 0) {
                        this.pIO.pIG = false;
                        com.tencent.pb.common.c.c.i("TalkRoomService", "onPlayPcmDataCallBack len: ", Integer.valueOf(i), " ret: ", Integer.valueOf(GetAudioData));
                    }
                    return GetAudioData;
                } catch (Exception e) {
                    com.tencent.pb.common.c.c.i("TalkRoomService", "initMediaComponent play", e);
                    return -1;
                }
            }
        }) <= 0) {
            this.pIq.zN(MMGIFException.D_GIF_ERR_OPEN_FAILED);
            h.zK(-2001);
            h hVar = this.pIq;
            hVar.pJw |= 1;
            this.pIy.d(-500, null);
        }
        com.tencent.pb.common.c.c.i("TalkRoomService", "audioAdapter startPlayer ret: ", Integer.valueOf(r0));
    }

    private boolean a(aq[] aqVarArr, an anVar, byte[] bArr, boolean z, int i, long j) {
        int[] iArr;
        int i2;
        int i3;
        com.tencent.pb.common.c.c.d("TalkRoomService", "connectToCompenent myRoomMemId roomid:", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), "groupId: ", this.gpg, " ip: ", Arrays.toString(this.pII), " ports: ", Arrays.toString(this.pIH));
        String bMo = com.tencent.pb.b.a.a.bMo();
        int i4 = -1;
        if (aqVarArr == null || aqVarArr.length <= 0) {
            iArr = null;
            i2 = -1;
        } else {
            int[] iArr2 = new int[aqVarArr.length];
            for (i3 = 0; i3 < aqVarArr.length; i3++) {
                iArr2[i3] = aqVarArr[i3].gGl;
                if (h.equals(aqVarArr[i3].prp, bMo)) {
                    i4 = aqVarArr[i3].gGl;
                }
            }
            iArr = iArr2;
            i2 = i4;
        }
        int QL = c.bPu().QL(this.gpg);
        this.pIq.gGl = i2;
        try {
            int i5;
            b bVar = this.pIr;
            com.tencent.mm.plugin.multi.talk.a aVar = this.pIs;
            TalkRoom QK = c.bPu().QK(this.gpg);
            if (QK == null) {
                com.tencent.pb.common.c.c.i("TalkRoomManager", "getMyUuid TalkRoom is null  groupId: ", r3);
                i5 = 0;
            } else {
                d QJ = QK.QJ(com.tencent.pb.b.a.a.bMo());
                if (QJ == null) {
                    com.tencent.pb.common.c.c.i("TalkRoomManager", "getMyUuid talkRoomMember is null  groupId: ", r3);
                    i5 = 0;
                } else {
                    aq aqVar = QJ.pHQ;
                    if (aqVar == null) {
                        com.tencent.pb.common.c.c.i("TalkRoomManager", "getMyUuid voiceGroupMem is null  groupId: ", r3);
                        i5 = 0;
                    } else {
                        com.tencent.pb.common.c.c.d("TalkRoomManager", "getMyUuid groupId: ", r3, " uuid: ", Integer.valueOf(aqVar.lYf));
                        i5 = aqVar.lYf;
                    }
                }
            }
            int[] iArr3 = this.pII;
            short[] sArr = this.pIH;
            com.tencent.pb.common.c.c.d("simon:TalkRoomContext", "Open");
            i iVar = null;
            if (anVar != null) {
                iVar = new i(anVar.prx, anVar.cGs, anVar.cGt, anVar.pry, anVar.prz, anVar.prA, anVar.prB, anVar.prC, anVar.prD, anVar.prE, anVar.prF, anVar.prG);
            } else {
                com.tencent.pb.common.c.c.i("simon:TalkRoomContext", "voiceConf is null");
            }
            i3 = bVar.pHK.Open(aVar, iVar, i5, i2, i, j, iArr3, sArr, 0, iArr, bArr, z, k.gB(com.tencent.pb.common.c.d.kzS));
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "connectToCompenent", th);
            i3 = QbSdk.EXTENSION_INIT_FAILURE;
        }
        g gVar = this.pIy;
        Runnable anonymousClass18 = new AnonymousClass18(gVar, i3);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass18.run();
        } else {
            gVar.handler.post(anonymousClass18);
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "connectToCompenent ret =", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(QL));
        if (i3 < 0) {
            h.zM(-3002);
        }
        if (i3 == 0) {
            this.pIq.kDA = 1;
        }
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    private boolean b(String str, int i, long j, boolean z) {
        if (z) {
            return h.ed(str, this.gpg);
        }
        com.tencent.pb.common.c.c.i("TalkRoomService", "isCurrentRoom groupId: ", str, " mGroupId: ", this.gpg, "roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.gLN), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.pIi));
        if (h.ed(str, this.gpg) && i == this.gLN && j == this.pIi) {
            return true;
        }
        return false;
    }

    private void e(String str, int i, long j) {
        String str2 = null;
        try {
            c bPu = c.bPu();
            if (i == 0 && j == 0) {
                com.tencent.pb.common.c.c.i("TalkRoomManager", "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", str);
            } else {
                TalkRoom QK = bPu.QK(str);
                if (QK == null) {
                    com.tencent.pb.common.c.c.i("TalkRoomManager", "getMsgKeyByGroupId talkRoom is null,groupId: ", str);
                } else {
                    d QJ = QK.QJ(com.tencent.pb.b.a.a.bMo());
                    if (QJ == null) {
                        com.tencent.pb.common.c.c.i("TalkRoomManager", "getMsgKeyByGroupId talkRoomMember is null,groupId: ", str);
                    } else {
                        aq aqVar = QJ.pHQ;
                        if (aqVar == null) {
                            com.tencent.pb.common.c.c.i("TalkRoomManager", "getMsgKeyByGroupId voiceGroupMem is null,groupId: ", str);
                        } else {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(",");
                            stringBuffer.append(i);
                            stringBuffer.append(",");
                            stringBuffer.append(j);
                            stringBuffer.append(",");
                            stringBuffer.append(aqVar.psg);
                            com.tencent.pb.common.c.c.i("TalkRoomManager", "getMsgKeyByGroupId msgKey is", stringBuffer.toString());
                            str2 = stringBuffer.toString();
                        }
                    }
                }
            }
            com.tencent.pb.common.c.c.i("TalkRoomService", "addCallLog groupId: ", str, " mIsOutCall: ", Boolean.valueOf(this.ktR), " mTalkDuration: ", Integer.valueOf(this.pIj), " msgKey: ", str2);
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "handleRoomExit: ", th);
        }
    }

    public final boolean O(String str, int i, int i2) {
        com.tencent.pb.common.c.c.i("TalkRoomService", "finishCurrentTalk groupId: ", str, " rejectReason: ", Integer.valueOf(i), " exitReason: ", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i == 1 || i2 == 100) {
            h hVar = this.pIq;
            com.tencent.pb.common.c.c.d(h.TAG, "endCancelCreate", Long.valueOf(System.currentTimeMillis() - hVar.pJJ), Long.valueOf(hVar.pJy));
            if (hVar.pJy <= 0) {
                hVar.kDE = 1;
                if (hVar.pJJ == 0) {
                    hVar.kDF = 0;
                } else {
                    hVar.kDF = System.currentTimeMillis() - hVar.pJJ;
                }
            }
        }
        int i3 = this.gLN;
        long j = this.pIi;
        int i4 = a.bPi().state;
        if (j.QW(str)) {
            this.pIq.zN(327);
            return a.bPi().cu(str, 1000);
        } else if (i4 == 2) {
            return a.bPi().b(str, i3, j, i);
        } else {
            Integer[] numArr = new Integer[]{Integer.valueOf(MMGIFException.D_GIF_ERR_READ_FAILED), Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_GIF_FILE), Integer.valueOf(MMGIFException.D_GIF_ERR_NO_SCRN_DSCR), Integer.valueOf(MMGIFException.D_GIF_ERR_NO_IMAG_DSCR), Integer.valueOf(MMGIFException.D_GIF_ERR_NO_COLOR_MAP), Integer.valueOf(MMGIFException.D_GIF_ERR_WRONG_RECORD), Integer.valueOf(MMGIFException.D_GIF_ERR_DATA_TOO_BIG)};
            List arrayList = new ArrayList();
            for (i4 = 0; i4 < 7; i4++) {
                arrayList.add(numArr[i4]);
            }
            arrayList.contains(Integer.valueOf(i2));
            return a.bPi().a(str, i3, j, i2, true);
        }
    }

    public final void cs(String str, int i) {
        if (!h.equals("GLOBAL_TOPIC_NETWORK_CHANGE", str) || !bbD()) {
            return;
        }
        if (this.gUW || this.pIg) {
            switch (i) {
                case 21:
                    switch (k.gB(com.tencent.pb.common.c.d.kzS)) {
                        case 4:
                            this.pIA = true;
                            break;
                        default:
                            this.pIA = false;
                            break;
                    }
                    if (this.gLN == 0 || this.pIi == 0) {
                        com.tencent.pb.common.c.c.i("TalkRoomService", "sendRedirect mRoomId valid(session ended)");
                        return;
                    }
                    com.tencent.pb.common.c.c.i("TalkRoomService", "sendRedirect", this.gpg, Integer.valueOf(this.gLN));
                    this.pIq.bPO();
                    boolean a = com.tencent.pb.common.b.e.bLT().a(new com.tencent.wecall.talkroom.a.h(this.gpg, this.gLN, this.pIi, c.bPu().QL(this.gpg)));
                    this.pIq.J("redirect", "req", String.valueOf(a), String.valueOf(this.state));
                    com.tencent.pb.common.c.c.i("TalkRoomService", "sendRedirect ret: ", Boolean.valueOf(a));
                    return;
                case 33:
                    b bVar = this.pIr;
                    int gB = k.gB(com.tencent.pb.common.c.d.kzS);
                    if (com.tencent.pb.common.a.a.poK) {
                        bVar.pHK.onNetworkChange(gB);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static boolean zH(int i) {
        return i != 1;
    }

    private void a(String str, int i, long j, String str2) {
        this.gLN = i;
        this.pIi = j;
        this.gpg = str2;
        this.pIh = str;
    }

    public static boolean qZ() {
        boolean isSpeakerphoneOn;
        try {
            isSpeakerphoneOn = ((AudioManager) com.tencent.pb.common.c.d.kzS.getSystemService("audio")).isSpeakerphoneOn();
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("TalkRoomService", "isSpeakerOn ", e);
            isSpeakerphoneOn = false;
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "isSpeakerOn ret: ", Boolean.valueOf(isSpeakerphoneOn));
        return isSpeakerphoneOn;
    }

    public static void a(com.tencent.pb.talkroom.sdk.e eVar) {
        ppx = eVar;
    }

    public static com.tencent.pb.talkroom.sdk.e bPL() {
        return ppx;
    }
}
