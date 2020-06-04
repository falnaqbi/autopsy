/*
 * Autopsy
 *
 * Copyright 2020 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.discovery;

import org.sleuthkit.autopsy.centralrepository.datamodel.CentralRepository;

/**
 * Panel for displaying all filters available for the searches of type Video.
 */
final class VideoFilterPanel extends AbstractFiltersPanel {

    private static final long serialVersionUID = 1L;
    private static final FileSearchData.FileType FILE_TYPE = FileSearchData.FileType.VIDEO;

    /**
     * Creates new form VideoFilterPanel.
     */
    VideoFilterPanel() {
        super();
        initComponents();
        addFilter(new SizeFilterPanel(FileSearchData.FileType.VIDEO), false, null, 0);
        addFilter(new DataSourceFilterPanel(), false, null, 0);
        int[] pastOccurrencesIndices;
        if (!CentralRepository.isEnabled()) {
            pastOccurrencesIndices = new int[]{0};
        } else {
            pastOccurrencesIndices = new int[]{1, 2, 3, 4, 5, 6, 7};
        }
        addFilter(new PastOccurrencesFilterPanel(), true, pastOccurrencesIndices, 0);
        addFilter(new UserCreatedFilterPanel(), false, null, 1);
        addFilter(new HashSetFilterPanel(), false, null, 1);
        addFilter(new InterestingItemsFilterPanel(), false, null, 1);
        addFilter(new ObjectDetectedFilterPanel(), false, null, 1);
        addFilter(new ParentFolderFilterPanel(), false, null, 1);
        addPanelsToScrollPane(videoFiltersSplitPane);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        videoFiltersScrollPane = new javax.swing.JScrollPane();
        videoFiltersPanel = new javax.swing.JPanel();
        videoFiltersSplitPane = new javax.swing.JSplitPane();

        setLayout(new java.awt.BorderLayout());

        videoFiltersPanel.setLayout(new java.awt.BorderLayout());

        videoFiltersSplitPane.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(VideoFilterPanel.class, "VideoFilterPanel.videoFiltersSplitPane.border.title"))); // NOI18N
        videoFiltersSplitPane.setResizeWeight(0.5);
        videoFiltersPanel.add(videoFiltersSplitPane, java.awt.BorderLayout.CENTER);

        videoFiltersScrollPane.setViewportView(videoFiltersPanel);

        add(videoFiltersScrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    @Override
    FileSearchData.FileType getFileType() {
        return FILE_TYPE;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel videoFiltersPanel;
    private javax.swing.JScrollPane videoFiltersScrollPane;
    private javax.swing.JSplitPane videoFiltersSplitPane;
    // End of variables declaration//GEN-END:variables

}
