package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.qqmail.b.h.d;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.q.c;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.plugin.qqmail.b.z;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements e {
    private TextView icZ;
    private ImageView ida;
    ComposeUI ieD;
    ViewGroup ieE;
    Map<String, z> ieF;
    Map<String, p> ieG;
    Map<String, String> ieH;
    Map<String, String> ieI;
    b ieJ;
    private OnClickListener ieK;
    int mode;

    private class a {
        TextView eVA;
        ImageView eZn;
        final /* synthetic */ b ieM;
        ProgressBar ieT;
        TextView ieU;
        ImageView ieV;
        ImageView ieW;
        TextView iem;

        private a(b bVar) {
            this.ieM = bVar;
        }
    }

    public interface b {
        void aHW();

        void onComplete();
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.aIe()) {
            Object obj;
            for (String str : bVar.ieF.keySet()) {
                if (((z) bVar.ieF.get(str)).state != 2) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
            if (obj != null && bVar.ieJ != null) {
                bVar.ieJ.onComplete();
            }
        } else if (bVar.ieJ != null) {
            b bVar2 = bVar.ieJ;
            bVar.ieF.size();
            for (String str2 : bVar.ieF.keySet()) {
                if (((z) bVar.ieF.get(str2)).state != 2) {
                    break;
                }
            }
            bVar2.aHW();
        }
    }

    private b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup) {
        this.ieF = new HashMap();
        this.ieG = new HashMap();
        this.ieH = new LinkedHashMap();
        this.ieI = new LinkedHashMap();
        this.ieJ = null;
        this.ieK = null;
        this.mode = 5;
        this.ieD = composeUI;
        this.ieE = viewGroup;
        this.ieK = null;
        this.icZ = textView;
        this.ida = imageView;
        aIf();
        ak.vy().a(484, this);
    }

    public b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup, byte b) {
        this(composeUI, textView, imageView, viewGroup);
    }

    public final void ba(List<z> list) {
        if (list != null) {
            for (z zVar : list) {
                a(zVar);
                this.ieF.put(zVar.path, zVar);
            }
            if (this.mode == 6) {
                for (z zVar2 : list) {
                    this.ieH.put(zVar2.path, zVar2.icm);
                    this.ieI.put(zVar2.path, zVar2.name);
                }
            }
        }
    }

    public final void cm(String str, String str2) {
        if (str != null && str.length() != 0 && !this.ieF.containsKey(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                z zVar = new z();
                zVar.path = str;
                if (str2 == null) {
                    zVar.name = file.getName();
                } else {
                    zVar.name = str2;
                }
                zVar.size = file.length();
                zVar.state = 0;
                this.ieF.put(str, zVar);
                a(zVar);
            }
        }
    }

    private void a(final z zVar) {
        final LinearLayout linearLayout = (LinearLayout) ((ViewGroup) View.inflate(this.ieD, 2130904212, null)).findViewById(2131758692);
        ImageView imageView = (ImageView) linearLayout.findViewById(2131758693);
        TextView textView = (TextView) linearLayout.findViewById(2131758694);
        TextView textView2 = (TextView) linearLayout.findViewById(2131758695);
        ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(2131758696);
        TextView textView3 = (TextView) linearLayout.findViewById(2131758697);
        final ImageView imageView2 = (ImageView) linearLayout.findViewById(2131758698);
        ImageView imageView3 = (ImageView) linearLayout.findViewById(2131758699);
        ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
        imageView.setImageResource(FileExplorerUI.HU(zVar.name));
        textView.setText(zVar.name);
        textView2.setText(be.aw(zVar.size));
        a aVar = new a();
        aVar.eZn = imageView;
        aVar.eVA = textView;
        aVar.iem = textView2;
        aVar.ieT = progressBar;
        aVar.ieU = textView3;
        aVar.ieV = imageView2;
        aVar.ieW = imageView3;
        linearLayout.setTag(aVar);
        linearLayout.setId(Math.abs(zVar.path.hashCode() / 2));
        if (this.ieK != null) {
            linearLayout.setOnClickListener(this.ieK);
        }
        this.ieE.addView(linearLayout);
        aIf();
        linearLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b ieM;

            public final void onClick(View view) {
                if (imageView2.getVisibility() == 0) {
                    imageView2.performClick();
                }
            }
        });
        imageView2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b ieM;

            public final void onClick(View view) {
                if (this.ieM.mode == 5) {
                    zVar.icl = this.ieM.yj(zVar.path);
                } else if (this.ieM.mode == 6) {
                    zVar.icl = this.ieM.cn(zVar.path, zVar.name);
                }
            }
        });
        imageView3.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b ieM;

            public final void onClick(View view) {
                g.a(this.ieM.ieD, 2131234190, 2131231164, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 ieP;

                    {
                        this.ieP = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (zVar.state == 0 || zVar.state == 1) {
                            b bVar = this.ieP.ieM;
                            z zVar = zVar;
                            if (bVar.mode == 5) {
                                x.aHG().cancel(zVar.icl);
                            } else if (bVar.mode == 6) {
                                p pVar = (p) bVar.ieG.get(zVar.path);
                                if (pVar != null) {
                                    ak.vy().c(pVar);
                                }
                                bVar.ieH.remove(zVar.path);
                                bVar.ieI.remove(zVar.path);
                            }
                        }
                        this.ieP.ieM.ieF.remove(zVar.path);
                        this.ieP.ieM.ieG.remove(zVar.path);
                        this.ieP.ieM.ieH.remove(zVar.path);
                        this.ieP.ieM.ieI.remove(zVar.path);
                        this.ieP.ieM.ieE.removeView(linearLayout);
                        this.ieP.ieM.aIf();
                    }
                }, null);
            }
        });
        this.ieE.post(new Runnable(this) {
            final /* synthetic */ b ieM;

            public final void run() {
                this.ieM.b(zVar);
            }
        });
        if (zVar.state != 0) {
            return;
        }
        if (this.mode == 5) {
            zVar.icl = yj(zVar.path);
        } else if (this.mode == 6) {
            zVar.icl = cn(zVar.path, zVar.name);
        }
    }

    public final String aIb() {
        String str = "";
        for (String str2 : this.ieF.keySet()) {
            if (str.length() > 0) {
                str = str + "|";
            }
            str = str + ((z) this.ieF.get(str2)).icm;
        }
        return str;
    }

    public final LinkedList<z> aIc() {
        LinkedList<z> linkedList = new LinkedList();
        for (String str : this.ieF.keySet()) {
            linkedList.add(this.ieF.get(str));
        }
        return linkedList;
    }

    public final void aId() {
        z zVar;
        if (this.mode == 5) {
            for (String str : this.ieF.keySet()) {
                zVar = (z) this.ieF.get(str);
                if (zVar.state != 2) {
                    x.aHG().cancel(zVar.icl);
                    zVar.state = 3;
                    b(zVar);
                }
            }
        } else if (this.mode == 6) {
            for (String str2 : this.ieF.keySet()) {
                zVar = (z) this.ieF.get(str2);
                if (zVar.state != 2) {
                    p pVar = (p) this.ieG.get(zVar.path);
                    if (pVar != null) {
                        ak.vy().c(pVar);
                        zVar.state = 3;
                        b(zVar);
                    }
                    this.ieH.remove(zVar.path);
                    this.ieI.remove(zVar.path);
                    this.ieG.remove(zVar.path);
                }
            }
        }
    }

    final long yj(final String str) {
        c cVar = new c();
        cVar.ibw = false;
        cVar.ibv = true;
        return x.aHG().a("/cgi-bin/uploaddata", 1, null, new d("UploadFile", str), cVar, new com.tencent.mm.plugin.qqmail.b.q.a(this) {
            final /* synthetic */ b ieM;

            public final boolean onReady() {
                z zVar = (z) this.ieM.ieF.get(str);
                if (zVar != null) {
                    zVar.state = 1;
                    this.ieM.b(zVar);
                }
                return true;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                String str2 = (String) map.get(".Response.result.DataID");
                z zVar = (z) this.ieM.ieF.get(str);
                if (zVar != null) {
                    zVar.state = 2;
                    zVar.icm = str2;
                    this.ieM.b(zVar);
                }
            }

            public final void onError(int i, String str) {
                v.e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", new Object[]{Integer.valueOf(i), str});
                z zVar = (z) this.ieM.ieF.get(str);
                if (zVar != null) {
                    zVar.state = 3;
                    this.ieM.b(zVar);
                }
                if (i == -5) {
                    this.ieM.ieD.idh.a(new com.tencent.mm.plugin.qqmail.ui.c.a(this) {
                        final /* synthetic */ AnonymousClass5 ieQ;

                        {
                            this.ieQ = r1;
                        }

                        public final void aHJ() {
                        }

                        public final void aHK() {
                        }
                    });
                }
            }

            public final void onComplete() {
                b.a(this.ieM);
            }
        });
    }

    final long cn(final String str, final String str2) {
        if (this.ieG.containsKey(str)) {
            return (long) ((p) this.ieG.get(str)).hashCode();
        }
        p pVar = new p(str, str, new f(this) {
            final /* synthetic */ b ieM;

            public final void a(int i, int i2, k kVar) {
                v.i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                final z zVar;
                if (i < i2) {
                    v.i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
                    zVar = (z) this.ieM.ieF.get(str);
                    if (zVar != null) {
                        zVar.state = 1;
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 ieS;

                            public final void run() {
                                this.ieS.ieM.b(zVar);
                            }
                        });
                    }
                } else if (i >= i2) {
                    zVar = (z) this.ieM.ieF.get(str);
                    String str = ((p) kVar).aHz().mon;
                    this.ieM.ieH.put(str, str);
                    this.ieM.ieI.put(str, str2);
                    this.ieM.ieG.remove(str);
                    v.i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", new Object[]{str, str});
                    if (zVar != null) {
                        zVar.state = 2;
                        zVar.icm = str;
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 ieS;

                            public final void run() {
                                this.ieS.ieM.b(zVar);
                            }
                        });
                    }
                    b.a(this.ieM);
                }
            }
        });
        z zVar = (z) this.ieF.get(str);
        if (zVar != null) {
            zVar.state = 1;
        }
        b(zVar);
        ak.vy().a(pVar, 0);
        this.ieG.put(str, pVar);
        return (long) pVar.hashCode();
    }

    public final boolean aIe() {
        for (String str : this.ieF.keySet()) {
            z zVar = (z) this.ieF.get(str);
            if (zVar.state != 2 && zVar.state != 3) {
                return false;
            }
        }
        return true;
    }

    public final void aIf() {
        if (this.ieF.size() == 0) {
            this.icZ.setText(this.ieD.getString(2131234197) + " " + this.ieD.getString(2131234200));
            this.ida.setImageResource(2131165852);
            ((View) this.ieE.getParent()).setVisibility(8);
        } else {
            this.icZ.setText(this.ieD.getString(2131234197) + this.ieD.getResources().getQuantityString(2131361815, this.ieF.size(), new Object[]{Integer.valueOf(this.ieF.size()), be.aw((long) VI())}));
            this.ida.setImageResource(2131165853);
            ((View) this.ieE.getParent()).setVisibility(0);
        }
        int childCount = this.ieE.getChildCount();
        int i = 0;
        while (i < childCount) {
            if (childCount == 1) {
                this.ieE.getChildAt(i).setBackgroundResource(2130838606);
            } else if (i == 0) {
                this.ieE.getChildAt(i).setBackgroundResource(2130838607);
            } else if (i <= 0 || i >= childCount - 1) {
                this.ieE.getChildAt(i).setBackgroundResource(2130838609);
            } else {
                this.ieE.getChildAt(i).setBackgroundResource(2130838608);
            }
            i++;
        }
    }

    public final int VI() {
        int i = 0;
        for (String str : this.ieF.keySet()) {
            long j = (long) i;
            i = (int) (((z) this.ieF.get(str)).size + j);
        }
        return i;
    }

    final void b(z zVar) {
        LinearLayout linearLayout = (LinearLayout) this.ieE.findViewById(Math.abs(zVar.path.hashCode() / 2));
        if (linearLayout != null) {
            a aVar = (a) linearLayout.getTag();
            switch (zVar.state) {
                case 0:
                case 1:
                    aVar.eVA.setTextColor(-16777216);
                    aVar.ieT.setVisibility(0);
                    aVar.ieU.setVisibility(8);
                    aVar.ieV.setVisibility(8);
                    aVar.ieW.setVisibility(0);
                    return;
                case 2:
                    aVar.eVA.setTextColor(-16777216);
                    aVar.ieT.setVisibility(8);
                    aVar.ieU.setVisibility(8);
                    aVar.ieV.setVisibility(8);
                    aVar.ieW.setVisibility(0);
                    return;
                case 3:
                    aVar.eVA.setTextColor(com.tencent.mm.bd.a.b(this.ieD, 2131689817));
                    aVar.ieT.setVisibility(8);
                    aVar.ieU.setVisibility(0);
                    aVar.ieV.setVisibility(0);
                    aVar.ieW.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 484) {
            p pVar = (p) kVar;
            String str2 = pVar.filePath;
            final z zVar = (z) this.ieF.get(str2);
            if (zVar == null) {
                return;
            }
            if (i != 0 || i2 != 0) {
                v.e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str2});
                zVar.state = 3;
                this.ieG.remove(str2);
                ak.vy().c(pVar);
                ad.o(new Runnable(this) {
                    final /* synthetic */ b ieM;

                    public final void run() {
                        this.ieM.b(zVar);
                    }
                });
            }
        }
    }
}
