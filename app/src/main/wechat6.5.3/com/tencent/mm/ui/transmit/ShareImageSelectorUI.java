package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.a.a.f;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.tools.ShowImageUI;
import java.util.ArrayList;

public class ShareImageSelectorUI extends MMActivity implements OnItemClickListener {
    private static int oXS = 1;
    private ListView Eq;
    private View fil;
    private ImageView fqF;
    private String hgx;
    private ac mHandler = new ac(this) {
        final /* synthetic */ ShareImageSelectorUI oXW;

        {
            this.oXW = r1;
        }

        public final void handleMessage(Message message) {
            this.oXW.finish();
        }
    };
    private int oIf = 2;
    private a oXT;
    private Dialog oXU;
    private OnClickListener oXV = new OnClickListener(this) {
        final /* synthetic */ ShareImageSelectorUI oXW;

        {
            this.oXW = r1;
        }

        public final void onClick(View view) {
            ShareImageSelectorUI.a(this.oXW);
        }
    };

    class a extends BaseAdapter {
        final /* synthetic */ ShareImageSelectorUI oXW;
        public a[] oXX = new a[]{new a(this, 2131232254, 2131165913), new a(this, 2131232255, 2131165561), new a(this, 2131232253, 2131165715)};

        class a {
            int oXY;
            int oXZ;
            final /* synthetic */ a oYa;

            public a(a aVar, int i, int i2) {
                this.oYa = aVar;
                this.oXY = i;
                this.oXZ = i2;
            }
        }

        a(ShareImageSelectorUI shareImageSelectorUI) {
            this.oXW = shareImageSelectorUI;
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.oXX[i];
        }

        public final int getCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.oXW.nDR.nEl).inflate(2130904380, null);
                bVar = new b(this.oXW, view);
            } else {
                bVar = (b) view.getTag();
            }
            a aVar = this.oXX[i];
            if (aVar != null) {
                bVar.oYb.setText(aVar.oXY);
                bVar.fQG.setImageResource(aVar.oXZ);
            }
            return view;
        }
    }

    class b {
        MMImageView fQG;
        final /* synthetic */ ShareImageSelectorUI oXW;
        TextView oYb;

        public b(ShareImageSelectorUI shareImageSelectorUI, View view) {
            this.oXW = shareImageSelectorUI;
            this.fQG = (MMImageView) view.findViewById(2131756640);
            this.oYb = (TextView) view.findViewById(2131759185);
        }
    }

    static /* synthetic */ void a(ShareImageSelectorUI shareImageSelectorUI) {
        Intent intent = new Intent(shareImageSelectorUI, ShowImageUI.class);
        intent.putExtra("key_image_path", shareImageSelectorUI.hgx);
        intent.putExtra("show_menu", false);
        shareImageSelectorUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return 2130904379;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        Object obj = c.vf().get(229635, null);
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 0 || intValue == 1) {
                oXS = intValue;
            }
        }
        vD(2131233833);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareImageSelectorUI oXW;

            {
                this.oXW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oXW.awV();
                return false;
            }
        });
        this.oIf = getIntent().getIntExtra("Select_Conv_Type", 2);
        this.hgx = getIntent().getStringExtra("intent_extra_image_path");
        this.fil = findViewById(2131757315);
        this.fqF = (ImageView) findViewById(f.Jm);
        this.fqF.setOnClickListener(this.oXV);
        this.Eq = (ListView) findViewById(2131756740);
        this.oXT = new a(this);
        this.Eq.setAdapter(this.oXT);
        this.Eq.setOnItemClickListener(this);
        v.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", this.oIf, this.hgx);
        if (oXS == 1) {
            vB(8);
            this.Eq.setVisibility(8);
            this.fqF.setLayoutParams(new LayoutParams(-1, -1));
            this.fqF.setPadding(0, 0, 0, 0);
            this.fqF.setOnClickListener(null);
            this.fil.setBackgroundColor(getResources().getColor(2131689641));
            bJN();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap lW = j.lW(this.hgx);
        v.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", Integer.valueOf(ExifHelper.JQ(this.hgx)));
        lW = d.b(lW, (float) r3);
        if (!(lW == null || lW.isRecycled())) {
            this.fqF.setImageBitmap(lW);
        }
        v.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", (System.currentTimeMillis() - currentTimeMillis) + "'");
    }

    protected final int NO() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (oXS != 1) {
            return;
        }
        if (this.oXU == null || !this.oXU.isShowing()) {
            bJN();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                bJO();
                return;
            case 1:
                bJP();
                return;
            case 2:
                bJQ();
                return;
            default:
                v.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                if (i2 == -1) {
                    ArrayList arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getStringArrayListExtra("Select_Contact");
                    }
                    if (arrayList != null && arrayList.size() == 1) {
                        Intent intent2 = new Intent(this, ChattingUI.class);
                        intent2.putExtra("Chat_User", (String) arrayList.get(0));
                        startActivity(intent2);
                    }
                    finish();
                    return;
                }
                v.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                return;
            case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                if (i2 == -1) {
                    Toast.makeText(this.nDR.nEl, 2131231978, 0).show();
                    finish();
                    return;
                }
                v.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                return;
            default:
                v.w("MicroMsg.ShareImageSelectorUI", "unknow result");
                return;
        }
    }

    public void onBackPressed() {
        awV();
    }

    private void awV() {
        g.a(this.nDR.nEl, getString(2131232250), getString(2131232252), true, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ ShareImageSelectorUI oXW;

            {
                this.oXW = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.oXW.finish();
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ ShareImageSelectorUI oXW;

            {
                this.oXW = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (ShareImageSelectorUI.oXS == 1) {
                    this.oXW.bJN();
                }
            }
        });
    }

    private void bJN() {
        if (this.oXU == null || !this.oXU.isShowing()) {
            this.oXU = g.a(this.nDR.nEl, getString(2131233833), new String[]{getString(2131232254), getString(2131232255), getString(2131232253)}, null, new g.c(this) {
                final /* synthetic */ ShareImageSelectorUI oXW;

                {
                    this.oXW = r1;
                }

                public final void gT(int i) {
                    switch (i) {
                        case 0:
                            this.oXW.bJO();
                            return;
                        case 1:
                            this.oXW.bJP();
                            return;
                        case 2:
                            this.oXW.bJQ();
                            return;
                        default:
                            return;
                    }
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ ShareImageSelectorUI oXW;

                {
                    this.oXW = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oXW.awV();
                }
            });
        }
    }

    private void bJO() {
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", r.oHP);
        intent.putExtra("titile", getString(2131230879));
        intent.putExtra("list_type", 11);
        intent.putExtra("shareImage", true);
        intent.putExtra("shareImagePath", this.hgx);
        startActivityForResult(intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
    }

    private void bJP() {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", this.hgx);
        intent.putExtra("need_result", true);
        com.tencent.mm.ay.c.b(this.nDR.nEl, "sns", ".ui.SnsUploadUI", intent, MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
    }

    private void bJQ() {
        bp bpVar = new bp();
        com.tencent.mm.pluginsdk.model.d.a(bpVar, 6, this.hgx);
        bpVar.aZd.aXH = this;
        bpVar.aZd.aZl = 52;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
        com.tencent.mm.plugin.report.service.g.iuh.h(11048, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0));
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(0, 800);
        }
    }
}
