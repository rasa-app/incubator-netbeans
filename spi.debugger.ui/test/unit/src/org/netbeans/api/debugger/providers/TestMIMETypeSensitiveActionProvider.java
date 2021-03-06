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

package org.netbeans.api.debugger.providers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.netbeans.spi.debugger.ActionsProvider;
import org.netbeans.spi.debugger.ActionsProviderListener;

/**
 *
 * @author Martin Entlicher
 */
@ActionsProvider.Registration(path="unittest_MIME", actions={"MIMETypeSensitiveAction"}, activateForMIMETypes={ "text/x-java" })
public class TestMIMETypeSensitiveActionProvider extends ActionsProvider {

    public static Object ACTION_OBJECT = "MIMETypeSensitiveAction";

    public static Set<TestMIMETypeSensitiveActionProvider> INSTANCES = new HashSet<TestMIMETypeSensitiveActionProvider>();

    public TestMIMETypeSensitiveActionProvider() {
        INSTANCES.add(this);
    }

    @Override
    public Set getActions() {
        return Collections.singleton(ACTION_OBJECT);
    }

    @Override
    public void doAction(Object action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEnabled(Object action) {
        return true;
    }

    @Override
    public void addActionsProviderListener(ActionsProviderListener l) {
    }

    @Override
    public void removeActionsProviderListener(ActionsProviderListener l) {
    }

}
