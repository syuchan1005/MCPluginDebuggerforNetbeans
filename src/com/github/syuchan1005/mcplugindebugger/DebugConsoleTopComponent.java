/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.syuchan1005.mcplugindebugger;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.text.DefaultCaret;
import org.netbeans.api.project.Project;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.filesystems.FileUtil;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.github.syuchan1005.mcplugindebugger//DebugConsole//EN",
        autostore = true
)
@TopComponent.Description(
        preferredID = "DebugConsoleTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "properties", openAtStartup = false)
@ActionID(category = "Window", id = "com.github.syuchan1005.mcplugindebugger.DebugConsoleTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_DebugConsoleAction",
        preferredID = "DebugConsoleTopComponent"
)
@Messages({
    "CTL_DebugConsoleAction=DebugConsole",
    "CTL_DebugConsoleTopComponent=DebugConsole Window",
    "HINT_DebugConsoleTopComponent=This is a DebugConsole window"
})
public final class DebugConsoleTopComponent extends TopComponent {

    private PluginDataConfig config = new PluginDataConfig();
    private ServerProcessManager processManager;

    public DebugConsoleTopComponent() {
        initComponents();
        ((DefaultCaret) outTextArea.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        setName(Bundle.CTL_DebugConsoleTopComponent());
        setToolTipText(Bundle.HINT_DebugConsoleTopComponent());
        processManager = new ServerProcessManager(config, line -> {
            if (line.equals("STX")) {
                outTextArea.setText("");
            } else {
                outTextArea.append(line + "\n");
            }
        });
    }

    private File getProjectBaseDir() {
        try {
            return FileUtil.toFile(Utilities.actionsGlobalContext().lookup(Project.class).getProjectDirectory());
        } catch (Exception e) {
            return new File("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        serverJarFile = new javax.swing.JTextField();
        serverBrowseButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pluginJarFile = new javax.swing.JTextField();
        pluginBrowseButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        hostField = new javax.swing.JTextField();
        hostSetButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        connectPort = new javax.swing.JTextField();
        portSetButton = new javax.swing.JButton();
        reloadPluginButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        reloadButton = new javax.swing.JButton();
        rebootButton = new javax.swing.JButton();
        forceStopButton = new javax.swing.JButton();
        commandField = new javax.swing.JTextField();
        sendCommandButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        outTextArea = new javax.swing.JTextArea();
        pluginName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pluginNameSetButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.jLabel1.text")); // NOI18N

        serverJarFile.setEditable(false);
        serverJarFile.setText(org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.serverJarFile.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(serverBrowseButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.serverBrowseButton.text")); // NOI18N
        serverBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverBrowseButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.jLabel2.text")); // NOI18N

        pluginJarFile.setEditable(false);
        pluginJarFile.setText(org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.pluginJarFile.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(pluginBrowseButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.pluginBrowseButton.text")); // NOI18N
        pluginBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pluginBrowseButtonActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.jLabel3.text")); // NOI18N
        jPanel1.add(jLabel3);

        hostField.setText(org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.hostField.text")); // NOI18N
        jPanel1.add(hostField);

        org.openide.awt.Mnemonics.setLocalizedText(hostSetButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.hostSetButton.text")); // NOI18N
        hostSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostSetButtonActionPerformed(evt);
            }
        });
        jPanel1.add(hostSetButton);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.jLabel4.text")); // NOI18N
        jPanel1.add(jLabel4);

        connectPort.setText(org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.connectPort.text")); // NOI18N
        jPanel1.add(connectPort);

        org.openide.awt.Mnemonics.setLocalizedText(portSetButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.portSetButton.text")); // NOI18N
        portSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portSetButtonActionPerformed(evt);
            }
        });
        jPanel1.add(portSetButton);

        org.openide.awt.Mnemonics.setLocalizedText(reloadPluginButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.reloadPluginButton.text")); // NOI18N
        reloadPluginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadPluginButtonActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.jLabel6.text")); // NOI18N
        jPanel2.add(jLabel6);

        org.openide.awt.Mnemonics.setLocalizedText(startButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.startButton.text")); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        jPanel2.add(startButton);

        org.openide.awt.Mnemonics.setLocalizedText(stopButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.stopButton.text")); // NOI18N
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        jPanel2.add(stopButton);

        org.openide.awt.Mnemonics.setLocalizedText(reloadButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.reloadButton.text")); // NOI18N
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });
        jPanel2.add(reloadButton);

        org.openide.awt.Mnemonics.setLocalizedText(rebootButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.rebootButton.text")); // NOI18N
        rebootButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rebootButtonActionPerformed(evt);
            }
        });
        jPanel2.add(rebootButton);

        org.openide.awt.Mnemonics.setLocalizedText(forceStopButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.forceStopButton.text")); // NOI18N
        forceStopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forceStopButtonActionPerformed(evt);
            }
        });
        jPanel2.add(forceStopButton);

        commandField.setText(org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.commandField.text")); // NOI18N
        commandField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(sendCommandButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.sendCommandButton.text")); // NOI18N
        sendCommandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendCommandButtonActionPerformed(evt);
            }
        });

        outTextArea.setEditable(false);
        outTextArea.setColumns(20);
        outTextArea.setLineWrap(true);
        outTextArea.setRows(5);
        jScrollPane2.setViewportView(outTextArea);

        pluginName.setText(org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.pluginName.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(pluginNameSetButton, org.openide.util.NbBundle.getMessage(DebugConsoleTopComponent.class, "DebugConsoleTopComponent.pluginNameSetButton.text")); // NOI18N
        pluginNameSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pluginNameSetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pluginJarFile)
                            .addComponent(serverJarFile))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serverBrowseButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pluginBrowseButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(reloadPluginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(commandField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendCommandButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pluginName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pluginNameSetButton))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(serverJarFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverBrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pluginJarFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pluginBrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pluginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pluginNameSetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloadPluginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendCommandButton)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(commandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void serverBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverBrowseButtonActionPerformed
        System.out.println(getProjectBaseDir().toString());
        JFileChooser chooser = new JFileChooser(getProjectBaseDir());
        if (chooser.showOpenDialog(mainPanel) == JFileChooser.APPROVE_OPTION) {
            config.setServerJarFile(new File(chooser.getSelectedFile().getPath()));
            this.serverJarFile.setText(config.getServerJarFile().getAbsolutePath());
        }
    }//GEN-LAST:event_serverBrowseButtonActionPerformed

    private void pluginBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pluginBrowseButtonActionPerformed
        JFileChooser chooser = new JFileChooser(getProjectBaseDir());
        if (chooser.showOpenDialog(mainPanel) == JFileChooser.APPROVE_OPTION) {
            config.setServerJarFile(new File(chooser.getSelectedFile().getPath()));
            this.serverJarFile.setText(config.getServerJarFile().getAbsolutePath());
        }
    }//GEN-LAST:event_pluginBrowseButtonActionPerformed

    private void reloadPluginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadPluginButtonActionPerformed
        new Thread(() -> {
            reloadPluginButton.setEnabled(false);
            try (Socket socket = new Socket(config.getHost(), config.getPort());
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {
                dataOutputStream.writeUTF(config.getPluginName());
                if (!socket.isClosed()) {
                    FileInputStream fileInputStream = new FileInputStream(config.getPluginJarFile());
                    byte[] buffer = new byte[512];
                    int fLength;
                    while ((fLength = fileInputStream.read(buffer)) > 0) {
                        dataOutputStream.write(buffer, 0, fLength);
                    }
                    fileInputStream.close();
                }
                dataOutputStream.flush();
            } catch (IOException e1) {
            } finally {
                reloadPluginButton.setEnabled(true);
            }
        }).start();
    }//GEN-LAST:event_reloadPluginButtonActionPerformed

    private void hostSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostSetButtonActionPerformed
        config.setHost(hostField.getText());
    }//GEN-LAST:event_hostSetButtonActionPerformed

    private void portSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portSetButtonActionPerformed
        config.setPort(Integer.valueOf(connectPort.getText()));
    }//GEN-LAST:event_portSetButtonActionPerformed

    private void pluginNameSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pluginNameSetButtonActionPerformed
        config.setPluginName(pluginName.getText());
    }//GEN-LAST:event_pluginNameSetButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        try {
            processManager.startServer();
        } catch (IOException e1) {
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        try {
            processManager.stopServer();
        } catch (InterruptedException | IOException e1) {
        }
    }//GEN-LAST:event_stopButtonActionPerformed

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        try {
            processManager.reload();
        } catch (IOException e1) {
        }
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void rebootButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rebootButtonActionPerformed
        try {
            processManager.reboot();
        } catch (InterruptedException | IOException e1) {
        }
    }//GEN-LAST:event_rebootButtonActionPerformed

    private void forceStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forceStopButtonActionPerformed
        try {
            processManager.forceStop();
        } catch (IOException e1) {
        }
    }//GEN-LAST:event_forceStopButtonActionPerformed

    private void commandFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandFieldActionPerformed
        sendCommandButton.doClick();
    }//GEN-LAST:event_commandFieldActionPerformed

    private void sendCommandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendCommandButtonActionPerformed
        try {
            processManager.writeCommand(commandField.getText() + "\n");
        } catch (IOException e1) {
        }
    }//GEN-LAST:event_sendCommandButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField commandField;
    private javax.swing.JTextField connectPort;
    private javax.swing.JButton forceStopButton;
    private javax.swing.JTextField hostField;
    private javax.swing.JButton hostSetButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextArea outTextArea;
    private javax.swing.JButton pluginBrowseButton;
    private javax.swing.JTextField pluginJarFile;
    private javax.swing.JTextField pluginName;
    private javax.swing.JButton pluginNameSetButton;
    private javax.swing.JButton portSetButton;
    private javax.swing.JButton rebootButton;
    private javax.swing.JButton reloadButton;
    private javax.swing.JButton reloadPluginButton;
    private javax.swing.JButton sendCommandButton;
    private javax.swing.JButton serverBrowseButton;
    private javax.swing.JTextField serverJarFile;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        config.init(this.getProjectBaseDir());
        serverJarFile.setText(config.getServerJarFile().getAbsolutePath());
        pluginJarFile.setText(config.getPluginJarFile().getAbsolutePath());
        pluginName.setText(config.getPluginName());
        hostField.setText(config.getHost());
        connectPort.setText(config.getPort().toString());
    }

    @Override
    public void componentClosed() {
        if (processManager.isRunning()) {
            try {
                processManager.stopServer();
            } catch (InterruptedException | IOException ex) {}
        }
    }

    void writeProperties(java.util.Properties p) {
        p.setProperty("version", "1.0");
        p.setProperty("serverJarFile", config.getServerJarFile().getAbsolutePath());
        p.setProperty("pluginJarFile", config.getPluginJarFile().getAbsolutePath());
        p.setProperty("pluginName", config.getPluginName());
        p.setProperty("host", config.getHost());
        p.setProperty("port", config.getPort().toString());
    }

    void readProperties(java.util.Properties p) {
        String path = this.getProjectBaseDir().getAbsolutePath();
        config.setServerJarFile(new File((String) p.getOrDefault("serverJarFile", path)));
        config.setPluginJarFile(new File((String) p.getOrDefault("pluginJarFile", path)));
        config.setPluginName((String) p.getOrDefault("pluginName", "EX"));
        config.setHost((String) p.getOrDefault("host", "localhost"));
        config.setPort(Integer.valueOf((String) p.getOrDefault("port", "9000")));
    }
}