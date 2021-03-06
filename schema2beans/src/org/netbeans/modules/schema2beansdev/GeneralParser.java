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

package org.netbeans.modules.schema2beansdev;

import java.util.*;
import java.io.*;

public abstract class GeneralParser  {
    // filename of the schema
    protected File 		filename;
    // If schemaIn is set, then it overrides filename as where to get the
    // XML Schema
    protected InputStream         schemaIn = null;

    //	The file stream that we are reading from
    protected Reader 	reader = null;

    // If we only have the InputStream, then the inputURI will help
    // us find relative URI's if anything gets included or imported.
    protected String inputURI = null;

    protected void startupReader() throws java.io.IOException {
	    if (schemaIn == null)
            reader = new FileReader(filename);
	    else
            reader = new InputStreamReader(schemaIn);
    }

    protected void shutdownReader() throws java.io.IOException {
        reader.close();
    }

    public void setInputURI(String uri) {
        inputURI = uri;
    }

    protected String getReaderURI() {
        if (inputURI != null)
            return inputURI;
        if (filename != null)
            return filename.toURI().toString();
        return schemaIn.toString();
    }
}
