package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>
{

	private String coursePrefix;
	@Override
	public void initialize(CourseCode theCourseCode)
	{
		coursePrefix= theCourseCode.value();
	}
	/*
	 * (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 * @theCode is the value entered by the user
	 */
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result;
		
		if(theCode!=null)
		{
		 result= theCode.startsWith(coursePrefix);
		}
		else
		{
			result=true;
		}
		
		return result;
	}
	

}
