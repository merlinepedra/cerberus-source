/*
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
package org.cerberus.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cerberus.api.dto.v001.TestcaseStepActionControlDTOV001;
import org.cerberus.api.mappers.v001.TestcaseStepActionControlMapperV001;
import org.cerberus.api.services.PublicApiAuthenticationService;
import org.cerberus.crud.service.ITestCaseStepActionControlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;

/**
 * @author mlombard
 */
@AllArgsConstructor
@Api(tags = "Testcase Control")
@ApiIgnore
@RestController
@RequestMapping(path = "/public/testcasestepactioncontrols")
public class TestcaseStepActionControlController {

    private static final Logger LOG = LogManager.getLogger(TestcaseStepActionControlController.class);

    private static final String API_VERSION_1 = "X-API-VERSION=1";
    private static final String API_KEY = "X-API-KEY";
    private final TestcaseStepActionControlMapperV001 controlMapper;
    private final ITestCaseStepActionControlService controlService;
    private final PublicApiAuthenticationService apiAuthenticationService;

    @ApiOperation("Find a testcaseStepActionControl by key (testFolderId, testcaseId, stepId, actionId, controlId)")
    @ApiResponse(code = 200, message = "operation successful", response = TestcaseStepActionControlDTOV001.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{testFolderId}/{testcaseId}/{stepId}/{actionId}/{controlId}", headers = {API_VERSION_1}, produces = MediaType.APPLICATION_JSON_VALUE)
    public TestcaseStepActionControlDTOV001 findControlByKey(
            @PathVariable("testFolderId") String testFolderId,
            @PathVariable("testcaseId") String testcaseId,
            @PathVariable("stepId") int stepId,
            @PathVariable("actionId") int actionId,
            @PathVariable("controlId") int controlId,
            @RequestHeader(name = API_KEY, required = false) String apiKey,
            Principal principal) {
        this.apiAuthenticationService.authenticate(principal, apiKey);
        return this.controlMapper.toDTO(
                this.controlService.findTestCaseStepActionControlByKey(
                        testFolderId, testcaseId, stepId, actionId, controlId)
        );
    }
}
