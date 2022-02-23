package com.api.backend.exceptions;

public class RecipeNotFoundException extends Exception{
   
   public RecipeNotFoundException(String message) {
      super(message);
   }

   private static final long serialVersionUID = 1L;
}
