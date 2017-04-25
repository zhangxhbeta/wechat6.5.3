package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
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
import android.widget.TextView;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileExplorerUI extends MMActivity {
    private int lSK = 0;
    private ListView lSL;
    private a lSM;
    private TextView lSN;
    private TextView lSO;
    private View lSP;
    private View lSQ;
    private String lSR;
    private String lSS;
    private File lST;
    private File lSU;

    private class a extends BaseAdapter {
        String jjG;
        final /* synthetic */ FileExplorerUI lSV;
        private File lSY;
        private File lSZ;
        private File[] lTa;

        private a(FileExplorerUI fileExplorerUI) {
            this.lSV = fileExplorerUI;
        }

        public final void c(File file, File file2) {
            this.lSY = file;
            if (file2.getAbsolutePath().equalsIgnoreCase(this.jjG)) {
                this.lSY = null;
            }
            this.lSZ = file2;
            if (this.lSZ.canRead() && this.lSZ.isDirectory()) {
                this.lTa = this.lSZ.listFiles(new FileFilter(this) {
                    final /* synthetic */ a lTb;

                    {
                        this.lTb = r1;
                    }

                    public final boolean accept(File file) {
                        if (file.isHidden()) {
                            return false;
                        }
                        return true;
                    }
                });
                if (this.lTa.length > 0) {
                    File[] fileArr = this.lTa;
                    if (fileArr != null && fileArr.length != 0) {
                        List<b> arrayList = new ArrayList();
                        List<b> arrayList2 = new ArrayList();
                        for (File file3 : fileArr) {
                            b bVar = new b();
                            bVar.file = file3;
                            bVar.lTc = com.tencent.mm.platformtools.c.lT(file3.getName()).toUpperCase();
                            if (file3.isDirectory()) {
                                arrayList.add(bVar);
                            } else {
                                arrayList2.add(bVar);
                            }
                        }
                        Collections.sort(arrayList, new Comparator<b>(this) {
                            final /* synthetic */ a lTb;

                            {
                                this.lTb = r1;
                            }

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return ((b) obj).lTc.compareTo(((b) obj2).lTc);
                            }
                        });
                        Collections.sort(arrayList2, new Comparator<b>(this) {
                            final /* synthetic */ a lTb;

                            {
                                this.lTb = r1;
                            }

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return ((b) obj).lTc.compareTo(((b) obj2).lTc);
                            }
                        });
                        int i = 0;
                        for (b bVar2 : arrayList) {
                            fileArr[i] = bVar2.file;
                            i++;
                        }
                        for (b bVar22 : arrayList2) {
                            fileArr[i] = bVar22.file;
                            i++;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.lTa = new File[0];
        }

        public final int getCount() {
            int i = 0;
            if (this.lTa == null) {
                return 0;
            }
            int length = this.lTa.length;
            if (this.lSY != null) {
                i = 1;
            }
            return i + length;
        }

        public final Object getItem(int i) {
            if (this.lSY != null && i == 0) {
                return this.lSY;
            }
            v.d("FileExplorer", "pos:" + i + ", subFile length:" + this.lTa.length);
            File[] fileArr = this.lTa;
            if (this.lSY != null) {
                i--;
            }
            return fileArr[i];
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.lSV, 2130903915, null);
                c cVar = new c();
                cVar.eZn = (ImageView) view.findViewById(2131757974);
                cVar.eVA = (TextView) view.findViewById(2131757437);
                cVar.lTd = (TextView) view.findViewById(2131757986);
                view.setTag(cVar);
            }
            c cVar2 = (c) view.getTag();
            File file = (File) getItem(i);
            if (file == this.lSY) {
                cVar2.eVA.setText(file.getName());
                cVar2.eZn.setImageResource(2130838940);
                cVar2.lTd.setVisibility(0);
            } else {
                cVar2.eZn.setImageResource(FileExplorerUI.w(file));
                cVar2.eVA.setText(file.getName());
                cVar2.lTd.setText(DateFormat.format("yyyy-MM-dd hh:mm:ss", file.lastModified()).toString() + (file.isDirectory() ? "" : "  " + be.aw(file.length())));
            }
            return view;
        }
    }

    private class b {
        File file;
        final /* synthetic */ FileExplorerUI lSV;
        String lTc;

        private b(FileExplorerUI fileExplorerUI) {
            this.lSV = fileExplorerUI;
        }
    }

    private class c {
        TextView eVA;
        ImageView eZn;
        final /* synthetic */ FileExplorerUI lSV;
        TextView lTd;

        private c(FileExplorerUI fileExplorerUI) {
            this.lSV = fileExplorerUI;
        }
    }

    static /* synthetic */ int w(File file) {
        return file.isDirectory() ? 2130838941 : HU(file.getName());
    }

    protected final int getLayoutId() {
        return 2130903914;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (be.kS(stringExtra)) {
            vD(2131234218);
        } else {
            Fd(stringExtra);
        }
        NI();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.lSM.lSY == null) {
            if (this.lSU != null) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(131074, this.lSU.getAbsolutePath());
            }
            if (this.lST != null) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(131073, this.lST.getAbsolutePath());
            }
            return super.onKeyDown(i, keyEvent);
        }
        if (1 == this.lSK) {
            this.lSU = this.lSM.lSY;
        } else if (this.lSK == 0) {
            this.lST = this.lSM.lSY;
        }
        this.lSM.c(this.lSM.lSY.getParentFile(), this.lSM.lSY);
        this.lSM.notifyDataSetChanged();
        this.lSL.setSelection(0);
        return true;
    }

    protected final void NI() {
        File file;
        File externalStorageDirectory;
        r vf;
        File file2;
        TextView textView;
        boolean z;
        TextView textView2;
        boolean z2 = true;
        Object obj = null;
        this.lSL = (ListView) findViewById(2131757985);
        this.lSN = (TextView) findViewById(2131757981);
        this.lSP = findViewById(2131757982);
        this.lSO = (TextView) findViewById(2131757983);
        this.lSQ = findViewById(2131757984);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FileExplorerUI lSV;

            {
                this.lSV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.lSV.lSM.lSY != null) {
                    if (1 == this.lSV.lSK) {
                        this.lSV.lSU = this.lSV.lSM.lSY;
                    } else if (this.lSV.lSK == 0) {
                        this.lSV.lST = this.lSV.lSM.lSY;
                    }
                    this.lSV.lSM.c(this.lSV.lSM.lSY.getParentFile(), this.lSV.lSM.lSY);
                    this.lSV.lSM.notifyDataSetChanged();
                    this.lSV.lSL.setSelection(0);
                } else {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(131074, this.lSV.lSU.getAbsolutePath());
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(131073, this.lSV.lST.getAbsolutePath());
                    this.lSV.finish();
                }
                return true;
            }
        });
        this.lSR = getString(2131234216);
        this.lSS = getString(2131234217);
        File rootDirectory = be.kS(p.ceJ.cea) ? Environment.getRootDirectory() : new File(p.ceJ.cea);
        if (rootDirectory.canRead()) {
            file = rootDirectory;
        } else {
            rootDirectory = h.getDataDirectory();
            if (rootDirectory.canRead()) {
                this.lSR = rootDirectory.getName();
                file = rootDirectory;
            } else {
                file = null;
            }
        }
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            externalStorageDirectory = h.getExternalStorageDirectory();
        } else {
            rootDirectory = be.kS(p.ceJ.cec) ? Environment.getDownloadCacheDirectory() : new File(p.ceJ.cec);
            if (rootDirectory.canRead()) {
                this.lSS = rootDirectory.getName();
                externalStorageDirectory = rootDirectory;
            } else {
                externalStorageDirectory = null;
            }
        }
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(131073, file == null ? null : file.getAbsolutePath());
        if (!(str == null || file == null || file.getAbsolutePath().equals(str))) {
            File file3 = new File(str);
            if (file3.exists()) {
                rootDirectory = file3;
                this.lST = rootDirectory;
                ak.yW();
                vf = com.tencent.mm.model.c.vf();
                if (externalStorageDirectory != null) {
                    obj = externalStorageDirectory.getAbsolutePath();
                }
                str = (String) vf.get(131074, obj);
                if (!(str == null || externalStorageDirectory == null || externalStorageDirectory.getAbsolutePath().equals(str))) {
                    file2 = new File(str);
                    if (file2.exists()) {
                        rootDirectory = file2;
                        this.lSU = rootDirectory;
                        this.lSM = new a();
                        if (externalStorageDirectory == null) {
                            uw(1);
                            this.lSM.jjG = externalStorageDirectory.getPath();
                            this.lSM.c(this.lSU.getParentFile(), this.lSU);
                        } else if (file == null) {
                            uw(0);
                            this.lSM.jjG = file.getPath();
                            this.lSM.c(this.lST.getParentFile(), this.lST);
                        } else {
                            v.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                            return;
                        }
                        textView = this.lSN;
                        if (file == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        textView.setEnabled(z);
                        textView2 = this.lSO;
                        if (externalStorageDirectory == null) {
                            z2 = false;
                        }
                        textView2.setEnabled(z2);
                        this.lSL.setAdapter(this.lSM);
                        this.lSM.notifyDataSetChanged();
                        this.lSL.setOnItemClickListener(new OnItemClickListener(this) {
                            final /* synthetic */ FileExplorerUI lSV;

                            {
                                this.lSV = r1;
                            }

                            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                File file = (File) this.lSV.lSM.getItem(i);
                                if (1 == this.lSV.lSK) {
                                    if (file.isFile()) {
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().set(131074, this.lSV.lSM.lSZ.getAbsolutePath());
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().set(131073, this.lSV.lST.getAbsolutePath());
                                    } else {
                                        this.lSV.lSU = file;
                                    }
                                } else if (this.lSV.lSK == 0) {
                                    if (file.isFile()) {
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().set(131073, this.lSV.lSM.lSZ.getAbsolutePath());
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().set(131074, this.lSV.lSU.getAbsolutePath());
                                    } else {
                                        this.lSV.lST = file;
                                    }
                                }
                                if (file == this.lSV.lSM.lSY) {
                                    this.lSV.lSM.c(this.lSV.lSM.lSY.getParentFile(), this.lSV.lSM.lSY);
                                } else if (file.isDirectory()) {
                                    this.lSV.lSM.c(this.lSV.lSM.lSZ, file);
                                } else if (file.isFile()) {
                                    this.lSV.setResult(-1, new Intent().putExtra("choosed_file_path", file.getAbsolutePath()));
                                    this.lSV.finish();
                                }
                                this.lSV.lSM.notifyDataSetChanged();
                                this.lSV.lSL.setSelection(0);
                            }
                        });
                        this.lSN.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ FileExplorerUI lSV;

                            public final void onClick(View view) {
                                this.lSV.uw(0);
                                this.lSV.lSM.jjG = file.getPath();
                                this.lSV.lSM.c(this.lSV.lST.getParentFile(), this.lSV.lST);
                                this.lSV.lSM.notifyDataSetInvalidated();
                                this.lSV.lSM.notifyDataSetChanged();
                                this.lSV.lSL.setSelection(0);
                            }
                        });
                        this.lSO.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ FileExplorerUI lSV;

                            public final void onClick(View view) {
                                this.lSV.uw(1);
                                this.lSV.lSM.jjG = externalStorageDirectory.getPath();
                                this.lSV.lSM.c(this.lSV.lSU.getParentFile(), this.lSV.lSU);
                                this.lSV.lSM.notifyDataSetInvalidated();
                                this.lSV.lSM.notifyDataSetChanged();
                                this.lSV.lSL.setSelection(0);
                            }
                        });
                    }
                }
                rootDirectory = externalStorageDirectory;
                this.lSU = rootDirectory;
                this.lSM = new a();
                if (externalStorageDirectory == null) {
                    uw(1);
                    this.lSM.jjG = externalStorageDirectory.getPath();
                    this.lSM.c(this.lSU.getParentFile(), this.lSU);
                } else if (file == null) {
                    v.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                    return;
                } else {
                    uw(0);
                    this.lSM.jjG = file.getPath();
                    this.lSM.c(this.lST.getParentFile(), this.lST);
                }
                textView = this.lSN;
                if (file == null) {
                    z = false;
                } else {
                    z = true;
                }
                textView.setEnabled(z);
                textView2 = this.lSO;
                if (externalStorageDirectory == null) {
                    z2 = false;
                }
                textView2.setEnabled(z2);
                this.lSL.setAdapter(this.lSM);
                this.lSM.notifyDataSetChanged();
                this.lSL.setOnItemClickListener(/* anonymous class already generated */);
                this.lSN.setOnClickListener(/* anonymous class already generated */);
                this.lSO.setOnClickListener(/* anonymous class already generated */);
            }
        }
        rootDirectory = file;
        this.lST = rootDirectory;
        ak.yW();
        vf = com.tencent.mm.model.c.vf();
        if (externalStorageDirectory != null) {
            obj = externalStorageDirectory.getAbsolutePath();
        }
        str = (String) vf.get(131074, obj);
        file2 = new File(str);
        if (file2.exists()) {
            rootDirectory = file2;
            this.lSU = rootDirectory;
            this.lSM = new a();
            if (externalStorageDirectory == null) {
                uw(1);
                this.lSM.jjG = externalStorageDirectory.getPath();
                this.lSM.c(this.lSU.getParentFile(), this.lSU);
            } else if (file == null) {
                uw(0);
                this.lSM.jjG = file.getPath();
                this.lSM.c(this.lST.getParentFile(), this.lST);
            } else {
                v.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                return;
            }
            textView = this.lSN;
            if (file == null) {
                z = true;
            } else {
                z = false;
            }
            textView.setEnabled(z);
            textView2 = this.lSO;
            if (externalStorageDirectory == null) {
                z2 = false;
            }
            textView2.setEnabled(z2);
            this.lSL.setAdapter(this.lSM);
            this.lSM.notifyDataSetChanged();
            this.lSL.setOnItemClickListener(/* anonymous class already generated */);
            this.lSN.setOnClickListener(/* anonymous class already generated */);
            this.lSO.setOnClickListener(/* anonymous class already generated */);
        }
        rootDirectory = externalStorageDirectory;
        this.lSU = rootDirectory;
        this.lSM = new a();
        if (externalStorageDirectory == null) {
            uw(1);
            this.lSM.jjG = externalStorageDirectory.getPath();
            this.lSM.c(this.lSU.getParentFile(), this.lSU);
        } else if (file == null) {
            v.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
            return;
        } else {
            uw(0);
            this.lSM.jjG = file.getPath();
            this.lSM.c(this.lST.getParentFile(), this.lST);
        }
        textView = this.lSN;
        if (file == null) {
            z = false;
        } else {
            z = true;
        }
        textView.setEnabled(z);
        textView2 = this.lSO;
        if (externalStorageDirectory == null) {
            z2 = false;
        }
        textView2.setEnabled(z2);
        this.lSL.setAdapter(this.lSM);
        this.lSM.notifyDataSetChanged();
        this.lSL.setOnItemClickListener(/* anonymous class already generated */);
        this.lSN.setOnClickListener(/* anonymous class already generated */);
        this.lSO.setOnClickListener(/* anonymous class already generated */);
    }

    private void uw(int i) {
        if (1 == i) {
            this.lSK = 1;
            this.lSO.setTextColor(getResources().getColor(2131690123));
            this.lSN.setTextColor(getResources().getColor(2131689909));
            this.lSP.setVisibility(4);
            this.lSQ.setVisibility(0);
            return;
        }
        this.lSK = 0;
        this.lSN.setTextColor(getResources().getColor(2131690123));
        this.lSO.setTextColor(getResources().getColor(2131689909));
        this.lSP.setVisibility(0);
        this.lSQ.setVisibility(4);
    }

    public static int HU(String str) {
        Object obj = null;
        String toLowerCase = str.toLowerCase();
        String toLowerCase2 = be.ma(toLowerCase).toLowerCase();
        Object obj2 = (toLowerCase2.endsWith(".doc") || toLowerCase2.endsWith(".docx") || toLowerCase2.endsWith("wps")) ? 1 : null;
        if (obj2 != null) {
            return 2131165248;
        }
        if (HV(toLowerCase)) {
            return 2130838942;
        }
        toLowerCase2 = be.ma(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".rar") || toLowerCase2.endsWith(".zip") || toLowerCase2.endsWith(".7z") || toLowerCase2.endsWith("tar") || toLowerCase2.endsWith(".iso")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return 2131165238;
        }
        toLowerCase2 = be.ma(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".txt") || toLowerCase2.endsWith(".rtf")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return 2131165240;
        }
        if (be.ma(toLowerCase).toLowerCase().endsWith(".pdf")) {
            return 2131165234;
        }
        toLowerCase2 = be.ma(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".ppt") || toLowerCase2.endsWith(".pptx")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return 2131165236;
        }
        toLowerCase2 = be.ma(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".xls") || toLowerCase2.endsWith(".xlsx")) {
            obj = 1;
        }
        if (obj != null) {
            return 2131165228;
        }
        return 2131165241;
    }

    public static boolean HV(String str) {
        String toLowerCase = be.ma(str).toLowerCase();
        return toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(".jpg") || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif");
    }

    public static boolean HW(String str) {
        String toLowerCase = be.ma(str).toLowerCase();
        return toLowerCase.endsWith(".mp3") || toLowerCase.endsWith(".wma") || toLowerCase.endsWith(".mp4") || toLowerCase.endsWith(".rm");
    }
}
