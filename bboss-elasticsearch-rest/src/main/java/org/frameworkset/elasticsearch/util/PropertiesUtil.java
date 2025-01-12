package org.frameworkset.elasticsearch.util;
/**
 * Copyright 2020 bboss
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.frameworkset.spi.assemble.PropertiesContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Description: 获取默认属性配置容器</p>
 * <p></p>
 * <p>Copyright (c) 2020</p>
 * @Date 2020/8/1 21:15
 * @author biaoping.yin
 * @version 1.0
 */
public class PropertiesUtil {
	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	private static PropertiesContainer propertiesContainer;
	public static PropertiesContainer getPropertiesContainer(){
		if(propertiesContainer != null){
			return propertiesContainer;
		}
		synchronized (PropertiesUtil.class) {
			if(propertiesContainer != null){
				return propertiesContainer;
			}
			PropertiesContainer propertiesContainer = new PropertiesContainer();
			propertiesContainer.addConfigPropertiesFile("application.properties");
			PropertiesUtil.propertiesContainer =  propertiesContainer;
		}
		return propertiesContainer;
	}

}
