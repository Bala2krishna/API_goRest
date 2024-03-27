package resources;

public enum ApiResources {
	
	
	add_User("/public/v2/users"),
	get_User("/public/v2/users/{userID}"),
	update_user("/public/v2/users/{userID}"),
	get_Users("/public/v2/users"),
	delete_User("/public/v2/users/{userID}");
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
