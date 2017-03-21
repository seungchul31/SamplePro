package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		List<FileItem> items =null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		///////////////////////////////////////////////////
	
		String fileName =null;
		String fieldValue =null;
		long fileSize = 0;
		
		Iterator<FileItem> ite = items.iterator();
		while(ite.hasNext()){
			FileItem fileItem = ite.next();
		 //isFormField는 파일이 아닌거 
		//파일인지 파일이 아닌지 구분짛는 메서드
			if(fileItem.isFormField()){ //type=file X
			   String fieldName = fileItem.getFieldName();
			   fieldValue = fileItem.getString("UTF-8");
			  System.out.println(fieldName +"\t"+ fieldValue);
		  }else{ //type=file
			  fileName = fileItem.getName();
			  fileSize = fileItem.getSize();
			  System.out.println(fileName);
		 File f = new File("c:\\temp\\upload",fileName);
	     try{
	     fileItem.write(f);
	    }catch (Exception e){
		e.printStackTrace();
	    }
		     }
		}//end while
		
		request.setAttribute("fieldValue", fieldValue);
		request.setAttribute("fileName", fileName);
		request.setAttribute("fileSize", fileSize);
		
		RequestDispatcher dis = request.getRequestDispatcher("uploadInfo.jsp");
		dis.forward(request, response);
		
		
		
	}//end post
}
