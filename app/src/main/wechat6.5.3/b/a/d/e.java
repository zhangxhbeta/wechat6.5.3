package b.a.d;

import b.a.g.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class e {
    public final List<d> pPa;

    public e() {
        this.pPa = new ArrayList();
    }

    public e(List<d> list) {
        this.pPa = new ArrayList(list);
    }

    public e(Map<String, String> map) {
        this();
        for (Entry entry : map.entrySet()) {
            this.pPa.add(new d((String) entry.getKey(), (String) entry.getValue()));
        }
    }

    public final String bRr() {
        if (this.pPa.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (d dVar : this.pPa) {
            stringBuilder.append('&').append(c.encode(dVar.apU).concat("=").concat(c.encode(dVar.value)));
        }
        return stringBuilder.toString().substring(1);
    }

    public final void a(e eVar) {
        this.pPa.addAll(eVar.pPa);
    }

    public final void Re(String str) {
        if (str != null && str.length() > 0) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                this.pPa.add(new d(c.decode(split2[0]), split2.length > 1 ? c.decode(split2[1]) : ""));
            }
        }
    }
}
