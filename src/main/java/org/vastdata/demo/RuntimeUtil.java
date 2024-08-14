package org.vastdata.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * description: org.vastdata
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/14
 * version: 1.0
 */
public class RuntimeUtil {

    public static final String exec(String[] commands) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(commands);
        try (InputStream is = process.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder cache = new StringBuilder();
            String ret = null;
            while ((ret = br.readLine()) != null) {
                cache.append(ret).append("\n");
            }
            return cache.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
