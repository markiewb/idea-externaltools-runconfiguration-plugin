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

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * It adds a 'Run Configuration' type for 'External Tools'.
 * <p>
 * The configuration executes nothing, BUT you can associate an 'External Tool' via the 'Before Launch' section.
 * Thus the 'External Tool' is available via the Run-/Debug-Popup.
 *
 * @author markiewb
 */
public class ExternalToolsRunConfigurationType implements ConfigurationType {
    @Override
    public String getDisplayName() {
        return "External Tools";
    }

    @Override
    public String getConfigurationTypeDescription() {
        return "External Tools Configuration Type";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.General.ExternalToolsSmall;
    }

    @NotNull
    @Override
    public String getId() {
        return "External_Tools_CONFIGURATION";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{new EmptyRunConfigurationFactory(this)};
    }
}
