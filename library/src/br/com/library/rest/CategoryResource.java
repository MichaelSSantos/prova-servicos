package br.com.library.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.library.dao.CategoryDao;
import br.com.library.models.Category;

@Path("/category")
public class CategoryResource {

	private static CategoryDao categoryDao;
	
	public CategoryResource() {
		categoryDao = new CategoryDao();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAll(){
		return categoryDao.findAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("id") Integer id){
		Category category = categoryDao.find(id); 
		Status status = (category != null ? Response.Status.OK : Response.Status.NOT_FOUND);
        return Response.status(status).entity(category).build();
		
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Category category){
		categoryDao.create(category);
		return Response.status(Response.Status.CREATED).entity(category).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Category category){
		categoryDao.update(category);
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("id") Integer id){
		categoryDao.remove(id);
		return Response.status(Response.Status.OK).build();
	}
	
}
