package com.java.layer5;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.java.layer2.InsecticideProvider;
import com.java.layer4.InsecticideProviderAlreadyExsists;
import com.java.layer4.InsecticideProviderNotFound;
import com.java.layer4.InsecticideProviderServiceImpl;

@Path("/insprodb")
public class InsecticideProviderController {
	
	InsecticideProviderServiceImpl ipsi = new InsecticideProviderServiceImpl();
	
	public InsecticideProviderController()
	{
		System.out.println("constructor is called");
		
	}
	
	@GET
	@Path("/get/{cid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void getIt(@PathParam ("cid")int x)
	{
		
		
			ipsi.findInsecticideProviderService(x);
			
		
		
	}
	
	@POST
	@Path("/add")
	public String Addit(InsecticideProvider inspobj)
	{
		try
		{
			ipsi.saveInsecticideProviderService(inspobj);
			System.out.println("Insecticide provider is added succesfully");
		}
		catch(InsecticideProviderAlreadyExsists e) {
			 return e.getMessage();
		}
		return null;
		
	}
	
	
	@PUT
	@Path("/update")
	public String updateit(InsecticideProvider inspobj)
	{
		try
		{
			ipsi.modifyInsecticideProviderService(inspobj);
			System.out.println("InsecticideProvider successfully updated");
		}
		catch(InsecticideProviderNotFound e)
		{
		return e.getMessage();
		}
		return null;
		
	}
	
	@DELETE
	@Path("/delete/{cid}")
	public String deleteit(@PathParam("cid") long x)
	{

			ipsi.removeInsecticideProviderService(x);
			
			return "insecticideProvider deleted";
			
		
		
			
		
		
		
	}
	

}
