package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.t.a.b.k;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

final class m extends com.tencent.mm.ui.chatting.ad.a {
    public static int[] fSx = new int[]{2131756248, 2131756249, 2131756250, 2131756251, 2131756252};
    protected TextView dtY;
    protected TextView dtZ;
    protected TextView fSs;
    private ArrayList<MMImageView> jIu = new ArrayList();
    protected TextView okA;
    protected LinearLayout okB;
    protected TextView okC;
    protected ImageView okD;
    protected MMPinProgressBtn okE;
    protected ImageView okF;
    protected ImageView okG;
    protected ImageView okH;
    protected ChattingItemFooter okI;
    protected ImageView okJ;
    protected LinearLayout okK;
    protected ViewGroup okL;
    protected TextView okM;
    protected LinearLayout okN;
    protected RelativeLayout okO;
    protected FrameLayout okP;
    protected LinearLayout okQ;
    protected LinearLayout okR;
    protected ViewStub okS;
    protected ImageView okT;
    protected LinearLayout okU;
    protected ImageView okV;
    protected TextView okW;
    protected TextView okX;
    protected ImageView okY;
    protected TextView okZ;
    protected MMImageView okd;
    ImageView okm;
    protected TextView oks;
    protected ImageView okz;
    protected TextView ola;
    protected LinearLayout olb;
    protected ImageView olc;
    protected TextView old;
    private int ole = Integer.MAX_VALUE;

