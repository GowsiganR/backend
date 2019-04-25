package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest
{
	static CategoryDAO categoryDAO;

@BeforeClass
public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}

@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("vehicle");
		category.setCategoryDescription("car and bike.");
		assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
	}
}
	
