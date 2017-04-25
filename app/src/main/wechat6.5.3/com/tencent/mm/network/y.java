package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.protocal.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;

public final class y {
    final a[] dmn = new a[100];

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int dmo;
        final /* synthetic */ int dmp;
        final /* synthetic */ y dmq;

        AnonymousClass1(y yVar, int i, int i2) {
            this.dmq = yVar;
            this.dmo = i;
            this.dmp = i2;
        }

        public final void run() {
            MMLogic.reportCGIServerError(this.dmo, this.dmp);
        }
    }

    private static class a {
        q dmr;
        k dms;
        c dmt;
        long startTime;
        int taskId;

        private a() {
        }
    }

    protected final void finalize() {
        reset();
        super.finalize();
    }

    final boolean Ml() {
        synchronized (this.dmn) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.dmn[i] != null && (701 == this.dmn[i].dmr.getType() || 702 == this.dmn[i].dmr.getType())) {
                        v.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.dmn[i].dmr.getType());
                        return true;
                    }
                } catch (Throwable e) {
                    this.dmn[i] = null;
                    v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", be.e(e), Integer.valueOf(i));
                }
                i++;
            }
            return false;
        }
    }

    final boolean Mm() {
        synchronized (this.dmn) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.dmn[i] != null && 1000 == this.dmn[i].dmr.getType()) {
                        v.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.dmn[i].dmr.getType());
                        return true;
                    }
                } catch (Throwable e) {
                    this.dmn[i] = null;
                    v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", be.e(e), Integer.valueOf(i));
                }
                i++;
            }
            return false;
        }
    }

    final q bm(boolean z) {
        synchronized (this.dmn) {
            int i = 0;
            q qVar = null;
            while (i < 100) {
                if (this.dmn[i] != null) {
                    if (z) {
                        try {
                            if (this.dmn[i].dmr instanceof com.tencent.mm.network.q.a) {
                                continue;
                            }
                        } catch (Throwable e) {
                            v.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", be.e(e));
                        }
                    }
                    if (z || (this.dmn[i].dmr instanceof com.tencent.mm.network.q.a)) {
                        if (701 == this.dmn[i].dmr.getType() || 702 == this.dmn[i].dmr.getType()) {
                            v.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.dmn[i].dmr.getType());
                            return null;
                        } else if (qVar == null) {
                            qVar = this.dmn[i].dmr;
                        } else {
                            continue;
                        }
                    }
                }
                i++;
            }
            return qVar;
        }
    }

    public final int Mn() {
        int i = 0;
        for (int i2 = 0; i2 < 100; i2++) {
            try {
                if (this.dmn[i2] != null) {
                    this.dmn[i2].dmr.getType();
                }
            } catch (Throwable e) {
                v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", be.e(e), Integer.valueOf(i2));
                i++;
                this.dmn[i2] = null;
            }
        }
        return i;
    }

    public final int a(q qVar, k kVar, c cVar, int i) {
        if (qVar == null) {
            v.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
            return -1;
        }
        int i2;
        qVar.hashCode();
        Task task = new Task();
        synchronized (this.dmn) {
            int i3 = 0;
            while (i3 < 100) {
                try {
                    if (this.dmn[i3] == null) {
                        this.dmn[i3] = new a();
                        this.dmn[i3].dmr = qVar;
                        this.dmn[i3].dms = kVar;
                        this.dmn[i3].dmt = cVar;
                        this.dmn[i3].startTime = be.Ni();
                        this.dmn[i3].taskId = task.taskID;
                        task.cmdID = qVar.Ce().getCmdId();
                        task.cgi = qVar.getUri();
                        int type = qVar.getType();
                        task.needAuthed = (qVar.Bu() & 1) != 1;
                        if (type == 126 || type == 701 || type == 702) {
                            task.needAuthed = false;
                            if (type == 701) {
                                task.retryCount = 1;
                            }
                        }
                        task.limitFlow = true;
                        if (type == 149 || type == 193 || type == 220 || type == 323 || type == 324 || type == 326 || type == 327) {
                            task.limitFlow = false;
                        }
                        task.channelStrategy = 0;
                        if (type == 233) {
                            task.channelStrategy = 1;
                        }
                        task.sendOnly = false;
                        if (type == 10 || type == 268369922) {
                            task.sendOnly = true;
                        }
                        if (qVar.Ce().Cd() && qVar.getUri() != null && qVar.getUri().length() > 0) {
                            task.channelSelect |= 1;
                        }
                        if (task.cmdID != 0) {
                            task.channelSelect |= 2;
                        }
                        task.reportArg = String.valueOf(type);
                        if (type == 522) {
                            task.totalTimeout = 300000;
                            task.priority = 0;
                        }
                        if (type == 710) {
                            task.totalTimeout = 15000;
                            task.serverProcessCost = 0;
                        }
                        v.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", Integer.valueOf(i3), Integer.valueOf(task.taskID), Integer.valueOf(qVar.BE()), Integer.valueOf(task.channelSelect), task.cgi, Boolean.valueOf(task.needAuthed));
                        i2 = i3;
                    } else {
                        i3++;
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", be.e(e));
                }
            }
            i2 = -1;
        }
        if (-1 != i2) {
            if (i == 1) {
                task.retryCount = 0;
            }
            StnLogic.startTask(task);
        } else {
            v.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        v.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=" + i2);
        return i2;
    }

    public final void reset() {
        v.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
        StnLogic.reset();
        synchronized (this.dmn) {
            for (int i = 0; i < 100; i++) {
                if (this.dmn[i] != null) {
                    try {
                        v.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i), Integer.valueOf(this.dmn[i].dmr.getType()), Integer.valueOf(this.dmn[i].dmr.BE()));
                        this.dmn[i] = null;
                    } catch (Throwable e) {
                        v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", be.e(e));
                    }
                }
            }
        }
    }

    public final void d(int i, int i2, String str) {
        v.i("MicroMsg.MMNativeNetTaskAdapter", "clearTaskAndCallback errType=" + i + ", errCode=" + i2 + ", errMsg=" + str);
        StnLogic.clearTask();
        a[] aVarArr = new a[100];
        synchronized (this.dmn) {
            for (int i3 = 0; i3 < 100; i3++) {
                aVarArr[i3] = this.dmn[i3];
                this.dmn[i3] = null;
            }
        }
        for (int i4 = 0; i4 < 100; i4++) {
            if (aVarArr[i4] != null) {
                try {
                    v.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi clearTaskAndCallback outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i4), Integer.valueOf(aVarArr[i4].dmr.getType()), Integer.valueOf(aVarArr[i4].dmr.BE()));
                    aVarArr[i4].dms.a(i4, i, i2, str, aVarArr[i4].dmr, null);
                } catch (Throwable e) {
                    v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", be.e(e));
                }
            }
        }
    }

    final int gC(int i) {
        int i2 = 0;
        synchronized (this.dmn) {
            int gD = gD(i);
            if (-1 == gD) {
                v.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
            } else {
                try {
                    i2 = this.dmn[gD].dmr.Cf().Ci();
                } catch (Throwable e) {
                    v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", be.e(e));
                }
            }
        }
        return i2;
    }

    final boolean a(int i, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        synchronized (this.dmn) {
            int gD = gD(i);
            if (-1 == gD) {
                return false;
            }
            boolean a;
            try {
                v.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s", Integer.valueOf(i2), Boolean.valueOf(this.dmn[gD].dmt.BS()), be.bn(this.dmn[gD].dmt.BP()));
                this.dmn[gD].dmr.Ce().B(this.dmn[gD].dmt.uT());
                this.dmn[gD].dmr.Ce().cW(this.dmn[gD].dmt.ww());
                a = this.dmn[gD].dmr.Ce().a(this.dmn[gD].dmr.getType(), this.dmn[gD].dmt.uT(), this.dmn[gD].dmt.BP(), this.dmn[gD].dmt.BR(), 0, this.dmn[gD].dmt.BS());
                if (a) {
                    byteArrayOutputStream.write(this.dmn[gD].dmr.Ce().BX());
                } else {
                    iArr[0] = 0;
                    b.itm.a(162, (long) iArr[0], 1, false);
                    v.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
                }
            } catch (Throwable e) {
                iArr[0] = 1;
                b.itm.a(162, (long) iArr[0], 1, false);
                v.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", be.e(e));
                a = false;
            } catch (Throwable e2) {
                iArr[0] = 2;
                b.itm.a(162, (long) iArr[0], 1, false);
                v.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", be.e(e2));
                a = false;
            } catch (Throwable e22) {
                iArr[0] = 3;
                b.itm.a(162, (long) iArr[0], 1, false);
                v.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", be.e(e22));
                a = false;
            }
            v.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", Boolean.valueOf(a));
            return a;
        }
    }

    final int a(int i, byte[] bArr, int[] iArr) {
        Throwable e;
        int i2 = -1;
        synchronized (this.dmn) {
            int gD = gD(i);
            if (-1 == gD) {
            } else {
                int i3 = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
                try {
                    byte[] Cb = this.dmn[gD].dmr.Ce().Cb();
                    i Cf = this.dmn[gD].dmr.Cf();
                    if (Cf.a(this.dmn[gD].dmr.getType(), bArr, Cb)) {
                        if (!(Cf.BP() == null || -13 != Cf.Ci() || z.Mx() == null)) {
                            z.Mx().Me();
                        }
                        if (-13 == Cf.Ci()) {
                            gD = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            try {
                                iArr[0] = Cf.Ci();
                                i2 = gD;
                            } catch (RemoteException e2) {
                                e = e2;
                                i3 = gD;
                                b.itm.a(162, 5, 1, false);
                                v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", be.e(e));
                                i2 = i3;
                                return i2;
                            } catch (Exception e3) {
                                e = e3;
                                i3 = gD;
                                b.itm.a(162, 7, 1, false);
                                v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", be.e(e));
                                i2 = i3;
                                return i2;
                            }
                        } else if (-3002 == Cf.Ci() || -3003 == Cf.Ci()) {
                            gD = StnLogic.RESP_FAIL_HANDLE_TASK_END;
                            iArr[0] = Cf.Ci();
                            i2 = gD;
                        } else if (-3001 == Cf.Ci()) {
                            gD = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
                            iArr[0] = Cf.Ci();
                            i2 = gD;
                        } else {
                            i2 = StnLogic.RESP_FAIL_HANDLE_NORMAL;
                        }
                    } else {
                        b.itm.a(162, 4, 1, false);
                        v.e("MicroMsg.MMNativeNetTaskAdapter", "buf to resp failed, change server and try again");
                        i2 = i3;
                    }
                } catch (RemoteException e4) {
                    e = e4;
                    b.itm.a(162, 5, 1, false);
                    v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", be.e(e));
                    i2 = i3;
                    return i2;
                } catch (Exception e5) {
                    e = e5;
                    b.itm.a(162, 7, 1, false);
                    v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", be.e(e));
                    i2 = i3;
                    return i2;
                }
            }
        }
        return i2;
    }

    final int gD(int i) {
        int i2 = 0;
        while (i2 < 100 && (this.dmn[i2] == null || i != this.dmn[i2].taskId)) {
            i2++;
        }
        if (100 <= i2) {
            return -1;
        }
        return i2;
    }
}
