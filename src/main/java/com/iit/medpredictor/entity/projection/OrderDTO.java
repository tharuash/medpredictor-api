package com.iit.medpredictor.entity.projection;

import com.iit.medpredictor.entity.type.Medicine;

public interface OrderDTO
{
	Medicine getMedicine();
	Integer getYear();
	Short getMonth();
	Integer getQuantity();
	Boolean getIsPredicted();
	String getNote();
}
