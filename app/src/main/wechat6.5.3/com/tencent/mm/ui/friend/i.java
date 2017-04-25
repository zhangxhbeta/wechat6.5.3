package com.tencent.mm.ui.friend;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.e.a.go;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class i extends ContentObserver implements e {
    private String bhT;
    private boolean cAv = false;
    private ContentResolver kRR;
    private boolean kRS = false;
    private boolean kRT = false;
    private String[] kRW;
    private Context mContext;
    private ProgressBar nKF;
    private h nKG = null;
    private ac nKH = new ac(this) {
        final /* synthetic */ i oPd;

        {
            this.oPd = r1;
        }

        public final void handleMessage(Message message) {
            if ((this.oPd.nKG == null || this.oPd.nKG.isShowing()) && !this.oPd.cAv) {
                i.c(this.oPd);
                this.oPd.nKF.setProgress(this.oPd.progress);
                if (this.oPd.progress < this.oPd.nKF.getMax() - 2) {
                    sendEmptyMessageDelayed(0, 1000);
                    return;
                }
                this.oPd.kRS = true;
                this.oPd.nKF.setIndeterminate(true);
                if (!this.oPd.kRT) {
                    if (this.oPd.nKG != null) {
                        this.oPd.nKG.dismiss();
                    }
                    this.oPd.vV(2);
                }
            }
        }
    };
    private u nLj;
    private String nOO;
    private final a oOT;
    private v oOU;
    private v oOV;
    private u oOW;
    private String oOX;
    private boolean oOY = false;
    private View oOZ;
    private String oPa = null;
    public boolean oPb = true;
    private int oPc;
    private int progress = 0;

    public interface a {
        void vV(int i);
    }

    public enum b {
        ;

        static {
            oPe = 1;
            oPf = 2;
            oPg = 3;
            oPh = new int[]{oPe, oPf, oPg};
        }
    }

    static /* synthetic */ int c(i iVar) {
        int i = iVar.progress + 1;
        iVar.progress = i;
        return i;
    }

    public i(int i, Context context, a aVar) {
        super(ac.fetchFreeHandler());
        this.oPc = i;
        this.oOY = false;
        this.mContext = context;
        this.kRW = this.mContext.getResources().getStringArray(2131296295);
        this.oOZ = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130904206, null);
        this.nKF = (ProgressBar) this.oOZ.findViewById(2131758671);
        this.oOT = aVar;
    }

    public final void Pv(String str) {
        if (this.oPc == b.oPf || this.oPc == b.oPg) {
            ak.vy().a(132, (e) this);
        } else {
            ak.vy().a(145, (e) this);
        }
        this.bhT = str;
        this.kRS = false;
        this.kRT = false;
        this.oOX = SQLiteDatabase.KeyEmpty;
        this.cAv = false;
        if (this.oPc == b.oPf || this.oPc == b.oPg) {
            int i = 1;
            if (this.oPc == b.oPg) {
                i = 18;
            }
            this.oOV = new v(this.bhT, i, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty);
            ak.vy().a(this.oOV, 0);
        } else {
            this.nLj = new u(this.bhT, this.oOY ? 8 : 5, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty);
            ak.vy().a(this.nLj, 0);
        }
        if (this.nKG == null) {
            this.nKG = g.a(this.mContext, false, this.mContext.getString(2131231440), this.oOZ, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, null, null);
        } else {
            this.nKG.show();
        }
        this.progress = 0;
        this.nKF.setIndeterminate(false);
        this.nKH.sendEmptyMessage(1000);
    }

    public final void recycle() {
        ak.vy().b(132, (e) this);
        ak.vy().b(145, (e) this);
        this.mContext = null;
        this.cAv = true;
        if (this.nKG != null) {
            this.nKG.dismiss();
        }
    }

    private boolean av(int i, String str) {
        switch (i) {
            case -214:
                com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                if (dm == null) {
                    return true;
                }
                dm.a(this.mContext, null, null);
                return true;
            case -74:
                g.a(this.mContext, 2131231398, 2131231164, null);
                return true;
            case -59:
                g.a(this.mContext, 2131231403, 2131231164, null);
                return true;
            case -57:
            case -1:
                Toast.makeText(this.mContext, 2131231042, 0).show();
                return true;
            case -43:
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
                this.cAv = true;
                if (b.oPf == this.oPc || this.oPc == b.oPg) {
                    ak.yW();
                    c.vf().set(4097, SQLiteDatabase.KeyEmpty);
                    ak.yW();
                    c.vf().set(6, this.bhT);
                    this.mContext.getApplicationContext();
                    com.tencent.mm.modelfriend.a.Ew();
                }
                vV(1);
                Toast.makeText(this.mContext, 2131231399, 0).show();
                return true;
            case -41:
                Toast.makeText(this.mContext, 2131231401, 0).show();
                return true;
            case -36:
                Toast.makeText(this.mContext, 2131231404, 0).show();
                return true;
            case -35:
                if (this.oPc == b.oPe) {
                    vV(3);
                    return true;
                }
                g.a(this.mContext, 2131231400, 2131231451, new OnClickListener(this) {
                    final /* synthetic */ i oPd;

                    {
                        this.oPd = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            case -34:
                Toast.makeText(this.mContext, 2131231402, 0).show();
                return true;
            case -4:
                if (this.oOY) {
                    vV(6);
                    return true;
                }
                break;
        }
        return false;
    }

    private void vV(int i) {
        if (this.oPc == b.oPf || this.oPc == b.oPg) {
            ak.vy().a(132, (e) this);
        } else {
            ak.vy().a(145, (e) this);
        }
        if (this.oOT != null) {
            this.oOT.vV(i);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (!kVar.equals(this.oOU) && !kVar.equals(this.oOV) && !kVar.equals(this.oOW) && !kVar.equals(this.nLj)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
        } else if (!this.cAv) {
            if (i == 1 || i == 2) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.SmsBindMobileObserver", "error net");
                if (this.nKG != null) {
                    this.nKG.dismiss();
                }
                vV(4);
            } else if (b.oPf == this.oPc && kVar.getType() == 132) {
                h(i, i2, str, kVar);
            } else if (b.oPg == this.oPc && kVar.getType() == 132) {
                h(i, i2, str, kVar);
            } else if (b.oPe == this.oPc && kVar.getType() == 145) {
                switch (((u) kVar).AG()) {
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                        if ((((u) kVar).AG() == 6 || ((u) kVar).AG() == 9) && this.nKG != null) {
                            this.nKG.dismiss();
                        }
                        int i3 = ((com.tencent.mm.protocal.n.b) ((u) kVar).cAt.ze()).lWZ.mgH;
                        if ((i == 0 && i2 == 0) || (i2 == -35 && i3 == 1)) {
                            if (((u) kVar).AG() == 6) {
                                this.oPa = ((u) kVar).Fi();
                                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.oPa);
                                vV(1);
                                return;
                            } else if (((u) kVar).AG() == 9) {
                                this.oPa = ((u) kVar).Fi();
                                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.oPa);
                                ((u) kVar).getUsername();
                                ((u) kVar).Fh();
                                return;
                            } else if (((u) kVar).AG() == 5 || ((u) kVar).AG() == 8) {
                                com.tencent.mm.sdk.platformtools.v.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.bhT);
                                if (((u) kVar).AG() == 5 && i2 == -35 && i3 == 1) {
                                    this.oOY = true;
                                    vV(5);
                                    return;
                                }
                                return;
                            }
                        }
                        if (((u) kVar).AG() == 6 || ((u) kVar).AG() == 9) {
                            if (this.nKG != null) {
                                this.nKG.dismiss();
                            }
                            this.cAv = true;
                            vV(2);
                            return;
                        } else if (av(i2, str)) {
                            if (this.nKG != null) {
                                this.nKG.dismiss();
                            }
                            this.cAv = true;
                            return;
                        } else {
                            this.cAv = true;
                            if (this.nKG != null) {
                                this.nKG.dismiss();
                            }
                            Toast.makeText(this.mContext, this.mContext.getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                            return;
                        }
                    default:
                        return;
                }
            } else {
                Assert.assertTrue("code path should not be here!", false);
            }
        }
    }

    private void h(int i, int i2, String str, k kVar) {
        switch (((v) kVar).AG()) {
            case 1:
            case 2:
            case android.support.v7.a.a.k.MG /*18*/:
            case 19:
                if ((((v) kVar).AG() == 2 || ((v) kVar).AG() == 19) && this.nKG != null) {
                    this.nKG.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (((v) kVar).AG() == 2 || ((v) kVar).AG() == 19) {
                        if (this.oPb) {
                            this.mContext.getApplicationContext();
                            com.tencent.mm.modelfriend.a.Ew();
                        }
                        vV(1);
                        return;
                    } else if (((v) kVar).AG() == 1 || ((v) kVar).AG() == 18) {
                        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.bhT);
                        return;
                    }
                }
                if (av(i2, str)) {
                    if (this.nKG != null) {
                        this.nKG.dismiss();
                    }
                    this.cAv = true;
                    return;
                } else if (((v) kVar).AG() == 2) {
                    if (this.nKG != null) {
                        this.nKG.dismiss();
                    }
                    this.cAv = true;
                    vV(2);
                    return;
                } else {
                    this.cAv = true;
                    if (this.nKG != null) {
                        this.nKG.dismiss();
                    }
                    com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                    if (dm != null) {
                        dm.a(this.mContext, null, null);
                        return;
                    }
                    Toast.makeText(this.mContext, this.mContext.getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                }
            default:
                return;
        }
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        if (this.mContext instanceof Activity) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SmsBindMobileObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a((Activity) this.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.mContext);
            if (!com.tencent.mm.pluginsdk.i.a.a((Activity) this.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                return;
            }
        }
        bBm();
    }

    public final void bBm() {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.SmsBindMobileObserver", "sms number:" + this.oOX);
        if (!this.kRS && !this.cAv && !this.kRT) {
            Uri parse = Uri.parse("content://sms/inbox");
            this.kRR = this.mContext.getContentResolver();
            String[] strArr = new String[]{"body", "_id", "date"};
            String bII = bII();
            if (bII != null && !bII.equals(SQLiteDatabase.KeyEmpty)) {
                Cursor query;
                try {
                    query = this.kRR.query(parse, strArr, bII, null, null);
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.SmsBindMobileObserver", "get sms failed");
                    com.tencent.mm.sdk.platformtools.v.a("MicroMsg.SmsBindMobileObserver", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    query = null;
                }
                if (query != null) {
                    int i = -1;
                    long j = 0;
                    while (query.moveToNext()) {
                        long j2 = query.getLong(2);
                        if (j2 > j) {
                            i = query.getPosition();
                            j = j2;
                        }
                    }
                    this.nOO = null;
                    if (i >= 0) {
                        String group;
                        this.kRT = true;
                        query.moveToPosition(i);
                        Matcher matcher = Pattern.compile("\\d{4,8}").matcher(query.getString(query.getColumnIndex("body")));
                        if (matcher.find()) {
                            group = matcher.group();
                        } else {
                            group = null;
                        }
                        this.nOO = group;
                        if (this.nKG != null) {
                            this.nKG.setCancelable(true);
                        }
                        if (this.oPc == b.oPf || this.oPc == b.oPg) {
                            com.tencent.mm.sdk.c.b gnVar = new gn();
                            gnVar.bfZ.context = this.mContext;
                            com.tencent.mm.sdk.c.a.nhr.z(gnVar);
                            String str = gnVar.bga.bgb;
                            gnVar = new go();
                            com.tencent.mm.sdk.c.a.nhr.z(gnVar);
                            this.oOU = new v(this.bhT, this.oPc == b.oPg ? 19 : 2, this.nOO, SQLiteDatabase.KeyEmpty, str, gnVar.bgc.bgd);
                            ak.vy().a(this.oOU, 0);
                        } else {
                            this.oOW = new u(this.bhT, this.oOY ? 9 : 6, this.nOO, 0, SQLiteDatabase.KeyEmpty);
                            ak.vy().a(this.oOW, 0);
                        }
                    }
                    query.close();
                }
            }
        }
    }

    private String bII() {
        String str = "( ";
        for (int i = 0; i < this.kRW.length; i++) {
            if (i == this.kRW.length - 1) {
                str = str + " body like \"%" + this.kRW[i] + "%\" ) ";
            } else {
                str = str + "body like \"%" + this.kRW[i] + "%\" or ";
            }
        }
        str = str + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.SmsBindMobileObserver", "sql where:" + str);
        return str;
    }
}
