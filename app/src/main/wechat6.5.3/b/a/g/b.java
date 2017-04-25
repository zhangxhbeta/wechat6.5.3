package b.a.g;

import java.util.Map;
import java.util.Map.Entry;

public final class b {
    public static <K, V> String ab(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(String.format(", %s -> %s ", new Object[]{entry.getKey().toString(), entry.getValue().toString()}));
        }
        return "{" + stringBuilder.substring(1) + "}";
    }
}
