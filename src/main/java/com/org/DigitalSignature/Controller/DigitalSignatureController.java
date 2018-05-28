package com.org.DigitalSignature.Controller;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("/DigitalSignature")
public class DigitalSignatureController {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/")
	public String indexPage(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "index";
	}

	@RequestMapping("/index")
	public String indexPage2(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "index";
	}

	@RequestMapping("/smart1")
	public String smart1(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "smart1";
	}

	@RequestMapping("/smart2")
	public String smart2(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "smart2";
	}

	@RequestMapping("/smart3")
	public String smart3(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "smart3";
	}

	@RequestMapping("/scan")
	public String scan(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "scan";
	}

	@RequestMapping("/manual")
	public String manual(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "manual";
	}

	@RequestMapping("/detailsManual")
	public String detailsManual(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "detailsManual";
	}

	@RequestMapping("/vehicleInfo")
	public String vehicleInfo(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "vehicleInfo";
	}

	@RequestMapping("/services")
	public String services(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "services";
	}

	@RequestMapping("/servicesrecommended")
	public String servicesRecommended(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "servicesrecommended";
	}

	@RequestMapping("/signature")
	public String signature(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) throws Exception {
		model.addAttribute("name", name);
		return "signature";
	}


	@RequestMapping(value = "/saveSignBlob", headers = "Content-Type=application/json", method = RequestMethod.POST)
	public @ResponseBody String saveSignBlob(@RequestBody String input) {
		// System.out.println("INPUT: "+input);
		//JSONObject object = new JSONObject(input);

		//String blobVal = object.optString("data");
		try {
			File file = new File("signBlob.txt");

			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}
			FileWriter filess = new FileWriter("signBlob.txt");
			filess.write(input);
			filess.close();
			System.out.println("JSON Object Successfully written to the file!!");
		}catch(Exception e)
		{
		}
		return "{\"status\": \"success\"}";

	}

	@RequestMapping(value = "/getRecommendedServices", method = RequestMethod.GET)
	public @ResponseBody String getRecommendedServices()
	{
		ReadDataFile readFileData=new ReadDataFile();
		JSONArray listEmp=readFileData.readFile();
		return listEmp.toString();
	}

	@RequestMapping(value = "/getCustomerDetail/{lastname}", method = RequestMethod.GET)
	public @ResponseBody String getCustomerDetail(@PathVariable("lastname") String lastname)
	{
		ReadDataFile readFileData=new ReadDataFile();
		JSONObject custData=readFileData.readCustomerFile(lastname);
		if(custData==null)
			return "{\"status\": \"DATA NOT FOUND\"}";
		return custData.toString();
	}

	@RequestMapping(value = "/getRecallDetails", method = RequestMethod.GET)
	public @ResponseBody String getRecallDetails()
	{
		ReadDataFile readFileData=new ReadDataFile();
		JSONArray listEmp=readFileData.readRecallFile();
		return listEmp.toString();
	}

	@RequestMapping(value = "/getRecallStatus/{vehicleInfo}", method = RequestMethod.GET)
	public @ResponseBody String getRecallStatus(@PathVariable("vehicleInfo") String vehicleInfo)
	{
		ReadDataFile readFileData=new ReadDataFile();
		JSONObject recallStatus=readFileData.getRecallStatus(vehicleInfo);
		if(recallStatus==null)
			return "{\"status\": \"DO NOT RECALL\"}";
		return recallStatus.toString();
	}
}
