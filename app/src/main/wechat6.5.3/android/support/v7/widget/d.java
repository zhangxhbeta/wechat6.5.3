package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class d extends DataSetObservable {
    private static final String De = d.class.getSimpleName();
    private static final Object Sv = new Object();
    private static final Map<String, d> Sw = new HashMap();
    private Intent OH;
    private final String SA;
    private b SB;
    private int SC;
    private boolean SD;
    private boolean SE;
    private boolean SF;
    private boolean SG;
    private d SH;
    final Object Sx;
    final List<a> Sy;
    private final List<c> Sz;
    private final Context mContext;

    public final class a implements Comparable<a> {
        final /* synthetic */ d SI;
        public final ResolveInfo resolveInfo;
        public float weight;

        public final /* synthetic */ int compareTo(Object obj) {
            return Float.floatToIntBits(((a) obj).weight) - Float.floatToIntBits(this.weight);
        }

        public a(d dVar, ResolveInfo resolveInfo) {
            this.SI = dVar;
            this.resolveInfo = resolveInfo;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((a) obj).weight)) {
                return false;
            }
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface b {
    }

    public static final class c {
        public final ComponentName SJ;
        public final long time;
        public final float weight;

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public c(ComponentName componentName, long j, float f) {
            this.SJ = componentName;
            this.time = j;
            this.weight = f;
        }

        public final int hashCode() {
            return (((((this.SJ == null ? 0 : this.SJ.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.SJ == null) {
                if (cVar.SJ != null) {
                    return false;
                }
            } else if (!this.SJ.equals(cVar.SJ)) {
                return false;
            }
            if (this.time != cVar.time) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(cVar.weight)) {
                return false;
            }
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.SJ);
            stringBuilder.append("; time:").append(this.time);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface d {
        boolean er();
    }

    private final class e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ d SI;

        private e(d dVar) {
            this.SI = dVar;
        }

        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return b(objArr);
        }

        private Void b(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            try {
                OutputStream openFileOutput = this.SI.mContext.openFileOutput((String) objArr[1], 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        c cVar = (c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", cVar.SJ.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(cVar.time));
                        newSerializer.attribute(null, "weight", String.valueOf(cVar.weight));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.SI.SD = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    d.De;
                    new StringBuilder("Error writing historical recrod file: ").append(this.SI.SA);
                    this.SI.SD = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IllegalStateException e4) {
                    d.De;
                    new StringBuilder("Error writing historical recrod file: ").append(this.SI.SA);
                    this.SI.SD = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IOException e6) {
                    d.De;
                    new StringBuilder("Error writing historical recrod file: ").append(this.SI.SA);
                    this.SI.SD = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (Throwable th) {
                    this.SI.SD = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                }
            } catch (FileNotFoundException e9) {
                d.De;
            }
            return null;
        }
    }

    public final int ek() {
        int size;
        synchronized (this.Sx) {
            em();
            size = this.Sy.size();
        }
        return size;
    }

    public final ResolveInfo aA(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.Sx) {
            em();
            resolveInfo = ((a) this.Sy.get(i)).resolveInfo;
        }
        return resolveInfo;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.Sx) {
            em();
            List list = this.Sy;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((a) list.get(i)).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent aB(int i) {
        synchronized (this.Sx) {
            if (this.OH == null) {
                return null;
            }
            em();
            a aVar = (a) this.Sy.get(i);
            ComponentName componentName = new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.OH);
            intent.setComponent(componentName);
            if (this.SH != null) {
                Intent intent2 = new Intent(intent);
                if (this.SH.er()) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo el() {
        synchronized (this.Sx) {
            em();
            if (this.Sy.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((a) this.Sy.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    public final int getHistorySize() {
        int size;
        synchronized (this.Sx) {
            em();
            size = this.Sz.size();
        }
        return size;
    }

    final void em() {
        int i;
        int i2 = 1;
        if (!this.SG || this.OH == null) {
            i = 0;
        } else {
            this.SG = false;
            this.Sy.clear();
            List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.OH, 0);
            int size = queryIntentActivities.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.Sy.add(new a(this, (ResolveInfo) queryIntentActivities.get(i3)));
            }
            i = 1;
        }
        if (this.SD && this.SF && !TextUtils.isEmpty(this.SA)) {
            this.SD = false;
            this.SE = true;
            ep();
        } else {
            i2 = 0;
        }
        i |= i2;
        eo();
        if (i != 0) {
            en();
            notifyChanged();
        }
    }

    private boolean en() {
        if (this.SB == null || this.OH == null || this.Sy.isEmpty() || this.Sz.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.Sz);
        return true;
    }

    final boolean a(c cVar) {
        boolean add = this.Sz.add(cVar);
        if (add) {
            this.SF = true;
            eo();
            if (this.SE) {
                if (this.SF) {
                    this.SF = false;
                    if (!TextUtils.isEmpty(this.SA)) {
                        AsyncTask eVar = new e();
                        Object[] objArr = new Object[]{new ArrayList(this.Sz), this.SA};
                        if (VERSION.SDK_INT >= 11) {
                            eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
                        } else {
                            eVar.execute(objArr);
                        }
                    }
                }
                en();
                notifyChanged();
            } else {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        return add;
    }

    private void eo() {
        int size = this.Sz.size() - this.SC;
        if (size > 0) {
            this.SF = true;
            for (int i = 0; i < size; i++) {
                this.Sz.remove(0);
            }
        }
    }

    private void ep() {
        try {
            InputStream openFileInput = this.mContext.openFileInput(this.SA);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.Sz;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (XmlPullParserException e2) {
                new StringBuilder("Error reading historical recrod file: ").append(this.SA);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                new StringBuilder("Error reading historical recrod file: ").append(this.SA);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (FileNotFoundException e7) {
        }
    }
}
