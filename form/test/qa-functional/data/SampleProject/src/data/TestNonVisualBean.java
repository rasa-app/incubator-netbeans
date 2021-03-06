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

package data;

import java.io.Serializable;

/**
 *  Creting simple visual and non-visual Bean Form
 *
 * @author Jiri Vagner
 */
public class TestNonVisualBean implements Serializable {
    private String _name = "Lancia Lybra"; // NOI18N
    private int _power = 140;
    
    /** Creates a new instance of NonVisualBean */
    public TestNonVisualBean() {
    }
    
    /**
     * Gets car name
     * @return car name
     */
    public String getCarName() {
        return _name;
    }
    
    /**
     * Sets car power value 
     * @param newPower 
     */
    public void setPower(int newPower) {
        _power = newPower;
    }
    
    /**
     * Gets car power value
     * @return car power
     */
    public int getPower() {
        return _power;
    }
}
