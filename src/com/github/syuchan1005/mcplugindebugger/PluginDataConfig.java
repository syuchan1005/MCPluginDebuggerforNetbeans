package com.github.syuchan1005.mcplugindebugger;

import java.io.File;

/**
 * Created by syuchan on 2017/07/04.
 */
public class PluginDataConfig {

    private String serverJarFile;
    private String pluginJarFile;
    private String pluginName;
    private String host;
    private Integer port;

    public void init(File baseDir) {
        if (serverJarFile == null) {
            setServerJarFile(baseDir);
        }
        if (pluginJarFile == null) {
            setPluginJarFile(baseDir);
        }
        if (pluginName == null) {
            pluginName = "EX";
        }
        if (host == null) {
            host = "localhost";
        }
        if (port == null) {
            port = 9000;
        }
    }

    public File getServerJarFile() {
        return new File(serverJarFile);
    }

    public void setServerJarFile(File serverJarFile) {
        this.serverJarFile = trimPath(serverJarFile.getAbsolutePath());
    }

    public File getPluginJarFile() {
        return new File(pluginJarFile);
    }

    public void setPluginJarFile(File pluginJarFile) {
        this.pluginJarFile = trimPath(pluginJarFile.getAbsolutePath());
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    private static String trimPath(String s) {
        if (s.endsWith("!")) {
            return s.substring(0, s.length() - 1);
        }
        return s;
    }
}
