package com.iit.medpredictor.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractService
{
	ResponseWrapper responseWrapper;

	public ResponseEntity< ResponseWrapper > buildEntityResponse( Object entity, HttpStatus httpStatus ){
		responseWrapper = new ResponseWrapper( entity, null, true, null );
		return ResponseEntity.status( httpStatus ).body( responseWrapper );
	}

	public ResponseEntity< ResponseWrapper > buildEntityListResponse( List<Object> entityList, HttpStatus httpStatus){
		responseWrapper = new ResponseWrapper( null, entityList, true, null );
		return ResponseEntity.status( httpStatus ).body( responseWrapper );
	}

	public ResponseEntity< ResponseWrapper > buildErrorResponse( String message ){
		responseWrapper = new ResponseWrapper( null, null, false, message );
		return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( responseWrapper );
	}


}
