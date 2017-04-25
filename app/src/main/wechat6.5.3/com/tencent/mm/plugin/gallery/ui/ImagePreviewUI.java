package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.w;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@a(19)
@TargetApi(16)
public class ImagePreviewUI extends MMActivity {
    private com.tencent.mm.plugin.gallery.stub.a geI = null;
    private ArrayList<MediaItem> geJ;
    private long gfA = 0;
    private ServiceConnection gfD = new ServiceConnection(this) {
        final /* synthetic */ ImagePreviewUI ggV;

        {
            this.ggV = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            v.d("MicroMsg.ImagePreviewUI", "onServiceConnected");
            this.ggV.geI = com.tencent.mm.plugin.gallery.stub.a.a.N(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            v.d("MicroMsg.ImagePreviewUI", "onServiceDisconnected");
            this.ggV.geI = null;
        }
    };
    private boolean gfY;
    private boolean gfp = true;
    private boolean gft;
    private int gfv;
    private ArrayList<String> ggA;
    private ArrayList<String> ggB;
    private ArrayList<Integer> ggC;
    private Integer ggD;
    private ImageButton ggE;
    private TextView ggF;
    private TextView ggG;
    private ah ggH;
    private ImageButton ggI;
    private TextView ggJ;
    private ViewGroup ggK;
    private ViewGroup ggL;
    private boolean ggM = true;
    private boolean ggN = true;
    private int ggO = 0;
    private TextView ggP;
    private TextView ggQ;
    private TextView ggR;
    private ProgressBar ggS;
    private HashMap<String, Integer> ggT = new HashMap();
    private HashSet<String> ggU;
    private c ggy;
    private MMViewPager ggz;

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, Intent intent, boolean z, boolean z2) {
        intent.putExtra("CropImage_Compress_Img", z ? true : z2);
        ArrayList arrayList = imagePreviewUI.ggB;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (arrayList == null || arrayList.size() <= 0) {
            v.i("MicroMsg.ImagePreviewUI", "no img selected. keep current ui.");
            return;
        }
        String str;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            MediaItem tW = c.tW(str);
            if (tW == null || tW.getType() != 2) {
                arrayList2.add(str);
            } else {
                arrayList3.add(str);
            }
        }
        if (z && arrayList2.size() == 0 && arrayList3.size() == 1) {
            MediaItem tW2 = c.tW((String) arrayList3.get(0));
            if (tW2 == null || !(tW2 instanceof VideoMediaItem) || ((VideoMediaItem) tW2).gee == -1) {
                v.e("MicroMsg.ImagePreviewUI", "dealWithSend VideoMediaItem not found.");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("K_SEGMENTVIDEOPATH", tW2.gdY);
                intent2.putExtra("KSEGMENTVIDEOTHUMBPATH", tW2.gdZ);
                com.tencent.mm.ay.c.b(imagePreviewUI, "mmsight", ".segment.VideoCompressUI", intent2, 4371);
                return;
            }
        }
        intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList2);
        intent.putStringArrayListExtra("key_select_video_list", arrayList3);
        boolean booleanExtra = imagePreviewUI.getIntent().getBooleanExtra("isTakePhoto", false);
        if (booleanExtra && imagePreviewUI.ggB.size() > 0) {
            LatLongData JR = ExifHelper.JR((String) imagePreviewUI.ggB.get(0));
            Intent intent3 = new Intent(imagePreviewUI, ImagePreviewUI.class);
            v.d("MicroMsg.ImagePreviewUI", "findlatlng %s", new Object[]{str});
            if (JR != null) {
                v.d("MicroMsg.ImagePreviewUI", "findlatlng %f %f", new Object[]{Float.valueOf(JR.bhs), Float.valueOf(JR.cNt)});
                intent3.putExtra("KlatLng", JR);
            }
        }
        v.d("MicroMsg.ImagePreviewUI", "summersafecdn send image, previewImageCount:%d, chooseForTimeline:%b, forTimeline:%b, beCompress:%b", new Object[]{Integer.valueOf(c.aqs()), Boolean.valueOf(imagePreviewUI.gfp), Boolean.valueOf(z), Boolean.valueOf(z2)});
        try {
            imagePreviewUI.geI.Q(11610, (imagePreviewUI.gfp ? 3 : 2) + "," + c.aqs());
        } catch (Throwable e) {
            v.e("MicroMsg.ImagePreviewUI", "report error, %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.ImagePreviewUI", e, "", new Object[0]);
        }
        c.aqr();
        v.d("MicroMsg.ImagePreviewUI", "isTaskPhoto ? " + booleanExtra + " | isPreviewPhoto ? " + intent.getBooleanExtra("isPreviewPhoto", false));
        intent.putExtra("isTakePhoto", booleanExtra);
        str = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (be.kS(imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser")) || "medianote".equals(str)) {
            imagePreviewUI.setResult(-1, intent);
            imagePreviewUI.finish();
        } else if (be.Nj() - imagePreviewUI.gfA < 1000) {
            v.w("MicroMsg.ImagePreviewUI", "sendimg btn event frequence limit");
        } else {
            imagePreviewUI.gfA = be.Nj();
            v.i("MicroMsg.ImagePreviewUI", "switch to SendImgProxyUI");
            intent.setClassName(imagePreviewUI, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            intent.putExtra("GalleryUI_FromUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser"));
            intent.putExtra("GalleryUI_ToUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser"));
            imagePreviewUI.startActivityForResult(intent, 4369);
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, boolean z) {
        if (z) {
            imagePreviewUI.iR(false);
            imagePreviewUI.dm(true);
            return;
        }
        imagePreviewUI.iR(true);
        imagePreviewUI.dm(false);
    }

    static /* synthetic */ void o(ImagePreviewUI imagePreviewUI) {
        if (imagePreviewUI.ggH == null || imagePreviewUI.ggH.btC()) {
            imagePreviewUI.ggH = new ah(new ah.a(imagePreviewUI) {
                final /* synthetic */ ImagePreviewUI ggV;

                {
                    this.ggV = r1;
                }

                public final boolean oU() {
                    boolean z;
                    ImagePreviewUI imagePreviewUI = this.ggV;
                    if (this.ggV.ggN) {
                        z = false;
                    } else {
                        z = true;
                    }
                    imagePreviewUI.ggN = z;
                    ImagePreviewUI.a(this.ggV, this.ggV.ggN);
                    return false;
                }
            }, false);
            imagePreviewUI.ggH.ea(350);
            return;
        }
        imagePreviewUI.ggH.QI();
    }

    @TargetApi(16)
    public void onCreate(Bundle bundle) {
        final long Nj = be.Nj();
        super.onCreate(bundle);
        iR(true);
        new ac().post(new Runnable(this) {
            final /* synthetic */ ImagePreviewUI ggV;

            public final void run() {
                ImagePreviewUI.a(this.ggV, true);
                c.aqo().lg(-8);
                v.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[]{Long.valueOf(be.az(Nj))});
            }
        });
        bindService(new Intent(this.nDR.nEl, GalleryStubService.class), this.gfD, 1);
        NI();
        v.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[]{Long.valueOf(be.az(Nj))});
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        if (this.ggH != null) {
            this.ggH.QI();
        }
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130903797;
    }

    protected final void bB(View view) {
        w.c(w.a(getWindow(), null), this.nDR.nDX);
        ((ViewGroup) this.nDR.nDX.getParent()).removeView(this.nDR.nDX);
        ((ViewGroup) getWindow().getDecorView()).addView(this.nDR.nDX, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void NI() {
        /*
        r10 = this;
        r9 = 2;
        r8 = 8;
        r1 = 1;
        r2 = 0;
        r0 = 2131757489; // 0x7f1009b1 float:1.9145915E38 double:1.0532281406E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.ggP = r0;
        r0 = 2131757490; // 0x7f1009b2 float:1.9145917E38 double:1.053228141E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.ggQ = r0;
        r0 = 2131757491; // 0x7f1009b3 float:1.914592E38 double:1.0532281416E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.ggR = r0;
        r0 = 2131757485; // 0x7f1009ad float:1.9145907E38 double:1.0532281386E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r10.ggS = r0;
        r0 = r10.getIntent();
        r3 = "max_select_count";
        r4 = 9;
        r0 = r0.getIntExtra(r3, r4);
        r10.gfv = r0;
        r0 = com.tencent.mm.plugin.gallery.model.c.aqn();
        r0 = r0.aqL();
        r3 = 4;
        if (r0 != r3) goto L_0x00f5;
    L_0x004b:
        r0 = r1;
    L_0x004c:
        r10.gfp = r0;
        r3 = r10.getIntent();
        r0 = "preview_image_list";
        r0 = r3.getStringArrayListExtra(r0);
        r10.ggA = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.ggB = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.ggC = r0;
        r0 = r10.ggA;
        if (r0 == 0) goto L_0x0074;
    L_0x006d:
        r0 = r10.ggB;
        r4 = r10.ggA;
        r0.addAll(r4);
    L_0x0074:
        r0 = com.tencent.mm.plugin.gallery.model.c.aqq();
        r10.geJ = r0;
        r0 = "preview_all";
        r4 = r3.getBooleanExtra(r0, r2);
        r5 = "MicroMsg.ImagePreviewUI";
        r6 = "preview all[%B] mediaitems is null[%B]";
        r7 = new java.lang.Object[r9];
        r0 = java.lang.Boolean.valueOf(r4);
        r7[r2] = r0;
        r0 = r10.geJ;
        if (r0 != 0) goto L_0x00f8;
    L_0x0093:
        r0 = r1;
    L_0x0094:
        r0 = java.lang.Boolean.valueOf(r0);
        r7[r1] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r5, r6, r7);
        if (r4 == 0) goto L_0x00c9;
    L_0x009f:
        r0 = r10.geJ;
        if (r0 == 0) goto L_0x00c9;
    L_0x00a3:
        r10.gfY = r1;
        r0 = "preview_position";
        r0 = r3.getIntExtra(r0, r2);
        r0 = java.lang.Integer.valueOf(r0);
        r10.ggD = r0;
        r0 = "MicroMsg.ImagePreviewUI";
        r4 = "start position=%d";
        r5 = new java.lang.Object[r1];
        r6 = r10.ggD;
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r0, r4, r5);
        r0 = r10.ggD;
        r0 = r0.intValue();
        if (r0 >= 0) goto L_0x00cf;
    L_0x00c9:
        r0 = java.lang.Integer.valueOf(r2);
        r10.ggD = r0;
    L_0x00cf:
        r0 = r10.ggD;
        r0 = r0.intValue();
        com.tencent.mm.plugin.gallery.model.c.lb(r0);
        r0 = r10.gfY;
        if (r0 != 0) goto L_0x00fa;
    L_0x00dc:
        r0 = r10.ggB;
        if (r0 == 0) goto L_0x00e8;
    L_0x00e0:
        r0 = r10.ggB;
        r0 = r0.size();
        if (r0 != 0) goto L_0x00fa;
    L_0x00e8:
        r0 = "MicroMsg.ImagePreviewUI";
        r1 = "not preview all items and imagepaths is null or empty";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r10.finish();
    L_0x00f4:
        return;
    L_0x00f5:
        r0 = r2;
        goto L_0x004c;
    L_0x00f8:
        r0 = r2;
        goto L_0x0094;
    L_0x00fa:
        r0 = 2131757482; // 0x7f1009aa float:1.91459E38 double:1.053228137E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ImageButton) r0;
        r10.ggE = r0;
        r0 = 2131757483; // 0x7f1009ab float:1.9145903E38 double:1.0532281376E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.ggF = r0;
        r0 = 2131757484; // 0x7f1009ac float:1.9145905E38 double:1.053228138E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.ggG = r0;
        r0 = "send_raw_img";
        r0 = r3.getBooleanExtra(r0, r2);
        r10.gft = r0;
        r0 = "query_source_type";
        r0 = r3.getIntExtra(r0, r2);
        r10.ggO = r0;
        r0 = r10.gft;
        if (r0 == 0) goto L_0x02cd;
    L_0x0131:
        r0 = r10.ggE;
        r3 = 2131165878; // 0x7f0702b6 float:1.7945986E38 double:1.052935846E-314;
        r0.setImageResource(r3);
    L_0x0139:
        r0 = r10.ggB;
        if (r0 == 0) goto L_0x015e;
    L_0x013d:
        r0 = r10.ggB;
        r0 = r0.size();
        if (r0 != r1) goto L_0x015e;
    L_0x0145:
        r0 = r10.ggB;
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r3 = ".jpg";
        r3 = r0.endsWith(r3);
        if (r3 == 0) goto L_0x015e;
    L_0x0156:
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$4;
        r3.<init>(r10, r0);
        com.tencent.mm.sdk.platformtools.ad.o(r3);
    L_0x015e:
        r0 = r10.ggF;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r10.nDR;
        r4 = r4.nEl;
        r5 = 2131233031; // 0x7f080907 float:1.8082188E38 double:1.052969024E-314;
        r4 = r4.getString(r5);
        r3 = r3.append(r4);
        r4 = r10.aqY();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r0.setText(r3);
        r0 = r10.ggE;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$10;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$11;
        r0.<init>(r10);
        r3 = r10.ggG;
        r3.setOnClickListener(r0);
        r3 = r10.ggR;
        r3.setOnClickListener(r0);
        r0 = r10.ggF;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$12;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$13;
        r0.<init>(r10);
        r10.b(r0);
        r0 = r10.aqX();
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$14;
        r3.<init>(r10);
        r4 = com.tencent.mm.ui.k.b.nET;
        r10.a(r2, r0, r3, r4);
        r0 = 2131757487; // 0x7f1009af float:1.9145911E38 double:1.0532281396E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ImageButton) r0;
        r10.ggI = r0;
        r0 = r10.ggI;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$15;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = 2131757486; // 0x7f1009ae float:1.914591E38 double:1.053228139E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.ggJ = r0;
        r0 = r10.ggJ;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$16;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = r10.gfv;
        if (r0 != r1) goto L_0x01f4;
    L_0x01ea:
        r0 = r10.ggI;
        r0.setVisibility(r8);
        r0 = r10.ggJ;
        r0.setVisibility(r8);
    L_0x01f4:
        r0 = 2131756559; // 0x7f10060f float:1.9144029E38 double:1.053227681E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        r10.ggK = r0;
        r0 = 2131757488; // 0x7f1009b0 float:1.9145913E38 double:1.05322814E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        r10.ggL = r0;
        r0 = r10.ggK;
        if (r0 == 0) goto L_0x021d;
    L_0x020e:
        r0 = r10.ggK;
        r0.setVisibility(r8);
        r0 = r10.ggK;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$2;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
    L_0x021d:
        r0 = r10.ggL;
        if (r0 == 0) goto L_0x0230;
    L_0x0221:
        r0 = r10.ggL;
        r0.setVisibility(r8);
        r0 = r10.ggL;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$3;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
    L_0x0230:
        r0 = 2131755843; // 0x7f100343 float:1.9142577E38 double:1.0532273273E-314;
        r0 = r10.findViewById(r0);
        r0 = (com.tencent.mm.ui.base.MMViewPager) r0;
        r10.ggz = r0;
        r0 = r10.ggz;
        r0.setVerticalFadingEdgeEnabled(r2);
        r0 = r10.ggz;
        r0.setHorizontalFadingEdgeEnabled(r2);
        r0 = r10.ggz;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$5;
        r3.<init>(r10);
        r0.nZl = r3;
        r0 = r10.ggz;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$6;
        r3.<init>(r10);
        r0.nZj = r3;
        r0 = new com.tencent.mm.plugin.gallery.ui.c;
        r0.<init>(r10);
        r10.ggy = r0;
        r0 = "";
        r3 = r10.gfY;
        if (r3 != 0) goto L_0x02d7;
    L_0x0265:
        r3 = r10.ggy;
        r4 = r10.ggA;
        r5 = r3.gfX;
        r5.clear();
        r5 = r3.gfX;
        r5.addAll(r4);
        r3.notifyDataSetChanged();
        r3 = r10.ggy;
        r3.gfY = r2;
        r3 = r10.ggA;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x0290;
    L_0x0282:
        r0 = r10.ggA;
        r3 = r10.ggD;
        r3 = r3.intValue();
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
    L_0x0290:
        r3 = r10.ggz;
        r4 = r10.ggy;
        r3.a(r4);
        r3 = r10.ggz;
        r4 = r10.ggD;
        r4 = r4.intValue();
        r3.Z(r4);
        r10.ua(r0);
        r0 = "%d/%d";
        r3 = new java.lang.Object[r9];
        r4 = r10.ggD;
        r4 = r4.intValue();
        r4 = r4 + 1;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r2] = r4;
        r2 = r10.ggy;
        r2 = r2.getCount();
        r2 = java.lang.Integer.valueOf(r2);
        r3[r1] = r2;
        r0 = java.lang.String.format(r0, r3);
        r10.Fd(r0);
        goto L_0x00f4;
    L_0x02cd:
        r0 = r10.ggE;
        r3 = 2131165881; // 0x7f0702b9 float:1.7945992E38 double:1.0529358474E-314;
        r0.setImageResource(r3);
        goto L_0x0139;
    L_0x02d7:
        r3 = r10.ggy;
        r4 = r10.geJ;
        r5 = r3.geJ;
        r5.clear();
        r5 = r3.geJ;
        r5.addAll(r4);
        r3.notifyDataSetChanged();
        r3 = r10.ggy;
        r3.gfY = r1;
        r3 = r10.ggD;
        r3 = r3.intValue();
        r4 = r10.geJ;
        r4 = r4.size();
        if (r3 < r4) goto L_0x0300;
    L_0x02fa:
        r3 = java.lang.Integer.valueOf(r2);
        r10.ggD = r3;
    L_0x0300:
        r3 = r10.geJ;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x0290;
    L_0x0308:
        r0 = r10.geJ;
        r3 = r10.ggD;
        r3 = r3.intValue();
        r0 = r0.get(r3);
        r0 = (com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem) r0;
        r0 = r0.gdY;
        goto L_0x0290;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.NI():void");
    }

    private void tZ(String str) {
        if (this.ggB.contains(str)) {
            this.ggI.setImageResource(2131165403);
            do {
            } while (this.ggB.remove(str));
        } else if (this.ggB.size() >= this.gfv) {
            g.bf(this.nDR.nEl, getResources().getQuantityString(2131361804, this.gfv, new Object[]{Integer.valueOf(this.gfv)}));
            this.ggI.setImageResource(2131165403);
        } else {
            this.ggB.add(str);
            this.ggI.setImageResource(2131165400);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
        if (i == 4371) {
            if (i2 == -1) {
                setResult(-1, intent);
                finish();
            } else if (this.ggB.size() > 0) {
                tZ((String) this.ggB.get(0));
            } else {
                v.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[]{Integer.valueOf(this.ggB.size())});
            }
        } else if (i == 4370) {
            if (i2 == -1) {
                setResult(-1, intent);
            }
            if (intent != null) {
                setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
                finish();
            }
        } else if (intent != null) {
            setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
            finish();
        }
    }

    protected final int NO() {
        return 1;
    }

    private String aqX() {
        switch (c.aqn().aqL()) {
            case 4:
            case 7:
            case 8:
                if (this.ggB.size() == 0 || this.gfv <= 1) {
                    return getString(2131233033);
                }
                return getString(2131233033) + "(" + this.ggB.size() + "/" + this.gfv + ")";
            case 11:
                return getString(2131232424);
            default:
                if (this.ggB.size() == 0 || this.gfv <= 1) {
                    return getString(2131231149);
                }
                return getString(2131233026, new Object[]{Integer.valueOf(this.ggB.size()), Integer.valueOf(this.gfv)});
        }
    }

    private String aqY() {
        String str = "";
        Iterator it = this.ggB.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (this.ggT.containsKey(str2)) {
                i = ((Integer) this.ggT.get(str2)).intValue() + i;
            } else {
                int aQ = e.aQ(str2);
                this.ggT.put(str2, Integer.valueOf(aQ));
                i += aQ;
            }
        }
        if (i > 1048576) {
            return String.format("(%.2fM)", new Object[]{Float.valueOf((((float) i) / 1024.0f) / 1024.0f)});
        } else if (i <= 0) {
            return str;
        } else {
            return String.format("(%dK)", new Object[]{Integer.valueOf(i / 1024)});
        }
    }

    private void dm(boolean z) {
        View findViewById;
        v.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + z + "], selectedNormalFooter = " + this.ggM);
        if (this.ggM) {
            findViewById = findViewById(2131756559);
        } else {
            findViewById = findViewById(2131757488);
        }
        if (findViewById == null) {
            String str;
            String str2 = "MicroMsg.ImagePreviewUI";
            String str3 = "set footer[%s] visibility[%B], but footerbar null";
            Object[] objArr = new Object[2];
            if (this.ggM) {
                str = "normal";
            } else {
                str = "edit_tips";
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(z);
            v.w(str2, str3, objArr);
        } else if (!z || findViewById.getVisibility() != 0) {
            if (!z && findViewById.getVisibility() == 8) {
                return;
            }
            if (z) {
                findViewById.setVisibility(0);
                findViewById.startAnimation(AnimationUtils.loadAnimation(this, 2130968622));
                return;
            }
            findViewById.setVisibility(8);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this, 2130968623));
        }
    }

    private void goBack() {
        boolean z = true;
        Intent intent = new Intent();
        boolean z2 = !this.gft;
        String str = "CropImage_Compress_Img";
        if (!this.gfp) {
            z = z2;
        }
        intent.putExtra(str, z);
        intent.putStringArrayListExtra("preview_image_list", this.ggB);
        setResult(0, intent);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.ggy != null) {
            this.ggy.release();
        }
        c.A(null);
        unbindService(this.gfD);
    }

    private void ua(String str) {
        MediaItem tW = c.tW(str);
        if (tW != null && tW.getType() == 2 && c.aqn().aqL() == 4) {
            boolean z;
            VideoMediaItem videoMediaItem = (VideoMediaItem) tW;
            iT(false);
            this.ggM = false;
            this.ggK.setVisibility(8);
            this.ggL.setVisibility(0);
            this.ggR.setVisibility(8);
            if (FileOp.jP(str) > 1073741824) {
                this.ggP.setText(getString(2131233039));
                this.ggQ.setText(getString(2131233038));
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (be.kS(videoMediaItem.gec)) {
                    iT(false);
                    this.ggM = true;
                    this.ggK.setVisibility(0);
                    this.ggL.setVisibility(8);
                    this.ggG.setVisibility(8);
                    a(str, tW);
                    ub(str);
                    Runnable mVar = new m(str, this.ggD.intValue(), videoMediaItem, new m.a(this) {
                        final /* synthetic */ ImagePreviewUI ggV;

                        {
                            this.ggV = r1;
                        }

                        public final void a(m mVar) {
                            if (mVar.position == this.ggV.ggD.intValue()) {
                                this.ggV.a(mVar.path, mVar.geC);
                            }
                        }
                    });
                    if (com.tencent.mm.sdk.i.e.M(mVar)) {
                        v.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[]{str});
                        return;
                    }
                    com.tencent.mm.sdk.i.e.a(mVar, "video_analysis");
                    return;
                }
                v.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[]{videoMediaItem.gdY, Integer.valueOf(videoMediaItem.gee), Integer.valueOf(videoMediaItem.gef), Integer.valueOf(videoMediaItem.geg)});
                a(str, videoMediaItem);
                return;
            }
            return;
        }
        this.ggM = true;
        this.ggK.setVisibility(0);
        this.ggL.setVisibility(8);
        this.ggS.setVisibility(8);
        a(str, tW);
        ub(str);
        iT(true);
        this.ggG.setVisibility(8);
    }

    private void a(String str, VideoMediaItem videoMediaItem) {
        boolean z;
        iT(false);
        this.ggM = false;
        this.ggK.setVisibility(8);
        this.ggL.setVisibility(0);
        this.ggR.setVisibility(8);
        if (videoMediaItem == null || videoMediaItem.geg <= 0 || videoMediaItem.gef <= 0 || ((float) videoMediaItem.geg) / ((float) videoMediaItem.gef) > 3.0f || ((float) videoMediaItem.geg) / ((float) videoMediaItem.gef) < 0.5f) {
            v.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[]{Integer.valueOf(videoMediaItem.geg), Integer.valueOf(videoMediaItem.gef)});
            this.ggP.setText(getString(2131233036));
            this.ggQ.setText(getString(2131233037));
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            v.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[]{videoMediaItem});
            if (!(videoMediaItem == null || be.kS(videoMediaItem.gdY))) {
                String str2 = videoMediaItem.gdY;
                if (be.kS(str2)) {
                    z = true;
                } else {
                    if (this.ggU == null) {
                        this.ggU = new HashSet();
                        this.ggU.add(".h264");
                        this.ggU.add(".h26l");
                        this.ggU.add(".264");
                        this.ggU.add(".avc");
                        this.ggU.add(".mov");
                        this.ggU.add(".mp4");
                        this.ggU.add(".m4a");
                        this.ggU.add(".3gp");
                        this.ggU.add(".3g2");
                        this.ggU.add(".mj2");
                        this.ggU.add(".m4v");
                    }
                    str2 = str2.trim();
                    int lastIndexOf = str2.lastIndexOf(".");
                    z = (lastIndexOf < 0 || lastIndexOf >= str2.length()) ? true : !this.ggU.contains(str2.substring(lastIndexOf));
                }
                if (!z && "video/avc".equalsIgnoreCase(videoMediaItem.gec) && ((be.kS(videoMediaItem.ged) || "audio/mp4a-latm".equalsIgnoreCase(videoMediaItem.ged)) && videoMediaItem.videoFrameRate <= 35)) {
                    z = false;
                    if (!z) {
                        v.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[]{Integer.valueOf(videoMediaItem.gee)});
                        if (videoMediaItem.gee <= BaseReportManager.MAX_READ_COUNT) {
                            this.ggP.setText(getString(2131233043));
                            this.ggQ.setText(getString(2131233042));
                            z = true;
                        } else if (videoMediaItem.gee >= 300000) {
                            this.ggP.setText(getString(2131233041));
                            this.ggQ.setText(getString(2131233040));
                            z = true;
                        } else if (videoMediaItem.gee < 10500) {
                            this.ggP.setText(getString(2131233030));
                            this.ggQ.setText(getString(2131233029));
                            this.ggR.setVisibility(0);
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            iT(true);
                            this.ggM = true;
                            this.ggK.setVisibility(0);
                            this.ggL.setVisibility(8);
                            this.ggG.setVisibility(0);
                            this.ggS.setVisibility(8);
                            a(str, (MediaItem) videoMediaItem);
                            ub(str);
                        }
                    }
                }
            }
            String str3 = "MicroMsg.ImagePreviewUI";
            String str4 = "check video format failed, dst format [video/avc], video format [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = videoMediaItem == null ? null : videoMediaItem.gec;
            v.d(str3, str4, objArr);
            this.ggP.setText(getString(2131233034));
            this.ggQ.setText(getString(2131233035));
            z = true;
            if (!z) {
                v.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[]{Integer.valueOf(videoMediaItem.gee)});
                if (videoMediaItem.gee <= BaseReportManager.MAX_READ_COUNT) {
                    this.ggP.setText(getString(2131233043));
                    this.ggQ.setText(getString(2131233042));
                    z = true;
                } else if (videoMediaItem.gee >= 300000) {
                    this.ggP.setText(getString(2131233041));
                    this.ggQ.setText(getString(2131233040));
                    z = true;
                } else if (videoMediaItem.gee < 10500) {
                    z = false;
                } else {
                    this.ggP.setText(getString(2131233030));
                    this.ggQ.setText(getString(2131233029));
                    this.ggR.setVisibility(0);
                    z = true;
                }
                if (!z) {
                    iT(true);
                    this.ggM = true;
                    this.ggK.setVisibility(0);
                    this.ggL.setVisibility(8);
                    this.ggG.setVisibility(0);
                    this.ggS.setVisibility(8);
                    a(str, (MediaItem) videoMediaItem);
                    ub(str);
                }
            }
        }
    }

    private void a(String str, MediaItem mediaItem) {
        if (mediaItem != null && mediaItem.getType() == 2 && c.aqn().aqL() == 4) {
            this.ggI.setVisibility(8);
            this.ggJ.setVisibility(8);
            return;
        }
        if (this.gfv == 1) {
            this.ggI.setVisibility(8);
            this.ggJ.setVisibility(8);
        } else {
            this.ggI.setVisibility(0);
            this.ggJ.setVisibility(0);
        }
        if (this.ggB.contains(str)) {
            this.ggI.setImageResource(2131165400);
        } else {
            this.ggI.setImageResource(2131165403);
        }
    }

    private void ub(String str) {
        Boolean valueOf;
        Boolean.valueOf(false);
        switch (c.aqn().aqL()) {
            case 4:
            case 7:
                valueOf = Boolean.valueOf(true);
                break;
            default:
                valueOf = Boolean.valueOf(false);
                break;
        }
        MediaItem tW = c.tW(str);
        if (tW != null && tW.getType() == 2) {
            valueOf = Boolean.valueOf(true);
        }
        if (tW == null && o.JZ(str)) {
            valueOf = Boolean.valueOf(true);
        } else if (tW != null && tW.mMimeType.equalsIgnoreCase("image/gif")) {
            valueOf = Boolean.valueOf(true);
        }
        if (valueOf.booleanValue()) {
            this.ggE.setVisibility(8);
            this.ggF.setVisibility(8);
            return;
        }
        this.ggE.setVisibility(0);
        this.ggF.setVisibility(0);
    }
}
