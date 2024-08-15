package org.vastdata.install.domain;

/**
 * description: org.vastdata.install.domain
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/15
 * version: 1.0
 */
public class DatabaseCfg {

    private int listenPort;

    private String username;

    public int getListenPort() {
        return listenPort;
    }

    public void setListenPort(int listenPort) {
        this.listenPort = listenPort;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
