/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.profiler.v2.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolTip;
import org.netbeans.lib.profiler.ui.UIUtils;
import org.netbeans.lib.profiler.ui.components.HTMLTextArea;
import org.netbeans.lib.profiler.ui.components.NoCaret;
import org.netbeans.modules.profiler.v2.ProfilerFeature;
import org.openide.util.NbBundle;

/**
 *
 * @author Jiri Sedlacek
 */
@NbBundle.Messages({
    "WelcomePanel_howtoCaption=Configure and Start Profiling",
    "WelcomePanel_clickForSetings=Click the {0} button in toolbar and select the desired profiling mode:",
    "WelcomePanel_startProfiling=Click the {0} button in toolbar once the session is configured to start profiling.",
    "WelcomePanel_modifyProfiling=Use the {0} <b>dropdown arrow</b> to change profiling settings for the session."
})
public abstract class WelcomePanel extends JPanel {
    
    public static final String CAPTION = Bundle.WelcomePanel_howtoCaption();
    
    public WelcomePanel(String configureButton, String profileButton, Set<ProfilerFeature> features) {
        
        Color background = UIUtils.getProfilerResultsBackground();
        
        JPanel pp = new JPanel(new GridBagLayout());
        pp.setOpaque(true);
        pp.setBackground(background);
        
        int y = 0;
        
        Paragraph header = new Paragraph(null, CAPTION, 3, background);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, header.getForeground()));
        if (UIUtils.isNimbus()) header.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = y++;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(4, 20, 4, 20);
        pp.add(header, c);
        
        int counter = 0;
        
        Paragraph hint1 = new Paragraph(Bundle.WelcomePanel_clickForSetings("<b><a href='#'>" + configureButton + "</a></b>"), Integer.toString(++counter), 1, background) { // NOI18N
            protected void showURL(URL url) { highlightItem(null); }
        };
        c = new GridBagConstraints();
        c.gridy = y++;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(4, 28, 0, 20);
        pp.add(hint1, c);
        
        for (ProfilerFeature feature : features) {
        
            JLabel l1 = new JLabel(feature.getName(), feature.getIcon(), JLabel.LEADING);
            l1.setFont(new JToolTip().getFont());
            l1.setIconTextGap(l1.getIconTextGap() + 2);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = y;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.WEST;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(3, 60, 3, 10);
            pp.add(l1, c);

            JLabel l2 = new JLabel(feature.getDescription());
            l2.setFont(l1.getFont());
            l2.setEnabled(false);
            c = new GridBagConstraints();
            c.gridx = 1;
            c.gridy = y++;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.WEST;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.insets = new Insets(3, 0, 3, 20);
            pp.add(l2, c);
        
        }
        
        Paragraph hint2 = new Paragraph(Bundle.WelcomePanel_startProfiling("<b>" + profileButton + "</b>"), Integer.toString(++counter), 1, background); // NOI18N
        c = new GridBagConstraints();
        c.gridy = y++;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(6, 28, 0, 20);
        pp.add(hint2, c);
        
        Paragraph hint3 = new Paragraph(Bundle.WelcomePanel_modifyProfiling(profileButton), Integer.toString(++counter), 1, background); // NOI18N
        c = new GridBagConstraints();
        c.gridy = y++;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 28, 0, 20);
        pp.add(hint3, c);
        
        int w = pp.getMinimumSize().width;
        
        header.setSize(w, Integer.MAX_VALUE);
        header.setPreferredSize(new Dimension(w, header.getPreferredSize().height));
        
        hint1.setSize(w, Integer.MAX_VALUE);
        hint1.setPreferredSize(new Dimension(w, hint1.getPreferredSize().height));
        
        hint2.setSize(w, Integer.MAX_VALUE);
        hint2.setPreferredSize(new Dimension(w, hint2.getPreferredSize().height));
        
        hint3.setSize(w, Integer.MAX_VALUE);
        hint3.setPreferredSize(new Dimension(w, hint2.getPreferredSize().height));
        
        setLayout(new GridBagLayout());
        setOpaque(true);
        setBackground(UIUtils.getProfilerResultsBackground());
        GridBagConstraints x = new GridBagConstraints();
        x.gridx = 0;
        x.gridy = 0;
        x.weightx = 1;
        x.weighty = 1;
        x.fill = GridBagConstraints.NONE;
        add(pp, x);
        
    }
    
    public abstract void highlightItem(String text);
    
    
    private static class Paragraph extends HTMLTextArea {
        
        Paragraph(String text, String caption, int captionSizeDiff, Color background) {
            setCaret(new NoCaret());
            setShowPopup(false);
            setBackground(background);
            if (UIUtils.isNimbus()) setOpaque(false);
            
            setFocusable(false);
            
            setFont(new JToolTip().getFont());
            setText(setupText(text, caption, captionSizeDiff));
        }
        
        private String setupText(String text, String caption, int captionSizeDiff) {
            int fsize = getFont().getSize() + captionSizeDiff;
            return caption == null ? text : "<span style='font-size:" + fsize + "px;'>" + caption + // NOI18N
                                            "</span>" + (text == null ? "" : ". " + text); // NOI18N
        }
        
    }
    
}
