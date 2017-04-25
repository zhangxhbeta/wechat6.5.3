package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import b.a.d.i;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.e.h;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.ui.tools.SightCaptureResult;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ad implements w {
    MMActivity aWn;
    private String appId;
    private String appName;
    private int jEZ;
    private com.tencent.mm.modelsns.a jFg = null;
    private String jGE;
    private boolean jGx = false;
    private boolean jGy = false;
    private WXMediaMessage jGz = null;
    Map<String, com.tencent.mm.compatible.util.Exif.a> jIA = new HashMap();
    private Map<String, awr> jIB = new HashMap();
    private int jIC = 0;
    private boolean jID = false;
    agp jIE;
    b jIx = new b(this);
    private PreviewImageView jIy;
    private boolean jIz = false;

    class b {
        final /* synthetic */ ad jIF;
        ArrayList<String> jIJ = new ArrayList();
        Map<String, Integer> jIK = new HashMap();

        b(ad adVar) {
            this.jIF = adVar;
        }

        public final b ba(String str, int i) {
            this.jIJ.add(str);
            this.jIK.put(str, Integer.valueOf(i));
            return this;
        }

        public final String toString() {
            Iterator it = this.jIJ.iterator();
            String str = "";
            while (it.hasNext()) {
                String str2 = (String) it.next();
                int i = 0;
                if (this.jIK != null) {
                    i = ((Integer) this.jIK.get(str2)).intValue();
                }
                str = str + str2 + "," + i + ";";
            }
            return str;
        }

        public final b BY(String str) {
            try {
                for (String split : str.split(";")) {
                    String[] split2 = split.split(",");
                    this.jIJ.add(split2[0]);
                    this.jIK.put(split2[0], Integer.valueOf(be.getInt(split2[1], 0)));
                }
            } catch (Exception e) {
            }
            return this;
        }
    }

    class a extends h<String, Integer, Boolean> {
        private ProgressDialog dwR = null;
        private au jHo;
        final /* synthetic */ ad jIF;
        private List<com.tencent.mm.plugin.sns.data.h> jIG;

        public final /* synthetic */ Object aRX() {
            long currentTimeMillis = System.currentTimeMillis();
            au auVar = this.jHo;
            auVar.bp(this.jIG);
            this.jHo = auVar;
            v.d("MicroMsg.MMAsyncTask", "commit imp time " + (System.currentTimeMillis() - currentTimeMillis));
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            this.dwR.dismiss();
            this.jIF.b(this.jHo);
        }

        public a(final ad adVar, au auVar, List<com.tencent.mm.plugin.sns.data.h> list) {
            this.jIF = adVar;
            this.jHo = auVar;
            this.jIG = list;
            MMActivity mMActivity = adVar.aWn;
            adVar.aWn.getString(2131231164);
            this.dwR = g.a(mMActivity, adVar.aWn.getString(2131231085), false, new OnCancelListener(this) {
                final /* synthetic */ a jII;

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }

        public final ac aRW() {
            return com.tencent.mm.plugin.sns.e.ad.aSr();
        }
    }

    public ad(MMActivity mMActivity) {
        this.aWn = mMActivity;
    }

    public final void v(Bundle bundle) {
        String str;
        int i = 1;
        this.jFg = com.tencent.mm.modelsns.a.m(this.aWn.getIntent());
        this.jIz = this.aWn.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.appId = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.jGx = this.aWn.getIntent().getBooleanExtra("KThrid_app", false);
        this.jID = this.aWn.getIntent().getBooleanExtra("KBlockAdd", false);
        this.jGy = this.aWn.getIntent().getBooleanExtra("KSnsAction", false);
        this.jEZ = this.aWn.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.jGE = be.ah(this.aWn.getIntent().getStringExtra("reportSessionId"), "");
        Bundle bundleExtra = this.aWn.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.jGz = new com.tencent.mm.sdk.modelmsg.c.a(bundleExtra).nhM;
        }
        String stringExtra = this.aWn.getIntent().getStringExtra("sns_kemdia_path");
        byte[] byteArrayExtra = this.aWn.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (byteArrayExtra == null && this.jGz != null && this.jGz.mediaObject != null && (this.jGz.mediaObject instanceof WXImageObject)) {
            byteArrayExtra = ((WXImageObject) this.jGz.mediaObject).imageData;
        }
        if (!be.kS(stringExtra) || be.bl(byteArrayExtra)) {
            str = stringExtra;
        } else {
            stringExtra = com.tencent.mm.plugin.sns.e.ad.xi() + com.tencent.mm.a.g.m((" " + System.currentTimeMillis()).getBytes());
            FileOp.deleteFile(stringExtra);
            FileOp.b(stringExtra, byteArrayExtra, byteArrayExtra.length);
            str = stringExtra;
        }
        int intExtra = this.aWn.getIntent().getIntExtra("KFilterId", 0);
        stringExtra = bundle == null ? null : bundle.getString("sns_kemdia_path_list");
        x(bundle);
        boolean x = x(this.aWn.getIntent().getExtras());
        this.jIC = 0;
        if (!be.kS(stringExtra)) {
            this.jIx.BY(stringExtra);
        } else if (be.kS(str)) {
            ArrayList stringArrayListExtra = this.aWn.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    v.d("MicroMsg.PicWidget", "newPath " + str);
                    this.jIx.ba(str, intExtra);
                    if (!x) {
                        r1 = Exif.fromFile(str).getLocation();
                        if (r1 != null) {
                            this.jIA.put(str, r1);
                        }
                    }
                    try {
                        File file = new File(str);
                        awr com_tencent_mm_protocal_c_awr = new awr();
                        com_tencent_mm_protocal_c_awr.mUe = this.jIz ? 1 : 2;
                        com_tencent_mm_protocal_c_awr.mUg = file.lastModified() / 1000;
                        com_tencent_mm_protocal_c_awr.mUf = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.jIB.put(str, com_tencent_mm_protocal_c_awr);
                    } catch (Exception e) {
                        v.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                }
            }
        } else {
            int i2;
            String str2 = com.tencent.mm.plugin.sns.e.ad.xi() + "pre_temp_sns_pic" + com.tencent.mm.a.g.m(str.getBytes());
            FileOp.p(str, str2);
            if (intExtra == -1) {
                i2 = 0;
            } else {
                i2 = intExtra;
            }
            this.jIx.ba(str2, i2);
            if (!x) {
                r1 = Exif.fromFile(str).getLocation();
                if (r1 != null) {
                    this.jIA.put(str2, r1);
                }
            }
            try {
                File file2 = new File(str);
                awr com_tencent_mm_protocal_c_awr2 = new awr();
                if (!this.jIz) {
                    i = 2;
                }
                com_tencent_mm_protocal_c_awr2.mUe = i;
                com_tencent_mm_protocal_c_awr2.mUg = file2.lastModified() / 1000;
                com_tencent_mm_protocal_c_awr2.mUf = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                this.jIB.put(str2, com_tencent_mm_protocal_c_awr2);
            } catch (Exception e2) {
                v.e("MicroMsg.PicWidget", "get report info error " + e2.getMessage());
            }
        }
    }

    private boolean x(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        ArrayList stringArrayList = bundle.getStringArrayList("sns_media_latlong_list");
        if (stringArrayList == null) {
            return false;
        }
        Iterator it = stringArrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("\n");
            if (3 != split.length) {
                v.e("MicroMsg.PicWidget", "invalid params");
                return true;
            }
            try {
                this.jIA.put(split[0].trim(), new com.tencent.mm.compatible.util.Exif.a(be.getDouble(split[1], 0.0d), be.getDouble(split[2], 0.0d), 0.0d));
            } catch (NumberFormatException e) {
                v.e("MicroMsg.PicWidget", e.toString());
            }
        }
        return true;
    }

    public final void w(Bundle bundle) {
        bundle.putString("sns_kemdia_path_list", this.jIx.toString());
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.jIA.entrySet()) {
            arrayList.add(String.format("%s\n%f\n%f", new Object[]{entry.getKey(), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).latitude), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).longitude)}));
        }
        bundle.putStringArrayList("sns_media_latlong_list", arrayList);
        bundle.getString("contentdesc");
    }

    public final boolean aVy() {
        if (this.jIx != null) {
            b bVar = this.jIx;
            boolean z = bVar.jIJ != null && bVar.jIJ.size() > 0;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final View aVz() {
        this.jIy = new PreviewImageView(this.aWn);
        if (this.jID) {
            this.jIy.jIR = false;
        }
        this.jIy.jIQ = new a(this) {
            final /* synthetic */ ad jIF;

            {
                this.jIF = r1;
            }

            public final void qR(int i) {
                v.d("MicroMsg.PicWidget", "I click");
                if (i < 0) {
                    this.jIF.aWj();
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(this.jIF.aWn, SnsUploadBrowseUI.class);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_temp_paths", this.jIF.jIx.jIJ);
                this.jIF.aWn.startActivityForResult(intent, 7);
            }
        };
        this.jIy.bw(this.jIx.jIJ);
        return this.jIy;
    }

    private static au a(au auVar, List<com.tencent.mm.plugin.sns.data.h> list) {
        auVar.bp(list);
        return auVar;
    }

    final void b(au auVar) {
        int commit = auVar.commit();
        if (this.jFg != null) {
            this.jFg.gj(commit);
            e.jtT.c(this.jFg);
        }
        if (!(this.jIx == null || this.jIx.jIJ == null || !p.aVg())) {
            com.tencent.mm.plugin.report.service.g.iuh.h(12834, new Object[]{Integer.valueOf(this.jIx.jIJ.size())});
        }
        Intent intent = new Intent();
        intent.putExtra("sns_local_id", commit);
        this.aWn.setResult(-1, intent);
        this.aWn.finish();
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, agp com_tencent_mm_protocal_c_agp, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        List<com.tencent.mm.plugin.sns.data.h> linkedList = new LinkedList();
        Iterator it = this.jIx.jIJ.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            String str3 = (String) it.next();
            com.tencent.mm.plugin.sns.data.h hVar = new com.tencent.mm.plugin.sns.data.h(str3, 2);
            hVar.type = 2;
            hVar.jdU = i;
            if (i6 == 0) {
                hVar.jdT = i2;
                if (iVar != null) {
                    hVar.jdW = iVar.token;
                    hVar.jdX = iVar.mIu;
                }
            } else {
                hVar.jdT = 0;
            }
            i6++;
            b bVar = this.jIx;
            hVar.jdS = bVar.jIK.containsKey(str3) ? ((Integer) bVar.jIK.get(str3)).intValue() : 0;
            hVar.desc = str;
            linkedList.add(hVar);
        }
        LinkedList linkedList2 = new LinkedList();
        if (list != null) {
            LinkedList linkedList3 = new LinkedList();
            List yv = m.yv();
            for (String str32 : list) {
                if (!yv.contains(str32)) {
                    axj com_tencent_mm_protocal_c_axj = new axj();
                    com_tencent_mm_protocal_c_axj.gln = str32;
                    linkedList2.add(com_tencent_mm_protocal_c_axj);
                }
            }
        }
        au auVar = new au(1);
        pInt.value = auVar.job;
        if (iVar != null) {
            auVar.cE(iVar.token, iVar.mIu);
        }
        if (i3 > com.tencent.mm.plugin.sns.b.a.jdC) {
            auVar.qk(3);
        }
        auVar.AG(str).a(com_tencent_mm_protocal_c_agp).Y(linkedList2).qm(i).qn(i2);
        if (z) {
            auVar.qp(1);
        } else {
            auVar.qp(0);
        }
        if (!be.kS(this.appId)) {
            auVar.AM(this.appId);
        }
        if (!be.kS(this.appName)) {
            auVar.AN(be.ah(this.appName, ""));
        }
        auVar.qo(this.jEZ);
        if (this.jGx) {
            auVar.qo(5);
        }
        if (this.jGy && this.jGz != null) {
            auVar.AH(this.jGz.mediaTagName);
            auVar.N(this.appId, this.jGz.messageExt, this.jGz.messageAction);
        }
        auVar.d(null, null, null, i4, i5);
        auVar.bo(list2);
        auVar.AQ(this.jGE);
        v.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(this.jIC)});
        com.tencent.mm.plugin.report.service.g.iuh.h(11602, new Object[]{Integer.valueOf(this.jIC), Integer.valueOf(linkedList.size())});
        for (com.tencent.mm.plugin.sns.data.h hVar2 : linkedList) {
            v.i("MicroMsg.PicWidget", "commit path  %s len: %d", new Object[]{hVar2.path, Long.valueOf(FileOp.jP(hVar2.path))});
        }
        for (com.tencent.mm.plugin.sns.data.h hVar22 : linkedList) {
            awr com_tencent_mm_protocal_c_awr;
            String str4 = hVar22.path;
            awr com_tencent_mm_protocal_c_awr2 = (awr) this.jIB.get(str4);
            if (com_tencent_mm_protocal_c_awr2 == null) {
                com_tencent_mm_protocal_c_awr = new awr();
            } else {
                com_tencent_mm_protocal_c_awr = com_tencent_mm_protocal_c_awr2;
            }
            if (this.jIE == null || (this.jIE.mjN == 0.0f && this.jIE.mjM == 0.0f)) {
                com_tencent_mm_protocal_c_awr.mUc = -1000.0f;
                com_tencent_mm_protocal_c_awr.mUd = -1000.0f;
            } else {
                com_tencent_mm_protocal_c_awr.mUc = this.jIE.mjN;
                com_tencent_mm_protocal_c_awr.mUd = this.jIE.mjM;
                com_tencent_mm_protocal_c_awr.jGV = this.jIE.jGV;
                com_tencent_mm_protocal_c_awr.aJp = this.jIE.aJp;
            }
            com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) this.jIA.get(str4);
            if (aVar == null || (aVar.latitude == 0.0d && aVar.longitude == 0.0d)) {
                com_tencent_mm_protocal_c_awr.mUa = -1000.0f;
                com_tencent_mm_protocal_c_awr.mUb = -1000.0f;
            } else {
                com_tencent_mm_protocal_c_awr.mUa = (float) aVar.latitude;
                com_tencent_mm_protocal_c_awr.mUb = (float) aVar.longitude;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("||index: " + auVar.jog.mIy.size());
            stringBuffer.append("||item poi lat " + com_tencent_mm_protocal_c_awr.mUc + " " + com_tencent_mm_protocal_c_awr.mUd);
            stringBuffer.append("||item pic lat " + com_tencent_mm_protocal_c_awr.mUa + " " + com_tencent_mm_protocal_c_awr.mUb);
            stringBuffer.append("||item exitime:" + com_tencent_mm_protocal_c_awr.mUf + " filetime: " + com_tencent_mm_protocal_c_awr.mUg);
            stringBuffer.append("||item source: " + com_tencent_mm_protocal_c_awr.mUe);
            v.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + stringBuffer.toString());
            auVar.jog.mIy.add(com_tencent_mm_protocal_c_awr);
        }
        if (linkedList.size() <= 1) {
            a(auVar, (List) linkedList);
            b(auVar);
        } else {
            new a(this, auVar, linkedList).l("");
        }
        return true;
    }

    protected final boolean aWj() {
        ak.yW();
        if (!c.isSDCardAvailable()) {
            s.ey(this.aWn);
            return false;
        } else if (this.jIx.jIJ.size() >= 9) {
            g.f(this.aWn, 2131235574, 2131231164);
            return false;
        } else {
            try {
                ax axVar = new ax(this.aWn);
                axVar.jXn = new n.c(this) {
                    final /* synthetic */ ad jIF;

                    {
                        this.jIF = r1;
                    }

                    public final void a(l lVar) {
                        if (!q.drg) {
                            lVar.d(0, this.jIF.aWn.getString(2131231049));
                        }
                        lVar.d(1, this.jIF.aWn.getString(2131231054));
                    }
                };
                axVar.b(0, this.aWn.getString(2131231052));
                axVar.jXo = new d(this) {
                    final /* synthetic */ ad jIF;

                    {
                        this.jIF = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (9 - this.jIF.jIx.jIJ.size() <= 0) {
                                    v.e("MicroMsg.PicWidget", "has select the max image count");
                                    return;
                                }
                                com.tencent.mm.plugin.report.service.g.iuh.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                                com.tencent.mm.pluginsdk.ui.tools.l.a(this.jIF.aWn, 11, new Intent(), 2, 2);
                                return;
                            case 1:
                                int size = 9 - this.jIF.jIx.jIJ.size();
                                if (size <= 0) {
                                    v.e("MicroMsg.PicWidget", "has select the max image count");
                                    return;
                                }
                                String string = this.jIF.aWn.getSharedPreferences(aa.bti(), 0).getString("gallery", "1");
                                com.tencent.mm.plugin.report.service.g.iuh.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                                if (string.equalsIgnoreCase("0")) {
                                    com.tencent.mm.pluginsdk.ui.tools.l.R(this.jIF.aWn);
                                    return;
                                } else {
                                    com.tencent.mm.pluginsdk.ui.tools.l.a(this.jIF.aWn, 9, size, 4, 1, false, null);
                                    return;
                                }
                            default:
                                return;
                        }
                    }
                };
                axVar.aXZ();
            } catch (Exception e) {
            }
            return true;
        }
    }

    public final boolean b(List<String> list, int i, boolean z) {
        if (list == null || list.size() == 0) {
            v.i("MicroMsg.PicWidget", "no image selected");
        } else if (this.jIx.jIJ.size() < 9) {
            for (String str : list) {
                if (FileOp.aR(str)) {
                    String str2 = "pre_temp_sns_pic" + com.tencent.mm.a.g.m((str + System.currentTimeMillis()).getBytes());
                    p.Q(com.tencent.mm.plugin.sns.e.ad.xi(), str, str2);
                    v.d("MicroMsg.PicWidget", "newPath " + com.tencent.mm.plugin.sns.e.ad.xi() + str2);
                    this.jIx.ba(com.tencent.mm.plugin.sns.e.ad.xi() + str2, i);
                    this.jIy.bw(this.jIx.jIJ);
                    try {
                        File file = new File(str);
                        awr com_tencent_mm_protocal_c_awr = new awr();
                        com_tencent_mm_protocal_c_awr.mUe = z ? 1 : 2;
                        com_tencent_mm_protocal_c_awr.mUg = file.lastModified() / 1000;
                        com_tencent_mm_protocal_c_awr.mUf = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.jIB.put(com.tencent.mm.plugin.sns.e.ad.xi() + str2, com_tencent_mm_protocal_c_awr);
                    } catch (Exception e) {
                        v.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                    com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                    if (location != null) {
                        this.jIA.put(com.tencent.mm.plugin.sns.e.ad.xi() + str2, location);
                    }
                }
            }
        }
        return true;
    }

    public final boolean a(int i, Intent intent) {
        String a;
        switch (i) {
            case 2:
                v.d("MicroMsg.PicWidget", "onActivityResult 1");
                if (intent == null) {
                    return false;
                }
                v.d("MicroMsg.PicWidget", "onActivityResult CONTEXT_CHOSE_IMAGE");
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                intent2.putExtra("CropImage_Filter", true);
                com.tencent.mm.plugin.sns.b.a.drp.a(this.aWn, intent, intent2, com.tencent.mm.plugin.sns.e.ad.xi(), 4, new com.tencent.mm.ui.tools.a.a(this) {
                    final /* synthetic */ ad jIF;

                    {
                        this.jIF = r1;
                    }

                    public final String BX(String str) {
                        return com.tencent.mm.plugin.sns.e.ad.xi() + com.tencent.mm.a.g.m((str + System.currentTimeMillis()).getBytes());
                    }
                });
                return true;
            case 3:
                v.d("MicroMsg.PicWidget", "onActivityResult 2");
                a = com.tencent.mm.pluginsdk.ui.tools.l.a(this.aWn.getApplicationContext(), intent, com.tencent.mm.plugin.sns.e.ad.xi());
                if (a == null) {
                    return true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 4);
                intent3.putExtra("CropImage_Filter", true);
                intent3.putExtra("CropImage_DirectlyIntoFilter", true);
                intent3.putExtra("CropImage_ImgPath", a);
                String m = com.tencent.mm.a.g.m((a + System.currentTimeMillis()).getBytes());
                intent3.putExtra("CropImage_OutputPath", com.tencent.mm.plugin.sns.e.ad.xi() + m);
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(a).getLocation();
                if (location != null) {
                    this.jIA.put(com.tencent.mm.plugin.sns.e.ad.xi() + m, location);
                    v.d("MicroMsg.PicWidget", "take picture lat:%f, long:%f", new Object[]{Double.valueOf(location.latitude), Double.valueOf(location.longitude)});
                }
                awr com_tencent_mm_protocal_c_awr = new awr();
                com_tencent_mm_protocal_c_awr.mUe = 1;
                com_tencent_mm_protocal_c_awr.mUg = System.currentTimeMillis();
                com_tencent_mm_protocal_c_awr.mUf = be.KM(Exif.fromFile(a).dateTime);
                this.jIB.put(com.tencent.mm.plugin.sns.e.ad.xi() + m, com_tencent_mm_protocal_c_awr);
                com.tencent.mm.plugin.sns.b.a.drp.a(this.aWn, intent3, 4);
                this.jIz = true;
                return true;
            case 4:
                v.d("MicroMsg.PicWidget", "onActivityResult 3");
                if (intent == null) {
                    return true;
                }
                a = intent.getStringExtra("CropImage_OutputPath");
                v.d("MicroMsg.PicWidget", "REQUEST_CODE_IMAGE_SEND_COMFIRM filePath " + a);
                if (a == null) {
                    return true;
                }
                if (!FileOp.aR(a)) {
                    return true;
                }
                if (this.jIx.jIJ.size() >= 9) {
                    return true;
                }
                int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                String str = "pre_temp_sns_pic" + com.tencent.mm.a.g.m((a + System.currentTimeMillis()).getBytes());
                v.i("MicroMsg.PicWidget", "onactivity result " + FileOp.jP(a) + " " + a);
                FileOp.p(a, com.tencent.mm.plugin.sns.e.ad.xi() + str);
                if (this.jIA.containsKey(a)) {
                    this.jIA.put(com.tencent.mm.plugin.sns.e.ad.xi() + str, this.jIA.get(a));
                }
                a = com.tencent.mm.plugin.sns.e.ad.xi() + str;
                v.d("MicroMsg.PicWidget", "newPath " + a);
                this.jIx.ba(a, intExtra);
                this.jIy.bw(this.jIx.jIJ);
                return true;
            case 7:
                if (intent == null) {
                    return true;
                }
                b bVar = this.jIx;
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("sns_gallery_temp_paths");
                if (stringArrayListExtra == null) {
                    bVar.jIJ = new ArrayList();
                } else {
                    bVar.jIJ = stringArrayListExtra;
                }
                this.jIy.bw(this.jIx.jIJ);
                this.jIC = intent.getIntExtra("sns_update_preview_image_count", 0);
                return true;
            case 9:
                return b(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_filterId", 0), intent.getBooleanExtra("isTakePhoto", false));
            case 11:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    a = sightCaptureResult.lUf;
                    if (!be.kS(a)) {
                        b(Collections.singletonList(a), 0, true);
                        break;
                    }
                }
                break;
        }
        return false;
    }

    public final boolean aVA() {
        if (this.jIy != null) {
            PreviewImageView previewImageView = this.jIy;
            previewImageView.jIS = true;
            for (Bitmap bitmap : previewImageView.jIP.values()) {
                if (com.tencent.mm.plugin.sns.data.i.i(bitmap)) {
                    bitmap.recycle();
                }
            }
        }
        return false;
    }
}
