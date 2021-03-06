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
package org.openide.actions;

import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallbackSystemAction;


/** Undock a top component.
*
* @see org.openide.windows.Mode
* @author   Petr Hamernik, Ian Formanek
* @deprecated Do not use.
*/
@Deprecated
public class UndockAction extends CallbackSystemAction {
    public String getName() {
        return NbBundle.getMessage(UndockAction.class, "UndockWindow");
    }

    public HelpCtx getHelpCtx() {
        return new HelpCtx(UndockAction.class);
    }

    protected String iconResource() {
        return "org/openide/resources/actions/undock.gif"; // NOI18N
    }

    protected boolean asynchronous() {
        return false;
    }
}
