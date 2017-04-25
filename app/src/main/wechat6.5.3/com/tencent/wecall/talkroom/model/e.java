package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.d.i;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.aq;
import com.tencent.pb.common.b.f;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.h;
import com.tencent.pb.common.system.ConnectReceiver;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.a;
import com.tencent.pb.talkroom.sdk.d;
import com.tencent.pb.talkroom.sdk.g;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.model.f.b;
import com.tencent.wecall.talkroom.model.g.AnonymousClass12;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class e implements d {
    private static e pHT = null;
    private final String TAG = "TalkRoomSdkApi";
    private a pHS = null;
    private ConnectReceiver pHU = new ConnectReceiver();
    private g.a pHV = new g.a(this) {
        final /* synthetic */ e pHW;

        {
            this.pHW = r1;
        }

        public final void p(MultiTalkGroup multiTalkGroup) {
            c.i("TalkRoomSdkApi", "onCreateRoom", multiTalkGroup);
            if (com.tencent.pb.common.a.a.poJ) {
                Toast.makeText(com.tencent.pb.common.c.d.kzS, "onCreateRoom " + multiTalkGroup, 0).show();
            }
            if (this.pHW.pHS != null) {
                this.pHW.pHS.e(multiTalkGroup);
            }
        }

        public final void zF(int i) {
            c.d("TalkRoomSdkApi", "onOpeningChannel", Integer.valueOf(i));
        }

        public final void awP() {
            c.i("TalkRoomSdkApi", "onInitSeccess");
            if (com.tencent.pb.common.a.a.poJ) {
                Toast.makeText(com.tencent.pb.common.c.d.kzS, "onInitSeccess ", 0).show();
            }
            if (this.pHW.pHS != null) {
                this.pHW.pHS.aCj();
            }
        }

        public final void g(MultiTalkGroup multiTalkGroup) {
            String str = a.bPi().gpg;
            String str2 = null;
            if (multiTalkGroup != null) {
                str2 = multiTalkGroup.pta;
            }
            c.h("TalkRoomSdkApi", "onMemberChange mGroupId: ", str, " groupId: ", str2, multiTalkGroup);
            if (com.tencent.pb.common.a.a.poJ) {
                Toast.makeText(com.tencent.pb.common.c.d.kzS, "onMemberChange " + multiTalkGroup, 0).show();
            }
            if (h.ed(str2, str)) {
                c.bPu();
                if (c.QN(str) && a.bPi().state != 3) {
                    int i;
                    int i2;
                    c.bPu();
                    int QO = c.QO(str);
                    if (QO == MMGIFException.D_GIF_ERR_NO_SCRN_DSCR) {
                        i = -1602;
                        i2 = 325;
                    } else if (QO == 2) {
                        i = -1603;
                        i2 = 326;
                    } else {
                        i = -1604;
                        i2 = 328;
                    }
                    c.i("TalkRoomSdkApi", "onMemberChange isMySelfExit finish ", "stopstatus", Integer.valueOf(i), Integer.valueOf(i2), str2, " reason: ", Integer.valueOf(QO));
                    h.zJ(i);
                    a.bPi().pIq.zN(i2);
                    f bPi = a.bPi();
                    QO = a.bPi().gLN;
                    long j = a.bPi().pIi;
                    boolean z = a.bPi().ktR;
                    bPi.a(str2, QO, j, false, false, false);
                }
            }
            if (this.pHW.pHS != null) {
                this.pHW.pHS.g(multiTalkGroup);
            }
        }

        public final void d(int i, Object obj) {
            c.i("TalkRoomSdkApi", "onErr errCode: ", Integer.valueOf(i), " data: ", obj);
            if (this.pHW.pHS != null) {
                this.pHW.pHS.d(i, obj);
            }
        }

        public final void q(MultiTalkGroup multiTalkGroup) {
            c.i("TalkRoomSdkApi", "onEnterRoom", multiTalkGroup);
            if (this.pHW.pHS != null) {
                this.pHW.pHS.f(multiTalkGroup);
                if (com.tencent.pb.common.a.a.poJ) {
                    Toast.makeText(com.tencent.pb.common.c.d.kzS, "onEnterRoom " + multiTalkGroup, 0).show();
                }
            }
        }

        public final void aU(String str, boolean z) {
            c.d("TalkRoomSdkApi", "onExitRoom", str, a.bPi().gpg, Boolean.valueOf(z));
        }

        public final void onStateChanged(int i) {
            c.d("TalkRoomSdkApi", "onStateChanged", Integer.valueOf(i));
        }

        public final void bPA() {
            c.d("TalkRoomSdkApi", "onSelfHoldOnBegin");
        }

        public final void bPB() {
            c.d("TalkRoomSdkApi", "onSelfHoldOnEnd");
        }

        public final void ct(String str, int i) {
            c.d("TalkRoomSdkApi", "onModifyGroupInfo", str, Integer.valueOf(i));
        }

        public final void ew(boolean z) {
            c.h("TalkRoomSdkApi", "onMuteStateChange", Boolean.valueOf(z));
            if (this.pHW.pHS != null) {
                this.pHW.pHS.ew(z);
            }
        }

        public final void b(MultiTalkGroup multiTalkGroup) {
            c.i("TalkRoomSdkApi", "onInviteMultiTalk", multiTalkGroup);
            if (this.pHW.pHS != null) {
                this.pHW.pHS.b(multiTalkGroup);
                if (com.tencent.pb.common.a.a.poJ) {
                    Toast.makeText(com.tencent.pb.common.c.d.kzS, "onInviteMultiTalk " + multiTalkGroup, 0).show();
                }
            }
        }

        public final void a(int i, MultiTalkGroup multiTalkGroup) {
            c.i("TalkRoomSdkApi", "onMisscMultiTalk", multiTalkGroup, " time: ", Integer.valueOf(i));
            if (this.pHW.pHS != null) {
                this.pHW.pHS.d(multiTalkGroup);
                if (com.tencent.pb.common.a.a.poJ) {
                    Toast.makeText(com.tencent.pb.common.c.d.kzS, "onMisscMultiTalk " + multiTalkGroup, 0).show();
                }
            }
        }

        public final void cL(List<MultiTalkGroup> list) {
            c.h("TalkRoomSdkApi", "onActiveMultiTalkList ", list);
        }

        public final void bPC() {
            c.i("TalkRoomSdkApi", "onSendMsgSucc");
        }

        public final void w(String str, byte[] bArr) {
            int i = 0;
            String str2 = "TalkRoomSdkApi";
            Object[] objArr = new Object[4];
            objArr[0] = "onRcvMultiTalkMsg groupId: ";
            objArr[1] = str;
            objArr[2] = " datas size: ";
            if (bArr != null) {
                i = bArr.length;
            }
            objArr[3] = Integer.valueOf(i);
            c.i(str2, objArr);
        }

        public final void zG(int i) {
            c.d("TalkRoomSdkApi", "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(i));
            if (this.pHW.pHS != null) {
                this.pHW.pHS.aCk();
            }
        }

        public final void aO(List<aj> list) {
            c.d("TalkRoomSdkApi", "onVideoGroupMemberChange videoUserNames: ", list);
            if (this.pHW.pHS != null) {
                this.pHW.pHS.aO(list);
            }
        }
    };

    public static e bPz() {
        if (pHT == null) {
            synchronized (e.class) {
                if (pHT == null) {
                    pHT = new e();
                }
            }
        }
        return pHT;
    }

    private e() {
    }

    public static void gA(Context context) {
        com.tencent.pb.common.c.d.kzS = context;
        i.gz(context);
    }

    public final boolean a(a aVar, com.tencent.pb.talkroom.sdk.e eVar) {
        if (com.tencent.pb.common.c.d.kzS == null) {
            c.i("TalkRoomSdkApi", "init fail context: ", com.tencent.pb.common.c.d.kzS);
            return false;
        }
        try {
            this.pHS = aVar;
            f.a(eVar);
            f bPi = a.bPi();
            g.a aVar2 = this.pHV;
            g gVar = bPi.pIy;
            synchronized (aVar2) {
                if (gVar.bXt.contains(aVar2)) {
                } else {
                    gVar.bXt.add(aVar2);
                }
            }
            f.bLW().ppx = eVar;
            a.bPh();
            a.bPj();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(Integer.MAX_VALUE);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            com.tencent.pb.common.c.d.kzS.registerReceiver(this.pHU, intentFilter);
            c.d("TalkRoomSdkApi", "init");
            return true;
        } catch (Exception e) {
            c.i("TalkRoomSdkApi", "init ", e);
            return false;
        }
    }

    public final void kv(boolean z) {
        f bPi = a.bPi();
        c.i("TalkRoomService", "setMute isMute: ", Boolean.valueOf(z));
        bPi.aUy = z;
        com.tencent.pb.common.c.i.S(new AnonymousClass12(bPi.pIy, z));
    }

    public final void eC(boolean z) {
        boolean ey;
        a.bPi();
        com.tencent.pb.talkroom.sdk.e bPL = f.bPL();
        if (bPL != null) {
            ey = bPL.ey(z);
        } else {
            ey = false;
        }
        c.d("TalkRoomService", "switchSpeakerPhone", Boolean.valueOf(z), " ret: ", Boolean.valueOf(ey), " realret: ", Boolean.valueOf(f.qZ()), " wxCallBack: ", bPL);
    }

    public final boolean bMq() {
        try {
            c.s(true, 0);
            c.i("TalkRoomSdkApi", "setOpenLog: isOpenSdkLog", Boolean.valueOf(true), " level: ", Integer.valueOf(0));
            return true;
        } catch (Throwable th) {
            c.i("TalkRoomSdkApi", "setOpenLog: ", th);
            return false;
        }
    }

    public final boolean f(String str, String str2, List<String> list) {
        f bPi = a.bPi();
        String[] cM = f.cM(list);
        if (cM.length > 0) {
            int nextInt;
            if (TextUtils.isEmpty(null)) {
                nextInt = (new Random().nextInt() << 16) | (com.tencent.pb.b.a.a.bMo().hashCode() & 65535);
            } else {
                String str3 = null;
                String str4 = null;
                int charAt = str3.charAt(str4.length() - 1) * FileUtils.S_IRUSR;
                int i = 0;
                String str5 = null;
                if (str5.length() > 1) {
                    str3 = null;
                    str5 = null;
                    i = str3.charAt(str5.length() - 2);
                }
                nextInt = i + charAt;
            }
            c.i("TalkRoomService", "createTalkRoom cliendId: ", str, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(cM.length), "routeId", Integer.valueOf(nextInt), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0), " sdkKey: ", null);
            if (!com.tencent.pb.b.a.a.bMp()) {
                c.i("TalkRoomService", "createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.b.a.a.bMp()), " isBindMobile: ", Boolean.valueOf(true));
                h.a(SQLiteDatabase.KeyEmpty, str, 0, 0, "create", "req", "false", "noAuth");
            } else if (!com.tencent.pb.common.b.h.isNetworkConnected()) {
                c.i("TalkRoomService", "createTalkRoom isNetworkConnected is false");
                h.zL(-4003);
                h.a(SQLiteDatabase.KeyEmpty, str, 0, 0, "create", "req", "false", "noNetwork");
            } else if (bPi.bbD()) {
                if (bPi.bbD()) {
                    h.zL(-4002);
                }
                h.a(SQLiteDatabase.KeyEmpty, str, 0, 0, "create", "req", "false", "isBusy");
            } else if (TextUtils.isEmpty(str)) {
                c.i("TalkRoomService", "createTalkRoom cliendId is null");
                h.a(SQLiteDatabase.KeyEmpty, str, 0, 0, "create", "req", "false", "cliendIdnull");
            } else if (j.QW(str)) {
                if (c.bPu().QK(str) == null) {
                    c.bPu().a(str, str2, 0, 0, cM);
                }
                bPi.bPG();
                bPi.kF(false);
                bPi.bPD();
                if (bPi.bam()) {
                    bPi.pIq.bPN();
                    bPi.gpg = str;
                    bPi.pIC = str;
                    bPi.ppl = nextInt;
                    bPi.pIh = str;
                    bPi.setState(1);
                    bPi.ktR = true;
                    a aVar = new a(bPi);
                    aVar.lEs = bPi.gpg;
                    aVar.pIX = cM;
                    aVar.pIY = null;
                    aVar.ppV = nextInt;
                    aVar.type = 0;
                    aVar.pIZ = 0;
                    aVar.pJa = null;
                    aVar.pJb = false;
                    aVar.pJc = str2;
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = aVar;
                    bPi.mHandler.removeMessages(2);
                    TalkRoom QK = c.bPu().QK(bPi.gpg);
                    if (QK == null) {
                        c.i("TalkRoomManager", "isOnlyMySelfInGroup talkroom is null");
                    } else {
                        List bPo = QK.bPo();
                        if (bPo == null || bPo.size() != 1) {
                            c.i("TalkRoomManager", "isOnlyMySelfInGroup TalkRoomMember list is not match");
                        } else {
                            d dVar = (d) bPo.get(0);
                            if (dVar == null) {
                                c.i("TalkRoomManager", "isOnlyMySelfInGroup talkRoomMember is null");
                            } else {
                                boolean bPy = dVar.bPy();
                                c.i("TalkRoomManager", "isOnlyMySelfInGroup ret: ", Boolean.valueOf(bPy));
                            }
                        }
                    }
                    bPi.mHandler.sendMessage(obtain);
                    bPi.pIE = true;
                    c.i("TalkRoomSdkApi", "createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", com.tencent.pb.b.a.a.bMo(), " usrnameList: ", list);
                    return str == null;
                } else {
                    c.i("TalkRoomService", "createTalkRoom initEngine fail");
                    h.a(SQLiteDatabase.KeyEmpty, str, 0, 0, "create", "req", "false", "initEnginefail");
                    bPi.kF(false);
                }
            } else {
                c.i("TalkRoomService", "createTalkRoom groupId is not cliend id: ", str);
                h.a(SQLiteDatabase.KeyEmpty, str, 0, 0, "create", "req", "false", "isnotcliendId");
            }
        }
        str = null;
        c.i("TalkRoomSdkApi", "createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", com.tencent.pb.b.a.a.bMo(), " usrnameList: ", list);
        if (str == null) {
        }
    }

    public final boolean cp(String str, int i) {
        f bPi = a.bPi();
        c.i("TalkRoomSdkApi", "enterMultiTalk multiTalkGroupid:", str, " isAccept: ", Boolean.valueOf(true), " routId: ", Integer.valueOf(i), " ret: ", bPi.a(null, str, bPi.gLN, bPi.pIi, i, 1));
        if (bPi.a(null, str, bPi.gLN, bPi.pIi, i, 1) == b.OK) {
            return true;
        }
        return false;
    }

    public final boolean a(String str, int i, long j, int i2) {
        c.i("TalkRoomSdkApi", "enterMultiTalk multiTalkGroupid:", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " routId: ", Integer.valueOf(i2), " ret: ", a.bPi().a(null, str, i, j, i2, 100));
        return a.bPi().a(null, str, i, j, i2, 100) == b.OK;
    }

    public final boolean o(String str, List<String> list) {
        if (h.ed(str, a.bPi().gpg)) {
            boolean z;
            f bPi = a.bPi();
            String str2 = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "addrTalkRoomMember";
            objArr[1] = str;
            objArr[2] = Integer.valueOf(bPi.gLN);
            objArr[3] = Long.valueOf(bPi.pIi);
            objArr[4] = " users length: ";
            objArr[5] = Integer.valueOf(list == null ? 0 : list.size());
            c.i(str2, objArr);
            bPi.pIE = false;
            if (TextUtils.isEmpty(str) || list == null) {
                z = false;
            } else if (com.tencent.pb.common.b.h.isNetworkConnected()) {
                String[] cM = f.cM(list);
                if (cM.length <= 0) {
                    c.i("TalkRoomService", "addTalkRoomMember users is null");
                    z = false;
                } else {
                    z = com.tencent.pb.common.b.e.bLT().a(new com.tencent.wecall.talkroom.a.b(str, bPi.gLN, bPi.pIi, cM));
                    bPi.pIq.J("add", "req", String.valueOf(z), String.valueOf(bPi.state));
                }
            } else {
                c.i("TalkRoomService", "addTalkRoomMember isNetworkConnected is false");
                z = false;
            }
            c.i("TalkRoomSdkApi", "addMultiTalkMember ret: ", Boolean.valueOf(z));
            return z;
        }
        c.i("TalkRoomSdkApi", "addMultiTalkMember groupid is not same; multiTalkGroupid: ", str, a.bPi().gpg);
        return false;
    }

    public final boolean wN(String str) {
        if (h.ed(str, a.bPi().gpg)) {
            int i = a.bPi().gLN;
            long j = a.bPi().pIi;
            boolean O = a.bPi().O(str, 1, 100);
            c.i("TalkRoomSdkApi", "exitMultiTalk groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j));
            return O;
        }
        c.i("TalkRoomSdkApi", "exitMultiTalk groupid is not same; multiTalkGroupid: ", str, a.bPi().gpg);
        if (!a.bPi().QR(str)) {
            return false;
        }
        int i2;
        e QQ = a.bPi().QQ(str);
        f bPi = a.bPi();
        if (QQ == null) {
            i2 = 0;
        } else {
            i2 = QQ.gFG;
        }
        if (QQ == null) {
            j = 0;
        } else {
            j = QQ.gFH;
        }
        bPi.b(str, i2, j, 1);
        return false;
    }

    public final List<String> Qg(String str) {
        if (h.ed(str, a.bPi().gpg)) {
            TalkRoom QK = c.bPu().QK(str);
            if (QK == null) {
                c.i("TalkRoomManager", "getTalkingMember talkroom is null: groupId: ", str);
                return null;
            }
            List<d> bPp = QK.bPp();
            List<String> arrayList = new ArrayList();
            for (d dVar : bPp) {
                if (dVar != null) {
                    int i;
                    f bPi = a.bPi();
                    int bPx = dVar.bPx();
                    if (bPi.pIr != null) {
                        i = (com.tencent.pb.common.a.a.poK && bPi.pIr.pHK.GetVoiceActivity(bPx) == 1) ? 1 : 0;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        arrayList.add(dVar.bPw());
                    }
                }
            }
            return arrayList;
        }
        c.i("TalkRoomSdkApi", "getTalkingMember groupid is not same; multiTalkGroupid: ", str, a.bPi().gpg);
        return null;
    }

    public final boolean c(int i, int i2, int i3, byte[] bArr) {
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[8];
        objArr[0] = "handleMultiTalkResp retCode: ";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = " seq: ";
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = " cmdId: ";
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = " data length: ";
        objArr[7] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        c.i(str, objArr);
        if (i == 0) {
            f.bLW().n(i2, bArr);
        } else {
            f bLW = f.bLW();
            a yF = bLW.yF(i2);
            if (yF != null) {
                c.i("NETCMD", "CLTRCV FAIL", Integer.valueOf(i2), yF.ppA, Integer.valueOf(1), Integer.valueOf(i));
                bLW.a(yF, -1, null);
            }
        }
        return true;
    }

    public final boolean bv(byte[] bArr) {
        f.bLW();
        c.i("TalkRoomSdkApi", "handleMultiTalkNotify ret: ", Integer.valueOf(f.bu(bArr)));
        if (f.bu(bArr) == 0) {
            return true;
        }
        return false;
    }

    public final boolean kw(boolean z) {
        c.i("TalkRoomSdkApi", "holadMultiTalk isHold", Boolean.valueOf(z));
        f bPi;
        if (z) {
            bPi = a.bPi();
            c.d("TalkRoomService", "syscall", "startHoldOn");
            bPi.pIJ = true;
            bPi.kG(false);
            com.tencent.pb.common.c.i.S(new Runnable(bPi.pIy) {
                final /* synthetic */ g pJp;

                {
                    this.pJp = r1;
                }

                public final void run() {
                    synchronized (this.pJp.bXt) {
                        for (a bPA : this.pJp.bXt) {
                            bPA.bPA();
                        }
                    }
                }
            });
        } else {
            bPi = a.bPi();
            c.d("TalkRoomService", "syscall", "endHoldOn");
            bPi.pIJ = false;
            bPi.bPE();
            if (bPi.bbD() && bPi.gUW) {
                bPi.kG(true);
                com.tencent.pb.common.c.i.S(new Runnable(bPi.pIy) {
                    final /* synthetic */ g pJp;

                    {
                        this.pJp = r1;
                    }

                    public final void run() {
                        synchronized (this.pJp.bXt) {
                            for (a bPB : this.pJp.bXt) {
                                bPB.bPB();
                            }
                        }
                    }
                });
            }
        }
        return true;
    }

    public final String bMr() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("client_");
        stringBuilder.append(com.tencent.pb.b.a.a.bMo());
        stringBuilder.append("_");
        stringBuilder.append(System.currentTimeMillis());
        c.i("TalkRoomSdkApi", "genMultiTalkClientId clientId: ", stringBuilder.toString());
        return stringBuilder.toString();
    }

    public final void ay(int i, String str) {
        com.tencent.pb.b.a.a.yG(i);
        com.tencent.pb.b.a.a.Qf(str);
        c.i("TalkRoomSdkApi", "setWxUinAndUsrName uin: ", Integer.valueOf(i), " usrname: ", str);
    }

    public final int a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        b bVar = a.bPi().pIr;
        if (bVar == null) {
            c.i("TalkRoomSdkApi", "setMultiTalkAppCmd talkRoomContext is null");
            return -100;
        }
        talk com_tencent_mm_plugin_multi_talk = bVar.pHK;
        if (com_tencent_mm_plugin_multi_talk == null) {
            c.i("TalkRoomSdkApi", "setMultiTalkAppCmd engine is null");
            return -101;
        }
        c.i("TalkRoomSdkApi", "setMultiTalkAppCmd inputVolumeScale: ", Integer.valueOf(i), " inputVolumeScaleForSpeaker: ", Integer.valueOf(i2), " outputVolumeScale: ", Integer.valueOf(i3), " outputVolumeScaleForSpeaker: ", Integer.valueOf(i4), " ehanceHeadsetEC: ", Integer.valueOf(i5), " setECModeLevelForHeadSet: ", Integer.valueOf(i6), " setECModeLevelForSpeaker: ", Integer.valueOf(i7), " enableSpeakerEnhanceEC: ", Integer.valueOf(i8), " aecMode: ", Integer.valueOf(i9), " nsMode: ", Integer.valueOf(i10), " agcMode: ", Integer.valueOf(i11), " agctargetdb: ", Integer.valueOf(i12), " agcgaindb: ", Integer.valueOf(i13), " agcFlag: ", Integer.valueOf(i14));
        if (!com.tencent.pb.common.a.a.poK) {
            return -200;
        }
        byte[] bArr;
        if (com.tencent.pb.a.a.a.pmD) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[1] = (byte) 2;
            bArr[0] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
            com_tencent_mm_plugin_multi_talk.bV(419, 0);
            com_tencent_mm_plugin_multi_talk.bV(418, 4);
        } else if (com.tencent.pb.a.a.a.pmF || com.tencent.pb.a.a.a.pmE) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[1] = (byte) 4;
            bArr[0] = (byte) 4;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            bArr[1] = (byte) 6;
            bArr[0] = (byte) 6;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
            com_tencent_mm_plugin_multi_talk.bV(416, 1);
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
        } else if (com.tencent.pb.a.a.a.pnS) {
            com_tencent_mm_plugin_multi_talk.bV(416, 1);
        } else if (com.tencent.pb.a.a.a.pmG) {
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, new byte[]{(byte) 2, (byte) 2}, 2);
        } else if (com.tencent.pb.a.a.a.pmH) {
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, new byte[]{(byte) 2, (byte) 2}, 2);
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
            com_tencent_mm_plugin_multi_talk.bV(418, 4);
            com_tencent_mm_plugin_multi_talk.bV(416, 1);
        } else if (com.tencent.pb.a.a.a.poe) {
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
        } else if (com.tencent.pb.a.a.a.pmI) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 1;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
        } else if (com.tencent.pb.a.a.a.pnT) {
            com_tencent_mm_plugin_multi_talk.bV(416, 1);
            bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            bArr[2] = (byte) 12;
            bArr[3] = (byte) 9;
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr, 4);
            com_tencent_mm_plugin_multi_talk.bV(418, 4);
        } else if (com.tencent.pb.a.a.a.pmJ) {
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
        } else if (com.tencent.pb.a.a.a.pmK) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 1;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
            com_tencent_mm_plugin_multi_talk.bV(418, 4);
        } else if (com.tencent.pb.a.a.a.pmO) {
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 1;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
        } else if (com.tencent.pb.a.a.a.pmL) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            bArr[0] = (byte) 1;
            bArr[1] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
        } else if (com.tencent.pb.a.a.a.pmM) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
            bArr[0] = (byte) 1;
            bArr[1] = (byte) 2;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
        } else if (com.tencent.pb.a.a.a.pmN) {
            bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            bArr[2] = (byte) 15;
            bArr[3] = (byte) 9;
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr, 4);
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
        } else if (com.tencent.pb.a.a.a.pon) {
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, new byte[]{(byte) 0, (byte) 6}, 2);
            com_tencent_mm_plugin_multi_talk.bV(408, 2);
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
        } else if (com.tencent.pb.a.a.a.pmP) {
            com_tencent_mm_plugin_multi_talk.bV(417, 1);
            com_tencent_mm_plugin_multi_talk.bV(418, 2);
        } else if (com.tencent.pb.a.a.a.pmT) {
            bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
            bArr[0] = (byte) 2;
            bArr[1] = (byte) 2;
            bArr[2] = (byte) 3;
            bArr[3] = (byte) 9;
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr, 4);
            com_tencent_mm_plugin_multi_talk.bV(417, 3);
        } else if (com.tencent.pb.a.a.a.pmU) {
            com_tencent_mm_plugin_multi_talk.bV(419, 0);
            bArr = new byte[]{(byte) 0, (byte) 0};
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 3;
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
        } else if (com.tencent.pb.a.a.a.pmW) {
            bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
            bArr[0] = (byte) 3;
            bArr[1] = (byte) 2;
            bArr[2] = (byte) 12;
            bArr[3] = (byte) 9;
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr, 4);
        } else if (com.tencent.pb.a.a.a.pmX) {
            com_tencent_mm_plugin_multi_talk.bV(419, 0);
        } else {
            boolean z = com.tencent.pb.a.a.a.pmV;
        }
        if (i >= 0 || i2 >= 0) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            if (i >= 0) {
                bArr[0] = (byte) i;
            }
            if (i2 >= 0) {
                bArr[1] = (byte) i2;
            }
            com_tencent_mm_plugin_multi_talk.setAppCmd(414, bArr, 2);
        }
        if (i3 >= 0 || i4 >= 0) {
            bArr = new byte[]{(byte) 0, (byte) 0};
            if (i3 >= 0) {
                bArr[0] = (byte) i3;
            }
            if (i4 >= 0) {
                bArr[1] = (byte) i4;
            }
            com_tencent_mm_plugin_multi_talk.setAppCmd(415, bArr, 2);
        }
        if (i5 >= 0) {
            com_tencent_mm_plugin_multi_talk.bV(416, i5);
        }
        if (i6 >= 0) {
            com_tencent_mm_plugin_multi_talk.bV(417, i6);
        }
        if (i7 >= 0) {
            com_tencent_mm_plugin_multi_talk.bV(418, i7);
        }
        if (i8 >= 0) {
            com_tencent_mm_plugin_multi_talk.bV(419, i8);
        }
        if (i9 >= 0) {
            com_tencent_mm_plugin_multi_talk.bV(406, i9);
        } else if (i9 == -2) {
            com_tencent_mm_plugin_multi_talk.nl(407);
        }
        if (i10 >= 0) {
            com_tencent_mm_plugin_multi_talk.bV(408, i10);
        } else if (i10 == -2) {
            com_tencent_mm_plugin_multi_talk.nl(409);
        }
        if (i11 >= 0) {
            if (i12 >= 0 && i13 >= 0) {
                bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
                bArr[0] = (byte) i14;
                bArr[1] = (byte) i11;
                bArr[2] = (byte) i12;
                bArr[3] = (byte) i13;
                com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr, 4);
                c.d("VoipAdapterUtil", "setAppCmd:EMethodSetAgcOn:" + bArr[0] + " " + bArr[1]);
            }
        } else if (i11 == -2) {
            com_tencent_mm_plugin_multi_talk.nl(405);
        } else if (com.tencent.pb.a.a.a.poc) {
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, new byte[]{(byte) 3, (byte) 1, (byte) 6, (byte) 9}, 4);
            c.d("VoipAdapterUtil", "setAppCmd:EMethodSetAgcOn:" + bArr[0] + " " + bArr[1]);
        } else if (com.tencent.pb.a.a.a.pod) {
            com_tencent_mm_plugin_multi_talk.setAppCmd(TencentLocation.ERROR_UNKNOWN, new byte[]{(byte) 1, (byte) 2, (byte) 2, (byte) 9}, 4);
            c.d("VoipAdapterUtil", "setAppCmd:EMethodSetAgcOn:" + bArr[0] + " " + bArr[1]);
        }
        return 0;
    }

    public final boolean nn(int i) {
        if (a.bPi().bbD()) {
            c.d("TalkRoomSdkApi", "switchMultiTalkVideo action: ", Integer.valueOf(i));
            f bPi = a.bPi();
            if (TextUtils.isEmpty(bPi.gpg)) {
                c.i("TalkRoomService", "switchMultiTalkVideo mGroupId is null");
                return false;
            }
            bPi.pIp = i;
            c.d("TalkRoomService", "switchMultiTalkVideo ret: ", Boolean.valueOf(com.tencent.pb.common.b.e.bLT().a(new k(bPi.gpg, bPi.gLN, bPi.pIi, i))));
            return com.tencent.pb.common.b.e.bLT().a(new k(bPi.gpg, bPi.gLN, bPi.pIi, i));
        }
        c.i("TalkRoomSdkApi", "switchMultiTalkVideo isWorking is false");
        return false;
    }

    public final int a(byte[] bArr, short s, int i, int i2, int i3, int i4) {
        int SendVideo;
        f bPi = a.bPi();
        if (bPi.pIr != null) {
            c.d("TalkRoomService", "sendVideo ", Integer.valueOf(i), Integer.valueOf(i2));
            SendVideo = bPi.pIr.pHK.SendVideo(bArr, s, i, i2, i3, i4);
        } else {
            SendVideo = -1;
        }
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[12];
        objArr[0] = "sendVideo buffer size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Short.valueOf(s);
        objArr[4] = " w: ";
        objArr[5] = Integer.valueOf(i);
        objArr[6] = " h: ";
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = " format: ";
        objArr[9] = Integer.valueOf(i3);
        objArr[10] = " mode: ";
        objArr[11] = Integer.valueOf(i4);
        c.d(str, objArr);
        return SendVideo;
    }

    public final com.tencent.pb.talkroom.sdk.f u(int[] iArr) {
        com.tencent.pb.talkroom.sdk.f fVar;
        int i = 0;
        f bPi = a.bPi();
        if (bPi.pIr != null) {
            c.d("TalkRoomService", "receiveVideo");
            b bVar = bPi.pIr;
            com.tencent.pb.talkroom.sdk.f fVar2 = new com.tencent.pb.talkroom.sdk.f();
            if (iArr == null) {
                c.i("simon:TalkRoomContext", "receiveVideo imgBuffer is null");
                fVar = fVar2;
            } else {
                String str;
                String str2;
                Object[] objArr;
                fVar2.ret = bVar.pHK.videoDecode(iArr);
                fVar2.pth = iArr;
                fVar2.pti = bVar.pHK.field_remoteImgLength;
                fVar2.ptj = bVar.pHK.field_remoteImgWidth;
                fVar2.ptk = bVar.pHK.field_remoteImgHeight;
                fVar2.ptl = bVar.pHK.field_remoteImgChannel & 32767;
                c bPu = c.bPu();
                Object obj = a.bPi().gpg;
                int i2 = fVar2.ptl;
                if (TextUtils.isEmpty(obj)) {
                    c.i("TalkRoomManager", "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i2));
                } else {
                    TalkRoom QK = bPu.QK(obj);
                    if (QK == null) {
                        c.i("TalkRoomManager", "getUsrNameByMemberId talkRoom is null groupId: ", obj, " memberId: ", Integer.valueOf(i2));
                    } else {
                        for (aq aqVar : QK.bPr()) {
                            if (aqVar != null && aqVar.gGl == i2) {
                                c.d("TalkRoomManager", "getUsrNameByMemberId wxUserName:", aqVar.prp, " groupId: ", obj, " memberId: ", Integer.valueOf(i2));
                                if (aqVar.prp != null) {
                                    str = aqVar.prp;
                                    fVar2.ptf = str;
                                    str2 = "simon:TalkRoomContext";
                                    objArr = new Object[4];
                                    objArr[0] = "receiveVideo imgBuffer size:";
                                    objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                                    objArr[2] = " MultiTalkVideoDecodeInfo: ";
                                    objArr[3] = fVar2;
                                    c.d(str2, objArr);
                                    fVar = fVar2;
                                }
                            }
                        }
                    }
                }
                str = SQLiteDatabase.KeyEmpty;
                fVar2.ptf = str;
                str2 = "simon:TalkRoomContext";
                objArr = new Object[4];
                objArr[0] = "receiveVideo imgBuffer size:";
                if (iArr != null) {
                }
                objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                objArr[2] = " MultiTalkVideoDecodeInfo: ";
                objArr[3] = fVar2;
                c.d(str2, objArr);
                fVar = fVar2;
            }
        } else {
            fVar = new com.tencent.pb.talkroom.sdk.f();
        }
        String str3 = "TalkRoomSdkApi";
        Object[] objArr2 = new Object[4];
        objArr2[0] = "receiveVideo imgBuffer size: ";
        if (iArr != null) {
            i = iArr.length;
        }
        objArr2[1] = Integer.valueOf(i);
        objArr2[2] = " MultiTalkVideoDecodeInfo: ";
        objArr2[3] = fVar;
        c.d(str3, objArr2);
        return fVar;
    }

    public final g b(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr) {
        f bPi = a.bPi();
        g gVar = new g();
        if (bPi.pIr != null) {
            b bVar = bPi.pIr;
            int videoTrans = bVar.pHK.videoTrans(bArr, i, i2, i3, i4, iArr);
            gVar = new g();
            gVar.ptm = iArr;
            gVar.ptn = bVar.pHK.field_localImgWidth;
            gVar.pto = bVar.pHK.field_localImgHeight;
            gVar.ret = videoTrans;
        }
        c.d("TalkRoomService", "videoTrans ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), " multiTalkVideoRGBinfo: ", gVar, " engine: ", bPi.pIr);
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[11];
        objArr[0] = "videoTrans recordData size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " localImg size: ";
        objArr[5] = Integer.valueOf(iArr == null ? 0 : iArr.length);
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = Integer.valueOf(i4);
        objArr[9] = " multiTalkVideoRGBinfo: ";
        objArr[10] = gVar;
        c.d(str, objArr);
        return gVar;
    }

    public final int D(byte[] bArr, int i) {
        int i2;
        f bPi = a.bPi();
        if (bPi.pIr == null) {
            c.i("TalkRoomService", "setAppCmd type: ", Integer.valueOf(10), " engine is null");
            i2 = -1;
        } else {
            i2 = bPi.pIr.pHK.setAppCmd(10, bArr, i);
        }
        c.d("TalkRoomSdkApi", "setAppCmd type: ", Integer.valueOf(10), " paramLen: ", Integer.valueOf(i), " ret: ", Integer.valueOf(i2));
        return i2;
    }
}
