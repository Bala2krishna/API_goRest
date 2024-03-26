package resources;

public enum ApiResources {
	
	
	add_User("/public/v2/users"),
	get_user("/public/v2/users/{userID}"),
	update_user("/public/v2/users/{userID}"),
	delete_user("/public/v2/users/{userID}");
	private String resource;
	
	ApiResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
	
	
	
	
	

}
