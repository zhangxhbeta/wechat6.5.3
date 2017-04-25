package com.tencent.mm.plugin.backup.backupmodel;

import android.os.HandlerThread;
import com.tencent.mm.lan_cs.Client;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public final class a implements com.tencent.mm.plugin.backup.b.b.a {
    public static final byte[] eab = "GSMW".getBytes();
    private String eac;
    private int ead;
    private ac eae = null;
    public int mode = 0;

    static /* synthetic */ void a(a aVar, byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[4];
        dataInputStream.read(bArr2);
        if (Arrays.equals(eab, bArr2)) {
            int readInt = dataInputStream.readInt();
            short readShort = dataInputStream.readShort();
            short readShort2 = dataInputStream.readShort();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 > 16777216) {
                String format = String.format("loopRead size too large, size:%d", new Object[]{Integer.valueOf(readInt2)});
                v.e("MicroMsg.BackupCEngine", format);
                aVar.a(true, readInt, 10007, format.getBytes());
                return;
            }
            int readInt3 = dataInputStream.readInt();
            v.i("MicroMsg.BackupCEngine", "read buf size:" + readInt2);
            byte[] bArr3 = new byte[(readInt2 - 20)];
            if (dataInputStream.read(bArr3) == bArr3.length) {
                PByteArray pByteArray = new PByteArray();
                if (e.a(eab, readInt, readShort, readShort2, readInt2, readInt3, bArr3, pByteArray) != 0) {
                    aVar.a(true, readInt, 10007, (pByteArray.value == null ? SQLiteDatabase.KeyEmpty : new String(pByteArray.value)).getBytes());
                } else {
                    aVar.a(false, readInt, readShort2, pByteArray.value);
                }
            }
        }
    }

    public final void connect(String str, int i) {
        this.mode = 2;
        this.eac = str;
        this.ead = i;
        Client.cmR = new com.tencent.mm.lan_cs.Client.a(this) {
            final /* synthetic */ a eaf;

            {
                this.eaf = r1;
            }

            public final void onRecv(String str, int i, byte[] bArr) {
                this.eaf.eac = str;
                this.eaf.ead = i;
                try {
                    a.a(this.eaf, bArr);
                } catch (IOException e) {
                    this.eaf.a(true, 0, 10006, ("client readErr:" + e.toString()).getBytes());
                }
            }

            public final void vW() {
                this.eaf.a(true, 0, 10011, "client onDisconnect".getBytes());
            }
        };
    }

    public final void stop() {
        v.i("MicroMsg.BackupCEngine", "summerbak BackupCEngine stop.");
        if (this.mode == 1) {
            Java2C.stop();
            this.mode = 0;
        } else if (this.mode == 2) {
            Client.Java2C.disconnect();
            b.TP();
            this.mode = 0;
        }
    }

    public final void Tt() {
        if (this.eae == null) {
            stop();
        } else {
            this.eae.postDelayed(new Runnable(this) {
                final /* synthetic */ a eaf;

                {
                    this.eaf = r1;
                }

                public final void run() {
                    this.eaf.stop();
                }
            }, 10);
        }
    }

    public final void i(int i, byte[] bArr) {
        final long Ni = be.Ni();
        v.v("MicroMsg.BackupCEngine", "send seq:%d buff:%d", Integer.valueOf(i), Integer.valueOf(be.bm(bArr)));
        if (this.eae == null || !this.eae.getLooper().getThread().isAlive()) {
            HandlerThread Lg = e.Lg("BackupCEngine_sendHandler");
            Lg.setPriority(10);
            Lg.start();
            this.eae = new ac(Lg.getLooper());
            v.w("MicroMsg.BackupCEngine", "BackupCEngine new writerHandler:%d", Long.valueOf(Lg.getId()));
        }
        final int i2 = i;
        final byte[] bArr2 = bArr;
        this.eae.post(new Runnable(this) {
            final /* synthetic */ a eaf;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r12 = this;
                r11 = 4;
                r10 = 3;
                r9 = 2;
                r8 = 1;
                r1 = 0;
                r2 = com.tencent.mm.sdk.platformtools.be.Ni();
                r0 = "MicroMsg.BackupCEngine";
                r4 = "before send server mode:%d  seq:%d  buff:%d time:[%d]";
                r5 = new java.lang.Object[r11];
                r6 = r12.eaf;
                r6 = r6.mode;
                r6 = java.lang.Integer.valueOf(r6);
                r5[r1] = r6;
                r6 = r2;
                r6 = java.lang.Integer.valueOf(r6);
                r5[r8] = r6;
                r6 = r3;
                r6 = com.tencent.mm.sdk.platformtools.be.bm(r6);
                r6 = java.lang.Integer.valueOf(r6);
                r5[r9] = r6;
                r6 = r4;
                r6 = r2 - r6;
                r6 = java.lang.Long.valueOf(r6);
                r5[r10] = r6;
                com.tencent.mm.sdk.platformtools.v.i(r0, r4, r5);
                r0 = r12.eaf;
                r0 = r0.mode;
                if (r0 != 0) goto L_0x0050;
            L_0x0046:
                r0 = "MicroMsg.BackupCEngine";
                r1 = "sendImp err mode!!";
                com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            L_0x004f:
                return;
            L_0x0050:
                r0 = r12.eaf;
                r0 = r0.mode;
                if (r0 != r8) goto L_0x00b4;
            L_0x0058:
                r0 = r12.eaf;
                r0 = r0.eac;
                r4 = r12.eaf;
                r4 = r4.ead;
                r5 = r3;
                r0 = com.tencent.mm.lan_cs.Server.Java2C.send(r0, r4, r5);
                if (r0 == 0) goto L_0x006c;
            L_0x006c:
                r4 = r2;
                r5 = r3;
                r5 = com.tencent.mm.sdk.platformtools.be.bm(r5);
                com.tencent.mm.plugin.backup.b.b.w(r0, r4, r5);
                r4 = "MicroMsg.BackupCEngine";
                r5 = "send result:%d seq:%d  buff:%d time[%d,%d]";
                r6 = 5;
                r6 = new java.lang.Object[r6];
                r0 = java.lang.Integer.valueOf(r0);
                r6[r1] = r0;
                r0 = r2;
                r0 = java.lang.Integer.valueOf(r0);
                r6[r8] = r0;
                r0 = r3;
                r0 = com.tencent.mm.sdk.platformtools.be.bm(r0);
                r0 = java.lang.Integer.valueOf(r0);
                r6[r9] = r0;
                r0 = r4;
                r0 = com.tencent.mm.sdk.platformtools.be.ay(r0);
                r0 = java.lang.Long.valueOf(r0);
                r6[r10] = r0;
                r0 = com.tencent.mm.sdk.platformtools.be.ay(r2);
                r0 = java.lang.Long.valueOf(r0);
                r6[r11] = r0;
                com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
                goto L_0x004f;
            L_0x00b4:
                r0 = r12.eaf;
                r0 = r0.mode;
                if (r0 != r9) goto L_0x00cf;
            L_0x00bc:
                r0 = r12.eaf;
                r0 = r0.eac;
                r4 = r12.eaf;
                r4 = r4.ead;
                r5 = r3;
                r0 = com.tencent.mm.lan_cs.Client.Java2C.send(r0, r4, r5);
                goto L_0x006c;
            L_0x00cf:
                r0 = r1;
                goto L_0x006c;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.backupmodel.a.4.run():void");
            }
        });
    }

    public final int j(int i, byte[] bArr) {
        long Ni = be.Ni();
        int send = Client.Java2C.send(this.eac, this.ead, bArr);
        b.w(send, i, be.bm(bArr));
        v.i("MicroMsg.BackupCEngine", "send result:%d seq:%d  buff:%d time[%d]", Integer.valueOf(send), Integer.valueOf(i), Integer.valueOf(be.bm(bArr)), Long.valueOf(be.ay(Ni)));
        return send;
    }

    private void a(boolean z, int i, int i2, byte[] bArr) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final byte[] bArr2 = bArr;
        ad.o(new Runnable(this) {
            final /* synthetic */ a eaf;

            public final void run() {
                b.b(z2, i3, i4, bArr2);
            }
        });
    }
}
