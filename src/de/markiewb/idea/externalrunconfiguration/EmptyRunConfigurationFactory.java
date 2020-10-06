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
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationSingletonPolicy;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author markiewb
 */
class EmptyRunConfigurationFactory extends ConfigurationFactory {
    private static final String FACTORY_NAME = "External tools configuration factory";

    EmptyRunConfigurationFactory(ConfigurationType type) {
        super(type);
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new EmptyRunConfiguration(project, this, "External tools");
    }

    @NotNull
    @Override
    public String getId()
    {
       return super.getType().getId();
    }

    @NotNull
    @Override
    public RunConfigurationSingletonPolicy getSingletonPolicy()
    {
        return RunConfigurationSingletonPolicy.MULTIPLE_INSTANCE;
    }
}
