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

import com.intellij.execution.DefaultExecutionResult;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.NopProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author markiewb
 */
class EmptyRunConfiguration extends RunConfigurationBase {
    EmptyRunConfiguration(Project project, ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new EmptyRunSettingsEditor();
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {

    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment)
    {
        return new EmptyRunProfileState(executionEnvironment);
    }
    
    static class EmptyRunProfileState implements RunProfileState {
        private final ExecutionEnvironment myEnvironment;

        public EmptyRunProfileState(ExecutionEnvironment environment) {
            myEnvironment = environment;
        }

        @Nullable
        @Override
        public ExecutionResult execute(Executor executor, @NotNull ProgramRunner runner) throws com.intellij.execution.ExecutionException {
            final RunProfile profile = myEnvironment.getRunProfile();
            if (profile instanceof EmptyRunConfiguration) {
                //NOOP action
                return new DefaultExecutionResult(null, new NopProcessHandler());
            }
            return null;
        }
    }

}
