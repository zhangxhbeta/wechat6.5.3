package com.tencent.mm.plugin.backup.moveui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.lan_cs.Server;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.movemodel.g;
import com.tencent.mm.plugin.backup.movemodel.h.a;
import com.tencent.mm.plugin.backup.movemodel.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class BakMoveWaitUI extends MMActivity implements a, e {
    private m cEZ = new m.a(this) {
        final /* synthetic */ BakMoveWaitUI emm;

        {
            this.emm = r1;
        }

        public final void cI(int i) {
            v.d("MicroMsg.BakMoveWaitUI", "cdntra onNetworkChange st:%d ", Integer.valueOf(i));
            this.emm.eml = null;
        }
    };
    private PLong elg = new PLong();
    private PInt elh = new PInt();
    private TextView emf;
    private ImageView emg;
    private ArrayList<String> emh = null;
    private LinkedList<li> emi;
    private String emj;
    private ah emk;
    private String eml = SQLiteDatabase.KeyEmpty;
    private WakeLock wakeLock;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ak.uz()) {
            this.emh = getIntent().getStringArrayListExtra("selected_records_username");
            this.elg.value = getIntent().getLongExtra("selected_records_addupsize", -1);
            this.elh.value = getIntent().getIntExtra("selected_records_count", -1);
            if (this.emh == null || this.emh.size() < 0 || this.elg.value < 0 || this.elh.value <= 0) {
                finish();
                return;
            } else if (g.Tu() == null) {
                finish();
                return;
            } else {
                NI();
                v.d("MicroMsg.BakMoveWaitUI", "resetMoveServerAndBakScene begin");
                b.UQ().bl(true);
                b.UQ().a(this.emh, this.elg, this.elh);
                b.UQ().a(this);
                com.tencent.mm.plugin.backup.b.b.clear();
                com.tencent.mm.plugin.backup.b.b.a(b.UQ());
                com.tencent.mm.plugin.backup.b.b.a(b.UP());
                com.tencent.mm.plugin.backup.b.b.setMode(2);
                ak.vy().a(704, (e) this);
                ak.vy().a(1000, (e) this);
                ak.a(this.cEZ);
                b.Vm();
                this.emk = new ah(new ah.a(this) {
                    final /* synthetic */ BakMoveWaitUI emm;

                    {
                        this.emm = r1;
                    }

                    public final boolean oU() {
                        this.emm.Wv();
                        return true;
                    }
                }, true);
                this.emk.ea(5000);
                this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "My Lock");
                return;
            }
        }
        finish();
    }

    private void Wv() {
        String bw = com.tencent.mm.plugin.backup.g.g.bw(this);
        v.i("MicroMsg.BakMoveWaitUI", "newWifiName: " + bw + " preWifiName : " + this.eml);
        if (!bw.equals(this.eml) && ak.uz()) {
            this.eml = bw;
            if (!Ww()) {
                return;
            }
            if (ak.uG()) {
                v.d("MicroMsg.BakMoveWaitUI", "begin to netscene create QRCode offline");
                ak.vy().a(new com.tencent.mm.plugin.backup.movemodel.m(this.emi, this.emj), 0);
                return;
            }
            v.d("MicroMsg.BakMoveWaitUI", "begin to netscene create QRCode online");
            ak.vy().a(new l(this.emi, this.emj), 0);
        }
    }

    public final void NI() {
        vD(2131234983);
        this.emf = (TextView) findViewById(2131755532);
        this.emg = (ImageView) findViewById(2131755531);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakMoveWaitUI emm;

            {
                this.emm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.emm.finish();
                return true;
            }
        });
        com.tencent.mm.a.e.e(new File(b.Vj()));
        if (Ww()) {
            this.eml = null;
            Wv();
        }
    }

    private boolean Ww() {
        int i;
        this.emi = new LinkedList();
        PString pString = new PString();
        PInt pInt = new PInt();
        com.tencent.mm.plugin.backup.backupmodel.a UP = b.UP();
        UP.mode = 0;
        v.i("MicroMsg.BackupCEngine", "before server.stop");
        Java2C.stop();
        v.i("MicroMsg.BackupCEngine", "after server.stop");
        v.i("MicroMsg.BackupCEngine", "before server.start listener");
        Server.cmS = new Server.a(UP) {
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
                    this.eaf.a(true, 0, 10006, ("server readErr:" + e.toString()).getBytes());
                }
            }

            public final void vW() {
                this.eaf.a(true, 0, 10011, "server onDisconnect".getBytes());
            }

            public final void onConnect(String str, int i) {
                this.eaf.eac = str;
                this.eaf.ead = i;
            }
        };
        Object[] access$000 = Java2C.start();
        if (access$000 == null || access$000.length != 3) {
            v.e("MicroMsg.BackupCEngine", "listen error");
            i = 0;
        } else {
            v.i("MicroMsg.BackupCEngine", "server listen result: %d, %s, %d", access$000);
            if (((Integer) access$000[0]).intValue() != 1) {
                i = 0;
            } else {
                pString.value = (String) access$000[1];
                pInt.value = ((Integer) access$000[2]).intValue();
                UP.mode = 1;
                i = 1;
            }
        }
        if (i == 0) {
            io(2131231344);
            this.eml = SQLiteDatabase.KeyEmpty;
            return false;
        }
        v.i("MicroMsg.BakMoveWaitUI", "server listen result: %s, %d", pString.value, Integer.valueOf(pInt.value));
        this.emj = com.tencent.mm.plugin.backup.g.g.bw(this);
        v.i("MicroMsg.BakMoveWaitUI", "wifiName :%s", this.emj);
        if (be.kS(this.emj)) {
            io(2131231344);
            this.eml = SQLiteDatabase.KeyEmpty;
            return false;
        }
        li liVar = new li();
        liVar.mnP = pString.value;
        liVar.mnQ = new LinkedList();
        liVar.mnQ.add(Integer.valueOf(pInt.value));
        this.emi.add(liVar);
        return true;
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        if (i == 4) {
            finish();
            z = true;
        } else {
            z = super.onKeyDown(i, keyEvent);
        }
        return z;
    }

    public void onDestroy() {
        v.i("MicroMsg.BakMoveWaitUI", "BakMoveWaitUI onDestroy.");
        if (this.emk != null) {
            this.emk.QI();
        }
        b.UQ().a(null);
        ak.vy().b(704, (e) this);
        ak.vy().b(1000, (e) this);
        ak.b(this.cEZ);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        byte[] bArr = null;
        if (kVar.getType() == 704) {
            if (i == 0 && i2 == 0) {
                dw dwVar = (dw) ((l) kVar).cif.czl.czs;
                if (!(dwVar == null || dwVar.meJ == null)) {
                    bArr = dwVar.meJ.mQw.lVU;
                }
                if (bArr != null) {
                    this.emg.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.emf.setText(2131231346);
                    this.emf.setTextColor(this.nDR.nEl.getResources().getColor(2131689547));
                    return;
                }
                return;
            }
            v.i("MicroMsg.BakMoveWaitUI", "err: %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i2 == -100) {
                ak.vy().a(new com.tencent.mm.plugin.backup.movemodel.m(this.emi, this.emj), 0);
            } else {
                io(2131231345);
            }
        } else if (kVar.getType() != 1000) {
        } else {
            if (i == 0 && i2 == 0) {
                dv dvVar = ((com.tencent.mm.protocal.k.b) ((com.tencent.mm.plugin.backup.movemodel.m) kVar).cAt.ze()).lWL;
                v.i("MicroMsg.NetSceneBakChatCreateQRCodeOffline", "onGYNetEnd QRCodeUrl:%s", dvVar.meK);
                byte[] bArr2 = dvVar == null ? null : dvVar.meJ == null ? null : dvVar.meJ.mQw.lVU;
                if (bArr2 != null) {
                    this.emg.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                    this.emf.setText(2131231346);
                    this.emf.setTextColor(this.nDR.nEl.getResources().getColor(2131689547));
                    return;
                }
                return;
            }
            v.i("MicroMsg.BakMoveWaitUI", "err: %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            io(2131231345);
        }
    }

    private void io(int i) {
        this.emf.setText(i);
        this.emf.setTextColor(this.nDR.nEl.getResources().getColor(2131689960));
        this.emg.setImageResource(2130838807);
    }

    public void onResume() {
        super.onResume();
        this.wakeLock.acquire();
    }

    public void onPause() {
        super.onPause();
        this.wakeLock.release();
    }

    protected final int getLayoutId() {
        return 2130903154;
    }

    public final void Wp() {
        v.d("MicroMsg.BakMoveWaitUI", "onAuthOK. go to bakMoveOldUI.");
        startActivity(new Intent(this, BakMoveOldUI.class));
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
    }
}
