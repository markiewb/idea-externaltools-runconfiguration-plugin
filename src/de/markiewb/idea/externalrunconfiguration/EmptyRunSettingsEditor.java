/*
 * Copyright 2017 markiewb
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package de.markiewb.idea.externalrunconfiguration;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author markiewb
 */
class EmptyRunSettingsEditor extends SettingsEditor<EmptyRunConfiguration> {
    private JPanel panel1;

    @Override
    protected void resetEditorFrom(@NotNull EmptyRunConfiguration s) {

    }

    @Override
    protected void applyEditorTo(@NotNull EmptyRunConfiguration s) throws ConfigurationException {

    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return panel1;
    }
}
