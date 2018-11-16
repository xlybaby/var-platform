package com.machintosh1983.var.platform.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/var")
public class PlatformFrontController {
	private Logger logger = Logger.getLogger(getClass());

	@Value("${var.platform.static.rootPath}")
	private String rootPath;
	
	@RequestMapping(value="/subview/*/{res}", method=RequestMethod.GET)
	public void fetchSubContent( @PathVariable("res") String res, HttpServletRequest request,  HttpServletResponse response ) throws IOException {
		File root = new File(rootPath);
		File body = new File(root, res+".html");
		response.setContentType("text/html; charset=utf-8");
		OutputStream out = response.getOutputStream();
		FileInputStream bodyfile = new FileInputStream(body);
		BufferedInputStream bufbodyfile = new BufferedInputStream(bodyfile);
		
		byte[] reads = new byte[1024];
		int readbytes;
		
		while((readbytes = bufbodyfile.read(reads)) > 0 ) {
			out.write(reads, 0, readbytes);
			out.flush();
		}
		bufbodyfile.close();		
		
	}
	
	@RequestMapping(value="/view/*/{path}", method=RequestMethod.GET)
	public void fetchContent( @PathVariable("path") String path, HttpServletRequest request,  HttpServletResponse response ) throws IOException {
		File root = new File(rootPath);
		File header = new File(root, "header.html");
		File body = new File(root, path+".html");
		File footer = new File(root, "footer.html");
		response.setContentType("text/html; charset=utf-8");
		OutputStream out = response.getOutputStream();
	
		FileInputStream headerfile = new FileInputStream(header);
		BufferedInputStream bufheaderfile = new BufferedInputStream(headerfile);
		
		FileInputStream footerfile = new FileInputStream(footer);
		BufferedInputStream buffooterfile = new BufferedInputStream(footerfile);
		
		FileInputStream bodyfile = new FileInputStream(body);
		BufferedInputStream bufbodyfile = new BufferedInputStream(bodyfile);
		
		byte[] reads = new byte[1024];
		int readbytes;
		while((readbytes = bufheaderfile.read(reads)) > 0 ) {
			out.write(reads, 0, readbytes);
			out.flush();
		}
		while((readbytes = bufbodyfile.read(reads)) > 0 ) {
			out.write(reads, 0, readbytes);
			out.flush();
		}
		while((readbytes = buffooterfile.read(reads)) > 0 ) {
			out.write(reads, 0, readbytes);
			out.flush();
		}
		
		bufheaderfile.close();
		bufbodyfile.close();
		buffooterfile.close();
		
		//out.close();
	}
	
	@RequestMapping(value="/res/**", method=RequestMethod.GET)
	public void fetchContent( HttpServletRequest request,  HttpServletResponse response ) throws IOException {
		//logger.info("var-platform-1.0.0");
		String uri = request.getRequestURI();
		if( uri.startsWith("/var/res/") ) {
			uri = uri.substring("/var/res/".length());
		}
		response.sendRedirect("http://localhost/"+uri);
	}
}
