package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.q;
import com.tencent.mm.model.q.b;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMGallery;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestureGalleryUI extends MMActivity implements OnTouchListener, b {
    private String crV = null;
    private MMGallery gsU;
    private MMGestureGallery gsV;
    float gsW = 0.0f;
    float gsX = 0.0f;
    boolean gsY = false;
    float gsZ = 1.0f;
    private q gta;
    private List<String> gtb = new ArrayList();
    private int gtc = -1;
    private OnItemSelectedListener gtd = new OnItemSelectedListener(this) {
        final /* synthetic */ GestureGalleryUI kgu;

        {
            this.kgu = r1;
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.kgu.gtc = i;
            this.kgu.Fd((this.kgu.gtc + 1) + " / " + this.kgu.gtb.size());
            v.d("MicroMsg.GestureGalleryUI", "pos:" + i);
            this.kgu.kgs = this.kgu.gta.c((String) this.kgu.gtb.get(i), this.kgu.type, i, this.kgu.crV);
            if (be.kS(this.kgu.kgs)) {
                this.kgu.kgs = (String) this.kgu.gtb.get(i);
            }
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    };
    private a kgr;
    private String kgs;
    private boolean kgt = false;
    private int type = 0;

    class a extends BaseAdapter {
        final /* synthetic */ GestureGalleryUI kgu;

        class a {
            ProgressBar gtf;
            MMGIFImageView kgw;
            final /* synthetic */ a kgx;

            a(a aVar) {
                this.kgx = aVar;
            }
        }

        public a(GestureGalleryUI gestureGalleryUI) {
            this.kgu = gestureGalleryUI;
        }

        public final int getCount() {
            v.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + this.kgu.gtb.size());
            return this.kgu.gtb.size();
        }

        public final Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.kgu, 2130904236, null);
                aVar.gtf = (ProgressBar) view.findViewById(2131757495);
                aVar.kgw = (MMGIFImageView) view.findViewById(2131755052);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            String str = (String) this.kgu.gtb.get(i);
            if (!e.aR(str)) {
                str = this.kgu.gta.c(str, this.kgu.type, i, this.kgu.crV);
            }
            if (be.kS(str)) {
                aVar.gtf.setVisibility(0);
                aVar.kgw.setVisibility(8);
            } else {
                Bitmap bitmap;
                aVar.gtf.setVisibility(8);
                if (str == null) {
                    bitmap = null;
                } else {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(str, options);
                    if (bitmap != null) {
                        v.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", new Object[]{bitmap.toString()});
                        bitmap.recycle();
                    }
                    bitmap = d.JV(str);
                    if (bitmap == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                        Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str);
                        String str2 = "MicroMsg.GestureGalleryUI";
                        String str3 = "Progressive jpeg, result isNull:%b";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(decodeAsBitmap == null);
                        v.i(str2, str3, objArr);
                        bitmap = decodeAsBitmap;
                    }
                    if (bitmap == null) {
                        v.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                        bitmap = null;
                    }
                }
                if (o.JZ(str)) {
                    try {
                        aVar.kgw.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                        aVar.kgw.setVisibility(0);
                        aVar.kgw.uz(str);
                    } catch (Throwable e) {
                        v.e("MicroMsg.GestureGalleryUI", be.e(e));
                        aVar.kgw.setVisibility(0);
                        aVar.kgw.setImageBitmap(bitmap);
                    }
                } else if (!(bitmap == null || bitmap.isRecycled())) {
                    if (b.aZy()) {
                        aVar.kgw.setVisibility(8);
                        view = new MultiTouchImageView(this.kgu, bitmap.getWidth(), bitmap.getHeight());
                        if (VERSION.SDK_INT == 20) {
                            view.setLayerType(1, null);
                        } else {
                            k.h(view, bitmap.getWidth(), bitmap.getHeight());
                        }
                        view.jOS = false;
                        view.setLayoutParams(new LayoutParams(-1, -1));
                        view.setImageBitmap(bitmap);
                    } else {
                        aVar.kgw.setImageBitmap(bitmap);
                        aVar.kgw.setVisibility(0);
                        aVar.kgw.setScaleType(ScaleType.MATRIX);
                    }
                }
            }
            return view;
        }
    }

    static /* synthetic */ void a(GestureGalleryUI gestureGalleryUI) {
        f fVar = new f(gestureGalleryUI.nDR.nEl, f.pbS, false);
        fVar.jXn = new c(gestureGalleryUI) {
            final /* synthetic */ GestureGalleryUI kgu;

            {
                this.kgu = r1;
            }

            public final void a(l lVar) {
                lVar.dg(1, 2131234310);
                lVar.dg(2, 2131234725);
                lVar.dg(3, 2131234180);
            }
        };
        fVar.jXo = new n.d(gestureGalleryUI) {
            final /* synthetic */ GestureGalleryUI kgu;

            {
                this.kgu = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                int i2 = 0;
                switch (menuItem.getItemId()) {
                    case 1:
                        if (be.kS(this.kgu.kgs)) {
                            v.w("MicroMsg.GestureGalleryUI", "share image to friend fail, imgPath is null");
                            return;
                        } else if (o.JZ(this.kgu.kgs)) {
                            com.tencent.mm.storage.a.c rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(g.aX(this.kgu.kgs));
                            if (rg == null) {
                                rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(com.tencent.mm.pluginsdk.j.a.bmr().rh(this.kgu.kgs));
                            }
                            if (rg != null) {
                                i2 = e.aQ(rg.dR(rg.field_groupId, rg.EB()));
                            }
                            if (i2 > com.tencent.mm.h.b.sJ()) {
                                com.tencent.mm.ui.base.g.a(this.kgu.nDR.nEl, this.kgu.getString(2131232336), "", this.kgu.getString(2131233285), null);
                                return;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("Retr_File_Name", rg.EB());
                            intent.putExtra("Retr_Msg_Type", 5);
                            intent.addFlags(268435456);
                            intent.putExtra("Retr_MsgImgScene", 1);
                            com.tencent.mm.plugin.subapp.b.drp.l(intent, this.kgu.nDR.nEl);
                            return;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("Retr_File_Name", this.kgu.kgs);
                            intent2.putExtra("Retr_Compress_Type", 0);
                            intent2.putExtra("Retr_Msg_Type", 0);
                            com.tencent.mm.plugin.subapp.b.drp.l(intent2, this.kgu.nDR.nEl);
                            return;
                        }
                    case 2:
                        if (this.kgu.kgs != null && !this.kgu.kgs.equals("")) {
                            ak.yW();
                            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                com.tencent.mm.pluginsdk.ui.tools.l.h(this.kgu.kgs, this.kgu);
                                return;
                            } else {
                                s.ey(this.kgu);
                                return;
                            }
                        }
                        return;
                    case 3:
                        bp bpVar = new bp();
                        com.tencent.mm.pluginsdk.model.d.a(bpVar, 1, this.kgu.kgs);
                        bpVar.aZd.aXH = this.kgu;
                        bpVar.aZd.aZl = 32;
                        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
    }

    static /* synthetic */ void a(GestureGalleryUI gestureGalleryUI, final String str) {
        if (str != null && str.length() != 0 && com.tencent.mm.pluginsdk.ui.applet.c.b(gestureGalleryUI.nDR, str, true, new com.tencent.mm.pluginsdk.ui.applet.c.a(gestureGalleryUI) {
            final /* synthetic */ GestureGalleryUI kgu;

            public final void a(boolean z, String str, int i) {
                if (z) {
                    if (j.ak.lyd != null) {
                        j.ak.lyd.cD(str, str);
                        j.ak.lyd.aTe();
                    }
                    com.tencent.mm.ui.base.g.bf(this.kgu, this.kgu.getResources().getString(2131231155));
                }
            }
        }) == null) {
            v.e("MicroMsg.GestureGalleryUI", "doTimeline fail, cannot show dialog");
        }
    }

    public final void a(String str, String str2, int i) {
        if (this.kgr != null) {
            if (i == (b.aZy() ? this.gsV.getSelectedItemPosition() : this.gsU.getSelectedItemPosition())) {
                this.kgs = str2;
                v.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[]{this.kgs, str});
            }
            this.kgr.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kgt = getIntent().getBooleanExtra("isFromWebView", false);
        this.crV = getIntent().getStringExtra("cookie");
        v.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, cookie = %s", new Object[]{Boolean.valueOf(this.kgt), this.crV});
        this.gta = new q(this.kgt);
        q qVar = this.gta;
        v.d("MicroMsg.GetPicService", "addListener :" + hashCode());
        qVar.crP = this;
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
        q qVar = this.gta;
        v.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
        qVar.crP = null;
        this.gta.yy();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return 2130904235;
    }

    protected final void NI() {
        int i;
        String ma = be.ma(getIntent().getStringExtra("nowUrl"));
        this.type = getIntent().getIntExtra("type", 0);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            String ma2 = be.ma(getIntent().getStringExtra("htmlData"));
            i = 0;
            while (i >= 0) {
                int indexOf = ma2.indexOf("weixin://viewimage/", i);
                if (indexOf < 0) {
                    break;
                }
                i = ma2.indexOf("\"", indexOf);
                if (i < 0) {
                    break;
                }
                String substring = ma2.substring(indexOf + 19, i);
                v.d("MicroMsg.GestureGalleryUI", "start:" + indexOf + " end:" + i + " url:" + substring);
                this.gtb.add(substring);
            }
        } else {
            this.gtb = Arrays.asList(stringArrayExtra);
        }
        for (i = 0; i < this.gtb.size(); i++) {
            if (ma.equals(this.gtb.get(i))) {
                this.gtc = i;
                break;
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GestureGalleryUI kgu;

            {
                this.kgu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kgu.finish();
                return true;
            }
        });
        this.kgr = new a(this);
        if (b.aZy()) {
            this.gsV = (MMGestureGallery) findViewById(2131755843);
            this.gsV.setVisibility(0);
            this.gsV.setVerticalFadingEdgeEnabled(false);
            this.gsV.setHorizontalFadingEdgeEnabled(false);
            this.gsV.setAdapter(this.kgr);
            this.gsV.setSelection(this.gtc);
            this.gsV.setOnItemSelectedListener(this.gtd);
        } else {
            this.gsU = (MMGallery) findViewById(2131758782);
            this.gsU.setVisibility(0);
            this.gsU.setAdapter(this.kgr);
            this.gsU.setSelection(this.gtc);
            this.gsU.setOnItemSelectedListener(this.gtd);
        }
        i = getIntent().getIntExtra("nevNext", 1);
        if (1 == i) {
            a(0, 2130838681, new OnMenuItemClickListener(this) {
                final /* synthetic */ GestureGalleryUI kgu;

                {
                    this.kgu = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    GestureGalleryUI.a(this.kgu);
                    return true;
                }
            });
        } else if (2 == i) {
            a(0, 2131165801, new OnMenuItemClickListener(this) {
                final /* synthetic */ GestureGalleryUI kgu;

                {
                    this.kgu = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.base.g.a(this.kgu, null, this.kgu.nDR.nEl.getResources().getStringArray(2131296288), "", false, new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ AnonymousClass3 kgv;

                        {
                            this.kgv = r1;
                        }

                        public final void gT(int i) {
                            switch (i) {
                                case 0:
                                    GestureGalleryUI.a(this.kgv.kgu, this.kgv.kgu.kgs);
                                    return;
                                case 1:
                                    GestureGalleryUI gestureGalleryUI = this.kgv.kgu;
                                    String b = this.kgv.kgu.kgs;
                                    if (b != null && b.length() != 0) {
                                        Intent intent = new Intent();
                                        intent.putExtra("Retr_File_Name", b);
                                        intent.putExtra("Retr_Msg_Type", 0);
                                        intent.putExtra("Retr_Compress_Type", 0);
                                        com.tencent.mm.plugin.subapp.b.drp.l(intent, gestureGalleryUI.nDR.nEl);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return true;
                }
            });
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        v.d("MicroMsg.GestureGalleryUI", "Main onTouch event.getAction():" + motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 2:
                if (this.gsY) {
                    this.gsX = b.u(motionEvent);
                    if (this.gsX >= 5.0f) {
                        float f = this.gsX - this.gsW;
                        if (f != 0.0f) {
                            if (Math.abs(f) <= 5.0f) {
                                return true;
                            }
                            float f2 = f / 854.0f;
                            Animation scaleAnimation = new ScaleAnimation(this.gsZ, this.gsZ + f2, this.gsZ, this.gsZ + f2, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(100);
                            scaleAnimation.setFillAfter(true);
                            scaleAnimation.setFillEnabled(true);
                            this.gsZ += f2;
                            this.gsU.getSelectedView().setLayoutParams(new LayoutParams((int) (480.0f * this.gsZ), (int) (this.gsZ * 854.0f)));
                            this.gsW = this.gsX;
                            return true;
                        }
                    }
                }
                break;
            case 5:
                this.gsW = b.u(motionEvent);
                if (this.gsW > 5.0f) {
                    this.gsY = true;
                    break;
                }
                break;
            case 6:
                this.gsY = false;
                break;
        }
        return false;
    }
}
