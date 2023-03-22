package com.java.layer5;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.java.layer2.Insecticide;
import com.java.layer4.InsecticideAlreadyExsists;
import com.java.layer4.InsecticideNotFound;
import com.java.layer4.InsecticideServiceImpl;



@Path("/insecticidedb")
public class InsecticideController {

	InsecticideServiceImpl insecticideservice= new InsecticideServiceImpl();
	
	
	public InsecticideController() {
		System.out.println("constructor is called");
	}
	
	@GET
	@Path("/get/{cid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void getIt(@PathParam ("cid")int x)
	{
		try
		{
			insecticideservice.findInsecticideService(x);
			
		}
		catch(InsecticideNotFound e)
		{
			
		}
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public String AddIt(Insecticide insobj)
	{
		try
		{
			insecticideservice.saveInsecticideService(insobj);
			return "Insecticide added succesfully";
		}
		catch(InsecticideAlreadyExsists e)
		{
			return e.getMessage();
		}
	}
	
	@PUT
	@Path("/update")
	public String ModifyIt(Insecticide insobj)
	{
		try
		{
			insecticideservice.modifyInsecticideService(insobj);
		}
		catch(InsecticideNotFound e)
		{
			return e.getMessage();
		}
		return null;
	}
	
	@GET
	@Path("/hai")
	public String hi()
	{
		System.out.println("Hello");
		return"welcome to Insecticide page";
	}
	
	@DELETE
	@Path("/delete/{cid}")
	public String deleteit(@PathParam("cid") int x)
	{

			insecticideservice.removeInsecticideService(x);
			
			return "insecticide removed Successfully";
	}
	
	
}
