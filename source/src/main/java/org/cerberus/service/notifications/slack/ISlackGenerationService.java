/**
 * Cerberus Copyright (C) 2013 - 2017 cerberustesting
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This file is part of Cerberus.
 *
 * Cerberus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cerberus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Cerberus.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cerberus.service.notifications.slack;

import org.cerberus.crud.entity.Tag;
import org.cerberus.crud.entity.TestCase;
import org.cerberus.crud.entity.TestCaseExecution;
import org.json.JSONObject;

/**
 *
 * @author vertigo17
 */
public interface ISlackGenerationService {

    /**
     *
     * @param tag
     * @param channel
     * @return
     * @throws Exception
     */
    public JSONObject generateNotifyStartTagExecution(Tag tag, String channel) throws Exception;

    /**
     *
     * @param tag
     * @param channel
     * @return
     * @throws Exception
     */
    public JSONObject generateNotifyEndTagExecution(Tag tag, String channel) throws Exception;

    /**
     *
     * @param exe
     * @param channel
     * @return
     * @throws Exception
     */
    public JSONObject generateNotifyStartExecution(TestCaseExecution exe, String channel) throws Exception;

    /**
     *
     * @param exe
     * @param channel
     * @return
     * @throws Exception
     */
    public JSONObject generateNotifyEndExecution(TestCaseExecution exe, String channel) throws Exception;

    /**
     *
     * @param testCase
     * @param channel
     * @param eventReference
     * @return
     * @throws Exception
     */
    public JSONObject generateNotifyTestCaseChange(TestCase testCase, String channel, String eventReference) throws Exception;
}