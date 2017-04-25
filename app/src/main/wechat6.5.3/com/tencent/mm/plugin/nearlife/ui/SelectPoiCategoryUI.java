package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tencent.mm.a.e;
import com.tencent.mm.al.k;
import com.tencent.mm.e.a.jw;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SelectPoiCategoryUI extends MMActivity {
    static final String hHH = (t.cng + "poi_categories");
    private ListView Eq;
    private OnMenuItemClickListener hHC = new OnMenuItemClickListener(this) {
        final /* synthetic */ SelectPoiCategoryUI hHM;

        {
            this.hHM = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.hHM.setResult(0, null);
            this.hHM.finish();
            return true;
        }
    };
    private a hHI;
    private ArrayAdapter<String> hHJ;
    private List<String> hHK;
    private OnItemClickListener hHL = new OnItemClickListener(this) {
        final /* synthetic */ SelectPoiCategoryUI hHM;

        {
            this.hHM = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            v.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.hHM.hHK.size())});
            Intent intent = new Intent();
            intent.putExtra("poi_category", (String) this.hHM.hHK.get(i));
            this.hHM.setResult(-1, intent);
            this.hHM.finish();
        }
    };

    private class a extends c<jw> {
        final /* synthetic */ SelectPoiCategoryUI hHM;
        SelectPoiCategoryUI hHN;

        public a(SelectPoiCategoryUI selectPoiCategoryUI) {
            this.hHM = selectPoiCategoryUI;
            super(0);
            this.nhz = jw.class.getName().hashCode();
        }

        private boolean a(jw jwVar) {
            if (jwVar instanceof jw) {
                SelectPoiCategoryUI selectPoiCategoryUI = this.hHN;
                byte[] bArr = jwVar.bkA.content;
                File file = new File(SelectPoiCategoryUI.hHH);
                if (!file.exists()) {
                    file.mkdir();
                }
                try {
                    String str = SelectPoiCategoryUI.hHH + "/lastest_poi_categories.dat";
                    File file2 = new File(str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    e.b(str, bArr, bArr.length);
                } catch (Exception e) {
                    v.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + e.getMessage());
                }
                selectPoiCategoryUI.aw(bArr);
                selectPoiCategoryUI.aDQ();
            }
            return false;
        }
    }

    protected final int getLayoutId() {
        return 2130904334;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hHK = new ArrayList();
        NI();
        this.hHI = new a(this);
        com.tencent.mm.sdk.c.a.nhr.e(this.hHI);
        this.hHI.hHN = this;
        ak.vy().a(new k(17), 0);
    }

    protected final void NI() {
        vD(2131234056);
        b(this.hHC);
        this.hHJ = new ArrayAdapter(this, 2130904163);
        this.Eq = (ListView) findViewById(2131759048);
        this.Eq.setAdapter(this.hHJ);
        this.Eq.setOnItemClickListener(this.hHL);
        if (!xj(hHH + "/lastest_poi_categories.dat")) {
            try {
                j(getAssets().open("default_poi_categories.dat"));
            } catch (IOException e) {
                v.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + e.getMessage());
            }
        }
        aDQ();
    }

    private boolean j(InputStream inputStream) {
        IOException e;
        Throwable th;
        if (inputStream == null) {
            return false;
        }
        this.hHK.clear();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.hHK.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            v.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e2.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            try {
                v.d("MicroMsg.SelectPoiCategoryUI", "read file failed: " + e.getMessage());
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e22) {
                        v.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e22.getMessage());
                    }
                }
                inputStream.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e5) {
                        v.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e5.getMessage());
                        throw th;
                    }
                }
                inputStream.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            inputStream.close();
            throw th;
        }
        return true;
    }

    private boolean xj(String str) {
        boolean z = false;
        if (!be.kS(str)) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    z = j(new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    v.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", new Object[]{str, e.getMessage()});
                }
            }
        }
        return z;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.c.a.nhr.f(this.hHI);
    }

    final void aw(byte[] bArr) {
        String[] split = new String(bArr).split("\n");
        this.hHK.clear();
        for (String trim : split) {
            this.hHK.add(trim.trim());
        }
    }

    final void aDQ() {
        this.hHJ.clear();
        for (int i = 0; i < this.hHK.size(); i++) {
            this.hHJ.add(this.hHK.get(i));
        }
        this.hHJ.notifyDataSetChanged();
    }
}
