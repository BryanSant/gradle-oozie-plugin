/*
 * Copyright 2013. Muhammad Ashraf
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.github.mansur.oozie.builders

import groovy.xml.MarkupBuilder

/**
 * @author Muhammad Ashraf
 * @since 7/25/13
 */
class ForkBuilder extends BaseBuilder {


    def buildXML(MarkupBuilder xml, HashMap<String, Object> action, HashMap<String, Object> common) {
        HashMap<String, Object> map = getMergedProperties(common, action)
        xml.fork(name: map.get(NAME)) {
            def paths = map.get("paths")
            paths.each {
                xml.path(start: it.toString())
            }
        }
    }
}
