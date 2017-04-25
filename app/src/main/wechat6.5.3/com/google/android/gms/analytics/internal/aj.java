package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.j;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;

public final class aj {
    public static a<Integer> aiA = a.a("analytics.max_hit_length.k", 8192, 8192);
    public static a<Integer> aiB = a.a("analytics.max_post_length.k", 8192, 8192);
    public static a<Integer> aiC = a.a("analytics.max_batch_post_length", 8192, 8192);
    public static a<String> aiD;
    public static a<Integer> aiE = a.a("analytics.batch_retry_interval.seconds.k", 3600, 3600);
    public static a<Long> aiF = a.a("analytics.service_monitor_interval", 86400000, 86400000);
    public static a<Integer> aiG = a.a("analytics.http_connection.connect_timeout_millis", 60000, 60000);
    public static a<Integer> aiH = a.a("analytics.http_connection.read_timeout_millis", 61000, 61000);
    public static a<Long> aiI = a.a("analytics.campaigns.time_limit", 86400000, 86400000);
    public static a<String> aiJ;
    public static a<Integer> aiK = a.a("analytics.first_party_experiment_variant", 0, 0);
    public static a<Boolean> aiL = a.d("analytics.test.disable_receiver", false);
    public static a<Long> aiM = a.a("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    public static a<Long> aiN = a.a("analytics.service_client.connect_timeout_millis", 5000, 5000);
    public static a<Long> aiO = a.a("analytics.service_client.second_connect_delay_millis", 5000, 5000);
    public static a<Long> aiP = a.a("analytics.service_client.unexpected_reconnect_millis", 60000, 60000);
    public static a<Long> aiQ = a.a("analytics.service_client.reconnect_throttle_millis", 1800000, 1800000);
    public static a<Long> aiR = a.a("analytics.monitoring.sample_period_millis", 86400000, 86400000);
    public static a<Long> aiS = a.a("analytics.initialization_warning_threshold", 5000, 5000);
    public static a<Boolean> aic = a.d("analytics.service_enabled", false);
    public static a<Boolean> aid = a.d("analytics.service_client_enabled", true);
    public static a<String> aie = a.b("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static a<Long> aif = a.a("analytics.max_tokens", 60, 60);
    public static a<Float> aig = new a(j.a("analytics.tokens_per_sec", Float.valueOf(0.5f)), Float.valueOf(0.5f));
    public static a<Integer> aih = a.a("analytics.max_stored_hits", 2000, 20000);
    public static a<Integer> aii = a.a("analytics.max_stored_hits_per_app", 2000, 2000);
    public static a<Integer> aij = a.a("analytics.max_stored_properties_per_app", 100, 100);
    public static a<Long> aik = a.a("analytics.local_dispatch_millis", 1800000, 120000);
    public static a<Long> ail = a.a("analytics.initial_local_dispatch_millis", 5000, 5000);
    public static a<Long> aim = a.a("analytics.min_local_dispatch_millis", 120000, 120000);
    public static a<Long> ain = a.a("analytics.max_local_dispatch_millis", 7200000, 7200000);
    public static a<Long> aio = a.a("analytics.dispatch_alarm_millis", 7200000, 7200000);
    public static a<Long> aip = a.a("analytics.max_dispatch_alarm_millis", 32400000, 32400000);
    public static a<Integer> aiq = a.a("analytics.max_hits_per_dispatch", 20, 20);
    public static a<Integer> air = a.a("analytics.max_hits_per_batch", 20, 20);
    public static a<String> ais;
    public static a<String> ait;
    public static a<String> aiu;
    public static a<String> aiv;
    public static a<Integer> aiw = a.a("analytics.max_get_length", 2036, 2036);
    public static a<String> aix = a.b("analytics.batching_strategy.k", x.ahG.name(), x.ahG.name());
    public static a<String> aiy;
    public static a<Integer> aiz = a.a("analytics.max_hits_per_request.k", 20, 20);

    public static final class a<V> {
        private final V aiT;
        private final j<V> aiU;
        private V aiV;

        a(j<V> jVar, V v) {
            w.Z(jVar);
            this.aiU = jVar;
            this.aiT = v;
        }

        static a<Integer> a(String str, int i, int i2) {
            return new a(j.a(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static a<Long> a(String str, long j, long j2) {
            return new a(j.a(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static a<String> b(String str, String str2, String str3) {
            return new a(j.j(str, str3), str2);
        }

        static a<Boolean> d(String str, boolean z) {
            return new a(j.f(str, z), Boolean.valueOf(z));
        }

        public final V get() {
            return this.aiV != null ? this.aiV : (f.aob && j.isInitialized()) ? this.aiU.kI() : this.aiT;
        }
    }

    static {
        String str = "http://www.google-analytics.com";
        ais = a.b("analytics.insecure_host", str, str);
        str = "https://ssl.google-analytics.com";
        ait = a.b("analytics.secure_host", str, str);
        str = "/collect";
        aiu = a.b("analytics.simple_endpoint", str, str);
        str = "/batch";
        aiv = a.b("analytics.batching_endpoint", str, str);
        str = z.GZIP.name();
        aiy = a.b("analytics.compression_strategy.k", str, str);
        str = "404,502";
        aiD = a.b("analytics.fallback_responses.k", str, str);
        str = "";
        aiJ = a.b("analytics.first_party_experiment_id", str, str);
    }
}
