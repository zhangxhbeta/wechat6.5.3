package com.tencent.mm.plugin.backup.backupmodel;

import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.n;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public final class d implements a {
    public static final byte[] eab = "GSMW".getBytes();
    private Socket dTP = null;
    private Boolean eaF = Boolean.valueOf(false);
    private ServerSocket eaG = null;
    private ac eaH = null;
    private ac eaI = new ac(Looper.getMainLooper());
    private DataOutputStream eaJ = null;
    private int eaK = 0;
    private int eaL = 0;
    private long eaM = 0;
    private Object lock = new Object();

    static /* synthetic */ void a(d dVar, int i) {
        v.i("MicroMsg.BackupJavaEngine", "doListen port:%d", Integer.valueOf(((i >> 8) & WebView.NORMAL_MODE_ALPHA) | ((i & WebView.NORMAL_MODE_ALPHA) << 8)));
        dVar.eaG = null;
        try {
            v.i("MicroMsg.BackupJavaEngine", "ip:" + InetAddress.getLocalHost().getHostAddress());
            try {
                v.i("MicroMsg.BackupJavaEngine", "before init ");
                dVar.eaG = new ServerSocket(r1);
                v.i("MicroMsg.BackupJavaEngine", "before accept server:  " + dVar.eaG.toString());
                dVar.dTP = dVar.eaG.accept();
                dVar.dTP.setKeepAlive(true);
                v.i("MicroMsg.BackupJavaEngine", "after accept client:  " + dVar.dTP.toString());
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(dVar.dTP.getInputStream()));
                dVar.eaJ = new DataOutputStream(new BufferedOutputStream(dVar.dTP.getOutputStream()));
                dVar.eaF = Boolean.valueOf(false);
                dVar.a(true, 0, CdnLogic.MediaType_FAVORITE_FILE, null);
                while (!dVar.eaF.booleanValue()) {
                    dVar.a(dataInputStream);
                }
            } catch (IOException e) {
                v.e("MicroMsg.BackupJavaEngine", "doListen %s", e);
                dVar.TA();
                dVar.a(true, 0, 10005, ("doListenErr " + e).getBytes());
            }
        } catch (Throwable e2) {
            v.a("MicroMsg.BackupJavaEngine", e2, "getHostAddress", new Object[0]);
        }
    }

    static /* synthetic */ void a(d dVar, String str, int i) {
        v.i("MicroMsg.BackupJavaEngine", "doConnect serverIp:%s, port:%d", str, Integer.valueOf(((i & WebView.NORMAL_MODE_ALPHA) << 8) | ((i >> 8) & WebView.NORMAL_MODE_ALPHA)));
        try {
            InetAddress byName = InetAddress.getByName(str);
            v.i("MicroMsg.BackupJavaEngine", "TCP  Connecting...");
            dVar.dTP = new Socket(byName, r0);
            dVar.dTP.setKeepAlive(true);
            v.i("MicroMsg.BackupJavaEngine", "TCP connected" + dVar.dTP.toString());
            dVar.eaJ = new DataOutputStream(new BufferedOutputStream(dVar.dTP.getOutputStream()));
            DataInputStream dataInputStream = new DataInputStream(dVar.dTP.getInputStream());
            dVar.eaF = Boolean.valueOf(false);
            dVar.a(true, 0, CdnLogic.MediaType_FAVORITE_VIDEO, null);
            while (!dVar.eaF.booleanValue()) {
                dVar.a(dataInputStream);
            }
        } catch (IOException e) {
            v.e("MicroMsg.BackupJavaEngine", "doConnect %s", e);
            dVar.TA();
            dVar.a(true, 0, 10004, ("doConnect " + e).getBytes());
        }
    }

    public d() {
        TB();
    }

    public final void b(final int i, final List<li> list) {
        v.i("MicroMsg.BackupJavaEngine", "connect type:%d", Integer.valueOf(i));
        TB();
        e.a(new Runnable(this) {
            final /* synthetic */ d eaO;

            public final void run() {
                switch (i) {
                    case 0:
                        d.a(this.eaO, ((Integer) ((li) list.get(0)).mnQ.getFirst()).intValue());
                        return;
                    case 1:
                        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
                        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                        int i = wifiManager.getDhcpInfo().netmask;
                        String str = (ipAddress & WebView.NORMAL_MODE_ALPHA) + "." + ((ipAddress >> 8) & WebView.NORMAL_MODE_ALPHA) + "." + ((ipAddress >> 16) & WebView.NORMAL_MODE_ALPHA) + "." + ((ipAddress >> 24) & WebView.NORMAL_MODE_ALPHA);
                        v.e("MicroMsg.BackupJavaEngine", "localip:%s, mask:%d", str, Integer.valueOf(i));
                        String str2 = null;
                        int i2 = 0;
                        for (li liVar : list) {
                            v.i("MicroMsg.BackupJavaEngine", "try ip:%s", liVar.mnP);
                            if (liVar.mnP != null) {
                                if (liVar.mnP.split("\\.").length >= 4) {
                                    int o = n.o(new byte[]{(byte) (be.getInt(liVar.mnP.split("\\.")[0], 0) & WebView.NORMAL_MODE_ALPHA), (byte) (be.getInt(liVar.mnP.split("\\.")[1], 0) & WebView.NORMAL_MODE_ALPHA), (byte) (be.getInt(liVar.mnP.split("\\.")[2], 0) & WebView.NORMAL_MODE_ALPHA), (byte) (be.getInt(liVar.mnP.split("\\.")[3], 0) & WebView.NORMAL_MODE_ALPHA)});
                                    if ((i & o) == (i & ipAddress)) {
                                        d.a(this.eaO, liVar.mnP, ((Integer) liVar.mnQ.getFirst()).intValue());
                                        return;
                                    }
                                    String str3;
                                    int intValue;
                                    if ((o & 65535) == (65535 & ipAddress)) {
                                        str3 = liVar.mnP;
                                        intValue = ((Integer) liVar.mnQ.getFirst()).intValue();
                                    } else {
                                        intValue = i2;
                                        str3 = str2;
                                    }
                                    str2 = str3;
                                    i2 = intValue;
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (str2 != null) {
                            v.w("MicroMsg.BackupJavaEngine", "try to connect to secondary:%s, port:%d", str2, Integer.valueOf(i2));
                            d.a(this.eaO, str2, i2);
                            return;
                        }
                        this.eaO.a(true, 0, 10009, String.format("not match ip mask:%d, localip:%s", new Object[]{Integer.valueOf(i), str}).getBytes());
                        v.e("MicroMsg.BackupJavaEngine", "not match ip mask:%d, localip:%s", Integer.valueOf(i), str);
                        return;
                    default:
                        return;
                }
            }
        }, "BakchatPcEngine_connect");
    }

    public final void Tz() {
        v.i("MicroMsg.BackupJavaEngine", "close connect");
        TA();
        a(true, 0, 10003, null);
    }

    private void TA() {
        this.eaK = 0;
        this.eaL = 0;
        this.eaM = 0;
        this.eaF = Boolean.valueOf(true);
        try {
            synchronized (this.lock) {
                if (this.eaJ != null) {
                    this.eaJ.close();
                }
            }
        } catch (Exception e) {
        }
        try {
            if (this.dTP != null) {
                this.dTP.close();
            }
        } catch (Exception e2) {
        }
    }

    private void a(boolean z, int i, int i2, byte[] bArr) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final byte[] bArr2 = bArr;
        this.eaI.post(new Runnable(this) {
            final /* synthetic */ d eaO;

            public final void run() {
                b.b(z2, i3, i4, bArr2);
            }
        });
    }

    public final void i(final int i, final byte[] bArr) {
        if (this.eaH != null) {
            M(bArr);
        } else {
            this.eaI.postDelayed(new Runnable(this) {
                final /* synthetic */ d eaO;

                public final void run() {
                    this.eaO.M(bArr);
                }
            }, 200);
        }
    }

    public final int j(int i, byte[] bArr) {
        return 0;
    }

    public final void M(final byte[] bArr) {
        if (this.eaF.booleanValue()) {
            v.e("MicroMsg.BackupJavaEngine", "engine has stop");
        } else {
            this.eaH.post(new Runnable(this) {
                final /* synthetic */ d eaO;

                public final void run() {
                    try {
                        synchronized (this.eaO.lock) {
                            this.eaO.eaJ.write(bArr);
                            this.eaO.eaJ.flush();
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.BackupJavaEngine", "send_error %s", e);
                        this.eaO.TA();
                        this.eaO.a(true, 0, 10008, ("send_error " + e).getBytes());
                    }
                }
            });
        }
    }

    private void TB() {
        if (this.eaH == null || !this.eaH.getLooper().getThread().isAlive()) {
            e.c(new Runnable(this) {
                final /* synthetic */ d eaO;

                {
                    this.eaO = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.eaO.eaH = new ac();
                    Looper.loop();
                }
            }, "BakchatPcEngine_handler").start();
        }
    }

    private void a(DataInputStream dataInputStream) {
        while (!this.eaF.booleanValue() && this.eaK != 4) {
            int i;
            try {
                if (eab[this.eaK] == dataInputStream.readByte()) {
                    this.eaK++;
                } else {
                    long Nh = be.Nh();
                    if (((long) this.eaL) - (Nh - this.eaM) < 10) {
                        if (this.eaL < 0) {
                            this.eaL = 0;
                        }
                        this.eaL++;
                        this.eaM = Nh;
                        i = 0;
                    } else {
                        boolean z = true;
                    }
                    if (i == 0) {
                        String format = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[]{Integer.valueOf(this.eaK + 1), Integer.valueOf(eab[this.eaK] & WebView.NORMAL_MODE_ALPHA), Integer.valueOf(r1 & WebView.NORMAL_MODE_ALPHA)});
                        v.e("MicroMsg.BackupJavaEngine", format);
                        a(true, 0, 10007, format.getBytes());
                    }
                    this.eaK = 0;
                }
            } catch (Exception e) {
                v.e("MicroMsg.BackupJavaEngine", "loopRead %s", e);
                try {
                    dataInputStream.close();
                } catch (IOException e2) {
                }
                if (!this.eaF.booleanValue()) {
                    a(true, 0, 10006, ("read_error " + e).getBytes());
                }
                TA();
                return;
            }
        }
        this.eaK = 0;
        int readInt = dataInputStream.readInt();
        short readShort = dataInputStream.readShort();
        short readShort2 = dataInputStream.readShort();
        int readInt2 = dataInputStream.readInt();
        if (readInt2 > 16777216) {
            format = String.format("loopRead size to large:%d", new Object[]{Integer.valueOf(readInt2)});
            v.e("MicroMsg.BackupJavaEngine", format);
            this.eaF = Boolean.valueOf(true);
            a(true, 0, 10007, format.getBytes());
            return;
        }
        int readInt3 = dataInputStream.readInt();
        v.i("MicroMsg.BackupJavaEngine", "read buf size:" + readInt2);
        byte[] bArr = new byte[(readInt2 - 20)];
        i = 0;
        while (i < bArr.length) {
            int read = dataInputStream.read(bArr, i, bArr.length - i);
            if (read == -1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                }
            } else {
                i += read;
            }
        }
        PByteArray pByteArray = new PByteArray();
        v.d("MicroMsg.BackupJavaEngine", "summerbak loopRead unpack ret[%d]", Integer.valueOf(e.a(eab, readInt, readShort, readShort2, readInt2, readInt3, bArr, pByteArray)));
        if (e.a(eab, readInt, readShort, readShort2, readInt2, readInt3, bArr, pByteArray) != 0) {
            a(true, 0, 10007, (pByteArray.value == null ? SQLiteDatabase.KeyEmpty : new String(pByteArray.value)).getBytes());
            return;
        }
        v.d("MicroMsg.BackupJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", Integer.valueOf(i), Integer.valueOf(readInt), Short.valueOf(readShort2));
        a(false, readInt, readShort2, pByteArray.value);
    }
}