    public static class a implements k {
        public static a fVO = new a(com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 215), com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 168));
        private int QW;
        private int Zx;

        private a(int i, int i2) {
            this.Zx = i;
            this.QW = i2;
        }

        public final Bitmap s(InputStream inputStream) {
            try {
                if (!inputStream.markSupported()) {
                    if (inputStream instanceof FileInputStream) {
                        inputStream = new i((FileInputStream) inputStream);
                    } else if (!inputStream.markSupported()) {
                        inputStream = new BufferedInputStream(inputStream);
                    }
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                inputStream.mark(8388608);
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                inputStream.reset();
                if (decodeStream != null) {
                    decodeStream.recycle();
                }
                if (options.outHeight <= 0 || options.outWidth <= 0) {
                    v.e("MicroMsg.AppMsgViewHolder", "decode[%s] error, outHeight[%d] outWidth[%d]", inputStream, Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
                    if (inputStream == null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    return null;
                }
                options.inSampleSize = (int) ((((double) options.outWidth) * 1.0d) / ((double) this.Zx));
                if (options.inSampleSize <= 1) {
                    options.inSampleSize = 1;
                }
                while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                options.inJustDecodeBounds = false;
                options.inMutable = true;
                Bitmap decodeRegion = BitmapRegionDecoder.newInstance(inputStream, false).decodeRegion(new Rect(0, 0, options.outWidth, (int) (((((float) options.outWidth) * 1.0f) * ((float) this.QW)) / ((float) this.Zx))), options);
                if (inputStream != null) {
                    return decodeRegion;
                }
                try {
                    inputStream.close();
                    return decodeRegion;
                } catch (IOException e2) {
                    return decodeRegion;
                }
            } catch (IOException e3) {
                v.e("MicroMsg.AppMsgViewHolder", "%s", e3);
                if (inputStream == null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                return null;
            } catch (Throwable th) {
                if (inputStream == null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
            }
        }
    }

    public m(int i) {
        super(i);
    }

    public final m p(View view, boolean z) {
        super.cM(view);
        this.okd = (MMImageView) view.findViewById(2131756168);
        this.dtY = (TextView) view.findViewById(2131756165);
        this.okC = (TextView) view.findViewById(2131756163);
        this.dtZ = (TextView) view.findViewById(2131756166);
        this.fSs = (TextView) view.findViewById(2131756174);
        this.okz = (ImageView) view.findViewById(2131756173);
        this.okA = (TextView) view.findViewById(2131756175);
        this.okB = (LinearLayout) view.findViewById(2131756172);
        this.okD = (ImageView) view.findViewById(2131756179);
        this.okE = (MMPinProgressBtn) view.findViewById(2131756169);
        this.okF = (ImageView) this.kad.findViewById(2131756178);
        this.okG = (ImageView) this.kad.findViewById(2131756177);
        this.okH = (ImageView) view.findViewById(2131756170);
        this.oks = (TextView) view.findViewById(2131756107);
        this.okJ = (ImageView) view.findViewById(2131756180);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.iJL = (TextView) view.findViewById(2131755341);
        this.okI = (ChattingItemFooter) view.findViewById(2131756106);
        this.okK = (LinearLayout) view.findViewById(2131756147);
        this.okL = (ViewGroup) view.findViewById(2131756144);
        this.okM = (TextView) view.findViewById(2131756146);
        this.okN = (LinearLayout) view.findViewById(2131755642);
        this.okP = (FrameLayout) view.findViewById(2131756148);
        this.okQ = (LinearLayout) view.findViewById(2131756162);
        this.okO = (RelativeLayout) view.findViewById(2131756167);
        this.okS = (ViewStub) view.findViewById(2131756171);
        this.okT = (ImageView) view.findViewById(2131756164);
        if (!z) {
            this.okm = (ImageView) this.kad.findViewById(2131756258);
            this.ieT = (ProgressBar) this.kad.findViewById(2131756257);
        }
        this.olb = (LinearLayout) view.findViewById(2131756149);
        this.olc = (ImageView) view.findViewById(2131756152);
        this.old = (TextView) view.findViewById(2131756150);
        this.okU = (LinearLayout) view.findViewById(2131756157);
        this.okV = (ImageView) view.findViewById(2131756158);
        this.okW = (TextView) view.findViewById(2131756159);
        this.okX = (TextView) view.findViewById(2131756151);
        this.okY = (ImageView) view.findViewById(2131756154);
        this.okZ = (TextView) view.findViewById(2131756155);
        this.ola = (TextView) view.findViewById(2131756156);
        if (this.okC != null && VERSION.SDK_INT >= 16) {
            this.ole = this.okC.getMaxLines();
        }
        return this;
    }

    public final void reset() {
        if (this.okC != null) {
            this.okC.setMaxLines(this.ole);
        }
    }

    public static void a(m mVar, String str, int i) {
        int GC = l.GC(str);
        if (GC == -1 || GC >= 100 || i <= 0) {
            mVar.okE.setVisibility(8);
            return;
        }
        mVar.okE.setVisibility(0);
        mVar.okE.setProgress(GC);
    }

    public static void a(m mVar, final Boolean bool, at atVar, String str, final String str2) {
        final long j = atVar.field_msgId;
        b dy = am.Wf().dy(j);
        if (dy == null) {
            v.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", Long.valueOf(j), str2);
            return;
        }
        if (bool.booleanValue()) {
            if (dy.field_status == 101) {
                mVar.okG.setVisibility(0);
                mVar.okE.setVisibility(0);
            } else if (dy.field_status == 102) {
                mVar.okG.setVisibility(8);
                mVar.okE.setVisibility(8);
            } else {
                mVar.okG.setVisibility(8);
                mVar.okE.setVisibility(8);
            }
        } else if (dy.field_status == 101) {
            mVar.okG.setVisibility(0);
            mVar.okF.setVisibility(8);
        } else if (dy.field_status == 105) {
            mVar.okG.setVisibility(8);
            mVar.okF.setVisibility(0);
        } else {
            mVar.okG.setVisibility(8);
            mVar.okF.setVisibility(8);
        }
        if (atVar.field_status == 5) {
            mVar.okG.setVisibility(8);
            mVar.okF.setVisibility(8);
        }
        final Boolean bool2 = bool;
        final String str3 = str;
        final String str4 = str2;
        mVar.okG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String str;
                c dy;
                if (bool2.booleanValue()) {
                    long j = j;
                    str = str4;
                    dy = am.Wf().dy(j);
                    if (dy == null) {
                        v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sm() + " getinfo failed: " + str);
                        return;
                    } else if (dy.field_status != 101) {
                        v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sm() + " get status failed: " + str + " status:" + dy.field_status);
                        return;
                    } else {
                        dy.field_status = 102;
                        dy.field_lastModifyTime = be.Nh();
                        am.Wf().a(dy, new String[0]);
                        return;
                    }
                }
                j = j;
                str = str4;
                dy = am.Wf().dy(j);
                if (dy == null) {
                    v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sm() + " getinfo failed: " + str);
                } else if (dy.field_status != 101) {
                    v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sm() + " get status failed: " + str + " status:" + dy.field_status);
                } else {
                    if (!be.kS(dy.field_clientAppDataId) || be.kS(dy.field_mediaSvrId)) {
                        dy.field_status = 105;
                    } else {
                        dy.field_status = 102;
                    }
                    dy.field_lastModifyTime = be.Nh();
                    am.Wf().a(dy, new String[0]);
                }
            }
        });
        mVar.okF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!bool.booleanValue()) {
                    long j = j;
                    String str = str2;
                    c dy = am.Wf().dy(j);
                    if (dy == null) {
                        v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sm() + " getinfo failed: " + str);
                    } else if (dy.field_status != 105) {
                        v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sm() + " get status failed: " + str + " status:" + dy.field_status);
                    } else {
                        dy.field_status = 101;
                        dy.field_lastModifyTime = be.Nh();
                        am.Wf().a(dy, new String[0]);
                        am.bnE().run();
                    }
                }
            }
        });
    }

    static void a(m mVar, com.tencent.mm.q.a.a aVar, boolean z) {
        com.tencent.mm.sdk.c.b kwVar = new kw();
        kwVar.bmf.type = 0;
        kwVar.bmf.bmh = aVar.coC;
        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
        com.tencent.mm.protocal.b.a.c cVar = kwVar.bmg.bmp;
        if (cVar != null) {
            mVar.okC.setText(e.a(mVar.okC.getContext(), be.ah(cVar.title, aVar.title), mVar.okC.getTextSize()));
            String str = cVar.desc;
            if (str == null) {
                v.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", aVar.coC);
            } else {
                str = str.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            if (str != null && str.length() > 100) {
                str = str.substring(0, 100);
            }
            mVar.dtZ.setText(e.a(mVar.dtZ.getContext(), be.ah(str, aVar.description), mVar.dtZ.getTextSize()));
            Iterator it = cVar.cqE.iterator();
            int i = 0;
            while (it.hasNext()) {
                pw pwVar = (pw) it.next();
                if (be.kS(pwVar.msh) || !pwVar.msh.equals(".htm") || be.kS(pwVar.msU) || !pwVar.msU.equals("WeNoteHtmlFile")) {
                    int i2;
                    switch (pwVar.aKG) {
                        case 1:
                            i2 = i;
                            break;
                        case 2:
                            if (z) {
                                mVar.okd.setVisibility(0);
                                mVar.okd.setImageResource(2130837647);
                            }
                            i2 = 1;
                            break;
                        case 3:
                            if (z) {
                                mVar.okd.setVisibility(0);
                                mVar.okd.setImageResource(2131165246);
                            }
                            i2 = 1;
                            break;
                        case 4:
                            if (z) {
                                mVar.okd.setVisibility(0);
                                mVar.okd.setImageResource(2131165244);
                            }
                            mVar.okH.setVisibility(0);
                            mVar.okH.setImageResource(2130839370);
                            break;
                        case 5:
                            if (z) {
                                mVar.okd.setVisibility(0);
                                mVar.okd.setImageResource(2131165247);
                            }
                            i2 = 1;
                            break;
                        case 6:
                            mVar.okd.setVisibility(0);
                            mVar.okd.setImageResource(2131165231);
                            break;
                        case 7:
                            if (z) {
                                mVar.okd.setVisibility(0);
                                mVar.okd.setImageResource(2131165232);
                            }
                            mVar.okH.setVisibility(0);
                            mVar.okH.setImageResource(2130838735);
                            break;
                        case 8:
                            if (z) {
                                mVar.okd.setVisibility(0);
                                mVar.okd.setImageResource(com.tencent.mm.pluginsdk.c.Ga(pwVar.msh));
                            }
                            i2 = 1;
                            break;
                        case 10:
                        case 11:
                        case 14:
                            if (z) {
                                mVar.okd.setVisibility(0);
                                mVar.okd.setImageResource(2131165241);
                            }
                            i2 = 1;
                            break;
                        case 16:
                            if (z) {
                                mVar.okd.setVisibility(0);
                                mVar.okd.setImageResource(2130838080);
                                break;
                            }
                            break;
                        default:
                            i2 = i;
                            break;
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, m mVar, com.tencent.mm.q.a.a aVar2, at atVar, boolean z) {
        com.tencent.mm.sdk.c.b kwVar = new kw();
        kwVar.bmf.type = 0;
        kwVar.bmf.bmh = aVar2.coC;
        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
        com.tencent.mm.protocal.b.a.c cVar = kwVar.bmg.bmp;
        mVar.okO.setVisibility(8);
        String[] strArr = new String[4];
        String[] strArr2 = new String[4];
        int[] iArr = new int[4];
        String[] strArr3 = new String[4];
        String[] strArr4 = new String[4];
        int[] iArr2 = new int[4];
        String[] strArr5 = new String[4];
        if (cVar != null) {
            CharSequence trim;
            Object obj;
            String str = null;
            String ah = be.ah(cVar.desc, aVar2.description);
            Object obj2 = null;
            Iterator it = cVar.cqE.iterator();
            int i = 0;
            while (it.hasNext()) {
                pw pwVar = (pw) it.next();
                if (be.kS(pwVar.msh) || !pwVar.msh.equals(".htm") || be.kS(pwVar.msU) || !pwVar.msU.equals("WeNoteHtmlFile")) {
                    int i2;
                    switch (pwVar.aKG) {
                        case 1:
                            if (obj2 == null) {
                                str = pwVar.desc;
                                obj2 = 1;
                                continue;
                            }
                            break;
                        case 2:
                            if (z) {
                                mVar.okO.setVisibility(0);
                                mVar.okd.setVisibility(0);
                                mVar.okd.setImageResource(2130837647);
                            }
                            if (i < 4) {
                                strArr[i] = pwVar.coj;
                                strArr2[i] = pwVar.mrO;
                                iArr[i] = (int) pwVar.msy;
                                strArr3[i] = pwVar.mrS;
                                strArr4[i] = pwVar.mrU;
                                iArr2[i] = (int) pwVar.msn;
                                strArr5[i] = pwVar.luu;
                            }
                            i2 = i + 1;
                            break;
                        case 3:
                            break;
                    }
                    i2 = i;
                    i = i2;
                }
            }
            Object obj3 = null;
            if (str != null) {
                String string;
                String[] split = str.split("\n", 2);
                if (split.length == 1) {
                    obj3 = 1;
                }
                if (split.length == 1 && cVar.cqE.size() == 2) {
                    string = aa.getContext().getString(2131232755);
                } else if (i > 0) {
                    string = split[0];
                    if (split.length > 1) {
                        str = split[1];
                    } else {
                        str = null;
                    }
                } else {
                    string = split[0];
                    String[] split2 = ah.split(Pattern.quote(string), 2);
                    str = split2[0].trim();
                    if (split2.length > 1) {
                        str = new StringBuilder(split2[0].trim()).append("\n").append(split2[1].trim()).toString().trim();
                    }
                }
                Object obj4 = obj3;
                trim = string.trim();
                obj = obj4;
            } else {
                obj = null;
                obj3 = aa.getContext().getString(2131232755);
                str = ah;
            }
            if (trim != null) {
                trim = trim.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            mVar.okC.setText(e.a(mVar.okC.getContext(), trim, (int) mVar.okC.getTextSize()));
            if (str == null || str.length() <= 100) {
                obj3 = str;
            } else {
                trim = str.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            mVar.dtZ.setText(e.a(mVar.dtZ.getContext(), trim, (int) mVar.dtZ.getTextSize()));
            if (i > 0) {
                int i3;
                mVar.okO.setVisibility(8);
                if (obj != null || obj2 == null) {
                    mVar.dtZ.setVisibility(8);
                    mVar.okC.setMaxLines(2);
                } else {
                    mVar.dtZ.setMaxLines(1);
                    mVar.dtZ.setVisibility(0);
                    mVar.okC.setMaxLines(1);
                }
                mVar.okT.setVisibility(8);
                mVar.okS.setLayoutResource(2130903333);
                try {
                    mVar.okR = (LinearLayout) mVar.okS.inflate();
                } catch (Exception e) {
                    mVar.okS.setVisibility(0);
                }
                if (i > 4) {
                    i3 = 4;
                } else {
                    i3 = i;
                }
                a(aVar, mVar, i3, strArr5, strArr2, strArr, iArr, strArr4, strArr3, iArr2, atVar.field_talker);
                ImageView imageView = (ImageView) mVar.okR.findViewById(2131756253);
                TextView textView = (TextView) mVar.okR.findViewById(2131756254);
                textView.setTextSize(0, (float) aa.getContext().getResources().getDimensionPixelSize(2131493169));
                if (i > 4) {
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    if (textView != null) {
                        textView.setText("(" + i + ")");
                        textView.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            mVar.okS.setVisibility(8);
            mVar.okT.setVisibility(0);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, m mVar, int i, String[] strArr, String[] strArr2, String[] strArr3, int[] iArr, String[] strArr4, String[] strArr5, int[] iArr2, String str) {
        int i2;
        for (i2 = 0; i2 <= 4; i2++) {
            MMImageView mMImageView = (MMImageView) mVar.okR.findViewById(fSx[i2]);
            if (mMImageView != null) {
                mMImageView.setImageDrawable(null);
                mMImageView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) mVar.okR.findViewById(2131756253);
        TextView textView = (TextView) mVar.okR.findViewById(2131756254);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
        for (int i3 = 0; i3 < i; i3++) {
            if (i == 1) {
                mMImageView = (MMImageView) mVar.okR.findViewById(fSx[i3]);
                mMImageView.setImageResource(2131165390);
            } else {
                mMImageView = (MMImageView) mVar.okR.findViewById(fSx[i3 + 1]);
                mMImageView.setImageResource(2131165389);
            }
            mMImageView.setVisibility(0);
            am.bny().a(aVar.onh, strArr[i3], be.Ni(), strArr2[i3], strArr3[i3], iArr[i3], str);
            String l = n.GH().l("Note_" + strArr[i3], SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            if (FileOp.aR(l)) {
                Bitmap a = n.GH().a(l, com.tencent.mm.bd.a.getDensity(aa.getContext()));
                if (a == null || a.isRecycled()) {
                    mMImageView.setImageResource(2131165389);
                } else {
                    mMImageView.setImageBitmap(a);
                }
            } else {
                am.bny().a(aVar.onh, strArr[i3], be.Ni(), strArr4[i3], strArr5[i3], iArr2[i3], str);
                n.GH().l("Note_" + strArr[i3], SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                i2 = com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, 45);
                if (FileOp.aR(l)) {
                    Bitmap a2 = n.GH().a(l, com.tencent.mm.bd.a.getDensity(aa.getContext()));
                    Bitmap.createScaledBitmap(a2, i2, i2, true);
                    if (a2 == null || a2.isRecycled()) {
                        mMImageView.setImageResource(2131165389);
                    } else {
                        mMImageView.setImageBitmap(a2);
                    }
                } else {
                    v.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
                }
            }
        }
    }
}
