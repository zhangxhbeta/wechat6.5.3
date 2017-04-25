package com.tencent.mm.plugin.ipcall.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class j implements com.tencent.mm.plugin.ipcall.a.b.b.a, e {
    private ah aSW;
    boolean blA = false;
    TextView dtE;
    ImageView dtz;
    long gHk;
    DialPad gIX;
    String gLs;
    String gLt;
    String gLu;
    String gLv;
    int gLw;
    int gLx;
    Bitmap gOQ;
    EditText gOZ;
    TextView gPa;
    ImageView gPb;
    IPCallFuncButton gPc;
    IPCallFuncButton gPd;
    IPCallFuncButton gPe;
    ImageButton gPf;
    public TextView gPg;
    public View gPh;
    String gPi;
    IPCallTalkUI gPj;
    c gPk;
    a gPl;
    long gPm = -1;
    boolean gPn = false;
    boolean gPo = false;
    TelephonyManager gPp = null;
    private AudioManager gPq = null;
    boolean gPr = false;
    boolean gPs = false;
    private boolean gPt = true;
    boolean gPu = false;
    PhoneStateListener gPv = new PhoneStateListener(this) {
        final /* synthetic */ j gPx;

        {
            this.gPx = r1;
        }

        public final void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            v.d("MicroMsg.TalkUIController", "onCallStateChanged " + i);
            if (i == 2) {
                v.i("MicroMsg.TalkUIController", "system phone call state offhook, stop call");
                this.gPx.j(true, 31);
            }
        }
    };
    ah gPw = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ j gPx;

        {
            this.gPx = r1;
        }

        public final boolean oU() {
            IPCallTalkUI iPCallTalkUI = this.gPx.gPj;
            Object[] objArr = new Object[1];
            objArr[0] = String.format("%02d:%02d", new Object[]{Long.valueOf(be.ax(this.gPx.gHk) / 60), Long.valueOf(be.ax(this.gPx.gHk) % 60)});
            CharSequence string = iPCallTalkUI.getString(2131233363, objArr);
            Notification notification = new Builder(aa.getContext()).setTicker(this.gPx.gPj.getString(2131233362)).setWhen(System.currentTimeMillis()).setContentTitle(this.gPx.gPj.getString(2131233354)).setContentText(string).setContentIntent(PendingIntent.getActivity(aa.getContext(), 42, new Intent(this.gPx.gPj, IPCallTalkUI.class), 134217728)).getNotification();
            notification.icon = com.tencent.mm.ax.a.bmo();
            notification.flags |= 32;
            ak.oH().a(42, notification, false);
            return true;
        }
    }, true);
    String gpi;

    public interface a {
        void dQ(boolean z);
    }

    public j(IPCallTalkUI iPCallTalkUI) {
        this.gPj = iPCallTalkUI;
        this.gPk = new c();
        this.gPk.gEo = this;
        this.gPp = (TelephonyManager) iPCallTalkUI.getSystemService("phone");
    }

    private void b(String str, String str2, int i, String str3) {
        String str4;
        avv();
        if (!be.kS(str)) {
            str4 = str;
        } else if (be.kS(str3)) {
            str4 = this.gPj.getString(2131233341);
        } else {
            str4 = str3;
        }
        if (2 == i && str2 != null) {
            this.dtE.setText(str2);
        } else if (1 == i && str2 != null) {
            g.a(this.gPj, str2, str4, this.gPj.getString(2131233342), false, new OnClickListener(this) {
                final /* synthetic */ j gPx;

                {
                    this.gPx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.gPx.gPj.finish();
                }
            });
        }
    }

    final void vf(String str) {
        if (be.kS(this.gpi)) {
            bS(com.tencent.mm.plugin.ipcall.b.a.vp(str), "");
        } else {
            bS(this.gpi, com.tencent.mm.plugin.ipcall.b.a.vp(str));
        }
    }

    final void bS(String str, String str2) {
        this.gOZ.setText(str);
        if (!be.kS(str)) {
            this.gOZ.setSelection(this.gOZ.getText().length() - 1);
        }
        this.gPa.setText(str2);
    }

    public final void atK() {
        int i = 0;
        v.i("MicroMsg.TalkUIController", "onInviteSuccess");
        String str = i.aum().gFa.gGi;
        String str2 = i.aum().gFa.gGj;
        if (!(be.kS(str) || be.kS(str2) || str.equals(str2))) {
            v.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[]{str, str2});
            vf(i.aum().gFa.gGj);
        }
        v.i("MicroMsg.TalkUIController", "callFlag:" + i.aum().gFa.gFX);
        int i2 = i.aum().gFa.gFX;
        if ((i2 & 1) > 0 && (i2 & 2) > 0) {
            i = 1;
        }
        if (i != 0) {
            v.i("MicroMsg.TalkUIController", "isOutOfAreaActivity");
            g.a(this.gPj, 2131233404, 2131233405, 2131233403, 2131233402, true, null, new OnClickListener(this) {
                final /* synthetic */ j gPx;

                {
                    this.gPx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.i("MicroMsg.TalkUIController", "user choose end this call because isOutOfAreaActivity");
                    this.gPx.j(true, 0);
                }
            });
        }
    }

    public final void atL() {
        v.d("MicroMsg.TalkUIController", "onStartRing");
        if (i.auq().auh()) {
            this.gPn = this.gPe.isChecked();
            this.gPo = this.gPe.isChecked();
            i.aup().dE(this.gPe.isChecked());
        }
    }

    public final void atU() {
        v.d("MicroMsg.TalkUIController", "onUserAccept");
        this.blA = true;
        this.dtE.setText("");
        this.gHk = be.Nh();
        if (this.aSW == null) {
            this.aSW = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ j gPx;

                {
                    this.gPx = r1;
                }

                public final boolean oU() {
                    this.gPx.dtE.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(be.ax(this.gPx.gHk) / 60), Long.valueOf(be.ax(this.gPx.gHk) % 60)}));
                    return true;
                }
            }, true);
        }
        if (this.gHk != 0) {
            this.dtE.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(be.ax(this.gHk) / 60), Long.valueOf(be.ax(this.gHk) % 60)}));
            this.aSW.ea(1000);
        }
        if (i.auq().auh()) {
            this.gPn = this.gPe.isChecked();
            this.gPo = this.gPe.isChecked();
            i.aup().dE(this.gPe.isChecked());
        }
        if (i.auq().aui()) {
            i.aup().gGt.dJ(this.gPc.isChecked());
        }
        if (this.gPr) {
            avu();
            this.gPw.ea(1000);
            return;
        }
        ak.oH().cancel(42);
    }

    public final void atV() {
        v.d("MicroMsg.TalkUIController", "onOthersideShutdown");
        avv();
        this.dtE.setText(2131233396);
        if (this.aSW != null) {
            this.aSW.QI();
        }
        this.gPw.QI();
        ak.oH().cancel(42);
        if (this.gPl != null) {
            this.gPl.dQ(true);
        }
    }

    public final void b(int i, String str, String str2, int i2) {
        v.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[]{Integer.valueOf(i)});
        if (i2 == 1) {
            this.gPt = false;
        }
        if (i == 8) {
            if (i2 == 1) {
                String string;
                if (be.kS(str)) {
                    string = this.gPj.getString(2131233341);
                } else {
                    string = str;
                }
                g.a(this.gPj, false, str2, string, this.gPj.getString(2131233375), this.gPj.getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ j gPx;

                    {
                        this.gPx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.setClass(this.gPx.gPj, IPCallShareCouponUI.class);
                        this.gPx.gPj.startActivity(intent);
                        intent = new Intent();
                        intent.setClass(this.gPx.gPj, IPCallRechargeUI.class);
                        this.gPx.gPj.startActivity(intent);
                        this.gPx.gPj.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ j gPx;

                    {
                        this.gPx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.gPx.gPj.finish();
                    }
                });
            } else {
                b(str, str2, i2, this.gPj.getString(2131233340));
            }
        } else if (i != 10) {
            b(str, str2, i2, null);
        } else {
            b(str, str2, i2, null);
        }
        avt();
    }

    public final void e(String str, String str2, int i, int i2) {
        v.i("MicroMsg.TalkUIController", "onDisasterHappen:" + i2 + "s");
        Editor edit = this.gPj.getSharedPreferences("IPCall_LastInputPref", 0).edit();
        edit.putLong("IPCall_LastInvite", ((long) (i2 * BaseReportManager.MAX_READ_COUNT)) + System.currentTimeMillis());
        edit.apply();
        b(str, str2, i, null);
        avt();
    }

    final void j(boolean z, int i) {
        this.gPk.bL(i, 0);
        this.gPw.QI();
        ak.oH().cancel(42);
        if (this.aSW != null) {
            this.aSW.QI();
        }
        if (z) {
            this.gPj.finish();
        }
    }

    private void avt() {
        this.gPw.QI();
        ak.oH().cancel(42);
        if (this.aSW != null) {
            this.aSW.QI();
        }
        if (this.gPl != null && !this.gPu) {
            this.gPl.dQ(this.gPt);
        }
    }

    public final void dH(boolean z) {
        v.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[]{Boolean.valueOf(z)});
        if (!i.auq().auh()) {
            return;
        }
        if (z) {
            i.aup();
            this.gPn = com.tencent.mm.plugin.ipcall.a.b.a.qZ();
            i.aup().dE(false);
            this.gPe.dN(false);
            return;
        }
        i.aup().dE(this.gPn);
        this.gPe.dN(true);
        this.gPe.setChecked(this.gPn);
    }

    public final void dI(boolean z) {
        v.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[]{Boolean.valueOf(z)});
        if (!i.auq().auh()) {
            return;
        }
        if (z) {
            i.aup();
            this.gPo = com.tencent.mm.plugin.ipcall.a.b.a.qZ();
            i.aup().dE(false);
            this.gPe.dN(false);
            return;
        }
        i.aup().dE(this.gPo);
        this.gPe.dN(true);
        this.gPe.setChecked(this.gPo);
    }

    final void avu() {
        CharSequence string;
        if (i.auq().auj()) {
            IPCallTalkUI iPCallTalkUI = this.gPj;
            Object[] objArr = new Object[1];
            objArr[0] = String.format("%02d:%02d", new Object[]{Long.valueOf(be.ax(this.gHk) / 60), Long.valueOf(be.ax(this.gHk) % 60)});
            string = iPCallTalkUI.getString(2131233363, objArr);
        } else {
            string = this.gPj.getString(2131233362);
        }
        Intent intent = new Intent(this.gPj, IPCallTalkUI.class);
        intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        intent.putExtra("IPCallTalkUI_contactId", this.gLt);
        intent.putExtra("IPCallTalkUI_countryCode", this.gLu);
        intent.putExtra("IPCallTalkUI_nickname", this.gpi);
        intent.putExtra("IPCallTalkUI_phoneNumber", this.gLs);
        intent.putExtra("IPCallTalkUI_toWechatUsername", this.gLv);
        Notification notification = new Builder(aa.getContext()).setTicker(this.gPj.getString(2131233362)).setWhen(System.currentTimeMillis()).setContentTitle(this.gPj.getString(2131233354)).setContentText(string).setContentIntent(PendingIntent.getActivity(aa.getContext(), 42, intent, 134217728)).getNotification();
        notification.icon = com.tencent.mm.ax.a.bmo();
        notification.flags |= 32;
        ak.oH().a(42, notification, false);
    }

    public final void avv() {
        if (this.gPg != null) {
            this.gPg.setVisibility(4);
        }
        if (this.gPh != null) {
            this.gPh.setVisibility(4);
        }
    }
}
