package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.protocal.c.bgj;
import com.tencent.mm.protocal.c.bgk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.h.a.a;
import com.tencent.mm.ui.h.a.b;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.v.e;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponCardUI extends MMActivity implements a, b, e {
    private int Dw = 0;
    private String can = null;
    private ProgressDialog dwR = null;
    private ProgressDialog gKB = null;
    private ImageView gNA = null;
    private ProgressBar gNB = null;
    private com.tencent.mm.plugin.ipcall.a.e.e gNC = new com.tencent.mm.plugin.ipcall.a.e.e();
    private String gND = null;
    private String gNE = null;
    private String gNF = null;
    private String gNG = null;
    private String gNH = null;
    private String gNI = null;
    private String gNJ = null;
    private String gNK = null;
    private String gNL = null;
    private bgk gNM = null;
    private String gNN = null;
    private View gNO;
    private TextView gNr;
    private TextView gNs;
    private TextView gNt;
    private TextView gNu;
    private Button gNv;
    private ImageView gNw;
    private com.tencent.mm.ui.h.a gNx = new com.tencent.mm.ui.h.a();
    private ProgressDialog gNy = null;
    private i gNz = null;
    private View iF;
    private String mTitle = null;

    static /* synthetic */ LinkedList a(IPCallShareCouponCardUI iPCallShareCouponCardUI, LinkedList linkedList) {
        v.i("MicroMsg.IPCallShareCouponCardUI", "CheckedShareList svr size =" + linkedList.size());
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(8));
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bgj com_tencent_mm_protocal_c_bgj = (bgj) it.next();
            ActionBarActivity actionBarActivity = iPCallShareCouponCardUI.nDR.nEl;
            int i = com_tencent_mm_protocal_c_bgj.aRI;
            boolean Z = (i == 8 || i == 0 || i == 1 || i == 2 || i == 3 || i == 5) ? true : i == 4 ? Z(actionBarActivity, "com.whatsapp") : i == 6 ? k.yf() : i == 7 ? Z(actionBarActivity, "com.facebook.orca") : false;
            if (Z) {
                linkedList2.add(Integer.valueOf(com_tencent_mm_protocal_c_bgj.aRI));
            }
        }
        v.i("MicroMsg.IPCallShareCouponCardUI", "CheckedShareList final size =" + linkedList2.size());
        return linkedList2;
    }

    static /* synthetic */ void a(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        iPCallShareCouponCardUI.gNC.start();
        iPCallShareCouponCardUI.gNC.gIb = (long) iPCallShareCouponCardUI.Dw;
        g.iuh.a(257, 19, 1, true);
        if (iPCallShareCouponCardUI.gNM != null) {
            f fVar = new f(iPCallShareCouponCardUI.nDR.nEl, f.pbR, true);
            fVar.c(iPCallShareCouponCardUI.getString(2131233440), 17);
            fVar.jXn = new c(iPCallShareCouponCardUI) {
                final /* synthetic */ IPCallShareCouponCardUI gNP;

                {
                    this.gNP = r1;
                }

                public final void a(l lVar) {
                    Iterator it = IPCallShareCouponCardUI.a(this.gNP, this.gNP.gNM.nbT).iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        CharSequence y = IPCallShareCouponCardUI.y(this.gNP.nDR.nEl, num.intValue());
                        int mi = IPCallShareCouponCardUI.mi(num.intValue());
                        if (!(y == null || mi == -1)) {
                            lVar.a(num.intValue(), y, mi);
                        }
                    }
                }
            };
            fVar.jXo = new d(iPCallShareCouponCardUI) {
                final /* synthetic */ IPCallShareCouponCardUI gNP;

                {
                    this.gNP = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    IPCallShareCouponCardUI.a(this.gNP, menuItem.getItemId());
                }
            };
            fVar.bKh();
        }
    }

    static /* synthetic */ void a(IPCallShareCouponCardUI iPCallShareCouponCardUI, int i) {
        String str = iPCallShareCouponCardUI.gNK + " " + iPCallShareCouponCardUI.gNN + String.format("&rt=%s", new Object[]{Integer.valueOf(i)});
        String str2;
        Intent intent;
        switch (i) {
            case 0:
                str = iPCallShareCouponCardUI.mTitle;
                str2 = iPCallShareCouponCardUI.gNG + String.format("&rt=%s", new Object[]{Integer.valueOf(i)});
                String str3 = iPCallShareCouponCardUI.can;
                String str4 = iPCallShareCouponCardUI.gNE;
                v.i("MicroMsg.IPCallShareCouponCardUI", "onShare2Friends>title:%s,onShare2Friends>url:%s,onShare2Friends>desc:%s,onShare2Friends>imgPath:%s", new Object[]{str, str2, str3, str4});
                iPCallShareCouponCardUI.gNC.gIc = 0;
                iPCallShareCouponCardUI.gNC.finish();
                g.iuh.a(257, 20, 1, true);
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_Type", 259);
                intent2.putExtra("select_is_ret", true);
                com.tencent.mm.ay.c.a(iPCallShareCouponCardUI, ".ui.transmit.SelectConversationUI", intent2, 1);
                break;
            case 1:
                str = iPCallShareCouponCardUI.mTitle;
                String str5 = iPCallShareCouponCardUI.gNG + String.format("&rt=%s", new Object[]{Integer.valueOf(i)});
                str2 = iPCallShareCouponCardUI.can;
                v.i("MicroMsg.IPCallShareCouponCardUI", "onShareSnsEvent>title:%s,onShareSnsEvent>url:%s,onShareSnsEvent>content:%s,onShareSnsEvent>content:%s", new Object[]{str, str5, str2, iPCallShareCouponCardUI.gNE});
                iPCallShareCouponCardUI.gNC.gIc = 1;
                iPCallShareCouponCardUI.gNC.finish();
                g.iuh.a(257, 21, 1, true);
                intent = new Intent();
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("need_result", false);
                intent.putExtra("Ksnsupload_title", be.ah(str, ""));
                intent.putExtra("Ksnsupload_imgurl", r10);
                intent.putExtra("Ksnsupload_link", str5);
                str = o.fz("wechat_out");
                o.yx().n(str, true).l("prePublishId", "wechat_out");
                intent.putExtra("reportSessionId", str);
                com.tencent.mm.ay.c.b(iPCallShareCouponCardUI, "sns", ".ui.SnsUploadUI", intent, 1);
                break;
            case 2:
                intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("sms_body", str);
                intent.setType("vnd.android-dir/mms-sms");
                if (!be.m(iPCallShareCouponCardUI, intent)) {
                    Toast.makeText(iPCallShareCouponCardUI, 2131234877, 1).show();
                    break;
                } else {
                    iPCallShareCouponCardUI.startActivity(intent);
                    break;
                }
            case 3:
                intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.SUBJECT", String.format(iPCallShareCouponCardUI.getString(2131233435), new Object[]{k.xH()}));
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.setType("plain/text");
                iPCallShareCouponCardUI.startActivity(Intent.createChooser(intent, iPCallShareCouponCardUI.getString(2131233314)));
                break;
            case 4:
                try {
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    iPCallShareCouponCardUI.startActivity(intent);
                    break;
                } catch (Exception e) {
                    v.e("MicroMsg.IPCallShareCouponCardUI", "go whatsapp error" + e.getMessage());
                    break;
                }
            case 5:
                if (!iPCallShareCouponCardUI.gNx.bJR()) {
                    com.tencent.mm.ui.base.g.a(iPCallShareCouponCardUI.nDR.nEl, 2131235184, 2131231164, new OnClickListener(iPCallShareCouponCardUI) {
                        final /* synthetic */ IPCallShareCouponCardUI gNP;

                        {
                            this.gNP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            IPCallShareCouponCardUI iPCallShareCouponCardUI = this.gNP;
                            ActionBarActivity actionBarActivity = this.gNP.nDR.nEl;
                            this.gNP.nDR.nEl.getString(2131231164);
                            iPCallShareCouponCardUI.gNy = com.tencent.mm.ui.base.g.a(actionBarActivity, this.gNP.nDR.nEl.getString(2131235701), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass16 gNX;

                                {
                                    this.gNX = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                }
                            });
                            this.gNP.gNx.a(this.gNP, this.gNP.nDR.nEl);
                        }
                    }, new OnClickListener(iPCallShareCouponCardUI) {
                        final /* synthetic */ IPCallShareCouponCardUI gNP;

                        {
                            this.gNP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
                } else {
                    iPCallShareCouponCardUI.n(16, str, iPCallShareCouponCardUI.getString(2131233316));
                    break;
                }
            case 6:
                if (!k.yh()) {
                    com.tencent.mm.ui.base.g.a(iPCallShareCouponCardUI.nDR.nEl, 2131235011, 2131231164, new OnClickListener(iPCallShareCouponCardUI) {
                        final /* synthetic */ IPCallShareCouponCardUI gNP;

                        {
                            this.gNP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.ay.c.a(this.gNP.nDR.nEl, ".ui.account.FacebookAuthUI", new Intent());
                        }
                    }, new OnClickListener(iPCallShareCouponCardUI) {
                        final /* synthetic */ IPCallShareCouponCardUI gNP;

                        {
                            this.gNP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
                } else {
                    iPCallShareCouponCardUI.n(8, str, iPCallShareCouponCardUI.getString(2131233311));
                    break;
                }
            case 7:
                try {
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.setType("text/plain");
                    intent.setPackage("com.facebook.orca");
                    iPCallShareCouponCardUI.startActivity(intent);
                    break;
                } catch (Exception e2) {
                    v.e("MicroMsg.IPCallShareCouponCardUI", "go facebook msger error" + e2.getMessage());
                    break;
                }
            case 8:
                com.tencent.mm.plugin.ipcall.b.c.c(iPCallShareCouponCardUI, str);
                Toast.makeText(iPCallShareCouponCardUI, 2131233382, 0).show();
                break;
        }
        g.iuh.h(13340, new Object[]{Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1)});
    }

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131233437);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallShareCouponCardUI gNP;

            {
                this.gNP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gNP.finish();
                return true;
            }
        });
        this.iF = findViewById(2131757519);
        this.gNr = (TextView) findViewById(2131757524);
        this.gNs = (TextView) findViewById(2131757525);
        this.gNt = (TextView) findViewById(2131757527);
        this.gNu = (TextView) findViewById(2131757528);
        this.gNv = (Button) findViewById(2131757529);
        this.gNw = (ImageView) findViewById(2131755306);
        this.iF.setVisibility(8);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.gNw, k.xF(), 0.5f, false);
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.gKB = com.tencent.mm.ui.base.g.a(actionBarActivity, getString(2131233361), true, new OnCancelListener(this) {
            final /* synthetic */ IPCallShareCouponCardUI gNP;

            {
                this.gNP = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                try {
                    this.gNP.finish();
                } catch (Exception e) {
                    v.e("MicroMsg.IPCallShareCouponCardUI", "loadFromSystemAddressBook error: %s", new Object[]{e.getMessage()});
                }
            }
        });
        com.tencent.mm.plugin.ipcall.a.f.b.auP().dK(false);
        this.Dw = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
        ak.vy().a(257, this);
        ak.vy().a(1804, this);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(257, this);
        ak.vy().b(1804, this);
    }

    protected final int getLayoutId() {
        return 2130903820;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.ipcall.a.d.e) {
            if (i == 0 && i2 == 0) {
                this.iF.setVisibility(0);
                aau avE = com.tencent.mm.plugin.ipcall.b.c.avE();
                this.gND = avE.mCd;
                this.can = avE.gkC;
                this.gNE = avE.mCe;
                this.mTitle = avE.aXz;
                this.gNF = avE.gIE;
                this.gNG = avE.mCf;
                this.gNI = avE.mCg;
                this.gNJ = avE.mCh;
                this.gNK = avE.mCi;
                this.gNL = avE.mCk;
                this.gNM = avE.mCj;
                this.gNN = avE.mCl;
                this.gNr.setText(this.gNL);
                this.gNs.setText(String.format(this.nDR.nEl.getString(2131233430), new Object[]{this.gND}));
                this.gNv.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ IPCallShareCouponCardUI gNP;

                    {
                        this.gNP = r1;
                    }

                    public final void onClick(View view) {
                        IPCallShareCouponCardUI.a(this.gNP);
                    }
                });
                this.gNt.setText(String.format(getString(2131233432), new Object[]{this.gNL}));
                TextView textView = this.gNu;
                String format = String.format(getString(2131233431), new Object[]{this.gNL});
                final String string = getString(2131233436);
                if (be.kS(string)) {
                    textView.setText(format);
                } else {
                    String str2;
                    String string2 = getString(2131233438);
                    TextPaint paint = textView.getPaint();
                    float measureText = paint.measureText(format);
                    float measureText2 = paint.measureText(string2);
                    int dv = com.tencent.mm.bd.a.dv(this.nDR.nEl) - (((LayoutParams) textView.getLayoutParams()).rightMargin + ((LayoutParams) textView.getLayoutParams()).leftMargin);
                    int ceil = (int) Math.ceil((double) (measureText / ((float) dv)));
                    int ceil2 = (int) Math.ceil((double) ((measureText + measureText2) / ((float) dv)));
                    if (ceil == 0) {
                        ceil = 1;
                    }
                    if (ceil2 > ceil) {
                        str2 = "\n" + string2;
                    } else {
                        str2 = string2;
                    }
                    textView.setGravity(17);
                    CharSequence newSpannable = Factory.getInstance().newSpannable(format + str2);
                    newSpannable.setSpan(new ClickableSpan(this) {
                        final /* synthetic */ IPCallShareCouponCardUI gNP;

                        public final void onClick(View view) {
                            ((TextView) view).setHighlightColor(this.gNP.getResources().getColor(2131690078));
                            g.iuh.h(13340, new Object[]{Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1)});
                            com.tencent.mm.ui.base.g.A(this.gNP.nDR.nEl, string, this.gNP.getString(2131233439)).a(2131233342, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass6 gNV;

                                {
                                    this.gNV = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(this.gNP.getResources().getColor(2131689819));
                            textPaint.setUnderlineText(false);
                        }
                    }, format.length(), str2.length() + format.length(), 33);
                    textView.setText(newSpannable);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                if (this.gKB != null && this.gKB.isShowing()) {
                    this.gKB.dismiss();
                }
            } else if (this.gKB != null && this.gKB.isShowing()) {
                this.gKB.dismiss();
                com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131233359), getString(2131233354), new OnClickListener(this) {
                    final /* synthetic */ IPCallShareCouponCardUI gNP;

                    {
                        this.gNP = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.gNP.finish();
                    }
                });
            }
        } else if (kVar instanceof h) {
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            if (!com.tencent.mm.plugin.subapp.b.drq.b(this.nDR.nEl, i, i2, str)) {
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.ui.base.g.bf(this, getResources().getString(2131231978));
                } else {
                    com.tencent.mm.ui.base.g.f(this.nDR.nEl, 2131234920, 2131231164);
                }
            }
        } else if ((kVar instanceof com.tencent.mm.am.a) && i == 0 && i2 == 0 && this.gNA != null) {
            if (this.gNB != null) {
                this.gNB.setVisibility(8);
            }
            this.gNA.setImageBitmap(avp());
        }
    }

    public static void a(Context context, int i, TextView textView, ImageView imageView) {
        CharSequence y = y(context, i);
        if (y != null) {
            textView.setText(y);
        }
        int mi = mi(i);
        if (mi != -1) {
            imageView.setImageResource(mi);
        }
    }

    public static String y(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), context.getString(2131233383));
        hashMap.put(Integer.valueOf(0), context.getString(2131236651));
        hashMap.put(Integer.valueOf(1), context.getString(2131233388));
        hashMap.put(Integer.valueOf(3), context.getString(2131233384));
        hashMap.put(Integer.valueOf(2), context.getString(2131233387));
        hashMap.put(Integer.valueOf(5), context.getString(2131233389));
        hashMap.put(Integer.valueOf(4), context.getString(2131233390));
        hashMap.put(Integer.valueOf(6), context.getString(2131233386));
        hashMap.put(Integer.valueOf(7), context.getString(2131233385));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return (String) hashMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public static int mi(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), Integer.valueOf(2131165310));
        hashMap.put(Integer.valueOf(0), Integer.valueOf(2131165349));
        hashMap.put(Integer.valueOf(1), Integer.valueOf(2131165348));
        hashMap.put(Integer.valueOf(3), Integer.valueOf(2131165311));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(2131165350));
        hashMap.put(Integer.valueOf(5), Integer.valueOf(2131165351));
        hashMap.put(Integer.valueOf(4), Integer.valueOf(2131165352));
        hashMap.put(Integer.valueOf(6), Integer.valueOf(2131165312));
        hashMap.put(Integer.valueOf(7), Integer.valueOf(2131165347));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return ((Integer) hashMap.get(Integer.valueOf(i))).intValue();
        }
        return -1;
    }

    private static boolean Z(Context context, String str) {
        if (be.kS(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public final void a(com.tencent.mm.ui.h.a.c cVar) {
        if (this.gNy != null) {
            this.gNy.cancel();
        }
        switch (cVar) {
            case Finished:
                mj(2131235703);
                return;
            case Failed:
                mj(2131235702);
                return;
            default:
                return;
        }
    }

    private void mj(int i) {
        com.tencent.mm.ui.base.g.a(this.nDR.nEl, i, 2131231164, new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponCardUI gNP;

            {
                this.gNP = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponCardUI gNP;

            {
                this.gNP = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void b(com.tencent.mm.ui.h.a.c cVar) {
    }

    private static Bitmap avp() {
        byte[] vc = vc(k.xF());
        if (vc == null) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.d.bc(vc);
    }

    private static byte[] vc(String str) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        ak.yW();
        String wP = com.tencent.mm.model.c.wP();
        ak.yW();
        try {
            randomAccessFile = new RandomAccessFile(com.tencent.mm.sdk.platformtools.h.e(wP, com.tencent.mm.model.c.wQ(), "qr_", com.tencent.mm.a.g.m(str.getBytes()), ".png"), "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (Exception e2) {
                    return bArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    v.a("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            v.a("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e;
        }
    }

    private void n(final int i, final String str, String str2) {
        this.gNO = View.inflate(this.nDR.nEl, 2130903397, null);
        final EditText editText = (EditText) this.gNO.findViewById(2131756405);
        this.gNA = (ImageView) this.gNO.findViewById(2131756404);
        this.gNB = (ProgressBar) this.gNO.findViewById(2131755522);
        editText.setText(str);
        Bitmap avp = avp();
        if (avp == null) {
            String xF = k.xF();
            ak.yW();
            ak.vy().a(new com.tencent.mm.am.a(xF, be.f((Integer) com.tencent.mm.model.c.vf().get(66561, null))), 0);
            this.gNB.setVisibility(0);
        } else if (this.gNA != null) {
            this.gNA.setImageBitmap(avp);
        }
        com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, str2, this.gNO, getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.b(this) {
            final /* synthetic */ IPCallShareCouponCardUI gNP;

            public final void dP(boolean z) {
                if (z) {
                    final h hVar = new h(i, editText == null ? str : editText.getText().toString());
                    IPCallShareCouponCardUI iPCallShareCouponCardUI = this.gNP;
                    Object obj = this.gNP;
                    this.gNP.getString(2131231164);
                    iPCallShareCouponCardUI.dwR = com.tencent.mm.ui.base.g.a(obj, this.gNP.getString(2131231151), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass5 gNT;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(hVar);
                        }
                    });
                    ak.vy().a(hVar, 0);
                }
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            final String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!be.kS(stringExtra)) {
                com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, this.mTitle, this.gNE, this.can, true, getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                    final /* synthetic */ IPCallShareCouponCardUI gNP;

                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            com.tencent.mm.q.a.a aVar = new com.tencent.mm.q.a.a();
                            aVar.title = this.gNP.mTitle;
                            aVar.url = this.gNP.gNG;
                            aVar.description = this.gNP.can;
                            aVar.thumburl = this.gNP.gNE;
                            aVar.type = 5;
                            com.tencent.mm.pluginsdk.model.app.l.a(aVar, null, null, stringExtra, "", null, null);
                            if (!be.kS(str)) {
                                mr mrVar = new mr();
                                mrVar.boa.bob = stringExtra;
                                mrVar.boa.content = str;
                                mrVar.boa.type = m.fp(stringExtra);
                                mrVar.boa.flags = 0;
                                com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                            }
                            com.tencent.mm.ui.base.g.bf(this.gNP.nDR.nEl, this.gNP.getResources().getString(2131231155));
                        }
                    }
                });
            }
        }
    }
}
