package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class Driver {

		static Pet[] pets;
		static int CurrentIndex;
		
		public static void main (String[] args) {
		CurrentIndex = 0;
		pets = new Pet[10]; 
		
		Javalin app = Javalin.create();
		
		app.start();
		
		app.post("/pets", ctx -> {
			// info comes from form parameters
			Pet pet = new Pet();
			pet.name=ctx.formParam("name");
			pet.species=ctx.formParam("species");
			pet.description=ctx.formParam("description");
			pet.age=Integer.parseInt(ctx.formParam("age"));
			
			pets[CurrentIndex]=pet;
			CurrentIndex++;
			
			String responseText = "";
			
			for (Pet eachPet:pets) {
				if(eachPet != null) 
					responseText += eachPet.name + "<br>";
			}
			ctx.html(responseText);					
	
		});
	}

		private static Context formParam(String string) {
			// TODO Auto-generated method stub
			return null;
		}
}