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

package org.netbeans.modules.xml.wsdl.model.extensions.soap12.impl;

import org.netbeans.modules.xml.wsdl.model.Message;
import org.netbeans.modules.xml.wsdl.model.Part;
import org.netbeans.modules.xml.wsdl.model.WSDLModel;
import org.netbeans.modules.xml.wsdl.model.extensions.soap12.SOAP12HeaderBase;
import org.netbeans.modules.xml.wsdl.model.impl.WSDLAttribute;
import org.netbeans.modules.xml.xam.Reference;
import org.netbeans.modules.xml.xam.dom.NamedComponentReference;
import org.w3c.dom.Element;

/**
 * @author Sujit Biswas
 *
 */
public abstract class SOAP12HeaderBaseImpl extends SOAP12MessageBaseImpl implements SOAP12HeaderBase {
    
    /** Creates a new instance of SOAPHeaderBaseImpl */
    public SOAP12HeaderBaseImpl(WSDLModel model, Element e) {
        super(model, e);
    }

    public String getPart() {
        return getAttribute(SOAP12Attribute.PART);
    }

    public void setPart(String part) {
        setAttribute(PART_PROPERTY, SOAP12Attribute.PART, part);
    }

    public void setPartRef(Reference<Part> partRef) {
        String v = partRef == null ? null : partRef.getRefString();
        setAttribute(PART_PROPERTY, SOAP12Attribute.PART, v);
    }

    public Reference<Part> getPartRef() {
        String v = getPart();
        return v == null ? null : new PartReference(this, v);
    }
    
    public void setMessage(NamedComponentReference<Message> message) {
        setAttribute(MESSAGE_PROPERTY, WSDLAttribute.MESSAGE, message);
    }

    public NamedComponentReference<Message> getMessage() {
        String s = getAttribute(WSDLAttribute.MESSAGE);
        return s == null ? null : resolveGlobalReference(Message.class, WSDLAttribute.MESSAGE);
    }

}
