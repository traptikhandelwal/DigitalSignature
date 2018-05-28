package com.org.DigitalSignature.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

import com.org.DigitalSignature.Model.CustomerDetail;
import com.org.DigitalSignature.Model.RecallDetail;
import com.org.DigitalSignature.Model.RecommendedServices;

public class ReadDataFile {

	public JSONArray readFile()
	{
		RecommendedServices objEmp;
		JSONObject jobj;
		JSONArray output = new JSONArray();
		int count;
		File file = new File("inputData.txt");
		BufferedReader br;
		Scanner scanner;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null)
			{
				System.out.println(st);
				jobj= new JSONObject();
				objEmp = new RecommendedServices();
				count =1;
				scanner= new Scanner(st);
				scanner.useDelimiter("\\|");

				while (scanner.hasNext())
				{
					String token = scanner.next();
					switch(count)
					{
					case 1:
						objEmp.setUpsell(token);
						jobj.put("Upsell_Category", objEmp.getUpsell());
						break;
					case 2:
						objEmp.setValue(Double.parseDouble(token));
						jobj.put("Value", token);
						break;
					case 3:
						objEmp.setService1(token);
						jobj.put("Service1", token);
						break;
					case 4:
						objEmp.setService2(token);
						jobj.put("Service2", token);
						break;
					case 5:
						objEmp.setService3(token);
						jobj.put("Service3", token);
						break;
					case 6 :
						objEmp.setService4(token);
						jobj.put("Service4", token);
						break;
					}
					count++;
				}
				output.put(jobj);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}


	public JSONArray readRecallFile()
	{
		RecallDetail objRecallDetail;
		JSONObject jobj;
		JSONArray output = new JSONArray();
		int count;
		File file = new File("RecallData.txt");
		BufferedReader br;
		Scanner scanner;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null)
			{
				System.out.println(st);
				jobj= new JSONObject();
				objRecallDetail = new RecallDetail();
				count =1;
				scanner= new Scanner(st);
				scanner.useDelimiter("\\|");

				while (scanner.hasNext())
				{
					String token = scanner.next();
					switch(count)
					{
					case 1:
						objRecallDetail.setRecall_number(token);
						jobj.put("recall_number", token);
						break;
					case 2:
						objRecallDetail.setRecall_vehicle_type(token);
						jobj.put("recall_vehicle_type", token);
						break;
					case 3:
						objRecallDetail.setRecall_reason(token);
						jobj.put("recall_reason", token);
						break;
					case 4:
						objRecallDetail.setRecall_start_data(token);
						jobj.put("recall_start_data", token);
						break;

					}
					count++;
				}
				output.put(jobj);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}


	public JSONObject readCustomerFile(String lastname)
	{
		List<CustomerDetail> listCust= new ArrayList<CustomerDetail>();
		CustomerDetail objCust;
		JSONObject jobj;
		JSONArray output = new JSONArray();
		boolean flag=false;
		int count;
		File file = new File("CustomerData.txt");
		BufferedReader br;
		Scanner scanner;
		JSONObject jObj=new JSONObject();
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null)
			{
				System.out.println(st);
				jobj= new JSONObject();
				objCust = new CustomerDetail();
				count =1;
				scanner= new Scanner(st);
				scanner.useDelimiter("\\|");

				while (scanner.hasNext())
				{
					String token = scanner.next();
					switch(count)
					{
					case 1:
						objCust.setId(token);
						jobj.put("Id", token);
						break;
					case 2:
						objCust.setFname(token);
						jobj.put("First Name", token);
						break;
					case 3:
						objCust.setLname(token);
						jobj.put("Last Name", token);
						break;
					case 4:
						objCust.setContact(token);
						jobj.put("contact", token);
						break;
					case 5:
						objCust.setOrgnization(token);
						jobj.put("Organization", token);
						break;
					}
					count++;
				}
				output.put(jobj);
				listCust.add(objCust);

			}

			for(Object cus:output)
			{
				if(!flag)
				{
					jObj=new JSONObject();
					jObj=(JSONObject)cus;
					if(lastname.equals(jObj.get("Last Name")))
					{
						flag=true;
					}
				}
				else
					break;


			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if(flag)
			return jObj;
		else
			return null;

	}

	public JSONObject getRecallStatus(String recallDetail)
	{
		RecallDetail objRecallDetail;
		JSONObject jobj,jObj = null ;
		JSONArray output = new JSONArray();
		int count;
		File file = new File("RecallData.txt");
		BufferedReader br;
		Scanner scanner;
		boolean flag=false;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null)
			{
				System.out.println(st);
				jobj= new JSONObject();
				objRecallDetail = new RecallDetail();
				count =1;
				scanner= new Scanner(st);
				scanner.useDelimiter("\\|");

				while (scanner.hasNext())
				{
					String token = scanner.next();
					switch(count)
					{
					case 1:
						objRecallDetail.setRecall_number(token);
						jobj.put("recall_number", token);
						break;
					case 2:
						objRecallDetail.setRecall_vehicle_type(token);
						jobj.put("recall_vehicle_type", token);
						break;
					case 3:
						objRecallDetail.setRecall_reason(token);
						jobj.put("recall_reason", token);
						break;
					case 4:
						objRecallDetail.setRecall_start_data(token);
						jobj.put("recall_start_data", token);
						break;

					}
					count++;
				}
				output.put(jobj);
			}

			for(Object cus:output)
			{

				if(!flag)
				{
					jObj = new JSONObject();
					jObj=(JSONObject)cus;
					if(jObj.get("recall_vehicle_type").toString().toLowerCase().contains(recallDetail.toLowerCase()))
					{
						flag=true;
					}
				}
				else
					break;


			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		if(flag)
			return jObj;
		else
			return null;
	}
}