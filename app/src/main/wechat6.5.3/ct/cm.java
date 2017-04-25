package ct;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import ct.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

final class cm {
    public int a;
    public final ArrayList<TencentPoi> b = new ArrayList();
    public cq c;

    cm() {
    }

    public cm(JSONObject jSONObject) {
        this.a = jSONObject.optInt("stat");
        if (jSONObject.has("subnation")) {
            this.c = new cq(jSONObject.optJSONObject("subnation"));
        } else if (jSONObject.has("results")) {
            this.c = a(jSONObject.optJSONArray("results"));
        } else {
            this.c = cq.a;
            a.b("DetailsData", "DetailsData: unknown json " + jSONObject.toString());
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("poilist");
        if (optJSONArray != null) {
            try {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.b.add(new cp(optJSONArray.getJSONObject(i)));
                }
            } catch (Throwable e) {
                a.a("DetailsData", "json error", e);
            }
        }
    }

    private static cq a(@Nullable JSONArray jSONArray) {
        int i = 2;
        if (jSONArray == null) {
            return null;
        }
        cq a = cq.a(cq.a);
        int length = jSONArray.length();
        if (length > 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            a.b = optJSONObject.optString("n");
            a.e = optJSONObject.optString("p");
            a.f = optJSONObject.optString("c");
            a.g = optJSONObject.optString("d");
            a.d = optJSONObject.optString("adcode");
        }
        if (length > 1) {
            optJSONObject = jSONArray.optJSONObject(1);
            a.l.putString("addrdesp.name", optJSONObject.optString("address_name"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("landmark");
            optJSONObject = optJSONObject.optJSONObject("second_landmark");
            if (optJSONObject2 != null) {
                a.l.putParcelable(TencentLocation.EXTRA_ADDRDESP_LANDMARK, new cl(optJSONObject2));
            }
            if (optJSONObject != null) {
                a.l.putParcelable(TencentLocation.EXTRA_ADDRDESP_SECOND_LANDMARK, new cl(optJSONObject));
            }
        }
        if (length <= 2) {
            return a;
        }
        ArrayList arrayList = new ArrayList();
        while (i < length) {
            cl clVar = new cl(jSONArray.optJSONObject(i));
            arrayList.add(clVar);
            if ("ST".equals(clVar.b)) {
                a.j = clVar.a;
            } else if ("ST_NO".equals(clVar.b)) {
                a.k = clVar.a;
            }
            i++;
        }
        a.l.putParcelableArrayList(TencentLocation.EXTRA_ADDRDESP_OTHERS_RESULTS, arrayList);
        return a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DetailsData{");
        stringBuilder.append("subnation=").append(this.c).append(",");
        stringBuilder.append("poilist=[");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            stringBuilder.append((TencentPoi) it.next()).append(",");
        }
        stringBuilder.append("]");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
