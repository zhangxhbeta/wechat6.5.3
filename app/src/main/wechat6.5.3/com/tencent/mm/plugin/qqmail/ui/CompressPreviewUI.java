package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.qqmail.b.q;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompressPreviewUI extends MMActivity {
    private ProgressBar edA;
    private String iaq = null;
    private String ibe = null;
    private String icG;
    private long idY = 0;
    private List<a> idZ = new ArrayList();
    private c idh = new c(this);
    private String iea;
    private ListView ieb;
    private TextView iec;
    private b ied;
    private com.tencent.mm.plugin.qqmail.b.q.a iee = new com.tencent.mm.plugin.qqmail.b.q.a(this) {
        final /* synthetic */ CompressPreviewUI ief;

        {
            this.ief = r1;
        }

        public final void onSuccess(String str, Map<String, String> map) {
            this.ief.iea = (String) map.get(".Response.result.compressfilepath");
            int i = be.getInt((String) map.get(".Response.result.filelist.count"), 0);
            int i2 = 0;
            while (i2 < i) {
                try {
                    String str2 = ".Response.result.filelist.list.item" + (i2 > 0 ? Integer.valueOf(i2) : "");
                    String str3 = (String) map.get(str2 + ".path");
                    if (str3 != null) {
                        String str4;
                        String decode = URLDecoder.decode(str3, ProtocolPackage.ServerEncoding);
                        String str5 = (String) map.get(str2 + ".parentpath");
                        int i3 = be.getInt((String) map.get(str2 + ".size"), 0);
                        int i4 = be.getInt((String) map.get(str2 + ".type"), 0);
                        boolean equals = ((String) map.get(str2 + ".preview")).equals("1");
                        String str6 = (String) map.get(str2 + ".name");
                        List h = this.ief.idZ;
                        CompressPreviewUI compressPreviewUI = this.ief;
                        if (i3 == 0) {
                            str4 = "";
                        } else {
                            str4 = "(" + be.aw((long) i3) + ")";
                        }
                        h.add(new a(compressPreviewUI, decode, str6, str5, i4, str4, equals));
                    }
                    i2++;
                } catch (Throwable e) {
                    v.a("MicroMsg.CompressPreviewUI", e, "", new Object[0]);
                }
            }
            this.ief.yh("");
        }

        public final void onError(int i, String str) {
            if (i == -5) {
                this.ief.idh.a(new com.tencent.mm.plugin.qqmail.ui.c.a(this) {
                    final /* synthetic */ AnonymousClass5 ieg;

                    {
                        this.ieg = r1;
                    }

                    public final void aHJ() {
                        this.ieg.ief.aHY();
                    }

                    public final void aHK() {
                    }
                });
                return;
            }
            this.ief.edA.setVisibility(8);
            this.ief.iec.setVisibility(0);
            this.ief.ieb.setVisibility(8);
        }
    };

    private class a {
        String id;
        final /* synthetic */ CompressPreviewUI ief;
        String ieh;
        String iei;
        boolean iej;
        String name;
        int type;

        public a(CompressPreviewUI compressPreviewUI, String str, String str2, String str3, int i, String str4, boolean z) {
            this.ief = compressPreviewUI;
            this.id = str;
            this.name = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.ieh = str3;
            this.type = i;
            this.iei = str4;
            this.iej = z;
        }

        public final boolean aHZ() {
            return this.type == 1;
        }
    }

    private class b extends BaseAdapter {
        final /* synthetic */ CompressPreviewUI ief;
        a iek;
        List<a> iel;

        private class a {
            TextView eVA;
            ImageView eZn;
            TextView iem;
            ImageView ien;
            final /* synthetic */ b ieo;

            private a(b bVar) {
                this.ieo = bVar;
            }
        }

        private b(CompressPreviewUI compressPreviewUI) {
            this.ief = compressPreviewUI;
            this.iel = null;
        }

        public final /* synthetic */ Object getItem(int i) {
            return oy(i);
        }

        public final String aIa() {
            if (this.iek == null || this.iek.ieh == null) {
                return null;
            }
            if (this.iek.ieh.length() == 0) {
                return "";
            }
            int indexOf = this.iek.id.indexOf(this.iek.ieh);
            if (indexOf >= 0) {
                return this.iek.id.substring(0, indexOf) + this.iek.ieh;
            }
            return null;
        }

        public final int getCount() {
            return this.iel != null ? this.iel.size() : 0;
        }

        public final a oy(int i) {
            return (this.iel == null || this.iel.size() <= i) ? null : (a) this.iel.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;
            int HU;
            if (view == null) {
                view = View.inflate(this.ief.nDR.nEl, 2130903912, null);
                a aVar = new a();
                aVar.eZn = (ImageView) view.findViewById(2131757974);
                aVar.eVA = (TextView) view.findViewById(2131757437);
                aVar.iem = (TextView) view.findViewById(2131757975);
                aVar.ien = (ImageView) view.findViewById(2131757976);
                view.setTag(aVar);
            }
            a aVar2 = (a) view.getTag();
            a oy = oy(i);
            if (i != 0 || aIa() == null) {
                imageView = aVar2.eZn;
                HU = oy.aHZ() ? 2130838941 : FileExplorerUI.HU(oy.name);
            } else {
                imageView = aVar2.eZn;
                HU = 2130838940;
            }
            imageView.setImageResource(HU);
            aVar2.ien.setVisibility(oy.iej ? 0 : 4);
            aVar2.eVA.setText(oy.name);
            aVar2.iem.setText(oy.iei);
            return view;
        }
    }

    protected final int getLayoutId() {
        return 2130903913;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iaq = getIntent().getStringExtra("mail_id");
        this.ibe = getIntent().getStringExtra("attach_id");
        this.idY = getIntent().getLongExtra("attach_size", 0);
        this.icG = getIntent().getStringExtra("attach_name");
        NI();
        Fd(this.icG);
    }

    protected final void NI() {
        this.ieb = (ListView) findViewById(2131757977);
        this.iec = (TextView) findViewById(2131757978);
        this.edA = (ProgressBar) findViewById(2131757979);
        if (this.iaq == null || this.ibe == null) {
            this.edA.setVisibility(8);
            this.iec.setText(2131233690);
            return;
        }
        this.ied = new b();
        this.ieb.setAdapter(this.ied);
        this.ieb.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CompressPreviewUI ief;

            {
                this.ief = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a oy = this.ief.ied.oy(i);
                String str = oy.id;
                b a = this.ief.ied;
                if (str.equals(a.iek == null ? null : a.iek.id)) {
                    this.ief.yh(this.ief.ied.aIa());
                } else if (oy.aHZ()) {
                    this.ief.yh(oy.id);
                } else if (oy.iej) {
                    String[] strArr = new String[]{"mailid=" + this.ief.iaq, "attachid=" + oy.id, "compressfilepath=" + this.ief.iea, "texttype=html"};
                    Intent intent = new Intent(this.ief, MailWebViewUI.class);
                    intent.putExtra("uri", "/cgi-bin/viewdocument");
                    intent.putExtra("params", strArr);
                    intent.putExtra("baseurl", q.aHA());
                    intent.putExtra("method", "get");
                    intent.putExtra("singleColumn", FileExplorerUI.HV(oy.name));
                    intent.putExtra("title", this.ief.getString(2131234327));
                    this.ief.startActivity(intent);
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CompressPreviewUI ief;

            {
                this.ief = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ief.onKeyDown(4, null);
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ CompressPreviewUI ief;

            {
                this.ief = r1;
            }

            public final void onClick(View view) {
                c.a(this.ief.ieb);
            }
        };
        a(0, getString(2131231024), new OnMenuItemClickListener(this) {
            final /* synthetic */ CompressPreviewUI ief;

            {
                this.ief = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(this.ief, AttachDownloadPage.class);
                intent.putExtra("attach_name", this.ief.icG);
                intent.putExtra("mail_id", this.ief.iaq);
                intent.putExtra("attach_id", this.ief.ibe);
                intent.putExtra("total_size", this.ief.idY);
                intent.putExtra("is_preview", 0);
                intent.putExtra("is_compress", true);
                this.ief.startActivity(intent);
                return true;
            }
        });
        aHY();
    }

    public void onDestroy() {
        super.onDestroy();
        this.idh.release();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ied.aIa() != null) {
            yh(this.ied.aIa());
            return true;
        } else if (keyEvent != null) {
            return super.onKeyDown(i, keyEvent);
        } else {
            finish();
            return true;
        }
    }

    private void yh(String str) {
        v.i("MicroMsg.CompressPreviewUI", "curPath=" + str);
        this.edA.setVisibility(8);
        this.iec.setVisibility(8);
        this.ieb.setVisibility(0);
        a yi = yi(str);
        List arrayList = new ArrayList();
        if (yi != null) {
            arrayList.add(yi);
        }
        for (int i = 0; i < this.idZ.size(); i++) {
            a aVar = (a) this.idZ.get(i);
            if ((str.endsWith(aVar.ieh) && aVar.ieh.length() > 0) || aVar.ieh.equals(str)) {
                arrayList.add(aVar);
            }
        }
        b bVar = this.ied;
        bVar.iek = yi;
        bVar.iel = arrayList;
        this.ied.notifyDataSetChanged();
        this.ieb.setSelection(0);
    }

    private a yi(String str) {
        for (a aVar : this.idZ) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private void aHY() {
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.iaq);
        hashMap.put("attachid", this.ibe);
        hashMap.put("fun", "list");
        x.aHG().a("/cgi-bin/viewcompress", hashMap, new q.c(), this.iee);
    }
}
