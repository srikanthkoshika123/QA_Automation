package com.pack.employeemaintenance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;

import com.pack.gurock.testrail.APIClient;
import com.pack.gurock.testrail.APIException;

public class TestRailManager {

	public static String TEST_RUN_ID                = "837";
	public static String TESTRAIL_USERNAME          = "skoshika@unifocus.com";
	public static String TESTRAIL_PASSWORD          = "Freedom1000!";
	public static String RAILS_ENGINE_URL           = "https://unifocus.testrail.com/";
	public static final int TEST_CASE_PASSED_STATUS = 1;
	public static final int TEST_CASE_FAILED_STATUS = 5;
	


	public static void addResultForTestCase(String testCaseId, int status,
			String error) throws IOException, APIException {

		String testRunId = TEST_RUN_ID;

		APIClient client = new APIClient(RAILS_ENGINE_URL);
		client.setUser(TESTRAIL_USERNAME);
		client.setPassword(TESTRAIL_PASSWORD);
		JSONArray jsArray = new JSONArray();
		jsArray.add(7);
		
		Map data = new HashMap();
		data.put("status_id", status);
		data.put("custom_fixversion", jsArray);
		client.sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"",data );

	}

}
