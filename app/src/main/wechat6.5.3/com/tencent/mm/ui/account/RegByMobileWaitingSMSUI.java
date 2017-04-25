package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegByMobileWaitingSMSUI extends MMActivity {
    private String bhT;
    private ProgressBar elJ;
    private ListView eyT;
    private String ivg;
    private j nKI;
    private boolean nKJ;
    private com.tencent.mm.ui.account.j.a nKK = new com.tencent.mm.ui.account.j.a(this) {
        final /* synthetic */ RegByMobileWaitingSMSUI nLx;

        {
            this.nLx = r1;
        }

        public final void Oj(String str) {
            this.nLx.Oi(str.trim());
        }

        public final void bAX() {
            this.nLx.Oi(null);
        }
    };
    private TextView nLo;
    private CountDownTimer nLp;
    private int nLq = 30;
    private a nLr;
    private List<Integer> nLs = new ArrayList();
    String[] nLt = new String[]{"你好", "可以请你喝一杯吗？", "Здравствуйте!", "Darf ich Ihnen einen Drink ausgeben?", "Ich habe Gefühle für Dich.", "Bonjour!", "Prends soins de toi.", "?Hola! ", "Soy un ingeniero.", "Tu novio es un hombre bonito", "今日は!", "カッコいいですね", "Buona notte!", "Ayons une fête ce soir!", "Let's enjoy the holidays.", "Hello!"};
    private Drawable nLu;
    private List<Drawable> nLv = new ArrayList();
    private boolean nLw = false;

    private class a extends ArrayAdapter<String> {
        private final LayoutInflater gwU;
        final /* synthetic */ RegByMobileWaitingSMSUI nLx;
        private final ArrayList<String> nLz;

        public final /* synthetic */ void add(Object obj) {
            Ez((String) obj);
        }

        public final /* synthetic */ Object getItem(int i) {
            return hd(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int itemViewType = getItemViewType(i);
            if (view == null) {
                View inflate;
                b bVar2 = new b();
                switch (itemViewType) {
                    case 0:
                        inflate = this.gwU.inflate(2130903093, null);
                        break;
                    case 1:
                        inflate = this.gwU.inflate(2130903094, null);
                        break;
                    default:
                        throw new IllegalArgumentException("UNIMPLEMENT TYPE");
                }
                bVar2.nLA = (TextView) inflate.findViewById(2131755342);
                bVar2.cHH = (ImageView) inflate.findViewById(2131755340);
                inflate.setTag(bVar2);
                view = inflate;
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            int intValue = ((Integer) this.nLx.nLs.get(i % this.nLx.nLs.size())).intValue();
            switch (itemViewType) {
                case 0:
                    bVar.cHH.setImageDrawable((Drawable) this.nLx.nLv.get(intValue % this.nLx.nLv.size()));
                    break;
                case 1:
                    bVar.cHH.setImageDrawable(this.nLx.nLu);
                    break;
            }
            bVar.nLA.setText(hd(i));
            return view;
        }

        public final int getCount() {
            return this.nLz.size();
        }

        private String hd(int i) {
            return (String) this.nLz.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (((Integer) this.nLx.nLs.get(i % this.nLx.nLs.size())).intValue() % 4 == 0) {
                return 1;
            }
            return 0;
        }

        public final void Ez(String str) {
            this.nLz.add(str);
            notifyDataSetChanged();
        }
    }

    private class b {
        public ImageView cHH;
        public TextView nLA;
        final /* synthetic */ RegByMobileWaitingSMSUI nLx;

        private b(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI) {
            this.nLx = regByMobileWaitingSMSUI;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nLv.add(getResources().getDrawable(2130838364));
        this.nLv.add(getResources().getDrawable(2130838365));
        this.nLv.add(getResources().getDrawable(2130838366));
        this.nLv.add(getResources().getDrawable(2130838367));
        this.nLv.add(getResources().getDrawable(2130838368));
        this.nLv.add(getResources().getDrawable(2130838369));
        NI();
        this.nKI = new j(this, this.nKK);
        this.nKI.bBk();
        this.ivg = com.tencent.mm.plugin.a.b.Oa();
    }

    protected void onDestroy() {
        if (this.nKI != null) {
            this.nKI.bBl();
            this.nKI = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.a.b.b(true, ak.uR() + "," + getClass().getName() + ",RE200_250," + ak.dR("RE200_250") + ",1");
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.a.b.mh("RE200_250");
        if (this.nLw) {
            com.tencent.mm.plugin.a.b.mi(this.ivg);
        } else {
            com.tencent.mm.plugin.a.b.mi("RE200_300");
        }
        com.tencent.mm.plugin.a.b.b(false, ak.uR() + "," + getClass().getName() + ",RE200_250," + ak.dR("RE200_250") + ",2");
    }

    protected final void NI() {
        this.nLo = (TextView) findViewById(2131758325);
        this.elJ = (ProgressBar) findViewById(2131758326);
        this.eyT = (ListView) findViewById(2131758327);
        this.nKJ = false;
        String string = getString(2131231430);
        if (d.lWk) {
            string = getString(2131230720) + getString(2131230892);
        }
        Fd(string);
        this.bhT = getIntent().getExtras().getString("bindmcontact_mobile");
        this.bhT = al.Kq(this.bhT);
        this.nLq = getIntent().getIntExtra("mobileverify_countdownsec", this.nLq);
        Random random = new Random();
        for (int i = 0; i < this.nLq; i++) {
            this.nLs.add(Integer.valueOf(random.nextInt(BaseReportManager.MAX_READ_COUNT)));
        }
        int nextInt = random.nextInt(BaseReportManager.MAX_READ_COUNT) % this.nLv.size();
        this.nLu = (Drawable) this.nLv.get(nextInt);
        this.nLv.remove(nextInt);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileWaitingSMSUI nLx;

            {
                this.nLx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nLx.goBack();
                return true;
            }
        });
        al alVar = new al();
        string = "86";
        if (this.bhT.startsWith("+")) {
            this.bhT = this.bhT.replace("+", "");
            string = al.vl(this.bhT);
            if (string != null) {
                this.bhT = this.bhT.substring(string.length());
            }
        }
        CharSequence formatNumber = al.formatNumber(string, this.bhT);
        if (string == null || string.length() <= 0) {
            this.nLo.setText(formatNumber);
        } else {
            this.nLo.setText("+" + string + " " + formatNumber);
        }
        this.eyT.setVisibility(4);
        if (this.nLp == null) {
            this.nLp = new CountDownTimer(this, (long) (this.nLq * BaseReportManager.MAX_READ_COUNT)) {
                final /* synthetic */ RegByMobileWaitingSMSUI nLx;

                public final void onFinish() {
                    this.nLx.Oi(null);
                }

                public final void onTick(long j) {
                    int c = (int) (((long) this.nLx.nLq) - (j / 1000));
                    this.nLx.elJ.setProgress(c);
                    if (c % 2 == 0 && this.nLx.nLr != null) {
                        this.nLx.nLr.Ez(this.nLx.nLt[(c / 2) % this.nLx.nLt.length]);
                        this.nLx.eyT.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 nLy;

                            {
                                this.nLy = r1;
                            }

                            public final void run() {
                                if (VERSION.SDK_INT >= 8) {
                                    this.nLy.nLx.eyT.smoothScrollToPosition(this.nLy.nLx.nLr.getCount() - 1);
                                } else {
                                    this.nLy.nLx.eyT.setSelection(this.nLy.nLx.nLr.getCount() - 1);
                                }
                            }
                        });
                    }
                }
            };
            this.elJ.setMax(this.nLq);
            this.nLp.start();
        }
    }

    protected final int getLayoutId() {
        return 2130904090;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        g.b(this, getString(2131233865), "", getString(2131233866), getString(2131233867), new OnClickListener(this) {
            final /* synthetic */ RegByMobileWaitingSMSUI nLx;

            {
                this.nLx = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.nLx.nLw = true;
                this.nLx.finish();
            }
        }, new OnClickListener(this) {
            final /* synthetic */ RegByMobileWaitingSMSUI nLx;

            {
                this.nLx = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private synchronized void Oi(String str) {
        if (this.nKI != null) {
            this.nKI.bBl();
            this.nKI = null;
        }
        if (!(this.nLp == null || this.nLp == null)) {
            this.nLp.cancel();
            this.nLp = null;
        }
        if (!this.nKJ) {
            this.nKJ = true;
            Intent intent = getIntent();
            intent.putExtra("mobile_verify_purpose", 2);
            if (str != null && str.length() > 0) {
                intent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", str);
            }
            a(MobileVerifyUI.class, intent);
            finish();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            int i2;
            String str = "MicroMsg.RegByMobileWaitingSMSUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            if (iArr == null) {
                i2 = -1;
            } else {
                i2 = iArr.length;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = be.bur();
            v.w(str, str2, objArr);
            return;
        }
        v.i("MicroMsg.RegByMobileWaitingSMSUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 128:
                if (iArr[0] == 0 && this.nKI != null) {
                    this.nKI.bBm();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
