package com.zenware;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoController {
	
	private static final Map<Long, Producto> products = new HashMap<>();
	private long idCounter = 1;
	
	@GET
	public Collection<Producto> list(){
		return products.values();
		
	}
	
	@POST
	public Response create(Producto product,@Context UriInfo uriInfo) {
		product.setId(idCounter++);
		products.put(product.getId(), product);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(String.valueOf(product.getId()));
		return Response.created(ub.build()).entity(product).build();		
	}
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") Long id) {
		Producto product = products.get(id);
		if(product != null) {
			return Response.ok(product).build();
		}else {
			
		
			return  Response.status(Response.Status.NOT_FOUND).entity(Map.of("code", 404, "message", "No encontrado")).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		Producto deleteProduct = products.remove(id);
		if(deleteProduct != null) {
			return Response.noContent().build();
		}else {
			return  Response.status(Response.Status.NOT_FOUND).entity(Map.of("code", 404, "message", "No encontrado")).build();
		}
		
		
	}
	
	

}
